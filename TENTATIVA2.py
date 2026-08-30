import time
import pandas as pd
from selenium import webdriver
from selenium.webdriver.chrome.options import Options  # <-- IMPORTANTE ADICIONAR ESSA LINHA
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# --- CONFIGURAÇÕES PARA EVITAR O BLOQUEIO ---
options = Options()
options.add_argument("--disable-blink-features=AutomationControlled")
options.add_experimental_option("excludeSwitches", ["enable-automation"])
options.add_experimental_option('useAutomationExtension', False)
options.add_argument("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")

# Inicializa o navegador com as opções acima
navegador = webdriver.Chrome(options=options)

# Executa script para ocultar a flag de automação
navegador.execute_script("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})")
# --------------------------------------------

# Agora segue a abertura do site normalmente
navegador.get("https://lista.mercadolivre.com.br/")

# Aguarda até o campo de busca estar pronto e clicavel
wait = WebDriverWait(navegador, 10)
campo_busca = wait.until(
    EC.element_to_be_clickable((By.CSS_SELECTOR, "input.nav-search-input, input[name='as_word']"))
)

campo_busca.clear()
campo_busca.send_keys("iphone")
campo_busca.send_keys(Keys.ENTER)
time.sleep(4)

# Contexto geral
fonte = "mercadolivre"
try:
    categoria = navegador.find_element(By.CLASS_NAME, "andes-breadcrumb__link").text.strip()
except Exception:
    categoria = "N/A"

# 2. Coleta os itens na página de listagem
produtos_elementos = navegador.find_elements(By.CLASS_NAME, "ui-search-layout__item")

# Lista temporária para armazenar os dados básicos + link de cada item
produtos_basicos = []

for prod in produtos_elementos:
    try:
        loja = prod.find_element(By.CLASS_NAME, "poly-component__seller").text.strip()
    except Exception:
        loja = "N/A"

    try:
        titulo_elem = prod.find_element(By.CLASS_NAME, "poly-component__title")
        titulo = titulo_elem.text.strip()
        url_produto = titulo_elem.get_attribute("href")
    except Exception:
        titulo = "N/A"
        url_produto = None

    try:
        preco_elem = prod.find_element(By.CLASS_NAME, "andes-money-amount")
        preco_valor = preco_elem.find_element(By.CLASS_NAME, "andes-money-amount__fraction").text.strip()
    except Exception:
        preco_valor = "N/A"

    if url_produto:
        produtos_basicos.append({
            "fonte": fonte,
            "categoria": categoria,
            "Loja": loja,
            "titulo": titulo,
            "preco": preco_valor,
            "url_produto": url_produto
        })

# Lista de chaves desejadas da tabela técnica
chaves_desejadas = [
    "Marca",
    "Linha",
    "Modelo",
    "Cor",
    "Memória interna",
    "Memória RAM"
]

dados_completos = []

# 3. Itera por cada produto e extrai as especificações técnicas da página individual
for produto in produtos_basicos:
    navegador.get(produto["url_produto"])
    
    # Aguarda o carregamento da tabela de características
    try:
        wait = WebDriverWait(navegador, 5)
        wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, "tr.andes-table__row")))
        navegador.execute_script("window.scrollTo(0, 1000);")
        time.sleep(1.5)

        linhas = navegador.find_elements(By.CSS_SELECTOR, "tr.andes-table__row")
        especificacoes = {}
        
        for linha in linhas:
            try:
                chave = linha.find_element(By.CSS_SELECTOR, "th").get_attribute("innerText").strip()
                valor = linha.find_element(By.CSS_SELECTOR, "td").get_attribute("innerText").strip()
                if chave:
                    especificacoes[chave] = valor
            except Exception:
                continue

        # Filtra apenas as chaves desejadas
        especificacoes_filtradas = {chave: especificacoes.get(chave, "N/A") for chave in chaves_desejadas}

    except Exception:
        # Caso a tabela não exista ou falhe o carregamento no produto específico
        especificacoes_filtradas = {chave: "N/A" for chave in chaves_desejadas}

    # Une os dados básicos com as especificações técnicas filtradas
    registro_completo = {**produto, **especificacoes_filtradas}
    dados_completos.append(registro_completo)

# 4. Exibição e exportação
pd.set_option('display.max_columns', None)
pd.set_option('display.width', 1000)

df = pd.DataFrame(dados_completos)
print(df)

df.to_csv("dados_produtos_completos.csv", index=False, encoding='utf-8-sig', sep=';')

navegador.quit()
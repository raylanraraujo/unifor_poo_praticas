import time
import pandas as pd
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# 1. Configuração Inicial e Busca
navegador = webdriver.Chrome()
navegador.get("https://lista.mercadolivre.com.br/")
time.sleep(3)

campo_busca = navegador.find_element(By.NAME, "as_word")
campo_busca.send_keys("iphone")
campo_busca.send_keys(Keys.ENTER)
time.sleep(3)

fonte = "mercadolivre"
try:
    categoria = navegador.find_element(By.CLASS_NAME, "andes-breadcrumb__link").text.strip()
except:
    categoria = "N/A"

# 2. Coleta dos Produtos da Lista Principal
produtos = navegador.find_elements(By.CLASS_NAME, "ui-search-layout__item")
dados_produtos = []

for produto in produtos:
    try:
        try:
            loja = produto.find_element(By.CLASS_NAME, "poly-component__seller").text.strip()
        except:
            loja = "N/A"

        titulo_elem = produto.find_element(By.CLASS_NAME, "poly-component__title")
        titulo_texto = titulo_elem.text
        url_produto = titulo_elem.get_attribute("href")

        try:
            preco_valor = produto.find_element(By.CLASS_NAME, "andes-money-amount__fraction").text
        except:
            preco_valor = "N/A"

        dados_produtos.append({
            "fonte": fonte,
            "categoria": categoria,
            "Loja": loja,
            "titulo": titulo_texto,
            "preco": preco_valor,
            "url_produto": url_produto
        })
    except Exception as e:
        continue

# 3. Chaves Desejadas da Ficha Técnica
chaves_desejadas = [
    "Marca",
    "Linha",
    "Modelo",
    "Cor",
    "Memória interna",
    "Memória RAM"
]

# 4. Navegação por Cada Produto para Coleta Detalhada
dados_finais = []

for item in dados_produtos:
    url = item["url_produto"]
    
    if not url:
        continue

    navegador.get(url)
    
    # Aguarda o carregamento das especificações técnicas
    try:
        wait = WebDriverWait(navegador, 7)
        wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, "tr.andes-table__row")))
        navegador.execute_script("window.scrollTo(0, 1000);")
        time.sleep(1)
    except:
        pass

    # Extrai todas as especificações disponíveis
    linhas = navegador.find_elements(By.CSS_SELECTOR, "tr.andes-table__row")
    especificacoes = {}

    for linha in linhas:
        try:
            chave = linha.find_element(By.CSS_SELECTOR, "th").get_attribute("innerText").strip()
            valor = linha.find_element(By.CSS_SELECTOR, "td").get_attribute("innerText").strip()
            if chave:
                especificacoes[chave] = valor
        except:
            continue

    # Filtra apenas os campos de interesse
    especificacoes_filtradas = {
        chave: especificacoes.get(chave, "N/A") for chave in chaves_desejadas
    }

    # Mescla os dados gerais do produto com a ficha técnica
    registro_completo = {**item, **especificacoes_filtradas}
    dados_finais.append(registro_completo)

# 5. Exportação dos Dados
df = pd.DataFrame(dados_finais)

pd.set_option('display.max_columns', None)
pd.set_option('display.width', 1000)
print(df)

df.to_csv("produtos_especificacoes.csv", index=False, encoding="utf-8-sig", sep=";")

navegador.quit()
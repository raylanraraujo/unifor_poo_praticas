import time
import pandas as pd
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome() # Ou webdriver.Safari()
wait = WebDriverWait(driver, 10)

# 1. Acessa a página da categoria Celulares
url_categoria = "https://www.mercadolivre.com.br/c/celulares-e-telefones"  # Ajuste a URL exata da página da imagem
driver.get(url_categoria)

# Rola a tela até o carrossel para forçar o carregamento dos elementos
driver.execute_script("window.scrollTo(0, 1200);")
time.sleep(3)

# 2. Captura apenas a section específica e pega todos os links contidos nela
section_carrossel = wait.until(
    EC.presence_of_element_located((By.CSS_SELECTOR, "section.dynamic-carousel-grid-desktop"))
)

# Encontra todas as tags de link <a> dentro da seção
elementos_links = section_carrossel.find_elements(By.TAG_NAME, "a")

# Filtra e extrai os URLs dos produtos sem duplicatas
urls_produtos = list(set([el.get_attribute("href") for el in elementos_links if el.get_attribute("href") and "/p/" in el.get_attribute("href") or "/MLB-" in el.get_attribute("href")]))

print(f"Total de produtos encontrados na seção: {len(urls_produtos)}")

# Campos que desejamos extrair de cada produto
chaves_desejadas = [
    "Marca", "Linha", "Modelo", "Cor", "Memória interna", 
    "Memória RAM", "Modelo do processador", "Tamanho da tela", 
    "Resolução da câmera traseira principal", "Resolução da câmera frontal principal", 
    "Rede móvel", "Ano de lançamento"
]

lista_dados_finais = []

# 3. Loop para navegar produto por produto
for index, url in enumerate(urls_produtos, 1):
    print(f"Coletando produto {index}/{len(urls_produtos)}...")
    driver.get(url)
    
    # Rola e aguarda a tabela carregar
    driver.execute_script("window.scrollTo(0, 1000);")
    time.sleep(2)
    
    especificacoes = {}
    linhas = driver.find_elements(By.CSS_SELECTOR, "tr.andes-table__row")
    
    for linha in linhas:
        try:
            chave = linha.find_element(By.CSS_SELECTOR, "th").get_attribute("innerText").strip()
            valor = linha.find_element(By.CSS_SELECTOR, "td").get_attribute("innerText").strip()
            if chave:
                especificacoes[chave] = valor
        except:
            continue
            
    # Filtra as especificações e adiciona o link do produto
    produto_filtrado = {chave: especificacoes.get(chave, "N/A") for chave in chaves_desejadas}
    produto_filtrado["url_produto"] = url
    
    lista_dados_finais.append(produto_filtrado)

driver.quit()

# 4. Converte em DataFrame e exibe/salva
df_final = pd.DataFrame(lista_dados_finais)

# Ajuste visual para o terminal
pd.set_option('display.max_colwidth', 30)
print(df_final)

# Exportar resultado para um arquivo Excel ou CSV
df_final.to_csv("celulares_grandes_ofertas.csv", index=False)
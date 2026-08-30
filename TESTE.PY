import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import pandas as pd 

driver = webdriver.Chrome() # Ou webdriver.Safari()
driver.get('https://www.mercadolivre.com.br/iphone-17-256gb-8-gb-preto/p/MLB55308917')

# 1. Aguarda até 10s para a tabela aparecer no DOM
wait = WebDriverWait(driver, 10)
wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, "tr.andes-table__row")))

# 2. Rola a página para baixo para garantir o carregamento do conteúdo dinâmico
driver.execute_script("window.scrollTo(0, 1000);")
time.sleep(2)

# 3. Coleta os elementos
linhas = driver.find_elements(By.CSS_SELECTOR, "tr.andes-table__row")

especificacoes = {}
for linha in linhas:
    try:
        # Usa innerText via JS para garantir que pega o texto mesmo se estiver oculto no layout
        chave = linha.find_element(By.CSS_SELECTOR, "th").get_attribute("innerText").strip()
        valor = linha.find_element(By.CSS_SELECTOR, "td").get_attribute("innerText").strip()
        
        if chave:
            especificacoes[chave] = valor
    except:
        continue

# Lista com apenas os campos de interesse
chaves_desejadas = [
    "Marca", 
    "Linha", 
    "Modelo", 
    "Cor", 
    "Memória interna", 
    "Memória RAM", 
    # "Modelo do processador", 
    # "Tamanho da tela", 
    # "Resolução da câmera traseira principal", 
    # "Resolução da câmera frontal principal", 
    # "Rede móvel", 
    # "Ano de lançamento"
]

# Cria um novo dicionário contendo apenas os campos da lista
especificacoes_filtradas = {
    chave: especificacoes.get(chave, "N/A") 
    for chave in chaves_desejadas
}

print(especificacoes_filtradas)
df = pd.DataFrame([especificacoes_filtradas])
print(df)

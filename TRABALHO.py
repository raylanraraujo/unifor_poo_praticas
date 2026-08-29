from selenium import webdriver # Importa a biblioteca Selenium para controlar o navegador
from selenium.webdriver.common.by import By # Importa o módulo 'By' para indicar como localizar elementos na página (ex: por classe, id, etc.)


driver = webdriver.Safari() # Inicia e abre uma nova janela do navegador Safari
driver.get("https://lista.mercadolivre.com.br/celular-iphone") # Faz o navegador acessar a URL informada dentro dos parênteses
driver.implicitly_wait(10) # Define um tempo limite de até 10 segundos para o navegador esperar os elementos carregarem na tela


nome_produto = driver.find_elements(By.CLASS_NAME, "poly-component__title-wrapper") # Busca na página todos os elementos com a classe CSS "text" (que contêm as frases) e os guarda em uma lista
preco_produto = driver.find_elements(By.CLASS_NAME, "andes-money-amount__fraction") # Busca na página todos os elementos com a classe CSS "author" (que contêm os autores) e os guarda em uma lista
vendedor = driver.find_elements(By.CLASS_NAME, "poly-component__seller") # Busca na página todos os elementos com a classe CSS "author" (que contêm os autores) e os guarda em uma lista


for nome, preco, vendedor in zip(nome_produto, preco_produto, vendedor): # Percorre as duas listas (textos e autores) de forma simultânea combinando cada frase com seu respectivo autor
    print(f"{nome.text} - {preco.text} - {vendedor.text}")     # Extrai o texto limpo de cada elemento e exibe no terminal no formato "Frase - Autor"

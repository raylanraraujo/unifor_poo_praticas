# from selenium import webdriver
# from selenium.webdriver.common.by import By
# from selenium.webdriver.chrome.service import Service
# from webdriver_manager.chrome import ChromeDriverManager


# # Iniciar o navegador
# driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
# driver.get("https://quotes.toscrape.com/js/")

# driver.implicitly_wait(10)

# textos = driver.find_elements(By.CLASS_NAME, "text")
# autores = driver.find_elements(By.CLASS_NAME, "author")

# for texto, autor in zip(textos, autores):
#     print(f"{texto.text} - {autor.text}")


from selenium import webdriver # Importa a biblioteca Selenium para controlar o navegador
from selenium.webdriver.common.by import By # Importa o módulo 'By' para indicar como localizar elementos na página (ex: por classe, id, etc.)


driver = webdriver.Safari() # Inicia e abre uma nova janela do navegador Safari
driver.get("https://quotes.toscrape.com/js/") # Faz o navegador acessar a URL informada dentro dos parênteses
driver.implicitly_wait(10) # Define um tempo limite de até 10 segundos para o navegador esperar os elementos carregarem na tela


textos = driver.find_elements(By.CLASS_NAME, "text") # Busca na página todos os elementos com a classe CSS "text" (que contêm as frases) e os guarda em uma lista
autores = driver.find_elements(By.CLASS_NAME, "author") # Busca na página todos os elementos com a classe CSS "author" (que contêm os autores) e os guarda em uma lista


for texto, autor in zip(textos, autores): # Percorre as duas listas (textos e autores) de forma simultânea combinando cada frase com seu respectivo autor
    print(f"{texto.text} - {autor.text}")     # Extrai o texto limpo de cada elemento e exibe no terminal no formato "Frase - Autor"

import requests
from bs4 import BeautifulSoup

url = "https://quotes.toscrape.com/" #essa API é um serviço de teste que retorna dados fictícios em formato JSON de alguma rede social que nao existe
response = requests.get(url) # usado para fazer uma requisição GET para a URL especificada e obter os dados.

# print(response) # imprime o código de status da resposta HTTP. Um código 200 indica que a requisição foi bem-sucedida.  
# print(response.text) # imprime o conteúdo da resposta HTTP, que é o HTML da página.

soup = BeautifulSoup(response.text, 'html.parser') # cria um objeto BeautifulSoup para analisar o HTML.

# print(soup.prettify()) # imprime o HTML formatado.
textos = soup.find_all('span', class_='text') # encontra todos os elementos <span> com a classe 'text', que contêm as citações.
for texto in textos: # itera sobre cada elemento encontrado.
    print(texto.text) # imprime o texto da citação.

autores = soup.find_all('small', class_='author') # encontra todos os elementos <small> com a classe 'author', que contêm os autores das citações.
for autor in autores: # itera sobre cada elemento encontrado.
    print(autor.text) # imprime o nome do autor da citação.
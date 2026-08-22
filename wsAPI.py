import requests

url = "https://jsonplaceholder.typicode.com/posts" #essa API é um serviço de teste que retorna dados fictícios em formato JSON de alguma rede social que nao existe
response = requests.get(url) # usado para fazer uma requisição GET para a URL especificada e obter os dados da API.

print(response) # imprime o código de status da resposta HTTP. Um código 200 indica que a requisição foi bem-sucedida.

if response.status_code == 200: # verifica se o código de status da resposta é 200, indicando sucesso.
    data = response.json() # converte a resposta JSON em um objeto Python (lista de dicionários).
    for post in data: # itera sobre cada post na lista de dados.
        print(f"Post ID: {post['id']}, Title: {post['title']}") # imprime o ID e o título de cada post.˜˜
    
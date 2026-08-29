from selenium import webdriver # e a ferramenta que permite controlar o navegador
from selenium.webdriver.common.by import By # diz ao Selenium como queremos localizar um elemento: por classe, por seletor CSS.
import time # serve para fazer o programa esperar alguns segundos
import pandas as pd # serve para manipular os dados

navegador = webdriver.Safari() # abre o navegador

navegador.get("https://lista.mercadolivre.com.br/iphone") # faz a requisição na url do site

time.sleep(5) # espera 5 segundos para o site carregar

fonte = "mercadolivre" 
categoria = "smartphone"
subcategoria = "iphone"

produtos = navegador.find_elements(By.CLASS_NAME, "ui-search-layout__item") # procura os elementos com a classe ui-search-layout__item

dados = [] # cria uma lista vazia para armazenar os dados dos produtos

for produto in produtos:
    titulo = produto.find_element(By.CLASS_NAME, "poly-component__title") # procura o elemento com onome dessa classe dentro do primeiro produto

    url_produto = titulo.get_attribute("href") # pega o link do produto

    preco_atual = produto.find_element(By.CLASS_NAME, "poly-price__current") # procura o elemento com onome dessa classe dentro do primeiro produto

    preco = preco_atual.find_element(By.CLASS_NAME, "andes-money-amount") # procura o elemento com onome dessa classe dentro do primeiro produto

    preco_aria = preco.get_attribute("aria-label") # pega o texto do elemento encontrado

    registro = {
        "fonte": fonte,
        "categoria": categoria,
        "subcategoria": subcategoria,
        "titulo": titulo.text,
        "preco": preco_aria,
        "url_produto": url_produto
    }

    dados.append(registro) # adiciona o registro na lista de dados

pd.set_option('display.max_columns', None)  # Exibe todas as colunas
pd.set_option('display.max_colwidth', None) # Não corta textos longos (ex: URLs)
pd.set_option('display.width', 1000)        # Aumenta a largura total da linha do terminal
df = pd.DataFrame(dados) # cria um DataFrame com os dados coletados
print(df) # imprime os dados coletados


df.to_csv("dados_brutos.csv", index=False, encoding='utf-8-sig', sep=';') # cria um arquivo csv
    

input("Pressione enter para sair") # espera o usuario apertar enter para sair



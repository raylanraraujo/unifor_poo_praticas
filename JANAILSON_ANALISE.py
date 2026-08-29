import pandas as pd

df = pd.read_csv("dados_brutos.csv", sep=';') # lê o arquivo dados brutos

# print(df.isnull().sum()) # o isnull verifica se tem dados faltando e o sum soma quantos estão faltando

# print("dados duplicados:", df.duplicated().sum()) # conta quantos dados estão duplicados

df = df[~df["preco"].str.contains("centavo", na=False)] # remove os produtos que tem centavos no preço o na=False é para não dar erro caso tenha algum valor nulo na coluna de preços

df["preco"] = df["preco"].str.replace("reais", "") # remove a palavra reais da coluna de preços

df["preco"] = pd.to_numeric(df["preco"]) # converte a coluna de preços para o tipo numérico

df.to_csv("dados_tratados.csv", index=False, encoding='utf-8-sig', sep=';') # cria um arquivo csv com os dados tratados

print("dados tratados com sucesso") 
print("total de produtos:", len(df))
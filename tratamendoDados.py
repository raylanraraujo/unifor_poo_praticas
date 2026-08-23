# primeira atividade para analisar esse dado é tratar esse dado. Portanto vamos importar o Pandas 
import pandas as pd

df = pd.read_csv('data.csv')  

# o primeiro passo é compreender a nossa base de dados. Apesar da nossa base de dados seer muito pequena, mas no dia a dia nós não vamos trabalhar com uma base tao pequena assim
print(df.head(10))  # para ver as primeiras linhas do nosso dataset

print()

df_limpo = df.dropna()  # para remover os valores nulos do nosso dataset
print(df_limpo.head(10))  # para ver as primeiras linhas do nosso dataset limpo

print()

df_preenchido = df.fillna(df.mean(numeric_only=True))  # para preencher os valores nulos com a média dos valores numéricos
print(df_preenchido.head(10))  # para ver as primeiras linhas do nosso dataset preenchido
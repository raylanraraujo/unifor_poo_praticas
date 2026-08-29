import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("dados_tratados.csv", sep=';') 


# pedi ajuda a IA na montagem dos graficos.

faixas = [2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, float("inf")]

nomes_faixas = [
    "2-3 mil",
    "3-4 mil",
    "4-5 mil",
    "5-6 mil",
    "6-7 mil",
    "7-8 mil",
    "8-9 mil",
    "9-10 mil",
    "10 mil+"
]

df["faixa_preco"] = pd.cut(
    df["preco"],
    bins=faixas,
    labels=nomes_faixas,
    right=False
) # o bins define os limites das faixas, e o labels define os nomes que serão atribuídos a cada faixa. O parâmetro right=False indica que o limite superior da faixa não está incluído na faixa.

quantidade_por_faixa = df["faixa_preco"].value_counts(sort = False) # o value_counts() retorna a quantidade de ocorrências de cada valor na coluna faixa_preco. O parâmetro sort=False indica que os valores não serão ordenados.

quantidade_por_faixa.plot(kind="bar")

plt.title("Quantidade de ofertas de iPhone por faixa de preço")
plt.xlabel("Faixa de preço")
plt.ylabel("Quantidade de ofertas")

plt.xticks(rotation=45)

plt.tight_layout()
plt.show()
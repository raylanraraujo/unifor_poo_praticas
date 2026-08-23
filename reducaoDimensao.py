import pandas as pd
import matplotlib.pyplot as plt
from sklearn.decomposition import PCA

# a importacao do pandas foi para carregar o DataFrame.
# a importacao do matplotlib.pyplot foi para plotar os graficos e fazer a visualizacao dos dados.
# a importacao do PCA foi para fazer a reducao de dimensionalidade dos dados.

# Configura o pandas para exibir todas as colunas na tela
pd.set_option('display.max_columns', None)
# Remove o limite de quebra de linha do pandas
pd.set_option('display.width', 1000)

# a primeira etapa é carregar o nosso dataframe, que contem os dados que vamos trabalhar.
df = pd.read_csv('iris.csv')
print(df.head())


# após carregar o DataFrame eu irei fazer uma separação dos dados.
x = df.drop(columns=['especie', 'codigo']).values  # estou guardando em uma variavel X os valores excluindo o valores da espécie. Isso porque os dados que me interessam para fazer a reducao de dimensionalidade são (altura_sepala,largura_sepala,altura_petala,largura_petala)
# ja na variavel y eu estou armazenando as classes porque quando eu fizer a reducao de dimensionalidade eu vou plotar esse dado num ScatterPlot ( num grafico que vai representar cada flor dessa)
y = df['especie'].values  # estou guardando em uma variavel y as classes das flores, para que eu possa colorir cada ponto do ScatterPlot de acordo com a sua classe.


pca = PCA(n_components=2)  # estou criando um objeto PCA, que vai me ajudar a reduzir a dimensionalidade dos dados. Eu estou dizendo que eu quero reduzir para 2 dimensões.
x_pca = pca.fit_transform(x)  # estou aplicando o PCA nos dados

# print(x_pca)  # estou imprimindo os dados reduzidos para 2 dimensões

# feito isso nós vamos criar um novo DataFrame para gente comecar a plotar os dados.
df_pca = pd.DataFrame({
    'PC1': x_pca[:, 0],  # estou criando uma coluna chamada PC1, que vai receber os valores da primeira componente principal
    'PC2': x_pca[:, 1],  # estou criando uma coluna chamada PC2, que vai receber os valores da segunda componente principal
    'especie': y    
})  # estou criando um novo DataFrame com os dados reduzidos para 2 dimensões. Eu estou chamando as colunas de PC1 e PC2 (Principal Component 1 e Principal Component 2)

# print(df_pca)  # estou imprimindo o novo DataFrame para verificar se os dados foram reduzidos corretamente

# feito isso a gente pode plotar esse gráfico utilizando o matplotlib.pyplot. Eu vou criar um ScatterPlot, que vai representar cada flor em um ponto no gráfico, e eu vou colorir cada ponto de acordo com a sua classe (especie).

plt.figure(figsize=(10, 7))                                        # Define o tamanho da figura/gráfico (10x7 polegadas)
for especie in df_pca["especie"].unique():                          # Percorre cada espécie única do DataFrame
    subset = df_pca[df_pca["especie"] == especie]                   # Filtra os dados apenas da espécie da iteração
    plt.scatter(subset["PC1"], subset["PC2"], label=especie, alpha=0.8)  # Plota os pontos de PC1 e PC2 com transparência

plt.title("Iris - PCA")                                            # Define o título principal do gráfico
plt.legend(title="Espécie")                                         # Adiciona a legenda com o título "Espécie"
plt.grid(True)                                                      # Ativa as linhas de grade no fundo do gráfico
plt.tight_layout()                                                 # Ajusta o espaçamento para evitar cortes no layout
plt.show()                                                          # Exibe a janela com o gráfico na tela
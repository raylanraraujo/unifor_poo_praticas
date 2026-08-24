import pandas as pd                                                         # Importa a biblioteca Pandas para manipulação e análise de dados
import matplotlib.pyplot as plt                                             # Importa o módulo Pyplot do Matplotlib para geração de gráficos

df = pd.read_csv("livros_books_to_scrape.csv")                              # Lê o arquivo CSV com os dados raspados e carrega em um DataFrame
df["preco"] = df["preco"].str.replace("£", "").astype(float)                # Remove o símbolo de libra '£' da coluna de preço e converte o texto para número decimal (float)

# contagem = df["categoria"].value_counts()                                   # Conta a quantidade total de livros pertencentes a cada categoria
# contagem.plot(kind="barh", figsize=(10, 8), color="skyblue", title="Número de Livros por Categoria")  # Cria um gráfico de barras horizontais (10x8) na cor azul-claro com título
# plt.xlabel("Quantidade")                                                    # Define o rótulo do eixo X como "Quantidade"
# plt.ylabel("Categoria")                                                     # Define o rótulo do eixo Y como "Categoria"
# plt.tight_layout()                                                          # Ajusta o espaçamento interno para evitar corte dos nomes das categorias
# plt.savefig("01_livros_por_categoria.png")                                  # Salva a imagem do gráfico gerado no diretório atual

# media = df.groupby("categoria")["preco"].mean().sort_values()               # Agrupa os livros por categoria, calcula a média dos preços e ordena do menor para o maior
# media.plot(kind="barh", figsize=(10, 8), color="lightgreen", title="Preço Médio por Categoria")       # Cria um gráfico de barras horizontais em verde-claro com título
# plt.xlabel("Preço (£)")                                                     # Define o rótulo do eixo X como "Preço (£)"
# plt.ylabel("Categoria")                                                     # Define o rótulo do eixo Y como "Categoria"
# plt.tight_layout()                                                          # Ajusta o layout da figura para não cortar legendas ou eixos
# plt.savefig("02_preco_medio_por_categoria.png")                             # Salva a imagem do gráfico de preço médio em arquivo PNG

# acima_50 = df[df["preco"] > 50]                                             # Filtra o DataFrame mantendo apenas os registros de livros com preço superior a 50
# cat_acima_50 = acima_50["categoria"].value_counts()                         # Conta a quantidade de livros com preço > 50 existentes dentro de cada categoria
# cat_acima_50.plot(kind="bar", figsize=(10, 6), color="salmon", title="Categorias com Livros > £50")    # Cria um gráfico de barras verticais na cor salmão
# plt.xlabel("Categoria")                                                     # Define o rótulo do eixo X como "Categoria"
# plt.ylabel("Quantidade")                                                    # Define o rótulo do eixo Y como "Quantidade"
# plt.tight_layout()                                                          # Organiza o espaçamento para que o nome das categorias fique visível
# plt.savefig("04_categorias_acima_50.png")                                   # Salva o gráfico filtrado em arquivo PNG

resumo = df.groupby("categoria").agg({                                      # Agrupa os dados por categoria e aplica funções de agregação especificadas em um dicionário
    "titulo": "count",                                                      # Contabiliza a contagem total de títulos por categoria
    "preco": "mean"                                                         # Calcula a média aritmética de preços por categoria
}).rename(columns={"titulo": "quantidade_livros", "preco": "preco_medio"})  # Renomeia as colunas resultantes para nomes mais claros e descritivos

print(resumo)                                                               # Imprime a tabela de resumo compilada no terminal

plt.figure(figsize=(10, 6))                                                 # Cria e define as dimensões de uma nova figura gráfica (10x6)
plt.scatter(resumo["quantidade_livros"], resumo["preco_medio"], s=100, alpha=0.7)  # Plota um gráfico de dispersão (pontos tamanho 100 com 70% de opacidade)
plt.title("Relação entre Quantidade de Livros e Preço Médio por Categoria") # Define o título do gráfico de dispersão
plt.xlabel("Quantidade de Livros")                                          # Define o rótulo do eixo X
plt.ylabel("Preço Médio (£)")                                               # Define o rótulo do eixo Y
plt.grid(True)                                                              # Exibe as linhas de grade ao fundo para facilitar a leitura visual dos dados
plt.tight_layout()                                                          # Ajusta as margens da figura gráfica
plt.savefig("05_scatter_livros_vs_preco.png")                               # Salva o gráfico de dispersão em arquivo de imagem PNG
#plt.show()                                                                 # Comentado: serve para exibir a janela do gráfico na tela se descomentado
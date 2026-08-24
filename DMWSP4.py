from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.safari.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import pandas as pd
import time

options = Options()
driver = webdriver.Safari()

driver.get("https://books.toscrape.com")
wait = WebDriverWait(driver, 10)

side_categories = wait.until(
	EC.presence_of_element_located((By.CLASS_NAME, "side_categories"))
)
category_elements = side_categories.find_elements(By.CSS_SELECTOR,"ul > li > ul > li > a")
category_urls = [(el.text.strip(), el.get_attribute("href")) for el in category_elements]

dados_livros = []

for categoria, url in category_urls:
    print(f"Acessando categoria: {categoria}")
    driver.get(url)
    try:
        wait.until(EC.presence_of_element_located((By.CLASS_NAME, "product_pod")))
    except:
        continue

    livros = driver.find_elements(By.CLASS_NAME, "product_pod")

    for livro in livros:
        titulo = livro.find_element(By.TAG_NAME, "h3").text.strip()
        preco = livro.find_element(By.CLASS_NAME, "price_color").text.strip()

        # Adiciona aos dados
        dados_livros.append({
            "categoria": categoria,
            "titulo": titulo,
            "preco": preco
        })

    time.sleep(1)

driver.quit()
df = pd.DataFrame(dados_livros)
df.to_csv("livros_books_to_scrape.csv", index=False)
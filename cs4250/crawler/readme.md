# CS4250 Project 1 - Web Crawler

Uses seed URL to download web pages and extract links that are then added to a dictionary which is then used to crawl more webpages from the links in the dictionary

### Running

clone repository and cd into directory

    gh repo clone maxhartke/cpp-code
    cd cpp-code/cs4250/crawler

Install dependencies

    pip install BeautifulSoup
    pip install requests
    pip install langdetect
    pip install -U matplotlib

run `scraper.py` using python3.x

    python scrapyer.py

All downloaded html pages will be in `/repository/text.html` and a report will be generated containing the craweled URL's and the number of outlinks

## Text Analysis

![Zipf's Law](Zipfs-law.png)

![Heaps's Law](Heaps-law.png)

FROM docker.elastic.co/elasticsearch/elasticsearch:8.9.2
# https://www.elastic.co/guide/en/elasticsearch/plugins/current/analysis-icu.html
RUN elasticsearch-plugin install analysis-icu
# https://www.elastic.co/guide/en/elasticsearch/plugins/current/analysis-kuromoji.html
RUN elasticsearch-plugin install analysis-kuromoji

# https://www.elastic.co/guide/en/elasticsearch/plugins/current/analysis-kuromoji-tokenizer.html
COPY ./dict/userdict_ja.txt /usr/share/elasticsearch/config/userdict_ja.txt

# Elasticsearch 8.x no longer uses log4j2.properties
# Instead, it uses log4j2.xml by default
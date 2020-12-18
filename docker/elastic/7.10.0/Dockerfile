FROM docker.elastic.co/elasticsearch/elasticsearch:7.10.0
# https://www.elastic.co/guide/en/elasticsearch/plugins/current/analysis-icu.html
RUN elasticsearch-plugin install analysis-icu
# https://www.elastic.co/guide/en/elasticsearch/plugins/current/analysis-kuromoji.html
RUN elasticsearch-plugin install analysis-kuromoji


# https://www.elastic.co/guide/en/elasticsearch/plugins/current/analysis-kuromoji-tokenizer.html
COPY ./dict/userdict_ja.txt /usr/share/elasticsearch/config/userdict_ja.txt

COPY ./log/log4j2.properties /usr/share/elasticsearch/config/log4j2.properties



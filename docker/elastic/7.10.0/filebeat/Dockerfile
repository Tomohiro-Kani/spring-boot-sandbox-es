FROM docker.elastic.co/beats/filebeat:7.10.0

COPY ./filebeat/config/filebeat.yml /usr/share/filebeat/filebeat.yml
USER root
RUN chown root:filebeat /usr/share/filebeat/filebeat.yml
USER filebeat

COPY ./filebeat/config/elasticsearch.yml /usr/share/filebeat/modules.d/elasticsearch.yml
USER root
RUN chown root:filebeat /usr/share/filebeat/modules.d/elasticsearch.yml
USER filebeat

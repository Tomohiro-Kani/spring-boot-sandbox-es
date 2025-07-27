FROM docker.elastic.co/beats/filebeat:8.9.2
USER root
COPY ./filebeat/config/filebeat.yml /usr/share/filebeat/filebeat.yml
RUN chmod go-w /usr/share/filebeat/filebeat.yml
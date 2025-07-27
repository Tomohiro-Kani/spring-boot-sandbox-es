# docker compose

#docker_es起動
# docker-compose.ymlからDockerイメージをビルド
$ docker compose build

# ビルドが成功したらコンテナ起動(background起動)
$ docker compose up -d

# Elasticsearch
http://localhost:9201/

# kibana
http://localhost:5601/

#終了
$ docker compose down


# docker

$ docker ps

$ docker network

$ docker image ls

$ docker volume ls

$ docker exec -it 7100_elasticsearch_1 bash


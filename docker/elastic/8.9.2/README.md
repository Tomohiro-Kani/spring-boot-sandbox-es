# Elasticsearch 8.9.2 Docker環境

## 概要
Elasticsearch 8.9.2、Kibana 8.9.2、Filebeat 8.9.2を含むDocker環境です。

## v7.10.0との主な違い

1. **セキュリティ機能**
   - Elasticsearch 8.xではデフォルトでセキュリティが有効化されています
   - 開発環境用に `xpack.security.enabled=false` で無効化しています

2. **ポート設定**
   - Elasticsearch: 9202 (ホスト) → 9200 (コンテナ)
   - Kibana: 5602 (ホスト) → 5601 (コンテナ)
   - v7.10.0環境と同時に起動可能なよう、異なるポートを使用

3. **ログ設定**
   - log4j2.propertiesの代わりにデフォルトのlog4j2.xmlを使用

## 起動方法

```bash
cd docker/elastic/8.9.2
docker compose build
docker compose up -d
```

## アクセスURL

- Elasticsearch: http://localhost:9202/
- Kibana: http://localhost:5602/

## 停止方法

```bash
docker compose down
```

## 注意事項

- 本環境は開発用です。本番環境では必ずセキュリティ機能を有効化してください
- v7.10.0環境と同時起動する場合は、ポート番号の違いに注意してください
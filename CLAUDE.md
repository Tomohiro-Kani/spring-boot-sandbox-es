# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## プロジェクト概要

Spring BootとElasticsearchの統合を検証するサンドボックスプロジェクトです。Docker環境でElasticsearch 7.10.0を実行し、REST High Level Clientを使用してJavaアプリケーションから接続します。

## 開発コマンド

### アプリケーションのビルドと実行
```bash
# アプリケーションのビルド
mvn clean package

# アプリケーションの実行
mvn spring-boot:run

# テストの実行
mvn test

# 単一テストの実行
mvn test -Dtest=テストクラス名#テストメソッド名
```

### Docker環境の操作
```bash
# Docker環境の起動（docker/elastic/7.10.0ディレクトリ内で実行）
cd docker/elastic/7.10.0
docker-compose build
docker-compose up -d

# Docker環境の停止
docker-compose down

# Elasticsearchコンテナへのアクセス
docker exec -it 7100_elasticsearch_1 bash
```

### アクセスURL
- Elasticsearch: http://localhost:9201/
- Kibana: http://localhost:5601/
- アプリケーション: http://localhost:8080/

## アーキテクチャ構造

### レイヤー構成
1. **Controller層** (`controller/`)
   - `ItemController`: RESTエンドポイントを提供（/item/list, /item/lists）
   - 現在ItemServiceへの依存があるが、Service層は未実装

2. **Elasticsearch設定** (`elasticsearch/`)
   - `EsClient`: メインのElasticsearchクライアントBean
   - `EsClientSub`: サブのElasticsearchクライアントBean
   - 両クライアントは同じ設定を使用し、複数のElasticsearch接続を管理可能

3. **設定ファイル**
   - `application.yml`: Elasticsearch接続設定（localhost:9200）とActuator設定
   - Docker環境では9201ポートにマッピングされる点に注意

### 重要な実装上の注意点

1. **未実装のService層**
   - ItemControllerがItemServiceを参照しているが、実際のServiceクラスは存在しない
   - 新機能追加時はまずService層の実装が必要

2. **ポートマッピング**
   - アプリケーション設定: 9200ポート
   - Docker環境: 9201ポート→9200ポート
   - 開発時はポート設定の確認が必要

3. **日本語解析サポート**
   - Dockerイメージに日本語辞書（userdict_ja.txt）が含まれる
   - KuromojiやICUプラグインの利用を想定

4. **監視とロギング**
   - Filebeatによるログ収集設定済み
   - Prometheusメトリクスエンドポイント有効
   - Actuatorエンドポイントはルートパス（/）で公開
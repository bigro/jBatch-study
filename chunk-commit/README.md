# chunk-commit

chunkのコミットを検証します。

## 準備
cloneした後に `./init.sh` を実行してください。(PostgreSQLが必要です)

## 検証
[チャンク指向処理](https://github.com/bigro/jBatch-study/wiki/%E3%83%81%E3%83%A3%E3%83%B3%E3%82%AF%E6%8C%87%E5%90%91%E5%87%A6%E7%90%86) に記載されているようなコミット単位になるか検証します。

chunkのコミット単位を5にして、9件目で例外を発生させる処理を実装しています。

動かすと、最初の5件のみDBに保存されていることが確認できます。

## Batch Checkpoints
また、例外が発生して異常終了した後にもう一度アプリケーションを起動すると６件目から処理が走っていることがわかります。

これは [Batch Checkpoints](https://github.com/bigro/jBatch-study/wiki/Batch-Checkpoints) の仕様です。

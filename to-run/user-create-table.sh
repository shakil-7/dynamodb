aws dynamodb --endpoint-url=http://localhost:4566 create-table \
    --table-name User \
    --attribute-definitions \
        AttributeName=userId,AttributeType=S \
        AttributeName=accountNo,AttributeType=S \
    --key-schema \
        AttributeName=userId,KeyType=HASH \
        AttributeName=accountNo,KeyType=RANGE \
--provisioned-throughput \
        ReadCapacityUnits=10,WriteCapacityUnits=5
aws dynamodb --endpoint-url=http://localhost:4566 create-table \
    --table-name Student \
    --attribute-definitions \
        AttributeName=studentId,AttributeType=S \
    --key-schema \
        AttributeName=studentId,KeyType=HASH \
--provisioned-throughput \
        ReadCapacityUnits=10,WriteCapacityUnits=5
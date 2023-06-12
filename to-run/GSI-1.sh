aws dynamodb --endpoint-url=http://localhost:4566 update-table \
    --table-name User \
    --attribute-definitions '[
      {
          "AttributeName": "accountNo",
          "AttributeType": "S"
      },
      {
          "AttributeName": "userId",
          "AttributeType": "S"
      }
    ]' \
    --global-secondary-index-updates '[
        {
            "Create": {
                "IndexName": "accountNo-userId",
                "KeySchema": [
                    {
                        "AttributeName": "accountNo",
                        "KeyType": "HASH"
                    },
                    {
                        "AttributeName": "userId",
                        "KeyType": "RANGE"
                    }
                ],
                "Projection": {
                    "ProjectionType": "ALL"
                },
                "ProvisionedThroughput": {
                    "ReadCapacityUnits": 1,
                    "WriteCapacityUnits": 1
                }
            }
        }
    ]' \
    $LOCAL
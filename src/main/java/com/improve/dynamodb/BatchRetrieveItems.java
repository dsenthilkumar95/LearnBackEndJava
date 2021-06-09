package com.improve.dynamodb;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.BatchGetItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.TableKeysAndAttributes;

import java.util.List;

public class BatchRetrieveItems {
    public static void main(String[] args){
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "ap-south-1")).withCredentials(new AWSCredentialsProvider() {
            @Override
            public AWSCredentials getCredentials() {
                return (new AWSCredentials() {
                    @Override
                    public String getAWSAccessKeyId() {
                        return "Accesskey";
                    }

                    @Override
                    public String getAWSSecretKey() {
                        return "SecretAccessKey";
                    }
                });
            }

            @Override
            public void refresh() {
            }
        })
                .build();
        DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
        TableKeysAndAttributes tableKeysAndAttributes = new TableKeysAndAttributes("Products")
                .addHashAndRangePrimaryKeys("ID","Nomenclature", 2, "sales management");

        BatchGetItemOutcome batchGetItemOutcome = dynamoDB.batchGetItem(tableKeysAndAttributes);

        for(String tableName : batchGetItemOutcome.getTableItems().keySet()){
            List<Item> items = batchGetItemOutcome.getTableItems().get(tableName);
            items.forEach(i -> {
                System.out.println(i.toJSONPretty());
            });
        }
    }
}

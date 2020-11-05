package com.comcast.dynamodb;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.BatchWriteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.TableWriteItems;

public class BatchWritingItems {
    public static void main(String[] args) {
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
        TableWriteItems tableWriteItems = new TableWriteItems("Products")
                .withItemsToPut(new Item()
                        .withPrimaryKey("ID", 4 , "Nomenclature", "New management")
                        .withString("batchUpdate", "new item create failed"));
        // Can contain up to 25 requests and 16MB of data
        BatchWriteItemOutcome batchWriteItemOutcome = dynamoDB.batchWriteItem(tableWriteItems);
        // Contains the unprocessed items
        System.out.println("batchWriteItemOutcome -> " + batchWriteItemOutcome.toString());
    }
}

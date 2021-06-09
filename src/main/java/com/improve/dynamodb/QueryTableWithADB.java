package com.improve.dynamodb;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

import java.util.HashMap;
import java.util.Map;

// ========================================================= NOT WORKING =======================================================
public class QueryTableWithADB {
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

        Map<String, AttributeValue> key = new HashMap<>();
        key.put("ID", new AttributeValue().withN("1"));
        GetItemResult products = amazonDynamoDB.getItem(new GetItemRequest().withTableName("Products").withKey(key));
        products.getItem().forEach((k,v) -> {
            System.out.println("Key -> " + k);
            System.out.println("Value -> " + v);
        });
    }
}

package com.improve.dynamodb;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.Arrays;

public class CreateTable {

    public static void main(String[] args) throws InterruptedException {
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

        String tableName = "Products1";

        Table table = dynamoDB.createTable (tableName,
                Arrays.asList (
                        new KeySchemaElement("ID", KeyType.HASH), // the partition key
                        // the sort key
                        new KeySchemaElement("Nomenclature", KeyType.RANGE)
                ),
                Arrays.asList (
                        new AttributeDefinition("ID", ScalarAttributeType.N),
                        new AttributeDefinition("Nomenclature", ScalarAttributeType.S)
                ),
                new ProvisionedThroughput(10L, 10L)
        );
        table.waitForActive();
        System.out.println("Table created successfully.  Status: " +
                table.getDescription().getTableStatus());
    }
}

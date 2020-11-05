package com.comcast.dynamodb;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.*;

public class CreateTableWithADB {
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
        CreateTableResult createTableResult = amazonDynamoDB.createTable(new CreateTableRequest()
                .withTableName("Products")
                .withKeySchema(new KeySchemaElement("ID", KeyType.HASH), new KeySchemaElement("Nomenclature", KeyType.RANGE))
                .withAttributeDefinitions(new AttributeDefinition("ID", ScalarAttributeType.N), new AttributeDefinition("Nomenclature", ScalarAttributeType.S))
                .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(10L).withWriteCapacityUnits(10L)));

        System.out.println("Table created in dynamoDB with name -> "
                + createTableResult.getTableDescription().getTableName());
    }
}

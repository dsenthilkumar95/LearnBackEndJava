package com.improve.dynamodb;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

import java.util.HashMap;
import java.util.Map;

public class LoadTableWithADB {

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

        int ID = 1;
        String Nomenclature = "Particle Blaster 5000";
        Map<String, AttributeValue> stat = new HashMap<>();
        stat.put("Manufacturer", new AttributeValue().withS("XYZ Inc."));
        stat.put("sales", new AttributeValue().withS("1M+"));
        stat.put("quantity", new AttributeValue().withS("500"));
        stat.put("img_src", new AttributeValue().withS("http://www.xyz.com/manuals/particleblaster5000.jpg"));
        stat.put("description", new AttributeValue().withS("A laser cutter used in plastic manufacturing."));

        Map<String, AttributeValue> stringAttributeValueMap = new HashMap<>();
        stringAttributeValueMap.put("ID", new AttributeValue().withN(String.valueOf(ID)));
        stringAttributeValueMap.put("Nomenclature", new AttributeValue().withS(Nomenclature));
        stringAttributeValueMap.put("stat", new AttributeValue().withM(stat));

        PutItemResult putItemResult = amazonDynamoDB.putItem(new PutItemRequest().withTableName("Products").withItem(stringAttributeValueMap));

        System.out.println("Put items result -> " + putItemResult);

    }
}

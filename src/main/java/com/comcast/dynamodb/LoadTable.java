package com.comcast.dynamodb;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class LoadTable {
    public LoadTable() throws IOException {
    }

    public static void main(String[] args) throws IOException {
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
        Table table = dynamoDB.getTable("Products");
        JsonParser parser = new JsonFactory()
                .createParser(new File("src/main/resources/jsons/secondLoadTableEntry.json"));

        JsonNode rootNode = new ObjectMapper().readTree(parser);
        Iterator<JsonNode> iter = rootNode.iterator();
        ObjectNode currentNode;

        while (iter.hasNext()) {
            currentNode = (ObjectNode) iter.next();
            int ID = currentNode.path("ID").asInt();
            String Nomenclature = currentNode.path("Nomenclature").asText();

            try {
                table.putItem(new Item()
                        .withPrimaryKey("ID", ID, "Nomenclature", Nomenclature)
                        .withJSON("Stat", currentNode.path("Stat").toString()));
                System.out.println("Successful load: " + ID + " " + Nomenclature);
            } catch (Exception e) {
                System.err.println("Cannot add product: " + ID + " " + Nomenclature);
                System.err.println(e.getMessage());
                break;
            }
        }
        parser.close();

    }
}

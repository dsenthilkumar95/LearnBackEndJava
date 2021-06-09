package com.improve.dynamodb;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import java.util.HashMap;
import java.util.Map;

public class CreateItems {
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
        Table productsTable = dynamoDB.getTable("Products");

        Map<String, String> stat = new HashMap<>();
        stat.put("Manufacturer" , "Products inc");
        stat.put("sales" , "2M+");
        stat.put("quantity" , "500");
        stat.put("img_src" , "http://www.sales.com/manuals/particleblaster5000.jpg");
        stat.put("description" , "A laser cutter is saled in this company");

        Item item = new Item()
                .withPrimaryKey("ID", 3)
                .withString("Nomenclature", "Production Management")
                .withMap("Stat", stat);
        PutItemOutcome putItemOutcome = productsTable.putItem(item);
        System.out.println("PutItemOutcome -> " + putItemOutcome.toString());

    }
}

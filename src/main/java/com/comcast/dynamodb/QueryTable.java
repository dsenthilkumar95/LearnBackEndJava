package com.comcast.dynamodb;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.internal.IteratorSupport;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

public class QueryTable {
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
        Table productsTable = dynamoDB.getTable("Products");

        QuerySpec querySpec = new QuerySpec().withKeyConditionExpression("ID = :ID").withValueMap(new ValueMap().with(":ID", 4));

        // Name map replaces name variable from key condition expression and value map replaces value variable from key condition expression
        // Projection expression is to decide fields to be displayed
        QuerySpec querySpec1 = new QuerySpec()
                .withProjectionExpression("ID, Stat.sales")
                .withKeyConditionExpression("#ID = :xxx")
                .withNameMap(new NameMap().with("#ID", "ID"))
                .withValueMap(new ValueMap().with(":xxx", 2));

        ItemCollection<QueryOutcome> items = productsTable.query(querySpec);
        IteratorSupport<Item, QueryOutcome> itemsIterator = items.iterator();
        while(itemsIterator.hasNext()){
            Item item = itemsIterator.next();
            System.out.println("Queried Item -> " + item.toJSONPretty());
        }
    }
}

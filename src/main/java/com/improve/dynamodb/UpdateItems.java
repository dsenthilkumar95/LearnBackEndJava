package com.improve.dynamodb;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

import static com.amazonaws.auth.policy.actions.DynamoDBv2Actions.UpdateItem;

public class UpdateItems {
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

        UpdateItemOutcome updateItemOutcome = productsTable.updateItem("ID", 2,
                "Nomenclature", "sales management",
                "set #st.#d = :val1",
                new NameMap().with("#st", "Stat").with("#d", "description"),
                new ValueMap().with(":val1", "Updated description"));

        System.out.println("updateItemOutcome -> " + updateItemOutcome.toString());

        UpdateItemOutcome updateItemOutcome1 = productsTable.updateItem(new UpdateItemSpec()
                .withPrimaryKey("ID", 2, "Nomenclature", "sales management")
                .withUpdateExpression("remove Stat.description").withReturnValues(ReturnValue.ALL_NEW));

        System.out.println("updateItemOutcome1 -> " + updateItemOutcome1);
    }
}

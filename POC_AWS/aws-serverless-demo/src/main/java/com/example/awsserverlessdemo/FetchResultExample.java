package com.example.awsserverlessdemo;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.rdsdata.AWSRDSData;
import com.amazonaws.services.rdsdata.AWSRDSDataClient;
import com.amazonaws.services.rdsdata.model.ExecuteStatementRequest;
import com.amazonaws.services.rdsdata.model.ExecuteStatementResult;
import com.amazonaws.services.rdsdata.model.Field;
import com.amazonaws.services.rdsdata.model.SqlParameter;
import com.example.awsserverlessdemo.model.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FetchResultExample {

    private static final String ORDER_TABLE_NAME = "order";
    private static final String DB_NAME = "testdatabase";
    private static final String RESOURCE_ARN = "arn:aws:rds:ap-south-1:881914528194:cluster:database-cluster";
    private static final String SECRET_ARN = "arn:aws:secretsmanager:ap-south-1:881914528194:secret:rds-db-credentials/cluster-NCDDGTT4DMSD4WHU7PNP4PY2FQ/admin-8Hsofg";

    public static void main(String[] args) {
        AWSRDSData rdsData = AWSRDSDataClient.builder().build();
        String insertQuery = "INSERT INTO `order` (`customerId`, `totalAmount`, `totalTax`) VALUES (:customerId," +
                " :totalAmount, :taxAmount);";
        String selectQuery = "select * from `order` ;";

        Order order = Order.builder()
                .customerId("customer123")
                .totalAmount(new BigDecimal("250.00"))
                .taxAmount(new BigDecimal("25.00"))
                .build();

        List<SqlParameter> parameters = new ArrayList<>();
        parameters.add(new SqlParameter().withName("customerId")
                .withValue(new Field().withStringValue(order.getCustomerId())));
        parameters.add(new SqlParameter().withName("totalAmount")
                .withValue(new Field().withDoubleValue(order.getTotalAmount().doubleValue())));
        parameters.add(new SqlParameter().withName("taxAmount")
                .withValue(new Field().withDoubleValue(order.getTaxAmount().doubleValue())));

        ExecuteStatementRequest request = new ExecuteStatementRequest()
                .withResourceArn(RESOURCE_ARN)
                .withSecretArn(SECRET_ARN)
                .withDatabase(DB_NAME)
                .withSql(insertQuery)
                .withParameters(parameters);

        rdsData.executeStatement(request);
        System.out.println("Data saved successfully.");

        request = new ExecuteStatementRequest()
                .withResourceArn(RESOURCE_ARN)
                .withSecretArn(SECRET_ARN)
                .withDatabase(DB_NAME)
                .withSql(selectQuery);

        ExecuteStatementResult result = rdsData.executeStatement(request);

        for (List<Field> fields : result.getRecords()) {
            long orderId = fields.get(0).getLongValue();
            String customerId = fields.get(1).getStringValue();
            String totalAmount = fields.get(2).getStringValue();
            String taxAmount = fields.get(3).getStringValue();

            System.out.println("orderId: " + orderId + ", customerId: " + customerId + ", totalAmount: "
                    + totalAmount + ", taxAmount: " + taxAmount);
        }
    }
}
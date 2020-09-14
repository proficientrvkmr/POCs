package com.example.awsserverlessdemo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.rdsdata.AWSRDSData;
import com.amazonaws.services.rdsdata.AWSRDSDataClient;
import com.amazonaws.services.rdsdata.model.ExecuteStatementRequest;
import com.amazonaws.services.rdsdata.model.Field;
import com.amazonaws.services.rdsdata.model.SqlParameter;
import com.example.awsserverlessdemo.model.Order;
import com.example.awsserverlessdemo.model.GatewayResponse;

import java.util.ArrayList;
import java.util.List;

import static com.example.awsserverlessdemo.AWSConstants.*;

public class CreateNewOrderHandler implements RequestHandler<Order, GatewayResponse<Object>> {

    String insertQuery = "INSERT INTO `order` (`customerId`, `totalAmount`, `totalTax`) VALUES (:customerId," +
            " :totalAmount, :taxAmount);";

    @Override
    public GatewayResponse<Object> handleRequest(Order order, Context context) {
        context.getLogger().log("Input: " + order);

        AWSRDSData rdsData = AWSRDSDataClient.builder().build();
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

        return GatewayResponse.builder()
                .statusCode(200)
                .body("Order saved successfully into Database.")
                .build();
    }
}
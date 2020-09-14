package com.example.awsserverlessdemo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.rdsdata.AWSRDSData;
import com.amazonaws.services.rdsdata.AWSRDSDataClient;
import com.amazonaws.services.rdsdata.model.ExecuteStatementRequest;
import com.amazonaws.services.rdsdata.model.ExecuteStatementResult;
import com.amazonaws.services.rdsdata.model.Field;
import com.example.awsserverlessdemo.model.GatewayResponse;
import com.example.awsserverlessdemo.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.awsserverlessdemo.AWSConstants.*;

public class GetAllOrderHandler implements RequestHandler<Order, GatewayResponse<Object>> {


    @Override
    public GatewayResponse<Object> handleRequest(Order requestBody, Context context) {
        String selectQuery = "select * from `" + ORDER_TABLE_NAME + "` ;";

        AWSRDSData rdsData = AWSRDSDataClient.builder().build();
        ExecuteStatementRequest request = new ExecuteStatementRequest()
                .withResourceArn(RESOURCE_ARN)
                .withSecretArn(SECRET_ARN)
                .withDatabase(DB_NAME)
                .withSql(selectQuery);

        ExecuteStatementResult result = rdsData.executeStatement(request);
        List<Map<String, Object>> resultData = new ArrayList<>();

        for (List<Field> fields : result.getRecords()) {
            long orderId = fields.get(0).getLongValue();
            String customerId = fields.get(1).getStringValue();
            String totalAmount = fields.get(2).getStringValue();
            String taxAmount = fields.get(3).getStringValue();

            System.out.println("orderId: " + orderId + ", customerId: " + customerId + ", totalAmount: "
                    + totalAmount + ", taxAmount: " + taxAmount);

            Map<String, Object> orderMap = new HashMap<>();
            orderMap.put("orderId", orderId);
            orderMap.put("customerId", customerId);
            orderMap.put("totalAmount", totalAmount);
            orderMap.put("taxAmount", taxAmount);
            resultData.add(orderMap);
        }

        return GatewayResponse.builder()
                .statusCode(200)
                .body(resultData)
                .build();
    }
}
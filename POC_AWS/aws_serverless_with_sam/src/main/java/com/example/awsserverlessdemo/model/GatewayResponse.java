package com.example.awsserverlessdemo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
@JsonAutoDetect
@Builder
public class GatewayResponse<T> {

    private final T body;
    private final int statusCode;

    /**
     * Creates a GatewayResponse object.
     *
     * @param body       body of the response
     * @param statusCode status code of the response
     */
    public GatewayResponse(final T body, final int statusCode) {
        this.statusCode = statusCode;
        this.body = body;
    }
}

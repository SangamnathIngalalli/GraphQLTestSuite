package com.graphql.test.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.graphql.test.config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.qameta.allure.Step;

public class GraphQLClient {
    private static final ConfigManager config = ConfigManager.getInstance();

    public GraphQLClient() {
        RestAssured.baseURI = config.getBaseUrl();
    }

    @Step("Execute GraphQL Query")
    public Response executeQuery(String query, Object variables) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + config.getApiKey())
                .body(new GraphQLRequest(query, variables))
                .when()
                .post("/graphql")
                .then()
                .extract()
                .response();
    }

    @Step("Execute GraphQL Mutation")
    public Response executeMutation(String mutation, Object variables) {
        return executeQuery(mutation, variables);
    }

    private static class GraphQLRequest {
        @JsonProperty("query")
        private final String query;
        
        @JsonProperty("variables")
        private final Object variables;

        public GraphQLRequest(String query, Object variables) {
            this.query = query;
            this.variables = variables;
        }
    }
} 
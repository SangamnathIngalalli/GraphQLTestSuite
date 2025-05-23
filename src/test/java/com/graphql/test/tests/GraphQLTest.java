package com.graphql.test.tests;

import com.graphql.test.services.GraphQLClient;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("GraphQL API Testing")
@Feature("User Management")
public class GraphQLTest {
    private GraphQLClient graphQLClient;

    @BeforeClass
    public void setup() {
        graphQLClient = new GraphQLClient();
    }

    @Test(description = "Verify user query functionality")
    @Story("User Query")
    @Severity(SeverityLevel.CRITICAL)
    public void testUserQuery() {
        String query = """
            query GetUser($id: ID!) {
                user(id: $id) {
                    id
                    name
                    email
                }
            }
            """;

        Response response = graphQLClient.executeQuery(query, new Object() {
            public final String id = "1";
        });

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().get("data.user"));
    }

    @Test(description = "Verify user creation mutation")
    @Story("User Creation")
    @Severity(SeverityLevel.CRITICAL)
    public void testUserCreation() {
        String mutation = """
            mutation CreateUser($input: CreateUserInput!) {
                createUser(input: $input) {
                    id
                    name
                    email
                }
            }
            """;

        Response response = graphQLClient.executeMutation(mutation, new Object() {
            public final Object input = new Object() {
                public final String name = "Test User";
                public final String email = "test@example.com";
            };
        });

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().get("data.createUser.id"));
    }
} 
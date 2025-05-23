package com.graphql.test.tests;

import com.graphql.test.services.GraphQLClient;
import com.graphql.test.utils.SpaceXQueries;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("SpaceX GraphQL API Testing")
@Feature("SpaceX Data")
public class SpaceXGraphQLTest {
    private GraphQLClient graphQLClient;

    @BeforeClass
    public void setup() {
        graphQLClient = new GraphQLClient();
    }

    @Test(description = "Verify rockets query functionality")
    @Story("Rockets Query")
    @Severity(SeverityLevel.CRITICAL)
    public void testRocketsQuery() {
        Response response = graphQLClient.executeQuery(SpaceXQueries.GET_ROCKETS, null);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().get("data.rockets"));
        Assert.assertTrue(response.jsonPath().getList("data.rockets").size() > 0);
    }

    @Test(description = "Verify launches query functionality")
    @Story("Launches Query")
    @Severity(SeverityLevel.CRITICAL)
    public void testLaunchesQuery() {
        Response response = graphQLClient.executeQuery(SpaceXQueries.GET_LAUNCHES, null);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().get("data.launches"));
        Assert.assertEquals(response.jsonPath().getList("data.launches").size(), 5);
    }

    @Test(description = "Verify specific launch query functionality")
    @Story("Specific Launch Query")
    @Severity(SeverityLevel.CRITICAL)
    public void testSpecificLaunchQuery() {
        Response response = graphQLClient.executeQuery(SpaceXQueries.GET_LAUNCH, new Object() {
            public final String id = "109";
        });

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().get("data.launch"));
        Assert.assertEquals(response.jsonPath().getString("data.launch.id"), "109");
    }

    @Test(description = "Verify ships query functionality")
    @Story("Ships Query")
    @Severity(SeverityLevel.CRITICAL)
    public void testShipsQuery() {
        Response response = graphQLClient.executeQuery(SpaceXQueries.GET_SHIPS, null);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response.jsonPath().get("data.ships"));
        Assert.assertTrue(response.jsonPath().getList("data.ships").size() > 0);
    }
} 
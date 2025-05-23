package com.graphql.test.utils;

public class SpaceXQueries {
    public static final String GET_ROCKETS = """
        query GetRockets {
            rockets {
                id
                name
                type
                company
                country
                description
                first_flight
                cost_per_launch
                success_rate_pct
            }
        }
        """;

    public static final String GET_LAUNCHES = """
        query GetLaunches {
            launches(limit: 5) {
                id
                mission_name
                launch_date_local
                launch_success
                rocket {
                    rocket_name
                }
                launch_site {
                    site_name
                }
            }
        }
        """;

    public static final String GET_LAUNCH = """
        query GetLaunch($id: ID!) {
            launch(id: $id) {
                id
                mission_name
                launch_date_local
                launch_success
                details
                rocket {
                    rocket_name
                    rocket_type
                }
                launch_site {
                    site_name
                    site_name_long
                }
            }
        }
        """;

    public static final String GET_SHIPS = """
        query GetShips {
            ships {
                id
                name
                type
                active
                home_port
                image
                missions {
                    name
                    flight
                }
            }
        }
        """;
} 
package com.app.requestBuilder;

import com.app.constants.FrameworkConstants;
import io.restassured.path.json.JsonPath;
import java.util.ArrayList;
import java.util.List;

import static com.app.utils.ApiUtils.readJsonAndGetAsString;

public final class RcbTeamRequestParsing {

    private final String resource = readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath() + "RCBTeam.json");
    private JsonPath jsonPath;

    private RcbTeamRequestParsing() {
    }

    public static RcbTeamRequestParsing RcbTeam() {
        return new RcbTeamRequestParsing();
    }

    public List<String> getRCBTeamForeignPlayers() {

        jsonPath = new JsonPath(resource);
        int numberOfPlayers;

        numberOfPlayers = jsonPath.getInt("player.size()");
        List<String> name = new ArrayList<>();

        try {
            for (int i = 0; i < numberOfPlayers; i++) {
                String countryName = jsonPath.getString("player[" + i + "].country");
                if (!countryName.equalsIgnoreCase("India")) {
                    String playerName = jsonPath.getString("player[" + i + "].name");
                    name.add(playerName);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception Occurred,There is a problem when fetching the RCBTeam foreign Player name, check the RCBTeam.json request ");
        }
        return name;
    }


    public List<String> getRcbTeamPlayersRoles() {

        jsonPath = new JsonPath(resource);
        int numberOfPlayers = jsonPath.getInt("player.size()");
        List<String> roles = new ArrayList<>();
        try {
            for (int i = 0; i < numberOfPlayers; i++) {
                String role = jsonPath.getString("player[" + i + "].role");
                roles.add(role);
            }
        } catch (Exception e) {
            throw new RuntimeException("ArrayIndexOutOfBoundsException,There is a problem when parsing the players based on role, check the RCBTeam.json request");
        }

        return roles;
    }


}


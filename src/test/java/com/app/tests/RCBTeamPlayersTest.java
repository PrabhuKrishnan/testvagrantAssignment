package com.app.tests;

import com.app.annotations.FrameworkAnnotation;
import com.app.enums.CategoryType;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import java.util.List;
import static com.app.requestBuilder.RcbTeamRequestParsing.RcbTeam;

public class RCBTeamPlayersTest {

    private final SoftAssertions softAssertion = new SoftAssertions();

    @FrameworkAnnotation(author = {"prabhu"}, category = {CategoryType.REGRESSION})
    @Test(description = "To Validates that the team has only 4 foreign players")
    public void validateRCBTeamHasFourForeignPlayers() {

        List<String> rcbTeamForeignPlayersName = RcbTeam()
                .getRCBTeamForeignPlayers();

        softAssertion.assertThat(rcbTeamForeignPlayersName)
                .isNotNull()
                .withFailMessage(() -> "There is at least 4 foreign players in team")
                .as("Validate that RCB team should have 4 foreign players in team").hasSize(4);
        softAssertion.assertAll();
    }

    @FrameworkAnnotation(author = {"prabhu"}, category = {CategoryType.REGRESSION})
    @Test(description = "To Validates that the team has at least one wicket keeper")
    public void validateRCBTeamHasOneWicketKeeper() {

        List<String> rctTeamPlayerRoles = RcbTeam().getRcbTeamPlayersRoles();

        softAssertion.assertThat(rctTeamPlayerRoles)
                .isNotNull()
                .withFailMessage(() -> "RCB team should have at least one wicket-keeper")
                .as("Validate that RCB team should have at least one wicket-keeper").contains("Wicket-keeper");
        softAssertion.assertAll();
    }
}

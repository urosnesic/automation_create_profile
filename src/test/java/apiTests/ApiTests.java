package apiTests;

import api.requests.GetProfilesRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/*
    TODO
    This is just a placeholder test.
    I managed to make api end points for POST login and GET profiles to function,
    but I was unable to make end points for CREATE profile and DELETE profile to function.
    (I can CREATE profile through Postman but did not yet managed to do that through code)
 */

public class ApiTests {

    @Test
    public void testDefaultProfile() throws IOException, InterruptedException {

        GetProfilesRequest request = new GetProfilesRequest();

        Assert.assertEquals(request.getProfilesJson().get(0).getProfileName(), "Family");
    }
}

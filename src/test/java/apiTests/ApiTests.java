package apiTests;

import api.requests.GetProfilesRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApiTests {

    @Test
    public void testDefaultProfile() throws IOException, InterruptedException {

        GetProfilesRequest request = new GetProfilesRequest();

        Assert.assertEquals(request.getProfilesJson().get(0).getProfileName(), "Family");
    }
}

package api.requests;

import api.parameters.ParametersForCreateProfile;
import api.parameters.PostCreateProfileParameters;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
    TODO
    This end point, for now, is not functional in code.
    Problem, probably is in parameters that I send through POST.
    (Although, I have no problem sending request through Postman)
 */

public class PostCreateProfileRequest extends PostLoginRequest {

    public PostCreateProfileRequest() throws IOException, InterruptedException {}

    ParametersForCreateProfile param = new ParametersForCreateProfile();

    public String jsonParam = mapper.writeValueAsString(param);

    private HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(POST_CREATE_PROFILE_URL))
            .header("Content-Type", "application/json")
            .header("Authorization", "Basic " + getAccessToken())
            .POST(HttpRequest.BodyPublishers.ofString(jsonParam))
            .build();

        private HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        PostCreateProfileParameters responseBody = mapper.readValue(response.body(), PostCreateProfileParameters.class);


}

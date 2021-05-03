package api.requests;

import api.parameters.GetProfileParameters;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class GetProfilesRequest extends PostLoginRequest {

        public GetProfilesRequest() throws IOException, InterruptedException {}

        private HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GET_PROFILES_URL))
                .GET()
                .header("Content-Type", "application/jason")
                .header("Authorization", "Bearer " + getAccessToken())
                .build();

        private HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        public List<GetProfileParameters> getProfilesJson() throws JsonProcessingException {
               List<GetProfileParameters> profileJson = Arrays.asList(mapper.readValue(response.body(), GetProfileParameters[].class));
               return profileJson;
        }


}

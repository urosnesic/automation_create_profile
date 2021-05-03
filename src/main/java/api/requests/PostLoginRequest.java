package api.requests;

import api.ApiBase;
import api.parameters.AccessToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class PostLoginRequest extends ApiBase {

    private static final String BASIC_TOKEN = "YjhkOWFkZTQtMTA5My00NmE3LWE0ZjctMGU0N2JlNDYzYzEwOjF3NGRtd3c4N3gxZTlsODllc3NxdmM4MXBpZHJxc2EwbGkxcnZhMjM=";

    public PostLoginRequest() throws IOException, InterruptedException {}

        private static Map<Object, Object> parameters = new HashMap<>();
        static {
            parameters.put("password", "N@vig@tor2o2o");
            parameters.put("username", "BAF15736AE789A1712EEB3F87E27C63D78F39E0A9FC226EECC6487DA9390B041");
            parameters.put("device_number", "3b20a4bb-39fd-4794-8977-724159e8a7f5");
        }

        private static HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(POST_LOGIN_URL))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Basic " + BASIC_TOKEN)
                .POST(ofFormData(parameters))
                .build();

        protected static String getAccessToken () throws IOException, InterruptedException {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            AccessToken responseBody = mapper.readValue(response.body(), AccessToken.class);
            String accessToken = responseBody.getAccess_token();
            return accessToken;
        }
}

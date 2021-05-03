package api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ApiBase {

    protected static final String POST_LOGIN_URL = "https://api-web.ug-be.cdn.united.cloud/oauth/token?grant_type=password";
    protected static final String POST_CREATE_PROFILE_URL = "https://api-web.ug-be.cdn.united.cloud/v1/profiles";
    protected static final String GET_PROFILES_URL = "https://api-web.ug-be.cdn.united.cloud/v1/profiles";

    protected static ObjectMapper mapper = new ObjectMapper();

    protected static HttpClient client = HttpClient.newHttpClient();

    protected static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder
                .append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder
                .append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }
}

package api.parameters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken {

    private String access_token;

    @JsonProperty("access_token")
    public String getAccess_token() {

        return access_token;
    }
}

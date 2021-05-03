package api.parameters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetProfileParameters {

    private String id;
    private String profileName;

    @JsonProperty("id")
    public String getId() {

        return id;
    }

    @JsonProperty("profileName")
    public String getProfileName() {

        return profileName;
    }

    @Override
    public String toString() {
        return "GetProfileParameters{" +
                "id='" + id + '\'' +
                ", profileName='" + profileName + '\'' +
                '}';
    }
}

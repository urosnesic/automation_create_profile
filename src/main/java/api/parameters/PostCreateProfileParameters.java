package api.parameters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCreateProfileParameters {

    private Integer id;
    private String profileName;
    private String ageGroup;
    private Boolean pinProtected;

    @JsonProperty("id")
    public Integer getId() {

        return id;
    }

    @JsonProperty("profileName")
    public String getProfileName() {

        return profileName;
    }

    @JsonProperty("ageGroup")
    public String getAgeGroup() {

        return ageGroup;
    }

    @JsonProperty("pinProtected")
    public Boolean getPinProtected() {

        return pinProtected;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public void setPinProtected(Boolean pinProtected) {
        this.pinProtected = pinProtected;
    }

    @Override
    public String toString() {
        return "PostCreateProfileParameters{" +
                "id=" + id +
                ", profileName='" + profileName + '\'' +
                ", ageGroup='" + ageGroup + '\'' +
                ", pinProtected=" + pinProtected +
                '}';
    }
}

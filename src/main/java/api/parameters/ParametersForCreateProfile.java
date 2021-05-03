package api.parameters;

public class ParametersForCreateProfile {

    private String profileName = "prifil 1";
    private String ageGroup = "AGE_18_PLUS";
    private Integer avatarId = 8;
    private Integer year = 2000;
    private String pin = "";

    public String getProfileName() {

        return profileName;
    }

    public void setProfileName(String profileName) {

        this.profileName = profileName;
    }

    public String getAgeGroup() {

        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {

        this.ageGroup = ageGroup;
    }

    public Integer getAvatarId() {

        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {

        this.avatarId = avatarId;
    }

    public Integer getYear() {

        return year;
    }

    public void setYear(Integer year) {

        this.year = year;
    }

    public String getPin() {

        return pin;
    }

    public void setPin(String pin) {

        this.pin = pin;
    }

    @Override
    public String toString() {
        return "ParametersForCreateProfile{" +
                "profileName='" + profileName + '\'' +
                ", ageGroup='" + ageGroup + '\'' +
                ", avatarId=" + avatarId +
                ", year=" + year +
                ", pin='" + pin + '\'' +
                '}';
    }
}

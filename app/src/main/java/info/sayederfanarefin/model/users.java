package info.sayederfanarefin.model;

/**
 * Created by erfan on 30/06/17.
 */
public class users {

    private String coverPicLocation;
    private String phone;
    private String uid;
    private String userCustomId;
    private String used_only_for_freind_requests;
    private String userName;
    private String email;
    private String profilePicLocation;
    private String timeLineAudio;
    private String birthDate;
    private String gender;
    private String mood;

    public users() {
        used_only_for_freind_requests = "new";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicLocation() {
        return profilePicLocation;
    }

    public void setProfilePicLocation(String profilePicLocation) {
        this.profilePicLocation = profilePicLocation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCoverPicLocation() {
        return coverPicLocation;
    }

    public void setCoverPicLocation(String coverPicLocation) {
        this.coverPicLocation = coverPicLocation;
    }

    public String getTimeLineAudio() {
        return timeLineAudio;
    }

    public void setTimeLineAudio(String timeLineAudio) {
        this.timeLineAudio = timeLineAudio;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getUserCustomId() {
        return userCustomId;
    }

    public void setUserCustomId(String userCustomId) {
        this.userCustomId = userCustomId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}

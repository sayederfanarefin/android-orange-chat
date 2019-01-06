package info.sayederfanarefin.model;
/**
 * Created by schmaedech on 30/06/17.
 */
public class users {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


    public String getuser_custom_id() {
        return user_custom_id;
    }

    public void setuser_custom_id(String user_custom_id) {
        this.user_custom_id = user_custom_id;
    }




    public String getCoverPicLocation() {
        return coverPicLocation;
    }

    public void setCoverPicLocation(String coverPicLocation) {
        this.coverPicLocation = coverPicLocation;
    }

    private String coverPicLocation;
    private String phone;
    private String uid;
    private String user_custom_id;
    private String used_only_for_freind_requests;
    private String username;
    private String email;
    private String profilePicLocation;
    private String timeLineAudio;

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

    private String mood;



    public users() {
        used_only_for_freind_requests = "new";
    }

}

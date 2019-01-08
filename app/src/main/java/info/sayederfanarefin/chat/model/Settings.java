package info.sayederfanarefin.chat.model;

public class Settings {
    private boolean messageNotification;
    private boolean newFriendsNotification;
    private boolean sound;
    private boolean vibrate;

    public boolean isMessageNotification() {
        return messageNotification;
    }

    public void setMessageNotification(boolean messageNotification) {
        this.messageNotification = messageNotification;
    }

    public boolean isNewFriendsNotification() {
        return newFriendsNotification;
    }

    public void setNewFriendsNotification(boolean newFriendsNotification) {
        this.newFriendsNotification = newFriendsNotification;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public boolean isVibrate() {
        return vibrate;
    }

    public void setVibrate(boolean vibrate) {
        this.vibrate = vibrate;
    }
}

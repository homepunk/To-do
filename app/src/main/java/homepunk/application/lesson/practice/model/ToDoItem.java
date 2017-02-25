package homepunk.application.lesson.practice.model;

import com.google.gson.annotations.SerializedName;

public class ToDoItem {
    public static final String KEY_ID = "id";
    public static final String KEY_USER_ID = "userId";
    public static final String KEY_TITLE = "title";
    public static final String KEY_COMPLETED = "completed";

    @SerializedName(KEY_ID)
    private int id;

    @SerializedName(KEY_USER_ID)
    private int userId;

    @SerializedName(KEY_TITLE)
    private String title;

    @SerializedName(KEY_COMPLETED)
    private boolean completed;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String getCompletedState() {
        return completed ? "yes" : "no";
    }

    @Override
    public String toString() {
        return "Id: " + this.id + "\nUser id: " + this.userId
                + "\nTitle: " + this.title + "\nCompleted: " + getCompletedState();
    }
}

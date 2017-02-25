package homepunk.application.lesson.practice.interfaces;

public interface IToDoPresenter {
    void setView(IToDoView view);

    void getToDoList();
}
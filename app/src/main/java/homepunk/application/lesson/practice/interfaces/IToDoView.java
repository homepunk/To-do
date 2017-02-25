package homepunk.application.lesson.practice.interfaces;

import java.util.List;

import homepunk.application.lesson.practice.model.ToDoItem;

public interface IToDoView {
    void onResult(List<ToDoItem> toDoList);

    void onError(String exception);
}

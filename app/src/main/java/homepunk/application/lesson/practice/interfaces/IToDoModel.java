package homepunk.application.lesson.practice.interfaces;

import java.util.List;

import homepunk.application.lesson.practice.model.ToDoItem;
import rx.Observable;

public interface IToDoModel {
        Observable<List<ToDoItem>> getToDoList();
}

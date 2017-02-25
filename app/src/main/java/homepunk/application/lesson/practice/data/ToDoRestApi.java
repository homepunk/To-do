package homepunk.application.lesson.practice.data;

import java.util.List;

import homepunk.application.lesson.practice.model.ToDoItem;
import retrofit2.http.GET;
import rx.Observable;

public interface ToDoRestApi {
    @GET("todos")
    Observable<List<ToDoItem>> loadToDoList();
}

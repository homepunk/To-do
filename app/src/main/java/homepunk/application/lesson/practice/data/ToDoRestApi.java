package homepunk.application.lesson.practice.data;

import java.util.List;

import homepunk.application.lesson.practice.model.ToDoItem;
import retrofit2.http.GET;
import rx.Observable;

import static homepunk.application.lesson.practice.data.Constants.END_POINT;

public interface ToDoRestApi {
    @GET('')
    Observable<List<ToDoItem>> loadToDoList();
}

package homepunk.application.lesson.practice.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import homepunk.application.lesson.practice.interfaces.IToDoModel;
import homepunk.application.lesson.practice.model.ToDoItem;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import static homepunk.application.lesson.practice.data.Constants.BASE_URL;

public class ToDoRepository implements IToDoModel {
    private ToDoRestApi toDoService;

    public ToDoRepository() {
        toDoService = createToDoRestApi();
    }

    private Gson createGson() {
        return new GsonBuilder()
                .create();
    }

    private ToDoRestApi createToDoRestApi() {
        Gson gson = createGson();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(ToDoRestApi.class);
    }

    @Override
    public Observable<List<ToDoItem>> getToDoList() {
        return toDoService.loadToDoList();
    }
}

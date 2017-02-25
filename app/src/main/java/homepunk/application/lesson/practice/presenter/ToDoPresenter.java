package homepunk.application.lesson.practice.presenter;

import java.util.List;

import homepunk.application.lesson.practice.data.ToDoRepository;
import homepunk.application.lesson.practice.interfaces.IToDoModel;
import homepunk.application.lesson.practice.interfaces.IToDoPresenter;
import homepunk.application.lesson.practice.interfaces.IToDoView;
import homepunk.application.lesson.practice.model.ToDoItem;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ToDoPresenter implements IToDoPresenter {
    private IToDoView view;
    private IToDoModel model;
    private Subscription subscription;

    public ToDoPresenter() {
        this.model = new ToDoRepository();
    }

    @Override
    public void setView(IToDoView view) {
        this.view = view;
    }

    @Override
    public void getToDoList() {
        model.getToDoList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(createSubscription());
    }

    private Subscriber createSubscription(){
        if (this.subscription == null)
            this.subscription = new Subscriber<List<ToDoItem>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                ToDoPresenter.this.view.onError(e.getLocalizedMessage());
            }

            @Override
            public void onNext(List<ToDoItem> toDoItems) {
                ToDoPresenter.this.view.onResult(toDoItems);
            }
        };

        return (Subscriber) this.subscription;
    }
}

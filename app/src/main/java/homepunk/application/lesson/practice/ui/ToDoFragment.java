package homepunk.application.lesson.practice.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import homepunk.application.lesson.practice.R;
import homepunk.application.lesson.practice.interfaces.IToDoPresenter;
import homepunk.application.lesson.practice.interfaces.IToDoView;
import homepunk.application.lesson.practice.model.ToDoItem;
import homepunk.application.lesson.practice.presenter.ToDoPresenter;

public class ToDoFragment extends Fragment implements IToDoView {
    @Bind(R.id.tv_todo) TextView textView;
    private IToDoPresenter toDoPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_todo, container, false);
        ButterKnife.bind(this, root);
        toDoPresenter = new ToDoPresenter();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        toDoPresenter.setView(this);
        toDoPresenter.getToDoList();
    }

    @Override
    public void onResult(List<ToDoItem> toDoList) {
        ToDoItem toDo = toDoList.get(0);
        textView.setText(toDo.toString());
    }

    @Override
    public void onError(String exception) {
        Toast.makeText(getContext(), exception, Toast.LENGTH_SHORT).show();
    }
}

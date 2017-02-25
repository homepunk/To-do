package homepunk.application.lesson.practice.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import homepunk.application.lesson.practice.R;

public class ToDoActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        initUi();
    }

    private void initUi() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

    }
}

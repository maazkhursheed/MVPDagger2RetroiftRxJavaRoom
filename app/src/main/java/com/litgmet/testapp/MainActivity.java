package com.litgmet.testapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.litgmet.testapp.adapters.RecyclerViewAdapter;
import com.litgmet.testapp.di.component.ApplicationComponent;
import com.litgmet.testapp.di.component.DaggerMainActivityComponent;
import com.litgmet.testapp.di.component.MainActivityComponent;
import com.litgmet.testapp.di.module.MainActivityContextModule;
import com.litgmet.testapp.di.module.MainActivityMvpModule;
import com.litgmet.testapp.di.qualifier.ActivityContext;
import com.litgmet.testapp.di.qualifier.ApplicationContext;
import com.litgmet.testapp.models.PostsData;
import com.litgmet.testapp.mvp.MainActivityContract;
import com.litgmet.testapp.mvp.PresenterImpl;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View, RecyclerViewAdapter.ClickListener {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;


    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Inject
    PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .mainActivityMvpModule(new MainActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
        recyclerView.setAdapter(recyclerViewAdapter);
        progressBar = findViewById(R.id.progressBar);

        presenter.loadData();


    }

    @Override
    public void launchIntent(String body) {
        startActivity(new Intent(activityContext, DetailActivity.class).putExtra("body", body));
    }

    @Override
    public void showData(List<PostsData> data) {
        recyclerViewAdapter.setData(data);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}

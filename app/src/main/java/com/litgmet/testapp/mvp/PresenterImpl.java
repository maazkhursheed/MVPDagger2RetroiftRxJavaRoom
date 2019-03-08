package com.litgmet.testapp.mvp;

import com.litgmet.testapp.MyApplication;
import com.litgmet.testapp.db.SampleDatabase;
import com.litgmet.testapp.di.component.ApplicationComponent;
import com.litgmet.testapp.models.PostsData;
import com.litgmet.testapp.network.APIInterface;
import com.litgmet.testapp.utils.Methodical;


import java.util.List;
import javax.inject.Inject;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PresenterImpl implements MainActivityContract.Presenter {

    APIInterface apiInterface;
    MainActivityContract.View mView;

    @Inject
    public PresenterImpl(APIInterface apiInterface, MainActivityContract.View mView) {
        this.apiInterface = apiInterface;
        this.mView = mView;
    }

    @Override
    public void loadData() {

        mView.showProgress();

        apiInterface.getAllPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PostsData>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                        mView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError("Error occurred");
                        mView.hideProgress();
                    }

                    @Override
                    public void onNext(List<PostsData> data) {
                        mView.showData(Methodical.setData(data));
                    }
                });
    }
}

package com.litgmet.testapp.mvp;


import com.litgmet.testapp.models.PostsData;

import java.util.List;

public interface MainActivityContract {
    interface View {
        void showData(List<PostsData> data);

        void showError(String message);

        void showComplete();

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void loadData();
    }
}

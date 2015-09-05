package in.co.mdg.mvpdemo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 21-Aug-15
 */
public class PresenterImpl implements Presenter, OnRequestFinishedListener {

    MainView mainView;
    Interactor interactor;

    public PresenterImpl(MainView mainView) {
        this.mainView = mainView;
        this.interactor = new InteractorImpl();
    }

    @Override
    public void fetchData() {
        mainView.showProgressbar();
        interactor.fetchData(this);
    }

    @Override
    public void onSuccess(ArrayList<String> movieslist){
        mainView.hideProgressbar();
        mainView.setSuccessLayout(movieslist);
    }

    @Override
    public void onError() {
        mainView.hideProgressbar();
        mainView.setErrorLayout();
    }
}

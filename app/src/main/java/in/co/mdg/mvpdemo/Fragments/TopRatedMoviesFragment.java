package in.co.mdg.mvpdemo.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import in.co.mdg.mvpdemo.Activities.MainActivity;
import in.co.mdg.mvpdemo.Presentors.Presenter;
import in.co.mdg.mvpdemo.Presentors.PresenterImpl;
import in.co.mdg.mvpdemo.R;
import in.co.mdg.mvpdemo.Views.MainView;

/**
 * Created by aksha on 9/6/2015.
 */
public class TopRatedMoviesFragment extends Fragment {
    Presenter presenter;
    ProgressBar progressBar;
    Button button;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View x =  inflater.inflate(R.layout.top_rated_movies,null);




        progressBar = (ProgressBar) getActivity().findViewById(R.id.progress_bar);
        button = (Button) getActivity().findViewById(R.id.btn_request);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.fetchData();
            }
        });

        return x;
    }
}

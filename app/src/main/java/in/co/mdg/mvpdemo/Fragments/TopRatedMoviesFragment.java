package in.co.mdg.mvpdemo.Fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import in.co.mdg.mvpdemo.Activities.ListMovies;
import in.co.mdg.mvpdemo.Activities.MainActivity;
import in.co.mdg.mvpdemo.Presentors.Presenter;
import in.co.mdg.mvpdemo.Presentors.PresenterImpl;
import in.co.mdg.mvpdemo.R;
import in.co.mdg.mvpdemo.Views.MainView;

/**
 * Created by aksha on 9/6/2015.
 */
public class TopRatedMoviesFragment extends Fragment implements MainView {
    Presenter presenter;
    ProgressBar progressBar;
    Button button;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View x =  inflater.inflate(R.layout.top_rated_movies,null);


        presenter = new PresenterImpl(this);
        try {
            //progressBar = (ProgressBar) getView().findViewById(R.id.progress_bar);
            button = (Button) getView().findViewById(R.id.btn_request);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.fetchData();
                }
            });
        }
        catch(Exception e)
        {
            Log.e("Error",e.toString());
        }
        return x;
    }

    @Override
    public void showProgressbar() {
        //progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        //progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setSuccessLayout(ArrayList<String> movieslist) {

        Intent i = new Intent(getActivity(), ListMovies.class);
        i.putStringArrayListExtra("Movies", movieslist);
        startActivity(i);
//        Toast.makeText(MainActivity.this, read, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setErrorLayout() {
        Log.e("Error", "Error");
    }
}



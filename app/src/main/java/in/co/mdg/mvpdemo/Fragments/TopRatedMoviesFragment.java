package in.co.mdg.mvpdemo.Fragments;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;

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
    Context c;
    ButtonSelectedListener listener;

    public interface ButtonSelectedListener{
        public void onSelected(ArrayList<String> movies);
    }


    @Override
    public void onAttach(Context context) {
        listener=(ButtonSelectedListener)context;
        super.onAttach(context);
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View x =  inflater.inflate(R.layout.top_rated_movies,null);
        c=x.getContext();

        presenter = new PresenterImpl(this);
        try {
            progressBar = (ProgressBar) x.findViewById(R.id.progress_bar);
            button = (Button) x.findViewById(R.id.btn_request);
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

//        Intent i = new Intent(c, ListMovies.class);
//        i.putStringArrayListExtra("Movies", movieslist);
//        startActivity(i);
        try{
        listener.onSelected(movieslist);}
        catch(Exception e)
        {
            Log.e("Error",e.toString());
        }


//        Toast.makeText(MainActivity.this, read, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setErrorLayout() {
        Log.e("Error", "Error");
    }
}



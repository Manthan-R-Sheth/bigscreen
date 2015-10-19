package in.co.mdg.mvpdemo.Fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import in.co.mdg.mvpdemo.R;

/**
 * Created by root on 19/10/15.
 */
public class ListMovies extends Fragment {

    ListView movielist;
    String[] movies;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_list_movies, null);
        movielist=(ListView)view.findViewById(R.id.movieslist);
        movies=getArguments().getStringArrayList("movies").toArray(new String[20]);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,
                movies);
        movielist.setAdapter(adapter);

        return view;
    }
}

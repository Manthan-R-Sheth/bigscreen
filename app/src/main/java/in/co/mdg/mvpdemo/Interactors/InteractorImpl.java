package in.co.mdg.mvpdemo.Interactors;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import in.co.mdg.mvpdemo.Utils.OnRequestFinishedListener;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 21-Aug-15
 */
public class InteractorImpl implements Interactor {
    public String read, movie;
    public ArrayList<String> movieslist;
    public JSONObject jsonObject;
    public int i;
    OnRequestFinishedListener listener;
    RequestCall requestCall;

    @Override
    public void fetchData(final OnRequestFinishedListener listener) {

        movieslist =new ArrayList<>();
        this.listener=listener;
//        final boolean temp = Math.random()<0.5; //random boolean

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//
//            }
//
//        });
//        thread.start();
        requestCall=new RequestCall();
        requestCall.execute();
    }


    public String readStream(InputStream i) {
        StringBuilder sb = new StringBuilder();
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(i));
            String nextline = "";
            while ((nextline = br.readLine()) != null) {
                sb.append(nextline);
            }
        } catch (Exception e) {
            Log.e("Error", e.toString());
        }
        return sb.toString();
    }



public class RequestCall extends AsyncTask<String,Void,ArrayList<String>>{
    @Override
    protected ArrayList<String> doInBackground(String... params) {
        try {


            URL url = new URL("https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=99cac354b4b0deb8452dc4c4e1d99488");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            read = readStream(con.getInputStream());
            Log.e("Got it baby", read);

            jsonObject = new JSONObject(read);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for ( i = 0; i < 20; i++) {

                JSONObject movie_details = jsonArray.getJSONObject(i);
                movie = movie_details.getString("original_title");
//                        Toast.makeText(MainActivity.c,movie,Toast.LENGTH_LONG).show();


                movieslist.add(movie);
            }
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                Log.e("Error1 detected", e.toString());

            } else Log.e("deo", e.toString());
        }
        return movieslist;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onPostExecute(ArrayList<String> strings) {

        if (!movieslist.isEmpty()) {

            listener.onSuccess(strings);
        } else {
            listener.onError();
        }
    }
}}
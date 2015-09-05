package in.co.mdg.mvpdemo;

import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 21-Aug-15
 */
public class InteractorImpl implements Interactor {
    String read,movie;
    ArrayList<String> movieslist;

    @Override
    public void fetchData(final OnRequestFinishedListener listener) {

//        final boolean temp = Math.random()<0.5; //random boolean
        movieslist=new ArrayList<>();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=4;i<10;i++)
                {
                try {


                    URL url = new URL("https://api.themoviedb.org/3/movie/"+i+"?api_key=99cac354b4b0deb8452dc4c4e1d99488");
                    HttpURLConnection con=(HttpURLConnection)url.openConnection();
                    read=readStream(con.getInputStream());
                    Log.e("Got it baby",read);

                    JSONObject jsonObject=new JSONObject(read);
                    movie=jsonObject.getString("original_title");
                    movieslist.add(movie);

                }
                catch (Exception e)
                {
                    Log.e("Error1",e.toString());
                    continue;

                }}

            }
        });
        thread.start();

        if (!movieslist.isEmpty()) {

            listener.onSuccess(movieslist);
        } else {
            listener.onError();
        }
    }

    public String readStream(InputStream i)
    {
        StringBuilder sb=new StringBuilder();
        try{

            BufferedReader br=new BufferedReader(new InputStreamReader(i));
            String nextline="";
            while((nextline=br.readLine())!=null)
            {
                sb.append(nextline);
            }
        }
        catch (Exception e)
        {
            Log.e("Error",e.toString());
        }
        return sb.toString();
    }

}
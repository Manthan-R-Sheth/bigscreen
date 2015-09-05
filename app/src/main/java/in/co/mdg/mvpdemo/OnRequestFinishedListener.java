package in.co.mdg.mvpdemo;

import java.util.ArrayList;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 21-Aug-15
 */
public interface OnRequestFinishedListener {

    void onSuccess(ArrayList<String> movieslist);

    void onError();
}

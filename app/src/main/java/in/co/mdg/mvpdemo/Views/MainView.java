package in.co.mdg.mvpdemo.Views;

import java.util.ArrayList;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 21-Aug-15
 */
public interface MainView {

    void showProgressbar();
    
    void hideProgressbar();

    void setSuccessLayout(ArrayList<String> movieslist);

    void setErrorLayout();
}

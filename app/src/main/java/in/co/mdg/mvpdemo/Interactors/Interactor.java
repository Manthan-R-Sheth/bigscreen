package in.co.mdg.mvpdemo.Interactors;

import in.co.mdg.mvpdemo.Utils.OnRequestFinishedListener;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 21-Aug-15
 */
public interface Interactor {

    void fetchData(OnRequestFinishedListener listener);
}

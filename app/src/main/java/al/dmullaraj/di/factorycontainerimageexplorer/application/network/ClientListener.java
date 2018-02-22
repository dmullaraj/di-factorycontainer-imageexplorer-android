package al.dmullaraj.di.factorycontainerimageexplorer.application.network;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public interface ClientListener<T, E extends Exception> {

    void onSuccess(T r);
    void onFailure(E e);

}
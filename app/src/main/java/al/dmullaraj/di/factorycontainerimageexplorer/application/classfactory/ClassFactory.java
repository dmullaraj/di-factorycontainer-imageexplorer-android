package al.dmullaraj.di.factorycontainerimageexplorer.application.classfactory;

import al.dmullaraj.di.factorycontainerimageexplorer.application.network.ClientRequestQueue;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public interface ClassFactory {

    ClientRequestQueue getRequestQueue();

}
package al.dmullaraj.di.factorycontainerimageexplorer.application.network.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

import al.dmullaraj.di.factorycontainerimageexplorer.BuildConfig;
import al.dmullaraj.di.factorycontainerimageexplorer.application.network.ClientApi;
import al.dmullaraj.di.factorycontainerimageexplorer.application.network.ClientRequestQueue;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class VolleyRequestQueue implements ClientRequestQueue {

    private RequestQueue mRequestQueue;
    private ClientApi mClientApi;

    public VolleyRequestQueue(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        if(BuildConfig.DEBUG){
            VolleyLog.DEBUG = true;
        }
    }

    @Override
    public ClientApi getClientApi() {
        if(mClientApi == null){
            mClientApi = new VolleyApi(mRequestQueue);
        }
        return mClientApi;
    }
}
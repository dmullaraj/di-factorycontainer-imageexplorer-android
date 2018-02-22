package al.dmullaraj.di.factorycontainerimageexplorer.application.classfactory.impl;

import android.content.Context;

import al.dmullaraj.di.factorycontainerimageexplorer.application.classfactory.ClassFactory;
import al.dmullaraj.di.factorycontainerimageexplorer.application.network.ClientRequestQueue;
import al.dmullaraj.di.factorycontainerimageexplorer.application.network.volley.VolleyRequestQueue;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class ClassFactoryImpl implements ClassFactory {

    private Context mContext;
    private ClientRequestQueue mVolleyRequestQueue;

    public ClassFactoryImpl(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ClientRequestQueue getRequestQueue() {
        if(mVolleyRequestQueue == null){
            mVolleyRequestQueue = new VolleyRequestQueue(mContext);
        }
        return mVolleyRequestQueue;
    }
}
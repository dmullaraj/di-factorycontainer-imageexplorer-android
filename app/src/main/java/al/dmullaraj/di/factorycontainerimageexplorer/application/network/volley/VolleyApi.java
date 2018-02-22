package al.dmullaraj.di.factorycontainerimageexplorer.application.network.volley;

import com.android.volley.RequestQueue;

import al.dmullaraj.di.factorycontainerimageexplorer.application.network.ClientApi;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class VolleyApi implements ClientApi {

    private final RequestQueue mQueue;

    public VolleyApi(RequestQueue queue) {
        mQueue = queue;
    }

    @Override
    public void retrieveMovieList() {

    }

    @Override
    public void emptyRequestQueue() {

    }
}
package al.dmullaraj.di.factorycontainerimageexplorer.application.network.volley;

import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;

import al.dmullaraj.di.factorycontainerimageexplorer.BuildConfig;
import al.dmullaraj.di.factorycontainerimageexplorer.application.network.ClientApi;
import al.dmullaraj.di.factorycontainerimageexplorer.application.network.ClientListener;
import al.dmullaraj.di.factorycontainerimageexplorer.application.network.volley.request.GsonRequest;
import al.dmullaraj.di.factorycontainerimageexplorer.domain.data.model.PopularTvShowResponse;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class VolleyApi implements ClientApi {

    private final RequestQueue mQueue;
    private final String BASE_AUTHORITY = "api.themoviedb.org";

    VolleyApi(RequestQueue queue) {
        mQueue = queue;
    }

    @Override
    public void retrieveMovieList(int index, final ClientListener listener) {
        final String popular_tv_show_path = "3/tv/popular";

        Response.Listener photosResponseListener = (Response.Listener<PopularTvShowResponse>) listener::onSuccess;

        Response.ErrorListener errorListener = listener::onFailure;

        Map<String, String> jsonParams = new HashMap<>();
        jsonParams.put("language", "en");
        jsonParams.put("page", String.valueOf(index));

        GsonRequest<PopularTvShowResponse> latestPhotoRequest = new GsonRequest<>(
                createGetWithParams(popular_tv_show_path, jsonParams), PopularTvShowResponse.class, null, photosResponseListener, errorListener
        );

        mQueue.add(latestPhotoRequest);
    }

    @Override
    public void emptyRequestQueue() {
        mQueue.cancelAll(request -> true);
    }

    private String createGetWithParams(String path, Map<String, String> params){
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority(BASE_AUTHORITY)
                .appendEncodedPath(path)
                .appendQueryParameter("api_key", BuildConfig.API_KEY);

        for(String key : params.keySet()){
            String value = params.get(key);
            if(value != null){
                builder.appendQueryParameter(key, value);
            }
        }

        return builder.build().toString();
    }
}
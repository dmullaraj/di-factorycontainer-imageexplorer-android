package al.dmullaraj.di.factorycontainerimageexplorer.ui.activity.moviegrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.VolleyError;

import java.util.ArrayList;

import al.dmullaraj.di.factorycontainerimageexplorer.R;
import al.dmullaraj.di.factorycontainerimageexplorer.application.classfactory.ClassWiring;
import al.dmullaraj.di.factorycontainerimageexplorer.application.network.ClientListener;
import al.dmullaraj.di.factorycontainerimageexplorer.domain.data.model.PopularTvShowResponse;
import al.dmullaraj.di.factorycontainerimageexplorer.domain.data.model.TvShow;
import al.dmullaraj.di.factorycontainerimageexplorer.domain.listener.OnGridMovieViewClickListener;
import al.dmullaraj.di.factorycontainerimageexplorer.ui.adapter.MovieGridAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class MovieGridActivity extends AppCompatActivity implements OnGridMovieViewClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.movie_grid_recycler_view)
    RecyclerView movieGridRecyclerView;

    private final static int STARTING_PAGE = 1;
    private MovieGridAdapter mMovieGridAdapter;
    private ArrayList<TvShow> mTvShowList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_grid);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mTvShowList = new ArrayList<>();
        mMovieGridAdapter = new MovieGridAdapter(this, mTvShowList, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        movieGridRecyclerView.setLayoutManager(gridLayoutManager);
        movieGridRecyclerView.setItemAnimator(new DefaultItemAnimator());
        movieGridRecyclerView.setAdapter(mMovieGridAdapter);

        getMovies(STARTING_PAGE);
    }

    private void getMovies(int index) {
        ClassWiring.getClassFactory().getRequestQueue().getClientApi()
                .retrieveMovieList(
                        index,
                        new ClientListener<PopularTvShowResponse, VolleyError>() {

                            @Override
                            public void onSuccess(PopularTvShowResponse r) {
                                mTvShowList.addAll(r.getTvShowList());
                                mMovieGridAdapter.notifyDataSetChanged();                            }

                            @Override
                            public void onFailure(VolleyError e) {
                                Log.d("ErrorLog", e.getMessage());
                            }
                        }
                );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ClassWiring.getClassFactory().getRequestQueue().getClientApi().emptyRequestQueue();
    }

    @Override
    public void onMovieClicked(int position) {

    }
}
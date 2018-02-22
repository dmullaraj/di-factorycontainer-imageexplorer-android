package al.dmullaraj.di.factorycontainerimageexplorer.ui.activity.moviegrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import al.dmullaraj.di.factorycontainerimageexplorer.R;
import al.dmullaraj.di.factorycontainerimageexplorer.domain.data.model.TvShow;
import al.dmullaraj.di.factorycontainerimageexplorer.ui.adapter.MovieGridAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class MovieGridActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.movie_grid_recycler_view)
    RecyclerView movieGridRecyclerView;

    private MovieGridAdapter mMovieGridAdapter;
    private ArrayList<TvShow> mTvShowList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_grid);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        mTvShowList = new ArrayList<>();
        mMovieGridAdapter = new MovieGridAdapter(this, mTvShowList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        movieGridRecyclerView.setLayoutManager(layoutManager);
        movieGridRecyclerView.setItemAnimator(new DefaultItemAnimator());
        movieGridRecyclerView.setAdapter(mMovieGridAdapter);
    }
}
package al.dmullaraj.di.factorycontainerimageexplorer.ui.adapter.moviegridoverview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import al.dmullaraj.di.factorycontainerimageexplorer.R;
import al.dmullaraj.di.factorycontainerimageexplorer.domain.data.model.TvShow;
import al.dmullaraj.di.factorycontainerimageexplorer.domain.listener.OnGridMovieViewClickListener;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class MovieGridAdapter extends RecyclerView.Adapter<MovieGridAdapter.MovieViewHolder> {

    private Context mContext;
    private ArrayList<TvShow> mTvShowList;
    private OnGridMovieViewClickListener mOnGridMovieViewClickListener;

    public MovieGridAdapter(Context context, ArrayList<TvShow> tvShows, OnGridMovieViewClickListener onGridMovieViewClickListener) {
        mContext = context;
        mTvShowList = tvShows;
        mOnGridMovieViewClickListener = onGridMovieViewClickListener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_gridview_item, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        TvShow tvShow = mTvShowList.get(position);

        Glide.with(mContext).load(tvShow.getLowResImageUrl())
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mTvShowList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;

        MovieViewHolder(View view){
            super(view);

            imageView = view.findViewById(R.id.movie_griview_item);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnGridMovieViewClickListener.onMovieClicked(getLayoutPosition());
        }
    }

}
package al.dmullaraj.di.factorycontainerimageexplorer.ui.adapter.moviedetail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import al.dmullaraj.di.factorycontainerimageexplorer.R;
import al.dmullaraj.di.factorycontainerimageexplorer.domain.data.model.TvShow;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class FullScreenMovieSliderPagerAdapter extends PagerAdapter {

    private ArrayList<TvShow> mTvShowList;
    private Context mContext;
    private ImageView mImage;

    public FullScreenMovieSliderPagerAdapter(Context context,  ArrayList<TvShow> tvShowList) {
        mContext = context;
        mTvShowList = tvShowList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.pageradapter_movie_fullscreen_slider, container, false);

        mImage = (ImageView) view.findViewById(R.id.full_screen_movie);

        TvShow tvShow = mTvShowList.get(position);

        Glide.with(mContext).load(tvShow.getHighResImageUrl())
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mImage);

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return mTvShowList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
package al.dmullaraj.di.factorycontainerimageexplorer.ui.fullscreenmovie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import al.dmullaraj.di.factorycontainerimageexplorer.R;
import al.dmullaraj.di.factorycontainerimageexplorer.domain.data.model.TvShow;
import al.dmullaraj.di.factorycontainerimageexplorer.ui.fullscreenmovie.adapter.FullScreenMovieSliderPagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class FullScreenMovieSliderDialogFragment extends AppCompatDialogFragment {

    public static final String TAG = FullScreenMovieSliderDialogFragment.class.getSimpleName();
    public static final String ARG_TV_SHOW_LIST = "tv_show_list";
    public static final String ARG_TV_SHOW_LIST_CURRENT_POSITION = "tv_show_list_current_position";

    private FullScreenMovieSliderPagerAdapter mFullScreenMovieSliderPagerAdapter;
    private ArrayList<TvShow> mTvShowList;
    private int mCurrentPosition;

    @BindView(R.id.fullscreen_slider_viewpager)
    ViewPager viewPager;

    public static FullScreenMovieSliderDialogFragment newInstance(ArrayList<TvShow> imagesList, int position){
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(ARG_TV_SHOW_LIST, imagesList);
        bundle.putInt(ARG_TV_SHOW_LIST_CURRENT_POSITION, position);
        FullScreenMovieSliderDialogFragment fragment = new FullScreenMovieSliderDialogFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_fullscreen_slider, container, false);
        ButterKnife.bind(this, view);

        mTvShowList = getArguments().getParcelableArrayList(ARG_TV_SHOW_LIST);
        mCurrentPosition = getArguments().getInt(ARG_TV_SHOW_LIST_CURRENT_POSITION);

        mFullScreenMovieSliderPagerAdapter = new FullScreenMovieSliderPagerAdapter(getActivity(), mTvShowList);
        viewPager.setAdapter(mFullScreenMovieSliderPagerAdapter);
        viewPager.setCurrentItem(mCurrentPosition, false);

        return view;
    }
}
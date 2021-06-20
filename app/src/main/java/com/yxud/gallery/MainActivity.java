package com.yxud.gallery;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.yxud.framework.base.BaseUIActivity;
import com.yxud.gallery.fragment.AlbumFragment;
import com.yxud.gallery.fragment.MeFragment;
import com.yxud.gallery.fragment.ShareFragment;
import com.yxud.gallery.fragment.TimelineFragment;

public class MainActivity extends BaseUIActivity implements View.OnClickListener {

    // 时间轴
    private ImageView iv_timeline;
    private TextView tv_timeline;
    private LinearLayout ll_timeline;
    private TimelineFragment mTimelineFragment = null;
    private FragmentTransaction mTimelineTransaction = null;

    // 相册
    private ImageView iv_album;
    private TextView tv_album;
    private LinearLayout ll_album;
    private AlbumFragment mAlbumFragment = null;
    private FragmentTransaction mAlbumTransaction = null;

    // 分享
    private ImageView iv_share;
    private TextView tv_share;
    private LinearLayout ll_share;
    private ShareFragment mShareFragment = null;
    private FragmentTransaction mShareTransaction = null;

    // 我的
    private ImageView iv_me;
    private TextView tv_me;
    private LinearLayout ll_me;
    private MeFragment mMeFragment = null;
    private FragmentTransaction mMeTransaction = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        ll_timeline = findViewById(R.id.ll_timeline);
        iv_timeline = findViewById(R.id.iv_timeline);
        tv_timeline = findViewById(R.id.tv_timeline);

        ll_album = findViewById(R.id.ll_album);
        iv_album = findViewById(R.id.iv_album);
        tv_album = findViewById(R.id.tv_album);

        ll_share = findViewById(R.id.ll_share);
        iv_share = findViewById(R.id.iv_share);
        tv_share = findViewById(R.id.tv_share);

        iv_me = findViewById(R.id.iv_me);
        tv_me = findViewById(R.id.tv_me);
        ll_me = findViewById(R.id.ll_me);

        ll_timeline.setOnClickListener(this);
        ll_album.setOnClickListener(this);
        ll_share.setOnClickListener(this);
        ll_me.setOnClickListener(this);

        initFragment();

        checkMainTab(0);
    }

    /**
     * 切换主页选项卡
     *
     * @param index 0：照片、1：相册、2：分享、3：我的
     */
    private void checkMainTab(int index) {
        switch (index) {
            case 0:
                showFragment(mTimelineFragment);
                iv_timeline.setImageResource(R.drawable.img_timeline_selected);
                iv_album.setImageResource(R.drawable.img_album);
                iv_share.setImageResource(R.drawable.img_share);
                iv_me.setImageResource(R.drawable.img_me);

                tv_timeline.setTextColor(getResources().getColor(R.color.colorAccent));
                tv_album.setTextColor(Color.BLACK);
                tv_share.setTextColor(Color.BLACK);
                tv_me.setTextColor(Color.BLACK);
                break;
            case 1:
                showFragment(mAlbumFragment);
                iv_timeline.setImageResource(R.drawable.img_timeline);
                iv_album.setImageResource(R.drawable.img_album_selected);
                iv_share.setImageResource(R.drawable.img_share);
                iv_me.setImageResource(R.drawable.img_me);

                tv_timeline.setTextColor(Color.BLACK);
                tv_album.setTextColor(getResources().getColor(R.color.colorAccent));
                tv_share.setTextColor(Color.BLACK);
                tv_me.setTextColor(Color.BLACK);
                break;
            case 2:
                showFragment(mShareFragment);
                iv_timeline.setImageResource(R.drawable.img_timeline);
                iv_album.setImageResource(R.drawable.img_album);
                iv_share.setImageResource(R.drawable.img_share_selected);
                iv_me.setImageResource(R.drawable.img_me);

                tv_timeline.setTextColor(Color.BLACK);
                tv_album.setTextColor(Color.BLACK);
                tv_share.setTextColor(getResources().getColor(R.color.colorAccent));
                tv_me.setTextColor(Color.BLACK);
                break;
            case 3:
                showFragment(mMeFragment);
                iv_timeline.setImageResource(R.drawable.img_timeline);
                iv_album.setImageResource(R.drawable.img_album);
                iv_share.setImageResource(R.drawable.img_share);
                iv_me.setImageResource(R.drawable.img_me_selected);

                tv_timeline.setTextColor(Color.BLACK);
                tv_album.setTextColor(Color.BLACK);
                tv_share.setTextColor(Color.BLACK);
                tv_me.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }
    }

    /**
     * 防止重叠
     * 当应用的内存紧张的时候，系统会回收掉Fragment对象
     * 再一次进入的时候会重新创建Fragment
     * 非原来对象，我们无法控制，导致重叠
     *
     * @param fragment
     */
    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        if (mTimelineFragment != null && fragment instanceof TimelineFragment) {
            mTimelineFragment = (TimelineFragment) fragment;
        }
        if (mAlbumFragment != null && fragment instanceof AlbumFragment) {
            mAlbumFragment = (AlbumFragment) fragment;
        }
        if (mShareFragment != null && fragment instanceof ShareFragment) {
            mShareFragment = (ShareFragment) fragment;
        }
        if (mMeFragment != null && fragment instanceof MeFragment) {
            mMeFragment = (MeFragment) fragment;
        }
    }

    /**
     * 显示Fragment
     *
     * @param fragment
     */
    private void showFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            hideAllFragment(transaction);
            transaction.show(fragment);
            transaction.commitNowAllowingStateLoss();
        }
    }

    /**
     * 隐藏所有的Fragment
     *
     * @param transaction
     */
    private void hideAllFragment(FragmentTransaction transaction) {
        if (mTimelineFragment != null) {
            transaction.hide(mTimelineFragment);
        }
        if (mAlbumFragment != null) {
            transaction.hide(mAlbumFragment);
        }
        if (mShareFragment != null) {
            transaction.hide(mShareFragment);
        }
        if (mMeFragment != null) {
            transaction.hide(mMeFragment);
        }
    }

    private void initFragment() {

        //时间轴
        if (mTimelineFragment == null) {
            mTimelineFragment = new TimelineFragment();
            mTimelineTransaction = getSupportFragmentManager().beginTransaction();
            mTimelineTransaction.add(R.id.mMainLayout, mTimelineFragment);
            mTimelineTransaction.commit();
        }

        // 相册
        if (mAlbumFragment == null) {
            mAlbumFragment = new AlbumFragment();
            mAlbumTransaction = getSupportFragmentManager().beginTransaction();
            mAlbumTransaction.add(R.id.mMainLayout, mAlbumFragment);
            mAlbumTransaction.commit();
        }

        // 分享
        if (mShareFragment == null) {
            mShareFragment = new ShareFragment();
            mShareTransaction = getSupportFragmentManager().beginTransaction();
            mShareTransaction.add(R.id.mMainLayout, mShareFragment);
            mShareTransaction.commit();
        }

        //我的
        if (mMeFragment == null) {
            mMeFragment = new MeFragment();
            mMeTransaction = getSupportFragmentManager().beginTransaction();
            mMeTransaction.add(R.id.mMainLayout, mMeFragment);
            mMeTransaction.commit();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_timeline:
                checkMainTab(0);
                break;
            case R.id.ll_album:
                checkMainTab(1);
                break;
            case R.id.ll_share:
                checkMainTab(2);
                break;
            case R.id.ll_me:
                checkMainTab(3);
                break;
        }
    }
}
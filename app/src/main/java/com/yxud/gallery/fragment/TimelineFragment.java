package com.yxud.gallery.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yxud.framework.base.BaseFragment;
import com.yxud.gallery.R;

/**
 * 页面1
 *
 * @author yangxudong
 * @date 2021-06-05
 */
public class TimelineFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timeline, null);
        return view;
    }
}

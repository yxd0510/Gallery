package com.yxud.framework.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.yxud.framework.utils.SystemUI;

/**
 * BaseUIActivity
 *
 * @author yangxudong
 * @date 2021-05-30
 */
public class BaseUIActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SystemUI.fixSystemUI(this);
    }
}

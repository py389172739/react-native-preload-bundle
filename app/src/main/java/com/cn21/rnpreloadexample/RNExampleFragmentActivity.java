package com.cn21.rnpreloadexample;


import android.app.Fragment;
import android.os.Bundle;

import com.cn21.preloadlibrary.CCCReactFragmentActivity;

/**
 * Created by lizhj on 2017/7/13.
 */

public class RNExampleFragmentActivity extends CCCReactFragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        Fragment exampleFragment = new ExampleFragment();
        getFragmentManager().beginTransaction().add(R.id.container, exampleFragment).commit();
    }
}

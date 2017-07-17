package com.cn21.rnpreloadexample;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cn21.preloadlibrary.RNCacheViewManager;
import com.facebook.react.ReactRootView;

import java.util.Map;

import static com.cn21.preloadlibrary.RNCacheViewManager.CACHE;
import static com.cn21.preloadlibrary.RNCacheViewManager.REQUEST_OVERLAY_PERMISSION_CODE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RNCacheViewManager.init(this, null, RNExampleActivity.MODULE_NAME, ExampleFragment.MODULE_NAME);
    }

    public void gotoRNActivity(View view) {
        startActivity(new Intent(this, RNExampleActivity.class));
    }

    public void gotoRNFragment(View view) {
        startActivity(new Intent(this, RNExampleFragmentActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_OVERLAY_PERMISSION_CODE && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && Settings.canDrawOverlays(this))
            for (Map.Entry<String, ReactRootView> entry : CACHE.entrySet())
                RNCacheViewManager.getRootView(entry.getKey()).startReactApplication(
                        RNCacheViewManager.getReactNativeHost(this).getReactInstanceManager(),
                        entry.getKey(),
                        null);
    }
}

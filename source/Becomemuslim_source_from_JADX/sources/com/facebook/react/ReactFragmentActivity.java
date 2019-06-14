package com.facebook.react;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C4890j;
import android.view.KeyEvent;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;

@Deprecated
public abstract class ReactFragmentActivity extends C4890j implements DefaultHardwareBackBtnHandler, PermissionAwareActivity {
    private final ReactActivityDelegate mDelegate = createReactActivityDelegate();

    protected String getMainComponentName() {
        return null;
    }

    protected ReactFragmentActivity() {
    }

    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate((C4890j) this, getMainComponentName());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mDelegate.onCreate(bundle);
    }

    protected void onPause() {
        super.onPause();
        this.mDelegate.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.mDelegate.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mDelegate.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mDelegate.onActivityResult(i, i2, intent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!this.mDelegate.onKeyUp(i, keyEvent)) {
            if (super.onKeyUp(i, keyEvent) == 0) {
                return false;
            }
        }
        return true;
    }

    public void onBackPressed() {
        if (!this.mDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    public void onNewIntent(Intent intent) {
        if (!this.mDelegate.onNewIntent(intent)) {
            super.onNewIntent(intent);
        }
    }

    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.mDelegate.requestPermissions(strArr, i, permissionListener);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mDelegate.onRequestPermissionsResult(i, strArr, iArr);
    }

    protected final ReactNativeHost getReactNativeHost() {
        return this.mDelegate.getReactNativeHost();
    }

    protected final ReactInstanceManager getReactInstanceManager() {
        return this.mDelegate.getReactInstanceManager();
    }

    protected final void loadApp(String str) {
        this.mDelegate.loadApp(str);
    }
}

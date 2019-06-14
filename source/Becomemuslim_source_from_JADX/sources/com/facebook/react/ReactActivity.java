package com.facebook.react;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;

public abstract class ReactActivity extends Activity implements DefaultHardwareBackBtnHandler, PermissionAwareActivity {
    private final ReactActivityDelegate mDelegate = createReactActivityDelegate();

    protected String getMainComponentName() {
        return null;
    }

    protected ReactActivity() {
    }

    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate((Activity) this, getMainComponentName());
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

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.mDelegate.onKeyDown(i, keyEvent)) {
            if (super.onKeyDown(i, keyEvent) == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!this.mDelegate.onKeyUp(i, keyEvent)) {
            if (super.onKeyUp(i, keyEvent) == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        if (!this.mDelegate.onKeyLongPress(i, keyEvent)) {
            if (super.onKeyLongPress(i, keyEvent) == 0) {
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

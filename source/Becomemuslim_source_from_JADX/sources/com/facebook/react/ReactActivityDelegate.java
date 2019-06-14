package com.facebook.react;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C4890j;
import android.view.KeyEvent;
import com.facebook.react.bridge.Callback;
import com.facebook.react.devsupport.DoubleTapReloadRecognizer;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionListener;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public class ReactActivityDelegate {
    private final Activity mActivity;
    private DoubleTapReloadRecognizer mDoubleTapReloadRecognizer;
    private final C4890j mFragmentActivity;
    private final String mMainComponentName;
    private PermissionListener mPermissionListener;
    private Callback mPermissionsCallback;
    private ReactRootView mReactRootView;

    protected Bundle getLaunchOptions() {
        return null;
    }

    public ReactActivityDelegate(Activity activity, String str) {
        this.mActivity = activity;
        this.mMainComponentName = str;
        this.mFragmentActivity = null;
    }

    public ReactActivityDelegate(C4890j c4890j, String str) {
        this.mFragmentActivity = c4890j;
        this.mMainComponentName = str;
        this.mActivity = null;
    }

    protected ReactRootView createRootView() {
        return new ReactRootView(getContext());
    }

    protected ReactNativeHost getReactNativeHost() {
        return ((ReactApplication) getPlainActivity().getApplication()).getReactNativeHost();
    }

    public ReactInstanceManager getReactInstanceManager() {
        return getReactNativeHost().getReactInstanceManager();
    }

    protected void onCreate(Bundle bundle) {
        if (this.mMainComponentName != null) {
            loadApp(this.mMainComponentName);
        }
        this.mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
    }

    protected void loadApp(String str) {
        if (this.mReactRootView == null) {
            this.mReactRootView = createRootView();
            this.mReactRootView.startReactApplication(getReactNativeHost().getReactInstanceManager(), str, getLaunchOptions());
            getPlainActivity().setContentView(this.mReactRootView);
            return;
        }
        throw new IllegalStateException("Cannot loadApp while app is already running.");
    }

    protected void onPause() {
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onHostPause(getPlainActivity());
        }
    }

    protected void onResume() {
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onHostResume(getPlainActivity(), (DefaultHardwareBackBtnHandler) getPlainActivity());
        }
        if (this.mPermissionsCallback != null) {
            this.mPermissionsCallback.invoke(new Object[0]);
            this.mPermissionsCallback = null;
        }
    }

    protected void onDestroy() {
        if (this.mReactRootView != null) {
            this.mReactRootView.unmountReactApplication();
            this.mReactRootView = null;
        }
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onHostDestroy(getPlainActivity());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onActivityResult(getPlainActivity(), i, i2, intent);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!getReactNativeHost().hasInstance() || !getReactNativeHost().getUseDeveloperSupport() || i != 90) {
            return false;
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!(getReactNativeHost().hasInstance() == null || getReactNativeHost().getUseDeveloperSupport() == null)) {
            if (i == 82) {
                getReactNativeHost().getReactInstanceManager().showDevOptionsDialog();
                return true;
            } else if (((DoubleTapReloadRecognizer) Assertions.assertNotNull(this.mDoubleTapReloadRecognizer)).didDoubleTapR(i, getPlainActivity().getCurrentFocus()) != 0) {
                getReactNativeHost().getReactInstanceManager().getDevSupportManager().handleReloadJS();
                return true;
            }
        }
        return false;
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        if (getReactNativeHost().hasInstance() == null || getReactNativeHost().getUseDeveloperSupport() == null || i != 90) {
            return false;
        }
        getReactNativeHost().getReactInstanceManager().showDevOptionsDialog();
        return true;
    }

    public boolean onBackPressed() {
        if (!getReactNativeHost().hasInstance()) {
            return false;
        }
        getReactNativeHost().getReactInstanceManager().onBackPressed();
        return true;
    }

    public boolean onNewIntent(Intent intent) {
        if (!getReactNativeHost().hasInstance()) {
            return null;
        }
        getReactNativeHost().getReactInstanceManager().onNewIntent(intent);
        return true;
    }

    @TargetApi(23)
    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;
        getPlainActivity().requestPermissions(strArr, i);
    }

    public void onRequestPermissionsResult(final int i, final String[] strArr, final int[] iArr) {
        this.mPermissionsCallback = new Callback() {
            public void invoke(Object... objArr) {
                if (ReactActivityDelegate.this.mPermissionListener != null && ReactActivityDelegate.this.mPermissionListener.onRequestPermissionsResult(i, strArr, iArr) != null) {
                    ReactActivityDelegate.this.mPermissionListener = null;
                }
            }
        };
    }

    private Context getContext() {
        if (this.mActivity != null) {
            return this.mActivity;
        }
        return (Context) Assertions.assertNotNull(this.mFragmentActivity);
    }

    private Activity getPlainActivity() {
        return (Activity) getContext();
    }
}

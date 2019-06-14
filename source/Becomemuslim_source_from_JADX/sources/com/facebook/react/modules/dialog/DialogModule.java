package com.facebook.react.modules.dialog;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.C0309n;
import android.support.v4.app.C4890j;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.internal.ShareConstants;
import java.util.Map;

@ReactModule(name = "DialogManagerAndroid")
public class DialogModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    public static String ACTION_BUTTON_CLICKED = "buttonClicked";
    public static String ACTION_DISMISSED = "dismissed";
    public static Map<String, Object> CONSTANTS = MapBuilder.of(ACTION_BUTTON_CLICKED, ACTION_BUTTON_CLICKED, ACTION_DISMISSED, ACTION_DISMISSED, KEY_BUTTON_POSITIVE, Integer.valueOf(-1), KEY_BUTTON_NEGATIVE, Integer.valueOf(-2), KEY_BUTTON_NEUTRAL, Integer.valueOf(-3));
    public static String FRAGMENT_TAG = "com.facebook.catalyst.react.dialog.DialogModule";
    public static String KEY_BUTTON_NEGATIVE = "buttonNegative";
    public static String KEY_BUTTON_NEUTRAL = "buttonNeutral";
    public static String KEY_BUTTON_POSITIVE = "buttonPositive";
    public static String KEY_CANCELABLE = "cancelable";
    public static String KEY_ITEMS = "items";
    public static String KEY_MESSAGE = "message";
    public static String KEY_TITLE = "title";
    public static final String NAME = "DialogManagerAndroid";
    public boolean mIsInForeground;

    class AlertFragmentListener implements OnClickListener, OnDismissListener {
        public final Callback mCallback;
        public boolean mCallbackConsumed = null;

        public AlertFragmentListener(Callback callback) {
            this.mCallback = callback;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.mCallbackConsumed == null && DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance() != null) {
                this.mCallback.invoke(DialogModule.ACTION_BUTTON_CLICKED, Integer.valueOf(i));
                this.mCallbackConsumed = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (this.mCallbackConsumed == null && DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance() != null) {
                this.mCallback.invoke(DialogModule.ACTION_DISMISSED);
                this.mCallbackConsumed = true;
            }
        }
    }

    private class FragmentManagerHelper {
        public final FragmentManager mFragmentManager;
        public Object mFragmentToShow;
        public final C0309n mSupportFragmentManager;

        private boolean isUsingSupportLibrary() {
            return this.mSupportFragmentManager != null;
        }

        public FragmentManagerHelper(C0309n c0309n) {
            this.mFragmentManager = null;
            this.mSupportFragmentManager = c0309n;
        }

        public FragmentManagerHelper(FragmentManager fragmentManager) {
            this.mFragmentManager = fragmentManager;
            this.mSupportFragmentManager = null;
        }

        public void showPendingAlert() {
            UiThreadUtil.assertOnUiThread();
            if (this.mFragmentToShow != null) {
                if (isUsingSupportLibrary()) {
                    ((SupportAlertFragment) this.mFragmentToShow).show(this.mSupportFragmentManager, DialogModule.FRAGMENT_TAG);
                } else {
                    ((AlertFragment) this.mFragmentToShow).show(this.mFragmentManager, DialogModule.FRAGMENT_TAG);
                }
                this.mFragmentToShow = null;
            }
        }

        private void dismissExisting() {
            if (isUsingSupportLibrary()) {
                SupportAlertFragment supportAlertFragment = (SupportAlertFragment) this.mSupportFragmentManager.mo200a(DialogModule.FRAGMENT_TAG);
                if (supportAlertFragment != null) {
                    supportAlertFragment.dismiss();
                    return;
                }
                return;
            }
            AlertFragment alertFragment = (AlertFragment) this.mFragmentManager.findFragmentByTag(DialogModule.FRAGMENT_TAG);
            if (alertFragment != null) {
                alertFragment.dismiss();
            }
        }

        public void showNewAlert(boolean z, Bundle bundle, Callback callback) {
            UiThreadUtil.assertOnUiThread();
            dismissExisting();
            AlertFragmentListener alertFragmentListener = callback != null ? new AlertFragmentListener(callback) : null;
            if (isUsingSupportLibrary() != null) {
                callback = new SupportAlertFragment(alertFragmentListener, bundle);
                if (z) {
                    if (bundle.containsKey(DialogModule.KEY_CANCELABLE)) {
                        callback.setCancelable(bundle.getBoolean(DialogModule.KEY_CANCELABLE));
                    }
                    callback.show((C0309n) this.mSupportFragmentManager, (String) DialogModule.FRAGMENT_TAG);
                    return;
                }
                this.mFragmentToShow = callback;
                return;
            }
            callback = new AlertFragment(alertFragmentListener, bundle);
            if (z) {
                if (bundle.containsKey(DialogModule.KEY_CANCELABLE)) {
                    callback.setCancelable(bundle.getBoolean(DialogModule.KEY_CANCELABLE));
                }
                callback.show(this.mFragmentManager, DialogModule.FRAGMENT_TAG);
                return;
            }
            this.mFragmentToShow = callback;
        }
    }

    public String getName() {
        return NAME;
    }

    public void onHostDestroy() {
    }

    public DialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        return CONSTANTS;
    }

    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    public void onHostPause() {
        this.mIsInForeground = false;
    }

    public void onHostResume() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = 1;
        r2.mIsInForeground = r0;	 Catch:{ Throwable -> 0x0014 }
        r0 = r2.getFragmentManagerHelper();	 Catch:{ Throwable -> 0x0014 }
        if (r0 == 0) goto L_0x000d;	 Catch:{ Throwable -> 0x0014 }
    L_0x0009:
        r0.showPendingAlert();	 Catch:{ Throwable -> 0x0014 }
        goto L_0x0014;	 Catch:{ Throwable -> 0x0014 }
    L_0x000d:
        r0 = com.facebook.react.modules.dialog.DialogModule.class;	 Catch:{ Throwable -> 0x0014 }
        r1 = "onHostResume called but no FragmentManager found";	 Catch:{ Throwable -> 0x0014 }
        com.facebook.common.logging.FLog.m5710w(r0, r1);	 Catch:{ Throwable -> 0x0014 }
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.dialog.DialogModule.onHostResume():void");
    }

    @ReactMethod
    public void showAlert(ReadableMap readableMap, Callback callback, final Callback callback2) {
        final FragmentManagerHelper fragmentManagerHelper = getFragmentManagerHelper();
        int i = 0;
        if (fragmentManagerHelper == null) {
            callback.invoke(new Object[]{"Tried to show an alert while not attached to an Activity"});
            return;
        }
        callback = new Bundle();
        if (readableMap.hasKey(KEY_TITLE)) {
            callback.putString("title", readableMap.getString(KEY_TITLE));
        }
        if (readableMap.hasKey(KEY_MESSAGE)) {
            callback.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, readableMap.getString(KEY_MESSAGE));
        }
        if (readableMap.hasKey(KEY_BUTTON_POSITIVE)) {
            callback.putString("button_positive", readableMap.getString(KEY_BUTTON_POSITIVE));
        }
        if (readableMap.hasKey(KEY_BUTTON_NEGATIVE)) {
            callback.putString("button_negative", readableMap.getString(KEY_BUTTON_NEGATIVE));
        }
        if (readableMap.hasKey(KEY_BUTTON_NEUTRAL)) {
            callback.putString("button_neutral", readableMap.getString(KEY_BUTTON_NEUTRAL));
        }
        if (readableMap.hasKey(KEY_ITEMS)) {
            ReadableArray array = readableMap.getArray(KEY_ITEMS);
            CharSequence[] charSequenceArr = new CharSequence[array.size()];
            while (i < array.size()) {
                charSequenceArr[i] = array.getString(i);
                i++;
            }
            callback.putCharSequenceArray("items", charSequenceArr);
        }
        if (readableMap.hasKey(KEY_CANCELABLE)) {
            callback.putBoolean(KEY_CANCELABLE, readableMap.getBoolean(KEY_CANCELABLE));
        }
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                fragmentManagerHelper.showNewAlert(DialogModule.this.mIsInForeground, callback, callback2);
            }
        });
    }

    private FragmentManagerHelper getFragmentManagerHelper() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return null;
        }
        if (currentActivity instanceof C4890j) {
            return new FragmentManagerHelper(((C4890j) currentActivity).getSupportFragmentManager());
        }
        return new FragmentManagerHelper(currentActivity.getFragmentManager());
    }
}

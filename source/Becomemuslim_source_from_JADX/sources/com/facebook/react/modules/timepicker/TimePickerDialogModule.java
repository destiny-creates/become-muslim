package com.facebook.react.modules.timepicker;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.C0309n;
import android.support.v4.app.C4457h;
import android.support.v4.app.C4890j;
import android.widget.TimePicker;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "TimePickerAndroid")
public class TimePickerDialogModule extends ReactContextBaseJavaModule {
    static final String ACTION_DISMISSED = "dismissedAction";
    static final String ACTION_TIME_SET = "timeSetAction";
    static final String ARG_HOUR = "hour";
    static final String ARG_IS24HOUR = "is24Hour";
    static final String ARG_MINUTE = "minute";
    static final String ARG_MODE = "mode";
    private static final String ERROR_NO_ACTIVITY = "E_NO_ACTIVITY";
    @VisibleForTesting
    public static final String FRAGMENT_TAG = "TimePickerAndroid";

    private class TimePickerDialogListener implements OnTimeSetListener, OnDismissListener {
        private final Promise mPromise;
        private boolean mPromiseResolved = null;

        public TimePickerDialogListener(Promise promise) {
            this.mPromise = promise;
        }

        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            if (this.mPromiseResolved == null && TimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance() != null) {
                timePicker = new WritableNativeMap();
                timePicker.putString(NativeProtocol.WEB_DIALOG_ACTION, TimePickerDialogModule.ACTION_TIME_SET);
                timePicker.putInt(TimePickerDialogModule.ARG_HOUR, i);
                timePicker.putInt(TimePickerDialogModule.ARG_MINUTE, i2);
                this.mPromise.resolve(timePicker);
                this.mPromiseResolved = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (this.mPromiseResolved == null && TimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance() != null) {
                dialogInterface = new WritableNativeMap();
                dialogInterface.putString(NativeProtocol.WEB_DIALOG_ACTION, TimePickerDialogModule.ACTION_DISMISSED);
                this.mPromise.resolve(dialogInterface);
                this.mPromiseResolved = true;
            }
        }
    }

    public String getName() {
        return FRAGMENT_TAG;
    }

    public TimePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(ERROR_NO_ACTIVITY, "Tried to open a TimePicker dialog while not attached to an Activity");
            return;
        }
        if (currentActivity instanceof C4890j) {
            C0309n supportFragmentManager = ((C4890j) currentActivity).getSupportFragmentManager();
            C4457h c4457h = (C4457h) supportFragmentManager.mo200a(FRAGMENT_TAG);
            if (c4457h != null) {
                c4457h.dismiss();
            }
            SupportTimePickerDialogFragment supportTimePickerDialogFragment = new SupportTimePickerDialogFragment();
            if (readableMap != null) {
                supportTimePickerDialogFragment.setArguments(createFragmentArguments(readableMap));
            }
            readableMap = new TimePickerDialogListener(promise);
            supportTimePickerDialogFragment.setOnDismissListener(readableMap);
            supportTimePickerDialogFragment.setOnTimeSetListener(readableMap);
            supportTimePickerDialogFragment.show(supportFragmentManager, (String) FRAGMENT_TAG);
        } else {
            FragmentManager fragmentManager = currentActivity.getFragmentManager();
            DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            }
            TimePickerDialogFragment timePickerDialogFragment = new TimePickerDialogFragment();
            if (readableMap != null) {
                timePickerDialogFragment.setArguments(createFragmentArguments(readableMap));
            }
            readableMap = new TimePickerDialogListener(promise);
            timePickerDialogFragment.setOnDismissListener(readableMap);
            timePickerDialogFragment.setOnTimeSetListener(readableMap);
            timePickerDialogFragment.show(fragmentManager, FRAGMENT_TAG);
        }
    }

    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey(ARG_HOUR) && !readableMap.isNull(ARG_HOUR)) {
            bundle.putInt(ARG_HOUR, readableMap.getInt(ARG_HOUR));
        }
        if (readableMap.hasKey(ARG_MINUTE) && !readableMap.isNull(ARG_MINUTE)) {
            bundle.putInt(ARG_MINUTE, readableMap.getInt(ARG_MINUTE));
        }
        if (readableMap.hasKey(ARG_IS24HOUR) && !readableMap.isNull(ARG_IS24HOUR)) {
            bundle.putBoolean(ARG_IS24HOUR, readableMap.getBoolean(ARG_IS24HOUR));
        }
        if (readableMap.hasKey(ARG_MODE) && !readableMap.isNull(ARG_MODE)) {
            bundle.putString(ARG_MODE, readableMap.getString(ARG_MODE));
        }
        return bundle;
    }
}

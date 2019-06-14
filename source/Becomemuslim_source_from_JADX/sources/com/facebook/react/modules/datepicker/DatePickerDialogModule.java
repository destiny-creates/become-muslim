package com.facebook.react.modules.datepicker;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.C0309n;
import android.support.v4.app.C4457h;
import android.support.v4.app.C4890j;
import android.widget.DatePicker;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "DatePickerAndroid")
public class DatePickerDialogModule extends ReactContextBaseJavaModule {
    static final String ACTION_DATE_SET = "dateSetAction";
    static final String ACTION_DISMISSED = "dismissedAction";
    static final String ARG_DATE = "date";
    static final String ARG_MAXDATE = "maxDate";
    static final String ARG_MINDATE = "minDate";
    static final String ARG_MODE = "mode";
    private static final String ERROR_NO_ACTIVITY = "E_NO_ACTIVITY";
    @VisibleForTesting
    public static final String FRAGMENT_TAG = "DatePickerAndroid";

    private class DatePickerDialogListener implements OnDateSetListener, OnDismissListener {
        private final Promise mPromise;
        private boolean mPromiseResolved = null;

        public DatePickerDialogListener(Promise promise) {
            this.mPromise = promise;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            if (this.mPromiseResolved == null && DatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance() != null) {
                datePicker = new WritableNativeMap();
                datePicker.putString(NativeProtocol.WEB_DIALOG_ACTION, DatePickerDialogModule.ACTION_DATE_SET);
                datePicker.putInt("year", i);
                datePicker.putInt("month", i2);
                datePicker.putInt("day", i3);
                this.mPromise.resolve(datePicker);
                this.mPromiseResolved = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (this.mPromiseResolved == null && DatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance() != null) {
                dialogInterface = new WritableNativeMap();
                dialogInterface.putString(NativeProtocol.WEB_DIALOG_ACTION, DatePickerDialogModule.ACTION_DISMISSED);
                this.mPromise.resolve(dialogInterface);
                this.mPromiseResolved = true;
            }
        }
    }

    public String getName() {
        return FRAGMENT_TAG;
    }

    public DatePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(ERROR_NO_ACTIVITY, "Tried to open a DatePicker dialog while not attached to an Activity");
            return;
        }
        if (currentActivity instanceof C4890j) {
            C0309n supportFragmentManager = ((C4890j) currentActivity).getSupportFragmentManager();
            C4457h c4457h = (C4457h) supportFragmentManager.mo200a(FRAGMENT_TAG);
            if (c4457h != null) {
                c4457h.dismiss();
            }
            SupportDatePickerDialogFragment supportDatePickerDialogFragment = new SupportDatePickerDialogFragment();
            if (readableMap != null) {
                supportDatePickerDialogFragment.setArguments(createFragmentArguments(readableMap));
            }
            readableMap = new DatePickerDialogListener(promise);
            supportDatePickerDialogFragment.setOnDismissListener(readableMap);
            supportDatePickerDialogFragment.setOnDateSetListener(readableMap);
            supportDatePickerDialogFragment.show(supportFragmentManager, (String) FRAGMENT_TAG);
        } else {
            FragmentManager fragmentManager = currentActivity.getFragmentManager();
            DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            }
            DatePickerDialogFragment datePickerDialogFragment = new DatePickerDialogFragment();
            if (readableMap != null) {
                datePickerDialogFragment.setArguments(createFragmentArguments(readableMap));
            }
            readableMap = new DatePickerDialogListener(promise);
            datePickerDialogFragment.setOnDismissListener(readableMap);
            datePickerDialogFragment.setOnDateSetListener(readableMap);
            datePickerDialogFragment.show(fragmentManager, FRAGMENT_TAG);
        }
    }

    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey(ARG_DATE) && !readableMap.isNull(ARG_DATE)) {
            bundle.putLong(ARG_DATE, (long) readableMap.getDouble(ARG_DATE));
        }
        if (readableMap.hasKey(ARG_MINDATE) && !readableMap.isNull(ARG_MINDATE)) {
            bundle.putLong(ARG_MINDATE, (long) readableMap.getDouble(ARG_MINDATE));
        }
        if (readableMap.hasKey(ARG_MAXDATE) && !readableMap.isNull(ARG_MAXDATE)) {
            bundle.putLong(ARG_MAXDATE, (long) readableMap.getDouble(ARG_MAXDATE));
        }
        if (readableMap.hasKey(ARG_MODE) && !readableMap.isNull(ARG_MODE)) {
            bundle.putString(ARG_MODE, readableMap.getString(ARG_MODE));
        }
        return bundle;
    }
}

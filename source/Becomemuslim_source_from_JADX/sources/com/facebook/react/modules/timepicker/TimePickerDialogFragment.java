package com.facebook.react.modules.timepicker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.format.DateFormat;
import com.facebook.internal.AnalyticsEvents;
import java.util.Calendar;
import java.util.Locale;

public class TimePickerDialogFragment extends DialogFragment {
    private OnDismissListener mOnDismissListener;
    private OnTimeSetListener mOnTimeSetListener;

    public Dialog onCreateDialog(Bundle bundle) {
        return createDialog(getArguments(), getActivity(), this.mOnTimeSetListener);
    }

    static Dialog createDialog(Bundle bundle, Context context, OnTimeSetListener onTimeSetListener) {
        Bundle bundle2 = bundle;
        Calendar instance = Calendar.getInstance();
        int i = instance.get(11);
        int i2 = instance.get(12);
        boolean is24HourFormat = DateFormat.is24HourFormat(context);
        TimePickerMode timePickerMode = TimePickerMode.DEFAULT;
        if (!(bundle2 == null || bundle.getString("mode", null) == null)) {
            timePickerMode = TimePickerMode.valueOf(bundle.getString("mode").toUpperCase(Locale.US));
        }
        if (bundle2 != null) {
            i = bundle.getInt("hour", instance.get(11));
            i2 = bundle.getInt("minute", instance.get(12));
            is24HourFormat = bundle.getBoolean("is24Hour", DateFormat.is24HourFormat(context));
        }
        if (VERSION.SDK_INT >= 21) {
            if (timePickerMode == TimePickerMode.CLOCK) {
                return new DismissableTimePickerDialog(context, context.getResources().getIdentifier("ClockTimePickerDialog", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, context.getPackageName()), onTimeSetListener, i, i2, is24HourFormat);
            } else if (timePickerMode == TimePickerMode.SPINNER) {
                return new DismissableTimePickerDialog(context, context.getResources().getIdentifier("SpinnerTimePickerDialog", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, context.getPackageName()), onTimeSetListener, i, i2, is24HourFormat);
            }
        }
        return new DismissableTimePickerDialog(context, onTimeSetListener, i, i2, is24HourFormat);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.mOnDismissListener != null) {
            this.mOnDismissListener.onDismiss(dialogInterface);
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnTimeSetListener(OnTimeSetListener onTimeSetListener) {
        this.mOnTimeSetListener = onTimeSetListener;
    }
}

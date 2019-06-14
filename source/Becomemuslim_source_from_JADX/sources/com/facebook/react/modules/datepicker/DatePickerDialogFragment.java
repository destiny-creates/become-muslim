package com.facebook.react.modules.datepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import java.util.Calendar;
import java.util.Locale;

@SuppressLint({"ValidFragment"})
public class DatePickerDialogFragment extends DialogFragment {
    private static final long DEFAULT_MIN_DATE = -2208988800001L;
    private OnDateSetListener mOnDateSetListener;
    private OnDismissListener mOnDismissListener;

    public Dialog onCreateDialog(Bundle bundle) {
        return createDialog(getArguments(), getActivity(), this.mOnDateSetListener);
    }

    static Dialog createDialog(Bundle bundle, Context context, OnDateSetListener onDateSetListener) {
        Dialog dialog;
        Calendar instance = Calendar.getInstance();
        if (bundle != null && bundle.containsKey("date")) {
            instance.setTimeInMillis(bundle.getLong("date"));
        }
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        DatePickerMode datePickerMode = DatePickerMode.DEFAULT;
        if (!(bundle == null || bundle.getString("mode", null) == null)) {
            datePickerMode = DatePickerMode.valueOf(bundle.getString("mode").toUpperCase(Locale.US));
        }
        DatePickerMode datePickerMode2 = datePickerMode;
        Dialog dismissableDatePickerDialog;
        if (VERSION.SDK_INT >= 21) {
            switch (datePickerMode2) {
                case CALENDAR:
                    dismissableDatePickerDialog = new DismissableDatePickerDialog(context, context.getResources().getIdentifier("CalendarDatePickerDialog", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, context.getPackageName()), onDateSetListener, i, i2, i3);
                    break;
                case SPINNER:
                    dismissableDatePickerDialog = new DismissableDatePickerDialog(context, context.getResources().getIdentifier("SpinnerDatePickerDialog", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, context.getPackageName()), onDateSetListener, i, i2, i3);
                    break;
                case DEFAULT:
                    dismissableDatePickerDialog = new DismissableDatePickerDialog(context, onDateSetListener, i, i2, i3);
                    break;
                default:
                    dialog = null;
                    break;
            }
        }
        dismissableDatePickerDialog = new DismissableDatePickerDialog(context, onDateSetListener, i, i2, i3);
        switch (datePickerMode2) {
            case CALENDAR:
                dismissableDatePickerDialog.getDatePicker().setCalendarViewShown(true);
                dismissableDatePickerDialog.getDatePicker().setSpinnersShown(false);
                break;
            case SPINNER:
                dismissableDatePickerDialog.getDatePicker().setCalendarViewShown(false);
                break;
            default:
                break;
        }
        dialog = dismissableDatePickerDialog;
        context = dialog.getDatePicker();
        if (bundle == null || !bundle.containsKey("minDate")) {
            context.setMinDate(DEFAULT_MIN_DATE);
        } else {
            instance.setTimeInMillis(bundle.getLong("minDate"));
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            context.setMinDate(instance.getTimeInMillis());
        }
        if (bundle != null && bundle.containsKey("maxDate")) {
            instance.setTimeInMillis(bundle.getLong("maxDate"));
            instance.set(11, 23);
            instance.set(12, 59);
            instance.set(13, 59);
            instance.set(14, 999);
            context.setMaxDate(instance.getTimeInMillis());
        }
        return dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.mOnDismissListener != null) {
            this.mOnDismissListener.onDismiss(dialogInterface);
        }
    }

    void setOnDateSetListener(OnDateSetListener onDateSetListener) {
        this.mOnDateSetListener = onDateSetListener;
    }

    void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }
}

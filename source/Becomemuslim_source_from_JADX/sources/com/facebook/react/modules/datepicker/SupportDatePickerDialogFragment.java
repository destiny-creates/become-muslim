package com.facebook.react.modules.datepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.C4457h;

@SuppressLint({"ValidFragment"})
public class SupportDatePickerDialogFragment extends C4457h {
    private OnDateSetListener mOnDateSetListener;
    private OnDismissListener mOnDismissListener;

    public Dialog onCreateDialog(Bundle bundle) {
        return DatePickerDialogFragment.createDialog(getArguments(), getActivity(), this.mOnDateSetListener);
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

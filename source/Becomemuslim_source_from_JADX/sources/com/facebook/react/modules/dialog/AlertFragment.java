package com.facebook.react.modules.dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class AlertFragment extends DialogFragment implements OnClickListener {
    static final String ARG_BUTTON_NEGATIVE = "button_negative";
    static final String ARG_BUTTON_NEUTRAL = "button_neutral";
    static final String ARG_BUTTON_POSITIVE = "button_positive";
    static final String ARG_ITEMS = "items";
    static final String ARG_MESSAGE = "message";
    static final String ARG_TITLE = "title";
    private final AlertFragmentListener mListener;

    public AlertFragment() {
        this.mListener = null;
    }

    @SuppressLint({"ValidFragment"})
    public AlertFragment(AlertFragmentListener alertFragmentListener, Bundle bundle) {
        this.mListener = alertFragmentListener;
        setArguments(bundle);
    }

    public static Dialog createDialog(Context context, Bundle bundle, OnClickListener onClickListener) {
        context = new Builder(context).setTitle(bundle.getString("title"));
        if (bundle.containsKey(ARG_BUTTON_POSITIVE)) {
            context.setPositiveButton(bundle.getString(ARG_BUTTON_POSITIVE), onClickListener);
        }
        if (bundle.containsKey(ARG_BUTTON_NEGATIVE)) {
            context.setNegativeButton(bundle.getString(ARG_BUTTON_NEGATIVE), onClickListener);
        }
        if (bundle.containsKey(ARG_BUTTON_NEUTRAL)) {
            context.setNeutralButton(bundle.getString(ARG_BUTTON_NEUTRAL), onClickListener);
        }
        if (bundle.containsKey("message")) {
            context.setMessage(bundle.getString("message"));
        }
        if (bundle.containsKey(ARG_ITEMS)) {
            context.setItems(bundle.getCharSequenceArray(ARG_ITEMS), onClickListener);
        }
        return context.create();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return createDialog(getActivity(), getArguments(), this);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.mListener != null) {
            this.mListener.onClick(dialogInterface, i);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.mListener != null) {
            this.mListener.onDismiss(dialogInterface);
        }
    }
}

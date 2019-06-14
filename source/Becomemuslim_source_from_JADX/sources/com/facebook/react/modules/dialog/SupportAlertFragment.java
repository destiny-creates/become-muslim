package com.facebook.react.modules.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.C4457h;

public class SupportAlertFragment extends C4457h implements OnClickListener {
    private final AlertFragmentListener mListener;

    public SupportAlertFragment() {
        this.mListener = null;
    }

    @SuppressLint({"ValidFragment"})
    public SupportAlertFragment(AlertFragmentListener alertFragmentListener, Bundle bundle) {
        this.mListener = alertFragmentListener;
        setArguments(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return AlertFragment.createDialog(getActivity(), getArguments(), this);
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

package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.common.c */
public class C2826c extends DialogFragment {
    /* renamed from: a */
    private Dialog f7225a = null;
    /* renamed from: b */
    private OnCancelListener f7226b = null;

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f7225a == null) {
            setShowsDialog(null);
        }
        return this.f7225a;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f7226b != null) {
            this.f7226b.onCancel(dialogInterface);
        }
    }

    /* renamed from: a */
    public static C2826c m8120a(Dialog dialog, OnCancelListener onCancelListener) {
        C2826c c2826c = new C2826c();
        dialog = (Dialog) C2872v.m8381a((Object) dialog, (Object) "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        c2826c.f7225a = dialog;
        if (onCancelListener != null) {
            c2826c.f7226b = onCancelListener;
        }
        return c2826c;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}

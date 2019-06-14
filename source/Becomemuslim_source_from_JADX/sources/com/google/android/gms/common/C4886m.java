package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.C0309n;
import android.support.v4.app.C4457h;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.common.m */
public class C4886m extends C4457h {
    /* renamed from: a */
    private Dialog f13987a = null;
    /* renamed from: b */
    private OnCancelListener f13988b = null;

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f13987a == null) {
            setShowsDialog(null);
        }
        return this.f13987a;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f13988b != null) {
            this.f13988b.onCancel(dialogInterface);
        }
    }

    /* renamed from: a */
    public static C4886m m17512a(Dialog dialog, OnCancelListener onCancelListener) {
        C4886m c4886m = new C4886m();
        dialog = (Dialog) C2872v.m8381a((Object) dialog, (Object) "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        c4886m.f13987a = dialog;
        if (onCancelListener != null) {
            c4886m.f13988b = onCancelListener;
        }
        return c4886m;
    }

    public void show(C0309n c0309n, String str) {
        super.show(c0309n, str);
    }
}

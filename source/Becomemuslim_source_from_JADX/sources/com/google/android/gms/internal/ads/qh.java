package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsResult;

final class qh implements OnCancelListener {
    /* renamed from: a */
    private final /* synthetic */ JsResult f15949a;

    qh(JsResult jsResult) {
        this.f15949a = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f15949a.cancel();
    }
}

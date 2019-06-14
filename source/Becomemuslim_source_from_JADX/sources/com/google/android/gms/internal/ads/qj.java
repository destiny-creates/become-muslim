package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

final class qj implements OnClickListener {
    /* renamed from: a */
    private final /* synthetic */ JsResult f15951a;

    qj(JsResult jsResult) {
        this.f15951a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f15951a.confirm();
    }
}

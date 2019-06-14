package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

final class qi implements OnClickListener {
    /* renamed from: a */
    private final /* synthetic */ JsResult f15950a;

    qi(JsResult jsResult) {
        this.f15950a = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f15950a.cancel();
    }
}

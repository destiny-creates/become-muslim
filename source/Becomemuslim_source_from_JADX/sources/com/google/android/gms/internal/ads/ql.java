package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;

final class ql implements OnClickListener {
    /* renamed from: a */
    private final /* synthetic */ JsPromptResult f15953a;

    ql(JsPromptResult jsPromptResult) {
        this.f15953a = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f15953a.cancel();
    }
}

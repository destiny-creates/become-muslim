package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsPromptResult;

final class qk implements OnCancelListener {
    /* renamed from: a */
    private final /* synthetic */ JsPromptResult f15952a;

    qk(JsPromptResult jsPromptResult) {
        this.f15952a = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f15952a.cancel();
    }
}

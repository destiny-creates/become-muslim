package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class qm implements OnClickListener {
    /* renamed from: a */
    private final /* synthetic */ JsPromptResult f15954a;
    /* renamed from: b */
    private final /* synthetic */ EditText f15955b;

    qm(JsPromptResult jsPromptResult, EditText editText) {
        this.f15954a = jsPromptResult;
        this.f15955b = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f15954a.confirm(this.f15955b.getText().toString());
    }
}

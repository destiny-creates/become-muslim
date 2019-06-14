package com.google.android.gms.internal.ads;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;

final class lk implements bdl {
    /* renamed from: a */
    private final /* synthetic */ String f24147a;
    /* renamed from: b */
    private final /* synthetic */ lo f24148b;

    lk(lg lgVar, String str, lo loVar) {
        this.f24147a = str;
        this.f24148b = loVar;
    }

    /* renamed from: a */
    public final void mo4310a(df dfVar) {
        String str = this.f24147a;
        String dfVar2 = dfVar.toString();
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 21) + String.valueOf(dfVar2).length());
        stringBuilder.append("Failed to load URL: ");
        stringBuilder.append(str);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append(dfVar2);
        mt.m19924e(stringBuilder.toString());
        this.f24148b.mo6110a(null);
    }
}

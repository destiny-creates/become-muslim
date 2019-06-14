package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.WebSettings;

@TargetApi(16)
public class kk extends kh {
    /* renamed from: a */
    public final void mo6843a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    /* renamed from: a */
    public final void mo6844a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    /* renamed from: a */
    public boolean mo6103a(Context context, WebSettings webSettings) {
        super.mo6103a(context, webSettings);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }
}

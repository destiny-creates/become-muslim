package com.google.android.gms.ads.internal;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.jn;

final class as extends WebViewClient {
    /* renamed from: a */
    private final /* synthetic */ ar f6729a;

    as(ar arVar) {
        this.f6729a = arVar;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.f6729a.f12983g != null) {
            try {
                this.f6729a.f12983g.a(0);
            } catch (Throwable e) {
                jn.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.f6729a.m16515d())) {
            return false;
        }
        if (str.startsWith((String) aph.f().a(asp.cu))) {
            if (this.f6729a.f12983g != null) {
                try {
                    this.f6729a.f12983g.a(3);
                } catch (Throwable e) {
                    jn.d("#007 Could not call remote method.", e);
                }
            }
            this.f6729a.m16496a(0);
            return true;
        }
        if (str.startsWith((String) aph.f().a(asp.cv))) {
            if (this.f6729a.f12983g != null) {
                try {
                    this.f6729a.f12983g.a(0);
                } catch (Throwable e2) {
                    jn.d("#007 Could not call remote method.", e2);
                }
            }
            this.f6729a.m16496a(0);
            return true;
        }
        if (str.startsWith((String) aph.f().a(asp.cw))) {
            if (this.f6729a.f12983g != null) {
                try {
                    this.f6729a.f12983g.c();
                } catch (Throwable e22) {
                    jn.d("#007 Could not call remote method.", e22);
                }
            }
            this.f6729a.m16496a(this.f6729a.m16510b(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            if (this.f6729a.f12983g != null) {
                try {
                    this.f6729a.f12983g.b();
                } catch (Throwable e222) {
                    jn.d("#007 Could not call remote method.", e222);
                }
            }
            this.f6729a.m16488d(this.f6729a.m16486c(str));
            return true;
        }
    }
}

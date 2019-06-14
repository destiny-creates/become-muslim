package com.google.android.gms.ads.internal;

import android.webkit.CookieManager;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import java.util.concurrent.Callable;

final class be implements Callable<String> {
    /* renamed from: a */
    private final /* synthetic */ bb f6821a;

    be(bb bbVar) {
        this.f6821a = bbVar;
    }

    public final /* synthetic */ Object call() {
        String str = "";
        if (!((Boolean) aph.f().a(asp.cC)).booleanValue()) {
            return str;
        }
        CookieManager c = ax.m7466g().c(this.f6821a.e.f6792c);
        return c != null ? c.getCookie("googleads.g.doubleclick.net") : str;
    }
}

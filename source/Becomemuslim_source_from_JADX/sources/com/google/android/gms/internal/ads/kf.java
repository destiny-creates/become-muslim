package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import java.util.Set;

@TargetApi(11)
public class kf extends ke {
    /* renamed from: a */
    public qp mo6101a(qo qoVar, boolean z) {
        return new rm(qoVar, z);
    }

    /* renamed from: a */
    public final Set<String> mo6102a(Uri uri) {
        return uri.getQueryParameterNames();
    }

    /* renamed from: a */
    public final boolean mo4308a(Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return true;
    }

    /* renamed from: a */
    public boolean mo6103a(Context context, WebSettings webSettings) {
        super.mo6103a(context, webSettings);
        return ((Boolean) lz.m19845a(context, new kg(this, context, webSettings))).booleanValue();
    }

    /* renamed from: a */
    public final boolean mo6104a(Window window) {
        window.setFlags(16777216, 16777216);
        return true;
    }

    /* renamed from: b */
    public final boolean mo6105b(View view) {
        view.setLayerType(0, null);
        return true;
    }

    /* renamed from: c */
    public final boolean mo6106c(View view) {
        view.setLayerType(1, null);
        return true;
    }
}

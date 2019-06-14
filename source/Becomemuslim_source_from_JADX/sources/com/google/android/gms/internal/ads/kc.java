package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.ax;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@TargetApi(8)
@cm
public class kc {
    private kc() {
    }

    /* renamed from: a */
    public static boolean m19752a(qo qoVar) {
        if (qoVar == null) {
            return false;
        }
        qoVar.onPause();
        return true;
    }

    /* renamed from: b */
    public static boolean m19753b(qo qoVar) {
        if (qoVar == null) {
            return false;
        }
        qoVar.onResume();
        return true;
    }

    /* renamed from: e */
    public static boolean m19754e() {
        int myUid = Process.myUid();
        if (myUid != 0) {
            if (myUid != 1000) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public int mo4307a() {
        return 0;
    }

    /* renamed from: a */
    public Drawable mo6867a(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    /* renamed from: a */
    public WebResourceResponse mo6907a(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    /* renamed from: a */
    public qp mo6101a(qo qoVar, boolean z) {
        return new qp(qoVar, z);
    }

    /* renamed from: a */
    public String mo6868a(Context context) {
        return "";
    }

    /* renamed from: a */
    public String mo6658a(SslError sslError) {
        return "";
    }

    /* renamed from: a */
    public Set<String> mo6102a(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* renamed from: a */
    public void mo6843a(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public void mo6844a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    /* renamed from: a */
    public boolean mo4308a(Request request) {
        return false;
    }

    /* renamed from: a */
    public boolean mo6103a(Context context, WebSettings webSettings) {
        return false;
    }

    /* renamed from: a */
    public boolean mo6877a(View view) {
        if (view.getWindowToken() == null) {
            if (view.getWindowVisibility() == 8) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo6104a(Window window) {
        return false;
    }

    /* renamed from: b */
    public int mo4309b() {
        return 1;
    }

    /* renamed from: b */
    public void mo6869b(Context context) {
    }

    /* renamed from: b */
    public boolean mo6105b(View view) {
        return false;
    }

    /* renamed from: c */
    public int mo6878c() {
        return 5;
    }

    /* renamed from: c */
    public CookieManager mo6908c(Context context) {
        if (m19754e()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            mt.m19919b("Failed to obtain CookieManager.", th);
            ax.i().m30834a(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    /* renamed from: c */
    public boolean mo6106c(View view) {
        return false;
    }

    /* renamed from: d */
    public LayoutParams mo6891d() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: f */
    public int mo6659f() {
        return 0;
    }
}

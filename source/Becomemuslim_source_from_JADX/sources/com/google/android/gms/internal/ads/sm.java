package com.google.android.gms.internal.ads;

import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.ax;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@cm
public class sm extends WebView implements sr, st, sv, sw {
    /* renamed from: a */
    protected final WebViewClient f24316a;
    /* renamed from: b */
    private final List<sr> f24317b = new CopyOnWriteArrayList();
    /* renamed from: c */
    private final List<sw> f24318c = new CopyOnWriteArrayList();
    /* renamed from: d */
    private final List<st> f24319d = new CopyOnWriteArrayList();
    /* renamed from: e */
    private final List<sv> f24320e = new CopyOnWriteArrayList();
    /* renamed from: f */
    private final sb f24321f;

    public sm(sb sbVar) {
        super(sbVar);
        this.f24321f = sbVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        ax.g().mo6103a(getContext(), settings);
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        try {
            getSettings().setJavaScriptEnabled(true);
        } catch (Throwable e) {
            mt.m19919b("Unable to enable Javascript.", e);
        }
        setLayerType(1, null);
        this.f24316a = new sn(this, this, this, this);
        super.setWebViewClient(this.f24316a);
    }

    /* renamed from: K */
    protected final sb m31089K() {
        return this.f24321f;
    }

    /* renamed from: a */
    public void mo4088a(so soVar) {
        for (sv a : this.f24320e) {
            a.mo4088a(soVar);
        }
    }

    /* renamed from: a */
    public final void m31091a(sr srVar) {
        this.f24317b.add(srVar);
    }

    /* renamed from: a */
    public final void m31092a(st stVar) {
        this.f24319d.add(stVar);
    }

    /* renamed from: a */
    public final void m31093a(sv svVar) {
        this.f24320e.add(svVar);
    }

    /* renamed from: a */
    public final void m31094a(sw swVar) {
        this.f24318c.add(swVar);
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (VERSION.SDK_INT >= 17) {
            super.addJavascriptInterface(obj, str);
        } else {
            jn.m30864a("Ignore addJavascriptInterface due to low Android version.");
        }
    }

    /* renamed from: b */
    public final void mo4087b(so soVar) {
        for (st b : this.f24319d) {
            b.mo4087b(soVar);
        }
    }

    /* renamed from: b */
    public void mo4090b(String str) {
        ss.m20100a(this, str);
    }

    /* renamed from: c */
    public final boolean mo4086c(so soVar) {
        for (sr c : this.f24317b) {
            if (c.mo4086c(soVar)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public final WebResourceResponse mo4355d(so soVar) {
        for (sw d : this.f24318c) {
            WebResourceResponse d2 = d.mo4355d(soVar);
            if (d2 != null) {
                return d2;
            }
        }
        return null;
    }

    public void loadUrl(String str) {
        try {
            super.loadUrl(str);
        } catch (Throwable e) {
            ax.i().m30834a(e, "CoreWebView.loadUrl");
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
    }
}

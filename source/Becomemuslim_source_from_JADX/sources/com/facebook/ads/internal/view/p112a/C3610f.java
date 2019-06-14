package com.facebook.ads.internal.view.p112a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.p105q.p108c.C1531a;
import com.facebook.ads.internal.p105q.p108c.C1532b;
import com.facebook.common.util.UriUtil;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

@TargetApi(19)
/* renamed from: com.facebook.ads.internal.view.a.f */
public class C3610f extends C1531a {
    /* renamed from: a */
    private static final String f9622a = "f";
    /* renamed from: b */
    private static final Set<String> f9623b = new HashSet(2);
    /* renamed from: c */
    private C1563a f9624c;
    /* renamed from: d */
    private C1561d f9625d;
    /* renamed from: e */
    private long f9626e = -1;
    /* renamed from: f */
    private long f9627f = -1;
    /* renamed from: g */
    private long f9628g = -1;
    /* renamed from: h */
    private long f9629h = -1;

    /* renamed from: com.facebook.ads.internal.view.a.f$a */
    public interface C1563a {
        /* renamed from: a */
        void mo1001a(int i);

        /* renamed from: a */
        void mo1002a(String str);

        /* renamed from: b */
        void mo1003b(String str);

        /* renamed from: c */
        void mo1004c(String str);
    }

    /* renamed from: com.facebook.ads.internal.view.a.f$b */
    static class C1564b extends WebChromeClient {
        /* renamed from: a */
        private final WeakReference<C1563a> f4674a;
        /* renamed from: b */
        private final WeakReference<C1561d> f4675b;

        C1564b(WeakReference<C1563a> weakReference, WeakReference<C1561d> weakReference2) {
            this.f4674a = weakReference;
            this.f4675b = weakReference2;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message = consoleMessage.message();
            if (!(TextUtils.isEmpty(message) || consoleMessage.messageLevel() != MessageLevel.LOG || this.f4675b.get() == null)) {
                ((C1561d) this.f4675b.get()).m5469a(message);
            }
            return true;
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (this.f4675b.get() != null) {
                ((C1561d) this.f4675b.get()).m5468a();
            }
            if (this.f4674a.get() != null) {
                ((C1563a) this.f4674a.get()).mo1001a(i);
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (this.f4674a.get() != null) {
                ((C1563a) this.f4674a.get()).mo1003b(str);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.a.f$c */
    static class C1565c extends WebViewClient {
        /* renamed from: a */
        private final WeakReference<C1563a> f4676a;
        /* renamed from: b */
        private final WeakReference<Context> f4677b;

        C1565c(WeakReference<C1563a> weakReference, WeakReference<Context> weakReference2) {
            this.f4676a = weakReference;
            this.f4677b = weakReference2;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.f4676a.get() != null) {
                ((C1563a) this.f4676a.get()).mo1004c(str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (this.f4676a.get() != null) {
                ((C1563a) this.f4676a.get()).mo1002a(str);
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse = Uri.parse(str);
            if (!(C3610f.f9623b.contains(parse.getScheme()) || this.f4677b.get() == null)) {
                try {
                    ((Context) this.f4677b.get()).startActivity(new Intent("android.intent.action.VIEW", parse));
                    return true;
                } catch (Throwable e) {
                    Log.w(C3610f.f9622a, "Activity not found to handle URI.", e);
                } catch (Throwable e2) {
                    Log.e(C3610f.f9622a, "Unknown exception occurred when trying to handle URI.", e2);
                }
            }
            return false;
        }
    }

    static {
        f9623b.add(UriUtil.HTTP_SCHEME);
        f9623b.add(UriUtil.HTTPS_SCHEME);
    }

    public C3610f(Context context) {
        super(context);
        m11769f();
    }

    /* renamed from: f */
    private void m11769f() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        this.f9625d = new C1561d(this);
    }

    /* renamed from: g */
    private void m11770g() {
        if (this.f9627f > -1 && this.f9628g > -1 && this.f9629h > -1) {
            this.f9625d.m5470a(false);
        }
    }

    /* renamed from: a */
    protected WebChromeClient mo997a() {
        return new C1564b(new WeakReference(this.f9624c), new WeakReference(this.f9625d));
    }

    /* renamed from: a */
    public void m11772a(long j) {
        if (this.f9626e < 0) {
            this.f9626e = j;
        }
    }

    /* renamed from: a */
    public void m11773a(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = 0;
        r2.evaluateJavascript(r3, r0);	 Catch:{ IllegalStateException -> 0x0005 }
        goto L_0x0019;
    L_0x0005:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "javascript:";
        r0.append(r1);
        r0.append(r3);
        r3 = r0.toString();
        r2.loadUrl(r3);
    L_0x0019:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.a.f.a(java.lang.String):void");
    }

    /* renamed from: b */
    protected WebViewClient mo998b() {
        return new C1565c(new WeakReference(this.f9624c), new WeakReference(getContext()));
    }

    /* renamed from: b */
    public void m11775b(long j) {
        if (this.f9627f < 0) {
            this.f9627f = j;
        }
        m11770g();
    }

    /* renamed from: c */
    public void m11776c(long j) {
        if (this.f9629h < 0) {
            this.f9629h = j;
        }
        m11770g();
    }

    public void destroy() {
        this.f9624c = null;
        C1532b.m5366a(this);
        super.destroy();
    }

    public long getDomContentLoadedMs() {
        return this.f9627f;
    }

    public String getFirstUrl() {
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        return copyBackForwardList.getSize() > 0 ? copyBackForwardList.getItemAtIndex(0).getUrl() : getUrl();
    }

    public long getLoadFinishMs() {
        return this.f9629h;
    }

    public long getResponseEndMs() {
        return this.f9626e;
    }

    public long getScrollReadyMs() {
        return this.f9628g;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9628g < 0 && computeVerticalScrollRange() > getHeight()) {
            this.f9628g = System.currentTimeMillis();
            m11770g();
        }
    }

    public void setListener(C1563a c1563a) {
        this.f9624c = c1563a;
    }
}

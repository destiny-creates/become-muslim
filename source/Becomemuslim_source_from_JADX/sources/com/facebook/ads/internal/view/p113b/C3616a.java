package com.facebook.ads.internal.view.p113b;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.p092g.C1384a;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p105q.p108c.C1531a;
import com.facebook.ads.internal.p105q.p108c.C1532b;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.p111r.C1545a.C1544a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.internal.view.b.a */
public class C3616a extends C1531a {
    /* renamed from: a */
    private static final String f9635a = "a";
    /* renamed from: b */
    private final WeakReference<C1568b> f9636b;
    /* renamed from: c */
    private final AtomicBoolean f9637c = new AtomicBoolean();
    /* renamed from: d */
    private final AtomicBoolean f9638d = new AtomicBoolean(true);
    /* renamed from: e */
    private WeakReference<C1569d> f9639e;
    /* renamed from: f */
    private C1545a f9640f;
    /* renamed from: g */
    private C1520t f9641g = new C1520t();
    /* renamed from: h */
    private C1544a f9642h;
    /* renamed from: i */
    private boolean f9643i = true;
    /* renamed from: j */
    private boolean f9644j;

    /* renamed from: com.facebook.ads.internal.view.b.a$a */
    static class C1567a {
        /* renamed from: a */
        private final String f4678a = C1567a.class.getSimpleName();
        /* renamed from: b */
        private final WeakReference<C3616a> f4679b;
        /* renamed from: c */
        private final WeakReference<C1568b> f4680c;
        /* renamed from: d */
        private final WeakReference<C1545a> f4681d;
        /* renamed from: e */
        private final WeakReference<AtomicBoolean> f4682e;
        /* renamed from: f */
        private final WeakReference<AtomicBoolean> f4683f;
        /* renamed from: g */
        private final boolean f4684g;

        C1567a(C3616a c3616a, C1568b c1568b, C1545a c1545a, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, boolean z) {
            this.f4679b = new WeakReference(c3616a);
            this.f4680c = new WeakReference(c1568b);
            this.f4681d = new WeakReference(c1545a);
            this.f4682e = new WeakReference(atomicBoolean);
            this.f4683f = new WeakReference(atomicBoolean2);
            this.f4684g = z;
        }

        @JavascriptInterface
        public void alert(String str) {
            Log.e(this.f4678a, str);
        }

        @JavascriptInterface
        public String getAnalogInfo() {
            return C1508k.m5306a(C1384a.m4731a());
        }

        @JavascriptInterface
        public void onMainAssetLoaded() {
            if (this.f4679b.get() != null && this.f4682e.get() != null) {
                if (this.f4683f.get() != null) {
                    if (this.f4684g && ((AtomicBoolean) this.f4683f.get()).get()) {
                        ((AtomicBoolean) this.f4682e.get()).set(true);
                        if (((C3616a) this.f4679b.get()).isShown()) {
                            new Handler(Looper.getMainLooper()).post(new C1570e(this.f4681d));
                        }
                    }
                }
            }
        }

        @JavascriptInterface
        public void onPageInitialized() {
            C3616a c3616a = (C3616a) this.f4679b.get();
            if (c3616a == null) {
                return;
            }
            if (!c3616a.m5364c()) {
                C1568b c1568b = (C1568b) this.f4680c.get();
                if (c1568b != null) {
                    c1568b.mo1005a();
                }
                if (!this.f4684g && ((C3616a) this.f4679b.get()).isShown()) {
                    new Handler(Looper.getMainLooper()).post(new C1570e(this.f4681d));
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.b.a$b */
    public interface C1568b {
        /* renamed from: a */
        void mo1005a();

        /* renamed from: a */
        void mo1006a(int i);

        /* renamed from: a */
        void mo1007a(WebResourceError webResourceError);

        /* renamed from: a */
        void mo1008a(String str, Map<String, String> map);

        /* renamed from: b */
        void mo1009b();
    }

    /* renamed from: com.facebook.ads.internal.view.b.a$d */
    public interface C1569d {
        /* renamed from: b */
        void mo1065b();
    }

    /* renamed from: com.facebook.ads.internal.view.b.a$e */
    static class C1570e implements Runnable {
        /* renamed from: a */
        private final WeakReference<C1545a> f4685a;

        C1570e(C1545a c1545a) {
            this.f4685a = new WeakReference(c1545a);
        }

        C1570e(WeakReference<C1545a> weakReference) {
            this.f4685a = weakReference;
        }

        public void run() {
            C1545a c1545a = (C1545a) this.f4685a.get();
            if (c1545a != null) {
                c1545a.m5431a();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.b.a$f */
    static class C1571f extends WebChromeClient {
        C1571f() {
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.b.a$g */
    static class C1573g extends WebViewClient {
        /* renamed from: a */
        private final WeakReference<C1568b> f4687a;
        /* renamed from: b */
        private final WeakReference<C1545a> f4688b;
        /* renamed from: c */
        private final WeakReference<C1520t> f4689c;
        /* renamed from: d */
        private final WeakReference<AtomicBoolean> f4690d;
        /* renamed from: e */
        private final WeakReference<C3616a> f4691e;
        /* renamed from: f */
        private boolean f4692f = false;

        /* renamed from: com.facebook.ads.internal.view.b.a$g$1 */
        class C15721 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C1573g f4686a;

            C15721(C1573g c1573g) {
                this.f4686a = c1573g;
            }

            public void run() {
                if (!this.f4686a.f4692f) {
                    this.f4686a.m5486a(null);
                }
            }
        }

        C1573g(WeakReference<C1568b> weakReference, WeakReference<C1545a> weakReference2, WeakReference<C1520t> weakReference3, WeakReference<AtomicBoolean> weakReference4, WeakReference<C3616a> weakReference5) {
            this.f4687a = weakReference;
            this.f4688b = weakReference2;
            this.f4689c = weakReference3;
            this.f4690d = weakReference4;
            this.f4691e = weakReference5;
        }

        /* renamed from: a */
        private void m5486a(WebResourceError webResourceError) {
            if (this.f4687a.get() != null) {
                ((C1568b) this.f4687a.get()).mo1007a(webResourceError);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            if (!(this.f4691e.get() == null || this.f4690d.get() == null || ((AtomicBoolean) this.f4690d.get()).get())) {
                ((C3616a) this.f4691e.get()).m11793e();
            }
            this.f4692f = true;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            new Handler().postDelayed(new C15721(this), 2000);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            this.f4692f = true;
            m5486a(webResourceError);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Map hashMap = new HashMap();
            if (this.f4688b.get() != null) {
                ((C1545a) this.f4688b.get()).m5433a(hashMap);
            }
            if (this.f4689c.get() != null) {
                hashMap.put("touch", C1508k.m5306a(((C1520t) this.f4689c.get()).m5335e()));
            }
            if (this.f4687a.get() != null) {
                ((C1568b) this.f4687a.get()).mo1008a(str, hashMap);
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.b.a$1 */
    class C36141 extends C1544a {
        /* renamed from: a */
        final /* synthetic */ C3616a f9634a;

        C36141(C3616a c3616a) {
            this.f9634a = c3616a;
        }

        /* renamed from: a */
        public void mo925a() {
            if (this.f9634a.f9643i || !this.f9634a.f9641g.m5332b()) {
                this.f9634a.f9641g.m5330a();
            }
            if (this.f9634a.f9636b.get() != null) {
                ((C1568b) this.f9634a.f9636b.get()).mo1009b();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.b.a$c */
    public static class C3615c implements C1568b {
        /* renamed from: a */
        public void mo1005a() {
        }

        /* renamed from: a */
        public void mo1006a(int i) {
        }

        /* renamed from: a */
        public void mo1007a(WebResourceError webResourceError) {
        }

        /* renamed from: a */
        public void mo1008a(String str, Map<String, String> map) {
        }

        /* renamed from: b */
        public void mo1009b() {
        }
    }

    public C3616a(Context context, WeakReference<C1568b> weakReference, int i) {
        super(context);
        this.f9644j = C1405a.m4842w(context);
        this.f9636b = weakReference;
        this.f9642h = new C36141(this);
        this.f9640f = new C1545a(this, i, this.f9642h);
        setWebChromeClient(mo997a());
        setWebViewClient(mo998b());
        getSettings().setSupportZoom(false);
        getSettings().setCacheMode(1);
        addJavascriptInterface(new C1567a(this, (C1568b) weakReference.get(), this.f9640f, this.f9637c, this.f9638d, this.f9644j), "AdControl");
    }

    /* renamed from: d */
    private boolean m11792d() {
        if (this.f9644j) {
            if (!this.f9637c.get()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    private void m11793e() {
        this.f9637c.set(true);
        new Handler(Looper.getMainLooper()).post(new C1570e(this.f9640f));
        if (this.f9639e != null && this.f9639e.get() != null) {
            ((C1569d) this.f9639e.get()).mo1065b();
        }
    }

    /* renamed from: a */
    protected WebChromeClient mo997a() {
        return new C1571f();
    }

    /* renamed from: a */
    public void m11795a(int i, int i2) {
        if (this.f9640f != null) {
            this.f9640f.m5432a(i);
            this.f9640f.m5434b(i2);
        }
    }

    /* renamed from: b */
    protected WebViewClient mo998b() {
        return new C1573g(this.f9636b, new WeakReference(this.f9640f), new WeakReference(this.f9641g), new WeakReference(this.f9638d), new WeakReference(this));
    }

    public void destroy() {
        if (this.f9640f != null) {
            this.f9640f.m5436c();
            this.f9640f = null;
        }
        C1523w.m5346b(this);
        this.f9642h = null;
        this.f9641g = null;
        C1532b.m5366a(this);
        super.destroy();
    }

    public Map<String, String> getTouchData() {
        return this.f9641g.m5335e();
    }

    public C1520t getTouchDataRecorder() {
        return this.f9641g;
    }

    public C1545a getViewabilityChecker() {
        return this.f9640f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f9641g.m5331a(motionEvent, this, this);
        return super.onTouchEvent(motionEvent);
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f9636b.get() != null) {
            ((C1568b) this.f9636b.get()).mo1006a(i);
        }
        if (this.f9640f != null) {
            if (i == 0 && m11792d()) {
                this.f9640f.m5431a();
            } else if (i == 8) {
                this.f9640f.m5436c();
            }
        }
    }

    public void setCheckAssetsByJavascriptBridge(boolean z) {
        this.f9638d.set(z);
    }

    public void setLogMultipleImpressions(boolean z) {
        this.f9643i = z;
    }

    public void setOnAssetsLoadedListener(C1569d c1569d) {
        this.f9639e = new WeakReference(c1569d);
    }

    public void setWaitForAssetsToLoad(boolean z) {
        this.f9644j = z;
    }
}

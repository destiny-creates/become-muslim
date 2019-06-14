package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.ax;

@cm
public class sp extends sm {
    /* renamed from: b */
    private boolean f28755b;
    /* renamed from: c */
    private boolean f28756c;

    public sp(sb sbVar) {
        super(sbVar);
        ax.i().m30844i();
    }

    /* renamed from: a */
    private final synchronized void mo6670a() {
        if (!this.f28756c) {
            this.f28756c = true;
            ax.i().m30845j();
        }
    }

    /* renamed from: A */
    public final synchronized boolean m37656A() {
        return this.f28755b;
    }

    /* renamed from: B */
    public final synchronized void m37657B() {
        jn.m30864a("Destroying WebView!");
        mo6670a();
        nu.f15846a.execute(new sq(this));
    }

    /* renamed from: L */
    final /* synthetic */ void m37658L() {
        super.destroy();
    }

    /* renamed from: a */
    public final synchronized void mo4088a(so soVar) {
        if (m37656A()) {
            jn.m30864a("Blank page loaded, 1...");
            m37657B();
            return;
        }
        super.mo4088a(soVar);
    }

    public synchronized void destroy() {
        if (!this.f28755b) {
            this.f28755b = true;
            mo6722f(false);
            jn.m30864a("Initiating WebView self destruct sequence in 3...");
            jn.m30864a("Loading blank page in WebView, 2...");
            try {
                super.loadUrl("about:blank");
            } catch (Throwable e) {
                ax.i().m30834a(e, "AdWebViewImpl.loadUrlUnsafe");
                mt.m19923d("#007 Could not call remote method.", e);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(19)
    public synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.m37656A();	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0014;
    L_0x0007:
        r2 = "#004 The webview is destroyed. Ignoring action.";
        com.google.android.gms.internal.ads.mt.m19924e(r2);	 Catch:{ all -> 0x0019 }
        if (r3 == 0) goto L_0x0012;
    L_0x000e:
        r2 = 0;
        r3.onReceiveValue(r2);	 Catch:{ all -> 0x0019 }
    L_0x0012:
        monitor-exit(r1);
        return;
    L_0x0014:
        super.evaluateJavascript(r2, r3);	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);
        return;
    L_0x0019:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.sp.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    /* renamed from: f */
    protected void mo6722f(boolean z) {
    }

    protected void finalize() {
        try {
            synchronized (this) {
                if (!m37656A()) {
                    mo6722f(true);
                }
                mo6670a();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public synchronized void loadData(String str, String str2, String str3) {
        if (m37656A()) {
            mt.m19924e("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (m37656A()) {
            mt.m19924e("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public synchronized void loadUrl(String str) {
        if (m37656A()) {
            mt.m19924e("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadUrl(str);
        }
    }

    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (!m37656A()) {
            super.onDraw(canvas);
        }
    }

    public void onPause() {
        if (!m37656A()) {
            super.onPause();
        }
    }

    public void onResume() {
        if (!m37656A()) {
            super.onResume();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !m37656A() && super.onTouchEvent(motionEvent);
    }

    public void stopLoading() {
        if (!m37656A()) {
            super.stopLoading();
        }
    }
}

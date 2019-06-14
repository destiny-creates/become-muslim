package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p108c.C1531a;
import com.facebook.ads.internal.p111r.C1545a;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.adapters.q */
public class C3569q extends C1323b {
    /* renamed from: c */
    private static final String f9531c = "q";
    /* renamed from: d */
    private final C1531a f9532d;
    /* renamed from: e */
    private final C1412c f9533e;
    /* renamed from: f */
    private C3568p f9534f;
    /* renamed from: g */
    private boolean f9535g;

    /* renamed from: com.facebook.ads.internal.adapters.q$1 */
    class C13371 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3569q f3891a;

        C13371(C3569q c3569q) {
            this.f3891a = c3569q;
        }

        public void run() {
            if (this.f3891a.f9532d.m5364c()) {
                Log.w(C3569q.f9531c, "Webview already destroyed, cannot activate");
                return;
            }
            C1531a a = this.f3891a.f9532d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("javascript:");
            stringBuilder.append(this.f3891a.f9534f.m11566e());
            a.loadUrl(stringBuilder.toString());
        }
    }

    public C3569q(Context context, C1412c c1412c, C1531a c1531a, C1545a c1545a, C1324c c1324c) {
        super(context, c1324c, c1545a);
        this.f9533e = c1412c;
        this.f9532d = c1531a;
    }

    /* renamed from: a */
    public void m11575a(C3568p c3568p) {
        this.f9534f = c3568p;
    }

    /* renamed from: a */
    protected void mo920a(Map<String, String> map) {
        if (this.f9534f != null && !TextUtils.isEmpty(this.f9534f.mo936c())) {
            this.f9533e.mo945a(this.f9534f.mo936c(), map);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public synchronized void m11577b() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f9535g;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0029;
    L_0x0005:
        r0 = r2.f9534f;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0029;
    L_0x000a:
        r0 = 1;
        r2.f9535g = r0;	 Catch:{ all -> 0x002b }
        r0 = r2.f9532d;	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x0027;
    L_0x0011:
        r0 = r2.f9534f;	 Catch:{ all -> 0x002b }
        r0 = r0.m11566e();	 Catch:{ all -> 0x002b }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0027;
    L_0x001d:
        r0 = r2.f9532d;	 Catch:{ all -> 0x002b }
        r1 = new com.facebook.ads.internal.adapters.q$1;	 Catch:{ all -> 0x002b }
        r1.<init>(r2);	 Catch:{ all -> 0x002b }
        r0.post(r1);	 Catch:{ all -> 0x002b }
    L_0x0027:
        monitor-exit(r2);
        return;
    L_0x0029:
        monitor-exit(r2);
        return;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.q.b():void");
    }
}

package net.openid.appauth.p368a;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.support.p015c.C0098a;
import android.support.p015c.C0104b;
import android.support.p015c.C0107c.C0106a;
import android.support.p015c.C0108d;
import android.support.p015c.C0109e;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import net.openid.appauth.p370c.C6578a;
import net.openid.appauth.p370c.C6579b;

/* compiled from: CustomTabManager */
/* renamed from: net.openid.appauth.a.e */
public class C6571e {
    /* renamed from: a */
    private final WeakReference<Context> f21108a;
    /* renamed from: b */
    private final AtomicReference<C0104b> f21109b = new AtomicReference();
    /* renamed from: c */
    private final CountDownLatch f21110c = new CountDownLatch(1);
    /* renamed from: d */
    private C0108d f21111d;

    /* compiled from: CustomTabManager */
    /* renamed from: net.openid.appauth.a.e$1 */
    class C76381 extends C0108d {
        /* renamed from: a */
        final /* synthetic */ C6571e f26408a;

        C76381(C6571e c6571e) {
            this.f26408a = c6571e;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C6578a.m26803a("CustomTabsService is disconnected", new Object[0]);
            m34529a(null);
        }

        /* renamed from: a */
        public void m34530a(ComponentName componentName, C0104b c0104b) {
            C6578a.m26803a("CustomTabsService is connected", new Object[0]);
            c0104b.a(0);
            m34529a(c0104b);
        }

        /* renamed from: a */
        private void m34529a(C0104b c0104b) {
            this.f26408a.f21109b.set(c0104b);
            this.f26408a.f21110c.countDown();
        }
    }

    public C6571e(Context context) {
        this.f21108a = new WeakReference(context);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public synchronized void m26790a(java.lang.String r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f21111d;	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);
        return;
    L_0x0007:
        r0 = new net.openid.appauth.a.e$1;	 Catch:{ all -> 0x002f }
        r0.<init>(r2);	 Catch:{ all -> 0x002f }
        r2.f21111d = r0;	 Catch:{ all -> 0x002f }
        r0 = r2.f21108a;	 Catch:{ all -> 0x002f }
        r0 = r0.get();	 Catch:{ all -> 0x002f }
        r0 = (android.content.Context) r0;	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x0020;
    L_0x0018:
        r1 = r2.f21111d;	 Catch:{ all -> 0x002f }
        r3 = android.support.p015c.C0104b.a(r0, r3, r1);	 Catch:{ all -> 0x002f }
        if (r3 != 0) goto L_0x002d;
    L_0x0020:
        r3 = "Unable to bind custom tabs service";
        r0 = 0;
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x002f }
        net.openid.appauth.p370c.C6578a.m26805b(r3, r0);	 Catch:{ all -> 0x002f }
        r3 = r2.f21110c;	 Catch:{ all -> 0x002f }
        r3.countDown();	 Catch:{ all -> 0x002f }
    L_0x002d:
        monitor-exit(r2);
        return;
    L_0x002f:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.a.e.a(java.lang.String):void");
    }

    /* renamed from: a */
    public C0106a m26788a(Uri... uriArr) {
        return new C0106a(m26789a(null, uriArr));
    }

    /* renamed from: a */
    public C0109e m26789a(C0098a c0098a, Uri... uriArr) {
        C0104b a = m26787a();
        if (a == null) {
            return null;
        }
        c0098a = a.a(c0098a);
        if (c0098a == null) {
            C6578a.m26807c("Failed to create custom tabs session through custom tabs client", new Object[0]);
            return null;
        }
        if (uriArr != null && uriArr.length > 0) {
            c0098a.a(uriArr[0], null, C6579b.m26813a(uriArr, 1));
        }
        return c0098a;
    }

    /* renamed from: a */
    public android.support.p015c.C0104b m26787a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.f21110c;	 Catch:{ InterruptedException -> 0x000a }
        r1 = 1;	 Catch:{ InterruptedException -> 0x000a }
        r3 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x000a }
        r0.await(r1, r3);	 Catch:{ InterruptedException -> 0x000a }
        goto L_0x0017;
    L_0x000a:
        r0 = "Interrupted while waiting for browser connection";
        r1 = 0;
        r1 = new java.lang.Object[r1];
        net.openid.appauth.p370c.C6578a.m26805b(r0, r1);
        r0 = r4.f21110c;
        r0.countDown();
    L_0x0017:
        r0 = r4.f21109b;
        r0 = r0.get();
        r0 = (android.support.p015c.C0104b) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.a.e.a():android.support.c.b");
    }
}

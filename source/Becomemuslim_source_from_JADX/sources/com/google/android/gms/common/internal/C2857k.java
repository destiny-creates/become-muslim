package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.internal.p205d.C4956e;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.internal.k */
public final class C2857k implements Callback {
    /* renamed from: a */
    private final C2856a f7312a;
    /* renamed from: b */
    private final ArrayList<C2775b> f7313b = new ArrayList();
    /* renamed from: c */
    private final ArrayList<C2775b> f7314c = new ArrayList();
    /* renamed from: d */
    private final ArrayList<C2776c> f7315d = new ArrayList();
    /* renamed from: e */
    private volatile boolean f7316e = false;
    /* renamed from: f */
    private final AtomicInteger f7317f = new AtomicInteger(0);
    /* renamed from: g */
    private boolean f7318g = false;
    /* renamed from: h */
    private final Handler f7319h;
    /* renamed from: i */
    private final Object f7320i = new Object();

    /* renamed from: com.google.android.gms.common.internal.k$a */
    public interface C2856a {
        /* renamed from: a */
        Bundle mo2420a();

        /* renamed from: h */
        boolean mo2421h();
    }

    public C2857k(Looper looper, C2856a c2856a) {
        this.f7312a = c2856a;
        this.f7319h = new C4956e(looper, this);
    }

    /* renamed from: a */
    public final void m8344a() {
        this.f7316e = false;
        this.f7317f.incrementAndGet();
    }

    /* renamed from: b */
    public final void m8350b() {
        this.f7316e = true;
    }

    /* renamed from: a */
    public final void m8346a(Bundle bundle) {
        boolean z = true;
        C2872v.m8387a(Looper.myLooper() == this.f7319h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f7320i) {
            C2872v.m8386a(this.f7318g ^ true);
            this.f7319h.removeMessages(1);
            this.f7318g = true;
            if (this.f7314c.size() != 0) {
                z = false;
            }
            C2872v.m8386a(z);
            ArrayList arrayList = new ArrayList(this.f7313b);
            int i = this.f7317f.get();
            arrayList = arrayList;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                C2775b c2775b = (C2775b) obj;
                if (!this.f7316e || !this.f7312a.mo2421h() || this.f7317f.get() != i) {
                    break;
                } else if (!this.f7314c.contains(c2775b)) {
                    c2775b.onConnected(bundle);
                }
            }
            this.f7314c.clear();
            this.f7318g = false;
        }
    }

    /* renamed from: a */
    public final void m8345a(int i) {
        C2872v.m8387a(Looper.myLooper() == this.f7319h.getLooper(), (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f7319h.removeMessages(1);
        synchronized (this.f7320i) {
            this.f7318g = true;
            ArrayList arrayList = new ArrayList(this.f7313b);
            int i2 = this.f7317f.get();
            arrayList = arrayList;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                C2775b c2775b = (C2775b) obj;
                if (!this.f7316e || this.f7317f.get() != i2) {
                    break;
                } else if (this.f7313b.contains(c2775b)) {
                    c2775b.onConnectionSuspended(i);
                }
            }
            this.f7314c.clear();
            this.f7318g = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m8349a(com.google.android.gms.common.C4775b r8) {
        /*
        r7 = this;
        r0 = android.os.Looper.myLooper();
        r1 = r7.f7319h;
        r1 = r1.getLooper();
        r2 = 0;
        r3 = 1;
        if (r0 != r1) goto L_0x0010;
    L_0x000e:
        r0 = 1;
        goto L_0x0011;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        r1 = "onConnectionFailure must only be called on the Handler thread";
        com.google.android.gms.common.internal.C2872v.m8387a(r0, r1);
        r0 = r7.f7319h;
        r0.removeMessages(r3);
        r0 = r7.f7320i;
        monitor-enter(r0);
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0058 }
        r3 = r7.f7315d;	 Catch:{ all -> 0x0058 }
        r1.<init>(r3);	 Catch:{ all -> 0x0058 }
        r3 = r7.f7317f;	 Catch:{ all -> 0x0058 }
        r3 = r3.get();	 Catch:{ all -> 0x0058 }
        r1 = (java.util.ArrayList) r1;	 Catch:{ all -> 0x0058 }
        r4 = r1.size();	 Catch:{ all -> 0x0058 }
    L_0x0031:
        if (r2 >= r4) goto L_0x0056;
    L_0x0033:
        r5 = r1.get(r2);	 Catch:{ all -> 0x0058 }
        r2 = r2 + 1;
        r5 = (com.google.android.gms.common.api.GoogleApiClient.C2776c) r5;	 Catch:{ all -> 0x0058 }
        r6 = r7.f7316e;	 Catch:{ all -> 0x0058 }
        if (r6 == 0) goto L_0x0054;
    L_0x003f:
        r6 = r7.f7317f;	 Catch:{ all -> 0x0058 }
        r6 = r6.get();	 Catch:{ all -> 0x0058 }
        if (r6 == r3) goto L_0x0048;
    L_0x0047:
        goto L_0x0054;
    L_0x0048:
        r6 = r7.f7315d;	 Catch:{ all -> 0x0058 }
        r6 = r6.contains(r5);	 Catch:{ all -> 0x0058 }
        if (r6 == 0) goto L_0x0031;
    L_0x0050:
        r5.onConnectionFailed(r8);	 Catch:{ all -> 0x0058 }
        goto L_0x0031;
    L_0x0054:
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        return;
    L_0x0056:
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        return;
    L_0x0058:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.k.a(com.google.android.gms.common.b):void");
    }

    /* renamed from: a */
    public final void m8347a(C2775b c2775b) {
        C2872v.m8380a((Object) c2775b);
        synchronized (this.f7320i) {
            if (this.f7313b.contains(c2775b)) {
                String valueOf = String.valueOf(c2775b);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 62);
                stringBuilder.append("registerConnectionCallbacks(): listener ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" is already registered");
                Log.w("GmsClientEvents", stringBuilder.toString());
            } else {
                this.f7313b.add(c2775b);
            }
        }
        if (this.f7312a.mo2421h()) {
            this.f7319h.sendMessage(this.f7319h.obtainMessage(1, c2775b));
        }
    }

    /* renamed from: a */
    public final void m8348a(C2776c c2776c) {
        C2872v.m8380a((Object) c2776c);
        synchronized (this.f7320i) {
            if (this.f7315d.contains(c2776c)) {
                c2776c = String.valueOf(c2776c);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(c2776c).length() + 67);
                stringBuilder.append("registerConnectionFailedListener(): listener ");
                stringBuilder.append(c2776c);
                stringBuilder.append(" is already registered");
                Log.w("GmsClientEvents", stringBuilder.toString());
            } else {
                this.f7315d.add(c2776c);
            }
        }
    }

    /* renamed from: b */
    public final void m8351b(C2776c c2776c) {
        C2872v.m8380a((Object) c2776c);
        synchronized (this.f7320i) {
            if (!this.f7315d.remove(c2776c)) {
                c2776c = String.valueOf(c2776c);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(c2776c).length() + 57);
                stringBuilder.append("unregisterConnectionFailedListener(): listener ");
                stringBuilder.append(c2776c);
                stringBuilder.append(" not found");
                Log.w("GmsClientEvents", stringBuilder.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            C2775b c2775b = (C2775b) message.obj;
            synchronized (this.f7320i) {
                if (this.f7316e && this.f7312a.mo2421h() && this.f7313b.contains(c2775b)) {
                    c2775b.onConnected(this.f7312a.mo2420a());
                }
            }
            return true;
        }
        message = message.what;
        StringBuilder stringBuilder = new StringBuilder(45);
        stringBuilder.append("Don't know how to handle message: ");
        stringBuilder.append(message);
        Log.wtf("GmsClientEvents", stringBuilder.toString(), new Exception());
        return null;
    }
}

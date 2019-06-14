package io.p347a.p348a.p349a.p350a.p352b;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: TimingMetric */
/* renamed from: io.a.a.a.a.b.t */
public class C6443t {
    /* renamed from: a */
    private final String f20817a;
    /* renamed from: b */
    private final String f20818b;
    /* renamed from: c */
    private final boolean f20819c;
    /* renamed from: d */
    private long f20820d;
    /* renamed from: e */
    private long f20821e;

    public C6443t(String str, String str2) {
        this.f20817a = str;
        this.f20818b = str2;
        this.f20819c = Log.isLoggable(str2, 2) ^ 1;
    }

    /* renamed from: a */
    public synchronized void m26448a() {
        if (!this.f20819c) {
            this.f20820d = SystemClock.elapsedRealtime();
            this.f20821e = 0;
        }
    }

    /* renamed from: b */
    public synchronized void m26449b() {
        if (!this.f20819c) {
            if (this.f20821e == 0) {
                this.f20821e = SystemClock.elapsedRealtime() - this.f20820d;
                m26447c();
            }
        }
    }

    /* renamed from: c */
    private void m26447c() {
        String str = this.f20818b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f20817a);
        stringBuilder.append(": ");
        stringBuilder.append(this.f20821e);
        stringBuilder.append("ms");
        Log.v(str, stringBuilder.toString());
    }
}

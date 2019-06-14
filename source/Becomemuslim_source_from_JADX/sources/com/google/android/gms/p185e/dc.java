package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.internal.p210i.cs;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.e.dc */
final class dc implements C4397k {
    /* renamed from: a */
    private final String f13259a;
    /* renamed from: b */
    private final Context f13260b;
    /* renamed from: c */
    private final ScheduledExecutorService f13261c;
    /* renamed from: d */
    private final df f13262d;
    /* renamed from: e */
    private ScheduledFuture<?> f13263e;
    /* renamed from: f */
    private boolean f13264f;
    /* renamed from: g */
    private C2942p f13265g;
    /* renamed from: h */
    private String f13266h;
    /* renamed from: i */
    private br<cs> f13267i;

    public dc(Context context, String str, C2942p c2942p) {
        this(context, str, c2942p, null, null);
    }

    private dc(Context context, String str, C2942p c2942p, dg dgVar, df dfVar) {
        this.f13265g = c2942p;
        this.f13260b = context;
        this.f13259a = str;
        this.f13261c = new dd(this).mo2545a();
        this.f13262d = new de(this);
    }

    /* renamed from: a */
    public final synchronized void mo3299a() {
        m16875b();
        if (this.f13263e != null) {
            this.f13263e.cancel(false);
        }
        this.f13261c.shutdown();
        this.f13264f = true;
    }

    /* renamed from: a */
    public final synchronized void mo3301a(br<cs> brVar) {
        m16875b();
        this.f13267i = brVar;
    }

    /* renamed from: a */
    public final synchronized void mo3300a(long j, String str) {
        String str2 = this.f13259a;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 55);
        stringBuilder.append("loadAfterDelay: containerId=");
        stringBuilder.append(str2);
        stringBuilder.append(" delay=");
        stringBuilder.append(j);
        bs.m8588e(stringBuilder.toString());
        m16875b();
        if (this.f13267i != null) {
            if (this.f13263e != null) {
                this.f13263e.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.f13261c;
            Runnable a = this.f13262d.mo2546a(this.f13265g);
            a.m8646a(this.f13267i);
            a.m8647a(this.f13266h);
            a.m8648b(str);
            this.f13263e = scheduledExecutorService.schedule(a, j, TimeUnit.MILLISECONDS);
        } else {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
    }

    /* renamed from: a */
    public final synchronized void mo3302a(String str) {
        m16875b();
        this.f13266h = str;
    }

    /* renamed from: b */
    private final synchronized void m16875b() {
        if (this.f13264f) {
            throw new IllegalStateException("called method after closed");
        }
    }
}

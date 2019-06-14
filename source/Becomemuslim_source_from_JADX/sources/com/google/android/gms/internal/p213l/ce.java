package com.google.android.gms.internal.p213l;

import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.C2872v;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: com.google.android.gms.internal.l.ce */
final class ce<V> extends FutureTask<V> implements Comparable<ce> {
    /* renamed from: a */
    final boolean f17026a;
    /* renamed from: b */
    private final long f17027b = cb.f32347k.getAndIncrement();
    /* renamed from: c */
    private final String f17028c;
    /* renamed from: d */
    private final /* synthetic */ cb f17029d;

    ce(cb cbVar, Runnable runnable, boolean z, String str) {
        this.f17029d = cbVar;
        super(runnable, null);
        C2872v.a(str);
        this.f17028c = str;
        this.f17026a = false;
        if (this.f17027b == Clock.MAX_TIME) {
            cbVar.mo4754r().I_().m21307a("Tasks index overflow");
        }
    }

    ce(cb cbVar, Callable<V> callable, boolean z, String str) {
        this.f17029d = cbVar;
        super(callable);
        C2872v.a(str);
        this.f17028c = str;
        this.f17026a = z;
        if (this.f17027b == Clock.MAX_TIME) {
            cbVar.mo4754r().I_().m21307a("Tasks index overflow");
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        ce ceVar = (ce) obj;
        if (this.f17026a != ceVar.f17026a) {
            return this.f17026a ? -1 : 1;
        } else {
            if (this.f17027b < ceVar.f17027b) {
                return -1;
            }
            if (this.f17027b > ceVar.f17027b) {
                return 1;
            }
            this.f17029d.mo4754r().m42563g().m21308a("Two tasks share the same index. index", Long.valueOf(this.f17027b));
            return 0;
        }
    }

    protected final void setException(Throwable th) {
        this.f17029d.mo4754r().I_().m21308a(this.f17028c, th);
        if (th instanceof cc) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}

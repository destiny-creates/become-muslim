package com.google.android.gms.internal.p213l;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.internal.l.dj */
final class dj implements Callable<String> {
    /* renamed from: a */
    private final /* synthetic */ df f17101a;

    dj(df dfVar) {
        this.f17101a = dfVar;
    }

    public final /* synthetic */ Object call() {
        String h = this.f17101a.mo6214s().m42594h();
        if (h != null) {
            return h;
        }
        bd I_;
        String str;
        db f = this.f17101a.mo6742f();
        String str2 = null;
        if (f.mo4753q().m42619g()) {
            I_ = f.mo4754r().I_();
            str = "Cannot retrieve app instance id from analytics worker thread";
        } else if (C5052x.m21503a()) {
            I_ = f.mo4754r().I_();
            str = "Cannot retrieve app instance id from main thread";
        } else {
            long b = f.mo4751m().b();
            String c = f.m44111c(120000);
            long b2 = f.mo4751m().b() - b;
            str2 = (c != null || b2 >= 120000) ? c : f.m44111c(120000 - b2);
            if (str2 == null) {
                this.f17101a.mo6214s().m42589d(str2);
                return str2;
            }
            throw new TimeoutException();
        }
        I_.m21307a(str);
        if (str2 == null) {
            throw new TimeoutException();
        }
        this.f17101a.mo6214s().m42589d(str2);
        return str2;
    }
}

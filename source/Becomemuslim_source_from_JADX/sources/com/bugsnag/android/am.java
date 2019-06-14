package com.bugsnag.android;

import com.bugsnag.android.ab.C1071a;
import java.io.File;
import java.util.List;
import java.util.Map;

/* compiled from: SessionTrackingPayload */
public class am implements C1071a {
    /* renamed from: a */
    private final ag f9183a = ag.m11035a();
    /* renamed from: b */
    private final aj f9184b;
    /* renamed from: c */
    private final Map<String, Object> f9185c;
    /* renamed from: d */
    private final Map<String, Object> f9186d;
    /* renamed from: e */
    private final List<File> f9187e;

    am(aj ajVar, List<File> list, C1070a c1070a, C1099r c1099r) {
        this.f9186d = c1070a.m3701a();
        this.f9185c = c1099r.m3897a();
        this.f9184b = ajVar;
        this.f9187e = list;
    }

    public void toStream(ab abVar) {
        abVar.mo772c();
        abVar.mo764a("notifier").m11021a(this.f9183a);
        abVar.mo764a("app").m11023a(this.f9186d);
        abVar.mo764a("device").m11023a(this.f9185c);
        abVar.mo764a("sessions").mo776e();
        if (this.f9184b == null) {
            for (File a : this.f9187e) {
                abVar.m11022a(a);
            }
        } else {
            abVar.m11021a(this.f9184b);
        }
        abVar.mo775d();
        abVar.mo770b();
    }
}

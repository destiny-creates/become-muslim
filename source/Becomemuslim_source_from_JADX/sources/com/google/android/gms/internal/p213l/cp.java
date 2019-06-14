package com.google.android.gms.internal.p213l;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.l.cp */
final class cp implements Callable<List<fv>> {
    /* renamed from: a */
    private final /* synthetic */ String f17051a;
    /* renamed from: b */
    private final /* synthetic */ String f17052b;
    /* renamed from: c */
    private final /* synthetic */ String f17053c;
    /* renamed from: d */
    private final /* synthetic */ ci f17054d;

    cp(ci ciVar, String str, String str2, String str3) {
        this.f17054d = ciVar;
        this.f17051a = str;
        this.f17052b = str2;
        this.f17053c = str3;
    }

    public final /* synthetic */ Object call() {
        this.f17054d.f28974a.m32071k();
        return this.f17054d.f28974a.m32063d().m43919a(this.f17051a, this.f17052b, this.f17053c);
    }
}

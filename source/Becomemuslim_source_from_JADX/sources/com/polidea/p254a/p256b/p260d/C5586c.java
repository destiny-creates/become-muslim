package com.polidea.p254a.p256b.p260d;

import com.polidea.p254a.p263c.C5619b;

/* compiled from: EmulatedScanFilterMatcher */
/* renamed from: com.polidea.a.b.d.c */
public class C5586c {
    /* renamed from: a */
    private final C5619b[] f18699a;

    public C5586c(C5619b... c5619bArr) {
        this.f18699a = c5619bArr;
    }

    /* renamed from: a */
    public boolean m23775a(C5588h c5588h) {
        if (this.f18699a != null) {
            if (this.f18699a.length != 0) {
                for (C5619b a : this.f18699a) {
                    if (a.m23891a(c5588h)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }
}

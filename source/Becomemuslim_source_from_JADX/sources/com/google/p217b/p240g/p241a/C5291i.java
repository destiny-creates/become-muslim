package com.google.p217b.p240g.p241a;

import com.google.p217b.C5316s;

/* compiled from: QRCodeDecoderMetaData */
/* renamed from: com.google.b.g.a.i */
public final class C5291i {
    /* renamed from: a */
    private final boolean f17875a;

    C5291i(boolean z) {
        this.f17875a = z;
    }

    /* renamed from: a */
    public void m22448a(C5316s[] c5316sArr) {
        if (this.f17875a && c5316sArr != null) {
            if (c5316sArr.length >= 3) {
                C5316s c5316s = c5316sArr[0];
                c5316sArr[0] = c5316sArr[2];
                c5316sArr[2] = c5316s;
            }
        }
    }
}

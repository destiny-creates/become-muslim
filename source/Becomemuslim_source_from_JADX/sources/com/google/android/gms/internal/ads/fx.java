package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.C2868t;

@cm
public final class fx extends gd {
    /* renamed from: a */
    private final String f28655a;
    /* renamed from: b */
    private final int f28656b;

    public fx(String str, int i) {
        this.f28655a = str;
        this.f28656b = i;
    }

    /* renamed from: a */
    public final String mo4247a() {
        return this.f28655a;
    }

    /* renamed from: b */
    public final int mo4248b() {
        return this.f28656b;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof fx) {
                fx fxVar = (fx) obj;
                if (C2868t.a(this.f28655a, fxVar.f28655a) && C2868t.a(Integer.valueOf(this.f28656b), Integer.valueOf(fxVar.f28656b))) {
                    return true;
                }
            }
        }
        return false;
    }
}

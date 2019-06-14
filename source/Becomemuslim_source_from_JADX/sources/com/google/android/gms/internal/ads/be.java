package com.google.android.gms.internal.ads;

import java.util.List;

final class be implements mz<List<att>, atp> {
    /* renamed from: a */
    private final /* synthetic */ String f23960a;
    /* renamed from: b */
    private final /* synthetic */ Integer f23961b;
    /* renamed from: c */
    private final /* synthetic */ Integer f23962c;
    /* renamed from: d */
    private final /* synthetic */ int f23963d;
    /* renamed from: e */
    private final /* synthetic */ int f23964e;
    /* renamed from: f */
    private final /* synthetic */ int f23965f;
    /* renamed from: g */
    private final /* synthetic */ int f23966g;
    /* renamed from: h */
    private final /* synthetic */ boolean f23967h;

    be(ay ayVar, String str, Integer num, Integer num2, int i, int i2, int i3, int i4, boolean z) {
        this.f23960a = str;
        this.f23961b = num;
        this.f23962c = num2;
        this.f23963d = i;
        this.f23964e = i2;
        this.f23965f = i3;
        this.f23966g = i4;
        this.f23967h = z;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4206a(Object obj) {
        List list = (List) obj;
        Integer num = null;
        if (list != null) {
            if (!list.isEmpty()) {
                String str = this.f23960a;
                Integer num2 = this.f23961b;
                Integer num3 = this.f23962c;
                if (this.f23963d > 0) {
                    num = Integer.valueOf(this.f23963d);
                }
                return new atp(str, list, num2, num3, num, this.f23964e + this.f23965f, this.f23966g, this.f23967h);
            }
        }
        return null;
    }
}

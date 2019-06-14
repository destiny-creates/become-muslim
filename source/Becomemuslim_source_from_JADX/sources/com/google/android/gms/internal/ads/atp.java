package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

@cm
public final class atp extends ava {
    /* renamed from: a */
    private static final int f28309a = Color.rgb(12, 174, 206);
    /* renamed from: b */
    private static final int f28310b;
    /* renamed from: c */
    private static final int f28311c;
    /* renamed from: d */
    private static final int f28312d = f28309a;
    /* renamed from: e */
    private final String f28313e;
    /* renamed from: f */
    private final List<att> f28314f = new ArrayList();
    /* renamed from: g */
    private final List<avd> f28315g = new ArrayList();
    /* renamed from: h */
    private final int f28316h;
    /* renamed from: i */
    private final int f28317i;
    /* renamed from: j */
    private final int f28318j;
    /* renamed from: k */
    private final int f28319k;
    /* renamed from: l */
    private final int f28320l;
    /* renamed from: m */
    private final boolean f28321m;

    static {
        int rgb = Color.rgb(204, 204, 204);
        f28310b = rgb;
        f28311c = rgb;
    }

    public atp(String str, List<att> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.f28313e = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                att att = (att) list.get(i3);
                this.f28314f.add(att);
                this.f28315g.add(att);
            }
        }
        this.f28316h = num != null ? num.intValue() : f28311c;
        this.f28317i = num2 != null ? num2.intValue() : f28312d;
        this.f28318j = num3 != null ? num3.intValue() : 12;
        this.f28319k = i;
        this.f28320l = i2;
        this.f28321m = z;
    }

    /* renamed from: a */
    public final String mo3994a() {
        return this.f28313e;
    }

    /* renamed from: b */
    public final List<avd> mo3995b() {
        return this.f28315g;
    }

    /* renamed from: c */
    public final List<att> m37020c() {
        return this.f28314f;
    }

    /* renamed from: d */
    public final int m37021d() {
        return this.f28316h;
    }

    /* renamed from: e */
    public final int m37022e() {
        return this.f28317i;
    }

    /* renamed from: f */
    public final int m37023f() {
        return this.f28318j;
    }

    /* renamed from: g */
    public final int m37024g() {
        return this.f28319k;
    }

    /* renamed from: h */
    public final int m37025h() {
        return this.f28320l;
    }

    /* renamed from: i */
    public final boolean m37026i() {
        return this.f28321m;
    }
}

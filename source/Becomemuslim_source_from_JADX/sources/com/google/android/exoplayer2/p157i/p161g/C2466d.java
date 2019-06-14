package com.google.android.exoplayer2.p157i.p161g;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: WebvttCssStyle */
/* renamed from: com.google.android.exoplayer2.i.g.d */
public final class C2466d {
    /* renamed from: a */
    private String f6256a;
    /* renamed from: b */
    private String f6257b;
    /* renamed from: c */
    private List<String> f6258c;
    /* renamed from: d */
    private String f6259d;
    /* renamed from: e */
    private String f6260e;
    /* renamed from: f */
    private int f6261f;
    /* renamed from: g */
    private boolean f6262g;
    /* renamed from: h */
    private int f6263h;
    /* renamed from: i */
    private boolean f6264i;
    /* renamed from: j */
    private int f6265j;
    /* renamed from: k */
    private int f6266k;
    /* renamed from: l */
    private int f6267l;
    /* renamed from: m */
    private int f6268m;
    /* renamed from: n */
    private int f6269n;
    /* renamed from: o */
    private float f6270o;
    /* renamed from: p */
    private Alignment f6271p;

    public C2466d() {
        m6854a();
    }

    /* renamed from: a */
    public void m6854a() {
        this.f6256a = "";
        this.f6257b = "";
        this.f6258c = Collections.emptyList();
        this.f6259d = "";
        this.f6260e = null;
        this.f6262g = false;
        this.f6264i = false;
        this.f6265j = -1;
        this.f6266k = -1;
        this.f6267l = -1;
        this.f6268m = -1;
        this.f6269n = -1;
        this.f6271p = null;
    }

    /* renamed from: a */
    public void m6855a(String str) {
        this.f6256a = str;
    }

    /* renamed from: b */
    public void m6860b(String str) {
        this.f6257b = str;
    }

    /* renamed from: a */
    public void m6856a(String[] strArr) {
        this.f6258c = Arrays.asList(strArr);
    }

    /* renamed from: c */
    public void m6862c(String str) {
        this.f6259d = str;
    }

    /* renamed from: a */
    public int m6851a(String str, String str2, String[] strArr, String str3) {
        if (this.f6256a.isEmpty() && this.f6257b.isEmpty() && this.f6258c.isEmpty() && this.f6259d.isEmpty()) {
            return str2.isEmpty();
        }
        str = C2466d.m6850a(C2466d.m6850a(C2466d.m6850a(0, this.f6256a, str, 1073741824), this.f6257b, str2, 2), this.f6259d, str3, 4);
        if (str != -1) {
            if (Arrays.asList(strArr).containsAll(this.f6258c) != null) {
                return str + (this.f6258c.size() * 4);
            }
        }
        return 0;
    }

    /* renamed from: b */
    public int m6857b() {
        if (this.f6267l == -1 && this.f6268m == -1) {
            return -1;
        }
        int i = 0;
        int i2 = this.f6267l == 1 ? 1 : 0;
        if (this.f6268m == 1) {
            i = 2;
        }
        return i2 | i;
    }

    /* renamed from: c */
    public boolean m6863c() {
        return this.f6265j == 1;
    }

    /* renamed from: d */
    public boolean m6865d() {
        return this.f6266k == 1;
    }

    /* renamed from: a */
    public C2466d m6853a(boolean z) {
        this.f6266k = z;
        return this;
    }

    /* renamed from: b */
    public C2466d m6859b(boolean z) {
        this.f6267l = z;
        return this;
    }

    /* renamed from: c */
    public C2466d m6861c(boolean z) {
        this.f6268m = z;
        return this;
    }

    /* renamed from: e */
    public String m6866e() {
        return this.f6260e;
    }

    /* renamed from: d */
    public C2466d m6864d(String str) {
        this.f6260e = C2541v.m7190d(str);
        return this;
    }

    /* renamed from: f */
    public int m6867f() {
        if (this.f6262g) {
            return this.f6261f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    /* renamed from: a */
    public C2466d m6852a(int i) {
        this.f6261f = i;
        this.f6262g = true;
        return this;
    }

    /* renamed from: g */
    public boolean m6868g() {
        return this.f6262g;
    }

    /* renamed from: h */
    public int m6869h() {
        if (this.f6264i) {
            return this.f6263h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    /* renamed from: b */
    public C2466d m6858b(int i) {
        this.f6263h = i;
        this.f6264i = true;
        return this;
    }

    /* renamed from: i */
    public boolean m6870i() {
        return this.f6264i;
    }

    /* renamed from: j */
    public Alignment m6871j() {
        return this.f6271p;
    }

    /* renamed from: k */
    public int m6872k() {
        return this.f6269n;
    }

    /* renamed from: l */
    public float m6873l() {
        return this.f6270o;
    }

    /* renamed from: a */
    private static int m6850a(int i, String str, String str2, int i2) {
        if (!str.isEmpty()) {
            int i3 = -1;
            if (i != -1) {
                if (str.equals(str2) != null) {
                    i3 = i + i2;
                }
                return i3;
            }
        }
        return i;
    }
}

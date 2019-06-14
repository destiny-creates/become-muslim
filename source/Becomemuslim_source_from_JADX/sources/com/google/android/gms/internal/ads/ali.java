package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;

@cm
public final class ali {
    /* renamed from: a */
    private final int f14674a;
    /* renamed from: b */
    private final int f14675b;
    /* renamed from: c */
    private final int f14676c;
    /* renamed from: d */
    private final alv f14677d;
    /* renamed from: e */
    private final amf f14678e;
    /* renamed from: f */
    private final Object f14679f = new Object();
    /* renamed from: g */
    private ArrayList<String> f14680g = new ArrayList();
    /* renamed from: h */
    private ArrayList<String> f14681h = new ArrayList();
    /* renamed from: i */
    private ArrayList<alt> f14682i = new ArrayList();
    /* renamed from: j */
    private int f14683j = 0;
    /* renamed from: k */
    private int f14684k = 0;
    /* renamed from: l */
    private int f14685l = 0;
    /* renamed from: m */
    private int f14686m;
    /* renamed from: n */
    private String f14687n = "";
    /* renamed from: o */
    private String f14688o = "";
    /* renamed from: p */
    private String f14689p = "";

    public ali(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f14674a = i;
        this.f14675b = i2;
        this.f14676c = i3;
        this.f14677d = new alv(i4);
        this.f14678e = new amf(i5, i6, i7);
    }

    /* renamed from: a */
    private static String m18565a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            stringBuilder.append((String) obj);
            stringBuilder.append(' ');
            if (stringBuilder.length() > 100) {
                break;
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String stringBuilder2 = stringBuilder.toString();
        return stringBuilder2.length() < 100 ? stringBuilder2 : stringBuilder2.substring(0, 100);
    }

    /* renamed from: c */
    private final void m18566c(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null) {
            if (str.length() >= this.f14676c) {
                synchronized (this.f14679f) {
                    this.f14680g.add(str);
                    this.f14683j += str.length();
                    if (z) {
                        this.f14681h.add(str);
                        this.f14682i.add(new alt(f, f2, f3, f4, this.f14681h.size() - 1));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m18567a(int i) {
        this.f14684k = i;
    }

    /* renamed from: a */
    public final void m18568a(String str, boolean z, float f, float f2, float f3, float f4) {
        m18566c(str, z, f, f2, f3, f4);
        synchronized (this.f14679f) {
            if (this.f14685l < 0) {
                mt.m19918b("ActivityContent: negative number of WebViews.");
            }
            m18577h();
        }
    }

    /* renamed from: a */
    public final boolean m18569a() {
        boolean z;
        synchronized (this.f14679f) {
            z = this.f14685l == 0;
        }
        return z;
    }

    /* renamed from: b */
    public final String m18570b() {
        return this.f14687n;
    }

    /* renamed from: b */
    public final void m18571b(String str, boolean z, float f, float f2, float f3, float f4) {
        m18566c(str, z, f, f2, f3, f4);
    }

    /* renamed from: c */
    public final String m18572c() {
        return this.f14688o;
    }

    /* renamed from: d */
    public final String m18573d() {
        return this.f14689p;
    }

    /* renamed from: e */
    public final void m18574e() {
        synchronized (this.f14679f) {
            this.f14686m -= 100;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ali)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ali ali = (ali) obj;
        return ali.f14687n != null && ali.f14687n.equals(this.f14687n);
    }

    /* renamed from: f */
    public final void m18575f() {
        synchronized (this.f14679f) {
            this.f14685l--;
        }
    }

    /* renamed from: g */
    public final void m18576g() {
        synchronized (this.f14679f) {
            this.f14685l++;
        }
    }

    /* renamed from: h */
    public final void m18577h() {
        synchronized (this.f14679f) {
            int i = (this.f14683j * this.f14674a) + (this.f14684k * this.f14675b);
            if (i > this.f14686m) {
                this.f14686m = i;
                if (((Boolean) aph.m18688f().m18889a(asp.f14932W)).booleanValue() && !ax.i().m30847l().m19659b()) {
                    this.f14687n = this.f14677d.m18616a(this.f14680g);
                    this.f14688o = this.f14677d.m18616a(this.f14681h);
                }
                if (((Boolean) aph.m18688f().m18889a(asp.f14934Y)).booleanValue() && !ax.i().m30847l().m19665d()) {
                    this.f14689p = this.f14678e.m18628a(this.f14681h, this.f14682i);
                }
            }
        }
    }

    public final int hashCode() {
        return this.f14687n.hashCode();
    }

    /* renamed from: i */
    public final int m18578i() {
        return this.f14686m;
    }

    /* renamed from: j */
    final int m18579j() {
        return this.f14683j;
    }

    public final String toString() {
        int i = this.f14684k;
        int i2 = this.f14686m;
        int i3 = this.f14683j;
        String a = m18565a(this.f14680g, 100);
        String a2 = m18565a(this.f14681h, 100);
        String str = this.f14687n;
        String str2 = this.f14688o;
        String str3 = this.f14689p;
        StringBuilder stringBuilder = new StringBuilder(((((String.valueOf(a).length() + 165) + String.valueOf(a2).length()) + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length());
        stringBuilder.append("ActivityContent fetchId: ");
        stringBuilder.append(i);
        stringBuilder.append(" score:");
        stringBuilder.append(i2);
        stringBuilder.append(" total_length:");
        stringBuilder.append(i3);
        stringBuilder.append("\n text: ");
        stringBuilder.append(a);
        stringBuilder.append("\n viewableText");
        stringBuilder.append(a2);
        stringBuilder.append("\n signture: ");
        stringBuilder.append(str);
        stringBuilder.append("\n viewableSignture: ");
        stringBuilder.append(str2);
        stringBuilder.append("\n viewableSignatureForVertical: ");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }
}

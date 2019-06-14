package com.google.android.p133a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.C0464m;

/* compiled from: AspectRatio */
/* renamed from: com.google.android.a.a */
public class C2186a implements Parcelable, Comparable<C2186a> {
    public static final Creator<C2186a> CREATOR = new C21851();
    /* renamed from: a */
    private static final C0464m<C0464m<C2186a>> f5225a = new C0464m(16);
    /* renamed from: b */
    private final int f5226b;
    /* renamed from: c */
    private final int f5227c;

    /* compiled from: AspectRatio */
    /* renamed from: com.google.android.a.a$1 */
    static class C21851 implements Creator<C2186a> {
        C21851() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6020a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6021a(i);
        }

        /* renamed from: a */
        public C2186a m6020a(Parcel parcel) {
            return C2186a.m6022a(parcel.readInt(), parcel.readInt());
        }

        /* renamed from: a */
        public C2186a[] m6021a(int i) {
            return new C2186a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m6026a((C2186a) obj);
    }

    /* renamed from: a */
    public static C2186a m6022a(int i, int i2) {
        int b = C2186a.m6024b(i, i2);
        i /= b;
        i2 /= b;
        C0464m c0464m = (C0464m) f5225a.m1467a(i);
        if (c0464m == null) {
            C2186a c2186a = new C2186a(i, i2);
            C0464m c0464m2 = new C0464m();
            c0464m2.m1471b(i2, c2186a);
            f5225a.m1471b(i, c0464m2);
            return c2186a;
        }
        C2186a c2186a2 = (C2186a) c0464m.m1467a(i2);
        if (c2186a2 == null) {
            c2186a2 = new C2186a(i, i2);
            c0464m.m1471b(i2, c2186a2);
        }
        return c2186a2;
    }

    /* renamed from: a */
    public static C2186a m6023a(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            try {
                return C2186a.m6022a(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed aspect ratio: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString(), e);
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Malformed aspect ratio: ");
        stringBuilder2.append(str);
        throw new IllegalArgumentException(stringBuilder2.toString());
    }

    private C2186a(int i, int i2) {
        this.f5226b = i;
        this.f5227c = i2;
    }

    /* renamed from: a */
    public int m6025a() {
        return this.f5226b;
    }

    /* renamed from: b */
    public int m6028b() {
        return this.f5227c;
    }

    /* renamed from: a */
    public boolean m6027a(C2210k c2210k) {
        int b = C2186a.m6024b(c2210k.m6098a(), c2210k.m6100b());
        return (this.f5226b == c2210k.m6098a() / b && this.f5227c == c2210k.m6100b() / b) ? true : null;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2186a)) {
            return false;
        }
        C2186a c2186a = (C2186a) obj;
        if (this.f5226b == c2186a.f5226b && this.f5227c == c2186a.f5227c) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f5226b);
        stringBuilder.append(":");
        stringBuilder.append(this.f5227c);
        return stringBuilder.toString();
    }

    /* renamed from: c */
    public float m6029c() {
        return ((float) this.f5226b) / ((float) this.f5227c);
    }

    public int hashCode() {
        return this.f5227c ^ ((this.f5226b << 16) | (this.f5226b >>> 16));
    }

    /* renamed from: a */
    public int m6026a(C2186a c2186a) {
        if (equals(c2186a)) {
            return null;
        }
        return m6029c() - c2186a.m6029c() > null ? 1 : -1;
    }

    /* renamed from: d */
    public C2186a m6030d() {
        return C2186a.m6022a(this.f5227c, this.f5226b);
    }

    /* renamed from: b */
    private static int m6024b(int i, int i2) {
        while (true) {
            int i3 = i2;
            i2 = i;
            i = i3;
            if (i == 0) {
                return i2;
            }
            i2 %= i;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5226b);
        parcel.writeInt(this.f5227c);
    }
}

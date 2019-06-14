package com.google.android.p133a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: Size */
/* renamed from: com.google.android.a.k */
public class C2210k implements Parcelable, Comparable<C2210k> {
    public static final Creator<C2210k> CREATOR = new C22091();
    /* renamed from: a */
    private final int f5258a;
    /* renamed from: b */
    private final int f5259b;

    /* compiled from: Size */
    /* renamed from: com.google.android.a.k$1 */
    static class C22091 implements Creator<C2210k> {
        C22091() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6095a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6096a(i);
        }

        /* renamed from: a */
        public C2210k m6095a(Parcel parcel) {
            return new C2210k(parcel.readInt(), parcel.readInt());
        }

        /* renamed from: a */
        public C2210k[] m6096a(int i) {
            return new C2210k[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m6099a((C2210k) obj);
    }

    public C2210k(int i, int i2) {
        this.f5258a = i;
        this.f5259b = i2;
    }

    /* renamed from: a */
    public static C2210k m6097a(String str) {
        int indexOf = str.indexOf(120);
        if (indexOf != -1) {
            try {
                return new C2210k(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed size: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString(), e);
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Malformed size: ");
        stringBuilder2.append(str);
        throw new IllegalArgumentException(stringBuilder2.toString());
    }

    /* renamed from: a */
    public int m6098a() {
        return this.f5258a;
    }

    /* renamed from: b */
    public int m6100b() {
        return this.f5259b;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2210k)) {
            return false;
        }
        C2210k c2210k = (C2210k) obj;
        if (this.f5258a == c2210k.f5258a && this.f5259b == c2210k.f5259b) {
            z = true;
        }
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f5258a);
        stringBuilder.append("x");
        stringBuilder.append(this.f5259b);
        return stringBuilder.toString();
    }

    public int hashCode() {
        return this.f5259b ^ ((this.f5258a << 16) | (this.f5258a >>> 16));
    }

    /* renamed from: a */
    public int m6099a(C2210k c2210k) {
        return (this.f5258a * this.f5259b) - (c2210k.f5258a * c2210k.f5259b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5258a);
        parcel.writeInt(this.f5259b);
    }
}

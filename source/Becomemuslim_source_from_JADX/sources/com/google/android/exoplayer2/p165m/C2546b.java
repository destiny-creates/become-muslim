package com.google.android.exoplayer2.p165m;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

/* compiled from: ColorInfo */
/* renamed from: com.google.android.exoplayer2.m.b */
public final class C2546b implements Parcelable {
    public static final Creator<C2546b> CREATOR = new C25451();
    /* renamed from: a */
    public final int f6482a;
    /* renamed from: b */
    public final int f6483b;
    /* renamed from: c */
    public final int f6484c;
    /* renamed from: d */
    public final byte[] f6485d;
    /* renamed from: e */
    private int f6486e;

    /* compiled from: ColorInfo */
    /* renamed from: com.google.android.exoplayer2.m.b$1 */
    static class C25451 implements Creator<C2546b> {
        C25451() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m7203a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m7204a(i);
        }

        /* renamed from: a */
        public C2546b m7203a(Parcel parcel) {
            return new C2546b(parcel);
        }

        /* renamed from: a */
        public C2546b[] m7204a(int i) {
            return new C2546b[0];
        }
    }

    public int describeContents() {
        return 0;
    }

    public C2546b(int i, int i2, int i3, byte[] bArr) {
        this.f6482a = i;
        this.f6483b = i2;
        this.f6484c = i3;
        this.f6485d = bArr;
    }

    C2546b(Parcel parcel) {
        this.f6482a = parcel.readInt();
        this.f6483b = parcel.readInt();
        this.f6484c = parcel.readInt();
        this.f6485d = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C2546b c2546b = (C2546b) obj;
                if (this.f6482a == c2546b.f6482a && this.f6483b == c2546b.f6483b && this.f6484c == c2546b.f6484c) {
                    if (Arrays.equals(this.f6485d, c2546b.f6485d) != null) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ColorInfo(");
        stringBuilder.append(this.f6482a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6483b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6484c);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6485d != null);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public int hashCode() {
        if (this.f6486e == 0) {
            this.f6486e = ((((((527 + this.f6482a) * 31) + this.f6483b) * 31) + this.f6484c) * 31) + Arrays.hashCode(this.f6485d);
        }
        return this.f6486e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6482a);
        parcel.writeInt(this.f6483b);
        parcel.writeInt(this.f6484c);
        parcel.writeInt(this.f6485d != 0 ? 1 : 0);
        if (this.f6485d != 0) {
            parcel.writeByteArray(this.f6485d);
        }
    }
}

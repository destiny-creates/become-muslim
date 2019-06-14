package com.google.android.exoplayer2.p145g.p147b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Arrays;

/* compiled from: ApicFrame */
/* renamed from: com.google.android.exoplayer2.g.b.a */
public final class C4695a extends C4163h {
    public static final Creator<C4695a> CREATOR = new C23451();
    /* renamed from: a */
    public final String f12680a;
    /* renamed from: b */
    public final String f12681b;
    /* renamed from: c */
    public final int f12682c;
    /* renamed from: d */
    public final byte[] f12683d;

    /* compiled from: ApicFrame */
    /* renamed from: com.google.android.exoplayer2.g.b.a$1 */
    static class C23451 implements Creator<C4695a> {
        C23451() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6506a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6507a(i);
        }

        /* renamed from: a */
        public C4695a m6506a(Parcel parcel) {
            return new C4695a(parcel);
        }

        /* renamed from: a */
        public C4695a[] m6507a(int i) {
            return new C4695a[i];
        }
    }

    public C4695a(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.f12680a = str;
        this.f12681b = str2;
        this.f12682c = i;
        this.f12683d = bArr;
    }

    C4695a(Parcel parcel) {
        super("APIC");
        this.f12680a = parcel.readString();
        this.f12681b = parcel.readString();
        this.f12682c = parcel.readInt();
        this.f12683d = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4695a c4695a = (C4695a) obj;
                if (this.f12682c != c4695a.f12682c || !C2541v.m7179a(this.f12680a, c4695a.f12680a) || !C2541v.m7179a(this.f12681b, c4695a.f12681b) || Arrays.equals(this.f12683d, c4695a.f12683d) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((527 + this.f12682c) * 31) + (this.f12680a != null ? this.f12680a.hashCode() : 0)) * 31;
        if (this.f12681b != null) {
            i = this.f12681b.hashCode();
        }
        return ((hashCode + i) * 31) + Arrays.hashCode(this.f12683d);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12680a);
        parcel.writeString(this.f12681b);
        parcel.writeInt(this.f12682c);
        parcel.writeByteArray(this.f12683d);
    }
}

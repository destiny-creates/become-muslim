package com.google.android.exoplayer2.p145g.p146a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p145g.C2344a.C2342a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Arrays;

/* compiled from: EventMessage */
/* renamed from: com.google.android.exoplayer2.g.a.a */
public final class C4160a implements C2342a {
    public static final Creator<C4160a> CREATOR = new C23431();
    /* renamed from: a */
    public final String f10790a;
    /* renamed from: b */
    public final String f10791b;
    /* renamed from: c */
    public final long f10792c;
    /* renamed from: d */
    public final long f10793d;
    /* renamed from: e */
    public final byte[] f10794e;
    /* renamed from: f */
    private int f10795f;

    /* compiled from: EventMessage */
    /* renamed from: com.google.android.exoplayer2.g.a.a$1 */
    static class C23431 implements Creator<C4160a> {
        C23431() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6502a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6503a(i);
        }

        /* renamed from: a */
        public C4160a m6502a(Parcel parcel) {
            return new C4160a(parcel);
        }

        /* renamed from: a */
        public C4160a[] m6503a(int i) {
            return new C4160a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public C4160a(String str, String str2, long j, long j2, byte[] bArr) {
        this.f10790a = str;
        this.f10791b = str2;
        this.f10792c = j;
        this.f10793d = j2;
        this.f10794e = bArr;
    }

    C4160a(Parcel parcel) {
        this.f10790a = parcel.readString();
        this.f10791b = parcel.readString();
        this.f10792c = parcel.readLong();
        this.f10793d = parcel.readLong();
        this.f10794e = parcel.createByteArray();
    }

    public int hashCode() {
        if (this.f10795f == 0) {
            int i = 0;
            int hashCode = (527 + (this.f10790a != null ? this.f10790a.hashCode() : 0)) * 31;
            if (this.f10791b != null) {
                i = this.f10791b.hashCode();
            }
            this.f10795f = ((((((hashCode + i) * 31) + ((int) (this.f10792c ^ (this.f10792c >>> 32)))) * 31) + ((int) (this.f10793d ^ (this.f10793d >>> 32)))) * 31) + Arrays.hashCode(this.f10794e);
        }
        return this.f10795f;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4160a c4160a = (C4160a) obj;
                if (this.f10792c != c4160a.f10792c || this.f10793d != c4160a.f10793d || !C2541v.m7179a(this.f10790a, c4160a.f10790a) || !C2541v.m7179a(this.f10791b, c4160a.f10791b) || Arrays.equals(this.f10794e, c4160a.f10794e) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10790a);
        parcel.writeString(this.f10791b);
        parcel.writeLong(this.f10792c);
        parcel.writeLong(this.f10793d);
        parcel.writeByteArray(this.f10794e);
    }
}

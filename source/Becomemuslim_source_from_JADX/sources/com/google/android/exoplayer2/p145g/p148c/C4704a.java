package com.google.android.exoplayer2.p145g.p148c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2529l;

/* compiled from: PrivateCommand */
/* renamed from: com.google.android.exoplayer2.g.c.a */
public final class C4704a extends C4164b {
    public static final Creator<C4704a> CREATOR = new C23571();
    /* renamed from: a */
    public final long f12709a;
    /* renamed from: b */
    public final long f12710b;
    /* renamed from: c */
    public final byte[] f12711c;

    /* compiled from: PrivateCommand */
    /* renamed from: com.google.android.exoplayer2.g.c.a$1 */
    static class C23571 implements Creator<C4704a> {
        C23571() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6529a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6530a(i);
        }

        /* renamed from: a */
        public C4704a m6529a(Parcel parcel) {
            return new C4704a(parcel);
        }

        /* renamed from: a */
        public C4704a[] m6530a(int i) {
            return new C4704a[i];
        }
    }

    private C4704a(long j, byte[] bArr, long j2) {
        this.f12709a = j2;
        this.f12710b = j;
        this.f12711c = bArr;
    }

    private C4704a(Parcel parcel) {
        this.f12709a = parcel.readLong();
        this.f12710b = parcel.readLong();
        this.f12711c = new byte[parcel.readInt()];
        parcel.readByteArray(this.f12711c);
    }

    /* renamed from: a */
    static C4704a m16051a(C2529l c2529l, int i, long j) {
        long m = c2529l.m7109m();
        byte[] bArr = new byte[(i - 4)];
        c2529l.m7092a(bArr, 0, bArr.length);
        return new C4704a(m, bArr, j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12709a);
        parcel.writeLong(this.f12710b);
        parcel.writeInt(this.f12711c.length);
        parcel.writeByteArray(this.f12711c);
    }
}

package com.google.android.exoplayer2.p145g.p147b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Arrays;

/* compiled from: GeobFrame */
/* renamed from: com.google.android.exoplayer2.g.b.f */
public final class C4700f extends C4163h {
    public static final Creator<C4700f> CREATOR = new C23501();
    /* renamed from: a */
    public final String f12699a;
    /* renamed from: b */
    public final String f12700b;
    /* renamed from: c */
    public final String f12701c;
    /* renamed from: d */
    public final byte[] f12702d;

    /* compiled from: GeobFrame */
    /* renamed from: com.google.android.exoplayer2.g.b.f$1 */
    static class C23501 implements Creator<C4700f> {
        C23501() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6516a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6517a(i);
        }

        /* renamed from: a */
        public C4700f m6516a(Parcel parcel) {
            return new C4700f(parcel);
        }

        /* renamed from: a */
        public C4700f[] m6517a(int i) {
            return new C4700f[i];
        }
    }

    public C4700f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f12699a = str;
        this.f12700b = str2;
        this.f12701c = str3;
        this.f12702d = bArr;
    }

    C4700f(Parcel parcel) {
        super("GEOB");
        this.f12699a = parcel.readString();
        this.f12700b = parcel.readString();
        this.f12701c = parcel.readString();
        this.f12702d = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4700f c4700f = (C4700f) obj;
                if (!C2541v.m7179a(this.f12699a, c4700f.f12699a) || !C2541v.m7179a(this.f12700b, c4700f.f12700b) || !C2541v.m7179a(this.f12701c, c4700f.f12701c) || Arrays.equals(this.f12702d, c4700f.f12702d) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((527 + (this.f12699a != null ? this.f12699a.hashCode() : 0)) * 31) + (this.f12700b != null ? this.f12700b.hashCode() : 0)) * 31;
        if (this.f12701c != null) {
            i = this.f12701c.hashCode();
        }
        return ((hashCode + i) * 31) + Arrays.hashCode(this.f12702d);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12699a);
        parcel.writeString(this.f12700b);
        parcel.writeString(this.f12701c);
        parcel.writeByteArray(this.f12702d);
    }
}

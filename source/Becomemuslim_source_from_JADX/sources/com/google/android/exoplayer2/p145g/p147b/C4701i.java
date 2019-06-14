package com.google.android.exoplayer2.p145g.p147b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Arrays;

/* compiled from: PrivFrame */
/* renamed from: com.google.android.exoplayer2.g.b.i */
public final class C4701i extends C4163h {
    public static final Creator<C4701i> CREATOR = new C23531();
    /* renamed from: a */
    public final String f12703a;
    /* renamed from: b */
    public final byte[] f12704b;

    /* compiled from: PrivFrame */
    /* renamed from: com.google.android.exoplayer2.g.b.i$1 */
    static class C23531 implements Creator<C4701i> {
        C23531() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6522a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6523a(i);
        }

        /* renamed from: a */
        public C4701i m6522a(Parcel parcel) {
            return new C4701i(parcel);
        }

        /* renamed from: a */
        public C4701i[] m6523a(int i) {
            return new C4701i[i];
        }
    }

    public C4701i(String str, byte[] bArr) {
        super("PRIV");
        this.f12703a = str;
        this.f12704b = bArr;
    }

    C4701i(Parcel parcel) {
        super("PRIV");
        this.f12703a = parcel.readString();
        this.f12704b = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4701i c4701i = (C4701i) obj;
                if (!C2541v.m7179a(this.f12703a, c4701i.f12703a) || Arrays.equals(this.f12704b, c4701i.f12704b) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + (this.f12703a != null ? this.f12703a.hashCode() : 0)) * 31) + Arrays.hashCode(this.f12704b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12703a);
        parcel.writeByteArray(this.f12704b);
    }
}

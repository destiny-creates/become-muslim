package com.google.android.exoplayer2.p145g.p147b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

/* compiled from: BinaryFrame */
/* renamed from: com.google.android.exoplayer2.g.b.b */
public final class C4696b extends C4163h {
    public static final Creator<C4696b> CREATOR = new C23461();
    /* renamed from: a */
    public final byte[] f12684a;

    /* compiled from: BinaryFrame */
    /* renamed from: com.google.android.exoplayer2.g.b.b$1 */
    static class C23461 implements Creator<C4696b> {
        C23461() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6508a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6509a(i);
        }

        /* renamed from: a */
        public C4696b m6508a(Parcel parcel) {
            return new C4696b(parcel);
        }

        /* renamed from: a */
        public C4696b[] m6509a(int i) {
            return new C4696b[i];
        }
    }

    public C4696b(String str, byte[] bArr) {
        super(str);
        this.f12684a = bArr;
    }

    C4696b(Parcel parcel) {
        super(parcel.readString());
        this.f12684a = parcel.createByteArray();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4696b c4696b = (C4696b) obj;
                if (!this.f.equals(c4696b.f) || Arrays.equals(this.f12684a, c4696b.f12684a) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f.hashCode()) * 31) + Arrays.hashCode(this.f12684a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeByteArray(this.f12684a);
    }
}

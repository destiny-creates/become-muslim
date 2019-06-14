package com.google.android.exoplayer2.p145g.p147b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: UrlLinkFrame */
/* renamed from: com.google.android.exoplayer2.g.b.k */
public final class C4703k extends C4163h {
    public static final Creator<C4703k> CREATOR = new C23551();
    /* renamed from: a */
    public final String f12707a;
    /* renamed from: b */
    public final String f12708b;

    /* compiled from: UrlLinkFrame */
    /* renamed from: com.google.android.exoplayer2.g.b.k$1 */
    static class C23551 implements Creator<C4703k> {
        C23551() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6526a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6527a(i);
        }

        /* renamed from: a */
        public C4703k m6526a(Parcel parcel) {
            return new C4703k(parcel);
        }

        /* renamed from: a */
        public C4703k[] m6527a(int i) {
            return new C4703k[i];
        }
    }

    public C4703k(String str, String str2, String str3) {
        super(str);
        this.f12707a = str2;
        this.f12708b = str3;
    }

    C4703k(Parcel parcel) {
        super(parcel.readString());
        this.f12707a = parcel.readString();
        this.f12708b = parcel.readString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4703k c4703k = (C4703k) obj;
                if (!this.f.equals(c4703k.f) || !C2541v.m7179a(this.f12707a, c4703k.f12707a) || C2541v.m7179a(this.f12708b, c4703k.f12708b) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((527 + this.f.hashCode()) * 31) + (this.f12707a != null ? this.f12707a.hashCode() : 0)) * 31;
        if (this.f12708b != null) {
            i = this.f12708b.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.f12707a);
        parcel.writeString(this.f12708b);
    }
}

package com.google.android.exoplayer2.p145g.p147b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: TextInformationFrame */
/* renamed from: com.google.android.exoplayer2.g.b.j */
public final class C4702j extends C4163h {
    public static final Creator<C4702j> CREATOR = new C23541();
    /* renamed from: a */
    public final String f12705a;
    /* renamed from: b */
    public final String f12706b;

    /* compiled from: TextInformationFrame */
    /* renamed from: com.google.android.exoplayer2.g.b.j$1 */
    static class C23541 implements Creator<C4702j> {
        C23541() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6524a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6525a(i);
        }

        /* renamed from: a */
        public C4702j m6524a(Parcel parcel) {
            return new C4702j(parcel);
        }

        /* renamed from: a */
        public C4702j[] m6525a(int i) {
            return new C4702j[i];
        }
    }

    public C4702j(String str, String str2, String str3) {
        super(str);
        this.f12705a = str2;
        this.f12706b = str3;
    }

    C4702j(Parcel parcel) {
        super(parcel.readString());
        this.f12705a = parcel.readString();
        this.f12706b = parcel.readString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4702j c4702j = (C4702j) obj;
                if (!this.f.equals(c4702j.f) || !C2541v.m7179a(this.f12705a, c4702j.f12705a) || C2541v.m7179a(this.f12706b, c4702j.f12706b) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((527 + this.f.hashCode()) * 31) + (this.f12705a != null ? this.f12705a.hashCode() : 0)) * 31;
        if (this.f12706b != null) {
            i = this.f12706b.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.f12705a);
        parcel.writeString(this.f12706b);
    }
}

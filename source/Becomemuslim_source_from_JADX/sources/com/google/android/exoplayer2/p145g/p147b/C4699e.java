package com.google.android.exoplayer2.p145g.p147b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: CommentFrame */
/* renamed from: com.google.android.exoplayer2.g.b.e */
public final class C4699e extends C4163h {
    public static final Creator<C4699e> CREATOR = new C23491();
    /* renamed from: a */
    public final String f12696a;
    /* renamed from: b */
    public final String f12697b;
    /* renamed from: c */
    public final String f12698c;

    /* compiled from: CommentFrame */
    /* renamed from: com.google.android.exoplayer2.g.b.e$1 */
    static class C23491 implements Creator<C4699e> {
        C23491() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6514a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6515a(i);
        }

        /* renamed from: a */
        public C4699e m6514a(Parcel parcel) {
            return new C4699e(parcel);
        }

        /* renamed from: a */
        public C4699e[] m6515a(int i) {
            return new C4699e[i];
        }
    }

    public C4699e(String str, String str2, String str3) {
        super("COMM");
        this.f12696a = str;
        this.f12697b = str2;
        this.f12698c = str3;
    }

    C4699e(Parcel parcel) {
        super("COMM");
        this.f12696a = parcel.readString();
        this.f12697b = parcel.readString();
        this.f12698c = parcel.readString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4699e c4699e = (C4699e) obj;
                if (!C2541v.m7179a(this.f12697b, c4699e.f12697b) || !C2541v.m7179a(this.f12696a, c4699e.f12696a) || C2541v.m7179a(this.f12698c, c4699e.f12698c) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((527 + (this.f12696a != null ? this.f12696a.hashCode() : 0)) * 31) + (this.f12697b != null ? this.f12697b.hashCode() : 0)) * 31;
        if (this.f12698c != null) {
            i = this.f12698c.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.f12696a);
        parcel.writeString(this.f12698c);
    }
}

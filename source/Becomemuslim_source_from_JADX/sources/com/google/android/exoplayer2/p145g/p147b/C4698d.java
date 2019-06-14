package com.google.android.exoplayer2.p145g.p147b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Arrays;

/* compiled from: ChapterTocFrame */
/* renamed from: com.google.android.exoplayer2.g.b.d */
public final class C4698d extends C4163h {
    public static final Creator<C4698d> CREATOR = new C23481();
    /* renamed from: a */
    public final String f12691a;
    /* renamed from: b */
    public final boolean f12692b;
    /* renamed from: c */
    public final boolean f12693c;
    /* renamed from: d */
    public final String[] f12694d;
    /* renamed from: e */
    private final C4163h[] f12695e;

    /* compiled from: ChapterTocFrame */
    /* renamed from: com.google.android.exoplayer2.g.b.d$1 */
    static class C23481 implements Creator<C4698d> {
        C23481() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6512a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6513a(i);
        }

        /* renamed from: a */
        public C4698d m6512a(Parcel parcel) {
            return new C4698d(parcel);
        }

        /* renamed from: a */
        public C4698d[] m6513a(int i) {
            return new C4698d[i];
        }
    }

    public C4698d(String str, boolean z, boolean z2, String[] strArr, C4163h[] c4163hArr) {
        super("CTOC");
        this.f12691a = str;
        this.f12692b = z;
        this.f12693c = z2;
        this.f12694d = strArr;
        this.f12695e = c4163hArr;
    }

    C4698d(Parcel parcel) {
        super("CTOC");
        this.f12691a = parcel.readString();
        boolean z = true;
        this.f12692b = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.f12693c = z;
        this.f12694d = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.f12695e = new C4163h[readInt];
        for (int i = 0; i < readInt; i++) {
            this.f12695e[i] = (C4163h) parcel.readParcelable(C4163h.class.getClassLoader());
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4698d c4698d = (C4698d) obj;
                if (this.f12692b != c4698d.f12692b || this.f12693c != c4698d.f12693c || !C2541v.m7179a(this.f12691a, c4698d.f12691a) || !Arrays.equals(this.f12694d, c4698d.f12694d) || Arrays.equals(this.f12695e, c4698d.f12695e) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f12692b) * 31) + this.f12693c) * 31) + (this.f12691a != null ? this.f12691a.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12691a);
        parcel.writeByte((byte) this.f12692b);
        parcel.writeByte((byte) this.f12693c);
        parcel.writeStringArray(this.f12694d);
        parcel.writeInt(this.f12695e.length);
        for (Parcelable writeParcelable : this.f12695e) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}

package com.google.android.exoplayer2.p145g.p147b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Arrays;

/* compiled from: ChapterFrame */
/* renamed from: com.google.android.exoplayer2.g.b.c */
public final class C4697c extends C4163h {
    public static final Creator<C4697c> CREATOR = new C23471();
    /* renamed from: a */
    public final String f12685a;
    /* renamed from: b */
    public final int f12686b;
    /* renamed from: c */
    public final int f12687c;
    /* renamed from: d */
    public final long f12688d;
    /* renamed from: e */
    public final long f12689e;
    /* renamed from: g */
    private final C4163h[] f12690g;

    /* compiled from: ChapterFrame */
    /* renamed from: com.google.android.exoplayer2.g.b.c$1 */
    static class C23471 implements Creator<C4697c> {
        C23471() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6510a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6511a(i);
        }

        /* renamed from: a */
        public C4697c m6510a(Parcel parcel) {
            return new C4697c(parcel);
        }

        /* renamed from: a */
        public C4697c[] m6511a(int i) {
            return new C4697c[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public C4697c(String str, int i, int i2, long j, long j2, C4163h[] c4163hArr) {
        super("CHAP");
        this.f12685a = str;
        this.f12686b = i;
        this.f12687c = i2;
        this.f12688d = j;
        this.f12689e = j2;
        this.f12690g = c4163hArr;
    }

    C4697c(Parcel parcel) {
        super("CHAP");
        this.f12685a = parcel.readString();
        this.f12686b = parcel.readInt();
        this.f12687c = parcel.readInt();
        this.f12688d = parcel.readLong();
        this.f12689e = parcel.readLong();
        int readInt = parcel.readInt();
        this.f12690g = new C4163h[readInt];
        for (int i = 0; i < readInt; i++) {
            this.f12690g[i] = (C4163h) parcel.readParcelable(C4163h.class.getClassLoader());
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C4697c c4697c = (C4697c) obj;
                if (this.f12686b != c4697c.f12686b || this.f12687c != c4697c.f12687c || this.f12688d != c4697c.f12688d || this.f12689e != c4697c.f12689e || !C2541v.m7179a(this.f12685a, c4697c.f12685a) || Arrays.equals(this.f12690g, c4697c.f12690g) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f12686b) * 31) + this.f12687c) * 31) + ((int) this.f12688d)) * 31) + ((int) this.f12689e)) * 31) + (this.f12685a != null ? this.f12685a.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12685a);
        parcel.writeInt(this.f12686b);
        parcel.writeInt(this.f12687c);
        parcel.writeLong(this.f12688d);
        parcel.writeLong(this.f12689e);
        parcel.writeInt(this.f12690g.length);
        for (Parcelable writeParcelable : this.f12690g) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}

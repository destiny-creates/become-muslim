package com.google.android.exoplayer2.p145g.p148c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;

/* compiled from: TimeSignalCommand */
/* renamed from: com.google.android.exoplayer2.g.c.g */
public final class C4708g extends C4164b {
    public static final Creator<C4708g> CREATOR = new C23641();
    /* renamed from: a */
    public final long f12726a;
    /* renamed from: b */
    public final long f12727b;

    /* compiled from: TimeSignalCommand */
    /* renamed from: com.google.android.exoplayer2.g.c.g$1 */
    static class C23641 implements Creator<C4708g> {
        C23641() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6549a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6550a(i);
        }

        /* renamed from: a */
        public C4708g m6549a(Parcel parcel) {
            return new C4708g(parcel.readLong(), parcel.readLong());
        }

        /* renamed from: a */
        public C4708g[] m6550a(int i) {
            return new C4708g[i];
        }
    }

    private C4708g(long j, long j2) {
        this.f12726a = j;
        this.f12727b = j2;
    }

    /* renamed from: a */
    static C4708g m16055a(C2529l c2529l, long j, C2537s c2537s) {
        c2529l = C4708g.m16054a(c2529l, j);
        return new C4708g(c2529l, c2537s.m7149b(c2529l));
    }

    /* renamed from: a */
    static long m16054a(C2529l c2529l, long j) {
        long g = (long) c2529l.m7103g();
        return (128 & g) != 0 ? -1 & ((((g & 1) << 32) | c2529l.m7109m()) + j) : 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12726a);
        parcel.writeLong(this.f12727b);
    }
}

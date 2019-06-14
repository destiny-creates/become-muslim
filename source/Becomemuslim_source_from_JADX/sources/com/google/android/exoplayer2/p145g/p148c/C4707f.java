package com.google.android.exoplayer2.p145g.p148c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SpliceScheduleCommand */
/* renamed from: com.google.android.exoplayer2.g.c.f */
public final class C4707f extends C4164b {
    public static final Creator<C4707f> CREATOR = new C23611();
    /* renamed from: a */
    public final List<C2363b> f12725a;

    /* compiled from: SpliceScheduleCommand */
    /* renamed from: com.google.android.exoplayer2.g.c.f$1 */
    static class C23611 implements Creator<C4707f> {
        C23611() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6537a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6538a(i);
        }

        /* renamed from: a */
        public C4707f m6537a(Parcel parcel) {
            return new C4707f(parcel);
        }

        /* renamed from: a */
        public C4707f[] m6538a(int i) {
            return new C4707f[i];
        }
    }

    /* compiled from: SpliceScheduleCommand */
    /* renamed from: com.google.android.exoplayer2.g.c.f$a */
    public static final class C2362a {
        /* renamed from: a */
        public final int f5813a;
        /* renamed from: b */
        public final long f5814b;

        private C2362a(int i, long j) {
            this.f5813a = i;
            this.f5814b = j;
        }

        /* renamed from: b */
        private static C2362a m6541b(Parcel parcel) {
            return new C2362a(parcel.readInt(), parcel.readLong());
        }

        /* renamed from: c */
        private void m6542c(Parcel parcel) {
            parcel.writeInt(this.f5813a);
            parcel.writeLong(this.f5814b);
        }
    }

    /* compiled from: SpliceScheduleCommand */
    /* renamed from: com.google.android.exoplayer2.g.c.f$b */
    public static final class C2363b {
        /* renamed from: a */
        public final long f5815a;
        /* renamed from: b */
        public final boolean f5816b;
        /* renamed from: c */
        public final boolean f5817c;
        /* renamed from: d */
        public final boolean f5818d;
        /* renamed from: e */
        public final long f5819e;
        /* renamed from: f */
        public final List<C2362a> f5820f;
        /* renamed from: g */
        public final boolean f5821g;
        /* renamed from: h */
        public final long f5822h;
        /* renamed from: i */
        public final int f5823i;
        /* renamed from: j */
        public final int f5824j;
        /* renamed from: k */
        public final int f5825k;

        private C2363b(long j, boolean z, boolean z2, boolean z3, List<C2362a> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.f5815a = j;
            this.f5816b = z;
            this.f5817c = z2;
            this.f5818d = z3;
            this.f5820f = Collections.unmodifiableList(list);
            this.f5819e = j2;
            this.f5821g = z4;
            this.f5822h = j3;
            this.f5823i = i;
            this.f5824j = i2;
            this.f5825k = i3;
        }

        private C2363b(Parcel parcel) {
            this.f5815a = parcel.readLong();
            boolean z = false;
            this.f5816b = parcel.readByte() == (byte) 1;
            this.f5817c = parcel.readByte() == (byte) 1;
            this.f5818d = parcel.readByte() == (byte) 1;
            int readInt = parcel.readInt();
            List arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(C2362a.m6541b(parcel));
            }
            this.f5820f = Collections.unmodifiableList(arrayList);
            this.f5819e = parcel.readLong();
            if (parcel.readByte() == (byte) 1) {
                z = true;
            }
            this.f5821g = z;
            this.f5822h = parcel.readLong();
            this.f5823i = parcel.readInt();
            this.f5824j = parcel.readInt();
            this.f5825k = parcel.readInt();
        }

        /* renamed from: b */
        private static C2363b m6546b(C2529l c2529l) {
            List list;
            boolean z;
            long j;
            boolean z2;
            long j2;
            int i;
            int i2;
            int i3;
            boolean z3;
            long m = c2529l.m7109m();
            boolean z4 = (c2529l.m7103g() & 128) != 0;
            ArrayList arrayList = new ArrayList();
            if (z4) {
                list = arrayList;
                z = false;
                j = -9223372036854775807L;
                z2 = false;
                j2 = -9223372036854775807L;
                i = 0;
                i2 = 0;
                i3 = 0;
                z3 = false;
            } else {
                boolean z5;
                long m2;
                int g = c2529l.m7103g();
                z2 = (g & 128) != 0;
                boolean z6 = (g & 64) != 0;
                Object obj = (g & 32) != 0 ? 1 : null;
                long m3 = z6 ? c2529l.m7109m() : -9223372036854775807L;
                if (!z6) {
                    int g2 = c2529l.m7103g();
                    ArrayList arrayList2 = new ArrayList(g2);
                    for (int i4 = 0; i4 < g2; i4++) {
                        arrayList2.add(new C2362a(c2529l.m7103g(), c2529l.m7109m()));
                    }
                    arrayList = arrayList2;
                }
                if (obj != null) {
                    long g3 = (long) c2529l.m7103g();
                    z5 = (128 & g3) != 0;
                    m2 = ((((g3 & 1) << 32) | c2529l.m7109m()) * 1000) / 90;
                } else {
                    z5 = false;
                    m2 = -9223372036854775807L;
                }
                int h = c2529l.m7104h();
                int g4 = c2529l.m7103g();
                i3 = c2529l.m7103g();
                z3 = z6;
                j = m3;
                j2 = m2;
                list = arrayList;
                i = h;
                i2 = g4;
                z = z2;
                z2 = z5;
            }
            return new C2363b(m, z4, z, z3, list, j, z2, j2, i, i2, i3);
        }

        /* renamed from: b */
        private void m6547b(Parcel parcel) {
            parcel.writeLong(this.f5815a);
            parcel.writeByte((byte) this.f5816b);
            parcel.writeByte((byte) this.f5817c);
            parcel.writeByte((byte) this.f5818d);
            int size = this.f5820f.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((C2362a) this.f5820f.get(i)).m6542c(parcel);
            }
            parcel.writeLong(this.f5819e);
            parcel.writeByte((byte) this.f5821g);
            parcel.writeLong(this.f5822h);
            parcel.writeInt(this.f5823i);
            parcel.writeInt(this.f5824j);
            parcel.writeInt(this.f5825k);
        }

        /* renamed from: c */
        private static C2363b m6548c(Parcel parcel) {
            return new C2363b(parcel);
        }
    }

    private C4707f(List<C2363b> list) {
        this.f12725a = Collections.unmodifiableList(list);
    }

    private C4707f(Parcel parcel) {
        int readInt = parcel.readInt();
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(C2363b.m6548c(parcel));
        }
        this.f12725a = Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    static C4707f m16053a(C2529l c2529l) {
        int g = c2529l.m7103g();
        List arrayList = new ArrayList(g);
        for (int i = 0; i < g; i++) {
            arrayList.add(C2363b.m6546b(c2529l));
        }
        return new C4707f(arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        i = this.f12725a.size();
        parcel.writeInt(i);
        for (int i2 = 0; i2 < i; i2++) {
            ((C2363b) this.f12725a.get(i2)).m6547b(parcel);
        }
    }
}

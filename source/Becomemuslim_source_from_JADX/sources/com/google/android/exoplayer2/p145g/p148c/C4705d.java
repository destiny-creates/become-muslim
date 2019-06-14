package com.google.android.exoplayer2.p145g.p148c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SpliceInsertCommand */
/* renamed from: com.google.android.exoplayer2.g.c.d */
public final class C4705d extends C4164b {
    public static final Creator<C4705d> CREATOR = new C23581();
    /* renamed from: a */
    public final long f12712a;
    /* renamed from: b */
    public final boolean f12713b;
    /* renamed from: c */
    public final boolean f12714c;
    /* renamed from: d */
    public final boolean f12715d;
    /* renamed from: e */
    public final boolean f12716e;
    /* renamed from: f */
    public final long f12717f;
    /* renamed from: g */
    public final long f12718g;
    /* renamed from: h */
    public final List<C2359a> f12719h;
    /* renamed from: i */
    public final boolean f12720i;
    /* renamed from: j */
    public final long f12721j;
    /* renamed from: k */
    public final int f12722k;
    /* renamed from: l */
    public final int f12723l;
    /* renamed from: m */
    public final int f12724m;

    /* compiled from: SpliceInsertCommand */
    /* renamed from: com.google.android.exoplayer2.g.c.d$1 */
    static class C23581 implements Creator<C4705d> {
        C23581() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6531a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6532a(i);
        }

        /* renamed from: a */
        public C4705d m6531a(Parcel parcel) {
            return new C4705d(parcel);
        }

        /* renamed from: a */
        public C4705d[] m6532a(int i) {
            return new C4705d[i];
        }
    }

    /* compiled from: SpliceInsertCommand */
    /* renamed from: com.google.android.exoplayer2.g.c.d$a */
    public static final class C2359a {
        /* renamed from: a */
        public final int f5810a;
        /* renamed from: b */
        public final long f5811b;
        /* renamed from: c */
        public final long f5812c;

        private C2359a(int i, long j, long j2) {
            this.f5810a = i;
            this.f5811b = j;
            this.f5812c = j2;
        }

        /* renamed from: a */
        public void m6534a(Parcel parcel) {
            parcel.writeInt(this.f5810a);
            parcel.writeLong(this.f5811b);
            parcel.writeLong(this.f5812c);
        }

        /* renamed from: b */
        public static C2359a m6533b(Parcel parcel) {
            return new C2359a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }
    }

    private C4705d(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<C2359a> list, boolean z5, long j4, int i, int i2, int i3) {
        this.f12712a = j;
        this.f12713b = z;
        this.f12714c = z2;
        this.f12715d = z3;
        this.f12716e = z4;
        this.f12717f = j2;
        this.f12718g = j3;
        this.f12719h = Collections.unmodifiableList(list);
        this.f12720i = z5;
        this.f12721j = j4;
        this.f12722k = i;
        this.f12723l = i2;
        this.f12724m = i3;
    }

    private C4705d(Parcel parcel) {
        this.f12712a = parcel.readLong();
        boolean z = false;
        this.f12713b = parcel.readByte() == (byte) 1;
        this.f12714c = parcel.readByte() == (byte) 1;
        this.f12715d = parcel.readByte() == (byte) 1;
        this.f12716e = parcel.readByte() == (byte) 1;
        this.f12717f = parcel.readLong();
        this.f12718g = parcel.readLong();
        int readInt = parcel.readInt();
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(C2359a.m6533b(parcel));
        }
        this.f12719h = Collections.unmodifiableList(arrayList);
        if (parcel.readByte() == (byte) 1) {
            z = true;
        }
        this.f12720i = z;
        this.f12721j = parcel.readLong();
        this.f12722k = parcel.readInt();
        this.f12723l = parcel.readInt();
        this.f12724m = parcel.readInt();
    }

    /* renamed from: a */
    static C4705d m16052a(C2529l c2529l, long j, C2537s c2537s) {
        List list;
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        int i;
        int i2;
        int i3;
        boolean z4;
        C2537s c2537s2 = c2537s;
        long m = c2529l.m7109m();
        boolean z5 = (c2529l.m7103g() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (z5) {
            list = emptyList;
            z = false;
            z2 = false;
            j2 = -9223372036854775807L;
            z3 = false;
            j3 = -9223372036854775807L;
            i = 0;
            i2 = 0;
            i3 = 0;
            z4 = false;
        } else {
            List list2;
            long a;
            int g = c2529l.m7103g();
            boolean z6 = (g & 128) != 0;
            boolean z7 = (g & 64) != 0;
            Object obj = (g & 32) != 0 ? 1 : null;
            boolean z8 = (g & 16) != 0;
            long a2 = (!z7 || z8) ? -9223372036854775807L : C4708g.m16054a(c2529l, j);
            if (z7) {
                list2 = emptyList;
            } else {
                int g2 = c2529l.m7103g();
                list2 = new ArrayList(g2);
                for (int i4 = 0; i4 < g2; i4++) {
                    int g3 = c2529l.m7103g();
                    a = !z8 ? C4708g.m16054a(c2529l, j) : -9223372036854775807L;
                    list2.add(new C2359a(g3, a, c2537s2.m7149b(a)));
                }
            }
            if (obj != null) {
                long g4 = (long) c2529l.m7103g();
                z4 = (128 & g4) != 0;
                a = ((((g4 & 1) << 32) | c2529l.m7109m()) * 1000) / 90;
            } else {
                a = -9223372036854775807L;
                z4 = false;
            }
            i = c2529l.m7104h();
            i2 = c2529l.m7103g();
            i3 = c2529l.m7103g();
            z = z6;
            list = list2;
            long j4 = a;
            z2 = z8;
            j2 = a2;
            z3 = z4;
            j3 = j4;
            z4 = z7;
        }
        return new C4705d(m, z5, z, z4, z2, j2, c2537s2.m7149b(j2), list, z3, j3, i, i2, i3);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12712a);
        parcel.writeByte((byte) this.f12713b);
        parcel.writeByte((byte) this.f12714c);
        parcel.writeByte((byte) this.f12715d);
        parcel.writeByte((byte) this.f12716e);
        parcel.writeLong(this.f12717f);
        parcel.writeLong(this.f12718g);
        i = this.f12719h.size();
        parcel.writeInt(i);
        for (int i2 = 0; i2 < i; i2++) {
            ((C2359a) this.f12719h.get(i2)).m6534a(parcel);
        }
        parcel.writeByte((byte) this.f12720i);
        parcel.writeLong(this.f12721j);
        parcel.writeInt(this.f12722k);
        parcel.writeInt(this.f12723l);
        parcel.writeInt(this.f12724m);
    }
}

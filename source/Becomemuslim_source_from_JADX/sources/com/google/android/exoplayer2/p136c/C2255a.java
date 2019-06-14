package com.google.android.exoplayer2.p136c;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.C2251b;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* compiled from: DrmInitData */
/* renamed from: com.google.android.exoplayer2.c.a */
public final class C2255a implements Parcelable, Comparator<C2254a> {
    public static final Creator<C2255a> CREATOR = new C22521();
    /* renamed from: a */
    public final String f5386a;
    /* renamed from: b */
    public final int f5387b;
    /* renamed from: c */
    private final C2254a[] f5388c;
    /* renamed from: d */
    private int f5389d;

    /* compiled from: DrmInitData */
    /* renamed from: com.google.android.exoplayer2.c.a$1 */
    static class C22521 implements Creator<C2255a> {
        C22521() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6223a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6224a(i);
        }

        /* renamed from: a */
        public C2255a m6223a(Parcel parcel) {
            return new C2255a(parcel);
        }

        /* renamed from: a */
        public C2255a[] m6224a(int i) {
            return new C2255a[i];
        }
    }

    /* compiled from: DrmInitData */
    /* renamed from: com.google.android.exoplayer2.c.a$a */
    public static final class C2254a implements Parcelable {
        public static final Creator<C2254a> CREATOR = new C22531();
        /* renamed from: a */
        public final String f5381a;
        /* renamed from: b */
        public final byte[] f5382b;
        /* renamed from: c */
        public final boolean f5383c;
        /* renamed from: d */
        private int f5384d;
        /* renamed from: e */
        private final UUID f5385e;

        /* compiled from: DrmInitData */
        /* renamed from: com.google.android.exoplayer2.c.a$a$1 */
        static class C22531 implements Creator<C2254a> {
            C22531() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m6225a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m6226a(i);
            }

            /* renamed from: a */
            public C2254a m6225a(Parcel parcel) {
                return new C2254a(parcel);
            }

            /* renamed from: a */
            public C2254a[] m6226a(int i) {
                return new C2254a[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public C2254a(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public C2254a(UUID uuid, String str, byte[] bArr, boolean z) {
            this.f5385e = (UUID) C2516a.m7015a((Object) uuid);
            this.f5381a = (String) C2516a.m7015a((Object) str);
            this.f5382b = bArr;
            this.f5383c = z;
        }

        C2254a(Parcel parcel) {
            this.f5385e = new UUID(parcel.readLong(), parcel.readLong());
            this.f5381a = parcel.readString();
            this.f5382b = parcel.createByteArray();
            this.f5383c = parcel.readByte() != null ? true : null;
        }

        /* renamed from: a */
        public boolean m6230a(UUID uuid) {
            if (!C2251b.f5376b.equals(this.f5385e)) {
                if (uuid.equals(this.f5385e) == null) {
                    return null;
                }
            }
            return true;
        }

        /* renamed from: a */
        public boolean m6229a(C2254a c2254a) {
            return (!m6228a() || c2254a.m6228a() || m6230a(c2254a.f5385e) == null) ? null : true;
        }

        /* renamed from: a */
        public boolean m6228a() {
            return this.f5382b != null;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C2254a)) {
                return false;
            }
            boolean z = true;
            if (obj == this) {
                return true;
            }
            C2254a c2254a = (C2254a) obj;
            if (!this.f5381a.equals(c2254a.f5381a) || !C2541v.m7179a(this.f5385e, c2254a.f5385e) || Arrays.equals(this.f5382b, c2254a.f5382b) == null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            if (this.f5384d == 0) {
                this.f5384d = (((this.f5385e.hashCode() * 31) + this.f5381a.hashCode()) * 31) + Arrays.hashCode(this.f5382b);
            }
            return this.f5384d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f5385e.getMostSignificantBits());
            parcel.writeLong(this.f5385e.getLeastSignificantBits());
            parcel.writeString(this.f5381a);
            parcel.writeByteArray(this.f5382b);
            parcel.writeByte((byte) this.f5383c);
        }
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m6231a((C2254a) obj, (C2254a) obj2);
    }

    public C2255a(List<C2254a> list) {
        this(null, false, (C2254a[]) list.toArray(new C2254a[list.size()]));
    }

    public C2255a(String str, List<C2254a> list) {
        this(str, false, (C2254a[]) list.toArray(new C2254a[list.size()]));
    }

    public C2255a(C2254a... c2254aArr) {
        this(null, c2254aArr);
    }

    public C2255a(String str, C2254a... c2254aArr) {
        this(str, true, c2254aArr);
    }

    private C2255a(String str, boolean z, C2254a... c2254aArr) {
        this.f5386a = str;
        if (z) {
            c2254aArr = (C2254a[]) c2254aArr.clone();
        }
        Arrays.sort(c2254aArr, this);
        this.f5388c = c2254aArr;
        this.f5387b = c2254aArr.length;
    }

    C2255a(Parcel parcel) {
        this.f5386a = parcel.readString();
        this.f5388c = (C2254a[]) parcel.createTypedArray(C2254a.CREATOR);
        this.f5387b = this.f5388c.length;
    }

    /* renamed from: a */
    public C2254a m6232a(int i) {
        return this.f5388c[i];
    }

    /* renamed from: a */
    public C2255a m6233a(String str) {
        if (C2541v.m7179a(this.f5386a, (Object) str)) {
            return this;
        }
        return new C2255a(str, false, this.f5388c);
    }

    public int hashCode() {
        if (this.f5389d == 0) {
            this.f5389d = ((this.f5386a == null ? 0 : this.f5386a.hashCode()) * 31) + Arrays.hashCode(this.f5388c);
        }
        return this.f5389d;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C2255a c2255a = (C2255a) obj;
                if (!C2541v.m7179a(this.f5386a, c2255a.f5386a) || Arrays.equals(this.f5388c, c2255a.f5388c) == null) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: a */
    public int m6231a(C2254a c2254a, C2254a c2254a2) {
        if (C2251b.f5376b.equals(c2254a.f5385e)) {
            return C2251b.f5376b.equals(c2254a2.f5385e) != null ? null : 1;
        } else {
            return c2254a.f5385e.compareTo(c2254a2.f5385e);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5386a);
        parcel.writeTypedArray(this.f5388c, 0);
    }
}

package com.polidea.p254a.p263c;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ScanSettings */
/* renamed from: com.polidea.a.c.e */
public class C5624e implements Parcelable {
    public static final Creator<C5624e> CREATOR = new C56221();
    /* renamed from: a */
    private int f18793a;
    /* renamed from: b */
    private int f18794b;
    /* renamed from: c */
    private long f18795c;
    /* renamed from: d */
    private int f18796d;
    /* renamed from: e */
    private int f18797e;

    /* compiled from: ScanSettings */
    /* renamed from: com.polidea.a.c.e$1 */
    static class C56221 implements Creator<C5624e> {
        C56221() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m23909a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m23910a(i);
        }

        /* renamed from: a */
        public C5624e[] m23910a(int i) {
            return new C5624e[i];
        }

        /* renamed from: a */
        public C5624e m23909a(Parcel parcel) {
            return new C5624e(parcel);
        }
    }

    /* compiled from: ScanSettings */
    /* renamed from: com.polidea.a.c.e$a */
    public static final class C5623a {
        /* renamed from: a */
        private int f18788a = 0;
        /* renamed from: b */
        private int f18789b = 1;
        /* renamed from: c */
        private long f18790c = 0;
        /* renamed from: d */
        private int f18791d = 1;
        /* renamed from: e */
        private int f18792e = 3;

        /* renamed from: c */
        private boolean m23911c(int i) {
            boolean z = true;
            if (!(i == 1 || i == 2)) {
                if (i != 4) {
                    if (i != 6) {
                        z = false;
                    }
                    return z;
                }
            }
            return true;
        }

        /* renamed from: a */
        public C5623a m23912a(int i) {
            if (i < -1 || i > 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("invalid scan mode ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.f18788a = i;
            return this;
        }

        /* renamed from: b */
        public C5623a m23914b(int i) {
            if (m23911c(i)) {
                this.f18789b = i;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid callback type - ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        /* renamed from: a */
        public C5624e m23913a() {
            return new C5624e(this.f18788a, this.f18789b, this.f18790c, this.f18791d, this.f18792e);
        }
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: a */
    public int m23915a() {
        return this.f18793a;
    }

    /* renamed from: b */
    public int m23916b() {
        return this.f18794b;
    }

    /* renamed from: c */
    public int m23917c() {
        return this.f18796d;
    }

    /* renamed from: d */
    public int m23918d() {
        return this.f18797e;
    }

    /* renamed from: e */
    public long m23919e() {
        return this.f18795c;
    }

    private C5624e(int i, int i2, long j, int i3, int i4) {
        this.f18793a = i;
        this.f18794b = i2;
        this.f18795c = j;
        this.f18797e = i4;
        this.f18796d = i3;
    }

    private C5624e(Parcel parcel) {
        this.f18793a = parcel.readInt();
        this.f18794b = parcel.readInt();
        this.f18795c = parcel.readLong();
        this.f18796d = parcel.readInt();
        this.f18797e = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f18793a);
        parcel.writeInt(this.f18794b);
        parcel.writeLong(this.f18795c);
        parcel.writeInt(this.f18796d);
        parcel.writeInt(this.f18797e);
    }
}

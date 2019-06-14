package com.stripe.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.stripe.android.p285b.C7160g;
import com.stripe.android.p285b.C7161h;

/* compiled from: PaymentSessionData */
/* renamed from: com.stripe.android.k */
public class C5744k implements Parcelable {
    public static final Creator<C5744k> CREATOR = new C57431();
    /* renamed from: a */
    private long f19109a;
    /* renamed from: b */
    private boolean f19110b;
    /* renamed from: c */
    private String f19111c;
    /* renamed from: d */
    private long f19112d;
    /* renamed from: e */
    private String f19113e;
    /* renamed from: f */
    private C7160g f19114f;
    /* renamed from: g */
    private C7161h f19115g;

    /* compiled from: PaymentSessionData */
    /* renamed from: com.stripe.android.k$1 */
    static class C57431 implements Creator<C5744k> {
        C57431() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m24316a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m24317a(i);
        }

        /* renamed from: a */
        public C5744k m24316a(Parcel parcel) {
            return new C5744k(parcel);
        }

        /* renamed from: a */
        public C5744k[] m24317a(int i) {
            return new C5744k[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public C5744k() {
        this.f19109a = 0;
        this.f19111c = "NO_PAYMENT";
        this.f19112d = 0;
        this.f19113e = "incomplete";
    }

    /* renamed from: a */
    public void m24318a(C7160g c7160g) {
        this.f19114f = c7160g;
    }

    /* renamed from: a */
    public void m24319a(C7161h c7161h) {
        this.f19115g = c7161h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        if (r6 != r7) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r7 == 0) goto L_0x006b;
    L_0x0007:
        r2 = r6.getClass();
        r3 = r7.getClass();
        if (r2 == r3) goto L_0x0012;
    L_0x0011:
        goto L_0x006b;
    L_0x0012:
        r7 = (com.stripe.android.C5744k) r7;
        r2 = r6.f19109a;
        r4 = r7.f19109a;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x001d;
    L_0x001c:
        return r1;
    L_0x001d:
        r2 = r6.f19110b;
        r3 = r7.f19110b;
        if (r2 == r3) goto L_0x0024;
    L_0x0023:
        return r1;
    L_0x0024:
        r2 = r6.f19112d;
        r4 = r7.f19112d;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x002d;
    L_0x002c:
        return r1;
    L_0x002d:
        r2 = r6.f19111c;
        r3 = r7.f19111c;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0038;
    L_0x0037:
        return r1;
    L_0x0038:
        r2 = r6.f19113e;
        r3 = r7.f19113e;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0043;
    L_0x0042:
        return r1;
    L_0x0043:
        r2 = r6.f19114f;
        if (r2 == 0) goto L_0x0052;
    L_0x0047:
        r2 = r6.f19114f;
        r3 = r7.f19114f;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0057;
    L_0x0051:
        goto L_0x0056;
    L_0x0052:
        r2 = r7.f19114f;
        if (r2 == 0) goto L_0x0057;
    L_0x0056:
        return r1;
    L_0x0057:
        r2 = r6.f19115g;
        if (r2 == 0) goto L_0x0064;
    L_0x005b:
        r0 = r6.f19115g;
        r7 = r7.f19115g;
        r0 = r0.equals(r7);
        goto L_0x006a;
    L_0x0064:
        r7 = r7.f19115g;
        if (r7 != 0) goto L_0x0069;
    L_0x0068:
        goto L_0x006a;
    L_0x0069:
        r0 = 0;
    L_0x006a:
        return r0;
    L_0x006b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.k.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((int) (this.f19109a ^ (this.f19109a >>> 32))) * 31) + this.f19110b) * 31) + this.f19111c.hashCode()) * 31) + ((int) (this.f19112d ^ (this.f19112d >>> 32)))) * 31) + this.f19113e.hashCode()) * 31) + (this.f19114f != null ? this.f19114f.hashCode() : 0)) * 31;
        if (this.f19115g != null) {
            i = this.f19115g.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f19109a);
        parcel.writeInt(this.f19110b);
        parcel.writeString(this.f19113e);
        parcel.writeString(this.f19111c);
        parcel.writeParcelable(this.f19114f, i);
        parcel.writeParcelable(this.f19115g, i);
        parcel.writeLong(this.f19112d);
    }

    private C5744k(Parcel parcel) {
        this.f19109a = 0;
        this.f19111c = "NO_PAYMENT";
        this.f19112d = 0;
        this.f19113e = "incomplete";
        this.f19109a = parcel.readLong();
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f19110b = z;
        this.f19113e = C5745l.m24320a(parcel.readString());
        this.f19111c = parcel.readString();
        this.f19114f = (C7160g) parcel.readParcelable(C7160g.class.getClassLoader());
        this.f19115g = (C7161h) parcel.readParcelable(C7161h.class.getClassLoader());
        this.f19112d = parcel.readLong();
    }
}

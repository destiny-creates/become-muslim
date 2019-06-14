package com.stripe.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.stripe.android.p285b.C7156a;
import com.stripe.android.p285b.C7160g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PaymentSessionConfig */
/* renamed from: com.stripe.android.j */
public class C5742j implements Parcelable {
    public static final Creator<C5742j> CREATOR = new C57411();
    /* renamed from: a */
    private List<String> f19104a;
    /* renamed from: b */
    private List<String> f19105b;
    /* renamed from: c */
    private C7160g f19106c;
    /* renamed from: d */
    private boolean f19107d;
    /* renamed from: e */
    private boolean f19108e;

    /* compiled from: PaymentSessionConfig */
    /* renamed from: com.stripe.android.j$1 */
    static class C57411 implements Creator<C5742j> {
        C57411() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m24309a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m24310a(i);
        }

        /* renamed from: a */
        public C5742j m24309a(Parcel parcel) {
            return new C5742j(parcel);
        }

        /* renamed from: a */
        public C5742j[] m24310a(int i) {
            return new C5742j[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    private C5742j(Parcel parcel) {
        this.f19104a = new ArrayList();
        parcel.readList(this.f19104a, String.class.getClassLoader());
        this.f19105b = new ArrayList();
        parcel.readList(this.f19105b, String.class.getClassLoader());
        this.f19106c = (C7160g) parcel.readParcelable(C7156a.class.getClassLoader());
        boolean z = false;
        this.f19107d = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        }
        this.f19108e = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                C5742j c5742j = (C5742j) obj;
                if (m24314d() == c5742j.m24314d() && m24315e() == c5742j.m24315e() && m24311a().equals(c5742j.m24311a()) && m24312b().equals(c5742j.m24312b())) {
                    return m24313c().equals(c5742j.m24313c());
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((((m24311a().hashCode() * 31) + m24312b().hashCode()) * 31) + this.f19106c.hashCode()) * 31) + m24314d()) * 31) + m24315e();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f19104a);
        parcel.writeList(this.f19105b);
        parcel.writeParcelable(this.f19106c, i);
        parcel.writeInt(this.f19107d);
        parcel.writeInt(this.f19108e);
    }

    /* renamed from: a */
    public List<String> m24311a() {
        return this.f19104a;
    }

    /* renamed from: b */
    public List<String> m24312b() {
        return this.f19105b;
    }

    /* renamed from: c */
    public C7160g m24313c() {
        return this.f19106c;
    }

    /* renamed from: d */
    public boolean m24314d() {
        return this.f19107d;
    }

    /* renamed from: e */
    public boolean m24315e() {
        return this.f19108e;
    }
}

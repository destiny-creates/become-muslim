package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.fitness.data.g */
public class C4805g extends C4363a {
    public static final Creator<C4805g> CREATOR = new C2998m();
    /* renamed from: a */
    private final C4801a f13537a;
    /* renamed from: b */
    private final DataType f13538b;
    /* renamed from: c */
    private final long f13539c;
    /* renamed from: d */
    private final int f13540d;

    /* renamed from: com.google.android.gms.fitness.data.g$a */
    public static class C2993a {
        /* renamed from: a */
        private C4801a f7727a;
        /* renamed from: b */
        private DataType f7728b;
        /* renamed from: c */
        private long f7729c = -1;
        /* renamed from: d */
        private int f7730d = 2;

        /* renamed from: a */
        public final C2993a m8857a(DataType dataType) {
            this.f7728b = dataType;
            return this;
        }

        /* renamed from: a */
        public final C4805g m8858a() {
            boolean z;
            boolean z2 = false;
            if (this.f7727a == null) {
                if (this.f7728b == null) {
                    z = false;
                    C2872v.m8387a(z, (Object) "Must call setDataSource() or setDataType()");
                    if (this.f7728b == null || this.f7727a == null || this.f7728b.equals(this.f7727a.m17005a())) {
                        z2 = true;
                    }
                    C2872v.m8387a(z2, (Object) "Specified data type is incompatible with specified data source");
                    return new C4805g();
                }
            }
            z = true;
            C2872v.m8387a(z, (Object) "Must call setDataSource() or setDataType()");
            z2 = true;
            C2872v.m8387a(z2, (Object) "Specified data type is incompatible with specified data source");
            return new C4805g();
        }
    }

    C4805g(C4801a c4801a, DataType dataType, long j, int i) {
        this.f13537a = c4801a;
        this.f13538b = dataType;
        this.f13539c = j;
        this.f13540d = i;
    }

    private C4805g(C2993a c2993a) {
        this.f13538b = c2993a.f7728b;
        this.f13537a = c2993a.f7727a;
        this.f13539c = c2993a.f7729c;
        this.f13540d = c2993a.f7730d;
    }

    /* renamed from: a */
    public C4801a m17030a() {
        return this.f13537a;
    }

    /* renamed from: b */
    public DataType m17031b() {
        return this.f13538b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4805g)) {
            return false;
        }
        C4805g c4805g = (C4805g) obj;
        return C2868t.m8374a(this.f13537a, c4805g.f13537a) && C2868t.m8374a(this.f13538b, c4805g.f13538b) && this.f13539c == c4805g.f13539c && this.f13540d == c4805g.f13540d;
    }

    public int hashCode() {
        return C2868t.m8372a(this.f13537a, this.f13537a, Long.valueOf(this.f13539c), Integer.valueOf(this.f13540d));
    }

    public String toString() {
        return C2868t.m8373a((Object) this).m8371a("dataSource", this.f13537a).m8371a("dataType", this.f13538b).m8371a("samplingIntervalMicros", Long.valueOf(this.f13539c)).m8371a("accuracyMode", Integer.valueOf(this.f13540d)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8188a(parcel, 1, m17030a(), i, false);
        C2835c.m8188a(parcel, 2, m17031b(), i, false);
        C2835c.m8185a(parcel, 3, this.f13539c);
        C2835c.m8184a(parcel, 4, this.f13540d);
        C2835c.m8180a(parcel, a);
    }
}

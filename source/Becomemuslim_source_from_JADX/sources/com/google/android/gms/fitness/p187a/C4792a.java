package com.google.android.gms.fitness.p187a;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.C4801a;
import com.google.android.gms.fitness.data.C4802b;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.p208g.ac;
import com.google.android.gms.internal.p208g.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.fitness.a.a */
public class C4792a extends C4363a {
    public static final Creator<C4792a> CREATOR = new C2980r();
    /* renamed from: a */
    private final List<DataType> f13325a;
    /* renamed from: b */
    private final List<C4801a> f13326b;
    /* renamed from: c */
    private final long f13327c;
    /* renamed from: d */
    private final long f13328d;
    /* renamed from: e */
    private final List<DataType> f13329e;
    /* renamed from: f */
    private final List<C4801a> f13330f;
    /* renamed from: g */
    private final int f13331g;
    /* renamed from: h */
    private final long f13332h;
    /* renamed from: i */
    private final C4801a f13333i;
    /* renamed from: j */
    private final int f13334j;
    /* renamed from: k */
    private final boolean f13335k;
    /* renamed from: l */
    private final boolean f13336l;
    /* renamed from: m */
    private final ac f13337m;
    /* renamed from: n */
    private final List<C4802b> f13338n;
    /* renamed from: o */
    private final List<Integer> f13339o;

    /* renamed from: com.google.android.gms.fitness.a.a$a */
    public static class C2968a {
        /* renamed from: a */
        private List<DataType> f7609a = new ArrayList();
        /* renamed from: b */
        private List<C4801a> f7610b = new ArrayList();
        /* renamed from: c */
        private List<DataType> f7611c = new ArrayList();
        /* renamed from: d */
        private List<C4801a> f7612d = new ArrayList();
        /* renamed from: e */
        private C4801a f7613e;
        /* renamed from: f */
        private long f7614f;
        /* renamed from: g */
        private long f7615g;
        /* renamed from: h */
        private int f7616h = 0;
        /* renamed from: i */
        private long f7617i = 0;
        /* renamed from: j */
        private int f7618j = 0;
        /* renamed from: k */
        private boolean f7619k = false;
        /* renamed from: l */
        private boolean f7620l = false;
        /* renamed from: m */
        private final List<C4802b> f7621m = new ArrayList();
        /* renamed from: n */
        private final List<Integer> f7622n = new ArrayList();

        /* renamed from: a */
        public C2968a m8811a(int i, TimeUnit timeUnit) {
            C2872v.m8392b(this.f7616h == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.f7616h));
            C2872v.m8392b(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.f7616h = 1;
            this.f7617i = timeUnit.toMillis((long) i);
            return this;
        }

        /* renamed from: a */
        public C2968a m8812a(long j, long j2, TimeUnit timeUnit) {
            this.f7614f = timeUnit.toMillis(j);
            this.f7615g = timeUnit.toMillis(j2);
            return this;
        }

        /* renamed from: a */
        public C2968a m8813a(DataType dataType, DataType dataType2) {
            C2872v.m8381a((Object) dataType, (Object) "Attempting to use a null data type");
            C2872v.m8387a(this.f7609a.contains(dataType) ^ true, (Object) "Cannot add the same data type as aggregated and detailed");
            List a = DataType.m16989a(dataType);
            C2872v.m8392b(a.isEmpty() ^ true, "Unsupported input data type specified for aggregation: %s", dataType);
            C2872v.m8392b(a.contains(dataType2), "Invalid output aggregate data type specified: %s -> %s", dataType, dataType2);
            if (!this.f7611c.contains(dataType)) {
                this.f7611c.add(dataType);
            }
            return this;
        }

        /* renamed from: a */
        public C4792a m8814a() {
            boolean z;
            boolean z2 = false;
            if (this.f7610b.isEmpty() && this.f7609a.isEmpty() && this.f7612d.isEmpty()) {
                if (this.f7611c.isEmpty()) {
                    z = false;
                    C2872v.m8387a(z, (Object) "Must add at least one data source (aggregated or detailed)");
                    C2872v.m8388a(this.f7614f <= 0, "Invalid start time: %s", Long.valueOf(this.f7614f));
                    z = this.f7615g <= 0 && this.f7615g > this.f7614f;
                    C2872v.m8388a(z, "Invalid end time: %s", Long.valueOf(this.f7615g));
                    Object obj = (this.f7612d.isEmpty() || !this.f7611c.isEmpty()) ? null : 1;
                    if ((obj != null && this.f7616h == 0) || (obj == null && this.f7616h != 0)) {
                        z2 = true;
                    }
                    C2872v.m8387a(z2, (Object) "Must specify a valid bucketing strategy while requesting aggregation");
                    return new C4792a();
                }
            }
            z = true;
            C2872v.m8387a(z, (Object) "Must add at least one data source (aggregated or detailed)");
            if (this.f7614f <= 0) {
            }
            C2872v.m8388a(this.f7614f <= 0, "Invalid start time: %s", Long.valueOf(this.f7614f));
            if (this.f7615g <= 0) {
            }
            C2872v.m8388a(z, "Invalid end time: %s", Long.valueOf(this.f7615g));
            if (this.f7612d.isEmpty()) {
            }
            z2 = true;
            C2872v.m8387a(z2, (Object) "Must specify a valid bucketing strategy while requesting aggregation");
            return new C4792a();
        }
    }

    private C4792a(C2968a c2968a) {
        this(c2968a.f7609a, c2968a.f7610b, c2968a.f7614f, c2968a.f7615g, c2968a.f7611c, c2968a.f7612d, c2968a.f7616h, c2968a.f7617i, c2968a.f7613e, c2968a.f7618j, false, c2968a.f7620l, null, c2968a.f7621m, c2968a.f7622n);
    }

    public C4792a(C4792a c4792a, ac acVar) {
        C4792a c4792a2 = c4792a;
        this(c4792a2.f13325a, c4792a2.f13326b, c4792a2.f13327c, c4792a2.f13328d, c4792a2.f13329e, c4792a2.f13330f, c4792a2.f13331g, c4792a2.f13332h, c4792a2.f13333i, c4792a2.f13334j, c4792a2.f13335k, c4792a2.f13336l, acVar, c4792a2.f13338n, c4792a2.f13339o);
    }

    C4792a(List<DataType> list, List<C4801a> list2, long j, long j2, List<DataType> list3, List<C4801a> list4, int i, long j3, C4801a c4801a, int i2, boolean z, boolean z2, IBinder iBinder, List<C4802b> list5, List<Integer> list6) {
        this.f13325a = list;
        this.f13326b = list2;
        this.f13327c = j;
        this.f13328d = j2;
        this.f13329e = list3;
        this.f13330f = list4;
        this.f13331g = i;
        this.f13332h = j3;
        this.f13333i = c4801a;
        this.f13334j = i2;
        this.f13335k = z;
        this.f13336l = z2;
        r0.f13337m = iBinder == null ? null : ad.a(iBinder);
        r0.f13338n = list5 == null ? Collections.emptyList() : list5;
        r0.f13339o = list6 == null ? Collections.emptyList() : list6;
    }

    private C4792a(List<DataType> list, List<C4801a> list2, long j, long j2, List<DataType> list3, List<C4801a> list4, int i, long j3, C4801a c4801a, int i2, boolean z, boolean z2, ac acVar, List<C4802b> list5, List<Integer> list6) {
        this((List) list, (List) list2, j, j2, (List) list3, (List) list4, i, j3, c4801a, i2, z, z2, acVar == null ? null : acVar.asBinder(), (List) list5, (List) list6);
    }

    /* renamed from: a */
    public List<DataType> m16938a() {
        return this.f13325a;
    }

    /* renamed from: b */
    public List<C4801a> m16939b() {
        return this.f13326b;
    }

    /* renamed from: c */
    public List<DataType> m16940c() {
        return this.f13329e;
    }

    /* renamed from: d */
    public List<C4801a> m16941d() {
        return this.f13330f;
    }

    /* renamed from: e */
    public int m16942e() {
        return this.f13331g;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C4792a) {
                C4792a c4792a = (C4792a) obj;
                obj = (this.f13325a.equals(c4792a.f13325a) && this.f13326b.equals(c4792a.f13326b) && this.f13327c == c4792a.f13327c && this.f13328d == c4792a.f13328d && this.f13331g == c4792a.f13331g && this.f13330f.equals(c4792a.f13330f) && this.f13329e.equals(c4792a.f13329e) && C2868t.m8374a(this.f13333i, c4792a.f13333i) && this.f13332h == c4792a.f13332h && this.f13336l == c4792a.f13336l && this.f13334j == c4792a.f13334j && this.f13335k == c4792a.f13335k && C2868t.m8374a(this.f13337m, c4792a.f13337m) && C2868t.m8374a(this.f13338n, c4792a.f13338n) && C2868t.m8374a(this.f13339o, c4792a.f13339o)) ? 1 : null;
                if (obj != null) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public C4801a m16943f() {
        return this.f13333i;
    }

    /* renamed from: g */
    public int m16944g() {
        return this.f13334j;
    }

    /* renamed from: h */
    public List<Integer> m16945h() {
        return this.f13339o;
    }

    public int hashCode() {
        return C2868t.m8372a(Integer.valueOf(this.f13331g), Long.valueOf(this.f13327c), Long.valueOf(this.f13328d));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataReadRequest{");
        if (!this.f13325a.isEmpty()) {
            for (DataType c : this.f13325a) {
                stringBuilder.append(c.m16993c());
                stringBuilder.append(" ");
            }
        }
        if (!this.f13326b.isEmpty()) {
            for (C4801a g : this.f13326b) {
                stringBuilder.append(g.m17011g());
                stringBuilder.append(" ");
            }
        }
        if (this.f13331g != 0) {
            stringBuilder.append("bucket by ");
            stringBuilder.append(Bucket.m16958a(this.f13331g));
            if (this.f13332h > 0) {
                stringBuilder.append(" >");
                stringBuilder.append(this.f13332h);
                stringBuilder.append("ms");
            }
            stringBuilder.append(": ");
        }
        if (!this.f13329e.isEmpty()) {
            for (DataType c2 : this.f13329e) {
                stringBuilder.append(c2.m16993c());
                stringBuilder.append(" ");
            }
        }
        if (!this.f13330f.isEmpty()) {
            for (C4801a g2 : this.f13330f) {
                stringBuilder.append(g2.m17011g());
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append(String.format(Locale.US, "(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.f13327c), Long.valueOf(this.f13327c), Long.valueOf(this.f13328d), Long.valueOf(this.f13328d)}));
        if (this.f13333i != null) {
            stringBuilder.append("activities: ");
            stringBuilder.append(this.f13333i.m17011g());
        }
        if (!this.f13339o.isEmpty()) {
            stringBuilder.append("quality: ");
            for (Integer intValue : this.f13339o) {
                stringBuilder.append(C4801a.m17002a(intValue.intValue()));
                stringBuilder.append(" ");
            }
        }
        if (this.f13336l) {
            stringBuilder.append(" +server");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8207c(parcel, 1, m16938a(), false);
        C2835c.m8207c(parcel, 2, m16939b(), false);
        C2835c.m8185a(parcel, 3, this.f13327c);
        C2835c.m8185a(parcel, 4, this.f13328d);
        C2835c.m8207c(parcel, 5, m16940c(), false);
        C2835c.m8207c(parcel, 6, m16941d(), false);
        C2835c.m8184a(parcel, 7, m16942e());
        C2835c.m8185a(parcel, 8, this.f13332h);
        C2835c.m8188a(parcel, 9, m16943f(), i, false);
        C2835c.m8184a(parcel, 10, m16944g());
        C2835c.m8196a(parcel, 12, this.f13335k);
        C2835c.m8196a(parcel, 13, this.f13336l);
        C2835c.m8187a(parcel, 14, this.f13337m == null ? null : this.f13337m.asBinder(), false);
        C2835c.m8207c(parcel, 16, this.f13338n, false);
        C2835c.m8194a(parcel, 17, m16945h(), false);
        C2835c.m8180a(parcel, a);
    }
}

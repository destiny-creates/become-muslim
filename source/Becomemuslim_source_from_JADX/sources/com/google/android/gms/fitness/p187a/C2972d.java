package com.google.android.gms.fitness.p187a;

import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.fitness.data.C4801a;
import com.google.android.gms.fitness.data.DataType;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.fitness.a.d */
public class C2972d {
    /* renamed from: a */
    private final C4801a f7634a;
    /* renamed from: b */
    private final DataType f7635b;
    /* renamed from: c */
    private final long f7636c;
    /* renamed from: d */
    private final long f7637d;
    /* renamed from: e */
    private final long f7638e;
    /* renamed from: f */
    private final int f7639f;
    /* renamed from: g */
    private final long f7640g;

    /* renamed from: com.google.android.gms.fitness.a.d$a */
    public static class C2971a {
        /* renamed from: a */
        private C4801a f7626a;
        /* renamed from: b */
        private DataType f7627b;
        /* renamed from: c */
        private long f7628c = -1;
        /* renamed from: d */
        private long f7629d = 0;
        /* renamed from: e */
        private long f7630e = 0;
        /* renamed from: f */
        private boolean f7631f = false;
        /* renamed from: g */
        private int f7632g = 2;
        /* renamed from: h */
        private long f7633h = Clock.MAX_TIME;

        /* renamed from: a */
        public C2971a m8826a(long j, TimeUnit timeUnit) {
            C2872v.m8391b(j >= 0, "Cannot use a negative sampling interval");
            this.f7628c = timeUnit.toMicros(j);
            if (!this.f7631f) {
                this.f7629d = this.f7628c / 2;
            }
            return this;
        }

        /* renamed from: a */
        public C2971a m8827a(DataType dataType) {
            this.f7627b = dataType;
            return this;
        }

        /* renamed from: a */
        public C2972d m8828a() {
            boolean z;
            boolean z2 = false;
            if (this.f7626a == null) {
                if (this.f7627b == null) {
                    z = false;
                    C2872v.m8387a(z, (Object) "Must call setDataSource() or setDataType()");
                    if (this.f7627b == null || this.f7626a == null || this.f7627b.equals(this.f7626a.m17005a())) {
                        z2 = true;
                    }
                    C2872v.m8387a(z2, (Object) "Specified data type is incompatible with specified data source");
                    return new C2972d();
                }
            }
            z = true;
            C2872v.m8387a(z, (Object) "Must call setDataSource() or setDataType()");
            z2 = true;
            C2872v.m8387a(z2, (Object) "Specified data type is incompatible with specified data source");
            return new C2972d();
        }
    }

    private C2972d(C2971a c2971a) {
        this.f7634a = c2971a.f7626a;
        this.f7635b = c2971a.f7627b;
        this.f7636c = c2971a.f7628c;
        this.f7637d = c2971a.f7629d;
        this.f7638e = c2971a.f7630e;
        this.f7639f = c2971a.f7632g;
        this.f7640g = c2971a.f7633h;
    }

    /* renamed from: a */
    public long m8829a(TimeUnit timeUnit) {
        return timeUnit.convert(this.f7636c, TimeUnit.MICROSECONDS);
    }

    /* renamed from: a */
    public C4801a m8830a() {
        return this.f7634a;
    }

    /* renamed from: b */
    public long m8831b(TimeUnit timeUnit) {
        return timeUnit.convert(this.f7637d, TimeUnit.MICROSECONDS);
    }

    /* renamed from: b */
    public DataType m8832b() {
        return this.f7635b;
    }

    /* renamed from: c */
    public int m8833c() {
        return this.f7639f;
    }

    /* renamed from: c */
    public long m8834c(TimeUnit timeUnit) {
        return timeUnit.convert(this.f7638e, TimeUnit.MICROSECONDS);
    }

    /* renamed from: d */
    public final long m8835d() {
        return this.f7640g;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C2972d) {
                C2972d c2972d = (C2972d) obj;
                obj = (C2868t.m8374a(this.f7634a, c2972d.f7634a) && C2868t.m8374a(this.f7635b, c2972d.f7635b) && this.f7636c == c2972d.f7636c && this.f7637d == c2972d.f7637d && this.f7638e == c2972d.f7638e && this.f7639f == c2972d.f7639f && this.f7640g == c2972d.f7640g) ? 1 : null;
                if (obj != null) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C2868t.m8372a(this.f7634a, this.f7635b, Long.valueOf(this.f7636c), Long.valueOf(this.f7637d), Long.valueOf(this.f7638e), Integer.valueOf(this.f7639f), Long.valueOf(this.f7640g));
    }

    public String toString() {
        return C2868t.m8373a((Object) this).m8371a("dataSource", this.f7634a).m8371a("dataType", this.f7635b).m8371a("samplingRateMicros", Long.valueOf(this.f7636c)).m8371a("deliveryLatencyMicros", Long.valueOf(this.f7638e)).m8371a("timeOutMicros", Long.valueOf(this.f7640g)).toString();
    }
}

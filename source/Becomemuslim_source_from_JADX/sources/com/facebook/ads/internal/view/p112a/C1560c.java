package com.facebook.ads.internal.view.p112a;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.a.c */
public class C1560c {
    /* renamed from: a */
    public final String f4661a;
    /* renamed from: b */
    public final long f4662b;
    /* renamed from: c */
    public final long f4663c;
    /* renamed from: d */
    public final long f4664d;
    /* renamed from: e */
    public final long f4665e;
    /* renamed from: f */
    public final long f4666f;
    /* renamed from: g */
    public final long f4667g;
    /* renamed from: h */
    public final long f4668h;

    /* renamed from: com.facebook.ads.internal.view.a.c$a */
    public static class C1559a {
        /* renamed from: a */
        private final String f4653a;
        /* renamed from: b */
        private long f4654b = -1;
        /* renamed from: c */
        private long f4655c = -1;
        /* renamed from: d */
        private long f4656d = -1;
        /* renamed from: e */
        private long f4657e = -1;
        /* renamed from: f */
        private long f4658f = -1;
        /* renamed from: g */
        private long f4659g = -1;
        /* renamed from: h */
        private long f4660h = -1;

        public C1559a(String str) {
            this.f4653a = str;
        }

        /* renamed from: a */
        public C1559a m5458a(long j) {
            this.f4654b = j;
            return this;
        }

        /* renamed from: a */
        public C1560c m5459a() {
            return new C1560c(this.f4653a, this.f4654b, this.f4655c, this.f4656d, this.f4657e, this.f4658f, this.f4659g, this.f4660h);
        }

        /* renamed from: b */
        public C1559a m5460b(long j) {
            this.f4655c = j;
            return this;
        }

        /* renamed from: c */
        public C1559a m5461c(long j) {
            this.f4656d = j;
            return this;
        }

        /* renamed from: d */
        public C1559a m5462d(long j) {
            this.f4657e = j;
            return this;
        }

        /* renamed from: e */
        public C1559a m5463e(long j) {
            this.f4658f = j;
            return this;
        }

        /* renamed from: f */
        public C1559a m5464f(long j) {
            this.f4659g = j;
            return this;
        }

        /* renamed from: g */
        public C1559a m5465g(long j) {
            this.f4660h = j;
            return this;
        }
    }

    private C1560c(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.f4661a = str;
        this.f4662b = j;
        this.f4663c = j2;
        this.f4664d = j3;
        this.f4665e = j4;
        this.f4666f = j5;
        this.f4667g = j6;
        this.f4668h = j7;
    }

    /* renamed from: a */
    public Map<String, String> m5466a() {
        Map<String, String> hashMap = new HashMap(7);
        hashMap.put("initial_url", this.f4661a);
        hashMap.put("handler_time_ms", String.valueOf(this.f4662b));
        hashMap.put("load_start_ms", String.valueOf(this.f4663c));
        hashMap.put("response_end_ms", String.valueOf(this.f4664d));
        hashMap.put("dom_content_loaded_ms", String.valueOf(this.f4665e));
        hashMap.put("scroll_ready_ms", String.valueOf(this.f4666f));
        hashMap.put("load_finish_ms", String.valueOf(this.f4667g));
        hashMap.put("session_finish_ms", String.valueOf(this.f4668h));
        return hashMap;
    }
}

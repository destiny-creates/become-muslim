package com.p073d.p074a.p075a;

import com.p073d.p074a.C1166t;
import com.p073d.p074a.p076b.C1139b;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: BasePayload */
/* renamed from: com.d.a.a.b */
public abstract class C3460b extends C1166t {

    /* compiled from: BasePayload */
    /* renamed from: com.d.a.a.b$a */
    public static abstract class C1127a<P extends C3460b, B extends C1127a> {
        /* renamed from: a */
        private String f3187a;
        /* renamed from: b */
        private Date f3188b;
        /* renamed from: c */
        private Map<String, Object> f3189c;
        /* renamed from: d */
        private Map<String, Object> f3190d;
        /* renamed from: e */
        private String f3191e;
        /* renamed from: f */
        private String f3192f;

        /* renamed from: b */
        abstract B mo781b();

        /* renamed from: b */
        abstract P mo782b(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3);

        C1127a() {
        }

        /* renamed from: a */
        public B m3945a(Map<String, ?> map) {
            C1139b.m4009a((Object) map, "context");
            this.f3189c = Collections.unmodifiableMap(new LinkedHashMap(map));
            return mo781b();
        }

        /* renamed from: b */
        public B m3948b(Map<String, ?> map) {
            if (C1139b.m4023a((Map) map)) {
                return mo781b();
            }
            if (this.f3190d == null) {
                this.f3190d = new LinkedHashMap();
            }
            this.f3190d.putAll(map);
            return mo781b();
        }

        /* renamed from: b */
        public B m3947b(String str) {
            this.f3192f = C1139b.m4012a(str, "anonymousId");
            return mo781b();
        }

        /* renamed from: c */
        public B m3950c(String str) {
            this.f3191e = C1139b.m4012a(str, "userId");
            return mo781b();
        }

        /* renamed from: c */
        public P m3951c() {
            Map emptyMap;
            if (C1139b.m4020a(this.f3191e)) {
                if (C1139b.m4020a(this.f3192f)) {
                    throw new NullPointerException("either userId or anonymousId is required");
                }
            }
            if (C1139b.m4023a(this.f3190d)) {
                emptyMap = Collections.emptyMap();
            } else {
                emptyMap = C1139b.m4026b(this.f3190d);
            }
            Map map = emptyMap;
            if (C1139b.m4020a(this.f3187a)) {
                this.f3187a = UUID.randomUUID().toString();
            }
            if (this.f3188b == null) {
                this.f3188b = new Date();
            }
            if (C1139b.m4023a(this.f3189c)) {
                this.f3189c = Collections.emptyMap();
            }
            return mo782b(this.f3187a, this.f3188b, this.f3189c, map, this.f3191e, this.f3192f);
        }
    }

    /* compiled from: BasePayload */
    /* renamed from: com.d.a.a.b$b */
    public enum C1128b {
        browser,
        mobile,
        server
    }

    /* compiled from: BasePayload */
    /* renamed from: com.d.a.a.b$c */
    public enum C1129c {
        alias,
        group,
        identify,
        screen,
        track
    }

    /* renamed from: b */
    public /* synthetic */ C1166t mo783b(String str, Object obj) {
        return m11116a(str, obj);
    }

    C3460b(C1129c c1129c, String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3) {
        m4134c("channel", C1128b.mobile);
        m4134c("type", c1129c);
        m4134c("messageId", str);
        m4134c("timestamp", C1139b.m4025b(date));
        m4134c("context", map);
        m4134c("integrations", map2);
        if (C1139b.m4020a((CharSequence) str2) == null) {
            m4134c("userId", str2);
        }
        m4134c("anonymousId", str3);
    }

    /* renamed from: b */
    public C1129c m11117b() {
        return (C1129c) m4131a(C1129c.class, "type");
    }

    /* renamed from: c */
    public String m11119c() {
        return m4135c("userId");
    }

    /* renamed from: d */
    public C1166t m11120d() {
        return m4129a("integrations");
    }

    /* renamed from: a */
    public C3460b m11116a(String str, Object obj) {
        super.mo783b(str, obj);
        return this;
    }
}

package com.p073d.p074a.p075a;

import com.p073d.p074a.p075a.C3460b.C1127a;
import com.p073d.p074a.p075a.C3460b.C1129c;
import com.p073d.p074a.p076b.C1139b;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: ScreenPayload */
/* renamed from: com.d.a.a.g */
public class C4543g extends C3460b {

    /* compiled from: ScreenPayload */
    /* renamed from: com.d.a.a.g$a */
    public static class C3463a extends C1127a<C4543g, C3463a> {
        /* renamed from: a */
        private String f9250a;
        /* renamed from: b */
        private String f9251b;
        /* renamed from: c */
        private Map<String, Object> f9252c;

        /* renamed from: a */
        C3463a m11132a() {
            return this;
        }

        /* renamed from: b */
        /* synthetic */ C1127a mo781b() {
            return m11132a();
        }

        /* renamed from: b */
        protected /* synthetic */ C3460b mo782b(String str, Date date, Map map, Map map2, String str2, String str3) {
            return m11134a(str, date, map, map2, str2, str3);
        }

        /* renamed from: a */
        public C3463a m11133a(String str) {
            this.f9250a = str;
            return this;
        }

        @Deprecated
        /* renamed from: d */
        public C3463a m11138d(String str) {
            this.f9251b = str;
            return this;
        }

        /* renamed from: c */
        public C3463a m11137c(Map<String, ?> map) {
            C1139b.m4009a((Object) map, "properties");
            this.f9252c = Collections.unmodifiableMap(new LinkedHashMap(map));
            return this;
        }

        /* renamed from: a */
        protected C4543g m11134a(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3) {
            if (C1139b.m4020a(this.f9250a)) {
                if (C1139b.m4020a(r0.f9251b)) {
                    throw new NullPointerException("either name or category is required");
                }
            }
            Map map3 = r0.f9252c;
            if (C1139b.m4023a(map3)) {
                map3 = Collections.emptyMap();
            }
            return new C4543g(str, date, map, map2, str2, str3, r0.f9250a, r0.f9251b, map3);
        }
    }

    C4543g(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3, String str4, String str5, Map<String, Object> map3) {
        C4543g c4543g = this;
        super(C1129c.screen, str, date, map, map2, str2, str3);
        if (!C1139b.m4020a((CharSequence) str4)) {
            m4134c("name", str4);
        }
        if (!C1139b.m4020a((CharSequence) str5)) {
            m4134c("category", str5);
        }
        m4134c("properties", map3);
    }

    @Deprecated
    /* renamed from: a */
    public String m15449a() {
        return m4135c("category");
    }

    /* renamed from: e */
    public String m15450e() {
        return m4135c("name");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScreenPayload{name=\"");
        stringBuilder.append(m15450e());
        stringBuilder.append(",category=\"");
        stringBuilder.append(m15449a());
        stringBuilder.append("\"}");
        return stringBuilder.toString();
    }
}

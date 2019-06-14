package com.p073d.p074a.p075a;

import com.p073d.p074a.p075a.C3460b.C1127a;
import com.p073d.p074a.p075a.C3460b.C1129c;
import com.p073d.p074a.p076b.C1139b;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: GroupPayload */
/* renamed from: com.d.a.a.c */
public class C4541c extends C3460b {

    /* compiled from: GroupPayload */
    /* renamed from: com.d.a.a.c$a */
    public static class C3461a extends C1127a<C4541c, C3461a> {
        /* renamed from: a */
        private String f9247a;
        /* renamed from: b */
        private Map<String, Object> f9248b;

        /* renamed from: a */
        C3461a m11121a() {
            return this;
        }

        /* renamed from: b */
        /* synthetic */ C1127a mo781b() {
            return m11121a();
        }

        /* renamed from: b */
        protected /* synthetic */ C3460b mo782b(String str, Date date, Map map, Map map2, String str2, String str3) {
            return m11123a(str, date, map, map2, str2, str3);
        }

        /* renamed from: a */
        public C3461a m11122a(String str) {
            this.f9247a = C1139b.m4012a(str, "groupId");
            return this;
        }

        /* renamed from: c */
        public C3461a m11126c(Map<String, ?> map) {
            C1139b.m4009a((Object) map, "traits");
            this.f9248b = Collections.unmodifiableMap(new LinkedHashMap(map));
            return this;
        }

        /* renamed from: a */
        protected C4541c m11123a(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3) {
            C1139b.m4012a(this.f9247a, "groupId");
            Map map3 = this.f9248b;
            if (C1139b.m4023a(map3)) {
                map3 = Collections.emptyMap();
            }
            return new C4541c(str, date, map, map2, str2, str3, r0.f9247a, map3);
        }
    }

    public C4541c(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3, String str4, Map<String, Object> map3) {
        C4541c c4541c = this;
        super(C1129c.group, str, date, map, map2, str2, str3);
        m4134c("groupId", str4);
        m4134c("traits", map3);
    }

    /* renamed from: a */
    public String m15448a() {
        return m4135c("groupId");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GroupPayload{groupId=\"");
        stringBuilder.append(m15448a());
        stringBuilder.append("\"}");
        return stringBuilder.toString();
    }
}

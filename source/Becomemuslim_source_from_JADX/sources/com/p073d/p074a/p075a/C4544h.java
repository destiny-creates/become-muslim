package com.p073d.p074a.p075a;

import com.p073d.p074a.p075a.C3460b.C1127a;
import com.p073d.p074a.p075a.C3460b.C1129c;
import com.p073d.p074a.p076b.C1139b;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: TrackPayload */
/* renamed from: com.d.a.a.h */
public class C4544h extends C3460b {

    /* compiled from: TrackPayload */
    /* renamed from: com.d.a.a.h$a */
    public static class C3464a extends C1127a<C4544h, C3464a> {
        /* renamed from: a */
        private String f9253a;
        /* renamed from: b */
        private Map<String, Object> f9254b;

        /* renamed from: a */
        C3464a m11139a() {
            return this;
        }

        /* renamed from: b */
        /* synthetic */ C1127a mo781b() {
            return m11139a();
        }

        /* renamed from: b */
        protected /* synthetic */ C3460b mo782b(String str, Date date, Map map, Map map2, String str2, String str3) {
            return m11141a(str, date, map, map2, str2, str3);
        }

        /* renamed from: a */
        public C3464a m11140a(String str) {
            this.f9253a = C1139b.m4012a(str, "event");
            return this;
        }

        /* renamed from: c */
        public C3464a m11144c(Map<String, ?> map) {
            C1139b.m4009a((Object) map, "properties");
            this.f9254b = Collections.unmodifiableMap(new LinkedHashMap(map));
            return this;
        }

        /* renamed from: a */
        protected C4544h m11141a(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3) {
            C1139b.m4012a(this.f9253a, "event");
            Map map3 = this.f9254b;
            if (C1139b.m4023a(map3)) {
                map3 = Collections.emptyMap();
            }
            return new C4544h(str, date, map, map2, str2, str3, r0.f9253a, map3);
        }
    }

    C4544h(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3, String str4, Map<String, Object> map3) {
        C4544h c4544h = this;
        super(C1129c.track, str, date, map, map2, str2, str3);
        m4134c("event", str4);
        m4134c("properties", map3);
    }

    /* renamed from: a */
    public String m15451a() {
        return m4135c("event");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackPayload{event=\"");
        stringBuilder.append(m15451a());
        stringBuilder.append("\"}");
        return stringBuilder.toString();
    }
}

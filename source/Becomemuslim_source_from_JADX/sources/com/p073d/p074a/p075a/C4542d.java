package com.p073d.p074a.p075a;

import com.p073d.p074a.p075a.C3460b.C1127a;
import com.p073d.p074a.p075a.C3460b.C1129c;
import com.p073d.p074a.p076b.C1139b;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: IdentifyPayload */
/* renamed from: com.d.a.a.d */
public class C4542d extends C3460b {

    /* compiled from: IdentifyPayload */
    /* renamed from: com.d.a.a.d$a */
    public static class C3462a extends C1127a<C4542d, C3462a> {
        /* renamed from: a */
        private Map<String, Object> f9249a;

        /* renamed from: a */
        C3462a m11127a() {
            return this;
        }

        /* renamed from: b */
        /* synthetic */ C1127a mo781b() {
            return m11127a();
        }

        /* renamed from: b */
        /* synthetic */ C3460b mo782b(String str, Date date, Map map, Map map2, String str2, String str3) {
            return m11128a(str, date, map, map2, str2, str3);
        }

        /* renamed from: c */
        public C3462a m11131c(Map<String, ?> map) {
            C1139b.m4009a((Object) map, "traits");
            this.f9249a = Collections.unmodifiableMap(new LinkedHashMap(map));
            return this;
        }

        /* renamed from: a */
        C4542d m11128a(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3) {
            if (C1139b.m4020a((CharSequence) str2)) {
                if (C1139b.m4023a(this.f9249a)) {
                    throw new NullPointerException("either userId or traits are required");
                }
            }
            return new C4542d(str, date, map, map2, str2, str3, this.f9249a);
        }
    }

    C4542d(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3, Map<String, Object> map3) {
        super(C1129c.identify, str, date, map, map2, str2, str3);
        m4134c("traits", map3);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IdentifyPayload{\"userId=\"");
        stringBuilder.append(m11119c());
        stringBuilder.append("\"}");
        return stringBuilder.toString();
    }
}

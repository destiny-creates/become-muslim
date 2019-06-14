package com.p073d.p074a.p075a;

import com.p073d.p074a.p075a.C3460b.C1127a;
import com.p073d.p074a.p075a.C3460b.C1129c;
import com.p073d.p074a.p076b.C1139b;
import java.util.Date;
import java.util.Map;

/* compiled from: AliasPayload */
/* renamed from: com.d.a.a.a */
public class C4540a extends C3460b {

    /* compiled from: AliasPayload */
    /* renamed from: com.d.a.a.a$a */
    public static final class C3459a extends C1127a<C4540a, C3459a> {
        /* renamed from: a */
        private String f9246a;

        /* renamed from: a */
        C3459a m11111a() {
            return this;
        }

        /* renamed from: b */
        /* synthetic */ C1127a mo781b() {
            return m11111a();
        }

        /* renamed from: b */
        protected /* synthetic */ C3460b mo782b(String str, Date date, Map map, Map map2, String str2, String str3) {
            return m11113a(str, date, map, map2, str2, str3);
        }

        /* renamed from: a */
        public C3459a m11112a(String str) {
            this.f9246a = C1139b.m4012a(str, "previousId");
            return this;
        }

        /* renamed from: a */
        protected C4540a m11113a(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3) {
            String str4 = str2;
            C1139b.m4012a(str2, "userId");
            C1139b.m4012a(this.f9246a, "previousId");
            return new C4540a(str, date, map, map2, str4, str3, this.f9246a);
        }
    }

    C4540a(String str, Date date, Map<String, Object> map, Map<String, Object> map2, String str2, String str3, String str4) {
        super(C1129c.alias, str, date, map, map2, str2, str3);
        m4134c("previousId", str4);
    }

    /* renamed from: a */
    public String m15447a() {
        return m4135c("previousId");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AliasPayload{userId=\"");
        stringBuilder.append(m11119c());
        stringBuilder.append(",previousId=\"");
        stringBuilder.append(m15447a());
        stringBuilder.append("\"}");
        return stringBuilder.toString();
    }
}

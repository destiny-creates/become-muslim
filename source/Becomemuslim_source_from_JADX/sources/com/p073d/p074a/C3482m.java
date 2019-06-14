package com.p073d.p074a;

import android.content.Context;
import com.p073d.p074a.C1166t.C1165a;
import java.util.Collections;
import java.util.Map;

/* compiled from: ProjectSettings */
/* renamed from: com.d.a.m */
class C3482m extends C1166t {

    /* compiled from: ProjectSettings */
    /* renamed from: com.d.a.m$a */
    static class C3481a extends C1165a<C3482m> {
        /* renamed from: b */
        public /* synthetic */ C1166t mo792b(Map map) {
            return m11187a(map);
        }

        C3481a(Context context, C1143d c1143d, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("project-settings-plan-");
            stringBuilder.append(str);
            super(context, c1143d, stringBuilder.toString(), str, C3482m.class);
        }

        /* renamed from: a */
        public C3482m m11187a(Map<String, Object> map) {
            return new C3482m(map);
        }
    }

    /* renamed from: a */
    static C3482m m11189a(Map<String, Object> map) {
        map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        return new C3482m(map);
    }

    C3482m(Map<String, Object> map) {
        super(Collections.unmodifiableMap(map));
    }

    /* renamed from: a */
    long m11190a() {
        return m4128a("timestamp", 0);
    }

    /* renamed from: b */
    C1166t m11191b() {
        return m4129a("plan");
    }

    /* renamed from: c */
    C1166t m11192c() {
        C1166t b = m11191b();
        if (b == null) {
            return null;
        }
        return b.m4129a("track");
    }

    /* renamed from: d */
    C1166t m11193d() {
        return m4129a("integrations");
    }
}

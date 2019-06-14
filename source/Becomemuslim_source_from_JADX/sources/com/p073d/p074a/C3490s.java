package com.p073d.p074a;

import android.content.Context;
import com.p073d.p074a.C1166t.C1165a;
import com.p073d.p074a.p076b.C1139b;
import com.p073d.p074a.p076b.C1139b.C1138d;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: Traits */
/* renamed from: com.d.a.s */
public class C3490s extends C1166t {

    /* compiled from: Traits */
    /* renamed from: com.d.a.s$a */
    static class C3489a extends C1165a<C3490s> {
        /* renamed from: b */
        public /* synthetic */ C1166t mo792b(Map map) {
            return m11214a(map);
        }

        C3489a(Context context, C1143d c1143d, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("traits-");
            stringBuilder.append(str);
            super(context, c1143d, stringBuilder.toString(), str, C3490s.class);
        }

        /* renamed from: a */
        public C3490s m11214a(Map<String, Object> map) {
            return new C3490s(new C1138d(map));
        }
    }

    /* renamed from: b */
    public /* synthetic */ C1166t mo783b(String str, Object obj) {
        return m11218a(str, obj);
    }

    /* renamed from: a */
    static C3490s m11216a() {
        C3490s c3490s = new C3490s(new C1138d());
        c3490s.m11220b(UUID.randomUUID().toString());
        return c3490s;
    }

    C3490s(Map<String, Object> map) {
        super(map);
    }

    /* renamed from: b */
    public C3490s m11219b() {
        return new C3490s(Collections.unmodifiableMap(new LinkedHashMap(this)));
    }

    /* renamed from: a */
    C3490s m11217a(String str) {
        return m11218a("userId", str);
    }

    /* renamed from: c */
    public String m11222c() {
        return m4135c("userId");
    }

    /* renamed from: b */
    C3490s m11220b(String str) {
        return m11218a("anonymousId", str);
    }

    /* renamed from: d */
    public String m11223d() {
        return m4135c("anonymousId");
    }

    /* renamed from: e */
    public String m11224e() {
        CharSequence c = m11222c();
        return C1139b.m4020a(c) ? m11223d() : c;
    }

    /* renamed from: a */
    public C3490s m11218a(String str, Object obj) {
        super.mo783b(str, obj);
        return this;
    }
}

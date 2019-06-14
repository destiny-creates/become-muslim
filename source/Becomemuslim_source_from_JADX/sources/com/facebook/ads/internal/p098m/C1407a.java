package com.facebook.ads.internal.p098m;

import android.text.TextUtils;
import com.facebook.ads.internal.p092g.C1384a;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.facebook.ads.internal.m.a */
public class C1407a {
    /* renamed from: a */
    private final String f4110a;
    /* renamed from: b */
    private final double f4111b = (((double) System.currentTimeMillis()) / 1000.0d);
    /* renamed from: c */
    private final double f4112c;
    /* renamed from: d */
    private final String f4113d;
    /* renamed from: e */
    private final Map<String, String> f4114e;
    /* renamed from: f */
    private final C1413e f4115f;
    /* renamed from: g */
    private final C1414f f4116g;
    /* renamed from: h */
    private final boolean f4117h;

    /* renamed from: com.facebook.ads.internal.m.a$a */
    public static class C1406a {
        /* renamed from: a */
        private String f4103a;
        /* renamed from: b */
        private double f4104b;
        /* renamed from: c */
        private String f4105c;
        /* renamed from: d */
        private Map<String, String> f4106d;
        /* renamed from: e */
        private C1413e f4107e;
        /* renamed from: f */
        private C1414f f4108f;
        /* renamed from: g */
        private boolean f4109g;

        /* renamed from: a */
        public C1406a m4849a(double d) {
            this.f4104b = d;
            return this;
        }

        /* renamed from: a */
        public C1406a m4850a(C1413e c1413e) {
            this.f4107e = c1413e;
            return this;
        }

        /* renamed from: a */
        public C1406a m4851a(C1414f c1414f) {
            this.f4108f = c1414f;
            return this;
        }

        /* renamed from: a */
        public C1406a m4852a(String str) {
            this.f4103a = str;
            return this;
        }

        /* renamed from: a */
        public C1406a m4853a(Map<String, String> map) {
            this.f4106d = map;
            return this;
        }

        /* renamed from: a */
        public C1406a m4854a(boolean z) {
            this.f4109g = z;
            return this;
        }

        /* renamed from: a */
        public C1407a m4855a() {
            return new C1407a(this.f4103a, this.f4104b, this.f4105c, this.f4106d, this.f4107e, this.f4108f, this.f4109g);
        }

        /* renamed from: b */
        public C1406a m4856b(String str) {
            this.f4105c = str;
            return this;
        }
    }

    public C1407a(String str, double d, String str2, Map<String, String> map, C1413e c1413e, C1414f c1414f, boolean z) {
        this.f4110a = str;
        this.f4112c = d;
        this.f4113d = str2;
        this.f4115f = c1413e;
        this.f4116g = c1414f;
        this.f4117h = z;
        Map hashMap = new HashMap();
        if (!(map == null || map.isEmpty())) {
            hashMap.putAll(map);
        }
        if (m4863f()) {
            hashMap.put("analog", C1508k.m5306a(C1384a.m4731a()));
        }
        this.f4114e = C1407a.m4857a(hashMap);
    }

    /* renamed from: a */
    private static Map<String, String> m4857a(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str2 != null) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public String m4858a() {
        return this.f4110a;
    }

    /* renamed from: b */
    public double m4859b() {
        return this.f4111b;
    }

    /* renamed from: c */
    public double m4860c() {
        return this.f4112c;
    }

    /* renamed from: d */
    public String m4861d() {
        return this.f4113d;
    }

    /* renamed from: e */
    public Map<String, String> m4862e() {
        return this.f4114e;
    }

    /* renamed from: f */
    final boolean m4863f() {
        return this.f4115f == C1413e.IMMEDIATE;
    }

    /* renamed from: g */
    final boolean m4864g() {
        return TextUtils.isEmpty(this.f4110a) ^ 1;
    }

    /* renamed from: h */
    public C1413e m4865h() {
        return this.f4115f;
    }

    /* renamed from: i */
    public C1414f m4866i() {
        return this.f4116g;
    }
}

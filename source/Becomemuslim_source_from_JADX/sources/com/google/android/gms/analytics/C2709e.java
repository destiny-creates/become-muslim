package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.analytics.p171a.C2702a;
import com.google.android.gms.analytics.p171a.C2703b;
import com.google.android.gms.analytics.p171a.C2704c;
import com.google.android.gms.internal.p210i.bk;
import com.google.android.gms.internal.p210i.bz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.e */
public class C2709e {

    /* renamed from: com.google.android.gms.analytics.e$c */
    public static class C2708c<T extends C2708c> {
        /* renamed from: a */
        private Map<String, String> f6960a = new HashMap();
        /* renamed from: b */
        private C2703b f6961b;
        /* renamed from: c */
        private Map<String, List<C2702a>> f6962c = new HashMap();
        /* renamed from: d */
        private List<C2704c> f6963d = new ArrayList();
        /* renamed from: e */
        private List<C2702a> f6964e = new ArrayList();

        protected C2708c() {
        }

        /* renamed from: a */
        public T m7712a() {
            m7719a("&sc", ViewProps.START);
            return this;
        }

        /* renamed from: d */
        public T m7722d(String str) {
            str = bz.c(str);
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            str = bz.a(str);
            m7711b("&cc", (String) str.get("utm_content"));
            m7711b("&cm", (String) str.get("utm_medium"));
            m7711b("&cn", (String) str.get("utm_campaign"));
            m7711b("&cs", (String) str.get("utm_source"));
            m7711b("&ck", (String) str.get("utm_term"));
            m7711b("&ci", (String) str.get("utm_id"));
            m7711b("&anid", (String) str.get("anid"));
            m7711b("&gclid", (String) str.get("gclid"));
            m7711b("&dclid", (String) str.get("dclid"));
            m7711b("&aclid", (String) str.get("aclid"));
            m7711b("&gmob_t", (String) str.get("gmob_t"));
            return this;
        }

        /* renamed from: a */
        public T m7714a(int i, String str) {
            m7719a(C2712l.m7727a(i), str);
            return this;
        }

        /* renamed from: a */
        public T m7713a(int i, float f) {
            m7719a(C2712l.m7730c(i), Float.toString(f));
            return this;
        }

        /* renamed from: a */
        public final T m7719a(String str, String str2) {
            if (str != null) {
                this.f6960a.put(str, str2);
            } else {
                bk.b("HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        /* renamed from: b */
        private final T m7711b(String str, String str2) {
            if (str2 != null) {
                this.f6960a.put(str, str2);
            }
            return this;
        }

        /* renamed from: a */
        public final T m7720a(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            this.f6960a.putAll(new HashMap(map));
            return this;
        }

        /* renamed from: b */
        public Map<String, String> m7721b() {
            Map<String, String> hashMap = new HashMap(this.f6960a);
            if (this.f6961b != null) {
                hashMap.putAll(this.f6961b.m7693a());
            }
            int i = 1;
            for (C2704c e : this.f6963d) {
                hashMap.putAll(e.m7706e(C2712l.m7734g(i)));
                i++;
            }
            i = 1;
            for (C2702a g : this.f6964e) {
                hashMap.putAll(g.m7688g(C2712l.m7732e(i)));
                i++;
            }
            i = 1;
            for (Entry entry : this.f6962c.entrySet()) {
                List<C2702a> list = (List) entry.getValue();
                String j = C2712l.m7737j(i);
                int i2 = 1;
                for (C2702a c2702a : list) {
                    String valueOf = String.valueOf(j);
                    String valueOf2 = String.valueOf(C2712l.m7736i(i2));
                    hashMap.putAll(c2702a.m7688g(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i2++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    String valueOf3 = String.valueOf(j);
                    j = String.valueOf("nm");
                    hashMap.put(j.length() != 0 ? valueOf3.concat(j) : new String(valueOf3), (String) entry.getKey());
                }
                i++;
            }
            return hashMap;
        }

        /* renamed from: a */
        public T m7717a(C2703b c2703b) {
            this.f6961b = c2703b;
            return this;
        }

        /* renamed from: a */
        public T m7716a(C2702a c2702a, String str) {
            if (c2702a == null) {
                bk.b("product should be non-null");
                return this;
            }
            if (str == null) {
                str = "";
            }
            if (!this.f6962c.containsKey(str)) {
                this.f6962c.put(str, new ArrayList());
            }
            ((List) this.f6962c.get(str)).add(c2702a);
            return this;
        }

        /* renamed from: a */
        public T m7718a(C2704c c2704c) {
            if (c2704c == null) {
                bk.b("promotion should be non-null");
                return this;
            }
            this.f6963d.add(c2704c);
            return this;
        }

        /* renamed from: a */
        public T m7715a(C2702a c2702a) {
            if (c2702a == null) {
                bk.b("product should be non-null");
                return this;
            }
            this.f6964e.add(c2702a);
            return this;
        }
    }

    /* renamed from: com.google.android.gms.analytics.e$a */
    public static class C4302a extends C2708c<C4302a> {
        public C4302a() {
            m7719a("&t", "event");
        }

        /* renamed from: a */
        public C4302a m13968a(String str) {
            m7719a("&ec", str);
            return this;
        }

        /* renamed from: b */
        public C4302a m13969b(String str) {
            m7719a("&ea", str);
            return this;
        }

        /* renamed from: c */
        public C4302a m13970c(String str) {
            m7719a("&el", str);
            return this;
        }

        /* renamed from: a */
        public C4302a m13967a(long j) {
            m7719a("&ev", Long.toString(j));
            return this;
        }
    }

    /* renamed from: com.google.android.gms.analytics.e$b */
    public static class C4303b extends C2708c<C4303b> {
        public C4303b() {
            m7719a("&t", "exception");
        }

        /* renamed from: a */
        public C4303b m13971a(String str) {
            m7719a("&exd", str);
            return this;
        }

        /* renamed from: a */
        public C4303b m13972a(boolean z) {
            m7719a("&exf", bz.a(z));
            return this;
        }
    }

    /* renamed from: com.google.android.gms.analytics.e$d */
    public static class C4304d extends C2708c<C4304d> {
        public C4304d() {
            m7719a("&t", "screenview");
        }
    }

    /* renamed from: com.google.android.gms.analytics.e$e */
    public static class C4305e extends C2708c<C4305e> {
        public C4305e() {
            m7719a("&t", "social");
        }

        /* renamed from: a */
        public C4305e m13973a(String str) {
            m7719a("&sn", str);
            return this;
        }

        /* renamed from: b */
        public C4305e m13974b(String str) {
            m7719a("&sa", str);
            return this;
        }

        /* renamed from: c */
        public C4305e m13975c(String str) {
            m7719a("&st", str);
            return this;
        }
    }

    /* renamed from: com.google.android.gms.analytics.e$f */
    public static class C4306f extends C2708c<C4306f> {
        public C4306f() {
            m7719a("&t", "timing");
        }

        /* renamed from: a */
        public C4306f m13977a(String str) {
            m7719a("&utv", str);
            return this;
        }

        /* renamed from: a */
        public C4306f m13976a(long j) {
            m7719a("&utt", Long.toString(j));
            return this;
        }

        /* renamed from: b */
        public C4306f m13978b(String str) {
            m7719a("&utc", str);
            return this;
        }

        /* renamed from: c */
        public C4306f m13979c(String str) {
            m7719a("&utl", str);
            return this;
        }
    }
}

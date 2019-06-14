package ai.api;

import ai.api.p009e.C0031c;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AIConfiguration */
/* renamed from: ai.api.a */
public class C0009a implements Cloneable {
    /* renamed from: g */
    private static Map<String, C0004a> f32g = new HashMap();
    /* renamed from: a */
    private final String f33a;
    /* renamed from: b */
    private final C0004a f34b;
    /* renamed from: c */
    private String f35c;
    /* renamed from: d */
    private String f36d;
    /* renamed from: e */
    private boolean f37e = false;
    /* renamed from: f */
    private Proxy f38f;

    /* compiled from: AIConfiguration */
    /* renamed from: ai.api.a$a */
    public enum C0004a {
        ChineseChina("zh-CN"),
        ChineseHongKong("zh-HK"),
        ChineseTaiwan("zh-TW"),
        English("en"),
        EnglishUS("en-US", "en"),
        EnglishGB("en-GB", "en"),
        Dutch("nl"),
        French("fr"),
        German("de"),
        Italian("it"),
        Japanese("ja"),
        Korean("ko"),
        Portuguese("pt"),
        PortugueseBrazil("pt-BR"),
        Russian("ru"),
        Spanish("es"),
        Ukrainian("uk");
        
        /* renamed from: r */
        public static C0004a f18r;
        /* renamed from: t */
        private final String f21t;
        /* renamed from: u */
        private final String f22u;

        static {
            f18r = English;
        }

        private C0004a(String str) {
            this(r1, r2, str, str);
        }

        private C0004a(String str, String str2) {
            if (f19s == null) {
                if (str == null) {
                    throw new AssertionError();
                }
            }
            if (f19s == null) {
                if (str2 == null) {
                    throw new AssertionError();
                }
            }
            this.f21t = str;
            this.f22u = str2;
            C0004a c0004a = (C0004a) C0009a.f32g.put(str, this);
            if (f19s != 0) {
                return;
            }
            if (c0004a != null) {
                throw new AssertionError("languageTag duplicates");
            }
        }

        /* renamed from: a */
        public static C0004a m6a(String str) {
            C0004a c0004a = (C0004a) C0009a.f32g.get(str);
            return c0004a != null ? c0004a : f18r;
        }
    }

    public /* synthetic */ Object clone() {
        return m31f();
    }

    public C0009a(String str, C0004a c0004a) {
        if (str != null) {
            this.f33a = str;
            if (c0004a == null) {
                c0004a = C0004a.f18r;
            }
            this.f34b = c0004a;
            this.f36d = "20150910";
            this.f35c = "https://api.api.ai/v1/";
            return;
        }
        throw new IllegalArgumentException("clientAccessToken");
    }

    /* renamed from: a */
    public String m25a() {
        return this.f33a;
    }

    /* renamed from: b */
    public String m27b() {
        return this.f34b.f21t;
    }

    /* renamed from: c */
    public String m28c() {
        return this.f34b.f22u;
    }

    /* renamed from: d */
    public boolean m29d() {
        return this.f37e;
    }

    /* renamed from: e */
    public Proxy m30e() {
        return this.f38f;
    }

    /* renamed from: f */
    public C0009a m31f() {
        try {
            return (C0009a) super.clone();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    String m26a(String str) {
        if (C0031c.m89a(this.f36d)) {
            return String.format("%s%s?sessionId=%s", new Object[]{this.f35c, "query", str});
        }
        return String.format("%s%s?v=%s&sessionId=%s", new Object[]{this.f35c, "query", this.f36d, str});
    }
}

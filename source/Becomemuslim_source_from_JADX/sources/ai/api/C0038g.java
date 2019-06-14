package ai.api;

import ai.api.p007c.C0017f;
import ai.api.p007c.C0017f.C0016a;
import ai.api.p007c.C0017f.C3095f;
import com.google.p127a.C2157f;
import com.google.p127a.C2158g;
import com.google.p127a.C2160j;
import com.google.p127a.C2161k;
import com.google.p127a.C2162l;
import com.google.p127a.C2163p;
import com.google.p127a.C2164r;
import com.google.p127a.C2165s;
import com.google.p127a.C4049i;
import com.google.p127a.C4052o;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: GsonFactory */
/* renamed from: ai.api.g */
public class C0038g {
    /* renamed from: a */
    private static final C2157f f128a = new C2158g().m5986a();
    /* renamed from: b */
    private static final C2157f f129b = new C2158g().m5987a(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US).toPattern()).m5988a(C0017f.class, new C3099a()).m5988a(C3095f.class, new C3100b()).m5986a();
    /* renamed from: c */
    private static final C0038g f130c = new C0038g();

    /* compiled from: GsonFactory */
    /* renamed from: ai.api.g$a */
    private static class C3099a implements C2161k<C0017f>, C2165s<C0017f> {
        private C3099a() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo13b(C2162l c2162l, Type type, C2160j c2160j) {
            return m9087a(c2162l, type, c2160j);
        }

        /* renamed from: a */
        public C0017f m9087a(C2162l c2162l, Type type, C2160j c2160j) {
            type = c2162l.m6002k().m12472a("type").mo2035e();
            for (C0016a c0016a : C0016a.values()) {
                if (c0016a.m62a() == type) {
                    return (C0017f) c2160j.mo2029a(c2162l, c0016a.m63b());
                }
            }
            throw new C2163p(String.format("Unexpected message type value: %d", new Object[]{Integer.valueOf(type)}));
        }

        /* renamed from: a */
        public C2162l m9088a(C0017f c0017f, Type type, C2164r c2164r) {
            return c2164r.mo2030a(c0017f, c0017f.getClass());
        }
    }

    /* compiled from: GsonFactory */
    /* renamed from: ai.api.g$b */
    private static class C3100b implements C2161k<C0017f> {
        private C3100b() {
        }

        /* renamed from: b */
        public /* synthetic */ Object mo13b(C2162l c2162l, Type type, C2160j c2160j) {
            return m9091a(c2162l, type, c2160j);
        }

        /* renamed from: a */
        public C3095f m9091a(C2162l c2162l, Type type, C2160j c2160j) {
            if (c2162l.m5999h() != null) {
                C4052o c4052o = (C4052o) c2162l;
                if (c4052o.m12472a("speech").m6000i()) {
                    C2162l c4049i = new C4049i();
                    c4049i.m12466a(c4052o.m12472a("speech"));
                    c4052o.m12473a("speech", c4049i);
                }
            }
            return (C3095f) C0038g.f128a.m5974a(c2162l, type);
        }
    }

    /* renamed from: a */
    public C2157f m113a() {
        return f129b;
    }

    /* renamed from: b */
    public static C0038g m111b() {
        return f130c;
    }
}

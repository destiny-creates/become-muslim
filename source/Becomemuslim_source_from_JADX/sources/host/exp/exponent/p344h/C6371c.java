package host.exp.exponent.p344h;

import com.raizlabs.android.dbflow.p273c.C5673e;
import com.raizlabs.android.dbflow.p273c.p274a.C5664b;
import com.raizlabs.android.dbflow.p273c.p274a.C5665d;
import com.raizlabs.android.dbflow.p273c.p274a.C8022c;
import com.raizlabs.android.dbflow.p276d.p277a.C8023b;
import com.raizlabs.android.dbflow.p281e.C5698h;
import host.exp.exponent.p334a.C6289b;
import org.json.JSONObject;

/* compiled from: ExponentDB */
/* renamed from: host.exp.exponent.h.c */
public class C6371c {
    /* renamed from: a */
    private static final String f20638a = "c";

    /* compiled from: ExponentDB */
    /* renamed from: host.exp.exponent.h.c$a */
    public interface C6370a {
        /* renamed from: a */
        void mo5431a();

        /* renamed from: a */
        void mo5432a(C8177a c8177a);
    }

    /* renamed from: a */
    public static void m26148a(String str, JSONObject jSONObject, String str2) {
        try {
            C5698h c8177a = new C8177a();
            c8177a.f30370a = jSONObject.getString("id");
            c8177a.f30371b = str;
            c8177a.f30372c = str2;
            c8177a.f30373d = jSONObject.toString();
            C5673e.m24047c().m24050a(c8177a);
        } catch (String str3) {
            C6289b.m25953c(f20638a, str3.getMessage());
        }
    }

    /* renamed from: a */
    public static void m26147a(String str, final C6370a c6370a) {
        C5673e.m24047c().m24049a(new C8022c(C8177a.class, new C5665d<C8177a>() {
            /* renamed from: a */
            public boolean mo5043a(C5664b<C8177a> c5664b) {
                return true;
            }

            /* renamed from: a */
            public boolean m34304a(C5664b<C8177a> c5664b, C8177a c8177a) {
                return true;
            }

            /* renamed from: a */
            public void m34301a(C8177a c8177a) {
                if (c8177a == null) {
                    c6370a.mo5431a();
                } else {
                    c6370a.mo5432a(c8177a);
                }
            }
        }, new C8023b[]{C8023b.m38874a("id").m38879b(str)}));
    }
}

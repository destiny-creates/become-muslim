package io.p347a.p348a.p349a.p350a.p358g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6430k;
import io.p347a.p348a.p349a.p350a.p357f.C6490c;
import io.p347a.p348a.p349a.p350a.p357f.C7619d;
import org.json.JSONObject;

/* compiled from: DefaultSettingsController */
/* renamed from: io.a.a.a.a.g.j */
class C7622j implements C6506s {
    /* renamed from: a */
    private final C6510w f26336a;
    /* renamed from: b */
    private final C6509v f26337b;
    /* renamed from: c */
    private final C6430k f26338c;
    /* renamed from: d */
    private final C6496g f26339d;
    /* renamed from: e */
    private final C6511x f26340e;
    /* renamed from: f */
    private final C6520i f26341f;
    /* renamed from: g */
    private final C6490c f26342g = new C7619d(this.f26341f);

    public C7622j(C6520i c6520i, C6510w c6510w, C6430k c6430k, C6509v c6509v, C6496g c6496g, C6511x c6511x) {
        this.f26341f = c6520i;
        this.f26336a = c6510w;
        this.f26338c = c6430k;
        this.f26337b = c6509v;
        this.f26339d = c6496g;
        this.f26340e = c6511x;
    }

    /* renamed from: a */
    public C6507t mo5467a() {
        return mo5468a(C6505r.USE_CACHE);
    }

    /* renamed from: a */
    public C6507t mo5468a(C6505r c6505r) {
        C6505r c6505r2 = null;
        try {
            if (!(C6514c.m26635i() || m34415d())) {
                c6505r2 = m34409b(c6505r);
            }
            if (c6505r2 == null) {
                c6505r = this.f26340e.mo5470a(this.f26336a);
                if (c6505r != null) {
                    C6507t a = this.f26337b.mo5469a(this.f26338c, c6505r);
                    try {
                        this.f26339d.mo5466a(a.f20972g, c6505r);
                        m34408a(c6505r, "Loaded settings: ");
                        m34412a(m34413b());
                        c6505r2 = a;
                    } catch (Exception e) {
                        c6505r = e;
                        c6505r2 = a;
                        C6514c.m26634h().mo5480e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", c6505r);
                        return c6505r2;
                    }
                }
            }
            if (c6505r2 == null) {
                return m34409b(C6505r.IGNORE_CACHE_EXPIRATION);
            }
        } catch (Exception e2) {
            c6505r = e2;
            C6514c.m26634h().mo5480e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", c6505r);
            return c6505r2;
        }
        return c6505r2;
    }

    /* renamed from: b */
    private C6507t m34409b(C6505r c6505r) {
        C6507t c6507t = null;
        try {
            if (C6505r.SKIP_CACHE_LOOKUP.equals(c6505r)) {
                return null;
            }
            JSONObject a = this.f26339d.mo5465a();
            if (a != null) {
                C6507t a2 = this.f26337b.mo5469a(this.f26338c, a);
                if (a2 != null) {
                    m34408a(a, "Loaded cached settings: ");
                    long a3 = this.f26338c.mo5438a();
                    if (C6505r.IGNORE_CACHE_EXPIRATION.equals(c6505r) == null) {
                        if (a2.m26617a(a3) != null) {
                            C6514c.m26634h().mo5472a("Fabric", "Cached settings have expired.");
                            return null;
                        }
                    }
                    try {
                        C6514c.m26634h().mo5472a("Fabric", "Returning cached settings.");
                        return a2;
                    } catch (Exception e) {
                        c6505r = e;
                        c6507t = a2;
                        C6514c.m26634h().mo5480e("Fabric", "Failed to get cached settings", c6505r);
                        return c6507t;
                    }
                }
                C6514c.m26634h().mo5480e("Fabric", "Failed to transform cached settings data.", null);
                return null;
            }
            C6514c.m26634h().mo5472a("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e2) {
            c6505r = e2;
            C6514c.m26634h().mo5480e("Fabric", "Failed to get cached settings", c6505r);
            return c6507t;
        }
    }

    /* renamed from: a */
    private void m34408a(JSONObject jSONObject, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(jSONObject.toString());
        C6514c.m26634h().mo5472a("Fabric", stringBuilder.toString());
    }

    /* renamed from: b */
    String m34413b() {
        return C6428i.m26362a(C6428i.m26389m(this.f26341f.m26655E()));
    }

    /* renamed from: c */
    String m34414c() {
        return this.f26342g.mo5462a().getString("existing_instance_identifier", "");
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    boolean m34412a(String str) {
        Editor b = this.f26342g.mo5464b();
        b.putString("existing_instance_identifier", str);
        return this.f26342g.mo5463a(b);
    }

    /* renamed from: d */
    boolean m34415d() {
        return m34414c().equals(m34413b()) ^ 1;
    }
}

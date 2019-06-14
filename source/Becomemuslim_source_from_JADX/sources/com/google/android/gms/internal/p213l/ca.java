package com.google.android.gms.internal.p213l;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.v4.util.C3211a;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.measurement.AppMeasurement.C6846a;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.l.ca */
public final class ca extends fl implements ac {
    /* renamed from: b */
    private static int f32800b = 65535;
    /* renamed from: c */
    private static int f32801c = 2;
    /* renamed from: d */
    private final Map<String, Map<String, String>> f32802d = new C3211a();
    /* renamed from: e */
    private final Map<String, Map<String, Boolean>> f32803e = new C3211a();
    /* renamed from: f */
    private final Map<String, Map<String, Boolean>> f32804f = new C3211a();
    /* renamed from: g */
    private final Map<String, gg> f32805g = new C3211a();
    /* renamed from: h */
    private final Map<String, Map<String, Integer>> f32806h = new C3211a();
    /* renamed from: i */
    private final Map<String, String> f32807i = new C3211a();

    ca(fm fmVar) {
        super(fmVar);
    }

    /* renamed from: a */
    private final gg m44033a(String str, byte[] bArr) {
        if (bArr == null) {
            return new gg();
        }
        C5033a a = C5033a.m21210a(bArr, 0, bArr.length);
        C5043j ggVar = new gg();
        try {
            ggVar.mo6216a(a);
            mo4754r().m42579w().m21309a("Parsed config. version, gmp_app_id", ggVar.f29024c, ggVar.f29025d);
            return ggVar;
        } catch (IOException e) {
            mo4754r().m42565i().m21309a("Unable to merge remote config. appId", bb.m42550a(str), e);
            return new gg();
        }
    }

    /* renamed from: a */
    private static Map<String, String> m44034a(gg ggVar) {
        Map<String, String> c3211a = new C3211a();
        if (!(ggVar == null || ggVar.f29026e == null)) {
            for (gh ghVar : ggVar.f29026e) {
                if (ghVar != null) {
                    c3211a.put(ghVar.f29031c, ghVar.f29032d);
                }
            }
        }
        return c3211a;
    }

    /* renamed from: a */
    private final void m44035a(String str, gg ggVar) {
        Map c3211a = new C3211a();
        Map c3211a2 = new C3211a();
        Map c3211a3 = new C3211a();
        if (!(ggVar == null || ggVar.f29027f == null)) {
            for (gf gfVar : ggVar.f29027f) {
                if (TextUtils.isEmpty(gfVar.f29020c)) {
                    mo4754r().m42565i().m21307a("EventConfig contained null event name");
                } else {
                    Object a = C6846a.m32210a(gfVar.f29020c);
                    if (!TextUtils.isEmpty(a)) {
                        gfVar.f29020c = a;
                    }
                    c3211a.put(gfVar.f29020c, gfVar.f29021d);
                    c3211a2.put(gfVar.f29020c, gfVar.f29022e);
                    if (gfVar.f29023f != null) {
                        if (gfVar.f29023f.intValue() >= f32801c) {
                            if (gfVar.f29023f.intValue() <= f32800b) {
                                c3211a3.put(gfVar.f29020c, gfVar.f29023f);
                            }
                        }
                        mo4754r().m42565i().m21309a("Invalid sampling rate. Event name, sample rate", gfVar.f29020c, gfVar.f29023f);
                    }
                }
            }
        }
        this.f32803e.put(str, c3211a);
        this.f32804f.put(str, c3211a2);
        this.f32806h.put(str, c3211a3);
    }

    /* renamed from: g */
    private final void m44036g(String str) {
        m42632I();
        mo6210d();
        C2872v.a(str);
        if (this.f32805g.get(str) == null) {
            byte[] d = E_().m43936d(str);
            if (d == null) {
                this.f32802d.put(str, null);
                this.f32803e.put(str, null);
                this.f32804f.put(str, null);
                this.f32805g.put(str, null);
                this.f32807i.put(str, null);
                this.f32806h.put(str, null);
                return;
            }
            gg a = m44033a(str, d);
            this.f32802d.put(str, ca.m44034a(a));
            m44035a(str, a);
            this.f32805g.put(str, a);
            this.f32807i.put(str, null);
        }
    }

    public final /* bridge */ /* synthetic */ ad E_() {
        return super.E_();
    }

    public final /* bridge */ /* synthetic */ C8339w F_() {
        return super.F_();
    }

    public final /* bridge */ /* synthetic */ fs G_() {
        return super.G_();
    }

    /* renamed from: a */
    protected final gg m44037a(String str) {
        m42632I();
        mo6210d();
        C2872v.a(str);
        m44036g(str);
        return (gg) this.f32805g.get(str);
    }

    /* renamed from: a */
    public final String mo4733a(String str, String str2) {
        mo6210d();
        m44036g(str);
        Map map = (Map) this.f32802d.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    protected final boolean m44040a(String str, byte[] bArr, String str2) {
        m42632I();
        mo6210d();
        C2872v.a(str);
        gg a = m44033a(str, bArr);
        if (a == null) {
            return false;
        }
        m44035a(str, a);
        this.f32805g.put(str, a);
        this.f32807i.put(str, str2);
        this.f32802d.put(str, ca.m44034a(a));
        F_().m44323a(str, a.f29028g);
        try {
            a.f29028g = null;
            byte[] bArr2 = new byte[a.m21444d()];
            a.mo4757a(C5035b.m21284a(bArr2, 0, bArr2.length));
            bArr = bArr2;
        } catch (IOException e) {
            mo4754r().m42565i().m21309a("Unable to serialize reduced-size config. Storing full config instead. appId", bb.m42550a(str), e);
        }
        db E_ = E_();
        C2872v.a(str);
        E_.mo6210d();
        E_.m42632I();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) E_.m43947i().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                E_.mo4754r().I_().m21308a("Failed to update remote config (got 0). appId", bb.m42550a(str));
            }
        } catch (SQLiteException e2) {
            E_.mo4754r().I_().m21309a("Error storing remote config. appId", bb.m42550a(str), e2);
        }
        return true;
    }

    /* renamed from: b */
    protected final String m44041b(String str) {
        mo6210d();
        return (String) this.f32807i.get(str);
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: b */
    final boolean m44043b(String str, String str2) {
        mo6210d();
        m44036g(str);
        if (m44051e(str) && fw.m42652g(str2)) {
            return true;
        }
        if (m44052f(str) && fw.m42643a(str2)) {
            return true;
        }
        Map map = (Map) this.f32803e.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: c */
    protected final void m44045c(String str) {
        mo6210d();
        this.f32807i.put(str, null);
    }

    /* renamed from: c */
    final boolean m44046c(String str, String str2) {
        mo6210d();
        m44036g(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f32804f.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    /* renamed from: d */
    final int m44047d(String str, String str2) {
        mo6210d();
        m44036g(str);
        Map map = (Map) this.f32806h.get(str);
        if (map == null) {
            return 1;
        }
        Integer num = (Integer) map.get(str2);
        return num == null ? 1 : num.intValue();
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: d */
    final void m44049d(String str) {
        mo6210d();
        this.f32805g.remove(str);
    }

    /* renamed from: e */
    protected final boolean mo6850e() {
        return false;
    }

    /* renamed from: e */
    final boolean m44051e(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(mo4733a(str, "measurement.upload.blacklist_internal"));
    }

    /* renamed from: f */
    final boolean m44052f(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(mo4733a(str, "measurement.upload.blacklist_public"));
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }
}

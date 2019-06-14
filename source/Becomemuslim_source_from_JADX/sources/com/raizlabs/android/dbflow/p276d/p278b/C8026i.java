package com.raizlabs.android.dbflow.p276d.p278b;

import android.database.Cursor;
import com.raizlabs.android.dbflow.config.C5675a;
import com.raizlabs.android.dbflow.config.C5679e;
import com.raizlabs.android.dbflow.config.C5679e.C5678a;
import com.raizlabs.android.dbflow.config.C5680f;
import com.raizlabs.android.dbflow.p276d.C5687a;
import com.raizlabs.android.dbflow.p276d.C5690c;
import com.raizlabs.android.dbflow.p276d.C7135b;
import com.raizlabs.android.dbflow.p276d.p277a.C5686d;
import com.raizlabs.android.dbflow.p276d.p277a.C8024c;
import com.raizlabs.android.dbflow.p276d.p280d.C5691a;
import com.raizlabs.android.dbflow.p281e.C5698h;
import java.util.List;

/* compiled from: Where */
/* renamed from: com.raizlabs.android.dbflow.d.b.i */
public class C8026i<ModelClass extends C5698h> extends C7127a<ModelClass> implements C5687a, C5691a<ModelClass> {
    /* renamed from: a */
    private final C7134j<ModelClass> f29803a;
    /* renamed from: b */
    private final C5675a f29804b = C5680f.m24086b(this.f29803a.m33179d());
    /* renamed from: c */
    private C8024c<ModelClass> f29805c = new C8024c(this.f29803a.m33179d(), new C5686d[0]);
    /* renamed from: d */
    private String f29806d;
    /* renamed from: e */
    private C8024c<ModelClass> f29807e = new C8024c(this.f29803a.m33179d(), new C5686d[0]);
    /* renamed from: f */
    private String f29808f;
    /* renamed from: g */
    private String f29809g;
    /* renamed from: h */
    private String f29810h;

    public C8026i(C7134j<ModelClass> c7134j) {
        super(c7134j.m33179d());
        this.f29803a = c7134j;
    }

    /* renamed from: a */
    public C8026i<ModelClass> m38899a(C8024c<ModelClass> c8024c) {
        if (c8024c != null) {
            this.f29805c = c8024c;
        }
        return this;
    }

    /* renamed from: a */
    public C8026i<ModelClass> m38902a(C5686d... c5686dArr) {
        this.f29805c.m38887a(c5686dArr);
        return this;
    }

    /* renamed from: a */
    public C8026i<ModelClass> m38901a(boolean z, String... strArr) {
        this.f29808f = C7131f.m33173a(strArr).m33174a(z).mo5061a();
        return this;
    }

    /* renamed from: a */
    public C8026i<ModelClass> m38900a(Object obj) {
        this.f29809g = String.valueOf(obj);
        return this;
    }

    /* renamed from: a */
    public String mo5061a() {
        C7135b a = new C7135b().m33189b(this.f29803a.mo5061a()).m33185a("WHERE", this.f29805c.mo5061a()).m33185a("GROUP BY", this.f29806d).m33185a("HAVING", this.f29807e.mo5061a()).m33185a(null, this.f29808f).m33185a("LIMIT", this.f29809g).m33185a("OFFSET", this.f29810h);
        if (C5679e.m24080a(C5678a.V)) {
            C5679e.m24075a(C5678a.V, a.mo5061a());
        }
        return a.mo5061a();
    }

    /* renamed from: e */
    public Cursor m38907e() {
        String a = mo5061a();
        if (this.f29803a.mo6281f() instanceof C7132g) {
            return this.f29804b.m24064f().rawQuery(a, null);
        }
        this.f29804b.m24064f().execSQL(a);
        return null;
    }

    /* renamed from: b */
    public List<ModelClass> mo6280b() {
        m38904a("query");
        return super.mo6280b();
    }

    /* renamed from: a */
    protected void m38904a(String str) {
        if (!(this.f29803a.mo6281f() instanceof C7132g)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Please use ");
            stringBuilder.append(str);
            stringBuilder.append("(). The beginning is not a Select");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: c */
    public ModelClass mo5060c() {
        m38904a("query");
        m38900a(Integer.valueOf(1));
        return super.mo5060c();
    }

    /* renamed from: f */
    public boolean m38908f() {
        m38904a("query");
        return C5690c.m24131c(this.f29803a.m33179d(), mo5061a(), new String[0]);
    }
}

package com.raizlabs.android.dbflow.p276d.p278b;

import com.raizlabs.android.dbflow.config.C5680f;
import com.raizlabs.android.dbflow.p276d.C5687a;
import com.raizlabs.android.dbflow.p276d.C7135b;
import com.raizlabs.android.dbflow.p276d.p277a.C5686d;
import com.raizlabs.android.dbflow.p276d.p277a.C8024c;
import com.raizlabs.android.dbflow.p276d.p280d.C5691a;
import com.raizlabs.android.dbflow.p281e.C5698h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: From */
/* renamed from: com.raizlabs.android.dbflow.d.b.d */
public class C8025d<ModelClass extends C5698h> extends C7127a<ModelClass> implements C7134j<ModelClass>, C5691a<ModelClass> {
    /* renamed from: a */
    private C5687a f29799a;
    /* renamed from: b */
    private Class<ModelClass> f29800b;
    /* renamed from: c */
    private String f29801c;
    /* renamed from: d */
    private List<C7130e> f29802d = new ArrayList();

    public C8025d(C5687a c5687a, Class<ModelClass> cls) {
        super(cls);
        this.f29799a = c5687a;
        this.f29800b = cls;
    }

    /* renamed from: e */
    public C8026i<ModelClass> m38897e() {
        return new C8026i(this);
    }

    /* renamed from: a */
    public C8026i<ModelClass> m38892a(C8024c<ModelClass> c8024c) {
        return m38897e().m38899a((C8024c) c8024c);
    }

    /* renamed from: a */
    public C8026i<ModelClass> m38893a(C5686d... c5686dArr) {
        return m38897e().m38902a(c5686dArr);
    }

    /* renamed from: b */
    public List<ModelClass> mo6280b() {
        return m38897e().mo6280b();
    }

    /* renamed from: c */
    public ModelClass mo5060c() {
        return m38897e().mo5060c();
    }

    public String toString() {
        return mo5061a();
    }

    /* renamed from: a */
    public String mo5061a() {
        C7135b b = new C7135b().m33189b(this.f29799a.mo5061a());
        if (!(this.f29799a instanceof C7133h)) {
            b.m33189b((Object) "FROM ");
        }
        b.m33184a(C5680f.m24082a(this.f29800b));
        if (this.f29799a instanceof C7132g) {
            b.m33188b().m33185a("AS", this.f29801c);
            for (C7130e a : this.f29802d) {
                b.m33189b(a.mo5061a());
            }
        } else {
            b.m33188b();
        }
        return b.mo5061a();
    }

    /* renamed from: f */
    public C5687a mo6281f() {
        return this.f29799a;
    }
}

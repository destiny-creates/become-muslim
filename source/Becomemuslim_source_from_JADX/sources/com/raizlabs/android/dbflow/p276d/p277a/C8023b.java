package com.raizlabs.android.dbflow.p276d.p277a;

import com.raizlabs.android.dbflow.p276d.C7135b;
import com.raizlabs.android.dbflow.p276d.p278b.C7128b;
import com.raizlabs.android.dbflow.p281e.C5698h;

/* compiled from: Condition */
/* renamed from: com.raizlabs.android.dbflow.d.a.b */
public class C8023b extends C7126a {
    /* renamed from: a */
    public /* bridge */ /* synthetic */ Object mo6274a() {
        return super.mo6274a();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ String mo6277b() {
        return super.mo6277b();
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ String mo5058c() {
        return super.mo5058c();
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ boolean mo5059d() {
        return super.mo5059d();
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ String mo6278e() {
        return super.mo6278e();
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ String mo6279f() {
        return super.mo6279f();
    }

    /* renamed from: a */
    public static C8023b m38874a(String str) {
        return new C8023b(C7128b.m33167a(str));
    }

    private C8023b(C7128b c7128b) {
        super(c7128b);
    }

    /* renamed from: a */
    public <ModelClass extends C5698h> void mo6275a(C8024c<ModelClass> c8024c) {
        ((C8024c) c8024c.m33189b((Object) mo6277b())).m33189b((Object) mo6278e());
        if (this.g) {
            c8024c.m33189b(this.f ? mo6274a() : c8024c.m38890c(mo6274a()));
        }
        if (mo6279f() != null) {
            ((C8024c) c8024c.m33188b()).m33189b((Object) mo6279f());
        }
    }

    /* renamed from: a */
    public void mo6276a(C7135b c7135b) {
        c7135b.m33189b(mo6277b());
        c7135b.m33189b(mo6278e()).m33189b(mo6274a());
        if (mo6279f() != null) {
            c7135b.m33188b().m33189b(mo6279f());
        }
    }

    /* renamed from: a */
    public C8023b m38875a(Object obj) {
        this.a = "=";
        return m38881c(obj);
    }

    /* renamed from: b */
    public C8023b m38879b(Object obj) {
        return m38875a(obj);
    }

    /* renamed from: c */
    public C8023b m38881c(Object obj) {
        this.b = obj;
        this.g = true;
        return this;
    }
}

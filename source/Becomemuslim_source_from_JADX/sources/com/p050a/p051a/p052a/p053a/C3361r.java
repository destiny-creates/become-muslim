package com.p050a.p051a.p052a.p053a;

import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p056c.p058b.C3382q;
import com.p050a.p051a.p056c.p058b.C3382q.C0906a;
import com.p050a.p051a.p056c.p059c.C4529a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent */
/* renamed from: com.a.a.a.a.r */
public class C3361r implements C0880b, C0884a {
    /* renamed from: a */
    private final String f8922a;
    /* renamed from: b */
    private final List<C0884a> f8923b = new ArrayList();
    /* renamed from: c */
    private final C0906a f8924c;
    /* renamed from: d */
    private final C0885a<?, Float> f8925d;
    /* renamed from: e */
    private final C0885a<?, Float> f8926e;
    /* renamed from: f */
    private final C0885a<?, Float> f8927f;

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
    }

    public C3361r(C4529a c4529a, C3382q c3382q) {
        this.f8922a = c3382q.m10765a();
        this.f8924c = c3382q.m10766b();
        this.f8925d = c3382q.m10768d().mo737a();
        this.f8926e = c3382q.m10767c().mo737a();
        this.f8927f = c3382q.m10769e().mo737a();
        c4529a.m15378a(this.f8925d);
        c4529a.m15378a(this.f8926e);
        c4529a.m15378a(this.f8927f);
        this.f8925d.m3133a((C0884a) this);
        this.f8926e.m3133a((C0884a) this);
        this.f8927f.m3133a((C0884a) this);
    }

    /* renamed from: a */
    public void mo728a() {
        for (int i = 0; i < this.f8923b.size(); i++) {
            ((C0884a) this.f8923b.get(i)).mo728a();
        }
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f8922a;
    }

    /* renamed from: a */
    void m10666a(C0884a c0884a) {
        this.f8923b.add(c0884a);
    }

    /* renamed from: c */
    C0906a m10669c() {
        return this.f8924c;
    }

    /* renamed from: d */
    public C0885a<?, Float> m10670d() {
        return this.f8925d;
    }

    /* renamed from: e */
    public C0885a<?, Float> m10671e() {
        return this.f8926e;
    }

    /* renamed from: f */
    public C0885a<?, Float> m10672f() {
        return this.f8927f;
    }
}

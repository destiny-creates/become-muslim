package io.p347a.p348a.p349a;

import io.p347a.p348a.p349a.p350a.p352b.C6443t;
import io.p347a.p348a.p349a.p350a.p353c.C6460e;
import io.p347a.p348a.p349a.p350a.p353c.C6466m;
import io.p347a.p348a.p349a.p350a.p353c.C7611f;

/* compiled from: InitializationTask */
/* renamed from: io.a.a.a.h */
class C8186h<Result> extends C7611f<Void, Void, Result> {
    /* renamed from: a */
    final C6520i<Result> f30388a;

    public C8186h(C6520i<Result> c6520i) {
        this.f30388a = c6520i;
    }

    /* renamed from: a */
    protected void mo6418a() {
        super.mo6418a();
        C6443t a = m39746a("onPreExecute");
        try {
            boolean d_ = this.f30388a.d_();
            a.m26449b();
            if (d_) {
                return;
            }
        } catch (C6466m e) {
            throw e;
        } catch (Throwable e2) {
            C6514c.m26634h().mo5480e("Fabric", "Failure onPreExecute()", e2);
            a.m26449b();
        } catch (Throwable th) {
            a.m26449b();
            m26466a(true);
        }
        m26466a(true);
    }

    /* renamed from: a */
    protected Result m39748a(Void... voidArr) {
        voidArr = m39746a("doInBackground");
        Result f = !m26469e() ? this.f30388a.mo5489f() : null;
        voidArr.m26449b();
        return f;
    }

    /* renamed from: a */
    protected void mo6419a(Result result) {
        this.f30388a.m26663a((Object) result);
        this.f30388a.f21020h.mo5485a((Object) result);
    }

    /* renamed from: b */
    protected void mo6420b(Result result) {
        this.f30388a.m26665b((Object) result);
        result = new StringBuilder();
        result.append(this.f30388a.mo5487b());
        result.append(" Initialization was cancelled");
        this.f30388a.f21020h.mo5484a(new C6519g(result.toString()));
    }

    /* renamed from: b */
    public C6460e mo5441b() {
        return C6460e.HIGH;
    }

    /* renamed from: a */
    private C6443t m39746a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f30388a.mo5487b());
        stringBuilder.append(".");
        stringBuilder.append(str);
        C6443t c6443t = new C6443t(stringBuilder.toString(), "KitInitialization");
        c6443t.m26448a();
        return c6443t;
    }
}

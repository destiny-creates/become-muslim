package io.p347a.p348a.p349a;

import android.content.Context;
import io.p347a.p348a.p349a.p350a.p352b.C6436o;
import io.p347a.p348a.p349a.p350a.p353c.C6459d;
import io.p347a.p348a.p349a.p350a.p353c.C6465l;
import java.io.File;
import java.util.Collection;

/* compiled from: Kit */
/* renamed from: io.a.a.a.i */
public abstract class C6520i<Result> implements Comparable<C6520i> {
    /* renamed from: e */
    C6514c f21017e;
    /* renamed from: f */
    C8186h<Result> f21018f = new C8186h(this);
    /* renamed from: g */
    Context f21019g;
    /* renamed from: h */
    C6518f<Result> f21020h;
    /* renamed from: i */
    C6436o f21021i;

    /* renamed from: a */
    public abstract String mo5486a();

    /* renamed from: a */
    protected void m26663a(Result result) {
    }

    /* renamed from: b */
    public abstract String mo5487b();

    /* renamed from: b */
    protected void m26665b(Result result) {
    }

    protected boolean d_() {
        return true;
    }

    /* renamed from: f */
    protected abstract Result mo5489f();

    public /* synthetic */ int compareTo(Object obj) {
        return m26660a((C6520i) obj);
    }

    /* renamed from: a */
    void m26662a(Context context, C6514c c6514c, C6518f<Result> c6518f, C6436o c6436o) {
        this.f21017e = c6514c;
        this.f21019g = new C6515d(context, mo5487b(), m26657G());
        this.f21020h = c6518f;
        this.f21021i = c6436o;
    }

    /* renamed from: C */
    final void m26653C() {
        this.f21018f.m34348a(this.f21017e.m26646f(), (Void) null);
    }

    /* renamed from: D */
    protected C6436o m26654D() {
        return this.f21021i;
    }

    /* renamed from: E */
    public Context m26655E() {
        return this.f21019g;
    }

    /* renamed from: F */
    public C6514c m26656F() {
        return this.f21017e;
    }

    /* renamed from: G */
    public String m26657G() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".Fabric");
        stringBuilder.append(File.separator);
        stringBuilder.append(mo5487b());
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public int m26660a(C6520i c6520i) {
        if (m26666b(c6520i)) {
            return 1;
        }
        if (c6520i.m26666b(this)) {
            return -1;
        }
        if (m26658H() && !c6520i.m26658H()) {
            return 1;
        }
        if (m26658H() || c6520i.m26658H() == null) {
            return null;
        }
        return -1;
    }

    /* renamed from: b */
    boolean m26666b(C6520i c6520i) {
        C6459d c6459d = (C6459d) getClass().getAnnotation(C6459d.class);
        if (c6459d != null) {
            for (Object equals : c6459d.m26483a()) {
                if (equals.equals(c6520i.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: H */
    boolean m26658H() {
        return ((C6459d) getClass().getAnnotation(C6459d.class)) != null;
    }

    /* renamed from: I */
    protected Collection<C6465l> m26659I() {
        return this.f21018f.mo5443c();
    }
}

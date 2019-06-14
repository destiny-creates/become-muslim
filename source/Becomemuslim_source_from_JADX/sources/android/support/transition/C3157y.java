package android.support.transition;

import android.support.transition.C0254u.C0252b;
import android.support.transition.C0254u.C0253c;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet */
/* renamed from: android.support.transition.y */
public class C3157y extends C0254u {
    /* renamed from: g */
    private ArrayList<C0254u> f8103g = new ArrayList();
    /* renamed from: h */
    private boolean f8104h = true;
    /* renamed from: i */
    private int f8105i;
    /* renamed from: j */
    private boolean f8106j = false;

    /* compiled from: TransitionSet */
    /* renamed from: android.support.transition.y$a */
    static class C4451a extends C3156v {
        /* renamed from: a */
        C3157y f11898a;

        C4451a(C3157y c3157y) {
            this.f11898a = c3157y;
        }

        /* renamed from: d */
        public void mo102d(C0254u c0254u) {
            if (this.f11898a.f8106j == null) {
                this.f11898a.m671j();
                this.f11898a.f8106j = true;
            }
        }

        /* renamed from: a */
        public void mo99a(C0254u c0254u) {
            C3157y.m9358b(this.f11898a);
            if (this.f11898a.f8105i == 0) {
                this.f11898a.f8106j = false;
                this.f11898a.m672k();
            }
            c0254u.mo151b((C0253c) this);
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m9358b(C3157y c3157y) {
        int i = c3157y.f8105i - 1;
        c3157y.f8105i = i;
        return i;
    }

    /* renamed from: a */
    public /* synthetic */ C0254u mo145a(long j) {
        return m9375c(j);
    }

    /* renamed from: a */
    public /* synthetic */ C0254u mo146a(C0253c c0253c) {
        return m9376c(c0253c);
    }

    /* renamed from: b */
    public /* synthetic */ C0254u mo150b(long j) {
        return m9378d(j);
    }

    /* renamed from: b */
    public /* synthetic */ C0254u mo151b(C0253c c0253c) {
        return m9379d(c0253c);
    }

    /* renamed from: b */
    public /* synthetic */ C0254u mo152b(View view) {
        return m9383f(view);
    }

    /* renamed from: c */
    public /* synthetic */ C0254u mo153c(View view) {
        return m9384g(view);
    }

    public /* synthetic */ Object clone() {
        return mo159m();
    }

    /* renamed from: a */
    public C3157y m9363a(int i) {
        switch (i) {
            case 0:
                this.f8104h = true;
                break;
            case 1:
                this.f8104h = false;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid parameter for TransitionSet ordering: ");
                stringBuilder.append(i);
                throw new AndroidRuntimeException(stringBuilder.toString());
        }
        return this;
    }

    /* renamed from: b */
    public C3157y m9372b(C0254u c0254u) {
        this.f8103g.add(c0254u);
        c0254u.f629d = this;
        if (this.a >= 0) {
            c0254u.mo145a(this.a);
        }
        return this;
    }

    /* renamed from: o */
    public int mo160o() {
        return this.f8103g.size();
    }

    /* renamed from: b */
    public C0254u m9368b(int i) {
        if (i >= 0) {
            if (i < this.f8103g.size()) {
                return (C0254u) this.f8103g.get(i);
            }
        }
        return 0;
    }

    /* renamed from: c */
    public C3157y m9375c(long j) {
        super.mo145a(j);
        if (this.a >= 0) {
            int size = this.f8103g.size();
            for (int i = 0; i < size; i++) {
                ((C0254u) this.f8103g.get(i)).mo145a(j);
            }
        }
        return this;
    }

    /* renamed from: d */
    public C3157y m9378d(long j) {
        return (C3157y) super.mo150b(j);
    }

    /* renamed from: f */
    public C3157y m9383f(View view) {
        for (int i = 0; i < this.f8103g.size(); i++) {
            ((C0254u) this.f8103g.get(i)).mo152b(view);
        }
        return (C3157y) super.mo152b(view);
    }

    /* renamed from: c */
    public C3157y m9376c(C0253c c0253c) {
        return (C3157y) super.mo146a(c0253c);
    }

    /* renamed from: g */
    public C3157y m9384g(View view) {
        for (int i = 0; i < this.f8103g.size(); i++) {
            ((C0254u) this.f8103g.get(i)).mo153c(view);
        }
        return (C3157y) super.mo153c(view);
    }

    /* renamed from: d */
    public C3157y m9379d(C0253c c0253c) {
        return (C3157y) super.mo151b(c0253c);
    }

    /* renamed from: p */
    private void m9360p() {
        C0253c c4451a = new C4451a(this);
        Iterator it = this.f8103g.iterator();
        while (it.hasNext()) {
            ((C0254u) it.next()).mo146a(c4451a);
        }
        this.f8105i = this.f8103g.size();
    }

    /* renamed from: a */
    protected void mo149a(ViewGroup viewGroup, ab abVar, ab abVar2, ArrayList<aa> arrayList, ArrayList<aa> arrayList2) {
        long c = m660c();
        int size = this.f8103g.size();
        int i = 0;
        while (i < size) {
            C0254u c0254u = (C0254u) r0.f8103g.get(i);
            if (c > 0 && (r0.f8104h || i == 0)) {
                long c2 = c0254u.m660c();
                if (c2 > 0) {
                    c0254u.mo150b(c2 + c);
                } else {
                    c0254u.mo150b(c);
                }
            }
            c0254u.mo149a(viewGroup, abVar, abVar2, arrayList, arrayList2);
            i++;
        }
    }

    /* renamed from: e */
    protected void mo157e() {
        if (this.f8103g.isEmpty()) {
            m671j();
            m672k();
            return;
        }
        m9360p();
        if (this.f8104h) {
            Iterator it = this.f8103g.iterator();
            while (it.hasNext()) {
                ((C0254u) it.next()).mo157e();
            }
        } else {
            for (int i = 1; i < this.f8103g.size(); i++) {
                final C0254u c0254u = (C0254u) this.f8103g.get(i);
                ((C0254u) this.f8103g.get(i - 1)).mo146a(new C3156v(this) {
                    /* renamed from: b */
                    final /* synthetic */ C3157y f11897b;

                    /* renamed from: a */
                    public void mo99a(C0254u c0254u) {
                        c0254u.mo157e();
                        c0254u.mo151b((C0253c) this);
                    }
                });
            }
            C0254u c0254u2 = (C0254u) this.f8103g.get(0);
            if (c0254u2 != null) {
                c0254u2.mo157e();
            }
        }
    }

    /* renamed from: a */
    public void mo135a(aa aaVar) {
        if (m652a(aaVar.f542b)) {
            Iterator it = this.f8103g.iterator();
            while (it.hasNext()) {
                C0254u c0254u = (C0254u) it.next();
                if (c0254u.m652a(aaVar.f542b)) {
                    c0254u.mo135a(aaVar);
                    aaVar.f543c.add(c0254u);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo138b(aa aaVar) {
        if (m652a(aaVar.f542b)) {
            Iterator it = this.f8103g.iterator();
            while (it.hasNext()) {
                C0254u c0254u = (C0254u) it.next();
                if (c0254u.m652a(aaVar.f542b)) {
                    c0254u.mo138b(aaVar);
                    aaVar.f543c.add(c0254u);
                }
            }
        }
    }

    /* renamed from: c */
    void mo154c(aa aaVar) {
        super.mo154c(aaVar);
        int size = this.f8103g.size();
        for (int i = 0; i < size; i++) {
            ((C0254u) this.f8103g.get(i)).mo154c(aaVar);
        }
    }

    /* renamed from: d */
    public void mo156d(View view) {
        super.mo156d(view);
        int size = this.f8103g.size();
        for (int i = 0; i < size; i++) {
            ((C0254u) this.f8103g.get(i)).mo156d(view);
        }
    }

    /* renamed from: e */
    public void mo158e(View view) {
        super.mo158e(view);
        int size = this.f8103g.size();
        for (int i = 0; i < size; i++) {
            ((C0254u) this.f8103g.get(i)).mo158e(view);
        }
    }

    /* renamed from: a */
    public void mo148a(C0252b c0252b) {
        super.mo148a(c0252b);
        int size = this.f8103g.size();
        for (int i = 0; i < size; i++) {
            ((C0254u) this.f8103g.get(i)).mo148a(c0252b);
        }
    }

    /* renamed from: a */
    String mo147a(String str) {
        String a = super.mo147a(str);
        for (int i = 0; i < this.f8103g.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            C0254u c0254u = (C0254u) this.f8103g.get(i);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("  ");
            stringBuilder.append(c0254u.mo147a(stringBuilder2.toString()));
            a = stringBuilder.toString();
        }
        return a;
    }

    /* renamed from: m */
    public C0254u mo159m() {
        C3157y c3157y = (C3157y) super.mo159m();
        c3157y.f8103g = new ArrayList();
        int size = this.f8103g.size();
        for (int i = 0; i < size; i++) {
            c3157y.m9372b(((C0254u) this.f8103g.get(i)).mo159m());
        }
        return c3157y;
    }
}

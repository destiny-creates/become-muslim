package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;

/* compiled from: CardViewApi21Impl */
class ad implements ag {
    /* renamed from: a */
    public void mo607a() {
    }

    ad() {
    }

    /* renamed from: a */
    public void mo609a(af afVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        afVar.mo517a(new bc(colorStateList, f));
        context = afVar.mo521d();
        context.setClipToOutline(true);
        context.setElevation(f2);
        mo612b(afVar, f3);
    }

    /* renamed from: a */
    public void mo608a(af afVar, float f) {
        m10371j(afVar).m2710a(f);
    }

    /* renamed from: b */
    public void mo612b(af afVar, float f) {
        m10371j(afVar).m2711a(f, afVar.mo518a(), afVar.mo519b());
        m10383f(afVar);
    }

    /* renamed from: a */
    public float mo606a(af afVar) {
        return m10371j(afVar).m2709a();
    }

    /* renamed from: b */
    public float mo611b(af afVar) {
        return mo615d(afVar) * 2.0f;
    }

    /* renamed from: c */
    public float mo613c(af afVar) {
        return mo615d(afVar) * 2.0f;
    }

    /* renamed from: d */
    public float mo615d(af afVar) {
        return m10371j(afVar).m2713b();
    }

    /* renamed from: c */
    public void mo614c(af afVar, float f) {
        afVar.mo521d().setElevation(f);
    }

    /* renamed from: e */
    public float mo616e(af afVar) {
        return afVar.mo521d().getElevation();
    }

    /* renamed from: f */
    public void m10383f(af afVar) {
        if (afVar.mo518a()) {
            float a = mo606a(afVar);
            float d = mo615d(afVar);
            int ceil = (int) Math.ceil((double) bd.m2719b(a, d, afVar.mo519b()));
            int ceil2 = (int) Math.ceil((double) bd.m2716a(a, d, afVar.mo519b()));
            afVar.mo516a(ceil, ceil2, ceil, ceil2);
            return;
        }
        afVar.mo516a(0, 0, 0, 0);
    }

    /* renamed from: g */
    public void mo617g(af afVar) {
        mo612b(afVar, mo606a(afVar));
    }

    /* renamed from: h */
    public void mo618h(af afVar) {
        mo612b(afVar, mo606a(afVar));
    }

    /* renamed from: a */
    public void mo610a(af afVar, ColorStateList colorStateList) {
        m10371j(afVar).m2712a(colorStateList);
    }

    /* renamed from: i */
    public ColorStateList mo619i(af afVar) {
        return m10371j(afVar).m2714c();
    }

    /* renamed from: j */
    private bc m10371j(af afVar) {
        return (bc) afVar.mo520c();
    }
}

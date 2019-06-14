package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: FragmentController */
/* renamed from: android.support.v4.app.l */
public class C0306l {
    /* renamed from: a */
    private final C3179m<?> f824a;

    /* renamed from: a */
    public static C0306l m896a(C3179m<?> c3179m) {
        return new C0306l(c3179m);
    }

    private C0306l(C3179m<?> c3179m) {
        this.f824a = c3179m;
    }

    /* renamed from: a */
    public C0309n m898a() {
        return this.f824a.m9500k();
    }

    /* renamed from: a */
    public C3178i m897a(String str) {
        return this.f824a.f8174d.m9569b(str);
    }

    /* renamed from: a */
    public void m902a(C3178i c3178i) {
        this.f824a.f8174d.m9559a(this.f824a, this.f824a, c3178i);
    }

    /* renamed from: a */
    public View m899a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f824a.f8174d.onCreateView(view, str, context, attributeSet);
    }

    /* renamed from: b */
    public void m907b() {
        this.f824a.f8174d.m9607l();
    }

    /* renamed from: c */
    public Parcelable m911c() {
        return this.f824a.f8174d.m9605k();
    }

    /* renamed from: a */
    public void m901a(Parcelable parcelable, C0321p c0321p) {
        this.f824a.f8174d.m9552a(parcelable, c0321p);
    }

    /* renamed from: d */
    public C0321p m912d() {
        return this.f824a.f8174d.m9601i();
    }

    /* renamed from: e */
    public void m913e() {
        this.f824a.f8174d.m9609m();
    }

    /* renamed from: f */
    public void m914f() {
        this.f824a.f8174d.m9612n();
    }

    /* renamed from: g */
    public void m915g() {
        this.f824a.f8174d.m9613o();
    }

    /* renamed from: h */
    public void m916h() {
        this.f824a.f8174d.m9615p();
    }

    /* renamed from: i */
    public void m917i() {
        this.f824a.f8174d.m9616q();
    }

    /* renamed from: j */
    public void m918j() {
        this.f824a.f8174d.m9617r();
    }

    /* renamed from: k */
    public void m919k() {
        this.f824a.f8174d.m9618s();
    }

    /* renamed from: l */
    public void m920l() {
        this.f824a.f8174d.m9620u();
    }

    /* renamed from: a */
    public void m903a(boolean z) {
        this.f824a.f8174d.m9562a(z);
    }

    /* renamed from: b */
    public void m909b(boolean z) {
        this.f824a.f8174d.m9577b(z);
    }

    /* renamed from: a */
    public void m900a(Configuration configuration) {
        this.f824a.f8174d.m9550a(configuration);
    }

    /* renamed from: m */
    public void m921m() {
        this.f824a.f8174d.m9621v();
    }

    /* renamed from: a */
    public boolean m905a(Menu menu, MenuInflater menuInflater) {
        return this.f824a.f8174d.m9565a(menu, menuInflater);
    }

    /* renamed from: a */
    public boolean m904a(Menu menu) {
        return this.f824a.f8174d.m9564a(menu);
    }

    /* renamed from: a */
    public boolean m906a(MenuItem menuItem) {
        return this.f824a.f8174d.m9566a(menuItem);
    }

    /* renamed from: b */
    public boolean m910b(MenuItem menuItem) {
        return this.f824a.f8174d.m9579b(menuItem);
    }

    /* renamed from: b */
    public void m908b(Menu menu) {
        this.f824a.f8174d.m9576b(menu);
    }

    /* renamed from: n */
    public boolean m922n() {
        return this.f824a.f8174d.m9594f();
    }
}

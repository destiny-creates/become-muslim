package android.support.v7.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C4890j;
import android.support.v4.app.aa;
import android.support.v4.app.al;
import android.support.v4.app.al.C0289a;
import android.support.v7.view.C0640b;
import android.support.v7.view.C0640b.C0639a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.bv;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: AppCompatActivity */
/* renamed from: android.support.v7.app.c */
public class C4908c extends C4890j implements C0289a, C0610d {
    /* renamed from: a */
    private C0611e f14104a;
    /* renamed from: b */
    private int f14105b = 0;
    /* renamed from: c */
    private Resources f14106c;

    /* renamed from: a */
    public C0640b mo384a(C0639a c0639a) {
        return null;
    }

    /* renamed from: a */
    public void mo385a(C0640b c0640b) {
    }

    /* renamed from: b */
    public void m17744b(al alVar) {
    }

    /* renamed from: b */
    public void mo386b(C0640b c0640b) {
    }

    @Deprecated
    /* renamed from: d */
    public void m17747d() {
    }

    protected void onCreate(Bundle bundle) {
        C0611e e = m17748e();
        e.mo2731h();
        e.mo2717a(bundle);
        if (e.mo374i() && this.f14105b != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f14105b, false);
            } else {
                setTheme(this.f14105b);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.f14105b = i;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m17748e().mo2724b(bundle);
    }

    /* renamed from: b */
    public C0608a m17742b() {
        return m17748e().mo367a();
    }

    /* renamed from: a */
    public void m17740a(Toolbar toolbar) {
        m17748e().mo2718a(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return m17748e().mo369b();
    }

    public void setContentView(int i) {
        m17748e().mo2723b(i);
    }

    public void setContentView(View view) {
        m17748e().mo2719a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m17748e().mo2720a(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m17748e().mo2725b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m17748e().mo2716a(configuration);
        if (this.f14106c != null) {
            this.f14106c.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    protected void onPostResume() {
        super.onPostResume();
        m17748e().mo2729e();
    }

    protected void onStart() {
        super.onStart();
        m17748e().mo370c();
    }

    protected void onStop() {
        super.onStop();
        m17748e().mo372d();
    }

    public <T extends View> T findViewById(int i) {
        return m17748e().mo2714a(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem) != 0) {
            return true;
        }
        i = m17742b();
        return (menuItem.getItemId() != 16908332 || i == 0 || (i.mo391a() & 4) == 0) ? false : m17746c();
    }

    protected void onDestroy() {
        super.onDestroy();
        m17748e().mo373g();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m17748e().mo368a(charSequence);
    }

    public void supportInvalidateOptionsMenu() {
        m17748e().mo2730f();
    }

    public void invalidateOptionsMenu() {
        m17748e().mo2730f();
    }

    /* renamed from: a */
    public void m17738a(al alVar) {
        alVar.m859a((Activity) this);
    }

    /* renamed from: c */
    public boolean m17746c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.mo3558a();
        if (r0 == 0) goto L_0x0026;
    L_0x0006:
        r1 = r2.m17741a(r0);
        if (r1 == 0) goto L_0x0021;
    L_0x000c:
        r0 = android.support.v4.app.al.m858a(r2);
        r2.m17738a(r0);
        r2.m17744b(r0);
        r0.m862a();
        android.support.v4.app.C3169a.m9425a(r2);	 Catch:{ IllegalStateException -> 0x001d }
        goto L_0x0024;
    L_0x001d:
        r2.finish();
        goto L_0x0024;
    L_0x0021:
        r2.m17743b(r0);
    L_0x0024:
        r0 = 1;
        return r0;
    L_0x0026:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.c.c():boolean");
    }

    /* renamed from: a */
    public Intent mo3558a() {
        return aa.m753a(this);
    }

    /* renamed from: a */
    public boolean m17741a(Intent intent) {
        return aa.m755a((Activity) this, intent);
    }

    /* renamed from: b */
    public void m17743b(Intent intent) {
        aa.m758b((Activity) this, intent);
    }

    public void onContentChanged() {
        m17747d();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m17748e().mo371c(bundle);
    }

    /* renamed from: e */
    public C0611e m17748e() {
        if (this.f14104a == null) {
            this.f14104a = C0611e.m2056a((Activity) this, (C0610d) this);
        }
        return this.f14104a;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        C0608a b = m17742b();
        if (keyCode == 82 && b != null && b.mo397a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.f14106c == null && bv.m2802a()) {
            this.f14106c = new bv(this, super.getResources());
        }
        return this.f14106c == null ? super.getResources() : this.f14106c;
    }

    /* renamed from: a */
    private boolean m17735a(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT < 26 && keyEvent.isCtrlPressed() == 0 && KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) == 0 && keyEvent.getRepeatCount() == 0 && KeyEvent.isModifierKey(keyEvent.getKeyCode()) == 0) {
            i = getWindow();
            if (!(i == 0 || i.getDecorView() == null || i.getDecorView().dispatchKeyShortcutEvent(keyEvent) == 0)) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (m17735a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void openOptionsMenu() {
        C0608a b = m17742b();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (b == null || !b.mo402c()) {
            super.openOptionsMenu();
        }
    }

    public void closeOptionsMenu() {
        C0608a b = m17742b();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (b == null || !b.mo403d()) {
            super.closeOptionsMenu();
        }
    }
}

package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.view.C0640b;
import android.support.v7.view.C0640b.C0639a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: AppCompatDialog */
/* renamed from: android.support.v7.app.k */
public class C3256k extends Dialog implements C0610d {
    /* renamed from: a */
    private C0611e f8355a;

    /* renamed from: a */
    public C0640b mo384a(C0639a c0639a) {
        return null;
    }

    /* renamed from: a */
    public void mo385a(C0640b c0640b) {
    }

    /* renamed from: b */
    public void mo386b(C0640b c0640b) {
    }

    public C3256k(Context context, int i) {
        super(context, C3256k.m9884a(context, i));
        m9885a().mo2717a((Bundle) 0);
        m9885a().mo374i();
    }

    protected void onCreate(Bundle bundle) {
        m9885a().mo2731h();
        super.onCreate(bundle);
        m9885a().mo2717a(bundle);
    }

    public void setContentView(int i) {
        m9885a().mo2723b(i);
    }

    public void setContentView(View view) {
        m9885a().mo2719a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m9885a().mo2720a(view, layoutParams);
    }

    public <T extends View> T findViewById(int i) {
        return m9885a().mo2714a(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m9885a().mo368a(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m9885a().mo368a(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m9885a().mo2725b(view, layoutParams);
    }

    protected void onStop() {
        super.onStop();
        m9885a().mo372d();
    }

    /* renamed from: a */
    public boolean m9888a(int i) {
        return m9885a().mo2728c(i);
    }

    public void invalidateOptionsMenu() {
        m9885a().mo2730f();
    }

    /* renamed from: a */
    public C0611e m9885a() {
        if (this.f8355a == null) {
            this.f8355a = C0611e.m2057a((Dialog) this, (C0610d) this);
        }
        return this.f8355a;
    }

    /* renamed from: a */
    private static int m9884a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        i = new TypedValue();
        context.getTheme().resolveAttribute(C0581a.dialogTheme, i, true);
        return i.resourceId;
    }
}

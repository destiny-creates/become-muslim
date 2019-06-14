package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.p035a.C0591a.C0589i;
import android.view.LayoutInflater;

/* compiled from: ContextThemeWrapper */
/* renamed from: android.support.v7.view.d */
public class C0642d extends ContextWrapper {
    /* renamed from: a */
    private int f1625a;
    /* renamed from: b */
    private Theme f1626b;
    /* renamed from: c */
    private LayoutInflater f1627c;
    /* renamed from: d */
    private Configuration f1628d;
    /* renamed from: e */
    private Resources f1629e;

    public C0642d() {
        super(null);
    }

    public C0642d(Context context, int i) {
        super(context);
        this.f1625a = i;
    }

    public C0642d(Context context, Theme theme) {
        super(context);
        this.f1626b = theme;
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public Resources getResources() {
        return m2152b();
    }

    /* renamed from: b */
    private Resources m2152b() {
        if (this.f1629e == null) {
            if (this.f1628d == null) {
                this.f1629e = super.getResources();
            } else if (VERSION.SDK_INT >= 17) {
                this.f1629e = createConfigurationContext(this.f1628d).getResources();
            }
        }
        return this.f1629e;
    }

    public void setTheme(int i) {
        if (this.f1625a != i) {
            this.f1625a = i;
            m2153c();
        }
    }

    /* renamed from: a */
    public int m2154a() {
        return this.f1625a;
    }

    public Theme getTheme() {
        if (this.f1626b != null) {
            return this.f1626b;
        }
        if (this.f1625a == 0) {
            this.f1625a = C0589i.Theme_AppCompat_Light;
        }
        m2153c();
        return this.f1626b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1627c == null) {
            this.f1627c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1627c;
    }

    /* renamed from: a */
    protected void m2155a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    /* renamed from: c */
    private void m2153c() {
        boolean z = this.f1626b == null;
        if (z) {
            this.f1626b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1626b.setTo(theme);
            }
        }
        m2155a(this.f1626b, this.f1625a, z);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}

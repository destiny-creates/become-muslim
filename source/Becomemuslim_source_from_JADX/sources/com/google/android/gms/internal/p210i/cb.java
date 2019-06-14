package com.google.android.gms.internal.p210i;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.i.cb */
public final class cb extends C6797o {
    /* renamed from: a */
    protected boolean f28813a;
    /* renamed from: b */
    protected int f28814b;
    /* renamed from: c */
    private String f28815c;
    /* renamed from: d */
    private String f28816d;
    /* renamed from: e */
    private int f28817e;
    /* renamed from: f */
    private boolean f28818f;
    /* renamed from: g */
    private boolean f28819g;

    public cb(C5008q c5008q) {
        super(c5008q);
    }

    /* renamed from: a */
    protected final void mo6145a() {
        ApplicationInfo applicationInfo;
        Context k = m21044k();
        try {
            applicationInfo = k.getPackageManager().getApplicationInfo(k.getPackageName(), 128);
        } catch (NameNotFoundException e) {
            m21034d("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            m21040h("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                bf bfVar = (bf) new bd(m21041i()).m31303a(i);
                if (bfVar != null) {
                    String str;
                    int i2;
                    m21036e("Loading global XML config values");
                    boolean z = false;
                    if ((bfVar.f24448a != null ? 1 : null) != null) {
                        str = bfVar.f24448a;
                        this.f28816d = str;
                        m21029b("XML config - app name", str);
                    }
                    if ((bfVar.f24449b != null ? 1 : null) != null) {
                        str = bfVar.f24449b;
                        this.f28815c = str;
                        m21029b("XML config - app version", str);
                    }
                    if ((bfVar.f24450c != null ? 1 : null) != null) {
                        str = bfVar.f24450c.toLowerCase(Locale.US);
                        i2 = "verbose".equals(str) ? 0 : "info".equals(str) ? 1 : "warning".equals(str) ? 2 : "error".equals(str) ? 3 : -1;
                        if (i2 >= 0) {
                            this.f28817e = i2;
                            m21026a("XML config - log level", Integer.valueOf(i2));
                        }
                    }
                    if ((bfVar.f24451d >= 0 ? 1 : null) != null) {
                        i2 = bfVar.f24451d;
                        this.f28814b = i2;
                        this.f28813a = true;
                        m21029b("XML config - dispatch period (sec)", Integer.valueOf(i2));
                    }
                    if (bfVar.f24452e != -1) {
                        if (bfVar.f24452e == 1) {
                            z = true;
                        }
                        this.f28819g = z;
                        this.f28818f = true;
                        m21029b("XML config - dry run", Boolean.valueOf(z));
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final String m37780b() {
        m31800z();
        return this.f28815c;
    }

    /* renamed from: c */
    public final String m37781c() {
        m31800z();
        return this.f28816d;
    }

    /* renamed from: d */
    public final boolean m37782d() {
        m31800z();
        return false;
    }

    /* renamed from: e */
    public final boolean m37783e() {
        m31800z();
        return this.f28818f;
    }

    /* renamed from: f */
    public final boolean m37784f() {
        m31800z();
        return this.f28819g;
    }
}

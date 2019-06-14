package com.google.android.gms.internal.p210i;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.analytics.C2721s;

/* renamed from: com.google.android.gms.internal.i.bp */
public final class bp extends C6797o {
    /* renamed from: a */
    private SharedPreferences f28809a;
    /* renamed from: b */
    private long f28810b;
    /* renamed from: c */
    private long f28811c = -1;
    /* renamed from: d */
    private final br f28812d = new br(this, "monitoring", ((Long) ba.f16367D.m20315a()).longValue());

    protected bp(C5008q c5008q) {
        super(c5008q);
    }

    /* renamed from: a */
    protected final void mo6145a() {
        this.f28809a = m21044k().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    /* renamed from: b */
    public final long m37773b() {
        C2721s.d();
        m31800z();
        if (this.f28810b == 0) {
            long j = this.f28809a.getLong("first_run", 0);
            if (j != 0) {
                this.f28810b = j;
            } else {
                j = m21043j().a();
                Editor edit = this.f28809a.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    m21040h("Failed to commit first run time");
                }
                this.f28810b = j;
            }
        }
        return this.f28810b;
    }

    /* renamed from: c */
    public final by m37774c() {
        return new by(m21043j(), m37773b());
    }

    /* renamed from: d */
    public final long m37775d() {
        C2721s.d();
        m31800z();
        if (this.f28811c == -1) {
            this.f28811c = this.f28809a.getLong("last_dispatch", 0);
        }
        return this.f28811c;
    }

    /* renamed from: e */
    public final void m37776e() {
        C2721s.d();
        m31800z();
        long a = m21043j().a();
        Editor edit = this.f28809a.edit();
        edit.putLong("last_dispatch", a);
        edit.apply();
        this.f28811c = a;
    }

    /* renamed from: f */
    public final String m37777f() {
        C2721s.d();
        m31800z();
        Object string = this.f28809a.getString("installation_campaign", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    /* renamed from: a */
    public final void m37772a(String str) {
        C2721s.d();
        m31800z();
        Editor edit = this.f28809a.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (edit.commit() == null) {
            m21040h("Failed to commit campaign data");
        }
    }

    /* renamed from: g */
    public final br m37778g() {
        return this.f28812d;
    }
}

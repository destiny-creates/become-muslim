package com.google.android.gms.internal.p210i;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.C2872v;
import java.util.UUID;

/* renamed from: com.google.android.gms.internal.i.br */
public final class br {
    /* renamed from: a */
    private final String f16432a;
    /* renamed from: b */
    private final long f16433b;
    /* renamed from: c */
    private final /* synthetic */ bp f16434c;

    private br(bp bpVar, String str, long j) {
        this.f16434c = bpVar;
        C2872v.a(str);
        C2872v.b(j > 0 ? true : null);
        this.f16432a = str;
        this.f16433b = j;
    }

    /* renamed from: b */
    private final void m20345b() {
        long a = this.f16434c.m21043j().a();
        Editor edit = this.f16434c.f28809a.edit();
        edit.remove(m20348e());
        edit.remove(m20349f());
        edit.putLong(m20347d(), a);
        edit.commit();
    }

    /* renamed from: a */
    public final void m20351a(String str) {
        if (m20346c() == 0) {
            m20345b();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j = this.f16434c.f28809a.getLong(m20348e(), 0);
            if (j <= 0) {
                Editor edit = this.f16434c.f28809a.edit();
                edit.putString(m20349f(), str);
                edit.putLong(m20348e(), 1);
                edit.apply();
                return;
            }
            j++;
            Object obj = (UUID.randomUUID().getLeastSignificantBits() & Clock.MAX_TIME) < Clock.MAX_TIME / j ? 1 : null;
            Editor edit2 = this.f16434c.f28809a.edit();
            if (obj != null) {
                edit2.putString(m20349f(), str);
            }
            edit2.putLong(m20348e(), j);
            edit2.apply();
        }
    }

    /* renamed from: a */
    public final Pair<String, Long> m20350a() {
        long c = m20346c();
        if (c == 0) {
            c = 0;
        } else {
            c = Math.abs(c - this.f16434c.m21043j().a());
        }
        if (c < this.f16433b) {
            return null;
        }
        if (c > (this.f16433b << 1)) {
            m20345b();
            return null;
        }
        String string = this.f16434c.f28809a.getString(m20349f(), null);
        long j = this.f16434c.f28809a.getLong(m20348e(), 0);
        m20345b();
        if (string != null) {
            if (j > 0) {
                return new Pair(string, Long.valueOf(j));
            }
        }
        return null;
    }

    /* renamed from: c */
    private final long m20346c() {
        return this.f16434c.f28809a.getLong(m20347d(), 0);
    }

    /* renamed from: d */
    private final String m20347d() {
        return String.valueOf(this.f16432a).concat(":start");
    }

    /* renamed from: e */
    private final String m20348e() {
        return String.valueOf(this.f16432a).concat(":count");
    }

    /* renamed from: f */
    private final String m20349f() {
        return String.valueOf(this.f16432a).concat(":value");
    }
}

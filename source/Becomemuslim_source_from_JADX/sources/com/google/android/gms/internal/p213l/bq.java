package com.google.android.gms.internal.p213l;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.l.bq */
public final class bq {
    /* renamed from: a */
    private final String f17000a;
    /* renamed from: b */
    private final String f17001b;
    /* renamed from: c */
    private final String f17002c;
    /* renamed from: d */
    private final long f17003d;
    /* renamed from: e */
    private final /* synthetic */ bm f17004e;

    private bq(bm bmVar, String str, long j) {
        this.f17004e = bmVar;
        C2872v.a(str);
        C2872v.b(j > 0);
        this.f17000a = String.valueOf(str).concat(":start");
        this.f17001b = String.valueOf(str).concat(":count");
        this.f17002c = String.valueOf(str).concat(":value");
        this.f17003d = j;
    }

    /* renamed from: b */
    private final void m21320b() {
        this.f17004e.mo6210d();
        long a = this.f17004e.mo4751m().a();
        Editor edit = this.f17004e.m42582x().edit();
        edit.remove(this.f17001b);
        edit.remove(this.f17002c);
        edit.putLong(this.f17000a, a);
        edit.apply();
    }

    /* renamed from: c */
    private final long m21321c() {
        return this.f17004e.m42582x().getLong(this.f17000a, 0);
    }

    /* renamed from: a */
    public final Pair<String, Long> m21322a() {
        this.f17004e.mo6210d();
        this.f17004e.mo6210d();
        long c = m21321c();
        if (c == 0) {
            m21320b();
            c = 0;
        } else {
            c = Math.abs(c - this.f17004e.mo4751m().a());
        }
        if (c < this.f17003d) {
            return null;
        }
        if (c > (this.f17003d << 1)) {
            m21320b();
            return null;
        }
        String string = this.f17004e.m42582x().getString(this.f17002c, null);
        long j = this.f17004e.m42582x().getLong(this.f17001b, 0);
        m21320b();
        if (string != null) {
            if (j > 0) {
                return new Pair(string, Long.valueOf(j));
            }
        }
        return bm.f32324a;
    }

    /* renamed from: a */
    public final void m21323a(String str, long j) {
        this.f17004e.mo6210d();
        if (m21321c() == 0) {
            m21320b();
        }
        if (str == null) {
            str = "";
        }
        j = this.f17004e.m42582x().getLong(this.f17001b, 0);
        if (j <= 0) {
            Editor edit = this.f17004e.m42582x().edit();
            edit.putString(this.f17002c, str);
            edit.putLong(this.f17001b, 1);
            edit.apply();
            return;
        }
        j++;
        Object obj = (this.f17004e.mo6213p().m42681h().nextLong() & Clock.MAX_TIME) < Clock.MAX_TIME / j ? 1 : null;
        Editor edit2 = this.f17004e.m42582x().edit();
        if (obj != null) {
            edit2.putString(this.f17002c, str);
        }
        edit2.putLong(this.f17001b, j);
        edit2.apply();
    }
}

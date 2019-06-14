package com.google.android.gms.internal.p210i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.analytics.C2721s;
import com.google.android.gms.analytics.C4746d;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;

/* renamed from: com.google.android.gms.internal.i.n */
public class C5006n {
    /* renamed from: a */
    private final C5008q f16812a;

    protected C5006n(C5008q c5008q) {
        C2872v.a(c5008q);
        this.f16812a = c5008q;
    }

    /* renamed from: i */
    public final C5008q m21041i() {
        return this.f16812a;
    }

    /* renamed from: j */
    protected final C2895e m21043j() {
        return this.f16812a.m21061c();
    }

    /* renamed from: k */
    protected final Context m21044k() {
        return this.f16812a.m21059a();
    }

    /* renamed from: l */
    protected final bl m21045l() {
        return this.f16812a.m21063e();
    }

    /* renamed from: m */
    protected final as m21046m() {
        return this.f16812a.m21062d();
    }

    /* renamed from: n */
    protected final C2721s m21047n() {
        return this.f16812a.m21065g();
    }

    /* renamed from: o */
    public final C4746d m21048o() {
        return this.f16812a.m21068j();
    }

    /* renamed from: p */
    protected final C7816f m21049p() {
        return this.f16812a.m21066h();
    }

    /* renamed from: q */
    protected final ax m21050q() {
        return this.f16812a.m21067i();
    }

    /* renamed from: r */
    protected final cb m21051r() {
        return this.f16812a.m21069k();
    }

    /* renamed from: s */
    protected final bp m21052s() {
        return this.f16812a.m21070l();
    }

    /* renamed from: t */
    protected final aj m21053t() {
        return this.f16812a.m21073o();
    }

    /* renamed from: u */
    protected final C7812e m21054u() {
        return this.f16812a.m21072n();
    }

    /* renamed from: v */
    protected final ac m21055v() {
        return this.f16812a.m21074p();
    }

    /* renamed from: w */
    protected final aw m21056w() {
        return this.f16812a.m21075q();
    }

    /* renamed from: e */
    public final void m21036e(String str) {
        mo6146a(2, str, null, null, null);
    }

    /* renamed from: a */
    public final void m21026a(String str, Object obj) {
        mo6146a(2, str, obj, null, null);
    }

    /* renamed from: a */
    public final void m21027a(String str, Object obj, Object obj2) {
        mo6146a(2, str, obj, obj2, null);
    }

    /* renamed from: f */
    public final void m21038f(String str) {
        mo6146a(3, str, null, null, null);
    }

    /* renamed from: b */
    public final void m21029b(String str, Object obj) {
        mo6146a(3, str, obj, null, null);
    }

    /* renamed from: b */
    public final void m21030b(String str, Object obj, Object obj2) {
        mo6146a(3, str, obj, obj2, null);
    }

    /* renamed from: a */
    public final void m21028a(String str, Object obj, Object obj2, Object obj3) {
        mo6146a(3, str, obj, obj2, obj3);
    }

    /* renamed from: g */
    public final void m21039g(String str) {
        mo6146a(4, str, null, null, null);
    }

    /* renamed from: c */
    public final void m21032c(String str, Object obj) {
        mo6146a(4, str, obj, null, null);
    }

    /* renamed from: h */
    public final void m21040h(String str) {
        mo6146a(5, str, null, null, null);
    }

    /* renamed from: d */
    public final void m21034d(String str, Object obj) {
        mo6146a(5, str, obj, null, null);
    }

    /* renamed from: c */
    public final void m21033c(String str, Object obj, Object obj2) {
        mo6146a(5, str, obj, obj2, null);
    }

    /* renamed from: b */
    public final void m21031b(String str, Object obj, Object obj2, Object obj3) {
        mo6146a(5, str, obj, obj2, obj3);
    }

    /* renamed from: i */
    public final void m21042i(String str) {
        mo6146a(6, str, null, null, null);
    }

    /* renamed from: e */
    public final void m21037e(String str, Object obj) {
        mo6146a(6, str, obj, null, null);
    }

    /* renamed from: d */
    public final void m21035d(String str, Object obj, Object obj2) {
        mo6146a(6, str, obj, obj2, null);
    }

    /* renamed from: x */
    public static boolean m21025x() {
        return Log.isLoggable((String) ba.f16383b.m20315a(), 2);
    }

    /* renamed from: a */
    private final void mo6146a(int i, String str, Object obj, Object obj2, Object obj3) {
        bl f = this.f16812a != null ? this.f16812a.m21064f() : null;
        String str2;
        if (f != null) {
            str2 = (String) ba.f16383b.m20315a();
            if (Log.isLoggable(str2, i)) {
                Log.println(i, str2, C5006n.m21024c(str, obj, obj2, obj3));
            }
            if (i >= 5) {
                f.mo6146a(i, str, obj, obj2, obj3);
            }
            return;
        }
        str2 = (String) ba.f16383b.m20315a();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, C5006n.m21024c(str, obj, obj2, obj3));
        }
    }

    /* renamed from: c */
    protected static String m21024c(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        obj = C5006n.m21022a(obj);
        obj2 = C5006n.m21022a(obj2);
        obj3 = C5006n.m21022a(obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
            str2 = ": ";
        }
        if (TextUtils.isEmpty(obj) == null) {
            stringBuilder.append(str2);
            stringBuilder.append(obj);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(obj2) == null) {
            stringBuilder.append(str2);
            stringBuilder.append(obj2);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(obj3) == null) {
            stringBuilder.append(str2);
            stringBuilder.append(obj3);
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static String m21022a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Boolean) {
            return obj == Boolean.TRUE ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        } else {
            if (obj instanceof Throwable) {
                return ((Throwable) obj).toString();
            }
            return obj.toString();
        }
    }
}

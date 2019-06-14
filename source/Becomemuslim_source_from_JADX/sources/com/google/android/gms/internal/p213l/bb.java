package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.measurement.AppMeasurement;

/* renamed from: com.google.android.gms.internal.l.bb */
public final class bb extends dc {
    /* renamed from: a */
    private char f32312a = '\u0000';
    /* renamed from: b */
    private long f32313b = -1;
    /* renamed from: c */
    private String f32314c;
    /* renamed from: d */
    private final bd f32315d = new bd(this, 6, false, false);
    /* renamed from: e */
    private final bd f32316e = new bd(this, 6, true, false);
    /* renamed from: f */
    private final bd f32317f = new bd(this, 6, false, true);
    /* renamed from: g */
    private final bd f32318g = new bd(this, 5, false, false);
    /* renamed from: h */
    private final bd f32319h = new bd(this, 5, true, false);
    /* renamed from: i */
    private final bd f32320i = new bd(this, 5, false, true);
    /* renamed from: j */
    private final bd f32321j = new bd(this, 4, false, false);
    /* renamed from: k */
    private final bd f32322k = new bd(this, 3, false, false);
    /* renamed from: l */
    private final bd f32323l = new bd(this, 2, false, false);

    bb(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: C */
    private final String m42546C() {
        String str;
        synchronized (this) {
            if (this.f32314c == null) {
                this.f32314c = aa.m38031e();
            }
            str = this.f32314c;
        }
        return str;
    }

    /* renamed from: a */
    protected static Object m42550a(String str) {
        return str == null ? null : new be(str);
    }

    /* renamed from: a */
    private static String m42551a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        String valueOf;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length());
            stringBuilder.append(str);
            stringBuilder.append(round);
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(round2);
            return stringBuilder.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (!(obj instanceof Throwable)) {
                return obj instanceof be ? ((be) obj).f16971a : z ? "-" : String.valueOf(obj);
            } else {
                Throwable th = (Throwable) obj;
                StringBuilder stringBuilder2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                valueOf = bb.m42554b(AppMeasurement.class.getCanonicalName());
                String b = bb.m42554b(cg.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (i < length) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = bb.m42554b(className);
                            if (className.equals(valueOf) || className.equals(b)) {
                                stringBuilder2.append(": ");
                                stringBuilder2.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                return stringBuilder2.toString();
            }
        }
    }

    /* renamed from: a */
    static String m42552a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        obj = bb.m42551a(z, obj);
        obj2 = bb.m42551a(z, obj2);
        Object a = bb.m42551a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(obj)) {
            stringBuilder.append(str2);
            stringBuilder.append(obj);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(obj2)) {
            stringBuilder.append(str2);
            stringBuilder.append(obj2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private static String m42554b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    public final bd I_() {
        return this.f32315d;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    protected final void m42556a(int i, String str) {
        Log.println(i, m42546C(), str);
    }

    /* renamed from: a */
    protected final void m42557a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && m42558a(i)) {
            m42556a(i, bb.m42552a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            String str2;
            C2872v.a(str);
            dc g = this.q.m31965g();
            if (g == null) {
                str2 = "Scheduler not set. Not logging error/warn";
            } else if (g.m38103y()) {
                if (i < 0) {
                    i = 0;
                }
                g.m42612a(new bc(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
            } else {
                str2 = "Scheduler not initialized. Not logging error/warn";
            }
            m42556a(6, str2);
        }
    }

    /* renamed from: a */
    protected final boolean m42558a(int i) {
        return Log.isLoggable(m42546C(), i);
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: e */
    protected final boolean mo6739e() {
        return false;
    }

    /* renamed from: g */
    public final bd m42563g() {
        return this.f32316e;
    }

    /* renamed from: h */
    public final bd m42564h() {
        return this.f32317f;
    }

    /* renamed from: i */
    public final bd m42565i() {
        return this.f32318g;
    }

    /* renamed from: j */
    public final bd m42566j() {
        return this.f32320i;
    }

    /* renamed from: k */
    public final bd m42567k() {
        return this.f32321j;
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }

    /* renamed from: v */
    public final bd m42578v() {
        return this.f32322k;
    }

    /* renamed from: w */
    public final bd m42579w() {
        return this.f32323l;
    }

    /* renamed from: x */
    public final String m42580x() {
        Pair a = mo6214s().f32325b.m21322a();
        if (a != null) {
            if (a != bm.f32324a) {
                String valueOf = String.valueOf(a.second);
                String str = (String) a.first;
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length());
                stringBuilder.append(valueOf);
                stringBuilder.append(":");
                stringBuilder.append(str);
                return stringBuilder.toString();
            }
        }
        return null;
    }
}

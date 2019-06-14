package com.p073d.p074a.p075a;

import android.util.Log;
import com.p073d.p074a.C1133a.C1126b;

/* compiled from: Logger */
/* renamed from: com.d.a.a.f */
public final class C1132f {
    /* renamed from: a */
    public final C1126b f3203a;
    /* renamed from: b */
    private final String f3204b;

    public C1132f(String str, C1126b c1126b) {
        this.f3204b = str;
        this.f3203a = c1126b;
    }

    /* renamed from: a */
    public void m3970a(String str, Object... objArr) {
        if (m3969b(C1126b.VERBOSE)) {
            Log.v(this.f3204b, String.format(str, objArr));
        }
    }

    /* renamed from: b */
    public void m3972b(String str, Object... objArr) {
        if (m3969b(C1126b.INFO)) {
            Log.i(this.f3204b, String.format(str, objArr));
        }
    }

    /* renamed from: c */
    public void m3973c(String str, Object... objArr) {
        if (m3969b(C1126b.DEBUG)) {
            Log.d(this.f3204b, String.format(str, objArr));
        }
    }

    /* renamed from: a */
    public void m3971a(Throwable th, String str, Object... objArr) {
        if (m3969b(C1126b.INFO)) {
            Log.e(this.f3204b, String.format(str, objArr), th);
        }
    }

    /* renamed from: a */
    public static C1132f m3968a(C1126b c1126b) {
        return new C1132f("Analytics", c1126b);
    }

    /* renamed from: b */
    private boolean m3969b(C1126b c1126b) {
        return this.f3203a.ordinal() >= c1126b.ordinal() ? true : null;
    }
}

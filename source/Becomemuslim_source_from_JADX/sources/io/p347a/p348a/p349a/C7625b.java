package io.p347a.p348a.p349a;

import android.util.Log;

/* compiled from: DefaultLogger */
/* renamed from: io.a.a.a.b */
public class C7625b implements C6523l {
    /* renamed from: a */
    private int f26343a;

    public C7625b(int i) {
        this.f26343a = i;
    }

    public C7625b() {
        this.f26343a = 4;
    }

    /* renamed from: a */
    public boolean mo5474a(String str, int i) {
        return this.f26343a <= i ? true : null;
    }

    /* renamed from: a */
    public void mo5473a(String str, String str2, Throwable th) {
        if (mo5474a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    /* renamed from: b */
    public void m34438b(String str, String str2, Throwable th) {
        if (mo5474a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    /* renamed from: c */
    public void m34440c(String str, String str2, Throwable th) {
        if (mo5474a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    /* renamed from: d */
    public void mo5478d(String str, String str2, Throwable th) {
        if (mo5474a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    /* renamed from: e */
    public void mo5480e(String str, String str2, Throwable th) {
        if (mo5474a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: a */
    public void mo5472a(String str, String str2) {
        mo5473a(str, str2, null);
    }

    /* renamed from: b */
    public void mo5475b(String str, String str2) {
        m34438b(str, str2, null);
    }

    /* renamed from: c */
    public void mo5476c(String str, String str2) {
        m34440c(str, str2, null);
    }

    /* renamed from: d */
    public void mo5477d(String str, String str2) {
        mo5478d(str, str2, null);
    }

    /* renamed from: e */
    public void mo5479e(String str, String str2) {
        mo5480e(str, str2, null);
    }

    /* renamed from: a */
    public void mo5471a(int i, String str, String str2) {
        m34433a(i, str, str2, false);
    }

    /* renamed from: a */
    public void m34433a(int i, String str, String str2, boolean z) {
        if (z || mo5474a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}

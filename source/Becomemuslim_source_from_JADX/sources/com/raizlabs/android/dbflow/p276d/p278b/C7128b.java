package com.raizlabs.android.dbflow.p276d.p278b;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.p276d.C5687a;
import com.raizlabs.android.dbflow.p276d.C7135b;

/* compiled from: ColumnAlias */
/* renamed from: com.raizlabs.android.dbflow.d.b.b */
public class C7128b implements C5687a {
    /* renamed from: a */
    private final String f25265a;
    /* renamed from: b */
    private boolean f25266b = true;
    /* renamed from: c */
    private String f25267c;

    /* renamed from: a */
    public static C7128b m33167a(String str) {
        return new C7128b(str);
    }

    private C7128b(String str) {
        this.f25265a = str;
    }

    /* renamed from: a */
    public String mo5061a() {
        C7135b c7135b = new C7135b();
        if (this.f25266b) {
            c7135b.m33184a(this.f25265a);
        } else {
            c7135b.m33189b(this.f25265a);
        }
        if (!TextUtils.isEmpty(this.f25267c)) {
            c7135b.m33183a((Object) "AS").m33184a(this.f25267c);
        }
        return c7135b.mo5061a();
    }

    /* renamed from: b */
    public String m33169b() {
        return C7135b.m33182b(!TextUtils.isEmpty(this.f25267c) ? this.f25267c : this.f25265a);
    }

    public String toString() {
        return mo5061a();
    }
}

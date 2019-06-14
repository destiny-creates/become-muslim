package com.raizlabs.android.dbflow.p276d.p278b;

import com.raizlabs.android.dbflow.p276d.C5687a;
import com.raizlabs.android.dbflow.p276d.C7135b;
import com.raizlabs.android.dbflow.p281e.C5698h;

/* compiled from: Select */
/* renamed from: com.raizlabs.android.dbflow.d.b.g */
public class C7132g implements C5687a {
    /* renamed from: a */
    private int f25278a = -1;
    /* renamed from: b */
    private final C7128b[] f25279b = null;
    /* renamed from: c */
    private String[] f25280c;
    /* renamed from: d */
    private C7128b f25281d;

    /* renamed from: a */
    public <ModelClass extends C5698h> C8025d<ModelClass> m33176a(Class<ModelClass> cls) {
        return new C8025d(this, cls);
    }

    public String toString() {
        return mo5061a();
    }

    /* renamed from: a */
    public String mo5061a() {
        C7135b c7135b = new C7135b("SELECT ");
        Object obj = 1;
        if (this.f25278a != -1) {
            if (this.f25278a == 0) {
                c7135b.m33189b((Object) "DISTINCT");
            } else if (this.f25278a == 1) {
                c7135b.m33189b((Object) "ALL");
            } else if (this.f25278a == 2) {
                c7135b.m33189b(this.f25281d.mo5061a());
            }
            c7135b.m33188b();
        }
        Object obj2 = (this.f25279b == null || this.f25279b.length <= 0) ? null : 1;
        if (this.f25280c == null || this.f25280c.length <= 0) {
            obj = null;
        }
        if (obj2 == null) {
            if (obj == null) {
                if (this.f25278a != 2) {
                    c7135b.m33189b((Object) "*");
                }
                c7135b.m33188b();
                return c7135b.mo5061a();
            }
        }
        if (obj2 != null) {
            c7135b.m33186a(this.f25279b);
        }
        if (obj != null) {
            if (obj2 != null) {
                c7135b.m33189b((Object) ", ");
            }
            c7135b.m33186a(this.f25280c);
        }
        c7135b.m33188b();
        return c7135b.mo5061a();
    }
}

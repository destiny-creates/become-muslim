package com.raizlabs.android.dbflow.p276d.p278b;

import com.raizlabs.android.dbflow.config.C5680f;
import com.raizlabs.android.dbflow.p276d.C5687a;
import com.raizlabs.android.dbflow.p276d.C7135b;
import com.raizlabs.android.dbflow.p276d.p277a.C8024c;
import com.raizlabs.android.dbflow.p281e.C5698h;

/* compiled from: Join */
/* renamed from: com.raizlabs.android.dbflow.d.b.e */
public class C7130e<ModelClass extends C5698h, FromClass extends C5698h> implements C5687a {
    /* renamed from: a */
    private Class<ModelClass> f25268a;
    /* renamed from: b */
    private C5688a f25269b;
    /* renamed from: c */
    private String f25270c;
    /* renamed from: d */
    private C8024c<ModelClass> f25271d;
    /* renamed from: e */
    private String[] f25272e;
    /* renamed from: f */
    private boolean f25273f;

    /* compiled from: Join */
    /* renamed from: com.raizlabs.android.dbflow.d.b.e$a */
    public enum C5688a {
        LEFT,
        OUTER,
        INNER,
        CROSS
    }

    /* renamed from: a */
    public String mo5061a() {
        C7135b c7135b = new C7135b();
        if (this.f25273f) {
            c7135b.m33189b((Object) "NATURAL ");
        }
        c7135b.m33189b(this.f25269b.toString()).m33188b();
        c7135b.m33189b((Object) "JOIN").m33188b().m33184a(C5680f.m24082a(this.f25268a)).m33188b();
        if (this.f25270c != null) {
            c7135b.m33189b((Object) "AS ").m33189b(this.f25270c).m33188b();
        }
        if (this.f25271d != null) {
            c7135b.m33189b((Object) "ON").m33188b().m33189b(this.f25271d.m38891d()).m33188b();
        } else if (this.f25272e != null) {
            c7135b.m33189b((Object) "USING (").m33186a(this.f25272e).m33189b((Object) ")").m33188b();
        }
        return c7135b.mo5061a();
    }
}

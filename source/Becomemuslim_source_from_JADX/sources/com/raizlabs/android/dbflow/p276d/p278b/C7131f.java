package com.raizlabs.android.dbflow.p276d.p278b;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.p271a.C5653a;
import com.raizlabs.android.dbflow.p276d.C5687a;
import com.raizlabs.android.dbflow.p276d.C7135b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OrderBy */
/* renamed from: com.raizlabs.android.dbflow.d.b.f */
public class C7131f implements C5687a {
    /* renamed from: a */
    private List<C7128b> f25274a = new ArrayList();
    /* renamed from: b */
    private boolean f25275b = false;
    /* renamed from: c */
    private C5653a f25276c;
    /* renamed from: d */
    private String f25277d;

    private C7131f() {
    }

    /* renamed from: a */
    public static C7131f m33173a(String... strArr) {
        C7131f c7131f = new C7131f();
        for (String a : strArr) {
            c7131f.f25274a.add(C7128b.m33167a(a));
        }
        return c7131f;
    }

    /* renamed from: a */
    public C7131f m33174a(boolean z) {
        this.f25275b = z;
        return this;
    }

    /* renamed from: a */
    public String mo5061a() {
        C7135b c7135b = new C7135b("ORDER BY ");
        if (TextUtils.isEmpty(this.f25277d)) {
            for (int i = 0; i < this.f25274a.size(); i++) {
                if (i > 0) {
                    c7135b.m33189b((Object) ", ");
                }
                c7135b.m33189b(((C7128b) this.f25274a.get(i)).m33169b());
            }
            c7135b.m33188b().m33189b(this.f25275b ? "ASC" : "DESC");
            if (this.f25276c != null) {
                c7135b.m33188b().m33189b((Object) "COLLATE").m33183a(this.f25276c);
            }
        } else {
            c7135b.m33189b(this.f25277d);
        }
        return c7135b.mo5061a();
    }
}

package com.google.android.gms.common.api.internal;

import android.support.v4.util.C3211a;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2783c;
import com.google.android.gms.common.api.C2787e;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2955h;
import java.util.Map;
import java.util.Set;

public final class ci {
    /* renamed from: a */
    private final C3211a<cg<?>, C4775b> f7160a = new C3211a();
    /* renamed from: b */
    private final C3211a<cg<?>, String> f7161b = new C3211a();
    /* renamed from: c */
    private final C2955h<Map<cg<?>, String>> f7162c = new C2955h();
    /* renamed from: d */
    private int f7163d;
    /* renamed from: e */
    private boolean f7164e = false;

    public ci(Iterable<? extends C2787e<?>> iterable) {
        for (C2787e g : iterable) {
            this.f7160a.put(g.m7951g(), null);
        }
        this.f7163d = this.f7160a.keySet().size();
    }

    /* renamed from: a */
    public final Set<cg<?>> m8032a() {
        return this.f7160a.keySet();
    }

    /* renamed from: b */
    public final C2954g<Map<cg<?>, String>> m8034b() {
        return this.f7162c.m8783a();
    }

    /* renamed from: a */
    public final void m8033a(cg<?> cgVar, C4775b c4775b, String str) {
        this.f7160a.put(cgVar, c4775b);
        this.f7161b.put(cgVar, str);
        this.f7163d -= 1;
        if (c4775b.m16826b() == null) {
            this.f7164e = true;
        }
        if (this.f7163d == null) {
            if (this.f7164e != null) {
                this.f7162c.m8784a(new C2783c(this.f7160a));
                return;
            }
            this.f7162c.m8785a(this.f7161b);
        }
    }
}

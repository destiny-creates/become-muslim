package com.p050a.p051a.p052a.p053a;

import android.graphics.Path;
import android.graphics.Path.FillType;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p056c.p058b.C3380o;
import com.p050a.p051a.p056c.p058b.C3382q.C0906a;
import com.p050a.p051a.p056c.p059c.C4529a;
import com.p050a.p051a.p061e.C0948f;
import java.util.List;

/* compiled from: ShapeContent */
/* renamed from: com.a.a.a.a.p */
public class C4512p implements C3360l, C0884a {
    /* renamed from: a */
    private final Path f12199a = new Path();
    /* renamed from: b */
    private final String f12200b;
    /* renamed from: c */
    private final C0957g f12201c;
    /* renamed from: d */
    private final C0885a<?, Path> f12202d;
    /* renamed from: e */
    private boolean f12203e;
    /* renamed from: f */
    private C3361r f12204f;

    public C4512p(C0957g c0957g, C4529a c4529a, C3380o c3380o) {
        this.f12200b = c3380o.m10753a();
        this.f12201c = c0957g;
        this.f12202d = c3380o.m10754b().mo737a();
        c4529a.m15378a(this.f12202d);
        this.f12202d.m3133a((C0884a) this);
    }

    /* renamed from: a */
    public void mo728a() {
        m15332c();
    }

    /* renamed from: c */
    private void m15332c() {
        this.f12203e = false;
        this.f12201c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
        for (list2 = null; list2 < list.size(); list2++) {
            C0880b c0880b = (C0880b) list.get(list2);
            if (c0880b instanceof C3361r) {
                C3361r c3361r = (C3361r) c0880b;
                if (c3361r.m10669c() == C0906a.Simultaneously) {
                    this.f12204f = c3361r;
                    this.f12204f.m10666a(this);
                }
            }
        }
    }

    /* renamed from: e */
    public Path mo2793e() {
        if (this.f12203e) {
            return this.f12199a;
        }
        this.f12199a.reset();
        this.f12199a.set((Path) this.f12202d.mo733e());
        this.f12199a.setFillType(FillType.EVEN_ODD);
        C0948f.m3318a(this.f12199a, this.f12204f);
        this.f12203e = true;
        return this.f12199a;
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f12200b;
    }
}

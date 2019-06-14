package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p210i.C5008q;
import com.google.android.gms.internal.p210i.C7812e;
import com.google.android.gms.internal.p210i.jp;
import java.util.ListIterator;

/* renamed from: com.google.android.gms.analytics.i */
public class C4308i extends C2717r<C4308i> {
    /* renamed from: b */
    private final C5008q f11354b;
    /* renamed from: c */
    private boolean f11355c;

    public C4308i(C5008q c5008q) {
        super(c5008q.g(), c5008q.c());
        this.f11354b = c5008q;
    }

    /* renamed from: g */
    final C5008q m13988g() {
        return this.f11354b;
    }

    /* renamed from: h */
    public final C2714o mo2356h() {
        C2714o a = this.f6977a.m7742a();
        a.m7745a(this.f11354b.p().b());
        a.m7745a(this.f11354b.q().b());
        m7762b(a);
        return a;
    }

    /* renamed from: a */
    protected final void mo2355a(C2714o c2714o) {
        jp jpVar = (jp) c2714o.m7746b(jp.class);
        if (TextUtils.isEmpty(jpVar.b())) {
            jpVar.b(this.f11354b.o().b());
        }
        if (this.f11355c && TextUtils.isEmpty(jpVar.d())) {
            C7812e n = this.f11354b.n();
            jpVar.d(n.c());
            jpVar.a(n.b());
        }
    }

    /* renamed from: c */
    public final void m13987c(boolean z) {
        this.f11355c = z;
    }

    /* renamed from: b */
    public final void m13986b(String str) {
        C2872v.m8382a(str);
        Uri a = C4309j.m13990a(str);
        ListIterator listIterator = this.f6977a.m7748c().listIterator();
        while (listIterator.hasNext()) {
            if (a.equals(((C2725w) listIterator.next()).mo2357a())) {
                listIterator.remove();
            }
        }
        this.f6977a.m7748c().add(new C4309j(this.f11354b, str));
    }
}

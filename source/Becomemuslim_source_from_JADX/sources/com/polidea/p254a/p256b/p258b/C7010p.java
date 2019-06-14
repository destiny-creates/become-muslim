package com.polidea.p254a.p256b.p258b;

import com.polidea.p254a.C5629x;
import com.polidea.p254a.af;
import com.polidea.p254a.p256b.p258b.C5567c.C5566a;
import com.polidea.p254a.p256b.p261e.C5593a;
import java.util.Set;
import java.util.concurrent.Callable;
import p289e.C5974e;
import p289e.C5986h;
import p289e.p291b.C5913a;
import p289e.p291b.C5918f;

/* compiled from: ConnectorImpl */
/* renamed from: com.polidea.a.b.b.p */
public class C7010p implements C5572o {
    /* renamed from: a */
    private final C5593a f24945a;
    /* renamed from: b */
    private final C5566a f24946b;
    /* renamed from: c */
    private final C5986h f24947c;

    public C7010p(C5593a c5593a, C5566a c5566a, C5986h c5986h) {
        this.f24945a = c5593a;
        this.f24946b = c5566a;
        this.f24947c = c5986h;
    }

    /* renamed from: a */
    public C5974e<af> mo4996a(final C5629x c5629x) {
        return C5974e.m24971a(new C5918f<C5974e<af>>(this) {
            /* renamed from: b */
            final /* synthetic */ C7010p f24944b;

            public /* synthetic */ Object call() {
                return m32844a();
            }

            /* renamed from: a */
            public C5974e<af> m32844a() {
                final C5567c a = this.f24944b.f24946b.mo5031b(new C5568d(c5629x)).mo5030a();
                C5974e a2 = C5974e.m24978a(new Callable<af>(this) {
                    /* renamed from: b */
                    final /* synthetic */ C70091 f18685b;

                    public /* synthetic */ Object call() {
                        return m23749a();
                    }

                    /* renamed from: a */
                    public af m23749a() {
                        return a.mo5033b();
                    }
                });
                C5974e a3 = this.f24944b.f24945a.mo5016a(a.mo5032a());
                C5974e b = a.mo5034c().m23713b();
                final Set d = a.mo5035d();
                return C5974e.m24986c(a2.m25031e(a3), b).m24991a(new C5913a(this) {
                    /* renamed from: b */
                    final /* synthetic */ C70091 f24942b;

                    /* renamed from: a */
                    public void mo4985a() {
                        for (C5571n a : d) {
                            a.mo4982a();
                        }
                    }
                }).m25018c(new C5913a(this) {
                    /* renamed from: b */
                    final /* synthetic */ C70091 f24940b;

                    /* renamed from: a */
                    public void mo4985a() {
                        for (C5571n b : d) {
                            b.mo4983b();
                        }
                    }
                }).m25014b(this.f24944b.f24947c).m25020c(this.f24944b.f24947c);
            }
        });
    }
}

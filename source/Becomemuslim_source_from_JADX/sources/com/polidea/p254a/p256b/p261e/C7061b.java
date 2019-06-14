package com.polidea.p254a.p256b.p261e;

import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p256b.p259c.C5578j;
import com.polidea.p254a.p256b.p262f.C5609u;
import p289e.C5974e;
import p289e.C5986h;
import p289e.C7332c;
import p289e.C7332c.C5922a;
import p289e.p291b.C5914b;
import p289e.p291b.C5917e;

/* compiled from: ClientOperationQueueImpl */
/* renamed from: com.polidea.a.b.e.b */
public class C7061b implements C5593a {
    /* renamed from: a */
    private C5597h f25034a = new C5597h();

    public C7061b(final C5986h c5986h) {
        new Thread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C7061b f18713b;

            public void run() {
                while (true) {
                    try {
                        C5596g a = this.f18713b.f25034a.m23803a();
                        C5578j c5578j = a.f18717a;
                        long currentTimeMillis = System.currentTimeMillis();
                        C5609u.m23832a(c5578j);
                        C7066j c7066j = new C7066j();
                        a.f18718b.mo6331a(a.m23802a(c7066j, c5986h));
                        c7066j.m32954b();
                        C5609u.m23833a(c5578j, currentTimeMillis, System.currentTimeMillis());
                    } catch (Throwable e) {
                        C5615p.m23869c(e, "Error while processing client operation queue", new Object[0]);
                    }
                }
            }
        }).start();
    }

    /* renamed from: a */
    public <T> C5974e<T> mo5016a(final C5578j<T> c5578j) {
        return C5974e.m24970a(new C5914b<C7332c<T>>(this) {
            /* renamed from: b */
            final /* synthetic */ C7061b f25033b;

            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m32944a((C7332c) obj);
            }

            /* renamed from: a */
            public void m32944a(C7332c<T> c7332c) {
                final C5596g c5596g = new C5596g(c5578j, c7332c);
                c7332c.mo6330a(new C5917e(this) {
                    /* renamed from: b */
                    final /* synthetic */ C70602 f25031b;

                    /* renamed from: a */
                    public void mo4973a() {
                        if (this.f25031b.f25033b.f25034a.m23806b(c5596g)) {
                            C5609u.m23834b(c5578j);
                        }
                    }
                });
                C5609u.m23835c(c5578j);
                this.f25033b.f25034a.m23804a(c5596g);
            }
        }, C5922a.NONE);
    }
}

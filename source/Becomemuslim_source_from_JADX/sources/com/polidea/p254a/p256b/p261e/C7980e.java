package com.polidea.p254a.p256b.p261e;

import com.polidea.p254a.p255a.C5548g;
import com.polidea.p254a.p255a.C6973f;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p256b.p258b.C5571n;
import com.polidea.p254a.p256b.p258b.C5575w;
import com.polidea.p254a.p256b.p259c.C5578j;
import com.polidea.p254a.p256b.p262f.C5609u;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import p289e.C5974e;
import p289e.C5986h;
import p289e.C5989l;
import p289e.C7332c;
import p289e.C7332c.C5922a;
import p289e.p291b.C5914b;
import p289e.p291b.C5917e;

/* compiled from: ConnectionOperationQueueImpl */
/* renamed from: com.polidea.a.b.e.e */
public class C7980e implements C5571n, C7062d {
    /* renamed from: a */
    private final String f29709a;
    /* renamed from: b */
    private final C5575w f29710b;
    /* renamed from: c */
    private C5989l f29711c;
    /* renamed from: d */
    private final C5597h f29712d = new C5597h();
    /* renamed from: e */
    private final Future<?> f29713e;
    /* renamed from: f */
    private volatile boolean f29714f = true;
    /* renamed from: g */
    private C5548g f29715g = null;

    /* compiled from: ConnectionOperationQueueImpl */
    /* renamed from: com.polidea.a.b.e.e$3 */
    class C70653 implements C5914b<C5548g> {
        /* renamed from: a */
        final /* synthetic */ C7980e f25039a;

        C70653(C7980e c7980e) {
            this.f25039a = c7980e;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m32951a((C5548g) obj);
        }

        /* renamed from: a */
        public void m32951a(C5548g c5548g) {
            this.f25039a.m38736a(c5548g);
        }
    }

    C7980e(String str, C5575w c5575w, ExecutorService executorService, final C5986h c5986h) {
        this.f29709a = str;
        this.f29710b = c5575w;
        this.f29713e = executorService.submit(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ C7980e f18715b;

            public void run() {
                while (this.f18715b.f29714f) {
                    try {
                        C5596g a = this.f18715b.f29712d.m23803a();
                        C5578j c5578j = a.f18717a;
                        long currentTimeMillis = System.currentTimeMillis();
                        C5609u.m23832a(c5578j);
                        C7066j c7066j = new C7066j();
                        a.f18718b.mo6331a(a.m23802a(c7066j, c5986h));
                        c7066j.m32954b();
                        C5609u.m23833a(c5578j, currentTimeMillis, System.currentTimeMillis());
                    } catch (Throwable e) {
                        synchronized (this.f18715b) {
                            if (!this.f18715b.f29714f) {
                                break;
                            }
                            C5615p.m23869c(e, "Error while processing connection operation queue", new Object[0]);
                        }
                    }
                }
                this.f18715b.m38732c();
                C5615p.m23865b("Terminated.", new Object[0]);
            }
        });
    }

    /* renamed from: c */
    private synchronized void m38732c() {
        while (!this.f29712d.m23807c()) {
            this.f29712d.m23805b().f18718b.mo5001a(this.f29715g);
        }
    }

    /* renamed from: a */
    public synchronized <T> C5974e<T> mo5016a(final C5578j<T> c5578j) {
        if (this.f29714f) {
            return C5974e.m24970a(new C5914b<C7332c<T>>(this) {
                /* renamed from: b */
                final /* synthetic */ C7980e f25038b;

                /* renamed from: b */
                public /* synthetic */ void mo4974b(Object obj) {
                    m32949a((C7332c) obj);
                }

                /* renamed from: a */
                public void m32949a(C7332c<T> c7332c) {
                    final C5596g c5596g = new C5596g(c5578j, c7332c);
                    c7332c.mo6330a(new C5917e(this) {
                        /* renamed from: b */
                        final /* synthetic */ C70642 f25036b;

                        /* renamed from: a */
                        public void mo4973a() {
                            if (this.f25036b.f25038b.f29712d.m23806b(c5596g)) {
                                C5609u.m23834b(c5578j);
                            }
                        }
                    });
                    C5609u.m23835c(c5578j);
                    this.f25038b.f29712d.m23804a(c5596g);
                }
            }, C5922a.NONE);
        }
        return C5974e.m24984b(this.f29715g);
    }

    /* renamed from: a */
    public synchronized void m38736a(C5548g c5548g) {
        if (this.f29715g == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Connection operations queue to be terminated (");
            stringBuilder.append(this.f29709a);
            stringBuilder.append(')');
            C5615p.m23868c(stringBuilder.toString(), new Object[0]);
            this.f29714f = false;
            this.f29715g = c5548g;
            this.f29713e.cancel(true);
        }
    }

    /* renamed from: a */
    public void mo4982a() {
        this.f29711c = this.f29710b.mo4997a().m25021c(new C70653(this));
    }

    /* renamed from: b */
    public void mo4983b() {
        this.f29711c.U_();
        this.f29711c = null;
        m38736a(new C6973f(this.f29709a, -1));
    }
}

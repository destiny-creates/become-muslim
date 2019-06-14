package p289e.p292c.p293a;

import java.util.concurrent.atomic.AtomicInteger;
import p289e.C5974e.C7335a;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p291b.C5914b;
import p289e.p298d.C7333b;
import p289e.p299e.C5973e;

/* compiled from: OnSubscribeAutoConnect */
/* renamed from: e.c.a.j */
public final class C8100j<T> extends AtomicInteger implements C7335a<T> {
    /* renamed from: a */
    final C7333b<? extends T> f30178a;
    /* renamed from: b */
    final int f30179b;
    /* renamed from: c */
    final C5914b<? super C5989l> f30180c;

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39386a((C7367k) obj);
    }

    public C8100j(C7333b<? extends T> c7333b, int i, C5914b<? super C5989l> c5914b) {
        if (i > 0) {
            this.f30178a = c7333b;
            this.f30179b = i;
            this.f30180c = c5914b;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    /* renamed from: a */
    public void m39386a(C7367k<? super T> c7367k) {
        this.f30178a.m25007a((C7367k) C5973e.m24966a((C7367k) c7367k));
        if (incrementAndGet() == this.f30179b) {
            this.f30178a.mo6326d(this.f30180c);
        }
    }
}

package com.polidea.p254a.p256b;

import android.os.DeadObjectException;
import com.polidea.p254a.p255a.C5548g;
import com.polidea.p254a.p256b.p259c.C5578j;
import com.polidea.p254a.p256b.p261e.C5598i;
import p289e.C5974e;
import p289e.C7332c;
import p289e.C7332c.C5922a;
import p289e.p291b.C5914b;

/* compiled from: QueueOperation */
/* renamed from: com.polidea.a.b.k */
public abstract class C7084k<T> implements C5578j<T> {
    /* renamed from: a */
    protected abstract C5548g mo6271a(DeadObjectException deadObjectException);

    /* renamed from: a */
    protected abstract void mo6272a(C7332c<T> c7332c, C5598i c5598i);

    public /* synthetic */ int compareTo(Object obj) {
        return m32987a((C5578j) obj);
    }

    /* renamed from: a */
    public final C5974e<T> mo5022a(final C5598i c5598i) {
        return C5974e.m24970a(new C5914b<C7332c<T>>(this) {
            /* renamed from: b */
            final /* synthetic */ C7084k f25065b;

            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m32985a((C7332c) obj);
            }

            /* renamed from: a */
            public void m32985a(C7332c<T> c7332c) {
                try {
                    this.f25065b.mo6272a(c7332c, c5598i);
                } catch (DeadObjectException e) {
                    c7332c.mo5001a(this.f25065b.mo6271a(e));
                } catch (Throwable th) {
                    c7332c.mo5001a(th);
                }
            }
        }, C5922a.NONE);
    }

    /* renamed from: a */
    public C5612j mo5021a() {
        return C5612j.f18745b;
    }

    /* renamed from: a */
    public int m32987a(C5578j c5578j) {
        return c5578j.mo5021a().f18747d - mo5021a().f18747d;
    }
}

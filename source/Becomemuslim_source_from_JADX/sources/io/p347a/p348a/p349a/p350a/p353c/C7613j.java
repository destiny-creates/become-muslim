package io.p347a.p348a.p349a.p350a.p353c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PriorityTask */
/* renamed from: io.a.a.a.a.c.j */
public class C7613j implements C6457b<C6465l>, C6462i, C6465l {
    /* renamed from: a */
    private final List<C6465l> f26314a = new ArrayList();
    /* renamed from: b */
    private final AtomicBoolean f26315b = new AtomicBoolean(false);
    /* renamed from: c */
    private final AtomicReference<Throwable> f26316c = new AtomicReference(null);

    /* renamed from: c */
    public /* synthetic */ void mo5444c(Object obj) {
        m34367a((C6465l) obj);
    }

    /* renamed from: c */
    public synchronized Collection<C6465l> mo5443c() {
        return Collections.unmodifiableCollection(this.f26314a);
    }

    /* renamed from: a */
    public synchronized void m34367a(C6465l c6465l) {
        this.f26314a.add(c6465l);
    }

    /* renamed from: d */
    public boolean mo5445d() {
        for (C6465l f : mo5443c()) {
            if (!f.mo5446f()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public synchronized void mo5442b(boolean z) {
        this.f26315b.set(z);
    }

    /* renamed from: f */
    public boolean mo5446f() {
        return this.f26315b.get();
    }

    /* renamed from: b */
    public C6460e mo5441b() {
        return C6460e.NORMAL;
    }

    /* renamed from: a */
    public void mo5440a(Throwable th) {
        this.f26316c.set(th);
    }

    public int compareTo(Object obj) {
        return C6460e.m26484a(this, obj);
    }

    /* renamed from: a */
    public static boolean m34366a(java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r3;	 Catch:{ ClassCastException -> 0x0011 }
        r1 = (io.p347a.p348a.p349a.p350a.p353c.C6457b) r1;	 Catch:{ ClassCastException -> 0x0011 }
        r2 = r3;	 Catch:{ ClassCastException -> 0x0011 }
        r2 = (io.p347a.p348a.p349a.p350a.p353c.C6465l) r2;	 Catch:{ ClassCastException -> 0x0011 }
        r3 = (io.p347a.p348a.p349a.p350a.p353c.C6462i) r3;	 Catch:{ ClassCastException -> 0x0011 }
        if (r1 == 0) goto L_0x0010;
    L_0x000b:
        if (r2 == 0) goto L_0x0010;
    L_0x000d:
        if (r3 == 0) goto L_0x0010;
    L_0x000f:
        r0 = 1;
    L_0x0010:
        return r0;
    L_0x0011:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.c.j.a(java.lang.Object):boolean");
    }
}

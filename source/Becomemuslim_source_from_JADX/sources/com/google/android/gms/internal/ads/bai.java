package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class bai {
    /* renamed from: a */
    private final AtomicInteger f15123a;
    /* renamed from: b */
    private final Set<awi<?>> f15124b;
    /* renamed from: c */
    private final PriorityBlockingQueue<awi<?>> f15125c;
    /* renamed from: d */
    private final PriorityBlockingQueue<awi<?>> f15126d;
    /* renamed from: e */
    private final zz f15127e;
    /* renamed from: f */
    private final arh f15128f;
    /* renamed from: g */
    private final C4922b f15129g;
    /* renamed from: h */
    private final ase[] f15130h;
    /* renamed from: i */
    private aia f15131i;
    /* renamed from: j */
    private final List<bbj> f15132j;

    public bai(zz zzVar, arh arh) {
        this(zzVar, arh, 4);
    }

    private bai(zz zzVar, arh arh, int i) {
        this(zzVar, arh, 4, new anf(new Handler(Looper.getMainLooper())));
    }

    private bai(zz zzVar, arh arh, int i, C4922b c4922b) {
        this.f15123a = new AtomicInteger();
        this.f15124b = new HashSet();
        this.f15125c = new PriorityBlockingQueue();
        this.f15126d = new PriorityBlockingQueue();
        this.f15132j = new ArrayList();
        this.f15127e = zzVar;
        this.f15128f = arh;
        this.f15130h = new ase[4];
        this.f15129g = c4922b;
    }

    /* renamed from: a */
    public final <T> awi<T> m19193a(awi<T> awi) {
        awi.m19053a(this);
        synchronized (this.f15124b) {
            this.f15124b.add(awi);
        }
        awi.m19051a(this.f15123a.incrementAndGet());
        awi.m19061b("add-to-queue");
        (!awi.m19068h() ? this.f15126d : this.f15125c).add(awi);
        return awi;
    }

    /* renamed from: a */
    public final void m19194a() {
        if (this.f15131i != null) {
            this.f15131i.m18475a();
        }
        for (ase ase : this.f15130h) {
            if (ase != null) {
                ase.m18868a();
            }
        }
        this.f15131i = new aia(this.f15125c, this.f15126d, this.f15127e, this.f15129g);
        this.f15131i.start();
        for (int i = 0; i < this.f15130h.length; i++) {
            ase ase2 = new ase(this.f15126d, this.f15128f, this.f15127e, this.f15129g);
            this.f15130h[i] = ase2;
            ase2.start();
        }
    }

    /* renamed from: b */
    final <T> void m19195b(awi<T> awi) {
        synchronized (this.f15124b) {
            this.f15124b.remove(awi);
        }
        synchronized (this.f15132j) {
            for (bbj a : this.f15132j) {
                a.m19210a(awi);
            }
        }
    }
}

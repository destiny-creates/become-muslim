package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class bg implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicInteger f15242a;
    /* renamed from: b */
    private final /* synthetic */ int f15243b;
    /* renamed from: c */
    private final /* synthetic */ nz f15244c;
    /* renamed from: d */
    private final /* synthetic */ List f15245d;

    bg(AtomicInteger atomicInteger, int i, nz nzVar, List list) {
        this.f15242a = atomicInteger;
        this.f15243b = i;
        this.f15244c = nzVar;
        this.f15245d = list;
    }

    public final void run() {
        if (this.f15242a.incrementAndGet() >= this.f15243b) {
            try {
                this.f15244c.m30915b(ay.m19119b(this.f15245d));
            } catch (Throwable e) {
                mt.m19921c("Unable to convert list of futures to a future of list", e);
            }
        }
    }
}

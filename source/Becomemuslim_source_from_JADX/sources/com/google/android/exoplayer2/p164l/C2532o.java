package com.google.android.exoplayer2.p164l;

import android.support.v7.widget.LinearLayoutManager;
import java.util.PriorityQueue;

/* compiled from: PriorityTaskManager */
/* renamed from: com.google.android.exoplayer2.l.o */
public final class C2532o {
    /* renamed from: a */
    private final Object f6448a;
    /* renamed from: b */
    private final PriorityQueue<Integer> f6449b;
    /* renamed from: c */
    private int f6450c;

    /* renamed from: a */
    public void m7136a(int i) {
        synchronized (this.f6448a) {
            this.f6449b.add(Integer.valueOf(i));
            this.f6450c = Math.max(this.f6450c, i);
        }
    }

    /* renamed from: b */
    public void m7137b(int i) {
        synchronized (this.f6448a) {
            this.f6449b.remove(Integer.valueOf(i));
            this.f6450c = this.f6449b.isEmpty() != 0 ? LinearLayoutManager.INVALID_OFFSET : ((Integer) this.f6449b.peek()).intValue();
            this.f6448a.notifyAll();
        }
    }
}

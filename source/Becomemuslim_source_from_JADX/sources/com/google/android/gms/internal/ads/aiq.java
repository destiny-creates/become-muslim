package com.google.android.gms.internal.ads;

import android.support.v7.widget.LinearLayoutManager;

public final class aiq extends ajk {
    public aiq(ahz ahz, String str, String str2, aaa aaa, int i, int i2) {
        super(ahz, str, str2, aaa, i, 5);
    }

    /* renamed from: a */
    protected final void mo3820a() {
        this.b.f27955d = Long.valueOf(-1);
        this.b.f27956e = Long.valueOf(-1);
        int[] iArr = (int[]) this.c.invoke(null, new Object[]{this.a.m18454a()});
        synchronized (this.b) {
            this.b.f27955d = Long.valueOf((long) iArr[0]);
            this.b.f27956e = Long.valueOf((long) iArr[1]);
            if (iArr[2] != LinearLayoutManager.INVALID_OFFSET) {
                this.b.f27941N = Long.valueOf((long) iArr[2]);
            }
        }
    }
}

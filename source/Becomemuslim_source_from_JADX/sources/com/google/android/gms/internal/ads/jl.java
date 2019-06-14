package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class jl {
    /* renamed from: e */
    private static final Comparator<byte[]> f15662e = new km();
    /* renamed from: a */
    private final List<byte[]> f15663a = new LinkedList();
    /* renamed from: b */
    private final List<byte[]> f15664b = new ArrayList(64);
    /* renamed from: c */
    private int f15665c = 0;
    /* renamed from: d */
    private final int f15666d = 4096;

    public jl(int i) {
    }

    /* renamed from: a */
    private final synchronized void m19605a() {
        while (this.f15665c > this.f15666d) {
            byte[] bArr = (byte[]) this.f15663a.remove(0);
            this.f15664b.remove(bArr);
            this.f15665c -= bArr.length;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final synchronized void m19606a(byte[] r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        if (r3 == 0) goto L_0x002e;
    L_0x0003:
        r0 = r3.length;	 Catch:{ all -> 0x002b }
        r1 = r2.f15666d;	 Catch:{ all -> 0x002b }
        if (r0 <= r1) goto L_0x0009;
    L_0x0008:
        goto L_0x002e;
    L_0x0009:
        r0 = r2.f15663a;	 Catch:{ all -> 0x002b }
        r0.add(r3);	 Catch:{ all -> 0x002b }
        r0 = r2.f15664b;	 Catch:{ all -> 0x002b }
        r1 = f15662e;	 Catch:{ all -> 0x002b }
        r0 = java.util.Collections.binarySearch(r0, r3, r1);	 Catch:{ all -> 0x002b }
        if (r0 >= 0) goto L_0x001b;
    L_0x0018:
        r0 = -r0;
        r0 = r0 + -1;
    L_0x001b:
        r1 = r2.f15664b;	 Catch:{ all -> 0x002b }
        r1.add(r0, r3);	 Catch:{ all -> 0x002b }
        r0 = r2.f15665c;	 Catch:{ all -> 0x002b }
        r3 = r3.length;	 Catch:{ all -> 0x002b }
        r0 = r0 + r3;
        r2.f15665c = r0;	 Catch:{ all -> 0x002b }
        r2.m19605a();	 Catch:{ all -> 0x002b }
        monitor-exit(r2);
        return;
    L_0x002b:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
    L_0x002e:
        monitor-exit(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jl.a(byte[]):void");
    }

    /* renamed from: a */
    public final synchronized byte[] m19607a(int i) {
        for (int i2 = 0; i2 < this.f15664b.size(); i2++) {
            byte[] bArr = (byte[]) this.f15664b.get(i2);
            if (bArr.length >= i) {
                this.f15665c -= bArr.length;
                this.f15664b.remove(i2);
                this.f15663a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}

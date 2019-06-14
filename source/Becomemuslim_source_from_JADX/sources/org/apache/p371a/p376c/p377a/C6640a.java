package org.apache.p371a.p376c.p377a;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ByteArrayOutputStream */
/* renamed from: org.apache.a.c.a.a */
public class C6640a extends OutputStream {
    /* renamed from: a */
    private static final byte[] f21336a = new byte[0];
    /* renamed from: b */
    private final List<byte[]> f21337b;
    /* renamed from: c */
    private int f21338c;
    /* renamed from: d */
    private int f21339d;
    /* renamed from: e */
    private byte[] f21340e;
    /* renamed from: f */
    private int f21341f;

    public void close() {
    }

    public C6640a() {
        this(1024);
    }

    public C6640a(int i) {
        this.f21337b = new ArrayList();
        if (i >= 0) {
            synchronized (this) {
                m27029a(i);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative initial size: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    private void m27029a(int i) {
        if (this.f21338c < this.f21337b.size() - 1) {
            this.f21339d += this.f21340e.length;
            this.f21338c++;
            this.f21340e = (byte[]) this.f21337b.get(this.f21338c);
            return;
        }
        if (this.f21340e == null) {
            this.f21339d = 0;
        } else {
            i = Math.max(this.f21340e.length << 1, i - this.f21339d);
            this.f21339d += this.f21340e.length;
        }
        this.f21338c++;
        this.f21340e = new byte[i];
        this.f21337b.add(this.f21340e);
    }

    public void write(byte[] bArr, int i, int i2) {
        if (i >= 0 && i <= bArr.length && i2 >= 0) {
            i += i2;
            if (i <= bArr.length && i >= 0) {
                if (i2 != 0) {
                    synchronized (this) {
                        int i3 = this.f21341f + i2;
                        int i4 = this.f21341f - this.f21339d;
                        while (i2 > 0) {
                            int min = Math.min(i2, this.f21340e.length - i4);
                            System.arraycopy(bArr, i - i2, this.f21340e, i4, min);
                            i2 -= min;
                            if (i2 > 0) {
                                m27029a(i3);
                                i4 = 0;
                            }
                        }
                        this.f21341f = i3;
                    }
                    return;
                }
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public synchronized void write(int i) {
        int i2 = this.f21341f - this.f21339d;
        if (i2 == this.f21340e.length) {
            m27029a(this.f21341f + 1);
            i2 = 0;
        }
        this.f21340e[i2] = (byte) i;
        this.f21341f++;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public synchronized byte[] m27030a() {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = r7.f21341f;	 Catch:{ all -> 0x002d }
        if (r0 != 0) goto L_0x0009;
    L_0x0005:
        r0 = f21336a;	 Catch:{ all -> 0x002d }
        monitor-exit(r7);
        return r0;
    L_0x0009:
        r1 = new byte[r0];	 Catch:{ all -> 0x002d }
        r2 = r7.f21337b;	 Catch:{ all -> 0x002d }
        r2 = r2.iterator();	 Catch:{ all -> 0x002d }
        r3 = 0;
        r4 = 0;
    L_0x0013:
        r5 = r2.hasNext();	 Catch:{ all -> 0x002d }
        if (r5 == 0) goto L_0x002b;
    L_0x0019:
        r5 = r2.next();	 Catch:{ all -> 0x002d }
        r5 = (byte[]) r5;	 Catch:{ all -> 0x002d }
        r6 = r5.length;	 Catch:{ all -> 0x002d }
        r6 = java.lang.Math.min(r6, r0);	 Catch:{ all -> 0x002d }
        java.lang.System.arraycopy(r5, r3, r1, r4, r6);	 Catch:{ all -> 0x002d }
        r4 = r4 + r6;
        r0 = r0 - r6;
        if (r0 != 0) goto L_0x0013;
    L_0x002b:
        monitor-exit(r7);
        return r1;
    L_0x002d:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.a.c.a.a.a():byte[]");
    }

    public String toString() {
        return new String(m27030a());
    }
}

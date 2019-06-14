package com.p064b.p065a.p068c;

import android.os.Process;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6436o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: CLSUUID */
/* renamed from: com.b.a.c.c */
class C1018c {
    /* renamed from: a */
    private static final AtomicLong f2869a = new AtomicLong(0);
    /* renamed from: b */
    private static String f2870b;

    public C1018c(C6436o c6436o) {
        r0 = new byte[10];
        m3499a(r0);
        m3501b(r0);
        m3503c(r0);
        c6436o = C6428i.a(c6436o.b());
        String a = C6428i.a(r0);
        f2870b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a.substring(0, 12), a.substring(12, 16), a.subSequence(16, 20), c6436o.substring(0, 12)}).toUpperCase(Locale.US);
    }

    /* renamed from: a */
    private void m3499a(byte[] bArr) {
        long time = new Date().getTime();
        long j = time / 1000;
        time %= 1000;
        byte[] a = C1018c.m3500a(j);
        bArr[0] = a[0];
        bArr[1] = a[1];
        bArr[2] = a[2];
        bArr[3] = a[3];
        byte[] b = C1018c.m3502b(time);
        bArr[4] = b[0];
        bArr[5] = b[1];
    }

    /* renamed from: b */
    private void m3501b(byte[] bArr) {
        byte[] b = C1018c.m3502b(f2869a.incrementAndGet());
        bArr[6] = b[0];
        bArr[7] = b[1];
    }

    /* renamed from: c */
    private void m3503c(byte[] bArr) {
        byte[] b = C1018c.m3502b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b[0];
        bArr[9] = b[1];
    }

    /* renamed from: a */
    private static byte[] m3500a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    /* renamed from: b */
    private static byte[] m3502b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return f2870b;
    }
}

package p286d;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout */
/* renamed from: d.u */
public class C5877u {
    public static final C5877u NONE = new C72161();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* compiled from: Timeout */
    /* renamed from: d.u$1 */
    class C72161 extends C5877u {
        public C5877u deadlineNanoTime(long j) {
            return this;
        }

        public void throwIfReached() {
        }

        public C5877u timeout(long j, TimeUnit timeUnit) {
            return this;
        }

        C72161() {
        }
    }

    public C5877u timeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("timeout < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit != null) {
            this.timeoutNanos = timeUnit.toNanos(j);
            return this;
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public C5877u deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }

    public final C5877u deadline(long j, TimeUnit timeUnit) {
        if (j <= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("duration <= 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit != null) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j));
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public C5877u clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public C5877u clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public void throwIfReached() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (!this.hasDeadline) {
        } else {
            if (this.deadlineNanoTime - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
        }
    }

    public final void waitUntilNotified(java.lang.Object r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r9.hasDeadline();	 Catch:{ InterruptedException -> 0x0057 }
        r1 = r9.timeoutNanos();	 Catch:{ InterruptedException -> 0x0057 }
        r3 = 0;	 Catch:{ InterruptedException -> 0x0057 }
        if (r0 != 0) goto L_0x0014;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x000c:
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0057 }
        if (r5 != 0) goto L_0x0014;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x0010:
        r10.wait();	 Catch:{ InterruptedException -> 0x0057 }
        return;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x0014:
        r5 = java.lang.System.nanoTime();	 Catch:{ InterruptedException -> 0x0057 }
        if (r0 == 0) goto L_0x0029;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x001a:
        r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0057 }
        if (r7 == 0) goto L_0x0029;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x001e:
        r7 = r9.deadlineNanoTime();	 Catch:{ InterruptedException -> 0x0057 }
        r0 = 0;	 Catch:{ InterruptedException -> 0x0057 }
        r7 = r7 - r5;	 Catch:{ InterruptedException -> 0x0057 }
        r1 = java.lang.Math.min(r1, r7);	 Catch:{ InterruptedException -> 0x0057 }
        goto L_0x0032;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x0029:
        if (r0 == 0) goto L_0x0032;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x002b:
        r0 = r9.deadlineNanoTime();	 Catch:{ InterruptedException -> 0x0057 }
        r2 = 0;	 Catch:{ InterruptedException -> 0x0057 }
        r1 = r0 - r5;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x0032:
        r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0057 }
        if (r0 <= 0) goto L_0x004a;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x0036:
        r3 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;	 Catch:{ InterruptedException -> 0x0057 }
        r7 = r1 / r3;	 Catch:{ InterruptedException -> 0x0057 }
        r3 = r3 * r7;	 Catch:{ InterruptedException -> 0x0057 }
        r0 = 0;	 Catch:{ InterruptedException -> 0x0057 }
        r3 = r1 - r3;	 Catch:{ InterruptedException -> 0x0057 }
        r0 = (int) r3;	 Catch:{ InterruptedException -> 0x0057 }
        r10.wait(r7, r0);	 Catch:{ InterruptedException -> 0x0057 }
        r3 = java.lang.System.nanoTime();	 Catch:{ InterruptedException -> 0x0057 }
        r10 = 0;	 Catch:{ InterruptedException -> 0x0057 }
        r3 = r3 - r5;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x004a:
        r10 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));	 Catch:{ InterruptedException -> 0x0057 }
        if (r10 >= 0) goto L_0x004f;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x004e:
        return;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x004f:
        r10 = new java.io.InterruptedIOException;	 Catch:{ InterruptedException -> 0x0057 }
        r0 = "timeout";	 Catch:{ InterruptedException -> 0x0057 }
        r10.<init>(r0);	 Catch:{ InterruptedException -> 0x0057 }
        throw r10;	 Catch:{ InterruptedException -> 0x0057 }
    L_0x0057:
        r10 = new java.io.InterruptedIOException;
        r0 = "interrupted";
        r10.<init>(r0);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: d.u.waitUntilNotified(java.lang.Object):void");
    }
}

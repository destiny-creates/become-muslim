package p289e.p292c.p295e;

import java.util.concurrent.CountDownLatch;
import p289e.C5989l;

/* compiled from: BlockingUtils */
/* renamed from: e.c.e.c */
public final class C5959c {
    /* renamed from: a */
    public static void m24926a(CountDownLatch countDownLatch, C5989l c5989l) {
        if (countDownLatch.getCount() != 0) {
            try {
                countDownLatch.await();
            } catch (CountDownLatch countDownLatch2) {
                c5989l.U_();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", countDownLatch2);
            }
        }
    }
}

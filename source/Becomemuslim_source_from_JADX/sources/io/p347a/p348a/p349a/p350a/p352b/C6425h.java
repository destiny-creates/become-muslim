package io.p347a.p348a.p349a.p350a.p352b;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable */
/* renamed from: io.a.a.a.a.b.h */
public abstract class C6425h implements Runnable {
    /* renamed from: a */
    protected abstract void mo5434a();

    public final void run() {
        Process.setThreadPriority(10);
        mo5434a();
    }
}

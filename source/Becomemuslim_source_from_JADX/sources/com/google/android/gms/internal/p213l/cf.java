package com.google.android.gms.internal.p213l;

import android.os.Process;
import com.amplitude.api.Constants;
import com.google.android.gms.common.internal.C2872v;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.google.android.gms.internal.l.cf */
final class cf extends Thread {
    /* renamed from: a */
    private final Object f17030a = new Object();
    /* renamed from: b */
    private final BlockingQueue<ce<?>> f17031b;
    /* renamed from: c */
    private final /* synthetic */ cb f17032c;

    public cf(cb cbVar, String str, BlockingQueue<ce<?>> blockingQueue) {
        this.f17032c = cbVar;
        C2872v.a(str);
        C2872v.a(blockingQueue);
        this.f17031b = blockingQueue;
        setName(str);
    }

    /* renamed from: a */
    private final void m21335a(InterruptedException interruptedException) {
        this.f17032c.mo4754r().m42565i().m21308a(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    /* renamed from: a */
    public final void m21336a() {
        synchronized (this.f17030a) {
            this.f17030a.notifyAll();
        }
    }

    public final void run() {
        Object obj = null;
        while (obj == null) {
            try {
                this.f17032c.f32356i.acquire();
                obj = 1;
            } catch (InterruptedException e) {
                m21335a(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                ce ceVar = (ce) this.f17031b.poll();
                if (ceVar != null) {
                    Process.setThreadPriority(ceVar.f17026a ? threadPriority : 10);
                    ceVar.run();
                } else {
                    synchronized (this.f17030a) {
                        if (this.f17031b.peek() == null && !this.f17032c.f32357j) {
                            try {
                                this.f17030a.wait(Constants.EVENT_UPLOAD_PERIOD_MILLIS);
                            } catch (InterruptedException e2) {
                                m21335a(e2);
                            }
                        }
                    }
                    synchronized (this.f17032c.f32355h) {
                        if (this.f17031b.peek() == null) {
                            break;
                        }
                    }
                }
            }
            synchronized (this.f17032c.f32355h) {
                this.f17032c.f32356i.release();
                this.f17032c.f32355h.notifyAll();
                if (this == this.f17032c.f32349b) {
                    this.f17032c.f32349b = null;
                } else if (this == this.f17032c.f32350c) {
                    this.f17032c.f32350c = null;
                } else {
                    this.f17032c.mo4754r().I_().m21307a("Current scheduler thread is neither worker nor network");
                }
            }
        } catch (Throwable th) {
            synchronized (this.f17032c.f32355h) {
                this.f17032c.f32356i.release();
                this.f17032c.f32355h.notifyAll();
                if (this == this.f17032c.f32349b) {
                    this.f17032c.f32349b = null;
                } else if (this == this.f17032c.f32350c) {
                    this.f17032c.f32350c = null;
                } else {
                    this.f17032c.mo4754r().I_().m21307a("Current scheduler thread is neither worker nor network");
                }
            }
        }
    }
}

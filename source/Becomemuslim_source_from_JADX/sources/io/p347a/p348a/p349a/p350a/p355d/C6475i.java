package io.p347a.p348a.p349a.p350a.p355d;

import android.content.Context;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;

/* compiled from: TimeBasedFileRollOverRunnable */
/* renamed from: io.a.a.a.a.d.i */
public class C6475i implements Runnable {
    /* renamed from: a */
    private final Context f20876a;
    /* renamed from: b */
    private final C6473e f20877b;

    public C6475i(Context context, C6473e c6473e) {
        this.f20876a = context;
        this.f20877b = c6473e;
    }

    public void run() {
        try {
            C6428i.m26364a(this.f20876a, "Performing time based file roll over.");
            if (!this.f20877b.m26518c()) {
                this.f20877b.m26519d();
            }
        } catch (Throwable e) {
            C6428i.m26365a(this.f20876a, "Failed to roll over file", e);
        }
    }
}

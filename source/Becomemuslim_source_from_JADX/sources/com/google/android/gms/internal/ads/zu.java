package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.util.List;

final class zu extends zr {
    /* renamed from: a */
    private final zs f24424a = new zs();

    zu() {
    }

    /* renamed from: a */
    public final void mo4394a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> a = this.f24424a.m20205a(th, false);
        if (a != null) {
            synchronized (a) {
                for (Throwable th2 : a) {
                    printWriter.print("Suppressed: ");
                    th2.printStackTrace(printWriter);
                }
            }
        }
    }
}

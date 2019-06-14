package com.google.android.gms.internal.p210i;

import java.io.PrintStream;

/* renamed from: com.google.android.gms.internal.i.dp */
final class dp extends dm {
    /* renamed from: a */
    private final dn f24466a = new dn();

    dp() {
    }

    /* renamed from: a */
    public final void mo4428a(Throwable th, PrintStream printStream) {
        th.printStackTrace(printStream);
        Throwable<Throwable> a = this.f24466a.m20445a(th, false);
        if (a != null) {
            synchronized (a) {
                for (Throwable th2 : a) {
                    printStream.print("Suppressed: ");
                    th2.printStackTrace(printStream);
                }
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final class nw implements Executor {
    nw() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}

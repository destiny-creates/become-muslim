package com.google.android.gms.internal.ads;

import android.os.Looper;

final class pj implements Runnable {
    pj(pi piVar) {
    }

    public final void run() {
        Looper.myLooper().quit();
    }
}

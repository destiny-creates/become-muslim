package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.ax;

@cm
public final class jo extends Handler {
    public jo(Looper looper) {
        super(looper);
    }

    public final void dispatchMessage(Message message) {
        try {
            super.dispatchMessage(message);
        } catch (Throwable th) {
            ax.e();
            jw.m19700a(ax.i().m30848m(), th);
        }
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Throwable e) {
            ax.i().m30834a(e, "AdMobHandler.handleMessage");
        }
    }
}

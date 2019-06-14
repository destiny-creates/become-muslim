package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.C2872v;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.android.gms.common.a */
public class C2773a implements ServiceConnection {
    /* renamed from: a */
    private boolean f7071a = false;
    /* renamed from: b */
    private final BlockingQueue<IBinder> f7072b = new LinkedBlockingQueue();

    public void onServiceDisconnected(ComponentName componentName) {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f7072b.add(iBinder);
    }

    /* renamed from: a */
    public IBinder m7891a(long j, TimeUnit timeUnit) {
        C2872v.m8393c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f7071a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f7071a = true;
        IBinder iBinder = (IBinder) this.f7072b.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    /* renamed from: a */
    public IBinder m7890a() {
        C2872v.m8393c("BlockingServiceConnection.getService() called on main thread");
        if (this.f7071a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f7071a = true;
        return (IBinder) this.f7072b.take();
    }
}

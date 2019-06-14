package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2798d.C4771a;
import com.google.android.gms.common.util.C2904o;

public abstract class ar {
    /* renamed from: a */
    private final int f7123a;

    public ar(int i) {
        this.f7123a = i;
    }

    /* renamed from: a */
    public abstract void mo2427a(Status status);

    /* renamed from: a */
    public abstract void mo2428a(C4771a<?> c4771a);

    /* renamed from: a */
    public abstract void mo2429a(C2812s c2812s, boolean z);

    /* renamed from: a */
    public abstract void mo2430a(RuntimeException runtimeException);

    /* renamed from: b */
    private static Status m7982b(RemoteException remoteException) {
        StringBuilder stringBuilder = new StringBuilder();
        if (C2904o.m8457c() && (remoteException instanceof TransactionTooLargeException)) {
            stringBuilder.append("TransactionTooLargeException: ");
        }
        stringBuilder.append(remoteException.getLocalizedMessage());
        return new Status(8, stringBuilder.toString());
    }
}

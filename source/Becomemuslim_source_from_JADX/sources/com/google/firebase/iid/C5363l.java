package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* renamed from: com.google.firebase.iid.l */
final class C5363l {
    /* renamed from: a */
    private final Messenger f18110a;
    /* renamed from: b */
    private final ao f18111b;

    C5363l(IBinder iBinder) {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f18110a = new Messenger(iBinder);
            this.f18111b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f18111b = new ao(iBinder);
            this.f18110a = null;
        } else {
            iBinder = "Invalid interface descriptor: ";
            interfaceDescriptor = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", interfaceDescriptor.length() != 0 ? iBinder.concat(interfaceDescriptor) : new String(iBinder));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    final void m22772a(Message message) {
        if (this.f18110a != null) {
            this.f18110a.send(message);
        } else if (this.f18111b != null) {
            this.f18111b.m22726a(message);
        } else {
            throw new IllegalStateException("Both messengers are null");
        }
    }
}

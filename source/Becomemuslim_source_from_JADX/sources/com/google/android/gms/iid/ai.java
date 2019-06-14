package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class ai {
    /* renamed from: a */
    final Messenger f7817a;
    /* renamed from: b */
    final MessengerCompat f7818b;

    ai(IBinder iBinder) {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f7817a = new Messenger(iBinder);
            this.f7818b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f7818b = new MessengerCompat(iBinder);
            this.f7817a = null;
        } else {
            iBinder = "Invalid interface descriptor: ";
            interfaceDescriptor = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", interfaceDescriptor.length() != 0 ? iBinder.concat(interfaceDescriptor) : new String(iBinder));
            throw new RemoteException();
        }
    }
}

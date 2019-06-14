package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGatt;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BluetoothGattProvider */
/* renamed from: com.polidea.a.b.b.a */
public class C5562a {
    /* renamed from: a */
    private final AtomicReference<BluetoothGatt> f18638a = new AtomicReference();

    C5562a() {
    }

    /* renamed from: a */
    public BluetoothGatt m23652a() {
        return (BluetoothGatt) this.f18638a.get();
    }

    /* renamed from: a */
    public void m23653a(BluetoothGatt bluetoothGatt) {
        this.f18638a.compareAndSet(null, bluetoothGatt);
    }
}

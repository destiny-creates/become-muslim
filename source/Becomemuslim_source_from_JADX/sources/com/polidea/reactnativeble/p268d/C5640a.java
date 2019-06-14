package com.polidea.reactnativeble.p268d;

import android.bluetooth.BluetoothGattCharacteristic;

/* compiled from: CannotMonitorCharacteristicException */
/* renamed from: com.polidea.reactnativeble.d.a */
public class C5640a extends RuntimeException {
    /* renamed from: a */
    private BluetoothGattCharacteristic f18877a;

    public C5640a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f18877a = bluetoothGattCharacteristic;
    }

    /* renamed from: a */
    public BluetoothGattCharacteristic m23968a() {
        return this.f18877a;
    }
}

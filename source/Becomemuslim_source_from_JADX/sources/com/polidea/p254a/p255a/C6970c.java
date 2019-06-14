package com.polidea.p254a.p255a;

import android.bluetooth.BluetoothGattCharacteristic;

/* compiled from: BleCannotSetCharacteristicNotificationException */
/* renamed from: com.polidea.a.a.c */
public class C6970c extends C5548g {
    /* renamed from: a */
    private final BluetoothGattCharacteristic f24855a;
    /* renamed from: b */
    private final int f24856b;

    /* renamed from: a */
    private static String m32741a(int i) {
        switch (i) {
            case 1:
                return "Cannot set local notification";
            case 2:
                return "Cannot find client characteristic config descriptor";
            case 3:
                return "Cannot write client characteristic config descriptor";
            default:
                return "Unknown error";
        }
    }

    public C6970c(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, Throwable th) {
        super(C6970c.m32742a(bluetoothGattCharacteristic, i), th);
        this.f24855a = bluetoothGattCharacteristic;
        this.f24856b = i;
    }

    /* renamed from: a */
    public BluetoothGattCharacteristic m32743a() {
        return this.f24855a;
    }

    /* renamed from: a */
    private static String m32742a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C6970c.m32741a(i));
        stringBuilder.append(" (code ");
        stringBuilder.append(i);
        stringBuilder.append(") with characteristic UUID ");
        stringBuilder.append(bluetoothGattCharacteristic.getUuid());
        return stringBuilder.toString();
    }
}

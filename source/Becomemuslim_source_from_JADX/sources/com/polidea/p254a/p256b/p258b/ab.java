package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.p254a.p256b.p262f.C5603f;
import java.util.Locale;

/* compiled from: IllegalOperationMessageCreator */
/* renamed from: com.polidea.a.b.b.ab */
public class ab {
    /* renamed from: a */
    private C5603f f18640a;

    public ab(C5603f c5603f) {
        this.f18640a = c5603f;
    }

    /* renamed from: a */
    public String m23655a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        return String.format(Locale.getDefault(), "Characteristic %s supports properties: %s (%d) does not have any property matching %s (%d)", new Object[]{bluetoothGattCharacteristic.getUuid(), this.f18640a.m23824a(bluetoothGattCharacteristic.getProperties()), Integer.valueOf(bluetoothGattCharacteristic.getProperties()), this.f18640a.m23824a(i), Integer.valueOf(i)});
    }
}

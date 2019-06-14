package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.p254a.p256b.C5560a;
import com.polidea.p254a.p256b.C5615p;

/* compiled from: ThrowingIllegalOperationHandler */
/* renamed from: com.polidea.a.b.b.az */
public class az extends aa {
    public az(ab abVar) {
        super(abVar);
    }

    /* renamed from: a */
    public C5560a mo4981a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        String a = this.a.m23655a(bluetoothGattCharacteristic, i);
        C5615p.m23871e(a, new Object[0]);
        return new C5560a(a, bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getProperties(), i);
    }
}

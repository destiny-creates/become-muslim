package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothGatt;
import com.polidea.p254a.p255a.C5549m;
import com.polidea.p254a.p256b.C7998q;
import com.polidea.p254a.p256b.p258b.av;
import p289e.C5974e;

/* compiled from: ReadRssiOperation */
/* renamed from: com.polidea.a.b.c.n */
public class C8244n extends C7998q<Integer> {
    C8244n(av avVar, BluetoothGatt bluetoothGatt, C5583t c5583t) {
        super(bluetoothGatt, avVar, C5549m.f18604j, c5583t);
    }

    /* renamed from: a */
    protected C5974e<Integer> mo6755a(av avVar) {
        return avVar.m23721j();
    }

    /* renamed from: a */
    protected boolean mo6756a(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.readRemoteRssi();
    }
}

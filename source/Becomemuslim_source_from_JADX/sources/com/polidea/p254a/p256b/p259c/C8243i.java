package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothGatt;
import com.polidea.p254a.p255a.C5549m;
import com.polidea.p254a.p256b.C7998q;
import com.polidea.p254a.p256b.p258b.av;
import p289e.C5974e;

/* compiled from: MtuRequestOperation */
/* renamed from: com.polidea.a.b.c.i */
public class C8243i extends C7998q<Integer> {
    /* renamed from: a */
    private final int f32417a;

    C8243i(av avVar, BluetoothGatt bluetoothGatt, C5583t c5583t, int i) {
        super(bluetoothGatt, avVar, C5549m.f18605k, c5583t);
        this.f32417a = i;
    }

    /* renamed from: a */
    protected C5974e<Integer> mo6755a(av avVar) {
        return avVar.m23716e();
    }

    /* renamed from: a */
    protected boolean mo6756a(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.requestMtu(this.f32417a);
    }
}

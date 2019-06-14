package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.p254a.p256b.C5560a;
import p289e.C5912a;
import p289e.p291b.C5913a;

/* compiled from: IllegalOperationChecker */
/* renamed from: com.polidea.a.b.b.y */
public class C5576y {
    /* renamed from: a */
    private aa f18688a;

    public C5576y(aa aaVar) {
        this.f18688a = aaVar;
    }

    /* renamed from: a */
    public C5912a m23753a(final BluetoothGattCharacteristic bluetoothGattCharacteristic, final int i) {
        return C5912a.m24802a(new C5913a(this) {
            /* renamed from: c */
            final /* synthetic */ C5576y f24959c;

            /* renamed from: a */
            public void mo4985a() {
                if ((bluetoothGattCharacteristic.getProperties() & i) == 0) {
                    C5560a a = this.f24959c.f18688a.mo4981a(bluetoothGattCharacteristic, i);
                    if (a != null) {
                        throw a;
                    }
                }
            }
        });
    }
}

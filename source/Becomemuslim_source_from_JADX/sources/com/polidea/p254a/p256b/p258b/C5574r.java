package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.p254a.p256b.p259c.C5579k;
import com.polidea.p254a.p256b.p261e.C7062d;
import p289e.C5974e;

/* compiled from: DescriptorWriter */
/* renamed from: com.polidea.a.b.b.r */
class C5574r {
    /* renamed from: a */
    private final C7062d f18686a;
    /* renamed from: b */
    private final C5579k f18687b;

    C5574r(C7062d c7062d, C5579k c5579k) {
        this.f18686a = c7062d;
        this.f18687b = c5579k;
    }

    /* renamed from: a */
    C5974e<byte[]> m23750a(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return this.f18686a.mo5016a(this.f18687b.mo5005a(bluetoothGattDescriptor, bArr));
    }
}

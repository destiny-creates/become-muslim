package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.polidea.p254a.p256b.p260d.C5586c;
import com.polidea.p254a.p256b.p260d.C5587d;
import com.polidea.p254a.p256b.p260d.C5588h;
import com.polidea.p254a.p256b.p262f.C5610w;
import p289e.C7332c;

/* compiled from: ScanOperationApi18 */
/* renamed from: com.polidea.a.b.c.q */
public class C8245q extends C7960p<C5588h, LeScanCallback> {
    /* renamed from: a */
    private final C5587d f32418a;
    /* renamed from: b */
    private final C5586c f32419b;

    /* renamed from: a */
    /* synthetic */ Object mo6757a(C7332c c7332c) {
        return m42822b(c7332c);
    }

    public C8245q(C5610w c5610w, C5587d c5587d, C5586c c5586c) {
        super(c5610w);
        this.f32418a = c5587d;
        this.f32419b = c5586c;
    }

    /* renamed from: b */
    LeScanCallback m42822b(final C7332c<C5588h> c7332c) {
        return new LeScanCallback(this) {
            /* renamed from: b */
            final /* synthetic */ C8245q f18690b;

            public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                bluetoothDevice = this.f18690b.f32418a.m23778a(bluetoothDevice, i, bArr);
                if (this.f18690b.f32419b.m23775a(bluetoothDevice) != 0) {
                    c7332c.mo5000a((Object) bluetoothDevice);
                }
            }
        };
    }

    /* renamed from: a */
    boolean m42820a(C5610w c5610w, LeScanCallback leScanCallback) {
        return c5610w.m23840a(leScanCallback);
    }

    /* renamed from: b */
    void m42823b(C5610w c5610w, LeScanCallback leScanCallback) {
        c5610w.m23841b(leScanCallback);
    }
}

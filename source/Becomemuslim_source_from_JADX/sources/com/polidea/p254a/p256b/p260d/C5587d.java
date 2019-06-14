package com.polidea.p254a.p256b.p260d;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p256b.p262f.aa;
import com.polidea.p254a.p263c.C5616a;

/* compiled from: InternalScanResultCreator */
/* renamed from: com.polidea.a.b.d.d */
public class C5587d {
    /* renamed from: a */
    private final aa f18700a;

    public C5587d(aa aaVar) {
        this.f18700a = aaVar;
    }

    /* renamed from: a */
    public C5588h m23778a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        return new C5588h(bluetoothDevice, i, System.nanoTime(), this.f18700a.m23812a(bArr), C5616a.CALLBACK_TYPE_UNSPECIFIED);
    }

    /* renamed from: a */
    public C5588h m23779a(ScanResult scanResult) {
        return new C5588h(scanResult.getDevice(), scanResult.getRssi(), scanResult.getTimestampNanos(), new C7045o(scanResult.getScanRecord()), C5616a.CALLBACK_TYPE_BATCH);
    }

    /* renamed from: a */
    public C5588h m23777a(int i, ScanResult scanResult) {
        return new C5588h(scanResult.getDevice(), scanResult.getRssi(), scanResult.getTimestampNanos(), new C7045o(scanResult.getScanRecord()), C5587d.m23776a(i));
    }

    /* renamed from: a */
    private static C5616a m23776a(int i) {
        if (i == 4) {
            return C5616a.CALLBACK_TYPE_MATCH_LOST;
        }
        switch (i) {
            case 1:
                return C5616a.CALLBACK_TYPE_ALL_MATCHES;
            case 2:
                return C5616a.CALLBACK_TYPE_FIRST_MATCH;
            default:
                C5615p.m23870d("Unknown callback type %d -> check android.bluetooth.le.ScanSettings", new Object[0]);
                return C5616a.CALLBACK_TYPE_UNKNOWN;
        }
    }
}

package com.polidea.p254a.p256b.p262f;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import com.polidea.p254a.p256b.C5615p;
import java.util.List;

/* compiled from: RxBleAdapterWrapper */
/* renamed from: com.polidea.a.b.f.w */
public class C5610w {
    /* renamed from: a */
    private final BluetoothAdapter f18742a;

    public C5610w(BluetoothAdapter bluetoothAdapter) {
        this.f18742a = bluetoothAdapter;
    }

    /* renamed from: a */
    public BluetoothDevice m23836a(String str) {
        return this.f18742a.getRemoteDevice(str);
    }

    /* renamed from: a */
    public boolean m23839a() {
        return this.f18742a != null;
    }

    /* renamed from: b */
    public boolean m23842b() {
        return this.f18742a != null && this.f18742a.isEnabled();
    }

    /* renamed from: a */
    public boolean m23840a(LeScanCallback leScanCallback) {
        return this.f18742a.startLeScan(leScanCallback);
    }

    /* renamed from: b */
    public void m23841b(LeScanCallback leScanCallback) {
        this.f18742a.stopLeScan(leScanCallback);
    }

    @TargetApi(21)
    /* renamed from: a */
    public void m23838a(List<ScanFilter> list, ScanSettings scanSettings, ScanCallback scanCallback) {
        this.f18742a.getBluetoothLeScanner().startScan(list, scanSettings, scanCallback);
    }

    @TargetApi(21)
    /* renamed from: a */
    public void m23837a(ScanCallback scanCallback) {
        BluetoothLeScanner bluetoothLeScanner = this.f18742a.getBluetoothLeScanner();
        if (bluetoothLeScanner == null) {
            C5615p.m23865b("Cannot perform BluetoothLeScanner.stopScan(ScanCallback) because scanner is unavailable (Probably adapter is off)", new Object[0]);
        } else {
            bluetoothLeScanner.stopScan(scanCallback);
        }
    }
}

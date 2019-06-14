package com.polidea.p254a.p255a;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import com.polidea.p254a.p264d.C5625a;

/* compiled from: BleGattException */
/* renamed from: com.polidea.a.a.l */
public class C6974l extends C5548g {
    /* renamed from: a */
    private final BluetoothGatt f24862a;
    /* renamed from: b */
    private final int f24863b;
    /* renamed from: c */
    private final C5549m f24864c;

    public C6974l(BluetoothGatt bluetoothGatt, int i, C5549m c5549m) {
        super(C6974l.m32749a(bluetoothGatt, i, c5549m));
        this.f24862a = bluetoothGatt;
        this.f24863b = i;
        this.f24864c = c5549m;
    }

    public C6974l(BluetoothGatt bluetoothGatt, C5549m c5549m) {
        this(bluetoothGatt, -1, c5549m);
    }

    /* renamed from: a */
    public String m32750a() {
        return C6974l.m32748a(this.f24862a);
    }

    /* renamed from: b */
    public C5549m m32751b() {
        return this.f24864c;
    }

    /* renamed from: c */
    public int m32752c() {
        return this.f24863b;
    }

    /* renamed from: a */
    private static String m32748a(BluetoothGatt bluetoothGatt) {
        return (bluetoothGatt == null || bluetoothGatt.getDevice() == null) ? null : bluetoothGatt.getDevice().getAddress();
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    private static String m32749a(BluetoothGatt bluetoothGatt, int i, C5549m c5549m) {
        if (i == -1) {
            return String.format("GATT exception from MAC address %s, with type %s", new Object[]{C6974l.m32748a(bluetoothGatt), c5549m});
        }
        String a = C5625a.m23920a(i);
        return String.format("GATT exception from MAC address %s, status %d (%s), type %s. (Look up status 0x%02x here %s)", new Object[]{C6974l.m32748a(bluetoothGatt), Integer.valueOf(i), a, c5549m, Integer.valueOf(i), "https://android.googlesource.com/platform/external/bluetooth/bluedroid/+/android-5.1.0_r1/stack/include/gatt_api.h"});
    }
}

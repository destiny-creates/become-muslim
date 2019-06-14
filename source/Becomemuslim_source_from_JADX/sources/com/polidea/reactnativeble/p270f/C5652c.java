package com.polidea.reactnativeble.p270f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.polidea.reactnativeble.p269e.C5643c;
import com.polidea.reactnativeble.p269e.C5644d;
import com.polidea.reactnativeble.p269e.C5649i;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* compiled from: Service */
/* renamed from: com.polidea.reactnativeble.f.c */
public class C5652c {
    /* renamed from: a */
    private C5651b f18898a;
    /* renamed from: b */
    private BluetoothGattService f18899b;
    /* renamed from: c */
    private int f18900c;

    public C5652c(C5651b c5651b, BluetoothGattService bluetoothGattService) {
        this.f18898a = c5651b;
        this.f18899b = bluetoothGattService;
        this.f18900c = C5643c.m23974a(new C5644d(c5651b.m23996b(), bluetoothGattService.getUuid(), bluetoothGattService.getInstanceId()));
    }

    /* renamed from: a */
    public int m23998a() {
        return this.f18900c;
    }

    /* renamed from: b */
    public C5651b m24000b() {
        return this.f18898a;
    }

    /* renamed from: c */
    public BluetoothGattService m24001c() {
        return this.f18899b;
    }

    /* renamed from: a */
    public C5650a m23999a(UUID uuid) {
        uuid = this.f18899b.getCharacteristic(uuid);
        if (uuid == null) {
            return null;
        }
        return new C5650a(this, uuid);
    }

    /* renamed from: d */
    public List<C5650a> m24002d() {
        List arrayList = new ArrayList(this.f18899b.getCharacteristics().size());
        for (BluetoothGattCharacteristic c5650a : this.f18899b.getCharacteristics()) {
            arrayList.add(new C5650a(this, c5650a));
        }
        return arrayList;
    }

    /* renamed from: e */
    public WritableMap m24003e() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", this.f18900c);
        createMap.putString("uuid", C5649i.m23982a(this.f18899b.getUuid()));
        createMap.putString("deviceID", this.f18898a.m23996b().mo5026c());
        createMap.putBoolean("isPrimary", this.f18899b.getType() == 0);
        return createMap;
    }
}

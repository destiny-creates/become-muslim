package com.polidea.reactnativeble.p270f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.reactnativeble.p269e.C5641a;
import com.polidea.reactnativeble.p269e.C5643c;
import com.polidea.reactnativeble.p269e.C5644d;
import com.polidea.reactnativeble.p269e.C5649i;
import java.util.UUID;

/* compiled from: Characteristic */
/* renamed from: com.polidea.reactnativeble.f.a */
public class C5650a {
    /* renamed from: a */
    public static final UUID f18890a = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    /* renamed from: e */
    private static final char[] f18891e = "0123456789ABCDEF".toCharArray();
    /* renamed from: b */
    private C5652c f18892b;
    /* renamed from: c */
    private BluetoothGattCharacteristic f18893c;
    /* renamed from: d */
    private int f18894d;

    public C5650a(C5652c c5652c, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f18892b = c5652c;
        this.f18893c = bluetoothGattCharacteristic;
        this.f18894d = C5643c.m23974a(new C5644d(c5652c.m24000b().m23996b(), bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getInstanceId()));
    }

    /* renamed from: a */
    public int m23987a() {
        return this.f18894d;
    }

    /* renamed from: b */
    public C5652c m23990b() {
        return this.f18892b;
    }

    /* renamed from: c */
    public BluetoothGattCharacteristic m23991c() {
        return this.f18893c;
    }

    /* renamed from: a */
    public WritableMap m23988a(byte[] bArr) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", this.f18894d);
        createMap.putString("uuid", C5649i.m23982a(this.f18893c.getUuid()));
        createMap.putInt("serviceID", this.f18892b.m24001c().getInstanceId());
        createMap.putString("serviceUUID", C5649i.m23982a(this.f18892b.m24001c().getUuid()));
        createMap.putString("deviceID", this.f18892b.m24000b().m23996b().mo5026c());
        boolean z = false;
        createMap.putBoolean("isReadable", (this.f18893c.getProperties() & 2) != 0);
        createMap.putBoolean("isWritableWithResponse", (this.f18893c.getProperties() & 8) != 0);
        createMap.putBoolean("isWritableWithoutResponse", (this.f18893c.getProperties() & 4) != 0);
        createMap.putBoolean("isNotifiable", (this.f18893c.getProperties() & 16) != 0);
        createMap.putBoolean("isIndicatable", (this.f18893c.getProperties() & 32) != 0);
        BluetoothGattDescriptor descriptor = this.f18893c.getDescriptor(f18890a);
        if (descriptor != null) {
            byte[] value = descriptor.getValue();
            if (!(value == null || (value[0] & 1) == 0)) {
                z = true;
            }
        }
        createMap.putBoolean("isNotifying", z);
        if (bArr == null) {
            bArr = this.f18893c.getValue();
        }
        createMap.putString("value", bArr != null ? C5641a.m23969a(bArr) : null);
        return createMap;
    }

    /* renamed from: b */
    private static String m23986b(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & JfifUtil.MARKER_FIRST_BYTE;
            int i3 = i * 2;
            cArr[i3] = f18891e[i2 >>> 4];
            cArr[i3 + 1] = f18891e[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public void m23989a(String str, byte[] bArr) {
        if (bArr == null) {
            bArr = this.f18893c.getValue();
        }
        bArr = bArr != null ? C5650a.m23986b(bArr) : "(null)";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" Characteristic(uuid: ");
        stringBuilder.append(this.f18893c.getUuid().toString());
        stringBuilder.append(", id: ");
        stringBuilder.append(this.f18894d);
        stringBuilder.append(", value: ");
        stringBuilder.append(bArr);
        stringBuilder.append(")");
        C5615p.m23863a(stringBuilder.toString(), new Object[null]);
    }
}

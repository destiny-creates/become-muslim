package com.polidea.p254a.p256b.p262f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.Arrays;
import java.util.UUID;

/* compiled from: ByteAssociation */
/* renamed from: com.polidea.a.b.f.c */
public class C5601c<T> {
    /* renamed from: a */
    public final T f18725a;
    /* renamed from: b */
    public final byte[] f18726b;

    public C5601c(T t, byte[] bArr) {
        this.f18725a = t;
        this.f18726b = bArr;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C5601c)) {
            return false;
        }
        C5601c c5601c = (C5601c) obj;
        if (Arrays.equals(c5601c.f18726b, this.f18726b) && c5601c.f18725a.equals(this.f18725a) != null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.f18725a.hashCode() ^ Arrays.hashCode(this.f18726b);
    }

    public String toString() {
        String stringBuilder;
        StringBuilder stringBuilder2;
        if (this.f18725a instanceof BluetoothGattCharacteristic) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(BluetoothGattCharacteristic.class.getSimpleName());
            stringBuilder2.append("(");
            stringBuilder2.append(((BluetoothGattCharacteristic) this.f18725a).getUuid().toString());
            stringBuilder2.append(")");
            stringBuilder = stringBuilder2.toString();
        } else if (this.f18725a instanceof BluetoothGattDescriptor) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(BluetoothGattDescriptor.class.getSimpleName());
            stringBuilder2.append("(");
            stringBuilder2.append(((BluetoothGattDescriptor) this.f18725a).getUuid().toString());
            stringBuilder2.append(")");
            stringBuilder = stringBuilder2.toString();
        } else if (this.f18725a instanceof UUID) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(UUID.class.getSimpleName());
            stringBuilder2.append("(");
            stringBuilder2.append(this.f18725a.toString());
            stringBuilder2.append(")");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = this.f18725a.getClass().getSimpleName();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(getClass().getSimpleName());
        stringBuilder3.append("[first=");
        stringBuilder3.append(stringBuilder);
        stringBuilder3.append(", second=");
        stringBuilder3.append(Arrays.toString(this.f18726b));
        stringBuilder3.append("]");
        return stringBuilder3.toString();
    }
}

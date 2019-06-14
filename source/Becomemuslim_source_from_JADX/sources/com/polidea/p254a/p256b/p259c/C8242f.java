package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.p254a.p255a.C5549m;
import com.polidea.p254a.p256b.C7998q;
import com.polidea.p254a.p256b.p258b.av;
import com.polidea.p254a.p256b.p262f.C5601c;
import p289e.C5974e;
import p289e.p291b.C5919g;

/* compiled from: DescriptorWriteOperation */
/* renamed from: com.polidea.a.b.c.f */
public class C8242f extends C7998q<byte[]> {
    /* renamed from: a */
    private BluetoothGattDescriptor f32414a;
    /* renamed from: b */
    private byte[] f32415b;
    /* renamed from: c */
    private final int f32416c;

    /* compiled from: DescriptorWriteOperation */
    /* renamed from: com.polidea.a.b.c.f$1 */
    class C70291 implements C5919g<C5601c<BluetoothGattDescriptor>, byte[]> {
        /* renamed from: a */
        final /* synthetic */ C8242f f24973a;

        C70291(C8242f c8242f) {
            this.f24973a = c8242f;
        }

        /* renamed from: a */
        public byte[] m32882a(C5601c<BluetoothGattDescriptor> c5601c) {
            return c5601c.f18726b;
        }
    }

    /* compiled from: DescriptorWriteOperation */
    /* renamed from: com.polidea.a.b.c.f$2 */
    class C70302 implements C5919g<C5601c<BluetoothGattDescriptor>, Boolean> {
        /* renamed from: a */
        final /* synthetic */ C8242f f24974a;

        C70302(C8242f c8242f) {
            this.f24974a = c8242f;
        }

        /* renamed from: a */
        public Boolean m32883a(C5601c<BluetoothGattDescriptor> c5601c) {
            return Boolean.valueOf(((BluetoothGattDescriptor) c5601c.f18725a).equals(this.f24974a.f32414a));
        }
    }

    C8242f(av avVar, BluetoothGatt bluetoothGatt, C5583t c5583t, int i, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        super(bluetoothGatt, avVar, C5549m.f18602h, c5583t);
        this.f32416c = i;
        this.f32414a = bluetoothGattDescriptor;
        this.f32415b = bArr;
    }

    /* renamed from: a */
    protected C5974e<byte[]> mo6755a(av avVar) {
        return avVar.m23720i().m25013b(new C70302(this)).m25030e(new C70291(this));
    }

    /* renamed from: a */
    protected boolean mo6756a(BluetoothGatt bluetoothGatt) {
        this.f32414a.setValue(this.f32415b);
        BluetoothGattCharacteristic characteristic = this.f32414a.getCharacteristic();
        int writeType = characteristic.getWriteType();
        characteristic.setWriteType(this.f32416c);
        bluetoothGatt = bluetoothGatt.writeDescriptor(this.f32414a);
        characteristic.setWriteType(writeType);
        return bluetoothGatt;
    }
}

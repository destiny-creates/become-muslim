package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.p254a.p255a.C5549m;
import com.polidea.p254a.p256b.C7998q;
import com.polidea.p254a.p256b.p258b.av;
import com.polidea.p254a.p256b.p262f.C5601c;
import java.util.UUID;
import p289e.C5974e;
import p289e.p291b.C5919g;

/* compiled from: CharacteristicWriteOperation */
/* renamed from: com.polidea.a.b.c.b */
public class C8240b extends C7998q<byte[]> {
    /* renamed from: a */
    private final BluetoothGattCharacteristic f32408a;
    /* renamed from: b */
    private final byte[] f32409b;

    /* compiled from: CharacteristicWriteOperation */
    /* renamed from: com.polidea.a.b.c.b$1 */
    class C70211 implements C5919g<C5601c<UUID>, byte[]> {
        /* renamed from: a */
        final /* synthetic */ C8240b f24963a;

        C70211(C8240b c8240b) {
            this.f24963a = c8240b;
        }

        /* renamed from: a */
        public byte[] m32870a(C5601c<UUID> c5601c) {
            return c5601c.f18726b;
        }
    }

    /* compiled from: CharacteristicWriteOperation */
    /* renamed from: com.polidea.a.b.c.b$2 */
    class C70222 implements C5919g<C5601c<UUID>, Boolean> {
        /* renamed from: a */
        final /* synthetic */ C8240b f24964a;

        C70222(C8240b c8240b) {
            this.f24964a = c8240b;
        }

        /* renamed from: a */
        public Boolean m32871a(C5601c<UUID> c5601c) {
            return Boolean.valueOf(((UUID) c5601c.f18725a).equals(this.f24964a.f32408a.getUuid()));
        }
    }

    C8240b(av avVar, BluetoothGatt bluetoothGatt, C5583t c5583t, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        super(bluetoothGatt, avVar, C5549m.f18598d, c5583t);
        this.f32408a = bluetoothGattCharacteristic;
        this.f32409b = bArr;
    }

    /* renamed from: a */
    protected C5974e<byte[]> mo6755a(av avVar) {
        return avVar.m23718g().m25013b(new C70222(this)).m25030e(new C70211(this));
    }

    /* renamed from: a */
    protected boolean mo6756a(BluetoothGatt bluetoothGatt) {
        this.f32408a.setValue(this.f32409b);
        return bluetoothGatt.writeCharacteristic(this.f32408a);
    }
}

package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.p071c.p072a.C4536c;
import com.p071c.p072a.C4539g;
import com.polidea.p254a.af.C5554a;
import com.polidea.p254a.ai;
import com.polidea.p254a.p255a.C5549m;
import com.polidea.p254a.p255a.C6973f;
import com.polidea.p254a.p255a.C6974l;
import com.polidea.p254a.p255a.C7931j;
import com.polidea.p254a.p255a.C7932k;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p256b.p262f.C5601c;
import com.polidea.p254a.p256b.p262f.C7067d;
import java.util.UUID;
import p289e.C5974e;
import p289e.C5986h;
import p289e.p291b.C5919g;

/* compiled from: RxBleGattCallback */
/* renamed from: com.polidea.a.b.b.av */
public class av {
    /* renamed from: a */
    private final C5986h f18660a;
    /* renamed from: b */
    private final C5562a f18661b;
    /* renamed from: c */
    private final C7016v f18662c;
    /* renamed from: d */
    private final an f18663d;
    /* renamed from: e */
    private final C4536c<C5554a> f18664e = C4536c.b();
    /* renamed from: f */
    private final C5565a<ai> f18665f = new C5565a();
    /* renamed from: g */
    private final C5565a<C5601c<UUID>> f18666g = new C5565a();
    /* renamed from: h */
    private final C5565a<C5601c<UUID>> f18667h = new C5565a();
    /* renamed from: i */
    private final C4539g<C7067d, C7067d> f18668i = C4536c.b().c();
    /* renamed from: j */
    private final C5565a<C5601c<BluetoothGattDescriptor>> f18669j = new C5565a();
    /* renamed from: k */
    private final C5565a<C5601c<BluetoothGattDescriptor>> f18670k = new C5565a();
    /* renamed from: l */
    private final C5565a<Integer> f18671l = new C5565a();
    /* renamed from: m */
    private final C5565a<Integer> f18672m = new C5565a();
    /* renamed from: n */
    private final C5919g<C6974l, C5974e<?>> f18673n = new C69991(this);
    /* renamed from: o */
    private BluetoothGattCallback f18674o = new C55642(this);

    /* compiled from: RxBleGattCallback */
    /* renamed from: com.polidea.a.b.b.av$2 */
    class C55642 extends BluetoothGattCallback {
        /* renamed from: a */
        final /* synthetic */ av f18657a;

        /* renamed from: a */
        private boolean m23686a(int i) {
            if (i != 0) {
                if (i != 3) {
                    return false;
                }
            }
            return true;
        }

        C55642(av avVar) {
            this.f18657a = avVar;
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            C5615p.m23865b("onConnectionStateChange newState=%d status=%d", Integer.valueOf(i2), Integer.valueOf(i));
            this.f18657a.f18663d.m23658a(bluetoothGatt, i, i2);
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            this.f18657a.f18661b.m23653a(bluetoothGatt);
            if (m23686a(i2)) {
                this.f18657a.f18662c.m32860a(new C6973f(bluetoothGatt.getDevice().getAddress(), i));
            } else if (i != 0) {
                this.f18657a.f18662c.m32861a(new C6974l(bluetoothGatt, i, C5549m.f18595a));
            }
            this.f18657a.f18664e.b(this.f18657a.m23688a(i2));
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            C5615p.m23865b("onServicesDiscovered status=%d", Integer.valueOf(i));
            this.f18657a.f18663d.m23663b(bluetoothGatt, i);
            super.onServicesDiscovered(bluetoothGatt, i);
            if (this.f18657a.f18665f.m23687a() && this.f18657a.m23692a(this.f18657a.f18665f, bluetoothGatt, i, C5549m.f18596b) == 0) {
                this.f18657a.f18665f.f18658a.b(new ai(bluetoothGatt.getServices()));
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            C5615p.m23865b("onCharacteristicRead characteristic=%s status=%d", bluetoothGattCharacteristic.getUuid(), Integer.valueOf(i));
            this.f18657a.f18663d.m23665b(bluetoothGatt, bluetoothGattCharacteristic, i);
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (this.f18657a.f18666g.m23687a()) {
                if (this.f18657a.m23693a(this.f18657a.f18666g, bluetoothGatt, bluetoothGattCharacteristic, i, C5549m.f18597c) == null) {
                    this.f18657a.f18666g.f18658a.b(new C5601c(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue()));
                }
            }
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            C5615p.m23865b("onCharacteristicWrite characteristic=%s status=%d", bluetoothGattCharacteristic.getUuid(), Integer.valueOf(i));
            this.f18657a.f18663d.m23660a(bluetoothGatt, bluetoothGattCharacteristic, i);
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (this.f18657a.f18667h.m23687a()) {
                if (this.f18657a.m23693a(this.f18657a.f18667h, bluetoothGatt, bluetoothGattCharacteristic, i, C5549m.f18598d) == null) {
                    this.f18657a.f18667h.f18658a.b(new C5601c(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getValue()));
                }
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            C5615p.m23865b("onCharacteristicChanged characteristic=%s", bluetoothGattCharacteristic.getUuid());
            this.f18657a.f18663d.m23659a(bluetoothGatt, bluetoothGattCharacteristic);
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            if (this.f18657a.f18668i.a() != null) {
                this.f18657a.f18668i.b(new C7067d(bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getValue()));
            }
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            C5615p.m23865b("onCharacteristicRead descriptor=%s status=%d", bluetoothGattDescriptor.getUuid(), Integer.valueOf(i));
            this.f18657a.f18663d.m23661a(bluetoothGatt, bluetoothGattDescriptor, i);
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
            if (this.f18657a.f18669j.m23687a()) {
                if (this.f18657a.m23694a(this.f18657a.f18669j, bluetoothGatt, bluetoothGattDescriptor, i, C5549m.f18601g) == null) {
                    this.f18657a.f18669j.f18658a.b(new C5601c(bluetoothGattDescriptor, bluetoothGattDescriptor.getValue()));
                }
            }
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            C5615p.m23865b("onDescriptorWrite descriptor=%s status=%d", bluetoothGattDescriptor.getUuid(), Integer.valueOf(i));
            this.f18657a.f18663d.m23666b(bluetoothGatt, bluetoothGattDescriptor, i);
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            if (this.f18657a.f18670k.m23687a()) {
                if (this.f18657a.m23694a(this.f18657a.f18670k, bluetoothGatt, bluetoothGattDescriptor, i, C5549m.f18602h) == null) {
                    this.f18657a.f18670k.f18658a.b(new C5601c(bluetoothGattDescriptor, bluetoothGattDescriptor.getValue()));
                }
            }
        }

        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
            C5615p.m23865b("onReliableWriteCompleted status=%d", Integer.valueOf(i));
            this.f18657a.f18663d.m23657a(bluetoothGatt, i);
            super.onReliableWriteCompleted(bluetoothGatt, i);
        }

        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            C5615p.m23865b("onReadRemoteRssi rssi=%d status=%d", Integer.valueOf(i), Integer.valueOf(i2));
            this.f18657a.f18663d.m23667c(bluetoothGatt, i, i2);
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
            if (this.f18657a.f18671l.m23687a() && this.f18657a.m23692a(this.f18657a.f18671l, bluetoothGatt, i2, C5549m.f18604j) == null) {
                this.f18657a.f18671l.f18658a.b(Integer.valueOf(i));
            }
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            C5615p.m23865b("onMtuChanged mtu=%d status=%d", Integer.valueOf(i), Integer.valueOf(i2));
            this.f18657a.f18663d.m23664b(bluetoothGatt, i, i2);
            super.onMtuChanged(bluetoothGatt, i, i2);
            if (this.f18657a.f18672m.m23687a() && this.f18657a.m23692a(this.f18657a.f18672m, bluetoothGatt, i2, C5549m.f18605k) == null) {
                this.f18657a.f18672m.f18658a.b(Integer.valueOf(i));
            }
        }
    }

    /* compiled from: RxBleGattCallback */
    /* renamed from: com.polidea.a.b.b.av$a */
    private static class C5565a<T> {
        /* renamed from: a */
        final C4536c<T> f18658a = C4536c.b();
        /* renamed from: b */
        final C4536c<C6974l> f18659b = C4536c.b();

        C5565a() {
        }

        /* renamed from: a */
        boolean m23687a() {
            if (!this.f18658a.a()) {
                if (!this.f18659b.a()) {
                    return false;
                }
            }
            return true;
        }
    }

    /* compiled from: RxBleGattCallback */
    /* renamed from: com.polidea.a.b.b.av$1 */
    class C69991 implements C5919g<C6974l, C5974e<?>> {
        /* renamed from: a */
        final /* synthetic */ av f24929a;

        C69991(av avVar) {
            this.f24929a = avVar;
        }

        /* renamed from: a */
        public C5974e<?> m32827a(C6974l c6974l) {
            return C5974e.m24984b((Throwable) c6974l);
        }
    }

    /* renamed from: b */
    private boolean m23700b(int i) {
        return i != 0;
    }

    public av(C5986h c5986h, C5562a c5562a, C7016v c7016v, an anVar) {
        this.f18660a = c5986h;
        this.f18661b = c5562a;
        this.f18662c = c7016v;
        this.f18663d = anVar;
    }

    /* renamed from: a */
    private C5554a m23688a(int i) {
        switch (i) {
            case 1:
                return C5554a.CONNECTING;
            case 2:
                return C5554a.CONNECTED;
            case 3:
                return C5554a.DISCONNECTING;
            default:
                return C5554a.DISCONNECTED;
        }
    }

    /* renamed from: a */
    private boolean m23693a(C5565a c5565a, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, C5549m c5549m) {
        return (!m23700b(i) || m23695a(c5565a, new C7931j(bluetoothGatt, bluetoothGattCharacteristic, i, c5549m)) == null) ? null : true;
    }

    /* renamed from: a */
    private boolean m23694a(C5565a c5565a, BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i, C5549m c5549m) {
        return (!m23700b(i) || m23695a(c5565a, new C7932k(bluetoothGatt, bluetoothGattDescriptor, i, c5549m)) == null) ? null : true;
    }

    /* renamed from: a */
    private boolean m23692a(C5565a c5565a, BluetoothGatt bluetoothGatt, int i, C5549m c5549m) {
        return (!m23700b(i) || m23695a(c5565a, new C6974l(bluetoothGatt, i, c5549m)) == null) ? null : true;
    }

    /* renamed from: a */
    private boolean m23695a(C5565a c5565a, C6974l c6974l) {
        c5565a.f18659b.b(c6974l);
        return true;
    }

    /* renamed from: a */
    private <T> C5974e<T> m23691a(C5565a<T> c5565a) {
        return C5974e.m24975a(this.f18662c.m32862b(), c5565a.f18658a, c5565a.f18659b.c(this.f18673n));
    }

    /* renamed from: a */
    public BluetoothGattCallback m23711a() {
        return this.f18674o;
    }

    /* renamed from: b */
    public <T> C5974e<T> m23713b() {
        return this.f18662c.m32862b();
    }

    /* renamed from: c */
    public C5974e<C5554a> m23714c() {
        return this.f18664e.a(this.f18660a);
    }

    /* renamed from: d */
    public C5974e<ai> m23715d() {
        return m23691a(this.f18665f).m24999a(this.f18660a);
    }

    /* renamed from: e */
    public C5974e<Integer> m23716e() {
        return m23691a(this.f18672m).m24999a(this.f18660a);
    }

    /* renamed from: f */
    public C5974e<C5601c<UUID>> m23717f() {
        return m23691a(this.f18666g).m24999a(this.f18660a);
    }

    /* renamed from: g */
    public C5974e<C5601c<UUID>> m23718g() {
        return m23691a(this.f18667h).m24999a(this.f18660a);
    }

    /* renamed from: h */
    public C5974e<C7067d> m23719h() {
        return C5974e.m24986c(this.f18662c.m32862b(), this.f18668i).m24999a(this.f18660a);
    }

    /* renamed from: i */
    public C5974e<C5601c<BluetoothGattDescriptor>> m23720i() {
        return m23691a(this.f18670k).m24999a(this.f18660a);
    }

    /* renamed from: j */
    public C5974e<Integer> m23721j() {
        return m23691a(this.f18671l).m24999a(this.f18660a);
    }

    /* renamed from: a */
    public void m23712a(BluetoothGattCallback bluetoothGattCallback) {
        this.f18663d.m23662a(bluetoothGattCallback);
    }
}

package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.p254a.C5631z;
import com.polidea.p254a.p255a.C6970c;
import com.polidea.p254a.p255a.C6972e;
import com.polidea.p254a.p256b.p262f.C5599a;
import com.polidea.p254a.p256b.p262f.C5602e;
import com.polidea.p254a.p256b.p262f.C5608t;
import com.polidea.p254a.p256b.p262f.C7067d;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import p289e.C5912a;
import p289e.C5912a.C7230c;
import p289e.C5974e;
import p289e.C5974e.C7337c;
import p289e.p291b.C5913a;
import p289e.p291b.C5916d;
import p289e.p291b.C5918f;
import p289e.p291b.C5919g;
import p289e.p302h.C8151b;

/* compiled from: NotificationAndIndicationManager */
/* renamed from: com.polidea.a.b.b.aq */
class aq {
    /* renamed from: a */
    static final UUID f18649a = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    /* renamed from: b */
    private final byte[] f18650b;
    /* renamed from: c */
    private final byte[] f18651c;
    /* renamed from: d */
    private final byte[] f18652d;
    /* renamed from: e */
    private final BluetoothGatt f18653e;
    /* renamed from: f */
    private final av f18654f;
    /* renamed from: g */
    private final C5574r f18655g;
    /* renamed from: h */
    private final Map<C5602e, C5599a> f18656h = new HashMap();

    /* compiled from: NotificationAndIndicationManager */
    /* renamed from: com.polidea.a.b.b.aq$5 */
    static class C69955 implements C5919g<C7067d, byte[]> {
        C69955() {
        }

        /* renamed from: a */
        public byte[] m32808a(C7067d c7067d) {
            return c7067d.f25041a;
        }
    }

    aq(byte[] bArr, byte[] bArr2, byte[] bArr3, BluetoothGatt bluetoothGatt, av avVar, C5574r c5574r) {
        this.f18650b = bArr;
        this.f18651c = bArr2;
        this.f18652d = bArr3;
        this.f18653e = bluetoothGatt;
        this.f18654f = avVar;
        this.f18655g = c5574r;
    }

    /* renamed from: a */
    C5974e<C5974e<byte[]>> m23685a(final BluetoothGattCharacteristic bluetoothGattCharacteristic, final C5631z c5631z, final boolean z) {
        return C5974e.m24971a(new C5918f<C5974e<C5974e<byte[]>>>(this) {
            /* renamed from: d */
            final /* synthetic */ aq f24909d;

            public /* synthetic */ Object call() {
                return m32803a();
            }

            /* renamed from: a */
            public C5974e<C5974e<byte[]>> m32803a() {
                synchronized (this.f24909d.f18656h) {
                    final C5602e c5602e = new C5602e(bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()));
                    C5599a c5599a = (C5599a) this.f24909d.f18656h.get(c5602e);
                    if (c5599a == null) {
                        byte[] b = z ? this.f24909d.f18651c : this.f24909d.f18650b;
                        final C8151b b2 = C8151b.m39544b();
                        C5974e<C5974e<byte[]>> c = aq.m23673b(this.f24909d.f18653e, bluetoothGattCharacteristic, true).m24821b(C5608t.m23831a(aq.m23676b(this.f24909d.f18654f, c5602e))).m24998a(aq.m23678c(this.f24909d.f18655g, bluetoothGattCharacteristic, b, c5631z)).m25030e(new C5919g<C5974e<byte[]>, C5974e<byte[]>>(this) {
                            /* renamed from: b */
                            final /* synthetic */ C69921 f24905b;

                            /* renamed from: a */
                            public C5974e<byte[]> m32801a(C5974e<byte[]> c5974e) {
                                return C5974e.m24974a(b2.m25003a(byte[].class), c5974e.m25035g(b2));
                            }
                        }).m25018c(new C5913a(this) {
                            /* renamed from: c */
                            final /* synthetic */ C69921 f24903c;

                            /* renamed from: a */
                            public void mo4985a() {
                                b2.L_();
                                synchronized (this.f24903c.f24909d.f18656h) {
                                    this.f24903c.f24909d.f18656h.remove(c5602e);
                                }
                                aq.m23673b(this.f24903c.f24909d.f18653e, bluetoothGattCharacteristic, false).m24810a(aq.m23681d(this.f24903c.f24909d.f18655g, bluetoothGattCharacteristic, this.f24903c.f24909d.f18652d, c5631z)).m24814a(C5916d.m24828a(), C5916d.m24827a(C5916d.m24828a()));
                            }
                        }).m25033f(this.f24909d.f18654f.m23713b()).m25016c(1).m33703c();
                        this.f24909d.f18656h.put(c5602e, new C5599a(c, z));
                        return c;
                    } else if (c5599a.f18722b == z) {
                        r1 = c5599a.f18721a;
                        return r1;
                    } else {
                        r1 = C5974e.m24984b(new C6972e(bluetoothGattCharacteristic.getUuid(), true ^ z));
                        return r1;
                    }
                }
            }
        });
    }

    /* renamed from: b */
    private static C5912a m23673b(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final boolean z) {
        return C5912a.m24802a(new C5913a() {
            /* renamed from: a */
            public void mo4985a() {
                if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
                    throw new C6970c(bluetoothGattCharacteristic, 1, null);
                }
            }
        });
    }

    /* renamed from: c */
    private static C7337c<C5974e<byte[]>, C5974e<byte[]>> m23678c(final C5574r c5574r, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final C5631z c5631z) {
        return new C7337c<C5974e<byte[]>, C5974e<byte[]>>() {
            /* renamed from: a */
            public C5974e<C5974e<byte[]>> m38575a(C5974e<C5974e<byte[]>> c5974e) {
                switch (c5631z) {
                    case COMPAT:
                        return c5974e;
                    case QUICK_SETUP:
                        final C5912a e = aq.m23674b(bluetoothGattCharacteristic, c5574r, bArr).m24822c().m25044l().m33701a(2).m25028e();
                        return c5974e.m25033f(e.m24822c()).m25030e(new C5919g<C5974e<byte[]>, C5974e<byte[]>>(this) {
                            /* renamed from: b */
                            final /* synthetic */ C79363 f24914b;

                            /* renamed from: a */
                            public C5974e<byte[]> m32805a(C5974e<byte[]> c5974e) {
                                return c5974e.m25033f(e.m24817b().m24822c());
                            }
                        });
                    default:
                        return aq.m23674b(bluetoothGattCharacteristic, c5574r, bArr).m24821b((C5974e) c5974e);
                }
            }
        };
    }

    /* renamed from: d */
    private static C7230c m23681d(final C5574r c5574r, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final C5631z c5631z) {
        return new C7230c() {
            /* renamed from: a */
            public C5912a m38577a(C5912a c5912a) {
                if (c5631z == C5631z.COMPAT) {
                    return c5912a;
                }
                return c5912a.m24811a(aq.m23674b(bluetoothGattCharacteristic, c5574r, bArr));
            }
        };
    }

    /* renamed from: b */
    private static C5974e<byte[]> m23676b(av avVar, final C5602e c5602e) {
        return avVar.m23719h().m25013b(new C5919g<C7067d, Boolean>() {
            /* renamed from: a */
            public Boolean m32809a(C7067d c7067d) {
                return Boolean.valueOf(c7067d.equals(c5602e));
            }
        }).m25030e(new C69955());
    }

    /* renamed from: b */
    private static C5912a m23674b(final BluetoothGattCharacteristic bluetoothGattCharacteristic, C5574r c5574r, byte[] bArr) {
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(f18649a);
        if (descriptor == null) {
            return C5912a.m24804a(new C6970c(bluetoothGattCharacteristic, 2, null));
        }
        return c5574r.m23750a(descriptor, bArr).m25028e().m24820b(new C5919g<Throwable, C5912a>() {
            /* renamed from: a */
            public C5912a m32811a(Throwable th) {
                return C5912a.m24804a(new C6970c(bluetoothGattCharacteristic, 3, th));
            }
        });
    }
}

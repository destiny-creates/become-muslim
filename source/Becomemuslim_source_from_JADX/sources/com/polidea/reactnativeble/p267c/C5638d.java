package com.polidea.reactnativeble.p267c;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.p254a.p255a.C5549m;
import com.polidea.p254a.p255a.C6969b;
import com.polidea.p254a.p255a.C6970c;
import com.polidea.p254a.p255a.C6971d;
import com.polidea.p254a.p255a.C6972e;
import com.polidea.p254a.p255a.C6973f;
import com.polidea.p254a.p255a.C6974l;
import com.polidea.p254a.p255a.C6975n;
import com.polidea.p254a.p255a.C6976o;
import com.polidea.p254a.p255a.C7929h;
import com.polidea.p254a.p255a.C7930i;
import com.polidea.p254a.p255a.C7931j;
import com.polidea.p254a.p255a.C7932k;
import com.polidea.reactnativeble.p268d.C5640a;
import com.polidea.reactnativeble.p269e.C5649i;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/* compiled from: ErrorConverter */
/* renamed from: com.polidea.reactnativeble.c.d */
public class C5638d {
    /* renamed from: a */
    public C5635a m23966a(Throwable th) {
        BluetoothGattCharacteristic a;
        if (th instanceof C5640a) {
            a = ((C5640a) th).m23968a();
            return C5637c.m23958a(th.getMessage(), null, C5649i.m23982a(a.getService().getUuid()), C5649i.m23982a(a.getUuid()));
        } else if (th instanceof TimeoutException) {
            return new C5635a(C5636b.OperationTimedOut, th.getMessage(), null);
        } else {
            if (th instanceof C6969b) {
                return new C5635a(C5636b.DeviceAlreadyConnected, th.getMessage(), null);
            }
            if (th instanceof C6970c) {
                a = ((C6970c) th).m32743a();
                return C5637c.m23958a(th.getMessage(), null, C5649i.m23982a(a.getService().getUuid()), C5649i.m23982a(a.getUuid()));
            } else if (th instanceof C6971d) {
                UUID a2 = ((C6971d) th).m32744a();
                C5635a c5635a = new C5635a(C5636b.CharacteristicNotFound, th.getMessage(), null);
                c5635a.f18828c = C5649i.m23982a(a2);
                return c5635a;
            } else if (th instanceof C6972e) {
                return C5637c.m23958a(th.getMessage(), null, null, C5649i.m23982a(((C6972e) th).m32745a()));
            } else if (th instanceof C6973f) {
                C6973f c6973f = (C6973f) th;
                C5635a c5635a2 = new C5635a(C5636b.DeviceDisconnected, th.getMessage(), Integer.valueOf(c6973f.f24861b));
                c5635a2.f18826a = c6973f.f24860a;
                return c5635a2;
            } else if (th instanceof C6975n) {
                return m23965a((C6975n) th);
            } else {
                if (th instanceof C6976o) {
                    C5635a c5635a3 = new C5635a(C5636b.ServiceNotFound, th.getMessage(), null);
                    c5635a3.f18827b = C5649i.m23982a(((C6976o) th).m32757a());
                    return c5635a3;
                } else if (th instanceof C7929h) {
                    return new C5635a(C5636b.OperationTimedOut, th.getMessage(), Integer.valueOf(((C7929h) th).m32752c()));
                } else {
                    if (th instanceof C7930i) {
                        return new C5635a(C5636b.OperationStartFailed, th.getMessage(), Integer.valueOf(((C7930i) th).m32752c()));
                    }
                    if (th instanceof C7931j) {
                        C7931j c7931j = (C7931j) th;
                        return m23964a(c7931j.m32752c(), th.getMessage(), c7931j.m32751b(), c7931j.m32750a(), C5649i.m23982a(c7931j.f29542a.getService().getUuid()), C5649i.m23982a(c7931j.f29542a.getUuid()), null);
                    } else if (th instanceof C7932k) {
                        C7932k c7932k = (C7932k) th;
                        return m23964a(c7932k.m32752c(), th.getMessage(), c7932k.m32751b(), c7932k.m32750a(), C5649i.m23982a(c7932k.f29543a.getCharacteristic().getService().getUuid()), C5649i.m23982a(c7932k.f29543a.getCharacteristic().getUuid()), C5649i.m23982a(c7932k.f29543a.getUuid()));
                    } else if (!(th instanceof C6974l)) {
                        return new C5635a(C5636b.f18847a, th.toString(), null);
                    } else {
                        C6974l c6974l = (C6974l) th;
                        return m23964a(c6974l.m32752c(), th.getMessage(), c6974l.m32751b(), c6974l.m32750a(), null, null, null);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private C5635a m23964a(int i, String str, C5549m c5549m, String str2, String str3, String str4, String str5) {
        if (C5549m.f18595a == c5549m) {
            c5549m = new C5635a(C5636b.DeviceDisconnected, str, Integer.valueOf(i));
            c5549m.f18826a = str2;
            return c5549m;
        } else if (C5549m.f18596b == c5549m) {
            c5549m = new C5635a(C5636b.ServicesDiscoveryFailed, str, Integer.valueOf(i));
            c5549m.f18826a = str2;
            return c5549m;
        } else {
            if (C5549m.f18597c != c5549m) {
                if (C5549m.f18600f != c5549m) {
                    if (!(C5549m.f18598d == c5549m || C5549m.f18599e == c5549m)) {
                        if (C5549m.f18603i != c5549m) {
                            if (C5549m.f18601g == c5549m) {
                                c5549m = new C5635a(C5636b.DescriptorReadFailed, str, Integer.valueOf(i));
                                c5549m.f18826a = str2;
                                c5549m.f18827b = str3;
                                c5549m.f18828c = str4;
                                c5549m.f18829d = str5;
                                return c5549m;
                            }
                            if (C5549m.f18602h == c5549m) {
                                c5549m = new C5635a(C5636b.DescriptorWriteFailed, str, Integer.valueOf(i));
                                c5549m.f18826a = str2;
                                c5549m.f18827b = str3;
                                c5549m.f18828c = str4;
                                c5549m.f18829d = str5;
                            } else if (C5549m.f18604j == c5549m) {
                                c5549m = new C5635a(C5636b.DeviceRSSIReadFailed, str, Integer.valueOf(i));
                                c5549m.f18826a = str2;
                                return c5549m;
                            } else if (C5549m.f18605k == c5549m) {
                                c5549m = new C5635a(C5636b.DeviceMTUChangeFailed, str, Integer.valueOf(i));
                                c5549m.f18826a = str2;
                                return c5549m;
                            } else {
                                c5549m = C5549m.f18606l;
                            }
                            return new C5635a(C5636b.f18847a, str, Integer.valueOf(i));
                        }
                    }
                    c5549m = new C5635a(C5636b.CharacteristicWriteFailed, str, Integer.valueOf(i));
                    c5549m.f18826a = str2;
                    c5549m.f18827b = str3;
                    c5549m.f18828c = str4;
                    return c5549m;
                }
            }
            c5549m = new C5635a(C5636b.CharacteristicReadFailed, str, Integer.valueOf(i));
            c5549m.f18826a = str2;
            c5549m.f18827b = str3;
            c5549m.f18828c = str4;
            return c5549m;
        }
    }

    /* renamed from: a */
    private C5635a m23965a(C6975n c6975n) {
        switch (c6975n.m32756a()) {
            case 0:
                return new C5635a(C5636b.ScanStartFailed, c6975n.getMessage(), null);
            case 1:
                return new C5635a(C5636b.BluetoothPoweredOff, c6975n.getMessage(), null);
            case 2:
                return new C5635a(C5636b.BluetoothUnsupported, c6975n.getMessage(), null);
            case 3:
                return new C5635a(C5636b.BluetoothUnauthorized, c6975n.getMessage(), null);
            case 4:
                return new C5635a(C5636b.LocationServicesDisabled, c6975n.getMessage(), null);
            default:
                return new C5635a(C5636b.ScanStartFailed, c6975n.getMessage(), null);
        }
    }
}

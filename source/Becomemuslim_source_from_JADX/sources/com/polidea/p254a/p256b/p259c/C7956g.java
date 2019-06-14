package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.os.DeadObjectException;
import com.polidea.p254a.af.C5554a;
import com.polidea.p254a.p255a.C5548g;
import com.polidea.p254a.p255a.C6973f;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p256b.C7084k;
import com.polidea.p254a.p256b.p258b.C5562a;
import com.polidea.p254a.p256b.p258b.C5570m;
import com.polidea.p254a.p256b.p258b.av;
import com.polidea.p254a.p256b.p261e.C5598i;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C5986h;
import p289e.C7332c;
import p289e.C7367k;
import p289e.p291b.C5913a;
import p289e.p291b.C5919g;

/* compiled from: DisconnectOperation */
/* renamed from: com.polidea.a.b.c.g */
public class C7956g extends C7084k<Void> {
    /* renamed from: a */
    private final av f29644a;
    /* renamed from: b */
    private final C5562a f29645b;
    /* renamed from: c */
    private final String f29646c;
    /* renamed from: d */
    private final BluetoothManager f29647d;
    /* renamed from: e */
    private final C5986h f29648e;
    /* renamed from: f */
    private final C5583t f29649f;
    /* renamed from: g */
    private final C5570m f29650g;

    /* compiled from: DisconnectOperation */
    /* renamed from: com.polidea.a.b.c.g$a */
    private static class C7035a extends C5974e<BluetoothGatt> {

        /* compiled from: DisconnectOperation */
        /* renamed from: com.polidea.a.b.c.g$a$1 */
        class C79551 implements C7335a<BluetoothGatt> {
            /* renamed from: a */
            final /* synthetic */ av f29641a;
            /* renamed from: b */
            final /* synthetic */ BluetoothGatt f29642b;
            /* renamed from: c */
            final /* synthetic */ C5986h f29643c;

            /* compiled from: DisconnectOperation */
            /* renamed from: com.polidea.a.b.c.g$a$1$1 */
            class C70321 implements C5919g<C5554a, BluetoothGatt> {
                /* renamed from: a */
                final /* synthetic */ C79551 f24978a;

                C70321(C79551 c79551) {
                    this.f24978a = c79551;
                }

                /* renamed from: a */
                public BluetoothGatt m32888a(C5554a c5554a) {
                    return this.f24978a.f29642b;
                }
            }

            /* compiled from: DisconnectOperation */
            /* renamed from: com.polidea.a.b.c.g$a$1$2 */
            class C70332 implements C5919g<C5554a, Boolean> {
                /* renamed from: a */
                final /* synthetic */ C79551 f24979a;

                C70332(C79551 c79551) {
                    this.f24979a = c79551;
                }

                /* renamed from: a */
                public Boolean m32890a(C5554a c5554a) {
                    return Boolean.valueOf(c5554a == C5554a.DISCONNECTED ? true : null);
                }
            }

            /* compiled from: DisconnectOperation */
            /* renamed from: com.polidea.a.b.c.g$a$1$3 */
            class C70343 implements C5913a {
                /* renamed from: a */
                final /* synthetic */ C79551 f24980a;

                C70343(C79551 c79551) {
                    this.f24980a = c79551;
                }

                /* renamed from: a */
                public void mo4985a() {
                    this.f24980a.f29642b.disconnect();
                }
            }

            C79551(av avVar, BluetoothGatt bluetoothGatt, C5986h c5986h) {
                this.f29641a = avVar;
                this.f29642b = bluetoothGatt;
                this.f29643c = c5986h;
            }

            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m38654a((C7367k) obj);
            }

            /* renamed from: a */
            public void m38654a(C7367k<? super BluetoothGatt> c7367k) {
                this.f29641a.m23714c().m25039i(new C70332(this)).m25030e(new C70321(this)).m25015b((C7367k) c7367k);
                this.f29643c.mo5127a().mo6332a(new C70343(this));
            }
        }

        C7035a(BluetoothGatt bluetoothGatt, av avVar, C5986h c5986h) {
            super(new C79551(avVar, bluetoothGatt, c5986h));
        }
    }

    C7956g(av avVar, C5562a c5562a, String str, BluetoothManager bluetoothManager, C5986h c5986h, C5583t c5583t, C5570m c5570m) {
        this.f29644a = avVar;
        this.f29645b = c5562a;
        this.f29646c = str;
        this.f29647d = bluetoothManager;
        this.f29648e = c5986h;
        this.f29649f = c5583t;
        this.f29650g = c5570m;
    }

    /* renamed from: a */
    protected void mo6272a(final C7332c<Void> c7332c, final C5598i c5598i) {
        this.f29650g.mo4998a(C5554a.DISCONNECTING);
        Object a = this.f29645b.m23652a();
        if (a == null) {
            C5615p.m23870d("Disconnect operation has been executed but GATT instance was null - considering disconnected.", new Object[0]);
            m38660b(c7332c, c5598i);
            return;
        }
        (m38656a((BluetoothGatt) a) ? C5974e.m24987c(a) : m38657b(a)).m24999a(this.f29648e).m25006a(new C5982f<BluetoothGatt>(this) {
            /* renamed from: c */
            final /* synthetic */ C7956g f24977c;

            /* renamed from: a */
            public void m32885a(BluetoothGatt bluetoothGatt) {
                bluetoothGatt.close();
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                C5615p.m23866b(th, "Disconnect operation has been executed but finished with an error - considering disconnected.", new Object[0]);
                this.f24977c.m38660b(c7332c, c5598i);
            }

            public void L_() {
                this.f24977c.m38660b(c7332c, c5598i);
            }
        });
    }

    /* renamed from: b */
    void m38660b(C7332c<Void> c7332c, C5598i c5598i) {
        this.f29650g.mo4998a(C5554a.DISCONNECTED);
        c5598i.mo5017a();
        c7332c.L_();
    }

    /* renamed from: a */
    private boolean m38656a(BluetoothGatt bluetoothGatt) {
        return this.f29647d.getConnectionState(bluetoothGatt.getDevice(), 7) == null ? true : null;
    }

    /* renamed from: b */
    private C5974e<BluetoothGatt> m38657b(BluetoothGatt bluetoothGatt) {
        return new C7035a(bluetoothGatt, this.f29644a, this.f29648e).m24990a(this.f29649f.f18694a, this.f29649f.f18695b, C5974e.m24987c((Object) bluetoothGatt), this.f29649f.f18696c);
    }

    /* renamed from: a */
    protected C5548g mo6271a(DeadObjectException deadObjectException) {
        return new C6973f(deadObjectException, this.f29646c, -1);
    }
}

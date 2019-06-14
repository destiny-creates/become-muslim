package com.polidea.p254a.p256b.p258b;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattService;
import com.polidea.p254a.ai;
import com.polidea.p254a.p256b.p259c.C5579k;
import com.polidea.p254a.p256b.p259c.C5583t;
import com.polidea.p254a.p256b.p261e.C7062d;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p289e.C5974e;
import p289e.p291b.C5913a;
import p289e.p291b.C5914b;
import p289e.p291b.C5918f;
import p289e.p291b.C5919g;
import p289e.p301g.C5983a;
import p289e.p302h.C8149a;
import p289e.p302h.C8153c;

/* compiled from: ServiceDiscoveryManager */
/* renamed from: com.polidea.a.b.b.ax */
class ax {
    /* renamed from: a */
    private final C7062d f18675a;
    /* renamed from: b */
    private final BluetoothGatt f18676b;
    /* renamed from: c */
    private final C5579k f18677c;
    /* renamed from: d */
    private C5974e<ai> f18678d;
    /* renamed from: e */
    private C8153c<C5583t, C5583t> f18679e = C8149a.m39535b().m33752c();
    /* renamed from: f */
    private boolean f18680f = false;

    /* compiled from: ServiceDiscoveryManager */
    /* renamed from: com.polidea.a.b.b.ax$2 */
    class C70012 implements C5914b<Throwable> {
        /* renamed from: a */
        final /* synthetic */ ax f24933a;

        C70012(ax axVar) {
            this.f24933a = axVar;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m32830a((Throwable) obj);
        }

        /* renamed from: a */
        public void m32830a(Throwable th) {
            this.f24933a.m23723a();
        }
    }

    /* compiled from: ServiceDiscoveryManager */
    /* renamed from: com.polidea.a.b.b.ax$3 */
    class C70023 implements C5914b<ai> {
        /* renamed from: a */
        final /* synthetic */ ax f24934a;

        C70023(ax axVar) {
            this.f24934a = axVar;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m32832a((ai) obj);
        }

        /* renamed from: a */
        public void m32832a(ai aiVar) {
            this.f24934a.f18680f = true;
        }
    }

    /* compiled from: ServiceDiscoveryManager */
    /* renamed from: com.polidea.a.b.b.ax$4 */
    class C70034 implements C5919g<List<BluetoothGattService>, ai> {
        /* renamed from: a */
        final /* synthetic */ ax f24935a;

        C70034(ax axVar) {
            this.f24935a = axVar;
        }

        /* renamed from: a */
        public ai m32834a(List<BluetoothGattService> list) {
            return new ai(list);
        }
    }

    /* compiled from: ServiceDiscoveryManager */
    /* renamed from: com.polidea.a.b.b.ax$5 */
    class C70045 implements C5919g<List<BluetoothGattService>, Boolean> {
        /* renamed from: a */
        final /* synthetic */ ax f24936a;

        C70045(ax axVar) {
            this.f24936a = axVar;
        }

        /* renamed from: a */
        public Boolean m32836a(List<BluetoothGattService> list) {
            return Boolean.valueOf(list.size() > null ? true : null);
        }
    }

    /* compiled from: ServiceDiscoveryManager */
    /* renamed from: com.polidea.a.b.b.ax$6 */
    class C70056 implements C5918f<List<BluetoothGattService>> {
        /* renamed from: a */
        final /* synthetic */ ax f24937a;

        C70056(ax axVar) {
            this.f24937a = axVar;
        }

        public /* synthetic */ Object call() {
            return m32838a();
        }

        /* renamed from: a */
        public List<BluetoothGattService> m32838a() {
            return this.f24937a.f18676b.getServices();
        }
    }

    /* compiled from: ServiceDiscoveryManager */
    /* renamed from: com.polidea.a.b.b.ax$7 */
    class C70067 implements C5919g<C5583t, C5974e<ai>> {
        /* renamed from: a */
        final /* synthetic */ ax f24938a;

        C70067(ax axVar) {
            this.f24938a = axVar;
        }

        /* renamed from: a */
        public C5974e<ai> m32839a(C5583t c5583t) {
            return this.f24938a.f18675a.mo5016a(this.f24938a.f18677c.mo5008a(c5583t.f18694a, c5583t.f18695b));
        }
    }

    ax(C7062d c7062d, BluetoothGatt bluetoothGatt, C5579k c5579k) {
        this.f18675a = c7062d;
        this.f18676b = bluetoothGatt;
        this.f18677c = c5579k;
        m23723a();
    }

    /* renamed from: a */
    C5974e<ai> m23731a(final long j, final TimeUnit timeUnit) {
        if (this.f18680f) {
            return this.f18678d;
        }
        return this.f18678d.m24991a(new C5913a(this) {
            /* renamed from: c */
            final /* synthetic */ ax f24932c;

            /* renamed from: a */
            public void mo4985a() {
                this.f24932c.f18679e.mo5000a(new C5583t(j, timeUnit, C5983a.m25109b()));
            }
        });
    }

    /* renamed from: a */
    private void m23723a() {
        this.f18680f = false;
        this.f18678d = C5974e.m24978a(new C70056(this)).m25013b(new C70045(this)).m25030e(new C70034(this)).m25025d(m23725b().m25019c(m23728c())).m25011b(new C70023(this)).m24992a(new C70012(this)).m25008b(1);
    }

    /* renamed from: b */
    private C5974e<C5583t> m23725b() {
        return this.f18679e.m25029e(1);
    }

    /* renamed from: c */
    private C5919g<C5583t, C5974e<ai>> m23728c() {
        return new C70067(this);
    }
}

package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.DeadObjectException;
import com.polidea.p254a.af.C5554a;
import com.polidea.p254a.p255a.C5548g;
import com.polidea.p254a.p255a.C5549m;
import com.polidea.p254a.p255a.C6973f;
import com.polidea.p254a.p255a.C7929h;
import com.polidea.p254a.p256b.C7084k;
import com.polidea.p254a.p256b.p258b.C5562a;
import com.polidea.p254a.p256b.p258b.C5570m;
import com.polidea.p254a.p256b.p258b.av;
import com.polidea.p254a.p256b.p261e.C5598i;
import com.polidea.p254a.p256b.p262f.C5600b;
import p289e.C5974e;
import p289e.C5974e.C7337c;
import p289e.C5982f;
import p289e.C5989l;
import p289e.C7332c;
import p289e.C7332c.C5922a;
import p289e.p291b.C5913a;
import p289e.p291b.C5914b;
import p289e.p291b.C5917e;
import p289e.p291b.C5918f;
import p289e.p291b.C5919g;

/* compiled from: ConnectOperation */
/* renamed from: com.polidea.a.b.c.c */
public class C7953c extends C7084k<BluetoothGatt> {
    /* renamed from: a */
    private final BluetoothDevice f29627a;
    /* renamed from: b */
    private final C5600b f29628b;
    /* renamed from: c */
    private final av f29629c;
    /* renamed from: d */
    private final C5562a f29630d;
    /* renamed from: e */
    private final C5583t f29631e;
    /* renamed from: f */
    private final boolean f29632f;
    /* renamed from: g */
    private final C5570m f29633g;

    /* compiled from: ConnectOperation */
    /* renamed from: com.polidea.a.b.c.c$3 */
    class C70243 implements C5918f<BluetoothGatt> {
        /* renamed from: a */
        final /* synthetic */ C7953c f24967a;

        C70243(C7953c c7953c) {
            this.f24967a = c7953c;
        }

        public /* synthetic */ Object call() {
            return m32874a();
        }

        /* renamed from: a */
        public BluetoothGatt m32874a() {
            throw new C7929h(this.f24967a.f29630d.m23652a(), C5549m.f18595a);
        }
    }

    /* compiled from: ConnectOperation */
    /* renamed from: com.polidea.a.b.c.c$4 */
    class C70284 implements C5914b<C7332c<BluetoothGatt>> {
        /* renamed from: a */
        final /* synthetic */ C7953c f24972a;

        /* compiled from: ConnectOperation */
        /* renamed from: com.polidea.a.b.c.c$4$1 */
        class C70251 implements C5919g<C5554a, Boolean> {
            /* renamed from: a */
            final /* synthetic */ C70284 f24968a;

            C70251(C70284 c70284) {
                this.f24968a = c70284;
            }

            /* renamed from: a */
            public Boolean m32875a(C5554a c5554a) {
                return Boolean.valueOf(c5554a == C5554a.CONNECTED ? true : null);
            }
        }

        /* compiled from: ConnectOperation */
        /* renamed from: com.polidea.a.b.c.c$4$2 */
        class C70262 implements C5918f<BluetoothGatt> {
            /* renamed from: a */
            final /* synthetic */ C70284 f24969a;

            C70262(C70284 c70284) {
                this.f24969a = c70284;
            }

            public /* synthetic */ Object call() {
                return m32877a();
            }

            /* renamed from: a */
            public BluetoothGatt m32877a() {
                this.f24969a.f24972a.f29633g.mo4998a(C5554a.CONNECTED);
                return this.f24969a.f24972a.f29630d.m23652a();
            }
        }

        C70284(C7953c c7953c) {
            this.f24972a = c7953c;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m32879a((C7332c) obj);
        }

        /* renamed from: a */
        public void m32879a(C7332c<BluetoothGatt> c7332c) {
            final C5989l a = C5974e.m24978a(new C70262(this)).m25031e(this.f24972a.f29629c.m23714c().m25039i(new C70251(this))).m25033f(this.f24972a.f29629c.m23713b()).m25029e(1).m25006a((C5982f) c7332c);
            c7332c.mo6330a(new C5917e(this) {
                /* renamed from: b */
                final /* synthetic */ C70284 f24971b;

                /* renamed from: a */
                public void mo4973a() {
                    a.U_();
                }
            });
            this.f24972a.f29633g.mo4998a(C5554a.CONNECTING);
            this.f24972a.f29630d.m23653a(this.f24972a.f29628b.m23820a(this.f24972a.f29627a, this.f24972a.f29632f, this.f24972a.f29629c.m23711a()));
        }
    }

    /* compiled from: ConnectOperation */
    /* renamed from: com.polidea.a.b.c.c$2 */
    class C79522 implements C7337c<BluetoothGatt, BluetoothGatt> {
        /* renamed from: a */
        final /* synthetic */ C7953c f29626a;

        C79522(C7953c c7953c) {
            this.f29626a = c7953c;
        }

        /* renamed from: a */
        public C5974e<BluetoothGatt> m38636a(C5974e<BluetoothGatt> c5974e) {
            if (this.f29626a.f29632f) {
                return c5974e;
            }
            return c5974e.m24990a(this.f29626a.f29631e.f18694a, this.f29626a.f29631e.f18695b, this.f29626a.m38641c(), this.f29626a.f29631e.f18696c);
        }
    }

    C7953c(BluetoothDevice bluetoothDevice, C5600b c5600b, av avVar, C5562a c5562a, C5583t c5583t, boolean z, C5570m c5570m) {
        this.f29627a = bluetoothDevice;
        this.f29628b = c5600b;
        this.f29629c = avVar;
        this.f29630d = c5562a;
        this.f29631e = c5583t;
        this.f29632f = z;
        this.f29633g = c5570m;
    }

    /* renamed from: a */
    protected void mo6272a(C7332c<BluetoothGatt> c7332c, final C5598i c5598i) {
        C5913a c70231 = new C5913a(this) {
            /* renamed from: b */
            final /* synthetic */ C7953c f24966b;

            /* renamed from: a */
            public void mo4985a() {
                c5598i.mo5017a();
            }
        };
        c7332c.mo6331a(m38644d().m24998a(m38640b()).m25018c(c70231).m25010b(c70231).m25006a((C5982f) c7332c));
        if (this.f29632f != null) {
            c5598i.mo5017a();
        }
    }

    /* renamed from: b */
    private C7337c<BluetoothGatt, BluetoothGatt> m38640b() {
        return new C79522(this);
    }

    /* renamed from: c */
    private C5974e<BluetoothGatt> m38641c() {
        return C5974e.m24978a(new C70243(this));
    }

    /* renamed from: d */
    private C5974e<BluetoothGatt> m38644d() {
        return C5974e.m24970a(new C70284(this), C5922a.NONE);
    }

    /* renamed from: a */
    protected C5548g mo6271a(DeadObjectException deadObjectException) {
        return new C6973f(deadObjectException, this.f29627a.getAddress(), -1);
    }
}

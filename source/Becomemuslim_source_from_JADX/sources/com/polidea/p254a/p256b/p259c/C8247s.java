package com.polidea.p254a.p256b.p259c;

import android.bluetooth.BluetoothGatt;
import com.polidea.p254a.ai;
import com.polidea.p254a.p255a.C5549m;
import com.polidea.p254a.p255a.C7929h;
import com.polidea.p254a.p256b.C7998q;
import com.polidea.p254a.p256b.p258b.av;
import com.polidea.p254a.p256b.p262f.C5611y;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p289e.C5974e;
import p289e.C5986h;
import p289e.p291b.C5914b;
import p289e.p291b.C5918f;
import p289e.p291b.C5919g;

/* compiled from: ServiceDiscoveryOperation */
/* renamed from: com.polidea.a.b.c.s */
public class C8247s extends C7998q<ai> {
    /* renamed from: a */
    private final BluetoothGatt f32425a;
    /* renamed from: b */
    private final C5611y f32426b;

    /* compiled from: ServiceDiscoveryOperation */
    /* renamed from: com.polidea.a.b.c.s$1 */
    class C70381 implements C5914b<ai> {
        /* renamed from: a */
        final /* synthetic */ C8247s f24990a;

        C70381(C8247s c8247s) {
            this.f24990a = c8247s;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m32901a((ai) obj);
        }

        /* renamed from: a */
        public void m32901a(ai aiVar) {
            this.f24990a.f32426b.m23856a(aiVar, this.f24990a.f32425a.getDevice());
        }
    }

    C8247s(av avVar, BluetoothGatt bluetoothGatt, C5611y c5611y, C5583t c5583t) {
        super(bluetoothGatt, avVar, C5549m.f18596b, c5583t);
        this.f32425a = bluetoothGatt;
        this.f32426b = c5611y;
    }

    /* renamed from: a */
    protected C5974e<ai> mo6755a(av avVar) {
        return avVar.m23715d().m25011b(new C70381(this));
    }

    /* renamed from: a */
    protected boolean mo6756a(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.discoverServices();
    }

    /* renamed from: a */
    protected C5974e<ai> mo6760a(final BluetoothGatt bluetoothGatt, av avVar, final C5986h c5986h) {
        return C5974e.m24971a(new C5918f<C5974e<ai>>(this) {
            /* renamed from: c */
            final /* synthetic */ C8247s f24994c;

            /* compiled from: ServiceDiscoveryOperation */
            /* renamed from: com.polidea.a.b.c.s$2$1 */
            class C70391 implements C5919g<Long, C5974e<ai>> {
                /* renamed from: a */
                final /* synthetic */ C70402 f24991a;

                /* compiled from: ServiceDiscoveryOperation */
                /* renamed from: com.polidea.a.b.c.s$2$1$1 */
                class C55821 implements Callable<ai> {
                    /* renamed from: a */
                    final /* synthetic */ C70391 f18693a;

                    C55821(C70391 c70391) {
                        this.f18693a = c70391;
                    }

                    public /* synthetic */ Object call() {
                        return m23764a();
                    }

                    /* renamed from: a */
                    public ai m23764a() {
                        return new ai(bluetoothGatt.getServices());
                    }
                }

                C70391(C70402 c70402) {
                    this.f24991a = c70402;
                }

                /* renamed from: a */
                public C5974e<ai> m32903a(Long l) {
                    return C5974e.m24978a(new C55821(this));
                }
            }

            public /* synthetic */ Object call() {
                return m32905a();
            }

            /* renamed from: a */
            public C5974e<ai> m32905a() {
                if (bluetoothGatt.getServices().size() == 0) {
                    return C5974e.m24984b(new C7929h(bluetoothGatt, C5549m.f18596b));
                }
                return C5974e.m24969a(5, TimeUnit.SECONDS, c5986h).m25019c(new C70391(this));
            }
        });
    }
}

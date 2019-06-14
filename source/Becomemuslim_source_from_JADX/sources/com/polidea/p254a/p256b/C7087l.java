package com.polidea.p254a.p256b;

import android.bluetooth.BluetoothDevice;
import com.p071c.p072a.C4535a;
import com.polidea.p254a.C5629x;
import com.polidea.p254a.C5629x.C5628a;
import com.polidea.p254a.af;
import com.polidea.p254a.af.C5554a;
import com.polidea.p254a.ah;
import com.polidea.p254a.p255a.C6969b;
import com.polidea.p254a.p256b.p258b.C5572o;
import java.util.concurrent.atomic.AtomicBoolean;
import p289e.C5974e;
import p289e.p291b.C5913a;
import p289e.p291b.C5918f;

/* compiled from: RxBleDeviceImpl */
/* renamed from: com.polidea.a.b.l */
class C7087l implements ah {
    /* renamed from: a */
    private final BluetoothDevice f25069a;
    /* renamed from: b */
    private final C5572o f25070b;
    /* renamed from: c */
    private final C4535a<C5554a> f25071c;
    /* renamed from: d */
    private AtomicBoolean f25072d = new AtomicBoolean(false);

    C7087l(BluetoothDevice bluetoothDevice, C5572o c5572o, C4535a<C5554a> c4535a) {
        this.f25069a = bluetoothDevice;
        this.f25070b = c5572o;
        this.f25071c = c4535a;
    }

    /* renamed from: a */
    public C5554a mo5023a() {
        return (C5554a) this.f25071c.b();
    }

    /* renamed from: a */
    public C5974e<af> mo5024a(boolean z) {
        return m32998a(new C5628a().m23926a(z).m23928b(true).m23927a());
    }

    /* renamed from: a */
    public C5974e<af> m32998a(final C5629x c5629x) {
        return C5974e.m24971a(new C5918f<C5974e<af>>(this) {
            /* renamed from: b */
            final /* synthetic */ C7087l f25068b;

            /* compiled from: RxBleDeviceImpl */
            /* renamed from: com.polidea.a.b.l$1$1 */
            class C70851 implements C5913a {
                /* renamed from: a */
                final /* synthetic */ C70861 f25066a;

                C70851(C70861 c70861) {
                    this.f25066a = c70861;
                }

                /* renamed from: a */
                public void mo4985a() {
                    this.f25066a.f25068b.f25072d.set(false);
                }
            }

            public /* synthetic */ Object call() {
                return m32993a();
            }

            /* renamed from: a */
            public C5974e<af> m32993a() {
                if (this.f25068b.f25072d.compareAndSet(false, true)) {
                    return this.f25068b.f25070b.mo4996a(c5629x).m25018c(new C70851(this));
                }
                return C5974e.m24984b(new C6969b(this.f25068b.f25069a.getAddress()));
            }
        });
    }

    /* renamed from: b */
    public String mo5025b() {
        return this.f25069a.getName();
    }

    /* renamed from: c */
    public String mo5026c() {
        return this.f25069a.getAddress();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7087l)) {
            return null;
        }
        return this.f25069a.equals(((C7087l) obj).f25069a);
    }

    public int hashCode() {
        return this.f25069a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RxBleDeviceImpl{bluetoothDevice=");
        stringBuilder.append(this.f25069a.getName());
        stringBuilder.append('(');
        stringBuilder.append(this.f25069a.getAddress());
        stringBuilder.append(')');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

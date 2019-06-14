package com.polidea.p254a.p256b;

import com.polidea.p254a.ah;
import com.polidea.p254a.p256b.C5577b.C5561a;
import com.polidea.p254a.p256b.p257a.C5557b;
import java.util.Map;
import p000a.p003b.p004a.C0003a;

/* compiled from: RxBleDeviceProvider */
/* renamed from: com.polidea.a.b.n */
public class C5613n {
    /* renamed from: a */
    private final Map<String, C5577b> f18748a;
    /* renamed from: b */
    private final C0003a<C5561a> f18749b;

    public C5613n(C5557b c5557b, C0003a<C5561a> c0003a) {
        this.f18748a = c5557b;
        this.f18749b = c0003a;
    }

    /* renamed from: a */
    public ah m23857a(String str) {
        C5577b c5577b = (C5577b) this.f18748a.get(str);
        if (c5577b != null) {
            return c5577b.mo5036a();
        }
        synchronized (this.f18748a) {
            C5577b c5577b2 = (C5577b) this.f18748a.get(str);
            if (c5577b2 != null) {
                str = c5577b2.mo5036a();
                return str;
            }
            c5577b2 = ((C5561a) this.f18749b.a()).mo5029b(new C5584c(str)).mo5028a();
            ah a = c5577b2.mo5036a();
            this.f18748a.put(str, c5577b2);
            return a;
        }
    }
}

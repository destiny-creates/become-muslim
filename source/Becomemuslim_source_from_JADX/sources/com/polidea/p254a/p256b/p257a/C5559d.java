package com.polidea.p254a.p256b.p257a;

import com.polidea.p254a.p256b.C5577b;
import java.lang.ref.WeakReference;

/* compiled from: DeviceComponentWeakReference */
/* renamed from: com.polidea.a.b.a.d */
class C5559d extends WeakReference<C5577b> {

    /* compiled from: DeviceComponentWeakReference */
    /* renamed from: com.polidea.a.b.a.d$a */
    public interface C5558a {
        /* renamed from: a */
        C5559d mo4979a(C5577b c5577b);
    }

    C5559d(C5577b c5577b) {
        super(c5577b);
    }

    /* renamed from: a */
    boolean m23649a(Object obj) {
        C5577b c5577b = (C5577b) get();
        return ((obj instanceof C5577b) && c5577b != null && c5577b.mo5036a() == ((C5577b) obj).mo5036a()) ? true : null;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof WeakReference)) {
            return false;
        }
        C5577b c5577b = (C5577b) get();
        obj = ((WeakReference) obj).get();
        if (!(c5577b == null || !(obj instanceof C5577b) || c5577b.mo5036a().equals(((C5577b) obj).mo5036a()) == null)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return get() != null ? ((C5577b) get()).hashCode() : 0;
    }

    /* renamed from: a */
    public boolean m23648a() {
        return get() == null;
    }
}

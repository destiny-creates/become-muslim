package android.arch.lifecycle;

import android.arch.lifecycle.C0074c.C0072a;

public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {
    /* renamed from: a */
    private final C0071b[] f11811a;

    CompositeGeneratedAdaptersObserver(C0071b[] c0071bArr) {
        this.f11811a = c0071bArr;
    }

    /* renamed from: a */
    public void mo2620a(C0076e c0076e, C0072a c0072a) {
        C0080i c0080i = new C0080i();
        int i = 0;
        for (C0071b a : this.f11811a) {
            a.m177a(c0076e, c0072a, false, c0080i);
        }
        C0071b[] c0071bArr = this.f11811a;
        int length = c0071bArr.length;
        while (i < length) {
            c0071bArr[i].m177a(c0076e, c0072a, true, c0080i);
            i++;
        }
    }
}

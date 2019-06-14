package com.google.firebase.iid;

import android.os.Bundle;

/* renamed from: com.google.firebase.iid.p */
final class C6912p extends C5364n<Bundle> {
    C6912p(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* renamed from: a */
    final boolean mo4895a() {
        return false;
    }

    /* renamed from: a */
    final void mo4894a(Bundle bundle) {
        Object bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        m22775a(bundle2);
    }
}

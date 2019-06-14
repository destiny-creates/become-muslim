package com.google.firebase.iid;

import android.os.Bundle;

/* renamed from: com.google.firebase.iid.m */
final class C6911m extends C5364n<Void> {
    C6911m(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* renamed from: a */
    final boolean mo4895a() {
        return true;
    }

    /* renamed from: a */
    final void mo4894a(Bundle bundle) {
        if (bundle.getBoolean("ack", false) != null) {
            m22775a((Object) null);
        } else {
            m22774a(new C5365o(4, "Invalid response to one way request"));
        }
    }
}

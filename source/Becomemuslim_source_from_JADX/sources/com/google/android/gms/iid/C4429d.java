package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;

/* renamed from: com.google.android.gms.iid.d */
final class C4429d extends aj<Bundle> {
    C4429d(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* renamed from: a */
    final boolean mo2603a() {
        return false;
    }

    /* renamed from: a */
    final void mo2602a(Bundle bundle) {
        Object bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(bundle2);
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 16) + String.valueOf(valueOf2).length());
            stringBuilder.append("Finishing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.f7820b.m8785a(bundle2);
    }
}

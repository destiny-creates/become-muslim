package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(18)
public class kj extends ki {
    /* renamed from: a */
    public boolean mo6877a(View view) {
        if (!super.mo6877a(view)) {
            if (view.getWindowId() == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public final int mo6878c() {
        return 14;
    }
}

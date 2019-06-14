package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* renamed from: com.google.android.gms.ads.mediation.b */
public interface C2683b {

    /* renamed from: com.google.android.gms.ads.mediation.b$a */
    public static class C2682a {
        /* renamed from: a */
        private int f6925a;

        /* renamed from: a */
        public final Bundle m7580a() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.f6925a);
            return bundle;
        }

        /* renamed from: a */
        public final C2682a m7581a(int i) {
            this.f6925a = 1;
            return this;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}

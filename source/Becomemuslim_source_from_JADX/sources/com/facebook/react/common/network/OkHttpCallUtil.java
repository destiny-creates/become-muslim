package com.facebook.react.common.network;

import expolib_v1.p321a.C6216e;
import expolib_v1.p321a.C7490w;

public class OkHttpCallUtil {
    private OkHttpCallUtil() {
    }

    public static void cancelTag(C7490w c7490w, Object obj) {
        for (C6216e c6216e : c7490w.t().b()) {
            if (obj.equals(c6216e.a().e())) {
                c6216e.c();
                return;
            }
        }
        for (C6216e c6216e2 : c7490w.t().c()) {
            if (obj.equals(c6216e2.a().e())) {
                c6216e2.c();
                return;
            }
        }
    }
}

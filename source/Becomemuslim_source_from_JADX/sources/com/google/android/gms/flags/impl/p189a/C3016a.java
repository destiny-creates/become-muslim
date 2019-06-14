package com.google.android.gms.flags.impl.p189a;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.a.a */
public class C3016a {
    /* renamed from: a */
    public static <T> T m8866a(Callable<T> callable) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(ThreadPolicy.LAX);
            T call = callable.call();
            return call;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import java.util.concurrent.Callable;

@cm
public final class lz {
    /* renamed from: a */
    public static <T> T m19845a(Context context, Callable<T> callable) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        T call;
        try {
            StrictMode.setThreadPolicy(new Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            call = callable.call();
            return call;
        } catch (Throwable th) {
            call = th;
            mt.m19919b("Unexpected exception.", call);
            cg.m30673a(context).mo4231a(call, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* renamed from: a */
    public static <T> T m19846a(Callable<T> callable) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            T call = callable.call();
            return call;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}

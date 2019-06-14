package com.bugsnag.android;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: StrictModeHandler */
class ao {
    @SuppressLint({"UseSparseArrays"})
    /* renamed from: a */
    private static final Map<Integer, String> f3026a = new HashMap();

    ao() {
    }

    static {
        f3026a.put(Integer.valueOf(1), "DiskWrite");
        f3026a.put(Integer.valueOf(2), "DiskRead");
        f3026a.put(Integer.valueOf(4), "NetworkOperation");
        f3026a.put(Integer.valueOf(8), "CustomSlowCall");
        f3026a.put(Integer.valueOf(16), "ResourceMismatch");
        f3026a.put(Integer.valueOf(256), "CursorLeak");
        f3026a.put(Integer.valueOf(512), "CloseableLeak");
        f3026a.put(Integer.valueOf(1024), "ActivityLeak");
        f3026a.put(Integer.valueOf(2048), "InstanceLeak");
        f3026a.put(Integer.valueOf(4096), "RegistrationLeak");
        f3026a.put(Integer.valueOf(Utility.DEFAULT_STREAM_BUFFER_SIZE), "FileUriLeak");
        f3026a.put(Integer.valueOf(16384), "CleartextNetwork");
    }

    /* renamed from: a */
    boolean m3762a(Throwable th) {
        return m3760b(th).getClass().getName().toLowerCase(Locale.US).startsWith("android.os.strictmode");
    }

    /* renamed from: a */
    String m3761a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        int lastIndexOf = str.lastIndexOf("violation=");
        if (lastIndexOf != -1) {
            str = str.substring(lastIndexOf).replace("violation=", "");
            if (TextUtils.isDigitsOnly(str)) {
                return (String) f3026a.get(Integer.valueOf(str));
            }
        }
        return null;
    }

    /* renamed from: b */
    private Throwable m3760b(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null) {
            return th;
        }
        return m3760b(cause);
    }
}

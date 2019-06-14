package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.io.File;

/* renamed from: com.google.android.gms.common.util.r */
public class C2907r {
    @Deprecated
    /* renamed from: a */
    public static void m8472a(Context context, Editor editor, String str) {
        File file = new File(context.getApplicationInfo().dataDir, "shared_prefs");
        context = file.getParentFile();
        if (context != null) {
            context.setExecutable(true, false);
        }
        file.setExecutable(true, false);
        editor.commit();
        new File(file, String.valueOf(str).concat(".xml")).setReadable(true, false);
    }
}

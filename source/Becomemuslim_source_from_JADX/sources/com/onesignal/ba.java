package com.onesignal;

import java.io.File;

/* compiled from: RootToolsInternalMethods */
class ba {
    /* renamed from: a */
    static boolean m23343a() {
        for (String str : new String[]{"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"}) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("su");
            if (new File(stringBuilder.toString()).exists()) {
                return true;
            }
        }
        return false;
    }
}

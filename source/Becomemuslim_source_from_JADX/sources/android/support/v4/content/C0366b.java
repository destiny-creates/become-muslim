package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;

/* compiled from: ContextCompat */
/* renamed from: android.support.v4.content.b */
public class C0366b {
    /* renamed from: a */
    private static final Object f963a = new Object();
    /* renamed from: b */
    private static TypedValue f964b;

    /* renamed from: a */
    public static boolean m1106a(Context context, Intent[] intentArr, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
        } else {
            context.startActivities(intentArr);
        }
        return true;
    }

    /* renamed from: a */
    public static void m1105a(Context context, Intent intent, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            context.startActivity(intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    /* renamed from: a */
    public static File[] m1108a(Context context, String str) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(str);
        }
        return new File[]{context.getExternalFilesDir(str)};
    }

    /* renamed from: a */
    public static File[] m1107a(Context context) {
        if (VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    /* renamed from: a */
    public static Drawable m1103a(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f963a) {
            if (f964b == null) {
                f964b = new TypedValue();
            }
            context.getResources().getValue(i, f964b, true);
            i = f964b.resourceId;
        }
        return context.getResources().getDrawable(i);
    }

    /* renamed from: b */
    public static ColorStateList m1110b(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        return context.getResources().getColorStateList(i);
    }

    /* renamed from: c */
    public static int m1112c(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }

    /* renamed from: b */
    public static int m1109b(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    /* renamed from: b */
    public static File m1111b(Context context) {
        if (VERSION.SDK_INT >= 21) {
            return context.getNoBackupFilesDir();
        }
        return C0366b.m1104a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static synchronized java.io.File m1104a(java.io.File r4) {
        /*
        r0 = android.support.v4.content.C0366b.class;
        monitor-enter(r0);
        r1 = r4.exists();	 Catch:{ all -> 0x0036 }
        if (r1 != 0) goto L_0x0034;
    L_0x0009:
        r1 = r4.mkdirs();	 Catch:{ all -> 0x0036 }
        if (r1 != 0) goto L_0x0034;
    L_0x000f:
        r1 = r4.exists();	 Catch:{ all -> 0x0036 }
        if (r1 == 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r0);
        return r4;
    L_0x0017:
        r1 = "ContextCompat";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0036 }
        r2.<init>();	 Catch:{ all -> 0x0036 }
        r3 = "Unable to create files subdir ";
        r2.append(r3);	 Catch:{ all -> 0x0036 }
        r4 = r4.getPath();	 Catch:{ all -> 0x0036 }
        r2.append(r4);	 Catch:{ all -> 0x0036 }
        r4 = r2.toString();	 Catch:{ all -> 0x0036 }
        android.util.Log.w(r1, r4);	 Catch:{ all -> 0x0036 }
        r4 = 0;
        monitor-exit(r0);
        return r4;
    L_0x0034:
        monitor-exit(r0);
        return r4;
    L_0x0036:
        r4 = move-exception;
        monitor-exit(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.b.a(java.io.File):java.io.File");
    }

    /* renamed from: c */
    public static boolean m1113c(Context context) {
        return VERSION.SDK_INT >= 24 ? context.isDeviceProtectedStorage() : null;
    }
}

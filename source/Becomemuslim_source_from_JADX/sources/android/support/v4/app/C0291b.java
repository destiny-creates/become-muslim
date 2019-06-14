package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build.VERSION;

/* compiled from: AppOpsManagerCompat */
/* renamed from: android.support.v4.app.b */
public final class C0291b {
    /* renamed from: a */
    public static String m865a(String str) {
        return VERSION.SDK_INT >= 23 ? AppOpsManager.permissionToOp(str) : null;
    }

    /* renamed from: a */
    public static int m864a(Context context, String str, String str2) {
        return VERSION.SDK_INT >= 23 ? ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2) : 1;
    }
}

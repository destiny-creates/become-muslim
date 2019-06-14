package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.support.v4.app.C3178i;
import com.google.android.gms.common.internal.C2855h;

public final class GooglePlayServicesUtil extends C2832i {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        if (C2832i.isPlayServicesPossiblyUpdating(activity, i)) {
            i = 18;
        }
        return C4361e.m14332a().m14338a(activity, i, i2, onCancelListener);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, C3178i c3178i, int i2, OnCancelListener onCancelListener) {
        if (C2832i.isPlayServicesPossiblyUpdating(activity, i)) {
            i = 18;
        }
        C4361e a = C4361e.m14332a();
        if (c3178i == null) {
            return a.m14350b(activity, i, i2, onCancelListener);
        }
        Dialog a2 = C4361e.m14331a((Context) activity, i, C2855h.m8339a(c3178i, C4361e.m14332a().mo2457a((Context) activity, i, "d"), i2), onCancelListener);
        if (a2 == 0) {
            return false;
        }
        C4361e.m14333a(activity, a2, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        C4361e a = C4361e.m14332a();
        if (!C2832i.isPlayServicesPossiblyUpdating(context, i)) {
            if (!C2832i.isPlayStorePossiblyUpdating(context, i)) {
                a.m14343a(context, i);
                return;
            }
        }
        a.m14349b(context);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return C2832i.getErrorString(i);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return C2832i.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context, int i) {
        return C2832i.isGooglePlayServicesAvailable(context, i);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return C2832i.getErrorPendingIntent(i, context, i2);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return C2832i.isUserRecoverableError(i);
    }

    public static Resources getRemoteResource(Context context) {
        return C2832i.getRemoteResource(context);
    }

    public static Context getRemoteContext(Context context) {
        return C2832i.getRemoteContext(context);
    }
}

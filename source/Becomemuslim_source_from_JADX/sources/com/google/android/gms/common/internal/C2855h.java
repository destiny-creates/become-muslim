package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.C3178i;
import android.util.Log;
import com.google.android.gms.common.api.internal.C2801g;

/* renamed from: com.google.android.gms.common.internal.h */
public abstract class C2855h implements OnClickListener {
    /* renamed from: a */
    protected abstract void mo2461a();

    /* renamed from: a */
    public static C2855h m8338a(Activity activity, Intent intent, int i) {
        return new ae(intent, activity, i);
    }

    /* renamed from: a */
    public static C2855h m8339a(C3178i c3178i, Intent intent, int i) {
        return new af(intent, c3178i, i);
    }

    /* renamed from: a */
    public static C2855h m8340a(C2801g c2801g, Intent intent, int i) {
        return new ag(intent, c2801g, i);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo2461a();
        } catch (int i2) {
            Log.e("DialogRedirect", "Failed to start resolution intent", i2);
        } finally {
            dialogInterface.dismiss();
        }
    }
}

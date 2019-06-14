package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.p015c.C0104b;
import android.support.p015c.C0108d;
import android.support.p015c.C0109e;
import com.facebook.internal.NativeProtocol;
import java.util.List;

@cm
public final class atn implements age {
    /* renamed from: a */
    private C0109e f23791a;
    /* renamed from: b */
    private C0104b f23792b;
    /* renamed from: c */
    private C0108d f23793c;
    /* renamed from: d */
    private ato f23794d;

    /* renamed from: a */
    public static boolean m30191a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (!(queryIntentActivities == null || resolveActivity == null)) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                if (resolveActivity.activityInfo.name.equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(agc.m18398a(context));
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public final void mo3965a() {
        this.f23792b = null;
        this.f23791a = null;
        if (this.f23794d != null) {
            this.f23794d.mo4305b();
        }
    }

    /* renamed from: a */
    public final void m30193a(Activity activity) {
        if (this.f23793c != null) {
            activity.unbindService(this.f23793c);
            this.f23792b = null;
            this.f23791a = null;
            this.f23793c = null;
        }
    }

    /* renamed from: a */
    public final void mo3966a(C0104b c0104b) {
        this.f23792b = c0104b;
        this.f23792b.a(0);
        if (this.f23794d != null) {
            this.f23794d.mo4304a();
        }
    }

    /* renamed from: a */
    public final void m30195a(ato ato) {
        this.f23794d = ato;
    }

    /* renamed from: a */
    public final boolean m30196a(Uri uri, Bundle bundle, List<Bundle> list) {
        if (this.f23792b == null) {
            return false;
        }
        if (this.f23792b == null) {
            this.f23791a = null;
        } else if (this.f23791a == null) {
            this.f23791a = this.f23792b.a(null);
        }
        C0109e c0109e = this.f23791a;
        return c0109e == null ? false : c0109e.a(uri, null, null);
    }

    /* renamed from: b */
    public final void m30197b(Activity activity) {
        if (this.f23792b == null) {
            String a = agc.m18398a(activity);
            if (a != null) {
                this.f23793c = new agd(this);
                C0104b.a(activity, a, this.f23793c);
            }
        }
    }
}

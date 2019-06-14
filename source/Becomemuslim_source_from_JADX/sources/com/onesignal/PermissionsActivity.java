package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.onesignal.C5440a.C5437a;
import com.onesignal.C5503e.C5499a;

public class PermissionsActivity extends Activity {
    /* renamed from: a */
    static boolean f18250a;
    /* renamed from: b */
    static boolean f18251b;
    /* renamed from: c */
    private static C5437a f18252c;

    /* renamed from: com.onesignal.PermissionsActivity$1 */
    static class C69471 implements C5437a {
        C69471() {
        }

        /* renamed from: a */
        public void mo4929a(Activity activity) {
            if (!activity.getClass().equals(PermissionsActivity.class)) {
                Intent intent = new Intent(activity, PermissionsActivity.class);
                intent.setFlags(131072);
                activity.startActivity(intent);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        am.m23152a((Context) this);
        if (bundle == null || bundle.getBoolean("android:hasCurrentPermissionsRequest", false) == null) {
            m23047b();
        } else {
            f18250a = true;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (am.f18402c != null) {
            m23047b();
        }
    }

    /* renamed from: b */
    private void m23047b() {
        if (VERSION.SDK_INT < 23) {
            finish();
            return;
        }
        if (!f18250a) {
            f18250a = true;
            C5499a.m23436a(this, new String[]{C5526p.f18555a}, 2);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        f18251b = 1;
        f18250a = false;
        if (i == 2) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                C5526p.m23516b();
            } else {
                C5526p.m23511a();
            }
        }
        C5440a.m23061b(f18252c);
        finish();
    }

    /* renamed from: a */
    static void m23046a() {
        if (!f18250a) {
            if (!f18251b) {
                f18252c = new C69471();
                C5440a.m23058a(f18252c);
            }
        }
    }
}

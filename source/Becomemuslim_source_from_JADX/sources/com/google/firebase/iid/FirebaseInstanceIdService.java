package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

@Deprecated
public class FirebaseInstanceIdService extends ad {
    @Deprecated
    /* renamed from: a */
    public void m32381a() {
    }

    /* renamed from: a */
    protected final Intent mo4882a(Intent intent) {
        return (Intent) C5370y.m22798a().f18133a.poll();
    }

    /* renamed from: b */
    public final void mo4883b(Intent intent) {
        if ("com.google.firebase.iid.TOKEN_REFRESH".equals(intent.getAction())) {
            m32381a();
            return;
        }
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                intent = String.valueOf(intent.getExtras());
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(stringExtra).length() + 21) + String.valueOf(intent).length());
                stringBuilder.append("Received command: ");
                stringBuilder.append(stringExtra);
                stringBuilder.append(" - ");
                stringBuilder.append(intent);
                Log.d("FirebaseInstanceId", stringBuilder.toString());
            }
            if ("RST".equals(stringExtra) == null) {
                if ("RST_FULL".equals(stringExtra) == null) {
                    if ("SYNC".equals(stringExtra) != null) {
                        FirebaseInstanceId.m22665a().m22694m();
                    }
                }
            }
            FirebaseInstanceId.m22665a().m22690i();
        }
    }
}

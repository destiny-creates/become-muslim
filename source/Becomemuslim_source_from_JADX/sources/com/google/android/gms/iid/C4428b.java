package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

@Deprecated
/* renamed from: com.google.android.gms.iid.b */
public class C4428b extends C3069o {
    /* renamed from: a */
    public void m14714a() {
    }

    public void handleIntent(Intent intent) {
        if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            Bundle bundle = null;
            String stringExtra = intent.getStringExtra("subtype");
            if (stringExtra != null) {
                bundle = new Bundle();
                bundle.putString("subtype", stringExtra);
            }
            C3060a a = C3060a.m8931a(this, bundle);
            intent = intent.getStringExtra("CMD");
            if (Log.isLoggable("InstanceID", 3)) {
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(stringExtra).length() + 34) + String.valueOf(intent).length());
                stringBuilder.append("Service command. subtype:");
                stringBuilder.append(stringExtra);
                stringBuilder.append(" command:");
                stringBuilder.append(intent);
                Log.d("InstanceID", stringBuilder.toString());
            }
            if ("RST".equals(intent)) {
                a.m8940b();
                m14714a();
                return;
            }
            if ("RST_FULL".equals(intent)) {
                if (C3060a.m8935c().m8981a() == null) {
                    C3060a.m8935c().m8983b();
                    m14714a();
                }
            } else if ("SYNC".equals(intent) != null) {
                intent = C3060a.m8935c();
                String valueOf = String.valueOf(stringExtra);
                String valueOf2 = String.valueOf("|T|");
                intent.m8984b(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                valueOf = String.valueOf(stringExtra);
                stringExtra = String.valueOf("|T-timestamp|");
                intent.m8984b(stringExtra.length() != 0 ? valueOf.concat(stringExtra) : new String(valueOf));
                m14714a();
            }
        }
    }

    /* renamed from: a */
    static void m14713a(Context context, C3067m c3067m) {
        c3067m.m8983b();
        c3067m = new Intent("com.google.android.gms.iid.InstanceID");
        c3067m.putExtra("CMD", "RST");
        c3067m.setClassName(context, "com.google.android.gms.gcm.GcmReceiver");
        context.sendBroadcast(c3067m);
    }
}

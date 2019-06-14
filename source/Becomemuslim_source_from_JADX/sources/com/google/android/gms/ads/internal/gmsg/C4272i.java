package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.hq;
import com.google.android.gms.internal.ads.jn;
import java.util.Map;

@cm
/* renamed from: com.google.android.gms.ads.internal.gmsg.i */
public final class C4272i implements ae<Object> {
    /* renamed from: a */
    private final C2650j f11302a;

    public C4272i(C2650j c2650j) {
        this.f11302a = c2650j;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("grant".equals(str)) {
            hq hqVar = null;
            try {
                int parseInt = Integer.parseInt((String) map.get("amount"));
                String str2 = (String) map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    hqVar = new hq(str2, parseInt);
                }
            } catch (Throwable e) {
                jn.c("Unable to parse reward amount.", e);
            }
            this.f11302a.mo3588a(hqVar);
        } else if ("video_start".equals(str)) {
            this.f11302a.i_();
        } else {
            if ("video_complete".equals(str)) {
                if (((Boolean) aph.f().a(asp.ax)).booleanValue()) {
                    if (((Boolean) aph.f().a(asp.ax)).booleanValue()) {
                        this.f11302a.j_();
                    }
                }
            }
        }
    }
}

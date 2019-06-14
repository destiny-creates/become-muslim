package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.qo;
import com.raizlabs.android.dbflow.config.C5679e;
import java.util.Map;

@cm
/* renamed from: com.google.android.gms.ads.internal.gmsg.n */
public final class C4274n implements ae<qo> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        qo qoVar = (qo) obj;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        String str2;
        if ("tick".equals(str)) {
            str = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            str2 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str)) {
                jn.e("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str2)) {
                jn.e("No timestamp given for CSI tick.");
            } else {
                try {
                    long b = ax.m7471l().mo2483b() + (Long.parseLong(str2) - ax.m7471l().mo2482a());
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    qoVar.j().a(str, str3, b);
                } catch (Throwable e) {
                    jn.c("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            str2 = (String) map.get("value");
            if (TextUtils.isEmpty(str2)) {
                jn.e("No value given for CSI experiment.");
                return;
            }
            r9 = qoVar.j().a();
            if (r9 == null) {
                jn.e("No ticker for WebView, dropping experiment ID.");
            } else {
                r9.a(C5679e.f18978a, str2);
            }
        } else {
            if ("extra".equals(str)) {
                str = (String) map.get("name");
                str2 = (String) map.get("value");
                if (TextUtils.isEmpty(str2)) {
                    jn.e("No value given for CSI extra.");
                } else if (TextUtils.isEmpty(str)) {
                    jn.e("No name given for CSI extra.");
                } else {
                    r9 = qoVar.j().a();
                    if (r9 == null) {
                        jn.e("No ticker for WebView, dropping extra parameter.");
                        return;
                    }
                    r9.a(str, str2);
                }
            }
        }
    }
}

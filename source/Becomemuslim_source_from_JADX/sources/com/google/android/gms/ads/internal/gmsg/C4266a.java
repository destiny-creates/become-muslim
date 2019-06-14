package com.google.android.gms.ads.internal.gmsg;

import android.os.Bundle;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@cm
/* renamed from: com.google.android.gms.ads.internal.gmsg.a */
public final class C4266a implements ae<Object> {
    /* renamed from: a */
    private final C2651k f11281a;

    public C4266a(C2651k c2651k) {
        this.f11281a = c2651k;
    }

    /* renamed from: a */
    private static Bundle m13901a(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            Bundle bundle = new Bundle();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                Object obj = jSONObject.get(str2);
                if (obj != null) {
                    if (obj instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str2, ((Double) obj).doubleValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str2, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str2, ((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        bundle.putString(str2, (String) obj);
                    } else {
                        String str3 = "Unsupported type for key:";
                        str2 = String.valueOf(str2);
                        jn.e(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                    }
                }
            }
            return bundle;
        } catch (Throwable e) {
            jn.b("Failed to convert ad metadata to JSON.", e);
            return null;
        }
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.f11281a != null) {
            String str = (String) map.get("name");
            if (str == null) {
                jn.d("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle a = C4266a.m13901a((String) map.get("info"));
            if (a == null) {
                jn.c("Failed to convert ad metadata to Bundle.");
            } else {
                this.f11281a.mo3251a(str, a);
            }
        }
    }
}

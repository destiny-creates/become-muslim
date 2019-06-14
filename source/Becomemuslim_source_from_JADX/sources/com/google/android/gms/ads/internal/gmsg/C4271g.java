package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@cm
/* renamed from: com.google.android.gms.ads.internal.gmsg.g */
public final class C4271g implements ae<Object> {
    /* renamed from: a */
    private final Object f11300a = new Object();
    /* renamed from: b */
    private final Map<String, C2649h> f11301b = new HashMap();

    /* renamed from: a */
    public final void m13908a(String str, C2649h c2649h) {
        synchronized (this.f11300a) {
            this.f11301b.put(str, c2649h);
        }
    }

    public final void zza(Object obj, Map<String, String> map) {
        Object obj2;
        String str = (String) map.get("id");
        String str2 = (String) map.get("fail");
        Object obj3 = (String) map.get("fail_reason");
        String str3 = (String) map.get("fail_stack");
        String str4 = (String) map.get("result");
        if (TextUtils.isEmpty(str3)) {
            obj3 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str3)) {
            obj2 = "";
        } else {
            String str5 = ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
            str3 = String.valueOf(str3);
            obj2 = str3.length() != 0 ? str5.concat(str3) : new String(str5);
        }
        synchronized (this.f11300a) {
            C2649h c2649h = (C2649h) this.f11301b.remove(str);
            if (c2649h == null) {
                str4 = "Received result for unexpected method invocation: ";
                str = String.valueOf(str);
                jn.e(str.length() != 0 ? str4.concat(str) : new String(str4));
                return;
            } else if (!TextUtils.isEmpty(str2)) {
                str = String.valueOf(obj3);
                str4 = String.valueOf(obj2);
                c2649h.m7531a(str4.length() != 0 ? str.concat(str4) : new String(str));
                return;
            } else if (str4 == null) {
                c2649h.m7532a(null);
                return;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    if (jn.a()) {
                        str4 = "Result GMSG: ";
                        str2 = String.valueOf(jSONObject.toString(2));
                        jn.a(str2.length() != 0 ? str4.concat(str2) : new String(str4));
                    }
                    c2649h.m7532a(jSONObject);
                } catch (JSONException e) {
                    c2649h.m7531a(e.getMessage());
                }
            }
        }
    }
}

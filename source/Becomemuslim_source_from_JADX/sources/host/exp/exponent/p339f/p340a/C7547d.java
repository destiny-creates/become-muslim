package host.exp.exponent.p339f.p340a;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import host.exp.exponent.C6301d;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p344h.C6373d;
import org.json.JSONObject;

/* compiled from: PermissionsKernelService */
/* renamed from: host.exp.exponent.f.a.d */
public class C7547d extends C6324a {
    /* renamed from: a */
    C6373d f26148a;

    /* renamed from: a */
    public void mo5404a(C6330b c6330b) {
    }

    /* renamed from: b */
    public void mo5405b(C6330b c6330b) {
    }

    public C7547d(Context context, C6373d c6373d) {
        super(context);
        this.f26148a = c6373d;
    }

    /* renamed from: a */
    public void m34176a(String str, C6330b c6330b) {
        try {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            JSONObject e = this.f26148a.m26165e(c6330b.m26048a());
            if (e == null) {
                e = new JSONObject();
            }
            if (e.has(NativeProtocol.RESULT_ARGS_PERMISSIONS)) {
                jSONObject = e.getJSONObject(NativeProtocol.RESULT_ARGS_PERMISSIONS);
            } else {
                jSONObject = new JSONObject();
            }
            if (jSONObject.has(str)) {
                jSONObject2 = jSONObject.getJSONObject(str);
            } else {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "granted");
            jSONObject.put(str, jSONObject2);
            e.put(NativeProtocol.RESULT_ARGS_PERMISSIONS, jSONObject);
            this.f26148a.m26158b(c6330b.m26048a(), e);
        } catch (String str2) {
            str2.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m34178b(String str, C6330b c6330b) {
        try {
            JSONObject e = this.f26148a.m26165e(c6330b.m26048a());
            if (e != null && e.has(NativeProtocol.RESULT_ARGS_PERMISSIONS)) {
                JSONObject jSONObject = e.getJSONObject(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                if (jSONObject.has(str)) {
                    jSONObject.remove(str);
                    e.put(NativeProtocol.RESULT_ARGS_PERMISSIONS, jSONObject);
                    this.f26148a.m26158b(c6330b.m26048a(), e);
                }
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
    }

    /* renamed from: c */
    public boolean m34179c(String str, C6330b c6330b) {
        if (C6301d.m26001a()) {
            return true;
        }
        c6330b = this.f26148a.m26165e(c6330b.m26048a());
        boolean z = false;
        if (c6330b == null) {
            return false;
        }
        try {
            if (c6330b.has(NativeProtocol.RESULT_ARGS_PERMISSIONS)) {
                c6330b = c6330b.getJSONObject(NativeProtocol.RESULT_ARGS_PERMISSIONS);
                if (c6330b.has(str)) {
                    str = c6330b.getJSONObject(str);
                    if (!(str.has(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == null || str.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS).equals("granted") == null)) {
                        z = true;
                    }
                    return z;
                }
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
        return false;
    }
}

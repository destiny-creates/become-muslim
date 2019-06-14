package versioned.host.exp.exponent.modules.universal;

import android.content.Context;
import expo.modules.constants.ConstantsService;
import expo.p307b.p310c.C6023a;
import host.exp.exponent.C6301d;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C7549c;
import host.exp.exponent.p344h.C6373d;
import java.util.HashMap;
import java.util.Map;
import javax.inject.C6562a;
import org.json.JSONObject;

public class ConstantsBinding extends ConstantsService implements C6023a {
    private final Map<String, Object> mExperienceProperties;
    @C6562a
    C6373d mExponentSharedPreferences;
    private JSONObject mManifest;

    private static int convertPixelsToDp(float f, Context context) {
        return (int) (f / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    public ConstantsBinding(Context context, Map<String, Object> map, JSONObject jSONObject) {
        super(context);
        C6294a.m25957a().m25961b(ConstantsBinding.class, this);
        this.mManifest = jSONObject;
        this.mExperienceProperties = map;
        if (jSONObject.has("androidStatusBarColor") == null) {
            context = this.mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (context > null) {
                this.mStatusBarHeight = convertPixelsToDp((float) this.mContext.getResources().getDimensionPixelSize(context), this.mContext);
                return;
            }
            return;
        }
        this.mStatusBarHeight = null;
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> constants = super.getConstants();
        constants.put("expoVersion", C7549c.m34188a().m34193b());
        constants.put("installationId", this.mExponentSharedPreferences.m26164e());
        constants.put("manifest", this.mManifest.toString());
        if (this.mExperienceProperties != null) {
            constants.put("appOwnership", getAppOwnership());
            constants.putAll(this.mExperienceProperties);
        }
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap2.put("versionCode", Integer.valueOf(C6301d.f20506l));
        hashMap.put("android", hashMap2);
        constants.put("platform", hashMap);
        constants.put("isDetached", Boolean.valueOf(C6301d.m26001a()));
        return constants;
    }

    public java.lang.String getAppId() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mManifest;	 Catch:{ JSONException -> 0x0009 }
        r1 = "id";	 Catch:{ JSONException -> 0x0009 }
        r0 = r0.getString(r1);	 Catch:{ JSONException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.universal.ConstantsBinding.getAppId():java.lang.String");
    }

    public String getAppOwnership() {
        if (!this.mExperienceProperties.containsKey("experienceUrl")) {
            return "expo";
        }
        String str = (String) this.mExperienceProperties.get("experienceUrl");
        if (C6301d.f20496b == null) {
            return "expo";
        }
        return str.equals(C6301d.f20496b) ? "standalone" : "guest";
    }
}

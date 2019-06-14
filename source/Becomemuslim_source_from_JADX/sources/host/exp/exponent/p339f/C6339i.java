package host.exp.exponent.p339f;

import android.net.Uri;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.MessengerShareContentUtility;
import expolib_v1.p321a.C6246z.C6245a;
import host.exp.exponent.C6301d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExponentUrls */
/* renamed from: host.exp.exponent.f.i */
public class C6339i {
    /* renamed from: a */
    private static final List<String> f20584a = new ArrayList();

    static {
        f20584a.add("exp.host");
        f20584a.add("exponentjs.com");
    }

    /* renamed from: c */
    private static boolean m26064c(String str) {
        for (int i = 0; i < f20584a.size(); i++) {
            if (((String) f20584a.get(i)).equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m26062a(String str) {
        if (str.startsWith(UriUtil.HTTP_SCHEME)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (!C6339i.m26064c(parse.getHost())) {
            if (str.startsWith("exps") == null) {
                str = null;
                return parse.buildUpon().scheme(str == null ? UriUtil.HTTPS_SCHEME : UriUtil.HTTP_SCHEME).build().toString();
            }
        }
        str = true;
        if (str == null) {
        }
        return parse.buildUpon().scheme(str == null ? UriUtil.HTTPS_SCHEME : UriUtil.HTTP_SCHEME).build().toString();
    }

    /* renamed from: b */
    public static C6245a m26063b(String str) {
        str = new C6245a().m25814a(str).m25816a("Exponent-SDK-Version", C6301d.f20499e).m25816a("Exponent-Platform", "android");
        if (C7549c.m34188a().m34193b() != null) {
            str.m25816a("Exponent-Version", C7549c.m34188a().m34193b());
        }
        return str;
    }

    /* renamed from: a */
    public static C6245a m26061a(String str, boolean z, String str2) {
        String str3;
        str = C6339i.m26063b(str).m25816a("Accept", "application/expo+json,application/json");
        if (C6348k.f20604c) {
            str.m25816a("Exponent-SDK-Version", "UNVERSIONED");
        }
        if (z) {
            str.m25816a("Expo-Release-Channel", C6301d.f20503i);
            str3 = "STANDALONE";
        } else {
            if (!Build.FINGERPRINT.contains("vbox")) {
                if (!Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) {
                    str3 = "EXPO_DEVICE";
                }
            }
            str3 = "EXPO_SIMULATOR";
        }
        str.m25816a("Expo-Api-Version", AppEventsConstants.EVENT_PARAM_VALUE_YES).m25816a("Expo-Client-Environment", str3);
        if (str2 != null) {
            str.m25816a("Expo-Session", str2);
        }
        return str;
    }
}

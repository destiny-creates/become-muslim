package co.apptailor.googlesignin;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.C2733a;
import com.google.android.gms.common.api.C2782b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.p186f.C2954g;

/* compiled from: Utils */
/* renamed from: co.apptailor.googlesignin.d */
public class C0850d {
    /* renamed from: a */
    static String m3060a(ReadableArray readableArray) {
        StringBuilder stringBuilder = new StringBuilder("oauth2:");
        for (int i = 0; i < readableArray.size(); i++) {
            stringBuilder.append(readableArray.getString(i));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /* renamed from: a */
    static WritableMap m3058a(GoogleSignInAccount googleSignInAccount) {
        Uri h = googleSignInAccount.m16664h();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("id", googleSignInAccount.m16657a());
        createMap.putString("name", googleSignInAccount.m16661e());
        createMap.putString("givenName", googleSignInAccount.m16662f());
        createMap.putString("familyName", googleSignInAccount.m16663g());
        createMap.putString("email", googleSignInAccount.m16659c());
        createMap.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, h != null ? h.toString() : null);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("user", createMap);
        createMap2.putString("idToken", googleSignInAccount.m16658b());
        createMap2.putString("serverAuthCode", googleSignInAccount.m16665i());
        createMap2.putString("accessToken", null);
        createMap2.putString("accessTokenExpirationDate", null);
        WritableArray createArray = Arguments.createArray();
        for (Scope scope : googleSignInAccount.m16668l()) {
            String scope2 = scope.toString();
            if (scope2.startsWith(UriUtil.HTTP_SCHEME)) {
                createArray.pushString(scope2);
            }
        }
        createMap2.putArray("scopes", createArray);
        return createMap2;
    }

    /* renamed from: a */
    static GoogleSignInOptions m3059a(Scope[] scopeArr, String str, boolean z, boolean z2, String str2, String str3) {
        scopeArr = new C2733a(GoogleSignInOptions.f13945f).m7784a(new Scope("email"), scopeArr);
        if (!(str == null || str.isEmpty())) {
            scopeArr.m7785a(str);
            if (z) {
                scopeArr.m7786a(str, z2);
            }
        }
        if (str2 != null && str2.isEmpty() == null) {
            scopeArr.m7788b(str2);
        }
        if (str3 != null && str3.isEmpty() == null) {
            scopeArr.m7790c(str3);
        }
        return scopeArr.m7791d();
    }

    /* renamed from: b */
    static Scope[] m3061b(ReadableArray readableArray) {
        int size = readableArray.size();
        Scope[] scopeArr = new Scope[size];
        for (int i = 0; i < size; i++) {
            scopeArr[i] = new Scope(readableArray.getString(i));
        }
        return scopeArr;
    }

    /* renamed from: a */
    public static int m3057a(C2954g<Void> c2954g) {
        c2954g = c2954g.mo2592e();
        return c2954g instanceof C2782b ? ((C2782b) c2954g).m7935a() : 8;
    }
}

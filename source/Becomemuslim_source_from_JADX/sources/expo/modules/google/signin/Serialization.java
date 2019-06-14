package expo.modules.google.signin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.C2733a;
import com.google.android.gms.common.api.C2782b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.p186f.C2954g;
import expo.p304a.C6009f;
import java.util.ArrayList;
import java.util.Map;

public class Serialization {
    private Bundle auth;

    static String scopesToString(ArrayList<String> arrayList) {
        StringBuilder stringBuilder = new StringBuilder("oauth2:");
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append((String) arrayList.get(i));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    static Bundle jsonFromGoogleUser(GoogleSignInAccount googleSignInAccount) {
        Bundle bundle = new Bundle();
        bundle.putString("accessToken", null);
        bundle.putString("accessTokenExpirationDate", null);
        bundle.putString("refreshToken", null);
        bundle.putString("idToken", googleSignInAccount.b());
        Uri h = googleSignInAccount.h();
        Bundle bundle2 = new Bundle();
        bundle2.putString("uid", googleSignInAccount.a());
        bundle2.putString("displayName", googleSignInAccount.e());
        bundle2.putString("firstName", googleSignInAccount.f());
        bundle2.putString("lastName", googleSignInAccount.g());
        bundle2.putString("email", googleSignInAccount.c());
        bundle2.putString("photoURL", h != null ? h.toString() : null);
        bundle2.putString("serverAuthCode", googleSignInAccount.i());
        bundle2.putBundle("auth", bundle);
        bundle2.putString("serverAuthCode", googleSignInAccount.i());
        bundle2.putString("domain", null);
        ArrayList arrayList = new ArrayList();
        for (Scope scope : googleSignInAccount.l()) {
            String scope2 = scope.toString();
            if (scope2.startsWith(UriUtil.HTTP_SCHEME)) {
                arrayList.add(scope2);
            }
        }
        bundle2.putStringArrayList("scopes", arrayList);
        return bundle2;
    }

    private static Boolean isNullOrEmpty(String str) {
        if (str != null) {
            if (str.isEmpty() == null) {
                str = null;
                return Boolean.valueOf(str);
            }
        }
        str = true;
        return Boolean.valueOf(str);
    }

    static GoogleSignInOptions getSignInOptions(Context context, Map<String, Object> map, String str, C6009f c6009f) {
        String str2 = map.containsKey("signInType") ? (String) map.get("signInType") : "default";
        ArrayList arrayList = map.containsKey("scopes") ? (ArrayList) map.get("scopes") : new ArrayList();
        String str3 = map.containsKey("webClientId") ? (String) map.get("webClientId") : null;
        Object obj = 1;
        Object obj2 = (map.containsKey("isOfflineEnabled") && ((Boolean) map.get("isOfflineEnabled")).booleanValue()) ? 1 : null;
        boolean z = map.containsKey("isPromptEnabled") && ((Boolean) map.get("isPromptEnabled")).booleanValue();
        String str4 = map.containsKey("accountName") ? (String) map.get("accountName") : null;
        map = map.containsKey("hostedDomain") ? (String) map.get("hostedDomain") : null;
        int hashCode = str2.hashCode();
        if (hashCode != 98120385) {
            if (hashCode == 1544803905) {
                if (str2.equals("default")) {
                    obj = null;
                    switch (obj) {
                        case null:
                            c6009f = new C2733a(GoogleSignInOptions.f13945f).b().c();
                            break;
                        case 1:
                            c6009f = new C2733a(GoogleSignInOptions.f13946g);
                            break;
                        default:
                            c6009f.m25152a("E_GOOGLE_SIGN_IN", "Invalid signInOption");
                            return null;
                    }
                    if (str3 != null && str.equals("standalone") != null) {
                        str = context.getResources().getIdentifier("default_web_client_id", "string", context.getPackageName());
                        if (str != null) {
                            c6009f.a(context.getString(str));
                        }
                    } else if (isNullOrEmpty(str3).booleanValue() == null) {
                        c6009f.a(str3);
                        if (obj2 != null) {
                            c6009f.a(str3, z);
                        }
                    }
                    context = arrayList.iterator();
                    while (context.hasNext() != null) {
                        c6009f.a(new Scope((String) context.next()), new Scope[0]);
                    }
                    if (isNullOrEmpty(map).booleanValue() == null) {
                        c6009f.c(map);
                    }
                    if (isNullOrEmpty(str4).booleanValue() == null) {
                        c6009f.b(str4);
                    }
                    return c6009f.d();
                }
            }
        } else if (str2.equals("games")) {
            switch (obj) {
                case null:
                    c6009f = new C2733a(GoogleSignInOptions.f13945f).b().c();
                    break;
                case 1:
                    c6009f = new C2733a(GoogleSignInOptions.f13946g);
                    break;
                default:
                    c6009f.m25152a("E_GOOGLE_SIGN_IN", "Invalid signInOption");
                    return null;
            }
            if (str3 != null) {
            }
            if (isNullOrEmpty(str3).booleanValue() == null) {
                c6009f.a(str3);
                if (obj2 != null) {
                    c6009f.a(str3, z);
                }
            }
            context = arrayList.iterator();
            while (context.hasNext() != null) {
                c6009f.a(new Scope((String) context.next()), new Scope[0]);
            }
            if (isNullOrEmpty(map).booleanValue() == null) {
                c6009f.c(map);
            }
            if (isNullOrEmpty(str4).booleanValue() == null) {
                c6009f.b(str4);
            }
            return c6009f.d();
        }
        obj = -1;
        switch (obj) {
            case null:
                c6009f = new C2733a(GoogleSignInOptions.f13945f).b().c();
                break;
            case 1:
                c6009f = new C2733a(GoogleSignInOptions.f13946g);
                break;
            default:
                c6009f.m25152a("E_GOOGLE_SIGN_IN", "Invalid signInOption");
                return null;
        }
        if (str3 != null) {
        }
        if (isNullOrEmpty(str3).booleanValue() == null) {
            c6009f.a(str3);
            if (obj2 != null) {
                c6009f.a(str3, z);
            }
        }
        context = arrayList.iterator();
        while (context.hasNext() != null) {
            c6009f.a(new Scope((String) context.next()), new Scope[0]);
        }
        if (isNullOrEmpty(map).booleanValue() == null) {
            c6009f.c(map);
        }
        if (isNullOrEmpty(str4).booleanValue() == null) {
            c6009f.b(str4);
        }
        return c6009f.d();
    }

    public static int getExceptionCode(C2954g<Void> c2954g) {
        c2954g = c2954g.e();
        return c2954g instanceof C2782b ? ((C2782b) c2954g).a() : 8;
    }
}

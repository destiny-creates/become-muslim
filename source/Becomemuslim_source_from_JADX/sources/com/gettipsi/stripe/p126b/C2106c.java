package com.gettipsi.stripe.p126b;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.places.model.PlaceFields;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.C7877i;
import com.stripe.android.p285b.C5722b;
import com.stripe.android.p285b.C7156a;
import com.stripe.android.p285b.C7157c;
import com.stripe.android.p285b.C7162i;
import com.stripe.android.p285b.C7163k;
import com.stripe.android.p285b.C7164l;
import com.stripe.android.p285b.C7165n;
import com.stripe.android.p285b.C7166o;
import com.stripe.android.p285b.C7168u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: Converters */
/* renamed from: com.gettipsi.stripe.b.c */
public class C2106c {
    /* renamed from: a */
    public static WritableMap m5794a(C7168u c7168u) {
        WritableMap createMap = Arguments.createMap();
        if (c7168u == null) {
            return createMap;
        }
        createMap.putString("tokenId", c7168u.y());
        createMap.putBoolean("livemode", c7168u.b());
        createMap.putBoolean("used", c7168u.c());
        createMap.putDouble("created", (double) c7168u.a().getTime());
        if (c7168u.d() != null) {
            createMap.putMap("card", C2106c.m5788a(c7168u.d()));
        }
        if (c7168u.e() != null) {
            createMap.putMap("bankAccount", C2106c.m5787a(c7168u.e()));
        }
        return createMap;
    }

    /* renamed from: a */
    public static WritableMap m5784a(WritableMap writableMap, UserAddress userAddress, UserAddress userAddress2) {
        C2104a.m5776a((Object) writableMap);
        WritableMap createMap = Arguments.createMap();
        createMap.putMap("billingContact", C2106c.m5785a(userAddress));
        createMap.putMap("shippingContact", C2106c.m5785a(userAddress2));
        writableMap.putMap("extra", createMap);
        return writableMap;
    }

    /* renamed from: a */
    private static WritableMap m5788a(C7157c c7157c) {
        WritableMap createMap = Arguments.createMap();
        if (c7157c == null) {
            return createMap;
        }
        createMap.putString("cardId", c7157c.y());
        createMap.putString("number", c7157c.g());
        createMap.putString("cvc", c7157c.i());
        createMap.putInt("expMonth", c7157c.j().intValue());
        createMap.putInt("expYear", c7157c.k().intValue());
        createMap.putString("name", c7157c.l());
        createMap.putString("addressLine1", c7157c.m());
        createMap.putString("addressLine2", c7157c.n());
        createMap.putString("addressCity", c7157c.o());
        createMap.putString("addressState", c7157c.q());
        createMap.putString("addressZip", c7157c.p());
        createMap.putString("addressCountry", c7157c.r());
        createMap.putString("last4", c7157c.t());
        createMap.putString("brand", c7157c.u());
        createMap.putString("funding", c7157c.w());
        createMap.putString("fingerprint", c7157c.v());
        createMap.putString(UserDataStore.COUNTRY, c7157c.x());
        createMap.putString("currency", c7157c.s());
        return createMap;
    }

    /* renamed from: a */
    public static WritableMap m5787a(C5722b c5722b) {
        WritableMap createMap = Arguments.createMap();
        if (c5722b == null) {
            return createMap;
        }
        createMap.putString("routingNumber", c5722b.i());
        createMap.putString("accountNumber", c5722b.a());
        createMap.putString("countryCode", c5722b.e());
        createMap.putString("currency", c5722b.f());
        createMap.putString("accountHolderName", c5722b.b());
        createMap.putString("accountHolderType", c5722b.c());
        createMap.putString("fingerprint", c5722b.g());
        createMap.putString("bankName", c5722b.d());
        createMap.putString("last4", c5722b.h());
        return createMap;
    }

    /* renamed from: a */
    public static String m5799a(ReadableMap readableMap, String str, String str2) {
        return readableMap.hasKey(str) ? readableMap.getString(str) : str2;
    }

    /* renamed from: a */
    public static Boolean m5797a(ReadableMap readableMap, String str, Boolean bool) {
        return readableMap.hasKey(str) ? Boolean.valueOf(readableMap.getBoolean(str)) : bool;
    }

    /* renamed from: a */
    public static ReadableArray m5783a(ReadableMap readableMap, String str, ReadableArray readableArray) {
        return readableMap.hasKey(str) ? readableMap.getArray(str) : readableArray;
    }

    /* renamed from: a */
    public static String m5798a(ReadableMap readableMap, String str) {
        return C2106c.m5799a(readableMap, str, (String) null);
    }

    /* renamed from: a */
    public static Collection<String> m5800a(ReadableMap readableMap) {
        Collection arrayList = new ArrayList();
        readableMap = C2106c.m5783a(readableMap, "shipping_countries", (ReadableArray) null);
        if (readableMap != null) {
            for (int i = 0; i < readableMap.size(); i++) {
                arrayList.add(readableMap.getString(i));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static C7157c m5804b(ReadableMap readableMap) {
        ReadableMap readableMap2 = readableMap;
        return new C7157c(readableMap2.getString("number"), Integer.valueOf(readableMap2.getInt("expMonth")), Integer.valueOf(readableMap2.getInt("expYear")), C2106c.m5798a(readableMap2, "cvc"), C2106c.m5798a(readableMap2, "name"), C2106c.m5798a(readableMap2, "addressLine1"), C2106c.m5798a(readableMap2, "addressLine2"), C2106c.m5798a(readableMap2, "addressCity"), C2106c.m5798a(readableMap2, "addressState"), C2106c.m5798a(readableMap2, "addressZip"), C2106c.m5798a(readableMap2, "addressCountry"), C2106c.m5798a(readableMap2, "brand"), C2106c.m5798a(readableMap2, "last4"), C2106c.m5798a(readableMap2, "fingerprint"), C2106c.m5798a(readableMap2, "funding"), C2106c.m5798a(readableMap2, UserDataStore.COUNTRY), C2106c.m5798a(readableMap2, "currency"), C2106c.m5798a(readableMap2, "id"));
    }

    /* renamed from: a */
    public static WritableMap m5789a(C7162i c7162i) {
        WritableMap createMap = Arguments.createMap();
        if (c7162i == null) {
            return createMap;
        }
        createMap.putString("sourceId", c7162i.y());
        createMap.putInt("amount", c7162i.c().intValue());
        createMap.putInt("created", c7162i.f().intValue());
        createMap.putMap("codeVerification", C2106c.m5790a(c7162i.e()));
        createMap.putString("currency", c7162i.g());
        createMap.putString("flow", c7162i.h());
        createMap.putBoolean("livemode", c7162i.i().booleanValue());
        createMap.putMap("metadata", C2106c.m5795a(c7162i.j()));
        createMap.putMap("owner", C2106c.m5791a(c7162i.k()));
        createMap.putMap("receiver", C2106c.m5792a(c7162i.l()));
        createMap.putMap("redirect", C2106c.m5793a(c7162i.m()));
        createMap.putMap("sourceTypeData", C2106c.m5803b(c7162i.o()));
        createMap.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, c7162i.n());
        createMap.putString("type", c7162i.q());
        createMap.putString("typeRaw", c7162i.r());
        createMap.putString("usage", c7162i.s());
        return createMap;
    }

    /* renamed from: a */
    public static WritableMap m5795a(Map<String, String> map) {
        WritableMap createMap = Arguments.createMap();
        if (map == null) {
            return createMap;
        }
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            createMap.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return createMap;
    }

    /* renamed from: a */
    public static WritableMap m5791a(C7164l c7164l) {
        WritableMap createMap = Arguments.createMap();
        if (c7164l == null) {
            return createMap;
        }
        createMap.putMap("address", C2106c.m5786a(c7164l.c()));
        createMap.putString("email", c7164l.d());
        createMap.putString("name", c7164l.e());
        createMap.putString(PlaceFields.PHONE, c7164l.f());
        createMap.putString("verifiedEmail", c7164l.h());
        createMap.putString("verifiedPhone", c7164l.j());
        createMap.putString("verifiedName", c7164l.i());
        createMap.putMap("verifiedAddress", C2106c.m5786a(c7164l.g()));
        return createMap;
    }

    /* renamed from: a */
    public static WritableMap m5786a(C7156a c7156a) {
        WritableMap createMap = Arguments.createMap();
        if (c7156a == null) {
            return createMap;
        }
        createMap.putString("city", c7156a.c());
        createMap.putString(UserDataStore.COUNTRY, c7156a.d());
        createMap.putString("line1", c7156a.e());
        createMap.putString("line2", c7156a.f());
        createMap.putString("postalCode", c7156a.g());
        createMap.putString(ServerProtocol.DIALOG_PARAM_STATE, c7156a.h());
        return createMap;
    }

    /* renamed from: a */
    public static WritableMap m5792a(C7165n c7165n) {
        WritableMap createMap = Arguments.createMap();
        if (c7165n == null) {
            return createMap;
        }
        createMap.putInt("amountCharged", (int) c7165n.d());
        createMap.putInt("amountReceived", (int) c7165n.e());
        createMap.putInt("amountReturned", (int) c7165n.f());
        createMap.putString("address", c7165n.c());
        return createMap;
    }

    /* renamed from: a */
    public static WritableMap m5793a(C7166o c7166o) {
        WritableMap createMap = Arguments.createMap();
        if (c7166o == null) {
            return createMap;
        }
        createMap.putString("returnUrl", c7166o.c());
        createMap.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, c7166o.d());
        createMap.putString("url", c7166o.e());
        return createMap;
    }

    /* renamed from: a */
    public static WritableMap m5790a(C7163k c7163k) {
        WritableMap createMap = Arguments.createMap();
        if (c7163k == null) {
            return createMap;
        }
        createMap.putInt("attemptsRemaining", c7163k.c());
        createMap.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, c7163k.d());
        return createMap;
    }

    /* renamed from: b */
    public static WritableMap m5803b(Map<String, Object> map) {
        WritableMap createMap = Arguments.createMap();
        if (map == null) {
            return createMap;
        }
        for (String str : map.keySet()) {
            C2106c.m5801a(createMap, str, map.get(str));
        }
        return createMap;
    }

    /* renamed from: a */
    public static void m5801a(WritableMap writableMap, String str, Object obj) {
        Class cls = obj.getClass();
        if (cls == Boolean.class) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (cls == Integer.class) {
            writableMap.putDouble(str, ((Integer) obj).doubleValue());
        } else if (cls == Double.class) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
        } else if (cls == Float.class) {
            writableMap.putDouble(str, ((Float) obj).doubleValue());
        } else if (cls == String.class) {
            writableMap.putString(str, obj.toString());
        } else if (cls == WritableNativeMap.class) {
            writableMap.putMap(str, (WritableNativeMap) obj);
        } else if (cls == WritableNativeArray.class) {
            writableMap.putArray(str, (WritableNativeArray) obj);
        }
    }

    /* renamed from: a */
    public static WritableMap m5785a(UserAddress userAddress) {
        WritableMap createMap = Arguments.createMap();
        if (userAddress == null) {
            return createMap;
        }
        C2106c.m5802a(createMap, "address1", userAddress.m17037b());
        C2106c.m5802a(createMap, "address2", userAddress.m17038c());
        C2106c.m5802a(createMap, "address3", userAddress.m17039d());
        C2106c.m5802a(createMap, "address4", userAddress.m17040e());
        C2106c.m5802a(createMap, "address5", userAddress.m17041f());
        C2106c.m5802a(createMap, "administrativeArea", userAddress.m17042g());
        C2106c.m5802a(createMap, "companyName", userAddress.m17048m());
        C2106c.m5802a(createMap, "countryCode", userAddress.m17044i());
        C2106c.m5802a(createMap, "locality", userAddress.m17043h());
        C2106c.m5802a(createMap, "name", userAddress.m17036a());
        C2106c.m5802a(createMap, "phoneNumber", userAddress.m17047l());
        C2106c.m5802a(createMap, "postalCode", userAddress.m17045j());
        C2106c.m5802a(createMap, "sortingCode", userAddress.m17046k());
        return createMap;
    }

    /* renamed from: c */
    public static C5722b m5806c(ReadableMap readableMap) {
        C5722b c5722b = new C5722b(readableMap.getString("accountNumber"), readableMap.getString("countryCode"), readableMap.getString("currency"), C2106c.m5799a(readableMap, "routingNumber", ""));
        c5722b.a(C2106c.m5798a(readableMap, "accountHolderName"));
        c5722b.b(C2106c.m5798a(readableMap, "accountHolderType"));
        return c5722b;
    }

    /* renamed from: b */
    public static String m5805b(ReadableMap readableMap, String str) {
        return readableMap.hasKey(str) ? readableMap.getString(str) : null;
    }

    /* renamed from: a */
    public static void m5802a(WritableMap writableMap, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            writableMap.putString(str, str2);
        }
    }

    /* renamed from: a */
    public static UserAddress m5796a(C7877i c7877i) {
        return (c7877i == null || c7877i.a() == null) ? null : c7877i.a().a();
    }
}

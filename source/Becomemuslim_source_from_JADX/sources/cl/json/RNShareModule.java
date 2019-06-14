package cl.json;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import cl.json.p047a.C0839h;
import cl.json.p047a.C3340d;
import cl.json.p047a.C4494a;
import cl.json.p047a.C4495b;
import cl.json.p047a.C4496c;
import cl.json.p047a.C4497e;
import cl.json.p047a.C4498f;
import cl.json.p047a.C4499g;
import cl.json.p047a.C4500j;
import cl.json.p047a.C4501k;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Map;

public class RNShareModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    /* renamed from: cl.json.RNShareModule$a */
    private enum C0838a {
        facebook,
        generic,
        pagesmanager,
        twitter,
        whatsapp,
        instagram,
        googleplus,
        email,
        pinterest;

        /* renamed from: a */
        public static C0839h m3016a(String str, ReactApplicationContext reactApplicationContext) {
            switch (C0838a.valueOf(str)) {
                case generic:
                    return new C3340d(reactApplicationContext);
                case facebook:
                    return new C4496c(reactApplicationContext);
                case pagesmanager:
                    return new C4495b(reactApplicationContext);
                case twitter:
                    return new C4500j(reactApplicationContext);
                case whatsapp:
                    return new C4501k(reactApplicationContext);
                case instagram:
                    return new C4498f(reactApplicationContext);
                case googleplus:
                    return new C4497e(reactApplicationContext);
                case email:
                    return new C4494a(reactApplicationContext);
                case pinterest:
                    return new C4499g(reactApplicationContext);
                default:
                    return null;
            }
        }
    }

    public String getName() {
        return "RNShare";
    }

    public RNShareModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        for (C0838a c0838a : C0838a.values()) {
            hashMap.put(c0838a.toString().toUpperCase(), c0838a.toString());
        }
        return hashMap;
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            new C3340d(this.reactContext).mo716a(readableMap);
            callback2.invoke(new Object[]{"OK"});
        } catch (ReadableMap readableMap2) {
            System.out.println("ERROR");
            System.out.println(readableMap2.getMessage());
            callback.invoke(new Object[]{"not_available"});
        } catch (ReadableMap readableMap22) {
            System.out.println("ERROR");
            System.out.println(readableMap22.getMessage());
            callback.invoke(new Object[]{readableMap22.getMessage()});
        }
    }

    @ReactMethod
    public void shareSingle(ReadableMap readableMap, Callback callback, Callback callback2) {
        System.out.println("SHARE SINGLE METHOD");
        if (C0839h.m3018a("social", readableMap)) {
            try {
                C0839h a = C0838a.m3016a(readableMap.getString("social"), this.reactContext);
                if (a == null || !(a instanceof C0839h)) {
                    throw new ActivityNotFoundException("Invalid share activity");
                }
                a.mo716a(readableMap);
                callback2.invoke(new Object[]{"OK"});
                return;
            } catch (ReadableMap readableMap2) {
                System.out.println("ERROR");
                System.out.println(readableMap2.getMessage());
                callback.invoke(new Object[]{readableMap2.getMessage()});
                return;
            } catch (ReadableMap readableMap22) {
                System.out.println("ERROR");
                System.out.println(readableMap22.getMessage());
                callback.invoke(new Object[]{readableMap22.getMessage()});
                return;
            }
        }
        callback.invoke(new Object[]{"key 'social' missing in options"});
    }

    @ReactMethod
    public void isBase64File(String str, Callback callback, Callback callback2) {
        try {
            str = Uri.parse(str).getScheme();
            if (str == null || str.equals("data") == null) {
                callback2.invoke(new Object[]{Boolean.valueOf(false)});
                return;
            }
            callback2.invoke(new Object[]{Boolean.valueOf(true)});
        } catch (String str2) {
            System.out.println("ERROR");
            System.out.println(str2.getMessage());
            callback.invoke(new Object[]{str2.getMessage()});
        }
    }
}

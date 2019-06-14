package expo.adapters.react;

import android.content.Context;
import com.facebook.react.bridge.ReactContext;
import expo.adapters.react.services.C7374a;
import expo.adapters.react.services.C7375b;
import expo.adapters.react.services.C7380c;
import expo.adapters.react.services.CookieManagerModule;
import expo.p304a.C7369b;
import expo.p304a.p305a.C5998e;
import java.util.Arrays;
import java.util.List;

/* compiled from: ReactAdapterPackage */
/* renamed from: expo.adapters.react.d */
public class C8157d extends C7369b {
    public List<C5998e> createInternalModules(Context context) {
        ReactContext reactContext = (ReactContext) context;
        return Arrays.asList(new C5998e[]{new CookieManagerModule(reactContext), new C7380c(reactContext), new C7374a(reactContext), new C7375b()});
    }
}

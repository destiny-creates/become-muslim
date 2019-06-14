package versioned.host.exp.exponent.modules.api;

import android.content.Context;
import android.net.Uri;
import android.support.p015c.C0107c.C0106a;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import de.p287a.p288a.C5884c;
import host.exp.exponent.chrometabs.ChromeTabsManagerActivity;
import host.exp.exponent.chrometabs.ChromeTabsManagerActivity.C6296a;
import host.exp.p333a.C6271b;

public class WebBrowserModule extends ReactContextBaseJavaModule {
    private static final String ERROR_CODE = "EXWebBrowser";
    private Promise mOpenBrowserPromise;

    public String getName() {
        return "ExponentWebBrowser";
    }

    public WebBrowserModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void openBrowserAsync(String str, Promise promise) {
        if (this.mOpenBrowserPromise != null) {
            str = Arguments.createMap();
            str.putString("type", "cancel");
            this.mOpenBrowserPromise.resolve(str);
            return;
        }
        this.mOpenBrowserPromise = promise;
        Context b = C6271b.m25897a().m25920b();
        if (b == null) {
            promise.reject(ERROR_CODE, "No activity");
            this.mOpenBrowserPromise = null;
            return;
        }
        promise = new C0106a().a().f240a;
        promise.setData(Uri.parse(str));
        promise.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 0);
        C5884c.m24753a().m24765a((Object) this);
        b.startActivity(ChromeTabsManagerActivity.m25992a(b, promise));
    }

    @ReactMethod
    public void dismissBrowser() {
        if (this.mOpenBrowserPromise != null) {
            Context b = C6271b.m25897a().m25920b();
            if (b == null) {
                this.mOpenBrowserPromise.reject(ERROR_CODE, "No activity");
                this.mOpenBrowserPromise = null;
                return;
            }
            C5884c.m24753a().m24768c(this);
            WritableMap createMap = Arguments.createMap();
            createMap.putString("type", "dismiss");
            this.mOpenBrowserPromise.resolve(createMap);
            this.mOpenBrowserPromise = null;
            b.startActivity(ChromeTabsManagerActivity.m25991a(b));
        }
    }

    public void onEvent(C6296a c6296a) {
        C5884c.m24753a().m24768c(this);
        Assertions.assertNotNull(this.mOpenBrowserPromise);
        c6296a = Arguments.createMap();
        c6296a.putString("type", "cancel");
        this.mOpenBrowserPromise.resolve(c6296a);
        this.mOpenBrowserPromise = null;
    }
}

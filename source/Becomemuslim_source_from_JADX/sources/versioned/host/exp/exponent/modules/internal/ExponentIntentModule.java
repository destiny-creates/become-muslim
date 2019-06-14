package versioned.host.exp.exponent.modules.internal;

import android.net.Uri;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.intent.IntentModule;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.p340a.C6328c;
import host.exp.exponent.p339f.p340a.p341a.C6323a;
import java.util.Map;
import javax.inject.C6562a;

public class ExponentIntentModule extends IntentModule {
    private Map<String, Object> mExperienceProperties;
    @C6562a
    protected C6328c mKernelServiceRegistry;

    public boolean canOverrideExistingModule() {
        return true;
    }

    public ExponentIntentModule(ReactApplicationContext reactApplicationContext, Map<String, Object> map) {
        super(reactApplicationContext);
        C6294a.m25957a().m25961b(ExponentIntentModule.class, this);
        this.mExperienceProperties = map;
    }

    private C6323a getKernelService() {
        return this.mKernelServiceRegistry.m26032a();
    }

    @ReactMethod
    public void getInitialURL(Promise promise) {
        try {
            promise.resolve(this.mExperienceProperties.get("intentUri"));
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not get the initial URL : ");
            stringBuilder.append(e.getMessage());
            promise.reject(new JSApplicationIllegalArgumentException(stringBuilder.toString()));
        }
    }

    @ReactMethod
    public void openURL(String str, final Promise promise) {
        if (str != null) {
            if (!str.isEmpty()) {
                final Uri parse = Uri.parse(str);
                if (getKernelService().m26010b(parse)) {
                    getReactApplicationContext().runOnUiQueueThread(new Runnable() {
                        public void run() {
                            ExponentIntentModule.this.getKernelService().m26009a(parse);
                            promise.resolve(Boolean.valueOf(true));
                        }
                    });
                } else {
                    super.openURL(str, promise);
                }
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid URL: ");
        stringBuilder.append(str);
        promise.reject(new JSApplicationIllegalArgumentException(stringBuilder.toString()));
    }

    @ReactMethod
    public void canOpenURL(String str, Promise promise) {
        if (str != null) {
            if (!str.isEmpty()) {
                if (this.mKernelServiceRegistry.m26032a().m26010b(Uri.parse(str))) {
                    promise.resolve(Boolean.valueOf(true));
                } else {
                    super.canOpenURL(str, promise);
                }
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid URL: ");
        stringBuilder.append(str);
        promise.reject(new JSApplicationIllegalArgumentException(stringBuilder.toString()));
    }
}

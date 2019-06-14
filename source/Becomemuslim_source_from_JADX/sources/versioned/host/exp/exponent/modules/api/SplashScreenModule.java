package versioned.host.exp.exponent.modules.api;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.p340a.C7548e;
import versioned.host.exp.exponent.modules.ExpoKernelServiceConsumerBaseModule;

public class SplashScreenModule extends ExpoKernelServiceConsumerBaseModule {
    private C7548e mSplashScreenKernelService = this.mKernelServiceRegistry.m26041j();

    public String getName() {
        return "ExponentSplashScreen";
    }

    public SplashScreenModule(ReactApplicationContext reactApplicationContext, C6330b c6330b) {
        super(reactApplicationContext, c6330b);
    }

    @ReactMethod
    public void preventAutoHide() {
        this.mSplashScreenKernelService.m34186f();
    }

    @ReactMethod
    public void hide() {
        this.mSplashScreenKernelService.m34182c(this.experienceId);
    }
}

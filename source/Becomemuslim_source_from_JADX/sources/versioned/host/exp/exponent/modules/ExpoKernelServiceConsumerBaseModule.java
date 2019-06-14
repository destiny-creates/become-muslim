package versioned.host.exp.exponent.modules;

import com.facebook.react.bridge.ReactApplicationContext;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.p340a.C6328c;
import javax.inject.C6562a;

public abstract class ExpoKernelServiceConsumerBaseModule extends ExpoBaseModule {
    @C6562a
    protected C6328c mKernelServiceRegistry;

    public ExpoKernelServiceConsumerBaseModule(ReactApplicationContext reactApplicationContext, C6330b c6330b) {
        super(reactApplicationContext, c6330b);
        C6294a.m25957a().m25961b(ExpoKernelServiceConsumerBaseModule.class, this);
    }
}

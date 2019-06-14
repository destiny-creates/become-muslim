package versioned.host.exp.exponent;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import host.exp.p333a.C6271b.C6267b;

public class VersionedUtils {
    public static ReactInstanceManagerBuilder getReactInstanceManagerBuilder(C6267b c6267b) {
        ReactInstanceManagerBuilder initialLifecycleState = ReactInstanceManager.builder().setApplication(c6267b.f20404a).addPackage(new MainReactPackage()).addPackage(new ExponentPackage(c6267b.f20406c, c6267b.f20409f, c6267b.f20407d, c6267b.f20408e, c6267b.f20410g)).setInitialLifecycleState(LifecycleState.RESUMED);
        return (c6267b.f20405b == null || c6267b.f20405b.length() <= 0) ? initialLifecycleState : initialLifecycleState.setJSBundleFile(c6267b.f20405b);
    }
}

package versioned.host.exp.exponent.modules;

import android.view.View;
import com.facebook.react.uimanager.SimpleViewManager;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.p340a.C6328c;
import javax.inject.C6562a;

public abstract class ExpoKernelServiceConsumerViewManager<T extends View> extends SimpleViewManager<T> {
    protected final C6330b experienceId;
    @C6562a
    protected C6328c mKernelServiceRegistry;

    public ExpoKernelServiceConsumerViewManager(C6330b c6330b) {
        this.experienceId = c6330b;
        C6294a.m25957a().m25961b(ExpoKernelServiceConsumerViewManager.class, this);
    }
}

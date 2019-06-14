package versioned.host.exp.exponent;

import android.content.Context;
import android.view.ContextThemeWrapper;
import host.exp.p333a.C6279c.C6278g;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.react.RNGestureHandlerEnabledRootView;

public class ReactUnthemedRootView extends RNGestureHandlerEnabledRootView {
    public ReactUnthemedRootView(Context context) {
        super(new ContextThemeWrapper(context, C6278g.Theme_Exponent_None));
    }
}

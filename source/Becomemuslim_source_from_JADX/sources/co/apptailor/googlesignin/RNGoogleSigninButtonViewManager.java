package co.apptailor.googlesignin;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.common.C2876l;

public class RNGoogleSigninButtonViewManager extends SimpleViewManager<C2876l> {
    public String getName() {
        return "RNGoogleSigninButton";
    }

    protected C2876l createViewInstance(final ThemedReactContext themedReactContext) {
        C2876l c2876l = new C2876l(themedReactContext);
        c2876l.setSize(0);
        c2876l.setColorScheme(2);
        c2876l.setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ RNGoogleSigninButtonViewManager f2345b;

            public void onClick(View view) {
                ((RCTDeviceEventEmitter) themedReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("RNGoogleSigninButtonClicked", null);
            }
        });
        return c2876l;
    }

    @ReactProp(name = "size")
    public void setSize(C2876l c2876l, int i) {
        c2876l.setSize(i);
    }

    @ReactProp(name = "color")
    public void setColor(C2876l c2876l, int i) {
        c2876l.setColorScheme(i);
    }

    @ReactProp(name = "disabled")
    public void setDisabled(C2876l c2876l, boolean z) {
        c2876l.setEnabled(z ^ 1);
    }
}

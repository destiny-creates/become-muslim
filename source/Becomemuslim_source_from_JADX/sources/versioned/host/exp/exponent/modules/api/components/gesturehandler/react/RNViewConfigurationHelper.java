package versioned.host.exp.exponent.modules.api.components.gesturehandler.react;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.views.view.ReactViewGroup;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.PointerEventsConfig;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.ViewConfigurationHelper;

public class RNViewConfigurationHelper implements ViewConfigurationHelper {

    /* renamed from: versioned.host.exp.exponent.modules.api.components.gesturehandler.react.RNViewConfigurationHelper$1 */
    static /* synthetic */ class C67371 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$PointerEvents = new int[PointerEvents.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.facebook.react.uimanager.PointerEvents.values();
            r0 = r0.length;
            r0 = new int[r0];
            $SwitchMap$com$facebook$react$uimanager$PointerEvents = r0;
            r0 = $SwitchMap$com$facebook$react$uimanager$PointerEvents;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.facebook.react.uimanager.PointerEvents.BOX_ONLY;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = $SwitchMap$com$facebook$react$uimanager$PointerEvents;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.facebook.react.uimanager.PointerEvents.BOX_NONE;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = $SwitchMap$com$facebook$react$uimanager$PointerEvents;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = com.facebook.react.uimanager.PointerEvents.NONE;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.components.gesturehandler.react.RNViewConfigurationHelper.1.<clinit>():void");
        }
    }

    public PointerEventsConfig getPointerEventsConfigForView(View view) {
        PointerEvents pointerEvents = view instanceof ReactPointerEventsView ? ((ReactPointerEventsView) view).getPointerEvents() : PointerEvents.AUTO;
        if (view.isEnabled() == null) {
            if (pointerEvents == PointerEvents.AUTO) {
                return PointerEventsConfig.BOX_NONE;
            }
            if (pointerEvents == PointerEvents.BOX_ONLY) {
                return PointerEventsConfig.NONE;
            }
        }
        switch (C67371.$SwitchMap$com$facebook$react$uimanager$PointerEvents[pointerEvents.ordinal()]) {
            case 1:
                return PointerEventsConfig.BOX_ONLY;
            case 2:
                return PointerEventsConfig.BOX_NONE;
            case 3:
                return PointerEventsConfig.NONE;
            default:
                return PointerEventsConfig.AUTO;
        }
    }

    public View getChildInDrawingOrderAtIndex(ViewGroup viewGroup, int i) {
        if (viewGroup instanceof ReactViewGroup) {
            return viewGroup.getChildAt(((ReactViewGroup) viewGroup).getZIndexMappedChildIndex(i));
        }
        return viewGroup.getChildAt(i);
    }
}

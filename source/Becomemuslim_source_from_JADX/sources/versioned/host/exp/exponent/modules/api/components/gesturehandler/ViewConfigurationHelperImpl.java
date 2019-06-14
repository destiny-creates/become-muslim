package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.view.View;
import android.view.ViewGroup;

public class ViewConfigurationHelperImpl implements ViewConfigurationHelper {
    public PointerEventsConfig getPointerEventsConfigForView(View view) {
        return view.isEnabled() != null ? PointerEventsConfig.AUTO : PointerEventsConfig.NONE;
    }

    public View getChildInDrawingOrderAtIndex(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i);
    }
}

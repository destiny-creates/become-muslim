package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.view.View;
import android.view.ViewGroup;

public interface ViewConfigurationHelper {
    View getChildInDrawingOrderAtIndex(ViewGroup viewGroup, int i);

    PointerEventsConfig getPointerEventsConfigForView(View view);
}

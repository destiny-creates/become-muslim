package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class GestureHandlerRegistryImpl implements GestureHandlerRegistry {
    private WeakHashMap<View, ArrayList<GestureHandler>> mHandlers = new WeakHashMap();

    public <T extends GestureHandler> T registerHandlerForView(View view, T t) {
        ArrayList arrayList = (ArrayList) this.mHandlers.get(view);
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            arrayList.add(t);
            this.mHandlers.put(view, arrayList);
        } else {
            arrayList.add(t);
        }
        return t;
    }

    public ArrayList<GestureHandler> getHandlersForView(View view) {
        return (ArrayList) this.mHandlers.get(view);
    }
}

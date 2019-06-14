package versioned.host.exp.exponent.modules.api.components.gesturehandler.react;

import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.GestureHandler;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.GestureHandlerRegistry;

public class RNGestureHandlerRegistry implements GestureHandlerRegistry {
    private final SparseArray<Integer> mAttachedTo = new SparseArray();
    private final SparseArray<GestureHandler> mHandlers = new SparseArray();
    private final SparseArray<ArrayList<GestureHandler>> mHandlersForView = new SparseArray();

    public synchronized void registerHandler(GestureHandler gestureHandler) {
        this.mHandlers.put(gestureHandler.getTag(), gestureHandler);
    }

    public synchronized GestureHandler getHandler(int i) {
        return (GestureHandler) this.mHandlers.get(i);
    }

    public synchronized boolean attachHandlerToView(int i, int i2) {
        GestureHandler gestureHandler = (GestureHandler) this.mHandlers.get(i);
        if (gestureHandler == null) {
            return false;
        }
        detachHandler(gestureHandler);
        registerHandlerForViewWithTag(i2, gestureHandler);
        return true;
    }

    private synchronized void registerHandlerForViewWithTag(int i, GestureHandler gestureHandler) {
        if (this.mAttachedTo.get(gestureHandler.getTag()) == null) {
            this.mAttachedTo.put(gestureHandler.getTag(), Integer.valueOf(i));
            ArrayList arrayList = (ArrayList) this.mHandlersForView.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                arrayList.add(gestureHandler);
                this.mHandlersForView.put(i, arrayList);
            } else {
                arrayList.add(gestureHandler);
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Handler ");
            stringBuilder.append(gestureHandler);
            stringBuilder.append(" already attached");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private synchronized void detachHandler(GestureHandler gestureHandler) {
        Integer num = (Integer) this.mAttachedTo.get(gestureHandler.getTag());
        if (num != null) {
            this.mAttachedTo.remove(gestureHandler.getTag());
            ArrayList arrayList = (ArrayList) this.mHandlersForView.get(num.intValue());
            if (arrayList != null) {
                arrayList.remove(gestureHandler);
                if (arrayList.size() == 0) {
                    this.mHandlersForView.remove(num.intValue());
                }
            }
        }
        if (gestureHandler.getView() != null) {
            gestureHandler.cancel();
        }
    }

    public synchronized void dropHandler(int i) {
        GestureHandler gestureHandler = (GestureHandler) this.mHandlers.get(i);
        if (gestureHandler != null) {
            detachHandler(gestureHandler);
            this.mHandlers.remove(i);
        }
    }

    public synchronized void dropAllHandlers() {
        this.mHandlers.clear();
        this.mAttachedTo.clear();
        this.mHandlersForView.clear();
    }

    public synchronized ArrayList<GestureHandler> getHandlersForViewWithTag(int i) {
        return (ArrayList) this.mHandlersForView.get(i);
    }

    public synchronized ArrayList<GestureHandler> getHandlersForView(View view) {
        return getHandlersForViewWithTag(view.getId());
    }
}

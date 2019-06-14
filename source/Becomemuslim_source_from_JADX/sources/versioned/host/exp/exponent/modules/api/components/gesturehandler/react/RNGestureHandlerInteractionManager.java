package versioned.host.exp.exponent.modules.api.components.gesturehandler.react;

import android.util.SparseArray;
import com.facebook.react.bridge.ReadableMap;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.GestureHandler;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.GestureHandlerInteractionController;

public class RNGestureHandlerInteractionManager implements GestureHandlerInteractionController {
    private static final String KEY_SIMULTANEOUS_HANDLERS = "simultaneousHandlers";
    private static final String KEY_WAIT_FOR = "waitFor";
    private SparseArray<int[]> mSimultaneousRelations = new SparseArray();
    private SparseArray<int[]> mWaitForRelations = new SparseArray();

    public boolean shouldHandlerBeCancelledBy(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        return false;
    }

    public boolean shouldRequireHandlerToWaitForFailure(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        return false;
    }

    public void dropRelationsForHandlerWithTag(int i) {
        this.mWaitForRelations.remove(i);
        this.mSimultaneousRelations.remove(i);
    }

    private int[] convertHandlerTagsArray(ReadableMap readableMap, String str) {
        readableMap = readableMap.getArray(str);
        str = new int[readableMap.size()];
        for (int i = 0; i < str.length; i++) {
            str[i] = readableMap.getInt(i);
        }
        return str;
    }

    public void configureInteractions(GestureHandler gestureHandler, ReadableMap readableMap) {
        gestureHandler.setInteractionController(this);
        if (readableMap.hasKey(KEY_WAIT_FOR)) {
            this.mWaitForRelations.put(gestureHandler.getTag(), convertHandlerTagsArray(readableMap, KEY_WAIT_FOR));
        }
        if (readableMap.hasKey(KEY_SIMULTANEOUS_HANDLERS)) {
            this.mSimultaneousRelations.put(gestureHandler.getTag(), convertHandlerTagsArray(readableMap, KEY_SIMULTANEOUS_HANDLERS));
        }
    }

    public boolean shouldWaitForHandlerFailure(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        int[] iArr = (int[]) this.mWaitForRelations.get(gestureHandler.getTag());
        if (iArr != null) {
            for (int i : iArr) {
                if (i == gestureHandler2.getTag()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        int[] iArr = (int[]) this.mSimultaneousRelations.get(gestureHandler.getTag());
        if (iArr != null) {
            for (int i : iArr) {
                if (i == gestureHandler2.getTag()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void reset() {
        this.mWaitForRelations.clear();
        this.mSimultaneousRelations.clear();
    }
}

package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GestureHandlerOrchestrator {
    private static final float DEFAULT_MIN_ALPHA_FOR_TRAVERSAL = 0.0f;
    private static final int SIMULTANEOUS_GESTURE_HANDLER_LIMIT = 20;
    private static final Comparator<GestureHandler> sHandlersComparator = new C67321();
    private static final Matrix sInverseMatrix = new Matrix();
    private static final float[] sMatrixTransformCoords = new float[2];
    private static final float[] sTempCoords = new float[2];
    private static final PointF sTempPoint = new PointF();
    private int mActivationIndex;
    private final GestureHandler[] mAwaitingHandlers;
    private int mAwaitingHandlersCount;
    private boolean mFinishedHandlersCleanupScheduled;
    private final GestureHandler[] mGestureHandlers;
    private int mGestureHandlersCount;
    private final GestureHandlerRegistry mHandlerRegistry;
    private final GestureHandler[] mHandlersToCancel;
    private int mHandlingChangeSemaphore;
    private boolean mIsHandlingTouch;
    private float mMinAlphaForTraversal;
    private final GestureHandler[] mPreparedHandlers;
    private final ViewConfigurationHelper mViewConfigHelper;
    private final ViewGroup mWrapperView;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.gesturehandler.GestureHandlerOrchestrator$1 */
    static class C67321 implements Comparator<GestureHandler> {
        C67321() {
        }

        public int compare(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
            if ((gestureHandler.mIsActive && gestureHandler2.mIsActive) || (gestureHandler.mIsAwaiting && gestureHandler2.mIsAwaiting)) {
                return Integer.signum(gestureHandler2.mActivationIndex - gestureHandler.mActivationIndex);
            }
            if (gestureHandler.mIsActive) {
                return -1;
            }
            if (gestureHandler2.mIsActive) {
                return 1;
            }
            if (gestureHandler.mIsAwaiting != null) {
                return -1;
            }
            if (gestureHandler2.mIsAwaiting != null) {
                return 1;
            }
            return null;
        }
    }

    private static boolean isFinished(int i) {
        return (i == 3 || i == 1) ? true : i == 5;
    }

    public GestureHandlerOrchestrator(ViewGroup viewGroup) {
        this(viewGroup, new GestureHandlerRegistryImpl(), new ViewConfigurationHelperImpl());
    }

    public GestureHandlerOrchestrator(ViewGroup viewGroup, GestureHandlerRegistry gestureHandlerRegistry, ViewConfigurationHelper viewConfigurationHelper) {
        this.mGestureHandlers = new GestureHandler[20];
        this.mAwaitingHandlers = new GestureHandler[20];
        this.mPreparedHandlers = new GestureHandler[20];
        this.mHandlersToCancel = new GestureHandler[20];
        this.mGestureHandlersCount = 0;
        this.mAwaitingHandlersCount = 0;
        this.mIsHandlingTouch = false;
        this.mHandlingChangeSemaphore = 0;
        this.mFinishedHandlersCleanupScheduled = false;
        this.mActivationIndex = 0;
        this.mMinAlphaForTraversal = DEFAULT_MIN_ALPHA_FOR_TRAVERSAL;
        this.mWrapperView = viewGroup;
        this.mHandlerRegistry = gestureHandlerRegistry;
        this.mViewConfigHelper = viewConfigurationHelper;
    }

    public void setMinimumAlphaForTraversal(float f) {
        this.mMinAlphaForTraversal = f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mIsHandlingTouch = true;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 5) {
                if (actionMasked == 3) {
                    cancelAll();
                }
                deliverEventToGestureHandlers(motionEvent);
                this.mIsHandlingTouch = null;
                if (this.mFinishedHandlersCleanupScheduled != null && this.mHandlingChangeSemaphore == null) {
                    cleanupFinishedHandlers();
                }
                return true;
            }
        }
        extractGestureHandlers(motionEvent);
        deliverEventToGestureHandlers(motionEvent);
        this.mIsHandlingTouch = null;
        cleanupFinishedHandlers();
        return true;
    }

    private void scheduleFinishedHandlersCleanup() {
        if (!this.mIsHandlingTouch) {
            if (this.mHandlingChangeSemaphore == 0) {
                cleanupFinishedHandlers();
                return;
            }
        }
        this.mFinishedHandlersCleanupScheduled = true;
    }

    private void cleanupFinishedHandlers() {
        int i;
        Object obj = null;
        for (i = this.mGestureHandlersCount - 1; i >= 0; i--) {
            GestureHandler gestureHandler = this.mGestureHandlers[i];
            if (isFinished(gestureHandler.getState()) && !gestureHandler.mIsAwaiting) {
                this.mGestureHandlers[i] = null;
                gestureHandler.reset();
                gestureHandler.mIsActive = false;
                gestureHandler.mIsAwaiting = false;
                gestureHandler.mActivationIndex = Integer.MAX_VALUE;
                obj = 1;
            }
        }
        if (obj != null) {
            int i2 = 0;
            for (i = 0; i < this.mGestureHandlersCount; i++) {
                if (this.mGestureHandlers[i] != null) {
                    int i3 = i2 + 1;
                    this.mGestureHandlers[i2] = this.mGestureHandlers[i];
                    i2 = i3;
                }
            }
            this.mGestureHandlersCount = i2;
        }
        this.mFinishedHandlersCleanupScheduled = false;
    }

    private boolean hasOtherHandlerToWaitFor(GestureHandler gestureHandler) {
        for (int i = 0; i < this.mGestureHandlersCount; i++) {
            GestureHandler gestureHandler2 = this.mGestureHandlers[i];
            if (!isFinished(gestureHandler2.getState()) && shouldHandlerWaitForOther(gestureHandler, gestureHandler2)) {
                return true;
            }
        }
        return false;
    }

    private void tryActivate(GestureHandler gestureHandler) {
        if (hasOtherHandlerToWaitFor(gestureHandler)) {
            addAwaitingHandler(gestureHandler);
            return;
        }
        makeActive(gestureHandler);
        gestureHandler.mIsAwaiting = false;
    }

    private void cleanupAwaitingHandlers() {
        int i = 0;
        for (int i2 = 0; i2 < this.mAwaitingHandlersCount; i2++) {
            if (this.mAwaitingHandlers[i2].mIsAwaiting) {
                int i3 = i + 1;
                this.mAwaitingHandlers[i] = this.mAwaitingHandlers[i2];
                i = i3;
            }
        }
        this.mAwaitingHandlersCount = i;
    }

    void onHandlerStateChange(GestureHandler gestureHandler, int i, int i2) {
        this.mHandlingChangeSemaphore++;
        if (isFinished(i)) {
            for (int i3 = 0; i3 < this.mAwaitingHandlersCount; i3++) {
                GestureHandler gestureHandler2 = this.mAwaitingHandlers[i3];
                if (shouldHandlerWaitForOther(gestureHandler2, gestureHandler)) {
                    if (i == 5) {
                        gestureHandler2.cancel();
                        gestureHandler2.mIsAwaiting = false;
                    } else {
                        tryActivate(gestureHandler2);
                    }
                }
            }
            cleanupAwaitingHandlers();
        }
        if (i == 4) {
            tryActivate(gestureHandler);
        } else {
            if (i2 != 4) {
                if (i2 != 5) {
                    gestureHandler.dispatchStateChange(i, i2);
                }
            }
            if (gestureHandler.mIsActive) {
                gestureHandler.dispatchStateChange(i, i2);
            }
        }
        this.mHandlingChangeSemaphore--;
        scheduleFinishedHandlersCleanup();
    }

    private void makeActive(GestureHandler gestureHandler) {
        int state = gestureHandler.getState();
        gestureHandler.mIsAwaiting = false;
        gestureHandler.mIsActive = true;
        int i = this.mActivationIndex;
        this.mActivationIndex = i + 1;
        gestureHandler.mActivationIndex = i;
        int i2 = 0;
        for (i = 0; i < this.mGestureHandlersCount; i++) {
            GestureHandler gestureHandler2 = this.mGestureHandlers[i];
            if (shouldHandlerBeCancelledBy(gestureHandler2, gestureHandler)) {
                int i3 = i2 + 1;
                this.mHandlersToCancel[i2] = gestureHandler2;
                i2 = i3;
            }
        }
        for (i2--; i2 >= 0; i2--) {
            this.mHandlersToCancel[i2].cancel();
        }
        for (i = this.mAwaitingHandlersCount - 1; i >= 0; i--) {
            GestureHandler gestureHandler3 = this.mAwaitingHandlers[i];
            if (shouldHandlerBeCancelledBy(gestureHandler3, gestureHandler)) {
                gestureHandler3.cancel();
                gestureHandler3.mIsAwaiting = false;
            }
        }
        cleanupAwaitingHandlers();
        gestureHandler.dispatchStateChange(4, 2);
        if (state != 4) {
            gestureHandler.dispatchStateChange(5, 4);
            if (state != 5) {
                gestureHandler.dispatchStateChange(0, 5);
            }
        }
    }

    public void deliverEventToGestureHandlers(MotionEvent motionEvent) {
        int i = this.mGestureHandlersCount;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            this.mPreparedHandlers[i3] = this.mGestureHandlers[i3];
        }
        Arrays.sort(this.mPreparedHandlers, 0, i, sHandlersComparator);
        while (i2 < i) {
            deliverEventToGestureHandler(this.mPreparedHandlers[i2], motionEvent);
            i2++;
        }
    }

    public GestureHandler getLastActivatedHandler() {
        GestureHandler gestureHandler = null;
        for (int i = 0; i < this.mGestureHandlersCount; i++) {
            GestureHandler gestureHandler2 = this.mGestureHandlers[i];
            if (gestureHandler2.mIsActive && (gestureHandler == null || gestureHandler.mActivationIndex < gestureHandler2.mActivationIndex)) {
                gestureHandler = gestureHandler2;
            }
        }
        return gestureHandler;
    }

    public void cancelAll() {
        int i;
        for (i = this.mAwaitingHandlersCount - 1; i >= 0; i--) {
            this.mAwaitingHandlers[i].cancel();
        }
        i = this.mGestureHandlersCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mPreparedHandlers[i2] = this.mGestureHandlers[i2];
        }
        for (i--; i >= 0; i--) {
            this.mPreparedHandlers[i].cancel();
        }
    }

    private void deliverEventToGestureHandler(GestureHandler gestureHandler, MotionEvent motionEvent) {
        if (gestureHandler.wantEvents()) {
            int actionMasked = motionEvent.getActionMasked();
            if (!gestureHandler.mIsAwaiting || actionMasked != 2) {
                float[] fArr = sTempCoords;
                extractCoordsForView(gestureHandler.getView(), motionEvent, fArr);
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                motionEvent.setLocation(fArr[0], fArr[1]);
                gestureHandler.handle(motionEvent);
                if (gestureHandler.mIsActive) {
                    gestureHandler.dispatchTouchEvent(motionEvent);
                }
                motionEvent.setLocation(x, y);
                if (actionMasked == 1 || actionMasked == 6) {
                    gestureHandler.stopTrackingPointer(motionEvent.getPointerId(motionEvent.getActionIndex()));
                }
            }
        }
    }

    private void extractCoordsForView(View view, MotionEvent motionEvent, float[] fArr) {
        if (view == this.mWrapperView) {
            fArr[0] = motionEvent.getX();
            fArr[1] = motionEvent.getY();
        } else if (view == null || !(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Parent is null? View is no longer in the tree");
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            extractCoordsForView(viewGroup, motionEvent, fArr);
            motionEvent = sTempPoint;
            isTransformedTouchPointInView(fArr[0], fArr[1], viewGroup, view, motionEvent);
            fArr[0] = motionEvent.x;
            fArr[1] = motionEvent.y;
        }
    }

    private void addAwaitingHandler(GestureHandler gestureHandler) {
        int i = 0;
        while (i < this.mAwaitingHandlersCount) {
            if (this.mAwaitingHandlers[i] != gestureHandler) {
                i++;
            } else {
                return;
            }
        }
        if (this.mAwaitingHandlersCount < this.mAwaitingHandlers.length) {
            GestureHandler[] gestureHandlerArr = this.mAwaitingHandlers;
            int i2 = this.mAwaitingHandlersCount;
            this.mAwaitingHandlersCount = i2 + 1;
            gestureHandlerArr[i2] = gestureHandler;
            gestureHandler.mIsAwaiting = true;
            i = this.mActivationIndex;
            this.mActivationIndex = i + 1;
            gestureHandler.mActivationIndex = i;
            return;
        }
        throw new IllegalStateException("Too many recognizers");
    }

    private void recordHandlerIfNotPresent(GestureHandler gestureHandler, View view) {
        int i = 0;
        while (i < this.mGestureHandlersCount) {
            if (this.mGestureHandlers[i] != gestureHandler) {
                i++;
            } else {
                return;
            }
        }
        if (this.mGestureHandlersCount < this.mGestureHandlers.length) {
            GestureHandler[] gestureHandlerArr = this.mGestureHandlers;
            int i2 = this.mGestureHandlersCount;
            this.mGestureHandlersCount = i2 + 1;
            gestureHandlerArr[i2] = gestureHandler;
            gestureHandler.mIsActive = false;
            gestureHandler.mIsAwaiting = false;
            gestureHandler.mActivationIndex = Integer.MAX_VALUE;
            gestureHandler.prepare(view, this);
            return;
        }
        throw new IllegalStateException("Too many recognizers");
    }

    private boolean recordViewHandlersForPointer(View view, float[] fArr, int i) {
        ArrayList handlersForView = this.mHandlerRegistry.getHandlersForView(view);
        if (handlersForView == null) {
            return false;
        }
        int size = handlersForView.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            GestureHandler gestureHandler = (GestureHandler) handlersForView.get(i2);
            if (gestureHandler.isEnabled() && gestureHandler.isWithinBounds(view, fArr[0], fArr[1])) {
                recordHandlerIfNotPresent(gestureHandler, view);
                gestureHandler.startTrackingPointer(i);
                z = true;
            }
        }
        return z;
    }

    private void extractGestureHandlers(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        sTempCoords[0] = motionEvent.getX(actionIndex);
        sTempCoords[1] = motionEvent.getY(actionIndex);
        traverseWithPointerEvents(this.mWrapperView, sTempCoords, pointerId);
        extractGestureHandlers(this.mWrapperView, sTempCoords, pointerId);
    }

    private boolean extractGestureHandlers(ViewGroup viewGroup, float[] fArr, int i) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childInDrawingOrderAtIndex = this.mViewConfigHelper.getChildInDrawingOrderAtIndex(viewGroup, childCount);
            PointF pointF = sTempPoint;
            if (canReceiveEvents(childInDrawingOrderAtIndex) && isTransformedTouchPointInView(fArr[0], fArr[1], viewGroup, childInDrawingOrderAtIndex, pointF)) {
                float f = fArr[0];
                float f2 = fArr[1];
                fArr[0] = pointF.x;
                fArr[1] = pointF.y;
                boolean traverseWithPointerEvents = traverseWithPointerEvents(childInDrawingOrderAtIndex, fArr, i);
                fArr[0] = f;
                fArr[1] = f2;
                if (traverseWithPointerEvents) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean shouldHandlerlessViewBecomeTouchTarget(View view, float[] fArr) {
        if ((view instanceof ViewGroup) != null) {
            if (view.getBackground() == null) {
                return null;
            }
        }
        return true;
    }

    private boolean traverseWithPointerEvents(View view, float[] fArr, int i) {
        PointerEventsConfig pointerEventsConfigForView = this.mViewConfigHelper.getPointerEventsConfigForView(view);
        boolean z = false;
        if (pointerEventsConfigForView == PointerEventsConfig.NONE) {
            return false;
        }
        if (pointerEventsConfigForView == PointerEventsConfig.BOX_ONLY) {
            if (!(recordViewHandlersForPointer(view, fArr, i) == 0 && shouldHandlerlessViewBecomeTouchTarget(view, fArr) == null)) {
                z = true;
            }
            return z;
        } else if (pointerEventsConfigForView == PointerEventsConfig.BOX_NONE) {
            if (view instanceof ViewGroup) {
                return extractGestureHandlers((ViewGroup) view, fArr, i);
            }
            return false;
        } else if (pointerEventsConfigForView == PointerEventsConfig.AUTO) {
            boolean extractGestureHandlers = view instanceof ViewGroup ? extractGestureHandlers((ViewGroup) view, fArr, i) : false;
            if (!(recordViewHandlersForPointer(view, fArr, i) == 0 && !extractGestureHandlers && shouldHandlerlessViewBecomeTouchTarget(view, fArr) == null)) {
                z = true;
            }
            return z;
        } else {
            fArr = new StringBuilder();
            fArr.append("Unknown pointer event type: ");
            fArr.append(pointerEventsConfigForView.toString());
            throw new IllegalArgumentException(fArr.toString());
        }
    }

    private boolean canReceiveEvents(View view) {
        return (view.getVisibility() != 0 || view.getAlpha() < this.mMinAlphaForTraversal) ? null : true;
    }

    private boolean isTransformedTouchPointInView(float f, float f2, ViewGroup viewGroup, View view, PointF pointF) {
        boolean z;
        f = (f + ((float) viewGroup.getScrollX())) - ((float) view.getLeft());
        f2 = (f2 + ((float) viewGroup.getScrollY())) - ((float) view.getTop());
        viewGroup = view.getMatrix();
        if (!viewGroup.isIdentity()) {
            float[] fArr = sMatrixTransformCoords;
            fArr[0] = f;
            fArr[1] = f2;
            f = sInverseMatrix;
            viewGroup.invert(f);
            f.mapPoints(fArr);
            f = fArr[0];
            f2 = fArr[1];
        }
        pointF.set(f, f2);
        viewGroup = this.mHandlerRegistry.getHandlersForView(view);
        if (viewGroup != null) {
            pointF = viewGroup.size();
            z = false;
            int i = 0;
            while (!z && i < pointF) {
                z = ((GestureHandler) viewGroup.get(i)).isWithinBounds(view, f, f2);
                i++;
            }
        } else {
            z = false;
        }
        if (z) {
            return z;
        }
        return f >= DEFAULT_MIN_ALPHA_FOR_TRAVERSAL && f <= ((float) view.getWidth()) && f2 >= DEFAULT_MIN_ALPHA_FOR_TRAVERSAL && f2 < ((float) view.getHeight());
    }

    private static boolean shouldHandlerWaitForOther(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        return (gestureHandler == gestureHandler2 || (!gestureHandler.shouldWaitForHandlerFailure(gestureHandler2) && gestureHandler2.shouldRequireToWaitForFailure(gestureHandler) == null)) ? null : true;
    }

    private static boolean canRunSimultaneously(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        if (!(gestureHandler == gestureHandler2 || gestureHandler.shouldRecognizeSimultaneously(gestureHandler2))) {
            if (gestureHandler2.shouldRecognizeSimultaneously(gestureHandler) == null) {
                return null;
            }
        }
        return true;
    }

    private static boolean shouldHandlerBeCancelledBy(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        if (gestureHandler.hasCommonPointers(gestureHandler2) && !canRunSimultaneously(gestureHandler, gestureHandler2)) {
            return (gestureHandler == gestureHandler2 || !(gestureHandler.mIsAwaiting || gestureHandler.getState() == 4)) ? true : gestureHandler.shouldBeCancelledBy(gestureHandler2);
        } else {
            return false;
        }
    }
}

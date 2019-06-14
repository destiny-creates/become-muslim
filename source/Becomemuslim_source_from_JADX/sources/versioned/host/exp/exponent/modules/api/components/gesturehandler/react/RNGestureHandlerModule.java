package versioned.host.exp.exponent.modules.api.components.gesturehandler.react;

import android.content.Context;
import android.view.MotionEvent;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.FlingGestureHandler;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.GestureHandler;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.LongPressGestureHandler;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.NativeViewGestureHandler;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.OnTouchEventListener;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.PanGestureHandler;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.PinchGestureHandler;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.RotationGestureHandler;
import versioned.host.exp.exponent.modules.api.components.gesturehandler.TapGestureHandler;

@ReactModule(name = "RNGestureHandlerModule")
public class RNGestureHandlerModule extends ReactContextBaseJavaModule {
    private static final String KEY_DIRECTION = "direction";
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_HIT_SLOP = "hitSlop";
    private static final String KEY_HIT_SLOP_BOTTOM = "bottom";
    private static final String KEY_HIT_SLOP_HEIGHT = "height";
    private static final String KEY_HIT_SLOP_HORIZONTAL = "horizontal";
    private static final String KEY_HIT_SLOP_LEFT = "left";
    private static final String KEY_HIT_SLOP_RIGHT = "right";
    private static final String KEY_HIT_SLOP_TOP = "top";
    private static final String KEY_HIT_SLOP_VERTICAL = "vertical";
    private static final String KEY_HIT_SLOP_WIDTH = "width";
    private static final String KEY_LONG_PRESS_MAX_DIST = "maxDist";
    private static final String KEY_LONG_PRESS_MIN_DURATION_MS = "minDurationMs";
    private static final String KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION = "disallowInterruption";
    private static final String KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START = "shouldActivateOnStart";
    private static final String KEY_NUMBER_OF_POINTERS = "numberOfPointers";
    private static final String KEY_PAN_ACTIVE_OFFSET_X_END = "activeOffsetXEnd";
    private static final String KEY_PAN_ACTIVE_OFFSET_X_START = "activeOffsetXStart";
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_END = "activeOffsetYEnd";
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_START = "activeOffsetYStart";
    private static final String KEY_PAN_AVG_TOUCHES = "avgTouches";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_END = "failOffsetXEnd";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_START = "failOffsetXStart";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_END = "failOffsetYEnd";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_START = "failOffsetYStart";
    private static final String KEY_PAN_MAX_POINTERS = "maxPointers";
    private static final String KEY_PAN_MIN_DIST = "minDist";
    private static final String KEY_PAN_MIN_POINTERS = "minPointers";
    private static final String KEY_PAN_MIN_VELOCITY = "minVelocity";
    private static final String KEY_PAN_MIN_VELOCITY_X = "minVelocityX";
    private static final String KEY_PAN_MIN_VELOCITY_Y = "minVelocityY";
    private static final String KEY_SHOULD_CANCEL_WHEN_OUTSIDE = "shouldCancelWhenOutside";
    private static final String KEY_TAP_MAX_DELAY_MS = "maxDelayMs";
    private static final String KEY_TAP_MAX_DELTA_X = "maxDeltaX";
    private static final String KEY_TAP_MAX_DELTA_Y = "maxDeltaY";
    private static final String KEY_TAP_MAX_DIST = "maxDist";
    private static final String KEY_TAP_MAX_DURATION_MS = "maxDurationMs";
    private static final String KEY_TAP_MIN_POINTERS = "minPointers";
    private static final String KEY_TAP_NUMBER_OF_TAPS = "numberOfTaps";
    public static final String MODULE_NAME = "RNGestureHandlerModule";
    private List<Integer> mEnqueuedRootViewInit = new ArrayList();
    private OnTouchEventListener mEventListener = new C77701();
    private HandlerFactory[] mHandlerFactories = new HandlerFactory[]{new NativeViewGestureHandlerFactory(), new TapGestureHandlerFactory(), new LongPressGestureHandlerFactory(), new PanGestureHandlerFactory(), new PinchGestureHandlerFactory(), new RotationGestureHandlerFactory(), new FlingGestureHandlerFactory()};
    private RNGestureHandlerInteractionManager mInteractionManager = new RNGestureHandlerInteractionManager();
    private final RNGestureHandlerRegistry mRegistry = new RNGestureHandlerRegistry();
    private List<RNGestureHandlerRootHelper> mRoots = new ArrayList();

    /* renamed from: versioned.host.exp.exponent.modules.api.components.gesturehandler.react.RNGestureHandlerModule$1 */
    class C77701 implements OnTouchEventListener {
        C77701() {
        }

        public void onTouchEvent(GestureHandler gestureHandler, MotionEvent motionEvent) {
            RNGestureHandlerModule.this.onTouchEvent(gestureHandler, motionEvent);
        }

        public void onStateChange(GestureHandler gestureHandler, int i, int i2) {
            RNGestureHandlerModule.this.onStateChange(gestureHandler, i, i2);
        }
    }

    private static abstract class HandlerFactory<T extends GestureHandler> implements RNGestureHandlerEventDataExtractor<T> {
        public abstract T create(Context context);

        public abstract String getName();

        public abstract Class<T> getType();

        private HandlerFactory() {
        }

        public void configure(T t, ReadableMap readableMap) {
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE)) {
                t.setShouldCancelWhenOutside(readableMap.getBoolean(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE));
            }
            if (readableMap.hasKey("enabled")) {
                t.setEnabled(readableMap.getBoolean("enabled"));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP)) {
                RNGestureHandlerModule.handleHitSlopProperty(t, readableMap);
            }
        }

        public void extractEventData(T t, WritableMap writableMap) {
            writableMap.putDouble(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS, (double) t.getNumberOfPointers());
        }
    }

    private static class FlingGestureHandlerFactory extends HandlerFactory<FlingGestureHandler> {
        public String getName() {
            return "FlingGestureHandler";
        }

        private FlingGestureHandlerFactory() {
            super();
        }

        public Class<FlingGestureHandler> getType() {
            return FlingGestureHandler.class;
        }

        public FlingGestureHandler create(Context context) {
            return new FlingGestureHandler();
        }

        public void configure(FlingGestureHandler flingGestureHandler, ReadableMap readableMap) {
            super.configure(flingGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS)) {
                flingGestureHandler.setNumberOfPointersRequired(readableMap.getInt(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_DIRECTION)) {
                flingGestureHandler.setDirection(readableMap.getInt(RNGestureHandlerModule.KEY_DIRECTION));
            }
        }

        public void extractEventData(FlingGestureHandler flingGestureHandler, WritableMap writableMap) {
            super.extractEventData(flingGestureHandler, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(flingGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(flingGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(flingGestureHandler.getLastAbsolutePositionX()));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(flingGestureHandler.getLastAbsolutePositionY()));
        }
    }

    private static class LongPressGestureHandlerFactory extends HandlerFactory<LongPressGestureHandler> {
        public String getName() {
            return "LongPressGestureHandler";
        }

        private LongPressGestureHandlerFactory() {
            super();
        }

        public Class<LongPressGestureHandler> getType() {
            return LongPressGestureHandler.class;
        }

        public LongPressGestureHandler create(Context context) {
            return new LongPressGestureHandler(context);
        }

        public void configure(LongPressGestureHandler longPressGestureHandler, ReadableMap readableMap) {
            super.configure(longPressGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS)) {
                longPressGestureHandler.setMinDurationMs((long) readableMap.getInt(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS));
            }
            if (readableMap.hasKey("maxDist")) {
                longPressGestureHandler.setMaxDist(PixelUtil.toPixelFromDIP(readableMap.getDouble("maxDist")));
            }
        }

        public void extractEventData(LongPressGestureHandler longPressGestureHandler, WritableMap writableMap) {
            super.extractEventData(longPressGestureHandler, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.getLastAbsolutePositionX()));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(longPressGestureHandler.getLastAbsolutePositionY()));
        }
    }

    private static class NativeViewGestureHandlerFactory extends HandlerFactory<NativeViewGestureHandler> {
        public String getName() {
            return "NativeViewGestureHandler";
        }

        private NativeViewGestureHandlerFactory() {
            super();
        }

        public Class<NativeViewGestureHandler> getType() {
            return NativeViewGestureHandler.class;
        }

        public NativeViewGestureHandler create(Context context) {
            return new NativeViewGestureHandler();
        }

        public void configure(NativeViewGestureHandler nativeViewGestureHandler, ReadableMap readableMap) {
            super.configure(nativeViewGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START)) {
                nativeViewGestureHandler.setShouldActivateOnStart(readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION)) {
                nativeViewGestureHandler.setDisallowInterruption(readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION));
            }
        }

        public void extractEventData(NativeViewGestureHandler nativeViewGestureHandler, WritableMap writableMap) {
            super.extractEventData(nativeViewGestureHandler, writableMap);
            writableMap.putBoolean("pointerInside", nativeViewGestureHandler.isWithinBounds());
        }
    }

    private static class PanGestureHandlerFactory extends HandlerFactory<PanGestureHandler> {
        public String getName() {
            return "PanGestureHandler";
        }

        private PanGestureHandlerFactory() {
            super();
        }

        public Class<PanGestureHandler> getType() {
            return PanGestureHandler.class;
        }

        public PanGestureHandler create(Context context) {
            return new PanGestureHandler(context);
        }

        public void configure(PanGestureHandler panGestureHandler, ReadableMap readableMap) {
            Object obj;
            super.configure(panGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)) {
                panGestureHandler.setActiveOffsetXStart(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)));
                obj = 1;
            } else {
                obj = null;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)) {
                panGestureHandler.setActiveOffsetXEnd(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)));
                obj = 1;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)) {
                panGestureHandler.setFailOffsetXStart(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)));
                obj = 1;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)) {
                panGestureHandler.setFailOffsetXEnd(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)));
                obj = 1;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)) {
                panGestureHandler.setActiveOffsetYStart(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)));
                obj = 1;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)) {
                panGestureHandler.setActiveOffsetYEnd(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)));
                obj = 1;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)) {
                panGestureHandler.setFailOffsetYStart(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)));
                obj = 1;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)) {
                panGestureHandler.setFailOffsetYEnd(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)));
                obj = 1;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)) {
                panGestureHandler.setMinVelocity(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)));
                obj = 1;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)) {
                panGestureHandler.setMinVelocityX(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)));
                obj = 1;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)) {
                panGestureHandler.setMinVelocityY(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)));
                obj = 1;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_DIST)) {
                panGestureHandler.setMinDist(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_DIST)));
            } else if (obj != null) {
                panGestureHandler.setMinDist(Float.MAX_VALUE);
            }
            if (readableMap.hasKey("minPointers")) {
                panGestureHandler.setMinPointers(readableMap.getInt("minPointers"));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS)) {
                panGestureHandler.setMaxPointers(readableMap.getInt(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES)) {
                panGestureHandler.setAverageTouches(readableMap.getBoolean(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES));
            }
        }

        public void extractEventData(PanGestureHandler panGestureHandler, WritableMap writableMap) {
            super.extractEventData(panGestureHandler, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getLastAbsolutePositionX()));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getLastAbsolutePositionY()));
            writableMap.putDouble("translationX", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getTranslationX()));
            writableMap.putDouble("translationY", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getTranslationY()));
            writableMap.putDouble("velocityX", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getVelocityX()));
            writableMap.putDouble("velocityY", (double) PixelUtil.toDIPFromPixel(panGestureHandler.getVelocityY()));
        }
    }

    private static class PinchGestureHandlerFactory extends HandlerFactory<PinchGestureHandler> {
        public String getName() {
            return "PinchGestureHandler";
        }

        private PinchGestureHandlerFactory() {
            super();
        }

        public Class<PinchGestureHandler> getType() {
            return PinchGestureHandler.class;
        }

        public PinchGestureHandler create(Context context) {
            return new PinchGestureHandler();
        }

        public void extractEventData(PinchGestureHandler pinchGestureHandler, WritableMap writableMap) {
            super.extractEventData(pinchGestureHandler, writableMap);
            writableMap.putDouble("scale", pinchGestureHandler.getScale());
            writableMap.putDouble("focalX", (double) PixelUtil.toDIPFromPixel(pinchGestureHandler.getFocalPointX()));
            writableMap.putDouble("focalY", (double) PixelUtil.toDIPFromPixel(pinchGestureHandler.getFocalPointY()));
            writableMap.putDouble("velocity", pinchGestureHandler.getVelocity());
        }
    }

    private static class RotationGestureHandlerFactory extends HandlerFactory<RotationGestureHandler> {
        public String getName() {
            return "RotationGestureHandler";
        }

        private RotationGestureHandlerFactory() {
            super();
        }

        public Class<RotationGestureHandler> getType() {
            return RotationGestureHandler.class;
        }

        public RotationGestureHandler create(Context context) {
            return new RotationGestureHandler();
        }

        public void extractEventData(RotationGestureHandler rotationGestureHandler, WritableMap writableMap) {
            super.extractEventData(rotationGestureHandler, writableMap);
            writableMap.putDouble("rotation", rotationGestureHandler.getRotation());
            writableMap.putDouble("anchorX", (double) PixelUtil.toDIPFromPixel(rotationGestureHandler.getAnchorX()));
            writableMap.putDouble("anchorY", (double) PixelUtil.toDIPFromPixel(rotationGestureHandler.getAnchorY()));
            writableMap.putDouble("velocity", rotationGestureHandler.getVelocity());
        }
    }

    private static class TapGestureHandlerFactory extends HandlerFactory<TapGestureHandler> {
        public String getName() {
            return "TapGestureHandler";
        }

        private TapGestureHandlerFactory() {
            super();
        }

        public Class<TapGestureHandler> getType() {
            return TapGestureHandler.class;
        }

        public TapGestureHandler create(Context context) {
            return new TapGestureHandler();
        }

        public void configure(TapGestureHandler tapGestureHandler, ReadableMap readableMap) {
            super.configure(tapGestureHandler, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS)) {
                tapGestureHandler.setNumberOfTaps(readableMap.getInt(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS)) {
                tapGestureHandler.setMaxDurationMs((long) readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS)) {
                tapGestureHandler.setMaxDelayMs((long) readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)) {
                tapGestureHandler.setMaxDx(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)) {
                tapGestureHandler.setMaxDy(PixelUtil.toPixelFromDIP(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)));
            }
            if (readableMap.hasKey("maxDist")) {
                tapGestureHandler.setMaxDist(PixelUtil.toPixelFromDIP(readableMap.getDouble("maxDist")));
            }
            if (readableMap.hasKey("minPointers")) {
                tapGestureHandler.setMinNumberOfPointers(readableMap.getInt("minPointers"));
            }
        }

        public void extractEventData(TapGestureHandler tapGestureHandler, WritableMap writableMap) {
            super.extractEventData(tapGestureHandler, writableMap);
            writableMap.putDouble("x", (double) PixelUtil.toDIPFromPixel(tapGestureHandler.getLastRelativePositionX()));
            writableMap.putDouble("y", (double) PixelUtil.toDIPFromPixel(tapGestureHandler.getLastRelativePositionY()));
            writableMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(tapGestureHandler.getLastAbsolutePositionX()));
            writableMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(tapGestureHandler.getLastAbsolutePositionY()));
        }
    }

    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public void handleClearJSResponder() {
    }

    public RNGestureHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void createGestureHandler(String str, int i, ReadableMap readableMap) {
        for (HandlerFactory handlerFactory : this.mHandlerFactories) {
            if (handlerFactory.getName().equals(str)) {
                str = handlerFactory.create(getReactApplicationContext());
                str.setTag(i);
                str.setOnTouchEventListener(this.mEventListener);
                this.mRegistry.registerHandler(str);
                this.mInteractionManager.configureInteractions(str, readableMap);
                handlerFactory.configure(str, readableMap);
                return;
            }
        }
        readableMap = new StringBuilder();
        readableMap.append("Invalid handler name ");
        readableMap.append(str);
        throw new JSApplicationIllegalArgumentException(readableMap.toString());
    }

    @ReactMethod
    public void attachGestureHandler(int i, int i2) {
        tryInitializeHandlerForReactRootView(i2);
        if (this.mRegistry.attachHandlerToView(i, i2) == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Handler with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
    }

    @ReactMethod
    public void updateGestureHandler(int i, ReadableMap readableMap) {
        GestureHandler handler = this.mRegistry.getHandler(i);
        if (handler != null) {
            HandlerFactory findFactoryForHandler = findFactoryForHandler(handler);
            if (findFactoryForHandler != null) {
                this.mInteractionManager.dropRelationsForHandlerWithTag(i);
                this.mInteractionManager.configureInteractions(handler, readableMap);
                findFactoryForHandler.configure(handler, readableMap);
            }
        }
    }

    @ReactMethod
    public void dropGestureHandler(int i) {
        this.mInteractionManager.dropRelationsForHandlerWithTag(i);
        this.mRegistry.dropHandler(i);
    }

    @ReactMethod
    public void handleSetJSResponder(int i, boolean z) {
        if (this.mRegistry != null) {
            RNGestureHandlerRootHelper findRootHelperForViewAncestor = findRootHelperForViewAncestor(i);
            if (findRootHelperForViewAncestor != null) {
                findRootHelperForViewAncestor.handleSetJSResponder(i, z);
            }
        }
    }

    public Map getConstants() {
        return MapBuilder.of("State", MapBuilder.of("UNDETERMINED", Integer.valueOf(0), "BEGAN", Integer.valueOf(2), "ACTIVE", Integer.valueOf(4), "CANCELLED", Integer.valueOf(3), "FAILED", Integer.valueOf(1), "END", Integer.valueOf(5)), "Direction", MapBuilder.of("RIGHT", Integer.valueOf(1), "LEFT", Integer.valueOf(2), "UP", Integer.valueOf(4), "DOWN", Integer.valueOf(8)));
    }

    public RNGestureHandlerRegistry getRegistry() {
        return this.mRegistry;
    }

    public void onCatalystInstanceDestroy() {
        this.mRegistry.dropAllHandlers();
        this.mInteractionManager.reset();
        synchronized (this.mRoots) {
            while (!this.mRoots.isEmpty()) {
                int size = this.mRoots.size();
                RNGestureHandlerRootHelper rNGestureHandlerRootHelper = (RNGestureHandlerRootHelper) this.mRoots.get(0);
                ReactRootView rootView = rNGestureHandlerRootHelper.getRootView();
                if (rootView instanceof RNGestureHandlerEnabledRootView) {
                    ((RNGestureHandlerEnabledRootView) rootView).tearDown();
                } else {
                    rNGestureHandlerRootHelper.tearDown();
                }
                if (this.mRoots.size() >= size) {
                    throw new IllegalStateException("Expected root helper to get unregistered while tearing down");
                }
            }
        }
        super.onCatalystInstanceDestroy();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void tryInitializeHandlerForReactRootView(int r5) {
        /*
        r4 = this;
        r0 = r4.getReactApplicationContext();
        r1 = com.facebook.react.uimanager.UIManagerModule.class;
        r0 = r0.getNativeModule(r1);
        r0 = (com.facebook.react.uimanager.UIManagerModule) r0;
        r1 = r0.resolveRootTagFromReactTag(r5);
        r2 = 1;
        if (r1 < r2) goto L_0x0061;
    L_0x0013:
        r2 = r4.mRoots;
        monitor-enter(r2);
        r5 = 0;
    L_0x0017:
        r3 = r4.mRoots;	 Catch:{ all -> 0x005e }
        r3 = r3.size();	 Catch:{ all -> 0x005e }
        if (r5 >= r3) goto L_0x0036;
    L_0x001f:
        r3 = r4.mRoots;	 Catch:{ all -> 0x005e }
        r3 = r3.get(r5);	 Catch:{ all -> 0x005e }
        r3 = (versioned.host.exp.exponent.modules.api.components.gesturehandler.react.RNGestureHandlerRootHelper) r3;	 Catch:{ all -> 0x005e }
        r3 = r3.getRootView();	 Catch:{ all -> 0x005e }
        r3 = r3.getRootViewTag();	 Catch:{ all -> 0x005e }
        if (r3 != r1) goto L_0x0033;
    L_0x0031:
        monitor-exit(r2);	 Catch:{ all -> 0x005e }
        return;
    L_0x0033:
        r5 = r5 + 1;
        goto L_0x0017;
    L_0x0036:
        monitor-exit(r2);	 Catch:{ all -> 0x005e }
        r5 = r4.mEnqueuedRootViewInit;
        monitor-enter(r5);
        r2 = r4.mEnqueuedRootViewInit;	 Catch:{ all -> 0x005b }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x005b }
        r2 = r2.contains(r3);	 Catch:{ all -> 0x005b }
        if (r2 == 0) goto L_0x0048;
    L_0x0046:
        monitor-exit(r5);	 Catch:{ all -> 0x005b }
        return;
    L_0x0048:
        r2 = r4.mEnqueuedRootViewInit;	 Catch:{ all -> 0x005b }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x005b }
        r2.add(r3);	 Catch:{ all -> 0x005b }
        monitor-exit(r5);	 Catch:{ all -> 0x005b }
        r5 = new versioned.host.exp.exponent.modules.api.components.gesturehandler.react.RNGestureHandlerModule$2;
        r5.<init>(r1);
        r0.addUIBlock(r5);
        return;
    L_0x005b:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x005b }
        throw r0;
    L_0x005e:
        r5 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x005e }
        throw r5;
    L_0x0061:
        r0 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Could find root view for a given ancestor with tag ";
        r1.append(r2);
        r1.append(r5);
        r5 = r1.toString();
        r0.<init>(r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.components.gesturehandler.react.RNGestureHandlerModule.tryInitializeHandlerForReactRootView(int):void");
    }

    public void registerRootHelper(RNGestureHandlerRootHelper rNGestureHandlerRootHelper) {
        synchronized (this.mRoots) {
            if (this.mRoots.contains(rNGestureHandlerRootHelper)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Root helper");
                stringBuilder.append(rNGestureHandlerRootHelper);
                stringBuilder.append(" already registered");
                throw new IllegalStateException(stringBuilder.toString());
            }
            this.mRoots.add(rNGestureHandlerRootHelper);
        }
    }

    public void unregisterRootHelper(RNGestureHandlerRootHelper rNGestureHandlerRootHelper) {
        synchronized (this.mRoots) {
            this.mRoots.remove(rNGestureHandlerRootHelper);
        }
    }

    private RNGestureHandlerRootHelper findRootHelperForViewAncestor(int i) {
        i = ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).resolveRootTagFromReactTag(i);
        if (i < 1) {
            return null;
        }
        synchronized (this.mRoots) {
            for (int i2 = 0; i2 < this.mRoots.size(); i2++) {
                RNGestureHandlerRootHelper rNGestureHandlerRootHelper = (RNGestureHandlerRootHelper) this.mRoots.get(i2);
                if (rNGestureHandlerRootHelper.getRootView().getRootViewTag() == i) {
                    return rNGestureHandlerRootHelper;
                }
            }
            return null;
        }
    }

    private HandlerFactory findFactoryForHandler(GestureHandler gestureHandler) {
        for (HandlerFactory handlerFactory : this.mHandlerFactories) {
            if (handlerFactory.getType().equals(gestureHandler.getClass())) {
                return handlerFactory;
            }
        }
        return null;
    }

    private void onTouchEvent(GestureHandler gestureHandler, MotionEvent motionEvent) {
        if (gestureHandler.getTag() >= null && gestureHandler.getState() == 4) {
            ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(RNGestureHandlerEvent.obtain(gestureHandler, findFactoryForHandler(gestureHandler)));
        }
    }

    private void onStateChange(GestureHandler gestureHandler, int i, int i2) {
        if (gestureHandler.getTag() >= 0) {
            ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(RNGestureHandlerStateChangeEvent.obtain(gestureHandler, i, i2, findFactoryForHandler(gestureHandler)));
        }
    }

    private static void handleHitSlopProperty(GestureHandler gestureHandler, ReadableMap readableMap) {
        if (readableMap.getType(KEY_HIT_SLOP) == ReadableType.Number) {
            float toPixelFromDIP = PixelUtil.toPixelFromDIP(readableMap.getDouble(KEY_HIT_SLOP));
            gestureHandler.setHitSlop(toPixelFromDIP, toPixelFromDIP, toPixelFromDIP, toPixelFromDIP, Float.NaN, Float.NaN);
            return;
        }
        float toPixelFromDIP2;
        float f;
        float toPixelFromDIP3;
        float f2;
        readableMap = readableMap.getMap(KEY_HIT_SLOP);
        if (readableMap.hasKey("horizontal")) {
            toPixelFromDIP2 = PixelUtil.toPixelFromDIP(readableMap.getDouble("horizontal"));
            f = toPixelFromDIP2;
        } else {
            toPixelFromDIP2 = Float.NaN;
            f = Float.NaN;
        }
        if (readableMap.hasKey(KEY_HIT_SLOP_VERTICAL)) {
            toPixelFromDIP3 = PixelUtil.toPixelFromDIP(readableMap.getDouble(KEY_HIT_SLOP_VERTICAL));
            f2 = toPixelFromDIP3;
        } else {
            toPixelFromDIP3 = Float.NaN;
            f2 = Float.NaN;
        }
        if (readableMap.hasKey("left")) {
            toPixelFromDIP2 = PixelUtil.toPixelFromDIP(readableMap.getDouble("left"));
        }
        toPixelFromDIP = toPixelFromDIP2;
        if (readableMap.hasKey("top")) {
            toPixelFromDIP3 = PixelUtil.toPixelFromDIP(readableMap.getDouble("top"));
        }
        float f3 = toPixelFromDIP3;
        if (readableMap.hasKey("right")) {
            f = PixelUtil.toPixelFromDIP(readableMap.getDouble("right"));
        }
        float f4 = f;
        if (readableMap.hasKey("bottom")) {
            f2 = PixelUtil.toPixelFromDIP(readableMap.getDouble("bottom"));
        }
        gestureHandler.setHitSlop(toPixelFromDIP, f3, f4, f2, readableMap.hasKey("width") ? PixelUtil.toPixelFromDIP(readableMap.getDouble("width")) : Float.NaN, readableMap.hasKey("height") ? PixelUtil.toPixelFromDIP(readableMap.getDouble("height")) : Float.NaN);
    }
}

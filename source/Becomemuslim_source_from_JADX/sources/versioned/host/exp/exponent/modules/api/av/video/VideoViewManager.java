package versioned.host.exp.exponent.modules.api.av.video;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.p082f.p083a.C1252b;
import java.util.Map;

public class VideoViewManager extends SimpleViewManager<VideoViewWrapper> {
    private static final String PROP_NATIVE_RESIZE_MODE = "nativeResizeMode";
    private static final String PROP_SOURCE = "source";
    private static final String PROP_STATUS = "status";
    private static final String PROP_USE_NATIVE_CONTROLS = "useNativeControls";
    public static final String REACT_CLASS = "ExponentVideo";

    enum Events {
        EVENT_STATUS_UPDATE("onStatusUpdateNative"),
        EVENT_LOAD_START("onLoadStartNative"),
        EVENT_LOAD("onLoadNative"),
        EVENT_ERROR("onErrorNative"),
        EVENT_READY_FOR_DISPLAY("onReadyForDisplayNative"),
        EVENT_FULLSCREEN_PLAYER_UPDATE("onFullscreenUpdateNative");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    enum FullscreenPlayerUpdate {
        FULLSCREEN_PLAYER_WILL_PRESENT(0),
        FULLSCREEN_PLAYER_DID_PRESENT(1),
        FULLSCREEN_PLAYER_WILL_DISMISS(2),
        FULLSCREEN_PLAYER_DID_DISMISS(3);
        
        private final int mValue;

        private FullscreenPlayerUpdate(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public String getName() {
        return REACT_CLASS;
    }

    protected VideoViewWrapper createViewInstance(ThemedReactContext themedReactContext) {
        return new VideoViewWrapper(themedReactContext);
    }

    public void onDropViewInstance(VideoViewWrapper videoViewWrapper) {
        super.onDropViewInstance(videoViewWrapper);
        videoViewWrapper.getVideoViewInstance().onDropViewInstance();
    }

    public Map<String, Object> getExportedViewConstants() {
        return MapBuilder.of("ScaleNone", Integer.toString(C1252b.LEFT_TOP.ordinal()), "ScaleToFill", Integer.toString(C1252b.FIT_XY.ordinal()), "ScaleAspectFit", Integer.toString(C1252b.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.toString(C1252b.CENTER_CROP.ordinal()));
    }

    @ReactProp(name = "status")
    public void setStatus(VideoViewWrapper videoViewWrapper, ReadableMap readableMap) {
        videoViewWrapper.getVideoViewInstance().setStatus(readableMap, null);
    }

    @ReactProp(defaultBoolean = false, name = "useNativeControls")
    public void setUseNativeControls(VideoViewWrapper videoViewWrapper, boolean z) {
        videoViewWrapper.getVideoViewInstance().setUseNativeControls(z);
    }

    @ReactProp(name = "source")
    public void setSource(VideoViewWrapper videoViewWrapper, ReadableMap readableMap) {
        videoViewWrapper.getVideoViewInstance().setSource(readableMap, null, null);
    }

    @ReactProp(defaultBoolean = false, name = "nativeResizeMode")
    public void setNativeResizeMode(VideoViewWrapper videoViewWrapper, String str) {
        videoViewWrapper.getVideoViewInstance().setResizeMode(C1252b.values()[Integer.parseInt(str)]);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Builder builder = MapBuilder.builder();
        for (Events events : Events.values()) {
            builder.put(events.toString(), MapBuilder.of("registrationName", events.toString()));
        }
        return builder.build();
    }
}

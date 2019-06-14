package com.facebook.react.views.swiperefresh;

import android.support.v4.widget.C3244q.C0571b;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Map;

@ReactModule(name = "AndroidSwipeRefreshLayout")
public class SwipeRefreshLayoutManager extends ViewGroupManager<ReactSwipeRefreshLayout> {
    protected static final String REACT_CLASS = "AndroidSwipeRefreshLayout";

    public String getName() {
        return REACT_CLASS;
    }

    protected ReactSwipeRefreshLayout createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactSwipeRefreshLayout(themedReactContext);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z) {
        reactSwipeRefreshLayout.setEnabled(z);
    }

    @ReactProp(customType = "ColorArray", name = "colors")
    public void setColors(ReactSwipeRefreshLayout reactSwipeRefreshLayout, ReadableArray readableArray) {
        int i = 0;
        if (readableArray != null) {
            int[] iArr = new int[readableArray.size()];
            while (i < readableArray.size()) {
                iArr[i] = readableArray.getInt(i);
                i++;
            }
            reactSwipeRefreshLayout.setColorSchemeColors(iArr);
            return;
        }
        reactSwipeRefreshLayout.setColorSchemeColors(new int[0]);
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "progressBackgroundColor")
    public void setProgressBackgroundColor(ReactSwipeRefreshLayout reactSwipeRefreshLayout, int i) {
        reactSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(i);
    }

    @ReactProp(defaultInt = 1, name = "size")
    public void setSize(ReactSwipeRefreshLayout reactSwipeRefreshLayout, int i) {
        reactSwipeRefreshLayout.setSize(i);
    }

    @ReactProp(name = "refreshing")
    public void setRefreshing(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z) {
        reactSwipeRefreshLayout.setRefreshing(z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "progressViewOffset")
    public void setProgressViewOffset(ReactSwipeRefreshLayout reactSwipeRefreshLayout, float f) {
        reactSwipeRefreshLayout.setProgressViewOffset(f);
    }

    protected void addEventEmitters(final ThemedReactContext themedReactContext, final ReactSwipeRefreshLayout reactSwipeRefreshLayout) {
        reactSwipeRefreshLayout.setOnRefreshListener(new C0571b() {
            public void onRefresh() {
                ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new RefreshEvent(reactSwipeRefreshLayout.getId()));
            }
        });
    }

    public Map<String, Object> getExportedViewConstants() {
        return MapBuilder.of("SIZE", MapBuilder.of(MessengerShareContentUtility.PREVIEW_DEFAULT, Integer.valueOf(1), "LARGE", Integer.valueOf(0)));
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("topRefresh", MapBuilder.of("registrationName", "onRefresh")).build();
    }
}

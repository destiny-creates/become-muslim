package com.facebook.react.views.drawer;

import android.os.Build.VERSION;
import android.support.v4.widget.C0553i;
import android.support.v4.widget.C0553i.C0549c;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.drawer.events.DrawerClosedEvent;
import com.facebook.react.views.drawer.events.DrawerOpenedEvent;
import com.facebook.react.views.drawer.events.DrawerSlideEvent;
import com.facebook.react.views.drawer.events.DrawerStateChangedEvent;
import java.util.Map;

@ReactModule(name = "AndroidDrawerLayout")
public class ReactDrawerLayoutManager extends ViewGroupManager<ReactDrawerLayout> {
    public static final int CLOSE_DRAWER = 2;
    public static final int OPEN_DRAWER = 1;
    protected static final String REACT_CLASS = "AndroidDrawerLayout";

    public static class DrawerEventEmitter implements C0549c {
        private final C0553i mDrawerLayout;
        private final EventDispatcher mEventDispatcher;

        public DrawerEventEmitter(C0553i c0553i, EventDispatcher eventDispatcher) {
            this.mDrawerLayout = c0553i;
            this.mEventDispatcher = eventDispatcher;
        }

        public void onDrawerSlide(View view, float f) {
            this.mEventDispatcher.dispatchEvent(new DrawerSlideEvent(this.mDrawerLayout.getId(), f));
        }

        public void onDrawerOpened(View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerOpenedEvent(this.mDrawerLayout.getId()));
        }

        public void onDrawerClosed(View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerClosedEvent(this.mDrawerLayout.getId()));
        }

        public void onDrawerStateChanged(int i) {
            this.mEventDispatcher.dispatchEvent(new DrawerStateChangedEvent(this.mDrawerLayout.getId(), i));
        }
    }

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    protected void addEventEmitters(ThemedReactContext themedReactContext, ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.setDrawerListener(new DrawerEventEmitter(reactDrawerLayout, ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher()));
    }

    protected ReactDrawerLayout createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactDrawerLayout(themedReactContext);
    }

    @ReactProp(defaultInt = 8388611, name = "drawerPosition")
    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, int i) {
        if (8388611 != i) {
            if (8388613 != i) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown drawerPosition ");
                stringBuilder.append(i);
                throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
        reactDrawerLayout.setDrawerPosition(i);
    }

    @ReactProp(defaultFloat = Float.NaN, name = "drawerWidth")
    public void getDrawerWidth(ReactDrawerLayout reactDrawerLayout, float f) {
        if (Float.isNaN(f)) {
            f = Float.NaN;
        } else {
            f = Math.round(PixelUtil.toPixelFromDIP(f));
        }
        reactDrawerLayout.setDrawerWidth(f);
    }

    @ReactProp(name = "drawerLockMode")
    public void setDrawerLockMode(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str != null) {
            if (!"unlocked".equals(str)) {
                if ("locked-closed".equals(str)) {
                    reactDrawerLayout.setDrawerLockMode(1);
                    return;
                } else if ("locked-open".equals(str)) {
                    reactDrawerLayout.setDrawerLockMode(2);
                    return;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown drawerLockMode ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                }
            }
        }
        reactDrawerLayout.setDrawerLockMode(null);
    }

    public void setElevation(ReactDrawerLayout reactDrawerLayout, float f) {
        if (VERSION.SDK_INT >= 21) {
            try {
                ReactDrawerLayout.class.getMethod("setDrawerElevation", new Class[]{Float.TYPE}).invoke(reactDrawerLayout, new Object[]{Float.valueOf(PixelUtil.toPixelFromDIP(f))});
            } catch (Throwable e) {
                FLog.m5715w(ReactConstants.TAG, "setDrawerElevation is not available in this version of the support lib.", e);
            }
        }
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("openDrawer", Integer.valueOf(1), "closeDrawer", Integer.valueOf(2));
    }

    public void receiveCommand(ReactDrawerLayout reactDrawerLayout, int i, ReadableArray readableArray) {
        switch (i) {
            case 1:
                reactDrawerLayout.openDrawer();
                return;
            case 2:
                reactDrawerLayout.closeDrawer();
                return;
            default:
                return;
        }
    }

    public Map getExportedViewConstants() {
        return MapBuilder.of("DrawerPosition", MapBuilder.of("Left", Integer.valueOf(8388611), "Right", Integer.valueOf(8388613)));
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(DrawerSlideEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDrawerSlide"), DrawerOpenedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDrawerOpen"), DrawerClosedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDrawerClose"), DrawerStateChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDrawerStateChanged"));
    }

    public void addView(ReactDrawerLayout reactDrawerLayout, View view, int i) {
        if (getChildCount(reactDrawerLayout) < 2) {
            if (i != 0) {
                if (i != 1) {
                    view = new StringBuilder();
                    view.append("The only valid indices for drawer's child are 0 or 1. Got ");
                    view.append(i);
                    view.append(" instead.");
                    throw new JSApplicationIllegalArgumentException(view.toString());
                }
            }
            reactDrawerLayout.addView(view, i);
            reactDrawerLayout.setDrawerProperties();
            return;
        }
        throw new JSApplicationIllegalArgumentException("The Drawer cannot have more than two children");
    }
}

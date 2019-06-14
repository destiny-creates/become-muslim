package com.facebook.react.views.toolbar;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v7.widget.Toolbar.C0736c;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.react.views.toolbar.events.ToolbarClickEvent;
import java.util.Map;

public class ReactToolbarManager extends ViewGroupManager<ReactToolbar> {
    private static final int COMMAND_DISMISS_POPUP_MENUS = 1;
    private static final String REACT_CLASS = "ToolbarAndroid";

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    protected ReactToolbar createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactToolbar(themedReactContext);
    }

    @ReactProp(name = "logo")
    public void setLogo(ReactToolbar reactToolbar, ReadableMap readableMap) {
        reactToolbar.setLogoSource(readableMap);
    }

    @ReactProp(name = "navIcon")
    public void setNavIcon(ReactToolbar reactToolbar, ReadableMap readableMap) {
        reactToolbar.setNavIconSource(readableMap);
    }

    @ReactProp(name = "overflowIcon")
    public void setOverflowIcon(ReactToolbar reactToolbar, ReadableMap readableMap) {
        reactToolbar.setOverflowIconSource(readableMap);
    }

    @ReactProp(name = "rtl")
    public void setRtl(ReactToolbar reactToolbar, boolean z) {
        reactToolbar.setLayoutDirection(z);
    }

    @ReactProp(name = "subtitle")
    public void setSubtitle(ReactToolbar reactToolbar, String str) {
        reactToolbar.setSubtitle((CharSequence) str);
    }

    @ReactProp(customType = "Color", name = "subtitleColor")
    public void setSubtitleColor(ReactToolbar reactToolbar, Integer num) {
        int[] defaultColors = getDefaultColors(reactToolbar.getContext());
        if (num != null) {
            reactToolbar.setSubtitleTextColor(num.intValue());
        } else {
            reactToolbar.setSubtitleTextColor(defaultColors[1]);
        }
    }

    @ReactProp(name = "title")
    public void setTitle(ReactToolbar reactToolbar, String str) {
        reactToolbar.setTitle((CharSequence) str);
    }

    @ReactProp(customType = "Color", name = "titleColor")
    public void setTitleColor(ReactToolbar reactToolbar, Integer num) {
        int[] defaultColors = getDefaultColors(reactToolbar.getContext());
        if (num != null) {
            reactToolbar.setTitleTextColor(num.intValue());
        } else {
            reactToolbar.setTitleTextColor(defaultColors[null]);
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "contentInsetStart")
    public void setContentInsetStart(ReactToolbar reactToolbar, float f) {
        if (Float.isNaN(f)) {
            f = getDefaultContentInsets(reactToolbar.getContext())[0];
        } else {
            f = Math.round(PixelUtil.toPixelFromDIP(f));
        }
        reactToolbar.setContentInsetsRelative(f, reactToolbar.getContentInsetEnd());
    }

    @ReactProp(defaultFloat = Float.NaN, name = "contentInsetEnd")
    public void setContentInsetEnd(ReactToolbar reactToolbar, float f) {
        if (Float.isNaN(f)) {
            f = getDefaultContentInsets(reactToolbar.getContext())[1];
        } else {
            f = Math.round(PixelUtil.toPixelFromDIP(f));
        }
        reactToolbar.setContentInsetsRelative(reactToolbar.getContentInsetStart(), f);
    }

    @ReactProp(name = "nativeActions")
    public void setActions(ReactToolbar reactToolbar, ReadableArray readableArray) {
        reactToolbar.setActions(readableArray);
    }

    protected void addEventEmitters(ThemedReactContext themedReactContext, final ReactToolbar reactToolbar) {
        themedReactContext = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        reactToolbar.setNavigationOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                themedReactContext.dispatchEvent(new ToolbarClickEvent(reactToolbar.getId(), -1));
            }
        });
        reactToolbar.setOnMenuItemClickListener(new C0736c() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                themedReactContext.dispatchEvent(new ToolbarClickEvent(reactToolbar.getId(), menuItem.getOrder()));
                return true;
            }
        });
    }

    public Map<String, Object> getExportedViewConstants() {
        return MapBuilder.of("ShowAsAction", MapBuilder.of(ReactScrollViewHelper.OVER_SCROLL_NEVER, Integer.valueOf(0), ReactScrollViewHelper.OVER_SCROLL_ALWAYS, Integer.valueOf(2), "ifRoom", Integer.valueOf(1)));
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("dismissPopupMenus", Integer.valueOf(1));
    }

    public void receiveCommand(ReactToolbar reactToolbar, int i, ReadableArray readableArray) {
        if (i == 1) {
            reactToolbar.dismissPopupMenus();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{Integer.valueOf(i), getClass().getSimpleName()}));
        }
    }

    private int[] getDefaultContentInsets(Context context) {
        TypedArray obtainStyledAttributes;
        Throwable th;
        Theme theme = context.getTheme();
        TypedArray typedArray = null;
        try {
            obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{getIdentifier(context, "toolbarStyle")});
            try {
                context = theme.obtainStyledAttributes(obtainStyledAttributes.getResourceId(0, 0), new int[]{getIdentifier(context, "contentInsetStart"), getIdentifier(context, "contentInsetEnd")});
            } catch (Throwable th2) {
                th = th2;
                recycleQuietly(obtainStyledAttributes);
                recycleQuietly(typedArray);
                throw th;
            }
            try {
                int dimensionPixelSize = context.getDimensionPixelSize(0, 0);
                int dimensionPixelSize2 = context.getDimensionPixelSize(1, 0);
                int[] iArr = new int[]{dimensionPixelSize, dimensionPixelSize2};
                recycleQuietly(obtainStyledAttributes);
                recycleQuietly(context);
                return iArr;
            } catch (Throwable th3) {
                th = th3;
                typedArray = context;
                recycleQuietly(obtainStyledAttributes);
                recycleQuietly(typedArray);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            obtainStyledAttributes = null;
            recycleQuietly(obtainStyledAttributes);
            recycleQuietly(typedArray);
            throw th;
        }
    }

    private static int[] getDefaultColors(Context context) {
        TypedArray typedArray;
        TypedArray typedArray2;
        Theme theme = context.getTheme();
        TypedArray typedArray3 = null;
        TypedArray obtainStyledAttributes;
        try {
            obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{getIdentifier(context, "toolbarStyle")});
            try {
                context = theme.obtainStyledAttributes(obtainStyledAttributes.getResourceId(0, 0), new int[]{getIdentifier(context, "titleTextAppearance"), getIdentifier(context, "subtitleTextAppearance")});
            } catch (Throwable th) {
                context = th;
                typedArray = null;
                typedArray2 = typedArray;
                recycleQuietly(obtainStyledAttributes);
                recycleQuietly(typedArray3);
                recycleQuietly(typedArray2);
                recycleQuietly(typedArray);
                throw context;
            }
            try {
                int resourceId = context.getResourceId(0, 0);
                int resourceId2 = context.getResourceId(1, 0);
                typedArray2 = theme.obtainStyledAttributes(resourceId, new int[]{16842904});
                try {
                    typedArray = theme.obtainStyledAttributes(resourceId2, new int[]{16842904});
                    try {
                        resourceId2 = typedArray2.getColor(0, -16777216);
                        int color = typedArray.getColor(0, -16777216);
                        int[] iArr = new int[]{resourceId2, color};
                        recycleQuietly(obtainStyledAttributes);
                        recycleQuietly(context);
                        recycleQuietly(typedArray2);
                        recycleQuietly(typedArray);
                        return iArr;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        typedArray3 = context;
                        context = th3;
                        recycleQuietly(obtainStyledAttributes);
                        recycleQuietly(typedArray3);
                        recycleQuietly(typedArray2);
                        recycleQuietly(typedArray);
                        throw context;
                    }
                } catch (Throwable th4) {
                    typedArray3 = context;
                    context = th4;
                    typedArray = null;
                    recycleQuietly(obtainStyledAttributes);
                    recycleQuietly(typedArray3);
                    recycleQuietly(typedArray2);
                    recycleQuietly(typedArray);
                    throw context;
                }
            } catch (Throwable th42) {
                typedArray2 = null;
                typedArray3 = context;
                context = th42;
                typedArray = typedArray2;
                recycleQuietly(obtainStyledAttributes);
                recycleQuietly(typedArray3);
                recycleQuietly(typedArray2);
                recycleQuietly(typedArray);
                throw context;
            }
        } catch (Throwable th5) {
            context = th5;
            typedArray = null;
            obtainStyledAttributes = typedArray;
            typedArray2 = obtainStyledAttributes;
            recycleQuietly(obtainStyledAttributes);
            recycleQuietly(typedArray3);
            recycleQuietly(typedArray2);
            recycleQuietly(typedArray);
            throw context;
        }
    }

    private static void recycleQuietly(TypedArray typedArray) {
        if (typedArray != null) {
            typedArray.recycle();
        }
    }

    private static int getIdentifier(Context context, String str) {
        return context.getResources().getIdentifier(str, "attr", context.getPackageName());
    }
}

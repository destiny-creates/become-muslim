package com.facebook.react.views.modal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.modal.ReactModalHostView.OnRequestCloseListener;
import java.util.Map;

@ReactModule(name = "RCTModalHostView")
public class ReactModalHostManager extends ViewGroupManager<ReactModalHostView> {
    protected static final String REACT_CLASS = "RCTModalHostView";

    public String getName() {
        return REACT_CLASS;
    }

    protected ReactModalHostView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactModalHostView(themedReactContext);
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ModalHostShadowNode();
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return ModalHostShadowNode.class;
    }

    public void onDropViewInstance(ReactModalHostView reactModalHostView) {
        super.onDropViewInstance(reactModalHostView);
        reactModalHostView.onDropInstance();
    }

    @ReactProp(name = "animationType")
    public void setAnimationType(ReactModalHostView reactModalHostView, String str) {
        reactModalHostView.setAnimationType(str);
    }

    @ReactProp(name = "transparent")
    public void setTransparent(ReactModalHostView reactModalHostView, boolean z) {
        reactModalHostView.setTransparent(z);
    }

    @ReactProp(name = "hardwareAccelerated")
    public void setHardwareAccelerated(ReactModalHostView reactModalHostView, boolean z) {
        reactModalHostView.setHardwareAccelerated(z);
    }

    protected void addEventEmitters(ThemedReactContext themedReactContext, final ReactModalHostView reactModalHostView) {
        themedReactContext = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        reactModalHostView.setOnRequestCloseListener(new OnRequestCloseListener() {
            public void onRequestClose(DialogInterface dialogInterface) {
                themedReactContext.dispatchEvent(new RequestCloseEvent(reactModalHostView.getId()));
            }
        });
        reactModalHostView.setOnShowListener(new OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                themedReactContext.dispatchEvent(new ShowEvent(reactModalHostView.getId()));
            }
        });
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(RequestCloseEvent.EVENT_NAME, MapBuilder.of("registrationName", "onRequestClose")).put(ShowEvent.EVENT_NAME, MapBuilder.of("registrationName", "onShow")).build();
    }

    protected void onAfterUpdateTransaction(ReactModalHostView reactModalHostView) {
        super.onAfterUpdateTransaction(reactModalHostView);
        reactModalHostView.showOrUpdate();
    }
}

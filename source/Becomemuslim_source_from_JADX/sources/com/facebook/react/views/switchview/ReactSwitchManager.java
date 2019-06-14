package com.facebook.react.views.switchview;

import android.graphics.PorterDuff.Mode;
import android.view.View.MeasureSpec;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;

public class ReactSwitchManager extends SimpleViewManager<ReactSwitch> {
    private static final OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new C19891();
    private static final String REACT_CLASS = "AndroidSwitch";

    /* renamed from: com.facebook.react.views.switchview.ReactSwitchManager$1 */
    static class C19891 implements OnCheckedChangeListener {
        C19891() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ((UIManagerModule) ((ReactContext) compoundButton.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSwitchEvent(compoundButton.getId(), z));
        }
    }

    static class ReactSwitchShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        private int mHeight;
        private boolean mMeasured;
        private int mWidth;

        private ReactSwitchShadowNode() {
            initMeasureFunction();
        }

        private ReactSwitchShadowNode(ReactSwitchShadowNode reactSwitchShadowNode) {
            super(reactSwitchShadowNode);
            this.mWidth = reactSwitchShadowNode.mWidth;
            this.mHeight = reactSwitchShadowNode.mHeight;
            this.mMeasured = reactSwitchShadowNode.mMeasured;
        }

        private void initMeasureFunction() {
            setMeasureFunction(this);
        }

        public ReactShadowNodeImpl mutableCopy(long j) {
            ReactSwitchShadowNode reactSwitchShadowNode = (ReactSwitchShadowNode) super.mutableCopy(j);
            reactSwitchShadowNode.initMeasureFunction();
            return reactSwitchShadowNode;
        }

        public ReactShadowNodeImpl mutableCopyWithNewChildren(long j) {
            ReactSwitchShadowNode reactSwitchShadowNode = (ReactSwitchShadowNode) super.mutableCopyWithNewChildren(j);
            reactSwitchShadowNode.initMeasureFunction();
            return reactSwitchShadowNode;
        }

        protected ReactSwitchShadowNode copy() {
            return new ReactSwitchShadowNode(this);
        }

        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            if (this.mMeasured == null) {
                yogaNode = new ReactSwitch(getThemedContext());
                yogaNode.setShowText(false);
                f = MeasureSpec.makeMeasureSpec(-2, 0);
                yogaNode.measure(f, f);
                this.mWidth = yogaNode.getMeasuredWidth();
                this.mHeight = yogaNode.getMeasuredHeight();
                this.mMeasured = true;
            }
            return YogaMeasureOutput.make(this.mWidth, this.mHeight);
        }
    }

    public String getName() {
        return REACT_CLASS;
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactSwitchShadowNode();
    }

    public Class getShadowNodeClass() {
        return ReactSwitchShadowNode.class;
    }

    protected ReactSwitch createViewInstance(ThemedReactContext themedReactContext) {
        ReactSwitch reactSwitch = new ReactSwitch(themedReactContext);
        reactSwitch.setShowText(null);
        return reactSwitch;
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setEnabled(z);
    }

    @ReactProp(name = "on")
    public void setOn(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setOnCheckedChangeListener(null);
        reactSwitch.setOn(z);
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSwitch reactSwitch, Integer num) {
        if (num == null) {
            reactSwitch.getThumbDrawable().clearColorFilter();
        } else {
            reactSwitch.getThumbDrawable().setColorFilter(num.intValue(), Mode.MULTIPLY);
        }
    }

    @ReactProp(customType = "Color", name = "trackTintColor")
    public void setTrackTintColor(ReactSwitch reactSwitch, Integer num) {
        if (num == null) {
            reactSwitch.getTrackDrawable().clearColorFilter();
        } else {
            reactSwitch.getTrackDrawable().setColorFilter(num.intValue(), Mode.MULTIPLY);
        }
    }

    protected void addEventEmitters(ThemedReactContext themedReactContext, ReactSwitch reactSwitch) {
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }
}

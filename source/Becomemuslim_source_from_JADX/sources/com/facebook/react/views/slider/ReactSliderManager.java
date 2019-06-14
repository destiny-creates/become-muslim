package com.facebook.react.views.slider;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LayerDrawable;
import android.view.View.MeasureSpec;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.MapBuilder;
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
import java.util.Map;

public class ReactSliderManager extends SimpleViewManager<ReactSlider> {
    private static final OnSeekBarChangeListener ON_CHANGE_LISTENER = new C19881();
    private static final String REACT_CLASS = "RCTSlider";
    private static final int STYLE = 16842875;

    /* renamed from: com.facebook.react.views.slider.ReactSliderManager$1 */
    static class C19881 implements OnSeekBarChangeListener {
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        C19881() {
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            ((UIManagerModule) ((ReactContext) seekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSliderEvent(seekBar.getId(), ((ReactSlider) seekBar).toRealProgress(i), z));
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            ((UIManagerModule) ((ReactContext) seekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSlidingCompleteEvent(seekBar.getId(), ((ReactSlider) seekBar).toRealProgress(seekBar.getProgress())));
        }
    }

    static class ReactSliderShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        private int mHeight;
        private boolean mMeasured;
        private int mWidth;

        private ReactSliderShadowNode() {
            initMeasureFunction();
        }

        private ReactSliderShadowNode(ReactSliderShadowNode reactSliderShadowNode) {
            super(reactSliderShadowNode);
            this.mWidth = reactSliderShadowNode.mWidth;
            this.mHeight = reactSliderShadowNode.mHeight;
            this.mMeasured = reactSliderShadowNode.mMeasured;
        }

        private void initMeasureFunction() {
            setMeasureFunction(this);
        }

        public ReactShadowNodeImpl mutableCopy(long j) {
            ReactSliderShadowNode reactSliderShadowNode = (ReactSliderShadowNode) super.mutableCopy(j);
            reactSliderShadowNode.initMeasureFunction();
            return reactSliderShadowNode;
        }

        public ReactShadowNodeImpl mutableCopyWithNewChildren(long j) {
            ReactSliderShadowNode reactSliderShadowNode = (ReactSliderShadowNode) super.mutableCopyWithNewChildren(j);
            reactSliderShadowNode.initMeasureFunction();
            return reactSliderShadowNode;
        }

        protected ReactSliderShadowNode copy() {
            return new ReactSliderShadowNode(this);
        }

        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            if (this.mMeasured == null) {
                yogaNode = new ReactSlider(getThemedContext(), null, 2.3693903E-38f);
                f = MeasureSpec.makeMeasureSpec(Float.NaN, null);
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
        return new ReactSliderShadowNode();
    }

    public Class getShadowNodeClass() {
        return ReactSliderShadowNode.class;
    }

    protected ReactSlider createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactSlider(themedReactContext, null, STYLE);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSlider reactSlider, boolean z) {
        reactSlider.setEnabled(z);
    }

    @ReactProp(defaultDouble = 0.0d, name = "value")
    public void setValue(ReactSlider reactSlider, double d) {
        reactSlider.setOnSeekBarChangeListener(null);
        reactSlider.setValue(d);
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    @ReactProp(defaultDouble = 0.0d, name = "minimumValue")
    public void setMinimumValue(ReactSlider reactSlider, double d) {
        reactSlider.setMinValue(d);
    }

    @ReactProp(defaultDouble = 1.0d, name = "maximumValue")
    public void setMaximumValue(ReactSlider reactSlider, double d) {
        reactSlider.setMaxValue(d);
    }

    @ReactProp(defaultDouble = 0.0d, name = "step")
    public void setStep(ReactSlider reactSlider, double d) {
        reactSlider.setStep(d);
    }

    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSlider reactSlider, Integer num) {
        if (num == null) {
            reactSlider.getThumb().clearColorFilter();
        } else {
            reactSlider.getThumb().setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    @ReactProp(customType = "Color", name = "minimumTrackTintColor")
    public void setMinimumTrackTintColor(ReactSlider reactSlider, Integer num) {
        reactSlider = ((LayerDrawable) reactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908301);
        if (num == null) {
            reactSlider.clearColorFilter();
        } else {
            reactSlider.setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    @ReactProp(customType = "Color", name = "maximumTrackTintColor")
    public void setMaximumTrackTintColor(ReactSlider reactSlider, Integer num) {
        reactSlider = ((LayerDrawable) reactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908288);
        if (num == null) {
            reactSlider.clearColorFilter();
        } else {
            reactSlider.setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    protected void addEventEmitters(ThemedReactContext themedReactContext, ReactSlider reactSlider) {
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(ReactSlidingCompleteEvent.EVENT_NAME, MapBuilder.of("registrationName", "onSlidingComplete"));
    }
}

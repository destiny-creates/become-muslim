package versioned.host.exp.exponent.modules.api.components.svg;

import android.util.SparseArray;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;

class SvgViewManager extends ReactViewManager {
    private static final String REACT_CLASS = "RNSVGSvgView";
    private static final SparseArray<SvgView> mTagToSvgView = new SparseArray();

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    SvgViewManager() {
    }

    static void setSvgView(int i, SvgView svgView) {
        mTagToSvgView.put(i, svgView);
    }

    static SvgView getSvgViewByTag(int i) {
        return (SvgView) mTagToSvgView.get(i);
    }

    public SvgView createViewInstance(ThemedReactContext themedReactContext) {
        return new SvgView(themedReactContext);
    }

    public void updateExtraData(ReactViewGroup reactViewGroup, Object obj) {
        super.updateExtraData(reactViewGroup, obj);
        reactViewGroup.invalidate();
    }

    public void onDropViewInstance(ReactViewGroup reactViewGroup) {
        super.onDropViewInstance(reactViewGroup);
        mTagToSvgView.remove(reactViewGroup.getId());
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(SvgView svgView, Integer num) {
        svgView.setTintColor(num);
    }

    @ReactProp(name = "minX")
    public void setMinX(SvgView svgView, float f) {
        svgView.setMinX(f);
    }

    @ReactProp(name = "minY")
    public void setMinY(SvgView svgView, float f) {
        svgView.setMinY(f);
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(SvgView svgView, float f) {
        svgView.setVbWidth(f);
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(SvgView svgView, float f) {
        svgView.setVbHeight(f);
    }

    @ReactProp(name = "bbWidth")
    public void setVbWidth(SvgView svgView, String str) {
        svgView.setVbWidth(str);
    }

    @ReactProp(name = "bbHeight")
    public void setVbHeight(SvgView svgView, String str) {
        svgView.setVbHeight(str);
    }

    @ReactProp(name = "align")
    public void setAlign(SvgView svgView, String str) {
        svgView.setAlign(str);
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(SvgView svgView, int i) {
        svgView.setMeetOrSlice(i);
    }
}

package versioned.host.exp.exponent.modules.api.components.svg;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.MatrixMathHelper;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.TransformHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.lang.reflect.Array;

class RenderableViewManager extends ViewGroupManager<VirtualView> {
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 5.0f;
    private static final double EPSILON = 1.0E-5d;
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private static final MatrixDecompositionContext sMatrixDecompositionContext = new MatrixDecompositionContext();
    private static final double[] sTransformDecompositionArray = new double[16];
    private final String mClassName;
    private final SVGClass svgClass;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.svg.RenderableViewManager$1 */
    class C67451 implements OnHierarchyChangeListener {
        C67451() {
        }

        public void onChildViewAdded(View view, View view2) {
            if ((view instanceof VirtualView) != null) {
                RenderableViewManager.this.invalidateSvgView((VirtualView) view);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if ((view instanceof VirtualView) != null) {
                RenderableViewManager.this.invalidateSvgView((VirtualView) view);
            }
        }
    }

    enum SVGClass {
        RNSVGGroup,
        RNSVGPath,
        RNSVGText,
        RNSVGTSpan,
        RNSVGTextPath,
        RNSVGImage,
        RNSVGCircle,
        RNSVGEllipse,
        RNSVGLine,
        RNSVGRect,
        RNSVGClipPath,
        RNSVGDefs,
        RNSVGUse,
        RNSVGSymbol,
        RNSVGLinearGradient,
        RNSVGRadialGradient,
        RNSVGPattern,
        RNSVGMask
    }

    static class MatrixDecompositionContext extends com.facebook.react.uimanager.MatrixMathHelper.MatrixDecompositionContext {
        final double[] perspective = new double[4];
        final double[] rotationDegrees = new double[3];
        final double[] scale = new double[3];
        final double[] skew = new double[3];
        final double[] translation = new double[3];

        MatrixDecompositionContext() {
        }
    }

    class RenderableShadowNode extends LayoutShadowNode {
        @ReactPropGroup(names = {"alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "justifyContent", "overflow", "alignContent", "display", "position", "right", "top", "bottom", "left", "start", "end", "width", "height", "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd", "borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
        public void ignoreLayoutProps(int i, Dynamic dynamic) {
        }

        RenderableShadowNode() {
        }
    }

    static class CircleViewManager extends RenderableViewManager {
        protected /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        protected /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return super.createViewInstance(themedReactContext);
        }

        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "transform")
        public /* bridge */ /* synthetic */ void setTransform(View view, ReadableArray readableArray) {
            super.setTransform((VirtualView) view, readableArray);
        }

        CircleViewManager() {
            super(SVGClass.RNSVGCircle);
        }

        @ReactProp(name = "cx")
        public void setCx(CircleView circleView, Dynamic dynamic) {
            circleView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(CircleView circleView, Dynamic dynamic) {
            circleView.setCy(dynamic);
        }

        @ReactProp(name = "r")
        public void setR(CircleView circleView, Dynamic dynamic) {
            circleView.setR(dynamic);
        }
    }

    static class DefsViewManager extends RenderableViewManager {
        protected /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        protected /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return super.createViewInstance(themedReactContext);
        }

        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "transform")
        public /* bridge */ /* synthetic */ void setTransform(View view, ReadableArray readableArray) {
            super.setTransform((VirtualView) view, readableArray);
        }

        DefsViewManager() {
            super(SVGClass.RNSVGDefs);
        }
    }

    static class EllipseViewManager extends RenderableViewManager {
        protected /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        protected /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return super.createViewInstance(themedReactContext);
        }

        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "transform")
        public /* bridge */ /* synthetic */ void setTransform(View view, ReadableArray readableArray) {
            super.setTransform((VirtualView) view, readableArray);
        }

        EllipseViewManager() {
            super(SVGClass.RNSVGEllipse);
        }

        @ReactProp(name = "cx")
        public void setCx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setCy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.setRy(dynamic);
        }
    }

    static class GroupViewManager extends RenderableViewManager {
        protected /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        protected /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return super.createViewInstance(themedReactContext);
        }

        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "transform")
        public /* bridge */ /* synthetic */ void setTransform(View view, ReadableArray readableArray) {
            super.setTransform((VirtualView) view, readableArray);
        }

        GroupViewManager() {
            super(SVGClass.RNSVGGroup);
        }

        GroupViewManager(SVGClass sVGClass) {
            super(sVGClass);
        }

        @ReactProp(name = "font")
        public void setFont(GroupView groupView, ReadableMap readableMap) {
            groupView.setFont(readableMap);
        }
    }

    static class ImageViewManager extends RenderableViewManager {
        protected /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        protected /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return super.createViewInstance(themedReactContext);
        }

        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "transform")
        public /* bridge */ /* synthetic */ void setTransform(View view, ReadableArray readableArray) {
            super.setTransform((VirtualView) view, readableArray);
        }

        ImageViewManager() {
            super(SVGClass.RNSVGImage);
        }

        @ReactProp(name = "x")
        public void setX(ImageView imageView, Dynamic dynamic) {
            imageView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(ImageView imageView, Dynamic dynamic) {
            imageView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(ImageView imageView, Dynamic dynamic) {
            imageView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(ImageView imageView, Dynamic dynamic) {
            imageView.setHeight(dynamic);
        }

        @ReactProp(name = "src")
        public void setSrc(ImageView imageView, ReadableMap readableMap) {
            imageView.setSrc(readableMap);
        }

        @ReactProp(name = "align")
        public void setAlign(ImageView imageView, String str) {
            imageView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(ImageView imageView, int i) {
            imageView.setMeetOrSlice(i);
        }
    }

    static class LineViewManager extends RenderableViewManager {
        protected /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        protected /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return super.createViewInstance(themedReactContext);
        }

        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "transform")
        public /* bridge */ /* synthetic */ void setTransform(View view, ReadableArray readableArray) {
            super.setTransform((VirtualView) view, readableArray);
        }

        LineViewManager() {
            super(SVGClass.RNSVGLine);
        }

        @ReactProp(name = "x1")
        public void setX1(LineView lineView, Dynamic dynamic) {
            lineView.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(LineView lineView, Dynamic dynamic) {
            lineView.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(LineView lineView, Dynamic dynamic) {
            lineView.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(LineView lineView, Dynamic dynamic) {
            lineView.setY2(dynamic);
        }
    }

    static class LinearGradientManager extends RenderableViewManager {
        protected /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        protected /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return super.createViewInstance(themedReactContext);
        }

        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "transform")
        public /* bridge */ /* synthetic */ void setTransform(View view, ReadableArray readableArray) {
            super.setTransform((VirtualView) view, readableArray);
        }

        LinearGradientManager() {
            super(SVGClass.RNSVGLinearGradient);
        }

        @ReactProp(name = "x1")
        public void setX1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setX1(dynamic);
        }

        @ReactProp(name = "y1")
        public void setY1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setY1(dynamic);
        }

        @ReactProp(name = "x2")
        public void setX2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setX2(dynamic);
        }

        @ReactProp(name = "y2")
        public void setY2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.setY2(dynamic);
        }

        @ReactProp(name = "gradient")
        public void setGradient(LinearGradientView linearGradientView, ReadableArray readableArray) {
            linearGradientView.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(LinearGradientView linearGradientView, int i) {
            linearGradientView.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(LinearGradientView linearGradientView, ReadableArray readableArray) {
            linearGradientView.setGradientTransform(readableArray);
        }
    }

    static class PathViewManager extends RenderableViewManager {
        protected /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        protected /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return super.createViewInstance(themedReactContext);
        }

        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "transform")
        public /* bridge */ /* synthetic */ void setTransform(View view, ReadableArray readableArray) {
            super.setTransform((VirtualView) view, readableArray);
        }

        PathViewManager() {
            super(SVGClass.RNSVGPath);
        }

        @ReactProp(name = "d")
        public void setD(PathView pathView, String str) {
            pathView.setD(str);
        }
    }

    static class RadialGradientManager extends RenderableViewManager {
        protected /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        protected /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return super.createViewInstance(themedReactContext);
        }

        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "transform")
        public /* bridge */ /* synthetic */ void setTransform(View view, ReadableArray readableArray) {
            super.setTransform((VirtualView) view, readableArray);
        }

        RadialGradientManager() {
            super(SVGClass.RNSVGRadialGradient);
        }

        @ReactProp(name = "fx")
        public void setFx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setFx(dynamic);
        }

        @ReactProp(name = "fy")
        public void setFy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setFy(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setRy(dynamic);
        }

        @ReactProp(name = "cx")
        public void setCx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setCx(dynamic);
        }

        @ReactProp(name = "cy")
        public void setCy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.setCy(dynamic);
        }

        @ReactProp(name = "gradient")
        public void setGradient(RadialGradientView radialGradientView, ReadableArray readableArray) {
            radialGradientView.setGradient(readableArray);
        }

        @ReactProp(name = "gradientUnits")
        public void setGradientUnits(RadialGradientView radialGradientView, int i) {
            radialGradientView.setGradientUnits(i);
        }

        @ReactProp(name = "gradientTransform")
        public void setGradientTransform(RadialGradientView radialGradientView, ReadableArray readableArray) {
            radialGradientView.setGradientTransform(readableArray);
        }
    }

    static class RectViewManager extends RenderableViewManager {
        protected /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        protected /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return super.createViewInstance(themedReactContext);
        }

        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "transform")
        public /* bridge */ /* synthetic */ void setTransform(View view, ReadableArray readableArray) {
            super.setTransform((VirtualView) view, readableArray);
        }

        RectViewManager() {
            super(SVGClass.RNSVGRect);
        }

        @ReactProp(name = "x")
        public void setX(RectView rectView, Dynamic dynamic) {
            rectView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(RectView rectView, Dynamic dynamic) {
            rectView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(RectView rectView, Dynamic dynamic) {
            rectView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(RectView rectView, Dynamic dynamic) {
            rectView.setHeight(dynamic);
        }

        @ReactProp(name = "rx")
        public void setRx(RectView rectView, Dynamic dynamic) {
            rectView.setRx(dynamic);
        }

        @ReactProp(name = "ry")
        public void setRy(RectView rectView, Dynamic dynamic) {
            rectView.setRy(dynamic);
        }
    }

    static class UseViewManager extends RenderableViewManager {
        protected /* bridge */ /* synthetic */ void addEventEmitters(ThemedReactContext themedReactContext, View view) {
            super.addEventEmitters(themedReactContext, (VirtualView) view);
        }

        public /* bridge */ /* synthetic */ ReactShadowNode createShadowNodeInstance() {
            return super.createShadowNodeInstance();
        }

        protected /* bridge */ /* synthetic */ View createViewInstance(ThemedReactContext themedReactContext) {
            return super.createViewInstance(themedReactContext);
        }

        protected /* bridge */ /* synthetic */ void onAfterUpdateTransaction(View view) {
            super.onAfterUpdateTransaction((VirtualView) view);
        }

        @ReactProp(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f) {
            super.setOpacity((VirtualView) view, f);
        }

        @ReactProp(name = "transform")
        public /* bridge */ /* synthetic */ void setTransform(View view, ReadableArray readableArray) {
            super.setTransform((VirtualView) view, readableArray);
        }

        UseViewManager() {
            super(SVGClass.RNSVGUse);
        }

        @ReactProp(name = "href")
        public void setHref(UseView useView, String str) {
            useView.setHref(str);
        }

        @ReactProp(name = "width")
        public void setWidth(UseView useView, Dynamic dynamic) {
            useView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(UseView useView, Dynamic dynamic) {
            useView.setHeight(dynamic);
        }
    }

    static class ClipPathViewManager extends GroupViewManager {
        ClipPathViewManager() {
            super(SVGClass.RNSVGClipPath);
        }
    }

    static class MaskManager extends GroupViewManager {
        MaskManager() {
            super(SVGClass.RNSVGMask);
        }

        @ReactProp(name = "x")
        public void setX(MaskView maskView, Dynamic dynamic) {
            maskView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(MaskView maskView, Dynamic dynamic) {
            maskView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(MaskView maskView, Dynamic dynamic) {
            maskView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(MaskView maskView, Dynamic dynamic) {
            maskView.setHeight(dynamic);
        }

        @ReactProp(name = "maskUnits")
        public void setMaskUnits(MaskView maskView, int i) {
            maskView.setMaskUnits(i);
        }

        @ReactProp(name = "maskContentUnits")
        public void setMaskContentUnits(MaskView maskView, int i) {
            maskView.setMaskContentUnits(i);
        }

        @ReactProp(name = "maskTransform")
        public void setMaskTransform(MaskView maskView, ReadableArray readableArray) {
            maskView.setMaskTransform(readableArray);
        }
    }

    static class PatternManager extends GroupViewManager {
        PatternManager() {
            super(SVGClass.RNSVGPattern);
        }

        @ReactProp(name = "x")
        public void setX(PatternView patternView, Dynamic dynamic) {
            patternView.setX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(PatternView patternView, Dynamic dynamic) {
            patternView.setY(dynamic);
        }

        @ReactProp(name = "width")
        public void setWidth(PatternView patternView, Dynamic dynamic) {
            patternView.setWidth(dynamic);
        }

        @ReactProp(name = "height")
        public void setHeight(PatternView patternView, Dynamic dynamic) {
            patternView.setHeight(dynamic);
        }

        @ReactProp(name = "patternUnits")
        public void setPatternUnits(PatternView patternView, int i) {
            patternView.setPatternUnits(i);
        }

        @ReactProp(name = "patternContentUnits")
        public void setPatternContentUnits(PatternView patternView, int i) {
            patternView.setPatternContentUnits(i);
        }

        @ReactProp(name = "patternTransform")
        public void setPatternTransform(PatternView patternView, ReadableArray readableArray) {
            patternView.setPatternTransform(readableArray);
        }

        @ReactProp(name = "minX")
        public void setMinX(PatternView patternView, float f) {
            patternView.setMinX(f);
        }

        @ReactProp(name = "minY")
        public void setMinY(PatternView patternView, float f) {
            patternView.setMinY(f);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(PatternView patternView, float f) {
            patternView.setVbWidth(f);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(PatternView patternView, float f) {
            patternView.setVbHeight(f);
        }

        @ReactProp(name = "align")
        public void setAlign(PatternView patternView, String str) {
            patternView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(PatternView patternView, int i) {
            patternView.setMeetOrSlice(i);
        }
    }

    static class SymbolManager extends GroupViewManager {
        SymbolManager() {
            super(SVGClass.RNSVGSymbol);
        }

        @ReactProp(name = "minX")
        public void setMinX(SymbolView symbolView, float f) {
            symbolView.setMinX(f);
        }

        @ReactProp(name = "minY")
        public void setMinY(SymbolView symbolView, float f) {
            symbolView.setMinY(f);
        }

        @ReactProp(name = "vbWidth")
        public void setVbWidth(SymbolView symbolView, float f) {
            symbolView.setVbWidth(f);
        }

        @ReactProp(name = "vbHeight")
        public void setVbHeight(SymbolView symbolView, float f) {
            symbolView.setVbHeight(f);
        }

        @ReactProp(name = "align")
        public void setAlign(SymbolView symbolView, String str) {
            symbolView.setAlign(str);
        }

        @ReactProp(name = "meetOrSlice")
        public void setMeetOrSlice(SymbolView symbolView, int i) {
            symbolView.setMeetOrSlice(i);
        }
    }

    static class TextViewManager extends GroupViewManager {
        TextViewManager() {
            super(SVGClass.RNSVGText);
        }

        TextViewManager(SVGClass sVGClass) {
            super(sVGClass);
        }

        @ReactProp(name = "textLength")
        public void setTextLength(TextView textView, Dynamic dynamic) {
            textView.setTextLength(dynamic);
        }

        @ReactProp(name = "lengthAdjust")
        public void setLengthAdjust(TextView textView, String str) {
            textView.setLengthAdjust(str);
        }

        @ReactProp(name = "alignmentBaseline")
        public void setMethod(TextView textView, String str) {
            textView.setMethod(str);
        }

        @ReactProp(name = "baselineShift")
        public void setBaselineShift(TextView textView, Dynamic dynamic) {
            textView.setBaselineShift(dynamic);
        }

        @ReactProp(name = "verticalAlign")
        public void setVerticalAlign(TextView textView, String str) {
            textView.setVerticalAlign(str);
        }

        @ReactProp(name = "rotate")
        public void setRotate(TextView textView, Dynamic dynamic) {
            textView.setRotate(dynamic);
        }

        @ReactProp(name = "dx")
        public void setDeltaX(TextView textView, Dynamic dynamic) {
            textView.setDeltaX(dynamic);
        }

        @ReactProp(name = "dy")
        public void setDeltaY(TextView textView, Dynamic dynamic) {
            textView.setDeltaY(dynamic);
        }

        @ReactProp(name = "x")
        public void setX(TextView textView, Dynamic dynamic) {
            textView.setPositionX(dynamic);
        }

        @ReactProp(name = "y")
        public void setY(TextView textView, Dynamic dynamic) {
            textView.setPositionY(dynamic);
        }

        @ReactProp(name = "font")
        public void setFont(TextView textView, ReadableMap readableMap) {
            textView.setFont(readableMap);
        }
    }

    static class TSpanViewManager extends TextViewManager {
        TSpanViewManager() {
            super(SVGClass.RNSVGTSpan);
        }

        @ReactProp(name = "content")
        public void setContent(TSpanView tSpanView, String str) {
            tSpanView.setContent(str);
        }
    }

    static class TextPathViewManager extends TextViewManager {
        TextPathViewManager() {
            super(SVGClass.RNSVGTextPath);
        }

        @ReactProp(name = "href")
        public void setHref(TextPathView textPathView, String str) {
            textPathView.setHref(str);
        }

        @ReactProp(name = "startOffset")
        public void setStartOffset(TextPathView textPathView, Dynamic dynamic) {
            textPathView.setStartOffset(dynamic);
        }

        @ReactProp(name = "method")
        public void setMethod(TextPathView textPathView, String str) {
            textPathView.setMethod(str);
        }

        @ReactProp(name = "spacing")
        public void setSpacing(TextPathView textPathView, String str) {
            textPathView.setSpacing(str);
        }

        @ReactProp(name = "side")
        public void setSide(TextPathView textPathView, String str) {
            textPathView.setSide(str);
        }

        @ReactProp(name = "midLine")
        public void setSharp(TextPathView textPathView, String str) {
            textPathView.setSharp(str);
        }
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new RenderableShadowNode();
    }

    public Class<RenderableShadowNode> getShadowNodeClass() {
        return RenderableShadowNode.class;
    }

    private static boolean isZero(double d) {
        return (Double.isNaN(d) || Math.abs(d) >= EPSILON) ? 0.0d : Double.MIN_VALUE;
    }

    private static void decomposeMatrix() {
        Assertions.assertCondition(sTransformDecompositionArray.length == 16);
        double[] dArr = sMatrixDecompositionContext.perspective;
        double[] dArr2 = sMatrixDecompositionContext.scale;
        double[] dArr3 = sMatrixDecompositionContext.skew;
        Object obj = sMatrixDecompositionContext.translation;
        double[] dArr4 = sMatrixDecompositionContext.rotationDegrees;
        if (!isZero(sTransformDecompositionArray[15])) {
            double[][] dArr5 = (double[][]) Array.newInstance(double.class, new int[]{4, 4});
            double[] dArr6 = new double[16];
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    int i3 = (i * 4) + i2;
                    double d = sTransformDecompositionArray[i3] / sTransformDecompositionArray[15];
                    dArr5[i][i2] = d;
                    if (i2 == 3) {
                        d = 0.0d;
                    }
                    dArr6[i3] = d;
                }
            }
            dArr6[15] = 1.0d;
            if (!isZero(MatrixMathHelper.determinant(dArr6))) {
                double[][] dArr7;
                int i4;
                if (isZero(dArr5[0][3]) && isZero(dArr5[1][3])) {
                    if (isZero(dArr5[2][3])) {
                        dArr[2] = 0.0d;
                        dArr[1] = 0.0d;
                        dArr[0] = 0.0d;
                        dArr[3] = 1.0d;
                        System.arraycopy(dArr5[3], 0, obj, 0, 3);
                        dArr7 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
                        for (i4 = 0; i4 < 3; i4++) {
                            dArr7[i4][0] = dArr5[i4][0];
                            dArr7[i4][1] = dArr5[i4][1];
                            dArr7[i4][2] = dArr5[i4][2];
                        }
                        dArr2[0] = MatrixMathHelper.v3Length(dArr7[0]);
                        dArr7[0] = MatrixMathHelper.v3Normalize(dArr7[0], dArr2[0]);
                        dArr3[0] = MatrixMathHelper.v3Dot(dArr7[0], dArr7[1]);
                        dArr7[1] = MatrixMathHelper.v3Combine(dArr7[1], dArr7[0], 1.0d, -dArr3[0]);
                        dArr3[0] = MatrixMathHelper.v3Dot(dArr7[0], dArr7[1]);
                        dArr7[1] = MatrixMathHelper.v3Combine(dArr7[1], dArr7[0], 1.0d, -dArr3[0]);
                        dArr2[1] = MatrixMathHelper.v3Length(dArr7[1]);
                        dArr7[1] = MatrixMathHelper.v3Normalize(dArr7[1], dArr2[1]);
                        dArr3[0] = dArr3[0] / dArr2[1];
                        dArr3[1] = MatrixMathHelper.v3Dot(dArr7[0], dArr7[2]);
                        dArr7[2] = MatrixMathHelper.v3Combine(dArr7[2], dArr7[0], 1.0d, -dArr3[1]);
                        dArr3[2] = MatrixMathHelper.v3Dot(dArr7[1], dArr7[2]);
                        dArr7[2] = MatrixMathHelper.v3Combine(dArr7[2], dArr7[1], 1.0d, -dArr3[2]);
                        dArr2[2] = MatrixMathHelper.v3Length(dArr7[2]);
                        dArr7[2] = MatrixMathHelper.v3Normalize(dArr7[2], dArr2[2]);
                        dArr3[1] = dArr3[1] / dArr2[2];
                        dArr3[2] = dArr3[2] / dArr2[2];
                        if (MatrixMathHelper.v3Dot(dArr7[0], MatrixMathHelper.v3Cross(dArr7[1], dArr7[2])) < 0.0d) {
                            for (i4 = 0; i4 < 3; i4++) {
                                dArr2[i4] = dArr2[i4] * -1.0d;
                                dArr3 = dArr7[i4];
                                dArr3[0] = dArr3[0] * -1.0d;
                                dArr3 = dArr7[i4];
                                dArr3[1] = dArr3[1] * -1.0d;
                                dArr3 = dArr7[i4];
                                dArr3[2] = dArr3[2] * -1.0d;
                            }
                        }
                        dArr4[0] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr7[2][1], dArr7[2][2])) * 57.29577951308232d);
                        dArr4[1] = MatrixMathHelper.roundTo3Places((-Math.atan2(-dArr7[2][0], Math.sqrt((dArr7[2][1] * dArr7[2][1]) + (dArr7[2][2] * dArr7[2][2])))) * 57.29577951308232d);
                        dArr4[2] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr7[1][0], dArr7[0][0])) * 57.29577951308232d);
                    }
                }
                MatrixMathHelper.multiplyVectorByMatrix(new double[]{dArr5[0][3], dArr5[1][3], dArr5[2][3], dArr5[3][3]}, MatrixMathHelper.transpose(MatrixMathHelper.inverse(dArr6)), dArr);
                System.arraycopy(dArr5[3], 0, obj, 0, 3);
                dArr7 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
                for (i4 = 0; i4 < 3; i4++) {
                    dArr7[i4][0] = dArr5[i4][0];
                    dArr7[i4][1] = dArr5[i4][1];
                    dArr7[i4][2] = dArr5[i4][2];
                }
                dArr2[0] = MatrixMathHelper.v3Length(dArr7[0]);
                dArr7[0] = MatrixMathHelper.v3Normalize(dArr7[0], dArr2[0]);
                dArr3[0] = MatrixMathHelper.v3Dot(dArr7[0], dArr7[1]);
                dArr7[1] = MatrixMathHelper.v3Combine(dArr7[1], dArr7[0], 1.0d, -dArr3[0]);
                dArr3[0] = MatrixMathHelper.v3Dot(dArr7[0], dArr7[1]);
                dArr7[1] = MatrixMathHelper.v3Combine(dArr7[1], dArr7[0], 1.0d, -dArr3[0]);
                dArr2[1] = MatrixMathHelper.v3Length(dArr7[1]);
                dArr7[1] = MatrixMathHelper.v3Normalize(dArr7[1], dArr2[1]);
                dArr3[0] = dArr3[0] / dArr2[1];
                dArr3[1] = MatrixMathHelper.v3Dot(dArr7[0], dArr7[2]);
                dArr7[2] = MatrixMathHelper.v3Combine(dArr7[2], dArr7[0], 1.0d, -dArr3[1]);
                dArr3[2] = MatrixMathHelper.v3Dot(dArr7[1], dArr7[2]);
                dArr7[2] = MatrixMathHelper.v3Combine(dArr7[2], dArr7[1], 1.0d, -dArr3[2]);
                dArr2[2] = MatrixMathHelper.v3Length(dArr7[2]);
                dArr7[2] = MatrixMathHelper.v3Normalize(dArr7[2], dArr2[2]);
                dArr3[1] = dArr3[1] / dArr2[2];
                dArr3[2] = dArr3[2] / dArr2[2];
                if (MatrixMathHelper.v3Dot(dArr7[0], MatrixMathHelper.v3Cross(dArr7[1], dArr7[2])) < 0.0d) {
                    for (i4 = 0; i4 < 3; i4++) {
                        dArr2[i4] = dArr2[i4] * -1.0d;
                        dArr3 = dArr7[i4];
                        dArr3[0] = dArr3[0] * -1.0d;
                        dArr3 = dArr7[i4];
                        dArr3[1] = dArr3[1] * -1.0d;
                        dArr3 = dArr7[i4];
                        dArr3[2] = dArr3[2] * -1.0d;
                    }
                }
                dArr4[0] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr7[2][1], dArr7[2][2])) * 57.29577951308232d);
                dArr4[1] = MatrixMathHelper.roundTo3Places((-Math.atan2(-dArr7[2][0], Math.sqrt((dArr7[2][1] * dArr7[2][1]) + (dArr7[2][2] * dArr7[2][2])))) * 57.29577951308232d);
                dArr4[2] = MatrixMathHelper.roundTo3Places((-Math.atan2(dArr7[1][0], dArr7[0][0])) * 57.29577951308232d);
            }
        }
    }

    private static void setTransformProperty(View view, ReadableArray readableArray) {
        TransformHelper.processTransform(readableArray, sTransformDecompositionArray);
        decomposeMatrix();
        view.setTranslationX(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.translation[0]));
        view.setTranslationY(PixelUtil.toPixelFromDIP((float) sMatrixDecompositionContext.translation[1]));
        view.setRotation((float) sMatrixDecompositionContext.rotationDegrees[2]);
        view.setRotationX((float) sMatrixDecompositionContext.rotationDegrees[0]);
        view.setRotationY((float) sMatrixDecompositionContext.rotationDegrees[1]);
        view.setScaleX((float) sMatrixDecompositionContext.scale[0]);
        view.setScaleY((float) sMatrixDecompositionContext.scale[1]);
        readableArray = sMatrixDecompositionContext.perspective;
        if (readableArray.length > 2) {
            readableArray = (float) readableArray[2];
            if (readableArray == 0.0f) {
                readableArray = 978111693;
            }
            view.setCameraDistance((DisplayMetricsHolder.getScreenDisplayMetrics().density * (-1.0f / readableArray)) * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
    }

    private static void resetTransformProperty(View view) {
        view.setTranslationX(PixelUtil.toPixelFromDIP(0.0f));
        view.setTranslationY(PixelUtil.toPixelFromDIP(0.0f));
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(0.0f);
    }

    private RenderableViewManager(SVGClass sVGClass) {
        this.svgClass = sVGClass;
        this.mClassName = sVGClass.toString();
    }

    public String getName() {
        return this.mClassName;
    }

    @ReactProp(name = "mask")
    public void setMask(VirtualView virtualView, String str) {
        virtualView.setMask(str);
    }

    @ReactProp(name = "clipPath")
    public void setClipPath(VirtualView virtualView, String str) {
        virtualView.setClipPath(str);
    }

    @ReactProp(name = "clipRule")
    public void setClipRule(VirtualView virtualView, int i) {
        virtualView.setClipRule(i);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(VirtualView virtualView, float f) {
        virtualView.setOpacity(f);
    }

    @ReactProp(name = "fill")
    public void setFill(RenderableView renderableView, Dynamic dynamic) {
        renderableView.setFill(dynamic);
    }

    @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(RenderableView renderableView, float f) {
        renderableView.setFillOpacity(f);
    }

    @ReactProp(defaultInt = 1, name = "fillRule")
    public void setFillRule(RenderableView renderableView, int i) {
        renderableView.setFillRule(i);
    }

    @ReactProp(name = "stroke")
    public void setStroke(RenderableView renderableView, Dynamic dynamic) {
        renderableView.setStroke(dynamic);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(RenderableView renderableView, float f) {
        renderableView.setStrokeOpacity(f);
    }

    @ReactProp(name = "strokeDasharray")
    public void setStrokeDasharray(RenderableView renderableView, ReadableArray readableArray) {
        renderableView.setStrokeDasharray(readableArray);
    }

    @ReactProp(name = "strokeDashoffset")
    public void setStrokeDashoffset(RenderableView renderableView, float f) {
        renderableView.setStrokeDashoffset(f);
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(RenderableView renderableView, Dynamic dynamic) {
        renderableView.setStrokeWidth(dynamic);
    }

    @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(RenderableView renderableView, float f) {
        renderableView.setStrokeMiterlimit(f);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(RenderableView renderableView, int i) {
        renderableView.setStrokeLinecap(i);
    }

    @ReactProp(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(RenderableView renderableView, int i) {
        renderableView.setStrokeLinejoin(i);
    }

    @ReactProp(name = "matrix")
    public void setMatrix(VirtualView virtualView, Dynamic dynamic) {
        virtualView.setMatrix(dynamic);
    }

    @ReactProp(name = "transform")
    public void setTransform(VirtualView virtualView, ReadableArray readableArray) {
        if (readableArray == null) {
            resetTransformProperty(virtualView);
        } else {
            setTransformProperty(virtualView, readableArray);
        }
        readableArray = virtualView.getMatrix();
        virtualView.mTransform = readableArray;
        virtualView.mTransformInvertible = readableArray.invert(virtualView.mInvTransform);
    }

    @ReactProp(name = "propList")
    public void setPropList(RenderableView renderableView, ReadableArray readableArray) {
        renderableView.setPropList(readableArray);
    }

    @ReactProp(name = "responsible")
    public void setResponsible(VirtualView virtualView, boolean z) {
        virtualView.setResponsible(z);
    }

    @ReactProp(name = "name")
    public void setName(VirtualView virtualView, String str) {
        virtualView.setName(str);
    }

    private void invalidateSvgView(VirtualView virtualView) {
        virtualView = virtualView.getSvgView();
        if (virtualView != null) {
            virtualView.invalidate();
        }
    }

    protected void addEventEmitters(ThemedReactContext themedReactContext, VirtualView virtualView) {
        super.addEventEmitters(themedReactContext, virtualView);
        virtualView.setOnHierarchyChangeListener(new C67451());
    }

    protected void onAfterUpdateTransaction(VirtualView virtualView) {
        super.onAfterUpdateTransaction(virtualView);
        invalidateSvgView(virtualView);
    }

    protected VirtualView createViewInstance(ThemedReactContext themedReactContext) {
        switch (this.svgClass) {
            case RNSVGGroup:
                return new GroupView(themedReactContext);
            case RNSVGPath:
                return new PathView(themedReactContext);
            case RNSVGCircle:
                return new CircleView(themedReactContext);
            case RNSVGEllipse:
                return new EllipseView(themedReactContext);
            case RNSVGLine:
                return new LineView(themedReactContext);
            case RNSVGRect:
                return new RectView(themedReactContext);
            case RNSVGText:
                return new TextView(themedReactContext);
            case RNSVGTSpan:
                return new TSpanView(themedReactContext);
            case RNSVGTextPath:
                return new TextPathView(themedReactContext);
            case RNSVGImage:
                return new ImageView(themedReactContext);
            case RNSVGClipPath:
                return new ClipPathView(themedReactContext);
            case RNSVGDefs:
                return new DefsView(themedReactContext);
            case RNSVGUse:
                return new UseView(themedReactContext);
            case RNSVGSymbol:
                return new SymbolView(themedReactContext);
            case RNSVGLinearGradient:
                return new LinearGradientView(themedReactContext);
            case RNSVGRadialGradient:
                return new RadialGradientView(themedReactContext);
            case RNSVGPattern:
                return new PatternView(themedReactContext);
            case RNSVGMask:
                return new MaskView(themedReactContext);
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected type ");
                stringBuilder.append(this.svgClass.toString());
                throw new IllegalStateException(stringBuilder.toString());
        }
    }
}

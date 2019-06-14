package com.facebook.react.uimanager;

import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaWrap;

public class LayoutShadowNode extends ReactShadowNodeImpl {
    private final MutableYogaValue mTempYogaValue;

    private static class MutableYogaValue {
        YogaUnit unit;
        float value;

        private MutableYogaValue() {
        }

        private MutableYogaValue(MutableYogaValue mutableYogaValue) {
            this.value = mutableYogaValue.value;
            this.unit = mutableYogaValue.unit;
        }

        void setFromDynamic(Dynamic dynamic) {
            if (dynamic.isNull()) {
                this.unit = YogaUnit.UNDEFINED;
                this.value = 1.0E21f;
            } else if (dynamic.getType() == ReadableType.String) {
                dynamic = dynamic.asString();
                if (dynamic.equals("auto")) {
                    this.unit = YogaUnit.AUTO;
                    this.value = 1.0E21f;
                } else if (dynamic.endsWith("%")) {
                    this.unit = YogaUnit.PERCENT;
                    this.value = Float.parseFloat(dynamic.substring(0, dynamic.length() - 1));
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown value: ");
                    stringBuilder.append(dynamic);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            } else {
                this.unit = YogaUnit.POINT;
                this.value = PixelUtil.toPixelFromDIP(dynamic.asDouble());
            }
        }
    }

    public LayoutShadowNode() {
        this.mTempYogaValue = new MutableYogaValue();
    }

    protected LayoutShadowNode(LayoutShadowNode layoutShadowNode) {
        super(layoutShadowNode);
        this.mTempYogaValue = new MutableYogaValue(layoutShadowNode.mTempYogaValue);
    }

    protected LayoutShadowNode copy() {
        return new LayoutShadowNode(this);
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            switch (this.mTempYogaValue.unit) {
                case POINT:
                case UNDEFINED:
                    setStyleWidth(this.mTempYogaValue.value);
                    break;
                case AUTO:
                    setStyleWidthAuto();
                    break;
                case PERCENT:
                    setStyleWidthPercent(this.mTempYogaValue.value);
                    break;
                default:
                    break;
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "minWidth")
    public void setMinWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = C19651.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i != 4) {
                switch (i) {
                    case 1:
                    case 2:
                        setStyleMinWidth(this.mTempYogaValue.value);
                        break;
                    default:
                        break;
                }
            }
            setStyleMinWidthPercent(this.mTempYogaValue.value);
            dynamic.recycle();
        }
    }

    @ReactProp(name = "maxWidth")
    public void setMaxWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = C19651.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i != 4) {
                switch (i) {
                    case 1:
                    case 2:
                        setStyleMaxWidth(this.mTempYogaValue.value);
                        break;
                    default:
                        break;
                }
            }
            setStyleMaxWidthPercent(this.mTempYogaValue.value);
            dynamic.recycle();
        }
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            switch (this.mTempYogaValue.unit) {
                case POINT:
                case UNDEFINED:
                    setStyleHeight(this.mTempYogaValue.value);
                    break;
                case AUTO:
                    setStyleHeightAuto();
                    break;
                case PERCENT:
                    setStyleHeightPercent(this.mTempYogaValue.value);
                    break;
                default:
                    break;
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "minHeight")
    public void setMinHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = C19651.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i != 4) {
                switch (i) {
                    case 1:
                    case 2:
                        setStyleMinHeight(this.mTempYogaValue.value);
                        break;
                    default:
                        break;
                }
            }
            setStyleMinHeightPercent(this.mTempYogaValue.value);
            dynamic.recycle();
        }
    }

    @ReactProp(name = "maxHeight")
    public void setMaxHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = C19651.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i != 4) {
                switch (i) {
                    case 1:
                    case 2:
                        setStyleMaxHeight(this.mTempYogaValue.value);
                        break;
                    default:
                        break;
                }
            }
            setStyleMaxHeightPercent(this.mTempYogaValue.value);
            dynamic.recycle();
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flex")
    public void setFlex(float f) {
        if (!isVirtual()) {
            super.setFlex(f);
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flexGrow")
    public void setFlexGrow(float f) {
        if (!isVirtual()) {
            super.setFlexGrow(f);
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flexShrink")
    public void setFlexShrink(float f) {
        if (!isVirtual()) {
            super.setFlexShrink(f);
        }
    }

    @ReactProp(name = "flexBasis")
    public void setFlexBasis(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            switch (this.mTempYogaValue.unit) {
                case POINT:
                case UNDEFINED:
                    setFlexBasis(this.mTempYogaValue.value);
                    break;
                case AUTO:
                    setFlexBasisAuto();
                    break;
                case PERCENT:
                    setFlexBasisPercent(this.mTempYogaValue.value);
                    break;
                default:
                    break;
            }
            dynamic.recycle();
        }
    }

    @ReactProp(defaultFloat = 1.0E21f, name = "aspectRatio")
    public void setAspectRatio(float f) {
        setStyleAspectRatio(f);
    }

    @ReactProp(name = "flexDirection")
    public void setFlexDirection(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setFlexDirection(YogaFlexDirection.COLUMN);
                return;
            }
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != -1448970769) {
                if (hashCode != -1354837162) {
                    if (hashCode != 113114) {
                        if (hashCode == 1272730475) {
                            if (str.equals("column-reverse")) {
                                obj = 1;
                            }
                        }
                    } else if (str.equals("row")) {
                        obj = 2;
                    }
                } else if (str.equals(StackTraceHelper.COLUMN_KEY)) {
                    obj = null;
                }
            } else if (str.equals("row-reverse")) {
                obj = 3;
            }
            switch (obj) {
                case null:
                    setFlexDirection(YogaFlexDirection.COLUMN);
                    break;
                case 1:
                    setFlexDirection(YogaFlexDirection.COLUMN_REVERSE);
                    break;
                case 2:
                    setFlexDirection(YogaFlexDirection.ROW);
                    break;
                case 3:
                    setFlexDirection(YogaFlexDirection.ROW_REVERSE);
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("invalid value for flexDirection: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    @ReactProp(name = "flexWrap")
    public void setFlexWrap(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setFlexWrap(YogaWrap.NO_WRAP);
                return;
            }
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != -1039592053) {
                if (hashCode != -749527969) {
                    if (hashCode == 3657802) {
                        if (str.equals("wrap")) {
                            obj = 1;
                        }
                    }
                } else if (str.equals("wrap-reverse")) {
                    obj = 2;
                }
            } else if (str.equals("nowrap")) {
                obj = null;
            }
            switch (obj) {
                case null:
                    setFlexWrap(YogaWrap.NO_WRAP);
                    break;
                case 1:
                    setFlexWrap(YogaWrap.WRAP);
                    break;
                case 2:
                    setFlexWrap(YogaWrap.WRAP_REVERSE);
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("invalid value for flexWrap: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    @ReactProp(name = "alignSelf")
    public void setAlignSelf(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignSelf(YogaAlign.AUTO);
                return;
            }
            Object obj = -1;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        obj = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        obj = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        obj = null;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        obj = 7;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (obj) {
                case null:
                    setAlignSelf(YogaAlign.AUTO);
                    return;
                case 1:
                    setAlignSelf(YogaAlign.FLEX_START);
                    return;
                case 2:
                    setAlignSelf(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignSelf(YogaAlign.FLEX_END);
                    return;
                case 4:
                    setAlignSelf(YogaAlign.STRETCH);
                    return;
                case 5:
                    setAlignSelf(YogaAlign.BASELINE);
                    return;
                case 6:
                    setAlignSelf(YogaAlign.SPACE_BETWEEN);
                    return;
                case 7:
                    setAlignSelf(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("invalid value for alignSelf: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    @ReactProp(name = "alignItems")
    public void setAlignItems(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignItems(YogaAlign.STRETCH);
                return;
            }
            Object obj = -1;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        obj = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        obj = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        obj = null;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        obj = 7;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (obj) {
                case null:
                    setAlignItems(YogaAlign.AUTO);
                    return;
                case 1:
                    setAlignItems(YogaAlign.FLEX_START);
                    return;
                case 2:
                    setAlignItems(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignItems(YogaAlign.FLEX_END);
                    return;
                case 4:
                    setAlignItems(YogaAlign.STRETCH);
                    return;
                case 5:
                    setAlignItems(YogaAlign.BASELINE);
                    return;
                case 6:
                    setAlignItems(YogaAlign.SPACE_BETWEEN);
                    return;
                case 7:
                    setAlignItems(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("invalid value for alignItems: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    @ReactProp(name = "alignContent")
    public void setAlignContent(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignContent(YogaAlign.FLEX_START);
                return;
            }
            Object obj = -1;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        obj = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        obj = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        obj = null;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        obj = 7;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (obj) {
                case null:
                    setAlignContent(YogaAlign.AUTO);
                    return;
                case 1:
                    setAlignContent(YogaAlign.FLEX_START);
                    return;
                case 2:
                    setAlignContent(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignContent(YogaAlign.FLEX_END);
                    return;
                case 4:
                    setAlignContent(YogaAlign.STRETCH);
                    return;
                case 5:
                    setAlignContent(YogaAlign.BASELINE);
                    return;
                case 6:
                    setAlignContent(YogaAlign.SPACE_BETWEEN);
                    return;
                case 7:
                    setAlignContent(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("invalid value for alignContent: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    @ReactProp(name = "justifyContent")
    public void setJustifyContent(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setJustifyContent(YogaJustify.FLEX_START);
                return;
            }
            Object obj = -1;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        obj = 1;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        obj = null;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 2055030478:
                    if (str.equals("space-evenly")) {
                        obj = 5;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (obj) {
                case null:
                    setJustifyContent(YogaJustify.FLEX_START);
                    break;
                case 1:
                    setJustifyContent(YogaJustify.CENTER);
                    break;
                case 2:
                    setJustifyContent(YogaJustify.FLEX_END);
                    break;
                case 3:
                    setJustifyContent(YogaJustify.SPACE_BETWEEN);
                    break;
                case 4:
                    setJustifyContent(YogaJustify.SPACE_AROUND);
                    break;
                case 5:
                    setJustifyContent(YogaJustify.SPACE_EVENLY);
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("invalid value for justifyContent: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    @ReactProp(name = "overflow")
    public void setOverflow(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setOverflow(YogaOverflow.VISIBLE);
                return;
            }
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != -1217487446) {
                if (hashCode != -907680051) {
                    if (hashCode == 466743410) {
                        if (str.equals(ViewProps.VISIBLE)) {
                            obj = null;
                        }
                    }
                } else if (str.equals(ViewProps.SCROLL)) {
                    obj = 2;
                }
            } else if (str.equals("hidden")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    setOverflow(YogaOverflow.VISIBLE);
                    break;
                case 1:
                    setOverflow(YogaOverflow.HIDDEN);
                    break;
                case 2:
                    setOverflow(YogaOverflow.SCROLL);
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("invalid value for overflow: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    @ReactProp(name = "display")
    public void setDisplay(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setDisplay(YogaDisplay.FLEX);
                return;
            }
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != 3145721) {
                if (hashCode == 3387192) {
                    if (str.equals(ViewProps.NONE)) {
                        obj = 1;
                    }
                }
            } else if (str.equals(ViewProps.FLEX)) {
                obj = null;
            }
            switch (obj) {
                case null:
                    setDisplay(YogaDisplay.FLEX);
                    break;
                case 1:
                    setDisplay(YogaDisplay.NONE);
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("invalid value for display: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            i = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            switch (this.mTempYogaValue.unit) {
                case POINT:
                case UNDEFINED:
                    setMargin(i, this.mTempYogaValue.value);
                    break;
                case AUTO:
                    setMarginAuto(i);
                    break;
                case PERCENT:
                    setMarginPercent(i, this.mTempYogaValue.value);
                    break;
                default:
                    break;
            }
            dynamic.recycle();
        }
    }

    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            i = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i2 = C19651.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i2 != 4) {
                switch (i2) {
                    case 1:
                    case 2:
                        setPadding(i, this.mTempYogaValue.value);
                        break;
                    default:
                        break;
                }
            }
            setPaddingPercent(i, this.mTempYogaValue.value);
            dynamic.recycle();
        }
    }

    @ReactPropGroup(defaultFloat = 1.0E21f, names = {"borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
    public void setBorderWidths(int i, float f) {
        if (!isVirtual()) {
            setBorder(maybeTransformLeftRightToStartEnd(ViewProps.BORDER_SPACING_TYPES[i]), PixelUtil.toPixelFromDIP(f));
        }
    }

    @ReactPropGroup(names = {"start", "end", "left", "right", "top", "bottom"})
    public void setPositionValues(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            i = maybeTransformLeftRightToStartEnd(new int[]{4, 5, 0, 2, 1, 3}[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i2 = C19651.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i2 != 4) {
                switch (i2) {
                    case 1:
                    case 2:
                        setPosition(i, this.mTempYogaValue.value);
                        break;
                    default:
                        break;
                }
            }
            setPositionPercent(i, this.mTempYogaValue.value);
            dynamic.recycle();
        }
    }

    private int maybeTransformLeftRightToStartEnd(int i) {
        if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(getThemedContext())) {
            return i;
        }
        if (i != 0) {
            return i != 2 ? i : 5;
        } else {
            return 4;
        }
    }

    @ReactProp(name = "position")
    public void setPosition(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setPositionType(YogaPositionType.RELATIVE);
                return;
            }
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != -554435892) {
                if (hashCode == 1728122231) {
                    if (str.equals(Constants.PATH_TYPE_ABSOLUTE)) {
                        obj = 1;
                    }
                }
            } else if (str.equals(Constants.PATH_TYPE_RELATIVE)) {
                obj = null;
            }
            switch (obj) {
                case null:
                    setPositionType(YogaPositionType.RELATIVE);
                    break;
                case 1:
                    setPositionType(YogaPositionType.ABSOLUTE);
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("invalid value for position: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    @ReactProp(name = "onLayout")
    public void setShouldNotifyOnLayout(boolean z) {
        super.setShouldNotifyOnLayout(z);
    }
}

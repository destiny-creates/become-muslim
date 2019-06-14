package com.facebook.react.views.text;

import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.stetho.server.http.HttpStatus;
import com.facebook.yoga.YogaDirection;
import java.util.ArrayList;
import java.util.List;

public abstract class ReactBaseTextShadowNode extends LayoutShadowNode {
    public static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
    private static final String INLINE_IMAGE_PLACEHOLDER = "I";
    public static final String PROP_SHADOW_COLOR = "textShadowColor";
    public static final String PROP_SHADOW_OFFSET = "textShadowOffset";
    public static final String PROP_SHADOW_OFFSET_HEIGHT = "height";
    public static final String PROP_SHADOW_OFFSET_WIDTH = "width";
    public static final String PROP_SHADOW_RADIUS = "textShadowRadius";
    public static final int UNSET = -1;
    protected boolean mAllowFontScaling = true;
    protected int mBackgroundColor;
    protected int mColor;
    protected boolean mContainsImages;
    protected String mFontFamily;
    protected int mFontSize = -1;
    protected float mFontSizeInput = -1.0f;
    protected int mFontStyle;
    protected int mFontWeight;
    protected float mHeightOfTallestInlineImage;
    protected boolean mIncludeFontPadding;
    protected boolean mIsBackgroundColorSet = false;
    protected boolean mIsColorSet = false;
    protected boolean mIsLineThroughTextDecorationSet;
    protected boolean mIsUnderlineTextDecorationSet;
    protected float mLetterSpacing = Float.NaN;
    protected float mLetterSpacingInput = Float.NaN;
    protected float mLineHeight = Float.NaN;
    protected float mLineHeightInput = -1.0f;
    protected int mNumberOfLines = -1;
    protected int mTextAlign = 0;
    protected int mTextBreakStrategy;
    protected int mTextShadowColor;
    protected float mTextShadowOffsetDx;
    protected float mTextShadowOffsetDy;
    protected float mTextShadowRadius;

    private static class SetSpanOperation {
        protected int end;
        protected int start;
        protected Object what;

        SetSpanOperation(int i, int i2, Object obj) {
            this.start = i;
            this.end = i2;
            this.what = obj;
        }

        public void execute(SpannableStringBuilder spannableStringBuilder, int i) {
            spannableStringBuilder.setSpan(this.what, this.start, this.end, ((i << 16) & 16711680) | ((this.start == 0 ? 18 : 34) & -16711681));
        }
    }

    private static void buildSpannedFromShadowNode(ReactBaseTextShadowNode reactBaseTextShadowNode, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        int length = spannableStringBuilder.length();
        int childCount = reactBaseTextShadowNode.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ReactShadowNode childAt = reactBaseTextShadowNode.getChildAt(i);
            if (childAt instanceof ReactRawTextShadowNode) {
                spannableStringBuilder.append(((ReactRawTextShadowNode) childAt).getText());
            } else if (childAt instanceof ReactBaseTextShadowNode) {
                buildSpannedFromShadowNode((ReactBaseTextShadowNode) childAt, spannableStringBuilder, list);
            } else if (childAt instanceof ReactTextInlineImageShadowNode) {
                spannableStringBuilder.append(INLINE_IMAGE_PLACEHOLDER);
                list.add(new SetSpanOperation(spannableStringBuilder.length() - INLINE_IMAGE_PLACEHOLDER.length(), spannableStringBuilder.length(), ((ReactTextInlineImageShadowNode) childAt).buildInlineImageSpan()));
            } else {
                spannableStringBuilder = new StringBuilder();
                spannableStringBuilder.append("Unexpected view type nested under text node: ");
                spannableStringBuilder.append(childAt.getClass());
                throw new IllegalViewOperationException(spannableStringBuilder.toString());
            }
            childAt.markUpdateSeen();
        }
        spannableStringBuilder = spannableStringBuilder.length();
        if (spannableStringBuilder >= length) {
            if (reactBaseTextShadowNode.mIsColorSet) {
                list.add(new SetSpanOperation(length, spannableStringBuilder, new ForegroundColorSpan(reactBaseTextShadowNode.mColor)));
            }
            if (reactBaseTextShadowNode.mIsBackgroundColorSet) {
                list.add(new SetSpanOperation(length, spannableStringBuilder, new BackgroundColorSpan(reactBaseTextShadowNode.mBackgroundColor)));
            }
            if (VERSION.SDK_INT >= 21 && !Float.isNaN(reactBaseTextShadowNode.mLetterSpacing)) {
                list.add(new SetSpanOperation(length, spannableStringBuilder, new CustomLetterSpacingSpan(reactBaseTextShadowNode.mLetterSpacing)));
            }
            if (reactBaseTextShadowNode.mFontSize != -1) {
                list.add(new SetSpanOperation(length, spannableStringBuilder, new AbsoluteSizeSpan(reactBaseTextShadowNode.mFontSize)));
            }
            if (!(reactBaseTextShadowNode.mFontStyle == -1 && reactBaseTextShadowNode.mFontWeight == -1 && reactBaseTextShadowNode.mFontFamily == null)) {
                list.add(new SetSpanOperation(length, spannableStringBuilder, new CustomStyleSpan(reactBaseTextShadowNode.mFontStyle, reactBaseTextShadowNode.mFontWeight, reactBaseTextShadowNode.mFontFamily, reactBaseTextShadowNode.getThemedContext().getAssets())));
            }
            if (reactBaseTextShadowNode.mIsUnderlineTextDecorationSet) {
                list.add(new SetSpanOperation(length, spannableStringBuilder, new UnderlineSpan()));
            }
            if (reactBaseTextShadowNode.mIsLineThroughTextDecorationSet) {
                list.add(new SetSpanOperation(length, spannableStringBuilder, new StrikethroughSpan()));
            }
            if (!(reactBaseTextShadowNode.mTextShadowOffsetDx == 0.0f && reactBaseTextShadowNode.mTextShadowOffsetDy == 0.0f)) {
                list.add(new SetSpanOperation(length, spannableStringBuilder, new ShadowStyleSpan(reactBaseTextShadowNode.mTextShadowOffsetDx, reactBaseTextShadowNode.mTextShadowOffsetDy, reactBaseTextShadowNode.mTextShadowRadius, reactBaseTextShadowNode.mTextShadowColor)));
            }
            if (!Float.isNaN(reactBaseTextShadowNode.getEffectiveLineHeight())) {
                list.add(new SetSpanOperation(length, spannableStringBuilder, new CustomLineHeightSpan(reactBaseTextShadowNode.getEffectiveLineHeight())));
            }
            list.add(new SetSpanOperation(length, spannableStringBuilder, new ReactTagSpan(reactBaseTextShadowNode.getReactTag())));
        }
    }

    protected static Spannable spannedFromShadowNode(ReactBaseTextShadowNode reactBaseTextShadowNode, String str) {
        Spannable spannableStringBuilder = new SpannableStringBuilder();
        List<SetSpanOperation> arrayList = new ArrayList();
        buildSpannedFromShadowNode(reactBaseTextShadowNode, spannableStringBuilder, arrayList);
        if (str != null) {
            spannableStringBuilder.append(str);
        }
        int i = 0;
        if (reactBaseTextShadowNode.mFontSize == -1) {
            if (reactBaseTextShadowNode.mAllowFontScaling != null) {
                str = (int) Math.ceil((double) PixelUtil.toPixelFromSP(14.0f));
            } else {
                str = (int) Math.ceil((double) PixelUtil.toPixelFromDIP(14.0f));
            }
            arrayList.add(new SetSpanOperation(0, spannableStringBuilder.length(), new AbsoluteSizeSpan(str)));
        }
        reactBaseTextShadowNode.mContainsImages = false;
        reactBaseTextShadowNode.mHeightOfTallestInlineImage = Float.NaN;
        for (SetSpanOperation setSpanOperation : arrayList) {
            if (setSpanOperation.what instanceof TextInlineImageSpan) {
                int height = ((TextInlineImageSpan) setSpanOperation.what).getHeight();
                reactBaseTextShadowNode.mContainsImages = true;
                if (Float.isNaN(reactBaseTextShadowNode.mHeightOfTallestInlineImage) || ((float) height) > reactBaseTextShadowNode.mHeightOfTallestInlineImage) {
                    reactBaseTextShadowNode.mHeightOfTallestInlineImage = (float) height;
                }
            }
            setSpanOperation.execute(spannableStringBuilder, i);
            i++;
        }
        return spannableStringBuilder;
    }

    private static int parseNumericFontWeight(String str) {
        return (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') ? -1 : (str.charAt(0) - 48) * 100;
    }

    public ReactBaseTextShadowNode() {
        this.mTextBreakStrategy = VERSION.SDK_INT < 23 ? 0 : 1;
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        this.mTextShadowRadius = 1.0f;
        this.mTextShadowColor = DEFAULT_TEXT_SHADOW_COLOR;
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        this.mIncludeFontPadding = true;
        this.mFontStyle = -1;
        this.mFontWeight = -1;
        this.mFontFamily = null;
        this.mContainsImages = false;
        this.mHeightOfTallestInlineImage = Float.NaN;
    }

    public ReactBaseTextShadowNode(ReactBaseTextShadowNode reactBaseTextShadowNode) {
        super(reactBaseTextShadowNode);
        this.mTextBreakStrategy = VERSION.SDK_INT < 23 ? 0 : 1;
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        this.mTextShadowRadius = 1.0f;
        this.mTextShadowColor = DEFAULT_TEXT_SHADOW_COLOR;
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        this.mIncludeFontPadding = true;
        this.mFontStyle = -1;
        this.mFontWeight = -1;
        this.mFontFamily = null;
        this.mContainsImages = false;
        this.mHeightOfTallestInlineImage = Float.NaN;
        this.mLineHeight = reactBaseTextShadowNode.mLineHeight;
        this.mIsColorSet = reactBaseTextShadowNode.mIsColorSet;
        this.mAllowFontScaling = reactBaseTextShadowNode.mAllowFontScaling;
        this.mColor = reactBaseTextShadowNode.mColor;
        this.mIsBackgroundColorSet = reactBaseTextShadowNode.mIsBackgroundColorSet;
        this.mBackgroundColor = reactBaseTextShadowNode.mBackgroundColor;
        this.mNumberOfLines = reactBaseTextShadowNode.mNumberOfLines;
        this.mFontSize = reactBaseTextShadowNode.mFontSize;
        this.mFontSizeInput = reactBaseTextShadowNode.mFontSizeInput;
        this.mLineHeightInput = reactBaseTextShadowNode.mLineHeightInput;
        this.mTextAlign = reactBaseTextShadowNode.mTextAlign;
        this.mTextBreakStrategy = reactBaseTextShadowNode.mTextBreakStrategy;
        this.mTextShadowOffsetDx = reactBaseTextShadowNode.mTextShadowOffsetDx;
        this.mTextShadowOffsetDy = reactBaseTextShadowNode.mTextShadowOffsetDy;
        this.mTextShadowRadius = reactBaseTextShadowNode.mTextShadowRadius;
        this.mTextShadowColor = reactBaseTextShadowNode.mTextShadowColor;
        this.mIsUnderlineTextDecorationSet = reactBaseTextShadowNode.mIsUnderlineTextDecorationSet;
        this.mIsLineThroughTextDecorationSet = reactBaseTextShadowNode.mIsLineThroughTextDecorationSet;
        this.mIncludeFontPadding = reactBaseTextShadowNode.mIncludeFontPadding;
        this.mFontStyle = reactBaseTextShadowNode.mFontStyle;
        this.mFontWeight = reactBaseTextShadowNode.mFontWeight;
        this.mFontFamily = reactBaseTextShadowNode.mFontFamily;
        this.mContainsImages = reactBaseTextShadowNode.mContainsImages;
        this.mHeightOfTallestInlineImage = reactBaseTextShadowNode.mHeightOfTallestInlineImage;
    }

    public float getEffectiveLineHeight() {
        Object obj = (Float.isNaN(this.mLineHeight) || Float.isNaN(this.mHeightOfTallestInlineImage) || this.mHeightOfTallestInlineImage <= this.mLineHeight) ? null : 1;
        return obj != null ? this.mHeightOfTallestInlineImage : this.mLineHeight;
    }

    private int getTextAlign() {
        int i = this.mTextAlign;
        if (getLayoutDirection() != YogaDirection.RTL) {
            return i;
        }
        if (i == 5) {
            return 3;
        }
        return i == 3 ? 5 : i;
    }

    @ReactProp(defaultInt = -1, name = "numberOfLines")
    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = -1;
        }
        this.mNumberOfLines = i;
        markUpdated();
    }

    @ReactProp(defaultFloat = -1.0f, name = "lineHeight")
    public void setLineHeight(float f) {
        this.mLineHeightInput = f;
        if (f == -1.0f) {
            this.mLineHeight = Float.NaN;
        } else {
            if (this.mAllowFontScaling) {
                f = PixelUtil.toPixelFromSP(f);
            } else {
                f = PixelUtil.toPixelFromDIP(f);
            }
            this.mLineHeight = f;
        }
        markUpdated();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "letterSpacing")
    public void setLetterSpacing(float f) {
        this.mLetterSpacingInput = f;
        if (this.mAllowFontScaling != null) {
            f = PixelUtil.toPixelFromSP(this.mLetterSpacingInput);
        } else {
            f = PixelUtil.toPixelFromDIP(this.mLetterSpacingInput);
        }
        this.mLetterSpacing = f;
        markUpdated();
    }

    @ReactProp(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(boolean z) {
        if (z != this.mAllowFontScaling) {
            this.mAllowFontScaling = z;
            setFontSize(this.mFontSizeInput);
            setLineHeight(this.mLineHeightInput);
            setLetterSpacing(this.mLetterSpacingInput);
            markUpdated();
        }
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(String str) {
        if (str != null) {
            if (!"auto".equals(str)) {
                if (ViewProps.LEFT.equals(str)) {
                    this.mTextAlign = 3;
                } else if (ViewProps.RIGHT.equals(str)) {
                    this.mTextAlign = 5;
                } else if ("center".equals(str)) {
                    this.mTextAlign = 1;
                } else if ("justify".equals(str)) {
                    this.mTextAlign = 3;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid textAlign: ");
                    stringBuilder.append(str);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                }
                markUpdated();
            }
        }
        this.mTextAlign = null;
        markUpdated();
    }

    @ReactProp(defaultFloat = -1.0f, name = "fontSize")
    public void setFontSize(float f) {
        this.mFontSizeInput = f;
        if (f != -1.0f) {
            if (this.mAllowFontScaling) {
                f = (float) Math.ceil((double) PixelUtil.toPixelFromSP(f));
            } else {
                f = (float) Math.ceil((double) PixelUtil.toPixelFromDIP(f));
            }
        }
        this.mFontSize = (int) f;
        markUpdated();
    }

    @ReactProp(name = "color")
    public void setColor(Integer num) {
        this.mIsColorSet = num != null;
        if (this.mIsColorSet) {
            this.mColor = num.intValue();
        }
        markUpdated();
    }

    @ReactProp(name = "backgroundColor")
    public void setBackgroundColor(Integer num) {
        if (!isVirtualAnchor()) {
            this.mIsBackgroundColorSet = num != null;
            if (this.mIsBackgroundColorSet) {
                this.mBackgroundColor = num.intValue();
            }
            markUpdated();
        }
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(String str) {
        this.mFontFamily = str;
        markUpdated();
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(String str) {
        int i = -1;
        int parseNumericFontWeight = str != null ? parseNumericFontWeight(str) : -1;
        if (parseNumericFontWeight < HttpStatus.HTTP_INTERNAL_SERVER_ERROR) {
            if (!"bold".equals(str)) {
                if ("normal".equals(str) != null || (parseNumericFontWeight != -1 && parseNumericFontWeight < HttpStatus.HTTP_INTERNAL_SERVER_ERROR)) {
                    i = 0;
                }
                if (i != this.mFontWeight) {
                    this.mFontWeight = i;
                    markUpdated();
                }
            }
        }
        i = 1;
        if (i != this.mFontWeight) {
            this.mFontWeight = i;
            markUpdated();
        }
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(String str) {
        str = "italic".equals(str) ? 2 : "normal".equals(str) != null ? null : -1;
        if (str != this.mFontStyle) {
            this.mFontStyle = str;
            markUpdated();
        }
    }

    @ReactProp(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(boolean z) {
        this.mIncludeFontPadding = z;
    }

    @ReactProp(name = "textDecorationLine")
    public void setTextDecorationLine(String str) {
        int i = 0;
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        if (str != null) {
            str = str.split(" ");
            int length = str.length;
            while (i < length) {
                Object obj = str[i];
                if ("underline".equals(obj)) {
                    this.mIsUnderlineTextDecorationSet = true;
                } else if ("line-through".equals(obj)) {
                    this.mIsLineThroughTextDecorationSet = true;
                }
                i++;
            }
        }
        markUpdated();
    }

    @ReactProp(name = "textBreakStrategy")
    public void setTextBreakStrategy(String str) {
        if (VERSION.SDK_INT >= 23) {
            if (str != null) {
                if (!"highQuality".equals(str)) {
                    if ("simple".equals(str)) {
                        this.mTextBreakStrategy = null;
                    } else if ("balanced".equals(str)) {
                        this.mTextBreakStrategy = 2;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid textBreakStrategy: ");
                        stringBuilder.append(str);
                        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                    }
                    markUpdated();
                }
            }
            this.mTextBreakStrategy = 1;
            markUpdated();
        }
    }

    @ReactProp(name = "textShadowOffset")
    public void setTextShadowOffset(ReadableMap readableMap) {
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey("width") && !readableMap.isNull("width")) {
                this.mTextShadowOffsetDx = PixelUtil.toPixelFromDIP(readableMap.getDouble("width"));
            }
            if (readableMap.hasKey("height") && !readableMap.isNull("height")) {
                this.mTextShadowOffsetDy = PixelUtil.toPixelFromDIP(readableMap.getDouble("height"));
            }
        }
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "textShadowRadius")
    public void setTextShadowRadius(float f) {
        if (f != this.mTextShadowRadius) {
            this.mTextShadowRadius = f;
            markUpdated();
        }
    }

    @ReactProp(customType = "Color", defaultInt = 1426063360, name = "textShadowColor")
    public void setTextShadowColor(int i) {
        if (i != this.mTextShadowColor) {
            this.mTextShadowColor = i;
            markUpdated();
        }
    }
}

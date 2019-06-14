package com.facebook.react.uimanager;

import java.util.Arrays;
import java.util.HashSet;

public class ViewProps {
    public static final String ALIGN_CONTENT = "alignContent";
    public static final String ALIGN_ITEMS = "alignItems";
    public static final String ALIGN_SELF = "alignSelf";
    public static final String ALLOW_FONT_SCALING = "allowFontScaling";
    public static final String ASPECT_RATIO = "aspectRatio";
    public static final String AUTO = "auto";
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String BORDER_BOTTOM_COLOR = "borderBottomColor";
    public static final String BORDER_BOTTOM_END_RADIUS = "borderBottomEndRadius";
    public static final String BORDER_BOTTOM_LEFT_RADIUS = "borderBottomLeftRadius";
    public static final String BORDER_BOTTOM_RIGHT_RADIUS = "borderBottomRightRadius";
    public static final String BORDER_BOTTOM_START_RADIUS = "borderBottomStartRadius";
    public static final String BORDER_BOTTOM_WIDTH = "borderBottomWidth";
    public static final String BORDER_COLOR = "borderColor";
    public static final String BORDER_END_COLOR = "borderEndColor";
    public static final String BORDER_END_WIDTH = "borderEndWidth";
    public static final String BORDER_LEFT_COLOR = "borderLeftColor";
    public static final String BORDER_LEFT_WIDTH = "borderLeftWidth";
    public static final String BORDER_RADIUS = "borderRadius";
    public static final String BORDER_RIGHT_COLOR = "borderRightColor";
    public static final String BORDER_RIGHT_WIDTH = "borderRightWidth";
    public static final int[] BORDER_SPACING_TYPES = new int[]{8, 4, 5, 1, 3, 0, 2};
    public static final String BORDER_START_COLOR = "borderStartColor";
    public static final String BORDER_START_WIDTH = "borderStartWidth";
    public static final String BORDER_TOP_COLOR = "borderTopColor";
    public static final String BORDER_TOP_END_RADIUS = "borderTopEndRadius";
    public static final String BORDER_TOP_LEFT_RADIUS = "borderTopLeftRadius";
    public static final String BORDER_TOP_RIGHT_RADIUS = "borderTopRightRadius";
    public static final String BORDER_TOP_START_RADIUS = "borderTopStartRadius";
    public static final String BORDER_TOP_WIDTH = "borderTopWidth";
    public static final String BORDER_WIDTH = "borderWidth";
    public static final String BOTTOM = "bottom";
    public static final String BOX_NONE = "box-none";
    public static final String COLLAPSABLE = "collapsable";
    public static final String COLOR = "color";
    public static final String DISPLAY = "display";
    public static final String ELLIPSIZE_MODE = "ellipsizeMode";
    public static final String ENABLED = "enabled";
    public static final String END = "end";
    public static final String FLEX = "flex";
    public static final String FLEX_BASIS = "flexBasis";
    public static final String FLEX_DIRECTION = "flexDirection";
    public static final String FLEX_GROW = "flexGrow";
    public static final String FLEX_SHRINK = "flexShrink";
    public static final String FLEX_WRAP = "flexWrap";
    public static final String FONT_FAMILY = "fontFamily";
    public static final String FONT_SIZE = "fontSize";
    public static final String FONT_STYLE = "fontStyle";
    public static final String FONT_WEIGHT = "fontWeight";
    public static final String HEIGHT = "height";
    public static final String HIDDEN = "hidden";
    public static final String INCLUDE_FONT_PADDING = "includeFontPadding";
    public static final String JUSTIFY_CONTENT = "justifyContent";
    private static final HashSet<String> LAYOUT_ONLY_PROPS = new HashSet(Arrays.asList(new String[]{ALIGN_SELF, ALIGN_ITEMS, COLLAPSABLE, FLEX, FLEX_BASIS, FLEX_DIRECTION, FLEX_GROW, FLEX_SHRINK, FLEX_WRAP, JUSTIFY_CONTENT, ALIGN_CONTENT, "display", POSITION, RIGHT, TOP, BOTTOM, LEFT, START, END, "width", "height", MIN_WIDTH, MAX_WIDTH, MIN_HEIGHT, MAX_HEIGHT, MARGIN, MARGIN_VERTICAL, MARGIN_HORIZONTAL, MARGIN_LEFT, MARGIN_RIGHT, MARGIN_TOP, MARGIN_BOTTOM, MARGIN_START, MARGIN_END, PADDING, PADDING_VERTICAL, PADDING_HORIZONTAL, PADDING_LEFT, PADDING_RIGHT, PADDING_TOP, PADDING_BOTTOM, PADDING_START, PADDING_END}));
    public static final String LEFT = "left";
    public static final String LETTER_SPACING = "letterSpacing";
    public static final String LINE_HEIGHT = "lineHeight";
    public static final String MARGIN = "margin";
    public static final String MARGIN_BOTTOM = "marginBottom";
    public static final String MARGIN_END = "marginEnd";
    public static final String MARGIN_HORIZONTAL = "marginHorizontal";
    public static final String MARGIN_LEFT = "marginLeft";
    public static final String MARGIN_RIGHT = "marginRight";
    public static final String MARGIN_START = "marginStart";
    public static final String MARGIN_TOP = "marginTop";
    public static final String MARGIN_VERTICAL = "marginVertical";
    public static final String MAX_HEIGHT = "maxHeight";
    public static final String MAX_WIDTH = "maxWidth";
    public static final String MIN_HEIGHT = "minHeight";
    public static final String MIN_WIDTH = "minWidth";
    public static final String NEEDS_OFFSCREEN_ALPHA_COMPOSITING = "needsOffscreenAlphaCompositing";
    public static final String NONE = "none";
    public static final String NUMBER_OF_LINES = "numberOfLines";
    public static final String ON = "on";
    public static final String ON_LAYOUT = "onLayout";
    public static final String OPACITY = "opacity";
    public static final String OVERFLOW = "overflow";
    public static final String PADDING = "padding";
    public static final String PADDING_BOTTOM = "paddingBottom";
    public static final String PADDING_END = "paddingEnd";
    public static final String PADDING_HORIZONTAL = "paddingHorizontal";
    public static final String PADDING_LEFT = "paddingLeft";
    public static final int[] PADDING_MARGIN_SPACING_TYPES = new int[]{8, 7, 6, 4, 5, 1, 3, 0, 2};
    public static final String PADDING_RIGHT = "paddingRight";
    public static final String PADDING_START = "paddingStart";
    public static final String PADDING_TOP = "paddingTop";
    public static final String PADDING_VERTICAL = "paddingVertical";
    public static final String POINTER_EVENTS = "pointerEvents";
    public static final String POSITION = "position";
    public static final int[] POSITION_SPACING_TYPES = new int[]{4, 5, 1, 3};
    public static final String RESIZE_METHOD = "resizeMethod";
    public static final String RESIZE_MODE = "resizeMode";
    public static final String RIGHT = "right";
    public static final String SCROLL = "scroll";
    public static final String START = "start";
    public static final String TEXT_ALIGN = "textAlign";
    public static final String TEXT_ALIGN_VERTICAL = "textAlignVertical";
    public static final String TEXT_BREAK_STRATEGY = "textBreakStrategy";
    public static final String TEXT_DECORATION_LINE = "textDecorationLine";
    public static final String TOP = "top";
    public static final String VIEW_CLASS_NAME = "RCTView";
    public static final String VISIBLE = "visible";
    public static final String WIDTH = "width";
    public static boolean sDefaultOverflowHidden;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isLayoutOnly(com.facebook.react.bridge.ReadableMap r5, java.lang.String r6) {
        /*
        r0 = LAYOUT_ONLY_PROPS;
        r0 = r0.contains(r6);
        r1 = 1;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = "pointerEvents";
        r0 = r0.equals(r6);
        r2 = 0;
        if (r0 == 0) goto L_0x002a;
    L_0x0013:
        r5 = r5.getString(r6);
        r6 = "auto";
        r6 = r6.equals(r5);
        if (r6 != 0) goto L_0x0029;
    L_0x001f:
        r6 = "box-none";
        r5 = r6.equals(r5);
        if (r5 == 0) goto L_0x0028;
    L_0x0027:
        goto L_0x0029;
    L_0x0028:
        r1 = 0;
    L_0x0029:
        return r1;
    L_0x002a:
        r0 = -1;
        r3 = r6.hashCode();
        switch(r3) {
            case -1989576717: goto L_0x00a8;
            case -1971292586: goto L_0x009d;
            case -1470826662: goto L_0x0093;
            case -1452542531: goto L_0x0088;
            case -1308858324: goto L_0x007e;
            case -1290574193: goto L_0x0073;
            case -1267206133: goto L_0x0069;
            case -242276144: goto L_0x005f;
            case -223992013: goto L_0x0055;
            case 529642498: goto L_0x004a;
            case 741115130: goto L_0x003f;
            case 1349188574: goto L_0x0034;
            default: goto L_0x0032;
        };
    L_0x0032:
        goto L_0x00b2;
    L_0x0034:
        r3 = "borderRadius";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x003c:
        r6 = 1;
        goto L_0x00b3;
    L_0x003f:
        r3 = "borderWidth";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x0047:
        r6 = 6;
        goto L_0x00b3;
    L_0x004a:
        r3 = "overflow";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x0052:
        r6 = 11;
        goto L_0x00b3;
    L_0x0055:
        r3 = "borderLeftWidth";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x005d:
        r6 = 7;
        goto L_0x00b3;
    L_0x005f:
        r3 = "borderLeftColor";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x0067:
        r6 = 2;
        goto L_0x00b3;
    L_0x0069:
        r3 = "opacity";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x0071:
        r6 = 0;
        goto L_0x00b3;
    L_0x0073:
        r3 = "borderBottomWidth";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x007b:
        r6 = 10;
        goto L_0x00b3;
    L_0x007e:
        r3 = "borderBottomColor";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x0086:
        r6 = 5;
        goto L_0x00b3;
    L_0x0088:
        r3 = "borderTopWidth";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x0090:
        r6 = 8;
        goto L_0x00b3;
    L_0x0093:
        r3 = "borderTopColor";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x009b:
        r6 = 4;
        goto L_0x00b3;
    L_0x009d:
        r3 = "borderRightWidth";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x00a5:
        r6 = 9;
        goto L_0x00b3;
    L_0x00a8:
        r3 = "borderRightColor";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b2;
    L_0x00b0:
        r6 = 3;
        goto L_0x00b3;
    L_0x00b2:
        r6 = -1;
    L_0x00b3:
        r3 = 0;
        switch(r6) {
            case 0: goto L_0x0194;
            case 1: goto L_0x0167;
            case 2: goto L_0x015c;
            case 3: goto L_0x0151;
            case 4: goto L_0x0146;
            case 5: goto L_0x013b;
            case 6: goto L_0x0126;
            case 7: goto L_0x0111;
            case 8: goto L_0x00fc;
            case 9: goto L_0x00e7;
            case 10: goto L_0x00d2;
            case 11: goto L_0x00b9;
            default: goto L_0x00b8;
        };
    L_0x00b8:
        return r2;
    L_0x00b9:
        r6 = "overflow";
        r6 = r5.isNull(r6);
        if (r6 != 0) goto L_0x00d1;
    L_0x00c1:
        r6 = "visible";
        r0 = "overflow";
        r5 = r5.getString(r0);
        r5 = r6.equals(r5);
        if (r5 == 0) goto L_0x00d0;
    L_0x00cf:
        goto L_0x00d1;
    L_0x00d0:
        r1 = 0;
    L_0x00d1:
        return r1;
    L_0x00d2:
        r6 = "borderBottomWidth";
        r6 = r5.isNull(r6);
        if (r6 != 0) goto L_0x00e6;
    L_0x00da:
        r6 = "borderBottomWidth";
        r5 = r5.getDouble(r6);
        r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x00e5;
    L_0x00e4:
        goto L_0x00e6;
    L_0x00e5:
        r1 = 0;
    L_0x00e6:
        return r1;
    L_0x00e7:
        r6 = "borderRightWidth";
        r6 = r5.isNull(r6);
        if (r6 != 0) goto L_0x00fb;
    L_0x00ef:
        r6 = "borderRightWidth";
        r5 = r5.getDouble(r6);
        r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x00fa;
    L_0x00f9:
        goto L_0x00fb;
    L_0x00fa:
        r1 = 0;
    L_0x00fb:
        return r1;
    L_0x00fc:
        r6 = "borderTopWidth";
        r6 = r5.isNull(r6);
        if (r6 != 0) goto L_0x0110;
    L_0x0104:
        r6 = "borderTopWidth";
        r5 = r5.getDouble(r6);
        r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x010f;
    L_0x010e:
        goto L_0x0110;
    L_0x010f:
        r1 = 0;
    L_0x0110:
        return r1;
    L_0x0111:
        r6 = "borderLeftWidth";
        r6 = r5.isNull(r6);
        if (r6 != 0) goto L_0x0125;
    L_0x0119:
        r6 = "borderLeftWidth";
        r5 = r5.getDouble(r6);
        r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x0124;
    L_0x0123:
        goto L_0x0125;
    L_0x0124:
        r1 = 0;
    L_0x0125:
        return r1;
    L_0x0126:
        r6 = "borderWidth";
        r6 = r5.isNull(r6);
        if (r6 != 0) goto L_0x013a;
    L_0x012e:
        r6 = "borderWidth";
        r5 = r5.getDouble(r6);
        r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x0139;
    L_0x0138:
        goto L_0x013a;
    L_0x0139:
        r1 = 0;
    L_0x013a:
        return r1;
    L_0x013b:
        r6 = "borderBottomColor";
        r5 = r5.getInt(r6);
        if (r5 != 0) goto L_0x0144;
    L_0x0143:
        goto L_0x0145;
    L_0x0144:
        r1 = 0;
    L_0x0145:
        return r1;
    L_0x0146:
        r6 = "borderTopColor";
        r5 = r5.getInt(r6);
        if (r5 != 0) goto L_0x014f;
    L_0x014e:
        goto L_0x0150;
    L_0x014f:
        r1 = 0;
    L_0x0150:
        return r1;
    L_0x0151:
        r6 = "borderRightColor";
        r5 = r5.getInt(r6);
        if (r5 != 0) goto L_0x015a;
    L_0x0159:
        goto L_0x015b;
    L_0x015a:
        r1 = 0;
    L_0x015b:
        return r1;
    L_0x015c:
        r6 = "borderLeftColor";
        r5 = r5.getInt(r6);
        if (r5 != 0) goto L_0x0165;
    L_0x0164:
        goto L_0x0166;
    L_0x0165:
        r1 = 0;
    L_0x0166:
        return r1;
    L_0x0167:
        r6 = "backgroundColor";
        r6 = r5.hasKey(r6);
        if (r6 == 0) goto L_0x0178;
    L_0x016f:
        r6 = "backgroundColor";
        r6 = r5.getInt(r6);
        if (r6 == 0) goto L_0x0178;
    L_0x0177:
        return r2;
    L_0x0178:
        r6 = "borderWidth";
        r6 = r5.hasKey(r6);
        if (r6 == 0) goto L_0x0193;
    L_0x0180:
        r6 = "borderWidth";
        r6 = r5.isNull(r6);
        if (r6 != 0) goto L_0x0193;
    L_0x0188:
        r6 = "borderWidth";
        r5 = r5.getDouble(r6);
        r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x0193;
    L_0x0192:
        return r2;
    L_0x0193:
        return r1;
    L_0x0194:
        r6 = "opacity";
        r6 = r5.isNull(r6);
        if (r6 != 0) goto L_0x01aa;
    L_0x019c:
        r6 = "opacity";
        r5 = r5.getDouble(r6);
        r3 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x01a9;
    L_0x01a8:
        goto L_0x01aa;
    L_0x01a9:
        r1 = 0;
    L_0x01aa:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ViewProps.isLayoutOnly(com.facebook.react.bridge.ReadableMap, java.lang.String):boolean");
    }
}

package versioned.host.exp.exponent.modules.api.components.svg;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;

class FontData {
    static final double DEFAULT_FONT_SIZE = 12.0d;
    private static final double DEFAULT_KERNING = 0.0d;
    private static final double DEFAULT_LETTER_SPACING = 0.0d;
    private static final double DEFAULT_WORD_SPACING = 0.0d;
    static final FontData Defaults = new FontData();
    private static final String FONT_DATA = "fontData";
    private static final String FONT_FEATURE_SETTINGS = "fontFeatureSettings";
    private static final String FONT_VARIANT_LIGATURES = "fontVariantLigatures";
    private static final String KERNING = "kerning";
    private static final String LETTER_SPACING = "letterSpacing";
    private static final String TEXT_ANCHOR = "textAnchor";
    private static final String TEXT_DECORATION = "textDecoration";
    private static final String WORD_SPACING = "wordSpacing";
    final ReadableMap fontData;
    final String fontFamily;
    final String fontFeatureSettings;
    final double fontSize;
    final FontStyle fontStyle;
    final FontVariantLigatures fontVariantLigatures;
    final FontWeight fontWeight;
    final double kerning;
    final double letterSpacing;
    final boolean manualKerning;
    final TextAnchor textAnchor;
    private final TextDecoration textDecoration;
    final double wordSpacing;

    private FontData() {
        this.fontData = null;
        this.fontFamily = "";
        this.fontStyle = FontStyle.normal;
        this.fontWeight = FontWeight.Normal;
        this.fontFeatureSettings = "";
        this.fontVariantLigatures = FontVariantLigatures.normal;
        this.textAnchor = TextAnchor.start;
        this.textDecoration = TextDecoration.None;
        this.manualKerning = false;
        this.kerning = 0.0d;
        this.fontSize = DEFAULT_FONT_SIZE;
        this.wordSpacing = 0.0d;
        this.letterSpacing = 0.0d;
    }

    private double toAbsolute(String str, double d, double d2) {
        return PropHelper.fromRelative(str, 0.0d, 0.0d, d, d2);
    }

    FontData(ReadableMap readableMap, FontData fontData, double d) {
        boolean z;
        double d2 = fontData.fontSize;
        if (readableMap.hasKey(ViewProps.FONT_SIZE)) {
            this.fontSize = PropHelper.fromRelative(readableMap.getString(ViewProps.FONT_SIZE), d2, 0.0d, 1.0d, d2);
        } else {
            this.fontSize = d2;
        }
        this.fontData = readableMap.hasKey(FONT_DATA) ? readableMap.getMap(FONT_DATA) : fontData.fontData;
        this.fontFamily = readableMap.hasKey(ViewProps.FONT_FAMILY) ? readableMap.getString(ViewProps.FONT_FAMILY) : fontData.fontFamily;
        this.fontStyle = readableMap.hasKey(ViewProps.FONT_STYLE) ? FontStyle.valueOf(readableMap.getString(ViewProps.FONT_STYLE)) : fontData.fontStyle;
        this.fontWeight = readableMap.hasKey(ViewProps.FONT_WEIGHT) ? FontWeight.getEnum(readableMap.getString(ViewProps.FONT_WEIGHT)) : fontData.fontWeight;
        this.fontFeatureSettings = readableMap.hasKey(FONT_FEATURE_SETTINGS) ? readableMap.getString(FONT_FEATURE_SETTINGS) : fontData.fontFeatureSettings;
        this.fontVariantLigatures = readableMap.hasKey(FONT_VARIANT_LIGATURES) ? FontVariantLigatures.valueOf(readableMap.getString(FONT_VARIANT_LIGATURES)) : fontData.fontVariantLigatures;
        this.textAnchor = readableMap.hasKey(TEXT_ANCHOR) ? TextAnchor.valueOf(readableMap.getString(TEXT_ANCHOR)) : fontData.textAnchor;
        this.textDecoration = readableMap.hasKey(TEXT_DECORATION) ? TextDecoration.getEnum(readableMap.getString(TEXT_DECORATION)) : fontData.textDecoration;
        boolean hasKey = readableMap.hasKey(KERNING);
        if (!hasKey) {
            if (!fontData.manualKerning) {
                z = false;
                this.manualKerning = z;
                this.kerning = hasKey ? toAbsolute(readableMap.getString(KERNING), d, this.fontSize) : fontData.kerning;
                this.wordSpacing = readableMap.hasKey(WORD_SPACING) ? toAbsolute(readableMap.getString(WORD_SPACING), d, this.fontSize) : fontData.wordSpacing;
                this.letterSpacing = readableMap.hasKey("letterSpacing") ? toAbsolute(readableMap.getString("letterSpacing"), d, this.fontSize) : fontData.letterSpacing;
            }
        }
        z = true;
        this.manualKerning = z;
        if (hasKey) {
        }
        this.kerning = hasKey ? toAbsolute(readableMap.getString(KERNING), d, this.fontSize) : fontData.kerning;
        if (readableMap.hasKey(WORD_SPACING)) {
        }
        this.wordSpacing = readableMap.hasKey(WORD_SPACING) ? toAbsolute(readableMap.getString(WORD_SPACING), d, this.fontSize) : fontData.wordSpacing;
        if (readableMap.hasKey("letterSpacing")) {
        }
        this.letterSpacing = readableMap.hasKey("letterSpacing") ? toAbsolute(readableMap.getString("letterSpacing"), d, this.fontSize) : fontData.letterSpacing;
    }
}

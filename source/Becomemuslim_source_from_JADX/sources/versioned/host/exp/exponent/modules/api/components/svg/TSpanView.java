package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class TSpanView extends TextView {
    private static final String FONTS = "fonts/";
    private static final String OTF = ".otf";
    private static final String TTF = ".ttf";
    private static final double radToDeg = 57.29577951308232d;
    private static final double tau = 6.283185307179586d;
    private Path mCache;
    String mContent;
    private TextPathView textPath;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.svg.TSpanView$1 */
    static /* synthetic */ class C67471 {
        /* renamed from: $SwitchMap$versioned$host$exp$exponent$modules$api$components$svg$TextProperties$TextLengthAdjust */
        static final /* synthetic */ int[] f23509xa45a5cfe = new int[TextLengthAdjust.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.TextAnchor.values();
            r0 = r0.length;
            r0 = new int[r0];
            f23508x482da85e = r0;
            r0 = 1;
            r1 = f23508x482da85e;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.TextAnchor.start;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2;
            r2 = f23508x482da85e;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.TextAnchor.middle;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3;
            r3 = f23508x482da85e;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.TextAnchor.end;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.values();
            r3 = r3.length;
            r3 = new int[r3];
            f23507xc8f7ac = r3;
            r3 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x003d }
            r4 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.baseline;	 Catch:{ NoSuchFieldError -> 0x003d }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x003d }
            r3[r4] = r0;	 Catch:{ NoSuchFieldError -> 0x003d }
        L_0x003d:
            r3 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x0047 }
            r4 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.textBottom;	 Catch:{ NoSuchFieldError -> 0x0047 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0047 }
            r3[r4] = r1;	 Catch:{ NoSuchFieldError -> 0x0047 }
        L_0x0047:
            r3 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x0051 }
            r4 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.afterEdge;	 Catch:{ NoSuchFieldError -> 0x0051 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0051 }
            r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x0051 }
        L_0x0051:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x005c }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.textAfterEdge;	 Catch:{ NoSuchFieldError -> 0x005c }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x005c }
            r4 = 4;	 Catch:{ NoSuchFieldError -> 0x005c }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x005c }
        L_0x005c:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x0067 }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.alphabetic;	 Catch:{ NoSuchFieldError -> 0x0067 }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x0067 }
            r4 = 5;	 Catch:{ NoSuchFieldError -> 0x0067 }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x0067 }
        L_0x0067:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x0072 }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.ideographic;	 Catch:{ NoSuchFieldError -> 0x0072 }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x0072 }
            r4 = 6;	 Catch:{ NoSuchFieldError -> 0x0072 }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x0072 }
        L_0x0072:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x007d }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.middle;	 Catch:{ NoSuchFieldError -> 0x007d }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x007d }
            r4 = 7;	 Catch:{ NoSuchFieldError -> 0x007d }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x007d }
        L_0x007d:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x0089 }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.central;	 Catch:{ NoSuchFieldError -> 0x0089 }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x0089 }
            r4 = 8;	 Catch:{ NoSuchFieldError -> 0x0089 }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x0089 }
        L_0x0089:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x0095 }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.mathematical;	 Catch:{ NoSuchFieldError -> 0x0095 }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x0095 }
            r4 = 9;	 Catch:{ NoSuchFieldError -> 0x0095 }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x0095 }
        L_0x0095:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x00a1 }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.hanging;	 Catch:{ NoSuchFieldError -> 0x00a1 }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x00a1 }
            r4 = 10;	 Catch:{ NoSuchFieldError -> 0x00a1 }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x00a1 }
        L_0x00a1:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x00ad }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.textTop;	 Catch:{ NoSuchFieldError -> 0x00ad }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x00ad }
            r4 = 11;	 Catch:{ NoSuchFieldError -> 0x00ad }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x00ad }
        L_0x00ad:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x00b9 }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.beforeEdge;	 Catch:{ NoSuchFieldError -> 0x00b9 }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x00b9 }
            r4 = 12;	 Catch:{ NoSuchFieldError -> 0x00b9 }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x00b9 }
        L_0x00b9:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x00c5 }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.textBeforeEdge;	 Catch:{ NoSuchFieldError -> 0x00c5 }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x00c5 }
            r4 = 13;	 Catch:{ NoSuchFieldError -> 0x00c5 }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x00c5 }
        L_0x00c5:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x00d1 }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.bottom;	 Catch:{ NoSuchFieldError -> 0x00d1 }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x00d1 }
            r4 = 14;	 Catch:{ NoSuchFieldError -> 0x00d1 }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x00d1 }
        L_0x00d1:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x00dd }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.center;	 Catch:{ NoSuchFieldError -> 0x00dd }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x00dd }
            r4 = 15;	 Catch:{ NoSuchFieldError -> 0x00dd }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x00dd }
        L_0x00dd:
            r2 = f23507xc8f7ac;	 Catch:{ NoSuchFieldError -> 0x00e9 }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.top;	 Catch:{ NoSuchFieldError -> 0x00e9 }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x00e9 }
            r4 = 16;	 Catch:{ NoSuchFieldError -> 0x00e9 }
            r2[r3] = r4;	 Catch:{ NoSuchFieldError -> 0x00e9 }
        L_0x00e9:
            r2 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.TextLengthAdjust.values();
            r2 = r2.length;
            r2 = new int[r2];
            f23509xa45a5cfe = r2;
            r2 = f23509xa45a5cfe;	 Catch:{ NoSuchFieldError -> 0x00fc }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.TextLengthAdjust.spacing;	 Catch:{ NoSuchFieldError -> 0x00fc }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x00fc }
            r2[r3] = r0;	 Catch:{ NoSuchFieldError -> 0x00fc }
        L_0x00fc:
            r0 = f23509xa45a5cfe;	 Catch:{ NoSuchFieldError -> 0x0106 }
            r2 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.TextLengthAdjust.spacingAndGlyphs;	 Catch:{ NoSuchFieldError -> 0x0106 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0106 }
            r0[r2] = r1;	 Catch:{ NoSuchFieldError -> 0x0106 }
        L_0x0106:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.components.svg.TSpanView.1.<clinit>():void");
        }
    }

    public TSpanView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "content")
    public void setContent(String str) {
        this.mContent = str;
        invalidate();
    }

    void draw(Canvas canvas, Paint paint, float f) {
        if (this.mContent != null) {
            drawPath(canvas, paint, f);
            return;
        }
        clip(canvas, paint);
        drawGroup(canvas, paint, f);
    }

    void releaseCachedPath() {
        this.mCache = null;
        this.mPath = null;
    }

    Path getPath(Canvas canvas, Paint paint) {
        if (this.mCache != null) {
            return this.mCache;
        }
        if (this.mContent == null) {
            return getGroupPath(canvas, paint);
        }
        setupTextPath();
        pushGlyphContext();
        this.mCache = getLinePath(this.mContent, paint, canvas);
        popGlyphContext();
        return this.mCache;
    }

    private Path getLinePath(String str, Paint paint, Canvas canvas) {
        TSpanView tSpanView = this;
        String str2 = str;
        Paint paint2 = paint;
        Canvas canvas2 = canvas;
        int length = str.length();
        Path path = new Path();
        if (length == 0) {
            return path;
        }
        PathMeasure pathMeasure;
        double length2;
        double d;
        boolean z;
        PathMeasure pathMeasure2;
        GlyphPathBag glyphPathBag;
        Object obj;
        boolean[] zArr;
        ReadableMap readableMap;
        float[] fArr;
        TextAnchor textAnchor;
        double measureText;
        double textAnchorOffset;
        double fontSize;
        Object obj2;
        GlyphPathBag glyphPathBag2;
        boolean[] zArr2;
        double d2;
        Object obj3;
        int i;
        double d3;
        FontMetrics fontMetrics;
        double d4;
        int i2;
        Object obj4;
        double d5;
        double d6;
        double d7;
        String baselineShift;
        AlignmentBaseline alignmentBaseline;
        int i3;
        Matrix matrix;
        Matrix matrix2;
        Matrix matrix3;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        int i4;
        String str3;
        int i5;
        int i6;
        float[] fArr5;
        int i7;
        double measureText2;
        double d8;
        Object obj5;
        double d9;
        double d10;
        GlyphContext glyphContext;
        Matrix matrix4;
        int i8;
        float[] fArr6;
        float[] fArr7;
        Path path2;
        GlyphPathBag glyphPathBag3;
        PathMeasure pathMeasure3;
        Matrix matrix5;
        Path path3;
        RectF rectF;
        Object obj6 = tSpanView.textPath != null ? 1 : null;
        if (obj6 != null) {
            pathMeasure = new PathMeasure(tSpanView.textPath.getTextPath(canvas2, paint2), false);
            length2 = (double) pathMeasure.getLength();
            boolean isClosed = pathMeasure.isClosed();
            if (length2 == 0.0d) {
                return path;
            }
            d = length2;
            z = isClosed;
            pathMeasure2 = pathMeasure;
        } else {
            pathMeasure2 = null;
            d = 0.0d;
            z = false;
        }
        GlyphContext textRootGlyphContext = getTextRootGlyphContext();
        FontData font = textRootGlyphContext.getFont();
        applyTextPropertiesToPaint(paint2, font);
        GlyphPathBag glyphPathBag4 = new GlyphPathBag(paint2);
        boolean[] zArr3 = new boolean[length];
        char[] toCharArray = str.toCharArray();
        Path path4 = path;
        double d11 = font.kerning;
        double d12 = font.wordSpacing;
        double d13 = font.letterSpacing;
        int i9 = font.manualKerning ^ 1;
        StringBuilder stringBuilder;
        String stringBuilder2;
        double d14;
        TextAnchor textAnchor2;
        float[] fArr8;
        PathMeasure pathMeasure4;
        GlyphContext glyphContext2;
        double d15;
        double d16;
        ReadableMap map;
        String valueOf;
        boolean z2;
        Object obj7;
        GlyphContext glyphContext3;
        char c;
        double nextY;
        double nextDeltaX;
        double nextDeltaY;
        double d17;
        double d18;
        PathMeasure pathMeasure5;
        String str4;
        int i10;
        float[] fArr9;
        double d19;
        float[] fArr10;
        Paint paint3;
        Canvas canvas3;
        float f;
        double d20;
        float[] fArr11;
        GlyphPathBag glyphPathBag5;
        String str5;
        if (d13 == 0.0d) {
            glyphPathBag = glyphPathBag4;
            if (font.fontVariantLigatures == FontVariantLigatures.normal) {
                obj = 1;
                zArr = zArr3;
                if (VERSION.SDK_INT >= 21) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk',");
                    stringBuilder.append("'kern', ");
                    stringBuilder2 = stringBuilder.toString();
                    if (obj == null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(stringBuilder2);
                        stringBuilder.append("'hlig', 'cala', ");
                        stringBuilder.append(font.fontFeatureSettings);
                        paint2.setFontFeatureSettings(stringBuilder.toString());
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(stringBuilder2);
                        stringBuilder.append("'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, ");
                        stringBuilder.append(font.fontFeatureSettings);
                        paint2.setFontFeatureSettings(stringBuilder.toString());
                    }
                }
                readableMap = font.fontData;
                fArr = new float[length];
                paint2.getTextWidths(str2, fArr);
                textAnchor = font.textAnchor;
                measureText = (double) paint2.measureText(str2);
                textAnchorOffset = getTextAnchorOffset(textAnchor, measureText);
                fontSize = textRootGlyphContext.getFontSize();
                obj2 = -1;
                if (obj6 == null) {
                    d14 = measureText;
                    Object obj8 = tSpanView.textPath.getMidLine() != TextPathMidLine.sharp ? 1 : null;
                    int i11 = tSpanView.textPath.getSide() != TextPathSide.right ? -1 : 1;
                    textAnchor2 = textAnchor;
                    glyphPathBag2 = glyphPathBag;
                    zArr2 = zArr;
                    fArr8 = fArr;
                    pathMeasure4 = pathMeasure2;
                    glyphContext2 = textRootGlyphContext;
                    measureText = getAbsoluteStartOffset(tSpanView.textPath.getStartOffset(), d, fontSize);
                    textAnchorOffset += measureText;
                    if (z) {
                        length2 = d;
                        d2 = 0.0d;
                    } else {
                        measureText += textAnchor2 != TextAnchor.middle ? -(d / 2.0d) : 0.0d;
                        length2 = measureText + d;
                        d2 = measureText;
                    }
                    obj3 = obj8;
                    i = i11;
                } else {
                    d14 = measureText;
                    pathMeasure4 = pathMeasure2;
                    glyphContext2 = textRootGlyphContext;
                    glyphPathBag2 = glyphPathBag;
                    zArr2 = zArr;
                    fArr8 = fArr;
                    length2 = d;
                    d2 = 0.0d;
                    i = 1;
                    obj3 = null;
                }
                d3 = 1.0d;
                if (tSpanView.mTextLength == null) {
                    d15 = d;
                    d16 = d2;
                    d2 = PropHelper.fromRelative(tSpanView.mTextLength, (double) canvas.getWidth(), 0.0d, (double) tSpanView.mScale, fontSize);
                    if (d2 >= 0.0d) {
                        throw new IllegalArgumentException("Negative textLength value");
                    } else if (C67471.f23509xa45a5cfe[tSpanView.mLengthAdjust.ordinal()] == 2) {
                        d13 += (d2 - d14) / ((double) (length - 1));
                    } else {
                        d3 = d2 / d14;
                    }
                } else {
                    d16 = d2;
                    d15 = d;
                }
                d2 = d13;
                d13 = (double) i;
                d = d3 * d13;
                fontMetrics = paint.getFontMetrics();
                d4 = d;
                d = (double) fontMetrics.descent;
                i2 = i;
                obj4 = obj3;
                measureText = ((double) fontMetrics.leading) + d;
                d5 = length2;
                length2 = (double) ((-fontMetrics.ascent) + fontMetrics.leading);
                d6 = d13;
                d13 = (double) (-fontMetrics.top);
                d7 = d13 + measureText;
                baselineShift = getBaselineShift();
                alignmentBaseline = getAlignmentBaseline();
                if (alignmentBaseline != null) {
                    switch (alignmentBaseline) {
                        case textBottom:
                        case afterEdge:
                        case textAfterEdge:
                            measureText = -d;
                            break;
                        case alphabetic:
                            break;
                        case ideographic:
                            measureText = -d;
                            break;
                        case middle:
                            Rect rect = new Rect();
                            paint2.getTextBounds("x", 0, 1, rect);
                            measureText = (double) (rect.height() / 2);
                            break;
                        case central:
                            measureText = (length2 - d) / 2.0d;
                            break;
                        case mathematical:
                            measureText = 0.5d * length2;
                            break;
                        case hanging:
                            measureText = 0.8d * length2;
                            break;
                        case textTop:
                        case beforeEdge:
                        case textBeforeEdge:
                            measureText = length2;
                            break;
                        case bottom:
                            break;
                        case center:
                            measureText = d7 / 2.0d;
                            break;
                        case top:
                            measureText = d13;
                            break;
                        default:
                            break;
                    }
                }
                measureText = 0.0d;
                if (!(baselineShift == null || baselineShift.isEmpty())) {
                    i3 = C67471.f23507xc8f7ac[alignmentBaseline.ordinal()];
                    if (!(i3 == 14 || i3 == 16)) {
                        i3 = baselineShift.hashCode();
                        if (i3 == -1720785339) {
                            if (i3 == 114240) {
                                if (i3 != 109801339) {
                                    if (baselineShift.equals("super")) {
                                        obj2 = 1;
                                    }
                                }
                            } else if (baselineShift.equals("sub")) {
                                obj2 = null;
                            }
                        } else if (baselineShift.equals("baseline")) {
                            obj2 = 2;
                        }
                        switch (obj2) {
                            case null:
                                if (readableMap != null && readableMap.hasKey("tables") && readableMap.hasKey("unitsPerEm")) {
                                    i3 = readableMap.getInt("unitsPerEm");
                                    map = readableMap.getMap("tables");
                                    if (map.hasKey("os2")) {
                                        map = map.getMap("os2");
                                        if (map.hasKey("ySubscriptYOffset")) {
                                            measureText += ((((double) tSpanView.mScale) * fontSize) * map.getDouble("ySubscriptYOffset")) / ((double) i3);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 1:
                                if (readableMap != null && readableMap.hasKey("tables") && readableMap.hasKey("unitsPerEm")) {
                                    i3 = readableMap.getInt("unitsPerEm");
                                    map = readableMap.getMap("tables");
                                    if (map.hasKey("os2")) {
                                        map = map.getMap("os2");
                                        if (map.hasKey("ySuperscriptYOffset")) {
                                            measureText -= ((((double) tSpanView.mScale) * fontSize) * map.getDouble("ySuperscriptYOffset")) / ((double) i3);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 2:
                                break;
                            default:
                                measureText -= PropHelper.fromRelative(baselineShift, ((double) tSpanView.mScale) * fontSize, 0.0d, (double) tSpanView.mScale, fontSize);
                                break;
                        }
                    }
                }
                matrix = new Matrix();
                matrix2 = new Matrix();
                matrix3 = new Matrix();
                fArr2 = new float[9];
                fArr3 = new float[9];
                fArr4 = new float[9];
                i4 = 0;
                while (i4 < length) {
                    char c2 = toCharArray[i4];
                    valueOf = String.valueOf(c2);
                    z2 = zArr2[i4];
                    if (z2) {
                        str3 = valueOf;
                        obj7 = null;
                        i5 = i4;
                        while (true) {
                            i6 = i5 + 1;
                            if (i6 >= length) {
                                if (fArr8[i6] > 0.0f) {
                                    StringBuilder stringBuilder3 = new StringBuilder();
                                    fArr5 = fArr3;
                                    stringBuilder3.append(str3);
                                    stringBuilder3.append(String.valueOf(toCharArray[i6]));
                                    str3 = stringBuilder3.toString();
                                    zArr2[i6] = true;
                                    i5 = i6;
                                    fArr3 = fArr5;
                                    tSpanView = this;
                                    obj7 = 1;
                                }
                            }
                            fArr5 = fArr3;
                            stringBuilder2 = str3;
                        }
                    } else {
                        fArr5 = fArr3;
                        stringBuilder2 = "";
                        obj7 = null;
                    }
                    i7 = length;
                    measureText2 = ((double) paint2.measureText(stringBuilder2)) * d3;
                    if (i9 == 0) {
                        d8 = measureText;
                        d11 = (((double) fArr8[i4]) * d3) - measureText2;
                    } else {
                        d8 = measureText;
                    }
                    obj5 = c2 != ' ' ? 1 : null;
                    d9 = measureText2 + ((obj5 == null ? d12 : 0.0d) + d2);
                    if (z2) {
                        d10 = d2;
                        d2 = d11 + d9;
                    } else {
                        d10 = d2;
                        d2 = 0.0d;
                    }
                    glyphContext3 = glyphContext2;
                    d2 = glyphContext3.nextX(d2);
                    c = c2;
                    nextY = glyphContext3.nextY();
                    nextDeltaX = glyphContext3.nextDeltaX();
                    nextDeltaY = glyphContext3.nextDeltaY();
                    d17 = nextY;
                    nextY = glyphContext3.nextRotation();
                    if (!z2) {
                        if (obj5 != null) {
                            measureText2 *= d6;
                            d2 = (textAnchorOffset + ((d2 + nextDeltaX) * d6)) - (d9 * d6);
                            if (obj6 == null) {
                                glyphContext = glyphContext3;
                                measureText = d2 + measureText2;
                                measureText2 /= 2.0d;
                                d18 = nextY;
                                nextY = d2 + measureText2;
                                if (nextY <= d5) {
                                    if (nextY < d16) {
                                        if (obj4 == null) {
                                            pathMeasure = pathMeasure4;
                                            pathMeasure.getMatrix((float) nextY, matrix2, 3);
                                            pathMeasure5 = pathMeasure;
                                            matrix4 = matrix;
                                            str4 = stringBuilder2;
                                            i10 = i4;
                                            fArr9 = fArr4;
                                            d19 = d15;
                                        } else {
                                            pathMeasure5 = pathMeasure4;
                                            if (d2 >= 0.0d) {
                                                str4 = stringBuilder2;
                                                i10 = i4;
                                                pathMeasure5.getMatrix(0.0f, matrix, 3);
                                                matrix.preTranslate((float) d2, 0.0f);
                                                i4 = 1;
                                            } else {
                                                str4 = stringBuilder2;
                                                i10 = i4;
                                                i4 = 1;
                                                pathMeasure5.getMatrix((float) d2, matrix, 1);
                                            }
                                            pathMeasure5.getMatrix((float) nextY, matrix2, i4);
                                            if (measureText <= d15) {
                                                nextY = d15;
                                                pathMeasure5.getMatrix((float) nextY, matrix3, 3);
                                                matrix3.preTranslate((float) (measureText - nextY), 0.0f);
                                            } else {
                                                nextY = d15;
                                                pathMeasure5.getMatrix((float) measureText, matrix3, i4);
                                            }
                                            matrix.getValues(fArr2);
                                            matrix3.getValues(fArr4);
                                            matrix4 = matrix;
                                            d19 = nextY;
                                            fArr9 = fArr4;
                                            matrix2.preRotate((float) ((Math.atan2(((double) fArr4[5]) - ((double) fArr2[5]), ((double) fArr4[2]) - ((double) fArr2[2])) * radToDeg) * d6));
                                        }
                                        matrix2.preTranslate((float) (-measureText2), (float) (nextDeltaY + d8));
                                        measureText = d4;
                                        i6 = i2;
                                        matrix2.preScale((float) measureText, (float) i6);
                                        matrix2.postTranslate(0.0f, (float) d17);
                                    }
                                }
                                matrix4 = matrix;
                                i8 = i4;
                                fArr6 = fArr4;
                                fArr7 = fArr2;
                                path2 = path4;
                                glyphPathBag3 = glyphPathBag2;
                                pathMeasure3 = pathMeasure4;
                                measureText = d15;
                                d2 = d4;
                                i6 = i2;
                                d9 = d6;
                                fArr10 = fArr5;
                                i5 = i7;
                                paint3 = paint;
                                canvas3 = canvas;
                                matrix5 = matrix3;
                                d15 = measureText;
                                i2 = i6;
                                d4 = d2;
                                glyphPathBag2 = glyphPathBag3;
                                matrix3 = matrix5;
                                length = i5;
                                pathMeasure4 = pathMeasure3;
                                fArr4 = fArr6;
                                d6 = d9;
                                fArr2 = fArr7;
                                measureText = d8;
                                d2 = d10;
                                glyphContext2 = glyphContext;
                                tSpanView = this;
                                fArr3 = fArr10;
                                path4 = path2;
                                paint2 = paint3;
                                i4 = i8 + 1;
                                matrix = matrix4;
                            } else {
                                glyphContext = glyphContext3;
                                matrix4 = matrix;
                                str4 = stringBuilder2;
                                d18 = nextY;
                                i10 = i4;
                                fArr9 = fArr4;
                                pathMeasure5 = pathMeasure4;
                                d19 = d15;
                                measureText = d4;
                                i6 = i2;
                                matrix2.setTranslate((float) d2, (float) ((d17 + nextDeltaY) + d8));
                            }
                            d2 = d18;
                            f = (float) d2;
                            matrix2.preRotate(f);
                            if (obj7 == null) {
                                Path path5 = new Path();
                                d20 = d2;
                                i8 = i10;
                                double d21 = measureText;
                                measureText = d19;
                                d2 = d21;
                                fArr6 = fArr9;
                                pathMeasure3 = pathMeasure5;
                                d9 = d6;
                                fArr11 = fArr5;
                                fArr7 = fArr2;
                                path2 = path4;
                                matrix5 = matrix3;
                                i5 = i7;
                                paint.getTextPath(str4, 0, str4.length(), 0.0f, 0.0f, path5);
                                path3 = path5;
                                glyphPathBag5 = glyphPathBag2;
                                str5 = str4;
                            } else {
                                d20 = d2;
                                pathMeasure3 = pathMeasure5;
                                fArr7 = fArr2;
                                path2 = path4;
                                glyphPathBag5 = glyphPathBag2;
                                d9 = d6;
                                fArr11 = fArr5;
                                i5 = i7;
                                i8 = i10;
                                str5 = str4;
                                fArr6 = fArr9;
                                d2 = measureText;
                                matrix5 = matrix3;
                                measureText = d19;
                                path3 = glyphPathBag5.getOrCreateAndCache(c, str5);
                            }
                            rectF = new RectF();
                            path3.computeBounds(rectF, true);
                            if (rectF.width() != 0.0f) {
                                fArr10 = fArr11;
                                matrix2.getValues(fArr10);
                                String str6 = str5;
                                float f2 = (float) ((double) fArr10[2]);
                                float f3 = (float) ((double) fArr10[5]);
                                glyphPathBag3 = glyphPathBag5;
                                canvas3 = canvas;
                                canvas3.rotate(f, f2, f3);
                                paint3 = paint;
                                canvas3.drawText(str6, f2, f3, paint3);
                                canvas3.rotate((float) (-d20), f2, f3);
                            } else {
                                glyphPathBag3 = glyphPathBag5;
                                fArr10 = fArr11;
                                paint3 = paint;
                                canvas3 = canvas;
                                path3.transform(matrix2);
                                path2.addPath(path3);
                            }
                            d15 = measureText;
                            i2 = i6;
                            d4 = d2;
                            glyphPathBag2 = glyphPathBag3;
                            matrix3 = matrix5;
                            length = i5;
                            pathMeasure4 = pathMeasure3;
                            fArr4 = fArr6;
                            d6 = d9;
                            fArr2 = fArr7;
                            measureText = d8;
                            d2 = d10;
                            glyphContext2 = glyphContext;
                            tSpanView = this;
                            fArr3 = fArr10;
                            path4 = path2;
                            paint2 = paint3;
                            i4 = i8 + 1;
                            matrix = matrix4;
                        }
                    }
                    glyphContext = glyphContext3;
                    matrix4 = matrix;
                    i8 = i4;
                    fArr6 = fArr4;
                    fArr7 = fArr2;
                    path2 = path4;
                    glyphPathBag3 = glyphPathBag2;
                    pathMeasure3 = pathMeasure4;
                    measureText = d15;
                    d2 = d4;
                    i6 = i2;
                    d9 = d6;
                    fArr10 = fArr5;
                    i5 = i7;
                    paint3 = paint;
                    canvas3 = canvas;
                    matrix5 = matrix3;
                    d15 = measureText;
                    i2 = i6;
                    d4 = d2;
                    glyphPathBag2 = glyphPathBag3;
                    matrix3 = matrix5;
                    length = i5;
                    pathMeasure4 = pathMeasure3;
                    fArr4 = fArr6;
                    d6 = d9;
                    fArr2 = fArr7;
                    measureText = d8;
                    d2 = d10;
                    glyphContext2 = glyphContext;
                    tSpanView = this;
                    fArr3 = fArr10;
                    path4 = path2;
                    paint2 = paint3;
                    i4 = i8 + 1;
                    matrix = matrix4;
                }
                return path4;
            }
        }
        glyphPathBag = glyphPathBag4;
        obj = null;
        zArr = zArr3;
        if (VERSION.SDK_INT >= 21) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk',");
            stringBuilder.append("'kern', ");
            stringBuilder2 = stringBuilder.toString();
            if (obj == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2);
                stringBuilder.append("'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, ");
                stringBuilder.append(font.fontFeatureSettings);
                paint2.setFontFeatureSettings(stringBuilder.toString());
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(stringBuilder2);
                stringBuilder.append("'hlig', 'cala', ");
                stringBuilder.append(font.fontFeatureSettings);
                paint2.setFontFeatureSettings(stringBuilder.toString());
            }
        }
        readableMap = font.fontData;
        fArr = new float[length];
        paint2.getTextWidths(str2, fArr);
        textAnchor = font.textAnchor;
        measureText = (double) paint2.measureText(str2);
        textAnchorOffset = getTextAnchorOffset(textAnchor, measureText);
        fontSize = textRootGlyphContext.getFontSize();
        obj2 = -1;
        if (obj6 == null) {
            d14 = measureText;
            pathMeasure4 = pathMeasure2;
            glyphContext2 = textRootGlyphContext;
            glyphPathBag2 = glyphPathBag;
            zArr2 = zArr;
            fArr8 = fArr;
            length2 = d;
            d2 = 0.0d;
            i = 1;
            obj3 = null;
        } else {
            d14 = measureText;
            if (tSpanView.textPath.getMidLine() != TextPathMidLine.sharp) {
            }
            if (tSpanView.textPath.getSide() != TextPathSide.right) {
            }
            textAnchor2 = textAnchor;
            glyphPathBag2 = glyphPathBag;
            zArr2 = zArr;
            fArr8 = fArr;
            pathMeasure4 = pathMeasure2;
            glyphContext2 = textRootGlyphContext;
            measureText = getAbsoluteStartOffset(tSpanView.textPath.getStartOffset(), d, fontSize);
            textAnchorOffset += measureText;
            if (z) {
                length2 = d;
                d2 = 0.0d;
            } else {
                if (textAnchor2 != TextAnchor.middle) {
                }
                measureText += textAnchor2 != TextAnchor.middle ? -(d / 2.0d) : 0.0d;
                length2 = measureText + d;
                d2 = measureText;
            }
            obj3 = obj8;
            i = i11;
        }
        d3 = 1.0d;
        if (tSpanView.mTextLength == null) {
            d16 = d2;
            d15 = d;
        } else {
            d15 = d;
            d16 = d2;
            d2 = PropHelper.fromRelative(tSpanView.mTextLength, (double) canvas.getWidth(), 0.0d, (double) tSpanView.mScale, fontSize);
            if (d2 >= 0.0d) {
                throw new IllegalArgumentException("Negative textLength value");
            } else if (C67471.f23509xa45a5cfe[tSpanView.mLengthAdjust.ordinal()] == 2) {
                d3 = d2 / d14;
            } else {
                d13 += (d2 - d14) / ((double) (length - 1));
            }
        }
        d2 = d13;
        d13 = (double) i;
        d = d3 * d13;
        fontMetrics = paint.getFontMetrics();
        d4 = d;
        d = (double) fontMetrics.descent;
        i2 = i;
        obj4 = obj3;
        measureText = ((double) fontMetrics.leading) + d;
        d5 = length2;
        length2 = (double) ((-fontMetrics.ascent) + fontMetrics.leading);
        d6 = d13;
        d13 = (double) (-fontMetrics.top);
        d7 = d13 + measureText;
        baselineShift = getBaselineShift();
        alignmentBaseline = getAlignmentBaseline();
        if (alignmentBaseline != null) {
            switch (alignmentBaseline) {
                case textBottom:
                case afterEdge:
                case textAfterEdge:
                    measureText = -d;
                    break;
                case alphabetic:
                    break;
                case ideographic:
                    measureText = -d;
                    break;
                case middle:
                    Rect rect2 = new Rect();
                    paint2.getTextBounds("x", 0, 1, rect2);
                    measureText = (double) (rect2.height() / 2);
                    break;
                case central:
                    measureText = (length2 - d) / 2.0d;
                    break;
                case mathematical:
                    measureText = 0.5d * length2;
                    break;
                case hanging:
                    measureText = 0.8d * length2;
                    break;
                case textTop:
                case beforeEdge:
                case textBeforeEdge:
                    measureText = length2;
                    break;
                case bottom:
                    break;
                case center:
                    measureText = d7 / 2.0d;
                    break;
                case top:
                    measureText = d13;
                    break;
                default:
                    break;
            }
        }
        measureText = 0.0d;
        i3 = C67471.f23507xc8f7ac[alignmentBaseline.ordinal()];
        i3 = baselineShift.hashCode();
        if (i3 == -1720785339) {
            if (baselineShift.equals("baseline")) {
                obj2 = 2;
            }
        } else if (i3 == 114240) {
            if (baselineShift.equals("sub")) {
                obj2 = null;
            }
        } else if (i3 != 109801339) {
            if (baselineShift.equals("super")) {
                obj2 = 1;
            }
        }
        switch (obj2) {
            case null:
                i3 = readableMap.getInt("unitsPerEm");
                map = readableMap.getMap("tables");
                if (map.hasKey("os2")) {
                    map = map.getMap("os2");
                    if (map.hasKey("ySubscriptYOffset")) {
                        measureText += ((((double) tSpanView.mScale) * fontSize) * map.getDouble("ySubscriptYOffset")) / ((double) i3);
                        break;
                    }
                }
                break;
            case 1:
                i3 = readableMap.getInt("unitsPerEm");
                map = readableMap.getMap("tables");
                if (map.hasKey("os2")) {
                    map = map.getMap("os2");
                    if (map.hasKey("ySuperscriptYOffset")) {
                        measureText -= ((((double) tSpanView.mScale) * fontSize) * map.getDouble("ySuperscriptYOffset")) / ((double) i3);
                        break;
                    }
                }
                break;
            case 2:
                break;
            default:
                measureText -= PropHelper.fromRelative(baselineShift, ((double) tSpanView.mScale) * fontSize, 0.0d, (double) tSpanView.mScale, fontSize);
                break;
        }
        matrix = new Matrix();
        matrix2 = new Matrix();
        matrix3 = new Matrix();
        fArr2 = new float[9];
        fArr3 = new float[9];
        fArr4 = new float[9];
        i4 = 0;
        while (i4 < length) {
            char c22 = toCharArray[i4];
            valueOf = String.valueOf(c22);
            z2 = zArr2[i4];
            if (z2) {
                str3 = valueOf;
                obj7 = null;
                i5 = i4;
                while (true) {
                    i6 = i5 + 1;
                    if (i6 >= length) {
                        if (fArr8[i6] > 0.0f) {
                            StringBuilder stringBuilder32 = new StringBuilder();
                            fArr5 = fArr3;
                            stringBuilder32.append(str3);
                            stringBuilder32.append(String.valueOf(toCharArray[i6]));
                            str3 = stringBuilder32.toString();
                            zArr2[i6] = true;
                            i5 = i6;
                            fArr3 = fArr5;
                            tSpanView = this;
                            obj7 = 1;
                        }
                    }
                    fArr5 = fArr3;
                    stringBuilder2 = str3;
                }
            } else {
                fArr5 = fArr3;
                stringBuilder2 = "";
                obj7 = null;
            }
            i7 = length;
            measureText2 = ((double) paint2.measureText(stringBuilder2)) * d3;
            if (i9 == 0) {
                d8 = measureText;
            } else {
                d8 = measureText;
                d11 = (((double) fArr8[i4]) * d3) - measureText2;
            }
            if (c22 != ' ') {
            }
            if (obj5 == null) {
            }
            d9 = measureText2 + ((obj5 == null ? d12 : 0.0d) + d2);
            if (z2) {
                d10 = d2;
                d2 = d11 + d9;
            } else {
                d10 = d2;
                d2 = 0.0d;
            }
            glyphContext3 = glyphContext2;
            d2 = glyphContext3.nextX(d2);
            c = c22;
            nextY = glyphContext3.nextY();
            nextDeltaX = glyphContext3.nextDeltaX();
            nextDeltaY = glyphContext3.nextDeltaY();
            d17 = nextY;
            nextY = glyphContext3.nextRotation();
            if (z2) {
                if (obj5 != null) {
                    measureText2 *= d6;
                    d2 = (textAnchorOffset + ((d2 + nextDeltaX) * d6)) - (d9 * d6);
                    if (obj6 == null) {
                        glyphContext = glyphContext3;
                        matrix4 = matrix;
                        str4 = stringBuilder2;
                        d18 = nextY;
                        i10 = i4;
                        fArr9 = fArr4;
                        pathMeasure5 = pathMeasure4;
                        d19 = d15;
                        measureText = d4;
                        i6 = i2;
                        matrix2.setTranslate((float) d2, (float) ((d17 + nextDeltaY) + d8));
                    } else {
                        glyphContext = glyphContext3;
                        measureText = d2 + measureText2;
                        measureText2 /= 2.0d;
                        d18 = nextY;
                        nextY = d2 + measureText2;
                        if (nextY <= d5) {
                            if (nextY < d16) {
                                if (obj4 == null) {
                                    pathMeasure5 = pathMeasure4;
                                    if (d2 >= 0.0d) {
                                        str4 = stringBuilder2;
                                        i10 = i4;
                                        i4 = 1;
                                        pathMeasure5.getMatrix((float) d2, matrix, 1);
                                    } else {
                                        str4 = stringBuilder2;
                                        i10 = i4;
                                        pathMeasure5.getMatrix(0.0f, matrix, 3);
                                        matrix.preTranslate((float) d2, 0.0f);
                                        i4 = 1;
                                    }
                                    pathMeasure5.getMatrix((float) nextY, matrix2, i4);
                                    if (measureText <= d15) {
                                        nextY = d15;
                                        pathMeasure5.getMatrix((float) measureText, matrix3, i4);
                                    } else {
                                        nextY = d15;
                                        pathMeasure5.getMatrix((float) nextY, matrix3, 3);
                                        matrix3.preTranslate((float) (measureText - nextY), 0.0f);
                                    }
                                    matrix.getValues(fArr2);
                                    matrix3.getValues(fArr4);
                                    matrix4 = matrix;
                                    d19 = nextY;
                                    fArr9 = fArr4;
                                    matrix2.preRotate((float) ((Math.atan2(((double) fArr4[5]) - ((double) fArr2[5]), ((double) fArr4[2]) - ((double) fArr2[2])) * radToDeg) * d6));
                                } else {
                                    pathMeasure = pathMeasure4;
                                    pathMeasure.getMatrix((float) nextY, matrix2, 3);
                                    pathMeasure5 = pathMeasure;
                                    matrix4 = matrix;
                                    str4 = stringBuilder2;
                                    i10 = i4;
                                    fArr9 = fArr4;
                                    d19 = d15;
                                }
                                matrix2.preTranslate((float) (-measureText2), (float) (nextDeltaY + d8));
                                measureText = d4;
                                i6 = i2;
                                matrix2.preScale((float) measureText, (float) i6);
                                matrix2.postTranslate(0.0f, (float) d17);
                            }
                        }
                        matrix4 = matrix;
                        i8 = i4;
                        fArr6 = fArr4;
                        fArr7 = fArr2;
                        path2 = path4;
                        glyphPathBag3 = glyphPathBag2;
                        pathMeasure3 = pathMeasure4;
                        measureText = d15;
                        d2 = d4;
                        i6 = i2;
                        d9 = d6;
                        fArr10 = fArr5;
                        i5 = i7;
                        paint3 = paint;
                        canvas3 = canvas;
                        matrix5 = matrix3;
                        d15 = measureText;
                        i2 = i6;
                        d4 = d2;
                        glyphPathBag2 = glyphPathBag3;
                        matrix3 = matrix5;
                        length = i5;
                        pathMeasure4 = pathMeasure3;
                        fArr4 = fArr6;
                        d6 = d9;
                        fArr2 = fArr7;
                        measureText = d8;
                        d2 = d10;
                        glyphContext2 = glyphContext;
                        tSpanView = this;
                        fArr3 = fArr10;
                        path4 = path2;
                        paint2 = paint3;
                        i4 = i8 + 1;
                        matrix = matrix4;
                    }
                    d2 = d18;
                    f = (float) d2;
                    matrix2.preRotate(f);
                    if (obj7 == null) {
                        d20 = d2;
                        pathMeasure3 = pathMeasure5;
                        fArr7 = fArr2;
                        path2 = path4;
                        glyphPathBag5 = glyphPathBag2;
                        d9 = d6;
                        fArr11 = fArr5;
                        i5 = i7;
                        i8 = i10;
                        str5 = str4;
                        fArr6 = fArr9;
                        d2 = measureText;
                        matrix5 = matrix3;
                        measureText = d19;
                        path3 = glyphPathBag5.getOrCreateAndCache(c, str5);
                    } else {
                        Path path52 = new Path();
                        d20 = d2;
                        i8 = i10;
                        double d212 = measureText;
                        measureText = d19;
                        d2 = d212;
                        fArr6 = fArr9;
                        pathMeasure3 = pathMeasure5;
                        d9 = d6;
                        fArr11 = fArr5;
                        fArr7 = fArr2;
                        path2 = path4;
                        matrix5 = matrix3;
                        i5 = i7;
                        paint.getTextPath(str4, 0, str4.length(), 0.0f, 0.0f, path52);
                        path3 = path52;
                        glyphPathBag5 = glyphPathBag2;
                        str5 = str4;
                    }
                    rectF = new RectF();
                    path3.computeBounds(rectF, true);
                    if (rectF.width() != 0.0f) {
                        glyphPathBag3 = glyphPathBag5;
                        fArr10 = fArr11;
                        paint3 = paint;
                        canvas3 = canvas;
                        path3.transform(matrix2);
                        path2.addPath(path3);
                    } else {
                        fArr10 = fArr11;
                        matrix2.getValues(fArr10);
                        String str62 = str5;
                        float f22 = (float) ((double) fArr10[2]);
                        float f32 = (float) ((double) fArr10[5]);
                        glyphPathBag3 = glyphPathBag5;
                        canvas3 = canvas;
                        canvas3.rotate(f, f22, f32);
                        paint3 = paint;
                        canvas3.drawText(str62, f22, f32, paint3);
                        canvas3.rotate((float) (-d20), f22, f32);
                    }
                    d15 = measureText;
                    i2 = i6;
                    d4 = d2;
                    glyphPathBag2 = glyphPathBag3;
                    matrix3 = matrix5;
                    length = i5;
                    pathMeasure4 = pathMeasure3;
                    fArr4 = fArr6;
                    d6 = d9;
                    fArr2 = fArr7;
                    measureText = d8;
                    d2 = d10;
                    glyphContext2 = glyphContext;
                    tSpanView = this;
                    fArr3 = fArr10;
                    path4 = path2;
                    paint2 = paint3;
                    i4 = i8 + 1;
                    matrix = matrix4;
                }
            }
            glyphContext = glyphContext3;
            matrix4 = matrix;
            i8 = i4;
            fArr6 = fArr4;
            fArr7 = fArr2;
            path2 = path4;
            glyphPathBag3 = glyphPathBag2;
            pathMeasure3 = pathMeasure4;
            measureText = d15;
            d2 = d4;
            i6 = i2;
            d9 = d6;
            fArr10 = fArr5;
            i5 = i7;
            paint3 = paint;
            canvas3 = canvas;
            matrix5 = matrix3;
            d15 = measureText;
            i2 = i6;
            d4 = d2;
            glyphPathBag2 = glyphPathBag3;
            matrix3 = matrix5;
            length = i5;
            pathMeasure4 = pathMeasure3;
            fArr4 = fArr6;
            d6 = d9;
            fArr2 = fArr7;
            measureText = d8;
            d2 = d10;
            glyphContext2 = glyphContext;
            tSpanView = this;
            fArr3 = fArr10;
            path4 = path2;
            paint2 = paint3;
            i4 = i8 + 1;
            matrix = matrix4;
        }
        return path4;
    }

    private double getAbsoluteStartOffset(SVGLength sVGLength, double d, double d2) {
        return PropHelper.fromRelative(sVGLength, d, 0.0d, (double) this.mScale, d2);
    }

    private double getTextAnchorOffset(TextAnchor textAnchor, double d) {
        switch (textAnchor) {
            case middle:
                return (-d) / 2.0d;
            case end:
                return -d;
            default:
                return null;
        }
    }

    private void applyTextPropertiesToPaint(android.graphics.Paint r9, versioned.host.exp.exponent.modules.api.components.svg.FontData r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.mContext;
        r0 = r0.getResources();
        r0 = r0.getAssets();
        r1 = r10.fontSize;
        r3 = r8.mScale;
        r3 = (double) r3;
        r1 = r1 * r3;
        r3 = r10.fontWeight;
        r4 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.FontWeight.Bold;
        r5 = 0;
        r6 = 1;
        if (r3 != r4) goto L_0x001b;
    L_0x0019:
        r3 = 1;
        goto L_0x001c;
    L_0x001b:
        r3 = 0;
    L_0x001c:
        r4 = r10.fontStyle;
        r7 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.FontStyle.italic;
        if (r4 != r7) goto L_0x0024;
    L_0x0022:
        r4 = 1;
        goto L_0x0025;
    L_0x0024:
        r4 = 0;
    L_0x0025:
        if (r3 == 0) goto L_0x002b;
    L_0x0027:
        if (r4 == 0) goto L_0x002b;
    L_0x0029:
        r5 = 3;
        goto L_0x0032;
    L_0x002b:
        if (r3 == 0) goto L_0x002f;
    L_0x002d:
        r5 = 1;
        goto L_0x0032;
    L_0x002f:
        if (r4 == 0) goto L_0x0032;
    L_0x0031:
        r5 = 2;
    L_0x0032:
        r3 = 0;
        r10 = r10.fontFamily;
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0051 }
        r4.<init>();	 Catch:{ Exception -> 0x0051 }
        r6 = "fonts/";	 Catch:{ Exception -> 0x0051 }
        r4.append(r6);	 Catch:{ Exception -> 0x0051 }
        r4.append(r10);	 Catch:{ Exception -> 0x0051 }
        r6 = ".otf";	 Catch:{ Exception -> 0x0051 }
        r4.append(r6);	 Catch:{ Exception -> 0x0051 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0051 }
        r4 = android.graphics.Typeface.createFromAsset(r0, r4);	 Catch:{ Exception -> 0x0051 }
        r10 = r4;
        goto L_0x0073;
    L_0x0051:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006d }
        r4.<init>();	 Catch:{ Exception -> 0x006d }
        r6 = "fonts/";	 Catch:{ Exception -> 0x006d }
        r4.append(r6);	 Catch:{ Exception -> 0x006d }
        r4.append(r10);	 Catch:{ Exception -> 0x006d }
        r6 = ".ttf";	 Catch:{ Exception -> 0x006d }
        r4.append(r6);	 Catch:{ Exception -> 0x006d }
        r4 = r4.toString();	 Catch:{ Exception -> 0x006d }
        r0 = android.graphics.Typeface.createFromAsset(r0, r4);	 Catch:{ Exception -> 0x006d }
        r10 = r0;
        goto L_0x0073;
    L_0x006d:
        r10 = android.graphics.Typeface.create(r10, r5);	 Catch:{ Exception -> 0x0072 }
        goto L_0x0073;
    L_0x0072:
        r10 = r3;
    L_0x0073:
        r9.setTypeface(r10);
        r10 = (float) r1;
        r9.setTextSize(r10);
        r10 = android.graphics.Paint.Align.LEFT;
        r9.setTextAlign(r10);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.components.svg.TSpanView.applyTextPropertiesToPaint(android.graphics.Paint, versioned.host.exp.exponent.modules.api.components.svg.FontData):void");
    }

    private void setupTextPath() {
        ViewParent parent = getParent();
        while (parent != null) {
            if (parent.getClass() == TextPathView.class) {
                this.textPath = (TextPathView) parent;
                return;
            } else if (parent instanceof TextView) {
                parent = parent.getParent();
            } else {
                return;
            }
        }
    }

    int hitTest(float[] fArr) {
        if (this.mContent == null) {
            return super.hitTest(fArr);
        }
        if (this.mPath != null && this.mInvertible) {
            if (this.mTransformInvertible) {
                float[] fArr2 = new float[2];
                this.mInvMatrix.mapPoints(fArr2, fArr);
                this.mInvTransform.mapPoints(fArr2);
                fArr = Math.round(fArr2[null]);
                int round = Math.round(fArr2[1]);
                if (this.mRegion == null && this.mFillPath != null) {
                    this.mRegion = getRegion(this.mFillPath);
                }
                if (this.mStrokeRegion == null && this.mStrokePath != null) {
                    this.mStrokeRegion = getRegion(this.mStrokePath);
                }
                if (this.mRegion == null || !this.mRegion.contains(fArr, round)) {
                    if (this.mStrokeRegion != null) {
                        if (!this.mStrokeRegion.contains(fArr, round)) {
                        }
                    }
                    return -1;
                }
                Path clipPath = getClipPath();
                if (clipPath != null) {
                    if (this.mClipRegionPath != clipPath) {
                        this.mClipRegionPath = clipPath;
                        this.mClipRegion = getRegion(clipPath);
                    }
                    if (this.mClipRegion.contains(fArr, round) == null) {
                        return -1;
                    }
                }
                return getId();
            }
        }
        return -1;
    }
}

package com.google.android.exoplayer2.p164l;

import android.text.TextUtils;
import com.facebook.imageutils.JfifUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: ColorParser */
/* renamed from: com.google.android.exoplayer2.l.d */
public final class C2519d {
    /* renamed from: a */
    private static final Pattern f6405a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    /* renamed from: b */
    private static final Pattern f6406b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    /* renamed from: c */
    private static final Pattern f6407c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    /* renamed from: d */
    private static final Map<String, Integer> f6408d = new HashMap();

    /* renamed from: a */
    private static int m7034a(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }

    static {
        f6408d.put("aliceblue", Integer.valueOf(-984833));
        f6408d.put("antiquewhite", Integer.valueOf(-332841));
        f6408d.put("aqua", Integer.valueOf(-16711681));
        f6408d.put("aquamarine", Integer.valueOf(-8388652));
        f6408d.put("azure", Integer.valueOf(-983041));
        f6408d.put("beige", Integer.valueOf(-657956));
        f6408d.put("bisque", Integer.valueOf(-6972));
        f6408d.put("black", Integer.valueOf(-16777216));
        f6408d.put("blanchedalmond", Integer.valueOf(-5171));
        f6408d.put("blue", Integer.valueOf(-16776961));
        f6408d.put("blueviolet", Integer.valueOf(-7722014));
        f6408d.put("brown", Integer.valueOf(-5952982));
        f6408d.put("burlywood", Integer.valueOf(-2180985));
        f6408d.put("cadetblue", Integer.valueOf(-10510688));
        f6408d.put("chartreuse", Integer.valueOf(-8388864));
        f6408d.put("chocolate", Integer.valueOf(-2987746));
        f6408d.put("coral", Integer.valueOf(-32944));
        f6408d.put("cornflowerblue", Integer.valueOf(-10185235));
        f6408d.put("cornsilk", Integer.valueOf(-1828));
        f6408d.put("crimson", Integer.valueOf(-2354116));
        f6408d.put("cyan", Integer.valueOf(-16711681));
        f6408d.put("darkblue", Integer.valueOf(-16777077));
        f6408d.put("darkcyan", Integer.valueOf(-16741493));
        f6408d.put("darkgoldenrod", Integer.valueOf(-4684277));
        f6408d.put("darkgray", Integer.valueOf(-5658199));
        f6408d.put("darkgreen", Integer.valueOf(-16751616));
        f6408d.put("darkgrey", Integer.valueOf(-5658199));
        f6408d.put("darkkhaki", Integer.valueOf(-4343957));
        f6408d.put("darkmagenta", Integer.valueOf(-7667573));
        f6408d.put("darkolivegreen", Integer.valueOf(-11179217));
        f6408d.put("darkorange", Integer.valueOf(-29696));
        f6408d.put("darkorchid", Integer.valueOf(-6737204));
        f6408d.put("darkred", Integer.valueOf(-7667712));
        f6408d.put("darksalmon", Integer.valueOf(-1468806));
        f6408d.put("darkseagreen", Integer.valueOf(-7357297));
        f6408d.put("darkslateblue", Integer.valueOf(-12042869));
        f6408d.put("darkslategray", Integer.valueOf(-13676721));
        f6408d.put("darkslategrey", Integer.valueOf(-13676721));
        f6408d.put("darkturquoise", Integer.valueOf(-16724271));
        f6408d.put("darkviolet", Integer.valueOf(-7077677));
        f6408d.put("deeppink", Integer.valueOf(-60269));
        f6408d.put("deepskyblue", Integer.valueOf(-16728065));
        f6408d.put("dimgray", Integer.valueOf(-9868951));
        f6408d.put("dimgrey", Integer.valueOf(-9868951));
        f6408d.put("dodgerblue", Integer.valueOf(-14774017));
        f6408d.put("firebrick", Integer.valueOf(-5103070));
        f6408d.put("floralwhite", Integer.valueOf(-1296));
        f6408d.put("forestgreen", Integer.valueOf(-14513374));
        f6408d.put("fuchsia", Integer.valueOf(-65281));
        f6408d.put("gainsboro", Integer.valueOf(-2302756));
        f6408d.put("ghostwhite", Integer.valueOf(-460545));
        f6408d.put("gold", Integer.valueOf(-10496));
        f6408d.put("goldenrod", Integer.valueOf(-2448096));
        f6408d.put("gray", Integer.valueOf(-8355712));
        f6408d.put("green", Integer.valueOf(-16744448));
        f6408d.put("greenyellow", Integer.valueOf(-5374161));
        f6408d.put("grey", Integer.valueOf(-8355712));
        f6408d.put("honeydew", Integer.valueOf(-983056));
        f6408d.put("hotpink", Integer.valueOf(-38476));
        f6408d.put("indianred", Integer.valueOf(-3318692));
        f6408d.put("indigo", Integer.valueOf(-11861886));
        f6408d.put("ivory", Integer.valueOf(-16));
        f6408d.put("khaki", Integer.valueOf(-989556));
        f6408d.put("lavender", Integer.valueOf(-1644806));
        f6408d.put("lavenderblush", Integer.valueOf(-3851));
        f6408d.put("lawngreen", Integer.valueOf(-8586240));
        f6408d.put("lemonchiffon", Integer.valueOf(-1331));
        f6408d.put("lightblue", Integer.valueOf(-5383962));
        f6408d.put("lightcoral", Integer.valueOf(-1015680));
        f6408d.put("lightcyan", Integer.valueOf(-2031617));
        f6408d.put("lightgoldenrodyellow", Integer.valueOf(-329006));
        f6408d.put("lightgray", Integer.valueOf(-2894893));
        f6408d.put("lightgreen", Integer.valueOf(-7278960));
        f6408d.put("lightgrey", Integer.valueOf(-2894893));
        f6408d.put("lightpink", Integer.valueOf(-18751));
        f6408d.put("lightsalmon", Integer.valueOf(-24454));
        f6408d.put("lightseagreen", Integer.valueOf(-14634326));
        f6408d.put("lightskyblue", Integer.valueOf(-7876870));
        f6408d.put("lightslategray", Integer.valueOf(-8943463));
        f6408d.put("lightslategrey", Integer.valueOf(-8943463));
        f6408d.put("lightsteelblue", Integer.valueOf(-5192482));
        f6408d.put("lightyellow", Integer.valueOf(-32));
        f6408d.put("lime", Integer.valueOf(-16711936));
        f6408d.put("limegreen", Integer.valueOf(-13447886));
        f6408d.put("linen", Integer.valueOf(-331546));
        f6408d.put("magenta", Integer.valueOf(-65281));
        f6408d.put("maroon", Integer.valueOf(-8388608));
        f6408d.put("mediumaquamarine", Integer.valueOf(-10039894));
        f6408d.put("mediumblue", Integer.valueOf(-16777011));
        f6408d.put("mediumorchid", Integer.valueOf(-4565549));
        f6408d.put("mediumpurple", Integer.valueOf(-7114533));
        f6408d.put("mediumseagreen", Integer.valueOf(-12799119));
        f6408d.put("mediumslateblue", Integer.valueOf(-8689426));
        f6408d.put("mediumspringgreen", Integer.valueOf(-16713062));
        f6408d.put("mediumturquoise", Integer.valueOf(-12004916));
        f6408d.put("mediumvioletred", Integer.valueOf(-3730043));
        f6408d.put("midnightblue", Integer.valueOf(-15132304));
        f6408d.put("mintcream", Integer.valueOf(-655366));
        f6408d.put("mistyrose", Integer.valueOf(-6943));
        f6408d.put("moccasin", Integer.valueOf(-6987));
        f6408d.put("navajowhite", Integer.valueOf(-8531));
        f6408d.put("navy", Integer.valueOf(-16777088));
        f6408d.put("oldlace", Integer.valueOf(-133658));
        f6408d.put("olive", Integer.valueOf(-8355840));
        f6408d.put("olivedrab", Integer.valueOf(-9728477));
        f6408d.put("orange", Integer.valueOf(-23296));
        f6408d.put("orangered", Integer.valueOf(-47872));
        f6408d.put("orchid", Integer.valueOf(-2461482));
        f6408d.put("palegoldenrod", Integer.valueOf(-1120086));
        f6408d.put("palegreen", Integer.valueOf(-6751336));
        f6408d.put("paleturquoise", Integer.valueOf(-5247250));
        f6408d.put("palevioletred", Integer.valueOf(-2396013));
        f6408d.put("papayawhip", Integer.valueOf(-4139));
        f6408d.put("peachpuff", Integer.valueOf(-9543));
        f6408d.put("peru", Integer.valueOf(-3308225));
        f6408d.put("pink", Integer.valueOf(-16181));
        f6408d.put("plum", Integer.valueOf(-2252579));
        f6408d.put("powderblue", Integer.valueOf(-5185306));
        f6408d.put("purple", Integer.valueOf(-8388480));
        f6408d.put("rebeccapurple", Integer.valueOf(-10079335));
        f6408d.put("red", Integer.valueOf(-65536));
        f6408d.put("rosybrown", Integer.valueOf(-4419697));
        f6408d.put("royalblue", Integer.valueOf(-12490271));
        f6408d.put("saddlebrown", Integer.valueOf(-7650029));
        f6408d.put("salmon", Integer.valueOf(-360334));
        f6408d.put("sandybrown", Integer.valueOf(-744352));
        f6408d.put("seagreen", Integer.valueOf(-13726889));
        f6408d.put("seashell", Integer.valueOf(-2578));
        f6408d.put("sienna", Integer.valueOf(-6270419));
        f6408d.put("silver", Integer.valueOf(-4144960));
        f6408d.put("skyblue", Integer.valueOf(-7876885));
        f6408d.put("slateblue", Integer.valueOf(-9807155));
        f6408d.put("slategray", Integer.valueOf(-9404272));
        f6408d.put("slategrey", Integer.valueOf(-9404272));
        f6408d.put("snow", Integer.valueOf(-1286));
        f6408d.put("springgreen", Integer.valueOf(-16711809));
        f6408d.put("steelblue", Integer.valueOf(-12156236));
        f6408d.put("tan", Integer.valueOf(-2968436));
        f6408d.put("teal", Integer.valueOf(-16744320));
        f6408d.put("thistle", Integer.valueOf(-2572328));
        f6408d.put("tomato", Integer.valueOf(-40121));
        f6408d.put("transparent", Integer.valueOf(0));
        f6408d.put("turquoise", Integer.valueOf(-12525360));
        f6408d.put("violet", Integer.valueOf(-1146130));
        f6408d.put("wheat", Integer.valueOf(-663885));
        f6408d.put("white", Integer.valueOf(-1));
        f6408d.put("whitesmoke", Integer.valueOf(-657931));
        f6408d.put("yellow", Integer.valueOf(-256));
        f6408d.put("yellowgreen", Integer.valueOf(-6632142));
    }

    /* renamed from: a */
    public static int m7035a(String str) {
        return C2519d.m7036a(str, false);
    }

    /* renamed from: b */
    public static int m7037b(String str) {
        return C2519d.m7036a(str, true);
    }

    /* renamed from: a */
    private static int m7036a(String str, boolean z) {
        C2516a.m7017a(TextUtils.isEmpty(str) ^ true);
        str = str.replace(" ", "");
        if (str.charAt(0) == '#') {
            z = (int) Long.parseLong(str.substring(1), 16);
            if (str.length() == 7) {
                str = -16777216 | z;
            } else if (str.length() == 9) {
                str = ((z & JfifUtil.MARKER_FIRST_BYTE) << 24) | (z >>> 8);
            } else {
                throw new IllegalArgumentException();
            }
            return str;
        }
        if (str.startsWith("rgba")) {
            str = (z ? f6407c : f6406b).matcher(str);
            if (str.matches()) {
                if (z) {
                    z = (int) (Float.parseFloat(str.group(4)) * true);
                } else {
                    z = Integer.parseInt(str.group(4), 10);
                }
                return C2519d.m7034a(z, Integer.parseInt(str.group(1), 10), Integer.parseInt(str.group(2), 10), Integer.parseInt(str.group(3), 10));
            }
        } else if (str.startsWith("rgb")) {
            str = f6405a.matcher(str);
            if (str.matches()) {
                return C2519d.m7033a(Integer.parseInt(str.group(1), 10), Integer.parseInt(str.group(2), 10), Integer.parseInt(str.group(3), 10));
            }
        } else {
            Integer num = (Integer) f6408d.get(C2541v.m7190d(str));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    private static int m7033a(int i, int i2, int i3) {
        return C2519d.m7034a(JfifUtil.MARKER_FIRST_BYTE, i, i2, i3);
    }
}

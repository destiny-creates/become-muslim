package com.google.android.exoplayer2.p157i.p161g;

import android.text.TextUtils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.p164l.C2519d;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: CssParser */
/* renamed from: com.google.android.exoplayer2.i.g.a */
final class C2465a {
    /* renamed from: a */
    private static final Pattern f6253a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    /* renamed from: b */
    private final C2529l f6254b = new C2529l();
    /* renamed from: c */
    private final StringBuilder f6255c = new StringBuilder();

    /* renamed from: a */
    public C2466d m6849a(C2529l c2529l) {
        this.f6255c.setLength(0);
        int d = c2529l.m7097d();
        C2465a.m6844c(c2529l);
        this.f6254b.m7091a(c2529l.f6441a, c2529l.m7097d());
        this.f6254b.m7096c(d);
        String b = C2465a.m6841b(this.f6254b, this.f6255c);
        C2466d c2466d = null;
        if (b != null) {
            if ("{".equals(C2465a.m6838a(this.f6254b, this.f6255c))) {
                C2466d c2466d2 = new C2466d();
                m6839a(c2466d2, b);
                Object obj = null;
                c2529l = null;
                while (c2529l == null) {
                    C2529l c2529l2;
                    c2529l = this.f6254b.m7097d();
                    obj = C2465a.m6838a(this.f6254b, this.f6255c);
                    if (obj != null) {
                        if (!"}".equals(obj)) {
                            c2529l2 = null;
                            if (c2529l2 == null) {
                                this.f6254b.m7096c(c2529l);
                                C2465a.m6840a(this.f6254b, c2466d2, this.f6255c);
                            }
                            c2529l = c2529l2;
                        }
                    }
                    c2529l2 = true;
                    if (c2529l2 == null) {
                        this.f6254b.m7096c(c2529l);
                        C2465a.m6840a(this.f6254b, c2466d2, this.f6255c);
                    }
                    c2529l = c2529l2;
                }
                if ("}".equals(obj) != null) {
                    c2466d = c2466d2;
                }
                return c2466d;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static String m6841b(C2529l c2529l, StringBuilder stringBuilder) {
        C2465a.m6842b(c2529l);
        if (c2529l.m7093b() < 5) {
            return null;
        }
        if (!"::cue".equals(c2529l.m7100e(5))) {
            return null;
        }
        int d = c2529l.m7097d();
        String a = C2465a.m6838a(c2529l, stringBuilder);
        if (a == null) {
            return null;
        }
        if ("{".equals(a)) {
            c2529l.m7096c(d);
            return "";
        }
        String d2 = "(".equals(a) ? C2465a.m6845d(c2529l) : null;
        c2529l = C2465a.m6838a(c2529l, stringBuilder);
        if (")".equals(c2529l) != null) {
            if (c2529l != null) {
                return d2;
            }
        }
        return null;
    }

    /* renamed from: d */
    private static String m6845d(C2529l c2529l) {
        int d = c2529l.m7097d();
        int c = c2529l.m7095c();
        Object obj = null;
        while (d < c && r3 == null) {
            int i = d + 1;
            obj = ((char) c2529l.f6441a[d]) == ')' ? 1 : null;
            d = i;
        }
        return c2529l.m7100e((d - 1) - c2529l.m7097d()).trim();
    }

    /* renamed from: a */
    private static void m6840a(C2529l c2529l, C2466d c2466d, StringBuilder stringBuilder) {
        C2465a.m6842b(c2529l);
        String d = C2465a.m6846d(c2529l, stringBuilder);
        if (!"".equals(d) && ":".equals(C2465a.m6838a(c2529l, stringBuilder))) {
            C2465a.m6842b(c2529l);
            String c = C2465a.m6843c(c2529l, stringBuilder);
            if (c != null) {
                if (!"".equals(c)) {
                    int d2 = c2529l.m7097d();
                    stringBuilder = C2465a.m6838a(c2529l, stringBuilder);
                    if (!";".equals(stringBuilder)) {
                        if ("}".equals(stringBuilder) != null) {
                            c2529l.m7096c(d2);
                        } else {
                            return;
                        }
                    }
                    if (ViewProps.COLOR.equals(d) != null) {
                        c2466d.m6852a(C2519d.m7037b(c));
                    } else if ("background-color".equals(d) != null) {
                        c2466d.m6858b(C2519d.m7037b(c));
                    } else if ("text-decoration".equals(d) != null) {
                        if ("underline".equals(c) != null) {
                            c2466d.m6853a(true);
                        }
                    } else if ("font-family".equals(d) != null) {
                        c2466d.m6864d(c);
                    } else if ("font-weight".equals(d) != null) {
                        if ("bold".equals(c) != null) {
                            c2466d.m6859b(true);
                        }
                    } else if (!("font-style".equals(d) == null || "italic".equals(c) == null)) {
                        c2466d.m6861c(true);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    static void m6842b(C2529l c2529l) {
        while (true) {
            Object obj = 1;
            while (c2529l.m7093b() > 0 && r1 != null) {
                if (!C2465a.m6847e(c2529l)) {
                    if (!C2465a.m6848f(c2529l)) {
                        obj = null;
                    }
                }
            }
            return;
        }
    }

    /* renamed from: a */
    static String m6838a(C2529l c2529l, StringBuilder stringBuilder) {
        C2465a.m6842b(c2529l);
        if (c2529l.m7093b() == 0) {
            return null;
        }
        stringBuilder = C2465a.m6846d(c2529l, stringBuilder);
        if (!"".equals(stringBuilder)) {
            return stringBuilder;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append((char) c2529l.m7103g());
        return stringBuilder.toString();
    }

    /* renamed from: e */
    private static boolean m6847e(C2529l c2529l) {
        switch (C2465a.m6837a(c2529l, c2529l.m7097d())) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
                c2529l.m7098d(1);
                return true;
            default:
                return null;
        }
    }

    /* renamed from: c */
    static void m6844c(C2529l c2529l) {
        do {
        } while (!TextUtils.isEmpty(c2529l.m7122z()));
    }

    /* renamed from: a */
    private static char m6837a(C2529l c2529l, int i) {
        return (char) c2529l.f6441a[i];
    }

    /* renamed from: c */
    private static String m6843c(C2529l c2529l, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder();
        Object obj = null;
        while (obj == null) {
            int d = c2529l.m7097d();
            String a = C2465a.m6838a(c2529l, stringBuilder);
            if (a == null) {
                return null;
            }
            if (!"}".equals(a)) {
                if (!";".equals(a)) {
                    stringBuilder2.append(a);
                }
            }
            c2529l.m7096c(d);
            obj = 1;
        }
        return stringBuilder2.toString();
    }

    /* renamed from: f */
    private static boolean m6848f(C2529l c2529l) {
        int d = c2529l.m7097d();
        int c = c2529l.m7095c();
        byte[] bArr = c2529l.f6441a;
        if (d + 2 <= c) {
            int i = d + 1;
            if (bArr[d] == (byte) 47) {
                d = i + 1;
                if (bArr[i] == (byte) 42) {
                    while (true) {
                        i = d + 1;
                        if (i >= c) {
                            c2529l.m7098d(c - c2529l.m7097d());
                            return true;
                        } else if (((char) bArr[d]) == '*' && ((char) bArr[i]) == '/') {
                            d = i + 1;
                            c = d;
                        } else {
                            d = i;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    private static String m6846d(C2529l c2529l, StringBuilder stringBuilder) {
        int i = 0;
        stringBuilder.setLength(0);
        int d = c2529l.m7097d();
        int c = c2529l.m7095c();
        while (d < c && r0 == 0) {
            char c2 = (char) c2529l.f6441a[d];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.'))) {
                if (c2 != '_') {
                    i = 1;
                }
            }
            d++;
            stringBuilder.append(c2);
        }
        c2529l.m7098d(d - c2529l.m7097d());
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private void m6839a(C2466d c2466d, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = f6253a.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    c2466d.m6862c(matcher.group(1));
                }
                str = str.substring(0, indexOf);
            }
            str = str.split("\\.");
            String str2 = str[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                c2466d.m6860b(str2.substring(0, indexOf2));
                c2466d.m6855a(str2.substring(indexOf2 + 1));
            } else {
                c2466d.m6860b(str2);
            }
            if (str.length > 1) {
                c2466d.m6856a((String[]) Arrays.copyOfRange(str, 1, str.length));
            }
        }
    }
}

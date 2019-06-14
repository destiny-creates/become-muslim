package com.google.p217b.p222b;

import com.facebook.stetho.common.Utf8Charset;
import com.google.p217b.C6891h;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CharacterSetECI */
/* renamed from: com.google.b.b.d */
public enum C5204d {
    Cp437((String) new int[]{0, 2}, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{"ISO-8859-1"}),
    ISO8859_2((String) 4, (int) new String[]{"ISO-8859-2"}),
    ISO8859_3((String) 5, (int) new String[]{"ISO-8859-3"}),
    ISO8859_4((String) 6, (int) new String[]{"ISO-8859-4"}),
    ISO8859_5((String) 7, (int) new String[]{"ISO-8859-5"}),
    ISO8859_6((String) 8, (int) new String[]{"ISO-8859-6"}),
    ISO8859_7((String) 9, (int) new String[]{"ISO-8859-7"}),
    ISO8859_8((String) 10, (int) new String[]{"ISO-8859-8"}),
    ISO8859_9((String) 11, (int) new String[]{"ISO-8859-9"}),
    ISO8859_10((String) 12, (int) new String[]{"ISO-8859-10"}),
    ISO8859_11((String) 13, (int) new String[]{"ISO-8859-11"}),
    ISO8859_13((String) 15, (int) new String[]{"ISO-8859-13"}),
    ISO8859_14((String) 16, (int) new String[]{"ISO-8859-14"}),
    ISO8859_15((String) 17, (int) new String[]{"ISO-8859-15"}),
    ISO8859_16((String) 18, (int) new String[]{"ISO-8859-16"}),
    SJIS((String) 20, (int) new String[]{"Shift_JIS"}),
    Cp1250((String) 21, (int) new String[]{"windows-1250"}),
    Cp1251((String) 22, (int) new String[]{"windows-1251"}),
    Cp1252((String) 23, (int) new String[]{"windows-1252"}),
    Cp1256((String) 24, (int) new String[]{"windows-1256"}),
    UnicodeBigUnmarked((String) 25, (int) new String[]{"UTF-16BE", "UnicodeBig"}),
    UTF8((String) 26, (int) new String[]{Utf8Charset.NAME}),
    ASCII((String) new int[]{27, 170}, (int) new String[]{"US-ASCII"}),
    Big5(28),
    GB18030((String) 29, (int) new String[]{"GB2312", "EUC_CN", "GBK"}),
    EUC_KR((String) 30, (int) new String[]{"EUC-KR"});
    
    /* renamed from: B */
    private static final Map<Integer, C5204d> f17544B = null;
    /* renamed from: C */
    private static final Map<String, C5204d> f17545C = null;
    /* renamed from: D */
    private final int[] f17573D;
    /* renamed from: E */
    private final String[] f17574E;

    static {
        f17544B = new HashMap();
        f17545C = new HashMap();
        for (C5204d c5204d : C5204d.values()) {
            for (int valueOf : c5204d.f17573D) {
                f17544B.put(Integer.valueOf(valueOf), c5204d);
            }
            f17545C.put(c5204d.name(), c5204d);
            for (Object put : c5204d.f17574E) {
                f17545C.put(put, c5204d);
            }
        }
    }

    private C5204d(int i) {
        this(r3, r4, new int[]{i}, new String[0]);
    }

    private C5204d(int i, String... strArr) {
        this.f17573D = new int[]{i};
        this.f17574E = strArr;
    }

    private C5204d(int[] iArr, String... strArr) {
        this.f17573D = iArr;
        this.f17574E = strArr;
    }

    /* renamed from: a */
    public int m22019a() {
        return this.f17573D[0];
    }

    /* renamed from: a */
    public static C5204d m22017a(int i) {
        if (i >= 0 && i < 900) {
            return (C5204d) f17544B.get(Integer.valueOf(i));
        }
        throw C6891h.m32342a();
    }

    /* renamed from: a */
    public static C5204d m22018a(String str) {
        return (C5204d) f17545C.get(str);
    }
}

package com.google.android.exoplayer2.p157i.p160e;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

/* compiled from: TtmlRenderUtil */
/* renamed from: com.google.android.exoplayer2.i.e.d */
final class C2462d {
    /* renamed from: a */
    public static C2463e m6804a(C2463e c2463e, String[] strArr, Map<String, C2463e> map) {
        if (c2463e == null && strArr == null) {
            return null;
        }
        int i = 0;
        if (c2463e == null && strArr.length == 1) {
            return (C2463e) map.get(strArr[0]);
        }
        int length;
        if (c2463e == null && strArr.length > 1) {
            c2463e = new C2463e();
            length = strArr.length;
            while (i < length) {
                c2463e.m6813a((C2463e) map.get(strArr[i]));
                i++;
            }
            return c2463e;
        } else if (c2463e != null && strArr != null && strArr.length == 1) {
            return c2463e.m6813a((C2463e) map.get(strArr[0]));
        } else {
            if (c2463e == null || strArr == null || strArr.length <= 1) {
                return c2463e;
            }
            length = strArr.length;
            while (i < length) {
                c2463e.m6813a((C2463e) map.get(strArr[i]));
                i++;
            }
            return c2463e;
        }
    }

    /* renamed from: a */
    public static void m6807a(SpannableStringBuilder spannableStringBuilder, int i, int i2, C2463e c2463e) {
        if (c2463e.m6809a() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(c2463e.m6809a()), i, i2, 33);
        }
        if (c2463e.m6819b()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (c2463e.m6822c()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (c2463e.m6826f()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(c2463e.m6825e()), i, i2, 33);
        }
        if (c2463e.m6828h()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(c2463e.m6827g()), i, i2, 33);
        }
        if (c2463e.m6824d() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(c2463e.m6824d()), i, i2, 33);
        }
        if (c2463e.m6830j() != null) {
            spannableStringBuilder.setSpan(new Standard(c2463e.m6830j()), i, i2, 33);
        }
        switch (c2463e.m6831k()) {
            case 1:
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) c2463e.m6832l(), true), i, i2, 33);
                return;
            case 2:
                spannableStringBuilder.setSpan(new RelativeSizeSpan(c2463e.m6832l()), i, i2, 33);
                return;
            case 3:
                spannableStringBuilder.setSpan(new RelativeSizeSpan(c2463e.m6832l() / 100.0f), i, i2, 33);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    static void m6806a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }

    /* renamed from: a */
    static String m6805a(String str) {
        return str.replaceAll("\r\n", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).replaceAll(" *\n *", ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).replaceAll(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }
}

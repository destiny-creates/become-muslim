package com.google.android.exoplayer2.p157i.p161g;

import com.google.android.exoplayer2.p157i.C2473g;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttParserUtil */
/* renamed from: com.google.android.exoplayer2.i.g.h */
public final class C2472h {
    /* renamed from: a */
    private static final Pattern f6293a = Pattern.compile("^NOTE(( |\t).*)?$");
    /* renamed from: b */
    private static final Pattern f6294b = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    /* renamed from: a */
    public static void m6906a(C2529l c2529l) {
        c2529l = c2529l.m7122z();
        if (c2529l == null || !f6294b.matcher(c2529l).matches()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected WEBVTT. Got ");
            stringBuilder.append(c2529l);
            throw new C2473g(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public static long m6905a(String str) {
        str = str.split("\\.", 2);
        int i = 0;
        String[] split = str[0].split(":");
        long j = 0;
        while (i < split.length) {
            j = (j * 60) + Long.parseLong(split[i]);
            i++;
        }
        j *= 1000;
        if (str.length == 2) {
            j += Long.parseLong(str[1]);
        }
        return j * 1000;
    }

    /* renamed from: b */
    public static float m6907b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    /* renamed from: b */
    public static Matcher m6908b(C2529l c2529l) {
        while (true) {
            CharSequence z = c2529l.m7122z();
            if (z == null) {
                return null;
            }
            if (f6293a.matcher(z).matches()) {
                while (true) {
                    String z2 = c2529l.m7122z();
                    if (z2 == null || z2.isEmpty()) {
                        break;
                    }
                }
            } else {
                Matcher matcher = C2471f.f6290a.matcher(z);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }
}

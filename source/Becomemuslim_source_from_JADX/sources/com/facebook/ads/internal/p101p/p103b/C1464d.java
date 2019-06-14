package com.facebook.ads.internal.p101p.p103b;

import android.text.TextUtils;
import com.facebook.stetho.common.Utf8Charset;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.facebook.ads.internal.p.b.d */
class C1464d {
    /* renamed from: d */
    private static final Pattern f4316d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    /* renamed from: e */
    private static final Pattern f4317e = Pattern.compile("GET /(.*) HTTP");
    /* renamed from: a */
    public final String f4318a;
    /* renamed from: b */
    public final long f4319b;
    /* renamed from: c */
    public final boolean f4320c;

    public C1464d(String str) {
        C1473j.m5210a(str);
        long a = m5175a(str);
        this.f4319b = Math.max(0, a);
        this.f4320c = a >= 0;
        this.f4318a = m5177b(str);
    }

    /* renamed from: a */
    private long m5175a(String str) {
        Matcher matcher = f4316d.matcher(str);
        return matcher.find() ? Long.parseLong(matcher.group(1)) : -1;
    }

    /* renamed from: a */
    public static C1464d m5176a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Utf8Charset.NAME));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            Object readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new C1464d(stringBuilder.toString());
            }
            stringBuilder.append(readLine);
            stringBuilder.append('\n');
        }
    }

    /* renamed from: b */
    private String m5177b(String str) {
        Matcher matcher = f4317e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid request `");
        stringBuilder.append(str);
        stringBuilder.append("`: url not found!");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GetRequest{rangeOffset=");
        stringBuilder.append(this.f4319b);
        stringBuilder.append(", partial=");
        stringBuilder.append(this.f4320c);
        stringBuilder.append(", uri='");
        stringBuilder.append(this.f4318a);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

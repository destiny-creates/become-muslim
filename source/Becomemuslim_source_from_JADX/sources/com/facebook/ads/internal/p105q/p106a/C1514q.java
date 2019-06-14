package com.facebook.ads.internal.p105q.p106a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import org.json.JSONArray;

/* renamed from: com.facebook.ads.internal.q.a.q */
public class C1514q {
    /* renamed from: a */
    public static final String m5318a(String str) {
        if (str == null) {
            return str;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ", true);
        if (str.length() <= 90) {
            return str;
        }
        if (str.length() <= 93 && str.endsWith("...")) {
            return str;
        }
        StringBuilder stringBuilder;
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            int length = stringTokenizer.nextToken().length() + i;
            if (length < 90) {
                i = length;
            }
        }
        if (i == 0) {
            stringBuilder = new StringBuilder();
            str = str.substring(0, 90);
        } else {
            stringBuilder = new StringBuilder();
            str = str.substring(0, i);
        }
        stringBuilder.append(str);
        stringBuilder.append("...");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static final String m5319a(Throwable th) {
        if (th == null) {
            return null;
        }
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static final String m5320a(StackTraceElement[] stackTraceElementArr) {
        JSONArray jSONArray = new JSONArray();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            jSONArray.put(stackTraceElement.toString());
        }
        return jSONArray.toString();
    }
}

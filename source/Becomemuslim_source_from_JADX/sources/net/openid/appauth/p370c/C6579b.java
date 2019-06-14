package net.openid.appauth.p370c;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.openid.appauth.C6605p;

/* compiled from: UriUtil */
/* renamed from: net.openid.appauth.c.b */
public final class C6579b {
    /* renamed from: a */
    public static Uri m26810a(String str) {
        return str == null ? null : Uri.parse(str);
    }

    /* renamed from: a */
    public static void m26814a(Builder builder, String str, Object obj) {
        if (obj != null && obj.toString() != null) {
            builder.appendQueryParameter(str, obj.toString());
        }
    }

    /* renamed from: a */
    public static Long m26811a(Uri uri, String str) {
        uri = uri.getQueryParameter(str);
        return uri != null ? Long.valueOf(Long.parseLong(uri)) : null;
    }

    /* renamed from: a */
    public static List<Bundle> m26813a(Uri[] uriArr, int i) {
        C6605p.m26935a(i >= 0, (Object) "startIndex must be positive");
        if (uriArr != null) {
            if (uriArr.length > i) {
                List<Bundle> arrayList = new ArrayList(uriArr.length - i);
                while (i < uriArr.length) {
                    if (uriArr[i] == null) {
                        C6578a.m26807c("Null URI in possibleUris list - ignoring", new Object[0]);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("android.support.customtabs.otherurls.URL", uriArr[i]);
                        arrayList.add(bundle);
                    }
                    i++;
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    /* renamed from: a */
    public static String m26812a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        Iterable arrayList = new ArrayList();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append(C6579b.m26815b((String) entry.getValue()));
            arrayList.add(stringBuilder.toString());
        }
        return TextUtils.join("&", arrayList);
    }

    /* renamed from: b */
    public static java.lang.String m26815b(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        net.openid.appauth.C6605p.m26932a(r1);
        r0 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x000a }
        r1 = java.net.URLEncoder.encode(r1, r0);	 Catch:{ UnsupportedEncodingException -> 0x000a }
        return r1;
    L_0x000a:
        r1 = new java.lang.IllegalStateException;
        r0 = "Unable to encode using UTF-8";
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.openid.appauth.c.b.b(java.lang.String):java.lang.String");
    }
}

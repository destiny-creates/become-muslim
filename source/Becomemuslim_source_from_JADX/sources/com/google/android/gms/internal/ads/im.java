package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.ax;

@cm
public final class im {
    /* renamed from: a */
    public static Uri m19557a(Uri uri, Context context) {
        if (!ax.B().m19551f(context) || !TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            return uri;
        }
        String j = ax.B().m19555j(context);
        uri = m19558a(uri.toString(), "fbs_aeid", j);
        ax.B().m19546d(context, j);
        return uri;
    }

    /* renamed from: a */
    private static Uri m19558a(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        indexOf++;
        StringBuilder stringBuilder = new StringBuilder(str.substring(0, indexOf));
        stringBuilder.append(str2);
        stringBuilder.append("=");
        stringBuilder.append(str3);
        stringBuilder.append("&");
        stringBuilder.append(str.substring(indexOf));
        return Uri.parse(stringBuilder.toString());
    }

    /* renamed from: a */
    public static String m19559a(String str, Context context) {
        if (ax.B().m19541a(context)) {
            if (!TextUtils.isEmpty(str)) {
                String j = ax.B().m19555j(context);
                if (j == null) {
                    return str;
                }
                if (((Boolean) aph.m18688f().m18889a(asp.at)).booleanValue()) {
                    String str2 = (String) aph.m18688f().m18889a(asp.au);
                    if (str.contains(str2)) {
                        if (ax.e().m19750d(str)) {
                            ax.B().m19546d(context, j);
                            return str.replace(str2, j);
                        } else if (ax.e().m19751e(str)) {
                            ax.B().m19548e(context, j);
                            return str.replace(str2, j);
                        }
                    }
                } else if (!str.contains("fbs_aeid")) {
                    if (ax.e().m19750d(str)) {
                        ax.B().m19546d(context, j);
                        return m19558a(str, "fbs_aeid", j).toString();
                    } else if (ax.e().m19751e(str)) {
                        ax.B().m19548e(context, j);
                        str = m19558a(str, "fbs_aeid", j).toString();
                    }
                }
            }
        }
        return str;
    }

    /* renamed from: b */
    public static String m19560b(String str, Context context) {
        if (ax.B().m19541a(context)) {
            if (!TextUtils.isEmpty(str)) {
                Object j = ax.B().m19555j(context);
                if (j == null || !ax.e().m19751e(str)) {
                    return str;
                }
                if (((Boolean) aph.m18688f().m18889a(asp.at)).booleanValue()) {
                    String str2 = (String) aph.m18688f().m18889a(asp.au);
                    if (str.contains(str2)) {
                        return str.replace(str2, j);
                    }
                } else if (!str.contains("fbs_aeid")) {
                    str = m19558a(str, "fbs_aeid", j).toString();
                }
            }
        }
        return str;
    }
}

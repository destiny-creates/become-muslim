package com.google.android.gms.internal.ads;

import com.facebook.internal.ServerProtocol;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

@cm
public final class rq {
    /* renamed from: a */
    private static final Pattern f15986a = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*\\s*<!DOCTYPE(\\s)+html(|(\\s)+[^>]*)>", 2);
    /* renamed from: b */
    private static final Pattern f15987b = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*?\\s*<!DOCTYPE[^>]*>", 2);

    /* renamed from: a */
    public static String m20060a() {
        String str = (String) aph.m18688f().m18889a(asp.f14921L);
        String str2 = "12.4.51-000";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, str);
            jSONObject.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, "Google Mobile Ads");
            jSONObject.put("sdkVersion", str2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<script>");
            stringBuilder.append("Object.defineProperty(window,'MRAID_ENV',{get:function(){return ");
            stringBuilder.append(jSONObject.toString());
            stringBuilder.append("}});");
            stringBuilder.append("</script>");
            return stringBuilder.toString();
        } catch (Throwable e) {
            mt.m19921c("Unable to build MRAID_ENV", e);
            return null;
        }
    }

    /* renamed from: a */
    public static String m20061a(String str, String... strArr) {
        if (strArr.length == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Matcher matcher = f15986a.matcher(str);
        int i = 0;
        int end;
        if (matcher.find()) {
            end = matcher.end();
            stringBuilder.append(str.substring(0, end));
            int length = strArr.length;
            while (i < length) {
                String str2 = strArr[i];
                if (str2 != null) {
                    stringBuilder.append(str2);
                }
                i++;
            }
            str = str.substring(end);
        } else if (!f15987b.matcher(str).find()) {
            end = strArr.length;
            while (i < end) {
                String str3 = strArr[i];
                if (str3 != null) {
                    stringBuilder.append(str3);
                }
                i++;
            }
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}

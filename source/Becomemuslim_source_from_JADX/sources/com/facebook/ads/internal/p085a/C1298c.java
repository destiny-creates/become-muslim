package com.facebook.ads.internal.p085a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1493a;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.a.c */
public class C1298c {
    /* renamed from: a */
    private static final String f3747a = "c";

    /* renamed from: a */
    public static C1297b m4444a(Context context, C1412c c1412c, String str, Uri uri, Map<String, String> map) {
        if (uri == null) {
            return null;
        }
        String authority = uri.getAuthority();
        String queryParameter = uri.getQueryParameter("video_url");
        if (!TextUtils.isEmpty(uri.getQueryParameter("data"))) {
            try {
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("data"));
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    map.put(str2, jSONObject.getString(str2));
                }
            } catch (Throwable e) {
                Log.w(f3747a, "Unable to parse json data in AdActionFactory.", e);
            }
        }
        C1304l a = C1304l.m4457a(c1412c, C1493a.m5262a());
        Object obj = -1;
        int hashCode = authority.hashCode();
        if (hashCode != -1458789996) {
            if (hashCode != 109770977) {
                if (hashCode == 1546100943) {
                    if (authority.equals("open_link")) {
                        obj = 1;
                    }
                }
            } else if (authority.equals("store")) {
                obj = null;
            }
        } else if (authority.equals("passthrough")) {
            obj = 2;
        }
        switch (obj) {
            case null:
                return queryParameter != null ? null : new C4556f(context, c1412c, str, uri, map, a);
            case 1:
                return new C4557i(context, c1412c, str, uri, map, a);
            case 2:
                return new C3546j(context, c1412c, str, uri, map);
            default:
                return new C3547k(context, c1412c, str, uri);
        }
    }

    /* renamed from: a */
    public static boolean m4445a(String str) {
        if (!"store".equalsIgnoreCase(str)) {
            if (!"open_link".equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }
}

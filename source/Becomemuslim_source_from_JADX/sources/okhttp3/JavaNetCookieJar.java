package okhttp3;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import okhttp3.Cookie.Builder;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

public final class JavaNetCookieJar implements CookieJar {
    private final CookieHandler cookieHandler;

    public JavaNetCookieJar(CookieHandler cookieHandler) {
        this.cookieHandler = cookieHandler;
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        if (this.cookieHandler != null) {
            List arrayList = new ArrayList();
            for (Cookie cookie : list) {
                arrayList.add(cookie.toString(true));
            }
            try {
                this.cookieHandler.put(httpUrl.uri(), Collections.singletonMap("Set-Cookie", arrayList));
            } catch (List<Cookie> list2) {
                Platform platform = Platform.get();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Saving cookies failed for ");
                stringBuilder.append(httpUrl.resolve("/..."));
                platform.log(5, stringBuilder.toString(), list2);
            }
        }
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        try {
            List list = null;
            for (Entry entry : this.cookieHandler.get(httpUrl.uri(), Collections.emptyMap()).entrySet()) {
                String str = (String) entry.getKey();
                if (("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) && !((List) entry.getValue()).isEmpty()) {
                    for (String str2 : (List) entry.getValue()) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.addAll(decodeHeaderAsJavaNetCookies(httpUrl, str2));
                    }
                }
            }
            if (list != null) {
                httpUrl = Collections.unmodifiableList(list);
            } else {
                httpUrl = Collections.emptyList();
            }
            return httpUrl;
        } catch (Throwable e) {
            Platform platform = Platform.get();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Loading cookies failed for ");
            stringBuilder.append(httpUrl.resolve("/..."));
            platform.log(5, stringBuilder.toString(), e);
            return Collections.emptyList();
        }
    }

    private List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl httpUrl, String str) {
        List<Cookie> arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int delimiterOffset = Util.delimiterOffset(str, i, length, ";,");
            int delimiterOffset2 = Util.delimiterOffset(str, i, delimiterOffset, '=');
            String trimSubstring = Util.trimSubstring(str, i, delimiterOffset2);
            if (!trimSubstring.startsWith("$")) {
                String trimSubstring2 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
                if (trimSubstring2.startsWith("\"") && trimSubstring2.endsWith("\"")) {
                    trimSubstring2 = trimSubstring2.substring(1, trimSubstring2.length() - 1);
                }
                arrayList.add(new Builder().name(trimSubstring).value(trimSubstring2).domain(httpUrl.host()).build());
            }
            i = delimiterOffset + 1;
        }
        return arrayList;
    }
}

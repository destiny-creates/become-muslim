package okhttp3.internal.http;

import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

public final class HttpHeaders {
    private static final Pattern PARAMETER = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    private static final String QUOTED_STRING = "\"([^\"]*)\"";
    private static final String TOKEN = "([^ \"=]*)";

    private HttpHeaders() {
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get(com.facebook.stetho.server.http.HttpHeaders.CONTENT_LENGTH));
    }

    private static long stringToLong(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = -1;
        if (r4 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = java.lang.Long.parseLong(r4);	 Catch:{ NumberFormatException -> 0x000a }
        return r2;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.stringToLong(java.lang.String):long");
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String str : varyFields(response)) {
            if (!Util.equal(headers.values(str), request.headers(str))) {
                return null;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> emptySet = Collections.emptySet();
        int size = headers.size();
        Set<String> set = emptySet;
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                if (set.isEmpty()) {
                    set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : value.split(",")) {
                    set.add(trim.trim());
                }
            }
        }
        return set;
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        headers2 = varyFields(headers2);
        if (headers2.isEmpty()) {
            return new Builder().build();
        }
        Builder builder = new Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (headers2.contains(name)) {
                builder.add(name, headers.value(i));
            }
        }
        return builder.build();
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        List<Challenge> arrayList = new ArrayList();
        for (String str2 : headers.values(str2)) {
            int indexOf = str2.indexOf(32);
            if (indexOf != -1) {
                String substring = str2.substring(0, indexOf);
                Matcher matcher = PARAMETER.matcher(str2);
                String str3 = null;
                String str4 = str3;
                while (matcher.find(indexOf)) {
                    if (str2.regionMatches(true, matcher.start(1), "realm", 0, 5)) {
                        str3 = matcher.group(3);
                    } else {
                        if (str2.regionMatches(true, matcher.start(1), "charset", 0, 7)) {
                            str4 = matcher.group(3);
                        }
                    }
                    if (str3 != null && r10 != null) {
                        break;
                    }
                    indexOf = matcher.end();
                }
                if (str3 != null) {
                    str2 = new Challenge(substring, str3);
                    if (str4 != null) {
                        if (str4.equalsIgnoreCase(Utf8Charset.NAME)) {
                            str2 = str2.withCharset(Util.UTF_8);
                        }
                    }
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar != CookieJar.NO_COOKIES) {
            headers = Cookie.parseAll(httpUrl, headers);
            if (!headers.isEmpty()) {
                cookieJar.saveFromResponse(httpUrl, headers);
            }
        }
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < HttpStatus.HTTP_OK) || code == 204 || code == 304) && contentLength(response) == -1) {
            if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding")) == null) {
                return false;
            }
        }
        return true;
    }

    public static int skipUntil(String str, int i, String str2) {
        while (i < str.length()) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                break;
            }
            i++;
        }
        return i;
    }

    public static int skipWhitespace(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                break;
            }
            i++;
        }
        return i;
    }

    public static int parseSeconds(java.lang.String r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x0019 }
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x000f;
    L_0x000b:
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        return r2;
    L_0x000f:
        r2 = 0;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0017;
    L_0x0015:
        r2 = 0;
        return r2;
    L_0x0017:
        r2 = (int) r0;
        return r2;
    L_0x0019:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.parseSeconds(java.lang.String, int):int");
    }
}

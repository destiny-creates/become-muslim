package okhttp3;

import com.facebook.common.util.UriUtil;
import com.facebook.imageutils.JfifUtil;
import com.facebook.soloader.MinElf;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import p286d.C8037c;

public final class HttpUrl {
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    final String host;
    private final String password;
    private final List<String> pathSegments;
    final int port;
    private final List<String> queryNamesAndValues;
    final String scheme;
    private final String url;
    private final String username;

    public static final class Builder {
        String encodedFragment;
        String encodedPassword = "";
        final List<String> encodedPathSegments = new ArrayList();
        List<String> encodedQueryNamesAndValues;
        String encodedUsername = "";
        String host;
        int port = -1;
        String scheme;

        enum ParseResult {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public Builder() {
            this.encodedPathSegments.add("");
        }

        public Builder scheme(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase(UriUtil.HTTP_SCHEME)) {
                    this.scheme = UriUtil.HTTP_SCHEME;
                } else if (str.equalsIgnoreCase(UriUtil.HTTPS_SCHEME)) {
                    this.scheme = UriUtil.HTTPS_SCHEME;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("unexpected scheme: ");
                    stringBuilder.append(str);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public Builder username(String str) {
            if (str != null) {
                this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public Builder encodedUsername(String str) {
            if (str != null) {
                this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedUsername == null");
        }

        public Builder password(String str) {
            if (str != null) {
                this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public Builder encodedPassword(String str) {
            if (str != null) {
                this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedPassword == null");
        }

        public Builder host(String str) {
            if (str != null) {
                String canonicalizeHost = canonicalizeHost(str, 0, str.length());
                if (canonicalizeHost != null) {
                    this.host = canonicalizeHost;
                    return this;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected host: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new NullPointerException("host == null");
        }

        public Builder port(int i) {
            if (i <= 0 || i > MinElf.PN_XNUM) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected port: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.port = i;
            return this;
        }

        int effectivePort() {
            return this.port != -1 ? this.port : HttpUrl.defaultPort(this.scheme);
        }

        public Builder addPathSegment(String str) {
            if (str != null) {
                push(str, 0, str.length(), false, false);
                return this;
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder addPathSegments(String str) {
            if (str != null) {
                return addPathSegments(str, false);
            }
            throw new NullPointerException("pathSegments == null");
        }

        public Builder addEncodedPathSegment(String str) {
            if (str != null) {
                push(str, 0, str.length(), false, true);
                return this;
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder addEncodedPathSegments(String str) {
            if (str != null) {
                return addPathSegments(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        private Builder addPathSegments(String str, boolean z) {
            int i = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(str, i, str.length(), "/\\");
                push(str, i, delimiterOffset, delimiterOffset < str.length(), z);
                i = delimiterOffset + 1;
            } while (i <= str.length());
            return this;
        }

        public Builder setPathSegment(int i, String str) {
            if (str != null) {
                String canonicalize = HttpUrl.canonicalize(str, 0, str.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, true, null);
                if (isDot(canonicalize) || isDotDot(canonicalize)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("unexpected path segment: ");
                    stringBuilder.append(str);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                this.encodedPathSegments.set(i, canonicalize);
                return this;
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder setEncodedPathSegment(int i, String str) {
            if (str != null) {
                String canonicalize = HttpUrl.canonicalize(str, 0, str.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, true, null);
                this.encodedPathSegments.set(i, canonicalize);
                if (isDot(canonicalize) == 0 && isDotDot(canonicalize) == 0) {
                    return this;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected path segment: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder removePathSegment(int i) {
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty() != 0) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public Builder encodedPath(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPath == null");
            } else if (str.startsWith("/")) {
                resolvePath(str, 0, str.length());
                return this;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected encodedPath: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        public Builder query(String str) {
            if (str != null) {
                str = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, HttpUrl.QUERY_ENCODE_SET, false, false, true, true));
            } else {
                str = null;
            }
            this.encodedQueryNamesAndValues = str;
            return this;
        }

        public Builder encodedQuery(String str) {
            if (str != null) {
                str = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, HttpUrl.QUERY_ENCODE_SET, true, false, true, true));
            } else {
                str = null;
            }
            this.encodedQueryNamesAndValues = str;
            return this;
        }

        public Builder addQueryParameter(String str, String str2) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
                str = this.encodedQueryNamesAndValues;
                if (str2 != null) {
                    str2 = HttpUrl.canonicalize(str2, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true);
                } else {
                    str2 = null;
                }
                str.add(str2);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public Builder addEncodedQueryParameter(String str, String str2) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
                str = this.encodedQueryNamesAndValues;
                if (str2 != null) {
                    str2 = HttpUrl.canonicalize(str2, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true);
                } else {
                    str2 = null;
                }
                str.add(str2);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public Builder setQueryParameter(String str, String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public Builder setEncodedQueryParameter(String str, String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public Builder removeAllQueryParameters(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (this.encodedQueryNamesAndValues == null) {
                return this;
            } else {
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
                return this;
            }
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            } else if (this.encodedQueryNamesAndValues == null) {
                return this;
            } else {
                removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
                return this;
            }
        }

        private void removeAllCanonicalQueryParameters(String str) {
            for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                    this.encodedQueryNamesAndValues.remove(size + 1);
                    this.encodedQueryNamesAndValues.remove(size);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
            }
        }

        public Builder fragment(String str) {
            if (str != null) {
                str = HttpUrl.canonicalize(str, "", false, false, false, false);
            } else {
                str = null;
            }
            this.encodedFragment = str;
            return this;
        }

        public Builder encodedFragment(String str) {
            if (str != null) {
                str = HttpUrl.canonicalize(str, "", true, false, false, false);
            } else {
                str = null;
            }
            this.encodedFragment = str;
            return this;
        }

        Builder reencodeForUri() {
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                this.encodedPathSegments.set(i, HttpUrl.canonicalize((String) this.encodedPathSegments.get(i), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            if (this.encodedQueryNamesAndValues != null) {
                size = this.encodedQueryNamesAndValues.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = (String) this.encodedQueryNamesAndValues.get(i2);
                    if (str != null) {
                        this.encodedQueryNamesAndValues.set(i2, HttpUrl.canonicalize(str, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            if (this.encodedFragment != null) {
                this.encodedFragment = HttpUrl.canonicalize(this.encodedFragment, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public HttpUrl build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.host != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.scheme);
            stringBuilder.append("://");
            if (!(this.encodedUsername.isEmpty() && this.encodedPassword.isEmpty())) {
                stringBuilder.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.encodedPassword);
                }
                stringBuilder.append('@');
            }
            if (this.host.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.host);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.host);
            }
            int effectivePort = effectivePort();
            if (effectivePort != HttpUrl.defaultPort(this.scheme)) {
                stringBuilder.append(':');
                stringBuilder.append(effectivePort);
            }
            HttpUrl.pathSegmentsToString(stringBuilder, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                stringBuilder.append('?');
                HttpUrl.namesAndValuesToQueryString(stringBuilder, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.encodedFragment);
            }
            return stringBuilder.toString();
        }

        ParseResult parse(HttpUrl httpUrl, String str) {
            int delimiterOffset;
            Builder builder = this;
            HttpUrl httpUrl2 = httpUrl;
            String str2 = str;
            int skipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str2, 0, str.length());
            int skipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str2, skipLeadingAsciiWhitespace, str.length());
            if (schemeDelimiterOffset(str2, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace) != -1) {
                if (str.regionMatches(true, skipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    builder.scheme = UriUtil.HTTPS_SCHEME;
                    skipLeadingAsciiWhitespace += "https:".length();
                } else {
                    if (!str.regionMatches(true, skipLeadingAsciiWhitespace, "http:", 0, 5)) {
                        return ParseResult.UNSUPPORTED_SCHEME;
                    }
                    builder.scheme = UriUtil.HTTP_SCHEME;
                    skipLeadingAsciiWhitespace += "http:".length();
                }
            } else if (httpUrl2 == null) {
                return ParseResult.MISSING_SCHEME;
            } else {
                builder.scheme = httpUrl2.scheme;
            }
            int slashCount = slashCount(str2, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            char c = '#';
            if (slashCount < 2 && httpUrl2 != null) {
                if (httpUrl2.scheme.equals(builder.scheme)) {
                    builder.encodedUsername = httpUrl.encodedUsername();
                    builder.encodedPassword = httpUrl.encodedPassword();
                    builder.host = httpUrl2.host;
                    builder.port = httpUrl2.port;
                    builder.encodedPathSegments.clear();
                    builder.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                    if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str2.charAt(skipLeadingAsciiWhitespace) == '#') {
                        encodedQuery(httpUrl.encodedQuery());
                    }
                    int i = skipLeadingAsciiWhitespace;
                    delimiterOffset = Util.delimiterOffset(str2, i, skipTrailingAsciiWhitespace, "?#");
                    resolvePath(str2, i, delimiterOffset);
                    if (delimiterOffset < skipTrailingAsciiWhitespace && str2.charAt(delimiterOffset) == '?') {
                        int delimiterOffset2 = Util.delimiterOffset(str2, delimiterOffset, skipTrailingAsciiWhitespace, '#');
                        builder.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, delimiterOffset + 1, delimiterOffset2, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                        delimiterOffset = delimiterOffset2;
                    }
                    if (delimiterOffset < skipTrailingAsciiWhitespace && str2.charAt(delimiterOffset) == '#') {
                        builder.encodedFragment = HttpUrl.canonicalize(str, 1 + delimiterOffset, skipTrailingAsciiWhitespace, "", true, false, false, false, null);
                    }
                    return ParseResult.SUCCESS;
                }
            }
            slashCount = skipLeadingAsciiWhitespace + slashCount;
            Object obj = null;
            Object obj2 = null;
            while (true) {
                skipLeadingAsciiWhitespace = Util.delimiterOffset(str2, slashCount, skipTrailingAsciiWhitespace, "@/\\?#");
                char charAt = skipLeadingAsciiWhitespace != skipTrailingAsciiWhitespace ? str2.charAt(skipLeadingAsciiWhitespace) : '￿';
                if (!(charAt == '￿' || charAt == r13 || charAt == '/' || charAt == '\\')) {
                    switch (charAt) {
                        case '?':
                            break;
                        case '@':
                            if (obj == null) {
                                int delimiterOffset3 = Util.delimiterOffset(str2, slashCount, skipLeadingAsciiWhitespace, ':');
                                int i2 = delimiterOffset3;
                                i = skipLeadingAsciiWhitespace;
                                String canonicalize = HttpUrl.canonicalize(str, slashCount, delimiterOffset3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                if (obj2 != null) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(builder.encodedUsername);
                                    stringBuilder.append("%40");
                                    stringBuilder.append(canonicalize);
                                    canonicalize = stringBuilder.toString();
                                }
                                builder.encodedUsername = canonicalize;
                                if (i2 != i) {
                                    builder.encodedPassword = HttpUrl.canonicalize(str, i2 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    obj = 1;
                                }
                                obj2 = 1;
                            } else {
                                i = skipLeadingAsciiWhitespace;
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(builder.encodedPassword);
                                stringBuilder2.append("%40");
                                stringBuilder2.append(HttpUrl.canonicalize(str, slashCount, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                                builder.encodedPassword = stringBuilder2.toString();
                            }
                            slashCount = i + 1;
                            continue;
                        default:
                            continue;
                    }
                }
                i = skipLeadingAsciiWhitespace;
                delimiterOffset = portColonOffset(str2, slashCount, i);
                int i3 = delimiterOffset + 1;
                if (i3 < i) {
                    builder.host = canonicalizeHost(str2, slashCount, delimiterOffset);
                    builder.port = parsePort(str2, i3, i);
                    if (builder.port == -1) {
                        return ParseResult.INVALID_PORT;
                    }
                }
                builder.host = canonicalizeHost(str2, slashCount, delimiterOffset);
                builder.port = HttpUrl.defaultPort(builder.scheme);
                if (builder.host == null) {
                    return ParseResult.INVALID_HOST;
                }
                delimiterOffset = Util.delimiterOffset(str2, i, skipTrailingAsciiWhitespace, "?#");
                resolvePath(str2, i, delimiterOffset);
                int delimiterOffset22 = Util.delimiterOffset(str2, delimiterOffset, skipTrailingAsciiWhitespace, '#');
                builder.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, delimiterOffset + 1, delimiterOffset22, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
                delimiterOffset = delimiterOffset22;
                builder.encodedFragment = HttpUrl.canonicalize(str, 1 + delimiterOffset, skipTrailingAsciiWhitespace, "", true, false, false, false, null);
                return ParseResult.SUCCESS;
                c = '#';
            }
        }

        private void resolvePath(String str, int i, int i2) {
            if (i != i2) {
                int i3;
                boolean z;
                char charAt = str.charAt(i);
                if (charAt != '/') {
                    if (charAt != '\\') {
                        this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
                        while (true) {
                            i3 = i;
                            if (i3 < i2) {
                                i = Util.delimiterOffset(str, i3, i2, "/\\");
                                z = i >= i2;
                                push(str, i3, i, z, true);
                                if (z) {
                                    i++;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i++;
                while (true) {
                    i3 = i;
                    if (i3 < i2) {
                        i = Util.delimiterOffset(str, i3, i2, "/\\");
                        if (i >= i2) {
                        }
                        push(str, i3, i, z, true);
                        if (z) {
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        private void push(String str, int i, int i2, boolean z, boolean z2) {
            str = HttpUrl.canonicalize(str, i, i2, HttpUrl.PATH_SEGMENT_ENCODE_SET, z2, false, false, true, null);
            if (isDot(str) == 0) {
                if (isDotDot(str) != 0) {
                    pop();
                    return;
                }
                if (((String) this.encodedPathSegments.get(this.encodedPathSegments.size() - 1)).isEmpty() != 0) {
                    this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, str);
                } else {
                    this.encodedPathSegments.add(str);
                }
                if (z) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private boolean isDot(String str) {
            if (!str.equals(".")) {
                if (str.equalsIgnoreCase("%2e") == null) {
                    return null;
                }
            }
            return true;
        }

        private boolean isDotDot(String str) {
            if (!(str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e"))) {
                if (str.equalsIgnoreCase("%2e%2e") == null) {
                    return null;
                }
            }
            return true;
        }

        private void pop() {
            if (!((String) this.encodedPathSegments.remove(this.encodedPathSegments.size() - 1)).isEmpty() || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
            }
        }

        private static int schemeDelimiterOffset(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if (charAt < 'a' || charAt > 'z') {
                if (charAt >= 'A') {
                    if (charAt > 'Z') {
                    }
                }
                return -1;
            }
            while (true) {
                i++;
                if (i < i2) {
                    charAt = str.charAt(i);
                    if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && !((charAt >= '0' && charAt <= '9') || charAt == '+' || charAt == '-'))) {
                        if (charAt != '.') {
                            break;
                        }
                    }
                } else {
                    return -1;
                }
            }
            if (charAt == ':') {
                return i;
            }
            return -1;
        }

        private static int slashCount(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int portColonOffset(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String canonicalizeHost(String str, int i, int i2) {
            return Util.canonicalizeHost(HttpUrl.percentDecode(str, i, i2, false));
        }

        private static int parsePort(java.lang.String r10, int r11, int r12) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = -1;
            r4 = "";	 Catch:{ NumberFormatException -> 0x001c }
            r5 = 0;	 Catch:{ NumberFormatException -> 0x001c }
            r6 = 0;	 Catch:{ NumberFormatException -> 0x001c }
            r7 = 0;	 Catch:{ NumberFormatException -> 0x001c }
            r8 = 1;	 Catch:{ NumberFormatException -> 0x001c }
            r9 = 0;	 Catch:{ NumberFormatException -> 0x001c }
            r1 = r10;	 Catch:{ NumberFormatException -> 0x001c }
            r2 = r11;	 Catch:{ NumberFormatException -> 0x001c }
            r3 = r12;	 Catch:{ NumberFormatException -> 0x001c }
            r10 = okhttp3.HttpUrl.canonicalize(r1, r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ NumberFormatException -> 0x001c }
            r10 = java.lang.Integer.parseInt(r10);	 Catch:{ NumberFormatException -> 0x001c }
            if (r10 <= 0) goto L_0x001b;
        L_0x0015:
            r11 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
            if (r10 > r11) goto L_0x001b;
        L_0x001a:
            return r10;
        L_0x001b:
            return r0;
        L_0x001c:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.parsePort(java.lang.String, int, int):int");
        }
    }

    HttpUrl(Builder builder) {
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments, false);
        String str = null;
        this.queryNamesAndValues = builder.encodedQueryNamesAndValues != null ? percentDecode(builder.encodedQueryNamesAndValues, true) : null;
        if (builder.encodedFragment != null) {
            str = percentDecode(builder.encodedFragment, false);
        }
        this.fragment = str;
        this.url = builder.toString();
    }

    public URL url() {
        try {
            return new URL(this.url);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public java.net.URI uri() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.newBuilder();
        r0 = r0.reencodeForUri();
        r0 = r0.toString();
        r1 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x0012 }
        r1.<init>(r0);	 Catch:{ URISyntaxException -> 0x0012 }
        return r1;
    L_0x0012:
        r1 = move-exception;
        r2 = "[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]";	 Catch:{ Exception -> 0x0020 }
        r3 = "";	 Catch:{ Exception -> 0x0020 }
        r0 = r0.replaceAll(r2, r3);	 Catch:{ Exception -> 0x0020 }
        r0 = java.net.URI.create(r0);	 Catch:{ Exception -> 0x0020 }
        return r0;
    L_0x0020:
        r0 = new java.lang.RuntimeException;
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.uri():java.net.URI");
    }

    public String scheme() {
        return this.scheme;
    }

    public boolean isHttps() {
        return this.scheme.equals(UriUtil.HTTPS_SCHEME);
    }

    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        return this.url.substring(length, Util.delimiterOffset(this.url, length, this.url.length(), ":@"));
    }

    public String username() {
        return this.username;
    }

    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, this.url.indexOf(64));
    }

    public String password() {
        return this.password;
    }

    public String host() {
        return this.host;
    }

    public int port() {
        return this.port;
    }

    public static int defaultPort(String str) {
        if (str.equals(UriUtil.HTTP_SCHEME)) {
            return 80;
        }
        return str.equals(UriUtil.HTTPS_SCHEME) != null ? 443 : -1;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public String encodedPath() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        return this.url.substring(indexOf, Util.delimiterOffset(this.url, indexOf, this.url.length(), "?#"));
    }

    static void pathSegmentsToString(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    public List<String> encodedPathSegments() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        int delimiterOffset = Util.delimiterOffset(this.url, indexOf, this.url.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            indexOf++;
            int delimiterOffset2 = Util.delimiterOffset(this.url, indexOf, delimiterOffset, '/');
            arrayList.add(this.url.substring(indexOf, delimiterOffset2));
            indexOf = delimiterOffset2;
        }
        return arrayList;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf = this.url.indexOf(63) + 1;
        return this.url.substring(indexOf, Util.delimiterOffset(this.url, indexOf, this.url.length(), '#'));
    }

    static void namesAndValuesToQueryString(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    static List<String> queryStringToNamesAndValues(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1) {
                if (indexOf2 <= indexOf) {
                    arrayList.add(str.substring(i, indexOf2));
                    arrayList.add(str.substring(indexOf2 + 1, indexOf));
                    i = indexOf + 1;
                }
            }
            arrayList.add(str.substring(i, indexOf));
            arrayList.add(null);
            i = indexOf + 1;
        }
        return arrayList;
    }

    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        namesAndValuesToQueryString(stringBuilder, this.queryNamesAndValues);
        return stringBuilder.toString();
    }

    public int querySize() {
        return this.queryNamesAndValues != null ? this.queryNamesAndValues.size() / 2 : 0;
    }

    public String queryParameter(String str) {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                return (String) this.queryNamesAndValues.get(i + 1);
            }
        }
        return null;
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public List<String> queryParameterValues(String str) {
        if (this.queryNamesAndValues == null) {
            return Collections.emptyList();
        }
        List arrayList = new ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                arrayList.add(this.queryNamesAndValues.get(i + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String queryParameterName(int i) {
        if (this.queryNamesAndValues != null) {
            return (String) this.queryNamesAndValues.get(i * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public String queryParameterValue(int i) {
        if (this.queryNamesAndValues != null) {
            return (String) this.queryNamesAndValues.get((i * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    public String fragment() {
        return this.fragment;
    }

    public String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    public HttpUrl resolve(String str) {
        str = newBuilder(str);
        return str != null ? str.build() : null;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        builder.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment = encodedFragment();
        return builder;
    }

    public Builder newBuilder(String str) {
        Builder builder = new Builder();
        return builder.parse(this, str) == ParseResult.SUCCESS ? builder : null;
    }

    public static HttpUrl parse(String str) {
        Builder builder = new Builder();
        if (builder.parse(null, str) == ParseResult.SUCCESS) {
            return builder.build();
        }
        return null;
    }

    public static HttpUrl get(URL url) {
        return parse(url.toString());
    }

    static HttpUrl getChecked(String str) {
        Builder builder = new Builder();
        ParseResult parse = builder.parse(null, str);
        switch (parse) {
            case SUCCESS:
                return builder.build();
            case INVALID_HOST:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid host: ");
                stringBuilder.append(str);
                throw new UnknownHostException(stringBuilder.toString());
            default:
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Invalid URL: ");
                stringBuilder2.append(parse);
                stringBuilder2.append(" for ");
                stringBuilder2.append(str);
                throw new MalformedURLException(stringBuilder2.toString());
        }
    }

    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    public boolean equals(Object obj) {
        return (!(obj instanceof HttpUrl) || ((HttpUrl) obj).url.equals(this.url) == null) ? null : true;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return this.url;
    }

    public String topPrivateDomain() {
        if (Util.verifyAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.host);
    }

    static String percentDecode(String str, boolean z) {
        return percentDecode(str, 0, str.length(), z);
    }

    private List<String> percentDecode(List<String> list, boolean z) {
        int size = list.size();
        List arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            arrayList.add(str != null ? percentDecode(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String percentDecode(String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt != '%') {
                if (charAt != '+' || !z) {
                    i3++;
                }
            }
            C8037c c8037c = new C8037c();
            c8037c.m38970a(str, i, i3);
            percentDecode(c8037c, str, i3, i2, z);
            return c8037c.m39022q();
        }
        return str.substring(i, i2);
    }

    static void percentDecode(C8037c c8037c, String str, int i, int i2, boolean z) {
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37) {
                int i3 = i + 2;
                if (i3 < i2) {
                    int decodeHexDigit = Util.decodeHexDigit(str.charAt(i + 1));
                    int decodeHexDigit2 = Util.decodeHexDigit(str.charAt(i3));
                    if (!(decodeHexDigit == -1 || decodeHexDigit2 == -1)) {
                        c8037c.m38981b((decodeHexDigit << 4) + decodeHexDigit2);
                        i = i3;
                        i += Character.charCount(codePointAt);
                    }
                    c8037c.m38966a(codePointAt);
                    i += Character.charCount(codePointAt);
                }
            }
            if (codePointAt == 43 && z) {
                c8037c.m38981b(32);
                i += Character.charCount(codePointAt);
            }
            c8037c.m38966a(codePointAt);
            i += Character.charCount(codePointAt);
        }
    }

    static boolean percentEncoded(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != 37 || Util.decodeHexDigit(str.charAt(i + 1)) == -1 || Util.decodeHexDigit(str.charAt(i3)) == -1) {
            return false;
        }
        return true;
    }

    static String canonicalize(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int codePointAt;
        String str3 = str;
        int i3 = i2;
        int i4 = i;
        while (i4 < i3) {
            codePointAt = str.codePointAt(i4);
            String str4;
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                str4 = str2;
            } else {
                str4 = str2;
                if (str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || percentEncoded(str, i4, i2))))) {
                    if (codePointAt != 43 || !z3) {
                        i4 += Character.charCount(codePointAt);
                    }
                }
            }
            C8037c c8037c = new C8037c();
            codePointAt = i;
            c8037c.m38970a(str, i, i4);
            canonicalize(c8037c, str, i4, i2, str2, z, z2, z3, z4, charset);
            return c8037c.m39022q();
        }
        codePointAt = i;
        return str.substring(i, i2);
    }

    static void canonicalize(C8037c c8037c, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        C8037c c8037c2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (z) {
                if (!(codePointAt == 9 || codePointAt == 10 || codePointAt == 12)) {
                    if (codePointAt == 13) {
                    }
                }
                i += Character.charCount(codePointAt);
            }
            if (codePointAt == 43 && z3) {
                c8037c.m38969a(z ? "+" : "%2B");
                i += Character.charCount(codePointAt);
            } else {
                int h;
                if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1)) {
                    if (codePointAt == 37) {
                        if (z) {
                            if (z2 && !percentEncoded(str, i, i2)) {
                            }
                        }
                    }
                    c8037c.m38966a(codePointAt);
                    i += Character.charCount(codePointAt);
                }
                if (c8037c2 == null) {
                    c8037c2 = new C8037c();
                }
                if (charset != null) {
                    if (!charset.equals(Util.UTF_8)) {
                        c8037c2.m38971a(str, i, Character.charCount(codePointAt) + i, charset);
                        while (!c8037c2.mo6300e()) {
                            h = c8037c2.mo6304h() & JfifUtil.MARKER_FIRST_BYTE;
                            c8037c.m38981b(37);
                            c8037c.m38981b(HEX_DIGITS[(h >> 4) & 15]);
                            c8037c.m38981b(HEX_DIGITS[h & 15]);
                        }
                        i += Character.charCount(codePointAt);
                    }
                }
                c8037c2.m38966a(codePointAt);
                while (!c8037c2.mo6300e()) {
                    h = c8037c2.mo6304h() & JfifUtil.MARKER_FIRST_BYTE;
                    c8037c.m38981b(37);
                    c8037c.m38981b(HEX_DIGITS[(h >> 4) & 15]);
                    c8037c.m38981b(HEX_DIGITS[h & 15]);
                }
                i += Character.charCount(codePointAt);
            }
        }
    }

    static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return canonicalize(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return canonicalize(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}

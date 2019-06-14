package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType {
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;

    private MediaType(String str, String str2, String str3, String str4) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.charset = str4;
    }

    public static MediaType parse(String str) {
        Matcher matcher = TYPE_SUBTYPE.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String toLowerCase = matcher.group(1).toLowerCase(Locale.US);
        String toLowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = PARAMETER.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null) {
                if (group.equalsIgnoreCase("charset")) {
                    group = matcher2.group(2);
                    if (group == null) {
                        group = matcher2.group(3);
                    } else if (group.startsWith("'") && group.endsWith("'") && group.length() > 2) {
                        group = group.substring(1, group.length() - 1);
                    }
                    if (str2 != null && !group.equalsIgnoreCase(str2)) {
                        return null;
                    }
                    str2 = group;
                }
            }
        }
        return new MediaType(str, toLowerCase, toLowerCase2, str2);
    }

    public String type() {
        return this.type;
    }

    public String subtype() {
        return this.subtype;
    }

    public Charset charset() {
        return charset(null);
    }

    public java.nio.charset.Charset charset(java.nio.charset.Charset r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.charset;	 Catch:{ IllegalArgumentException -> 0x000c }
        if (r0 == 0) goto L_0x000b;	 Catch:{ IllegalArgumentException -> 0x000c }
    L_0x0004:
        r0 = r1.charset;	 Catch:{ IllegalArgumentException -> 0x000c }
        r0 = java.nio.charset.Charset.forName(r0);	 Catch:{ IllegalArgumentException -> 0x000c }
        r2 = r0;
    L_0x000b:
        return r2;
    L_0x000c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.MediaType.charset(java.nio.charset.Charset):java.nio.charset.Charset");
    }

    public String toString() {
        return this.mediaType;
    }

    public boolean equals(Object obj) {
        return (!(obj instanceof MediaType) || ((MediaType) obj).mediaType.equals(this.mediaType) == null) ? null : true;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }
}

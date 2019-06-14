package expolib_v1.p321a;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MediaType */
/* renamed from: expolib_v1.a.u */
public final class C6240u {
    /* renamed from: a */
    private static final Pattern f20319a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    /* renamed from: b */
    private static final Pattern f20320b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    /* renamed from: c */
    private final String f20321c;
    /* renamed from: d */
    private final String f20322d;
    /* renamed from: e */
    private final String f20323e;
    /* renamed from: f */
    private final String f20324f;

    private C6240u(String str, String str2, String str3, String str4) {
        this.f20321c = str;
        this.f20322d = str2;
        this.f20323e = str3;
        this.f20324f = str4;
    }

    /* renamed from: a */
    public static C6240u m25781a(String str) {
        Matcher matcher = f20319a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String toLowerCase = matcher.group(1).toLowerCase(Locale.US);
        String toLowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f20320b.matcher(str);
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
                    if (str2 != null) {
                        if (!group.equalsIgnoreCase(str2)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Multiple different charsets: ");
                            stringBuilder.append(str);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                    str2 = group;
                }
            }
        }
        return new C6240u(str, toLowerCase, toLowerCase2, str2);
    }

    /* renamed from: a */
    public String m25782a() {
        return this.f20322d;
    }

    /* renamed from: b */
    public Charset m25784b() {
        return this.f20324f != null ? Charset.forName(this.f20324f) : null;
    }

    /* renamed from: a */
    public Charset m25783a(Charset charset) {
        return this.f20324f != null ? Charset.forName(this.f20324f) : charset;
    }

    public String toString() {
        return this.f20321c;
    }

    public boolean equals(Object obj) {
        return (!(obj instanceof C6240u) || ((C6240u) obj).f20321c.equals(this.f20321c) == null) ? null : true;
    }

    public int hashCode() {
        return this.f20321c.hashCode();
    }
}

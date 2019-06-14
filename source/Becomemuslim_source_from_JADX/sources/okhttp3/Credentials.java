package okhttp3;

import java.nio.charset.Charset;
import okhttp3.internal.Util;
import p286d.C5869f;

public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        return basic(str, str2, Util.ISO_8859_1);
    }

    public static String basic(String str, String str2, Charset charset) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(str2);
        str = C5869f.m24698a(stringBuilder.toString(), charset).mo5103b();
        str2 = new StringBuilder();
        str2.append("Basic ");
        str2.append(str);
        return str2.toString();
    }
}

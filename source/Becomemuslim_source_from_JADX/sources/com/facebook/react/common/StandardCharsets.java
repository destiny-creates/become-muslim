package com.facebook.react.common;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;

public class StandardCharsets {
    public static final Charset UTF_16 = Charset.forName("UTF-16");
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
    public static final Charset UTF_8 = Charset.forName(Utf8Charset.NAME);
}

package org.apache.p371a.p376c;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;

/* compiled from: Charsets */
/* renamed from: org.apache.a.c.a */
public class C6643a {
    /* renamed from: a */
    public static final Charset f21343a = Charset.forName("ISO-8859-1");
    /* renamed from: b */
    public static final Charset f21344b = Charset.forName("US-ASCII");
    /* renamed from: c */
    public static final Charset f21345c = Charset.forName("UTF-16");
    /* renamed from: d */
    public static final Charset f21346d = Charset.forName("UTF-16BE");
    /* renamed from: e */
    public static final Charset f21347e = Charset.forName("UTF-16LE");
    /* renamed from: f */
    public static final Charset f21348f = Charset.forName(Utf8Charset.NAME);

    /* renamed from: a */
    public static Charset m27035a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    /* renamed from: a */
    public static Charset m27034a(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }
}

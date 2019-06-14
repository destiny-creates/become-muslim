package com.p064b.p065a.p067b;

import java.io.InputStream;
import java.util.Properties;

/* compiled from: BuildProperties */
/* renamed from: com.b.a.b.d */
class C1003d {
    /* renamed from: a */
    public final String f2807a;
    /* renamed from: b */
    public final String f2808b;
    /* renamed from: c */
    public final String f2809c;
    /* renamed from: d */
    public final String f2810d;

    C1003d(String str, String str2, String str3, String str4) {
        this.f2807a = str;
        this.f2808b = str2;
        this.f2809c = str3;
        this.f2810d = str4;
    }

    /* renamed from: a */
    public static C1003d m3448a(Properties properties) {
        return new C1003d(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    /* renamed from: a */
    public static C1003d m3447a(InputStream inputStream) {
        Properties properties = new Properties();
        properties.load(inputStream);
        return C1003d.m3448a(properties);
    }
}

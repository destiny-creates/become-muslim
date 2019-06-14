package org.apache.p371a.p376c;

import java.io.File;

/* compiled from: FilenameUtils */
/* renamed from: org.apache.a.c.c */
public class C6645c {
    /* renamed from: a */
    public static final String f21359a = Character.toString('.');
    /* renamed from: b */
    private static final char f21360b = File.separatorChar;
    /* renamed from: c */
    private static final char f21361c;

    static {
        if (C6645c.m27048a()) {
            f21361c = '/';
        } else {
            f21361c = '\\';
        }
    }

    /* renamed from: a */
    static boolean m27048a() {
        return f21360b == '\\';
    }

    /* renamed from: a */
    public static int m27047a(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    /* renamed from: b */
    public static int m27049b(String str) {
        int i = -1;
        if (str == null) {
            return -1;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (C6645c.m27047a(str) <= lastIndexOf) {
            i = lastIndexOf;
        }
        return i;
    }

    /* renamed from: c */
    public static String m27050c(String str) {
        if (str == null) {
            return null;
        }
        int b = C6645c.m27049b(str);
        if (b == -1) {
            return "";
        }
        return str.substring(b + 1);
    }
}

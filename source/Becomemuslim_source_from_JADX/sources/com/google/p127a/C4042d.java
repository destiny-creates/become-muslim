package com.google.p127a;

import java.lang.reflect.Field;

/* compiled from: FieldNamingPolicy */
/* renamed from: com.google.a.d */
public enum C4042d implements C2156e {
    IDENTITY {
        /* renamed from: a */
        public String mo3167a(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        /* renamed from: a */
        public String mo3167a(Field field) {
            return C4042d.m12446b(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        /* renamed from: a */
        public String mo3167a(Field field) {
            return C4042d.m12446b(C4042d.m12447b(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        /* renamed from: a */
        public String mo3167a(Field field) {
            return C4042d.m12447b(field.getName(), "_").toLowerCase();
        }
    },
    LOWER_CASE_WITH_DASHES {
        /* renamed from: a */
        public String mo3167a(Field field) {
            return C4042d.m12447b(field.getName(), "-").toLowerCase();
        }
    };

    /* renamed from: b */
    private static String m12447b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && stringBuilder.length() != 0) {
                stringBuilder.append(str2);
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private static String m12446b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        char charAt = str.charAt(0);
        while (i < str.length() - 1) {
            if (Character.isLetter(charAt)) {
                break;
            }
            stringBuilder.append(charAt);
            i++;
            charAt = str.charAt(i);
        }
        if (i == str.length()) {
            return stringBuilder.toString();
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        stringBuilder.append(C4042d.m12443a(Character.toUpperCase(charAt), str, i + 1));
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static String m12443a(char c, String str, int i) {
        if (i >= str.length()) {
            return String.valueOf(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append(str.substring(i));
        return stringBuilder.toString();
    }
}

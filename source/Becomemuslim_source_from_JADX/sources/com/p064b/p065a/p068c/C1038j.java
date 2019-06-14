package com.p064b.p065a.p068c;

/* compiled from: CrashlyticsMissingDependencyException */
/* renamed from: com.b.a.c.j */
public class C1038j extends RuntimeException {
    private static final long serialVersionUID = -1151536370019872859L;

    C1038j(String str) {
        super(C1038j.m3569a(str));
    }

    /* renamed from: a */
    private static String m3569a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append(str);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        return stringBuilder.toString();
    }
}

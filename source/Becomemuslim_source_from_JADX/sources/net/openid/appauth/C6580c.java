package net.openid.appauth;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: AsciiStringListUtil */
/* renamed from: net.openid.appauth.c */
final class C6580c {
    /* renamed from: a */
    public static String m26816a(Iterable<String> iterable) {
        if (iterable == null) {
            return null;
        }
        Iterable linkedHashSet = new LinkedHashSet();
        for (String str : iterable) {
            C6605p.m26935a(TextUtils.isEmpty(str) ^ 1, (Object) "individual scopes cannot be null or empty");
            linkedHashSet.add(str);
        }
        if (linkedHashSet.isEmpty() != null) {
            return null;
        }
        return TextUtils.join(" ", linkedHashSet);
    }

    /* renamed from: a */
    public static Set<String> m26817a(String str) {
        if (str == null) {
            return null;
        }
        str = Arrays.asList(TextUtils.split(str, " "));
        Set linkedHashSet = new LinkedHashSet(str.size());
        linkedHashSet.addAll(str);
        return linkedHashSet;
    }
}

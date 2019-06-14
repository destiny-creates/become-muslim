package org.apache.p371a.p372a;

import java.util.List;

/* compiled from: MissingOptionException */
/* renamed from: org.apache.a.a.g */
public class C7677g extends C6635l {
    /* renamed from: a */
    private List f26419a;

    public C7677g(String str) {
        super(str);
    }

    public C7677g(List list) {
        this(C7677g.m34546a(list));
        this.f26419a = list;
    }

    /* renamed from: a */
    private static String m34546a(List list) {
        StringBuffer stringBuffer = new StringBuffer("Missing required option");
        stringBuffer.append(list.size() == 1 ? "" : "s");
        stringBuffer.append(": ");
        list = list.iterator();
        while (list.hasNext()) {
            stringBuffer.append(list.next());
            if (list.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }
}

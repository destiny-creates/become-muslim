package org.apache.p371a.p372a;

/* compiled from: MissingArgumentException */
/* renamed from: org.apache.a.a.f */
public class C7676f extends C6635l {
    /* renamed from: a */
    private C6631h f26418a;

    public C7676f(String str) {
        super(str);
    }

    public C7676f(C6631h c6631h) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Missing argument for option: ");
        stringBuffer.append(c6631h.m26990a());
        this(stringBuffer.toString());
        this.f26418a = c6631h;
    }
}

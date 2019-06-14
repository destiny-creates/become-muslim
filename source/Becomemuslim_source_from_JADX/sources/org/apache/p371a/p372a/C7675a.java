package org.apache.p371a.p372a;

/* compiled from: AlreadySelectedException */
/* renamed from: org.apache.a.a.a */
public class C7675a extends C6635l {
    /* renamed from: a */
    private C6632i f26416a;
    /* renamed from: b */
    private C6631h f26417b;

    public C7675a(String str) {
        super(str);
    }

    public C7675a(C6632i c6632i, C6631h c6631h) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The option '");
        stringBuffer.append(c6631h.m26990a());
        stringBuffer.append("' was specified but an option from this group ");
        stringBuffer.append("has already been selected: '");
        stringBuffer.append(c6632i.m27008b());
        stringBuffer.append("'");
        this(stringBuffer.toString());
        this.f26416a = c6632i;
        this.f26417b = c6631h;
    }
}

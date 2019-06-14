package org.spongycastle.i18n;

public class LocalizedMessage {
    /* renamed from: a */
    protected final String f22652a;
    /* renamed from: b */
    protected final String f22653b;
    /* renamed from: c */
    protected String f22654c;
    /* renamed from: d */
    protected FilteredArguments f22655d;
    /* renamed from: e */
    protected FilteredArguments f22656e;
    /* renamed from: f */
    protected ClassLoader f22657f;

    protected class FilteredArguments {
        /* renamed from: a */
        protected Object[] f22651a;

        /* renamed from: a */
        public Object[] m27887a() {
            return this.f22651a;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Resource: \"");
        stringBuffer.append(this.f22653b);
        stringBuffer.append("\" Id: \"");
        stringBuffer.append(this.f22652a);
        stringBuffer.append("\"");
        stringBuffer.append(" Arguments: ");
        stringBuffer.append(this.f22655d.m27887a().length);
        stringBuffer.append(" normal");
        if (this.f22656e != null && this.f22656e.m27887a().length > 0) {
            stringBuffer.append(", ");
            stringBuffer.append(this.f22656e.m27887a().length);
            stringBuffer.append(" extra");
        }
        stringBuffer.append(" Encoding: ");
        stringBuffer.append(this.f22654c);
        stringBuffer.append(" ClassLoader: ");
        stringBuffer.append(this.f22657f);
        return stringBuffer.toString();
    }
}

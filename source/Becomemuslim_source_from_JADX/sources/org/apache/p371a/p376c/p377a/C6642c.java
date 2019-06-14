package org.apache.p371a.p376c.p377a;

import java.io.Serializable;
import java.io.Writer;

/* compiled from: StringBuilderWriter */
/* renamed from: org.apache.a.c.a.c */
public class C6642c extends Writer implements Serializable {
    /* renamed from: a */
    private final StringBuilder f21342a;

    public void close() {
    }

    public void flush() {
    }

    public C6642c() {
        this.f21342a = new StringBuilder();
    }

    public C6642c(int i) {
        this.f21342a = new StringBuilder(i);
    }

    public Writer append(char c) {
        this.f21342a.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.f21342a.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        this.f21342a.append(charSequence, i, i2);
        return this;
    }

    public void write(String str) {
        if (str != null) {
            this.f21342a.append(str);
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.f21342a.append(cArr, i, i2);
        }
    }

    public String toString() {
        return this.f21342a.toString();
    }
}

package org.apache.p371a.p372a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: CommandLine */
/* renamed from: org.apache.a.a.b */
public class C6626b implements Serializable {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private List f21298a = new LinkedList();
    /* renamed from: b */
    private List f21299b = new ArrayList();

    C6626b() {
    }

    /* renamed from: a */
    public boolean m26974a(String str) {
        return this.f21299b.contains(m26971c(str));
    }

    /* renamed from: c */
    private C6631h m26971c(String str) {
        str = C6636o.m27019a(str);
        for (C6631h c6631h : this.f21299b) {
            if (str.equals(c6631h.m26992b())) {
                return c6631h;
            }
            if (str.equals(c6631h.m26993c())) {
                return c6631h;
            }
        }
        return null;
    }

    /* renamed from: a */
    public List m26972a() {
        return this.f21298a;
    }

    /* renamed from: b */
    void m26975b(String str) {
        this.f21298a.add(str);
    }

    /* renamed from: a */
    void m26973a(C6631h c6631h) {
        this.f21299b.add(c6631h);
    }
}

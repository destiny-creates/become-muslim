package org.apache.p378b.p379a.p381c;

import com.facebook.stetho.server.http.HttpStatus;
import java.util.EnumSet;
import java.util.Iterator;

/* compiled from: StandardLevel */
/* renamed from: org.apache.b.a.c.i */
public enum C6655i {
    OFF(0),
    FATAL(100),
    ERROR(HttpStatus.HTTP_OK),
    WARN(300),
    INFO(400),
    DEBUG(HttpStatus.HTTP_INTERNAL_SERVER_ERROR),
    TRACE(600),
    ALL(Integer.MAX_VALUE);
    
    /* renamed from: j */
    private static final EnumSet<C6655i> f21395j = null;
    /* renamed from: i */
    private final int f21397i;

    static {
        f21395j = EnumSet.allOf(C6655i.class);
    }

    private C6655i(int i) {
        this.f21397i = i;
    }

    /* renamed from: a */
    public int m27088a() {
        return this.f21397i;
    }

    /* renamed from: a */
    public static C6655i m27087a(int i) {
        C6655i c6655i = OFF;
        Iterator it = f21395j.iterator();
        while (it.hasNext()) {
            C6655i c6655i2 = (C6655i) it.next();
            if (c6655i2.m27088a() > i) {
                break;
            }
            c6655i = c6655i2;
        }
        return c6655i;
    }
}

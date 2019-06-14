package com.raizlabs.android.dbflow.p272b;

import java.util.Date;

/* compiled from: DateConverter */
/* renamed from: com.raizlabs.android.dbflow.b.c */
public class C7112c extends C5657e<Long, Date> {
    /* renamed from: b */
    public /* synthetic */ Object mo5041b(Object obj) {
        return m33122a((Date) obj);
    }

    /* renamed from: a */
    public Long m33122a(Date date) {
        return date == null ? null : Long.valueOf(date.getTime());
    }

    /* renamed from: a */
    public Date m33124a(Long l) {
        return l == null ? null : new Date(l.longValue());
    }
}

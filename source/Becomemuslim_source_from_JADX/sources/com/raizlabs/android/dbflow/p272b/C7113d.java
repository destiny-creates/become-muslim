package com.raizlabs.android.dbflow.p272b;

import java.sql.Date;

/* compiled from: SqlDateConverter */
/* renamed from: com.raizlabs.android.dbflow.b.d */
public class C7113d extends C5657e<Long, Date> {
    /* renamed from: b */
    public /* synthetic */ Object mo5041b(Object obj) {
        return m33126a((Date) obj);
    }

    /* renamed from: a */
    public Long m33126a(Date date) {
        return date == null ? null : Long.valueOf(date.getTime());
    }

    /* renamed from: a */
    public Date m33128a(Long l) {
        return l == null ? null : new Date(l.longValue());
    }
}

package com.raizlabs.android.dbflow.p272b;

import java.util.Calendar;

/* compiled from: CalendarConverter */
/* renamed from: com.raizlabs.android.dbflow.b.b */
public class C7111b extends C5657e<Long, Calendar> {
    /* renamed from: b */
    public /* synthetic */ Object mo5041b(Object obj) {
        return m33118a((Calendar) obj);
    }

    /* renamed from: a */
    public Long m33118a(Calendar calendar) {
        return calendar == null ? null : Long.valueOf(calendar.getTimeInMillis());
    }

    /* renamed from: a */
    public Calendar m33120a(Long l) {
        if (l == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(l.longValue());
        return instance;
    }
}

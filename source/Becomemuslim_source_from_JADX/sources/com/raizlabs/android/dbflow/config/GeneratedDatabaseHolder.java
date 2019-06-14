package com.raizlabs.android.dbflow.config;

import com.raizlabs.android.dbflow.p272b.C7110a;
import com.raizlabs.android.dbflow.p272b.C7111b;
import com.raizlabs.android.dbflow.p272b.C7112c;
import com.raizlabs.android.dbflow.p272b.C7113d;
import java.util.Calendar;
import java.util.Date;

public final class GeneratedDatabaseHolder extends C5676b {
    public GeneratedDatabaseHolder() {
        C7118c c7118c = new C7118c(this);
        C7119d c7119d = new C7119d(this);
    }

    static {
        c.put(Boolean.class, new C7110a());
        c.put(Calendar.class, new C7111b());
        c.put(Date.class, new C7112c());
        c.put(java.sql.Date.class, new C7113d());
    }
}

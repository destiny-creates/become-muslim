package com.raizlabs.android.dbflow.p276d.p277a;

import android.database.DatabaseUtils;
import com.raizlabs.android.dbflow.config.C5680f;
import com.raizlabs.android.dbflow.p272b.C5657e;
import com.raizlabs.android.dbflow.p276d.C7135b;
import com.raizlabs.android.dbflow.p276d.p278b.C7128b;
import com.raizlabs.android.dbflow.p276d.p278b.C8026i;
import com.raizlabs.android.dbflow.p281e.C5698h;
import com.raizlabs.android.dbflow.p281e.C8030i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ConditionQueryBuilder */
/* renamed from: com.raizlabs.android.dbflow.d.a.c */
public class C8024c<ModelClass extends C5698h> extends C7135b<C8024c<ModelClass>> {
    /* renamed from: b */
    private C8030i<ModelClass> f29793b;
    /* renamed from: c */
    private List<C5686d> f29794c = new ArrayList();
    /* renamed from: d */
    private boolean f29795d = false;
    /* renamed from: e */
    private boolean f29796e = false;
    /* renamed from: f */
    private String f29797f = "AND";
    /* renamed from: g */
    private String f29798g;

    /* renamed from: a */
    public String mo5061a() {
        if (this.f29795d || this.a.length() == 0) {
            int i = 0;
            this.f29795d = false;
            this.a = new StringBuilder();
            if (this.f29798g != null) {
                this.a.append(this.f29798g);
            }
            int size = this.f29794c.size();
            int i2 = 0;
            while (i < size) {
                C5686d c5686d = (C5686d) this.f29794c.get(i);
                m38889b(c5686d);
                if (i2 < size - 1) {
                    if (c5686d.mo5059d()) {
                        m33183a((Object) c5686d.mo5058c());
                    } else {
                        m33183a((Object) this.f29797f);
                    }
                }
                i2++;
                i++;
            }
        }
        return this.a.toString();
    }

    public C8024c(Class<ModelClass> cls, C5686d... c5686dArr) {
        this.f29793b = C5680f.m24089e(cls);
        m38887a(c5686dArr);
    }

    /* renamed from: c */
    public String m38890c(Object obj) {
        if (!(this.f29796e || obj == null)) {
            C5657e c = C5680f.m24087c(obj.getClass());
            if (c != null) {
                obj = c.mo5041b(obj);
            }
        }
        if (obj instanceof Number) {
            return String.valueOf(obj);
        }
        if (obj instanceof C8026i) {
            return String.format("(%1s)", new Object[]{((C8026i) obj).mo5061a().trim()});
        } else if (obj instanceof C7128b) {
            return ((C7128b) obj).mo5061a();
        } else {
            obj = String.valueOf(obj);
            return !obj.equals("?") ? DatabaseUtils.sqlEscapeString(obj) : obj;
        }
    }

    /* renamed from: a */
    public C8024c<ModelClass> m38887a(C5686d... c5686dArr) {
        if (c5686dArr.length > 0) {
            for (C5686d a : c5686dArr) {
                m38886a(a);
            }
            this.f29795d = 1;
        }
        return this;
    }

    /* renamed from: a */
    public C8024c<ModelClass> m38886a(C5686d c5686d) {
        this.f29794c.add(c5686d);
        this.f29795d = true;
        return this;
    }

    /* renamed from: d */
    public String m38891d() {
        C7135b c7135b = new C7135b();
        int size = this.f29794c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            C5686d c5686d = (C5686d) this.f29794c.get(i2);
            c5686d.mo6276a(c7135b);
            if (i < size - 1) {
                if (c5686d.mo5059d()) {
                    c7135b.m33183a(c5686d.mo5058c());
                } else {
                    c7135b.m33183a(this.f29797f);
                }
            }
            i++;
        }
        return c7135b.toString();
    }

    /* renamed from: b */
    C8024c<ModelClass> m38889b(C5686d c5686d) {
        c5686d.mo6275a(this);
        return this;
    }
}

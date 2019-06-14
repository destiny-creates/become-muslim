package com.raizlabs.android.dbflow.p273c;

import android.annotation.TargetApi;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import com.raizlabs.android.dbflow.p276d.C5690c;
import com.raizlabs.android.dbflow.p281e.C5698h;
import com.raizlabs.android.dbflow.p281e.C7139b.C5695a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: FlowContentObserver */
/* renamed from: com.raizlabs.android.dbflow.c.d */
public class C5672d extends ContentObserver {
    /* renamed from: b */
    private static final List<C5672d> f18942b = new ArrayList();
    /* renamed from: c */
    private static boolean f18943c = false;
    /* renamed from: a */
    protected boolean f18944a;
    /* renamed from: d */
    private final List<C5670a> f18945d;
    /* renamed from: e */
    private final List<C5671b> f18946e;
    /* renamed from: f */
    private final Map<String, Class<? extends C5698h>> f18947f;
    /* renamed from: g */
    private final Set<Uri> f18948g;
    /* renamed from: h */
    private boolean f18949h;

    /* compiled from: FlowContentObserver */
    /* renamed from: com.raizlabs.android.dbflow.c.d$a */
    public interface C5670a {
        /* renamed from: a */
        void m24041a(Class<? extends C5698h> cls, C5695a c5695a);
    }

    @TargetApi(16)
    /* compiled from: FlowContentObserver */
    /* renamed from: com.raizlabs.android.dbflow.c.d$b */
    public interface C5671b {
        /* renamed from: a */
        void m24042a(Class<? extends C5698h> cls, C5695a c5695a, String str, String str2);
    }

    /* renamed from: a */
    public static boolean m24043a() {
        if (!f18943c) {
            if (f18942b.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public void m24044b() {
        if (!this.f18944a) {
            this.f18944a = true;
        }
    }

    /* renamed from: c */
    public void m24045c() {
        if (this.f18944a) {
            this.f18944a = false;
            if (VERSION.SDK_INT < 16) {
                onChange(true);
                return;
            }
            synchronized (this.f18948g) {
                for (Uri onChange : this.f18948g) {
                    onChange(true, onChange);
                }
                this.f18948g.clear();
            }
        }
    }

    public void onChange(boolean z) {
        for (C5670a a : this.f18945d) {
            a.m24041a(null, C5695a.CHANGE);
        }
    }

    @TargetApi(16)
    public void onChange(boolean z, Uri uri) {
        String decode;
        Class cls;
        z = uri.getFragment();
        String authority = uri.getAuthority();
        Set queryParameterNames = uri.getQueryParameterNames();
        String str = null;
        if (!queryParameterNames.isEmpty()) {
            Iterator it = queryParameterNames.iterator();
            if (it.hasNext()) {
                str = (String) it.next();
                decode = Uri.decode(uri.getQueryParameter(str));
                cls = (Class) this.f18947f.get(authority);
                if (this.f18944a) {
                    z = C5695a.valueOf(z);
                    if (z) {
                        for (C5670a a : this.f18945d) {
                            a.m24041a(cls, z);
                        }
                        if (str != null && decode != null) {
                            for (C5671b a2 : this.f18946e) {
                                a2.m24042a(cls, z, str, decode);
                            }
                            return;
                        }
                    }
                }
                if (!this.f18949h) {
                    uri = C5690c.m24117a(cls, C5695a.CHANGE);
                }
                synchronized (this.f18948g) {
                    this.f18948g.add(uri);
                }
                return;
            }
        }
        decode = null;
        cls = (Class) this.f18947f.get(authority);
        if (this.f18944a) {
            if (this.f18949h) {
                uri = C5690c.m24117a(cls, C5695a.CHANGE);
            }
            synchronized (this.f18948g) {
                this.f18948g.add(uri);
            }
            return;
        }
        z = C5695a.valueOf(z);
        if (z) {
            while (uri.hasNext()) {
                a.m24041a(cls, z);
            }
            if (str != null) {
            }
        }
    }
}

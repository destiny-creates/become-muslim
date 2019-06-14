package com.p064b.p065a.p068c;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p357f.C6489a;
import java.io.File;
import java.util.Set;

/* compiled from: LogFileManager */
/* renamed from: com.b.a.c.t */
class C1062t {
    /* renamed from: a */
    private static final C3427a f2955a = new C3427a();
    /* renamed from: b */
    private final Context f2956b;
    /* renamed from: c */
    private final C6489a f2957c;
    /* renamed from: d */
    private C1060s f2958d;

    /* compiled from: LogFileManager */
    /* renamed from: com.b.a.c.t$a */
    private static final class C3427a implements C1060s {
        /* renamed from: a */
        public C1017b mo754a() {
            return null;
        }

        /* renamed from: b */
        public void mo755b() {
        }

        /* renamed from: c */
        public void mo756c() {
        }

        private C3427a() {
        }
    }

    public C1062t(Context context, C6489a c6489a) {
        this(context, c6489a, null);
    }

    public C1062t(Context context, C6489a c6489a, String str) {
        this.f2956b = context;
        this.f2957c = c6489a;
        this.f2958d = f2955a;
        m3659a(str);
    }

    /* renamed from: a */
    public final void m3659a(String str) {
        this.f2958d.mo755b();
        this.f2958d = f2955a;
        if (str != null) {
            if (m3655c()) {
                m3658a(m3654b(str), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            } else {
                C6514c.h().a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            }
        }
    }

    /* renamed from: a */
    public C1017b m3657a() {
        return this.f2958d.mo754a();
    }

    /* renamed from: b */
    public void m3661b() {
        this.f2958d.mo756c();
    }

    /* renamed from: a */
    public void m3660a(Set<String> set) {
        File[] listFiles = m3656d().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(m3653a(file))) {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: a */
    void m3658a(File file, int i) {
        this.f2958d = new C3442y(file, i);
    }

    /* renamed from: b */
    private File m3654b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("crashlytics-userlog-");
        stringBuilder.append(str);
        stringBuilder.append(".temp");
        return new File(m3656d(), stringBuilder.toString());
    }

    /* renamed from: a */
    private String m3653a(File file) {
        file = file.getName();
        int lastIndexOf = file.lastIndexOf(".temp");
        if (lastIndexOf == -1) {
            return file;
        }
        return file.substring("crashlytics-userlog-".length(), lastIndexOf);
    }

    /* renamed from: c */
    private boolean m3655c() {
        return C6428i.a(this.f2956b, "com.crashlytics.CollectCustomLogs", true);
    }

    /* renamed from: d */
    private File m3656d() {
        File file = new File(this.f2957c.a(), "log-files");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}

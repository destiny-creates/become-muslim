package com.p064b.p065a.p068c;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.AppMeasurement;
import com.p064b.p065a.p068c.C1052l;
import com.p064b.p065a.p068c.C1063v;
import com.p064b.p065a.p068c.p069a.p070a.C1010d;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6431l;
import io.p347a.p348a.p349a.p350a.p352b.C6436o;
import io.p347a.p348a.p349a.p350a.p357f.C6489a;
import io.p347a.p348a.p349a.p350a.p358g.C6500p;
import io.p347a.p348a.p349a.p350a.p358g.C6504q;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: CrashlyticsUncaughtExceptionHandler */
/* renamed from: com.b.a.c.l */
class C1052l implements UncaughtExceptionHandler {
    /* renamed from: a */
    static final FilenameFilter f2924a = new C10391();
    /* renamed from: b */
    static final Comparator<File> f2925b = new C10446();
    /* renamed from: c */
    static final Comparator<File> f2926c = new C10457();
    /* renamed from: d */
    static final FilenameFilter f2927d = new C10468();
    /* renamed from: e */
    private static final Pattern f2928e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    /* renamed from: f */
    private static final Map<String, String> f2929f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    /* renamed from: g */
    private static final String[] f2930g = new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    /* renamed from: h */
    private final AtomicInteger f2931h = new AtomicInteger(0);
    /* renamed from: i */
    private final UncaughtExceptionHandler f2932i;
    /* renamed from: j */
    private final C6489a f2933j;
    /* renamed from: k */
    private final AtomicBoolean f2934k;
    /* renamed from: l */
    private final C1035g f2935l;
    /* renamed from: m */
    private final C6436o f2936m;
    /* renamed from: n */
    private final C3424f f2937n;
    /* renamed from: o */
    private final C1062t f2938o;
    /* renamed from: p */
    private final C1057p f2939p;
    /* renamed from: q */
    private final String f2940q;

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    /* renamed from: com.b.a.c.l$1 */
    static class C10391 implements FilenameFilter {
        C10391() {
        }

        public boolean accept(File file, String str) {
            return (str.length() != ".cls".length() + 35 || str.endsWith(".cls") == null) ? null : true;
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    /* renamed from: com.b.a.c.l$2 */
    class C10402 implements Callable<Void> {
        /* renamed from: a */
        final /* synthetic */ C1052l f2911a;

        C10402(C1052l c1052l) {
            this.f2911a = c1052l;
        }

        public /* synthetic */ Object call() {
            return m3571a();
        }

        /* renamed from: a */
        public Void m3571a() {
            this.f2911a.m3618l();
            return null;
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    /* renamed from: com.b.a.c.l$3 */
    class C10413 implements Callable<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C1052l f2912a;

        C10413(C1052l c1052l) {
            this.f2912a = c1052l;
        }

        public /* synthetic */ Object call() {
            return m3572a();
        }

        /* renamed from: a */
        public Boolean m3572a() {
            if (this.f2912a.f2934k.get()) {
                C6514c.h().a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                return Boolean.FALSE;
            }
            C6514c.h().a("CrashlyticsCore", "Finalizing previously open sessions.");
            C1010d v = this.f2912a.f2937n.m10973v();
            if (v != null) {
                this.f2912a.m3579a(v);
            }
            this.f2912a.m3595a(true);
            C6514c.h().a("CrashlyticsCore", "Closed all previously open sessions");
            return Boolean.TRUE;
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    /* renamed from: com.b.a.c.l$4 */
    class C10424 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1052l f2913a;

        C10424(C1052l c1052l) {
            this.f2913a = c1052l;
        }

        public void run() {
            this.f2913a.m3626a(this.f2913a.m3598a(C1020d.f2871a));
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    /* renamed from: com.b.a.c.l$6 */
    static class C10446 implements Comparator<File> {
        C10446() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3573a((File) obj, (File) obj2);
        }

        /* renamed from: a */
        public int m3573a(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    /* renamed from: com.b.a.c.l$7 */
    static class C10457 implements Comparator<File> {
        C10457() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3574a((File) obj, (File) obj2);
        }

        /* renamed from: a */
        public int m3574a(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    /* renamed from: com.b.a.c.l$8 */
    static class C10468 implements FilenameFilter {
        C10468() {
        }

        public boolean accept(File file, String str) {
            return C1052l.f2928e.matcher(str).matches();
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    /* renamed from: com.b.a.c.l$a */
    private static class C1048a implements FilenameFilter {
        private C1048a() {
        }

        public boolean accept(File file, String str) {
            return (C1052l.f2924a.accept(file, str) != null || C1052l.f2928e.matcher(str).matches() == null) ? null : true;
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    /* renamed from: com.b.a.c.l$b */
    static class C1049b implements FilenameFilter {
        /* renamed from: a */
        private final String f2920a;

        public C1049b(String str) {
            this.f2920a = str;
        }

        public boolean accept(File file, String str) {
            return (str.contains(this.f2920a) == null || str.endsWith(".cls_temp") != null) ? null : true;
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    /* renamed from: com.b.a.c.l$c */
    private static final class C1050c implements Runnable {
        /* renamed from: a */
        private final C3424f f2921a;
        /* renamed from: b */
        private final File f2922b;

        public C1050c(C3424f c3424f, File file) {
            this.f2921a = c3424f;
            this.f2922b = file;
        }

        public void run() {
            if (C6428i.n(this.f2921a.E())) {
                C6514c.h().a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                C1054n a = this.f2921a.m10949a(C6504q.a().b());
                if (a != null) {
                    new aa(a).m3458a(new ac(this.f2922b, C1052l.f2929f));
                }
            }
        }
    }

    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    /* renamed from: com.b.a.c.l$d */
    static class C1051d implements FilenameFilter {
        /* renamed from: a */
        private final String f2923a;

        public C1051d(String str) {
            this.f2923a = str;
        }

        public boolean accept(File file, String str) {
            file = new StringBuilder();
            file.append(this.f2923a);
            file.append(".cls");
            boolean z = false;
            if (str.equals(file.toString()) != null) {
                return false;
            }
            if (str.contains(this.f2923a) != null && str.endsWith(".cls_temp") == null) {
                z = true;
            }
            return z;
        }
    }

    C1052l(UncaughtExceptionHandler uncaughtExceptionHandler, C1035g c1035g, C6436o c6436o, ad adVar, C6489a c6489a, C3424f c3424f) {
        this.f2932i = uncaughtExceptionHandler;
        this.f2935l = c1035g;
        this.f2936m = c6436o;
        this.f2937n = c3424f;
        this.f2940q = adVar.mo757a();
        this.f2933j = c6489a;
        this.f2934k = new AtomicBoolean(false);
        uncaughtExceptionHandler = c3424f.E();
        this.f2938o = new C1062t(uncaughtExceptionHandler, c6489a);
        this.f2939p = new C1057p(uncaughtExceptionHandler);
    }

    public synchronized void uncaughtException(final Thread thread, final Throwable th) {
        this.f2934k.set(true);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Crashlytics is handling uncaught exception \"");
            stringBuilder.append(th);
            stringBuilder.append("\" from thread ");
            stringBuilder.append(thread.getName());
            C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
            this.f2939p.m3637b();
            final Date date = new Date();
            this.f2935l.m3561a(new Callable<Void>(this) {
                /* renamed from: d */
                final /* synthetic */ C1052l f2919d;

                public /* synthetic */ Object call() {
                    return m3575a();
                }

                /* renamed from: a */
                public Void m3575a() {
                    this.f2919d.m3594a(date, thread, th);
                    return null;
                }
            });
            C6514c.h().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f2932i.uncaughtException(thread, th);
            thread = this.f2934k;
        } catch (Throwable e) {
            try {
                C6514c.h().e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
                C6514c.h().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
                this.f2932i.uncaughtException(thread, th);
                thread = this.f2934k;
            } catch (Throwable th2) {
                C6514c.h().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
                this.f2932i.uncaughtException(thread, th);
                this.f2934k.set(false);
            }
        }
        thread.set(false);
    }

    /* renamed from: a */
    private void m3594a(Date date, Thread thread, Throwable th) {
        this.f2937n.m10947A();
        m3602b(date, thread, th);
        m3630d();
        m3618l();
        m3632f();
        if (this.f2937n.m10975x() == null) {
            m3622p();
        }
    }

    /* renamed from: a */
    boolean m3627a() {
        return this.f2934k.get();
    }

    /* renamed from: a */
    void m3624a(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.f2935l.m3562a(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ C1052l f2908d;

            public void run() {
                if (!this.f2908d.f2934k.get()) {
                    this.f2908d.m3607c(date, thread, th);
                }
            }
        });
    }

    /* renamed from: a */
    void m3625a(final Map<String, String> map) {
        this.f2935l.m3563b(new Callable<Void>(this) {
            /* renamed from: b */
            final /* synthetic */ C1052l f2910b;

            public /* synthetic */ Object call() {
                return m3570a();
            }

            /* renamed from: a */
            public Void m3570a() {
                new C1063v(this.f2910b.m3623q()).m3669a(this.f2910b.m3616j(), map);
                return null;
            }
        });
    }

    /* renamed from: b */
    void m3628b() {
        this.f2935l.m3563b(new C10402(this));
    }

    /* renamed from: j */
    private String m3616j() {
        File[] n = m3620n();
        return n.length > 0 ? m3576a(n[0]) : null;
    }

    /* renamed from: k */
    private String m3617k() {
        File[] n = m3620n();
        return n.length > 1 ? m3576a(n[1]) : null;
    }

    /* renamed from: a */
    private String m3576a(File file) {
        return file.getName().substring(0, 35);
    }

    /* renamed from: c */
    boolean m3629c() {
        return ((Boolean) this.f2935l.m3561a(new C10413(this))).booleanValue();
    }

    /* renamed from: l */
    private void m3618l() {
        Date date = new Date();
        String c1018c = new C1018c(this.f2936m).toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Opening an new session with ID ");
        stringBuilder.append(c1018c);
        C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
        m3593a(c1018c, date);
        m3606c(c1018c);
        m3609d(c1018c);
        m3611e(c1018c);
        this.f2938o.m3659a(c1018c);
    }

    /* renamed from: d */
    void m3630d() {
        m3595a(false);
    }

    /* renamed from: a */
    private void m3595a(boolean z) {
        m3578a(z + 8);
        File[] n = m3620n();
        if (n.length <= z) {
            C6514c.h().a("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        m3612f(m3576a(n[z]));
        C3424f c3424f = this.f2937n;
        C6500p B = C3424f.m10931B();
        if (B == null) {
            C6514c.h().a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
        } else {
            m3596a(n, (int) z, B.f20953c);
        }
    }

    /* renamed from: a */
    private void m3596a(File[] fileArr, int i, int i2) {
        C6514c.h().a("CrashlyticsCore", "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String a = m3576a(file);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Closing session: ");
            stringBuilder.append(a);
            C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
            m3588a(file, a, i2);
            i++;
        }
    }

    /* renamed from: a */
    private void m3580a(C1020d c1020d) {
        if (c1020d != null) {
            try {
                c1020d.m3504a();
            } catch (C1020d c1020d2) {
                C6514c.h().e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", c1020d2);
            }
        }
    }

    /* renamed from: a */
    private void m3591a(String str) {
        for (File delete : m3603b(str)) {
            delete.delete();
        }
    }

    /* renamed from: b */
    private File[] m3603b(String str) {
        return m3598a(new C1051d(str));
    }

    /* renamed from: m */
    private File[] m3619m() {
        return m3598a(f2924a);
    }

    /* renamed from: e */
    File[] m3631e() {
        return m3598a(new C1049b("BeginSession"));
    }

    /* renamed from: n */
    private File[] m3620n() {
        File[] e = m3631e();
        Arrays.sort(e, f2925b);
        return e;
    }

    /* renamed from: a */
    private File[] m3598a(FilenameFilter filenameFilter) {
        return m3604b(m3623q().listFiles(filenameFilter));
    }

    /* renamed from: b */
    private File[] m3604b(File[] fileArr) {
        return fileArr == null ? new File[null] : fileArr;
    }

    /* renamed from: a */
    private void m3592a(String str, int i) {
        File q = m3623q();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("SessionEvent");
        af.m3492a(q, new C1049b(stringBuilder.toString()), i, f2926c);
    }

    /* renamed from: f */
    void m3632f() {
        af.m3492a(m3623q(), f2924a, 4, f2926c);
    }

    /* renamed from: a */
    private void m3578a(int i) {
        Set hashSet = new HashSet();
        File[] n = m3620n();
        i = Math.min(i, n.length);
        for (int i2 = 0; i2 < i; i2++) {
            hashSet.add(m3576a(n[i2]));
        }
        this.f2938o.m3660a(hashSet);
        for (File file : m3598a(new C1048a())) {
            Object name = file.getName();
            Matcher matcher = f2928e.matcher(name);
            matcher.matches();
            if (!hashSet.contains(matcher.group(1))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Trimming open session file: ");
                stringBuilder.append(name);
                C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
                file.delete();
            }
        }
    }

    /* renamed from: a */
    private File[] m3599a(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        C6514c.h().a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
        m3592a(str, i);
        i = new StringBuilder();
        i.append(str);
        i.append("SessionEvent");
        return m3598a(new C1049b(i.toString()));
    }

    /* renamed from: g */
    void m3633g() {
        this.f2935l.m3562a(new C10424(this));
    }

    /* renamed from: a */
    void m3626a(File[] fileArr) {
        m3621o();
        for (File file : fileArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Found invalid session part file: ");
            stringBuilder.append(file);
            C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
            final String a = m3576a(file);
            FilenameFilter c10435 = new FilenameFilter(this) {
                /* renamed from: b */
                final /* synthetic */ C1052l f2915b;

                public boolean accept(File file, String str) {
                    return str.startsWith(a);
                }
            };
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Deleting all part files for invalid session: ");
            stringBuilder2.append(a);
            C6514c.h().a("CrashlyticsCore", stringBuilder2.toString());
            for (File file2 : m3598a(c10435)) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Deleting session file: ");
                stringBuilder3.append(file2);
                C6514c.h().a("CrashlyticsCore", stringBuilder3.toString());
                file2.delete();
            }
        }
    }

    /* renamed from: o */
    private void m3621o() {
        File file = new File(this.f2937n.m10974w(), "invalidClsFiles");
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
            file.delete();
        }
    }

    /* renamed from: b */
    private void m3602b(Date date, Thread thread, Throwable th) {
        Closeable c1020d;
        Flushable a;
        Throwable e;
        OutputStream outputStream;
        Flushable flushable = null;
        try {
            String j = m3616j();
            if (j == null) {
                C6514c.h().e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
                C6428i.a(null, "Failed to flush to session begin file.");
                C6428i.a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            C3424f.m10942b(j);
            File q = m3623q();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("SessionCrash");
            c1020d = new C1020d(q, stringBuilder.toString());
            try {
                a = C1022e.m3505a((OutputStream) c1020d);
                try {
                    m3583a(a, date, thread, th, AppMeasurement.CRASH_ORIGIN, true);
                    C6428i.a(a, "Failed to flush to session begin file.");
                    C6428i.a(c1020d, "Failed to close fatal exception file output stream.");
                } catch (Exception e2) {
                    e = e2;
                    outputStream = c1020d;
                    try {
                        C6514c.h().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                        C1059r.m3647a(e, outputStream);
                        C6428i.a(a, "Failed to flush to session begin file.");
                        C6428i.a(outputStream, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th2) {
                        date = th2;
                        c1020d = outputStream;
                        flushable = a;
                        C6428i.a(flushable, "Failed to flush to session begin file.");
                        C6428i.a(c1020d, "Failed to close fatal exception file output stream.");
                        throw date;
                    }
                } catch (Throwable th3) {
                    date = th3;
                    flushable = a;
                    C6428i.a(flushable, "Failed to flush to session begin file.");
                    C6428i.a(c1020d, "Failed to close fatal exception file output stream.");
                    throw date;
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
                outputStream = c1020d;
                C6514c.h().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                C1059r.m3647a(e, outputStream);
                C6428i.a(a, "Failed to flush to session begin file.");
                C6428i.a(outputStream, "Failed to close fatal exception file output stream.");
            } catch (Throwable th4) {
                date = th4;
                C6428i.a(flushable, "Failed to flush to session begin file.");
                C6428i.a(c1020d, "Failed to close fatal exception file output stream.");
                throw date;
            }
        } catch (Exception e4) {
            e = e4;
            a = null;
            C6514c.h().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            C1059r.m3647a(e, outputStream);
            C6428i.a(a, "Failed to flush to session begin file.");
            C6428i.a(outputStream, "Failed to close fatal exception file output stream.");
        } catch (Throwable th5) {
            date = th5;
            c1020d = null;
            C6428i.a(flushable, "Failed to flush to session begin file.");
            C6428i.a(c1020d, "Failed to close fatal exception file output stream.");
            throw date;
        }
    }

    /* renamed from: a */
    private void m3579a(C1010d c1010d) {
        Throwable e;
        OutputStream outputStream;
        Flushable flushable = null;
        Closeable c1020d;
        Flushable a;
        try {
            String k = m3617k();
            if (k == null) {
                C6514c.h().e("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
                C6428i.a(null, "Failed to flush to session begin file.");
                C6428i.a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            C3424f.m10942b(k);
            File q = m3623q();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(k);
            stringBuilder.append("SessionCrash");
            c1020d = new C1020d(q, stringBuilder.toString());
            try {
                a = C1022e.m3505a((OutputStream) c1020d);
                try {
                    C1065w.m3682a(c1010d, new C1062t(this.f2937n.E(), this.f2933j, k), new C1063v(m3623q()).m3670b(k), a);
                    C6428i.a(a, "Failed to flush to session begin file.");
                    C6428i.a(c1020d, "Failed to close fatal exception file output stream.");
                } catch (Exception e2) {
                    e = e2;
                    outputStream = c1020d;
                    try {
                        C6514c.h().e("CrashlyticsCore", "An error occurred in the native crash logger", e);
                        C1059r.m3647a(e, outputStream);
                        C6428i.a(a, "Failed to flush to session begin file.");
                        C6428i.a(outputStream, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th) {
                        c1010d = th;
                        c1020d = outputStream;
                        flushable = a;
                        C6428i.a(flushable, "Failed to flush to session begin file.");
                        C6428i.a(c1020d, "Failed to close fatal exception file output stream.");
                        throw c1010d;
                    }
                } catch (Throwable th2) {
                    c1010d = th2;
                    flushable = a;
                    C6428i.a(flushable, "Failed to flush to session begin file.");
                    C6428i.a(c1020d, "Failed to close fatal exception file output stream.");
                    throw c1010d;
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
                outputStream = c1020d;
                C6514c.h().e("CrashlyticsCore", "An error occurred in the native crash logger", e);
                C1059r.m3647a(e, outputStream);
                C6428i.a(a, "Failed to flush to session begin file.");
                C6428i.a(outputStream, "Failed to close fatal exception file output stream.");
            } catch (Throwable th3) {
                c1010d = th3;
                C6428i.a(flushable, "Failed to flush to session begin file.");
                C6428i.a(c1020d, "Failed to close fatal exception file output stream.");
                throw c1010d;
            }
        } catch (Exception e4) {
            e = e4;
            a = null;
            C6514c.h().e("CrashlyticsCore", "An error occurred in the native crash logger", e);
            C1059r.m3647a(e, outputStream);
            C6428i.a(a, "Failed to flush to session begin file.");
            C6428i.a(outputStream, "Failed to close fatal exception file output stream.");
        } catch (Throwable th4) {
            c1010d = th4;
            c1020d = null;
            C6428i.a(flushable, "Failed to flush to session begin file.");
            C6428i.a(c1020d, "Failed to close fatal exception file output stream.");
            throw c1010d;
        }
    }

    /* renamed from: c */
    private void m3607c(Date date, Thread thread, Throwable th) {
        Closeable c1020d;
        Flushable a;
        Throwable e;
        OutputStream outputStream;
        String j = m3616j();
        Flushable flushable = null;
        if (j == null) {
            C6514c.h().e("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        C3424f.m10938a(j);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Crashlytics is logging non-fatal exception \"");
            stringBuilder.append(th);
            stringBuilder.append("\" from thread ");
            stringBuilder.append(thread.getName());
            C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
            String a2 = C6428i.a(this.f2931h.getAndIncrement());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(j);
            stringBuilder2.append("SessionEvent");
            stringBuilder2.append(a2);
            c1020d = new C1020d(m3623q(), stringBuilder2.toString());
            try {
                a = C1022e.m3505a((OutputStream) c1020d);
                try {
                    m3583a(a, date, thread, th, "error", false);
                    C6428i.a(a, "Failed to flush to non-fatal file.");
                    C6428i.a(c1020d, "Failed to close non-fatal file output stream.");
                } catch (Exception e2) {
                    e = e2;
                    outputStream = c1020d;
                    try {
                        C6514c.h().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                        C1059r.m3647a(e, outputStream);
                        C6428i.a(a, "Failed to flush to non-fatal file.");
                        C6428i.a(outputStream, "Failed to close non-fatal file output stream.");
                        m3592a(j, 64);
                    } catch (Throwable th2) {
                        date = th2;
                        c1020d = outputStream;
                        flushable = a;
                        C6428i.a(flushable, "Failed to flush to non-fatal file.");
                        C6428i.a(c1020d, "Failed to close non-fatal file output stream.");
                        throw date;
                    }
                } catch (Throwable th3) {
                    date = th3;
                    flushable = a;
                    C6428i.a(flushable, "Failed to flush to non-fatal file.");
                    C6428i.a(c1020d, "Failed to close non-fatal file output stream.");
                    throw date;
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
                outputStream = c1020d;
                C6514c.h().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                C1059r.m3647a(e, outputStream);
                C6428i.a(a, "Failed to flush to non-fatal file.");
                C6428i.a(outputStream, "Failed to close non-fatal file output stream.");
                m3592a(j, 64);
            } catch (Throwable th4) {
                date = th4;
                C6428i.a(flushable, "Failed to flush to non-fatal file.");
                C6428i.a(c1020d, "Failed to close non-fatal file output stream.");
                throw date;
            }
        } catch (Exception e4) {
            e = e4;
            a = null;
            C6514c.h().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
            C1059r.m3647a(e, outputStream);
            C6428i.a(a, "Failed to flush to non-fatal file.");
            C6428i.a(outputStream, "Failed to close non-fatal file output stream.");
            m3592a(j, 64);
        } catch (Throwable th5) {
            date = th5;
            c1020d = null;
            C6428i.a(flushable, "Failed to flush to non-fatal file.");
            C6428i.a(c1020d, "Failed to close non-fatal file output stream.");
            throw date;
        }
        try {
            m3592a(j, 64);
        } catch (Date date2) {
            C6514c.h().e("CrashlyticsCore", "An error occurred when trimming non-fatal files.", date2);
        }
    }

    /* renamed from: a */
    private void m3593a(String str, Date date) {
        Flushable a;
        Throwable e;
        Closeable closeable = null;
        try {
            File q = m3623q();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("BeginSession");
            OutputStream c1020d = new C1020d(q, stringBuilder.toString());
            try {
                a = C1022e.m3505a(c1020d);
                try {
                    ab.m3480a((C1022e) a, str, String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.f2937n.m10950a()}), date.getTime() / 1000);
                    C6428i.a(a, "Failed to flush to session begin file.");
                    C6428i.a(c1020d, "Failed to close begin session file.");
                } catch (Exception e2) {
                    e = e2;
                    closeable = c1020d;
                    try {
                        C1059r.m3647a(e, (OutputStream) closeable);
                        throw e;
                    } catch (Throwable th) {
                        str = th;
                        C6428i.a(a, "Failed to flush to session begin file.");
                        C6428i.a(closeable, "Failed to close begin session file.");
                        throw str;
                    }
                } catch (Throwable th2) {
                    str = th2;
                    closeable = c1020d;
                    C6428i.a(a, "Failed to flush to session begin file.");
                    C6428i.a(closeable, "Failed to close begin session file.");
                    throw str;
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
                closeable = c1020d;
                C1059r.m3647a(e, (OutputStream) closeable);
                throw e;
            } catch (Throwable th3) {
                str = th3;
                a = null;
                closeable = c1020d;
                C6428i.a(a, "Failed to flush to session begin file.");
                C6428i.a(closeable, "Failed to close begin session file.");
                throw str;
            }
        } catch (Exception e4) {
            e = e4;
            a = null;
            C1059r.m3647a(e, (OutputStream) closeable);
            throw e;
        } catch (Throwable th4) {
            str = th4;
            a = null;
            C6428i.a(a, "Failed to flush to session begin file.");
            C6428i.a(closeable, "Failed to close begin session file.");
            throw str;
        }
    }

    /* renamed from: c */
    private void m3606c(String str) {
        Throwable e;
        Closeable c1020d;
        try {
            File q = m3623q();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("SessionApp");
            c1020d = new C1020d(q, stringBuilder.toString());
            try {
                str = C1022e.m3505a((OutputStream) c1020d);
                try {
                    ab.m3482a((C1022e) str, this.f2936m.c(), this.f2937n.m10960i(), this.f2937n.m10963l(), this.f2937n.m10962k(), this.f2936m.b(), C6431l.a(this.f2937n.m10961j()).a(), this.f2940q);
                    C6428i.a(str, "Failed to flush to session app file.");
                    C6428i.a(c1020d, "Failed to close session app file.");
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C1059r.m3647a(e, (OutputStream) c1020d);
                        throw e;
                    } catch (Throwable th) {
                        e = th;
                        C6428i.a(str, "Failed to flush to session app file.");
                        C6428i.a(c1020d, "Failed to close session app file.");
                        throw e;
                    }
                }
            } catch (String str2) {
                e = str2;
                str2 = null;
                C1059r.m3647a(e, (OutputStream) c1020d);
                throw e;
            } catch (String str22) {
                e = str22;
                str22 = null;
                C6428i.a(str22, "Failed to flush to session app file.");
                C6428i.a(c1020d, "Failed to close session app file.");
                throw e;
            }
        } catch (String str222) {
            c1020d = null;
            e = str222;
            str222 = c1020d;
            C1059r.m3647a(e, (OutputStream) c1020d);
            throw e;
        } catch (String str2222) {
            c1020d = null;
            e = str2222;
            str2222 = c1020d;
            C6428i.a(str2222, "Failed to flush to session app file.");
            C6428i.a(c1020d, "Failed to close session app file.");
            throw e;
        }
    }

    /* renamed from: d */
    private void m3609d(String str) {
        Closeable c1020d;
        OutputStream outputStream;
        C1022e c1022e;
        Throwable th;
        OutputStream outputStream2;
        Flushable flushable = null;
        try {
            File q = m3623q();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("SessionOS");
            c1020d = new C1020d(q, stringBuilder.toString());
            try {
                C1022e a = C1022e.m3505a((OutputStream) c1020d);
                try {
                    ab.m3488a(a, C6428i.g(this.f2937n.E()));
                    C6428i.a(a, "Failed to flush to session OS file.");
                    C6428i.a(c1020d, "Failed to close session OS file.");
                } catch (Throwable e) {
                    outputStream = c1020d;
                    c1022e = a;
                    th = e;
                    outputStream2 = outputStream;
                    try {
                        C1059r.m3647a(th, outputStream2);
                        throw th;
                    } catch (Throwable th2) {
                        str = th2;
                        C1022e c1022e2 = c1022e;
                        c1020d = outputStream2;
                        flushable = c1022e2;
                        C6428i.a(flushable, "Failed to flush to session OS file.");
                        C6428i.a(c1020d, "Failed to close session OS file.");
                        throw str;
                    }
                } catch (Throwable e2) {
                    Throwable th3 = e2;
                    flushable = a;
                    str = th3;
                    C6428i.a(flushable, "Failed to flush to session OS file.");
                    C6428i.a(c1020d, "Failed to close session OS file.");
                    throw str;
                }
            } catch (Exception e3) {
                th = e3;
                outputStream = c1020d;
                c1022e = null;
                outputStream2 = outputStream;
                C1059r.m3647a(th, outputStream2);
                throw th;
            } catch (Throwable th4) {
                str = th4;
                C6428i.a(flushable, "Failed to flush to session OS file.");
                C6428i.a(c1020d, "Failed to close session OS file.");
                throw str;
            }
        } catch (Exception e4) {
            th = e4;
            c1022e = null;
            C1059r.m3647a(th, outputStream2);
            throw th;
        } catch (Throwable th5) {
            str = th5;
            c1020d = null;
            C6428i.a(flushable, "Failed to flush to session OS file.");
            C6428i.a(c1020d, "Failed to close session OS file.");
            throw str;
        }
    }

    /* renamed from: e */
    private void m3611e(String str) {
        Closeable c1020d;
        Flushable a;
        Throwable e;
        C1052l c1052l = this;
        OutputStream outputStream = null;
        try {
            File q = m3623q();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("SessionDevice");
            c1020d = new C1020d(q, stringBuilder.toString());
            try {
                a = C1022e.m3505a((OutputStream) c1020d);
            } catch (Exception e2) {
                e = e2;
                a = null;
                outputStream = c1020d;
                try {
                    C1059r.m3647a(e, outputStream);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    c1020d = outputStream;
                    C6428i.a(a, "Failed to flush session device info.");
                    C6428i.a(c1020d, "Failed to close session device file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                a = null;
                C6428i.a(a, "Failed to flush session device info.");
                C6428i.a(c1020d, "Failed to close session device file.");
                throw e;
            }
            try {
                Context E = c1052l.f2937n.E();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                C1022e c1022e = a;
                ab.m3479a(c1022e, c1052l.f2936m.h(), C6428i.a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), C6428i.b(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), C6428i.f(E), c1052l.f2936m.i(), C6428i.h(E), Build.MANUFACTURER, Build.PRODUCT);
                C6428i.a(a, "Failed to flush session device info.");
                C6428i.a(c1020d, "Failed to close session device file.");
            } catch (Exception e3) {
                e = e3;
                outputStream = c1020d;
                C1059r.m3647a(e, outputStream);
                throw e;
            } catch (Throwable th3) {
                e = th3;
                C6428i.a(a, "Failed to flush session device info.");
                C6428i.a(c1020d, "Failed to close session device file.");
                throw e;
            }
        } catch (Exception e4) {
            e = e4;
            a = null;
            C1059r.m3647a(e, outputStream);
            throw e;
        } catch (Throwable th4) {
            e = th4;
            c1020d = null;
            a = c1020d;
            C6428i.a(a, "Failed to flush session device info.");
            C6428i.a(c1020d, "Failed to close session device file.");
            throw e;
        }
    }

    /* renamed from: f */
    private void m3612f(String str) {
        Throwable e;
        OutputStream outputStream;
        Flushable flushable = null;
        Closeable c1020d;
        Flushable a;
        try {
            File q = m3623q();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("SessionUser");
            c1020d = new C1020d(q, stringBuilder.toString());
            try {
                a = C1022e.m3505a((OutputStream) c1020d);
                try {
                    str = m3613g(str);
                    if (str.m3491a()) {
                        C6428i.a(a, "Failed to flush session user file.");
                        C6428i.a(c1020d, "Failed to close session user file.");
                        return;
                    }
                    ab.m3481a((C1022e) a, str.f2859b, str.f2860c, str.f2861d);
                    C6428i.a(a, "Failed to flush session user file.");
                    C6428i.a(c1020d, "Failed to close session user file.");
                } catch (Exception e2) {
                    e = e2;
                    outputStream = c1020d;
                    try {
                        C1059r.m3647a(e, outputStream);
                        throw e;
                    } catch (Throwable th) {
                        str = th;
                        c1020d = outputStream;
                        flushable = a;
                        C6428i.a(flushable, "Failed to flush session user file.");
                        C6428i.a(c1020d, "Failed to close session user file.");
                        throw str;
                    }
                } catch (Throwable th2) {
                    str = th2;
                    flushable = a;
                    C6428i.a(flushable, "Failed to flush session user file.");
                    C6428i.a(c1020d, "Failed to close session user file.");
                    throw str;
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
                outputStream = c1020d;
                C1059r.m3647a(e, outputStream);
                throw e;
            } catch (Throwable th3) {
                str = th3;
                C6428i.a(flushable, "Failed to flush session user file.");
                C6428i.a(c1020d, "Failed to close session user file.");
                throw str;
            }
        } catch (Exception e4) {
            e = e4;
            a = null;
            C1059r.m3647a(e, outputStream);
            throw e;
        } catch (Throwable th4) {
            str = th4;
            c1020d = null;
            C6428i.a(flushable, "Failed to flush session user file.");
            C6428i.a(c1020d, "Failed to close session user file.");
            throw str;
        }
    }

    /* renamed from: a */
    private void m3583a(C1022e c1022e, Date date, Thread thread, Throwable th, String str, boolean z) {
        Thread[] threadArr;
        TreeMap g;
        Map treeMap;
        Context E = this.f2937n.E();
        long time = date.getTime() / 1000;
        float c = C6428i.c(E);
        int a = C6428i.a(E, this.f2939p.m3636a());
        boolean d = C6428i.d(E);
        int i = E.getResources().getConfiguration().orientation;
        long b = C6428i.b() - C6428i.b(E);
        long b2 = C6428i.b(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a2 = C6428i.a(E.getPackageName(), E);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTrace = th.getStackTrace();
        String n = this.f2937n.m10965n();
        String c2 = this.f2936m.c();
        int i2 = 0;
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr2[i2] = (Thread) entry.getKey();
                linkedList.add(entry.getValue());
                i2++;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (C6428i.a(E, "com.crashlytics.CollectCustomKeys", true)) {
            g = r0.f2937n.m10958g();
            if (g != null && g.size() > 1) {
                treeMap = new TreeMap(g);
                ab.m3477a(c1022e, time, str, th, thread, stackTrace, threadArr, linkedList, treeMap, r0.f2938o, a2, i, c2, n, c, a, d, b, b2);
            }
        }
        g = new TreeMap();
        treeMap = g;
        ab.m3477a(c1022e, time, str, th, thread, stackTrace, threadArr, linkedList, treeMap, r0.f2938o, a2, i, c2, n, c, a, d, b, b2);
    }

    /* renamed from: a */
    private void m3588a(File file, String str, int i) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Collecting session parts for ID ");
        stringBuilder2.append(str);
        C6514c.h().a("CrashlyticsCore", stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append("SessionCrash");
        File[] a = m3598a(new C1049b(stringBuilder3.toString()));
        boolean z = a != null && a.length > 0;
        C6514c.h().a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z)}));
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(str);
        stringBuilder4.append("SessionEvent");
        File[] a2 = m3598a(new C1049b(stringBuilder4.toString()));
        boolean z2 = a2 != null && a2.length > 0;
        C6514c.h().a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z2)}));
        if (!z) {
            if (!z2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("No events present for session ID ");
                stringBuilder.append(str);
                C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("Removing session part files for ID ");
                stringBuilder.append(str);
                C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
                m3591a(str);
            }
        }
        m3589a(file, str, m3599a(str, a2, i), z ? a[0] : null);
        stringBuilder = new StringBuilder();
        stringBuilder.append("Removing session part files for ID ");
        stringBuilder.append(str);
        C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
        m3591a(str);
    }

    /* renamed from: a */
    private void m3589a(File file, String str, File[] fileArr, File file2) {
        Closeable c1020d;
        Flushable a;
        Throwable e;
        StringBuilder stringBuilder;
        boolean z = file2 != null;
        C1020d c1020d2 = null;
        try {
            c1020d = new C1020d(m3623q(), str);
            try {
                a = C1022e.m3505a((OutputStream) c1020d);
                try {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Collecting SessionStart data for session ID ");
                    stringBuilder2.append(str);
                    C6514c.h().a("CrashlyticsCore", stringBuilder2.toString());
                    C1052l.m3581a((C1022e) a, file);
                    a.m3532a(4, new Date().getTime() / 1000);
                    a.m3534a(5, z);
                    m3582a((C1022e) a, str);
                    C1052l.m3584a((C1022e) a, fileArr, str);
                    if (z) {
                        C1052l.m3581a((C1022e) a, file2);
                    }
                    a.m3531a(11, 1);
                    a.m3542b(12, 3);
                    C6428i.a(a, "Error flushing session file stream");
                    C6428i.a(c1020d, "Failed to close CLS file");
                } catch (Exception e2) {
                    e = e2;
                    c1020d2 = c1020d;
                    try {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to write session file for session ID: ");
                        stringBuilder.append(str);
                        C6514c.h().e("CrashlyticsCore", stringBuilder.toString(), e);
                        C1059r.m3647a(e, (OutputStream) c1020d2);
                        C6428i.a(a, "Error flushing session file stream");
                        m3580a(c1020d2);
                    } catch (Throwable th) {
                        file = th;
                        c1020d = c1020d2;
                        C6428i.a(a, "Error flushing session file stream");
                        C6428i.a(c1020d, "Failed to close CLS file");
                        throw file;
                    }
                } catch (Throwable th2) {
                    file = th2;
                    C6428i.a(a, "Error flushing session file stream");
                    C6428i.a(c1020d, "Failed to close CLS file");
                    throw file;
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
                c1020d2 = c1020d;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to write session file for session ID: ");
                stringBuilder.append(str);
                C6514c.h().e("CrashlyticsCore", stringBuilder.toString(), e);
                C1059r.m3647a(e, (OutputStream) c1020d2);
                C6428i.a(a, "Error flushing session file stream");
                m3580a(c1020d2);
            } catch (Throwable th3) {
                file = th3;
                a = null;
                C6428i.a(a, "Error flushing session file stream");
                C6428i.a(c1020d, "Failed to close CLS file");
                throw file;
            }
        } catch (Exception e4) {
            e = e4;
            a = null;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to write session file for session ID: ");
            stringBuilder.append(str);
            C6514c.h().e("CrashlyticsCore", stringBuilder.toString(), e);
            C1059r.m3647a(e, (OutputStream) c1020d2);
            C6428i.a(a, "Error flushing session file stream");
            m3580a(c1020d2);
        } catch (Throwable th4) {
            file = th4;
            c1020d = null;
            a = c1020d;
            C6428i.a(a, "Error flushing session file stream");
            C6428i.a(c1020d, "Failed to close CLS file");
            throw file;
        }
    }

    /* renamed from: a */
    private static void m3584a(C1022e c1022e, File[] fileArr, String str) {
        Arrays.sort(fileArr, C6428i.f20767a);
        for (File name : fileArr) {
            try {
                C6514c.h().a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, name.getName()}));
                C1052l.m3581a(c1022e, name);
            } catch (Throwable e) {
                C6514c.h().e("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    /* renamed from: a */
    private void m3582a(C1022e c1022e, String str) {
        for (String str2 : f2930g) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            File[] a = m3598a(new C1049b(stringBuilder.toString()));
            if (a.length == 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Can't find ");
                stringBuilder2.append(str2);
                stringBuilder2.append(" data for session ID ");
                stringBuilder2.append(str);
                C6514c.h().e("CrashlyticsCore", stringBuilder2.toString(), null);
            } else {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Collecting ");
                stringBuilder3.append(str2);
                stringBuilder3.append(" data for session ID ");
                stringBuilder3.append(str);
                C6514c.h().a("CrashlyticsCore", stringBuilder3.toString());
                C1052l.m3581a(c1022e, a[0]);
            }
        }
    }

    /* renamed from: a */
    private static void m3581a(C1022e c1022e, File file) {
        if (file.exists()) {
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    C1052l.m3590a((InputStream) fileInputStream, c1022e, (int) file.length());
                    C6428i.a(fileInputStream, "Failed to close file input stream.");
                    return;
                } catch (Throwable th) {
                    c1022e = th;
                    C6428i.a(fileInputStream, "Failed to close file input stream.");
                    throw c1022e;
                }
            } catch (Throwable th2) {
                c1022e = th2;
                fileInputStream = null;
                C6428i.a(fileInputStream, "Failed to close file input stream.");
                throw c1022e;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tried to include a file that doesn't exist: ");
        stringBuilder.append(file.getName());
        C6514c.h().e("CrashlyticsCore", stringBuilder.toString(), null);
    }

    /* renamed from: a */
    private static void m3590a(InputStream inputStream, C1022e c1022e, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = inputStream.read(bArr, i2, bArr.length - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        c1022e.m3539a(bArr);
    }

    /* renamed from: g */
    private ae m3613g(String str) {
        return m3627a() ? new ae(this.f2937n.m10967p(), this.f2937n.m10969r(), this.f2937n.m10968q()) : new C1063v(m3623q()).m3668a(str);
    }

    /* renamed from: p */
    private void m3622p() {
        for (File c1050c : m3619m()) {
            this.f2935l.m3562a(new C1050c(this.f2937n, c1050c));
        }
    }

    /* renamed from: q */
    private File m3623q() {
        return this.f2933j.a();
    }
}

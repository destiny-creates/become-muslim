package com.bugsnag.android;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Semaphore;

/* compiled from: ErrorStore */
/* renamed from: com.bugsnag.android.u */
class C3449u extends C1108y<C3448s> {
    /* renamed from: b */
    static final Comparator<File> f9216b = new C11031();
    /* renamed from: a */
    volatile boolean f9217a = null;
    /* renamed from: g */
    private final Semaphore f9218g = new Semaphore(1);

    /* compiled from: ErrorStore */
    /* renamed from: com.bugsnag.android.u$1 */
    static class C11031 implements Comparator<File> {
        C11031() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3922a((File) obj, (File) obj2);
        }

        /* renamed from: a */
        public int m3922a(File file, File file2) {
            if (file == null && file2 == null) {
                return null;
            }
            if (file == null) {
                return 1;
            }
            if (file2 == null) {
                return -1;
            }
            return file.getName().replaceAll("_startupcrash", "").compareTo(file2.getName().replaceAll("_startupcrash", ""));
        }
    }

    /* compiled from: ErrorStore */
    /* renamed from: com.bugsnag.android.u$3 */
    class C11053 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3449u f3113a;

        C11053(C3449u c3449u) {
            this.f3113a = c3449u;
        }

        public void run() {
            this.f3113a.m11083a(this.f3113a.m3935d());
        }
    }

    C3449u(C1091l c1091l, Context context) {
        super(c1091l, context, "/bugsnag-errors/", 128, f9216b);
    }

    /* renamed from: a */
    void m11082a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r6 = this;
        r0 = r6.c;
        r0 = r0.m3864q();
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x0054;
    L_0x000c:
        r0 = r6.m3935d();
        r1 = r6.m11080d(r0);
        r4 = r1.isEmpty();
        if (r4 != 0) goto L_0x0051;
    L_0x001a:
        r4 = 0;
        r6.f9217a = r4;
        r4 = "Attempting to send launch crash reports";
        com.bugsnag.android.ad.m3732a(r4);
        r4 = new com.bugsnag.android.u$2;	 Catch:{ RejectedExecutionException -> 0x002b }
        r4.<init>(r6, r1);	 Catch:{ RejectedExecutionException -> 0x002b }
        com.bugsnag.android.C1076b.m3764a(r4);	 Catch:{ RejectedExecutionException -> 0x002b }
        goto L_0x0034;
    L_0x002b:
        r1 = move-exception;
        r4 = "Failed to flush launch crash reports";
        com.bugsnag.android.ad.m3733a(r4, r1);
        r1 = 1;
        r6.f9217a = r1;
    L_0x0034:
        r1 = r6.f9217a;
        if (r1 != 0) goto L_0x004c;
    L_0x0038:
        r4 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 >= 0) goto L_0x004c;
    L_0x003e:
        r4 = 50;
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0046 }
        r1 = 0;
        r2 = r2 + r4;
        goto L_0x0034;
    L_0x0046:
        r1 = "Interrupted while waiting for launch crash report request";
        com.bugsnag.android.ad.m3736b(r1);
        goto L_0x0034;
    L_0x004c:
        r1 = "Continuing with Bugsnag initialisation";
        com.bugsnag.android.ad.m3732a(r1);
    L_0x0051:
        r6.m3932b(r0);
    L_0x0054:
        r6.m11086b();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.u.a():void");
    }

    /* renamed from: b */
    void m11086b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r1 = this;
        r0 = r1.d;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = new com.bugsnag.android.u$3;	 Catch:{ RejectedExecutionException -> 0x000e }
        r0.<init>(r1);	 Catch:{ RejectedExecutionException -> 0x000e }
        com.bugsnag.android.C1076b.m3764a(r0);	 Catch:{ RejectedExecutionException -> 0x000e }
        goto L_0x0013;
    L_0x000e:
        r0 = "Failed to flush all on-disk errors, retaining unsent errors for later.";
        com.bugsnag.android.ad.m3736b(r0);
    L_0x0013:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.u.b():void");
    }

    /* renamed from: a */
    void m11083a(Collection<File> collection) {
        if (!collection.isEmpty() && this.f9218g.tryAcquire(1)) {
            try {
                ad.m3732a(String.format(Locale.US, "Sending %d saved error(s) to Bugsnag", new Object[]{Integer.valueOf(collection.size())}));
                for (File b : collection) {
                    m11079b(b);
                }
            } finally {
                this.f9218g.release(1);
            }
        }
    }

    /* renamed from: b */
    private void m11079b(File file) {
        try {
            ai aiVar;
            if (this.c.m3862o().size() > 0) {
                aiVar = new ai(this.c.m3829a(), C1102t.m3909a(this.c, file));
                for (C1079e a : this.c.m3862o()) {
                    try {
                        if (!a.m3767a(aiVar)) {
                            m3934c(Collections.singleton(file));
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Deleting cancelled error file ");
                            stringBuilder.append(file.getName());
                            ad.m3732a(stringBuilder.toString());
                            return;
                        }
                    } catch (Throwable th) {
                        ad.m3733a("BeforeSend threw an Exception", th);
                    }
                }
            } else {
                aiVar = new ai(this.c.m3829a(), file);
            }
            this.c.m3869v().mo779a(aiVar, this.c);
            m3934c(Collections.singleton(file));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Deleting sent error file ");
            stringBuilder2.append(file.getName());
            ad.m3732a(stringBuilder2.toString());
        } catch (Throwable e) {
            m3932b(Collections.singleton(file));
            ad.m3733a("Could not send previously saved error(s) to Bugsnag, will try again later", e);
        } catch (Throwable e2) {
            m3934c(Collections.singleton(file));
            ad.m3733a("Problem sending unsent error from disk", e2);
        }
    }

    /* renamed from: a */
    boolean m11085a(File file) {
        return file.getName().endsWith("_startupcrash.json");
    }

    /* renamed from: d */
    private List<File> m11080d(Collection<File> collection) {
        List<File> arrayList = new ArrayList();
        for (File file : collection) {
            if (m11085a(file)) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    String mo778a(Object obj) {
        String str = "";
        if (obj instanceof C3448s) {
            obj = ((C3448s) obj).m11074e();
            if ((obj instanceof Map) && (obj.get("duration") instanceof Number) && m11084a(((Number) obj.get("duration")).longValue()) != null) {
                str = "_startupcrash";
            }
        } else {
            str = "not-jvm";
        }
        return String.format(Locale.US, "%s%d_%s%s.json", new Object[]{this.d, Long.valueOf(System.currentTimeMillis()), UUID.randomUUID().toString(), str});
    }

    /* renamed from: a */
    boolean m11084a(long j) {
        return j < this.c.m3864q() ? 1 : 0;
    }
}

package com.p064b.p065a.p068c;

import com.facebook.appevents.AppEventsConstants;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6523l;
import io.p347a.p348a.p349a.p350a.p352b.C6424g;
import io.p347a.p348a.p349a.p350a.p352b.C6425h;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ReportUploader */
/* renamed from: com.b.a.c.aa */
class aa {
    /* renamed from: a */
    static final Map<String, String> f2850a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    /* renamed from: b */
    private static final FilenameFilter f2851b = new C10161();
    /* renamed from: c */
    private static final short[] f2852c = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    /* renamed from: d */
    private final Object f2853d = new Object();
    /* renamed from: e */
    private final C1054n f2854e;
    /* renamed from: f */
    private Thread f2855f;

    /* compiled from: ReportUploader */
    /* renamed from: com.b.a.c.aa$1 */
    static class C10161 implements FilenameFilter {
        C10161() {
        }

        public boolean accept(File file, String str) {
            return (str.endsWith(".cls") == null || str.contains("Session") != null) ? null : true;
        }
    }

    /* compiled from: ReportUploader */
    /* renamed from: com.b.a.c.aa$a */
    private class C3420a extends C6425h {
        /* renamed from: a */
        final /* synthetic */ aa f9097a;
        /* renamed from: b */
        private final float f9098b;

        C3420a(aa aaVar, float f) {
            this.f9097a = aaVar;
            this.f9098b = f;
        }

        /* renamed from: a */
        public void m10920a() {
            try {
                m10919b();
            } catch (Throwable e) {
                C6514c.h().e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            this.f9097a.f2855f = null;
        }

        /* renamed from: b */
        private void m10919b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r8 = this;
            r0 = io.p347a.p348a.p349a.C6514c.h();
            r1 = "CrashlyticsCore";
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "Starting report processing in ";
            r2.append(r3);
            r3 = r8.f9098b;
            r2.append(r3);
            r3 = " second(s)...";
            r2.append(r3);
            r2 = r2.toString();
            r0.a(r1, r2);
            r0 = r8.f9098b;
            r1 = 0;
            r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
            if (r0 <= 0) goto L_0x003b;
        L_0x0028:
            r0 = r8.f9098b;	 Catch:{ InterruptedException -> 0x0033 }
            r1 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;	 Catch:{ InterruptedException -> 0x0033 }
            r0 = r0 * r1;	 Catch:{ InterruptedException -> 0x0033 }
            r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0033 }
            java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0033 }
            goto L_0x003b;
        L_0x0033:
            r0 = java.lang.Thread.currentThread();
            r0.interrupt();
            return;
        L_0x003b:
            r0 = com.p064b.p065a.p068c.C3424f.m10946e();
            r1 = r0.m10966o();
            r2 = r8.f9097a;
            r2 = r2.m3456a();
            r1 = r1.m3627a();
            if (r1 == 0) goto L_0x0050;
        L_0x004f:
            return;
        L_0x0050:
            r1 = r2.isEmpty();
            if (r1 != 0) goto L_0x0094;
        L_0x0056:
            r0 = r0.m10977z();
            if (r0 != 0) goto L_0x0094;
        L_0x005c:
            r0 = io.p347a.p348a.p349a.C6514c.h();
            r1 = "CrashlyticsCore";
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = "User declined to send. Removing ";
            r3.append(r4);
            r4 = r2.size();
            r3.append(r4);
            r4 = " Report(s).";
            r3.append(r4);
            r3 = r3.toString();
            r0.a(r1, r3);
            r0 = r2.iterator();
        L_0x0083:
            r1 = r0.hasNext();
            if (r1 == 0) goto L_0x0093;
        L_0x0089:
            r1 = r0.next();
            r1 = (com.p064b.p065a.p068c.C1067z) r1;
            r1.mo747a();
            goto L_0x0083;
        L_0x0093:
            return;
        L_0x0094:
            r0 = 0;
        L_0x0095:
            r1 = r2.isEmpty();
            if (r1 != 0) goto L_0x0134;
        L_0x009b:
            r1 = com.p064b.p065a.p068c.C3424f.m10946e();
            r1 = r1.m10966o();
            r1 = r1.m3627a();
            if (r1 == 0) goto L_0x00aa;
        L_0x00a9:
            return;
        L_0x00aa:
            r1 = io.p347a.p348a.p349a.C6514c.h();
            r3 = "CrashlyticsCore";
            r4 = new java.lang.StringBuilder;
            r4.<init>();
            r5 = "Attempting to send ";
            r4.append(r5);
            r5 = r2.size();
            r4.append(r5);
            r5 = " report(s)";
            r4.append(r5);
            r4 = r4.toString();
            r1.a(r3, r4);
            r1 = r2.iterator();
        L_0x00d1:
            r2 = r1.hasNext();
            if (r2 == 0) goto L_0x00e3;
        L_0x00d7:
            r2 = r1.next();
            r2 = (com.p064b.p065a.p068c.C1067z) r2;
            r3 = r8.f9097a;
            r3.m3458a(r2);
            goto L_0x00d1;
        L_0x00e3:
            r1 = r8.f9097a;
            r2 = r1.m3456a();
            r1 = r2.isEmpty();
            if (r1 != 0) goto L_0x0095;
        L_0x00ef:
            r1 = com.p064b.p065a.p068c.aa.f2852c;
            r3 = r0 + 1;
            r4 = com.p064b.p065a.p068c.aa.f2852c;
            r4 = r4.length;
            r4 = r4 + -1;
            r0 = java.lang.Math.min(r0, r4);
            r0 = r1[r0];
            r0 = (long) r0;
            r4 = io.p347a.p348a.p349a.C6514c.h();
            r5 = "CrashlyticsCore";
            r6 = new java.lang.StringBuilder;
            r6.<init>();
            r7 = "Report submisson: scheduling delayed retry in ";
            r6.append(r7);
            r6.append(r0);
            r7 = " seconds";
            r6.append(r7);
            r6 = r6.toString();
            r4.a(r5, r6);
            r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r0 = r0 * r4;
            java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x012c }
            r0 = r3;
            goto L_0x0095;
        L_0x012c:
            r0 = java.lang.Thread.currentThread();
            r0.interrupt();
            return;
        L_0x0134:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.b.a.c.aa.a.b():void");
        }
    }

    public aa(C1054n c1054n) {
        if (c1054n != null) {
            this.f2854e = c1054n;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    /* renamed from: a */
    public synchronized void m3457a(float f) {
        if (this.f2855f == null) {
            this.f2855f = new Thread(new C3420a(this, f), "Crashlytics Report Uploader");
            this.f2855f.start();
        }
    }

    /* renamed from: a */
    boolean m3458a(C1067z c1067z) {
        boolean z;
        synchronized (this.f2853d) {
            z = false;
            try {
                boolean a = this.f2854e.mo753a(new C1053m(new C6424g().a(C3424f.m10946e().E()), c1067z));
                C6523l h = C6514c.h();
                String str = "CrashlyticsCore";
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Crashlytics report upload ");
                stringBuilder.append(a ? "complete: " : "FAILED: ");
                stringBuilder.append(c1067z.mo748b());
                h.c(str, stringBuilder.toString());
                if (a) {
                    c1067z.mo747a();
                    z = true;
                }
            } catch (Throwable e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error occurred sending report ");
                stringBuilder.append(c1067z);
                C6514c.h().e("CrashlyticsCore", stringBuilder.toString(), e);
            }
        }
        return z;
    }

    /* renamed from: a */
    List<C1067z> m3456a() {
        C6514c.h().a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f2853d) {
            File[] listFiles = C3424f.m10946e().m10974w().listFiles(f2851b);
        }
        List<C1067z> linkedList = new LinkedList();
        for (File file : listFiles) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Found crash report ");
            stringBuilder.append(file.getPath());
            C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
            linkedList.add(new ac(file));
        }
        if (linkedList.isEmpty()) {
            C6514c.h().a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }
}

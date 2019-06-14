package com.bugsnag;

import com.bugsnag.android.ab.C1071a;

/* compiled from: BugsnagReactNative */
/* renamed from: com.bugsnag.c */
class C3453c extends Exception implements C1071a {
    private static final long serialVersionUID = 1175784680140218622L;
    /* renamed from: a */
    private final String f9233a;
    /* renamed from: b */
    private final String f9234b;

    C3453c(String str, String str2, String str3) {
        super(str2);
        this.f9233a = str;
        this.f9234b = str3;
    }

    public void toStream(com.bugsnag.android.ab r14) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r13 = this;
        r14.mo772c();
        r0 = "errorClass";
        r0 = r14.mo764a(r0);
        r1 = r13.f9233a;
        r0.mo771b(r1);
        r0 = "message";
        r0 = r14.mo764a(r0);
        r1 = r13.getLocalizedMessage();
        r0.mo771b(r1);
        r0 = "type";
        r0 = r14.mo764a(r0);
        r1 = "browserjs";
        r0.mo771b(r1);
        r0 = "stacktrace";
        r14.mo764a(r0);
        r14.mo776e();
        r0 = r13.f9234b;
        r1 = "\\n";
        r0 = r0.split(r1);
        r1 = r0.length;
        r2 = 0;
        r3 = 0;
    L_0x0039:
        if (r3 >= r1) goto L_0x00d3;
    L_0x003b:
        r4 = r0[r3];
        r14.mo772c();
        r5 = "@";
        r6 = 2;
        r4 = r4.split(r5, r6);
        r5 = r4[r2];
        r7 = r4.length;
        r8 = 1;
        if (r7 != r6) goto L_0x005a;
    L_0x004d:
        r5 = "method";
        r5 = r14.mo764a(r5);
        r6 = r4[r2];
        r5.mo771b(r6);
        r5 = r4[r8];
    L_0x005a:
        r4 = ":";
        r4 = r5.lastIndexOf(r4);
        r6 = -1;
        if (r4 == r6) goto L_0x008f;
    L_0x0063:
        r7 = r4 + 1;
        r9 = r5.length();
        r7 = r5.substring(r7, r9);
        r9 = java.lang.Integer.parseInt(r7);	 Catch:{ NumberFormatException -> 0x007c }
        r10 = "columnNumber";	 Catch:{ NumberFormatException -> 0x007c }
        r10 = r14.mo764a(r10);	 Catch:{ NumberFormatException -> 0x007c }
        r11 = (long) r9;	 Catch:{ NumberFormatException -> 0x007c }
        r10.mo766a(r11);	 Catch:{ NumberFormatException -> 0x007c }
        goto L_0x008b;
    L_0x007c:
        r9 = com.bugsnag.BugsnagReactNative.logger;
        r10 = "Failed to parse column: '%s'";
        r11 = new java.lang.Object[r8];
        r11[r2] = r7;
        r7 = java.lang.String.format(r10, r11);
        r9.info(r7);
    L_0x008b:
        r5 = r5.substring(r2, r4);
    L_0x008f:
        r4 = ":";
        r4 = r5.lastIndexOf(r4);
        if (r4 == r6) goto L_0x00c3;
    L_0x0097:
        r6 = r4 + 1;
        r7 = r5.length();
        r6 = r5.substring(r6, r7);
        r7 = java.lang.Integer.parseInt(r6);	 Catch:{ NumberFormatException -> 0x00b0 }
        r9 = "lineNumber";	 Catch:{ NumberFormatException -> 0x00b0 }
        r9 = r14.mo764a(r9);	 Catch:{ NumberFormatException -> 0x00b0 }
        r10 = (long) r7;	 Catch:{ NumberFormatException -> 0x00b0 }
        r9.mo766a(r10);	 Catch:{ NumberFormatException -> 0x00b0 }
        goto L_0x00bf;
    L_0x00b0:
        r7 = com.bugsnag.BugsnagReactNative.logger;
        r9 = "Failed to parse lineNumber: '%s'";
        r8 = new java.lang.Object[r8];
        r8[r2] = r6;
        r6 = java.lang.String.format(r9, r8);
        r7.info(r6);
    L_0x00bf:
        r5 = r5.substring(r2, r4);
    L_0x00c3:
        r4 = "file";
        r4 = r14.mo764a(r4);
        r4.mo771b(r5);
        r14.mo770b();
        r3 = r3 + 1;
        goto L_0x0039;
    L_0x00d3:
        r14.mo775d();
        r14.mo770b();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.c.toStream(com.bugsnag.android.ab):void");
    }
}

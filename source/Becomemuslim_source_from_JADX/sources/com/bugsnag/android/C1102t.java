package com.bugsnag.android;

import android.util.JsonReader;
import android.util.JsonToken;
import com.facebook.common.util.UriUtil;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: ErrorReader */
/* renamed from: com.bugsnag.android.t */
class C1102t {

    /* compiled from: ErrorReader */
    /* renamed from: com.bugsnag.android.t$1 */
    static /* synthetic */ class C11011 {
        /* renamed from: a */
        static final /* synthetic */ int[] f3110a = new int[JsonToken.values().length];

        static {
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
            r0 = android.util.JsonToken.values();
            r0 = r0.length;
            r0 = new int[r0];
            f3110a = r0;
            r0 = f3110a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.util.JsonToken.BEGIN_OBJECT;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f3110a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.util.JsonToken.STRING;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f3110a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.util.JsonToken.BOOLEAN;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f3110a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = android.util.JsonToken.NUMBER;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = f3110a;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = android.util.JsonToken.BEGIN_ARRAY;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.t.1.<clinit>():void");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static com.bugsnag.android.C3448s m3909a(com.bugsnag.android.C1091l r19, java.io.File r20) {
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
        r0 = r19;
        r2 = com.bugsnag.android.Severity.ERROR;	 Catch:{ all -> 0x018e }
        r8 = new android.util.JsonReader;	 Catch:{ all -> 0x018e }
        r3 = new java.io.FileReader;	 Catch:{ all -> 0x018e }
        r4 = r20;	 Catch:{ all -> 0x018e }
        r3.<init>(r4);	 Catch:{ all -> 0x018e }
        r8.<init>(r3);	 Catch:{ all -> 0x018e }
        r8.beginObject();	 Catch:{ all -> 0x018c }
        r5 = r2;	 Catch:{ all -> 0x018c }
        r2 = 0;	 Catch:{ all -> 0x018c }
        r4 = 0;	 Catch:{ all -> 0x018c }
        r6 = 0;	 Catch:{ all -> 0x018c }
        r7 = 0;	 Catch:{ all -> 0x018c }
        r9 = 0;	 Catch:{ all -> 0x018c }
        r10 = 0;	 Catch:{ all -> 0x018c }
        r11 = 0;	 Catch:{ all -> 0x018c }
        r12 = 0;	 Catch:{ all -> 0x018c }
        r13 = 0;	 Catch:{ all -> 0x018c }
        r14 = 0;	 Catch:{ all -> 0x018c }
        r15 = 0;	 Catch:{ all -> 0x018c }
        r16 = 0;	 Catch:{ all -> 0x018c }
    L_0x0021:
        r17 = r8.hasNext();	 Catch:{ all -> 0x018c }
        if (r17 == 0) goto L_0x012b;	 Catch:{ all -> 0x018c }
    L_0x0027:
        r3 = r8.nextName();	 Catch:{ all -> 0x018c }
        r17 = -1;	 Catch:{ all -> 0x018c }
        r18 = r3.hashCode();	 Catch:{ all -> 0x018c }
        switch(r18) {
            case -1890362749: goto L_0x00b5;
            case -1337936983: goto L_0x00aa;
            case -1335157162: goto L_0x00a0;
            case -1314244092: goto L_0x0096;
            case -450957489: goto L_0x008c;
            case -68904783: goto L_0x0082;
            case -51457840: goto L_0x0078;
            case 96801: goto L_0x006e;
            case 3599307: goto L_0x0063;
            case 398106529: goto L_0x0058;
            case 951530927: goto L_0x004d;
            case 1478300413: goto L_0x0041;
            case 1984987798: goto L_0x0036;
            default: goto L_0x0034;
        };	 Catch:{ all -> 0x018c }
    L_0x0034:
        goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x0036:
        r1 = "session";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x003e:
        r3 = 7;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x0041:
        r1 = "severity";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x0049:
        r3 = 8;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x004d:
        r1 = "context";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x0055:
        r3 = 2;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x0058:
        r1 = "severityReason";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x0060:
        r3 = 9;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x0063:
        r1 = "user";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x006b:
        r3 = 12;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x006e:
        r1 = "app";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x0076:
        r3 = 0;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x0078:
        r1 = "breadcrumbs";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x0080:
        r3 = 1;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x0082:
        r1 = "groupingHash";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x008a:
        r3 = 5;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x008c:
        r1 = "metaData";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x0094:
        r3 = 6;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x0096:
        r1 = "exceptions";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x009e:
        r3 = 4;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x00a0:
        r1 = "device";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x00a8:
        r3 = 3;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x00aa:
        r1 = "threads";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x00b2:
        r3 = 10;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x00b5:
        r1 = "unhandled";	 Catch:{ all -> 0x018c }
        r1 = r3.equals(r1);	 Catch:{ all -> 0x018c }
        if (r1 == 0) goto L_0x00c0;	 Catch:{ all -> 0x018c }
    L_0x00bd:
        r3 = 11;	 Catch:{ all -> 0x018c }
        goto L_0x00c1;	 Catch:{ all -> 0x018c }
    L_0x00c0:
        r3 = -1;	 Catch:{ all -> 0x018c }
    L_0x00c1:
        switch(r3) {
            case 0: goto L_0x0124;
            case 1: goto L_0x011c;
            case 2: goto L_0x0115;
            case 3: goto L_0x010e;
            case 4: goto L_0x0107;
            case 5: goto L_0x0100;
            case 6: goto L_0x00f4;
            case 7: goto L_0x00ee;
            case 8: goto L_0x00e4;
            case 9: goto L_0x00dd;
            case 10: goto L_0x00d7;
            case 11: goto L_0x00d0;
            case 12: goto L_0x00c9;
            default: goto L_0x00c4;
        };	 Catch:{ all -> 0x018c }
    L_0x00c4:
        r8.skipValue();	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x00c9:
        r1 = com.bugsnag.android.C1102t.m3918g(r8);	 Catch:{ all -> 0x018c }
        r10 = r1;	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x00d0:
        r1 = r8.nextBoolean();	 Catch:{ all -> 0x018c }
        r4 = r1;	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x00d7:
        r7 = com.bugsnag.android.C1102t.m3912c(r0, r8);	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x00dd:
        r1 = com.bugsnag.android.C1102t.m3916e(r8);	 Catch:{ all -> 0x018c }
        r2 = r1;	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x00e4:
        r1 = r8.nextString();	 Catch:{ all -> 0x018c }
        r5 = com.bugsnag.android.Severity.fromString(r1);	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x00ee:
        r6 = com.bugsnag.android.C1102t.m3917f(r8);	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x00f4:
        r1 = new com.bugsnag.android.af;	 Catch:{ all -> 0x018c }
        r3 = com.bugsnag.android.C1102t.m3919h(r8);	 Catch:{ all -> 0x018c }
        r1.<init>(r3);	 Catch:{ all -> 0x018c }
        r14 = r1;	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x0100:
        r1 = r8.nextString();	 Catch:{ all -> 0x018c }
        r12 = r1;	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x0107:
        r1 = com.bugsnag.android.C1102t.m3911b(r0, r8);	 Catch:{ all -> 0x018c }
        r9 = r1;	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x010e:
        r1 = com.bugsnag.android.C1102t.m3919h(r8);	 Catch:{ all -> 0x018c }
        r15 = r1;	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x0115:
        r1 = r8.nextString();	 Catch:{ all -> 0x018c }
        r11 = r1;	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x011c:
        r1 = com.bugsnag.android.C1102t.m3908a(r0, r8);	 Catch:{ all -> 0x018c }
        r16 = r1;	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x0124:
        r1 = com.bugsnag.android.C1102t.m3919h(r8);	 Catch:{ all -> 0x018c }
        r13 = r1;	 Catch:{ all -> 0x018c }
        goto L_0x0021;	 Catch:{ all -> 0x018c }
    L_0x012b:
        r8.endObject();	 Catch:{ all -> 0x018c }
        if (r2 == 0) goto L_0x0184;	 Catch:{ all -> 0x018c }
    L_0x0130:
        if (r9 == 0) goto L_0x0184;	 Catch:{ all -> 0x018c }
    L_0x0132:
        r1 = r2.size();	 Catch:{ all -> 0x018c }
        r3 = 1;	 Catch:{ all -> 0x018c }
        if (r1 <= r3) goto L_0x0140;	 Catch:{ all -> 0x018c }
    L_0x0139:
        r1 = r2.get(r3);	 Catch:{ all -> 0x018c }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x018c }
        goto L_0x0141;	 Catch:{ all -> 0x018c }
    L_0x0140:
        r1 = 0;	 Catch:{ all -> 0x018c }
    L_0x0141:
        r3 = new com.bugsnag.android.z;	 Catch:{ all -> 0x018c }
        r0 = 0;	 Catch:{ all -> 0x018c }
        r0 = r2.get(r0);	 Catch:{ all -> 0x018c }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x018c }
        r3.<init>(r0, r5, r4, r1);	 Catch:{ all -> 0x018c }
        r0 = new com.bugsnag.android.s;	 Catch:{ all -> 0x018c }
        r4 = r9.m11089a();	 Catch:{ all -> 0x018c }
        r1 = r0;	 Catch:{ all -> 0x018c }
        r2 = r19;	 Catch:{ all -> 0x018c }
        r17 = r3;	 Catch:{ all -> 0x018c }
        r3 = r4;	 Catch:{ all -> 0x018c }
        r4 = r17;	 Catch:{ all -> 0x018c }
        r1.<init>(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x018c }
        r1 = r0.m11077h();	 Catch:{ all -> 0x018c }
        r2 = r9.m11091b();	 Catch:{ all -> 0x018c }
        r1.m11090a(r2);	 Catch:{ all -> 0x018c }
        r0.m11066a(r10);	 Catch:{ all -> 0x018c }
        r0.m11067a(r11);	 Catch:{ all -> 0x018c }
        r0.m11070b(r12);	 Catch:{ all -> 0x018c }
        r0.m11068a(r13);	 Catch:{ all -> 0x018c }
        r0.m11065a(r14);	 Catch:{ all -> 0x018c }
        r0.m11071b(r15);	 Catch:{ all -> 0x018c }
        r1 = r16;	 Catch:{ all -> 0x018c }
        r0.m11063a(r1);	 Catch:{ all -> 0x018c }
        r8.close();	 Catch:{ Exception -> 0x0183 }
    L_0x0183:
        return r0;
    L_0x0184:
        r0 = new java.io.IOException;	 Catch:{ all -> 0x018c }
        r1 = "File did not contain a valid error";	 Catch:{ all -> 0x018c }
        r0.<init>(r1);	 Catch:{ all -> 0x018c }
        throw r0;	 Catch:{ all -> 0x018c }
    L_0x018c:
        r0 = move-exception;
        goto L_0x0190;
    L_0x018e:
        r0 = move-exception;
        r8 = 0;
    L_0x0190:
        if (r8 == 0) goto L_0x0195;
    L_0x0192:
        r8.close();	 Catch:{ Exception -> 0x0195 }
    L_0x0195:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.t.a(com.bugsnag.android.l, java.io.File):com.bugsnag.android.s");
    }

    /* renamed from: a */
    private static Breadcrumbs m3908a(C1091l c1091l, JsonReader jsonReader) {
        Breadcrumbs breadcrumbs = new Breadcrumbs(c1091l);
        jsonReader.beginArray();
        while (jsonReader.hasNext() != null) {
            c1091l = C1102t.m3907a(jsonReader);
            if (c1091l != null) {
                breadcrumbs.add(c1091l);
            }
        }
        jsonReader.endArray();
        return breadcrumbs;
    }

    /* renamed from: a */
    private static Breadcrumb m3907a(JsonReader jsonReader) {
        Map hashMap = new HashMap();
        jsonReader.beginObject();
        String str = null;
        Date date = str;
        String str2 = date;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != -450957489) {
                if (hashCode != 3373707) {
                    if (hashCode != 3575610) {
                        if (hashCode == 55126294) {
                            if (nextName.equals("timestamp")) {
                                obj = 1;
                            }
                        }
                    } else if (nextName.equals("type")) {
                        obj = 2;
                    }
                } else if (nextName.equals("name")) {
                    obj = null;
                }
            } else if (nextName.equals("metaData")) {
                obj = 3;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    try {
                        date = C1093m.m3875a(jsonReader.nextString());
                        break;
                    } catch (JsonReader jsonReader2) {
                        throw new IOException("Failed to parse breadcrumb timestamp: ", jsonReader2);
                    }
                case 2:
                    str2 = jsonReader2.nextString().toUpperCase(Locale.US);
                    break;
                case 3:
                    jsonReader2.beginObject();
                    while (jsonReader2.hasNext()) {
                        hashMap.put(jsonReader2.nextName(), jsonReader2.nextString());
                    }
                    jsonReader2.endObject();
                    break;
                default:
                    jsonReader2.skipValue();
                    break;
            }
        }
        jsonReader2.endObject();
        if (str == null || date == null || str2 == null) {
            return null;
        }
        return new Breadcrumb(str, BreadcrumbType.valueOf(str2), date, hashMap);
    }

    /* renamed from: b */
    private static C3450x m3911b(C1091l c1091l, JsonReader jsonReader) {
        jsonReader.beginArray();
        Throwable b = C1102t.m3910b(jsonReader);
        Throwable th = b;
        while (jsonReader.hasNext()) {
            Throwable b2 = C1102t.m3910b(jsonReader);
            th.initCause(b2);
            th = b2;
        }
        jsonReader.endArray();
        jsonReader = new C3450x(c1091l, b);
        if (b != null) {
            jsonReader.m11090a(b.m3783b());
        }
        return jsonReader;
    }

    /* renamed from: b */
    private static C1081g m3910b(JsonReader jsonReader) {
        jsonReader.beginObject();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[0];
        String str = null;
        String str2 = "android";
        String str3 = null;
        while (jsonReader.hasNext()) {
            Object obj;
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == 3575610) {
                if (nextName.equals("type")) {
                    obj = 3;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            str3 = jsonReader.nextString();
                            break;
                        case 2:
                            stackTraceElementArr = C1102t.m3913c(jsonReader);
                            break;
                        case 3:
                            str2 = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 954925063) {
                if (nextName.equals(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            str3 = jsonReader.nextString();
                            break;
                        case 2:
                            stackTraceElementArr = C1102t.m3913c(jsonReader);
                            break;
                        case 3:
                            str2 = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 1610083408) {
                if (nextName.equals("errorClass")) {
                    obj = null;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            str3 = jsonReader.nextString();
                            break;
                        case 2:
                            stackTraceElementArr = C1102t.m3913c(jsonReader);
                            break;
                        case 3:
                            str2 = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 2055832509) {
                if (nextName.equals("stacktrace")) {
                    obj = 2;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            str3 = jsonReader.nextString();
                            break;
                        case 2:
                            stackTraceElementArr = C1102t.m3913c(jsonReader);
                            break;
                        case 3:
                            str2 = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            obj = -1;
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str3 = jsonReader.nextString();
                    break;
                case 2:
                    stackTraceElementArr = C1102t.m3913c(jsonReader);
                    break;
                case 3:
                    str2 = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        jsonReader = new C1081g(str, str3, stackTraceElementArr);
        jsonReader.m3782a(str2);
        return jsonReader;
    }

    /* renamed from: c */
    private static StackTraceElement[] m3913c(JsonReader jsonReader) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(C1102t.m3915d(jsonReader));
        }
        jsonReader.endArray();
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    /* renamed from: d */
    private static StackTraceElement m3915d(JsonReader jsonReader) {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        int i = 0;
        while (jsonReader.hasNext()) {
            Object obj;
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == -1077554975) {
                if (nextName.equals("method")) {
                    obj = null;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            str2 = jsonReader.nextString();
                            break;
                        case 2:
                            i = jsonReader.nextInt();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == -329142179) {
                if (nextName.equals(StackTraceHelper.LINE_NUMBER_KEY)) {
                    obj = 2;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            str2 = jsonReader.nextString();
                            break;
                        case 2:
                            i = jsonReader.nextInt();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 3143036) {
                if (nextName.equals(UriUtil.LOCAL_FILE_SCHEME)) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            str2 = jsonReader.nextString();
                            break;
                        case 2:
                            i = jsonReader.nextInt();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            obj = -1;
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str2 = jsonReader.nextString();
                    break;
                case 2:
                    i = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new StackTraceElement("", str, str2, i);
    }

    /* renamed from: e */
    private static ArrayList<String> m3916e(JsonReader jsonReader) {
        jsonReader.beginObject();
        Object obj = null;
        Object obj2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("type")) {
                obj = jsonReader.nextString();
            } else if (nextName.equals("attributes")) {
                jsonReader.beginObject();
                jsonReader.nextName();
                obj2 = jsonReader.nextString();
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader = new ArrayList();
        if (obj != null) {
            jsonReader.add(obj);
            if (obj2 != null) {
                jsonReader.add(obj2);
            }
            return jsonReader;
        }
        throw new IOException("Severity Reason type is required");
    }

    /* renamed from: f */
    private static aj m3917f(JsonReader jsonReader) {
        jsonReader.beginObject();
        String str = null;
        Date date = str;
        aq aqVar = date;
        int i = 0;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("id")) {
                str = jsonReader.nextString();
            } else if (nextName.equals("startedAt")) {
                try {
                    date = C1093m.m3875a(jsonReader.nextString());
                } catch (JsonReader jsonReader2) {
                    throw new IOException("Unable to parse session startedAt: ", jsonReader2);
                }
            } else if (nextName.equals("events")) {
                jsonReader2.beginObject();
                while (jsonReader2.hasNext()) {
                    nextName = jsonReader2.nextName();
                    if (nextName.equals("unhandled")) {
                        i = jsonReader2.nextInt();
                    } else if (nextName.equals("handled")) {
                        i2 = jsonReader2.nextInt();
                    } else {
                        jsonReader2.skipValue();
                    }
                }
                jsonReader2.endObject();
            } else if (nextName.equals("user")) {
                aqVar = C1102t.m3918g(jsonReader2);
            } else {
                jsonReader2.skipValue();
            }
        }
        jsonReader2.endObject();
        if (str != null && date != null) {
            return new aj(str, date, aqVar, i, i2);
        }
        throw new IOException("Session data missing required fields");
    }

    /* renamed from: g */
    private static aq m3918g(JsonReader jsonReader) {
        aq aqVar = new aq();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 3355) {
                if (hashCode != 3373707) {
                    if (hashCode == 96619420) {
                        if (nextName.equals("email")) {
                            obj = 2;
                        }
                    }
                } else if (nextName.equals("name")) {
                    obj = null;
                }
            } else if (nextName.equals("id")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    aqVar.m11057c(jsonReader.nextString());
                    break;
                case 1:
                    aqVar.m11053a(jsonReader.nextString());
                    break;
                case 2:
                    aqVar.m11055b(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return aqVar;
    }

    /* renamed from: c */
    private static ap m3912c(C1091l c1091l, JsonReader jsonReader) {
        List arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            C3446h d = C1102t.m3914d(c1091l, jsonReader);
            if (d != null) {
                arrayList.add(d);
            }
        }
        jsonReader.endArray();
        return new ap((C3446h[]) arrayList.toArray(new C3446h[arrayList.size()]));
    }

    /* renamed from: d */
    private static C3446h m3914d(C1091l c1091l, JsonReader jsonReader) {
        jsonReader.beginObject();
        String str = null;
        String str2 = str;
        StackTraceElement[] stackTraceElementArr = str2;
        long j = 0;
        boolean z = false;
        while (jsonReader.hasNext()) {
            Object obj;
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == -767067472) {
                if (nextName.equals("errorReportingThread")) {
                    obj = 4;
                    switch (obj) {
                        case null:
                            j = jsonReader.nextLong();
                            break;
                        case 1:
                            str = jsonReader.nextString();
                            break;
                        case 2:
                            str2 = jsonReader.nextString();
                            break;
                        case 3:
                            stackTraceElementArr = C1102t.m3913c(jsonReader);
                            break;
                        case 4:
                            z = jsonReader.nextBoolean();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 3355) {
                if (nextName.equals("id")) {
                    obj = null;
                    switch (obj) {
                        case null:
                            j = jsonReader.nextLong();
                            break;
                        case 1:
                            str = jsonReader.nextString();
                            break;
                        case 2:
                            str2 = jsonReader.nextString();
                            break;
                        case 3:
                            stackTraceElementArr = C1102t.m3913c(jsonReader);
                            break;
                        case 4:
                            z = jsonReader.nextBoolean();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 3373707) {
                if (nextName.equals("name")) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            j = jsonReader.nextLong();
                            break;
                        case 1:
                            str = jsonReader.nextString();
                            break;
                        case 2:
                            str2 = jsonReader.nextString();
                            break;
                        case 3:
                            stackTraceElementArr = C1102t.m3913c(jsonReader);
                            break;
                        case 4:
                            z = jsonReader.nextBoolean();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 3575610) {
                if (nextName.equals("type")) {
                    obj = 2;
                    switch (obj) {
                        case null:
                            j = jsonReader.nextLong();
                            break;
                        case 1:
                            str = jsonReader.nextString();
                            break;
                        case 2:
                            str2 = jsonReader.nextString();
                            break;
                        case 3:
                            stackTraceElementArr = C1102t.m3913c(jsonReader);
                            break;
                        case 4:
                            z = jsonReader.nextBoolean();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 2055832509) {
                if (nextName.equals("stacktrace")) {
                    obj = 3;
                    switch (obj) {
                        case null:
                            j = jsonReader.nextLong();
                            break;
                        case 1:
                            str = jsonReader.nextString();
                            break;
                        case 2:
                            str2 = jsonReader.nextString();
                            break;
                        case 3:
                            stackTraceElementArr = C1102t.m3913c(jsonReader);
                            break;
                        case 4:
                            z = jsonReader.nextBoolean();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            obj = -1;
            switch (obj) {
                case null:
                    j = jsonReader.nextLong();
                    break;
                case 1:
                    str = jsonReader.nextString();
                    break;
                case 2:
                    str2 = jsonReader.nextString();
                    break;
                case 3:
                    stackTraceElementArr = C1102t.m3913c(jsonReader);
                    break;
                case 4:
                    z = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (str2 == null || stackTraceElementArr == null) {
            return null;
        }
        return new C3446h(c1091l, j, str, str2, z, stackTraceElementArr);
    }

    /* renamed from: h */
    private static Map<String, Object> m3919h(JsonReader jsonReader) {
        Map<String, Object> hashMap = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object j = C1102t.m3921j(jsonReader);
            if (j != null) {
                hashMap.put(nextName, j);
            }
        }
        jsonReader.endObject();
        return hashMap;
    }

    /* renamed from: i */
    private static List<Object> m3920i(JsonReader jsonReader) {
        List<Object> arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            Object j = C1102t.m3921j(jsonReader);
            if (j != null) {
                arrayList.add(j);
            }
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* renamed from: j */
    private static java.lang.Object m3921j(android.util.JsonReader r2) {
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
        r0 = com.bugsnag.android.C1102t.C11011.f3110a;
        r1 = r2.peek();
        r1 = r1.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x003f;
            case 2: goto L_0x003a;
            case 3: goto L_0x0031;
            case 4: goto L_0x0016;
            case 5: goto L_0x0011;
            default: goto L_0x000f;
        };
    L_0x000f:
        r2 = 0;
        return r2;
    L_0x0011:
        r2 = com.bugsnag.android.C1102t.m3920i(r2);
        return r2;
    L_0x0016:
        r0 = r2.nextInt();	 Catch:{ NumberFormatException -> 0x001f }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x001f }
        return r0;
    L_0x001f:
        r0 = r2.nextLong();	 Catch:{ NumberFormatException -> 0x0028 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0028 }
        return r0;
    L_0x0028:
        r0 = r2.nextDouble();
        r2 = java.lang.Double.valueOf(r0);
        return r2;
    L_0x0031:
        r2 = r2.nextBoolean();
        r2 = java.lang.Boolean.valueOf(r2);
        return r2;
    L_0x003a:
        r2 = r2.nextString();
        return r2;
    L_0x003f:
        r2 = com.bugsnag.android.C1102t.m3919h(r2);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.t.j(android.util.JsonReader):java.lang.Object");
    }
}

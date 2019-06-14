package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.util.Base64;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.ads.internal.ax;
import java.io.IOException;

@cm
final class azk {
    /* renamed from: a */
    final aoq f15101a;
    /* renamed from: b */
    final String f15102b;
    /* renamed from: c */
    final int f15103c;

    private azk(aoq aoq, String str, int i) {
        this.f15101a = aoq;
        this.f15102b = str;
        this.f15103c = i;
    }

    azk(azf azf) {
        this(azf.m19148a(), azf.m19153c(), azf.m19152b());
    }

    /* renamed from: a */
    static azk m19171a(String str) {
        String[] split = str.split("\u0000");
        if (split.length == 3) {
            Parcel obtain = Parcel.obtain();
            try {
                String str2 = new String(Base64.decode(split[0], 0), Utf8Charset.NAME);
                int parseInt = Integer.parseInt(split[1]);
                byte[] decode = Base64.decode(split[2], 0);
                obtain.unmarshall(decode, 0, decode.length);
                obtain.setDataPosition(0);
                azk azk = new azk((aoq) aoq.CREATOR.createFromParcel(obtain), str2, parseInt);
                obtain.recycle();
                return azk;
            } catch (Throwable e) {
                ax.i().m30834a(e, "QueueSeed.decode");
                throw new IOException("Malformed QueueSeed encoding.", e);
            } catch (Throwable th) {
                obtain.recycle();
            }
        } else {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
    }

    /* renamed from: a */
    final java.lang.String m19172a() {
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
        r0 = android.os.Parcel.obtain();
        r1 = r6.f15102b;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r2 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r1 = r1.getBytes(r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r2 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r1 = android.util.Base64.encodeToString(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r3 = r6.f15103c;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = r6.f15101a;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4.writeToParcel(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = r0.marshall();	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r2 = android.util.Base64.encodeToString(r4, r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = java.lang.String.valueOf(r1);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = r4.length();	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = r4 + 2;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = java.lang.String.valueOf(r3);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = r5.length();	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = r4 + r5;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = java.lang.String.valueOf(r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = r5.length();	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = r4 + r5;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r1 = "\u0000";	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r1 = "\u0000";	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.append(r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r1 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r0.recycle();
        return r1;
    L_0x0060:
        r1 = move-exception;
        goto L_0x006d;
    L_0x0062:
        r1 = "QueueSeed encode failed because UTF-8 is not available.";	 Catch:{ all -> 0x0060 }
        com.google.android.gms.internal.ads.mt.m19920c(r1);	 Catch:{ all -> 0x0060 }
        r0.recycle();
        r0 = "";
        return r0;
    L_0x006d:
        r0.recycle();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.azk.a():java.lang.String");
    }
}

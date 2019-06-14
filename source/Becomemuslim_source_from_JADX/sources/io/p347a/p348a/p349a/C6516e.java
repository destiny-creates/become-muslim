package io.p347a.p348a.p349a;

import android.text.TextUtils;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: FabricKitsFinder */
/* renamed from: io.a.a.a.e */
class C6516e implements Callable<Map<String, C6522k>> {
    /* renamed from: a */
    final String f21015a;

    public /* synthetic */ Object call() {
        return m26649a();
    }

    C6516e(String str) {
        this.f21015a = str;
    }

    /* renamed from: a */
    public java.util.Map<java.lang.String, io.p347a.p348a.p349a.C6522k> m26649a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r13 = this;
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = android.os.SystemClock.elapsedRealtime();
        r3 = r13.m26650b();
        r4 = r3.entries();
        r5 = 0;
        r6 = 0;
    L_0x0013:
        r7 = r4.hasMoreElements();
        if (r7 == 0) goto L_0x006a;
    L_0x0019:
        r6 = r6 + 1;
        r7 = r4.nextElement();
        r7 = (java.util.zip.ZipEntry) r7;
        r8 = r7.getName();
        r9 = "fabric/";
        r8 = r8.startsWith(r9);
        if (r8 == 0) goto L_0x0013;
    L_0x002d:
        r8 = r7.getName();
        r8 = r8.length();
        r9 = "fabric/";
        r9 = r9.length();
        if (r8 <= r9) goto L_0x0013;
    L_0x003d:
        r7 = r13.m26648a(r7, r3);
        if (r7 == 0) goto L_0x0013;
    L_0x0043:
        r8 = r7.m26669a();
        r0.put(r8, r7);
        r8 = io.p347a.p348a.p349a.C6514c.m26634h();
        r9 = "Fabric";
        r10 = "Found kit:[%s] version:[%s]";
        r11 = 2;
        r11 = new java.lang.Object[r11];
        r12 = r7.m26669a();
        r11[r5] = r12;
        r7 = r7.m26670b();
        r12 = 1;
        r11[r12] = r7;
        r7 = java.lang.String.format(r10, r11);
        r8.mo5475b(r9, r7);
        goto L_0x0013;
    L_0x006a:
        if (r3 == 0) goto L_0x006f;
    L_0x006c:
        r3.close();	 Catch:{ IOException -> 0x006f }
    L_0x006f:
        r3 = io.p347a.p348a.p349a.C6514c.m26634h();
        r4 = "Fabric";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r7 = "finish scanning in ";
        r5.append(r7);
        r7 = android.os.SystemClock.elapsedRealtime();
        r7 = r7 - r1;
        r5.append(r7);
        r1 = " reading:";
        r5.append(r1);
        r5.append(r6);
        r1 = r5.toString();
        r3.mo5475b(r4, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.e.a():java.util.Map<java.lang.String, io.a.a.a.k>");
    }

    /* renamed from: a */
    private C6522k m26648a(ZipEntry zipEntry, ZipFile zipFile) {
        Throwable e;
        StringBuilder stringBuilder;
        Closeable inputStream;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                Object property = properties.getProperty("fabric-identifier");
                Object property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Invalid format of fabric file,");
                    stringBuilder2.append(zipEntry.getName());
                    throw new IllegalStateException(stringBuilder2.toString());
                }
                C6522k c6522k = new C6522k(property, property2, property3);
                C6428i.m26366a(inputStream);
                return c6522k;
            } catch (IOException e2) {
                e = e2;
                try {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error when parsing fabric properties ");
                    stringBuilder.append(zipEntry.getName());
                    C6514c.m26634h().mo5480e("Fabric", stringBuilder.toString(), e);
                    C6428i.m26366a(inputStream);
                    return null;
                } catch (Throwable th) {
                    zipEntry = th;
                    C6428i.m26366a(inputStream);
                    throw zipEntry;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error when parsing fabric properties ");
            stringBuilder.append(zipEntry.getName());
            C6514c.m26634h().mo5480e("Fabric", stringBuilder.toString(), e);
            C6428i.m26366a(inputStream);
            return null;
        } catch (Throwable th2) {
            zipEntry = th2;
            inputStream = null;
            C6428i.m26366a(inputStream);
            throw zipEntry;
        }
    }

    /* renamed from: b */
    protected ZipFile m26650b() {
        return new ZipFile(this.f21015a);
    }
}

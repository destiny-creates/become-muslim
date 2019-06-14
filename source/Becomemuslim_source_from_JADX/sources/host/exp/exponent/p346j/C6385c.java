package host.exp.exponent.p346j;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/* compiled from: ExpFileUtils */
/* renamed from: host.exp.exponent.j.c */
public class C6385c {
    /* renamed from: a */
    public static Uri m26193a(File file) {
        return Uri.fromFile(file);
    }

    /* renamed from: b */
    public static android.net.Uri m26195b(java.io.File r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = host.exp.p333a.C6271b.m25897a();	 Catch:{ Exception -> 0x002a }
        r0 = r0.m25924d();	 Catch:{ Exception -> 0x002a }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x002a }
        r1.<init>();	 Catch:{ Exception -> 0x002a }
        r2 = host.exp.p333a.C6271b.m25897a();	 Catch:{ Exception -> 0x002a }
        r2 = r2.m25924d();	 Catch:{ Exception -> 0x002a }
        r2 = r2.getPackageName();	 Catch:{ Exception -> 0x002a }
        r1.append(r2);	 Catch:{ Exception -> 0x002a }
        r2 = ".provider";	 Catch:{ Exception -> 0x002a }
        r1.append(r2);	 Catch:{ Exception -> 0x002a }
        r1 = r1.toString();	 Catch:{ Exception -> 0x002a }
        r0 = android.support.v4.content.FileProvider.a(r0, r1, r3);	 Catch:{ Exception -> 0x002a }
        return r0;
    L_0x002a:
        r3 = android.net.Uri.fromFile(r3);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.j.c.b(java.io.File):android.net.Uri");
    }

    /* renamed from: c */
    public static File m26196c(File file) {
        if (!file.isDirectory()) {
            if (!file.mkdirs()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't create directory '");
                stringBuilder.append(file);
                stringBuilder.append("'");
                throw new IOException(stringBuilder.toString());
            }
        }
        return file;
    }

    /* renamed from: a */
    public static String m26194a(File file, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file);
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        File file2 = new File(stringBuilder.toString());
        C6385c.m26196c(file2);
        file = UUID.randomUUID().toString();
        str = new StringBuilder();
        str.append(file2);
        str.append(File.separator);
        str.append(file);
        str.append(str2);
        return str.toString();
    }
}

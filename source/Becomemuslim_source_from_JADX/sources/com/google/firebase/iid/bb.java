package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.C0366b;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.internal.p207f.C4966c;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

final class bb {
    bb() {
    }

    /* renamed from: a */
    final bc m22749a(Context context, String str) {
        bc c = m22746c(context, str);
        if (c != null) {
            return c;
        }
        return m22750b(context, str);
    }

    /* renamed from: b */
    final bc m22750b(Context context, String str) {
        bc bcVar = new bc(C5354c.m22757a(), System.currentTimeMillis());
        bc a = m22734a(context, str, bcVar, true);
        if (a == null || a.equals(bcVar)) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Generated new key");
            }
            m22740a(context, str, bcVar);
            return bcVar;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3) != null) {
            Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
        }
        return a;
    }

    /* renamed from: a */
    static void m22739a(Context context) {
        for (File file : m22745b(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    /* renamed from: c */
    private final bc m22746c(Context context, String str) {
        C5355d c5355d;
        try {
            bc d = m22747d(context, str);
            if (d != null) {
                m22740a(context, str, d);
                return d;
            }
            c5355d = null;
            try {
                bc a = m22735a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (a != null) {
                    m22734a(context, str, a, false);
                    return a;
                }
            } catch (Context context2) {
                c5355d = context2;
            }
            if (c5355d == null) {
                return null;
            }
            throw c5355d;
        } catch (C5355d e) {
            c5355d = e;
        }
    }

    /* renamed from: a */
    private static KeyPair m22738a(String str, String str2) {
        try {
            str = Base64.decode(str, 8);
            str2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(str)), instance.generatePrivate(new PKCS8EncodedKeySpec(str2)));
            } catch (Exception e) {
                str2 = String.valueOf(e);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 19);
                stringBuilder.append("Invalid key stored ");
                stringBuilder.append(str2);
                Log.w("FirebaseInstanceId", stringBuilder.toString());
                throw new C5355d(e);
            }
        } catch (Exception e2) {
            throw new C5355d(e2);
        }
    }

    /* renamed from: d */
    private final bc m22747d(Context context, String str) {
        File e = m22748e(context, str);
        if (e.exists() == null) {
            return null;
        }
        try {
            return m22736a(e);
        } catch (String str2) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                str2 = String.valueOf(str2);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 40);
                stringBuilder.append("Failed to read key from file, retrying: ");
                stringBuilder.append(str2);
                Log.d("FirebaseInstanceId", stringBuilder.toString());
            }
            try {
                return m22736a(e);
            } catch (Exception e2) {
                str2 = String.valueOf(e2);
                StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str2).length() + 45);
                stringBuilder2.append("IID file exists, but failed to read from it: ");
                stringBuilder2.append(str2);
                Log.w("FirebaseInstanceId", stringBuilder2.toString());
                throw new C5355d(e2);
            }
        }
    }

    /* renamed from: a */
    private final bc m22734a(Context context, String str, bc bcVar, boolean z) {
        bc bcVar2;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to properties file");
        }
        Properties properties = new Properties();
        properties.setProperty("pub", bcVar.m22752b());
        properties.setProperty("pri", bcVar.m22755c());
        properties.setProperty("cre", String.valueOf(bcVar.f18093b));
        context = m22748e(context, str);
        try {
            context.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(context, "rw");
            Throwable th;
            try {
                Throwable th2;
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    channel.lock();
                    if (z && channel.size() > 0) {
                        try {
                            channel.position(0);
                            z = m22737a(channel);
                            if (channel != null) {
                                m22743a(null, channel);
                            }
                            m22742a(null, randomAccessFile);
                            return z;
                        } catch (boolean z2) {
                            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                                z2 = String.valueOf(z2);
                                StringBuilder stringBuilder = new StringBuilder(String.valueOf(z2).length() + 64);
                                stringBuilder.append("Tried reading key pair before writing new one, but failed with: ");
                                stringBuilder.append(z2);
                                Log.d("FirebaseInstanceId", stringBuilder.toString());
                            }
                        }
                    }
                    channel.position(0);
                    properties.store(Channels.newOutputStream(channel), null);
                    if (channel != null) {
                        m22743a(null, channel);
                    }
                    m22742a(null, randomAccessFile);
                    return bcVar;
                } catch (boolean z22) {
                    bcVar2 = z22;
                    th2 = bcVar;
                    bcVar = bcVar2;
                }
                m22742a(th, randomAccessFile);
                throw context;
                if (channel != null) {
                    m22743a(th2, channel);
                }
                throw bcVar;
            } catch (bc bcVar3) {
                bcVar2 = bcVar3;
                th = context;
                context = bcVar2;
            }
        } catch (Context context2) {
            context2 = String.valueOf(context2);
            StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(context2).length() + 21);
            stringBuilder2.append("Failed to write key: ");
            stringBuilder2.append(context2);
            Log.w("FirebaseInstanceId", stringBuilder2.toString());
            return null;
        }
    }

    /* renamed from: b */
    private static File m22745b(Context context) {
        File b = C0366b.b(context);
        if (b != null && b.isDirectory()) {
            return b;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    /* renamed from: e */
    private static File m22748e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "com.google.InstanceId.properties";
        } else {
            try {
                str = Base64.encodeToString(str.getBytes(Utf8Charset.NAME), 11);
                StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 33);
                stringBuilder.append("com.google.InstanceId_");
                stringBuilder.append(str);
                stringBuilder.append(".properties");
                str = stringBuilder.toString();
            } catch (Context context2) {
                throw new AssertionError(context2);
            }
        }
        return new File(m22745b(context2), str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final com.google.firebase.iid.bc m22736a(java.io.File r10) {
        /*
        r9 = this;
        r0 = new java.io.FileInputStream;
        r0.<init>(r10);
        r10 = 0;
        r7 = r0.getChannel();	 Catch:{ Throwable -> 0x0034 }
        r2 = 0;
        r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r6 = 1;
        r1 = r7;
        r1.lock(r2, r4, r6);	 Catch:{ Throwable -> 0x0026, all -> 0x0023 }
        r1 = m22737a(r7);	 Catch:{ Throwable -> 0x0026, all -> 0x0023 }
        if (r7 == 0) goto L_0x001f;
    L_0x001c:
        m22743a(r10, r7);	 Catch:{ Throwable -> 0x0034 }
    L_0x001f:
        m22741a(r10, r0);
        return r1;
    L_0x0023:
        r1 = move-exception;
        r2 = r10;
        goto L_0x002c;
    L_0x0026:
        r1 = move-exception;
        throw r1;	 Catch:{ all -> 0x0028 }
    L_0x0028:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x002c:
        if (r7 == 0) goto L_0x0031;
    L_0x002e:
        m22743a(r2, r7);	 Catch:{ Throwable -> 0x0034 }
    L_0x0031:
        throw r1;	 Catch:{ Throwable -> 0x0034 }
    L_0x0032:
        r1 = move-exception;
        goto L_0x0036;
    L_0x0034:
        r10 = move-exception;
        throw r10;	 Catch:{ all -> 0x0032 }
    L_0x0036:
        m22741a(r10, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.bb.a(java.io.File):com.google.firebase.iid.bc");
    }

    /* renamed from: a */
    private static bc m22737a(FileChannel fileChannel) {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        String property = properties.getProperty("pub");
        String property2 = properties.getProperty("pri");
        if (property == null || property2 == null) {
            throw new C5355d("Invalid properties file");
        }
        try {
            return new bc(m22738a(property, property2), Long.parseLong(properties.getProperty("cre")));
        } catch (Exception e) {
            throw new C5355d(e);
        }
    }

    /* renamed from: a */
    private static bc m22735a(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(C5371z.m22805a(str, "|P|"), null);
        String string2 = sharedPreferences.getString(C5371z.m22805a(str, "|K|"), null);
        if (string != null) {
            if (string2 != null) {
                return new bc(m22738a(string, string2), m22744b(sharedPreferences, str));
            }
        }
        return null;
    }

    /* renamed from: a */
    private final void m22740a(android.content.Context r3, java.lang.String r4, com.google.firebase.iid.bc r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = "com.google.android.gms.appid";
        r1 = 0;
        r3 = r3.getSharedPreferences(r0, r1);
        r0 = m22735a(r3, r4);	 Catch:{ d -> 0x0012 }
        r0 = r5.equals(r0);	 Catch:{ d -> 0x0012 }
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        return;
    L_0x0012:
        r0 = "FirebaseInstanceId";
        r1 = 3;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0022;
    L_0x001b:
        r0 = "FirebaseInstanceId";
        r1 = "Writing key to shared preferences";
        android.util.Log.d(r0, r1);
    L_0x0022:
        r3 = r3.edit();
        r0 = "|P|";
        r0 = com.google.firebase.iid.C5371z.m22805a(r4, r0);
        r1 = r5.m22752b();
        r3.putString(r0, r1);
        r0 = "|K|";
        r0 = com.google.firebase.iid.C5371z.m22805a(r4, r0);
        r1 = r5.m22755c();
        r3.putString(r0, r1);
        r0 = "cre";
        r4 = com.google.firebase.iid.C5371z.m22805a(r4, r0);
        r0 = r5.f18093b;
        r5 = java.lang.String.valueOf(r0);
        r3.putString(r4, r5);
        r3.commit();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.bb.a(android.content.Context, java.lang.String, com.google.firebase.iid.bc):void");
    }

    /* renamed from: b */
    private static long m22744b(android.content.SharedPreferences r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "cre";
        r2 = com.google.firebase.iid.C5371z.m22805a(r2, r0);
        r0 = 0;
        r1 = r1.getString(r2, r0);
        if (r1 == 0) goto L_0x0012;
    L_0x000d:
        r1 = java.lang.Long.parseLong(r1);	 Catch:{ NumberFormatException -> 0x0012 }
        return r1;
    L_0x0012:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.bb.b(android.content.SharedPreferences, java.lang.String):long");
    }

    /* renamed from: a */
    private static /* synthetic */ void m22743a(Throwable th, FileChannel fileChannel) {
        if (th != null) {
            try {
                fileChannel.close();
                return;
            } catch (FileChannel fileChannel2) {
                C4966c.m20245a(th, fileChannel2);
                return;
            }
        }
        fileChannel2.close();
    }

    /* renamed from: a */
    private static /* synthetic */ void m22742a(Throwable th, RandomAccessFile randomAccessFile) {
        if (th != null) {
            try {
                randomAccessFile.close();
                return;
            } catch (RandomAccessFile randomAccessFile2) {
                C4966c.m20245a(th, randomAccessFile2);
                return;
            }
        }
        randomAccessFile2.close();
    }

    /* renamed from: a */
    private static /* synthetic */ void m22741a(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
                return;
            } catch (FileInputStream fileInputStream2) {
                C4966c.m20245a(th, fileInputStream2);
                return;
            }
        }
        fileInputStream2.close();
    }
}

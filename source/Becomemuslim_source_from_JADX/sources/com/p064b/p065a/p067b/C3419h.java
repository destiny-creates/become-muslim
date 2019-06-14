package com.p064b.p065a.p067b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p351a.C6416d;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: DeviceTokenLoader */
/* renamed from: com.b.a.b.h */
public class C3419h implements C6416d<String> {
    /* renamed from: c */
    public /* synthetic */ Object m10918c(Context context) {
        return m10915a(context);
    }

    /* renamed from: a */
    public String m10915a(Context context) {
        double nanoTime;
        StringBuilder stringBuilder;
        Throwable th;
        long nanoTime2 = System.nanoTime();
        String str = "";
        ZipInputStream zipInputStream = null;
        try {
            ZipInputStream b = m10917b(context);
            try {
                String a = m10916a(b);
                if (b != null) {
                    try {
                        b.close();
                    } catch (Context context2) {
                        C6514c.h().e("Beta", "Failed to close the APK file", context2);
                    }
                }
                str = a;
            } catch (NameNotFoundException e) {
                NameNotFoundException nameNotFoundException = e;
                zipInputStream = b;
                context2 = nameNotFoundException;
                C6514c.h().e("Beta", "Failed to find this app in the PackageManager", context2);
                if (zipInputStream != null) {
                    zipInputStream.close();
                }
                nanoTime = ((double) (System.nanoTime() - nanoTime2)) / 1000000.0d;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Beta device token load took ");
                stringBuilder.append(nanoTime);
                stringBuilder.append("ms");
                C6514c.h().a("Beta", stringBuilder.toString());
                return str;
            } catch (FileNotFoundException e2) {
                FileNotFoundException fileNotFoundException = e2;
                zipInputStream = b;
                context2 = fileNotFoundException;
                C6514c.h().e("Beta", "Failed to find the APK file", context2);
                if (zipInputStream != null) {
                    zipInputStream.close();
                }
                nanoTime = ((double) (System.nanoTime() - nanoTime2)) / 1000000.0d;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Beta device token load took ");
                stringBuilder.append(nanoTime);
                stringBuilder.append("ms");
                C6514c.h().a("Beta", stringBuilder.toString());
                return str;
            } catch (IOException e3) {
                IOException iOException = e3;
                zipInputStream = b;
                context2 = iOException;
                try {
                    C6514c.h().e("Beta", "Failed to read the APK file", context2);
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (Context context22) {
                            C6514c.h().e("Beta", "Failed to close the APK file", context22);
                        }
                    }
                    nanoTime = ((double) (System.nanoTime() - nanoTime2)) / 1000000.0d;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Beta device token load took ");
                    stringBuilder.append(nanoTime);
                    stringBuilder.append("ms");
                    C6514c.h().a("Beta", stringBuilder.toString());
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (Context context222) {
                            C6514c.h().e("Beta", "Failed to close the APK file", context222);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zipInputStream = b;
                if (zipInputStream != null) {
                    zipInputStream.close();
                }
                throw th;
            }
        } catch (NameNotFoundException e4) {
            context222 = e4;
            C6514c.h().e("Beta", "Failed to find this app in the PackageManager", context222);
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            nanoTime = ((double) (System.nanoTime() - nanoTime2)) / 1000000.0d;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Beta device token load took ");
            stringBuilder.append(nanoTime);
            stringBuilder.append("ms");
            C6514c.h().a("Beta", stringBuilder.toString());
            return str;
        } catch (FileNotFoundException e5) {
            context222 = e5;
            C6514c.h().e("Beta", "Failed to find the APK file", context222);
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            nanoTime = ((double) (System.nanoTime() - nanoTime2)) / 1000000.0d;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Beta device token load took ");
            stringBuilder.append(nanoTime);
            stringBuilder.append("ms");
            C6514c.h().a("Beta", stringBuilder.toString());
            return str;
        } catch (IOException e6) {
            context222 = e6;
            C6514c.h().e("Beta", "Failed to read the APK file", context222);
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            nanoTime = ((double) (System.nanoTime() - nanoTime2)) / 1000000.0d;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Beta device token load took ");
            stringBuilder.append(nanoTime);
            stringBuilder.append("ms");
            C6514c.h().a("Beta", stringBuilder.toString());
            return str;
        }
        nanoTime = ((double) (System.nanoTime() - nanoTime2)) / 1000000.0d;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Beta device token load took ");
        stringBuilder.append(nanoTime);
        stringBuilder.append("ms");
        C6514c.h().a("Beta", stringBuilder.toString());
        return str;
    }

    /* renamed from: b */
    ZipInputStream m10917b(Context context) {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir));
    }

    /* renamed from: a */
    String m10916a(ZipInputStream zipInputStream) {
        String name;
        do {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return "";
            }
            name = nextEntry.getName();
        } while (!name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token="));
        return name.substring("assets/com.crashlytics.android.beta/dirfactor-device-token=".length(), name.length() - 1);
    }
}

package com.facebook.soloader;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public final class SysUtil {
    private static final byte APK_SIGNATURE_VERSION = (byte) 1;

    private static final class LollipopSysdeps {
        private LollipopSysdeps() {
        }

        @DoNotOptimize
        public static String[] getSupportedAbis() {
            return Build.SUPPORTED_ABIS;
        }

        @DoNotOptimize
        public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j) {
            try {
                Os.posix_fallocate(fileDescriptor, 0, j);
            } catch (FileDescriptor fileDescriptor2) {
                if (fileDescriptor2.errno != OsConstants.EOPNOTSUPP && fileDescriptor2.errno != OsConstants.ENOSYS) {
                    if (fileDescriptor2.errno != OsConstants.EINVAL) {
                        throw new IOException(fileDescriptor2.toString(), fileDescriptor2);
                    }
                }
            }
        }
    }

    public static int findAbiScore(String[] strArr, String str) {
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i] != null && str.equals(strArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void deleteOrThrow(File file) {
        if (!file.delete()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("could not delete file ");
            stringBuilder.append(file);
            throw new IOException(stringBuilder.toString());
        }
    }

    public static String[] getSupportedAbis() {
        if (VERSION.SDK_INT >= 21) {
            return LollipopSysdeps.getSupportedAbis();
        }
        return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j) {
        if (VERSION.SDK_INT >= 21) {
            LollipopSysdeps.fallocateIfSupported(fileDescriptor, j);
        }
    }

    public static void dumbDeleteRecursive(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File dumbDeleteRecursive : listFiles) {
                    dumbDeleteRecursive(dumbDeleteRecursive);
                }
            } else {
                return;
            }
        }
        if (!file.delete()) {
            if (file.exists()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("could not delete: ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
        }
    }

    static void mkdirOrThrow(File file) {
        if (!file.mkdirs()) {
            if (!file.isDirectory()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("cannot mkdir: ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
        }
    }

    static int copyBytes(RandomAccessFile randomAccessFile, InputStream inputStream, int i, byte[] bArr) {
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, 0, Math.min(bArr.length, i - i2));
            if (read == -1) {
                break;
            }
            randomAccessFile.write(bArr, 0, read);
            i2 += read;
        }
        return i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void fsyncRecursive(java.io.File r3) {
        /*
        r0 = r3.isDirectory();
        if (r0 == 0) goto L_0x002f;
    L_0x0006:
        r0 = r3.listFiles();
        if (r0 == 0) goto L_0x0018;
    L_0x000c:
        r3 = 0;
    L_0x000d:
        r1 = r0.length;
        if (r3 >= r1) goto L_0x004e;
    L_0x0010:
        r1 = r0[r3];
        fsyncRecursive(r1);
        r3 = r3 + 1;
        goto L_0x000d;
    L_0x0018:
        r0 = new java.io.IOException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "cannot list directory ";
        r1.append(r2);
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
    L_0x002f:
        r0 = r3.getPath();
        r1 = "_lock";
        r0 = r0.endsWith(r1);
        if (r0 == 0) goto L_0x003c;
    L_0x003b:
        goto L_0x004e;
    L_0x003c:
        r0 = new java.io.RandomAccessFile;
        r1 = "r";
        r0.<init>(r3, r1);
        r3 = 0;
        r1 = r0.getFD();	 Catch:{ Throwable -> 0x0051 }
        r1.sync();	 Catch:{ Throwable -> 0x0051 }
        r0.close();
    L_0x004e:
        return;
    L_0x004f:
        r1 = move-exception;
        goto L_0x0053;
    L_0x0051:
        r3 = move-exception;
        throw r3;	 Catch:{ all -> 0x004f }
    L_0x0053:
        if (r3 == 0) goto L_0x005e;
    L_0x0055:
        r0.close();	 Catch:{ Throwable -> 0x0059 }
        goto L_0x0061;
    L_0x0059:
        r0 = move-exception;
        r3.addSuppressed(r0);
        goto L_0x0061;
    L_0x005e:
        r0.close();
    L_0x0061:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SysUtil.fsyncRecursive(java.io.File):void");
    }

    public static byte[] makeApkDepBlock(File file, Context context) {
        file = file.getCanonicalFile();
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeByte((byte) 1);
            obtain.writeString(file.getPath());
            obtain.writeLong(file.lastModified());
            obtain.writeInt(getAppVersionCode(context));
            file = obtain.marshall();
            return file;
        } finally {
            obtain.recycle();
        }
    }

    public static int getAppVersionCode(android.content.Context r2) {
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
        r0 = r2.getPackageManager();
        r1 = 0;
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0012, NameNotFoundException -> 0x0012 }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0012, NameNotFoundException -> 0x0012 }
        r2 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x0012, NameNotFoundException -> 0x0012 }
        return r2;
    L_0x0012:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SysUtil.getAppVersionCode(android.content.Context):int");
    }
}

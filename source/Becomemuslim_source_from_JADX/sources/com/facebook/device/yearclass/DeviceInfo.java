package com.facebook.device.yearclass;

import java.io.File;
import java.io.FileFilter;

public class DeviceInfo {
    private static final FileFilter CPU_FILTER = new C17411();
    public static final int DEVICEINFO_UNKNOWN = -1;

    /* renamed from: com.facebook.device.yearclass.DeviceInfo$1 */
    static class C17411 implements FileFilter {
        C17411() {
        }

        public boolean accept(File file) {
            file = file.getName();
            if (!file.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < file.length(); i++) {
                if (!Character.isDigit(file.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static int getNumberOfCPUCores() {
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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 10;
        if (r0 > r1) goto L_0x0008;
    L_0x0006:
        r0 = 1;
        return r0;
    L_0x0008:
        r0 = -1;
        r1 = "/sys/devices/system/cpu/possible";	 Catch:{ SecurityException -> 0x001e, SecurityException -> 0x001e }
        r1 = getCoresFromFileInfo(r1);	 Catch:{ SecurityException -> 0x001e, SecurityException -> 0x001e }
        if (r1 != r0) goto L_0x0017;	 Catch:{ SecurityException -> 0x001e, SecurityException -> 0x001e }
    L_0x0011:
        r1 = "/sys/devices/system/cpu/present";	 Catch:{ SecurityException -> 0x001e, SecurityException -> 0x001e }
        r1 = getCoresFromFileInfo(r1);	 Catch:{ SecurityException -> 0x001e, SecurityException -> 0x001e }
    L_0x0017:
        if (r1 != r0) goto L_0x001d;	 Catch:{ SecurityException -> 0x001e, SecurityException -> 0x001e }
    L_0x0019:
        r1 = getCoresFromCPUFileList();	 Catch:{ SecurityException -> 0x001e, SecurityException -> 0x001e }
    L_0x001d:
        r0 = r1;
    L_0x001e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.yearclass.DeviceInfo.getNumberOfCPUCores():int");
    }

    private static int getCoresFromFileInfo(java.lang.String r2) {
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
        r0 = 0;
        r1 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x002b, all -> 0x0023 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x002b, all -> 0x0023 }
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0021, all -> 0x001f }
        r0 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0021, all -> 0x001f }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0021, all -> 0x001f }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0021, all -> 0x001f }
        r0 = r2.readLine();	 Catch:{ IOException -> 0x0021, all -> 0x001f }
        r2.close();	 Catch:{ IOException -> 0x0021, all -> 0x001f }
        r2 = getCoresFromFileString(r0);	 Catch:{ IOException -> 0x0021, all -> 0x001f }
        r1.close();	 Catch:{ IOException -> 0x001e }
    L_0x001e:
        return r2;
    L_0x001f:
        r2 = move-exception;
        goto L_0x0025;
        goto L_0x002c;
    L_0x0023:
        r2 = move-exception;
        r1 = r0;
    L_0x0025:
        if (r1 == 0) goto L_0x002a;
    L_0x0027:
        r1.close();	 Catch:{ IOException -> 0x002a }
    L_0x002a:
        throw r2;
    L_0x002b:
        r1 = r0;
    L_0x002c:
        r2 = -1;
        if (r1 == 0) goto L_0x0032;
    L_0x002f:
        r1.close();	 Catch:{ IOException -> 0x0032 }
    L_0x0032:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.yearclass.DeviceInfo.getCoresFromFileInfo(java.lang.String):int");
    }

    static int getCoresFromFileString(String str) {
        if (str != null) {
            if (str.matches("0-[\\d]+$")) {
                return Integer.valueOf(str.substring(2)).intValue() + 1;
            }
        }
        return -1;
    }

    private static int getCoresFromCPUFileList() {
        return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
    }

    public static int getCPUMaxFreqKHz() {
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
        r0 = 0;
        r1 = -1;
        r2 = 0;
        r3 = -1;
    L_0x0004:
        r4 = getNumberOfCPUCores();	 Catch:{ IOException -> 0x0090 }
        if (r2 >= r4) goto L_0x0070;	 Catch:{ IOException -> 0x0090 }
    L_0x000a:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0090 }
        r4.<init>();	 Catch:{ IOException -> 0x0090 }
        r5 = "/sys/devices/system/cpu/cpu";	 Catch:{ IOException -> 0x0090 }
        r4.append(r5);	 Catch:{ IOException -> 0x0090 }
        r4.append(r2);	 Catch:{ IOException -> 0x0090 }
        r5 = "/cpufreq/cpuinfo_max_freq";	 Catch:{ IOException -> 0x0090 }
        r4.append(r5);	 Catch:{ IOException -> 0x0090 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0090 }
        r5 = new java.io.File;	 Catch:{ IOException -> 0x0090 }
        r5.<init>(r4);	 Catch:{ IOException -> 0x0090 }
        r4 = r5.exists();	 Catch:{ IOException -> 0x0090 }
        if (r4 == 0) goto L_0x006d;	 Catch:{ IOException -> 0x0090 }
    L_0x002b:
        r4 = r5.canRead();	 Catch:{ IOException -> 0x0090 }
        if (r4 == 0) goto L_0x006d;	 Catch:{ IOException -> 0x0090 }
    L_0x0031:
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ IOException -> 0x0090 }
        r4 = new byte[r4];	 Catch:{ IOException -> 0x0090 }
        r6 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0090 }
        r6.<init>(r5);	 Catch:{ IOException -> 0x0090 }
        r6.read(r4);	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
        r5 = 0;	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
    L_0x003e:
        r7 = r4[r5];	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
        r7 = java.lang.Character.isDigit(r7);	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
        if (r7 == 0) goto L_0x004c;	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
    L_0x0046:
        r7 = r4.length;	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
        if (r5 >= r7) goto L_0x004c;	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
    L_0x0049:
        r5 = r5 + 1;	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
        goto L_0x003e;	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
    L_0x004c:
        r7 = new java.lang.String;	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
        r7.<init>(r4, r0, r5);	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
        r4 = java.lang.Integer.parseInt(r7);	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
        r5 = r4.intValue();	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
        if (r5 <= r3) goto L_0x0064;	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
    L_0x005f:
        r4 = r4.intValue();	 Catch:{ NumberFormatException -> 0x0064, all -> 0x0068 }
        r3 = r4;
    L_0x0064:
        r6.close();	 Catch:{ IOException -> 0x0090 }
        goto L_0x006d;	 Catch:{ IOException -> 0x0090 }
    L_0x0068:
        r0 = move-exception;	 Catch:{ IOException -> 0x0090 }
        r6.close();	 Catch:{ IOException -> 0x0090 }
        throw r0;	 Catch:{ IOException -> 0x0090 }
    L_0x006d:
        r2 = r2 + 1;	 Catch:{ IOException -> 0x0090 }
        goto L_0x0004;	 Catch:{ IOException -> 0x0090 }
    L_0x0070:
        if (r3 != r1) goto L_0x008f;	 Catch:{ IOException -> 0x0090 }
    L_0x0072:
        r0 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0090 }
        r2 = "/proc/cpuinfo";	 Catch:{ IOException -> 0x0090 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x0090 }
        r2 = "cpu MHz";	 Catch:{ all -> 0x008a }
        r2 = parseFileForValue(r2, r0);	 Catch:{ all -> 0x008a }
        r2 = r2 * 1000;
        if (r2 <= r3) goto L_0x0084;
    L_0x0083:
        goto L_0x0085;
    L_0x0084:
        r2 = r3;
    L_0x0085:
        r0.close();	 Catch:{ IOException -> 0x0090 }
        r1 = r2;	 Catch:{ IOException -> 0x0090 }
        goto L_0x0090;	 Catch:{ IOException -> 0x0090 }
    L_0x008a:
        r2 = move-exception;	 Catch:{ IOException -> 0x0090 }
        r0.close();	 Catch:{ IOException -> 0x0090 }
        throw r2;	 Catch:{ IOException -> 0x0090 }
    L_0x008f:
        r1 = r3;
    L_0x0090:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.yearclass.DeviceInfo.getCPUMaxFreqKHz():int");
    }

    @android.annotation.TargetApi(16)
    public static long getTotalMemory(android.content.Context r4) {
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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x0019;
    L_0x0006:
        r0 = new android.app.ActivityManager$MemoryInfo;
        r0.<init>();
        r1 = "activity";
        r4 = r4.getSystemService(r1);
        r4 = (android.app.ActivityManager) r4;
        r4.getMemoryInfo(r0);
        r0 = r0.totalMem;
        return r0;
    L_0x0019:
        r0 = -1;
        r4 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0036 }
        r2 = "/proc/meminfo";	 Catch:{ IOException -> 0x0036 }
        r4.<init>(r2);	 Catch:{ IOException -> 0x0036 }
        r2 = "MemTotal";	 Catch:{ all -> 0x0031 }
        r2 = parseFileForValue(r2, r4);	 Catch:{ all -> 0x0031 }
        r0 = (long) r2;
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = r0 * r2;
        r4.close();	 Catch:{ IOException -> 0x0036 }
        goto L_0x0036;	 Catch:{ IOException -> 0x0036 }
    L_0x0031:
        r2 = move-exception;	 Catch:{ IOException -> 0x0036 }
        r4.close();	 Catch:{ IOException -> 0x0036 }
        throw r2;	 Catch:{ IOException -> 0x0036 }
    L_0x0036:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.yearclass.DeviceInfo.getTotalMemory(android.content.Context):long");
    }

    private static int parseFileForValue(java.lang.String r6, java.io.FileInputStream r7) {
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
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];
        r7 = r7.read(r0);	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
        r1 = 0;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
    L_0x0009:
        if (r1 >= r7) goto L_0x003a;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
    L_0x000b:
        r2 = r0[r1];	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
        r3 = 10;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
        if (r2 == r3) goto L_0x0013;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
    L_0x0011:
        if (r1 != 0) goto L_0x0037;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
    L_0x0013:
        r2 = r0[r1];	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
        if (r2 != r3) goto L_0x0019;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
    L_0x0017:
        r1 = r1 + 1;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
    L_0x0019:
        r2 = r1;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
    L_0x001a:
        if (r2 >= r7) goto L_0x0037;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
    L_0x001c:
        r3 = r2 - r1;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
        r4 = r0[r2];	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
        r5 = r6.charAt(r3);	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
        if (r4 == r5) goto L_0x0027;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
    L_0x0026:
        goto L_0x0037;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
    L_0x0027:
        r4 = r6.length();	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
        r4 = r4 + -1;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
        if (r3 != r4) goto L_0x0034;	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
    L_0x002f:
        r6 = extractValue(r0, r2);	 Catch:{ IOException -> 0x003a, IOException -> 0x003a }
        return r6;
    L_0x0034:
        r2 = r2 + 1;
        goto L_0x001a;
    L_0x0037:
        r1 = r1 + 1;
        goto L_0x0009;
    L_0x003a:
        r6 = -1;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.yearclass.DeviceInfo.parseFileForValue(java.lang.String, java.io.FileInputStream):int");
    }

    private static int extractValue(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != (byte) 10) {
            if (Character.isDigit(bArr[i])) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }
}

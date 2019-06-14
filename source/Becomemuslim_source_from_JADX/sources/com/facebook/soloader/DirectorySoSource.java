package com.facebook.soloader;

import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;

public class DirectorySoSource extends SoSource {
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    protected final int flags;
    protected final File soDirectory;

    public DirectorySoSource(File file, int i) {
        this.soDirectory = file;
        this.flags = i;
    }

    public int loadLibrary(String str, int i, ThreadPolicy threadPolicy) {
        return loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
    }

    protected int loadLibraryFrom(String str, int i, File file, ThreadPolicy threadPolicy) {
        File file2 = new File(file, str);
        if (file2.exists()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" found on ");
            stringBuilder.append(file.getCanonicalPath());
            Log.d("SoLoader", stringBuilder.toString());
            if ((i & 1) == null || (this.flags & 2) == null) {
                if ((this.flags & 1) != null) {
                    loadDependencies(file2, i, threadPolicy);
                } else {
                    threadPolicy = new StringBuilder();
                    threadPolicy.append("Not resolving dependencies for ");
                    threadPolicy.append(str);
                    Log.d("SoLoader", threadPolicy.toString());
                }
                try {
                    SoLoader.sSoFileLoader.load(file2.getAbsolutePath(), i);
                    return 1;
                } catch (String str2) {
                    if (str2.getMessage().contains("bad ELF magic") != 0) {
                        Log.d("SoLoader", "Corrupted lib file detected");
                        return 3;
                    }
                    throw str2;
                }
            }
            file = new StringBuilder();
            file.append(str2);
            file.append(" loaded implicitly");
            Log.d("SoLoader", file.toString());
            return 2;
        }
        threadPolicy = new StringBuilder();
        threadPolicy.append(str2);
        threadPolicy.append(" not found on ");
        threadPolicy.append(file.getCanonicalPath());
        Log.d("SoLoader", threadPolicy.toString());
        return null;
    }

    private void loadDependencies(File file, int i, ThreadPolicy threadPolicy) {
        file = getDependencies(file);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Loading lib dependencies: ");
        stringBuilder.append(Arrays.toString(file));
        Log.d("SoLoader", stringBuilder.toString());
        for (String str : file) {
            if (!str.startsWith("/")) {
                SoLoader.loadLibraryBySoName(str, i | 1, threadPolicy);
            }
        }
    }

    private static String[] getDependencies(File file) {
        if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SoLoader.getElfDependencies[");
            stringBuilder.append(file.getName());
            stringBuilder.append("]");
            Api18TraceUtils.beginTraceSection(stringBuilder.toString());
        }
        try {
            file = MinElf.extract_DT_NEEDED(file);
            return file;
        } finally {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
        }
    }

    public File unpackLibrary(String str) {
        File file = new File(this.soDirectory, str);
        return file.exists() != null ? file : null;
    }

    public void addToLdLibraryPath(Collection<String> collection) {
        collection.add(this.soDirectory.getAbsolutePath());
    }

    public java.lang.String toString() {
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
        r3 = this;
        r0 = r3.soDirectory;	 Catch:{ IOException -> 0x000b }
        r0 = r0.getCanonicalPath();	 Catch:{ IOException -> 0x000b }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ IOException -> 0x000b }
        goto L_0x0011;
    L_0x000b:
        r0 = r3.soDirectory;
        r0 = r0.getName();
    L_0x0011:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r3.getClass();
        r2 = r2.getName();
        r1.append(r2);
        r2 = "[root = ";
        r1.append(r2);
        r1.append(r0);
        r0 = " flags = ";
        r1.append(r0);
        r0 = r3.flags;
        r1.append(r0);
        r0 = 93;
        r1.append(r0);
        r0 = r1.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.DirectorySoSource.toString():java.lang.String");
    }
}

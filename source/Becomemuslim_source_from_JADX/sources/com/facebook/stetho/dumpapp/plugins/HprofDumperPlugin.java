package com.facebook.stetho.dumpapp.plugins;

import android.content.Context;
import android.os.Debug;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class HprofDumperPlugin implements DumperPlugin {
    private static final String NAME = "hprof";
    private final Context mContext;

    public String getName() {
        return NAME;
    }

    public HprofDumperPlugin(Context context) {
        this.mContext = context;
    }

    public void dump(DumperContext dumperContext) {
        OutputStream stdout = dumperContext.getStdout();
        dumperContext = dumperContext.getArgsAsList().iterator();
        dumperContext = dumperContext.hasNext() ? (String) dumperContext.next() : null;
        if (dumperContext == null) {
            usage(stdout);
        } else if ("-".equals(dumperContext)) {
            handlePipeOutput(stdout);
        } else {
            File file = new File(dumperContext);
            if (!file.isAbsolute()) {
                file = this.mContext.getFileStreamPath(dumperContext);
            }
            writeHprof(file);
            dumperContext = new StringBuilder();
            dumperContext.append("Wrote to ");
            dumperContext.append(file);
            stdout.println(dumperContext.toString());
        }
    }

    private void handlePipeOutput(java.io.OutputStream r4) {
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
        r3 = this;
        r0 = r3.mContext;
        r1 = "hprof-dump.hprof";
        r0 = r0.getFileStreamPath(r1);
        r3.writeHprof(r0);	 Catch:{ all -> 0x0045 }
        r1 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0029 }
        r1.<init>(r0);	 Catch:{ IOException -> 0x0029 }
        r2 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r2 = new byte[r2];	 Catch:{ all -> 0x0024 }
        com.facebook.stetho.common.Util.copy(r1, r4, r2);	 Catch:{ all -> 0x0024 }
        r1.close();	 Catch:{ IOException -> 0x0029 }
        r4 = r0.exists();
        if (r4 == 0) goto L_0x0023;
    L_0x0020:
        r0.delete();
    L_0x0023:
        return;
    L_0x0024:
        r4 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0029 }
        throw r4;	 Catch:{ IOException -> 0x0029 }
    L_0x0029:
        r4 = new com.facebook.stetho.dumpapp.DumpException;	 Catch:{ all -> 0x0045 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0045 }
        r1.<init>();	 Catch:{ all -> 0x0045 }
        r2 = "Failure copying ";	 Catch:{ all -> 0x0045 }
        r1.append(r2);	 Catch:{ all -> 0x0045 }
        r1.append(r0);	 Catch:{ all -> 0x0045 }
        r2 = " to dumper output";	 Catch:{ all -> 0x0045 }
        r1.append(r2);	 Catch:{ all -> 0x0045 }
        r1 = r1.toString();	 Catch:{ all -> 0x0045 }
        r4.<init>(r1);	 Catch:{ all -> 0x0045 }
        throw r4;	 Catch:{ all -> 0x0045 }
    L_0x0045:
        r4 = move-exception;
        r1 = r0.exists();
        if (r1 == 0) goto L_0x004f;
    L_0x004c:
        r0.delete();
    L_0x004f:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.dumpapp.plugins.HprofDumperPlugin.handlePipeOutput(java.io.OutputStream):void");
    }

    private void writeHprof(File file) {
        try {
            truncateAndDeleteFile(file);
            Debug.dumpHprofData(file.getAbsolutePath());
        } catch (IOException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failure writing to ");
            stringBuilder.append(file);
            stringBuilder.append(": ");
            stringBuilder.append(e.getMessage());
            throw new DumpException(stringBuilder.toString());
        }
    }

    private static void truncateAndDeleteFile(File file) {
        new FileOutputStream(file).close();
        if (!file.delete()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to delete ");
            stringBuilder.append(file);
            throw new IOException(stringBuilder.toString());
        }
    }

    private void usage(PrintStream printStream) {
        printStream.println("Usage: dumpapp hprof [ path ]");
        printStream.println("Dump HPROF memory usage data from the running application.");
        printStream.println();
        printStream.println("Where path can be any of:");
        printStream.println("  -           Output directly to stdout");
        printStream.println("  <path>      Full path to a writable file on the device");
        printStream.println("  <filename>  Relative filename that will be stored in the app internal storage");
        throw new DumpUsageException("Missing path");
    }
}

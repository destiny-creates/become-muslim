package com.facebook.stetho.dumpapp.plugins;

import android.os.Process;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.Iterator;

public class CrashDumperPlugin implements DumperPlugin {
    private static final String NAME = "crash";
    private static final String OPTION_EXIT_DEFAULT = "0";
    private static final String OPTION_KILL_DEFAULT = "9";
    private static final String OPTION_THROW_DEFAULT = "java.lang.Error";

    private static class ThrowRunnable implements Runnable {
        private final Throwable mThrowable;

        public ThrowRunnable(Throwable th) {
            this.mThrowable = th;
        }

        public void run() {
            ExceptionUtil.sneakyThrow(this.mThrowable);
        }
    }

    public String getName() {
        return "crash";
    }

    public void dump(DumperContext dumperContext) {
        Iterator it = dumperContext.getArgsAsList().iterator();
        String nextOptionalArg = ArgsHelper.nextOptionalArg(it, null);
        if ("throw".equals(nextOptionalArg)) {
            doUncaughtException(it);
        } else if ("kill".equals(nextOptionalArg)) {
            doKill(dumperContext, it);
        } else if ("exit".equals(nextOptionalArg)) {
            doSystemExit(it);
        } else {
            doUsage(dumperContext.getStdout());
            if (nextOptionalArg != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported command: ");
                stringBuilder.append(nextOptionalArg);
                throw new DumpUsageException(stringBuilder.toString());
            }
        }
    }

    private void doUsage(PrintStream printStream) {
        String str = "Usage: dumpapp crash ";
        String str2 = "       dumpapp crash ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("<command> [command-options]");
        printStream.println(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("throw");
        printStream.println(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append("kill");
        printStream.println(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append("exit");
        printStream.println(stringBuilder2.toString());
        printStream.println();
        printStream.println("dumpapp crash throw: Throw an uncaught exception (simulates a program crash)");
        printStream.println("    <Throwable>: Throwable class to use (default: java.lang.Error)");
        printStream.println();
        printStream.println("dumpapp crash kill: Send a signal to this process (simulates the low memory killer)");
        printStream.println("    <SIGNAL>: Either signal name or number to send (default: 9)");
        printStream.println("              See `adb shell kill -l` for more information");
        printStream.println();
        printStream.println("dumpapp crash exit: Invoke System.exit (simulates an abnormal Android exit strategy)");
        printStream.println("    <code>: Exit code (default: 0)");
    }

    private void doSystemExit(Iterator<String> it) {
        System.exit(Integer.parseInt(ArgsHelper.nextOptionalArg(it, "0")));
    }

    private void doKill(DumperContext dumperContext, Iterator<String> it) {
        it = ArgsHelper.nextOptionalArg(it, OPTION_KILL_DEFAULT);
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
            String[] strArr = new String[3];
            strArr[0] = "/system/bin/kill";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-");
            stringBuilder.append(it);
            strArr[1] = stringBuilder.toString();
            strArr[2] = String.valueOf(Process.myPid());
            it = processBuilder.command(strArr).redirectErrorStream(true).start();
            Util.copy(it.getInputStream(), dumperContext.getStdout(), new byte[1024]);
            it.destroy();
        } catch (DumperContext dumperContext2) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Failed to invoke kill: ");
            stringBuilder2.append(dumperContext2);
            throw new DumpException(stringBuilder2.toString());
        } catch (Throwable th) {
            it.destroy();
        }
    }

    private void doUncaughtException(Iterator<String> it) {
        try {
            it = Class.forName(ArgsHelper.nextOptionalArg(it, OPTION_THROW_DEFAULT));
            Constructor tryGetDeclaredConstructor = tryGetDeclaredConstructor(it, String.class);
            if (tryGetDeclaredConstructor != null) {
                it = (Throwable) tryGetDeclaredConstructor.newInstance(new Object[]{"Uncaught exception triggered by Stetho"});
            } else {
                it = (Throwable) it.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            Thread thread = new Thread(new ThrowRunnable(it));
            thread.start();
            Util.joinUninterruptibly(thread);
        } catch (Iterator<String> it2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid supplied Throwable class: ");
            stringBuilder.append(it2);
            throw new DumpException(stringBuilder.toString());
        } catch (Iterator<String> it22) {
            throw ExceptionUtil.propagate(it22.getCause());
        }
    }

    private static <T> java.lang.reflect.Constructor<? extends T> tryGetDeclaredConstructor(java.lang.Class<T> r0, java.lang.Class<?>... r1) {
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
        r0 = r0.getDeclaredConstructor(r1);	 Catch:{ NoSuchMethodException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.dumpapp.plugins.CrashDumperPlugin.tryGetDeclaredConstructor(java.lang.Class, java.lang.Class[]):java.lang.reflect.Constructor<? extends T>");
    }
}

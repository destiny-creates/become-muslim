package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.Util;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.apache.p371a.p372a.C6627c;

public class DumperContext {
    private final List<String> mArgs;
    private final C6627c mParser;
    private final PrintStream mStderr;
    private final InputStream mStdin;
    private final PrintStream mStdout;

    protected DumperContext(DumperContext dumperContext, List<String> list) {
        this(dumperContext.getStdin(), dumperContext.getStdout(), dumperContext.getStderr(), dumperContext.getParser(), list);
    }

    public DumperContext(InputStream inputStream, PrintStream printStream, PrintStream printStream2, C6627c c6627c, List<String> list) {
        this.mStdin = (InputStream) Util.throwIfNull(inputStream);
        this.mStdout = (PrintStream) Util.throwIfNull(printStream);
        this.mStderr = (PrintStream) Util.throwIfNull(printStream2);
        this.mParser = (C6627c) Util.throwIfNull(c6627c);
        this.mArgs = (List) Util.throwIfNull(list);
    }

    public InputStream getStdin() {
        return this.mStdin;
    }

    public PrintStream getStdout() {
        return this.mStdout;
    }

    public PrintStream getStderr() {
        return this.mStderr;
    }

    public C6627c getParser() {
        return this.mParser;
    }

    public List<String> getArgsAsList() {
        return this.mArgs;
    }
}

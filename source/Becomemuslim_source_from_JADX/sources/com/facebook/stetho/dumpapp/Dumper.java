package com.facebook.stetho.dumpapp;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.p371a.p372a.C6626b;
import org.apache.p371a.p372a.C6627c;
import org.apache.p371a.p372a.C6630e;
import org.apache.p371a.p372a.C8190d;

public class Dumper {
    private final Map<String, DumperPlugin> mDumperPlugins;
    private final GlobalOptions mGlobalOptions;
    private final C6627c mParser;

    public Dumper(Iterable<DumperPlugin> iterable) {
        this(iterable, new C8190d());
    }

    public Dumper(Iterable<DumperPlugin> iterable, C6627c c6627c) {
        this.mDumperPlugins = generatePluginMap(iterable);
        this.mParser = c6627c;
        this.mGlobalOptions = new GlobalOptions();
    }

    private static Map<String, DumperPlugin> generatePluginMap(Iterable<DumperPlugin> iterable) {
        Map hashMap = new HashMap();
        for (DumperPlugin dumperPlugin : iterable) {
            hashMap.put(dumperPlugin.getName(), dumperPlugin);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public int dump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) {
        try {
            return doDump(inputStream, printStream, printStream2, strArr);
        } catch (InputStream inputStream2) {
            printStream2.println(inputStream2.getMessage());
            dumpUsage(printStream2);
            return 1;
        } catch (InputStream inputStream22) {
            printStream2.println(inputStream22.getMessage());
            return 1;
        } catch (InputStream inputStream222) {
            throw inputStream222;
        } catch (InputStream inputStream2222) {
            inputStream2222.printStackTrace(printStream2);
            return 1;
        }
    }

    private int doDump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) {
        strArr = this.mParser.a(this.mGlobalOptions.options, strArr, true);
        if (strArr.a(this.mGlobalOptions.optionHelp.b())) {
            dumpUsage(printStream);
            return 0;
        } else if (strArr.a(this.mGlobalOptions.optionListPlugins.b())) {
            dumpAvailablePlugins(printStream);
            return 0;
        } else if (strArr.a().isEmpty()) {
            dumpUsage(printStream2);
            return 1;
        } else {
            dumpPluginOutput(inputStream, printStream, printStream2, strArr);
            return 0;
        }
    }

    private void dumpAvailablePlugins(PrintStream printStream) {
        List<String> arrayList = new ArrayList();
        for (DumperPlugin name : this.mDumperPlugins.values()) {
            arrayList.add(name.getName());
        }
        Collections.sort(arrayList);
        for (String println : arrayList) {
            printStream.println(println);
        }
    }

    private void dumpPluginOutput(InputStream inputStream, PrintStream printStream, PrintStream printStream2, C6626b c6626b) {
        List arrayList = new ArrayList(c6626b.a());
        if (arrayList.size() >= 1) {
            String str = (String) arrayList.remove(null);
            DumperPlugin dumperPlugin = (DumperPlugin) this.mDumperPlugins.get(str);
            if (dumperPlugin != null) {
                dumperPlugin.dump(new DumperContext(inputStream, printStream, printStream2, this.mParser, arrayList));
                return;
            }
            printStream = new StringBuilder();
            printStream.append("No plugin named '");
            printStream.append(str);
            printStream.append("'");
            throw new DumpException(printStream.toString());
        }
        throw new DumpException("Expected plugin argument");
    }

    private void dumpUsage(PrintStream printStream) {
        C6630e c6630e = new C6630e();
        printStream.println("Usage: dumpapp [options] <plugin> [plugin-options]");
        PrintWriter printWriter = new PrintWriter(printStream);
        try {
            c6630e.a(printWriter, c6630e.a(), this.mGlobalOptions.options, c6630e.b(), c6630e.c());
        } finally {
            printWriter.flush();
        }
    }
}

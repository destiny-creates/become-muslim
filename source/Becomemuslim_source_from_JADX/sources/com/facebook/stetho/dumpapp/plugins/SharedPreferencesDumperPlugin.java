package com.facebook.stetho.dumpapp.plugins;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SharedPreferencesDumperPlugin implements DumperPlugin {
    private static final String NAME = "prefs";
    private static final String XML_SUFFIX = ".xml";
    private final Context mAppContext;

    private enum Type {
        BOOLEAN("boolean"),
        INT("int"),
        LONG("long"),
        FLOAT("float"),
        STRING("string"),
        SET("set");
        
        private final String name;

        private Type(String str) {
            this.name = str;
        }

        public static Type of(String str) {
            for (Type type : values()) {
                if (type.name.equals(str)) {
                    return type;
                }
            }
            return null;
        }

        public static StringBuilder appendNamesList(StringBuilder stringBuilder, String str) {
            Object obj = 1;
            for (Type type : values()) {
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder.append(str);
                }
                stringBuilder.append(type.name);
            }
            return stringBuilder;
        }
    }

    public String getName() {
        return NAME;
    }

    public SharedPreferencesDumperPlugin(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public void dump(DumperContext dumperContext) {
        PrintStream stdout = dumperContext.getStdout();
        dumperContext = dumperContext.getArgsAsList();
        String str = dumperContext.isEmpty() ? "" : (String) dumperContext.remove(0);
        if (str.equals("print")) {
            doPrint(stdout, dumperContext);
        } else if (str.equals("write")) {
            doWrite(dumperContext);
        } else {
            doUsage(stdout);
        }
    }

    private void doWrite(List<String> list) {
        list = list.iterator();
        String nextArg = nextArg(list, "Expected <path>");
        String nextArg2 = nextArg(list, "Expected <key>");
        Type of = Type.of(nextArg(list, "Expected <type>"));
        if (of != null) {
            Editor edit = getSharedPreferences(nextArg).edit();
            switch (of) {
                case BOOLEAN:
                    edit.putBoolean(nextArg2, Boolean.valueOf(nextArgValue(list)).booleanValue());
                    break;
                case INT:
                    edit.putInt(nextArg2, Integer.valueOf(nextArgValue(list)).intValue());
                    break;
                case LONG:
                    edit.putLong(nextArg2, Long.valueOf(nextArgValue(list)).longValue());
                    break;
                case FLOAT:
                    edit.putFloat(nextArg2, Float.valueOf(nextArgValue(list)).floatValue());
                    break;
                case STRING:
                    edit.putString(nextArg2, nextArgValue(list));
                    break;
                case SET:
                    putStringSet(edit, nextArg2, list);
                    break;
                default:
                    break;
            }
            edit.commit();
            return;
        }
        throw new DumpUsageException("Usage: prefs write <path> <key> <type> <value>, where type is one of: " + ", ");
    }

    private static String nextArg(Iterator<String> it, String str) {
        if (it.hasNext()) {
            return (String) it.next();
        }
        throw new DumpUsageException(str);
    }

    private static String nextArgValue(Iterator<String> it) {
        return nextArg(it, "Expected <value>");
    }

    @TargetApi(11)
    private static void putStringSet(Editor editor, String str, Iterator<String> it) {
        Set hashSet = new HashSet();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        editor.putStringSet(str, hashSet);
    }

    private void doPrint(PrintStream printStream, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mAppContext.getApplicationInfo().dataDir);
        stringBuilder.append("/shared_prefs");
        printRecursive(printStream, stringBuilder.toString(), "", list.isEmpty() ? "" : (String) list.get(0), list.size() > 1 ? (String) list.get(1) : "");
    }

    private void printRecursive(PrintStream printStream, String str, String str2, String str3, String str4) {
        File file = new File(str, str2);
        int i = 0;
        if (file.isFile()) {
            if (str2.endsWith(XML_SUFFIX) != null) {
                printFile(printStream, str2.substring(0, str2.length() - XML_SUFFIX.length()), str4);
            }
        } else if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                while (i < list.length) {
                    String str5;
                    if (TextUtils.isEmpty(str2)) {
                        str5 = list[i];
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str2);
                        stringBuilder.append(File.separator);
                        stringBuilder.append(list[i]);
                        str5 = stringBuilder.toString();
                    }
                    String str6 = str5;
                    if (str6.startsWith(str3)) {
                        printRecursive(printStream, str, str6, str3, str4);
                    }
                    i++;
                }
            }
        }
    }

    private void printFile(PrintStream printStream, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(":");
        printStream.println(stringBuilder.toString());
        for (Entry entry : getSharedPreferences(str).getAll().entrySet()) {
            if (((String) entry.getKey()).startsWith(str2)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("  ");
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append(" = ");
                stringBuilder2.append(entry.getValue());
                printStream.println(stringBuilder2.toString());
            }
        }
    }

    private void doUsage(PrintStream printStream) {
        String str = "Usage: dumpapp prefs ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("<command> [command-options]");
        printStream.println(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("print [pathPrefix [keyPrefix]]");
        printStream.println(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder("       dumpapp prefs ");
        stringBuilder2.append("write <path> <key> <");
        stringBuilder2 = Type.appendNamesList(stringBuilder2, "|");
        stringBuilder2.append("> <value>");
        printStream.println(stringBuilder2);
        printStream.println();
        printStream.println("dumpapp prefs print: Print all matching values from the shared preferences");
        printStream.println();
        printStream.println("dumpapp prefs write: Writes a value to the shared preferences");
    }

    private SharedPreferences getSharedPreferences(String str) {
        return this.mAppContext.getSharedPreferences(str, 4);
    }
}

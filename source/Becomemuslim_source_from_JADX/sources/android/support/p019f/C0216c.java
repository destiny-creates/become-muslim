package android.support.p019f;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: MultiDexExtractor */
/* renamed from: android.support.f.c */
final class C0216c implements Closeable {
    /* renamed from: a */
    private final File f532a;
    /* renamed from: b */
    private final long f533b;
    /* renamed from: c */
    private final File f534c;
    /* renamed from: d */
    private final RandomAccessFile f535d;
    /* renamed from: e */
    private final FileChannel f536e;
    /* renamed from: f */
    private final FileLock f537f;

    /* compiled from: MultiDexExtractor */
    /* renamed from: android.support.f.c$1 */
    class C02141 implements FileFilter {
        /* renamed from: a */
        final /* synthetic */ C0216c f530a;

        C02141(C0216c c0216c) {
            this.f530a = c0216c;
        }

        public boolean accept(File file) {
            return file.getName().equals("MultiDex.lock") ^ 1;
        }
    }

    /* compiled from: MultiDexExtractor */
    /* renamed from: android.support.f.c$a */
    private static class C0215a extends File {
        /* renamed from: a */
        public long f531a = -1;

        public C0215a(File file, String str) {
            super(file, str);
        }
    }

    C0216c(File file, File file2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MultiDexExtractor(");
        stringBuilder.append(file.getPath());
        stringBuilder.append(", ");
        stringBuilder.append(file2.getPath());
        stringBuilder.append(")");
        Log.i("MultiDex", stringBuilder.toString());
        this.f532a = file;
        this.f534c = file2;
        this.f533b = C0216c.m549b(file);
        file = new File(file2, "MultiDex.lock");
        this.f535d = new RandomAccessFile(file, "rw");
        try {
            this.f536e = this.f535d.getChannel();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Blocking on lock ");
            stringBuilder2.append(file.getPath());
            Log.i("MultiDex", stringBuilder2.toString());
            this.f537f = this.f536e.lock();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(file.getPath());
            stringBuilder2.append(" locked");
            Log.i("MultiDex", stringBuilder2.toString());
        } catch (File file3) {
            C0216c.m546a(this.f536e);
            throw file3;
        } catch (File file32) {
            C0216c.m546a(this.f535d);
            throw file32;
        }
    }

    /* renamed from: a */
    List<? extends File> m551a(Context context, String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MultiDexExtractor.load(");
        stringBuilder.append(this.f532a.getPath());
        stringBuilder.append(", ");
        stringBuilder.append(z);
        stringBuilder.append(", ");
        stringBuilder.append(str);
        stringBuilder.append(")");
        Log.i("MultiDex", stringBuilder.toString());
        if (this.f537f.isValid()) {
            if (z || C0216c.m548a(context, this.f532a, this.f533b, str)) {
                if (z) {
                    Log.i("MultiDex", "Forced extraction must be performed.");
                } else {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                }
                z = m543a();
                C0216c.m545a(context, str, C0216c.m541a(this.f532a), this.f533b, z);
            } else {
                try {
                    z = m544a(context, str);
                } catch (boolean z2) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", z2);
                    z2 = m543a();
                    C0216c.m545a(context, str, C0216c.m541a(this.f532a), this.f533b, z2);
                }
            }
            str = new StringBuilder();
            str.append("load found ");
            str.append(z2.size());
            str.append(" secondary dex files");
            Log.i("MultiDex", str.toString());
            return z2;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public void close() {
        this.f537f.release();
        this.f536e.close();
        this.f535d.close();
    }

    /* renamed from: a */
    private List<C0215a> m544a(Context context, String str) {
        String str2 = str;
        Log.i("MultiDex", "loading existing secondary dex files");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f532a.getName());
        stringBuilder.append(".classes");
        String stringBuilder2 = stringBuilder.toString();
        SharedPreferences a = C0216c.m542a(context);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str2);
        stringBuilder3.append("dex.number");
        int i = a.getInt(stringBuilder3.toString(), 1);
        List<C0215a> arrayList = new ArrayList(i - 1);
        int i2 = 2;
        while (i2 <= i) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append(i2);
            stringBuilder4.append(".zip");
            File c0215a = new C0215a(r0.f534c, stringBuilder4.toString());
            if (c0215a.isFile()) {
                c0215a.f531a = C0216c.m549b(c0215a);
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str2);
                stringBuilder4.append("dex.crc.");
                stringBuilder4.append(i2);
                long j = a.getLong(stringBuilder4.toString(), -1);
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str2);
                stringBuilder4.append("dex.time.");
                stringBuilder4.append(i2);
                long j2 = a.getLong(stringBuilder4.toString(), -1);
                long lastModified = c0215a.lastModified();
                if (j2 == lastModified) {
                    String str3 = stringBuilder2;
                    SharedPreferences sharedPreferences = a;
                    if (j == c0215a.f531a) {
                        arrayList.add(c0215a);
                        i2++;
                        stringBuilder2 = str3;
                        a = sharedPreferences;
                    }
                }
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append("Invalid extracted dex: ");
                stringBuilder5.append(c0215a);
                stringBuilder5.append(" (key \"");
                stringBuilder5.append(str2);
                stringBuilder5.append("\"), expected modification time: ");
                stringBuilder5.append(j2);
                stringBuilder5.append(", modification time: ");
                stringBuilder5.append(lastModified);
                stringBuilder5.append(", expected crc: ");
                stringBuilder5.append(j);
                stringBuilder5.append(", file crc: ");
                stringBuilder5.append(c0215a.f531a);
                throw new IOException(stringBuilder5.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Missing extracted secondary dex file '");
            stringBuilder.append(c0215a.getPath());
            stringBuilder.append("'");
            throw new IOException(stringBuilder.toString());
        }
        return arrayList;
    }

    /* renamed from: a */
    private static boolean m548a(Context context, File file, long j, String str) {
        context = C0216c.m542a(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("timestamp");
        if (context.getLong(stringBuilder.toString(), -1) == C0216c.m541a(file)) {
            file = new StringBuilder();
            file.append(str);
            file.append("crc");
            if (context.getLong(file.toString(), -1) == j) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static long m541a(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    /* renamed from: b */
    private static long m549b(File file) {
        long a = C0218d.m552a(file);
        return a == -1 ? a - 1 : a;
    }

    /* renamed from: a */
    private List<C0215a> m543a() {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.f532a.getName());
        stringBuilder2.append(".classes");
        String stringBuilder3 = stringBuilder2.toString();
        m550b();
        List<C0215a> arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f532a);
        int i = 2;
        File c0215a;
        Object obj;
        try {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("classes");
            stringBuilder4.append(2);
            stringBuilder4.append(".dex");
            ZipEntry entry = zipFile.getEntry(stringBuilder4.toString());
            while (entry != null) {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(stringBuilder3);
                stringBuilder5.append(i);
                stringBuilder5.append(".zip");
                c0215a = new C0215a(this.f534c, stringBuilder5.toString());
                arrayList.add(c0215a);
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append("Extraction is needed for file ");
                stringBuilder6.append(c0215a);
                Log.i("MultiDex", stringBuilder6.toString());
                int i2 = 0;
                obj = null;
                while (i2 < 3 && obj == null) {
                    i2++;
                    C0216c.m547a(zipFile, entry, c0215a, stringBuilder3);
                    c0215a.f531a = C0216c.m549b(c0215a);
                    obj = 1;
                    String str = "MultiDex";
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Extraction ");
                    stringBuilder.append(obj != null ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
                    stringBuilder.append(" '");
                    stringBuilder.append(c0215a.getAbsolutePath());
                    stringBuilder.append("': length ");
                    stringBuilder.append(c0215a.length());
                    stringBuilder.append(" - crc: ");
                    stringBuilder.append(c0215a.f531a);
                    Log.i(str, stringBuilder.toString());
                    if (obj == null) {
                        c0215a.delete();
                        if (c0215a.exists()) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Failed to delete corrupted secondary dex '");
                            stringBuilder.append(c0215a.getPath());
                            stringBuilder.append("'");
                            Log.w("MultiDex", stringBuilder.toString());
                        }
                    }
                }
                if (obj != null) {
                    i++;
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("classes");
                    stringBuilder4.append(i);
                    stringBuilder4.append(".dex");
                    entry = zipFile.getEntry(stringBuilder4.toString());
                } else {
                    StringBuilder stringBuilder7 = new StringBuilder();
                    stringBuilder7.append("Could not create zip file ");
                    stringBuilder7.append(c0215a.getAbsolutePath());
                    stringBuilder7.append(" for secondary dex (");
                    stringBuilder7.append(i);
                    stringBuilder7.append(")");
                    throw new IOException(stringBuilder7.toString());
                }
            }
            try {
                zipFile.close();
            } catch (Throwable e) {
                Log.w("MultiDex", "Failed to close resource", e);
            }
            return arrayList;
        } catch (Throwable e2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read crc from ");
            stringBuilder.append(c0215a.getAbsolutePath());
            Log.w("MultiDex", stringBuilder.toString(), e2);
            obj = null;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (Throwable e3) {
                Log.w("MultiDex", "Failed to close resource", e3);
            }
        }
    }

    /* renamed from: a */
    private static void m545a(Context context, String str, long j, long j2, List<C0215a> list) {
        context = C0216c.m542a(context).edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("timestamp");
        context.putLong(stringBuilder.toString(), j);
        j = new StringBuilder();
        j.append(str);
        j.append("crc");
        context.putLong(j.toString(), j2);
        j = new StringBuilder();
        j.append(str);
        j.append("dex.number");
        context.putInt(j.toString(), list.size() + 1);
        int i = 2;
        for (C0215a c0215a : list) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("dex.crc.");
            stringBuilder2.append(i);
            context.putLong(stringBuilder2.toString(), c0215a.f531a);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("dex.time.");
            stringBuilder2.append(i);
            context.putLong(stringBuilder2.toString(), c0215a.lastModified());
            i++;
        }
        context.commit();
    }

    /* renamed from: a */
    private static SharedPreferences m542a(Context context) {
        return context.getSharedPreferences("multidex.version", VERSION.SDK_INT < 11 ? 0 : 4);
    }

    /* renamed from: b */
    private void m550b() {
        File[] listFiles = this.f534c.listFiles(new C02141(this));
        if (listFiles == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to list secondary dex dir content (");
            stringBuilder.append(this.f534c.getPath());
            stringBuilder.append(").");
            Log.w("MultiDex", stringBuilder.toString());
            return;
        }
        for (File file : listFiles) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Trying to delete old file ");
            stringBuilder2.append(file.getPath());
            stringBuilder2.append(" of size ");
            stringBuilder2.append(file.length());
            Log.i("MultiDex", stringBuilder2.toString());
            if (file.delete()) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Deleted old file ");
                stringBuilder2.append(file.getPath());
                Log.i("MultiDex", stringBuilder2.toString());
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Failed to delete old file ");
                stringBuilder2.append(file.getPath());
                Log.w("MultiDex", stringBuilder2.toString());
            }
        }
    }

    /* renamed from: a */
    private static void m547a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        Closeable inputStream = zipFile.getInputStream(zipEntry);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tmp-");
        stringBuilder.append(str);
        str = File.createTempFile(stringBuilder.toString(), ".zip", file.getParentFile());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Extracting ");
        stringBuilder2.append(str.getPath());
        Log.i("MultiDex", stringBuilder2.toString());
        ZipOutputStream zipOutputStream;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            zipEntry = new byte[16384];
            for (int read = inputStream.read(zipEntry); read != -1; read = inputStream.read(zipEntry)) {
                zipOutputStream.write(zipEntry, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (str.setReadOnly() != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Renaming to ");
                stringBuilder.append(file.getPath());
                Log.i("MultiDex", stringBuilder.toString());
                if (str.renameTo(file) != null) {
                    C0216c.m546a(inputStream);
                    str.delete();
                    return;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to rename \"");
                stringBuilder.append(str.getAbsolutePath());
                stringBuilder.append("\" to \"");
                stringBuilder.append(file.getAbsolutePath());
                stringBuilder.append("\"");
                throw new IOException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to mark readonly \"");
            stringBuilder.append(str.getAbsolutePath());
            stringBuilder.append("\" (tmp of \"");
            stringBuilder.append(file.getAbsolutePath());
            stringBuilder.append("\")");
            throw new IOException(stringBuilder.toString());
        } catch (Throwable th) {
            C0216c.m546a(inputStream);
            str.delete();
        }
    }

    /* renamed from: a */
    private static void m546a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Closeable closeable2) {
            Log.w("MultiDex", "Failed to close resource", closeable2);
        }
    }
}

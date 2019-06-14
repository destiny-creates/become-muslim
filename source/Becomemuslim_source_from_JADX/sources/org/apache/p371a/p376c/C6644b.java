package org.apache.p371a.p376c;

import com.facebook.stetho.common.Utf8Charset;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FileUtils */
/* renamed from: org.apache.a.c.b */
public class C6644b {
    /* renamed from: a */
    public static final BigInteger f21349a = BigInteger.valueOf(1024);
    /* renamed from: b */
    public static final BigInteger f21350b = f21349a.multiply(f21349a);
    /* renamed from: c */
    public static final BigInteger f21351c = f21349a.multiply(f21350b);
    /* renamed from: d */
    public static final BigInteger f21352d = f21349a.multiply(f21351c);
    /* renamed from: e */
    public static final BigInteger f21353e = f21349a.multiply(f21352d);
    /* renamed from: f */
    public static final BigInteger f21354f = f21349a.multiply(f21353e);
    /* renamed from: g */
    public static final BigInteger f21355g = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
    /* renamed from: h */
    public static final BigInteger f21356h = f21349a.multiply(f21355g);
    /* renamed from: i */
    public static final File[] f21357i = new File[0];
    /* renamed from: j */
    private static final Charset f21358j = Charset.forName(Utf8Charset.NAME);

    /* renamed from: a */
    public static void m27037a(File file, File file2) {
        C6644b.m27040a(file, file2, true);
    }

    /* renamed from: a */
    public static void m27040a(File file, File file2, boolean z) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            z = new StringBuilder();
            z.append("Source '");
            z.append(file);
            z.append("' does not exist");
            throw new FileNotFoundException(z.toString());
        } else if (file.isDirectory()) {
            z = new StringBuilder();
            z.append("Source '");
            z.append(file);
            z.append("' exists but is a directory");
            throw new IOException(z.toString());
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Source '");
            stringBuilder.append(file);
            stringBuilder.append("' and destination '");
            stringBuilder.append(file2);
            stringBuilder.append("' are the same");
            throw new IOException(stringBuilder.toString());
        } else {
            File parentFile = file2.getParentFile();
            if (!(parentFile == null || parentFile.mkdirs())) {
                if (!parentFile.isDirectory()) {
                    file2 = new StringBuilder();
                    file2.append("Destination '");
                    file2.append(parentFile);
                    file2.append("' directory cannot be created");
                    throw new IOException(file2.toString());
                }
            }
            if (file2.exists()) {
                if (!file2.canWrite()) {
                    z = new StringBuilder();
                    z.append("Destination '");
                    z.append(file2);
                    z.append("' exists but is read-only");
                    throw new IOException(z.toString());
                }
            }
            C6644b.m27045c(file, file2, z);
        }
    }

    /* renamed from: c */
    private static void m27045c(File file, File file2, boolean z) {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        Throwable th;
        Closeable closeable;
        File file3 = file;
        File file4 = file2;
        if (file2.exists()) {
            if (file2.isDirectory()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Destination '");
                stringBuilder.append(file4);
                stringBuilder.append("' exists but is a directory");
                throw new IOException(stringBuilder.toString());
            }
        }
        Closeable closeable2 = null;
        try {
            Closeable channel;
            fileInputStream = new FileInputStream(file3);
            try {
                fileOutputStream = new FileOutputStream(file4);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                closeable = fileOutputStream;
                C6646d.m27057a(closeable2);
                C6646d.m27060a(fileOutputStream);
                C6646d.m27057a(closeable);
                C6646d.m27058a(fileInputStream);
                throw th;
            }
            try {
                closeable = fileInputStream.getChannel();
                try {
                    channel = fileOutputStream.getChannel();
                } catch (Throwable th3) {
                    th = th3;
                    C6646d.m27057a(closeable2);
                    C6646d.m27060a(fileOutputStream);
                    C6646d.m27057a(closeable);
                    C6646d.m27058a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                C6646d.m27057a(closeable2);
                C6646d.m27060a(fileOutputStream);
                C6646d.m27057a(closeable);
                C6646d.m27058a(fileInputStream);
                throw th;
            }
            try {
                long size = closeable.size();
                long j = 0;
                while (j < size) {
                    long j2 = size - j;
                    j += channel.transferFrom(closeable, j, j2 > 31457280 ? 31457280 : j2);
                }
                C6646d.m27057a(channel);
                C6646d.m27060a(fileOutputStream);
                C6646d.m27057a(closeable);
                C6646d.m27058a(fileInputStream);
                if (file.length() != file2.length()) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Failed to copy full contents from '");
                    stringBuilder2.append(file3);
                    stringBuilder2.append("' to '");
                    stringBuilder2.append(file4);
                    stringBuilder2.append("'");
                    throw new IOException(stringBuilder2.toString());
                } else if (z) {
                    file4.setLastModified(file.lastModified());
                }
            } catch (Throwable th5) {
                th = th5;
                closeable2 = channel;
                C6646d.m27057a(closeable2);
                C6646d.m27060a(fileOutputStream);
                C6646d.m27057a(closeable);
                C6646d.m27058a(fileInputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
            fileOutputStream = fileInputStream;
            closeable = fileOutputStream;
            C6646d.m27057a(closeable2);
            C6646d.m27060a(fileOutputStream);
            C6646d.m27057a(closeable);
            C6646d.m27058a(fileInputStream);
            throw th;
        }
    }

    /* renamed from: b */
    public static void m27042b(File file, File file2) {
        C6644b.m27043b(file, file2, true);
    }

    /* renamed from: b */
    public static void m27043b(File file, File file2, boolean z) {
        C6644b.m27038a(file, file2, null, z);
    }

    /* renamed from: a */
    public static void m27038a(File file, File file2, FileFilter fileFilter, boolean z) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            fileFilter = new StringBuilder();
            fileFilter.append("Source '");
            fileFilter.append(file);
            fileFilter.append("' does not exist");
            throw new FileNotFoundException(fileFilter.toString());
        } else if (!file.isDirectory()) {
            fileFilter = new StringBuilder();
            fileFilter.append("Source '");
            fileFilter.append(file);
            fileFilter.append("' exists but is not a directory");
            throw new IOException(fileFilter.toString());
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            z = new StringBuilder();
            z.append("Source '");
            z.append(file);
            z.append("' and destination '");
            z.append(file2);
            z.append("' are the same");
            throw new IOException(z.toString());
        } else {
            List list = null;
            if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
                if (listFiles != null && listFiles.length > 0) {
                    list = new ArrayList(listFiles.length);
                    for (File name : listFiles) {
                        list.add(new File(file2, name.getName()).getCanonicalPath());
                    }
                }
            }
            C6644b.m27039a(file, file2, fileFilter, z, list);
        }
    }

    /* renamed from: a */
    private static void m27039a(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles != null) {
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    fileFilter = new StringBuilder();
                    fileFilter.append("Destination '");
                    fileFilter.append(file2);
                    fileFilter.append("' exists but is not a directory");
                    throw new IOException(fileFilter.toString());
                }
            } else if (!file2.mkdirs()) {
                if (!file2.isDirectory()) {
                    fileFilter = new StringBuilder();
                    fileFilter.append("Destination '");
                    fileFilter.append(file2);
                    fileFilter.append("' directory cannot be created");
                    throw new IOException(fileFilter.toString());
                }
            }
            if (file2.canWrite()) {
                for (File file3 : listFiles) {
                    File file4 = new File(file2, file3.getName());
                    if (list == null || !list.contains(file3.getCanonicalPath())) {
                        if (file3.isDirectory()) {
                            C6644b.m27039a(file3, file4, fileFilter, z, list);
                        } else {
                            C6644b.m27045c(file3, file4, z);
                        }
                    }
                }
                if (z) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            fileFilter = new StringBuilder();
            fileFilter.append("Destination '");
            fileFilter.append(file2);
            fileFilter.append("' cannot be written to");
            throw new IOException(fileFilter.toString());
        }
        fileFilter = new StringBuilder();
        fileFilter.append("Failed to list contents of ");
        fileFilter.append(file);
        throw new IOException(fileFilter.toString());
    }

    /* renamed from: a */
    public static void m27036a(File file) {
        if (file.exists()) {
            if (!C6644b.m27046d(file)) {
                C6644b.m27041b(file);
            }
            if (!file.delete()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to delete directory ");
                stringBuilder.append(file);
                stringBuilder.append(".");
                throw new IOException(stringBuilder.toString());
            }
        }
    }

    /* renamed from: b */
    public static void m27041b(File file) {
        StringBuilder stringBuilder;
        if (!file.exists()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(file);
            stringBuilder.append(" does not exist");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                file = null;
                for (File c : listFiles) {
                    try {
                        C6644b.m27044c(c);
                    } catch (IOException e) {
                        file = e;
                    }
                }
                if (file != null) {
                    throw file;
                }
                return;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Failed to list contents of ");
            stringBuilder2.append(file);
            throw new IOException(stringBuilder2.toString());
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(file);
            stringBuilder.append(" is not a directory");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: c */
    public static void m27044c(File file) {
        if (file.isDirectory()) {
            C6644b.m27036a(file);
            return;
        }
        boolean exists = file.exists();
        if (!file.delete()) {
            if (exists) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to delete file: ");
                stringBuilder.append(file);
                throw new IOException(stringBuilder.toString());
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("File does not exist: ");
            stringBuilder2.append(file);
            throw new FileNotFoundException(stringBuilder2.toString());
        }
    }

    /* renamed from: d */
    public static boolean m27046d(File file) {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        } else if (C6645c.m27048a()) {
            return false;
        } else {
            if (file.getParent() != null) {
                file = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            if (file.getCanonicalFile().equals(file.getAbsoluteFile()) != null) {
                return false;
            }
            return true;
        }
    }
}

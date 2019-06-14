package org.apache.p371a.p376c;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import org.apache.p371a.p376c.p377a.C6642c;

/* compiled from: IOUtils */
/* renamed from: org.apache.a.c.d */
public class C6646d {
    /* renamed from: a */
    public static final char f21362a = File.separatorChar;
    /* renamed from: b */
    public static final String f21363b;

    static {
        Writer c6642c = new C6642c(4);
        PrintWriter printWriter = new PrintWriter(c6642c);
        printWriter.println();
        f21363b = c6642c.toString();
        printWriter.close();
    }

    /* renamed from: a */
    public static void m27058a(InputStream inputStream) {
        C6646d.m27057a((Closeable) inputStream);
    }

    /* renamed from: a */
    public static void m27060a(OutputStream outputStream) {
        C6646d.m27057a((Closeable) outputStream);
    }

    /* renamed from: a */
    public static void m27057a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.a.c.d.a(java.io.Closeable):void");
    }

    /* renamed from: b */
    public static String m27063b(InputStream inputStream) {
        return C6646d.m27056a(inputStream, Charset.defaultCharset());
    }

    /* renamed from: a */
    public static String m27056a(InputStream inputStream, Charset charset) {
        Writer c6642c = new C6642c();
        C6646d.m27059a(inputStream, c6642c, charset);
        return c6642c.toString();
    }

    /* renamed from: a */
    public static String m27055a(InputStream inputStream, String str) {
        return C6646d.m27056a(inputStream, C6643a.m27034a(str));
    }

    /* renamed from: a */
    public static int m27051a(InputStream inputStream, OutputStream outputStream) {
        inputStream = C6646d.m27061b(inputStream, outputStream);
        return inputStream > 2147483647L ? -1 : (int) inputStream;
    }

    /* renamed from: b */
    public static long m27061b(InputStream inputStream, OutputStream outputStream) {
        return C6646d.m27053a(inputStream, outputStream, new byte[4096]);
    }

    /* renamed from: a */
    public static long m27053a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: a */
    public static void m27059a(InputStream inputStream, Writer writer, Charset charset) {
        C6646d.m27052a(new InputStreamReader(inputStream, C6643a.m27035a(charset)), writer);
    }

    /* renamed from: a */
    public static int m27052a(Reader reader, Writer writer) {
        reader = C6646d.m27062b(reader, writer);
        return reader > 2147483647L ? -1 : (int) reader;
    }

    /* renamed from: b */
    public static long m27062b(Reader reader, Writer writer) {
        return C6646d.m27054a(reader, writer, new char[4096]);
    }

    /* renamed from: a */
    public static long m27054a(Reader reader, Writer writer, char[] cArr) {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }
}

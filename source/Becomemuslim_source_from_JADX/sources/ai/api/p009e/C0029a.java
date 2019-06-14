package ai.api.p009e;

import com.facebook.stetho.common.Utf8Charset;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: IOUtils */
/* renamed from: ai.api.e.a */
public class C0029a {
    /* renamed from: a */
    static final /* synthetic */ boolean f104a = (C0029a.class.desiredAssertionStatus() ^ 1);

    /* renamed from: a */
    public static void m84a(String str, OutputStream outputStream, String str2) {
        if (str != null && str.length() > 0) {
            outputStream.write(str.getBytes(str2));
        }
    }

    /* renamed from: a */
    public static void m83a(String str, OutputStream outputStream) {
        C0029a.m84a(str, outputStream, Utf8Charset.NAME);
    }

    /* renamed from: a */
    public static String m81a(InputStream inputStream, String str) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        try {
            inputStream = C0029a.m82a(inputStreamReader);
            inputStreamReader.close();
            return inputStream;
        } catch (Throwable th) {
            inputStream = th;
        }
        throw inputStream;
        if (str != null) {
            try {
                inputStreamReader.close();
            } catch (Throwable th2) {
                str.addSuppressed(th2);
            }
        } else {
            inputStreamReader.close();
        }
        throw inputStream;
    }

    /* renamed from: a */
    public static String m80a(InputStream inputStream) {
        return C0029a.m81a(inputStream, Utf8Charset.NAME);
    }

    /* renamed from: a */
    public static String m82a(InputStreamReader inputStreamReader) {
        Writer stringWriter = new StringWriter();
        C0029a.m78a((Reader) inputStreamReader, stringWriter);
        return stringWriter.toString();
    }

    /* renamed from: a */
    private static long m78a(Reader reader, Writer writer) {
        return C0029a.m79a(reader, writer, new char[4096]);
    }

    /* renamed from: a */
    private static long m79a(Reader reader, Writer writer, char[] cArr) {
        if (!f104a) {
            if (cArr == null) {
                throw new AssertionError();
            }
        }
        if (!f104a) {
            if (cArr.length <= 0) {
                throw new AssertionError();
            }
        }
        long j = 0;
        int read = reader.read(cArr);
        while (read > 0) {
            writer.write(cArr, 0, read);
            j += (long) read;
            read = reader.read(cArr);
        }
        return j;
    }
}

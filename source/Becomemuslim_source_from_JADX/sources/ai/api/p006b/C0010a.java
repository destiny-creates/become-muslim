package ai.api.p006b;

import ai.api.p009e.C0029a;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import org.apache.p378b.p379a.C6650b;
import org.apache.p378b.p379a.C6657c;

/* compiled from: HttpClient */
/* renamed from: ai.api.b.a */
public class C0010a {
    /* renamed from: a */
    private static final C6657c f39a = C6650b.a(C0010a.class);
    /* renamed from: b */
    private final HttpURLConnection f40b;
    /* renamed from: c */
    private OutputStream f41c;
    /* renamed from: d */
    private final String f42d = "--";
    /* renamed from: e */
    private final String f43e;
    /* renamed from: f */
    private boolean f44f;

    public C0010a(HttpURLConnection httpURLConnection) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SwA");
        stringBuilder.append(Long.toString(System.currentTimeMillis()));
        stringBuilder.append("SwA");
        this.f43e = stringBuilder.toString();
        if (httpURLConnection != null) {
            this.f40b = httpURLConnection;
            return;
        }
        throw new IllegalArgumentException("Connection cannot be null");
    }

    /* renamed from: a */
    public void m32a() {
        this.f40b.setRequestProperty("Connection", "Keep-Alive");
        HttpURLConnection httpURLConnection = this.f40b;
        String str = HttpHeaders.CONTENT_TYPE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("multipart/form-data; boundary=");
        stringBuilder.append(this.f43e);
        httpURLConnection.setRequestProperty(str, stringBuilder.toString());
        this.f40b.setChunkedStreamingMode(2048);
        this.f40b.connect();
        this.f41c = this.f40b.getOutputStream();
    }

    /* renamed from: a */
    public void m33a(String str, String str2) {
        OutputStream outputStream = this.f41c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(this.f43e);
        stringBuilder.append("\r\n");
        outputStream.write(stringBuilder.toString().getBytes());
        this.f41c.write("Content-Type: application/json\r\n".getBytes());
        outputStream = this.f41c;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Content-Disposition: form-data; name=\"");
        stringBuilder.append(str);
        stringBuilder.append("\"\r\n");
        outputStream.write(stringBuilder.toString().getBytes());
        str = this.f41c;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("\r\n");
        stringBuilder2.append(str2);
        stringBuilder2.append("\r\n");
        str.write(stringBuilder2.toString().getBytes());
    }

    /* renamed from: a */
    public void m34a(String str, String str2, InputStream inputStream) {
        OutputStream outputStream = this.f41c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(this.f43e);
        stringBuilder.append("\r\n");
        outputStream.write(stringBuilder.toString().getBytes());
        outputStream = this.f41c;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Content-Disposition: form-data; name=\"");
        stringBuilder.append(str);
        stringBuilder.append("\"; filename=\"");
        stringBuilder.append(str2);
        stringBuilder.append("\"\r\n");
        outputStream.write(stringBuilder.toString().getBytes());
        this.f41c.write("Content-Type: audio/wav\r\n".getBytes());
        this.f41c.write("\r\n".getBytes());
        f39a.a("Sound write start");
        if (this.f44f != null) {
            str = new File(System.getProperty("java.io.tmpdir"));
            if (!str.exists()) {
                str.mkdirs();
            }
            f39a.a(str.getAbsolutePath());
            str = new FileOutputStream(new File(str, "log.wav"), false);
        } else {
            str = null;
        }
        byte[] bArr = new byte[4096];
        int read = inputStream.read(bArr, 0, bArr.length);
        while (read >= 0) {
            if (read > 0) {
                this.f41c.write(bArr, 0, read);
                if (this.f44f) {
                    str.write(bArr, 0, read);
                }
            }
            read = inputStream.read(bArr, 0, bArr.length);
        }
        if (this.f44f != null) {
            str.close();
        }
        f39a.a("Sound write finished");
        this.f41c.write("\r\n".getBytes());
    }

    /* renamed from: b */
    public void m36b() {
        OutputStream outputStream = this.f41c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(this.f43e);
        stringBuilder.append("--");
        stringBuilder.append("\r\n");
        outputStream.write(stringBuilder.toString().getBytes());
        this.f41c.close();
    }

    /* renamed from: c */
    public String m37c() {
        InputStream bufferedInputStream = new BufferedInputStream(this.f40b.getInputStream());
        String a = C0029a.m80a(bufferedInputStream);
        bufferedInputStream.close();
        return a;
    }

    /* renamed from: d */
    public String m38d() {
        try {
            InputStream bufferedInputStream = new BufferedInputStream(this.f40b.getErrorStream());
            String a = C0029a.m80a(bufferedInputStream);
            bufferedInputStream.close();
            return a;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m35a(boolean z) {
        this.f44f = z;
    }
}

package org.apache.p371a.p376c.p377a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ProxyOutputStream */
/* renamed from: org.apache.a.c.a.b */
public class C6641b extends FilterOutputStream {
    /* renamed from: a */
    protected void m27031a(int i) {
    }

    /* renamed from: b */
    protected void m27033b(int i) {
    }

    public C6641b(OutputStream outputStream) {
        super(outputStream);
    }

    public void write(int i) {
        try {
            m27031a(1);
            this.out.write(i);
            m27033b(1);
        } catch (IOException e) {
            m27032a(e);
        }
    }

    public void write(byte[] bArr) {
        int length;
        if (bArr != null) {
            try {
                length = bArr.length;
            } catch (IOException e) {
                m27032a(e);
                return;
            }
        }
        length = 0;
        m27031a(length);
        this.out.write(bArr);
        m27033b(length);
    }

    public void write(byte[] bArr, int i, int i2) {
        try {
            m27031a(i2);
            this.out.write(bArr, i, i2);
            m27033b(i2);
        } catch (IOException e) {
            m27032a(e);
        }
    }

    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            m27032a(e);
        }
    }

    public void close() {
        try {
            this.out.close();
        } catch (IOException e) {
            m27032a(e);
        }
    }

    /* renamed from: a */
    protected void m27032a(IOException iOException) {
        throw iOException;
    }
}

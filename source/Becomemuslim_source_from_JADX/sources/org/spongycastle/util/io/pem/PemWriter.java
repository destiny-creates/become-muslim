package org.spongycastle.util.io.pem;

import java.io.BufferedWriter;
import java.io.Writer;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Base64;

public class PemWriter extends BufferedWriter {
    /* renamed from: a */
    private final int f23453a;
    /* renamed from: b */
    private char[] f23454b = new char[64];

    public PemWriter(Writer writer) {
        super(writer);
        writer = Strings.m29418a();
        if (writer != null) {
            this.f23453a = writer.length();
        } else {
            this.f23453a = 2;
        }
    }

    /* renamed from: a */
    public void m29451a(PemObjectGenerator pemObjectGenerator) {
        pemObjectGenerator = pemObjectGenerator.mo5939d();
        m29448a(pemObjectGenerator.m36598a());
        if (!pemObjectGenerator.m36599b().isEmpty()) {
            for (PemHeader pemHeader : pemObjectGenerator.m36599b()) {
                write(pemHeader.m29445a());
                write(": ");
                write(pemHeader.m29446b());
                newLine();
            }
            newLine();
        }
        m29449a(pemObjectGenerator.m36600c());
        m29450b(pemObjectGenerator.m36598a());
    }

    /* renamed from: a */
    private void m29449a(byte[] bArr) {
        bArr = Base64.m29432a(bArr);
        int i = 0;
        while (i < bArr.length) {
            int i2 = 0;
            while (i2 != this.f23454b.length) {
                int i3 = i + i2;
                if (i3 >= bArr.length) {
                    break;
                }
                this.f23454b[i2] = (char) bArr[i3];
                i2++;
            }
            write(this.f23454b, 0, i2);
            newLine();
            i += this.f23454b.length;
        }
    }

    /* renamed from: a */
    private void m29448a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----BEGIN ");
        stringBuilder.append(str);
        stringBuilder.append("-----");
        write(stringBuilder.toString());
        newLine();
    }

    /* renamed from: b */
    private void m29450b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----END ");
        stringBuilder.append(str);
        stringBuilder.append("-----");
        write(stringBuilder.toString());
        newLine();
    }
}

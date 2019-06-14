package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.util.encoders.Base64;

public class PEMUtil {
    /* renamed from: a */
    private final String f22983a;
    /* renamed from: b */
    private final String f22984b;
    /* renamed from: c */
    private final String f22985c;
    /* renamed from: d */
    private final String f22986d;

    PEMUtil(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----BEGIN ");
        stringBuilder.append(str);
        stringBuilder.append("-----");
        this.f22983a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("-----BEGIN X509 ");
        stringBuilder.append(str);
        stringBuilder.append("-----");
        this.f22984b = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("-----END ");
        stringBuilder.append(str);
        stringBuilder.append("-----");
        this.f22985c = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("-----END X509 ");
        stringBuilder.append(str);
        stringBuilder.append("-----");
        this.f22986d = stringBuilder.toString();
    }

    /* renamed from: b */
    private String m28174b(InputStream inputStream) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = inputStream.read();
            if (read == 13 || read == 10 || read < 0) {
                if (read < 0 || stringBuffer.length() != 0) {
                    if (read >= 0) {
                        return null;
                    }
                    return stringBuffer.toString();
                }
            } else if (read != 13) {
                stringBuffer.append((char) read);
            }
        }
        if (read >= 0) {
            return stringBuffer.toString();
        }
        return null;
    }

    /* renamed from: a */
    ASN1Sequence m28175a(InputStream inputStream) {
        String b;
        StringBuffer stringBuffer = new StringBuffer();
        do {
            b = m28174b(inputStream);
            if (b == null || b.startsWith(this.f22983a)) {
                while (true) {
                    b = m28174b(inputStream);
                    stringBuffer.append(b);
                }
            }
        } while (!b.startsWith(this.f22984b));
        while (true) {
            b = m28174b(inputStream);
            if (b == null || b.startsWith(this.f22985c)) {
                break;
            } else if (b.startsWith(this.f22986d)) {
                break;
            } else {
                stringBuffer.append(b);
            }
        }
        if (stringBuffer.length() == null) {
            return null;
        }
        inputStream = new ASN1InputStream(Base64.m29431a(stringBuffer.toString())).m34595d();
        if (inputStream instanceof ASN1Sequence) {
            return (ASN1Sequence) inputStream;
        }
        throw new IOException("malformed PEM data encountered");
    }
}

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class PKCS5S1ParametersGenerator extends PBEParametersGenerator {
    /* renamed from: d */
    private Digest f26856d;

    public PKCS5S1ParametersGenerator(Digest digest) {
        this.f26856d = digest;
    }

    /* renamed from: a */
    private byte[] m35360a() {
        byte[] bArr = new byte[this.f26856d.mo5732b()];
        this.f26856d.mo5731a(this.a, 0, this.a.length);
        this.f26856d.mo5731a(this.b, 0, this.b.length);
        this.f26856d.mo5728a(bArr, 0);
        for (int i = 1; i < this.c; i++) {
            this.f26856d.mo5731a(bArr, 0, bArr.length);
            this.f26856d.mo5728a(bArr, 0);
        }
        return bArr;
    }

    /* renamed from: a */
    public CipherParameters mo5758a(int i) {
        i /= 8;
        if (i <= this.f26856d.mo5732b()) {
            return new KeyParameter(m35360a(), 0, i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't generate a derived key ");
        stringBuilder.append(i);
        stringBuilder.append(" bytes long.");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public CipherParameters mo5759a(int i, int i2) {
        i /= 8;
        i2 /= 8;
        int i3 = i + i2;
        if (i3 <= this.f26856d.mo5732b()) {
            byte[] a = m35360a();
            return new ParametersWithIV(new KeyParameter(a, 0, i), a, i, i2);
        }
        i2 = new StringBuilder();
        i2.append("Can't generate a derived key ");
        i2.append(i3);
        i2.append(" bytes long.");
        throw new IllegalArgumentException(i2.toString());
    }

    /* renamed from: b */
    public CipherParameters mo5760b(int i) {
        return mo5758a(i);
    }
}

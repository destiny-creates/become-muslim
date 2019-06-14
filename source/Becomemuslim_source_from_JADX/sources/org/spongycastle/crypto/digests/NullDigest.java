package org.spongycastle.crypto.digests;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.Digest;

public class NullDigest implements Digest {
    /* renamed from: a */
    private ByteArrayOutputStream f26489a = new ByteArrayOutputStream();

    /* renamed from: a */
    public String mo5729a() {
        return "NULL";
    }

    /* renamed from: b */
    public int mo5732b() {
        return this.f26489a.size();
    }

    /* renamed from: a */
    public void mo5730a(byte b) {
        this.f26489a.write(b);
    }

    /* renamed from: a */
    public void mo5731a(byte[] bArr, int i, int i2) {
        this.f26489a.write(bArr, i, i2);
    }

    /* renamed from: a */
    public int mo5728a(byte[] bArr, int i) {
        Object toByteArray = this.f26489a.toByteArray();
        System.arraycopy(toByteArray, 0, bArr, i, toByteArray.length);
        mo5733c();
        return toByteArray.length;
    }

    /* renamed from: c */
    public void mo5733c() {
        this.f26489a.reset();
    }
}

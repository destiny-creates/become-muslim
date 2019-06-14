package org.spongycastle.crypto.signers;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class GenericSigner implements Signer {
    /* renamed from: a */
    private final AsymmetricBlockCipher f27258a;
    /* renamed from: b */
    private final Digest f27259b;
    /* renamed from: c */
    private boolean f27260c;

    public GenericSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this.f27258a = asymmetricBlockCipher;
        this.f27259b = digest;
    }

    /* renamed from: a */
    public void mo5796a(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.f27260c = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).m35698b();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z) {
            if (!asymmetricKeyParameter.m35630a()) {
                throw new IllegalArgumentException("signing requires private key");
            }
        }
        if (!z) {
            if (asymmetricKeyParameter.m35630a()) {
                throw new IllegalArgumentException("verification requires public key");
            }
        }
        m35811b();
        this.f27258a.mo5737a(z, cipherParameters);
    }

    /* renamed from: a */
    public void mo5795a(byte b) {
        this.f27259b.mo5730a(b);
    }

    /* renamed from: a */
    public void mo5797a(byte[] bArr, int i, int i2) {
        this.f27259b.mo5731a(bArr, i, i2);
    }

    /* renamed from: a */
    public byte[] mo5799a() {
        if (this.f27260c) {
            byte[] bArr = new byte[this.f27259b.mo5732b()];
            this.f27259b.mo5728a(bArr, 0);
            return this.f27258a.mo5738a(bArr, 0, bArr.length);
        }
        throw new IllegalStateException("GenericSigner not initialised for signature generation.");
    }

    /* renamed from: a */
    public boolean mo5798a(byte[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.f27260c;
        if (r0 != 0) goto L_0x002e;
    L_0x0004:
        r0 = r5.f27259b;
        r0 = r0.mo5732b();
        r0 = new byte[r0];
        r1 = r5.f27259b;
        r2 = 0;
        r1.mo5728a(r0, r2);
        r1 = r5.f27258a;	 Catch:{ Exception -> 0x002d }
        r3 = r6.length;	 Catch:{ Exception -> 0x002d }
        r6 = r1.mo5738a(r6, r2, r3);	 Catch:{ Exception -> 0x002d }
        r1 = r6.length;	 Catch:{ Exception -> 0x002d }
        r3 = r0.length;	 Catch:{ Exception -> 0x002d }
        if (r1 >= r3) goto L_0x0028;	 Catch:{ Exception -> 0x002d }
    L_0x001d:
        r1 = r0.length;	 Catch:{ Exception -> 0x002d }
        r1 = new byte[r1];	 Catch:{ Exception -> 0x002d }
        r3 = r1.length;	 Catch:{ Exception -> 0x002d }
        r4 = r6.length;	 Catch:{ Exception -> 0x002d }
        r3 = r3 - r4;	 Catch:{ Exception -> 0x002d }
        r4 = r6.length;	 Catch:{ Exception -> 0x002d }
        java.lang.System.arraycopy(r6, r2, r1, r3, r4);	 Catch:{ Exception -> 0x002d }
        r6 = r1;	 Catch:{ Exception -> 0x002d }
    L_0x0028:
        r6 = org.spongycastle.util.Arrays.m29372b(r6, r0);	 Catch:{ Exception -> 0x002d }
        return r6;
    L_0x002d:
        return r2;
    L_0x002e:
        r6 = new java.lang.IllegalStateException;
        r0 = "GenericSigner not initialised for verification";
        r6.<init>(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.signers.GenericSigner.a(byte[]):boolean");
    }

    /* renamed from: b */
    public void m35811b() {
        this.f27259b.mo5733c();
    }
}

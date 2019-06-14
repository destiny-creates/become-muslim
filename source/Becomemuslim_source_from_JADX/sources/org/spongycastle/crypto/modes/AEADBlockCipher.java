package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;

public interface AEADBlockCipher {
    /* renamed from: a */
    int mo5768a(int i);

    /* renamed from: a */
    int mo5769a(byte[] bArr, int i);

    /* renamed from: a */
    int mo5770a(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    /* renamed from: a */
    BlockCipher mo5771a();

    /* renamed from: a */
    void mo5772a(boolean z, CipherParameters cipherParameters);

    /* renamed from: a */
    void mo5773a(byte[] bArr, int i, int i2);

    /* renamed from: b */
    int mo5774b(int i);
}

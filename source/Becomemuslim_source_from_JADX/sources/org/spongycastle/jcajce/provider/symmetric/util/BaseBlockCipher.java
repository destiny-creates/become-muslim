package org.spongycastle.jcajce.provider.symmetric.util;

import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.CTSBlockCipher;
import org.spongycastle.crypto.modes.EAXBlockCipher;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.GOFBBlockCipher;
import org.spongycastle.crypto.modes.OCBBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.spongycastle.crypto.modes.PGPCFBBlockCipher;
import org.spongycastle.crypto.modes.SICBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.paddings.ISO10126d2Padding;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.paddings.TBCPadding;
import org.spongycastle.crypto.paddings.X923Padding;
import org.spongycastle.crypto.paddings.ZeroBytePadding;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.util.Strings;

public class BaseBlockCipher extends BaseWrapCipher implements PBE {
    /* renamed from: e */
    private static final Class f31962e = m41113c("javax.crypto.spec.GCMParameterSpec");
    /* renamed from: f */
    private Class[] f31963f;
    /* renamed from: g */
    private BlockCipher f31964g;
    /* renamed from: h */
    private BlockCipherProvider f31965h;
    /* renamed from: i */
    private GenericBlockCipher f31966i;
    /* renamed from: j */
    private ParametersWithIV f31967j;
    /* renamed from: k */
    private AEADParameters f31968k;
    /* renamed from: l */
    private int f31969l;
    /* renamed from: m */
    private int f31970m;
    /* renamed from: n */
    private int f31971n;
    /* renamed from: o */
    private int f31972o;
    /* renamed from: p */
    private boolean f31973p;
    /* renamed from: q */
    private boolean f31974q;
    /* renamed from: r */
    private PBEParameterSpec f31975r;
    /* renamed from: s */
    private String f31976s;
    /* renamed from: t */
    private String f31977t;

    private interface GenericBlockCipher {
        /* renamed from: a */
        int mo5867a(int i);

        /* renamed from: a */
        int mo5868a(byte[] bArr, int i);

        /* renamed from: a */
        int mo5869a(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

        /* renamed from: a */
        String mo5870a();

        /* renamed from: a */
        void mo5871a(boolean z, CipherParameters cipherParameters);

        /* renamed from: a */
        void mo5872a(byte[] bArr, int i, int i2);

        /* renamed from: b */
        int mo5873b(int i);

        /* renamed from: b */
        boolean mo5874b();

        /* renamed from: c */
        BlockCipher mo5875c();
    }

    private static class AEADGenericBlockCipher implements GenericBlockCipher {
        /* renamed from: a */
        private static final Constructor f27490a;
        /* renamed from: b */
        private AEADBlockCipher f27491b;

        /* renamed from: b */
        public boolean mo5874b() {
            return false;
        }

        static {
            Class a = BaseBlockCipher.m41113c("javax.crypto.AEADBadTagException");
            if (a != null) {
                f27490a = m36101a(a);
            } else {
                f27490a = null;
            }
        }

        /* renamed from: a */
        private static java.lang.reflect.Constructor m36101a(java.lang.Class r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = 1;
            r0 = new java.lang.Class[r0];	 Catch:{ Exception -> 0x000d }
            r1 = 0;	 Catch:{ Exception -> 0x000d }
            r2 = java.lang.String.class;	 Catch:{ Exception -> 0x000d }
            r0[r1] = r2;	 Catch:{ Exception -> 0x000d }
            r3 = r3.getConstructor(r0);	 Catch:{ Exception -> 0x000d }
            return r3;
        L_0x000d:
            r3 = 0;
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher.a(java.lang.Class):java.lang.reflect.Constructor");
        }

        AEADGenericBlockCipher(AEADBlockCipher aEADBlockCipher) {
            this.f27491b = aEADBlockCipher;
        }

        /* renamed from: a */
        public void mo5871a(boolean z, CipherParameters cipherParameters) {
            this.f27491b.mo5772a(z, cipherParameters);
        }

        /* renamed from: a */
        public String mo5870a() {
            return this.f27491b.mo5771a().mo5741a();
        }

        /* renamed from: c */
        public BlockCipher mo5875c() {
            return this.f27491b.mo5771a();
        }

        /* renamed from: a */
        public int mo5867a(int i) {
            return this.f27491b.mo5774b(i);
        }

        /* renamed from: b */
        public int mo5873b(int i) {
            return this.f27491b.mo5768a(i);
        }

        /* renamed from: a */
        public void mo5872a(byte[] bArr, int i, int i2) {
            this.f27491b.mo5773a(bArr, i, i2);
        }

        /* renamed from: a */
        public int mo5869a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            return this.f27491b.mo5770a(bArr, i, i2, bArr2, i3);
        }

        /* renamed from: a */
        public int mo5868a(byte[] r5, int r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r4.f27491b;	 Catch:{ InvalidCipherTextException -> 0x0007 }
            r5 = r0.mo5769a(r5, r6);	 Catch:{ InvalidCipherTextException -> 0x0007 }
            return r5;
        L_0x0007:
            r5 = move-exception;
            r6 = f27490a;
            if (r6 == 0) goto L_0x0023;
        L_0x000c:
            r6 = 0;
            r0 = f27490a;	 Catch:{ Exception -> 0x0020 }
            r1 = 1;	 Catch:{ Exception -> 0x0020 }
            r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0020 }
            r2 = 0;	 Catch:{ Exception -> 0x0020 }
            r3 = r5.getMessage();	 Catch:{ Exception -> 0x0020 }
            r1[r2] = r3;	 Catch:{ Exception -> 0x0020 }
            r0 = r0.newInstance(r1);	 Catch:{ Exception -> 0x0020 }
            r0 = (javax.crypto.BadPaddingException) r0;	 Catch:{ Exception -> 0x0020 }
            r6 = r0;
        L_0x0020:
            if (r6 == 0) goto L_0x0023;
        L_0x0022:
            throw r6;
        L_0x0023:
            r6 = new javax.crypto.BadPaddingException;
            r5 = r5.getMessage();
            r6.<init>(r5);
            throw r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher.a(byte[], int):int");
        }
    }

    private static class BufferedGenericBlockCipher implements GenericBlockCipher {
        /* renamed from: a */
        private BufferedBlockCipher f27492a;

        BufferedGenericBlockCipher(BufferedBlockCipher bufferedBlockCipher) {
            this.f27492a = bufferedBlockCipher;
        }

        BufferedGenericBlockCipher(BlockCipher blockCipher) {
            this.f27492a = new PaddedBufferedBlockCipher(blockCipher);
        }

        BufferedGenericBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.f27492a = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }

        /* renamed from: a */
        public void mo5871a(boolean z, CipherParameters cipherParameters) {
            this.f27492a.mo5786a(z, cipherParameters);
        }

        /* renamed from: b */
        public boolean mo5874b() {
            return !(this.f27492a instanceof CTSBlockCipher);
        }

        /* renamed from: a */
        public String mo5870a() {
            return this.f27492a.m27301a().mo5741a();
        }

        /* renamed from: c */
        public BlockCipher mo5875c() {
            return this.f27492a.m27301a();
        }

        /* renamed from: a */
        public int mo5867a(int i) {
            return this.f27492a.mo5778b(i);
        }

        /* renamed from: b */
        public int mo5873b(int i) {
            return this.f27492a.mo5775a(i);
        }

        /* renamed from: a */
        public void mo5872a(byte[] bArr, int i, int i2) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        /* renamed from: a */
        public int mo5869a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            return this.f27492a.mo5777a(bArr, i, i2, bArr2, i3);
        }

        /* renamed from: a */
        public int mo5868a(byte[] bArr, int i) {
            try {
                return this.f27492a.mo5776a(bArr, i);
            } catch (byte[] bArr2) {
                throw new BadPaddingException(bArr2.getMessage());
            }
        }
    }

    /* renamed from: c */
    private static java.lang.Class m41113c(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.class;	 Catch:{ Exception -> 0x000b }
        r0 = r0.getClassLoader();	 Catch:{ Exception -> 0x000b }
        r1 = r0.loadClass(r1);	 Catch:{ Exception -> 0x000b }
        return r1;
    L_0x000b:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c(java.lang.String):java.lang.Class");
    }

    protected BaseBlockCipher(BlockCipher blockCipher) {
        this.f31963f = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, f31962e, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.f31970m = -1;
        this.f31972o = 0;
        this.f31974q = true;
        this.f31975r = null;
        this.f31976s = null;
        this.f31977t = null;
        this.f31964g = blockCipher;
        this.f31966i = new BufferedGenericBlockCipher(blockCipher);
    }

    protected BaseBlockCipher(BlockCipher blockCipher, int i, int i2, int i3, int i4) {
        this.f31963f = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, f31962e, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.f31970m = -1;
        this.f31972o = 0;
        this.f31974q = true;
        this.f31975r = null;
        this.f31976s = null;
        this.f31977t = null;
        this.f31964g = blockCipher;
        this.f31970m = i;
        this.f31971n = i2;
        this.f31969l = i3;
        this.f31972o = i4;
        this.f31966i = new BufferedGenericBlockCipher(blockCipher);
    }

    protected BaseBlockCipher(BlockCipherProvider blockCipherProvider) {
        this.f31963f = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, f31962e, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.f31970m = -1;
        this.f31972o = 0;
        this.f31974q = true;
        this.f31975r = null;
        this.f31976s = null;
        this.f31977t = null;
        this.f31964g = blockCipherProvider.mo5863a();
        this.f31965h = blockCipherProvider;
        this.f31966i = new BufferedGenericBlockCipher(blockCipherProvider.mo5863a());
    }

    protected BaseBlockCipher(AEADBlockCipher aEADBlockCipher) {
        this.f31963f = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, f31962e, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.f31970m = -1;
        this.f31972o = 0;
        this.f31974q = true;
        this.f31975r = null;
        this.f31976s = null;
        this.f31977t = null;
        this.f31964g = aEADBlockCipher.mo5771a();
        this.f31972o = this.f31964g.mo5743b();
        this.f31966i = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    protected BaseBlockCipher(AEADBlockCipher aEADBlockCipher, boolean z, int i) {
        this.f31963f = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, f31962e, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.f31970m = -1;
        this.f31972o = 0;
        this.f31974q = true;
        this.f31975r = null;
        this.f31976s = null;
        this.f31977t = null;
        this.f31964g = aEADBlockCipher.mo5771a();
        this.f31974q = z;
        this.f31972o = i;
        this.f31966i = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    protected BaseBlockCipher(BlockCipher blockCipher, int i) {
        this.f31963f = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, f31962e, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.f31970m = -1;
        this.f31972o = 0;
        this.f31974q = true;
        this.f31975r = null;
        this.f31976s = null;
        this.f31977t = null;
        this.f31964g = blockCipher;
        this.f31966i = new BufferedGenericBlockCipher(blockCipher);
        this.f31972o = i / 8;
    }

    protected BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, int i) {
        this.f31963f = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, f31962e, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
        this.f31970m = -1;
        this.f31972o = 0;
        this.f31974q = true;
        this.f31975r = null;
        this.f31976s = null;
        this.f31977t = null;
        this.f31964g = bufferedBlockCipher.m27301a();
        this.f31966i = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.f31972o = i / 8;
    }

    protected int engineGetBlockSize() {
        return this.f31964g.mo5743b();
    }

    protected byte[] engineGetIV() {
        if (this.f31968k != null) {
            return this.f31968k.m35629d();
        }
        return this.f31967j != null ? this.f31967j.m35695a() : null;
    }

    protected int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    protected int engineGetOutputSize(int i) {
        return this.f31966i.mo5867a(i);
    }

    protected java.security.AlgorithmParameters engineGetParameters() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.c;
        if (r0 != 0) goto L_0x008a;
    L_0x0004:
        r0 = r4.f31975r;
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r4.f31976s;	 Catch:{ Exception -> 0x0018 }
        r0 = r4.m36121b(r0);	 Catch:{ Exception -> 0x0018 }
        r4.c = r0;	 Catch:{ Exception -> 0x0018 }
        r0 = r4.c;	 Catch:{ Exception -> 0x0018 }
        r1 = r4.f31975r;	 Catch:{ Exception -> 0x0018 }
        r0.init(r1);	 Catch:{ Exception -> 0x0018 }
        goto L_0x008a;
    L_0x0018:
        r0 = 0;
        return r0;
    L_0x001a:
        r0 = r4.f31967j;
        if (r0 == 0) goto L_0x0056;
    L_0x001e:
        r0 = r4.f31966i;
        r0 = r0.mo5875c();
        r0 = r0.mo5741a();
        r1 = 47;
        r2 = r0.indexOf(r1);
        if (r2 < 0) goto L_0x0039;
    L_0x0030:
        r2 = 0;
        r1 = r0.indexOf(r1);
        r0 = r0.substring(r2, r1);
    L_0x0039:
        r0 = r4.m36121b(r0);	 Catch:{ Exception -> 0x004b }
        r4.c = r0;	 Catch:{ Exception -> 0x004b }
        r0 = r4.c;	 Catch:{ Exception -> 0x004b }
        r1 = r4.f31967j;	 Catch:{ Exception -> 0x004b }
        r1 = r1.m35695a();	 Catch:{ Exception -> 0x004b }
        r0.init(r1);	 Catch:{ Exception -> 0x004b }
        goto L_0x008a;
    L_0x004b:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0056:
        r0 = r4.f31968k;
        if (r0 == 0) goto L_0x008a;
    L_0x005a:
        r0 = "GCM";	 Catch:{ Exception -> 0x007f }
        r0 = r4.m36121b(r0);	 Catch:{ Exception -> 0x007f }
        r4.c = r0;	 Catch:{ Exception -> 0x007f }
        r0 = r4.c;	 Catch:{ Exception -> 0x007f }
        r1 = new org.spongycastle.asn1.cms.GCMParameters;	 Catch:{ Exception -> 0x007f }
        r2 = r4.f31968k;	 Catch:{ Exception -> 0x007f }
        r2 = r2.m35629d();	 Catch:{ Exception -> 0x007f }
        r3 = r4.f31968k;	 Catch:{ Exception -> 0x007f }
        r3 = r3.m35627b();	 Catch:{ Exception -> 0x007f }
        r3 = r3 / 8;	 Catch:{ Exception -> 0x007f }
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x007f }
        r1 = r1.mo6822f();	 Catch:{ Exception -> 0x007f }
        r0.init(r1);	 Catch:{ Exception -> 0x007f }
        goto L_0x008a;
    L_0x007f:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x008a:
        r0 = r4.c;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.engineGetParameters():java.security.AlgorithmParameters");
    }

    protected void engineSetMode(String str) {
        this.f31977t = Strings.m29424b(str);
        if (this.f31977t.equals("ECB")) {
            this.f31972o = 0;
            this.f31966i = new BufferedGenericBlockCipher(this.f31964g);
        } else if (this.f31977t.equals("CBC")) {
            this.f31972o = this.f31964g.mo5743b();
            this.f31966i = new BufferedGenericBlockCipher(new CBCBlockCipher(this.f31964g));
        } else if (this.f31977t.startsWith("OFB")) {
            this.f31972o = this.f31964g.mo5743b();
            if (this.f31977t.length() != 3) {
                this.f31966i = new BufferedGenericBlockCipher(new OFBBlockCipher(this.f31964g, Integer.parseInt(this.f31977t.substring(3))));
                return;
            }
            this.f31966i = new BufferedGenericBlockCipher(new OFBBlockCipher(this.f31964g, this.f31964g.mo5743b() * 8));
        } else if (this.f31977t.startsWith("CFB")) {
            this.f31972o = this.f31964g.mo5743b();
            if (this.f31977t.length() != 3) {
                this.f31966i = new BufferedGenericBlockCipher(new CFBBlockCipher(this.f31964g, Integer.parseInt(this.f31977t.substring(3))));
                return;
            }
            this.f31966i = new BufferedGenericBlockCipher(new CFBBlockCipher(this.f31964g, this.f31964g.mo5743b() * 8));
        } else if (this.f31977t.startsWith("PGP")) {
            str = this.f31977t.equalsIgnoreCase("PGPCFBwithIV");
            this.f31972o = this.f31964g.mo5743b();
            this.f31966i = new BufferedGenericBlockCipher(new PGPCFBBlockCipher(this.f31964g, str));
        } else if (this.f31977t.equalsIgnoreCase("OpenPGPCFB")) {
            this.f31972o = 0;
            this.f31966i = new BufferedGenericBlockCipher(new OpenPGPCFBBlockCipher(this.f31964g));
        } else if (this.f31977t.startsWith("SIC")) {
            this.f31972o = this.f31964g.mo5743b();
            if (this.f31972o >= 16) {
                this.f31966i = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.f31964g)));
                return;
            }
            throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
        } else if (this.f31977t.startsWith("CTR")) {
            this.f31972o = this.f31964g.mo5743b();
            this.f31966i = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.f31964g)));
        } else if (this.f31977t.startsWith("GOFB")) {
            this.f31972o = this.f31964g.mo5743b();
            this.f31966i = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(this.f31964g)));
        } else if (this.f31977t.startsWith("GCFB")) {
            this.f31972o = this.f31964g.mo5743b();
            this.f31966i = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GCFBBlockCipher(this.f31964g)));
        } else if (this.f31977t.startsWith("CTS")) {
            this.f31972o = this.f31964g.mo5743b();
            this.f31966i = new BufferedGenericBlockCipher(new CTSBlockCipher(new CBCBlockCipher(this.f31964g)));
        } else if (this.f31977t.startsWith("CCM")) {
            this.f31972o = 13;
            this.f31966i = new AEADGenericBlockCipher(new CCMBlockCipher(this.f31964g));
        } else if (this.f31977t.startsWith("OCB")) {
            if (this.f31965h != null) {
                this.f31972o = 15;
                this.f31966i = new AEADGenericBlockCipher(new OCBBlockCipher(this.f31964g, this.f31965h.mo5863a()));
                return;
            }
            r1 = new StringBuilder();
            r1.append("can't support mode ");
            r1.append(str);
            throw new NoSuchAlgorithmException(r1.toString());
        } else if (this.f31977t.startsWith("EAX")) {
            this.f31972o = this.f31964g.mo5743b();
            this.f31966i = new AEADGenericBlockCipher(new EAXBlockCipher(this.f31964g));
        } else if (this.f31977t.startsWith("GCM")) {
            this.f31972o = this.f31964g.mo5743b();
            this.f31966i = new AEADGenericBlockCipher(new GCMBlockCipher(this.f31964g));
        } else {
            r1 = new StringBuilder();
            r1.append("can't support mode ");
            r1.append(str);
            throw new NoSuchAlgorithmException(r1.toString());
        }
    }

    protected void engineSetPadding(String str) {
        String b = Strings.m29424b(str);
        if (b.equals("NOPADDING")) {
            if (this.f31966i.mo5874b() != null) {
                this.f31966i = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.f31966i.mo5875c()));
            }
        } else if (b.equals("WITHCTS")) {
            this.f31966i = new BufferedGenericBlockCipher(new CTSBlockCipher(this.f31966i.mo5875c()));
        } else {
            this.f31973p = true;
            if (m41114d(this.f31977t)) {
                throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
            }
            if (!b.equals("PKCS5PADDING")) {
                if (!b.equals("PKCS7PADDING")) {
                    if (b.equals("ZEROBYTEPADDING")) {
                        this.f31966i = new BufferedGenericBlockCipher(this.f31966i.mo5875c(), new ZeroBytePadding());
                        return;
                    }
                    if (!b.equals("ISO10126PADDING")) {
                        if (!b.equals("ISO10126-2PADDING")) {
                            if (!b.equals("X9.23PADDING")) {
                                if (!b.equals("X923PADDING")) {
                                    if (!b.equals("ISO7816-4PADDING")) {
                                        if (!b.equals("ISO9797-1PADDING")) {
                                            if (b.equals("TBCPADDING")) {
                                                this.f31966i = new BufferedGenericBlockCipher(this.f31966i.mo5875c(), new TBCPadding());
                                                return;
                                            }
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("Padding ");
                                            stringBuilder.append(str);
                                            stringBuilder.append(" unknown.");
                                            throw new NoSuchPaddingException(stringBuilder.toString());
                                        }
                                    }
                                    this.f31966i = new BufferedGenericBlockCipher(this.f31966i.mo5875c(), new ISO7816d4Padding());
                                    return;
                                }
                            }
                            this.f31966i = new BufferedGenericBlockCipher(this.f31966i.mo5875c(), new X923Padding());
                            return;
                        }
                    }
                    this.f31966i = new BufferedGenericBlockCipher(this.f31966i.mo5875c(), new ISO10126d2Padding());
                    return;
                }
            }
            this.f31966i = new BufferedGenericBlockCipher(this.f31966i.mo5875c());
        }
    }

    protected void engineInit(int r18, java.security.Key r19, java.security.spec.AlgorithmParameterSpec r20, java.security.SecureRandom r21) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r17 = this;
        r1 = r17;
        r0 = r18;
        r2 = r19;
        r3 = r20;
        r4 = r21;
        r5 = 0;
        r1.f31975r = r5;
        r1.f31976s = r5;
        r1.c = r5;
        r1.f31968k = r5;
        r6 = r2 instanceof javax.crypto.SecretKey;
        if (r6 == 0) goto L_0x0480;
    L_0x0017:
        if (r3 != 0) goto L_0x0030;
    L_0x0019:
        r6 = r1.f31964g;
        r6 = r6.mo5741a();
        r7 = "RC5-64";
        r6 = r6.startsWith(r7);
        if (r6 != 0) goto L_0x0028;
    L_0x0027:
        goto L_0x0030;
    L_0x0028:
        r0 = new java.security.InvalidAlgorithmParameterException;
        r2 = "RC5 requires an RC5ParametersSpec to be passed in.";
        r0.<init>(r2);
        throw r0;
    L_0x0030:
        r6 = r1.f31970m;
        r7 = 2;
        r8 = 1;
        if (r6 == r7) goto L_0x0151;
    L_0x0036:
        r6 = r2 instanceof org.spongycastle.jcajce.PKCS12Key;
        if (r6 == 0) goto L_0x003c;
    L_0x003a:
        goto L_0x0151;
    L_0x003c:
        r6 = r2 instanceof org.spongycastle.jcajce.PBKDF1Key;
        if (r6 == 0) goto L_0x008a;
    L_0x0040:
        r5 = r2;
        r5 = (org.spongycastle.jcajce.PBKDF1Key) r5;
        r6 = r3 instanceof javax.crypto.spec.PBEParameterSpec;
        if (r6 == 0) goto L_0x004c;
    L_0x0047:
        r6 = r3;
        r6 = (javax.crypto.spec.PBEParameterSpec) r6;
        r1.f31975r = r6;
    L_0x004c:
        r6 = r5 instanceof org.spongycastle.jcajce.PBKDF1KeyWithParameters;
        if (r6 == 0) goto L_0x0066;
    L_0x0050:
        r6 = r1.f31975r;
        if (r6 != 0) goto L_0x0066;
    L_0x0054:
        r6 = new javax.crypto.spec.PBEParameterSpec;
        r7 = r5;
        r7 = (org.spongycastle.jcajce.PBKDF1KeyWithParameters) r7;
        r9 = r7.getSalt();
        r7 = r7.getIterationCount();
        r6.<init>(r9, r7);
        r1.f31975r = r6;
    L_0x0066:
        r10 = r5.getEncoded();
        r11 = 0;
        r12 = r1.f31971n;
        r13 = r1.f31969l;
        r5 = r1.f31972o;
        r14 = r5 * 8;
        r15 = r1.f31975r;
        r5 = r1.f31966i;
        r16 = r5.mo5870a();
        r5 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.m28094a(r10, r11, r12, r13, r14, r15, r16);
        r6 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV;
        if (r6 == 0) goto L_0x01a8;
    L_0x0083:
        r6 = r5;
        r6 = (org.spongycastle.crypto.params.ParametersWithIV) r6;
        r1.f31967j = r6;
        goto L_0x01a8;
    L_0x008a:
        r6 = r2 instanceof org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
        if (r6 == 0) goto L_0x00e1;
    L_0x008e:
        r5 = r2;
        r5 = (org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey) r5;
        r6 = r5.m28074f();
        if (r6 == 0) goto L_0x00a2;
    L_0x0097:
        r6 = r5.m28074f();
        r6 = r6.m42986b();
        r1.f31976s = r6;
        goto L_0x00a8;
    L_0x00a2:
        r6 = r5.getAlgorithm();
        r1.f31976s = r6;
    L_0x00a8:
        r6 = r5.m28073e();
        if (r6 == 0) goto L_0x00b7;
    L_0x00ae:
        r5 = r5.m28073e();
        r5 = r1.m41112a(r3, r5);
        goto L_0x00ce;
    L_0x00b7:
        r6 = r3 instanceof javax.crypto.spec.PBEParameterSpec;
        if (r6 == 0) goto L_0x00d9;
    L_0x00bb:
        r6 = r3;
        r6 = (javax.crypto.spec.PBEParameterSpec) r6;
        r1.f31975r = r6;
        r6 = r1.f31966i;
        r6 = r6.mo5875c();
        r6 = r6.mo5741a();
        r5 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.m28093a(r5, r3, r6);
    L_0x00ce:
        r6 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV;
        if (r6 == 0) goto L_0x01a8;
    L_0x00d2:
        r6 = r5;
        r6 = (org.spongycastle.crypto.params.ParametersWithIV) r6;
        r1.f31967j = r6;
        goto L_0x01a8;
    L_0x00d9:
        r0 = new java.security.InvalidAlgorithmParameterException;
        r2 = "PBE requires PBE parameters to be set.";
        r0.<init>(r2);
        throw r0;
    L_0x00e1:
        r6 = r2 instanceof javax.crypto.interfaces.PBEKey;
        if (r6 == 0) goto L_0x0129;
    L_0x00e5:
        r5 = r2;
        r5 = (javax.crypto.interfaces.PBEKey) r5;
        r6 = r3;
        r6 = (javax.crypto.spec.PBEParameterSpec) r6;
        r1.f31975r = r6;
        r6 = r5 instanceof org.spongycastle.jcajce.PKCS12KeyWithParameters;
        if (r6 == 0) goto L_0x0104;
    L_0x00f1:
        r6 = r1.f31975r;
        if (r6 != 0) goto L_0x0104;
    L_0x00f5:
        r6 = new javax.crypto.spec.PBEParameterSpec;
        r7 = r5.getSalt();
        r9 = r5.getIterationCount();
        r6.<init>(r7, r9);
        r1.f31975r = r6;
    L_0x0104:
        r10 = r5.getEncoded();
        r11 = r1.f31970m;
        r12 = r1.f31971n;
        r13 = r1.f31969l;
        r5 = r1.f31972o;
        r14 = r5 * 8;
        r15 = r1.f31975r;
        r5 = r1.f31966i;
        r16 = r5.mo5870a();
        r5 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.m28094a(r10, r11, r12, r13, r14, r15, r16);
        r6 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV;
        if (r6 == 0) goto L_0x01a8;
    L_0x0122:
        r6 = r5;
        r6 = (org.spongycastle.crypto.params.ParametersWithIV) r6;
        r1.f31967j = r6;
        goto L_0x01a8;
    L_0x0129:
        r6 = r2 instanceof org.spongycastle.jcajce.spec.RepeatedSecretKeySpec;
        if (r6 != 0) goto L_0x01a8;
    L_0x012d:
        r5 = r1.f31970m;
        if (r5 == 0) goto L_0x0149;
    L_0x0131:
        r5 = r1.f31970m;
        r6 = 4;
        if (r5 == r6) goto L_0x0149;
    L_0x0136:
        r5 = r1.f31970m;
        if (r5 == r8) goto L_0x0149;
    L_0x013a:
        r5 = r1.f31970m;
        r6 = 5;
        if (r5 == r6) goto L_0x0149;
    L_0x013f:
        r5 = new org.spongycastle.crypto.params.KeyParameter;
        r6 = r19.getEncoded();
        r5.<init>(r6);
        goto L_0x01a8;
    L_0x0149:
        r0 = new java.security.InvalidKeyException;
        r2 = "Algorithm requires a PBE key";
        r0.<init>(r2);
        throw r0;
    L_0x0151:
        r5 = r2;	 Catch:{ Exception -> 0x0478 }
        r5 = (javax.crypto.SecretKey) r5;	 Catch:{ Exception -> 0x0478 }
        r6 = r3 instanceof javax.crypto.spec.PBEParameterSpec;
        if (r6 == 0) goto L_0x015d;
    L_0x0158:
        r6 = r3;
        r6 = (javax.crypto.spec.PBEParameterSpec) r6;
        r1.f31975r = r6;
    L_0x015d:
        r6 = r5 instanceof javax.crypto.interfaces.PBEKey;
        if (r6 == 0) goto L_0x0177;
    L_0x0161:
        r7 = r1.f31975r;
        if (r7 != 0) goto L_0x0177;
    L_0x0165:
        r7 = new javax.crypto.spec.PBEParameterSpec;
        r9 = r5;
        r9 = (javax.crypto.interfaces.PBEKey) r9;
        r10 = r9.getSalt();
        r9 = r9.getIterationCount();
        r7.<init>(r10, r9);
        r1.f31975r = r7;
    L_0x0177:
        r7 = r1.f31975r;
        if (r7 != 0) goto L_0x0186;
    L_0x017b:
        if (r6 == 0) goto L_0x017e;
    L_0x017d:
        goto L_0x0186;
    L_0x017e:
        r0 = new java.security.InvalidKeyException;
        r2 = "Algorithm requires a PBE key";
        r0.<init>(r2);
        throw r0;
    L_0x0186:
        r9 = r5.getEncoded();
        r10 = 2;
        r11 = r1.f31971n;
        r12 = r1.f31969l;
        r5 = r1.f31972o;
        r13 = r5 * 8;
        r14 = r1.f31975r;
        r5 = r1.f31966i;
        r15 = r5.mo5870a();
        r5 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.m28094a(r9, r10, r11, r12, r13, r14, r15);
        r6 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV;
        if (r6 == 0) goto L_0x01a8;
    L_0x01a3:
        r6 = r5;
        r6 = (org.spongycastle.crypto.params.ParametersWithIV) r6;
        r1.f31967j = r6;
    L_0x01a8:
        r6 = r3 instanceof javax.crypto.spec.IvParameterSpec;
        r7 = 0;
        if (r6 == 0) goto L_0x0224;
    L_0x01ad:
        r2 = r1.f31972o;
        if (r2 == 0) goto L_0x020c;
    L_0x01b1:
        r2 = r3;
        r2 = (javax.crypto.spec.IvParameterSpec) r2;
        r3 = r2.getIV();
        r3 = r3.length;
        r6 = r1.f31972o;
        if (r3 == r6) goto L_0x01e6;
    L_0x01bd:
        r3 = r1.f31966i;
        r3 = r3 instanceof org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher;
        if (r3 != 0) goto L_0x01e6;
    L_0x01c3:
        r3 = r1.f31974q;
        if (r3 != 0) goto L_0x01c8;
    L_0x01c7:
        goto L_0x01e6;
    L_0x01c8:
        r0 = new java.security.InvalidAlgorithmParameterException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "IV must be ";
        r2.append(r3);
        r3 = r1.f31972o;
        r2.append(r3);
        r3 = " bytes long.";
        r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r2);
        throw r0;
    L_0x01e6:
        r3 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV;
        if (r3 == 0) goto L_0x01fb;
    L_0x01ea:
        r3 = new org.spongycastle.crypto.params.ParametersWithIV;
        r5 = (org.spongycastle.crypto.params.ParametersWithIV) r5;
        r5 = r5.m35696b();
        r2 = r2.getIV();
        r3.<init>(r5, r2);
    L_0x01f9:
        r5 = r3;
        goto L_0x0205;
    L_0x01fb:
        r3 = new org.spongycastle.crypto.params.ParametersWithIV;
        r2 = r2.getIV();
        r3.<init>(r5, r2);
        goto L_0x01f9;
    L_0x0205:
        r2 = r5;
        r2 = (org.spongycastle.crypto.params.ParametersWithIV) r2;
        r1.f31967j = r2;
        goto L_0x03ec;
    L_0x020c:
        r2 = r1.f31977t;
        if (r2 == 0) goto L_0x03ec;
    L_0x0210:
        r2 = r1.f31977t;
        r3 = "ECB";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x021c;
    L_0x021a:
        goto L_0x03ec;
    L_0x021c:
        r0 = new java.security.InvalidAlgorithmParameterException;
        r2 = "ECB mode does not use an IV";
        r0.<init>(r2);
        throw r0;
    L_0x0224:
        r6 = r3 instanceof org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
        if (r6 == 0) goto L_0x026b;
    L_0x0228:
        r3 = (org.spongycastle.jcajce.spec.GOST28147ParameterSpec) r3;
        r5 = new org.spongycastle.crypto.params.ParametersWithSBox;
        r6 = new org.spongycastle.crypto.params.KeyParameter;
        r2 = r19.getEncoded();
        r6.<init>(r2);
        r2 = r3.m28104a();
        r5.<init>(r6, r2);
        r2 = r3.m28105b();
        if (r2 == 0) goto L_0x03ec;
    L_0x0242:
        r2 = r1.f31972o;
        if (r2 == 0) goto L_0x03ec;
    L_0x0246:
        r2 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV;
        if (r2 == 0) goto L_0x025a;
    L_0x024a:
        r2 = new org.spongycastle.crypto.params.ParametersWithIV;
        r5 = (org.spongycastle.crypto.params.ParametersWithIV) r5;
        r5 = r5.m35696b();
        r3 = r3.m28105b();
        r2.<init>(r5, r3);
        goto L_0x0263;
    L_0x025a:
        r2 = new org.spongycastle.crypto.params.ParametersWithIV;
        r3 = r3.m28105b();
        r2.<init>(r5, r3);
    L_0x0263:
        r3 = r2;
        r3 = (org.spongycastle.crypto.params.ParametersWithIV) r3;
        r1.f31967j = r3;
    L_0x0268:
        r5 = r2;
        goto L_0x03ec;
    L_0x026b:
        r6 = r3 instanceof javax.crypto.spec.RC2ParameterSpec;
        if (r6 == 0) goto L_0x02ab;
    L_0x026f:
        r3 = (javax.crypto.spec.RC2ParameterSpec) r3;
        r5 = new org.spongycastle.crypto.params.RC2Parameters;
        r2 = r19.getEncoded();
        r6 = r3.getEffectiveKeyBits();
        r5.<init>(r2, r6);
        r2 = r3.getIV();
        if (r2 == 0) goto L_0x03ec;
    L_0x0284:
        r2 = r1.f31972o;
        if (r2 == 0) goto L_0x03ec;
    L_0x0288:
        r2 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV;
        if (r2 == 0) goto L_0x029c;
    L_0x028c:
        r2 = new org.spongycastle.crypto.params.ParametersWithIV;
        r5 = (org.spongycastle.crypto.params.ParametersWithIV) r5;
        r5 = r5.m35696b();
        r3 = r3.getIV();
        r2.<init>(r5, r3);
        goto L_0x02a5;
    L_0x029c:
        r2 = new org.spongycastle.crypto.params.ParametersWithIV;
        r3 = r3.getIV();
        r2.<init>(r5, r3);
    L_0x02a5:
        r3 = r2;
        r3 = (org.spongycastle.crypto.params.ParametersWithIV) r3;
        r1.f31967j = r3;
        goto L_0x0268;
    L_0x02ab:
        r6 = r3 instanceof javax.crypto.spec.RC5ParameterSpec;
        if (r6 == 0) goto L_0x0370;
    L_0x02af:
        r3 = (javax.crypto.spec.RC5ParameterSpec) r3;
        r5 = new org.spongycastle.crypto.params.RC5Parameters;
        r2 = r19.getEncoded();
        r6 = r3.getRounds();
        r5.<init>(r2, r6);
        r2 = r1.f31964g;
        r2 = r2.mo5741a();
        r6 = "RC5";
        r2 = r2.startsWith(r6);
        if (r2 == 0) goto L_0x0368;
    L_0x02cc:
        r2 = r1.f31964g;
        r2 = r2.mo5741a();
        r6 = "RC5-32";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x0303;
    L_0x02da:
        r2 = r3.getWordSize();
        r6 = 32;
        if (r2 != r6) goto L_0x02e3;
    L_0x02e2:
        goto L_0x033a;
    L_0x02e3:
        r0 = new java.security.InvalidAlgorithmParameterException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "RC5 already set up for a word size of 32 not ";
        r2.append(r4);
        r3 = r3.getWordSize();
        r2.append(r3);
        r3 = ".";
        r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r2);
        throw r0;
    L_0x0303:
        r2 = r1.f31964g;
        r2 = r2.mo5741a();
        r6 = "RC5-64";
        r2 = r2.equals(r6);
        if (r2 == 0) goto L_0x033a;
    L_0x0311:
        r2 = r3.getWordSize();
        r6 = 64;
        if (r2 != r6) goto L_0x031a;
    L_0x0319:
        goto L_0x033a;
    L_0x031a:
        r0 = new java.security.InvalidAlgorithmParameterException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "RC5 already set up for a word size of 64 not ";
        r2.append(r4);
        r3 = r3.getWordSize();
        r2.append(r3);
        r3 = ".";
        r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r2);
        throw r0;
    L_0x033a:
        r2 = r3.getIV();
        if (r2 == 0) goto L_0x03ec;
    L_0x0340:
        r2 = r1.f31972o;
        if (r2 == 0) goto L_0x03ec;
    L_0x0344:
        r2 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV;
        if (r2 == 0) goto L_0x0358;
    L_0x0348:
        r2 = new org.spongycastle.crypto.params.ParametersWithIV;
        r5 = (org.spongycastle.crypto.params.ParametersWithIV) r5;
        r5 = r5.m35696b();
        r3 = r3.getIV();
        r2.<init>(r5, r3);
        goto L_0x0361;
    L_0x0358:
        r2 = new org.spongycastle.crypto.params.ParametersWithIV;
        r3 = r3.getIV();
        r2.<init>(r5, r3);
    L_0x0361:
        r3 = r2;
        r3 = (org.spongycastle.crypto.params.ParametersWithIV) r3;
        r1.f31967j = r3;
        goto L_0x0268;
    L_0x0368:
        r0 = new java.security.InvalidAlgorithmParameterException;
        r2 = "RC5 parameters passed to a cipher that is not RC5.";
        r0.<init>(r2);
        throw r0;
    L_0x0370:
        r2 = f31962e;
        if (r2 == 0) goto L_0x03dd;
    L_0x0374:
        r2 = f31962e;
        r2 = r2.isInstance(r3);
        if (r2 == 0) goto L_0x03dd;
    L_0x037c:
        r2 = r1.f31977t;
        r2 = r1.m41114d(r2);
        if (r2 != 0) goto L_0x0393;
    L_0x0384:
        r2 = r1.f31966i;
        r2 = r2 instanceof org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher;
        if (r2 == 0) goto L_0x038b;
    L_0x038a:
        goto L_0x0393;
    L_0x038b:
        r0 = new java.security.InvalidAlgorithmParameterException;
        r2 = "GCMParameterSpec can only be used with AEAD modes.";
        r0.<init>(r2);
        throw r0;
    L_0x0393:
        r2 = f31962e;	 Catch:{ Exception -> 0x03d5 }
        r6 = "getTLen";	 Catch:{ Exception -> 0x03d5 }
        r9 = new java.lang.Class[r7];	 Catch:{ Exception -> 0x03d5 }
        r2 = r2.getDeclaredMethod(r6, r9);	 Catch:{ Exception -> 0x03d5 }
        r6 = f31962e;	 Catch:{ Exception -> 0x03d5 }
        r9 = "getIV";	 Catch:{ Exception -> 0x03d5 }
        r10 = new java.lang.Class[r7];	 Catch:{ Exception -> 0x03d5 }
        r6 = r6.getDeclaredMethod(r9, r10);	 Catch:{ Exception -> 0x03d5 }
        r9 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV;	 Catch:{ Exception -> 0x03d5 }
        if (r9 == 0) goto L_0x03b4;	 Catch:{ Exception -> 0x03d5 }
    L_0x03ab:
        r5 = (org.spongycastle.crypto.params.ParametersWithIV) r5;	 Catch:{ Exception -> 0x03d5 }
        r5 = r5.m35696b();	 Catch:{ Exception -> 0x03d5 }
        r5 = (org.spongycastle.crypto.params.KeyParameter) r5;	 Catch:{ Exception -> 0x03d5 }
        goto L_0x03b6;	 Catch:{ Exception -> 0x03d5 }
    L_0x03b4:
        r5 = (org.spongycastle.crypto.params.KeyParameter) r5;	 Catch:{ Exception -> 0x03d5 }
    L_0x03b6:
        r9 = new org.spongycastle.crypto.params.AEADParameters;	 Catch:{ Exception -> 0x03d5 }
        r10 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x03d5 }
        r2 = r2.invoke(r3, r10);	 Catch:{ Exception -> 0x03d5 }
        r2 = (java.lang.Integer) r2;	 Catch:{ Exception -> 0x03d5 }
        r2 = r2.intValue();	 Catch:{ Exception -> 0x03d5 }
        r10 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x03d5 }
        r3 = r6.invoke(r3, r10);	 Catch:{ Exception -> 0x03d5 }
        r3 = (byte[]) r3;	 Catch:{ Exception -> 0x03d5 }
        r3 = (byte[]) r3;	 Catch:{ Exception -> 0x03d5 }
        r9.<init>(r5, r2, r3);	 Catch:{ Exception -> 0x03d5 }
        r1.f31968k = r9;	 Catch:{ Exception -> 0x03d5 }
        r5 = r9;
        goto L_0x03ec;
    L_0x03d5:
        r0 = new java.security.InvalidAlgorithmParameterException;
        r2 = "Cannot process GCMParameterSpec.";
        r0.<init>(r2);
        throw r0;
    L_0x03dd:
        if (r3 == 0) goto L_0x03ec;
    L_0x03df:
        r2 = r3 instanceof javax.crypto.spec.PBEParameterSpec;
        if (r2 == 0) goto L_0x03e4;
    L_0x03e3:
        goto L_0x03ec;
    L_0x03e4:
        r0 = new java.security.InvalidAlgorithmParameterException;
        r2 = "unknown parameter type.";
        r0.<init>(r2);
        throw r0;
    L_0x03ec:
        r2 = r1.f31972o;
        if (r2 == 0) goto L_0x0434;
    L_0x03f0:
        r2 = r5 instanceof org.spongycastle.crypto.params.ParametersWithIV;
        if (r2 != 0) goto L_0x0434;
    L_0x03f4:
        r2 = r5 instanceof org.spongycastle.crypto.params.AEADParameters;
        if (r2 != 0) goto L_0x0434;
    L_0x03f8:
        if (r4 != 0) goto L_0x0400;
    L_0x03fa:
        r2 = new java.security.SecureRandom;
        r2.<init>();
        goto L_0x0401;
    L_0x0400:
        r2 = r4;
    L_0x0401:
        if (r0 == r8) goto L_0x0422;
    L_0x0403:
        r3 = 3;
        if (r0 != r3) goto L_0x0407;
    L_0x0406:
        goto L_0x0422;
    L_0x0407:
        r2 = r1.f31966i;
        r2 = r2.mo5875c();
        r2 = r2.mo5741a();
        r3 = "PGPCFB";
        r2 = r2.indexOf(r3);
        if (r2 < 0) goto L_0x041a;
    L_0x0419:
        goto L_0x0434;
    L_0x041a:
        r0 = new java.security.InvalidAlgorithmParameterException;
        r2 = "no IV set when one expected";
        r0.<init>(r2);
        throw r0;
    L_0x0422:
        r3 = r1.f31972o;
        r3 = new byte[r3];
        r2.nextBytes(r3);
        r2 = new org.spongycastle.crypto.params.ParametersWithIV;
        r2.<init>(r5, r3);
        r3 = r2;
        r3 = (org.spongycastle.crypto.params.ParametersWithIV) r3;
        r1.f31967j = r3;
        goto L_0x0435;
    L_0x0434:
        r2 = r5;
    L_0x0435:
        if (r4 == 0) goto L_0x0441;
    L_0x0437:
        r3 = r1.f31973p;
        if (r3 == 0) goto L_0x0441;
    L_0x043b:
        r3 = new org.spongycastle.crypto.params.ParametersWithRandom;
        r3.<init>(r2, r4);
        r2 = r3;
    L_0x0441:
        switch(r0) {
            case 1: goto L_0x044d;
            case 2: goto L_0x0447;
            case 3: goto L_0x044d;
            case 4: goto L_0x0447;
            default: goto L_0x0444;
        };
    L_0x0444:
        r2 = new java.security.InvalidParameterException;	 Catch:{ Exception -> 0x046d }
        goto L_0x0453;	 Catch:{ Exception -> 0x046d }
    L_0x0447:
        r0 = r1.f31966i;	 Catch:{ Exception -> 0x046d }
        r0.mo5871a(r7, r2);	 Catch:{ Exception -> 0x046d }
        goto L_0x0452;	 Catch:{ Exception -> 0x046d }
    L_0x044d:
        r0 = r1.f31966i;	 Catch:{ Exception -> 0x046d }
        r0.mo5871a(r8, r2);	 Catch:{ Exception -> 0x046d }
    L_0x0452:
        return;	 Catch:{ Exception -> 0x046d }
    L_0x0453:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x046d }
        r3.<init>();	 Catch:{ Exception -> 0x046d }
        r4 = "unknown opmode ";	 Catch:{ Exception -> 0x046d }
        r3.append(r4);	 Catch:{ Exception -> 0x046d }
        r3.append(r0);	 Catch:{ Exception -> 0x046d }
        r0 = " passed";	 Catch:{ Exception -> 0x046d }
        r3.append(r0);	 Catch:{ Exception -> 0x046d }
        r0 = r3.toString();	 Catch:{ Exception -> 0x046d }
        r2.<init>(r0);	 Catch:{ Exception -> 0x046d }
        throw r2;	 Catch:{ Exception -> 0x046d }
    L_0x046d:
        r0 = move-exception;
        r2 = new org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$1;
        r3 = r0.getMessage();
        r2.<init>(r1, r3, r0);
        throw r2;
    L_0x0478:
        r0 = new java.security.InvalidKeyException;
        r2 = "PKCS12 requires a SecretKey/PBEKey";
        r0.<init>(r2);
        throw r0;
    L_0x0480:
        r0 = new java.security.InvalidKeyException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Key for algorithm ";
        r3.append(r4);
        r2 = r19.getAlgorithm();
        r3.append(r2);
        r2 = " not suitable for symmetric enryption.";
        r3.append(r2);
        r2 = r3.toString();
        r0.<init>(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
    }

    /* renamed from: a */
    private CipherParameters m41112a(AlgorithmParameterSpec algorithmParameterSpec, CipherParameters cipherParameters) {
        CipherParameters b;
        GOST28147ParameterSpec gOST28147ParameterSpec;
        if (cipherParameters instanceof ParametersWithIV) {
            b = ((ParametersWithIV) cipherParameters).m35696b();
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f31967j = new ParametersWithIV(b, ((IvParameterSpec) algorithmParameterSpec).getIV());
                return this.f31967j;
            } else if (!(algorithmParameterSpec instanceof GOST28147ParameterSpec)) {
                return cipherParameters;
            } else {
                gOST28147ParameterSpec = (GOST28147ParameterSpec) algorithmParameterSpec;
                ParametersWithSBox parametersWithSBox = new ParametersWithSBox(cipherParameters, gOST28147ParameterSpec.m28104a());
                if (gOST28147ParameterSpec.m28105b() == null || this.f31972o == null) {
                    return parametersWithSBox;
                }
                this.f31967j = new ParametersWithIV(b, gOST28147ParameterSpec.m28105b());
                return this.f31967j;
            }
        } else if (algorithmParameterSpec instanceof IvParameterSpec) {
            this.f31967j = new ParametersWithIV(cipherParameters, ((IvParameterSpec) algorithmParameterSpec).getIV());
            return this.f31967j;
        } else if (!(algorithmParameterSpec instanceof GOST28147ParameterSpec)) {
            return cipherParameters;
        } else {
            gOST28147ParameterSpec = (GOST28147ParameterSpec) algorithmParameterSpec;
            b = new ParametersWithSBox(cipherParameters, gOST28147ParameterSpec.m28104a());
            return (gOST28147ParameterSpec.m28105b() == null || this.f31972o == null) ? b : new ParametersWithIV(b, gOST28147ParameterSpec.m28105b());
        }
    }

    protected void engineInit(int r4, java.security.Key r5, java.security.AlgorithmParameters r6, java.security.SecureRandom r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x003b;
    L_0x0003:
        r1 = 0;
    L_0x0004:
        r2 = r3.f31963f;
        r2 = r2.length;
        if (r1 == r2) goto L_0x001d;
    L_0x0009:
        r2 = r3.f31963f;
        r2 = r2[r1];
        if (r2 != 0) goto L_0x0010;
    L_0x000f:
        goto L_0x001a;
    L_0x0010:
        r2 = r3.f31963f;	 Catch:{ Exception -> 0x001a }
        r2 = r2[r1];	 Catch:{ Exception -> 0x001a }
        r2 = r6.getParameterSpec(r2);	 Catch:{ Exception -> 0x001a }
        r0 = r2;
        goto L_0x001d;
    L_0x001a:
        r1 = r1 + 1;
        goto L_0x0004;
    L_0x001d:
        if (r0 == 0) goto L_0x0020;
    L_0x001f:
        goto L_0x003b;
    L_0x0020:
        r4 = new java.security.InvalidAlgorithmParameterException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r7 = "can't handle parameter ";
        r5.append(r7);
        r6 = r6.toString();
        r5.append(r6);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x003b:
        r3.engineInit(r4, r5, r0, r7);
        r3.c = r6;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.engineInit(int, java.security.Key, java.security.AlgorithmParameters, java.security.SecureRandom):void");
    }

    protected void engineInit(int i, Key key, SecureRandom secureRandom) {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (int i2) {
            throw new InvalidKeyException(i2.getMessage());
        }
    }

    protected void engineUpdateAAD(byte[] bArr, int i, int i2) {
        this.f31966i.mo5872a(bArr, i, i2);
    }

    protected void engineUpdateAAD(ByteBuffer byteBuffer) {
        engineUpdateAAD(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
    }

    protected byte[] engineUpdate(byte[] bArr, int i, int i2) {
        int b = this.f31966i.mo5873b(i2);
        if (b > 0) {
            Object obj = new byte[b];
            bArr = this.f31966i.mo5869a(bArr, i, i2, obj, 0);
            if (bArr == null) {
                return null;
            }
            if (bArr == obj.length) {
                return obj;
            }
            i = new byte[bArr];
            System.arraycopy(obj, 0, i, 0, bArr);
            return i;
        }
        this.f31966i.mo5869a(bArr, i, i2, null, 0);
        return null;
    }

    protected int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (this.f31966i.mo5873b(i2) + i3 <= bArr2.length) {
            try {
                return this.f31966i.mo5869a(bArr, i, i2, bArr2, i3);
            } catch (byte[] bArr3) {
                throw new IllegalStateException(bArr3.toString());
            }
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    protected byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[engineGetOutputSize(i2)];
        int a = i2 != 0 ? this.f31966i.mo5869a(bArr, i, i2, bArr2, 0) : null;
        try {
            bArr = a + this.f31966i.mo5868a(bArr2, a);
            if (bArr == bArr2.length) {
                return bArr2;
            }
            i = new byte[bArr];
            System.arraycopy(bArr2, 0, i, 0, bArr);
            return i;
        } catch (byte[] bArr3) {
            throw new IllegalBlockSizeException(bArr3.getMessage());
        }
    }

    protected int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (engineGetOutputSize(i2) + i3 <= bArr2.length) {
            if (i2 != 0) {
                try {
                    bArr = this.f31966i.mo5869a(bArr, i, i2, bArr2, i3);
                } catch (byte[] bArr3) {
                    throw new IllegalBlockSizeException(bArr3.getMessage());
                } catch (byte[] bArr32) {
                    throw new IllegalBlockSizeException(bArr32.getMessage());
                }
            }
            bArr32 = null;
            return bArr32 + this.f31966i.mo5868a(bArr2, i3 + bArr32);
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    /* renamed from: d */
    private boolean m41114d(String str) {
        if (!("CCM".equals(str) || "EAX".equals(str) || "GCM".equals(str))) {
            if ("OCB".equals(str) == null) {
                return null;
            }
        }
        return true;
    }
}

package org.spongycastle.jcajce.provider.keystore.bc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.generators.PKCS12ParametersGenerator;
import org.spongycastle.crypto.io.DigestInputStream;
import org.spongycastle.crypto.io.DigestOutputStream;
import org.spongycastle.crypto.io.MacInputStream;
import org.spongycastle.crypto.io.MacOutputStream;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.interfaces.BCKeyStore;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;
import org.spongycastle.util.io.TeeOutputStream;

public class BcKeyStoreSpi extends KeyStoreSpi implements BCKeyStore {
    /* renamed from: a */
    protected Hashtable f27446a = new Hashtable();
    /* renamed from: b */
    protected SecureRandom f27447b = new SecureRandom();
    /* renamed from: c */
    protected int f27448c;
    /* renamed from: d */
    private final JcaJceHelper f27449d = new BCJcaJceHelper();

    private class StoreEntry {
        /* renamed from: a */
        int f22857a;
        /* renamed from: b */
        String f22858b;
        /* renamed from: c */
        Object f22859c;
        /* renamed from: d */
        Certificate[] f22860d;
        /* renamed from: e */
        Date f22861e;
        /* renamed from: f */
        final /* synthetic */ BcKeyStoreSpi f22862f;

        StoreEntry(BcKeyStoreSpi bcKeyStoreSpi, String str, Certificate certificate) {
            this.f22862f = bcKeyStoreSpi;
            this.f22861e = new Date();
            this.f22857a = 1;
            this.f22858b = str;
            this.f22859c = certificate;
            this.f22860d = null;
        }

        StoreEntry(BcKeyStoreSpi bcKeyStoreSpi, String str, byte[] bArr, Certificate[] certificateArr) {
            this.f22862f = bcKeyStoreSpi;
            this.f22861e = new Date();
            this.f22857a = 3;
            this.f22858b = str;
            this.f22859c = bArr;
            this.f22860d = certificateArr;
        }

        StoreEntry(BcKeyStoreSpi bcKeyStoreSpi, String str, Key key, char[] cArr, Certificate[] certificateArr) {
            this.f22862f = bcKeyStoreSpi;
            this.f22861e = new Date();
            this.f22857a = 4;
            this.f22858b = str;
            this.f22860d = certificateArr;
            byte[] bArr = new byte[20];
            bcKeyStoreSpi.f27447b.setSeed(System.currentTimeMillis());
            bcKeyStoreSpi.f27447b.nextBytes(bArr);
            int nextInt = (bcKeyStoreSpi.f27447b.nextInt() & 1023) + 1024;
            str = new ByteArrayOutputStream();
            certificateArr = new DataOutputStream(str);
            certificateArr.writeInt(bArr.length);
            certificateArr.write(bArr);
            certificateArr.writeInt(nextInt);
            cArr = new DataOutputStream(new CipherOutputStream(certificateArr, bcKeyStoreSpi.m36039a("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, cArr, bArr, nextInt)));
            bcKeyStoreSpi.m36035a(key, (DataOutputStream) cArr);
            cArr.close();
            this.f22859c = str.toByteArray();
        }

        StoreEntry(BcKeyStoreSpi bcKeyStoreSpi, String str, Date date, int i, Object obj) {
            this.f22862f = bcKeyStoreSpi;
            this.f22861e = new Date();
            this.f22858b = str;
            this.f22861e = date;
            this.f22857a = i;
            this.f22859c = obj;
        }

        StoreEntry(BcKeyStoreSpi bcKeyStoreSpi, String str, Date date, int i, Object obj, Certificate[] certificateArr) {
            this.f22862f = bcKeyStoreSpi;
            this.f22861e = new Date();
            this.f22858b = str;
            this.f22861e = date;
            this.f22857a = i;
            this.f22859c = obj;
            this.f22860d = certificateArr;
        }

        /* renamed from: a */
        int m28050a() {
            return this.f22857a;
        }

        /* renamed from: b */
        String m28052b() {
            return this.f22858b;
        }

        /* renamed from: c */
        Object m28053c() {
            return this.f22859c;
        }

        /* renamed from: a */
        java.lang.Object m28051a(char[] r10) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r9 = this;
            if (r10 == 0) goto L_0x0005;
        L_0x0002:
            r0 = r10.length;
            if (r0 != 0) goto L_0x000e;
        L_0x0005:
            r0 = r9.f22859c;
            r0 = r0 instanceof java.security.Key;
            if (r0 == 0) goto L_0x000e;
        L_0x000b:
            r10 = r9.f22859c;
            return r10;
        L_0x000e:
            r0 = r9.f22857a;
            r1 = 4;
            if (r0 != r1) goto L_0x0108;
        L_0x0013:
            r0 = new java.io.ByteArrayInputStream;
            r1 = r9.f22859c;
            r1 = (byte[]) r1;
            r0.<init>(r1);
            r1 = new java.io.DataInputStream;
            r1.<init>(r0);
            r0 = r1.readInt();	 Catch:{ Exception -> 0x0100 }
            r6 = new byte[r0];	 Catch:{ Exception -> 0x0100 }
            r1.readFully(r6);	 Catch:{ Exception -> 0x0100 }
            r7 = r1.readInt();	 Catch:{ Exception -> 0x0100 }
            r2 = r9.f22862f;	 Catch:{ Exception -> 0x0100 }
            r3 = "PBEWithSHAAnd3-KeyTripleDES-CBC";	 Catch:{ Exception -> 0x0100 }
            r4 = 2;	 Catch:{ Exception -> 0x0100 }
            r5 = r10;	 Catch:{ Exception -> 0x0100 }
            r0 = r2.m36039a(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0100 }
            r2 = new javax.crypto.CipherInputStream;	 Catch:{ Exception -> 0x0100 }
            r2.<init>(r1, r0);	 Catch:{ Exception -> 0x0100 }
            r0 = r9.f22862f;	 Catch:{ Exception -> 0x0049 }
            r1 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x0049 }
            r1.<init>(r2);	 Catch:{ Exception -> 0x0049 }
            r0 = r0.m36038b(r1);	 Catch:{ Exception -> 0x0049 }
            return r0;
        L_0x0049:
            r0 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0100 }
            r1 = r9.f22859c;	 Catch:{ Exception -> 0x0100 }
            r1 = (byte[]) r1;	 Catch:{ Exception -> 0x0100 }
            r1 = (byte[]) r1;	 Catch:{ Exception -> 0x0100 }
            r0.<init>(r1);	 Catch:{ Exception -> 0x0100 }
            r1 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x0100 }
            r1.<init>(r0);	 Catch:{ Exception -> 0x0100 }
            r0 = r1.readInt();	 Catch:{ Exception -> 0x0100 }
            r0 = new byte[r0];	 Catch:{ Exception -> 0x0100 }
            r1.readFully(r0);	 Catch:{ Exception -> 0x0100 }
            r8 = r1.readInt();	 Catch:{ Exception -> 0x0100 }
            r2 = r9.f22862f;	 Catch:{ Exception -> 0x0100 }
            r3 = "BrokenPBEWithSHAAnd3-KeyTripleDES-CBC";	 Catch:{ Exception -> 0x0100 }
            r4 = 2;	 Catch:{ Exception -> 0x0100 }
            r5 = r10;	 Catch:{ Exception -> 0x0100 }
            r6 = r0;	 Catch:{ Exception -> 0x0100 }
            r7 = r8;	 Catch:{ Exception -> 0x0100 }
            r2 = r2.m36039a(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0100 }
            r3 = new javax.crypto.CipherInputStream;	 Catch:{ Exception -> 0x0100 }
            r3.<init>(r1, r2);	 Catch:{ Exception -> 0x0100 }
            r1 = r9.f22862f;	 Catch:{ Exception -> 0x0085 }
            r2 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x0085 }
            r2.<init>(r3);	 Catch:{ Exception -> 0x0085 }
            r1 = r1.m36038b(r2);	 Catch:{ Exception -> 0x0085 }
        L_0x0082:
            r6 = r0;
            r7 = r8;
            goto L_0x00bf;
        L_0x0085:
            r0 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0100 }
            r1 = r9.f22859c;	 Catch:{ Exception -> 0x0100 }
            r1 = (byte[]) r1;	 Catch:{ Exception -> 0x0100 }
            r1 = (byte[]) r1;	 Catch:{ Exception -> 0x0100 }
            r0.<init>(r1);	 Catch:{ Exception -> 0x0100 }
            r1 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x0100 }
            r1.<init>(r0);	 Catch:{ Exception -> 0x0100 }
            r0 = r1.readInt();	 Catch:{ Exception -> 0x0100 }
            r0 = new byte[r0];	 Catch:{ Exception -> 0x0100 }
            r1.readFully(r0);	 Catch:{ Exception -> 0x0100 }
            r8 = r1.readInt();	 Catch:{ Exception -> 0x0100 }
            r2 = r9.f22862f;	 Catch:{ Exception -> 0x0100 }
            r3 = "OldPBEWithSHAAnd3-KeyTripleDES-CBC";	 Catch:{ Exception -> 0x0100 }
            r4 = 2;	 Catch:{ Exception -> 0x0100 }
            r5 = r10;	 Catch:{ Exception -> 0x0100 }
            r6 = r0;	 Catch:{ Exception -> 0x0100 }
            r7 = r8;	 Catch:{ Exception -> 0x0100 }
            r2 = r2.m36039a(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0100 }
            r3 = new javax.crypto.CipherInputStream;	 Catch:{ Exception -> 0x0100 }
            r3.<init>(r1, r2);	 Catch:{ Exception -> 0x0100 }
            r1 = r9.f22862f;	 Catch:{ Exception -> 0x0100 }
            r2 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x0100 }
            r2.<init>(r3);	 Catch:{ Exception -> 0x0100 }
            r1 = r1.m36038b(r2);	 Catch:{ Exception -> 0x0100 }
            goto L_0x0082;	 Catch:{ Exception -> 0x0100 }
        L_0x00bf:
            if (r1 == 0) goto L_0x00f8;	 Catch:{ Exception -> 0x0100 }
        L_0x00c1:
            r0 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0100 }
            r0.<init>();	 Catch:{ Exception -> 0x0100 }
            r8 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x0100 }
            r8.<init>(r0);	 Catch:{ Exception -> 0x0100 }
            r2 = r6.length;	 Catch:{ Exception -> 0x0100 }
            r8.writeInt(r2);	 Catch:{ Exception -> 0x0100 }
            r8.write(r6);	 Catch:{ Exception -> 0x0100 }
            r8.writeInt(r7);	 Catch:{ Exception -> 0x0100 }
            r2 = r9.f22862f;	 Catch:{ Exception -> 0x0100 }
            r3 = "PBEWithSHAAnd3-KeyTripleDES-CBC";	 Catch:{ Exception -> 0x0100 }
            r4 = 1;	 Catch:{ Exception -> 0x0100 }
            r5 = r10;	 Catch:{ Exception -> 0x0100 }
            r10 = r2.m36039a(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0100 }
            r2 = new javax.crypto.CipherOutputStream;	 Catch:{ Exception -> 0x0100 }
            r2.<init>(r8, r10);	 Catch:{ Exception -> 0x0100 }
            r10 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x0100 }
            r10.<init>(r2);	 Catch:{ Exception -> 0x0100 }
            r2 = r9.f22862f;	 Catch:{ Exception -> 0x0100 }
            r2.m36035a(r1, r10);	 Catch:{ Exception -> 0x0100 }
            r10.close();	 Catch:{ Exception -> 0x0100 }
            r10 = r0.toByteArray();	 Catch:{ Exception -> 0x0100 }
            r9.f22859c = r10;	 Catch:{ Exception -> 0x0100 }
            return r1;	 Catch:{ Exception -> 0x0100 }
        L_0x00f8:
            r10 = new java.security.UnrecoverableKeyException;	 Catch:{ Exception -> 0x0100 }
            r0 = "no match";	 Catch:{ Exception -> 0x0100 }
            r10.<init>(r0);	 Catch:{ Exception -> 0x0100 }
            throw r10;	 Catch:{ Exception -> 0x0100 }
        L_0x0100:
            r10 = new java.security.UnrecoverableKeyException;
            r0 = "no match";
            r10.<init>(r0);
            throw r10;
        L_0x0108:
            r10 = new java.lang.RuntimeException;
            r0 = "forget something!";
            r10.<init>(r0);
            throw r10;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi.StoreEntry.a(char[]):java.lang.Object");
        }

        /* renamed from: d */
        Certificate[] m28054d() {
            return this.f22860d;
        }

        /* renamed from: e */
        Date m28055e() {
            return this.f22861e;
        }
    }

    public static class BouncyCastleStore extends BcKeyStoreSpi {
        public BouncyCastleStore() {
            super(1);
        }

        public void engineLoad(InputStream inputStream, char[] cArr) {
            this.a.clear();
            if (inputStream != null) {
                InputStream dataInputStream = new DataInputStream(inputStream);
                inputStream = dataInputStream.readInt();
                if (!(inputStream == 2 || inputStream == null)) {
                    if (inputStream != 1) {
                        throw new IOException("Wrong version of key store.");
                    }
                }
                byte[] bArr = new byte[dataInputStream.readInt()];
                if (bArr.length == 20) {
                    dataInputStream.readFully(bArr);
                    int readInt = dataInputStream.readInt();
                    if (readInt < 0 || readInt > 4096) {
                        throw new IOException("Key store corrupted.");
                    }
                    InputStream cipherInputStream = new CipherInputStream(dataInputStream, m36039a(inputStream == null ? "OldPBEWithSHAAndTwofish-CBC" : "PBEWithSHAAndTwofish-CBC", 2, cArr, bArr, readInt));
                    inputStream = new SHA1Digest();
                    m36040a(new DigestInputStream(cipherInputStream, inputStream));
                    byte[] bArr2 = new byte[inputStream.mo5732b()];
                    inputStream.mo5728a(bArr2, 0);
                    byte[] bArr3 = new byte[inputStream.mo5732b()];
                    Streams.m29439a(cipherInputStream, bArr3);
                    if (Arrays.m29372b(bArr2, bArr3) == null) {
                        this.a.clear();
                        throw new IOException("KeyStore integrity check failed.");
                    }
                    return;
                }
                throw new IOException("Key store corrupted.");
            }
        }

        public void engineStore(OutputStream outputStream, char[] cArr) {
            OutputStream dataOutputStream = new DataOutputStream(outputStream);
            byte[] bArr = new byte[20];
            int nextInt = (this.b.nextInt() & 1023) + 1024;
            this.b.nextBytes(bArr);
            dataOutputStream.writeInt(this.c);
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
            dataOutputStream.writeInt(nextInt);
            cArr = new CipherOutputStream(dataOutputStream, m36039a("PBEWithSHAAndTwofish-CBC", 1, cArr, bArr, nextInt));
            outputStream = new DigestOutputStream(new SHA1Digest());
            m36041a(new TeeOutputStream(cArr, outputStream));
            cArr.write(outputStream.m27459a());
            cArr.close();
        }
    }

    public static class Std extends BcKeyStoreSpi {
        public Std() {
            super(2);
        }
    }

    public static class Version1 extends BcKeyStoreSpi {
        public Version1() {
            super(1);
        }
    }

    public BcKeyStoreSpi(int i) {
        this.f27448c = i;
    }

    /* renamed from: a */
    private void m36036a(Certificate certificate, DataOutputStream dataOutputStream) {
        try {
            byte[] encoded = certificate.getEncoded();
            dataOutputStream.writeUTF(certificate.getType());
            dataOutputStream.writeInt(encoded.length);
            dataOutputStream.write(encoded);
        } catch (Certificate certificate2) {
            throw new IOException(certificate2.toString());
        }
    }

    /* renamed from: a */
    private Certificate m36034a(DataInputStream dataInputStream) {
        String readUTF = dataInputStream.readUTF();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        try {
            return this.f27449d.mo5882g(readUTF).generateCertificate(new ByteArrayInputStream(bArr));
        } catch (DataInputStream dataInputStream2) {
            throw new IOException(dataInputStream2.toString());
        } catch (DataInputStream dataInputStream22) {
            throw new IOException(dataInputStream22.toString());
        }
    }

    /* renamed from: a */
    private void m36035a(Key key, DataOutputStream dataOutputStream) {
        byte[] encoded = key.getEncoded();
        if (key instanceof PrivateKey) {
            dataOutputStream.write(0);
        } else if (key instanceof PublicKey) {
            dataOutputStream.write(1);
        } else {
            dataOutputStream.write(2);
        }
        dataOutputStream.writeUTF(key.getFormat());
        dataOutputStream.writeUTF(key.getAlgorithm());
        dataOutputStream.writeInt(encoded.length);
        dataOutputStream.write(encoded);
    }

    /* renamed from: b */
    private Key m36038b(DataInputStream dataInputStream) {
        int read = dataInputStream.read();
        String readUTF = dataInputStream.readUTF();
        String readUTF2 = dataInputStream.readUTF();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        if (readUTF.equals("PKCS#8") == null) {
            if (readUTF.equals("PKCS8") == null) {
                if (readUTF.equals("X.509") == null) {
                    if (readUTF.equals("X509") == null) {
                        if (readUTF.equals("RAW") != null) {
                            return new SecretKeySpec(bArr, readUTF2);
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Key format ");
                        stringBuilder.append(readUTF);
                        stringBuilder.append(" not recognised!");
                        throw new IOException(stringBuilder.toString());
                    }
                }
                dataInputStream = new X509EncodedKeySpec(bArr);
                switch (read) {
                    case 0:
                        return this.f27449d.mo5879d(readUTF2).generatePrivate(dataInputStream);
                    case 1:
                        return this.f27449d.mo5879d(readUTF2).generatePublic(dataInputStream);
                    case 2:
                        return this.f27449d.mo5880e(readUTF2).generateSecret(dataInputStream);
                    default:
                        try {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Key type ");
                            stringBuilder2.append(read);
                            stringBuilder2.append(" not recognised!");
                            throw new IOException(stringBuilder2.toString());
                        } catch (DataInputStream dataInputStream2) {
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Exception creating key: ");
                            stringBuilder2.append(dataInputStream2.toString());
                            throw new IOException(stringBuilder2.toString());
                        }
                }
            }
        }
        dataInputStream2 = new PKCS8EncodedKeySpec(bArr);
        switch (read) {
            case 0:
                return this.f27449d.mo5879d(readUTF2).generatePrivate(dataInputStream2);
            case 1:
                return this.f27449d.mo5879d(readUTF2).generatePublic(dataInputStream2);
            case 2:
                return this.f27449d.mo5880e(readUTF2).generateSecret(dataInputStream2);
            default:
                StringBuilder stringBuilder22 = new StringBuilder();
                stringBuilder22.append("Key type ");
                stringBuilder22.append(read);
                stringBuilder22.append(" not recognised!");
                throw new IOException(stringBuilder22.toString());
        }
    }

    /* renamed from: a */
    protected Cipher m36039a(String str, int i, char[] cArr, byte[] bArr, int i2) {
        try {
            KeySpec pBEKeySpec = new PBEKeySpec(cArr);
            cArr = this.f27449d.mo5880e(str);
            AlgorithmParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i2);
            str = this.f27449d.mo5876a(str);
            str.init(i, cArr.generateSecret(pBEKeySpec), pBEParameterSpec);
            return str;
        } catch (String str2) {
            cArr = new StringBuilder();
            cArr.append("Error initialising store of key store: ");
            cArr.append(str2);
            throw new IOException(cArr.toString());
        }
    }

    public Enumeration engineAliases() {
        return this.f27446a.keys();
    }

    public boolean engineContainsAlias(String str) {
        return this.f27446a.get(str) != null ? true : null;
    }

    public void engineDeleteEntry(String str) {
        if (this.f27446a.get(str) != null) {
            this.f27446a.remove(str);
        }
    }

    public Certificate engineGetCertificate(String str) {
        StoreEntry storeEntry = (StoreEntry) this.f27446a.get(str);
        if (storeEntry != null) {
            if (storeEntry.m28050a() == 1) {
                return (Certificate) storeEntry.m28053c();
            }
            str = storeEntry.m28054d();
            if (str != null) {
                return str[0];
            }
        }
        return null;
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration elements = this.f27446a.elements();
        while (elements.hasMoreElements()) {
            StoreEntry storeEntry = (StoreEntry) elements.nextElement();
            if (!(storeEntry.m28053c() instanceof Certificate)) {
                Certificate[] d = storeEntry.m28054d();
                if (d != null && d[0].equals(certificate)) {
                    return storeEntry.m28052b();
                }
            } else if (((Certificate) storeEntry.m28053c()).equals(certificate)) {
                return storeEntry.m28052b();
            }
        }
        return null;
    }

    public Certificate[] engineGetCertificateChain(String str) {
        StoreEntry storeEntry = (StoreEntry) this.f27446a.get(str);
        return storeEntry != null ? storeEntry.m28054d() : null;
    }

    public Date engineGetCreationDate(String str) {
        StoreEntry storeEntry = (StoreEntry) this.f27446a.get(str);
        return storeEntry != null ? storeEntry.m28055e() : null;
    }

    public Key engineGetKey(String str, char[] cArr) {
        StoreEntry storeEntry = (StoreEntry) this.f27446a.get(str);
        if (storeEntry != null) {
            if (storeEntry.m28050a() != 1) {
                return (Key) storeEntry.m28051a(cArr);
            }
        }
        return null;
    }

    public boolean engineIsCertificateEntry(String str) {
        StoreEntry storeEntry = (StoreEntry) this.f27446a.get(str);
        return (storeEntry == null || storeEntry.m28050a() != 1) ? null : true;
    }

    public boolean engineIsKeyEntry(String str) {
        StoreEntry storeEntry = (StoreEntry) this.f27446a.get(str);
        return (storeEntry == null || storeEntry.m28050a() == 1) ? null : true;
    }

    public void engineSetCertificateEntry(String str, Certificate certificate) {
        StoreEntry storeEntry = (StoreEntry) this.f27446a.get(str);
        if (storeEntry != null) {
            if (storeEntry.m28050a() != 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("key store already has a key entry with alias ");
                stringBuilder.append(str);
                throw new KeyStoreException(stringBuilder.toString());
            }
        }
        this.f27446a.put(str, new StoreEntry(this, str, certificate));
    }

    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
        this.f27446a.put(str, new StoreEntry(this, str, bArr, certificateArr));
    }

    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
        if (key instanceof PrivateKey) {
            if (certificateArr == null) {
                throw new KeyStoreException("no certificate chain for private key");
            }
        }
        try {
            this.f27446a.put(str, new StoreEntry(this, str, key, cArr, certificateArr));
        } catch (String str2) {
            throw new KeyStoreException(str2.toString());
        }
    }

    public int engineSize() {
        return this.f27446a.size();
    }

    /* renamed from: a */
    protected void m36040a(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        for (int read = dataInputStream.read(); read > 0; read = dataInputStream.read()) {
            inputStream = dataInputStream.readUTF();
            Date date = new Date(dataInputStream.readLong());
            int readInt = dataInputStream.readInt();
            Certificate[] certificateArr = null;
            if (readInt != 0) {
                certificateArr = new Certificate[readInt];
                for (int i = 0; i != readInt; i++) {
                    certificateArr[i] = m36034a(dataInputStream);
                }
            }
            Certificate[] certificateArr2 = certificateArr;
            switch (read) {
                case 1:
                    this.f27446a.put(inputStream, new StoreEntry(this, (String) inputStream, date, 1, m36034a(dataInputStream)));
                    break;
                case 2:
                    this.f27446a.put(inputStream, new StoreEntry(this, inputStream, date, 2, m36038b(dataInputStream), certificateArr2));
                    break;
                case 3:
                case 4:
                    Object obj = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(obj);
                    this.f27446a.put(inputStream, new StoreEntry(this, inputStream, date, read, obj, certificateArr2));
                    break;
                default:
                    throw new RuntimeException("Unknown object type in store.");
            }
        }
    }

    /* renamed from: a */
    protected void m36041a(OutputStream outputStream) {
        Enumeration elements = this.f27446a.elements();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        while (true) {
            int i = 0;
            if (elements.hasMoreElements() != null) {
                StoreEntry storeEntry = (StoreEntry) elements.nextElement();
                dataOutputStream.write(storeEntry.m28050a());
                dataOutputStream.writeUTF(storeEntry.m28052b());
                dataOutputStream.writeLong(storeEntry.m28055e().getTime());
                Certificate[] d = storeEntry.m28054d();
                if (d == null) {
                    dataOutputStream.writeInt(0);
                } else {
                    dataOutputStream.writeInt(d.length);
                    while (i != d.length) {
                        m36036a(d[i], dataOutputStream);
                        i++;
                    }
                }
                switch (storeEntry.m28050a()) {
                    case 1:
                        m36036a((Certificate) storeEntry.m28053c(), dataOutputStream);
                        break;
                    case 2:
                        m36035a((Key) storeEntry.m28053c(), dataOutputStream);
                        break;
                    case 3:
                    case 4:
                        byte[] bArr = (byte[]) storeEntry.m28053c();
                        dataOutputStream.writeInt(bArr.length);
                        dataOutputStream.write(bArr);
                        break;
                    default:
                        throw new RuntimeException("Unknown object type in store.");
                }
            }
            dataOutputStream.write(0);
            return;
        }
    }

    public void engineLoad(InputStream inputStream, char[] cArr) {
        this.f27446a.clear();
        if (inputStream != null) {
            InputStream dataInputStream = new DataInputStream(inputStream);
            inputStream = dataInputStream.readInt();
            if (!(inputStream == 2 || inputStream == null)) {
                if (inputStream != 1) {
                    throw new IOException("Wrong version of key store.");
                }
            }
            int readInt = dataInputStream.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                dataInputStream.readFully(bArr);
                int readInt2 = dataInputStream.readInt();
                HMac hMac = new HMac(new SHA1Digest());
                if (cArr == null || cArr.length == 0) {
                    m36040a(dataInputStream);
                    dataInputStream.readFully(new byte[hMac.mo5766b()]);
                } else {
                    CipherParameters b;
                    byte[] c = PBEParametersGenerator.m27336c(cArr);
                    PBEParametersGenerator pKCS12ParametersGenerator = new PKCS12ParametersGenerator(new SHA1Digest());
                    pKCS12ParametersGenerator.m27339a(c, bArr, readInt2);
                    if (inputStream != 2) {
                        b = pKCS12ParametersGenerator.mo5760b(hMac.mo5766b());
                    } else {
                        b = pKCS12ParametersGenerator.mo5760b(hMac.mo5766b() * 8);
                    }
                    Arrays.m29351a(c, (byte) 0);
                    hMac.mo5764a(b);
                    m36040a(new MacInputStream(dataInputStream, hMac));
                    byte[] bArr2 = new byte[hMac.mo5766b()];
                    hMac.mo5761a(bArr2, 0);
                    c = new byte[hMac.mo5766b()];
                    dataInputStream.readFully(c);
                    if (Arrays.m29372b(bArr2, c) == null) {
                        this.f27446a.clear();
                        throw new IOException("KeyStore integrity check failed.");
                    }
                }
                return;
            }
            throw new IOException("Invalid salt detected");
        }
    }

    public void engineStore(OutputStream outputStream, char[] cArr) {
        OutputStream dataOutputStream = new DataOutputStream(outputStream);
        outputStream = new byte[20];
        int nextInt = (this.f27447b.nextInt() & 1023) + 1024;
        this.f27447b.nextBytes(outputStream);
        dataOutputStream.writeInt(this.f27448c);
        dataOutputStream.writeInt(outputStream.length);
        dataOutputStream.write(outputStream);
        dataOutputStream.writeInt(nextInt);
        HMac hMac = new HMac(new SHA1Digest());
        OutputStream macOutputStream = new MacOutputStream(hMac);
        PBEParametersGenerator pKCS12ParametersGenerator = new PKCS12ParametersGenerator(new SHA1Digest());
        cArr = PBEParametersGenerator.m27336c(cArr);
        pKCS12ParametersGenerator.m27339a(cArr, outputStream, nextInt);
        if (this.f27448c < 2) {
            hMac.mo5764a(pKCS12ParametersGenerator.mo5760b(hMac.mo5766b()));
        } else {
            hMac.mo5764a(pKCS12ParametersGenerator.mo5760b(hMac.mo5766b() * 8));
        }
        for (nextInt = 0; nextInt != cArr.length; nextInt++) {
            cArr[nextInt] = '\u0000';
        }
        m36041a(new TeeOutputStream(dataOutputStream, macOutputStream));
        cArr = new byte[hMac.mo5766b()];
        hMac.mo5761a(cArr, 0);
        dataOutputStream.write(cArr);
        dataOutputStream.close();
    }
}

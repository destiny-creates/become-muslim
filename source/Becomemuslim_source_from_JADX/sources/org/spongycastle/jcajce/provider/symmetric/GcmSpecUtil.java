package org.spongycastle.jcajce.provider.symmetric;

import java.security.spec.AlgorithmParameterSpec;

class GcmSpecUtil {
    /* renamed from: a */
    static final Class f22869a = m28063a("javax.crypto.spec.GCMParameterSpec");

    GcmSpecUtil() {
    }

    /* renamed from: a */
    static boolean m28065a() {
        return f22869a != null;
    }

    /* renamed from: a */
    static boolean m28067a(AlgorithmParameterSpec algorithmParameterSpec) {
        return (f22869a == null || f22869a.isInstance(algorithmParameterSpec) == null) ? null : true;
    }

    /* renamed from: a */
    static boolean m28066a(Class cls) {
        return f22869a == cls ? true : null;
    }

    /* renamed from: a */
    static java.security.spec.AlgorithmParameterSpec m28064a(org.spongycastle.asn1.ASN1Primitive r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = org.spongycastle.asn1.cms.GCMParameters.m39884a(r6);	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r0 = f22869a;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r1 = 2;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r2 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r3 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r2[r4] = r3;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r3 = byte[].class;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r5 = 1;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r2[r5] = r3;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r0 = r0.getConstructor(r2);	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r1 = new java.lang.Object[r1];	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r2 = r6.m39886b();	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r2 = r2 * 8;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r2 = org.spongycastle.util.Integers.m29396a(r2);	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r1[r4] = r2;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r6 = r6.m39885a();	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r1[r5] = r6;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r6 = r0.newInstance(r1);	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        r6 = (java.security.spec.AlgorithmParameterSpec) r6;	 Catch:{ NoSuchMethodException -> 0x004e, Exception -> 0x0032 }
        return r6;
    L_0x0032:
        r6 = move-exception;
        r0 = new java.security.spec.InvalidParameterSpecException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Construction failed: ";
        r1.append(r2);
        r6 = r6.getMessage();
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x004e:
        r6 = new java.security.spec.InvalidParameterSpecException;
        r0 = "No constructor found!";
        r6.<init>(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.GcmSpecUtil.a(org.spongycastle.asn1.ASN1Primitive):java.security.spec.AlgorithmParameterSpec");
    }

    /* renamed from: b */
    static org.spongycastle.asn1.cms.GCMParameters m28068b(java.security.spec.AlgorithmParameterSpec r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = f22869a;	 Catch:{ Exception -> 0x0033 }
        r1 = "getTLen";	 Catch:{ Exception -> 0x0033 }
        r2 = 0;	 Catch:{ Exception -> 0x0033 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0033 }
        r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ Exception -> 0x0033 }
        r1 = f22869a;	 Catch:{ Exception -> 0x0033 }
        r3 = "getIV";	 Catch:{ Exception -> 0x0033 }
        r4 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0033 }
        r1 = r1.getDeclaredMethod(r3, r4);	 Catch:{ Exception -> 0x0033 }
        r3 = new org.spongycastle.asn1.cms.GCMParameters;	 Catch:{ Exception -> 0x0033 }
        r4 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0033 }
        r1 = r1.invoke(r5, r4);	 Catch:{ Exception -> 0x0033 }
        r1 = (byte[]) r1;	 Catch:{ Exception -> 0x0033 }
        r1 = (byte[]) r1;	 Catch:{ Exception -> 0x0033 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0033 }
        r5 = r0.invoke(r5, r2);	 Catch:{ Exception -> 0x0033 }
        r5 = (java.lang.Integer) r5;	 Catch:{ Exception -> 0x0033 }
        r5 = r5.intValue();	 Catch:{ Exception -> 0x0033 }
        r5 = r5 / 8;	 Catch:{ Exception -> 0x0033 }
        r3.<init>(r1, r5);	 Catch:{ Exception -> 0x0033 }
        return r3;
    L_0x0033:
        r5 = new java.security.spec.InvalidParameterSpecException;
        r0 = "Cannot process GCMParameterSpec";
        r5.<init>(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.GcmSpecUtil.b(java.security.spec.AlgorithmParameterSpec):org.spongycastle.asn1.cms.GCMParameters");
    }

    /* renamed from: a */
    private static java.lang.Class m28063a(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = org.spongycastle.jcajce.provider.symmetric.GcmSpecUtil.class;	 Catch:{ Exception -> 0x000b }
        r0 = r0.getClassLoader();	 Catch:{ Exception -> 0x000b }
        r1 = r0.loadClass(r1);	 Catch:{ Exception -> 0x000b }
        return r1;
    L_0x000b:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.GcmSpecUtil.a(java.lang.String):java.lang.Class");
    }
}

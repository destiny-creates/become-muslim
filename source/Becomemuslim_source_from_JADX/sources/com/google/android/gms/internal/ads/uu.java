package com.google.android.gms.internal.ads;

public class uu extends awi<String> {
    /* renamed from: a */
    private final Object f24331a = new Object();
    /* renamed from: b */
    private bee<String> f24332b;

    public uu(int i, String str, bee<String> bee, bdl bdl) {
        super(i, str, bdl);
        this.f24332b = bee;
    }

    /* renamed from: a */
    protected final com.google.android.gms.internal.ads.bck<java.lang.String> mo4314a(com.google.android.gms.internal.ads.aug r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r1 = r10.f15005b;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r2 = r10.f15006c;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r3 = "ISO-8859-1";	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r4 = "Content-Type";	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r2 = r2.get(r4);	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r2 = (java.lang.String) r2;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        if (r2 == 0) goto L_0x003e;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
    L_0x0012:
        r4 = ";";	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r2 = r2.split(r4);	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r4 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r5 = 1;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
    L_0x001a:
        r6 = r2.length;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        if (r5 >= r6) goto L_0x003e;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
    L_0x001d:
        r6 = r2[r5];	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r6 = r6.trim();	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r7 = "=";	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r6 = r6.split(r7);	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r7 = r6.length;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r8 = 2;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        if (r7 != r8) goto L_0x003b;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
    L_0x002d:
        r7 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r7 = r6[r7];	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r8 = "charset";	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        r7 = r7.equals(r8);	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        if (r7 == 0) goto L_0x003b;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
    L_0x0038:
        r3 = r6[r4];	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        goto L_0x003e;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
    L_0x003b:
        r5 = r5 + 1;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        goto L_0x001a;	 Catch:{ UnsupportedEncodingException -> 0x0042 }
    L_0x003e:
        r0.<init>(r1, r3);	 Catch:{ UnsupportedEncodingException -> 0x0042 }
        goto L_0x0049;
    L_0x0042:
        r0 = new java.lang.String;
        r1 = r10.f15005b;
        r0.<init>(r1);
    L_0x0049:
        r10 = com.google.android.gms.internal.ads.oq.m19972a(r10);
        r10 = com.google.android.gms.internal.ads.bck.m19231a(r0, r10);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.uu.a(com.google.android.gms.internal.ads.aug):com.google.android.gms.internal.ads.bck<java.lang.String>");
    }

    /* renamed from: a */
    protected /* synthetic */ void mo4315a(Object obj) {
        mo6107a((String) obj);
    }

    /* renamed from: a */
    protected void mo6107a(String str) {
        synchronized (this.f24331a) {
            bee bee = this.f24332b;
        }
        if (bee != null) {
            bee.mo6110a(str);
        }
    }
}

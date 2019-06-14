package com.onesignal;

import java.lang.Thread.State;
import org.json.JSONObject;

/* compiled from: OneSignalRestClient */
class ar {

    /* compiled from: OneSignalRestClient */
    /* renamed from: com.onesignal.ar$a */
    static class C5480a {
        /* renamed from: a */
        void mo4936a(int i, String str, Throwable th) {
        }

        /* renamed from: a */
        void mo4940a(String str) {
        }

        C5480a() {
        }
    }

    /* renamed from: a */
    private static int m23288a(int i) {
        return i + 5000;
    }

    /* renamed from: a */
    static void m23293a(final String str, final JSONObject jSONObject, final C5480a c5480a) {
        new Thread(new Runnable() {
            public void run() {
                ar.m23297c(str, "PUT", jSONObject, c5480a, 120000);
            }
        }).start();
    }

    /* renamed from: b */
    static void m23296b(final String str, final JSONObject jSONObject, final C5480a c5480a) {
        new Thread(new Runnable() {
            public void run() {
                ar.m23297c(str, "POST", jSONObject, c5480a, 120000);
            }
        }).start();
    }

    /* renamed from: a */
    static void m23291a(final String str, final C5480a c5480a) {
        new Thread(new Runnable() {
            public void run() {
                ar.m23297c(str, null, null, c5480a, 60000);
            }
        }).start();
    }

    /* renamed from: b */
    static void m23295b(String str, C5480a c5480a) {
        m23297c(str, null, null, c5480a, 60000);
    }

    /* renamed from: c */
    static void m23298c(String str, JSONObject jSONObject, C5480a c5480a) {
        m23297c(str, "PUT", jSONObject, c5480a, 120000);
    }

    /* renamed from: d */
    static void m23300d(String str, JSONObject jSONObject, C5480a c5480a) {
        m23297c(str, "POST", jSONObject, c5480a, 120000);
    }

    /* renamed from: c */
    private static void m23297c(String str, String str2, JSONObject jSONObject, C5480a c5480a, int i) {
        if (str2 == null || !am.m23179a(null)) {
            Thread[] threadArr = new Thread[1];
            final Thread[] threadArr2 = threadArr;
            final String str3 = str;
            final String str4 = str2;
            final JSONObject jSONObject2 = jSONObject;
            final C5480a c5480a2 = c5480a;
            final int i2 = i;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    threadArr2[0] = ar.m23299d(str3, str4, jSONObject2, c5480a2, i2);
                }
            }, "OS_HTTPConnection");
            thread.start();
            try {
                thread.join((long) m23288a(i));
                if (thread.getState() != State.TERMINATED) {
                    thread.interrupt();
                }
                if (threadArr[0] != null) {
                    threadArr[0].join();
                }
            } catch (String str5) {
                str5.printStackTrace();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    private static java.lang.Thread m23299d(java.lang.String r5, java.lang.String r6, org.json.JSONObject r7, com.onesignal.ar.C5480a r8, int r9) {
        /*
        r0 = 0;
        r1 = -1;
        r2 = com.onesignal.am.C5464i.DEBUG;	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r3.<init>();	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r4 = "OneSignalRestClient: Making request to: https://onesignal.com/api/v1/";
        r3.append(r4);	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r3.append(r5);	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        com.onesignal.am.m23187b(r2, r3);	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r2 = new java.net.URL;	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r3.<init>();	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r4 = "https://onesignal.com/api/v1/";
        r3.append(r4);	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r3.append(r5);	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r2 = r2.openConnection();	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Throwable -> 0x018f, all -> 0x018c }
        r3 = 0;
        r2.setUseCaches(r3);	 Catch:{ Throwable -> 0x018a }
        r2.setConnectTimeout(r9);	 Catch:{ Throwable -> 0x018a }
        r2.setReadTimeout(r9);	 Catch:{ Throwable -> 0x018a }
        r9 = 1;
        if (r7 == 0) goto L_0x0044;
    L_0x0041:
        r2.setDoInput(r9);	 Catch:{ Throwable -> 0x018a }
    L_0x0044:
        if (r6 == 0) goto L_0x0053;
    L_0x0046:
        r3 = "Content-Type";
        r4 = "application/json; charset=UTF-8";
        r2.setRequestProperty(r3, r4);	 Catch:{ Throwable -> 0x018a }
        r2.setRequestMethod(r6);	 Catch:{ Throwable -> 0x018a }
        r2.setDoOutput(r9);	 Catch:{ Throwable -> 0x018a }
    L_0x0053:
        if (r7 == 0) goto L_0x0088;
    L_0x0055:
        r7 = r7.toString();	 Catch:{ Throwable -> 0x018a }
        r9 = com.onesignal.am.C5464i.DEBUG;	 Catch:{ Throwable -> 0x018a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x018a }
        r3.<init>();	 Catch:{ Throwable -> 0x018a }
        r4 = "OneSignalRestClient: ";
        r3.append(r4);	 Catch:{ Throwable -> 0x018a }
        r3.append(r6);	 Catch:{ Throwable -> 0x018a }
        r4 = " SEND JSON: ";
        r3.append(r4);	 Catch:{ Throwable -> 0x018a }
        r3.append(r7);	 Catch:{ Throwable -> 0x018a }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x018a }
        com.onesignal.am.m23187b(r9, r3);	 Catch:{ Throwable -> 0x018a }
        r9 = "UTF-8";
        r7 = r7.getBytes(r9);	 Catch:{ Throwable -> 0x018a }
        r9 = r7.length;	 Catch:{ Throwable -> 0x018a }
        r2.setFixedLengthStreamingMode(r9);	 Catch:{ Throwable -> 0x018a }
        r9 = r2.getOutputStream();	 Catch:{ Throwable -> 0x018a }
        r9.write(r7);	 Catch:{ Throwable -> 0x018a }
    L_0x0088:
        r7 = r2.getResponseCode();	 Catch:{ Throwable -> 0x018a }
        r9 = com.onesignal.am.C5464i.VERBOSE;	 Catch:{ Throwable -> 0x0188 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0188 }
        r1.<init>();	 Catch:{ Throwable -> 0x0188 }
        r3 = "OneSignalRestClient: After con.getResponseCode  to: https://onesignal.com/api/v1/";
        r1.append(r3);	 Catch:{ Throwable -> 0x0188 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0188 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0188 }
        com.onesignal.am.m23187b(r9, r1);	 Catch:{ Throwable -> 0x0188 }
        r9 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r7 != r9) goto L_0x00fc;
    L_0x00a6:
        r9 = com.onesignal.am.C5464i.DEBUG;	 Catch:{ Throwable -> 0x0188 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0188 }
        r1.<init>();	 Catch:{ Throwable -> 0x0188 }
        r3 = "OneSignalRestClient: Successfully finished request to: https://onesignal.com/api/v1/";
        r1.append(r3);	 Catch:{ Throwable -> 0x0188 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0188 }
        r5 = r1.toString();	 Catch:{ Throwable -> 0x0188 }
        com.onesignal.am.m23187b(r9, r5);	 Catch:{ Throwable -> 0x0188 }
        r5 = r2.getInputStream();	 Catch:{ Throwable -> 0x0188 }
        r9 = new java.util.Scanner;	 Catch:{ Throwable -> 0x0188 }
        r1 = "UTF-8";
        r9.<init>(r5, r1);	 Catch:{ Throwable -> 0x0188 }
        r5 = "\\A";
        r5 = r9.useDelimiter(r5);	 Catch:{ Throwable -> 0x0188 }
        r5 = r5.hasNext();	 Catch:{ Throwable -> 0x0188 }
        if (r5 == 0) goto L_0x00d8;
    L_0x00d3:
        r5 = r9.next();	 Catch:{ Throwable -> 0x0188 }
        goto L_0x00da;
    L_0x00d8:
        r5 = "";
    L_0x00da:
        r9.close();	 Catch:{ Throwable -> 0x0188 }
        r9 = com.onesignal.am.C5464i.DEBUG;	 Catch:{ Throwable -> 0x0188 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0188 }
        r1.<init>();	 Catch:{ Throwable -> 0x0188 }
        r1.append(r6);	 Catch:{ Throwable -> 0x0188 }
        r3 = " RECEIVED JSON: ";
        r1.append(r3);	 Catch:{ Throwable -> 0x0188 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0188 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0188 }
        com.onesignal.am.m23187b(r9, r1);	 Catch:{ Throwable -> 0x0188 }
        r5 = m23290a(r8, r5);	 Catch:{ Throwable -> 0x0188 }
        goto L_0x0182;
    L_0x00fc:
        r9 = com.onesignal.am.C5464i.DEBUG;	 Catch:{ Throwable -> 0x0188 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0188 }
        r1.<init>();	 Catch:{ Throwable -> 0x0188 }
        r3 = "OneSignalRestClient: Failed request to: https://onesignal.com/api/v1/";
        r1.append(r3);	 Catch:{ Throwable -> 0x0188 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0188 }
        r5 = r1.toString();	 Catch:{ Throwable -> 0x0188 }
        com.onesignal.am.m23187b(r9, r5);	 Catch:{ Throwable -> 0x0188 }
        r5 = r2.getErrorStream();	 Catch:{ Throwable -> 0x0188 }
        if (r5 != 0) goto L_0x011c;
    L_0x0118:
        r5 = r2.getInputStream();	 Catch:{ Throwable -> 0x0188 }
    L_0x011c:
        if (r5 == 0) goto L_0x015a;
    L_0x011e:
        r9 = new java.util.Scanner;	 Catch:{ Throwable -> 0x0188 }
        r1 = "UTF-8";
        r9.<init>(r5, r1);	 Catch:{ Throwable -> 0x0188 }
        r5 = "\\A";
        r5 = r9.useDelimiter(r5);	 Catch:{ Throwable -> 0x0188 }
        r5 = r5.hasNext();	 Catch:{ Throwable -> 0x0188 }
        if (r5 == 0) goto L_0x0136;
    L_0x0131:
        r5 = r9.next();	 Catch:{ Throwable -> 0x0188 }
        goto L_0x0138;
    L_0x0136:
        r5 = "";
    L_0x0138:
        r9.close();	 Catch:{ Throwable -> 0x0188 }
        r9 = com.onesignal.am.C5464i.WARN;	 Catch:{ Throwable -> 0x0188 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0188 }
        r1.<init>();	 Catch:{ Throwable -> 0x0188 }
        r3 = "OneSignalRestClient: ";
        r1.append(r3);	 Catch:{ Throwable -> 0x0188 }
        r1.append(r6);	 Catch:{ Throwable -> 0x0188 }
        r3 = " RECEIVED JSON: ";
        r1.append(r3);	 Catch:{ Throwable -> 0x0188 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0188 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0188 }
        com.onesignal.am.m23187b(r9, r1);	 Catch:{ Throwable -> 0x0188 }
        goto L_0x017e;
    L_0x015a:
        r5 = com.onesignal.am.C5464i.WARN;	 Catch:{ Throwable -> 0x0188 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0188 }
        r9.<init>();	 Catch:{ Throwable -> 0x0188 }
        r1 = "OneSignalRestClient: ";
        r9.append(r1);	 Catch:{ Throwable -> 0x0188 }
        r9.append(r6);	 Catch:{ Throwable -> 0x0188 }
        r1 = " HTTP Code: ";
        r9.append(r1);	 Catch:{ Throwable -> 0x0188 }
        r9.append(r7);	 Catch:{ Throwable -> 0x0188 }
        r1 = " No response body!";
        r9.append(r1);	 Catch:{ Throwable -> 0x0188 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0188 }
        com.onesignal.am.m23187b(r5, r9);	 Catch:{ Throwable -> 0x0188 }
        r5 = r0;
    L_0x017e:
        r5 = m23289a(r8, r7, r5, r0);	 Catch:{ Throwable -> 0x0188 }
    L_0x0182:
        if (r2 == 0) goto L_0x01dc;
    L_0x0184:
        r2.disconnect();
        goto L_0x01dc;
    L_0x0188:
        r5 = move-exception;
        goto L_0x0192;
    L_0x018a:
        r5 = move-exception;
        goto L_0x0191;
    L_0x018c:
        r5 = move-exception;
        r2 = r0;
        goto L_0x01de;
    L_0x018f:
        r5 = move-exception;
        r2 = r0;
    L_0x0191:
        r7 = -1;
    L_0x0192:
        r9 = r5 instanceof java.net.ConnectException;	 Catch:{ all -> 0x01dd }
        if (r9 != 0) goto L_0x01b7;
    L_0x0196:
        r9 = r5 instanceof java.net.UnknownHostException;	 Catch:{ all -> 0x01dd }
        if (r9 == 0) goto L_0x019b;
    L_0x019a:
        goto L_0x01b7;
    L_0x019b:
        r9 = com.onesignal.am.C5464i.WARN;	 Catch:{ all -> 0x01dd }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01dd }
        r1.<init>();	 Catch:{ all -> 0x01dd }
        r3 = "OneSignalRestClient: ";
        r1.append(r3);	 Catch:{ all -> 0x01dd }
        r1.append(r6);	 Catch:{ all -> 0x01dd }
        r6 = " Error thrown from network stack. ";
        r1.append(r6);	 Catch:{ all -> 0x01dd }
        r6 = r1.toString();	 Catch:{ all -> 0x01dd }
        com.onesignal.am.m23161a(r9, r6, r5);	 Catch:{ all -> 0x01dd }
        goto L_0x01d5;
    L_0x01b7:
        r6 = com.onesignal.am.C5464i.INFO;	 Catch:{ all -> 0x01dd }
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01dd }
        r9.<init>();	 Catch:{ all -> 0x01dd }
        r1 = "OneSignalRestClient: Could not send last request, device is offline. Throwable: ";
        r9.append(r1);	 Catch:{ all -> 0x01dd }
        r1 = r5.getClass();	 Catch:{ all -> 0x01dd }
        r1 = r1.getName();	 Catch:{ all -> 0x01dd }
        r9.append(r1);	 Catch:{ all -> 0x01dd }
        r9 = r9.toString();	 Catch:{ all -> 0x01dd }
        com.onesignal.am.m23187b(r6, r9);	 Catch:{ all -> 0x01dd }
    L_0x01d5:
        r5 = m23289a(r8, r7, r0, r5);	 Catch:{ all -> 0x01dd }
        if (r2 == 0) goto L_0x01dc;
    L_0x01db:
        goto L_0x0184;
    L_0x01dc:
        return r5;
    L_0x01dd:
        r5 = move-exception;
    L_0x01de:
        if (r2 == 0) goto L_0x01e3;
    L_0x01e0:
        r2.disconnect();
    L_0x01e3:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.ar.d(java.lang.String, java.lang.String, org.json.JSONObject, com.onesignal.ar$a, int):java.lang.Thread");
    }

    /* renamed from: a */
    private static Thread m23290a(final C5480a c5480a, final String str) {
        if (c5480a == null) {
            return null;
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                c5480a.mo4940a(str);
            }
        });
        thread.start();
        return thread;
    }

    /* renamed from: a */
    private static Thread m23289a(final C5480a c5480a, final int i, final String str, final Throwable th) {
        if (c5480a == null) {
            return null;
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                c5480a.mo4936a(i, str, th);
            }
        });
        thread.start();
        return thread;
    }
}

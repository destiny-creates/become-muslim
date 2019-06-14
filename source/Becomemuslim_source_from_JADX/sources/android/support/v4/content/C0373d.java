package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: LocalBroadcastManager */
/* renamed from: android.support.v4.content.d */
public final class C0373d {
    /* renamed from: f */
    private static final Object f981f = new Object();
    /* renamed from: g */
    private static C0373d f982g;
    /* renamed from: a */
    private final Context f983a;
    /* renamed from: b */
    private final HashMap<BroadcastReceiver, ArrayList<C0372b>> f984b = new HashMap();
    /* renamed from: c */
    private final HashMap<String, ArrayList<C0372b>> f985c = new HashMap();
    /* renamed from: d */
    private final ArrayList<C0371a> f986d = new ArrayList();
    /* renamed from: e */
    private final Handler f987e;

    /* compiled from: LocalBroadcastManager */
    /* renamed from: android.support.v4.content.d$a */
    private static final class C0371a {
        /* renamed from: a */
        final Intent f975a;
        /* renamed from: b */
        final ArrayList<C0372b> f976b;

        C0371a(Intent intent, ArrayList<C0372b> arrayList) {
            this.f975a = intent;
            this.f976b = arrayList;
        }
    }

    /* compiled from: LocalBroadcastManager */
    /* renamed from: android.support.v4.content.d$b */
    private static final class C0372b {
        /* renamed from: a */
        final IntentFilter f977a;
        /* renamed from: b */
        final BroadcastReceiver f978b;
        /* renamed from: c */
        boolean f979c;
        /* renamed from: d */
        boolean f980d;

        C0372b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f977a = intentFilter;
            this.f978b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.f978b);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.f977a);
            if (this.f980d) {
                stringBuilder.append(" DEAD");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    /* renamed from: a */
    public static C0373d m1138a(Context context) {
        synchronized (f981f) {
            if (f982g == null) {
                f982g = new C0373d(context.getApplicationContext());
            }
            context = f982g;
        }
        return context;
    }

    private C0373d(Context context) {
        this.f983a = context;
        this.f987e = new Handler(this, context.getMainLooper()) {
            /* renamed from: a */
            final /* synthetic */ C0373d f974a;

            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    this.f974a.m1139a();
                }
            }
        };
    }

    /* renamed from: a */
    public void m1142a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f984b) {
            C0372b c0372b = new C0372b(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.f984b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f984b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(c0372b);
            for (broadcastReceiver = null; broadcastReceiver < intentFilter.countActions(); broadcastReceiver++) {
                String action = intentFilter.getAction(broadcastReceiver);
                ArrayList arrayList2 = (ArrayList) this.f985c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f985c.put(action, arrayList2);
                }
                arrayList2.add(c0372b);
            }
        }
    }

    /* renamed from: a */
    public void m1141a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f984b) {
            ArrayList arrayList = (ArrayList) this.f984b.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                C0372b c0372b = (C0372b) arrayList.get(size);
                c0372b.f980d = true;
                for (int i = 0; i < c0372b.f977a.countActions(); i++) {
                    String action = c0372b.f977a.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.f985c.get(action);
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            C0372b c0372b2 = (C0372b) arrayList2.get(size2);
                            if (c0372b2.f978b == broadcastReceiver) {
                                c0372b2.f980d = true;
                                arrayList2.remove(size2);
                            }
                        }
                        if (arrayList2.size() <= 0) {
                            this.f985c.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean m1143a(android.content.Intent r22) {
        /*
        r21 = this;
        r1 = r21;
        r0 = r22;
        r2 = r1.f984b;
        monitor-enter(r2);
        r10 = r22.getAction();	 Catch:{ all -> 0x016c }
        r3 = r1.f983a;	 Catch:{ all -> 0x016c }
        r3 = r3.getContentResolver();	 Catch:{ all -> 0x016c }
        r11 = r0.resolveTypeIfNeeded(r3);	 Catch:{ all -> 0x016c }
        r12 = r22.getData();	 Catch:{ all -> 0x016c }
        r13 = r22.getScheme();	 Catch:{ all -> 0x016c }
        r14 = r22.getCategories();	 Catch:{ all -> 0x016c }
        r3 = r22.getFlags();	 Catch:{ all -> 0x016c }
        r3 = r3 & 8;
        if (r3 == 0) goto L_0x002c;
    L_0x0029:
        r16 = 1;
        goto L_0x002e;
    L_0x002c:
        r16 = 0;
    L_0x002e:
        if (r16 == 0) goto L_0x0056;
    L_0x0030:
        r3 = "LocalBroadcastManager";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x016c }
        r4.<init>();	 Catch:{ all -> 0x016c }
        r5 = "Resolving type ";
        r4.append(r5);	 Catch:{ all -> 0x016c }
        r4.append(r11);	 Catch:{ all -> 0x016c }
        r5 = " scheme ";
        r4.append(r5);	 Catch:{ all -> 0x016c }
        r4.append(r13);	 Catch:{ all -> 0x016c }
        r5 = " of intent ";
        r4.append(r5);	 Catch:{ all -> 0x016c }
        r4.append(r0);	 Catch:{ all -> 0x016c }
        r4 = r4.toString();	 Catch:{ all -> 0x016c }
        android.util.Log.v(r3, r4);	 Catch:{ all -> 0x016c }
    L_0x0056:
        r3 = r1.f985c;	 Catch:{ all -> 0x016c }
        r4 = r22.getAction();	 Catch:{ all -> 0x016c }
        r3 = r3.get(r4);	 Catch:{ all -> 0x016c }
        r8 = r3;
        r8 = (java.util.ArrayList) r8;	 Catch:{ all -> 0x016c }
        if (r8 == 0) goto L_0x0169;
    L_0x0065:
        if (r16 == 0) goto L_0x007d;
    L_0x0067:
        r3 = "LocalBroadcastManager";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x016c }
        r4.<init>();	 Catch:{ all -> 0x016c }
        r5 = "Action list: ";
        r4.append(r5);	 Catch:{ all -> 0x016c }
        r4.append(r8);	 Catch:{ all -> 0x016c }
        r4 = r4.toString();	 Catch:{ all -> 0x016c }
        android.util.Log.v(r3, r4);	 Catch:{ all -> 0x016c }
    L_0x007d:
        r3 = 0;
        r6 = r3;
        r7 = 0;
    L_0x0080:
        r3 = r8.size();	 Catch:{ all -> 0x016c }
        if (r7 >= r3) goto L_0x0139;
    L_0x0086:
        r3 = r8.get(r7);	 Catch:{ all -> 0x016c }
        r5 = r3;
        r5 = (android.support.v4.content.C0373d.C0372b) r5;	 Catch:{ all -> 0x016c }
        if (r16 == 0) goto L_0x00a7;
    L_0x008f:
        r3 = "LocalBroadcastManager";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x016c }
        r4.<init>();	 Catch:{ all -> 0x016c }
        r9 = "Matching against filter ";
        r4.append(r9);	 Catch:{ all -> 0x016c }
        r9 = r5.f977a;	 Catch:{ all -> 0x016c }
        r4.append(r9);	 Catch:{ all -> 0x016c }
        r4 = r4.toString();	 Catch:{ all -> 0x016c }
        android.util.Log.v(r3, r4);	 Catch:{ all -> 0x016c }
    L_0x00a7:
        r3 = r5.f979c;	 Catch:{ all -> 0x016c }
        if (r3 == 0) goto L_0x00c0;
    L_0x00ab:
        if (r16 == 0) goto L_0x00b4;
    L_0x00ad:
        r3 = "LocalBroadcastManager";
        r4 = "  Filter's target already added";
        android.util.Log.v(r3, r4);	 Catch:{ all -> 0x016c }
    L_0x00b4:
        r18 = r7;
        r19 = r8;
        r17 = r10;
        r20 = r11;
        r11 = 1;
        r10 = r6;
        goto L_0x012e;
    L_0x00c0:
        r3 = r5.f977a;	 Catch:{ all -> 0x016c }
        r9 = "LocalBroadcastManager";
        r4 = r10;
        r15 = r5;
        r5 = r11;
        r17 = r10;
        r10 = r6;
        r6 = r13;
        r18 = r7;
        r7 = r12;
        r19 = r8;
        r8 = r14;
        r20 = r11;
        r11 = 1;
        r3 = r3.match(r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x016c }
        if (r3 < 0) goto L_0x0105;
    L_0x00da:
        if (r16 == 0) goto L_0x00f6;
    L_0x00dc:
        r4 = "LocalBroadcastManager";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x016c }
        r5.<init>();	 Catch:{ all -> 0x016c }
        r6 = "  Filter matched!  match=0x";
        r5.append(r6);	 Catch:{ all -> 0x016c }
        r3 = java.lang.Integer.toHexString(r3);	 Catch:{ all -> 0x016c }
        r5.append(r3);	 Catch:{ all -> 0x016c }
        r3 = r5.toString();	 Catch:{ all -> 0x016c }
        android.util.Log.v(r4, r3);	 Catch:{ all -> 0x016c }
    L_0x00f6:
        if (r10 != 0) goto L_0x00fe;
    L_0x00f8:
        r6 = new java.util.ArrayList;	 Catch:{ all -> 0x016c }
        r6.<init>();	 Catch:{ all -> 0x016c }
        goto L_0x00ff;
    L_0x00fe:
        r6 = r10;
    L_0x00ff:
        r6.add(r15);	 Catch:{ all -> 0x016c }
        r15.f979c = r11;	 Catch:{ all -> 0x016c }
        goto L_0x012f;
    L_0x0105:
        if (r16 == 0) goto L_0x012e;
    L_0x0107:
        switch(r3) {
            case -4: goto L_0x0116;
            case -3: goto L_0x0113;
            case -2: goto L_0x0110;
            case -1: goto L_0x010d;
            default: goto L_0x010a;
        };	 Catch:{ all -> 0x016c }
    L_0x010a:
        r3 = "unknown reason";
        goto L_0x0118;
    L_0x010d:
        r3 = "type";
        goto L_0x0118;
    L_0x0110:
        r3 = "data";
        goto L_0x0118;
    L_0x0113:
        r3 = "action";
        goto L_0x0118;
    L_0x0116:
        r3 = "category";
    L_0x0118:
        r4 = "LocalBroadcastManager";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x016c }
        r5.<init>();	 Catch:{ all -> 0x016c }
        r6 = "  Filter did not match: ";
        r5.append(r6);	 Catch:{ all -> 0x016c }
        r5.append(r3);	 Catch:{ all -> 0x016c }
        r3 = r5.toString();	 Catch:{ all -> 0x016c }
        android.util.Log.v(r4, r3);	 Catch:{ all -> 0x016c }
    L_0x012e:
        r6 = r10;
    L_0x012f:
        r7 = r18 + 1;
        r10 = r17;
        r8 = r19;
        r11 = r20;
        goto L_0x0080;
    L_0x0139:
        r10 = r6;
        r11 = 1;
        if (r10 == 0) goto L_0x0169;
    L_0x013d:
        r3 = 0;
    L_0x013e:
        r4 = r10.size();	 Catch:{ all -> 0x016c }
        if (r3 >= r4) goto L_0x0150;
    L_0x0144:
        r4 = r10.get(r3);	 Catch:{ all -> 0x016c }
        r4 = (android.support.v4.content.C0373d.C0372b) r4;	 Catch:{ all -> 0x016c }
        r5 = 0;
        r4.f979c = r5;	 Catch:{ all -> 0x016c }
        r3 = r3 + 1;
        goto L_0x013e;
    L_0x0150:
        r3 = r1.f986d;	 Catch:{ all -> 0x016c }
        r4 = new android.support.v4.content.d$a;	 Catch:{ all -> 0x016c }
        r4.<init>(r0, r10);	 Catch:{ all -> 0x016c }
        r3.add(r4);	 Catch:{ all -> 0x016c }
        r0 = r1.f987e;	 Catch:{ all -> 0x016c }
        r0 = r0.hasMessages(r11);	 Catch:{ all -> 0x016c }
        if (r0 != 0) goto L_0x0167;
    L_0x0162:
        r0 = r1.f987e;	 Catch:{ all -> 0x016c }
        r0.sendEmptyMessage(r11);	 Catch:{ all -> 0x016c }
    L_0x0167:
        monitor-exit(r2);	 Catch:{ all -> 0x016c }
        return r11;
    L_0x0169:
        monitor-exit(r2);	 Catch:{ all -> 0x016c }
        r0 = 0;
        return r0;
    L_0x016c:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x016c }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.d.a(android.content.Intent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m1139a() {
        /*
        r9 = this;
    L_0x0000:
        r0 = r9.f984b;
        monitor-enter(r0);
        r1 = r9.f986d;	 Catch:{ all -> 0x0045 }
        r1 = r1.size();	 Catch:{ all -> 0x0045 }
        if (r1 > 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r0);	 Catch:{ all -> 0x0045 }
        return;
    L_0x000d:
        r1 = new android.support.v4.content.C0373d.C0371a[r1];	 Catch:{ all -> 0x0045 }
        r2 = r9.f986d;	 Catch:{ all -> 0x0045 }
        r2.toArray(r1);	 Catch:{ all -> 0x0045 }
        r2 = r9.f986d;	 Catch:{ all -> 0x0045 }
        r2.clear();	 Catch:{ all -> 0x0045 }
        monitor-exit(r0);	 Catch:{ all -> 0x0045 }
        r0 = 0;
        r2 = 0;
    L_0x001c:
        r3 = r1.length;
        if (r2 >= r3) goto L_0x0000;
    L_0x001f:
        r3 = r1[r2];
        r4 = r3.f976b;
        r4 = r4.size();
        r5 = 0;
    L_0x0028:
        if (r5 >= r4) goto L_0x0042;
    L_0x002a:
        r6 = r3.f976b;
        r6 = r6.get(r5);
        r6 = (android.support.v4.content.C0373d.C0372b) r6;
        r7 = r6.f980d;
        if (r7 != 0) goto L_0x003f;
    L_0x0036:
        r6 = r6.f978b;
        r7 = r9.f983a;
        r8 = r3.f975a;
        r6.onReceive(r7, r8);
    L_0x003f:
        r5 = r5 + 1;
        goto L_0x0028;
    L_0x0042:
        r2 = r2 + 1;
        goto L_0x001c;
    L_0x0045:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0045 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.d.a():void");
    }
}

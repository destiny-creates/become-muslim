package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.C3211a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.measurement.AppMeasurement.C5149b;
import com.google.android.gms.measurement.AppMeasurement.C5150c;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2958j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.df */
public final class df extends C8220s {
    /* renamed from: a */
    protected dy f32808a;
    /* renamed from: b */
    protected boolean f32809b = true;
    /* renamed from: c */
    private C5149b f32810c;
    /* renamed from: d */
    private final Set<C5150c> f32811d = new CopyOnWriteArraySet();
    /* renamed from: e */
    private boolean f32812e;
    /* renamed from: f */
    private final AtomicReference<String> f32813f = new AtomicReference();

    protected df(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: a */
    private final void m44067a(java.lang.String r29, java.lang.String r30, long r31, android.os.Bundle r33, boolean r34, boolean r35, boolean r36, java.lang.String r37) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r28 = this;
        r1 = r28;
        r8 = r29;
        r6 = r30;
        r5 = r33;
        com.google.android.gms.common.internal.C2872v.a(r29);
        com.google.android.gms.common.internal.C2872v.a(r30);
        com.google.android.gms.common.internal.C2872v.a(r33);
        r28.mo6210d();
        r28.m42728w();
        r0 = r1.q;
        r0 = r0.m31983y();
        if (r0 != 0) goto L_0x002d;
    L_0x001f:
        r0 = r28.mo4754r();
        r0 = r0.m42578v();
        r2 = "Event not sent since app measurement is disabled";
        r0.m21307a(r2);
        return;
    L_0x002d:
        r0 = r1.f32812e;
        r4 = 0;
        r16 = 0;
        r7 = 1;
        if (r0 != 0) goto L_0x0071;
    L_0x0035:
        r1.f32812e = r7;
        r0 = "com.google.android.gms.tagmanager.TagManagerService";	 Catch:{ ClassNotFoundException -> 0x0064 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0064 }
        r9 = "initialize";	 Catch:{ Exception -> 0x0055 }
        r10 = new java.lang.Class[r7];	 Catch:{ Exception -> 0x0055 }
        r11 = android.content.Context.class;	 Catch:{ Exception -> 0x0055 }
        r10[r16] = r11;	 Catch:{ Exception -> 0x0055 }
        r0 = r0.getDeclaredMethod(r9, r10);	 Catch:{ Exception -> 0x0055 }
        r9 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0055 }
        r10 = r28.mo4752n();	 Catch:{ Exception -> 0x0055 }
        r9[r16] = r10;	 Catch:{ Exception -> 0x0055 }
        r0.invoke(r4, r9);	 Catch:{ Exception -> 0x0055 }
        goto L_0x0071;
    L_0x0055:
        r0 = move-exception;
        r9 = r28.mo4754r();	 Catch:{ ClassNotFoundException -> 0x0064 }
        r9 = r9.m42565i();	 Catch:{ ClassNotFoundException -> 0x0064 }
        r10 = "Failed to invoke Tag Manager's initialize() method";	 Catch:{ ClassNotFoundException -> 0x0064 }
        r9.m21308a(r10, r0);	 Catch:{ ClassNotFoundException -> 0x0064 }
        goto L_0x0071;
    L_0x0064:
        r0 = r28.mo4754r();
        r0 = r0.m42567k();
        r9 = "Tag Manager is not found and thus will not be used";
        r0.m21307a(r9);
    L_0x0071:
        r0 = 40;
        if (r36 == 0) goto L_0x00df;
    L_0x0075:
        r28.mo4755u();
        r9 = "_iap";
        r9 = r9.equals(r6);
        if (r9 != 0) goto L_0x00df;
    L_0x0080:
        r9 = r1.q;
        r9 = r9.m31969k();
        r10 = "event";
        r10 = r9.m42666a(r10, r6);
        r11 = 2;
        if (r10 != 0) goto L_0x0090;
    L_0x008f:
        goto L_0x00a9;
    L_0x0090:
        r10 = "event";
        r12 = com.google.android.gms.measurement.AppMeasurement.C6846a.f24652a;
        r10 = r9.m42667a(r10, r12, r6);
        if (r10 != 0) goto L_0x009f;
    L_0x009a:
        r9 = 13;
        r11 = 13;
        goto L_0x00a9;
    L_0x009f:
        r10 = "event";
        r9 = r9.m42665a(r10, r0, r6);
        if (r9 != 0) goto L_0x00a8;
    L_0x00a7:
        goto L_0x00a9;
    L_0x00a8:
        r11 = 0;
    L_0x00a9:
        if (r11 == 0) goto L_0x00df;
    L_0x00ab:
        r2 = r28.mo4754r();
        r2 = r2.m42564h();
        r3 = "Invalid public event name. Event will not be logged (FE)";
        r4 = r28.mo6212o();
        r4 = r4.m42528a(r6);
        r2.m21308a(r3, r4);
        r2 = r1.q;
        r2.m31969k();
        r0 = com.google.android.gms.internal.p213l.fw.m42637a(r6, r0, r7);
        if (r6 == 0) goto L_0x00d2;
    L_0x00cb:
        r16 = r30.length();
        r2 = r16;
        goto L_0x00d3;
    L_0x00d2:
        r2 = 0;
    L_0x00d3:
        r3 = r1.q;
        r3 = r3.m31969k();
        r4 = "_ev";
        r3.m42662a(r11, r4, r0, r2);
        return;
    L_0x00df:
        r28.mo4755u();
        r9 = r28.mo6745i();
        r15 = r9.m44139B();
        if (r15 == 0) goto L_0x00f6;
    L_0x00ec:
        r9 = "_sc";
        r9 = r5.containsKey(r9);
        if (r9 != 0) goto L_0x00f6;
    L_0x00f4:
        r15.f17148d = r7;
    L_0x00f6:
        if (r34 == 0) goto L_0x00fc;
    L_0x00f8:
        if (r36 == 0) goto L_0x00fc;
    L_0x00fa:
        r9 = 1;
        goto L_0x00fd;
    L_0x00fc:
        r9 = 0;
    L_0x00fd:
        com.google.android.gms.internal.p213l.ea.m44136a(r15, r5, r9);
        r9 = "am";
        r17 = r9.equals(r8);
        r9 = com.google.android.gms.internal.p213l.fw.m42652g(r30);
        if (r34 == 0) goto L_0x013f;
    L_0x010c:
        r2 = r1.f32810c;
        if (r2 == 0) goto L_0x013f;
    L_0x0110:
        if (r9 != 0) goto L_0x013f;
    L_0x0112:
        if (r17 != 0) goto L_0x013f;
    L_0x0114:
        r0 = r28.mo4754r();
        r0 = r0.m42578v();
        r2 = "Passing event to registered event handler (FE)";
        r3 = r28.mo6212o();
        r3 = r3.m42528a(r6);
        r4 = r28.mo6212o();
        r4 = r4.m42525a(r5);
        r0.m21309a(r2, r3, r4);
        r2 = r1.f32810c;
        r3 = r29;
        r4 = r30;
        r5 = r33;
        r6 = r31;
        r2.m21831a(r3, r4, r5, r6);
        return;
    L_0x013f:
        r2 = r1.q;
        r2 = r2.m31956D();
        if (r2 != 0) goto L_0x0148;
    L_0x0147:
        return;
    L_0x0148:
        r2 = r28.mo6213p();
        r2 = r2.m42668b(r6);
        if (r2 == 0) goto L_0x018c;
    L_0x0152:
        r3 = r28.mo4754r();
        r3 = r3.m42564h();
        r4 = "Invalid event name. Event will not be logged (FE)";
        r5 = r28.mo6212o();
        r5 = r5.m42528a(r6);
        r3.m21308a(r4, r5);
        r28.mo6213p();
        r0 = com.google.android.gms.internal.p213l.fw.m42637a(r6, r0, r7);
        if (r6 == 0) goto L_0x0174;
    L_0x0170:
        r16 = r30.length();
    L_0x0174:
        r3 = r1.q;
        r3 = r3.m31969k();
        r4 = "_ev";
        r29 = r3;
        r30 = r37;
        r31 = r2;
        r32 = r4;
        r33 = r0;
        r34 = r16;
        r29.m42664a(r30, r31, r32, r33, r34);
        return;
    L_0x018c:
        r0 = "_o";
        r2 = "_sn";
        r9 = "_sc";
        r10 = "_si";
        r0 = new java.lang.String[]{r0, r2, r9, r10};
        r0 = com.google.android.gms.common.util.C2896f.a(r0);
        r9 = r28.mo6213p();
        r2 = 1;
        r10 = r37;
        r11 = r30;
        r12 = r33;
        r13 = r0;
        r14 = r36;
        r18 = r15;
        r15 = r2;
        r2 = r9.m42658a(r10, r11, r12, r13, r14, r15);
        if (r2 == 0) goto L_0x01e5;
    L_0x01b3:
        r9 = "_sc";
        r9 = r2.containsKey(r9);
        if (r9 == 0) goto L_0x01e5;
    L_0x01bb:
        r9 = "_si";
        r9 = r2.containsKey(r9);
        if (r9 != 0) goto L_0x01c4;
    L_0x01c3:
        goto L_0x01e5;
    L_0x01c4:
        r4 = "_sn";
        r4 = r2.getString(r4);
        r9 = "_sc";
        r9 = r2.getString(r9);
        r10 = "_si";
        r10 = r2.getLong(r10);
        r10 = java.lang.Long.valueOf(r10);
        r11 = new com.google.android.gms.internal.l.dz;
        r12 = r10.longValue();
        r11.<init>(r4, r9, r12);
        r15 = r11;
        goto L_0x01e6;
    L_0x01e5:
        r15 = r4;
    L_0x01e6:
        if (r15 != 0) goto L_0x01eb;
    L_0x01e8:
        r4 = r18;
        goto L_0x01ec;
    L_0x01eb:
        r4 = r15;
    L_0x01ec:
        r15 = new java.util.ArrayList;
        r15.<init>();
        r15.add(r2);
        r9 = r28.mo6213p();
        r9 = r9.m42681h();
        r13 = r9.nextLong();
        r9 = r2.keySet();
        r5 = r33.size();
        r5 = new java.lang.String[r5];
        r5 = r9.toArray(r5);
        r5 = (java.lang.String[]) r5;
        java.util.Arrays.sort(r5);
        r12 = r5.length;
        r10 = 0;
        r11 = 0;
    L_0x0216:
        if (r11 >= r12) goto L_0x02d0;
    L_0x0218:
        r9 = r5[r11];
        r18 = r2.get(r9);
        r28.mo6213p();
        r19 = r15;
        r15 = com.google.android.gms.internal.p213l.fw.m42646a(r18);
        if (r15 == 0) goto L_0x02b1;
    L_0x0229:
        r7 = r15.length;
        r2.putInt(r9, r7);
        r7 = 0;
    L_0x022e:
        r3 = r15.length;
        if (r7 >= r3) goto L_0x0299;
    L_0x0231:
        r3 = r15[r7];
        r21 = r15;
        r15 = 1;
        com.google.android.gms.internal.p213l.ea.m44136a(r4, r3, r15);
        r18 = r28.mo6213p();
        r20 = "_ep";
        r22 = 0;
        r23 = r9;
        r9 = r18;
        r24 = r10;
        r10 = r37;
        r18 = r11;
        r11 = r20;
        r20 = r12;
        r12 = r3;
        r25 = r4;
        r3 = r13;
        r13 = r0;
        r14 = r36;
        r26 = r0;
        r27 = r5;
        r0 = r19;
        r5 = r21;
        r19 = 1;
        r15 = r22;
        r9 = r9.m42658a(r10, r11, r12, r13, r14, r15);
        r10 = "_en";
        r9.putString(r10, r6);
        r10 = "_eid";
        r9.putLong(r10, r3);
        r10 = "_gn";
        r11 = r23;
        r9.putString(r10, r11);
        r10 = "_ll";
        r12 = r5.length;
        r9.putInt(r10, r12);
        r10 = "_i";
        r9.putInt(r10, r7);
        r0.add(r9);
        r7 = r7 + 1;
        r19 = r0;
        r13 = r3;
        r15 = r5;
        r9 = r11;
        r11 = r18;
        r12 = r20;
        r10 = r24;
        r4 = r25;
        r0 = r26;
        r5 = r27;
        goto L_0x022e;
    L_0x0299:
        r26 = r0;
        r25 = r4;
        r27 = r5;
        r24 = r10;
        r18 = r11;
        r20 = r12;
        r3 = r13;
        r5 = r15;
        r0 = r19;
        r19 = 1;
        r5 = r5.length;
        r7 = r24;
        r10 = r7 + r5;
        goto L_0x02c1;
    L_0x02b1:
        r26 = r0;
        r25 = r4;
        r27 = r5;
        r7 = r10;
        r18 = r11;
        r20 = r12;
        r3 = r13;
        r0 = r19;
        r19 = 1;
    L_0x02c1:
        r11 = r18 + 1;
        r15 = r0;
        r13 = r3;
        r12 = r20;
        r4 = r25;
        r0 = r26;
        r5 = r27;
        r7 = 1;
        goto L_0x0216;
    L_0x02d0:
        r7 = r10;
        r3 = r13;
        r0 = r15;
        r19 = 1;
        if (r7 == 0) goto L_0x02e1;
    L_0x02d7:
        r5 = "_eid";
        r2.putLong(r5, r3);
        r3 = "_epc";
        r2.putInt(r3, r7);
    L_0x02e1:
        r9 = 0;
    L_0x02e2:
        r2 = r0.size();
        if (r9 >= r2) goto L_0x036a;
    L_0x02e8:
        r2 = r0.get(r9);
        r2 = (android.os.Bundle) r2;
        if (r9 == 0) goto L_0x02f2;
    L_0x02f0:
        r3 = 1;
        goto L_0x02f3;
    L_0x02f2:
        r3 = 0;
    L_0x02f3:
        if (r3 == 0) goto L_0x02f8;
    L_0x02f5:
        r3 = "_ep";
        goto L_0x02f9;
    L_0x02f8:
        r3 = r6;
    L_0x02f9:
        r4 = "_o";
        r2.putString(r4, r8);
        if (r35 == 0) goto L_0x0308;
    L_0x0300:
        r4 = r28.mo6213p();
        r2 = r4.m42657a(r2);
    L_0x0308:
        r11 = r2;
        r2 = r28.mo4754r();
        r2 = r2.m42578v();
        r4 = "Logging event (FE)";
        r5 = r28.mo6212o();
        r5 = r5.m42528a(r6);
        r7 = r28.mo6212o();
        r7 = r7.m42525a(r11);
        r2.m21309a(r4, r5, r7);
        r12 = new com.google.android.gms.internal.l.aq;
        r4 = new com.google.android.gms.internal.l.an;
        r4.<init>(r11);
        r2 = r12;
        r5 = r29;
        r13 = r6;
        r14 = 1;
        r6 = r31;
        r2.<init>(r3, r4, r5, r6);
        r2 = r28.mo6744h();
        r15 = r37;
        r2.m44192a(r12, r15);
        if (r17 != 0) goto L_0x0363;
    L_0x0342:
        r2 = r1.f32811d;
        r12 = r2.iterator();
    L_0x0348:
        r2 = r12.hasNext();
        if (r2 == 0) goto L_0x0363;
    L_0x034e:
        r2 = r12.next();
        r2 = (com.google.android.gms.measurement.AppMeasurement.C5150c) r2;
        r5 = new android.os.Bundle;
        r5.<init>(r11);
        r3 = r29;
        r4 = r30;
        r6 = r31;
        r2.m21832a(r3, r4, r5, r6);
        goto L_0x0348;
    L_0x0363:
        r9 = r9 + 1;
        r6 = r13;
        r19 = 1;
        goto L_0x02e2;
    L_0x036a:
        r13 = r6;
        r14 = 1;
        r28.mo4755u();
        r0 = r28.mo6745i();
        r0 = r0.m44139B();
        if (r0 == 0) goto L_0x0388;
    L_0x0379:
        r0 = "_ae";
        r0 = r0.equals(r13);
        if (r0 == 0) goto L_0x0388;
    L_0x0381:
        r0 = r28.mo6747k();
        r0.m44232a(r14);
    L_0x0388:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.df.a(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    /* renamed from: a */
    private final void m44068a(String str, String str2, long j, Object obj) {
        mo4753q().m42612a(new dh(this, str, str2, obj, j));
    }

    /* renamed from: a */
    private final void m44069a(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        m44074b(str, str2, mo4751m().a(), bundle, z, z2, z3, str3);
    }

    /* renamed from: a */
    private final void m44070a(String str, String str2, Object obj, long j) {
        C2872v.a(str);
        C2872v.a(str2);
        mo6210d();
        mo6208b();
        m42728w();
        if (!this.q.m31983y()) {
            mo4754r().m42578v().m21307a("User property not set since app measurement is disabled");
        } else if (this.q.m31956D()) {
            mo4754r().m42578v().m21309a("Setting user property (FE)", mo6212o().m42528a(str2), obj);
            mo6744h().m44196a(new ft(str2, j, obj, str));
        }
    }

    /* renamed from: b */
    private final List<ConditionalUserProperty> m44071b(String str, String str2, String str3) {
        bd I_;
        if (mo4753q().m42619g()) {
            I_ = mo4754r().I_();
            str2 = "Cannot get conditional user properties from analytics worker thread";
        } else if (C5052x.m21503a()) {
            I_ = mo4754r().I_();
            str2 = "Cannot get conditional user properties from main thread";
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.q.mo4753q().m42612a(new C5037do(this, atomicReference, str, str2, str3));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    mo4754r().m42565i().m21309a("Interrupted waiting for get conditional user properties", str, e);
                }
            }
            List<C7827y> list = (List) atomicReference.get();
            if (list == null) {
                mo4754r().m42565i().m21308a("Timed out waiting for get conditional user properties", str);
                return Collections.emptyList();
            }
            List<ConditionalUserProperty> arrayList = new ArrayList(list.size());
            for (C7827y c7827y : list) {
                ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
                conditionalUserProperty.mAppId = c7827y.f29124a;
                conditionalUserProperty.mOrigin = c7827y.f29125b;
                conditionalUserProperty.mCreationTimestamp = c7827y.f29127d;
                conditionalUserProperty.mName = c7827y.f29126c.f28979a;
                conditionalUserProperty.mValue = c7827y.f29126c.m38105a();
                conditionalUserProperty.mActive = c7827y.f29128e;
                conditionalUserProperty.mTriggerEventName = c7827y.f29129f;
                if (c7827y.f29130g != null) {
                    conditionalUserProperty.mTimedOutEventName = c7827y.f29130g.f28970a;
                    if (c7827y.f29130g.f28971b != null) {
                        conditionalUserProperty.mTimedOutEventParams = c7827y.f29130g.f28971b.m38075b();
                    }
                }
                conditionalUserProperty.mTriggerTimeout = c7827y.f29131h;
                if (c7827y.f29132i != null) {
                    conditionalUserProperty.mTriggeredEventName = c7827y.f29132i.f28970a;
                    if (c7827y.f29132i.f28971b != null) {
                        conditionalUserProperty.mTriggeredEventParams = c7827y.f29132i.f28971b.m38075b();
                    }
                }
                conditionalUserProperty.mTriggeredTimestamp = c7827y.f29126c.f28980b;
                conditionalUserProperty.mTimeToLive = c7827y.f29133j;
                if (c7827y.f29134k != null) {
                    conditionalUserProperty.mExpiredEventName = c7827y.f29134k.f28970a;
                    if (c7827y.f29134k.f28971b != null) {
                        conditionalUserProperty.mExpiredEventParams = c7827y.f29134k.f28971b.m38075b();
                    }
                }
                arrayList.add(conditionalUserProperty);
            }
            return arrayList;
        }
        I_.m21307a(str2);
        return Collections.emptyList();
    }

    /* renamed from: b */
    private final Map<String, Object> m44072b(String str, String str2, String str3, boolean z) {
        bd I_;
        if (mo4753q().m42619g()) {
            I_ = mo4754r().I_();
            str2 = "Cannot get user properties from analytics worker thread";
        } else if (C5052x.m21503a()) {
            I_ = mo4754r().I_();
            str2 = "Cannot get user properties from main thread";
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.q.mo4753q().m42612a(new dp(this, atomicReference, str, str2, str3, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    mo4754r().m42565i().m21308a("Interrupted waiting for get user properties", e);
                }
            }
            List<ft> list = (List) atomicReference.get();
            if (list == null) {
                I_ = mo4754r().m42565i();
                str2 = "Timed out waiting for get user properties";
            } else {
                Map<String, Object> c3211a = new C3211a(list.size());
                for (ft ftVar : list) {
                    c3211a.put(ftVar.f28979a, ftVar.m38105a());
                }
                return c3211a;
            }
        }
        I_.m21307a(str2);
        return Collections.emptyMap();
    }

    /* renamed from: b */
    private final void m44074b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        Bundle bundle3 = bundle;
        if (bundle3 == null) {
            bundle2 = new Bundle();
        } else {
            Bundle bundle4 = new Bundle(bundle3);
            for (String str4 : bundle4.keySet()) {
                Object obj = bundle4.get(str4);
                if (obj instanceof Bundle) {
                    bundle4.putBundle(str4, new Bundle((Bundle) obj));
                } else {
                    int i = 0;
                    if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        while (i < parcelableArr.length) {
                            if (parcelableArr[i] instanceof Bundle) {
                                parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                            }
                            i++;
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        while (i < arrayList.size()) {
                            Object obj2 = arrayList.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.set(i, new Bundle((Bundle) obj2));
                            }
                            i++;
                        }
                    }
                }
            }
            bundle2 = bundle4;
        }
        mo4753q().m42612a(new dx(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    /* renamed from: b */
    private final void m44075b(String str, String str2, String str3, Bundle bundle) {
        long a = mo4751m().a();
        C2872v.a(str2);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = a;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        mo4753q().m42612a(new dn(this, conditionalUserProperty));
    }

    /* renamed from: c */
    private final void m44076c(ConditionalUserProperty conditionalUserProperty) {
        long a = mo4751m().a();
        C2872v.a(conditionalUserProperty);
        C2872v.a(conditionalUserProperty.mName);
        C2872v.a(conditionalUserProperty.mOrigin);
        C2872v.a(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = a;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (mo6213p().m42674d(str) != 0) {
            mo4754r().I_().m21308a("Invalid conditional user property name", mo6212o().m42532c(str));
        } else if (mo6213p().m42669b(str, obj) != 0) {
            mo4754r().I_().m21309a("Invalid conditional user property value", mo6212o().m42532c(str), obj);
        } else {
            Object c = mo6213p().m42672c(str, obj);
            if (c == null) {
                mo4754r().I_().m21309a("Unable to normalize conditional user property value", mo6212o().m42532c(str), obj);
                return;
            }
            conditionalUserProperty.mValue = c;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                j = conditionalUserProperty.mTimeToLive;
                if (j <= 15552000000L) {
                    if (j >= 1) {
                        mo4753q().m42612a(new dm(this, conditionalUserProperty));
                        return;
                    }
                }
                mo4754r().I_().m21309a("Invalid conditional user property time to live", mo6212o().m42532c(str), Long.valueOf(j));
                return;
            }
            mo4754r().I_().m21309a("Invalid conditional user property timeout", mo6212o().m42532c(str), Long.valueOf(j));
        }
    }

    /* renamed from: c */
    private final void m44077c(boolean z) {
        mo6210d();
        mo6208b();
        m42728w();
        mo4754r().m42578v().m21308a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        mo6214s().m42586b(z);
        if (!mo6215t().m38058k(mo6743g().m43958C())) {
            mo6744h().m44185C();
        } else if (this.q.m31983y() && this.f32809b) {
            mo4754r().m42578v().m21307a("Recording app launch after enabling measurement for the first time (FE)");
            m44088J();
        } else {
            mo6744h().m44185C();
        }
    }

    /* renamed from: d */
    private final void m44078d(com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty r26) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r25 = this;
        r0 = r26;
        r25.mo6210d();
        r25.m42728w();
        com.google.android.gms.common.internal.C2872v.a(r26);
        r1 = r0.mName;
        com.google.android.gms.common.internal.C2872v.a(r1);
        r1 = r0.mOrigin;
        com.google.android.gms.common.internal.C2872v.a(r1);
        r1 = r0.mValue;
        com.google.android.gms.common.internal.C2872v.a(r1);
        r1 = r25;
        r2 = r1.q;
        r2 = r2.m31983y();
        if (r2 != 0) goto L_0x0032;
    L_0x0024:
        r0 = r25.mo4754r();
        r0 = r0.m42578v();
        r2 = "Conditional property not sent since Firebase Analytics is disabled";
        r0.m21307a(r2);
        return;
    L_0x0032:
        r2 = new com.google.android.gms.internal.l.ft;
        r4 = r0.mName;
        r5 = r0.mTriggeredTimestamp;
        r7 = r0.mValue;
        r8 = r0.mOrigin;
        r3 = r2;
        r3.<init>(r4, r5, r7, r8);
        r9 = r25.mo6213p();	 Catch:{ IllegalArgumentException -> 0x00ad }
        r10 = r0.mAppId;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r11 = r0.mTriggeredEventName;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r12 = r0.mTriggeredEventParams;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r13 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r14 = 0;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r16 = 1;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r17 = 0;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r14 = r9.m42659a(r10, r11, r12, r13, r14, r16, r17);	 Catch:{ IllegalArgumentException -> 0x00ad }
        r3 = r25.mo6213p();	 Catch:{ IllegalArgumentException -> 0x00ad }
        r4 = r0.mAppId;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r5 = r0.mTimedOutEventName;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r6 = r0.mTimedOutEventParams;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r7 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r8 = 0;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r10 = 1;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r11 = 0;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r11 = r3.m42659a(r4, r5, r6, r7, r8, r10, r11);	 Catch:{ IllegalArgumentException -> 0x00ad }
        r15 = r25.mo6213p();	 Catch:{ IllegalArgumentException -> 0x00ad }
        r3 = r0.mAppId;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r4 = r0.mExpiredEventName;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r5 = r0.mExpiredEventParams;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r6 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r20 = 0;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r22 = 1;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r23 = 0;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r16 = r3;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r17 = r4;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r18 = r5;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r19 = r6;	 Catch:{ IllegalArgumentException -> 0x00ad }
        r17 = r15.m42659a(r16, r17, r18, r19, r20, r22, r23);	 Catch:{ IllegalArgumentException -> 0x00ad }
        r15 = new com.google.android.gms.internal.l.y;
        r4 = r0.mAppId;
        r5 = r0.mOrigin;
        r7 = r0.mCreationTimestamp;
        r10 = r0.mTriggerEventName;
        r12 = r0.mTriggerTimeout;
        r24 = r10;
        r9 = r0.mTimeToLive;
        r3 = r15;
        r6 = r2;
        r18 = r9;
        r0 = 0;
        r9 = r0;
        r10 = r24;
        r0 = r15;
        r15 = r18;
        r3.<init>(r4, r5, r6, r7, r9, r10, r11, r12, r14, r15, r17);
        r2 = r25.mo6744h();
        r2.m44197a(r0);
    L_0x00ad:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.df.d(com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty):void");
    }

    /* renamed from: e */
    private final void m44079e(com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty r23) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r22 = this;
        r0 = r23;
        r22.mo6210d();
        r22.m42728w();
        com.google.android.gms.common.internal.C2872v.a(r23);
        r1 = r0.mName;
        com.google.android.gms.common.internal.C2872v.a(r1);
        r1 = r22;
        r2 = r1.q;
        r2 = r2.m31983y();
        if (r2 != 0) goto L_0x0028;
    L_0x001a:
        r0 = r22.mo4754r();
        r0 = r0.m42578v();
        r2 = "Conditional property not cleared since Firebase Analytics is disabled";
        r0.m21307a(r2);
        return;
    L_0x0028:
        r2 = new com.google.android.gms.internal.l.ft;
        r4 = r0.mName;
        r5 = 0;
        r7 = 0;
        r8 = 0;
        r3 = r2;
        r3.<init>(r4, r5, r7, r8);
        r9 = r22.mo6213p();	 Catch:{ IllegalArgumentException -> 0x0072 }
        r10 = r0.mAppId;	 Catch:{ IllegalArgumentException -> 0x0072 }
        r11 = r0.mExpiredEventName;	 Catch:{ IllegalArgumentException -> 0x0072 }
        r12 = r0.mExpiredEventParams;	 Catch:{ IllegalArgumentException -> 0x0072 }
        r13 = r0.mOrigin;	 Catch:{ IllegalArgumentException -> 0x0072 }
        r14 = r0.mCreationTimestamp;	 Catch:{ IllegalArgumentException -> 0x0072 }
        r16 = 1;	 Catch:{ IllegalArgumentException -> 0x0072 }
        r17 = 0;	 Catch:{ IllegalArgumentException -> 0x0072 }
        r17 = r9.m42659a(r10, r11, r12, r13, r14, r16, r17);	 Catch:{ IllegalArgumentException -> 0x0072 }
        r15 = new com.google.android.gms.internal.l.y;
        r4 = r0.mAppId;
        r5 = r0.mOrigin;
        r7 = r0.mCreationTimestamp;
        r9 = r0.mActive;
        r10 = r0.mTriggerEventName;
        r12 = r0.mTriggerTimeout;
        r14 = 0;
        r18 = r12;
        r11 = r0.mTimeToLive;
        r3 = r15;
        r6 = r2;
        r20 = r11;
        r0 = 0;
        r11 = r0;
        r12 = r18;
        r0 = r15;
        r15 = r20;
        r3.<init>(r4, r5, r6, r7, r9, r10, r11, r12, r14, r15, r17);
        r2 = r22.mo6744h();
        r2.m44197a(r0);
    L_0x0072:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.df.e(com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty):void");
    }

    /* renamed from: B */
    public final Boolean m44080B() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) mo4753q().m42609a(atomicReference, 15000, "boolean test flag value", new dg(this, atomicReference));
    }

    /* renamed from: C */
    public final String m44081C() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) mo4753q().m42609a(atomicReference, 15000, "String test flag value", new dq(this, atomicReference));
    }

    /* renamed from: D */
    public final Long m44082D() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) mo4753q().m42609a(atomicReference, 15000, "long test flag value", new dr(this, atomicReference));
    }

    /* renamed from: E */
    public final Integer m44083E() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) mo4753q().m42609a(atomicReference, 15000, "int test flag value", new ds(this, atomicReference));
    }

    /* renamed from: F */
    public final Double m44084F() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) mo4753q().m42609a(atomicReference, 15000, "double test flag value", new dt(this, atomicReference));
    }

    /* renamed from: G */
    public final C2954g<String> m44085G() {
        try {
            String h = mo6214s().m42594h();
            return h != null ? C2958j.a(h) : C2958j.a(mo4753q().m42620h(), new dj(this));
        } catch (Exception e) {
            mo4754r().m42565i().m21307a("Failed to schedule task for getAppInstanceId");
            return C2958j.a(e);
        }
    }

    /* renamed from: H */
    public final String m44086H() {
        mo6208b();
        return (String) this.f32813f.get();
    }

    /* renamed from: I */
    public final void m44087I() {
        mo4753q().m42612a(new dl(this, mo4751m().a()));
    }

    /* renamed from: J */
    public final void m44088J() {
        mo6210d();
        mo6208b();
        m42728w();
        if (this.q.m31956D()) {
            mo6744h().m44187E();
            this.f32809b = false;
            String k = mo6214s().m42597k();
            if (!TextUtils.isEmpty(k)) {
                mo6211l().m38104z();
                if (!k.equals(VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", k);
                    m44099a("auto", "_ou", bundle);
                }
            }
        }
    }

    /* renamed from: a */
    public final List<ConditionalUserProperty> m44089a(String str, String str2) {
        mo6208b();
        return m44071b(null, str, str2);
    }

    /* renamed from: a */
    public final List<ConditionalUserProperty> m44090a(String str, String str2, String str3) {
        C2872v.a(str);
        mo6207a();
        return m44071b(str, str2, str3);
    }

    /* renamed from: a */
    public final Map<String, Object> m44091a(String str, String str2, String str3, boolean z) {
        C2872v.a(str);
        mo6207a();
        return m44072b(str, str2, str3, z);
    }

    /* renamed from: a */
    public final Map<String, Object> m44092a(String str, String str2, boolean z) {
        mo6208b();
        return m44072b(null, str, str2, z);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    public final void m44094a(long j) {
        mo6208b();
        mo4753q().m42612a(new dv(this, j));
    }

    /* renamed from: a */
    public final void m44095a(ConditionalUserProperty conditionalUserProperty) {
        C2872v.a(conditionalUserProperty);
        mo6208b();
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            mo4754r().m42565i().m21307a("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        m44076c(conditionalUserProperty2);
    }

    /* renamed from: a */
    public final void m44096a(C5149b c5149b) {
        mo6210d();
        mo6208b();
        m42728w();
        if (!(c5149b == null || c5149b == this.f32810c)) {
            C2872v.a(this.f32810c == null, "EventInterceptor already set.");
        }
        this.f32810c = c5149b;
    }

    /* renamed from: a */
    public final void m44097a(C5150c c5150c) {
        mo6208b();
        m42728w();
        C2872v.a(c5150c);
        if (!this.f32811d.add(c5150c)) {
            mo4754r().m42565i().m21307a("OnEventListener already registered");
        }
    }

    /* renamed from: a */
    final void m44098a(String str) {
        this.f32813f.set(str);
    }

    /* renamed from: a */
    public final void m44099a(String str, String str2, Bundle bundle) {
        boolean z;
        mo6208b();
        if (this.f32810c != null) {
            if (!fw.m42652g(str2)) {
                z = false;
                m44069a(str, str2, bundle, true, z, false, null);
            }
        }
        z = true;
        m44069a(str, str2, bundle, true, z, false, null);
    }

    /* renamed from: a */
    public final void m44100a(String str, String str2, Bundle bundle, long j) {
        mo6208b();
        m44074b(str, str2, j, bundle, false, true, true, null);
    }

    /* renamed from: a */
    public final void m44101a(String str, String str2, Bundle bundle, boolean z) {
        boolean z2;
        mo6208b();
        if (this.f32810c != null) {
            if (!fw.m42652g(str2)) {
                z2 = false;
                m44069a(str, str2, bundle, true, z2, true, null);
            }
        }
        z2 = true;
        m44069a(str, str2, bundle, true, z2, true, null);
    }

    /* renamed from: a */
    public final void m44102a(String str, String str2, Object obj) {
        C2872v.a(str);
        long a = mo4751m().a();
        int d = mo6213p().m42674d(str2);
        int i = 0;
        if (d != 0) {
            mo6213p();
            str = fw.m42637a(str2, 24, true);
            if (str2 != null) {
                i = str2.length();
            }
            this.q.m31969k().m42662a(d, "_ev", str, i);
        } else if (obj != null) {
            d = mo6213p().m42669b(str2, obj);
            if (d != 0) {
                mo6213p();
                str = fw.m42637a(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.q.m31969k().m42662a(d, "_ev", str, i);
                return;
            }
            Object c = mo6213p().m42672c(str2, obj);
            if (c != null) {
                m44068a(str, str2, a, c);
            }
        } else {
            m44068a(str, str2, a, null);
        }
    }

    /* renamed from: a */
    public final void m44103a(String str, String str2, String str3, Bundle bundle) {
        C2872v.a(str);
        mo6207a();
        m44075b(str, str2, str3, bundle);
    }

    /* renamed from: a */
    public final void m44104a(boolean z) {
        m42728w();
        mo6208b();
        mo4753q().m42612a(new du(this, z));
    }

    /* renamed from: b */
    public final List<ft> m44105b(boolean z) {
        bd I_;
        String str;
        mo6208b();
        m42728w();
        mo4754r().m42578v().m21307a("Fetching user attributes (FE)");
        if (mo4753q().m42619g()) {
            I_ = mo4754r().I_();
            str = "Cannot get all user properties from analytics worker thread";
        } else if (C5052x.m21503a()) {
            I_ = mo4754r().I_();
            str = "Cannot get all user properties from main thread";
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.q.mo4753q().m42612a(new di(this, atomicReference, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    mo4754r().m42565i().m21308a("Interrupted waiting for get user properties", e);
                }
            }
            List<ft> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            I_ = mo4754r().m42565i();
            str = "Timed out waiting for get user properties";
        }
        I_.m21307a(str);
        return Collections.emptyList();
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: b */
    public final void m44107b(long j) {
        mo6208b();
        mo4753q().m42612a(new dw(this, j));
    }

    /* renamed from: b */
    public final void m44108b(ConditionalUserProperty conditionalUserProperty) {
        C2872v.a(conditionalUserProperty);
        C2872v.a(conditionalUserProperty.mAppId);
        mo6207a();
        m44076c(new ConditionalUserProperty(conditionalUserProperty));
    }

    /* renamed from: b */
    public final void m44109b(C5150c c5150c) {
        mo6208b();
        m42728w();
        C2872v.a(c5150c);
        if (!this.f32811d.remove(c5150c)) {
            mo4754r().m42565i().m21307a("OnEventListener had not been registered");
        }
    }

    /* renamed from: b */
    final void m44110b(String str, String str2, Bundle bundle) {
        boolean z;
        mo6208b();
        mo6210d();
        if (this.f32810c != null) {
            if (!fw.m42652g(str2)) {
                z = false;
                m44067a(str, str2, mo4751m().a(), bundle, true, z, false, null);
            }
        }
        z = true;
        m44067a(str, str2, mo4751m().a(), bundle, true, z, false, null);
    }

    /* renamed from: c */
    final java.lang.String m44111c(long r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = new java.util.concurrent.atomic.AtomicReference;
        r0.<init>();
        monitor-enter(r0);
        r1 = r3.mo4753q();	 Catch:{ all -> 0x002d }
        r2 = new com.google.android.gms.internal.l.dk;	 Catch:{ all -> 0x002d }
        r2.<init>(r3, r0);	 Catch:{ all -> 0x002d }
        r1.m42612a(r2);	 Catch:{ all -> 0x002d }
        r0.wait(r4);	 Catch:{ InterruptedException -> 0x001d }
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        r4 = r0.get();
        r4 = (java.lang.String) r4;
        return r4;
    L_0x001d:
        r4 = r3.mo4754r();	 Catch:{ all -> 0x002d }
        r4 = r4.m42565i();	 Catch:{ all -> 0x002d }
        r5 = "Interrupted waiting for app instance id";	 Catch:{ all -> 0x002d }
        r4.m21307a(r5);	 Catch:{ all -> 0x002d }
        r4 = 0;	 Catch:{ all -> 0x002d }
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        return r4;	 Catch:{ all -> 0x002d }
    L_0x002d:
        r4 = move-exception;	 Catch:{ all -> 0x002d }
        monitor-exit(r0);	 Catch:{ all -> 0x002d }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.df.c(long):java.lang.String");
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: c */
    public final void m44113c(String str, String str2, Bundle bundle) {
        mo6208b();
        m44075b(null, str, str2, bundle);
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: e */
    public final /* bridge */ /* synthetic */ C8219n mo6741e() {
        return super.mo6741e();
    }

    /* renamed from: f */
    public final /* bridge */ /* synthetic */ df mo6742f() {
        return super.mo6742f();
    }

    /* renamed from: g */
    public final /* bridge */ /* synthetic */ aw mo6743g() {
        return super.mo6743g();
    }

    /* renamed from: h */
    public final /* bridge */ /* synthetic */ ed mo6744h() {
        return super.mo6744h();
    }

    /* renamed from: i */
    public final /* bridge */ /* synthetic */ ea mo6745i() {
        return super.mo6745i();
    }

    /* renamed from: j */
    public final /* bridge */ /* synthetic */ ax mo6746j() {
        return super.mo6746j();
    }

    /* renamed from: k */
    public final /* bridge */ /* synthetic */ fc mo6747k() {
        return super.mo6747k();
    }

    /* renamed from: l */
    public final /* bridge */ /* synthetic */ ak mo6211l() {
        return super.mo6211l();
    }

    /* renamed from: m */
    public final /* bridge */ /* synthetic */ C2895e mo4751m() {
        return super.mo4751m();
    }

    /* renamed from: n */
    public final /* bridge */ /* synthetic */ Context mo4752n() {
        return super.mo4752n();
    }

    /* renamed from: o */
    public final /* bridge */ /* synthetic */ az mo6212o() {
        return super.mo6212o();
    }

    /* renamed from: p */
    public final /* bridge */ /* synthetic */ fw mo6213p() {
        return super.mo6213p();
    }

    /* renamed from: q */
    public final /* bridge */ /* synthetic */ cb mo4753q() {
        return super.mo4753q();
    }

    /* renamed from: r */
    public final /* bridge */ /* synthetic */ bb mo4754r() {
        return super.mo4754r();
    }

    /* renamed from: s */
    public final /* bridge */ /* synthetic */ bm mo6214s() {
        return super.mo6214s();
    }

    /* renamed from: t */
    public final /* bridge */ /* synthetic */ aa mo6215t() {
        return super.mo6215t();
    }

    /* renamed from: u */
    public final /* bridge */ /* synthetic */ C5052x mo4755u() {
        return super.mo4755u();
    }

    /* renamed from: z */
    protected final boolean mo6852z() {
        return false;
    }
}

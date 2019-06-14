package android.support.v4.content.p026a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.support.v4.p020a.p021a.C0260b;
import android.text.TextUtils;

/* compiled from: ShortcutInfoCompat */
/* renamed from: android.support.v4.content.a.a */
public class C0355a {
    /* renamed from: a */
    private Context f945a;
    /* renamed from: b */
    private String f946b;
    /* renamed from: c */
    private Intent[] f947c;
    /* renamed from: d */
    private ComponentName f948d;
    /* renamed from: e */
    private CharSequence f949e;
    /* renamed from: f */
    private CharSequence f950f;
    /* renamed from: g */
    private CharSequence f951g;
    /* renamed from: h */
    private C0260b f952h;
    /* renamed from: i */
    private boolean f953i;

    /* compiled from: ShortcutInfoCompat */
    /* renamed from: android.support.v4.content.a.a$a */
    public static class C0354a {
        /* renamed from: a */
        private final C0355a f944a = new C0355a();

        public C0354a(Context context, String str) {
            this.f944a.f945a = context;
            this.f944a.f946b = str;
        }

        /* renamed from: a */
        public C0354a m1061a(CharSequence charSequence) {
            this.f944a.f949e = charSequence;
            return this;
        }

        /* renamed from: a */
        public C0354a m1059a(Intent intent) {
            return m1062a(new Intent[]{intent});
        }

        /* renamed from: a */
        public C0354a m1062a(Intent[] intentArr) {
            this.f944a.f947c = intentArr;
            return this;
        }

        /* renamed from: a */
        public C0354a m1060a(C0260b c0260b) {
            this.f944a.f952h = c0260b;
            return this;
        }

        /* renamed from: a */
        public C0355a m1063a() {
            if (TextUtils.isEmpty(this.f944a.f949e)) {
                throw new IllegalArgumentException("Shortcut much have a non-empty label");
            } else if (this.f944a.f947c != null && this.f944a.f947c.length != 0) {
                return this.f944a;
            } else {
                throw new IllegalArgumentException("Shortcut much have an intent");
            }
        }
    }

    private C0355a() {
    }

    /* renamed from: a */
    public ShortcutInfo m1072a() {
        Builder intents = new Builder(this.f945a, this.f946b).setShortLabel(this.f949e).setIntents(this.f947c);
        if (this.f952h != null) {
            intents.setIcon(this.f952h.m709a());
        }
        if (!TextUtils.isEmpty(this.f950f)) {
            intents.setLongLabel(this.f950f);
        }
        if (!TextUtils.isEmpty(this.f951g)) {
            intents.setDisabledMessage(this.f951g);
        }
        if (this.f948d != null) {
            intents.setActivity(this.f948d);
        }
        return intents.build();
    }

    /* renamed from: a */
    android.content.Intent m1071a(android.content.Intent r4) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = "android.intent.extra.shortcut.INTENT";
        r1 = r3.f947c;
        r2 = r3.f947c;
        r2 = r2.length;
        r2 = r2 + -1;
        r1 = r1[r2];
        r0 = r4.putExtra(r0, r1);
        r1 = "android.intent.extra.shortcut.NAME";
        r2 = r3.f949e;
        r2 = r2.toString();
        r0.putExtra(r1, r2);
        r0 = r3.f952h;
        if (r0 == 0) goto L_0x0045;
    L_0x001e:
        r0 = 0;
        r1 = r3.f953i;
        if (r1 == 0) goto L_0x0040;
    L_0x0023:
        r1 = r3.f945a;
        r1 = r1.getPackageManager();
        r2 = r3.f948d;
        if (r2 == 0) goto L_0x0034;
    L_0x002d:
        r2 = r3.f948d;	 Catch:{ NameNotFoundException -> 0x0034 }
        r2 = r1.getActivityIcon(r2);	 Catch:{ NameNotFoundException -> 0x0034 }
        r0 = r2;
    L_0x0034:
        if (r0 != 0) goto L_0x0040;
    L_0x0036:
        r0 = r3.f945a;
        r0 = r0.getApplicationInfo();
        r0 = r0.loadIcon(r1);
    L_0x0040:
        r1 = r3.f952h;
        r1.m710a(r4, r0);
    L_0x0045:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.a.a.a(android.content.Intent):android.content.Intent");
    }
}

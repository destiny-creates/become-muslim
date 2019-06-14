package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ActivityChooserModel */
/* renamed from: android.support.v7.widget.e */
class C0792e extends DataSetObservable {
    /* renamed from: a */
    static final String f2184a = "e";
    /* renamed from: e */
    private static final Object f2185e = new Object();
    /* renamed from: f */
    private static final Map<String, C0792e> f2186f = new HashMap();
    /* renamed from: b */
    final Context f2187b;
    /* renamed from: c */
    final String f2188c;
    /* renamed from: d */
    boolean f2189d;
    /* renamed from: g */
    private final Object f2190g;
    /* renamed from: h */
    private final List<C0787a> f2191h;
    /* renamed from: i */
    private final List<C0789c> f2192i;
    /* renamed from: j */
    private Intent f2193j;
    /* renamed from: k */
    private C0788b f2194k;
    /* renamed from: l */
    private int f2195l;
    /* renamed from: m */
    private boolean f2196m;
    /* renamed from: n */
    private boolean f2197n;
    /* renamed from: o */
    private boolean f2198o;
    /* renamed from: p */
    private C0790d f2199p;

    /* compiled from: ActivityChooserModel */
    /* renamed from: android.support.v7.widget.e$a */
    public static final class C0787a implements Comparable<C0787a> {
        /* renamed from: a */
        public final ResolveInfo f2178a;
        /* renamed from: b */
        public float f2179b;

        public /* synthetic */ int compareTo(Object obj) {
            return m2843a((C0787a) obj);
        }

        public C0787a(ResolveInfo resolveInfo) {
            this.f2178a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f2179b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(this.f2179b) == Float.floatToIntBits(((C0787a) obj).f2179b);
        }

        /* renamed from: a */
        public int m2843a(C0787a c0787a) {
            return Float.floatToIntBits(c0787a.f2179b) - Float.floatToIntBits(this.f2179b);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:");
            stringBuilder.append(this.f2178a.toString());
            stringBuilder.append("; weight:");
            stringBuilder.append(new BigDecimal((double) this.f2179b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: ActivityChooserModel */
    /* renamed from: android.support.v7.widget.e$b */
    public interface C0788b {
        /* renamed from: a */
        void m2844a(Intent intent, List<C0787a> list, List<C0789c> list2);
    }

    /* compiled from: ActivityChooserModel */
    /* renamed from: android.support.v7.widget.e$c */
    public static final class C0789c {
        /* renamed from: a */
        public final ComponentName f2180a;
        /* renamed from: b */
        public final long f2181b;
        /* renamed from: c */
        public final float f2182c;

        public C0789c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public C0789c(ComponentName componentName, long j, float f) {
            this.f2180a = componentName;
            this.f2181b = j;
            this.f2182c = f;
        }

        public int hashCode() {
            return (((((this.f2180a == null ? 0 : this.f2180a.hashCode()) + 31) * 31) + ((int) (this.f2181b ^ (this.f2181b >>> 32)))) * 31) + Float.floatToIntBits(this.f2182c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0789c c0789c = (C0789c) obj;
            if (this.f2180a == null) {
                if (c0789c.f2180a != null) {
                    return false;
                }
            } else if (!this.f2180a.equals(c0789c.f2180a)) {
                return false;
            }
            return this.f2181b == c0789c.f2181b && Float.floatToIntBits(this.f2182c) == Float.floatToIntBits(c0789c.f2182c);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:");
            stringBuilder.append(this.f2180a);
            stringBuilder.append("; time:");
            stringBuilder.append(this.f2181b);
            stringBuilder.append("; weight:");
            stringBuilder.append(new BigDecimal((double) this.f2182c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: ActivityChooserModel */
    /* renamed from: android.support.v7.widget.e$d */
    public interface C0790d {
        /* renamed from: a */
        boolean m2845a(C0792e c0792e, Intent intent);
    }

    /* compiled from: ActivityChooserModel */
    /* renamed from: android.support.v7.widget.e$e */
    private final class C0791e extends AsyncTask<Object, Void, Void> {
        /* renamed from: a */
        final /* synthetic */ C0792e f2183a;

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return m2846a(objArr);
        }

        C0791e(C0792e c0792e) {
            this.f2183a = c0792e;
        }

        /* renamed from: a */
        public java.lang.Void m2846a(java.lang.Object... r12) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r11 = this;
            r0 = 0;
            r1 = r12[r0];
            r1 = (java.util.List) r1;
            r2 = 1;
            r12 = r12[r2];
            r12 = (java.lang.String) r12;
            r3 = 0;
            r4 = r11.f2183a;	 Catch:{ FileNotFoundException -> 0x00e8 }
            r4 = r4.f2187b;	 Catch:{ FileNotFoundException -> 0x00e8 }
            r4 = r4.openFileOutput(r12, r0);	 Catch:{ FileNotFoundException -> 0x00e8 }
            r12 = android.util.Xml.newSerializer();
            r12.setOutput(r4, r3);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r5 = "UTF-8";	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r6 = java.lang.Boolean.valueOf(r2);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.startDocument(r5, r6);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r5 = "historical-records";	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.startTag(r3, r5);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r5 = r1.size();	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r6 = 0;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
        L_0x002d:
            if (r6 >= r5) goto L_0x0063;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
        L_0x002f:
            r7 = r1.remove(r0);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r7 = (android.support.v7.widget.C0792e.C0789c) r7;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r8 = "historical-record";	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.startTag(r3, r8);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r8 = "activity";	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r9 = r7.f2180a;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r9 = r9.flattenToString();	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.attribute(r3, r8, r9);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r8 = "time";	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r9 = r7.f2181b;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r9 = java.lang.String.valueOf(r9);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.attribute(r3, r8, r9);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r8 = "weight";	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r7 = r7.f2182c;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r7 = java.lang.String.valueOf(r7);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.attribute(r3, r8, r7);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r7 = "historical-record";	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.endTag(r3, r7);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r6 = r6 + 1;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            goto L_0x002d;	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
        L_0x0063:
            r0 = "historical-records";	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.endTag(r3, r0);	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12.endDocument();	 Catch:{ IllegalArgumentException -> 0x00bb, IllegalStateException -> 0x0099, IOException -> 0x0077 }
            r12 = r11.f2183a;
            r12.f2189d = r2;
            if (r4 == 0) goto L_0x00dd;
        L_0x0071:
            r4.close();	 Catch:{ IOException -> 0x00dd }
            goto L_0x00dd;
        L_0x0075:
            r12 = move-exception;
            goto L_0x00de;
        L_0x0077:
            r12 = move-exception;
            r0 = android.support.v7.widget.C0792e.f2184a;	 Catch:{ all -> 0x0075 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r1.<init>();	 Catch:{ all -> 0x0075 }
            r5 = "Error writing historical record file: ";	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r5 = r11.f2183a;	 Catch:{ all -> 0x0075 }
            r5 = r5.f2188c;	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r1 = r1.toString();	 Catch:{ all -> 0x0075 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ all -> 0x0075 }
            r12 = r11.f2183a;
            r12.f2189d = r2;
            if (r4 == 0) goto L_0x00dd;
        L_0x0098:
            goto L_0x0071;
        L_0x0099:
            r12 = move-exception;
            r0 = android.support.v7.widget.C0792e.f2184a;	 Catch:{ all -> 0x0075 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r1.<init>();	 Catch:{ all -> 0x0075 }
            r5 = "Error writing historical record file: ";	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r5 = r11.f2183a;	 Catch:{ all -> 0x0075 }
            r5 = r5.f2188c;	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r1 = r1.toString();	 Catch:{ all -> 0x0075 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ all -> 0x0075 }
            r12 = r11.f2183a;
            r12.f2189d = r2;
            if (r4 == 0) goto L_0x00dd;
        L_0x00ba:
            goto L_0x0071;
        L_0x00bb:
            r12 = move-exception;
            r0 = android.support.v7.widget.C0792e.f2184a;	 Catch:{ all -> 0x0075 }
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0075 }
            r1.<init>();	 Catch:{ all -> 0x0075 }
            r5 = "Error writing historical record file: ";	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r5 = r11.f2183a;	 Catch:{ all -> 0x0075 }
            r5 = r5.f2188c;	 Catch:{ all -> 0x0075 }
            r1.append(r5);	 Catch:{ all -> 0x0075 }
            r1 = r1.toString();	 Catch:{ all -> 0x0075 }
            android.util.Log.e(r0, r1, r12);	 Catch:{ all -> 0x0075 }
            r12 = r11.f2183a;
            r12.f2189d = r2;
            if (r4 == 0) goto L_0x00dd;
        L_0x00dc:
            goto L_0x0071;
        L_0x00dd:
            return r3;
        L_0x00de:
            r0 = r11.f2183a;
            r0.f2189d = r2;
            if (r4 == 0) goto L_0x00e7;
        L_0x00e4:
            r4.close();	 Catch:{ IOException -> 0x00e7 }
        L_0x00e7:
            throw r12;
        L_0x00e8:
            r0 = move-exception;
            r1 = android.support.v7.widget.C0792e.f2184a;
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r4 = "Error writing historical record file: ";
            r2.append(r4);
            r2.append(r12);
            r12 = r2.toString();
            android.util.Log.e(r1, r12, r0);
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.e.e.a(java.lang.Object[]):java.lang.Void");
        }
    }

    /* renamed from: a */
    public int m2855a() {
        int size;
        synchronized (this.f2190g) {
            m2849d();
            size = this.f2191h.size();
        }
        return size;
    }

    /* renamed from: a */
    public ResolveInfo m2857a(int i) {
        synchronized (this.f2190g) {
            m2849d();
            i = ((C0787a) this.f2191h.get(i)).f2178a;
        }
        return i;
    }

    /* renamed from: a */
    public int m2856a(ResolveInfo resolveInfo) {
        synchronized (this.f2190g) {
            m2849d();
            List list = this.f2191h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C0787a) list.get(i)).f2178a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: b */
    public Intent m2858b(int i) {
        synchronized (this.f2190g) {
            if (this.f2193j == null) {
                return null;
            }
            m2849d();
            C0787a c0787a = (C0787a) this.f2191h.get(i);
            ComponentName componentName = new ComponentName(c0787a.f2178a.activityInfo.packageName, c0787a.f2178a.activityInfo.name);
            i = new Intent(this.f2193j);
            i.setComponent(componentName);
            if (this.f2199p != null) {
                if (this.f2199p.m2845a(this, new Intent(i))) {
                    return null;
                }
            }
            m2847a(new C0789c(componentName, System.currentTimeMillis(), 1.0f));
            return i;
        }
    }

    /* renamed from: b */
    public ResolveInfo m2859b() {
        synchronized (this.f2190g) {
            m2849d();
            if (this.f2191h.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0787a) this.f2191h.get(0)).f2178a;
            return resolveInfo;
        }
    }

    /* renamed from: c */
    public void m2860c(int i) {
        synchronized (this.f2190g) {
            m2849d();
            C0787a c0787a = (C0787a) this.f2191h.get(i);
            C0787a c0787a2 = (C0787a) this.f2191h.get(0);
            m2847a(new C0789c(new ComponentName(c0787a.f2178a.activityInfo.packageName, c0787a.f2178a.activityInfo.name), System.currentTimeMillis(), c0787a2 != null ? (c0787a2.f2179b - c0787a.f2179b) + 5.0f : 1.0f));
        }
    }

    /* renamed from: c */
    private void m2848c() {
        if (!this.f2196m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f2197n) {
            this.f2197n = false;
            if (!TextUtils.isEmpty(this.f2188c)) {
                new C0791e(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f2192i), this.f2188c});
            }
        }
    }

    /* renamed from: d */
    private void m2849d() {
        int f = m2851f() | m2852g();
        m2853h();
        if (f != 0) {
            m2850e();
            notifyChanged();
        }
    }

    /* renamed from: e */
    private boolean m2850e() {
        if (this.f2194k == null || this.f2193j == null || this.f2191h.isEmpty() || this.f2192i.isEmpty()) {
            return false;
        }
        this.f2194k.m2844a(this.f2193j, this.f2191h, Collections.unmodifiableList(this.f2192i));
        return true;
    }

    /* renamed from: f */
    private boolean m2851f() {
        int i = 0;
        if (!this.f2198o || this.f2193j == null) {
            return false;
        }
        this.f2198o = false;
        this.f2191h.clear();
        List queryIntentActivities = this.f2187b.getPackageManager().queryIntentActivities(this.f2193j, 0);
        int size = queryIntentActivities.size();
        while (i < size) {
            this.f2191h.add(new C0787a((ResolveInfo) queryIntentActivities.get(i)));
            i++;
        }
        return true;
    }

    /* renamed from: g */
    private boolean m2852g() {
        if (!this.f2189d || !this.f2197n || TextUtils.isEmpty(this.f2188c)) {
            return false;
        }
        this.f2189d = false;
        this.f2196m = true;
        m2854i();
        return true;
    }

    /* renamed from: a */
    private boolean m2847a(C0789c c0789c) {
        c0789c = this.f2192i.add(c0789c);
        if (c0789c != null) {
            this.f2197n = true;
            m2853h();
            m2848c();
            m2850e();
            notifyChanged();
        }
        return c0789c;
    }

    /* renamed from: h */
    private void m2853h() {
        int size = this.f2192i.size() - this.f2195l;
        if (size > 0) {
            this.f2197n = true;
            for (int i = 0; i < size; i++) {
                C0789c c0789c = (C0789c) this.f2192i.remove(0);
            }
        }
    }

    /* renamed from: i */
    private void m2854i() {
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
        r9 = this;
        r0 = r9.f2187b;	 Catch:{ FileNotFoundException -> 0x00c4 }
        r1 = r9.f2188c;	 Catch:{ FileNotFoundException -> 0x00c4 }
        r0 = r0.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x00c4 }
        r1 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r2 = "UTF-8";	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r1.setInput(r0, r2);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r2 = 0;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
    L_0x0012:
        r3 = 1;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        if (r2 == r3) goto L_0x001d;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
    L_0x0015:
        r4 = 2;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        if (r2 == r4) goto L_0x001d;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
    L_0x0018:
        r2 = r1.next();	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        goto L_0x0012;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
    L_0x001d:
        r2 = "historical-records";	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r4 = r1.getName();	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r2 = r2.equals(r4);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        if (r2 == 0) goto L_0x007a;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
    L_0x0029:
        r2 = r9.f2192i;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r2.clear();	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
    L_0x002e:
        r4 = r1.next();	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        if (r4 != r3) goto L_0x003b;
    L_0x0034:
        if (r0 == 0) goto L_0x00bd;
    L_0x0036:
        r0.close();	 Catch:{ IOException -> 0x00bd }
        goto L_0x00bd;
    L_0x003b:
        r5 = 3;
        if (r4 == r5) goto L_0x002e;
    L_0x003e:
        r5 = 4;
        if (r4 != r5) goto L_0x0042;
    L_0x0041:
        goto L_0x002e;
    L_0x0042:
        r4 = r1.getName();	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r5 = "historical-record";	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r4 = r5.equals(r4);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        if (r4 == 0) goto L_0x0072;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
    L_0x004e:
        r4 = "activity";	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r5 = 0;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r4 = r1.getAttributeValue(r5, r4);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r6 = "time";	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r6 = r1.getAttributeValue(r5, r6);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r6 = java.lang.Long.parseLong(r6);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r8 = "weight";	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r5 = r1.getAttributeValue(r5, r8);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r5 = java.lang.Float.parseFloat(r5);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r8 = new android.support.v7.widget.e$c;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r8.<init>(r4, r6, r5);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r2.add(r8);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        goto L_0x002e;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
    L_0x0072:
        r1 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r2 = "Share records file not well-formed.";	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r1.<init>(r2);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        throw r1;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
    L_0x007a:
        r1 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r2 = "Share records file does not start with historical-records tag.";	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        r1.<init>(r2);	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
        throw r1;	 Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x0084 }
    L_0x0082:
        r1 = move-exception;
        goto L_0x00be;
    L_0x0084:
        r1 = move-exception;
        r2 = f2184a;	 Catch:{ all -> 0x0082 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0082 }
        r3.<init>();	 Catch:{ all -> 0x0082 }
        r4 = "Error reading historical recrod file: ";	 Catch:{ all -> 0x0082 }
        r3.append(r4);	 Catch:{ all -> 0x0082 }
        r4 = r9.f2188c;	 Catch:{ all -> 0x0082 }
        r3.append(r4);	 Catch:{ all -> 0x0082 }
        r3 = r3.toString();	 Catch:{ all -> 0x0082 }
        android.util.Log.e(r2, r3, r1);	 Catch:{ all -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;	 Catch:{ all -> 0x0082 }
    L_0x009f:
        goto L_0x0036;	 Catch:{ all -> 0x0082 }
    L_0x00a0:
        r1 = move-exception;	 Catch:{ all -> 0x0082 }
        r2 = f2184a;	 Catch:{ all -> 0x0082 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0082 }
        r3.<init>();	 Catch:{ all -> 0x0082 }
        r4 = "Error reading historical recrod file: ";	 Catch:{ all -> 0x0082 }
        r3.append(r4);	 Catch:{ all -> 0x0082 }
        r4 = r9.f2188c;	 Catch:{ all -> 0x0082 }
        r3.append(r4);	 Catch:{ all -> 0x0082 }
        r3 = r3.toString();	 Catch:{ all -> 0x0082 }
        android.util.Log.e(r2, r3, r1);	 Catch:{ all -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bb:
        goto L_0x0036;
    L_0x00bd:
        return;
    L_0x00be:
        if (r0 == 0) goto L_0x00c3;
    L_0x00c0:
        r0.close();	 Catch:{ IOException -> 0x00c3 }
    L_0x00c3:
        throw r1;
    L_0x00c4:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.e.i():void");
    }
}

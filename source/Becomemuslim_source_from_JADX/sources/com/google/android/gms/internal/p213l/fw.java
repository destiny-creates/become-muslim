package com.google.android.gms.internal.p213l;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.C2830f;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p180d.C2829c;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C2896f;
import com.google.android.gms.measurement.AppMeasurement.C6846a;
import com.google.android.gms.measurement.AppMeasurement.C6848e;
import expo.modules.contacts.EXColumns;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.google.android.gms.internal.l.fw */
public final class fw extends dc {
    /* renamed from: a */
    private static final String[] f32359a = new String[]{"firebase_", "google_", "ga_"};
    /* renamed from: b */
    private SecureRandom f32360b;
    /* renamed from: c */
    private final AtomicLong f32361c = new AtomicLong(0);
    /* renamed from: d */
    private int f32362d;
    /* renamed from: e */
    private Integer f32363e = null;

    fw(cg cgVar) {
        super(cgVar);
    }

    /* renamed from: a */
    static long m42635a(byte[] bArr) {
        C2872v.a(bArr);
        long j = null;
        C2872v.a(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    /* renamed from: a */
    private static Object m42636a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Long)) {
            if (!(obj instanceof Double)) {
                if (obj instanceof Integer) {
                    return Long.valueOf((long) ((Integer) obj).intValue());
                }
                if (obj instanceof Byte) {
                    return Long.valueOf((long) ((Byte) obj).byteValue());
                }
                if (obj instanceof Short) {
                    return Long.valueOf((long) ((Short) obj).shortValue());
                }
                if (obj instanceof Boolean) {
                    return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                } else if (obj instanceof Float) {
                    return Double.valueOf(((Float) obj).doubleValue());
                } else {
                    if (!((obj instanceof String) || (obj instanceof Character))) {
                        if (!(obj instanceof CharSequence)) {
                            return null;
                        }
                    }
                    return fw.m42637a(String.valueOf(obj), i, z);
                }
            }
        }
        return obj;
    }

    /* renamed from: a */
    public static String m42637a(String str, int i, boolean z) {
        if (str.codePointCount(0, str.length()) > i) {
            if (z) {
                return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
            }
            str = null;
        }
        return str;
    }

    /* renamed from: a */
    public static String m42638a(String str, String[] strArr, String[] strArr2) {
        C2872v.a(strArr);
        C2872v.a(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (fw.m42649b(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m42639a(Bundle bundle, Object obj) {
        C2872v.a(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    /* renamed from: a */
    static boolean m42640a(Context context, boolean z) {
        C2872v.a(context);
        return fw.m42648b(context, VERSION.SDK_INT >= 24 ? "com.google.android.gms.measurement.AppMeasurementJobService" : "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* renamed from: a */
    static boolean m42641a(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (!("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra))) {
            if (!"android-app://com.google.appcrawler".equals(stringExtra)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m42642a(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    /* renamed from: a */
    static boolean m42643a(String str) {
        C2872v.a(str);
        if (str.charAt(0) == '_') {
            if (!str.equals("_ep")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private final boolean m42644a(String str, String str2, int i, Object obj, boolean z) {
        if (!(obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean))) {
            if (!(obj instanceof Double)) {
                if (!((obj instanceof String) || (obj instanceof Character))) {
                    if (!(obj instanceof CharSequence)) {
                        if ((obj instanceof Bundle) && z) {
                            return true;
                        }
                        int length;
                        Object obj2;
                        if ((obj instanceof Parcelable[]) && z) {
                            Parcelable[] parcelableArr = (Parcelable[]) obj;
                            length = parcelableArr.length;
                            i = 0;
                            while (i < length) {
                                obj2 = parcelableArr[i];
                                if (obj2 instanceof Bundle) {
                                    i++;
                                } else {
                                    mo4754r().m42565i().m21309a("All Parcelable[] elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                                    return false;
                                }
                            }
                            return true;
                        } else if (!(obj instanceof ArrayList) || !z) {
                            return false;
                        } else {
                            ArrayList arrayList = (ArrayList) obj;
                            length = arrayList.size();
                            i = 0;
                            while (i < length) {
                                obj2 = arrayList.get(i);
                                i++;
                                if (!(obj2 instanceof Bundle)) {
                                    mo4754r().m42565i().m21309a("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                }
                String valueOf = String.valueOf(obj);
                if (valueOf.codePointCount(0, valueOf.length()) > i) {
                    mo4754r().m42565i().m21310a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    static byte[] m42645a(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    /* renamed from: a */
    static Bundle[] m42646a(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        Object[] copyOf;
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            copyOf = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            copyOf = arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return (Bundle[]) copyOf;
    }

    /* renamed from: b */
    public static java.lang.Object m42647b(java.lang.Object r4) {
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
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = new java.io.ObjectOutputStream;	 Catch:{ all -> 0x0032 }
        r2.<init>(r1);	 Catch:{ all -> 0x0032 }
        r2.writeObject(r4);	 Catch:{ all -> 0x002f }
        r2.flush();	 Catch:{ all -> 0x002f }
        r4 = new java.io.ObjectInputStream;	 Catch:{ all -> 0x002f }
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ all -> 0x002f }
        r1 = r1.toByteArray();	 Catch:{ all -> 0x002f }
        r3.<init>(r1);	 Catch:{ all -> 0x002f }
        r4.<init>(r3);	 Catch:{ all -> 0x002f }
        r1 = r4.readObject();	 Catch:{ all -> 0x002d }
        r2.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        return r1;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x002d:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        goto L_0x0035;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x002f:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4 = r0;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        goto L_0x0035;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0032:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4 = r0;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r2 = r4;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0035:
        if (r2 == 0) goto L_0x003a;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0037:
        r2.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003a:
        if (r4 == 0) goto L_0x003f;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003c:
        r4.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003f:
        throw r1;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0040:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.fw.b(java.lang.Object):java.lang.Object");
    }

    /* renamed from: b */
    private static boolean m42648b(android.content.Context r3, java.lang.String r4) {
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
        r0 = 0;
        r1 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0019 }
        if (r1 != 0) goto L_0x0008;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x0007:
        return r0;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x0008:
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x0019 }
        r2.<init>(r3, r4);	 Catch:{ NameNotFoundException -> 0x0019 }
        r3 = r1.getServiceInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x0019 }
        if (r3 == 0) goto L_0x0019;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x0013:
        r3 = r3.enabled;	 Catch:{ NameNotFoundException -> 0x0019 }
        if (r3 == 0) goto L_0x0019;
    L_0x0017:
        r3 = 1;
        return r3;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.fw.b(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: b */
    static boolean m42649b(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    /* renamed from: c */
    private final boolean m42650c(Context context, String str) {
        Object e;
        bd I_;
        String str2;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo b = C2829c.a(context).b(str, 64);
            if (!(b == null || b.signatures == null || b.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(b.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e2) {
            e = e2;
            I_ = mo4754r().I_();
            str2 = "Error obtaining certificate";
            I_.m21308a(str2, e);
            return true;
        } catch (NameNotFoundException e3) {
            e = e3;
            I_ = mo4754r().I_();
            str2 = "Package name not found";
            I_.m21308a(str2, e);
            return true;
        }
        return true;
    }

    /* renamed from: c */
    private final boolean m42651c(String str, String str2) {
        if (str2 == null) {
            mo4754r().I_().m21308a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            mo4754r().I_().m21308a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        mo4754r().I_().m21309a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            mo4754r().I_().m21309a("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    /* renamed from: g */
    static boolean m42652g(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    /* renamed from: i */
    private static int m42653i(String str) {
        return "_ldl".equals(str) ? 2048 : EXColumns.ID.equals(str) ? 256 : 36;
    }

    /* renamed from: i */
    static java.security.MessageDigest m42654i() {
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
        r0 = 0;
    L_0x0001:
        r1 = 2;
        if (r0 >= r1) goto L_0x0010;
    L_0x0004:
        r1 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x000d }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x000d }
        if (r1 == 0) goto L_0x000d;
    L_0x000c:
        return r1;
    L_0x000d:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x0010:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.l.fw.i():java.security.MessageDigest");
    }

    /* renamed from: a */
    final long m42655a(Context context, String str) {
        mo6210d();
        C2872v.a(context);
        C2872v.a(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest i = fw.m42654i();
        if (i == null) {
            mo4754r().I_().m21307a("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!m42650c(context, str)) {
                    PackageInfo b = C2829c.a(context).b(mo4752n().getPackageName(), 64);
                    if (b.signatures != null && b.signatures.length > 0) {
                        return fw.m42635a(i.digest(b.signatures[0].toByteArray()));
                    }
                    mo4754r().m42565i().m21307a("Could not get signatures");
                    return -1;
                }
            } catch (NameNotFoundException e) {
                mo4754r().I_().m21308a("Package name not found", e);
            }
        }
        return 0;
    }

    /* renamed from: a */
    final Bundle m42656a(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            Object queryParameter;
            Object queryParameter2;
            Object queryParameter3;
            Object queryParameter4;
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
            } else {
                queryParameter = null;
                queryParameter2 = queryParameter;
                queryParameter3 = queryParameter2;
                queryParameter4 = queryParameter3;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3)) {
                if (TextUtils.isEmpty(queryParameter4)) {
                    return null;
                }
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(ShareConstants.FEED_SOURCE_PARAM, queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            queryParameter = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(UriUtil.LOCAL_CONTENT_SCHEME, queryParameter);
            }
            queryParameter = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("aclid", queryParameter);
            }
            queryParameter = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("cp1", queryParameter);
            }
            Object queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            mo4754r().m42565i().m21308a("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    /* renamed from: a */
    final Bundle m42657a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object a = m42660a(str, bundle.get(str));
                if (a == null) {
                    mo4754r().m42565i().m21308a("Param value can't be null", mo6212o().m42530b(str));
                } else {
                    m42663a(bundle2, str, a);
                }
            }
        }
        return bundle2;
    }

    /* renamed from: a */
    final Bundle m42658a(String str, String str2, Bundle bundle, List<String> list, boolean z, boolean z2) {
        fw fwVar = this;
        Bundle bundle2 = bundle;
        List<String> list2 = list;
        String[] strArr = null;
        if (bundle2 == null) {
            return null;
        }
        Bundle bundle3 = new Bundle(bundle2);
        int i = 0;
        for (String str3 : bundle.keySet()) {
            int i2;
            Object obj;
            String str4;
            Object obj2;
            int i3;
            boolean z3;
            StringBuilder stringBuilder;
            String str5;
            String str6;
            int i4;
            fw fwVar2;
            String str7;
            int i5;
            if (list2 != null) {
                if (!list2.contains(str3)) {
                }
                i2 = 0;
                if (i2 == 0) {
                    if (fw.m42642a(bundle3, i2)) {
                        bundle3.putString("_ev", fw.m42637a(str3, 40, true));
                        if (i2 == 3) {
                            fw.m42639a(bundle3, (Object) str3);
                        }
                    }
                    bundle3.remove(str3);
                } else {
                    obj = bundle2.get(str3);
                    mo6210d();
                    if (z2) {
                        str4 = "param";
                        if (obj instanceof Parcelable[]) {
                            if (obj instanceof ArrayList) {
                                i2 = ((ArrayList) obj).size();
                            }
                            obj2 = 1;
                            if (obj2 == null) {
                                i3 = 17;
                                z3 = true;
                                if (i3 != 0 || "_ev".equals(str3)) {
                                    if (fw.m42643a(str3)) {
                                        i++;
                                        if (i > 25) {
                                            stringBuilder = new StringBuilder(48);
                                            stringBuilder.append("Event can't contain more than 25 params");
                                            mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                            fw.m42642a(bundle3, 5);
                                            bundle3.remove(str3);
                                        }
                                    }
                                    str5 = str2;
                                } else {
                                    if (fw.m42642a(bundle3, i3)) {
                                        bundle3.putString("_ev", fw.m42637a(str3, 40, z3));
                                        fw.m42639a(bundle3, bundle2.get(str3));
                                    }
                                    bundle3.remove(str3);
                                }
                            }
                        } else {
                            i2 = ((Parcelable[]) obj).length;
                        }
                        if (i2 > 1000) {
                            mo4754r().m42565i().m21310a("Parameter array is too long; discarded. Value kind, name, array length", str4, str3, Integer.valueOf(i2));
                            obj2 = null;
                            if (obj2 == null) {
                                i3 = 17;
                                z3 = true;
                                if (i3 != 0) {
                                }
                                if (fw.m42643a(str3)) {
                                    i++;
                                    if (i > 25) {
                                        stringBuilder = new StringBuilder(48);
                                        stringBuilder.append("Event can't contain more than 25 params");
                                        mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                        fw.m42642a(bundle3, 5);
                                        bundle3.remove(str3);
                                    }
                                }
                                str5 = str2;
                            }
                        }
                        obj2 = 1;
                        if (obj2 == null) {
                            i3 = 17;
                            z3 = true;
                            if (i3 != 0) {
                            }
                            if (fw.m42643a(str3)) {
                                i++;
                                if (i > 25) {
                                    stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more than 25 params");
                                    mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                    fw.m42642a(bundle3, 5);
                                    bundle3.remove(str3);
                                }
                            }
                            str5 = str2;
                        }
                    }
                    if ((mo6215t().m38050f(str) || !fw.m42652g(str2)) && !fw.m42652g(str3)) {
                        z3 = true;
                        str6 = "param";
                        i4 = 100;
                        fwVar2 = this;
                        str7 = str3;
                    } else {
                        str6 = "param";
                        fwVar2 = this;
                        str7 = str3;
                        i4 = 256;
                        z3 = true;
                    }
                    i3 = fwVar2.m42644a(str6, str7, i4, obj, z2) ? 0 : 4;
                    if (i3 != 0) {
                    }
                    if (fw.m42643a(str3)) {
                        i++;
                        if (i > 25) {
                            stringBuilder = new StringBuilder(48);
                            stringBuilder.append("Event can't contain more than 25 params");
                            mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                            fw.m42642a(bundle3, 5);
                            bundle3.remove(str3);
                        }
                    }
                    str5 = str2;
                }
                strArr = null;
            }
            i2 = 14;
            if (z) {
                if (m42666a("event param", str3)) {
                    if (!m42667a("event param", strArr, str3)) {
                        i5 = 14;
                        if (i5 == 0) {
                            if (m42651c("event param", str3)) {
                                if (!m42667a("event param", strArr, str3)) {
                                    if (!m42665a("event param", 40, str3)) {
                                    }
                                    i2 = 0;
                                }
                            }
                            i2 = 3;
                        } else {
                            i2 = i5;
                        }
                        if (i2 == 0) {
                            obj = bundle2.get(str3);
                            mo6210d();
                            if (z2) {
                                str4 = "param";
                                if (obj instanceof Parcelable[]) {
                                    if (obj instanceof ArrayList) {
                                        i2 = ((ArrayList) obj).size();
                                    }
                                    obj2 = 1;
                                    if (obj2 == null) {
                                        i3 = 17;
                                        z3 = true;
                                        if (i3 != 0) {
                                        }
                                        if (fw.m42643a(str3)) {
                                            i++;
                                            if (i > 25) {
                                                stringBuilder = new StringBuilder(48);
                                                stringBuilder.append("Event can't contain more than 25 params");
                                                mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                                fw.m42642a(bundle3, 5);
                                                bundle3.remove(str3);
                                            }
                                        }
                                        str5 = str2;
                                    }
                                } else {
                                    i2 = ((Parcelable[]) obj).length;
                                }
                                if (i2 > 1000) {
                                    mo4754r().m42565i().m21310a("Parameter array is too long; discarded. Value kind, name, array length", str4, str3, Integer.valueOf(i2));
                                    obj2 = null;
                                    if (obj2 == null) {
                                        i3 = 17;
                                        z3 = true;
                                        if (i3 != 0) {
                                        }
                                        if (fw.m42643a(str3)) {
                                            i++;
                                            if (i > 25) {
                                                stringBuilder = new StringBuilder(48);
                                                stringBuilder.append("Event can't contain more than 25 params");
                                                mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                                fw.m42642a(bundle3, 5);
                                                bundle3.remove(str3);
                                            }
                                        }
                                        str5 = str2;
                                    }
                                }
                                obj2 = 1;
                                if (obj2 == null) {
                                    i3 = 17;
                                    z3 = true;
                                    if (i3 != 0) {
                                    }
                                    if (fw.m42643a(str3)) {
                                        i++;
                                        if (i > 25) {
                                            stringBuilder = new StringBuilder(48);
                                            stringBuilder.append("Event can't contain more than 25 params");
                                            mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                            fw.m42642a(bundle3, 5);
                                            bundle3.remove(str3);
                                        }
                                    }
                                    str5 = str2;
                                }
                            }
                            if (mo6215t().m38050f(str)) {
                            }
                            z3 = true;
                            str6 = "param";
                            i4 = 100;
                            fwVar2 = this;
                            str7 = str3;
                            if (fwVar2.m42644a(str6, str7, i4, obj, z2)) {
                            }
                            if (i3 != 0) {
                            }
                            if (fw.m42643a(str3)) {
                                i++;
                                if (i > 25) {
                                    stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more than 25 params");
                                    mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                    fw.m42642a(bundle3, 5);
                                    bundle3.remove(str3);
                                }
                            }
                            str5 = str2;
                        } else {
                            if (fw.m42642a(bundle3, i2)) {
                                bundle3.putString("_ev", fw.m42637a(str3, 40, true));
                                if (i2 == 3) {
                                    fw.m42639a(bundle3, (Object) str3);
                                }
                            }
                            bundle3.remove(str3);
                        }
                        strArr = null;
                    } else if (!m42665a("event param", 40, str3)) {
                    }
                }
                i5 = 3;
                if (i5 == 0) {
                    i2 = i5;
                } else {
                    if (m42651c("event param", str3)) {
                        if (!m42667a("event param", strArr, str3)) {
                            if (m42665a("event param", 40, str3)) {
                            }
                            i2 = 0;
                        }
                    }
                    i2 = 3;
                }
                if (i2 == 0) {
                    if (fw.m42642a(bundle3, i2)) {
                        bundle3.putString("_ev", fw.m42637a(str3, 40, true));
                        if (i2 == 3) {
                            fw.m42639a(bundle3, (Object) str3);
                        }
                    }
                    bundle3.remove(str3);
                } else {
                    obj = bundle2.get(str3);
                    mo6210d();
                    if (z2) {
                        str4 = "param";
                        if (obj instanceof Parcelable[]) {
                            i2 = ((Parcelable[]) obj).length;
                        } else {
                            if (obj instanceof ArrayList) {
                                i2 = ((ArrayList) obj).size();
                            }
                            obj2 = 1;
                            if (obj2 == null) {
                                i3 = 17;
                                z3 = true;
                                if (i3 != 0) {
                                }
                                if (fw.m42643a(str3)) {
                                    i++;
                                    if (i > 25) {
                                        stringBuilder = new StringBuilder(48);
                                        stringBuilder.append("Event can't contain more than 25 params");
                                        mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                        fw.m42642a(bundle3, 5);
                                        bundle3.remove(str3);
                                    }
                                }
                                str5 = str2;
                            }
                        }
                        if (i2 > 1000) {
                            mo4754r().m42565i().m21310a("Parameter array is too long; discarded. Value kind, name, array length", str4, str3, Integer.valueOf(i2));
                            obj2 = null;
                            if (obj2 == null) {
                                i3 = 17;
                                z3 = true;
                                if (i3 != 0) {
                                }
                                if (fw.m42643a(str3)) {
                                    i++;
                                    if (i > 25) {
                                        stringBuilder = new StringBuilder(48);
                                        stringBuilder.append("Event can't contain more than 25 params");
                                        mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                        fw.m42642a(bundle3, 5);
                                        bundle3.remove(str3);
                                    }
                                }
                                str5 = str2;
                            }
                        }
                        obj2 = 1;
                        if (obj2 == null) {
                            i3 = 17;
                            z3 = true;
                            if (i3 != 0) {
                            }
                            if (fw.m42643a(str3)) {
                                i++;
                                if (i > 25) {
                                    stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more than 25 params");
                                    mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                    fw.m42642a(bundle3, 5);
                                    bundle3.remove(str3);
                                }
                            }
                            str5 = str2;
                        }
                    }
                    if (mo6215t().m38050f(str)) {
                    }
                    z3 = true;
                    str6 = "param";
                    i4 = 100;
                    fwVar2 = this;
                    str7 = str3;
                    if (fwVar2.m42644a(str6, str7, i4, obj, z2)) {
                    }
                    if (i3 != 0) {
                    }
                    if (fw.m42643a(str3)) {
                        i++;
                        if (i > 25) {
                            stringBuilder = new StringBuilder(48);
                            stringBuilder.append("Event can't contain more than 25 params");
                            mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                            fw.m42642a(bundle3, 5);
                            bundle3.remove(str3);
                        }
                    }
                    str5 = str2;
                }
                strArr = null;
            }
            i5 = 0;
            if (i5 == 0) {
                if (m42651c("event param", str3)) {
                    if (!m42667a("event param", strArr, str3)) {
                        if (m42665a("event param", 40, str3)) {
                        }
                        i2 = 0;
                    }
                }
                i2 = 3;
            } else {
                i2 = i5;
            }
            if (i2 == 0) {
                obj = bundle2.get(str3);
                mo6210d();
                if (z2) {
                    str4 = "param";
                    if (obj instanceof Parcelable[]) {
                        if (obj instanceof ArrayList) {
                            i2 = ((ArrayList) obj).size();
                        }
                        obj2 = 1;
                        if (obj2 == null) {
                            i3 = 17;
                            z3 = true;
                            if (i3 != 0) {
                            }
                            if (fw.m42643a(str3)) {
                                i++;
                                if (i > 25) {
                                    stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more than 25 params");
                                    mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                    fw.m42642a(bundle3, 5);
                                    bundle3.remove(str3);
                                }
                            }
                            str5 = str2;
                        }
                    } else {
                        i2 = ((Parcelable[]) obj).length;
                    }
                    if (i2 > 1000) {
                        mo4754r().m42565i().m21310a("Parameter array is too long; discarded. Value kind, name, array length", str4, str3, Integer.valueOf(i2));
                        obj2 = null;
                        if (obj2 == null) {
                            i3 = 17;
                            z3 = true;
                            if (i3 != 0) {
                            }
                            if (fw.m42643a(str3)) {
                                i++;
                                if (i > 25) {
                                    stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more than 25 params");
                                    mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                    fw.m42642a(bundle3, 5);
                                    bundle3.remove(str3);
                                }
                            }
                            str5 = str2;
                        }
                    }
                    obj2 = 1;
                    if (obj2 == null) {
                        i3 = 17;
                        z3 = true;
                        if (i3 != 0) {
                        }
                        if (fw.m42643a(str3)) {
                            i++;
                            if (i > 25) {
                                stringBuilder = new StringBuilder(48);
                                stringBuilder.append("Event can't contain more than 25 params");
                                mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                                fw.m42642a(bundle3, 5);
                                bundle3.remove(str3);
                            }
                        }
                        str5 = str2;
                    }
                }
                if (mo6215t().m38050f(str)) {
                }
                z3 = true;
                str6 = "param";
                i4 = 100;
                fwVar2 = this;
                str7 = str3;
                if (fwVar2.m42644a(str6, str7, i4, obj, z2)) {
                }
                if (i3 != 0) {
                }
                if (fw.m42643a(str3)) {
                    i++;
                    if (i > 25) {
                        stringBuilder = new StringBuilder(48);
                        stringBuilder.append("Event can't contain more than 25 params");
                        mo4754r().I_().m21309a(stringBuilder.toString(), mo6212o().m42528a(str2), mo6212o().m42525a(bundle2));
                        fw.m42642a(bundle3, 5);
                        bundle3.remove(str3);
                    }
                }
                str5 = str2;
            } else {
                if (fw.m42642a(bundle3, i2)) {
                    bundle3.putString("_ev", fw.m42637a(str3, 40, true));
                    if (i2 == 3) {
                        fw.m42639a(bundle3, (Object) str3);
                    }
                }
                bundle3.remove(str3);
            }
            strArr = null;
        }
        return bundle3;
    }

    /* renamed from: a */
    final aq m42659a(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (m42668b(str2) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str3);
            return new aq(str2, new an(m42657a(m42658a(str, str2, bundle2, C2896f.a("_o"), false, false))), str3, j);
        }
        mo4754r().I_().m21308a("Invalid conditional property event name", mo6212o().m42532c(str2));
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    final Object m42660a(String str, Object obj) {
        boolean z;
        int i = 256;
        if ("_ev".equals(str)) {
            z = true;
        } else {
            if (!fw.m42652g(str)) {
                i = 100;
            }
            z = false;
        }
        return fw.m42636a(i, obj, z);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6207a() {
        super.mo6207a();
    }

    /* renamed from: a */
    public final void m42662a(int i, String str, String str2, int i2) {
        m42664a(null, i, str, str2, i2);
    }

    /* renamed from: a */
    final void m42663a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else {
                if (str != null) {
                    mo4754r().m42566j().m21309a("Not putting event parameter. Invalid value type. name, type", mo6212o().m42530b(str), obj != null ? obj.getClass().getSimpleName() : null);
                }
            }
        }
    }

    /* renamed from: a */
    final void m42664a(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        fw.m42642a(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.q.mo4755u();
        this.q.m31966h().m44099a("auto", "_err", bundle);
    }

    /* renamed from: a */
    final boolean m42665a(String str, int i, String str2) {
        if (str2 == null) {
            mo4754r().I_().m21308a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            mo4754r().I_().m21310a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* renamed from: a */
    final boolean m42666a(String str, String str2) {
        if (str2 == null) {
            mo4754r().I_().m21308a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            mo4754r().I_().m21308a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt)) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        mo4754r().I_().m21309a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            mo4754r().I_().m21309a("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    /* renamed from: a */
    final boolean m42667a(String str, String[] strArr, String str2) {
        if (str2 == null) {
            mo4754r().I_().m21308a("Name is required and can't be null. Type", str);
            return false;
        }
        Object obj;
        C2872v.a(str2);
        for (String startsWith : f32359a) {
            if (str2.startsWith(startsWith)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            mo4754r().I_().m21309a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            Object obj2;
            C2872v.a(strArr);
            for (String b : strArr) {
                if (fw.m42649b(str2, b)) {
                    obj2 = 1;
                    break;
                }
            }
            obj2 = null;
            if (obj2 != null) {
                mo4754r().I_().m21309a("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    final int m42668b(String str) {
        return !m42651c("event", str) ? 2 : !m42667a("event", C6846a.f24652a, str) ? 13 : !m42665a("event", 40, str) ? 2 : 0;
    }

    /* renamed from: b */
    final int m42669b(String str, Object obj) {
        return "_ldl".equals(str) ? m42644a("user property referrer", str, fw.m42653i(str), obj, false) : m42644a("user property", str, fw.m42653i(str), obj, false) ? 0 : 7;
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ void mo6208b() {
        super.mo6208b();
    }

    /* renamed from: c */
    public final int m42671c(String str) {
        return !m42666a("user property", str) ? 6 : !m42667a("user property", C6848e.f24656a, str) ? 15 : !m42665a("user property", 24, str) ? 6 : 0;
    }

    /* renamed from: c */
    final Object m42672c(String str, Object obj) {
        int i;
        boolean z;
        if ("_ldl".equals(str)) {
            i = fw.m42653i(str);
            z = true;
        } else {
            i = fw.m42653i(str);
            z = false;
        }
        return fw.m42636a(i, obj, z);
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ void mo6209c() {
        super.mo6209c();
    }

    /* renamed from: d */
    final int m42674d(String str) {
        return !m42651c("user property", str) ? 6 : !m42667a("user property", C6848e.f24656a, str) ? 15 : !m42665a("user property", 24, str) ? 6 : 0;
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ void mo6210d() {
        super.mo6210d();
    }

    /* renamed from: e */
    protected final boolean mo6739e() {
        return true;
    }

    /* renamed from: e */
    final boolean m42677e(String str) {
        if (TextUtils.isEmpty(str)) {
            mo4754r().I_().m21307a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        C2872v.a(str);
        if (str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
            return true;
        }
        mo4754r().I_().m21308a("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    /* renamed from: f */
    protected final void mo6740f() {
        mo6210d();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                mo4754r().m42565i().m21307a("Utils falling back to Random for random id");
            }
        }
        this.f32361c.set(nextLong);
    }

    /* renamed from: f */
    final boolean m42679f(String str) {
        mo6210d();
        if (C2829c.a(mo4752n()).a(str) == 0) {
            return true;
        }
        mo4754r().m42578v().m21308a("Permission not granted", str);
        return false;
    }

    /* renamed from: g */
    public final long m42680g() {
        long nextLong;
        if (this.f32361c.get() == 0) {
            synchronized (this.f32361c) {
                nextLong = new Random(System.nanoTime() ^ mo4751m().a()).nextLong();
                int i = this.f32362d + 1;
                this.f32362d = i;
                nextLong += (long) i;
            }
            return nextLong;
        }
        synchronized (this.f32361c) {
            this.f32361c.compareAndSet(-1, 1);
            nextLong = this.f32361c.getAndIncrement();
        }
        return nextLong;
    }

    /* renamed from: h */
    final SecureRandom m42681h() {
        mo6210d();
        if (this.f32360b == null) {
            this.f32360b = new SecureRandom();
        }
        return this.f32360b;
    }

    /* renamed from: h */
    final boolean m42682h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String v = mo6215t().m38070v();
        mo4755u();
        return v.equals(str);
    }

    /* renamed from: j */
    public final int m42683j() {
        if (this.f32363e == null) {
            this.f32363e = Integer.valueOf(C2830f.b().d(mo4752n()) / 1000);
        }
        return this.f32363e.intValue();
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
}

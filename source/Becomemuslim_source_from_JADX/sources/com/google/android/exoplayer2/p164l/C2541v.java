package com.google.android.exoplayer2.p164l;

import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imageutils.JfifUtil;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.exoplayer2.C2571p;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Util */
/* renamed from: com.google.android.exoplayer2.l.v */
public final class C2541v {
    /* renamed from: a */
    public static final int f6467a;
    /* renamed from: b */
    public static final String f6468b = Build.DEVICE;
    /* renamed from: c */
    public static final String f6469c = Build.MANUFACTURER;
    /* renamed from: d */
    public static final String f6470d = Build.MODEL;
    /* renamed from: e */
    public static final String f6471e;
    /* renamed from: f */
    private static final Pattern f6472f = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    /* renamed from: g */
    private static final Pattern f6473g = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    /* renamed from: h */
    private static final Pattern f6474h = Pattern.compile("%([A-Fa-f0-9]{2})");
    /* renamed from: i */
    private static final int[] f6475i = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};

    /* renamed from: a */
    public static boolean m7177a(int i) {
        if (i != 10) {
            if (i != 13) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static int m7182b(int i) {
        return i != 8 ? i != 16 ? i != 24 ? i != 32 ? 0 : 1073741824 : LinearLayoutManager.INVALID_OFFSET : 2 : 3;
    }

    /* renamed from: c */
    public static int m7187c(int i) {
        switch (i) {
            case 1:
            case 12:
            case 14:
                return 3;
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 13:
                return 1;
            default:
                return 3;
        }
    }

    static {
        int i = (VERSION.SDK_INT == 25 && VERSION.CODENAME.charAt(0) == 'O') ? 26 : VERSION.SDK_INT;
        f6467a = i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f6468b);
        stringBuilder.append(", ");
        stringBuilder.append(f6470d);
        stringBuilder.append(", ");
        stringBuilder.append(f6469c);
        stringBuilder.append(", ");
        stringBuilder.append(f6467a);
        f6471e = stringBuilder.toString();
    }

    /* renamed from: a */
    public static boolean m7178a(Uri uri) {
        uri = uri.getScheme();
        if (!TextUtils.isEmpty(uri)) {
            if (uri.equals(UriUtil.LOCAL_FILE_SCHEME) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m7179a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null ? true : null;
        } else {
            return obj.equals(obj2);
        }
    }

    /* renamed from: a */
    public static ExecutorService m7173a(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, str);
            }
        });
    }

    /* renamed from: a */
    public static void m7174a(com.google.android.exoplayer2.p163k.C2498g r0) {
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
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.mo2270b();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l.v.a(com.google.android.exoplayer2.k.g):void");
    }

    /* renamed from: a */
    public static void m7175a(java.io.Closeable r0) {
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
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l.v.a(java.io.Closeable):void");
    }

    /* renamed from: b */
    public static java.lang.String m7186b(java.lang.String r1) {
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
        if (r1 != 0) goto L_0x0004;
    L_0x0002:
        r1 = 0;
        goto L_0x000e;
    L_0x0004:
        r0 = new java.util.Locale;	 Catch:{ MissingResourceException -> 0x000f }
        r0.<init>(r1);	 Catch:{ MissingResourceException -> 0x000f }
        r0 = r0.getISO3Language();	 Catch:{ MissingResourceException -> 0x000f }
        r1 = r0;
    L_0x000e:
        return r1;
    L_0x000f:
        r1 = r1.toLowerCase();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l.v.b(java.lang.String):java.lang.String");
    }

    /* renamed from: c */
    public static byte[] m7188c(String str) {
        return str.getBytes(Charset.forName(Utf8Charset.NAME));
    }

    /* renamed from: d */
    public static String m7190d(String str) {
        return str == null ? null : str.toLowerCase(Locale.US);
    }

    /* renamed from: a */
    public static int m7163a(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    /* renamed from: a */
    public static long m7168a(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    /* renamed from: a */
    public static int m7164a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    /* renamed from: a */
    public static long m7169a(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    /* renamed from: a */
    public static float m7162a(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }

    /* renamed from: a */
    public static int m7167a(long[] jArr, long j, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            jArr = -(binarySearch + 2);
        } else {
            while (true) {
                binarySearch--;
                if (binarySearch < 0 || jArr[binarySearch] != j) {
                    jArr = z ? binarySearch + 1 : binarySearch;
                }
            }
            if (z) {
            }
        }
        return z2 ? Math.max(0, jArr) : jArr;
    }

    /* renamed from: b */
    public static int m7184b(long[] jArr, long j, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            j = ~binarySearch;
        } else {
            while (true) {
                binarySearch++;
                if (binarySearch >= jArr.length || jArr[binarySearch] != j) {
                    j = z ? binarySearch - 1 : binarySearch;
                }
            }
            if (z) {
            }
        }
        return z2 ? Math.min(jArr.length - 1, j) : j;
    }

    /* renamed from: a */
    public static <T> int m7165a(List<? extends Comparable<? super T>> list, T t, boolean z, boolean z2) {
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            list = -(binarySearch + 2);
        } else {
            while (true) {
                binarySearch--;
                if (binarySearch < 0 || ((Comparable) list.get(binarySearch)).compareTo(t) != 0) {
                    list = z ? binarySearch + 1 : binarySearch;
                }
            }
            if (z) {
            }
        }
        return z2 ? Math.max(null, list) : list;
    }

    /* renamed from: e */
    public static long m7191e(String str) {
        Matcher matcher = f6473g.matcher(str);
        if (!matcher.matches()) {
            return (long) ((Double.parseDouble(str) * 3600.0d) * 1000.0d);
        }
        str = 1 ^ TextUtils.isEmpty(matcher.group(1));
        String group = matcher.group(3);
        double d = 0.0d;
        double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
        group = matcher.group(5);
        parseDouble += group != null ? Double.parseDouble(group) * 2629739.0d : 0.0d;
        group = matcher.group(7);
        parseDouble += group != null ? Double.parseDouble(group) * 86400.0d : 0.0d;
        group = matcher.group(10);
        parseDouble += group != null ? 3600.0d * Double.parseDouble(group) : 0.0d;
        group = matcher.group(12);
        parseDouble += group != null ? Double.parseDouble(group) * 60.0d : 0.0d;
        String group2 = matcher.group(14);
        if (group2 != null) {
            d = Double.parseDouble(group2);
        }
        long j = (long) ((parseDouble + d) * 1000.0d);
        if (str != null) {
            j = -j;
        }
        return j;
    }

    /* renamed from: f */
    public static long m7192f(String str) {
        Matcher matcher = f6472f.matcher(str);
        if (matcher.matches()) {
            int i = 0;
            if (matcher.group(9) != null) {
                if (matcher.group(9).equalsIgnoreCase("Z") == null) {
                    i = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                    if (matcher.group(11).equals("-") != null) {
                        i *= -1;
                    }
                }
            }
            str = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            str.clear();
            str.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("0.");
                stringBuilder.append(matcher.group(8));
                str.set(14, new BigDecimal(stringBuilder.toString()).movePointRight(3).intValue());
            }
            long timeInMillis = str.getTimeInMillis();
            return i != 0 ? timeInMillis - ((long) (i * 60000)) : timeInMillis;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Invalid date/time format: ");
            stringBuilder2.append(str);
            throw new C2571p(stringBuilder2.toString());
        }
    }

    /* renamed from: b */
    public static long m7185b(long j, long j2, long j3) {
        int i = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        if (i >= 0 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (i < 0 && j2 % j3 == 0) {
            return j * (j2 / j3);
        }
        return (long) (((double) j) * (((double) j2) / ((double) j3)));
    }

    /* renamed from: a */
    public static long[] m7181a(List<Long> list, long j, long j2) {
        long[] jArr = new long[list.size()];
        int i = 0;
        int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
        if (i2 >= 0 && j2 % j == 0) {
            j2 /= j;
            while (i < jArr.length) {
                jArr[i] = ((Long) list.get(i)).longValue() / j2;
                i++;
            }
        } else if (i2 >= 0 || j % j2 != 0) {
            j = ((double) j) / ((double) j2);
            while (i < jArr.length) {
                jArr[i] = (long) (((double) ((Long) list.get(i)).longValue()) * j);
                i++;
            }
        } else {
            j /= j2;
            while (i < jArr.length) {
                jArr[i] = ((Long) list.get(i)).longValue() * j;
                i++;
            }
        }
        return jArr;
    }

    /* renamed from: a */
    public static void m7176a(long[] jArr, long j, long j2) {
        int i = 0;
        int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
        if (i2 >= 0 && j2 % j == 0) {
            j2 /= j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j2;
                i++;
            }
        } else if (i2 >= 0 || j % j2 != 0) {
            j = ((double) j) / ((double) j2);
            while (i < jArr.length) {
                jArr[i] = (long) (((double) jArr[i]) * j);
                i++;
            }
        } else {
            j /= j2;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j;
                i++;
            }
        }
    }

    /* renamed from: a */
    public static int[] m7180a(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) list.get(i)).intValue();
        }
        return iArr;
    }

    /* renamed from: g */
    public static int m7193g(String str) {
        int length = str.length();
        C2516a.m7017a(length <= 4);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i << 8) | str.charAt(i2);
        }
        return i;
    }

    /* renamed from: h */
    public static byte[] m7194h(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    /* renamed from: a */
    public static String m7172a(Object[] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            stringBuilder.append(objArr[i].getClass().getSimpleName());
            if (i < objArr.length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static java.lang.String m7170a(android.content.Context r2, java.lang.String r3) {
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
        r0 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0010 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r2.getPackageInfo(r0, r1);	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r2.versionName;	 Catch:{ NameNotFoundException -> 0x0010 }
        goto L_0x0012;
    L_0x0010:
        r2 = "?";
    L_0x0012:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r3);
        r3 = "/";
        r0.append(r3);
        r0.append(r2);
        r2 = " (Linux;Android ";
        r0.append(r2);
        r2 = android.os.Build.VERSION.RELEASE;
        r0.append(r2);
        r2 = ") ";
        r0.append(r2);
        r2 = "ExoPlayerLib/2.6.1";
        r0.append(r2);
        r2 = r0.toString();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.l.v.a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static int m7183b(int i, int i2) {
        if (i == LinearLayoutManager.INVALID_OFFSET) {
            return i2 * 3;
        }
        if (i != 1073741824) {
            switch (i) {
                case 2:
                    return i2 * 2;
                case 3:
                    return i2;
                case 4:
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return i2 * 4;
    }

    /* renamed from: i */
    public static int m7195i(String str) {
        str = C2541v.m7190d(str);
        if (str.endsWith(".mpd")) {
            return null;
        }
        if (str.endsWith(".m3u8")) {
            return 2;
        }
        return str.matches(".*\\.ism(l)?(/manifest(\\(.+\\))?)?") != null ? 1 : 3;
    }

    /* renamed from: a */
    public static String m7171a(StringBuilder stringBuilder, Formatter formatter, long j) {
        if (j == -9223372036854775807L) {
            j = 0;
        }
        j = (j + 500) / 1000;
        long j2 = j % 60;
        long j3 = (j / 60) % 60;
        j /= 3600;
        stringBuilder.setLength(0);
        if (j > 0) {
            return formatter.format("%d:%02d:%02d", new Object[]{Long.valueOf(j), Long.valueOf(j3), Long.valueOf(j2)}).toString();
        }
        return formatter.format("%02d:%02d", new Object[]{Long.valueOf(j3), Long.valueOf(j2)}).toString();
    }

    /* renamed from: d */
    public static int m7189d(int i) {
        switch (i) {
            case 0:
                return 16777216;
            case 1:
                return 3538944;
            case 2:
                return 13107200;
            case 3:
                return 131072;
            case 4:
                return 131072;
            default:
                throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public static int m7166a(byte[] bArr, int i, int i2, int i3) {
        while (i < i2) {
            i3 = f6475i[((i3 >>> 24) ^ (bArr[i] & JfifUtil.MARKER_FIRST_BYTE)) & JfifUtil.MARKER_FIRST_BYTE] ^ (i3 << 8);
            i++;
        }
        return i3;
    }
}

package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SoLoader {
    static final boolean DEBUG = false;
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    private static final String SO_STORE_NAME_MAIN = "lib-main";
    static final boolean SYSTRACE_LIBRARY_LOADING;
    static final String TAG = "SoLoader";
    private static ApplicationSoSource sApplicationSoSource;
    private static UnpackingSoSource sBackupSoSource;
    private static int sFlags;
    private static final Set<String> sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final HashSet<String> sLoadedLibraries = new HashSet();
    private static final Map<String, Object> sLoadingLibraries = new HashMap();
    static SoFileLoader sSoFileLoader;
    private static SoSource[] sSoSources = null;
    private static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    private static int sSoSourcesVersion = 0;
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    @DoNotOptimize
    @TargetApi(14)
    private static class Api14Utils {
        private Api14Utils() {
        }

        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Throwable e) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ClassLoader ");
            stringBuilder.append(classLoader.getClass().getName());
            stringBuilder.append(" should be of type BaseDexClassLoader");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th) {
            super("APK was built for a different platform");
            initCause(th);
        }
    }

    static {
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
        r0 = new java.util.concurrent.locks.ReentrantReadWriteLock;
        r0.<init>();
        sSoSourcesLock = r0;
        r0 = 0;
        sSoSources = r0;
        r1 = 0;
        sSoSourcesVersion = r1;
        r2 = new java.util.HashSet;
        r2.<init>();
        sLoadedLibraries = r2;
        r2 = new java.util.HashMap;
        r2.<init>();
        sLoadingLibraries = r2;
        r2 = new java.util.concurrent.ConcurrentHashMap;
        r2.<init>();
        r2 = java.util.Collections.newSetFromMap(r2);
        sLoadedAndMergedLibraries = r2;
        sSystemLoadLibraryWrapper = r0;
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ NoClassDefFoundError -> 0x0030, NoClassDefFoundError -> 0x0030 }
        r2 = 18;
        if (r0 < r2) goto L_0x0030;
    L_0x002e:
        r0 = 1;
        r1 = 1;
    L_0x0030:
        SYSTRACE_LIBRARY_LOADING = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.<clinit>():void");
    }

    public static void init(Context context, int i) {
        init(context, i, null);
    }

    private static void init(Context context, int i, SoFileLoader soFileLoader) {
        ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            initSoLoader(soFileLoader);
            initSoSources(context, i, soFileLoader);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, (int) z);
        } catch (Context context2) {
            throw new RuntimeException(context2);
        }
    }

    private static void initSoSources(Context context, int i, SoFileLoader soFileLoader) {
        sSoSourcesLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                StringBuilder stringBuilder;
                Log.d(TAG, "init start");
                sFlags = i;
                soFileLoader = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    str = "/vendor/lib:/system/lib";
                }
                String[] split = str.split(":");
                for (int i2 = 0; i2 < split.length; i2++) {
                    String str2 = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("adding system library source: ");
                    stringBuilder2.append(split[i2]);
                    Log.d(str2, stringBuilder2.toString());
                    soFileLoader.add(new DirectorySoSource(new File(split[i2]), 2));
                }
                if (context != null) {
                    if ((i & 1) != 0) {
                        sBackupSoSource = 0;
                        Log.d(TAG, "adding exo package source: lib-main");
                        soFileLoader.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                    } else {
                        i = context.getApplicationInfo();
                        i = ((i.flags & 1) == 0 || (i.flags & 128) != 0) ? 0 : 1;
                        if (i != 0) {
                            i = 0;
                        } else {
                            sApplicationSoSource = new ApplicationSoSource(context, VERSION.SDK_INT <= 17 ? 1 : 0);
                            i = TAG;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("adding application source: ");
                            stringBuilder.append(sApplicationSoSource.toString());
                            Log.d(i, stringBuilder.toString());
                            soFileLoader.add(0, sApplicationSoSource);
                            i = 1;
                        }
                        sBackupSoSource = new ApkSoSource(context, SO_STORE_NAME_MAIN, i);
                        context = TAG;
                        i = new StringBuilder();
                        i.append("adding backup  source: ");
                        i.append(sBackupSoSource.toString());
                        Log.d(context, i.toString());
                        soFileLoader.add(0, sBackupSoSource);
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) soFileLoader.toArray(new SoSource[soFileLoader.size()]);
                i = makePrepareFlags();
                soFileLoader = soSourceArr.length;
                while (true) {
                    int i3 = soFileLoader - 1;
                    if (soFileLoader <= null) {
                        break;
                    }
                    soFileLoader = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Preparing SO source: ");
                    stringBuilder.append(soSourceArr[i3]);
                    Log.d(soFileLoader, stringBuilder.toString());
                    soSourceArr[i3].prepare(i);
                    soFileLoader = i3;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion += 1;
                context = TAG;
                i = new StringBuilder();
                i.append("init finish: ");
                i.append(sSoSources.length);
                i.append(" SO sources prepared");
                Log.d(context, i.toString());
            }
            Log.d(TAG, "init exiting");
            sSoSourcesLock.writeLock().unlock();
        } catch (Throwable th) {
            Log.d(TAG, "init exiting");
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static int makePrepareFlags() {
        sSoSourcesLock.writeLock().lock();
        try {
            int i = (sFlags & 2) != 0 ? 1 : 0;
            sSoSourcesLock.writeLock().unlock();
            return i;
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    private static synchronized void initSoLoader(SoFileLoader soFileLoader) {
        synchronized (SoLoader.class) {
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            final Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
            final boolean z = nativeLoadRuntimeMethod != null;
            final SoFileLoader classLoaderLdLoadLibrary = z ? Api14Utils.getClassLoaderLdLoadLibrary() : null;
            final String makeNonZipPath = makeNonZipPath(classLoaderLdLoadLibrary);
            sSoFileLoader = new SoFileLoader() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void load(java.lang.String r10, int r11) {
                    /*
                    r9 = this;
                    r0 = r2;
                    if (r0 == 0) goto L_0x00d6;
                L_0x0004:
                    r0 = 4;
                    r11 = r11 & r0;
                    r1 = 0;
                    r2 = 1;
                    if (r11 != r0) goto L_0x000c;
                L_0x000a:
                    r11 = 1;
                    goto L_0x000d;
                L_0x000c:
                    r11 = 0;
                L_0x000d:
                    if (r11 == 0) goto L_0x0012;
                L_0x000f:
                    r11 = r3;
                    goto L_0x0014;
                L_0x0012:
                    r11 = r4;
                L_0x0014:
                    r0 = 0;
                    r3 = r5;	 Catch:{ IllegalAccessException -> 0x008f, IllegalAccessException -> 0x008f, IllegalAccessException -> 0x008f }
                    monitor-enter(r3);	 Catch:{ IllegalAccessException -> 0x008f, IllegalAccessException -> 0x008f, IllegalAccessException -> 0x008f }
                    r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x008a }
                    r5 = 27;
                    r6 = 2;
                    if (r4 > r5) goto L_0x0039;
                L_0x001f:
                    r4 = r6;	 Catch:{ all -> 0x008a }
                    r5 = r5;	 Catch:{ all -> 0x008a }
                    r7 = 3;
                    r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x008a }
                    r7[r1] = r10;	 Catch:{ all -> 0x008a }
                    r1 = com.facebook.soloader.SoLoader.class;
                    r1 = r1.getClassLoader();	 Catch:{ all -> 0x008a }
                    r7[r2] = r1;	 Catch:{ all -> 0x008a }
                    r7[r6] = r11;	 Catch:{ all -> 0x008a }
                    r1 = r4.invoke(r5, r7);	 Catch:{ all -> 0x008a }
                    r1 = (java.lang.String) r1;	 Catch:{ all -> 0x008a }
                    goto L_0x004f;
                L_0x0039:
                    r4 = r6;	 Catch:{ all -> 0x008a }
                    r5 = r5;	 Catch:{ all -> 0x008a }
                    r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x008a }
                    r6[r1] = r10;	 Catch:{ all -> 0x008a }
                    r1 = com.facebook.soloader.SoLoader.class;
                    r1 = r1.getClassLoader();	 Catch:{ all -> 0x008a }
                    r6[r2] = r1;	 Catch:{ all -> 0x008a }
                    r1 = r4.invoke(r5, r6);	 Catch:{ all -> 0x008a }
                    r1 = (java.lang.String) r1;	 Catch:{ all -> 0x008a }
                L_0x004f:
                    if (r1 != 0) goto L_0x007f;
                L_0x0051:
                    monitor-exit(r3);	 Catch:{ all -> 0x0085 }
                    if (r1 == 0) goto L_0x00d9;
                L_0x0054:
                    r0 = "SoLoader";
                    r2 = new java.lang.StringBuilder;
                    r2.<init>();
                    r3 = "Error when loading lib: ";
                    r2.append(r3);
                    r2.append(r1);
                    r1 = " lib hash: ";
                    r2.append(r1);
                    r10 = r9.getLibHash(r10);
                    r2.append(r10);
                    r10 = " search path is ";
                    r2.append(r10);
                    r2.append(r11);
                    r10 = r2.toString();
                    android.util.Log.e(r0, r10);
                    goto L_0x00d9;
                L_0x007f:
                    r0 = new java.lang.UnsatisfiedLinkError;	 Catch:{ all -> 0x0085 }
                    r0.<init>(r1);	 Catch:{ all -> 0x0085 }
                    throw r0;	 Catch:{ all -> 0x0085 }
                L_0x0085:
                    r0 = move-exception;
                    r8 = r1;
                    r1 = r0;
                    r0 = r8;
                    goto L_0x008b;
                L_0x008a:
                    r1 = move-exception;
                L_0x008b:
                    monitor-exit(r3);	 Catch:{ all -> 0x008a }
                    throw r1;	 Catch:{ IllegalAccessException -> 0x008f, IllegalAccessException -> 0x008f, IllegalAccessException -> 0x008f }
                L_0x008d:
                    r1 = move-exception;
                    goto L_0x00a9;
                L_0x008f:
                    r1 = move-exception;
                    r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
                    r2.<init>();	 Catch:{ all -> 0x008d }
                    r3 = "Error: Cannot load ";
                    r2.append(r3);	 Catch:{ all -> 0x008d }
                    r2.append(r10);	 Catch:{ all -> 0x008d }
                    r2 = r2.toString();	 Catch:{ all -> 0x008d }
                    r0 = new java.lang.RuntimeException;	 Catch:{ all -> 0x00a7 }
                    r0.<init>(r2, r1);	 Catch:{ all -> 0x00a7 }
                    throw r0;	 Catch:{ all -> 0x00a7 }
                L_0x00a7:
                    r1 = move-exception;
                    r0 = r2;
                L_0x00a9:
                    if (r0 == 0) goto L_0x00d5;
                L_0x00ab:
                    r2 = new java.lang.StringBuilder;
                    r2.<init>();
                    r3 = "Error when loading lib: ";
                    r2.append(r3);
                    r2.append(r0);
                    r0 = " lib hash: ";
                    r2.append(r0);
                    r10 = r9.getLibHash(r10);
                    r2.append(r10);
                    r10 = " search path is ";
                    r2.append(r10);
                    r2.append(r11);
                    r10 = r2.toString();
                    r11 = "SoLoader";
                    android.util.Log.e(r11, r10);
                L_0x00d5:
                    throw r1;
                L_0x00d6:
                    java.lang.System.load(r10);
                L_0x00d9:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.1.load(java.lang.String, int):void");
                }

                private String getLibHash(String str) {
                    String str2;
                    InputStream fileInputStream;
                    try {
                        File file = new File(str);
                        str = MessageDigest.getInstance("MD5");
                        fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                str.update(bArr, 0, read);
                            } else {
                                str = String.format("%32x", new Object[]{new BigInteger(1, str.digest())});
                                fileInputStream.close();
                                return str;
                            }
                        }
                    } catch (String str3) {
                        return str3.toString();
                    } catch (String str32) {
                        return str32.toString();
                    } catch (Throwable th) {
                        str2.addSuppressed(th);
                    }
                }
            };
        }
    }

    private static Method getNativeLoadRuntimeMethod() {
        if (VERSION.SDK_INT < 23) {
            return null;
        }
        try {
            Method declaredMethod;
            if (VERSION.SDK_INT <= 27) {
                declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});
            } else {
                declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class});
            }
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable e) {
            Log.w(TAG, "Cannot get nativeLoad method", e);
            return null;
        }
    }

    public static void setInTestMode() {
        setSoSources(new SoSource[]{new NoopSoSource()});
    }

    public static void deinitForTest() {
        setSoSources(null);
    }

    static void setSoSources(SoSource[] soSourceArr) {
        sSoSourcesLock.writeLock().lock();
        try {
            sSoSources = soSourceArr;
            sSoSourcesVersion++;
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    static void setSoFileLoader(SoFileLoader soFileLoader) {
        sSoFileLoader = soFileLoader;
    }

    static void resetStatus() {
        synchronized (SoLoader.class) {
            sLoadedLibraries.clear();
            sLoadingLibraries.clear();
            sSoFileLoader = null;
        }
        setSoSources(null);
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    /* renamed from: loadLibrary */
    public static boolean m44627loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    public static boolean loadLibrary(String str, int i) {
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    boolean contains;
                    synchronized (SoLoader.class) {
                        contains = sLoadedLibraries.contains(str) ^ 1;
                        if (contains) {
                            if (sSystemLoadLibraryWrapper != null) {
                                sSystemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    sSoSourcesLock.readLock().unlock();
                    return contains;
                }
            }
            sSoSourcesLock.readLock().unlock();
            String mapLibName = MergedSoMapping.mapLibName(str);
            return loadLibraryBySoName(System.mapLibraryName(mapLibName != null ? mapLibName : str), str, mapLibName, i, null);
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
        }
    }

    static void loadLibraryBySoName(String str, int i, ThreadPolicy threadPolicy) {
        loadLibraryBySoName(str, null, null, i, threadPolicy);
    }

    public static Set<String> getLoadedLibraries() {
        HashSet hashSet;
        synchronized (SoLoader.class) {
            hashSet = (HashSet) sLoadedLibraries.clone();
        }
        return hashSet;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean loadLibraryBySoName(java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, android.os.StrictMode.ThreadPolicy r11) {
        /*
        r0 = android.text.TextUtils.isEmpty(r8);
        r1 = 0;
        if (r0 != 0) goto L_0x0010;
    L_0x0007:
        r0 = sLoadedAndMergedLibraries;
        r0 = r0.contains(r8);
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = com.facebook.soloader.SoLoader.class;
        monitor-enter(r0);
        r2 = sLoadedLibraries;	 Catch:{ all -> 0x011f }
        r2 = r2.contains(r7);	 Catch:{ all -> 0x011f }
        r3 = 1;
        if (r2 == 0) goto L_0x0022;
    L_0x001c:
        if (r9 != 0) goto L_0x0020;
    L_0x001e:
        monitor-exit(r0);	 Catch:{ all -> 0x011f }
        return r1;
    L_0x0020:
        r2 = 1;
        goto L_0x0023;
    L_0x0022:
        r2 = 0;
    L_0x0023:
        r4 = sLoadingLibraries;	 Catch:{ all -> 0x011f }
        r4 = r4.containsKey(r7);	 Catch:{ all -> 0x011f }
        if (r4 == 0) goto L_0x0032;
    L_0x002b:
        r4 = sLoadingLibraries;	 Catch:{ all -> 0x011f }
        r4 = r4.get(r7);	 Catch:{ all -> 0x011f }
        goto L_0x003c;
    L_0x0032:
        r4 = new java.lang.Object;	 Catch:{ all -> 0x011f }
        r4.<init>();	 Catch:{ all -> 0x011f }
        r5 = sLoadingLibraries;	 Catch:{ all -> 0x011f }
        r5.put(r7, r4);	 Catch:{ all -> 0x011f }
    L_0x003c:
        monitor-exit(r0);	 Catch:{ all -> 0x011f }
        monitor-enter(r4);
        if (r2 != 0) goto L_0x00b2;
    L_0x0040:
        r0 = com.facebook.soloader.SoLoader.class;
        monitor-enter(r0);	 Catch:{ all -> 0x00b0 }
        r5 = sLoadedLibraries;	 Catch:{ all -> 0x00ad }
        r5 = r5.contains(r7);	 Catch:{ all -> 0x00ad }
        if (r5 == 0) goto L_0x0051;
    L_0x004b:
        if (r9 != 0) goto L_0x0050;
    L_0x004d:
        monitor-exit(r0);	 Catch:{ all -> 0x00ad }
        monitor-exit(r4);	 Catch:{ all -> 0x00b0 }
        return r1;
    L_0x0050:
        r2 = 1;
    L_0x0051:
        monitor-exit(r0);	 Catch:{ all -> 0x00ad }
        if (r2 != 0) goto L_0x00b2;
    L_0x0054:
        r0 = "SoLoader";
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
        r5.<init>();	 Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
        r6 = "About to load: ";
        r5.append(r6);	 Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
        r5.append(r7);	 Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
        doLoadLibraryBySoName(r7, r10, r11);	 Catch:{ IOException -> 0x00a6, UnsatisfiedLinkError -> 0x0090 }
        r10 = com.facebook.soloader.SoLoader.class;
        monitor-enter(r10);	 Catch:{ all -> 0x00b0 }
        r11 = "SoLoader";
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r0.<init>();	 Catch:{ all -> 0x008d }
        r5 = "Loaded: ";
        r0.append(r5);	 Catch:{ all -> 0x008d }
        r0.append(r7);	 Catch:{ all -> 0x008d }
        r0 = r0.toString();	 Catch:{ all -> 0x008d }
        android.util.Log.d(r11, r0);	 Catch:{ all -> 0x008d }
        r11 = sLoadedLibraries;	 Catch:{ all -> 0x008d }
        r11.add(r7);	 Catch:{ all -> 0x008d }
        monitor-exit(r10);	 Catch:{ all -> 0x008d }
        goto L_0x00b2;
    L_0x008d:
        r7 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x008d }
        throw r7;	 Catch:{ all -> 0x00b0 }
    L_0x0090:
        r7 = move-exception;
        r8 = r7.getMessage();	 Catch:{ all -> 0x00b0 }
        if (r8 == 0) goto L_0x00a5;
    L_0x0097:
        r9 = "unexpected e_machine:";
        r8 = r8.contains(r9);	 Catch:{ all -> 0x00b0 }
        if (r8 == 0) goto L_0x00a5;
    L_0x009f:
        r8 = new com.facebook.soloader.SoLoader$WrongAbiError;	 Catch:{ all -> 0x00b0 }
        r8.<init>(r7);	 Catch:{ all -> 0x00b0 }
        throw r8;	 Catch:{ all -> 0x00b0 }
    L_0x00a5:
        throw r7;	 Catch:{ all -> 0x00b0 }
    L_0x00a6:
        r7 = move-exception;
        r8 = new java.lang.RuntimeException;	 Catch:{ all -> 0x00b0 }
        r8.<init>(r7);	 Catch:{ all -> 0x00b0 }
        throw r8;	 Catch:{ all -> 0x00b0 }
    L_0x00ad:
        r7 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00ad }
        throw r7;	 Catch:{ all -> 0x00b0 }
    L_0x00b0:
        r7 = move-exception;
        goto L_0x011d;
    L_0x00b2:
        r10 = android.text.TextUtils.isEmpty(r8);	 Catch:{ all -> 0x00b0 }
        if (r10 != 0) goto L_0x00c1;
    L_0x00b8:
        r10 = sLoadedAndMergedLibraries;	 Catch:{ all -> 0x00b0 }
        r10 = r10.contains(r8);	 Catch:{ all -> 0x00b0 }
        if (r10 == 0) goto L_0x00c1;
    L_0x00c0:
        r1 = 1;
    L_0x00c1:
        if (r9 == 0) goto L_0x0119;
    L_0x00c3:
        if (r1 != 0) goto L_0x0119;
    L_0x00c5:
        r9 = SYSTRACE_LIBRARY_LOADING;	 Catch:{ all -> 0x00b0 }
        if (r9 == 0) goto L_0x00e2;
    L_0x00c9:
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b0 }
        r9.<init>();	 Catch:{ all -> 0x00b0 }
        r10 = "MergedSoMapping.invokeJniOnload[";
        r9.append(r10);	 Catch:{ all -> 0x00b0 }
        r9.append(r8);	 Catch:{ all -> 0x00b0 }
        r10 = "]";
        r9.append(r10);	 Catch:{ all -> 0x00b0 }
        r9 = r9.toString();	 Catch:{ all -> 0x00b0 }
        com.facebook.soloader.Api18TraceUtils.beginTraceSection(r9);	 Catch:{ all -> 0x00b0 }
    L_0x00e2:
        r9 = "SoLoader";
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0110 }
        r10.<init>();	 Catch:{ all -> 0x0110 }
        r11 = "About to merge: ";
        r10.append(r11);	 Catch:{ all -> 0x0110 }
        r10.append(r8);	 Catch:{ all -> 0x0110 }
        r11 = " / ";
        r10.append(r11);	 Catch:{ all -> 0x0110 }
        r10.append(r7);	 Catch:{ all -> 0x0110 }
        r7 = r10.toString();	 Catch:{ all -> 0x0110 }
        android.util.Log.d(r9, r7);	 Catch:{ all -> 0x0110 }
        com.facebook.soloader.MergedSoMapping.invokeJniOnload(r8);	 Catch:{ all -> 0x0110 }
        r7 = sLoadedAndMergedLibraries;	 Catch:{ all -> 0x0110 }
        r7.add(r8);	 Catch:{ all -> 0x0110 }
        r7 = SYSTRACE_LIBRARY_LOADING;	 Catch:{ all -> 0x00b0 }
        if (r7 == 0) goto L_0x0119;
    L_0x010c:
        com.facebook.soloader.Api18TraceUtils.endSection();	 Catch:{ all -> 0x00b0 }
        goto L_0x0119;
    L_0x0110:
        r7 = move-exception;
        r8 = SYSTRACE_LIBRARY_LOADING;	 Catch:{ all -> 0x00b0 }
        if (r8 == 0) goto L_0x0118;
    L_0x0115:
        com.facebook.soloader.Api18TraceUtils.endSection();	 Catch:{ all -> 0x00b0 }
    L_0x0118:
        throw r7;	 Catch:{ all -> 0x00b0 }
    L_0x0119:
        monitor-exit(r4);	 Catch:{ all -> 0x00b0 }
        r7 = r2 ^ 1;
        return r7;
    L_0x011d:
        monitor-exit(r4);	 Catch:{ all -> 0x00b0 }
        throw r7;
    L_0x011f:
        r7 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x011f }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.loadLibraryBySoName(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    public static File unpackLibraryAndDependencies(String str) {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (String str2) {
            throw new RuntimeException(str2);
        }
    }

    private static void doLoadLibraryBySoName(String str, int i, ThreadPolicy threadPolicy) {
        Object obj;
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                if (threadPolicy == null) {
                    threadPolicy = StrictMode.allowThreadDiskReads();
                    obj = 1;
                } else {
                    obj = null;
                }
                if (SYSTRACE_LIBRARY_LOADING) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("SoLoader.loadLibrary[");
                    stringBuilder.append(str);
                    stringBuilder.append("]");
                    Api18TraceUtils.beginTraceSection(stringBuilder.toString());
                }
                int i2 = 0;
                while (true) {
                    try {
                        Object obj2;
                        sSoSourcesLock.readLock().lock();
                        int i3 = sSoSourcesVersion;
                        int i4 = 0;
                        while (i2 == 0) {
                            try {
                                if (i4 >= sSoSources.length) {
                                    break;
                                }
                                int loadLibrary = sSoSources[i4].loadLibrary(str, i, threadPolicy);
                                if (loadLibrary == 3) {
                                    try {
                                        if (sBackupSoSource != null) {
                                            String str2 = TAG;
                                            StringBuilder stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append("Trying backup SoSource for ");
                                            stringBuilder2.append(str);
                                            Log.d(str2, stringBuilder2.toString());
                                            sBackupSoSource.prepare(str);
                                            i2 = sBackupSoSource.loadLibrary(str, i, threadPolicy);
                                            break;
                                        }
                                    } catch (Throwable th) {
                                        i = th;
                                        i2 = loadLibrary;
                                    }
                                }
                                i4++;
                                i2 = loadLibrary;
                            } catch (Throwable th2) {
                                i = th2;
                            }
                        }
                        sSoSourcesLock.readLock().unlock();
                        if (i2 == 0) {
                            sSoSourcesLock.writeLock().lock();
                            if (sApplicationSoSource != null && sApplicationSoSource.checkAndMaybeUpdate()) {
                                sSoSourcesVersion++;
                            }
                            obj2 = sSoSourcesVersion != i3 ? 1 : null;
                            sSoSourcesLock.writeLock().unlock();
                            continue;
                        } else {
                            obj2 = null;
                            continue;
                        }
                        if (obj2 == null) {
                            break;
                        }
                    } catch (Throwable th3) {
                        if (SYSTRACE_LIBRARY_LOADING) {
                            Api18TraceUtils.endSection();
                        }
                        if (obj != null) {
                            StrictMode.setThreadPolicy(threadPolicy);
                        }
                        if (i2 != 0) {
                            if (i2 == 3) {
                            }
                        }
                        i = new StringBuilder();
                        i.append("couldn't find DSO to load: ");
                        i.append(str);
                        str = i.toString();
                        Log.e(TAG, str);
                        i = new UnsatisfiedLinkError(str);
                    }
                }
                if (SYSTRACE_LIBRARY_LOADING != 0) {
                    Api18TraceUtils.endSection();
                }
                if (obj != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                if (i2 == 0 || i2 == 3) {
                    i = new StringBuilder();
                    i.append("couldn't find DSO to load: ");
                    i.append(str);
                    str = i.toString();
                    Log.e(TAG, str);
                    throw new UnsatisfiedLinkError(str);
                }
                return;
            }
            i = TAG;
            threadPolicy = new StringBuilder();
            threadPolicy.append("Could not load: ");
            threadPolicy.append(str);
            threadPolicy.append(" because no SO source exists");
            Log.e(i, threadPolicy.toString());
            threadPolicy = new StringBuilder();
            threadPolicy.append("couldn't find DSO to load: ");
            threadPolicy.append(str);
            throw new UnsatisfiedLinkError(threadPolicy.toString());
            sSoSourcesLock.readLock().unlock();
            throw i;
        } finally {
            i = sSoSourcesLock.readLock();
            i.unlock();
        }
    }

    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        str = str.split(":");
        Iterable arrayList = new ArrayList(str.length);
        for (String str2 : str) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    static File unpackLibraryBySoName(String str) {
        sSoSourcesLock.readLock().lock();
        int i = 0;
        while (i < sSoSources.length) {
            try {
                File unpackLibrary = sSoSources[i].unpackLibrary(str);
                if (unpackLibrary != null) {
                    return unpackLibrary;
                }
                i++;
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        sSoSourcesLock.readLock().unlock();
        throw new FileNotFoundException(str);
    }

    private static void assertInitialized() {
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                throw new RuntimeException("SoLoader.init() not yet called");
            }
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static void prependSoSource(SoSource soSource) {
        sSoSourcesLock.writeLock().lock();
        try {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Prepending to SO sources: ");
            stringBuilder.append(soSource);
            Log.d(str, stringBuilder.toString());
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            Object obj = new SoSource[(sSoSources.length + 1)];
            obj[0] = soSource;
            System.arraycopy(sSoSources, 0, obj, 1, sSoSources.length);
            sSoSources = obj;
            sSoSourcesVersion++;
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Prepended to SO sources: ");
            stringBuilder.append(soSource);
            Log.d(str, stringBuilder.toString());
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    public static String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        try {
            assertInitialized();
            Log.d(TAG, "makeLdLibraryPath");
            Iterable arrayList = new ArrayList();
            SoSource[] soSourceArr = sSoSources;
            for (SoSource addToLdLibraryPath : soSourceArr) {
                addToLdLibraryPath.addToLdLibraryPath(arrayList);
            }
            String join = TextUtils.join(":", arrayList);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("makeLdLibraryPath final path: ");
            stringBuilder.append(join);
            Log.d(str, stringBuilder.toString());
            return join;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean areSoSourcesAbisSupported() {
        sSoSourcesLock.readLock().lock();
        boolean z;
        try {
            z = false;
            if (sSoSources == null) {
                return z;
            }
            String[] supportedAbis = SysUtil.getSupportedAbis();
            for (SoSource soSourceAbis : sSoSources) {
                String[] soSourceAbis2 = soSourceAbis.getSoSourceAbis();
                int i = 0;
                while (i < soSourceAbis2.length) {
                    boolean z2 = false;
                    for (int i2 = 0; i2 < supportedAbis.length && !z2; i2++) {
                        z2 = soSourceAbis2[i].equals(supportedAbis[i2]);
                    }
                    if (z2) {
                        i++;
                    } else {
                        sSoSourcesLock.readLock().unlock();
                        return false;
                    }
                }
            }
            sSoSourcesLock.readLock().unlock();
            return true;
        } finally {
            z = sSoSourcesLock.readLock();
            z.unlock();
        }
    }

    public static void loadLibrary(String str) {
        loadLibrary(str);
    }
}

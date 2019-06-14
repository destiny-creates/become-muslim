package android.support.p019f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipFile;

/* compiled from: MultiDex */
/* renamed from: android.support.f.a */
public final class C0212a {
    /* renamed from: a */
    private static final Set<File> f528a = new HashSet();
    /* renamed from: b */
    private static final boolean f529b = C0212a.m535a(System.getProperty("java.vm.version"));

    /* compiled from: MultiDex */
    /* renamed from: android.support.f.a$a */
    private static final class C0209a {
        /* renamed from: a */
        private static final int f526a = ".zip".length();
        /* renamed from: b */
        private final C0208a f527b;

        /* compiled from: MultiDex */
        /* renamed from: android.support.f.a$a$a */
        private interface C0208a {
            /* renamed from: a */
            Object mo98a(File file, DexFile dexFile);
        }

        /* compiled from: MultiDex */
        /* renamed from: android.support.f.a$a$b */
        private static class C3140b implements C0208a {
            /* renamed from: a */
            private final Constructor<?> f8058a;

            C3140b(Class<?> cls) {
                this.f8058a = cls.getConstructor(new Class[]{File.class, ZipFile.class, DexFile.class});
                this.f8058a.setAccessible(true);
            }

            /* renamed from: a */
            public Object mo98a(File file, DexFile dexFile) {
                return this.f8058a.newInstance(new Object[]{file, new ZipFile(file), dexFile});
            }
        }

        /* compiled from: MultiDex */
        /* renamed from: android.support.f.a$a$c */
        private static class C3141c implements C0208a {
            /* renamed from: a */
            private final Constructor<?> f8059a;

            C3141c(Class<?> cls) {
                this.f8059a = cls.getConstructor(new Class[]{File.class, File.class, DexFile.class});
                this.f8059a.setAccessible(true);
            }

            /* renamed from: a */
            public Object mo98a(File file, DexFile dexFile) {
                return this.f8059a.newInstance(new Object[]{file, file, dexFile});
            }
        }

        /* compiled from: MultiDex */
        /* renamed from: android.support.f.a$a$d */
        private static class C3142d implements C0208a {
            /* renamed from: a */
            private final Constructor<?> f8060a;

            C3142d(Class<?> cls) {
                this.f8060a = cls.getConstructor(new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class});
                this.f8060a.setAccessible(true);
            }

            /* renamed from: a */
            public Object mo98a(File file, DexFile dexFile) {
                return this.f8060a.newInstance(new Object[]{file, Boolean.FALSE, file, dexFile});
            }
        }

        /* renamed from: a */
        static void m522a(ClassLoader classLoader, List<? extends File> list) {
            Object obj = C0212a.m537b(classLoader, "pathList").get(classLoader);
            Object[] a = new C0209a().m523a((List) list);
            try {
                C0212a.m539b(obj, "dexElements", a);
            } catch (Throwable e) {
                Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", e);
                C0212a.m539b(obj, "pathElements", a);
            }
        }

        private C0209a() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r2 = this;
            r2.<init>();
            r0 = "dalvik.system.DexPathList$Element";
            r0 = java.lang.Class.forName(r0);
            r1 = new android.support.f.a$a$b;	 Catch:{ NoSuchMethodException -> 0x000f }
            r1.<init>(r0);	 Catch:{ NoSuchMethodException -> 0x000f }
            goto L_0x001a;
        L_0x000f:
            r1 = new android.support.f.a$a$c;	 Catch:{ NoSuchMethodException -> 0x0015 }
            r1.<init>(r0);	 Catch:{ NoSuchMethodException -> 0x0015 }
            goto L_0x001a;
        L_0x0015:
            r1 = new android.support.f.a$a$d;
            r1.<init>(r0);
        L_0x001a:
            r2.f527b = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.f.a.a.<init>():void");
        }

        /* renamed from: a */
        private Object[] m523a(List<? extends File> list) {
            Object[] objArr = new Object[list.size()];
            for (int i = 0; i < objArr.length; i++) {
                File file = (File) list.get(i);
                objArr[i] = this.f527b.mo98a(file, DexFile.loadDex(file.getPath(), C0209a.m521a(file), 0));
            }
            return objArr;
        }

        /* renamed from: a */
        private static String m521a(File file) {
            File parentFile = file.getParentFile();
            file = file.getName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.substring(0, file.length() - f526a));
            stringBuilder.append(".dex");
            return new File(parentFile, stringBuilder.toString()).getPath();
        }
    }

    /* compiled from: MultiDex */
    /* renamed from: android.support.f.a$b */
    private static final class C0210b {
        /* renamed from: a */
        static void m524a(ClassLoader classLoader, List<? extends File> list, File file) {
            Object obj = C0212a.m537b(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            C0212a.m539b(obj, "dexElements", C0210b.m525a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > null) {
                list = arrayList.iterator();
                while (list.hasNext() != null) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) list.next());
                }
                list = C0212a.m537b(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr = (IOException[]) list.get(obj);
                if (iOExceptionArr == null) {
                    file = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    File file2 = new IOException[(arrayList.size() + iOExceptionArr.length)];
                    arrayList.toArray(file2);
                    System.arraycopy(iOExceptionArr, 0, file2, arrayList.size(), iOExceptionArr.length);
                    file = file2;
                }
                list.set(obj, file);
                classLoader = new IOException("I/O exception during makeDexElement");
                classLoader.initCause((Throwable) arrayList.get(0));
                throw classLoader;
            }
        }

        /* renamed from: a */
        private static Object[] m525a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            return (Object[]) C0212a.m538b(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    /* compiled from: MultiDex */
    /* renamed from: android.support.f.a$c */
    private static final class C0211c {
        /* renamed from: a */
        static void m526a(ClassLoader classLoader, List<? extends File> list) {
            int size = list.size();
            Field a = C0212a.m537b(classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String) a.get(classLoader));
            Object[] objArr = new String[size];
            Object[] objArr2 = new File[size];
            Object[] objArr3 = new ZipFile[size];
            Object[] objArr4 = new DexFile[size];
            list = list.listIterator();
            while (list.hasNext()) {
                File file = (File) list.next();
                String absolutePath = file.getAbsolutePath();
                stringBuilder.append(':');
                stringBuilder.append(absolutePath);
                int previousIndex = list.previousIndex();
                objArr[previousIndex] = absolutePath;
                objArr2[previousIndex] = file;
                objArr3[previousIndex] = new ZipFile(file);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(absolutePath);
                stringBuilder2.append(".dex");
                objArr4[previousIndex] = DexFile.loadDex(absolutePath, stringBuilder2.toString(), 0);
            }
            a.set(classLoader, stringBuilder.toString());
            C0212a.m539b((Object) classLoader, "mPaths", objArr);
            C0212a.m539b((Object) classLoader, "mFiles", objArr2);
            C0212a.m539b((Object) classLoader, "mZips", objArr3);
            C0212a.m539b((Object) classLoader, "mDexs", objArr4);
        }
    }

    /* renamed from: a */
    public static void m530a(Context context) {
        Log.i("MultiDex", "Installing application");
        if (f529b) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
        } else if (VERSION.SDK_INT >= 4) {
            try {
                ApplicationInfo b = C0212a.m536b(context);
                if (b == null) {
                    Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                C0212a.m531a(context, new File(b.sourceDir), new File(b.dataDir), "secondary-dexes", "", true);
                Log.i("MultiDex", "install done");
            } catch (Context context2) {
                Log.e("MultiDex", "MultiDex installation failure", context2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("MultiDex installation failed (");
                stringBuilder.append(context2.getMessage());
                stringBuilder.append(").");
                throw new RuntimeException(stringBuilder.toString());
            }
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("MultiDex installation failed. SDK ");
            stringBuilder2.append(VERSION.SDK_INT);
            stringBuilder2.append(" is unsupported. Min SDK version is ");
            stringBuilder2.append(4);
            stringBuilder2.append(".");
            throw new RuntimeException(stringBuilder2.toString());
        }
    }

    /* renamed from: a */
    private static void m531a(android.content.Context r5, java.io.File r6, java.io.File r7, java.lang.String r8, java.lang.String r9, boolean r10) {
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
        r0 = f528a;
        monitor-enter(r0);
        r1 = f528a;	 Catch:{ all -> 0x00af }
        r1 = r1.contains(r6);	 Catch:{ all -> 0x00af }
        if (r1 == 0) goto L_0x000d;	 Catch:{ all -> 0x00af }
    L_0x000b:
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        return;	 Catch:{ all -> 0x00af }
    L_0x000d:
        r1 = f528a;	 Catch:{ all -> 0x00af }
        r1.add(r6);	 Catch:{ all -> 0x00af }
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00af }
        r2 = 20;	 Catch:{ all -> 0x00af }
        if (r1 <= r2) goto L_0x0055;	 Catch:{ all -> 0x00af }
    L_0x0018:
        r1 = "MultiDex";	 Catch:{ all -> 0x00af }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00af }
        r3.<init>();	 Catch:{ all -> 0x00af }
        r4 = "MultiDex is not guaranteed to work in SDK version ";	 Catch:{ all -> 0x00af }
        r3.append(r4);	 Catch:{ all -> 0x00af }
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00af }
        r3.append(r4);	 Catch:{ all -> 0x00af }
        r4 = ": SDK version higher than ";	 Catch:{ all -> 0x00af }
        r3.append(r4);	 Catch:{ all -> 0x00af }
        r3.append(r2);	 Catch:{ all -> 0x00af }
        r2 = " should be backed by ";	 Catch:{ all -> 0x00af }
        r3.append(r2);	 Catch:{ all -> 0x00af }
        r2 = "runtime with built-in multidex capabilty but it's not the ";	 Catch:{ all -> 0x00af }
        r3.append(r2);	 Catch:{ all -> 0x00af }
        r2 = "case here: java.vm.version=\"";	 Catch:{ all -> 0x00af }
        r3.append(r2);	 Catch:{ all -> 0x00af }
        r2 = "java.vm.version";	 Catch:{ all -> 0x00af }
        r2 = java.lang.System.getProperty(r2);	 Catch:{ all -> 0x00af }
        r3.append(r2);	 Catch:{ all -> 0x00af }
        r2 = "\"";	 Catch:{ all -> 0x00af }
        r3.append(r2);	 Catch:{ all -> 0x00af }
        r2 = r3.toString();	 Catch:{ all -> 0x00af }
        android.util.Log.w(r1, r2);	 Catch:{ all -> 0x00af }
    L_0x0055:
        r1 = r5.getClassLoader();	 Catch:{ RuntimeException -> 0x00a5 }
        if (r1 != 0) goto L_0x0064;
    L_0x005b:
        r5 = "MultiDex";	 Catch:{ all -> 0x00af }
        r6 = "Context class loader is null. Must be running in test mode. Skip patching.";	 Catch:{ all -> 0x00af }
        android.util.Log.e(r5, r6);	 Catch:{ all -> 0x00af }
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        return;
    L_0x0064:
        android.support.p019f.C0212a.m540c(r5);	 Catch:{ Throwable -> 0x0068 }
        goto L_0x0070;
    L_0x0068:
        r2 = move-exception;
        r3 = "MultiDex";	 Catch:{ all -> 0x00af }
        r4 = "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.";	 Catch:{ all -> 0x00af }
        android.util.Log.w(r3, r4, r2);	 Catch:{ all -> 0x00af }
    L_0x0070:
        r7 = android.support.p019f.C0212a.m527a(r5, r7, r8);	 Catch:{ all -> 0x00af }
        r8 = new android.support.f.c;	 Catch:{ all -> 0x00af }
        r8.<init>(r6, r7);	 Catch:{ all -> 0x00af }
        r6 = 0;
        r2 = 0;
        r2 = r8.m551a(r5, r9, r2);	 Catch:{ all -> 0x00a0 }
        android.support.p019f.C0212a.m533a(r1, r7, r2);	 Catch:{ IOException -> 0x0083 }
        goto L_0x0095;
    L_0x0083:
        r2 = move-exception;
        if (r10 == 0) goto L_0x009f;
    L_0x0086:
        r10 = "MultiDex";	 Catch:{ all -> 0x00a0 }
        r3 = "Failed to install extracted secondary dex files, retrying with forced extraction";	 Catch:{ all -> 0x00a0 }
        android.util.Log.w(r10, r3, r2);	 Catch:{ all -> 0x00a0 }
        r10 = 1;	 Catch:{ all -> 0x00a0 }
        r5 = r8.m551a(r5, r9, r10);	 Catch:{ all -> 0x00a0 }
        android.support.p019f.C0212a.m533a(r1, r7, r5);	 Catch:{ all -> 0x00a0 }
    L_0x0095:
        r8.close();	 Catch:{ IOException -> 0x0099 }
        goto L_0x009a;
    L_0x0099:
        r6 = move-exception;
    L_0x009a:
        if (r6 != 0) goto L_0x009e;
    L_0x009c:
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        return;	 Catch:{ all -> 0x00af }
    L_0x009e:
        throw r6;	 Catch:{ all -> 0x00af }
    L_0x009f:
        throw r2;	 Catch:{ all -> 0x00a0 }
    L_0x00a0:
        r5 = move-exception;
        r8.close();	 Catch:{ IOException -> 0x00a4 }
    L_0x00a4:
        throw r5;	 Catch:{ all -> 0x00af }
    L_0x00a5:
        r5 = move-exception;	 Catch:{ all -> 0x00af }
        r6 = "MultiDex";	 Catch:{ all -> 0x00af }
        r7 = "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.";	 Catch:{ all -> 0x00af }
        android.util.Log.w(r6, r7, r5);	 Catch:{ all -> 0x00af }
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        return;	 Catch:{ all -> 0x00af }
    L_0x00af:
        r5 = move-exception;	 Catch:{ all -> 0x00af }
        monitor-exit(r0);	 Catch:{ all -> 0x00af }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.f.a.a(android.content.Context, java.io.File, java.io.File, java.lang.String, java.lang.String, boolean):void");
    }

    /* renamed from: b */
    private static ApplicationInfo m536b(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (Context context2) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", context2);
            return null;
        }
    }

    /* renamed from: a */
    static boolean m535a(java.lang.String r5) {
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
        r0 = 0;
        if (r5 == 0) goto L_0x002c;
    L_0x0003:
        r1 = "(\\d+)\\.(\\d+)(\\.\\d+)?";
        r1 = java.util.regex.Pattern.compile(r1);
        r1 = r1.matcher(r5);
        r2 = r1.matches();
        if (r2 == 0) goto L_0x002c;
    L_0x0013:
        r2 = 1;
        r3 = r1.group(r2);	 Catch:{ NumberFormatException -> 0x002c }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x002c }
        r4 = 2;	 Catch:{ NumberFormatException -> 0x002c }
        r1 = r1.group(r4);	 Catch:{ NumberFormatException -> 0x002c }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x002c }
        if (r3 > r4) goto L_0x002b;
    L_0x0027:
        if (r3 != r4) goto L_0x002c;
    L_0x0029:
        if (r1 < r2) goto L_0x002c;
    L_0x002b:
        r0 = 1;
    L_0x002c:
        r1 = "MultiDex";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "VM with version ";
        r2.append(r3);
        r2.append(r5);
        if (r0 == 0) goto L_0x0040;
    L_0x003d:
        r5 = " has multidex support";
        goto L_0x0042;
    L_0x0040:
        r5 = " does not have multidex support";
    L_0x0042:
        r2.append(r5);
        r5 = r2.toString();
        android.util.Log.i(r1, r5);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.f.a.a(java.lang.String):boolean");
    }

    /* renamed from: a */
    private static void m533a(ClassLoader classLoader, File file, List<? extends File> list) {
        if (!list.isEmpty()) {
            if (VERSION.SDK_INT >= 19) {
                C0210b.m524a(classLoader, list, file);
            } else if (VERSION.SDK_INT >= 14) {
                C0209a.m522a(classLoader, list);
            } else {
                C0211c.m526a(classLoader, list);
            }
        }
    }

    /* renamed from: b */
    private static java.lang.reflect.Field m537b(java.lang.Object r3, java.lang.String r4) {
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
        r0 = r3.getClass();
    L_0x0004:
        if (r0 == 0) goto L_0x001a;
    L_0x0006:
        r1 = r0.getDeclaredField(r4);	 Catch:{ NoSuchFieldException -> 0x0015 }
        r2 = r1.isAccessible();	 Catch:{ NoSuchFieldException -> 0x0015 }
        if (r2 != 0) goto L_0x0014;	 Catch:{ NoSuchFieldException -> 0x0015 }
    L_0x0010:
        r2 = 1;	 Catch:{ NoSuchFieldException -> 0x0015 }
        r1.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x0015 }
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = r0.getSuperclass();
        goto L_0x0004;
    L_0x001a:
        r0 = new java.lang.NoSuchFieldException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Field ";
        r1.append(r2);
        r1.append(r4);
        r4 = " not found in ";
        r1.append(r4);
        r3 = r3.getClass();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.f.a.b(java.lang.Object, java.lang.String):java.lang.reflect.Field");
    }

    /* renamed from: b */
    private static java.lang.reflect.Method m538b(java.lang.Object r3, java.lang.String r4, java.lang.Class<?>... r5) {
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
        r0 = r3.getClass();
    L_0x0004:
        if (r0 == 0) goto L_0x001a;
    L_0x0006:
        r1 = r0.getDeclaredMethod(r4, r5);	 Catch:{ NoSuchMethodException -> 0x0015 }
        r2 = r1.isAccessible();	 Catch:{ NoSuchMethodException -> 0x0015 }
        if (r2 != 0) goto L_0x0014;	 Catch:{ NoSuchMethodException -> 0x0015 }
    L_0x0010:
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r1.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x0015 }
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = r0.getSuperclass();
        goto L_0x0004;
    L_0x001a:
        r0 = new java.lang.NoSuchMethodException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Method ";
        r1.append(r2);
        r1.append(r4);
        r4 = " with parameters ";
        r1.append(r4);
        r4 = java.util.Arrays.asList(r5);
        r1.append(r4);
        r4 = " not found in ";
        r1.append(r4);
        r3 = r3.getClass();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.f.a.b(java.lang.Object, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* renamed from: b */
    private static void m539b(Object obj, String str, Object[] objArr) {
        str = C0212a.m537b(obj, str);
        Object[] objArr2 = (Object[]) str.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        str.set(obj, objArr3);
    }

    /* renamed from: c */
    private static void m540c(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory() != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Clearing old secondary dex dir (");
            stringBuilder.append(file.getPath());
            stringBuilder.append(").");
            Log.i("MultiDex", stringBuilder.toString());
            context = file.listFiles();
            if (context == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to list secondary dex dir content (");
                stringBuilder.append(file.getPath());
                stringBuilder.append(").");
                Log.w("MultiDex", stringBuilder.toString());
                return;
            }
            for (File file2 : context) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Trying to delete old file ");
                stringBuilder2.append(file2.getPath());
                stringBuilder2.append(" of size ");
                stringBuilder2.append(file2.length());
                Log.i("MultiDex", stringBuilder2.toString());
                if (file2.delete()) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Deleted old file ");
                    stringBuilder2.append(file2.getPath());
                    Log.i("MultiDex", stringBuilder2.toString());
                } else {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Failed to delete old file ");
                    stringBuilder2.append(file2.getPath());
                    Log.w("MultiDex", stringBuilder2.toString());
                }
            }
            if (file.delete() == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to delete secondary dex dir ");
                stringBuilder.append(file.getPath());
                Log.w("MultiDex", stringBuilder.toString());
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Deleted old secondary dex dir ");
                stringBuilder.append(file.getPath());
                Log.i("MultiDex", stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    private static java.io.File m527a(android.content.Context r2, java.io.File r3, java.lang.String r4) {
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
        r0 = new java.io.File;
        r1 = "code_cache";
        r0.<init>(r3, r1);
        android.support.p019f.C0212a.m532a(r0);	 Catch:{ IOException -> 0x000b }
        goto L_0x0019;
    L_0x000b:
        r0 = new java.io.File;
        r2 = r2.getFilesDir();
        r3 = "code_cache";
        r0.<init>(r2, r3);
        android.support.p019f.C0212a.m532a(r0);
    L_0x0019:
        r2 = new java.io.File;
        r2.<init>(r0, r4);
        android.support.p019f.C0212a.m532a(r2);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.f.a.a(android.content.Context, java.io.File, java.lang.String):java.io.File");
    }

    /* renamed from: a */
    private static void m532a(File file) {
        file.mkdir();
        if (!file.isDirectory()) {
            StringBuilder stringBuilder;
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Failed to create dir ");
                stringBuilder2.append(file.getPath());
                stringBuilder2.append(". Parent file is null.");
                Log.e("MultiDex", stringBuilder2.toString());
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to create dir ");
                stringBuilder.append(file.getPath());
                stringBuilder.append(". parent file is a dir ");
                stringBuilder.append(parentFile.isDirectory());
                stringBuilder.append(", a file ");
                stringBuilder.append(parentFile.isFile());
                stringBuilder.append(", exists ");
                stringBuilder.append(parentFile.exists());
                stringBuilder.append(", readable ");
                stringBuilder.append(parentFile.canRead());
                stringBuilder.append(", writable ");
                stringBuilder.append(parentFile.canWrite());
                Log.e("MultiDex", stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to create directory ");
            stringBuilder.append(file.getPath());
            throw new IOException(stringBuilder.toString());
        }
    }
}

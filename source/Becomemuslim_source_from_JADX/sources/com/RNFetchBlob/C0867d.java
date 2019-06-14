package com.RNFetchBlob;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Base64;
import com.RNFetchBlob.p049b.C0861a;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.stetho.common.Utf8Charset;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import versioned.host.exp.exponent.modules.api.viewshot.ViewShot.Results;

/* compiled from: RNFetchBlobFS */
/* renamed from: com.RNFetchBlob.d */
public class C0867d {
    /* renamed from: f */
    static HashMap<String, C0867d> f2419f = new HashMap();
    /* renamed from: a */
    ReactApplicationContext f2420a;
    /* renamed from: b */
    RCTDeviceEventEmitter f2421b;
    /* renamed from: c */
    String f2422c = Results.BASE_64;
    /* renamed from: d */
    boolean f2423d = false;
    /* renamed from: e */
    OutputStream f2424e = null;

    C0867d(ReactApplicationContext reactApplicationContext) {
        this.f2420a = reactApplicationContext;
        this.f2421b = (RCTDeviceEventEmitter) reactApplicationContext.getJSModule(RCTDeviceEventEmitter.class);
    }

    /* renamed from: a */
    public static void m3086a(String str, String str2, String str3, boolean z, Promise promise) {
        try {
            int i;
            File file = new File(str);
            str = file.getParentFile();
            if (!str.exists()) {
                str.mkdirs();
            }
            str = new FileOutputStream(file, z);
            if (str2.equalsIgnoreCase("uri")) {
                str2 = C0867d.m3097e(str3);
                str3 = new File(str2);
                if (str3.exists()) {
                    str2 = new FileInputStream(str3);
                    str3 = new byte[10240];
                    i = 0;
                    while (true) {
                        int read = str2.read(str3);
                        if (read <= 0) {
                            break;
                        }
                        str.write(str3, false, read);
                        i += read;
                    }
                    str2.close();
                } else {
                    z = new StringBuilder();
                    z.append("source file : ");
                    z.append(str2);
                    z.append("not exists");
                    promise.reject("RNfetchBlob writeFileError", z.toString());
                    str.close();
                    return;
                }
            }
            str2 = C0867d.m3087a(str3, str2);
            str.write(str2);
            i = str2.length;
            str.close();
            promise.resolve(Integer.valueOf(i));
        } catch (String str4) {
            promise.reject("RNFetchBlob writeFileError", str4.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    public static void m3079a(String str, ReadableArray readableArray, boolean z, Promise promise) {
        try {
            File file = new File(str);
            str = file.getParentFile();
            if (!str.exists()) {
                str.mkdirs();
            }
            str = new FileOutputStream(file, z);
            z = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                z[i] = (byte) readableArray.getInt(i);
            }
            str.write(z);
            str.close();
            promise.resolve(Integer.valueOf(readableArray.size()));
        } catch (String str2) {
            promise.reject("RNFetchBlob writeFileError", str2.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    public static void m3082a(String str, String str2, Promise promise) {
        int length;
        byte[] bArr;
        String e = C0867d.m3097e(str);
        if (e != null) {
            str = e;
        }
        int i = 0;
        if (e != null) {
            try {
                if (e.startsWith("bundle-assets://")) {
                    str = str.replace("bundle-assets://", "");
                    length = (int) RNFetchBlob.RCTContext.getAssets().openFd(str).getLength();
                    bArr = new byte[length];
                    str = RNFetchBlob.RCTContext.getAssets().open(str);
                    str.read(bArr, 0, length);
                    str.close();
                    str = str2.toLowerCase();
                    length = str.hashCode();
                    if (length == -1396204209) {
                        if (length == 3600241) {
                            if (length != 93106001) {
                                if (str.equals("ascii") != null) {
                                    str = true;
                                    switch (str) {
                                        case null:
                                            promise.resolve(Base64.encodeToString(bArr, 2));
                                            return;
                                        case 1:
                                            str = Arguments.createArray();
                                            str2 = bArr.length;
                                            while (i < str2) {
                                                str.pushInt(bArr[i]);
                                                i++;
                                            }
                                            promise.resolve(str);
                                            return;
                                        case 2:
                                            promise.resolve(new String(bArr));
                                            return;
                                        default:
                                            promise.resolve(new String(bArr));
                                            return;
                                    }
                                }
                            }
                        } else if (str.equals("utf8") != null) {
                            str = 2;
                            switch (str) {
                                case null:
                                    promise.resolve(Base64.encodeToString(bArr, 2));
                                    return;
                                case 1:
                                    str = Arguments.createArray();
                                    str2 = bArr.length;
                                    while (i < str2) {
                                        str.pushInt(bArr[i]);
                                        i++;
                                    }
                                    promise.resolve(str);
                                    return;
                                case 2:
                                    promise.resolve(new String(bArr));
                                    return;
                                default:
                                    promise.resolve(new String(bArr));
                                    return;
                            }
                        }
                    } else if (str.equals(Results.BASE_64) != null) {
                        str = null;
                        switch (str) {
                            case null:
                                promise.resolve(Base64.encodeToString(bArr, 2));
                                return;
                            case 1:
                                str = Arguments.createArray();
                                str2 = bArr.length;
                                while (i < str2) {
                                    str.pushInt(bArr[i]);
                                    i++;
                                }
                                promise.resolve(str);
                                return;
                            case 2:
                                promise.resolve(new String(bArr));
                                return;
                            default:
                                promise.resolve(new String(bArr));
                                return;
                        }
                    }
                    str = -1;
                    switch (str) {
                        case null:
                            promise.resolve(Base64.encodeToString(bArr, 2));
                            return;
                        case 1:
                            str = Arguments.createArray();
                            str2 = bArr.length;
                            while (i < str2) {
                                str.pushInt(bArr[i]);
                                i++;
                            }
                            promise.resolve(str);
                            return;
                        case 2:
                            promise.resolve(new String(bArr));
                            return;
                        default:
                            promise.resolve(new String(bArr));
                            return;
                    }
                }
            } catch (String str3) {
                promise.reject("ReadFile Error", str3.getLocalizedMessage());
                return;
            }
        }
        if (e == null) {
            str3 = RNFetchBlob.RCTContext.getContentResolver().openInputStream(Uri.parse(str3));
            bArr = new byte[str3.available()];
            str3.read(bArr);
            str3.close();
        } else {
            File file = new File(str3);
            bArr = new byte[((int) file.length())];
            str3 = new FileInputStream(file);
            str3.read(bArr);
            str3.close();
        }
        str3 = str2.toLowerCase();
        length = str3.hashCode();
        if (length == -1396204209) {
            if (str3.equals(Results.BASE_64) != null) {
                str3 = null;
                switch (str3) {
                    case null:
                        promise.resolve(Base64.encodeToString(bArr, 2));
                        return;
                    case 1:
                        str3 = Arguments.createArray();
                        str2 = bArr.length;
                        while (i < str2) {
                            str3.pushInt(bArr[i]);
                            i++;
                        }
                        promise.resolve(str3);
                        return;
                    case 2:
                        promise.resolve(new String(bArr));
                        return;
                    default:
                        promise.resolve(new String(bArr));
                        return;
                }
            }
        } else if (length == 3600241) {
            if (str3.equals("utf8") != null) {
                str3 = 2;
                switch (str3) {
                    case null:
                        promise.resolve(Base64.encodeToString(bArr, 2));
                        return;
                    case 1:
                        str3 = Arguments.createArray();
                        str2 = bArr.length;
                        while (i < str2) {
                            str3.pushInt(bArr[i]);
                            i++;
                        }
                        promise.resolve(str3);
                        return;
                    case 2:
                        promise.resolve(new String(bArr));
                        return;
                    default:
                        promise.resolve(new String(bArr));
                        return;
                }
            }
        } else if (length != 93106001) {
            if (str3.equals("ascii") != null) {
                str3 = true;
                switch (str3) {
                    case null:
                        promise.resolve(Base64.encodeToString(bArr, 2));
                        return;
                    case 1:
                        str3 = Arguments.createArray();
                        str2 = bArr.length;
                        while (i < str2) {
                            str3.pushInt(bArr[i]);
                            i++;
                        }
                        promise.resolve(str3);
                        return;
                    case 2:
                        promise.resolve(new String(bArr));
                        return;
                    default:
                        promise.resolve(new String(bArr));
                        return;
                }
            }
        }
        str3 = -1;
        switch (str3) {
            case null:
                promise.resolve(Base64.encodeToString(bArr, 2));
                return;
            case 1:
                str3 = Arguments.createArray();
                str2 = bArr.length;
                while (i < str2) {
                    str3.pushInt(bArr[i]);
                    i++;
                }
                promise.resolve(str3);
                return;
            case 2:
                promise.resolve(new String(bArr));
                return;
            default:
                promise.resolve(new String(bArr));
                return;
        }
    }

    /* renamed from: a */
    public static Map<String, Object> m3073a(ReactApplicationContext reactApplicationContext) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("DocumentDir", reactApplicationContext.getFilesDir().getAbsolutePath());
        hashMap.put("CacheDir", reactApplicationContext.getCacheDir().getAbsolutePath());
        hashMap.put("DCIMDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        hashMap.put("PictureDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        hashMap.put("MusicDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        hashMap.put("DownloadDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        hashMap.put("MovieDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        hashMap.put("RingtoneDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath());
        if (Environment.getExternalStorageState().equals("mounted")) {
            hashMap.put("SDCardDir", Environment.getExternalStorageDirectory().getAbsolutePath());
            File externalFilesDir = reactApplicationContext.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                hashMap.put("SDCardApplicationDir", externalFilesDir.getParentFile().getAbsolutePath());
            }
        }
        hashMap.put("MainBundleDir", reactApplicationContext.getApplicationInfo().dataDir);
        return hashMap;
    }

    /* renamed from: a */
    public static String m3072a(ReactApplicationContext reactApplicationContext, String str) {
        reactApplicationContext = new StringBuilder();
        reactApplicationContext.append(RNFetchBlob.RCTContext.getFilesDir());
        reactApplicationContext.append("/RNFetchBlobTmp_");
        reactApplicationContext.append(str);
        return reactApplicationContext.toString();
    }

    /* renamed from: a */
    public void m3101a(String str, String str2, int i, int i2, String str3) {
        String e = C0867d.m3097e(str);
        if (e != null) {
            str = e;
        }
        try {
            int i3 = str2.equalsIgnoreCase(Results.BASE_64) ? 4095 : 4096;
            if (i <= 0) {
                i = i3;
            }
            if (e != null && str.startsWith("bundle-assets://")) {
                str = RNFetchBlob.RCTContext.getAssets().open(str.replace("bundle-assets://", ""));
            } else if (e == null) {
                str = RNFetchBlob.RCTContext.getContentResolver().openInputStream(Uri.parse(str));
            } else {
                str = new FileInputStream(new File(str));
            }
            byte[] bArr = new byte[i];
            int i4 = 0;
            if (str2.equalsIgnoreCase("utf8")) {
                i = Charset.forName(Utf8Charset.NAME).newEncoder();
                while (true) {
                    i3 = str.read(bArr);
                    if (i3 == -1) {
                        break;
                    }
                    i.encode(ByteBuffer.wrap(bArr).asCharBuffer());
                    m3084a(str3, "data", new String(bArr, 0, i3));
                    if (i2 > 0) {
                        SystemClock.sleep((long) i2);
                    }
                }
            } else if (str2.equalsIgnoreCase("ascii")) {
                while (true) {
                    i = str.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    WritableArray createArray = Arguments.createArray();
                    for (int i5 = 0; i5 < i; i5++) {
                        createArray.pushInt(bArr[i5]);
                    }
                    m3083a(str3, "data", createArray);
                    if (i2 > 0) {
                        SystemClock.sleep((long) i2);
                    }
                }
            } else if (str2.equalsIgnoreCase(Results.BASE_64)) {
                while (true) {
                    i3 = str.read(bArr);
                    if (i3 == -1) {
                        break;
                    }
                    if (i3 < i) {
                        byte[] bArr2 = new byte[i3];
                        for (int i6 = 0; i6 < i3; i6++) {
                            bArr2[i6] = bArr[i6];
                        }
                        m3084a(str3, "data", Base64.encodeToString(bArr2, 2));
                    } else {
                        m3084a(str3, "data", Base64.encodeToString(bArr, 2));
                    }
                    if (i2 > 0) {
                        SystemClock.sleep((long) i2);
                    }
                }
            } else {
                i = new StringBuilder();
                i.append("unrecognized encoding `");
                i.append(str2);
                i.append("`");
                m3084a(str3, "error", i.toString());
                i4 = 1;
            }
            if (i4 == 0) {
                m3084a(str3, ViewProps.END, "");
            }
            str.close();
        } catch (String str4) {
            i2 = new StringBuilder();
            i2.append("Failed to convert data to ");
            i2.append(str2);
            i2.append(" encoded string, this might due to the source data is not able to convert using this encoding.");
            m3084a(str3, "warn", i2.toString());
            str4.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m3102a(String str, String str2, boolean z, Callback callback) {
        File file = new File(str);
        if (file.exists()) {
            if (!file.isDirectory()) {
                try {
                    OutputStream fileOutputStream = new FileOutputStream(str, z);
                    this.f2422c = str2;
                    this.f2423d = z;
                    f2419f.put(UUID.randomUUID().toString(), this);
                    this.f2424e = fileOutputStream;
                    callback.invoke(new Object[]{null, str2});
                } catch (String str22) {
                    z = new Object[1];
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("write stream error: failed to create write stream at path `");
                    stringBuilder.append(str);
                    stringBuilder.append("` ");
                    stringBuilder.append(str22.getLocalizedMessage());
                    z[0] = stringBuilder.toString();
                    callback.invoke(z);
                }
                return;
            }
        }
        str22 = new Object[1];
        z = new StringBuilder();
        z.append("write stream error: target path `");
        z.append(str);
        z.append("` may not exists or it's a folder");
        str22[0] = z.toString();
        callback.invoke(str22);
    }

    /* renamed from: a */
    static void m3081a(String str, String str2, Callback callback) {
        C0867d c0867d = (C0867d) f2419f.get(str);
        try {
            c0867d.f2424e.write(C0867d.m3087a(str2, c0867d.f2422c));
            callback.invoke(new Object[0]);
        } catch (String str3) {
            callback.invoke(str3.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    static void m3078a(String str, ReadableArray readableArray, Callback callback) {
        try {
            str = ((C0867d) f2419f.get(str)).f2424e;
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            str.write(bArr);
            callback.invoke(new Object[0]);
        } catch (String str2) {
            callback.invoke(new Object[]{str2.getLocalizedMessage()});
        }
    }

    /* renamed from: a */
    static void m3077a(String str, Callback callback) {
        try {
            OutputStream outputStream = ((C0867d) f2419f.get(str)).f2424e;
            f2419f.remove(str);
            outputStream.close();
            callback.invoke(new Object[0]);
        } catch (String str2) {
            callback.invoke(str2.getLocalizedMessage());
        }
    }

    /* renamed from: b */
    static void m3089b(String str, Callback callback) {
        try {
            C0867d.m3076a(new File(str));
            callback.invoke(new Object[]{null, Boolean.valueOf(true)});
        } catch (String str2) {
            callback.invoke(str2.getLocalizedMessage(), Boolean.valueOf(false));
        }
    }

    /* renamed from: a */
    static void m3076a(File file) {
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                C0867d.m3076a(a);
            }
        }
        file.delete();
    }

    /* renamed from: c */
    static void m3092c(String str, Callback callback) {
        File file = new File(str);
        if (file.exists()) {
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mkdir error: failed to create folder at `");
            stringBuilder.append(str);
            stringBuilder.append("` folder already exists");
            objArr[0] = stringBuilder.toString();
            callback.invoke(objArr);
            return;
        }
        file.mkdirs();
        callback.invoke(new Object[0]);
    }

    /* renamed from: b */
    static void m3091b(String str, String str2, Callback callback) {
        OutputStream fileOutputStream;
        str = C0867d.m3097e(str);
        InputStream inputStream = null;
        try {
            if (C0867d.m3094c(str)) {
                if (!new File(str2).exists()) {
                    new File(str2).createNewFile();
                }
                str = C0867d.m3088b(str);
                try {
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        str2 = new byte[10240];
                        while (true) {
                            int read = str.read(str2);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(str2, 0, read);
                        }
                        if (str != null) {
                            try {
                                str.close();
                            } catch (String str3) {
                                str2 = new Object[]{str3.getLocalizedMessage()};
                                callback.invoke(str2);
                            }
                        }
                        fileOutputStream.close();
                        callback.invoke(new Object[0]);
                    } catch (Exception e) {
                        str2 = e;
                        inputStream = str3;
                        str3 = str2;
                        try {
                            callback.invoke(new Object[]{str3.getLocalizedMessage()});
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (String str32) {
                                    str2 = new Object[]{str32.getLocalizedMessage()};
                                    callback.invoke(str2);
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            callback.invoke(new Object[0]);
                        } catch (Throwable th) {
                            str32 = th;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (String str22) {
                                    callback.invoke(str22.getLocalizedMessage());
                                    throw str32;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            callback.invoke(new Object[0]);
                            throw str32;
                        }
                    } catch (Throwable th2) {
                        str22 = th2;
                        inputStream = str32;
                        str32 = str22;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        callback.invoke(new Object[0]);
                        throw str32;
                    }
                } catch (Exception e2) {
                    str22 = e2;
                    fileOutputStream = null;
                    inputStream = str32;
                    str32 = str22;
                    callback.invoke(new Object[]{str32.getLocalizedMessage()});
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    callback.invoke(new Object[0]);
                } catch (Throwable th3) {
                    str22 = th3;
                    fileOutputStream = null;
                    inputStream = str32;
                    str32 = str22;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    callback.invoke(new Object[0]);
                    throw str32;
                }
            }
            str22 = new Object[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cp error: source file at path`");
            stringBuilder.append(str32);
            stringBuilder.append("` not exists");
            str22[0] = stringBuilder.toString();
            callback.invoke(str22);
            try {
                callback.invoke(new Object[0]);
            } catch (String str322) {
                callback.invoke(new Object[]{str322.getLocalizedMessage()});
            }
        } catch (Exception e3) {
            str322 = e3;
            fileOutputStream = null;
            callback.invoke(new Object[]{str322.getLocalizedMessage()});
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            callback.invoke(new Object[0]);
        } catch (Throwable th4) {
            str322 = th4;
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            callback.invoke(new Object[0]);
            throw str322;
        }
    }

    /* renamed from: c */
    static void m3093c(String str, String str2, Callback callback) {
        File file = new File(str);
        if (file.exists()) {
            file.renameTo(new File(str2));
            callback.invoke(new Object[0]);
            return;
        }
        str2 = new Object[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mv error: source file at path `");
        stringBuilder.append(str);
        stringBuilder.append("` does not exists");
        str2[0] = stringBuilder.toString();
        callback.invoke(str2);
    }

    /* renamed from: d */
    static void m3095d(java.lang.String r5, com.facebook.react.bridge.Callback r6) {
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
        r0 = com.RNFetchBlob.C0867d.m3096d(r5);
        r1 = 2;
        r2 = 1;
        r3 = 0;
        if (r0 == 0) goto L_0x003e;
    L_0x0009:
        r0 = "bundle-assets://";	 Catch:{ IOException -> 0x002c }
        r4 = "";	 Catch:{ IOException -> 0x002c }
        r5 = r5.replace(r0, r4);	 Catch:{ IOException -> 0x002c }
        r0 = com.RNFetchBlob.RNFetchBlob.RCTContext;	 Catch:{ IOException -> 0x002c }
        r0 = r0.getAssets();	 Catch:{ IOException -> 0x002c }
        r0.openFd(r5);	 Catch:{ IOException -> 0x002c }
        r5 = new java.lang.Object[r1];	 Catch:{ IOException -> 0x002c }
        r0 = java.lang.Boolean.valueOf(r2);	 Catch:{ IOException -> 0x002c }
        r5[r3] = r0;	 Catch:{ IOException -> 0x002c }
        r0 = java.lang.Boolean.valueOf(r3);	 Catch:{ IOException -> 0x002c }
        r5[r2] = r0;	 Catch:{ IOException -> 0x002c }
        r6.invoke(r5);	 Catch:{ IOException -> 0x002c }
        goto L_0x0065;
    L_0x002c:
        r5 = new java.lang.Object[r1];
        r0 = java.lang.Boolean.valueOf(r3);
        r5[r3] = r0;
        r0 = java.lang.Boolean.valueOf(r3);
        r5[r2] = r0;
        r6.invoke(r5);
        goto L_0x0065;
    L_0x003e:
        r5 = com.RNFetchBlob.C0867d.m3097e(r5);
        r0 = new java.io.File;
        r0.<init>(r5);
        r0 = r0.exists();
        r4 = new java.io.File;
        r4.<init>(r5);
        r5 = r4.isDirectory();
        r1 = new java.lang.Object[r1];
        r0 = java.lang.Boolean.valueOf(r0);
        r1[r3] = r0;
        r5 = java.lang.Boolean.valueOf(r5);
        r1[r2] = r5;
        r6.invoke(r1);
    L_0x0065:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.d.d(java.lang.String, com.facebook.react.bridge.Callback):void");
    }

    /* renamed from: e */
    static void m3098e(String str, Callback callback) {
        str = C0867d.m3097e(str);
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory()) {
                str = new File(str).list();
                WritableArray createArray = Arguments.createArray();
                for (String pushString : str) {
                    createArray.pushString(pushString);
                }
                callback.invoke(new Object[]{null, createArray});
                return;
            }
        }
        Object[] objArr = new Object[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ls error: failed to list path `");
        stringBuilder.append(str);
        stringBuilder.append("` for it is not exist or it is not a folder");
        objArr[0] = stringBuilder.toString();
        callback.invoke(objArr);
    }

    /* renamed from: a */
    public static void m3080a(String str, String str2, int i, int i2, String str3, Promise promise) {
        String str4 = str2;
        Promise promise2 = promise;
        try {
            String e = C0867d.m3097e(str);
            File file = new File(e);
            if (file.exists()) {
                long j = (long) i;
                long min = Math.min(file.length(), (long) i2) - j;
                FileInputStream fileInputStream = new FileInputStream(new File(e));
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str4));
                fileInputStream.skip(j);
                int i3 = 10240;
                byte[] bArr = new byte[10240];
                long j2 = 0;
                while (j2 < min) {
                    long read = (long) fileInputStream.read(bArr, 0, i3);
                    byte[] bArr2 = bArr;
                    j = min - j2;
                    if (read <= 0) {
                        break;
                    }
                    bArr = bArr2;
                    fileOutputStream.write(bArr, 0, (int) Math.min(j, read));
                    j2 += read;
                    i3 = 10240;
                }
                fileInputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                promise2.resolve(str4);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("source file : ");
            stringBuilder.append(e);
            stringBuilder.append(" not exists");
            promise2.reject("RNFetchBlob.slice error", stringBuilder.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            promise2.reject(e2.getLocalizedMessage());
        }
    }

    /* renamed from: f */
    static void m3099f(String str, final Callback callback) {
        str = C0867d.m3097e(str);
        new AsyncTask<String, Integer, Integer>() {
            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m3069a((String[]) objArr);
            }

            /* renamed from: a */
            protected Integer m3069a(String... strArr) {
                WritableArray createArray = Arguments.createArray();
                if (strArr[0] == null) {
                    callback.invoke("lstat error: the path specified for lstat is either `null` or `undefined`.");
                    return Integer.valueOf(0);
                }
                File file = new File(strArr[0]);
                if (file.exists()) {
                    if (file.isDirectory() != null) {
                        for (String str : file.list()) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(file.getPath());
                            stringBuilder.append("/");
                            stringBuilder.append(str);
                            createArray.pushMap(C0867d.m3071a(stringBuilder.toString()));
                        }
                    } else {
                        createArray.pushMap(C0867d.m3071a(file.getAbsolutePath()));
                    }
                    callback.invoke(null, createArray);
                    return Integer.valueOf(0);
                }
                Callback callback = callback;
                Object[] objArr = new Object[1];
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("lstat error: failed to list path `");
                stringBuilder2.append(strArr[0]);
                stringBuilder2.append("` for it is not exist or it is not a folder");
                objArr[0] = stringBuilder2.toString();
                callback.invoke(objArr);
                return Integer.valueOf(0);
            }
        }.execute(new String[]{str});
    }

    /* renamed from: g */
    static void m3100g(String str, Callback callback) {
        try {
            str = C0867d.m3097e(str);
            if (C0867d.m3071a(str) == null) {
                Object[] objArr = new Object[2];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("stat error: failed to list path `");
                stringBuilder.append(str);
                stringBuilder.append("` for it is not exist or it is not a folder");
                objArr[0] = stringBuilder.toString();
                objArr[1] = null;
                callback.invoke(objArr);
                return;
            }
            callback.invoke(new Object[]{null, C0867d.m3071a(str)});
        } catch (String str2) {
            callback.invoke(str2.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    static com.facebook.react.bridge.WritableMap m3071a(java.lang.String r5) {
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
        r5 = com.RNFetchBlob.C0867d.m3097e(r5);	 Catch:{ Exception -> 0x008f }
        r1 = com.facebook.react.bridge.Arguments.createMap();	 Catch:{ Exception -> 0x008f }
        r2 = com.RNFetchBlob.C0867d.m3096d(r5);	 Catch:{ Exception -> 0x008f }
        if (r2 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x008f }
    L_0x000f:
        r2 = "bundle-assets://";	 Catch:{ Exception -> 0x008f }
        r3 = "";	 Catch:{ Exception -> 0x008f }
        r2 = r5.replace(r2, r3);	 Catch:{ Exception -> 0x008f }
        r3 = com.RNFetchBlob.RNFetchBlob.RCTContext;	 Catch:{ Exception -> 0x008f }
        r3 = r3.getAssets();	 Catch:{ Exception -> 0x008f }
        r3 = r3.openFd(r2);	 Catch:{ Exception -> 0x008f }
        r4 = "filename";	 Catch:{ Exception -> 0x008f }
        r1.putString(r4, r2);	 Catch:{ Exception -> 0x008f }
        r2 = "path";	 Catch:{ Exception -> 0x008f }
        r1.putString(r2, r5);	 Catch:{ Exception -> 0x008f }
        r5 = "type";	 Catch:{ Exception -> 0x008f }
        r2 = "asset";	 Catch:{ Exception -> 0x008f }
        r1.putString(r5, r2);	 Catch:{ Exception -> 0x008f }
        r5 = "size";	 Catch:{ Exception -> 0x008f }
        r2 = r3.getLength();	 Catch:{ Exception -> 0x008f }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x008f }
        r1.putString(r5, r2);	 Catch:{ Exception -> 0x008f }
        r5 = "lastModified";	 Catch:{ Exception -> 0x008f }
        r2 = 0;	 Catch:{ Exception -> 0x008f }
        r1.putInt(r5, r2);	 Catch:{ Exception -> 0x008f }
        goto L_0x008e;	 Catch:{ Exception -> 0x008f }
    L_0x0046:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x008f }
        r2.<init>(r5);	 Catch:{ Exception -> 0x008f }
        r5 = r2.exists();	 Catch:{ Exception -> 0x008f }
        if (r5 != 0) goto L_0x0052;	 Catch:{ Exception -> 0x008f }
    L_0x0051:
        return r0;	 Catch:{ Exception -> 0x008f }
    L_0x0052:
        r5 = "filename";	 Catch:{ Exception -> 0x008f }
        r3 = r2.getName();	 Catch:{ Exception -> 0x008f }
        r1.putString(r5, r3);	 Catch:{ Exception -> 0x008f }
        r5 = "path";	 Catch:{ Exception -> 0x008f }
        r3 = r2.getPath();	 Catch:{ Exception -> 0x008f }
        r1.putString(r5, r3);	 Catch:{ Exception -> 0x008f }
        r5 = "type";	 Catch:{ Exception -> 0x008f }
        r3 = r2.isDirectory();	 Catch:{ Exception -> 0x008f }
        if (r3 == 0) goto L_0x006f;	 Catch:{ Exception -> 0x008f }
    L_0x006c:
        r3 = "directory";	 Catch:{ Exception -> 0x008f }
        goto L_0x0071;	 Catch:{ Exception -> 0x008f }
    L_0x006f:
        r3 = "file";	 Catch:{ Exception -> 0x008f }
    L_0x0071:
        r1.putString(r5, r3);	 Catch:{ Exception -> 0x008f }
        r5 = "size";	 Catch:{ Exception -> 0x008f }
        r3 = r2.length();	 Catch:{ Exception -> 0x008f }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x008f }
        r1.putString(r5, r3);	 Catch:{ Exception -> 0x008f }
        r2 = r2.lastModified();	 Catch:{ Exception -> 0x008f }
        r5 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x008f }
        r2 = "lastModified";	 Catch:{ Exception -> 0x008f }
        r1.putString(r2, r5);	 Catch:{ Exception -> 0x008f }
    L_0x008e:
        return r1;
    L_0x008f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.d.a(java.lang.String):com.facebook.react.bridge.WritableMap");
    }

    /* renamed from: a */
    void m3103a(String[] strArr, String[] strArr2, final Callback callback) {
        try {
            MediaScannerConnection.scanFile(this.f2420a, strArr, strArr2, new OnScanCompletedListener(this) {
                /* renamed from: b */
                final /* synthetic */ C0867d f2417b;

                public void onScanCompleted(String str, Uri uri) {
                    callback.invoke(new Object[]{null, Boolean.valueOf(true)});
                }
            });
        } catch (String[] strArr3) {
            callback.invoke(strArr3.getLocalizedMessage(), null);
        }
    }

    /* renamed from: a */
    static void m3085a(String str, String str2, String str3, Callback callback) {
        try {
            File file = new File(str);
            boolean createNewFile = file.createNewFile();
            if (str3.equals("uri")) {
                File file2 = new File(str2.replace("RNFetchBlob-file://", ""));
                if (file2.exists() == null) {
                    str = new Object[2];
                    str[0] = "RNfetchBlob writeFileError";
                    str3 = new StringBuilder();
                    str3.append("source file : ");
                    str3.append(str2);
                    str3.append("not exists");
                    str[1] = str3.toString();
                    callback.invoke(str);
                    return;
                }
                str2 = new FileInputStream(file2);
                str3 = new FileOutputStream(file);
                byte[] bArr = new byte[10240];
                for (int read = str2.read(bArr); read > 0; read = str2.read(bArr)) {
                    str3.write(bArr, 0, read);
                }
                str2.close();
                str3.close();
            } else if (createNewFile) {
                new FileOutputStream(file).write(C0867d.m3087a(str2, str3));
            } else {
                str2 = new Object[1];
                str3 = new StringBuilder();
                str3.append("create file error: failed to create file at path `");
                str3.append(str);
                str3.append("` for its parent path may not exists, or the file already exists. If you intended to overwrite the existing file use fs.writeFile instead.");
                str2[0] = str3.toString();
                callback.invoke(str2);
                return;
            }
            callback.invoke(new Object[]{null, str});
        } catch (String str4) {
            callback.invoke(new Object[]{str4.getLocalizedMessage()});
        }
    }

    /* renamed from: b */
    static void m3090b(String str, ReadableArray readableArray, Callback callback) {
        try {
            File file = new File(str);
            StringBuilder stringBuilder;
            if (file.exists()) {
                readableArray = new Object[1];
                stringBuilder = new StringBuilder();
                stringBuilder.append("create file error: failed to create file at path `");
                stringBuilder.append(str);
                stringBuilder.append("`, file already exists.");
                readableArray[0] = stringBuilder.toString();
                callback.invoke(readableArray);
            } else if (file.createNewFile()) {
                OutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[readableArray.size()];
                for (int i = 0; i < readableArray.size(); i++) {
                    bArr[i] = (byte) readableArray.getInt(i);
                }
                fileOutputStream.write(bArr);
                callback.invoke(new Object[]{null, str});
            } else {
                readableArray = new Object[1];
                stringBuilder = new StringBuilder();
                stringBuilder.append("create file error: failed to create file at path `");
                stringBuilder.append(str);
                stringBuilder.append("` for its parent path may not exists");
                readableArray[0] = stringBuilder.toString();
                callback.invoke(readableArray);
            }
        } catch (String str2) {
            callback.invoke(new Object[]{str2.getLocalizedMessage()});
        }
    }

    /* renamed from: a */
    static void m3074a(Callback callback) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        WritableMap createMap = Arguments.createMap();
        if (VERSION.SDK_INT >= 18) {
            createMap.putString("internal_free", String.valueOf(statFs.getFreeBytes()));
            createMap.putString("internal_total", String.valueOf(statFs.getTotalBytes()));
            statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            createMap.putString("external_free", String.valueOf(statFs.getFreeBytes()));
            createMap.putString("external_total", String.valueOf(statFs.getTotalBytes()));
        }
        callback.invoke(null, createMap);
    }

    /* renamed from: a */
    static void m3075a(ReadableArray readableArray, final Callback callback) {
        new AsyncTask<ReadableArray, Integer, Integer>() {
            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m3070a((ReadableArray[]) objArr);
            }

            /* renamed from: a */
            protected Integer m3070a(ReadableArray... readableArrayArr) {
                int i = 0;
                while (i < readableArrayArr[0].size()) {
                    try {
                        File file = new File(readableArrayArr[0].getString(i));
                        if (file.exists()) {
                            file.delete();
                        }
                        i++;
                    } catch (Exception e) {
                        callback.invoke(e.getLocalizedMessage());
                    }
                }
                callback.invoke(null, Boolean.valueOf(true));
                return Integer.valueOf(readableArrayArr[0].size());
            }
        }.execute(new ReadableArray[]{readableArray});
    }

    /* renamed from: a */
    private static byte[] m3087a(String str, String str2) {
        if (str2.equalsIgnoreCase("ascii")) {
            return str.getBytes(Charset.forName("US-ASCII"));
        }
        if (str2.toLowerCase().contains(Results.BASE_64)) {
            return Base64.decode(str, 2);
        }
        if (str2.equalsIgnoreCase("utf8") != null) {
            return str.getBytes(Charset.forName(Utf8Charset.NAME));
        }
        return str.getBytes(Charset.forName("US-ASCII"));
    }

    /* renamed from: a */
    private void m3084a(String str, String str2, String str3) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("event", str2);
        createMap.putString("detail", str3);
        this.f2421b.emit(str, createMap);
    }

    /* renamed from: a */
    private void m3083a(String str, String str2, WritableArray writableArray) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("event", str2);
        createMap.putArray("detail", writableArray);
        this.f2421b.emit(str, createMap);
    }

    /* renamed from: b */
    static InputStream m3088b(String str) {
        if (str.startsWith("bundle-assets://")) {
            return RNFetchBlob.RCTContext.getAssets().open(str.replace("bundle-assets://", ""));
        }
        return new FileInputStream(new File(str));
    }

    /* renamed from: c */
    static boolean m3094c(java.lang.String r3) {
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
        r0 = "bundle-assets://";
        r0 = r3.startsWith(r0);
        if (r0 == 0) goto L_0x001d;
    L_0x0008:
        r0 = com.RNFetchBlob.RNFetchBlob.RCTContext;	 Catch:{ IOException -> 0x001b }
        r0 = r0.getAssets();	 Catch:{ IOException -> 0x001b }
        r1 = "bundle-assets://";	 Catch:{ IOException -> 0x001b }
        r2 = "";	 Catch:{ IOException -> 0x001b }
        r3 = r3.replace(r1, r2);	 Catch:{ IOException -> 0x001b }
        r0.open(r3);	 Catch:{ IOException -> 0x001b }
        r3 = 1;
        return r3;
    L_0x001b:
        r3 = 0;
        return r3;
    L_0x001d:
        r0 = new java.io.File;
        r0.<init>(r3);
        r3 = r0.exists();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.d.c(java.lang.String):boolean");
    }

    /* renamed from: d */
    static boolean m3096d(String str) {
        return str != null ? str.startsWith("bundle-assets://") : null;
    }

    /* renamed from: e */
    static String m3097e(String str) {
        if (str == null) {
            return null;
        }
        if (!str.matches("\\w+\\:.*")) {
            return str;
        }
        if (str.startsWith("file://")) {
            return str.replace("file://", "");
        }
        Uri parse = Uri.parse(str);
        if (str.startsWith("bundle-assets://")) {
            return str;
        }
        return C0861a.m3063a(RNFetchBlob.RCTContext, parse);
    }
}

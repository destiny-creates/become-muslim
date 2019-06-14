package expo.modules.filesystem;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.uimanager.ViewProps;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5991a;
import expo.p307b.p312e.C6026a;
import expo.p307b.p312e.C6027b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.p371a.p373b.p374a.C6637a;
import org.apache.p371a.p373b.p375b.C6639a;
import org.apache.p371a.p376c.C6644b;
import org.apache.p371a.p376c.C6646d;
import p286d.C5870l;
import p286d.C5876t;
import p286d.C7203d;
import p286d.C7204e;
import p286d.C7206h;
import p286d.C8037c;
import versioned.host.exp.exponent.modules.api.viewshot.ViewShot.Results;

public class FileSystemModule extends C6006c implements C6001h {
    private static final String EXDownloadProgressEventName = "Exponent.downloadProgress";
    private static final String HEADER_KEY = "headers";
    private static final long MIN_EVENT_DT_MS = 100;
    private static final String NAME = "ExponentFileSystem";
    private static final String TAG = "FileSystemModule";
    private final Map<String, DownloadResumable> mDownloadResumableMap = new HashMap();
    private C6007d mModuleRegistry;

    private static class DownloadResumable {
        public final Call call;
        public final Uri fileUri;
        public final String url;
        public final String uuid;

        public DownloadResumable(String str, String str2, Uri uri, Call call) {
            this.uuid = str;
            this.url = str2;
            this.fileUri = uri;
            this.call = call;
        }
    }

    private class DownloadResumableTask extends AsyncTask<DownloadResumableTaskParams, Void, Void> {
        private DownloadResumableTask() {
        }

        protected Void doInBackground(DownloadResumableTaskParams... downloadResumableTaskParamsArr) {
            Call call = downloadResumableTaskParamsArr[0].call;
            C6009f c6009f = downloadResumableTaskParamsArr[0].promise;
            File file = downloadResumableTaskParamsArr[0].file;
            boolean z = downloadResumableTaskParamsArr[0].isResume;
            downloadResumableTaskParamsArr = downloadResumableTaskParamsArr[0].options;
            try {
                OutputStream fileOutputStream;
                Response execute = call.execute();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(execute.body().byteStream());
                if (z) {
                    fileOutputStream = new FileOutputStream(file, true);
                } else {
                    fileOutputStream = new FileOutputStream(file, false);
                }
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                Object bundle = new Bundle();
                bundle.putString("uri", Uri.fromFile(file).toString());
                if (!(downloadResumableTaskParamsArr == null || !downloadResumableTaskParamsArr.containsKey("md5") || ((Boolean) downloadResumableTaskParamsArr.get("md5")).booleanValue() == null)) {
                    bundle.putString("md5", FileSystemModule.this.md5(file));
                }
                bundle.putInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, execute.code());
                bundle.putBundle(FileSystemModule.HEADER_KEY, FileSystemModule.translateHeaders(execute.headers()));
                c6009f.mo5137a(bundle);
                return null;
            } catch (Throwable e) {
                Log.e(FileSystemModule.TAG, e.getMessage());
                c6009f.m25155a(e);
                return null;
            }
        }
    }

    private static class DownloadResumableTaskParams {
        Call call;
        File file;
        boolean isResume;
        Map<String, Object> options;
        C6009f promise;

        DownloadResumableTaskParams(Map<String, Object> map, Call call, File file, boolean z, C6009f c6009f) {
            this.options = map;
            this.call = call;
            this.file = file;
            this.isResume = z;
            this.promise = c6009f;
        }
    }

    interface ProgressListener {
        void update(long j, long j2, boolean z);
    }

    private static class ProgressResponseBody extends ResponseBody {
        private C7204e bufferedSource;
        private final ProgressListener progressListener;
        private final ResponseBody responseBody;

        ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
            this.responseBody = responseBody;
            this.progressListener = progressListener;
        }

        public MediaType contentType() {
            return this.responseBody.contentType();
        }

        public long contentLength() {
            return this.responseBody.contentLength();
        }

        public C7204e source() {
            if (this.bufferedSource == null) {
                this.bufferedSource = C5870l.m24720a(source(this.responseBody.source()));
            }
            return this.bufferedSource;
        }

        private C5876t source(C5876t c5876t) {
            return new C7206h(c5876t) {
                long totalBytesRead = null;

                public long read(C8037c c8037c, long j) {
                    c8037c = super.read(c8037c, j);
                    int i = (c8037c > -1 ? 1 : (c8037c == -1 ? 0 : -1));
                    this.totalBytesRead += i != 0 ? c8037c : 0;
                    ProgressResponseBody.this.progressListener.update(this.totalBytesRead, ProgressResponseBody.this.responseBody.contentLength(), i == 0);
                    return c8037c;
                }
            };
        }
    }

    public String getName() {
        return NAME;
    }

    public FileSystemModule(Context context) {
        super(context);
        try {
            ensureDirExists(getContext().getFilesDir());
            ensureDirExists(getContext().getCacheDir());
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Uri.fromFile(getContext().getFilesDir()).toString());
        stringBuilder.append("/");
        hashMap.put("documentDirectory", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(Uri.fromFile(getContext().getCacheDir()).toString());
        stringBuilder.append("/");
        hashMap.put("cacheDirectory", stringBuilder.toString());
        hashMap.put("bundleDirectory", "asset:///");
        return hashMap;
    }

    private File uriToFile(Uri uri) {
        return new File(uri.getPath());
    }

    private EnumSet<C6027b> permissionsForPath(String str) {
        return ((C6026a) this.mModuleRegistry.m25133a(C6026a.class)).getPathPermissions(getContext(), str);
    }

    private EnumSet<C6027b> permissionsForUri(Uri uri) {
        if (UriUtil.LOCAL_CONTENT_SCHEME.equals(uri.getScheme())) {
            return EnumSet.of(C6027b.READ);
        }
        if (UriUtil.LOCAL_ASSET_SCHEME.equals(uri.getScheme())) {
            return EnumSet.of(C6027b.READ);
        }
        if (UriUtil.LOCAL_FILE_SCHEME.equals(uri.getScheme())) {
            return permissionsForPath(uri.getPath());
        }
        return EnumSet.noneOf(C6027b.class);
    }

    private void ensurePermission(Uri uri, C6027b c6027b, String str) {
        if (permissionsForUri(uri).contains(c6027b) == null) {
            throw new IOException(str);
        }
    }

    private void ensurePermission(Uri uri, C6027b c6027b) {
        StringBuilder stringBuilder;
        if (c6027b.equals(C6027b.READ)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Location '");
            stringBuilder.append(uri);
            stringBuilder.append("' isn't readable.");
            ensurePermission(uri, c6027b, stringBuilder.toString());
        }
        if (c6027b.equals(C6027b.WRITE)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Location '");
            stringBuilder.append(uri);
            stringBuilder.append("' isn't writable.");
            ensurePermission(uri, c6027b, stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Location '");
        stringBuilder.append(uri);
        stringBuilder.append("' doesn't have permission '");
        stringBuilder.append(c6027b.name());
        stringBuilder.append("'.");
        ensurePermission(uri, c6027b, stringBuilder.toString());
    }

    private InputStream openAssetInputStream(Uri uri) {
        return getContext().getAssets().open(uri.getPath().substring(1));
    }

    @expo.p304a.p305a.C5996c
    public void getInfoAsync(java.lang.String r7, java.util.Map<java.lang.String, java.lang.Object> r8, expo.p304a.C6009f r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r7 = android.net.Uri.parse(r7);	 Catch:{ Exception -> 0x0144 }
        r0 = expo.p307b.p312e.C6027b.READ;	 Catch:{ Exception -> 0x0144 }
        r6.ensurePermission(r7, r0);	 Catch:{ Exception -> 0x0144 }
        r0 = "file";	 Catch:{ Exception -> 0x0144 }
        r1 = r7.getScheme();	 Catch:{ Exception -> 0x0144 }
        r0 = r0.equals(r1);	 Catch:{ Exception -> 0x0144 }
        r1 = 1;	 Catch:{ Exception -> 0x0144 }
        r2 = 0;	 Catch:{ Exception -> 0x0144 }
        if (r0 == 0) goto L_0x008f;	 Catch:{ Exception -> 0x0144 }
    L_0x0017:
        r7 = r6.uriToFile(r7);	 Catch:{ Exception -> 0x0144 }
        r0 = new android.os.Bundle;	 Catch:{ Exception -> 0x0144 }
        r0.<init>();	 Catch:{ Exception -> 0x0144 }
        r3 = r7.exists();	 Catch:{ Exception -> 0x0144 }
        if (r3 == 0) goto L_0x0080;	 Catch:{ Exception -> 0x0144 }
    L_0x0026:
        r2 = "exists";	 Catch:{ Exception -> 0x0144 }
        r0.putBoolean(r2, r1);	 Catch:{ Exception -> 0x0144 }
        r1 = "isDirectory";	 Catch:{ Exception -> 0x0144 }
        r2 = r7.isDirectory();	 Catch:{ Exception -> 0x0144 }
        r0.putBoolean(r1, r2);	 Catch:{ Exception -> 0x0144 }
        r1 = "uri";	 Catch:{ Exception -> 0x0144 }
        r2 = android.net.Uri.fromFile(r7);	 Catch:{ Exception -> 0x0144 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0144 }
        r0.putString(r1, r2);	 Catch:{ Exception -> 0x0144 }
        r1 = "md5";	 Catch:{ Exception -> 0x0144 }
        r1 = r8.containsKey(r1);	 Catch:{ Exception -> 0x0144 }
        if (r1 == 0) goto L_0x0060;	 Catch:{ Exception -> 0x0144 }
    L_0x0049:
        r1 = "md5";	 Catch:{ Exception -> 0x0144 }
        r8 = r8.get(r1);	 Catch:{ Exception -> 0x0144 }
        r8 = (java.lang.Boolean) r8;	 Catch:{ Exception -> 0x0144 }
        r8 = r8.booleanValue();	 Catch:{ Exception -> 0x0144 }
        if (r8 == 0) goto L_0x0060;	 Catch:{ Exception -> 0x0144 }
    L_0x0057:
        r8 = "md5";	 Catch:{ Exception -> 0x0144 }
        r1 = r6.md5(r7);	 Catch:{ Exception -> 0x0144 }
        r0.putString(r8, r1);	 Catch:{ Exception -> 0x0144 }
    L_0x0060:
        r8 = "size";	 Catch:{ Exception -> 0x0144 }
        r1 = r7.length();	 Catch:{ Exception -> 0x0144 }
        r1 = (double) r1;	 Catch:{ Exception -> 0x0144 }
        r0.putDouble(r8, r1);	 Catch:{ Exception -> 0x0144 }
        r8 = "modificationTime";	 Catch:{ Exception -> 0x0144 }
        r1 = 4562254508917369340; // 0x3f50624dd2f1a9fc float:-5.18969491E11 double:0.001;	 Catch:{ Exception -> 0x0144 }
        r3 = r7.lastModified();	 Catch:{ Exception -> 0x0144 }
        r3 = (double) r3;	 Catch:{ Exception -> 0x0144 }
        r3 = r3 * r1;	 Catch:{ Exception -> 0x0144 }
        r0.putDouble(r8, r3);	 Catch:{ Exception -> 0x0144 }
        r9.mo5137a(r0);	 Catch:{ Exception -> 0x0144 }
        goto L_0x0151;	 Catch:{ Exception -> 0x0144 }
    L_0x0080:
        r7 = "exists";	 Catch:{ Exception -> 0x0144 }
        r0.putBoolean(r7, r2);	 Catch:{ Exception -> 0x0144 }
        r7 = "isDirectory";	 Catch:{ Exception -> 0x0144 }
        r0.putBoolean(r7, r2);	 Catch:{ Exception -> 0x0144 }
        r9.mo5137a(r0);	 Catch:{ Exception -> 0x0144 }
        goto L_0x0151;	 Catch:{ Exception -> 0x0144 }
    L_0x008f:
        r0 = "content";	 Catch:{ Exception -> 0x0144 }
        r3 = r7.getScheme();	 Catch:{ Exception -> 0x0144 }
        r0 = r0.equals(r3);	 Catch:{ Exception -> 0x0144 }
        if (r0 != 0) goto L_0x00c4;	 Catch:{ Exception -> 0x0144 }
    L_0x009b:
        r0 = "asset";	 Catch:{ Exception -> 0x0144 }
        r3 = r7.getScheme();	 Catch:{ Exception -> 0x0144 }
        r0 = r0.equals(r3);	 Catch:{ Exception -> 0x0144 }
        if (r0 == 0) goto L_0x00a8;	 Catch:{ Exception -> 0x0144 }
    L_0x00a7:
        goto L_0x00c4;	 Catch:{ Exception -> 0x0144 }
    L_0x00a8:
        r8 = new java.io.IOException;	 Catch:{ Exception -> 0x0144 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0144 }
        r0.<init>();	 Catch:{ Exception -> 0x0144 }
        r1 = "Unsupported scheme for location '";	 Catch:{ Exception -> 0x0144 }
        r0.append(r1);	 Catch:{ Exception -> 0x0144 }
        r0.append(r7);	 Catch:{ Exception -> 0x0144 }
        r7 = "'.";	 Catch:{ Exception -> 0x0144 }
        r0.append(r7);	 Catch:{ Exception -> 0x0144 }
        r7 = r0.toString();	 Catch:{ Exception -> 0x0144 }
        r8.<init>(r7);	 Catch:{ Exception -> 0x0144 }
        throw r8;	 Catch:{ Exception -> 0x0144 }
    L_0x00c4:
        r0 = new android.os.Bundle;	 Catch:{ Exception -> 0x0144 }
        r0.<init>();	 Catch:{ Exception -> 0x0144 }
        r3 = "content";	 Catch:{ FileNotFoundException -> 0x0136 }
        r4 = r7.getScheme();	 Catch:{ FileNotFoundException -> 0x0136 }
        r3 = r3.equals(r4);	 Catch:{ FileNotFoundException -> 0x0136 }
        if (r3 == 0) goto L_0x00e2;	 Catch:{ FileNotFoundException -> 0x0136 }
    L_0x00d5:
        r3 = r6.getContext();	 Catch:{ FileNotFoundException -> 0x0136 }
        r3 = r3.getContentResolver();	 Catch:{ FileNotFoundException -> 0x0136 }
        r3 = r3.openInputStream(r7);	 Catch:{ FileNotFoundException -> 0x0136 }
        goto L_0x00e6;	 Catch:{ FileNotFoundException -> 0x0136 }
    L_0x00e2:
        r3 = r6.openAssetInputStream(r7);	 Catch:{ FileNotFoundException -> 0x0136 }
    L_0x00e6:
        if (r3 == 0) goto L_0x0130;	 Catch:{ FileNotFoundException -> 0x0136 }
    L_0x00e8:
        r4 = "exists";	 Catch:{ FileNotFoundException -> 0x0136 }
        r0.putBoolean(r4, r1);	 Catch:{ FileNotFoundException -> 0x0136 }
        r1 = "isDirectory";	 Catch:{ FileNotFoundException -> 0x0136 }
        r0.putBoolean(r1, r2);	 Catch:{ FileNotFoundException -> 0x0136 }
        r1 = "uri";	 Catch:{ FileNotFoundException -> 0x0136 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0136 }
        r0.putString(r1, r7);	 Catch:{ FileNotFoundException -> 0x0136 }
        r7 = "size";	 Catch:{ FileNotFoundException -> 0x0136 }
        r1 = r3.available();	 Catch:{ FileNotFoundException -> 0x0136 }
        r4 = (double) r1;	 Catch:{ FileNotFoundException -> 0x0136 }
        r0.putDouble(r7, r4);	 Catch:{ FileNotFoundException -> 0x0136 }
        r7 = "md5";	 Catch:{ FileNotFoundException -> 0x0136 }
        r7 = r8.containsKey(r7);	 Catch:{ FileNotFoundException -> 0x0136 }
        if (r7 == 0) goto L_0x012c;	 Catch:{ FileNotFoundException -> 0x0136 }
    L_0x010d:
        r7 = "md5";	 Catch:{ FileNotFoundException -> 0x0136 }
        r7 = r8.get(r7);	 Catch:{ FileNotFoundException -> 0x0136 }
        r7 = (java.lang.Boolean) r7;	 Catch:{ FileNotFoundException -> 0x0136 }
        r7 = r7.booleanValue();	 Catch:{ FileNotFoundException -> 0x0136 }
        if (r7 == 0) goto L_0x012c;	 Catch:{ FileNotFoundException -> 0x0136 }
    L_0x011b:
        r7 = org.apache.p371a.p373b.p375b.C6639a.m27027a(r3);	 Catch:{ FileNotFoundException -> 0x0136 }
        r8 = "md5";	 Catch:{ FileNotFoundException -> 0x0136 }
        r7 = org.apache.p371a.p373b.p374a.C6637a.m27021a(r7);	 Catch:{ FileNotFoundException -> 0x0136 }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ FileNotFoundException -> 0x0136 }
        r0.putString(r8, r7);	 Catch:{ FileNotFoundException -> 0x0136 }
    L_0x012c:
        r9.mo5137a(r0);	 Catch:{ FileNotFoundException -> 0x0136 }
        goto L_0x0151;	 Catch:{ FileNotFoundException -> 0x0136 }
    L_0x0130:
        r7 = new java.io.FileNotFoundException;	 Catch:{ FileNotFoundException -> 0x0136 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x0136 }
        throw r7;	 Catch:{ FileNotFoundException -> 0x0136 }
    L_0x0136:
        r7 = "exists";	 Catch:{ Exception -> 0x0144 }
        r0.putBoolean(r7, r2);	 Catch:{ Exception -> 0x0144 }
        r7 = "isDirectory";	 Catch:{ Exception -> 0x0144 }
        r0.putBoolean(r7, r2);	 Catch:{ Exception -> 0x0144 }
        r9.mo5137a(r0);	 Catch:{ Exception -> 0x0144 }
        goto L_0x0151;
    L_0x0144:
        r7 = move-exception;
        r8 = TAG;
        r0 = r7.getMessage();
        android.util.Log.e(r8, r0);
        r9.m25155a(r7);
    L_0x0151:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule.getInfoAsync(java.lang.String, java.util.Map, expo.a.f):void");
    }

    @C5996c
    public void readAsStringAsync(String str, Map<String, Object> map, C6009f c6009f) {
        try {
            Object encodeToString;
            str = Uri.parse(str);
            ensurePermission(str, C6027b.READ);
            String str2 = "utf8";
            if (map.containsKey("encoding") && (map.get("encoding") instanceof String)) {
                str2 = ((String) map.get("encoding")).toLowerCase();
            }
            StringBuilder stringBuilder;
            if (str2.equalsIgnoreCase(Results.BASE_64)) {
                InputStream fileInputStream;
                if (UriUtil.LOCAL_FILE_SCHEME.equals(str.getScheme())) {
                    fileInputStream = new FileInputStream(uriToFile(str));
                } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(str.getScheme())) {
                    fileInputStream = openAssetInputStream(str);
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported scheme for location '");
                    stringBuilder.append(str);
                    stringBuilder.append("'.");
                    throw new IOException(stringBuilder.toString());
                }
                if (map.containsKey("length") == null || map.containsKey(ViewProps.POSITION) == null) {
                    encodeToString = Base64.encodeToString(getInputStreamBytes(fileInputStream), 2);
                } else {
                    str = ((Number) map.get("length")).intValue();
                    byte[] bArr = new byte[str];
                    fileInputStream.skip((long) ((Number) map.get(ViewProps.POSITION)).intValue());
                    encodeToString = Base64.encodeToString(bArr, 0, fileInputStream.read(bArr, 0, str), 2);
                }
            } else if (UriUtil.LOCAL_FILE_SCHEME.equals(str.getScheme()) != null) {
                encodeToString = C6646d.m27063b(new FileInputStream(uriToFile(str)));
            } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(str.getScheme()) != null) {
                encodeToString = C6646d.m27063b(openAssetInputStream(str));
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported scheme for location '");
                stringBuilder.append(str);
                stringBuilder.append("'.");
                throw new IOException(stringBuilder.toString());
            }
            c6009f.mo5137a(encodeToString);
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage());
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void writeAsStringAsync(String str, String str2, Map<String, Object> map, C6009f c6009f) {
        try {
            str = Uri.parse(str);
            ensurePermission(str, C6027b.WRITE);
            if (UriUtil.LOCAL_FILE_SCHEME.equals(str.getScheme())) {
                String str3 = "utf8";
                if (map.containsKey("encoding") && (map.get("encoding") instanceof String)) {
                    str3 = ((String) map.get("encoding")).toLowerCase();
                }
                map = new FileOutputStream(uriToFile(str));
                if (str3.equals(Results.BASE_64) != null) {
                    map.write(Base64.decode(str2, null));
                } else {
                    str = new OutputStreamWriter(map);
                    str.write(str2);
                    str.close();
                }
                map.close();
                c6009f.mo5137a((Object) null);
                return;
            }
            map = new StringBuilder();
            map.append("Unsupported scheme for location '");
            map.append(str);
            map.append("'.");
            throw new IOException(map.toString());
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage());
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void deleteAsync(String str, Map<String, Object> map, C6009f c6009f) {
        try {
            str = Uri.parse(str);
            Uri withAppendedPath = Uri.withAppendedPath(str, "..");
            C6027b c6027b = C6027b.WRITE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Location '");
            stringBuilder.append(str);
            stringBuilder.append("' isn't deletable.");
            ensurePermission(withAppendedPath, c6027b, stringBuilder.toString());
            StringBuilder stringBuilder2;
            if (UriUtil.LOCAL_FILE_SCHEME.equals(str.getScheme())) {
                File uriToFile = uriToFile(str);
                if (uriToFile.exists()) {
                    C6644b.m27044c(uriToFile);
                    c6009f.mo5137a(null);
                    return;
                } else if (!map.containsKey("idempotent") || ((Boolean) map.get("idempotent")).booleanValue() == null) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("File '");
                    stringBuilder2.append(str);
                    stringBuilder2.append("' could not be deleted because it could not be found");
                    c6009f.m25152a("E_FILE_NOT_FOUND", stringBuilder2.toString());
                    return;
                } else {
                    c6009f.mo5137a(null);
                    return;
                }
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unsupported scheme for location '");
            stringBuilder2.append(str);
            stringBuilder2.append("'.");
            throw new IOException(stringBuilder2.toString());
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage());
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void moveAsync(Map<String, Object> map, C6009f c6009f) {
        try {
            if (map.containsKey("from")) {
                Uri parse = Uri.parse((String) map.get("from"));
                Uri withAppendedPath = Uri.withAppendedPath(parse, "..");
                C6027b c6027b = C6027b.WRITE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Location '");
                stringBuilder.append(parse);
                stringBuilder.append("' isn't movable.");
                ensurePermission(withAppendedPath, c6027b, stringBuilder.toString());
                if (map.containsKey("to")) {
                    map = Uri.parse((String) map.get("to"));
                    ensurePermission(map, C6027b.WRITE);
                    if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                        if (uriToFile(parse).renameTo(uriToFile(map))) {
                            c6009f.mo5137a((Object) null);
                        } else {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("File '");
                            stringBuilder2.append(parse);
                            stringBuilder2.append("' could not be moved to '");
                            stringBuilder2.append(map);
                            stringBuilder2.append("'");
                            c6009f.m25152a("E_FILE_NOT_MOVED", stringBuilder2.toString());
                        }
                        return;
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Unsupported scheme for location '");
                    stringBuilder3.append(parse);
                    stringBuilder3.append("'.");
                    throw new IOException(stringBuilder3.toString());
                }
                c6009f.m25152a("E_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `to` path.");
                return;
            }
            c6009f.m25152a("E_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `from` path.");
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage());
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void copyAsync(Map<String, Object> map, C6009f c6009f) {
        try {
            if (map.containsKey("from")) {
                Uri parse = Uri.parse((String) map.get("from"));
                ensurePermission(parse, C6027b.READ);
                if (map.containsKey("to")) {
                    map = Uri.parse((String) map.get("to"));
                    ensurePermission(map, C6027b.WRITE);
                    if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                        File uriToFile = uriToFile(parse);
                        map = uriToFile(map);
                        if (uriToFile.isDirectory()) {
                            C6644b.m27042b(uriToFile, map);
                            c6009f.mo5137a(null);
                        } else {
                            C6644b.m27037a(uriToFile, map);
                            c6009f.mo5137a(null);
                        }
                    } else if (UriUtil.LOCAL_CONTENT_SCHEME.equals(parse.getScheme())) {
                        C6646d.m27051a(getContext().getContentResolver().openInputStream(parse), new FileOutputStream(uriToFile(map)));
                        c6009f.mo5137a(null);
                    } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(parse.getScheme())) {
                        C6646d.m27051a(openAssetInputStream(parse), new FileOutputStream(uriToFile(map)));
                        c6009f.mo5137a(null);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unsupported scheme for location '");
                        stringBuilder.append(parse);
                        stringBuilder.append("'.");
                        throw new IOException(stringBuilder.toString());
                    }
                    return;
                }
                c6009f.m25152a("E_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `to` path.");
                return;
            }
            c6009f.m25152a("E_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `from` path.");
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage());
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void makeDirectoryAsync(String str, Map<String, Object> map, C6009f c6009f) {
        try {
            str = Uri.parse(str);
            ensurePermission(str, C6027b.WRITE);
            StringBuilder stringBuilder;
            if (UriUtil.LOCAL_FILE_SCHEME.equals(str.getScheme())) {
                File uriToFile = uriToFile(str);
                if (!map.containsKey("intermediates") || ((Boolean) map.get("intermediates")).booleanValue() == null) {
                    map = uriToFile.mkdir();
                } else {
                    map = uriToFile.mkdirs();
                }
                if (map != null) {
                    c6009f.mo5137a((Object) null);
                    return;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Directory '");
                stringBuilder.append(str);
                stringBuilder.append("' could not be created.");
                c6009f.m25152a("E_DIRECTORY_NOT_CREATED", stringBuilder.toString());
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported scheme for location '");
            stringBuilder.append(str);
            stringBuilder.append("'.");
            throw new IOException(stringBuilder.toString());
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage());
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void readDirectoryAsync(String str, Map<String, Object> map, C6009f c6009f) {
        try {
            str = Uri.parse(str);
            ensurePermission(str, C6027b.READ);
            StringBuilder stringBuilder;
            if (UriUtil.LOCAL_FILE_SCHEME.equals(str.getScheme()) != null) {
                map = uriToFile(str).listFiles();
                if (map != null) {
                    Object arrayList = new ArrayList();
                    for (File name : map) {
                        arrayList.add(name.getName());
                    }
                    c6009f.mo5137a(arrayList);
                    return;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Directory '");
                stringBuilder.append(str);
                stringBuilder.append("' could not be read.");
                c6009f.m25152a("E_DIRECTORY_NOT_READ", stringBuilder.toString());
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported scheme for location '");
            stringBuilder.append(str);
            stringBuilder.append("'.");
            throw new IOException(stringBuilder.toString());
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage());
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void downloadAsync(String str, String str2, final Map<String, Object> map, final C6009f c6009f) {
        try {
            str2 = Uri.parse(str2);
            ensurePermission(str2, C6027b.WRITE);
            if (UriUtil.LOCAL_FILE_SCHEME.equals(str2.getScheme())) {
                getOkHttpClientBuilder().build().newCall(new Builder().url(str).build()).enqueue(new Callback() {
                    public void onFailure(Call call, IOException iOException) {
                        Log.e(FileSystemModule.TAG, iOException.getMessage());
                        c6009f.m25155a((Throwable) iOException);
                    }

                    public void onResponse(Call call, Response response) {
                        File access$100 = FileSystemModule.this.uriToFile(str2);
                        access$100.delete();
                        C7203d a = C5870l.m24719a(C5870l.m24729b(access$100));
                        a.mo6286a(response.body().source());
                        a.close();
                        Object bundle = new Bundle();
                        bundle.putString("uri", Uri.fromFile(access$100).toString());
                        if (map != null && map.containsKey("md5") && ((Boolean) map.get("md5")).booleanValue()) {
                            bundle.putString("md5", FileSystemModule.this.md5(access$100));
                        }
                        bundle.putInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, response.code());
                        bundle.putBundle(FileSystemModule.HEADER_KEY, FileSystemModule.translateHeaders(response.headers()));
                        c6009f.mo5137a(bundle);
                    }
                });
                return;
            }
            map = new StringBuilder();
            map.append("Unsupported scheme for location '");
            map.append(str2);
            map.append("'.");
            throw new IOException(map.toString());
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage());
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void downloadResumableStartAsync(String str, String str2, final String str3, Map<String, Object> map, final String str4, C6009f c6009f) {
        try {
            str2 = Uri.parse(str2);
            if (UriUtil.LOCAL_FILE_SCHEME.equals(str2.getScheme())) {
                final boolean z = str4 != null;
                final ProgressListener c74102 = new ProgressListener() {
                    long mLastUpdate = -1;

                    public void update(long j, long j2, boolean z) {
                        C5991a c5991a = (C5991a) FileSystemModule.this.mModuleRegistry.m25133a(C5991a.class);
                        if (c5991a != null) {
                            Bundle bundle = new Bundle();
                            Bundle bundle2 = new Bundle();
                            if (z) {
                                j += Long.parseLong(str4);
                            }
                            if (z) {
                                j2 += Long.parseLong(str4);
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis > this.mLastUpdate + FileSystemModule.MIN_EVENT_DT_MS || j == j2) {
                                this.mLastUpdate = currentTimeMillis;
                                bundle2.putDouble("totalBytesWritten", (double) j);
                                bundle2.putDouble("totalBytesExpectedToWrite", (double) j2);
                                bundle.putString("uuid", str3);
                                bundle.putBundle("data", bundle2);
                                c5991a.mo5142a(FileSystemModule.EXDownloadProgressEventName, bundle);
                            }
                        }
                    }
                };
                OkHttpClient build = getOkHttpClientBuilder().addNetworkInterceptor(new Interceptor() {
                    public Response intercept(Chain chain) {
                        chain = chain.proceed(chain.request());
                        return chain.newBuilder().body(new ProgressResponseBody(chain.body(), c74102)).build();
                    }
                }).build();
                Builder builder = new Builder();
                if (z) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("bytes=");
                    stringBuilder.append(str4);
                    stringBuilder.append("-");
                    builder.addHeader("Range", stringBuilder.toString());
                }
                if (!(map == null || map.containsKey(HEADER_KEY) == null)) {
                    Map map2 = (Map) map.get(HEADER_KEY);
                    for (String str5 : map2.keySet()) {
                        builder.addHeader(str5, map2.get(str5).toString());
                    }
                }
                Call newCall = build.newCall(builder.url(str).build());
                this.mDownloadResumableMap.put(str3, new DownloadResumable(str3, str, str2, newCall));
                String downloadResumableTaskParams = new DownloadResumableTaskParams(map, newCall, uriToFile(str2), z, c6009f);
                new DownloadResumableTask().execute(new DownloadResumableTaskParams[]{downloadResumableTaskParams});
                return;
            }
            str3 = new StringBuilder();
            str3.append("Unsupported scheme for location '");
            str3.append(str2);
            str3.append("'.");
            throw new IOException(str3.toString());
        } catch (Throwable e) {
            Log.e(TAG, e.getMessage());
            c6009f.m25155a(e);
        }
    }

    @C5996c
    public void downloadResumablePauseAsync(String str, C6009f c6009f) {
        DownloadResumable downloadResumable = (DownloadResumable) this.mDownloadResumableMap.get(str);
        if (downloadResumable != null) {
            downloadResumable.call.cancel();
            this.mDownloadResumableMap.remove(downloadResumable.uuid);
            try {
                str = uriToFile(downloadResumable.fileUri);
                Object bundle = new Bundle();
                bundle.putString("resumeData", String.valueOf(str.length()));
                c6009f.mo5137a(bundle);
                return;
            } catch (Throwable e) {
                Throwable e2;
                Log.e(TAG, e2.getMessage());
                c6009f.m25155a(e2);
                return;
            }
        }
        e2 = new IOException("No download object available");
        Log.e(TAG, e2.getMessage());
        c6009f.m25155a(e2);
    }

    private static byte[] getInputStreamBytes(java.io.InputStream r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];
    L_0x0009:
        r2 = r4.read(r1);	 Catch:{ all -> 0x001d }
        r3 = -1;	 Catch:{ all -> 0x001d }
        if (r2 == r3) goto L_0x0015;	 Catch:{ all -> 0x001d }
    L_0x0010:
        r3 = 0;	 Catch:{ all -> 0x001d }
        r0.write(r1, r3, r2);	 Catch:{ all -> 0x001d }
        goto L_0x0009;	 Catch:{ all -> 0x001d }
    L_0x0015:
        r4 = r0.toByteArray();	 Catch:{ all -> 0x001d }
        r0.close();	 Catch:{ IOException -> 0x001c }
    L_0x001c:
        return r4;
    L_0x001d:
        r4 = move-exception;
        r0.close();	 Catch:{ IOException -> 0x0021 }
    L_0x0021:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule.getInputStreamBytes(java.io.InputStream):byte[]");
    }

    private static Bundle translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        for (int i = 0; i < headers.size(); i++) {
            String name = headers.name(i);
            if (bundle.get(name) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(bundle.getString(name));
                stringBuilder.append(", ");
                stringBuilder.append(headers.value(i));
                bundle.putString(name, stringBuilder.toString());
            } else {
                bundle.putString(name, headers.value(i));
            }
        }
        return bundle;
    }

    private OkHttpClient.Builder getOkHttpClientBuilder() {
        CookieHandler cookieHandler = (CookieHandler) this.mModuleRegistry.m25133a(CookieHandler.class);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (cookieHandler != null) {
            builder.cookieJar(new JavaNetCookieJar(cookieHandler));
        }
        return builder;
    }

    private String md5(File file) {
        InputStream fileInputStream = new FileInputStream(file);
        try {
            file = String.valueOf(C6637a.m27021a(C6639a.m27027a(fileInputStream)));
            return file;
        } finally {
            fileInputStream.close();
        }
    }

    private void ensureDirExists(File file) {
        if (!file.isDirectory()) {
            if (!file.mkdirs()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't create directory '");
                stringBuilder.append(file);
                stringBuilder.append("'");
                throw new IOException(stringBuilder.toString());
            }
        }
    }
}

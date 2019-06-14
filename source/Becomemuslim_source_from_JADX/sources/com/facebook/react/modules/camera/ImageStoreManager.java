package com.facebook.react.modules.camera;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Base64OutputStream;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@ReactModule(name = "ImageStoreManager")
public class ImageStoreManager extends ReactContextBaseJavaModule {
    private static final int BUFFER_SIZE = 8192;

    private class GetBase64Task extends GuardedAsyncTask<Void, Void> {
        private final Callback mError;
        private final Callback mSuccess;
        private final String mUri;

        private GetBase64Task(ReactContext reactContext, String str, Callback callback, Callback callback2) {
            super(reactContext);
            this.mUri = str;
            this.mSuccess = callback;
            this.mError = callback2;
        }

        protected void doInBackgroundGuarded(Void... voidArr) {
            Closeable openInputStream;
            try {
                openInputStream = ImageStoreManager.this.getReactApplicationContext().getContentResolver().openInputStream(Uri.parse(this.mUri));
                try {
                    this.mSuccess.invoke(ImageStoreManager.this.convertInputStreamToBase64OutputStream(openInputStream));
                } catch (IOException e) {
                    this.mError.invoke(e.getMessage());
                }
                ImageStoreManager.closeQuietly(openInputStream);
            } catch (FileNotFoundException e2) {
                this.mError.invoke(e2.getMessage());
            } catch (Throwable th) {
                ImageStoreManager.closeQuietly(openInputStream);
            }
        }
    }

    public String getName() {
        return "ImageStoreManager";
    }

    public ImageStoreManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getBase64ForTag(String str, Callback callback, Callback callback2) {
        new GetBase64Task(getReactApplicationContext(), str, callback, callback2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[null]);
    }

    String convertInputStreamToBase64OutputStream(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Closeable base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 2);
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read <= -1) {
                    break;
                }
                base64OutputStream.write(bArr, 0, read);
            } finally {
                closeQuietly(base64OutputStream);
            }
        }
        return byteArrayOutputStream.toString();
    }

    private static void closeQuietly(java.io.Closeable r0) {
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
        r0.close();	 Catch:{ IOException -> 0x0003 }
    L_0x0003:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.camera.ImageStoreManager.closeQuietly(java.io.Closeable):void");
    }
}

package com.facebook.stetho.inspector.network;

import android.content.Context;
import android.util.Base64OutputStream;
import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.common.Util;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ResponseBodyFileManager {
    private static final String FILENAME_PREFIX = "network-response-body-";
    private static final int PRETTY_PRINT_TIMEOUT_SEC = 10;
    private static final String TAG = "ResponseBodyFileManager";
    private final Context mContext;
    private final Map<String, AsyncPrettyPrinter> mRequestIdMap = Collections.synchronizedMap(new HashMap());

    private class AsyncPrettyPrintingCallable implements Callable<String> {
        private final AsyncPrettyPrinter mAsyncPrettyPrinter;
        private final InputStream mInputStream;

        public AsyncPrettyPrintingCallable(InputStream inputStream, AsyncPrettyPrinter asyncPrettyPrinter) {
            this.mInputStream = inputStream;
            this.mAsyncPrettyPrinter = asyncPrettyPrinter;
        }

        public String call() {
            return prettyPrintContent(this.mInputStream, this.mAsyncPrettyPrinter);
        }

        private String prettyPrintContent(InputStream inputStream, AsyncPrettyPrinter asyncPrettyPrinter) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
            asyncPrettyPrinter.printTo(printWriter, inputStream);
            printWriter.flush();
            return byteArrayOutputStream.toString(Utf8Charset.NAME);
        }
    }

    public ResponseBodyFileManager(Context context) {
        this.mContext = context;
    }

    public void cleanupFiles() {
        for (File file : this.mContext.getFilesDir().listFiles()) {
            if (file.getName().startsWith(FILENAME_PREFIX) && !file.delete()) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to delete ");
                stringBuilder.append(file.getAbsolutePath());
                LogRedirector.m5736w(str, stringBuilder.toString());
            }
        }
        LogRedirector.m5732i(TAG, "Cleaned up temporary network files.");
    }

    public ResponseBodyData readFile(String str) {
        InputStream openFileInput = this.mContext.openFileInput(getFilename(str));
        try {
            int read = openFileInput.read();
            if (read != -1) {
                ResponseBodyData responseBodyData = new ResponseBodyData();
                responseBodyData.base64Encoded = read != 0;
                AsyncPrettyPrinter asyncPrettyPrinter = (AsyncPrettyPrinter) this.mRequestIdMap.get(str);
                if (asyncPrettyPrinter != null) {
                    responseBodyData.data = prettyPrintContentWithTimeOut(asyncPrettyPrinter, openFileInput);
                } else {
                    responseBodyData.data = Util.readAsUTF8(openFileInput);
                }
                openFileInput.close();
                return responseBodyData;
            }
            throw new EOFException("Failed to read base64Encode byte");
        } catch (Throwable th) {
            openFileInput.close();
        }
    }

    private java.lang.String prettyPrintContentWithTimeOut(com.facebook.stetho.inspector.network.AsyncPrettyPrinter r4, java.io.InputStream r5) {
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
        r0 = new com.facebook.stetho.inspector.network.ResponseBodyFileManager$AsyncPrettyPrintingCallable;
        r0.<init>(r5, r4);
        r4 = com.facebook.stetho.inspector.network.AsyncPrettyPrinterExecutorHolder.getExecutorService();
        if (r4 != 0) goto L_0x000d;
    L_0x000b:
        r4 = 0;
        return r4;
    L_0x000d:
        r4 = r4.submit(r0);
        r0 = 10;
        r2 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ TimeoutException -> 0x002b, ExecutionException -> 0x001c }
        r0 = com.facebook.stetho.common.Util.getUninterruptibly(r4, r0, r2);	 Catch:{ TimeoutException -> 0x002b, ExecutionException -> 0x001c }
        r0 = (java.lang.String) r0;	 Catch:{ TimeoutException -> 0x002b, ExecutionException -> 0x001c }
        return r0;
    L_0x001c:
        r4 = move-exception;
        r4 = r4.getCause();
        r5 = java.io.IOException.class;
        com.facebook.stetho.common.ExceptionUtil.propagateIfInstanceOf(r4, r5);
        r4 = com.facebook.stetho.common.ExceptionUtil.propagate(r4);
        throw r4;
    L_0x002b:
        r0 = 1;
        r4.cancel(r0);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = "Time out after 10 seconds of attempting to pretty print\n";
        r4.append(r0);
        r5 = com.facebook.stetho.common.Util.readAsUTF8(r5);
        r4.append(r5);
        r4 = r4.toString();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.network.ResponseBodyFileManager.prettyPrintContentWithTimeOut(com.facebook.stetho.inspector.network.AsyncPrettyPrinter, java.io.InputStream):java.lang.String");
    }

    public OutputStream openResponseBodyFile(String str, boolean z) {
        str = this.mContext.openFileOutput(getFilename(str), 0);
        str.write(z);
        return z ? new Base64OutputStream(str, 0) : str;
    }

    private static String getFilename(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FILENAME_PREFIX);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public void associateAsyncPrettyPrinterWithId(String str, AsyncPrettyPrinter asyncPrettyPrinter) {
        if (this.mRequestIdMap.put(str, asyncPrettyPrinter) != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cannot associate different pretty printers with the same request id: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}

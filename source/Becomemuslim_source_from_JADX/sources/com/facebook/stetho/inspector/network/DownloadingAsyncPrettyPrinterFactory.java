package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.server.http.HttpStatus;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public abstract class DownloadingAsyncPrettyPrinterFactory implements AsyncPrettyPrinterFactory {

    protected class MatchResult {
        private final PrettyPrinterDisplayType mDisplayType;
        private final String mSchemaUri;

        public MatchResult(String str, PrettyPrinterDisplayType prettyPrinterDisplayType) {
            this.mSchemaUri = str;
            this.mDisplayType = prettyPrinterDisplayType;
        }

        public String getSchemaUri() {
            return this.mSchemaUri;
        }

        public PrettyPrinterDisplayType getDisplayType() {
            return this.mDisplayType;
        }
    }

    private static class Request implements Callable<String> {
        private URL url;

        public Request(URL url) {
            this.url = url;
        }

        public String call() {
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpStatus.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    String readAsUTF8 = Util.readAsUTF8(inputStream);
                    return readAsUTF8;
                } finally {
                    inputStream.close();
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Got status code: ");
                stringBuilder.append(responseCode);
                stringBuilder.append(" while downloading ");
                stringBuilder.append("schema with url: ");
                stringBuilder.append(this.url.toString());
                throw new IOException(stringBuilder.toString());
            }
        }
    }

    protected abstract void doPrint(PrintWriter printWriter, InputStream inputStream, String str);

    protected abstract MatchResult matchAndParseHeader(String str, String str2);

    public AsyncPrettyPrinter getInstance(String str, String str2) {
        final MatchResult matchAndParseHeader = matchAndParseHeader(str, str2);
        if (matchAndParseHeader == null) {
            return null;
        }
        URL parseURL = parseURL(matchAndParseHeader.getSchemaUri());
        if (parseURL == null) {
            return getErrorAsyncPrettyPrinter(str, str2);
        }
        str = AsyncPrettyPrinterExecutorHolder.getExecutorService();
        if (str == null) {
            return null;
        }
        str = str.submit(new Request(parseURL));
        return new AsyncPrettyPrinter() {
            public void printTo(PrintWriter printWriter, InputStream inputStream) {
                StringBuilder stringBuilder;
                try {
                    DownloadingAsyncPrettyPrinterFactory.this.doPrint(printWriter, inputStream, (String) str.get());
                } catch (ExecutionException e) {
                    if (IOException.class.isInstance(e.getCause())) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Cannot successfully download schema: ");
                        stringBuilder.append(e.getMessage());
                        DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, stringBuilder.toString());
                        return;
                    }
                    throw e;
                } catch (InterruptedException e2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Encountered spurious interrupt while downloading schema for pretty printing: ");
                    stringBuilder.append(e2.getMessage());
                    DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, stringBuilder.toString());
                } catch (PrintWriter printWriter2) {
                    throw ExceptionUtil.propagate(printWriter2.getCause());
                }
            }

            public PrettyPrinterDisplayType getPrettifiedType() {
                return matchAndParseHeader.getDisplayType();
            }
        };
    }

    private static java.net.URL parseURL(java.lang.String r1) {
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
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0006 }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x0006 }
        return r0;
    L_0x0006:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.network.DownloadingAsyncPrettyPrinterFactory.parseURL(java.lang.String):java.net.URL");
    }

    private static void doErrorPrint(PrintWriter printWriter, InputStream inputStream, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        stringBuilder.append(Util.readAsUTF8(inputStream));
        printWriter.print(stringBuilder.toString());
    }

    private static AsyncPrettyPrinter getErrorAsyncPrettyPrinter(final String str, final String str2) {
        return new AsyncPrettyPrinter() {
            public void printTo(PrintWriter printWriter, InputStream inputStream) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[Failed to parse header: ");
                stringBuilder.append(str);
                stringBuilder.append(" : ");
                stringBuilder.append(str2);
                stringBuilder.append(" ]");
                DownloadingAsyncPrettyPrinterFactory.doErrorPrint(printWriter, inputStream, stringBuilder.toString());
            }

            public PrettyPrinterDisplayType getPrettifiedType() {
                return PrettyPrinterDisplayType.TEXT;
            }
        };
    }
}

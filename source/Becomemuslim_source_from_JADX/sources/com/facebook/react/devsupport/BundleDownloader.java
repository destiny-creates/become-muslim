package com.facebook.react.devsupport;

import android.util.Log;
import com.facebook.cache.disk.DefaultDiskStorage.FileType;
import com.facebook.common.logging.FLog;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.NativeDeltaClient;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.BundleDeltaClient.ClientType;
import com.facebook.react.devsupport.MultipartStreamReader.ChunkListener;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.stetho.server.http.HttpHeaders;
import com.facebook.stetho.server.http.HttpStatus;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import expolib_v1.p321a.C6216e;
import expolib_v1.p321a.C6217f;
import expolib_v1.p321a.C6234q;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.ab;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C8170c;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class BundleDownloader {
    private static final int FILES_CHANGED_COUNT_NOT_BUILT_BY_BUNDLER = -2;
    private static final String TAG = "BundleDownloader";
    private BundleDeltaClient mBundleDeltaClient;
    private final C7490w mClient;
    private C6216e mDownloadBundleFromURLCall;

    public static class BundleInfo {
        private String mDeltaClientName;
        private int mFilesChangedCount;
        private String mUrl;

        public static BundleInfo fromJSONString(String str) {
            if (str == null) {
                return null;
            }
            BundleInfo bundleInfo = new BundleInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                bundleInfo.mDeltaClientName = jSONObject.getString("deltaClient");
                bundleInfo.mUrl = jSONObject.getString("url");
                bundleInfo.mFilesChangedCount = jSONObject.getInt("filesChangedCount");
                return bundleInfo;
            } catch (String str2) {
                Log.e(BundleDownloader.TAG, "Invalid bundle info: ", str2);
                return null;
            }
        }

        public String toJSONString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deltaClient", this.mDeltaClientName);
                jSONObject.put("url", this.mUrl);
                jSONObject.put("filesChangedCount", this.mFilesChangedCount);
                return jSONObject.toString();
            } catch (Throwable e) {
                Log.e(BundleDownloader.TAG, "Can't serialize bundle info: ", e);
                return null;
            }
        }

        public String getDeltaClient() {
            return this.mDeltaClientName;
        }

        public String getUrl() {
            return this.mUrl != null ? this.mUrl : "unknown";
        }

        public int getFilesChangedCount() {
            return this.mFilesChangedCount;
        }
    }

    public BundleDownloader(C7490w c7490w) {
        this.mClient = c7490w;
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleInfo bundleInfo, ClientType clientType) {
        downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, clientType, new C6245a());
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleInfo bundleInfo, ClientType clientType, C6245a c6245a) {
        this.mDownloadBundleFromURLCall = (C6216e) Assertions.assertNotNull(this.mClient.a(c6245a.a(formatBundleUrl(str, clientType)).b("Accept", "multipart/mixed").b()));
        final DevBundleDownloadListener devBundleDownloadListener2 = devBundleDownloadListener;
        final File file2 = file;
        final BundleInfo bundleInfo2 = bundleInfo;
        final ClientType clientType2 = clientType;
        this.mDownloadBundleFromURLCall.a(new C6217f() {
            public void onFailure(C6216e c6216e, IOException iOException) {
                if (BundleDownloader.this.mDownloadBundleFromURLCall != null) {
                    if (!BundleDownloader.this.mDownloadBundleFromURLCall.d()) {
                        BundleDownloader.this.mDownloadBundleFromURLCall = null;
                        DevBundleDownloadListener devBundleDownloadListener = devBundleDownloadListener2;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("URL: ");
                        stringBuilder.append(c6216e.a().a().toString());
                        devBundleDownloadListener.onFailure(DebugServerException.makeGeneric("Could not connect to development server.", stringBuilder.toString(), iOException));
                        return;
                    }
                }
                BundleDownloader.this.mDownloadBundleFromURLCall = null;
            }

            public void onResponse(C6216e c6216e, ab abVar) {
                C6216e c6216e2;
                if (BundleDownloader.this.mDownloadBundleFromURLCall != null) {
                    if (BundleDownloader.this.mDownloadBundleFromURLCall.d() == null) {
                        BundleDownloader.this.mDownloadBundleFromURLCall = null;
                        String c6237r = abVar.a().a().toString();
                        c6216e = Pattern.compile("multipart/mixed;.*boundary=\"([^\"]+)\"").matcher(abVar.a("content-type"));
                        try {
                            if (c6216e.find()) {
                                BundleDownloader.this.processMultipartResponse(c6237r, abVar, c6216e.group(1), file2, bundleInfo2, clientType2, devBundleDownloadListener2);
                            } else {
                                BundleDownloader.this.processBundleResult(c6237r, abVar.c(), abVar.g(), C6252l.a(abVar.h().source()), file2, bundleInfo2, clientType2, devBundleDownloadListener2);
                            }
                            if (abVar != null) {
                                abVar.close();
                            }
                            return;
                        } catch (ab abVar2) {
                            c6216e2.addSuppressed(abVar2);
                        }
                    }
                }
                BundleDownloader.this.mDownloadBundleFromURLCall = null;
            }
        });
    }

    private String formatBundleUrl(String str, ClientType clientType) {
        return (!BundleDeltaClient.isDeltaUrl(str) || this.mBundleDeltaClient == null || this.mBundleDeltaClient.canHandle(clientType) == null) ? str : this.mBundleDeltaClient.extendUrlForDelta(str);
    }

    private void processMultipartResponse(String str, ab abVar, String str2, File file, BundleInfo bundleInfo, ClientType clientType, DevBundleDownloadListener devBundleDownloadListener) {
        String str3 = str2;
        final ab abVar2 = abVar;
        final String str4 = str;
        final File file2 = file;
        final BundleInfo bundleInfo2 = bundleInfo;
        final ClientType clientType2 = clientType;
        final DevBundleDownloadListener devBundleDownloadListener2 = devBundleDownloadListener;
        if (!new MultipartStreamReader(abVar.h().source(), str2).readAllParts(new ChunkListener() {
            public void onChunkComplete(Map<String, String> map, C8170c c8170c, boolean z) {
                if (z) {
                    z = abVar2.c();
                    if (map.containsKey("X-Http-Status")) {
                        z = Integer.parseInt((String) map.get("X-Http-Status"));
                    }
                    BundleDownloader.this.processBundleResult(str4, z, C6234q.a(map), c8170c, file2, bundleInfo2, clientType2, devBundleDownloadListener2);
                } else {
                    if (map.containsKey(HttpHeaders.CONTENT_TYPE)) {
                        if (((String) map.get(HttpHeaders.CONTENT_TYPE)).equals("application/json") != null) {
                            try {
                                map = new JSONObject(c8170c.r());
                                z = false;
                                c8170c = map.has(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) != null ? map.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) : null;
                                Integer valueOf = map.has("done") ? Integer.valueOf(map.getInt("done")) : null;
                                if (map.has("total")) {
                                    z = Integer.valueOf(map.getInt("total"));
                                }
                                devBundleDownloadListener2.onProgress(c8170c, valueOf, z);
                            } catch (Map<String, String> map2) {
                                String str = ReactConstants.TAG;
                                z = new StringBuilder();
                                z.append("Error parsing progress JSON. ");
                                z.append(map2.toString());
                                FLog.m5674e(str, z.toString());
                            }
                        }
                    }
                }
            }

            public void onChunkProgress(Map<String, String> map, long j, long j2) {
                if ("application/javascript".equals(map.get(HttpHeaders.CONTENT_TYPE)) != null) {
                    devBundleDownloadListener2.onProgress("Downloading JavaScript bundle", Integer.valueOf((int) (j / 1024)), Integer.valueOf((int) (j2 / 1024)));
                }
            }
        })) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error while reading multipart response.\n\nResponse code: ");
            stringBuilder.append(abVar.c());
            stringBuilder.append("\n\nURL: ");
            stringBuilder.append(str.toString());
            stringBuilder.append("\n\n");
            devBundleDownloadListener.onFailure(new DebugServerException(stringBuilder.toString()));
        }
    }

    private void processBundleResult(String str, int i, C6234q c6234q, C7497e c7497e, File file, BundleInfo bundleInfo, ClientType clientType, DevBundleDownloadListener devBundleDownloadListener) {
        if (i != HttpStatus.HTTP_OK) {
            c6234q = c7497e.r().replaceAll("\\\\u001b\\[[\\d;]*m", "");
            c7497e = DebugServerException.parse(c6234q);
            if (c7497e != null) {
                devBundleDownloadListener.onFailure(c7497e);
            } else {
                c7497e = new StringBuilder();
                c7497e.append("The development server returned response error code: ");
                c7497e.append(i);
                c7497e.append("\n\n");
                c7497e.append("URL: ");
                c7497e.append(str);
                c7497e.append("\n\n");
                c7497e.append("Body:\n");
                c7497e.append(c6234q);
                devBundleDownloadListener.onFailure(new DebugServerException(c7497e.toString()));
            }
            return;
        }
        if (bundleInfo != null) {
            populateBundleInfo(str, c6234q, clientType, bundleInfo);
        }
        bundleInfo = new StringBuilder();
        bundleInfo.append(file.getPath());
        bundleInfo.append(FileType.TEMP);
        i = new File(bundleInfo.toString());
        bundleInfo = null;
        if (BundleDeltaClient.isDeltaUrl(str) != null) {
            str = getBundleDeltaClient(clientType);
            Assertions.assertNotNull(str);
            str = str.processDelta(c6234q, c7497e, i);
            c6234q = ((Boolean) str.first).booleanValue();
            bundleInfo = (NativeDeltaClient) str.second;
        } else {
            this.mBundleDeltaClient = null;
            c6234q = storePlainJSInFile(c7497e, i);
        }
        if (c6234q != null) {
            if (i.renameTo(file) == null) {
                c6234q = new StringBuilder();
                c6234q.append("Couldn't rename ");
                c6234q.append(i);
                c6234q.append(" to ");
                c6234q.append(file);
                throw new IOException(c6234q.toString());
            }
        }
        devBundleDownloadListener.onSuccess(bundleInfo);
    }

    private BundleDeltaClient getBundleDeltaClient(ClientType clientType) {
        if (this.mBundleDeltaClient == null || !this.mBundleDeltaClient.canHandle(clientType)) {
            this.mBundleDeltaClient = BundleDeltaClient.create(clientType);
        }
        return this.mBundleDeltaClient;
    }

    private static boolean storePlainJSInFile(C7497e c7497e, File file) {
        try {
            file = C6252l.b(file);
            try {
                c7497e.a(file);
                if (file != null) {
                    file.close();
                }
                return true;
            } catch (Throwable th) {
                c7497e = th;
                if (file != null) {
                    file.close();
                }
                throw c7497e;
            }
        } catch (Throwable th2) {
            c7497e = th2;
            file = null;
            if (file != null) {
                file.close();
            }
            throw c7497e;
        }
    }

    private static void populateBundleInfo(java.lang.String r1, expolib_v1.p321a.C6234q r2, com.facebook.react.devsupport.BundleDeltaClient.ClientType r3, com.facebook.react.devsupport.BundleDownloader.BundleInfo r4) {
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
        r0 = com.facebook.react.devsupport.BundleDeltaClient.ClientType.NONE;
        if (r3 != r0) goto L_0x0006;
    L_0x0004:
        r3 = 0;
        goto L_0x000a;
    L_0x0006:
        r3 = r3.name();
    L_0x000a:
        r4.mDeltaClientName = r3;
        r4.mUrl = r1;
        r1 = "X-Metro-Files-Changed-Count";
        r1 = r2.a(r1);
        if (r1 == 0) goto L_0x0024;
    L_0x0018:
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x0020 }
        r4.mFilesChangedCount = r1;	 Catch:{ NumberFormatException -> 0x0020 }
        goto L_0x0024;
    L_0x0020:
        r1 = -2;
        r4.mFilesChangedCount = r1;
    L_0x0024:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.BundleDownloader.populateBundleInfo(java.lang.String, expolib_v1.a.q, com.facebook.react.devsupport.BundleDeltaClient$ClientType, com.facebook.react.devsupport.BundleDownloader$BundleInfo):void");
    }
}

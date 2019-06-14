package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class FileIoHandler implements Runnable {
    private static final long FILE_TTL = 30000;
    private static final String TAG = JSPackagerClient.class.getSimpleName();
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private int mNextHandle = 1;
    private final Map<Integer, TtlFileInputStream> mOpenFiles = new HashMap();
    private final Map<String, RequestHandler> mRequestHandlers = new HashMap();

    private static class TtlFileInputStream {
        private final FileInputStream mStream;
        private long mTtl = (System.currentTimeMillis() + 30000);

        public TtlFileInputStream(String str) {
            this.mStream = new FileInputStream(str);
        }

        private void extendTtl() {
            this.mTtl = System.currentTimeMillis() + 30000;
        }

        public boolean expiredTtl() {
            return System.currentTimeMillis() >= this.mTtl;
        }

        public String read(int i) {
            extendTtl();
            i = new byte[i];
            return Base64.encodeToString(i, 0, this.mStream.read(i), 0);
        }

        public void close() {
            this.mStream.close();
        }
    }

    /* renamed from: com.facebook.react.packagerconnection.FileIoHandler$1 */
    class C46731 extends RequestOnlyHandler {
        C46731() {
        }

        public void onRequest(Object obj, Responder responder) {
            synchronized (FileIoHandler.this.mOpenFiles) {
                try {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("mode");
                        if (optString != null) {
                            obj = jSONObject.optString("filename");
                            if (obj == null) {
                                throw new Exception("missing params.filename");
                            } else if (optString.equals("r")) {
                                responder.respond(Integer.valueOf(FileIoHandler.this.addOpenFile(obj)));
                            } else {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("unsupported mode: ");
                                stringBuilder.append(optString);
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                        }
                        throw new Exception("missing params.mode");
                    }
                    throw new Exception("params must be an object { mode: string, filename: string }");
                } catch (Object obj2) {
                    responder.error(obj2.toString());
                }
            }
        }
    }

    /* renamed from: com.facebook.react.packagerconnection.FileIoHandler$2 */
    class C46742 extends RequestOnlyHandler {
        C46742() {
        }

        public void onRequest(Object obj, Responder responder) {
            synchronized (FileIoHandler.this.mOpenFiles) {
                try {
                    if (obj instanceof Number) {
                        TtlFileInputStream ttlFileInputStream = (TtlFileInputStream) FileIoHandler.this.mOpenFiles.get(Integer.valueOf(((Integer) obj).intValue()));
                        if (ttlFileInputStream != null) {
                            FileIoHandler.this.mOpenFiles.remove(Integer.valueOf(((Integer) obj).intValue()));
                            ttlFileInputStream.close();
                            responder.respond("");
                        } else {
                            throw new Exception("invalid file handle, it might have timed out");
                        }
                    }
                    throw new Exception("params must be a file handle");
                } catch (Object obj2) {
                    responder.error(obj2.toString());
                }
            }
        }
    }

    /* renamed from: com.facebook.react.packagerconnection.FileIoHandler$3 */
    class C46753 extends RequestOnlyHandler {
        C46753() {
        }

        public void onRequest(Object obj, Responder responder) {
            synchronized (FileIoHandler.this.mOpenFiles) {
                try {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt(UriUtil.LOCAL_FILE_SCHEME);
                        if (optInt != 0) {
                            obj = jSONObject.optInt("size");
                            if (obj != null) {
                                TtlFileInputStream ttlFileInputStream = (TtlFileInputStream) FileIoHandler.this.mOpenFiles.get(Integer.valueOf(optInt));
                                if (ttlFileInputStream != null) {
                                    responder.respond(ttlFileInputStream.read(obj));
                                } else {
                                    throw new Exception("invalid file handle, it might have timed out");
                                }
                            }
                            throw new Exception("invalid or missing read size");
                        }
                        throw new Exception("invalid or missing file handle");
                    }
                    throw new Exception("params must be an object { file: handle, size: number }");
                } catch (Object obj2) {
                    responder.error(obj2.toString());
                }
            }
        }
    }

    public FileIoHandler() {
        this.mRequestHandlers.put("fopen", new C46731());
        this.mRequestHandlers.put("fclose", new C46742());
        this.mRequestHandlers.put("fread", new C46753());
    }

    public Map<String, RequestHandler> handlers() {
        return this.mRequestHandlers;
    }

    private int addOpenFile(String str) {
        int i = this.mNextHandle;
        this.mNextHandle = i + 1;
        this.mOpenFiles.put(Integer.valueOf(i), new TtlFileInputStream(str));
        if (this.mOpenFiles.size() == 1) {
            this.mHandler.postDelayed(this, 30000);
        }
        return i;
    }

    public void run() {
        synchronized (this.mOpenFiles) {
            Iterator it = this.mOpenFiles.values().iterator();
            while (it.hasNext()) {
                TtlFileInputStream ttlFileInputStream = (TtlFileInputStream) it.next();
                if (ttlFileInputStream.expiredTtl()) {
                    it.remove();
                    try {
                        ttlFileInputStream.close();
                    } catch (IOException e) {
                        String str = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("closing expired file failed: ");
                        stringBuilder.append(e.toString());
                        FLog.m5674e(str, stringBuilder.toString());
                    }
                }
            }
            if (!this.mOpenFiles.isEmpty()) {
                this.mHandler.postDelayed(this, 30000);
            }
        }
    }
}

package com.facebook.react.devsupport;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Pair;
import com.facebook.react.bridge.NativeDeltaClient;
import expolib_v1.p321a.C6234q;
import expolib_v1.p332b.C7497e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.LinkedHashMap;

public abstract class BundleDeltaClient {
    private static final String METRO_DELTA_ID_HEADER = "X-Metro-Delta-ID";
    private String mDeltaId;

    public enum ClientType {
        NONE,
        DEV_SUPPORT,
        NATIVE
    }

    private static class BundleDeltaJavaClient extends BundleDeltaClient {
        final LinkedHashMap<Number, byte[]> mDeltaModules;
        final LinkedHashMap<Number, byte[]> mPostModules;
        final LinkedHashMap<Number, byte[]> mPreModules;

        private BundleDeltaJavaClient() {
            this.mPreModules = new LinkedHashMap();
            this.mDeltaModules = new LinkedHashMap();
            this.mPostModules = new LinkedHashMap();
        }

        public boolean canHandle(ClientType clientType) {
            return clientType == ClientType.DEV_SUPPORT ? true : null;
        }

        public void reset() {
            super.reset();
            this.mDeltaModules.clear();
            this.mPreModules.clear();
            this.mPostModules.clear();
        }

        public synchronized Pair<Boolean, NativeDeltaClient> processDelta(C7497e c7497e, File file) {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(c7497e.g()));
            jsonReader.beginObject();
            c7497e = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (nextName.equals("pre")) {
                    c7497e += patchDelta(jsonReader, this.mPreModules);
                } else if (nextName.equals("post")) {
                    c7497e += patchDelta(jsonReader, this.mPostModules);
                } else if (nextName.equals("delta")) {
                    c7497e += patchDelta(jsonReader, this.mDeltaModules);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            jsonReader.close();
            if (c7497e == null) {
                return Pair.create(Boolean.FALSE, null);
            }
            c7497e = new FileOutputStream(file);
            try {
                for (byte[] write : this.mPreModules.values()) {
                    c7497e.write(write);
                    c7497e.write(10);
                }
                for (byte[] write2 : this.mDeltaModules.values()) {
                    c7497e.write(write2);
                    c7497e.write(10);
                }
                for (byte[] write22 : this.mPostModules.values()) {
                    c7497e.write(write22);
                    c7497e.write(10);
                }
                return Pair.create(Boolean.TRUE, null);
            } finally {
                c7497e.flush();
                c7497e.close();
            }
        }

        private static int patchDelta(JsonReader jsonReader, LinkedHashMap<Number, byte[]> linkedHashMap) {
            jsonReader.beginArray();
            int i = 0;
            while (jsonReader.hasNext()) {
                jsonReader.beginArray();
                int nextInt = jsonReader.nextInt();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.skipValue();
                    linkedHashMap.remove(Integer.valueOf(nextInt));
                } else {
                    linkedHashMap.put(Integer.valueOf(nextInt), jsonReader.nextString().getBytes());
                }
                jsonReader.endArray();
                i++;
            }
            jsonReader.endArray();
            return i;
        }
    }

    private static class BundleDeltaNativeClient extends BundleDeltaClient {
        private final NativeDeltaClient nativeClient;

        private static class ReadableBufferedSource implements ReadableByteChannel {
            private C7497e mBufferedSource;

            public boolean isOpen() {
                return false;
            }

            ReadableBufferedSource(C7497e c7497e) {
                this.mBufferedSource = c7497e;
            }

            public int read(ByteBuffer byteBuffer) {
                if (this.mBufferedSource.b().a() == 0 && this.mBufferedSource.read(this.mBufferedSource.b(), 8192) == -1) {
                    return -1;
                }
                return this.mBufferedSource.b().a(byteBuffer.array());
            }

            public void close() {
                this.mBufferedSource.close();
            }
        }

        private BundleDeltaNativeClient() {
            this.nativeClient = new NativeDeltaClient();
        }

        public boolean canHandle(ClientType clientType) {
            return clientType == ClientType.NATIVE ? true : null;
        }

        protected Pair<Boolean, NativeDeltaClient> processDelta(C7497e c7497e, File file) {
            this.nativeClient.processDelta(new ReadableBufferedSource(c7497e));
            return Pair.create(Boolean.FALSE, this.nativeClient);
        }

        public void reset() {
            super.reset();
            this.nativeClient.reset();
        }
    }

    public abstract boolean canHandle(ClientType clientType);

    protected abstract Pair<Boolean, NativeDeltaClient> processDelta(C7497e c7497e, File file);

    static boolean isDeltaUrl(String str) {
        return str.indexOf(".delta?") != -1 ? true : null;
    }

    static BundleDeltaClient create(ClientType clientType) {
        switch (clientType) {
            case DEV_SUPPORT:
                return new BundleDeltaJavaClient();
            case NATIVE:
                return new BundleDeltaNativeClient();
            default:
                return null;
        }
    }

    public final String extendUrlForDelta(String str) {
        if (this.mDeltaId == null) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("&deltaBundleId=");
        stringBuilder.append(this.mDeltaId);
        return stringBuilder.toString();
    }

    public void reset() {
        this.mDeltaId = null;
    }

    public Pair<Boolean, NativeDeltaClient> processDelta(C6234q c6234q, C7497e c7497e, File file) {
        this.mDeltaId = c6234q.a(METRO_DELTA_ID_HEADER);
        return processDelta(c7497e, file);
    }
}

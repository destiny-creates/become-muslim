package com.facebook.react.modules.blob;

import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.network.NetworkingModule.RequestBodyHandler;
import com.facebook.react.modules.network.NetworkingModule.ResponseHandler;
import com.facebook.react.modules.network.NetworkingModule.UriHandler;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.modules.websocket.WebSocketModule.ContentHandler;
import com.facebook.stetho.common.Utf8Charset;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.aa;
import expolib_v1.p321a.ac;
import expolib_v1.p332b.C6251f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

@ReactModule(name = "BlobModule")
public class BlobModule extends ReactContextBaseJavaModule {
    protected static final String NAME = "BlobModule";
    private final Map<String, byte[]> mBlobs = new HashMap();
    private final RequestBodyHandler mNetworkingRequestBodyHandler = new C38493();
    private final ResponseHandler mNetworkingResponseHandler = new C38504();
    private final UriHandler mNetworkingUriHandler = new C38482();
    private final ContentHandler mWebSocketContentHandler = new C38471();

    /* renamed from: com.facebook.react.modules.blob.BlobModule$1 */
    class C38471 implements ContentHandler {
        C38471() {
        }

        public void onMessage(String str, WritableMap writableMap) {
            writableMap.putString("data", str);
        }

        public void onMessage(C6251f c6251f, WritableMap writableMap) {
            c6251f = c6251f.i();
            WritableMap createMap = Arguments.createMap();
            createMap.putString("blobId", BlobModule.this.store(c6251f));
            createMap.putInt("offset", 0);
            createMap.putInt("size", c6251f.length);
            writableMap.putMap("data", createMap);
            writableMap.putString("type", "blob");
        }
    }

    /* renamed from: com.facebook.react.modules.blob.BlobModule$2 */
    class C38482 implements UriHandler {
        C38482() {
        }

        public boolean supports(Uri uri, String str) {
            uri = uri.getScheme();
            if (!UriUtil.HTTP_SCHEME.equals(uri)) {
                if (UriUtil.HTTPS_SCHEME.equals(uri) == null) {
                    uri = null;
                    if (uri != null && "blob".equals(str) != null) {
                        return true;
                    }
                }
            }
            uri = true;
            return uri != null ? false : false;
        }

        public WritableMap fetch(Uri uri) {
            byte[] access$000 = BlobModule.this.getBytesFromUri(uri);
            WritableMap createMap = Arguments.createMap();
            createMap.putString("blobId", BlobModule.this.store(access$000));
            createMap.putInt("offset", 0);
            createMap.putInt("size", access$000.length);
            createMap.putString("type", BlobModule.this.getMimeTypeFromUri(uri));
            createMap.putString("name", BlobModule.this.getNameFromUri(uri));
            createMap.putDouble("lastModified", (double) BlobModule.this.getLastModifiedFromUri(uri));
            return createMap;
        }
    }

    /* renamed from: com.facebook.react.modules.blob.BlobModule$3 */
    class C38493 implements RequestBodyHandler {
        C38493() {
        }

        public boolean supports(ReadableMap readableMap) {
            return readableMap.hasKey("blob");
        }

        public aa toRequestBody(ReadableMap readableMap, String str) {
            if (readableMap.hasKey("type") && !readableMap.getString("type").isEmpty()) {
                str = readableMap.getString("type");
            }
            if (str == null) {
                str = "application/octet-stream";
            }
            readableMap = readableMap.getMap("blob");
            return aa.create(C6240u.a(str), BlobModule.this.resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt("size")));
        }
    }

    /* renamed from: com.facebook.react.modules.blob.BlobModule$4 */
    class C38504 implements ResponseHandler {
        C38504() {
        }

        public boolean supports(String str) {
            return "blob".equals(str);
        }

        public WritableMap toResponseData(ac acVar) {
            acVar = acVar.bytes();
            WritableMap createMap = Arguments.createMap();
            createMap.putString("blobId", BlobModule.this.store(acVar));
            createMap.putInt("offset", 0);
            createMap.putInt("size", acVar.length);
            return createMap;
        }
    }

    public String getName() {
        return NAME;
    }

    public BlobModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        Resources resources = getReactApplicationContext().getResources();
        int identifier = resources.getIdentifier("blob_provider_authority", "string", getReactApplicationContext().getPackageName());
        if (identifier == 0) {
            return null;
        }
        return MapBuilder.of("BLOB_URI_SCHEME", UriUtil.LOCAL_CONTENT_SCHEME, "BLOB_URI_HOST", resources.getString(identifier));
    }

    public String store(byte[] bArr) {
        String uuid = UUID.randomUUID().toString();
        store(bArr, uuid);
        return uuid;
    }

    public void store(byte[] bArr, String str) {
        this.mBlobs.put(str, bArr);
    }

    public void remove(String str) {
        this.mBlobs.remove(str);
    }

    public byte[] resolve(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        String queryParameter = uri.getQueryParameter("offset");
        int parseInt = queryParameter != null ? Integer.parseInt(queryParameter, 10) : 0;
        uri = uri.getQueryParameter("size");
        return resolve(lastPathSegment, parseInt, uri != null ? Integer.parseInt(uri, 10) : -1);
    }

    public byte[] resolve(String str, int i, int i2) {
        str = (byte[]) this.mBlobs.get(str);
        if (str == null) {
            return null;
        }
        if (i2 == -1) {
            i2 = str.length - i;
        }
        if (i > 0 || i2 != str.length) {
            str = Arrays.copyOfRange(str, i, i2 + i);
        }
        return str;
    }

    public byte[] resolve(ReadableMap readableMap) {
        return resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt("size"));
    }

    private byte[] getBytesFromUri(Uri uri) {
        InputStream openInputStream = getReactApplicationContext().getContentResolver().openInputStream(uri);
        if (openInputStream != null) {
            uri = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read == -1) {
                    return uri.toByteArray();
                }
                uri.write(bArr, 0, read);
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("File not found for ");
            stringBuilder.append(uri);
            throw new FileNotFoundException(stringBuilder.toString());
        }
    }

    private String getNameFromUri(Uri uri) {
        if (UriUtil.LOCAL_FILE_SCHEME.equals(uri.getScheme())) {
            return uri.getLastPathSegment();
        }
        Cursor query = getReactApplicationContext().getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    uri = query.getString(null);
                    return uri;
                }
                query.close();
            } finally {
                query.close();
            }
        }
        return uri.getLastPathSegment();
    }

    private long getLastModifiedFromUri(Uri uri) {
        return UriUtil.LOCAL_FILE_SCHEME.equals(uri.getScheme()) ? new File(uri.toString()).lastModified() : 0;
    }

    private String getMimeTypeFromUri(Uri uri) {
        String type = getReactApplicationContext().getContentResolver().getType(uri);
        if (type == null) {
            uri = MimeTypeMap.getFileExtensionFromUrl(uri.getPath());
            if (uri != null) {
                type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(uri);
            }
        }
        return type == null ? "" : type;
    }

    private WebSocketModule getWebSocketModule() {
        return (WebSocketModule) getReactApplicationContext().getNativeModule(WebSocketModule.class);
    }

    @ReactMethod
    public void addNetworkingHandler() {
        NetworkingModule networkingModule = (NetworkingModule) getReactApplicationContext().getNativeModule(NetworkingModule.class);
        networkingModule.addUriHandler(this.mNetworkingUriHandler);
        networkingModule.addRequestBodyHandler(this.mNetworkingRequestBodyHandler);
        networkingModule.addResponseHandler(this.mNetworkingResponseHandler);
    }

    @ReactMethod
    public void addWebSocketHandler(int i) {
        getWebSocketModule().setContentHandler(i, this.mWebSocketContentHandler);
    }

    @ReactMethod
    public void removeWebSocketHandler(int i) {
        getWebSocketModule().setContentHandler(i, null);
    }

    @ReactMethod
    public void sendOverSocket(ReadableMap readableMap, int i) {
        readableMap = resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt("size"));
        if (readableMap != null) {
            getWebSocketModule().sendBinary(C6251f.a(readableMap), i);
        } else {
            getWebSocketModule().sendBinary((C6251f) null, i);
        }
    }

    @ReactMethod
    public void createFromParts(ReadableArray readableArray, String str) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        int i = 0;
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            Object obj;
            Object bytes;
            ReadableMap map = readableArray.getMap(i2);
            String string = map.getString("type");
            int hashCode = string.hashCode();
            if (hashCode != -891985903) {
                if (hashCode == 3026845) {
                    if (string.equals("blob")) {
                        obj = null;
                        switch (obj) {
                            case null:
                                map = map.getMap("data");
                                i += map.getInt("size");
                                arrayList.add(i2, resolve(map));
                                break;
                            case 1:
                                bytes = map.getString("data").getBytes(Charset.forName(Utf8Charset.NAME));
                                i += bytes.length;
                                arrayList.add(i2, bytes);
                                break;
                            default:
                                str = new StringBuilder();
                                str.append("Invalid type for blob: ");
                                str.append(map.getString("type"));
                                throw new IllegalArgumentException(str.toString());
                        }
                    }
                }
            } else if (string.equals("string")) {
                obj = 1;
                switch (obj) {
                    case null:
                        map = map.getMap("data");
                        i += map.getInt("size");
                        arrayList.add(i2, resolve(map));
                        break;
                    case 1:
                        bytes = map.getString("data").getBytes(Charset.forName(Utf8Charset.NAME));
                        i += bytes.length;
                        arrayList.add(i2, bytes);
                        break;
                    default:
                        str = new StringBuilder();
                        str.append("Invalid type for blob: ");
                        str.append(map.getString("type"));
                        throw new IllegalArgumentException(str.toString());
                }
            }
            obj = -1;
            switch (obj) {
                case null:
                    map = map.getMap("data");
                    i += map.getInt("size");
                    arrayList.add(i2, resolve(map));
                    break;
                case 1:
                    bytes = map.getString("data").getBytes(Charset.forName(Utf8Charset.NAME));
                    i += bytes.length;
                    arrayList.add(i2, bytes);
                    break;
                default:
                    str = new StringBuilder();
                    str.append("Invalid type for blob: ");
                    str.append(map.getString("type"));
                    throw new IllegalArgumentException(str.toString());
            }
        }
        readableArray = ByteBuffer.allocate(i);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            readableArray.put((byte[]) it.next());
        }
        store(readableArray.array(), str);
    }

    @ReactMethod
    public void release(String str) {
        remove(str);
    }
}

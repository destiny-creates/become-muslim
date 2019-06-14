package versioned.host.exp.exponent.modules.api;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.GraphResponse;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import host.exp.exponent.C6292b;
import host.exp.exponent.p346j.C6385c;
import host.exp.exponent.p346j.C6393j;
import host.exp.p333a.C6271b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.p371a.p376c.C6645c;
import org.apache.p371a.p376c.C6646d;

public class DocumentPickerModule extends ReactContextBaseJavaModule implements C6292b {
    private static int OPEN_DOCUMENT_CODE = 4137;
    private boolean mCopyToCacheDirectory = true;
    private Promise mPromise;
    private C6393j mScopedContext;

    public String getName() {
        return "ExponentDocumentPicker";
    }

    public DocumentPickerModule(ReactApplicationContext reactApplicationContext, C6393j c6393j) {
        super(reactApplicationContext);
        this.mScopedContext = c6393j;
        C6271b.m25897a().m25912a((C6292b) this);
    }

    @ReactMethod
    public void getDocumentAsync(ReadableMap readableMap, Promise promise) {
        if (this.mPromise != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("type", "cancel");
            this.mPromise.resolve(createMap);
        }
        this.mPromise = promise;
        promise = new Intent("android.intent.action.OPEN_DOCUMENT");
        promise.addCategory("android.intent.category.OPENABLE");
        if (readableMap.hasKey("type")) {
            promise.setType(readableMap.getString("type"));
        } else {
            promise.setType("*/*");
        }
        if (readableMap.hasKey("copyToCacheDirectory") && readableMap.getBoolean("copyToCacheDirectory") == null) {
            this.mCopyToCacheDirectory = null;
        } else {
            this.mCopyToCacheDirectory = true;
        }
        C6271b.m25897a().m25920b().startActivityForResult(promise, OPEN_DOCUMENT_CODE);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Throwable th;
        if (i == OPEN_DOCUMENT_CODE && this.mPromise != 0) {
            i = Arguments.createMap();
            if (i2 == -1) {
                i.putString("type", GraphResponse.SUCCESS_KEY);
                i2 = intent.getData();
                intent = getReactApplicationContext().getContentResolver();
                Cursor query = intent.query(i2, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            String string = query.getString(query.getColumnIndex("_display_name"));
                            i.putString("name", string);
                            if (this.mCopyToCacheDirectory) {
                                i.putString("uri", Uri.fromFile(new File(writeDocument(i2, intent, string))).toString());
                            } else {
                                i.putString("uri", i2.toString());
                            }
                            i2 = query.getColumnIndex("_size");
                            if (query.isNull(i2) == null) {
                                i.putInt("size", query.getInt(i2));
                            } else {
                                i.putNull("size");
                            }
                        }
                    } catch (int i22) {
                        th.addSuppressed(i22);
                    }
                }
                if (query != null) {
                    query.close();
                }
            } else {
                i.putString("type", "cancel");
            }
            this.mPromise.resolve(i);
            this.mPromise = null;
        }
    }

    private String writeDocument(Uri uri, ContentResolver contentResolver, String str) {
        OutputStream fileOutputStream;
        OutputStream outputStream = null;
        try {
            InputStream openInputStream = contentResolver.openInputStream(uri);
            contentResolver = C6385c.m26194a(this.mScopedContext.getCacheDir(), "DocumentPicker", C6645c.m27050c(str));
            try {
                fileOutputStream = new FileOutputStream(new File(contentResolver));
                try {
                    C6646d.m27051a(openInputStream, fileOutputStream);
                } catch (IOException e) {
                    uri = e;
                    outputStream = fileOutputStream;
                    try {
                        uri.printStackTrace();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return contentResolver;
                    } catch (Throwable th) {
                        uri = th;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (ContentResolver contentResolver2) {
                                contentResolver2.printStackTrace();
                            }
                        }
                        throw uri;
                    }
                } catch (Throwable th2) {
                    uri = th2;
                    outputStream = fileOutputStream;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw uri;
                }
            } catch (IOException e2) {
                uri = e2;
                uri.printStackTrace();
                if (outputStream != null) {
                    outputStream.close();
                }
                return contentResolver2;
            }
            try {
                fileOutputStream.close();
            } catch (Uri uri2) {
                uri2.printStackTrace();
            }
        } catch (IOException e3) {
            uri2 = e3;
            contentResolver2 = null;
            uri2.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
            return contentResolver2;
        }
        return contentResolver2;
    }
}

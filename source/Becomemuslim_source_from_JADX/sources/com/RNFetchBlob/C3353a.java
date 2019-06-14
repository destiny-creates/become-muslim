package com.RNFetchBlob;

import android.util.Base64;
import com.RNFetchBlob.C0874g.C0871a;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.aa;
import expolib_v1.p332b.C7496d;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* compiled from: RNFetchBlobBody */
/* renamed from: com.RNFetchBlob.a */
public class C3353a extends aa {
    /* renamed from: a */
    InputStream f8908a;
    /* renamed from: b */
    long f8909b = 0;
    /* renamed from: c */
    ReadableArray f8910c;
    /* renamed from: d */
    String f8911d;
    /* renamed from: e */
    String f8912e;
    /* renamed from: f */
    C0871a f8913f;
    /* renamed from: g */
    C6240u f8914g;
    /* renamed from: h */
    File f8915h;
    /* renamed from: i */
    int f8916i = 0;
    /* renamed from: j */
    Boolean f8917j = Boolean.valueOf(false);

    /* compiled from: RNFetchBlobBody */
    /* renamed from: com.RNFetchBlob.a$a */
    private class C0859a {
        /* renamed from: a */
        public String f2396a;
        /* renamed from: b */
        public String f2397b;
        /* renamed from: c */
        public String f2398c;
        /* renamed from: d */
        public String f2399d;
        /* renamed from: e */
        final /* synthetic */ C3353a f2400e;

        public C0859a(C3353a c3353a, ReadableMap readableMap) {
            this.f2400e = c3353a;
            if (readableMap.hasKey("name") != null) {
                this.f2396a = readableMap.getString("name");
            }
            if (readableMap.hasKey("filename") != null) {
                this.f2397b = readableMap.getString("filename");
            }
            if (readableMap.hasKey("type") != null) {
                this.f2398c = readableMap.getString("type");
            } else {
                this.f2398c = this.f2397b == null ? "text/plain" : "application/octet-stream";
            }
            if (readableMap.hasKey("data") != null) {
                this.f2399d = readableMap.getString("data");
            }
        }
    }

    public C3353a(String str) {
        this.f8911d = str;
    }

    /* renamed from: a */
    C3353a m10660a(boolean z) {
        this.f8917j = Boolean.valueOf(z);
        return this;
    }

    /* renamed from: a */
    C3353a m10658a(C6240u c6240u) {
        this.f8914g = c6240u;
        return this;
    }

    /* renamed from: a */
    C3353a m10656a(C0871a c0871a) {
        this.f8913f = c0871a;
        return this;
    }

    /* renamed from: a */
    C3353a m10659a(String str) {
        this.f8912e = str;
        if (this.f8912e == null) {
            this.f8912e = "";
            this.f8913f = C0871a.AsIs;
        }
        try {
            switch (this.f8913f) {
                case SingleFile:
                    this.f8908a = m10653b();
                    this.f8909b = (long) this.f8908a.available();
                    break;
                case AsIs:
                    this.f8909b = (long) this.f8912e.getBytes().length;
                    this.f8908a = new ByteArrayInputStream(this.f8912e.getBytes());
                    break;
                default:
                    break;
            }
        } catch (String str2) {
            str2.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RNFetchBlob failed to create single content request body :");
            stringBuilder.append(str2.getLocalizedMessage());
            stringBuilder.append("\r\n");
            C0877h.m3120b(stringBuilder.toString());
        }
        return this;
    }

    /* renamed from: a */
    C3353a m10657a(ReadableArray readableArray) {
        this.f8910c = readableArray;
        try {
            this.f8915h = m10654c();
            this.f8908a = new FileInputStream(this.f8915h);
            this.f8909b = this.f8915h.length();
        } catch (ReadableArray readableArray2) {
            readableArray2.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RNFetchBlob failed to create request multipart body :");
            stringBuilder.append(readableArray2.getLocalizedMessage());
            C0877h.m3120b(stringBuilder.toString());
        }
        return this;
    }

    public long contentLength() {
        return this.f8917j.booleanValue() ? -1 : this.f8909b;
    }

    public C6240u contentType() {
        return this.f8914g;
    }

    public void writeTo(C7496d c7496d) {
        try {
            m10651a(this.f8908a, c7496d);
        } catch (C7496d c7496d2) {
            C0877h.m3120b(c7496d2.getLocalizedMessage());
            c7496d2.printStackTrace();
        }
    }

    /* renamed from: a */
    boolean m10661a() {
        try {
            if (this.f8915h != null && this.f8915h.exists()) {
                this.f8915h.delete();
            }
            return true;
        } catch (Exception e) {
            C0877h.m3120b(e.getLocalizedMessage());
            return false;
        }
    }

    /* renamed from: b */
    private InputStream m10653b() {
        StringBuilder stringBuilder;
        if (this.f8912e.startsWith("RNFetchBlob-file://")) {
            String e = C0867d.m3097e(this.f8912e.substring("RNFetchBlob-file://".length()));
            if (C0867d.m3096d(e)) {
                try {
                    return RNFetchBlob.RCTContext.getAssets().open(e.replace("bundle-assets://", ""));
                } catch (Exception e2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("error when getting request stream from asset : ");
                    stringBuilder.append(e2.getLocalizedMessage());
                    throw new Exception(stringBuilder.toString());
                }
            }
            File file = new File(C0867d.m3097e(e));
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                return new FileInputStream(file);
            } catch (Exception e22) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("error when getting request stream: ");
                stringBuilder.append(e22.getLocalizedMessage());
                throw new Exception(stringBuilder.toString());
            }
        }
        try {
            return new ByteArrayInputStream(Base64.decode(this.f8912e, 0));
        } catch (Exception e222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("error when getting request stream: ");
            stringBuilder.append(e222.getLocalizedMessage());
            throw new Exception(stringBuilder.toString());
        }
    }

    /* renamed from: c */
    private File m10654c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RNFetchBlob-");
        stringBuilder.append(this.f8911d);
        String stringBuilder2 = stringBuilder.toString();
        File createTempFile = File.createTempFile("rnfb-form-tmp", "", RNFetchBlob.RCTContext.getCacheDir());
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        ArrayList d = m10655d();
        ReactApplicationContext reactApplicationContext = RNFetchBlob.RCTContext;
        for (int i = 0; i < d.size(); i++) {
            C0859a c0859a = (C0859a) d.get(i);
            String str = c0859a.f2399d;
            String str2 = c0859a.f2396a;
            if (str2 != null) {
                if (str != null) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("--");
                    stringBuilder3.append(stringBuilder2);
                    stringBuilder3.append("\r\n");
                    String stringBuilder4 = stringBuilder3.toString();
                    StringBuilder stringBuilder5;
                    StringBuilder stringBuilder6;
                    if (c0859a.f2397b != null) {
                        StringBuilder stringBuilder7 = new StringBuilder();
                        stringBuilder7.append(stringBuilder4);
                        stringBuilder7.append("Content-Disposition: form-data; name=\"");
                        stringBuilder7.append(str2);
                        stringBuilder7.append("\"; filename=\"");
                        stringBuilder7.append(c0859a.f2397b);
                        stringBuilder7.append("\"\r\n");
                        str2 = stringBuilder7.toString();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(str2);
                        stringBuilder3.append("Content-Type: ");
                        stringBuilder3.append(c0859a.f2398c);
                        stringBuilder3.append("\r\n\r\n");
                        fileOutputStream.write(stringBuilder3.toString().getBytes());
                        if (str.startsWith("RNFetchBlob-file://")) {
                            String e = C0867d.m3097e(str.substring("RNFetchBlob-file://".length()));
                            if (C0867d.m3096d(e)) {
                                try {
                                    m10652a(reactApplicationContext.getAssets().open(e.replace("bundle-assets://", "")), fileOutputStream);
                                } catch (IOException e2) {
                                    stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append("Failed to create form data asset :");
                                    stringBuilder5.append(e);
                                    stringBuilder5.append(", ");
                                    stringBuilder5.append(e2.getLocalizedMessage());
                                    C0877h.m3120b(stringBuilder5.toString());
                                }
                            } else {
                                File file = new File(C0867d.m3097e(e));
                                if (file.exists()) {
                                    m10652a(new FileInputStream(file), fileOutputStream);
                                } else {
                                    stringBuilder6 = new StringBuilder();
                                    stringBuilder6.append("Failed to create form data from path :");
                                    stringBuilder6.append(e);
                                    stringBuilder6.append(", file not exists.");
                                    C0877h.m3120b(stringBuilder6.toString());
                                }
                            }
                        } else {
                            fileOutputStream.write(Base64.decode(str, 0));
                        }
                    } else {
                        stringBuilder6 = new StringBuilder();
                        stringBuilder6.append(stringBuilder4);
                        stringBuilder6.append("Content-Disposition: form-data; name=\"");
                        stringBuilder6.append(str2);
                        stringBuilder6.append("\"\r\n");
                        str = stringBuilder6.toString();
                        stringBuilder5 = new StringBuilder();
                        stringBuilder5.append(str);
                        stringBuilder5.append("Content-Type: ");
                        stringBuilder5.append(c0859a.f2398c);
                        stringBuilder5.append("\r\n\r\n");
                        fileOutputStream.write(stringBuilder5.toString().getBytes());
                        fileOutputStream.write(c0859a.f2399d.getBytes());
                    }
                    fileOutputStream.write("\r\n".getBytes());
                }
            }
        }
        StringBuilder stringBuilder8 = new StringBuilder();
        stringBuilder8.append("--");
        stringBuilder8.append(stringBuilder2);
        stringBuilder8.append("--\r\n");
        fileOutputStream.write(stringBuilder8.toString().getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
        return createTempFile;
    }

    /* renamed from: a */
    private void m10651a(InputStream inputStream, C7496d c7496d) {
        byte[] bArr = new byte[10240];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 10240);
            if (read <= 0) {
                inputStream.close();
                return;
            } else if (read > 0) {
                c7496d.c(bArr, 0, read);
                i += read;
                m10650a(i);
            }
        }
    }

    /* renamed from: a */
    private void m10652a(InputStream inputStream, FileOutputStream fileOutputStream) {
        byte[] bArr = new byte[10240];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    /* renamed from: d */
    private ArrayList<C0859a> m10655d() {
        ArrayList<C0859a> arrayList = new ArrayList();
        ReactApplicationContext reactApplicationContext = RNFetchBlob.RCTContext;
        long j = 0;
        for (int i = 0; i < this.f8910c.size(); i++) {
            C0859a c0859a = new C0859a(this, this.f8910c.getMap(i));
            arrayList.add(c0859a);
            String str = c0859a.f2399d;
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("RNFetchBlob multipart request builder has found a field without `data` property, the field `");
                stringBuilder.append(c0859a.f2396a);
                stringBuilder.append("` will be removed implicitly.");
                C0877h.m3120b(stringBuilder.toString());
            } else if (c0859a.f2397b == null) {
                j += c0859a.f2399d != null ? (long) c0859a.f2399d.getBytes().length : 0;
            } else if (str.startsWith("RNFetchBlob-file://")) {
                String e = C0867d.m3097e(str.substring("RNFetchBlob-file://".length()));
                if (C0867d.m3096d(e)) {
                    try {
                        j += (long) reactApplicationContext.getAssets().open(e.replace("bundle-assets://", "")).available();
                    } catch (IOException e2) {
                        C0877h.m3120b(e2.getLocalizedMessage());
                    }
                } else {
                    j += new File(C0867d.m3097e(e)).length();
                }
            } else {
                j += (long) Base64.decode(str, 0).length;
            }
        }
        this.f8909b = j;
        return arrayList;
    }

    /* renamed from: a */
    private void m10650a(int i) {
        C0869f c = C0874g.m3117c(this.f8911d);
        if (c != null && this.f8909b != 0 && c.m3104a(((float) i) / ((float) this.f8909b))) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("taskId", this.f8911d);
            createMap.putString("written", String.valueOf(i));
            createMap.putString("total", String.valueOf(this.f8909b));
            ((RCTDeviceEventEmitter) RNFetchBlob.RCTContext.getJSModule(RCTDeviceEventEmitter.class)).emit("RNFetchBlobProgress-upload", createMap);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.JsonWriter;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.common.util.C2893c;
import com.google.android.gms.common.util.C2895e;
import com.google.android.gms.common.util.C4376h;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

@cm
public final class mm {
    /* renamed from: a */
    private static Object f15804a = new Object();
    /* renamed from: b */
    private static boolean f15805b = false;
    /* renamed from: c */
    private static boolean f15806c = false;
    /* renamed from: d */
    private static C2895e f15807d = C4376h.d();
    /* renamed from: e */
    private static final Set<String> f15808e = new HashSet(Arrays.asList(new String[0]));
    /* renamed from: f */
    private final List<String> f15809f;

    public mm() {
        this(null);
    }

    public mm(String str) {
        List asList;
        if (m19905c()) {
            String uuid = UUID.randomUUID().toString();
            if (str == null) {
                String[] strArr = new String[1];
                String str2 = "network_request_";
                uuid = String.valueOf(uuid);
                strArr[0] = uuid.length() != 0 ? str2.concat(uuid) : new String(str2);
                asList = Arrays.asList(strArr);
            } else {
                String[] strArr2 = new String[2];
                String str3 = "ad_request_";
                str = String.valueOf(str);
                strArr2[0] = str.length() != 0 ? str3.concat(str) : new String(str3);
                str = "network_request_";
                uuid = String.valueOf(uuid);
                strArr2[1] = uuid.length() != 0 ? str.concat(uuid) : new String(str);
                asList = Arrays.asList(strArr2);
            }
        } else {
            asList = new ArrayList();
        }
        this.f15809f = asList;
    }

    /* renamed from: a */
    public static void m19891a() {
        synchronized (f15804a) {
            f15805b = false;
            f15806c = false;
            mt.m19924e("Ad debug logging enablement is out of date.");
        }
    }

    /* renamed from: a */
    static final /* synthetic */ void m19892a(int i, Map map, JsonWriter jsonWriter) {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i);
        jsonWriter.endObject();
        m19893a(jsonWriter, map);
        jsonWriter.endObject();
    }

    /* renamed from: a */
    private static void m19893a(JsonWriter jsonWriter, Map<String, ?> map) {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (!f15808e.contains(str)) {
                    if (!(entry.getValue() instanceof List)) {
                        if (!(entry.getValue() instanceof String)) {
                            mt.m19920c("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name("value").value((String) entry.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String str2 : (List) entry.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(str);
                            jsonWriter.name("value").value(str2);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: a */
    static final /* synthetic */ void m19894a(String str, JsonWriter jsonWriter) {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        if (str != null) {
            jsonWriter.name(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION).value(str);
        }
        jsonWriter.endObject();
    }

    /* renamed from: a */
    private final void m19895a(String str, ms msVar) {
        Writer stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(f15807d.a());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            for (String value : this.f15809f) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            msVar.mo4316a(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (Throwable e) {
            mt.m19919b("unable to log", e);
        }
        m19904c(stringWriter.toString());
    }

    /* renamed from: a */
    static final /* synthetic */ void m19896a(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) {
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        m19893a(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(C2893c.a(bArr));
        }
        jsonWriter.endObject();
    }

    /* renamed from: a */
    public static void m19897a(boolean z) {
        synchronized (f15804a) {
            f15805b = true;
            f15806c = z;
        }
    }

    /* renamed from: a */
    static final /* synthetic */ void m19898a(byte[] bArr, JsonWriter jsonWriter) {
        String str;
        jsonWriter.name(NativeProtocol.WEB_DIALOG_PARAMS).beginObject();
        int length = bArr.length;
        String a = C2893c.a(bArr);
        if (length < 10000) {
            str = "body";
        } else {
            a = mi.m19867a(a);
            if (a != null) {
                str = "bodydigest";
            }
            jsonWriter.name("bodylength").value((long) length);
            jsonWriter.endObject();
        }
        jsonWriter.name(str).value(a);
        jsonWriter.name("bodylength").value((long) length);
        jsonWriter.endObject();
    }

    /* renamed from: a */
    public static boolean m19899a(Context context) {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((Boolean) aph.m18688f().m18889a(asp.bh)).booleanValue()) {
            return false;
        }
        try {
            return Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
        } catch (Throwable e) {
            mt.m19921c("Fail to determine debug setting.", e);
            return false;
        }
    }

    /* renamed from: b */
    private final void m19900b(String str) {
        m19895a("onNetworkRequestError", new mr(str));
    }

    /* renamed from: b */
    private final void m19901b(String str, String str2, Map<String, ?> map, byte[] bArr) {
        m19895a("onNetworkRequest", new mn(str, str2, map, bArr));
    }

    /* renamed from: b */
    private final void m19902b(Map<String, ?> map, int i) {
        m19895a("onNetworkResponse", new mp(i, map));
    }

    /* renamed from: b */
    public static boolean m19903b() {
        boolean z;
        synchronized (f15804a) {
            z = f15805b;
        }
        return z;
    }

    /* renamed from: c */
    private static synchronized void m19904c(String str) {
        synchronized (mm.class) {
            mt.m19922d("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 4000;
                String str2 = "GMA Debug CONTENT ";
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                mt.m19922d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                i = i2;
            }
            mt.m19922d("GMA Debug FINISH");
        }
    }

    /* renamed from: c */
    public static boolean m19905c() {
        boolean z;
        synchronized (f15804a) {
            z = f15805b && f15806c;
        }
        return z;
    }

    /* renamed from: a */
    public final void m19906a(String str) {
        if (m19905c() && str != null) {
            m19911a(str.getBytes());
        }
    }

    /* renamed from: a */
    public final void m19907a(String str, String str2, Map<String, ?> map, byte[] bArr) {
        if (m19905c()) {
            m19901b(str, str2, map, bArr);
        }
    }

    /* renamed from: a */
    public final void m19908a(HttpURLConnection httpURLConnection, int i) {
        if (m19905c()) {
            m19902b(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < HttpStatus.HTTP_OK || i >= 300) {
                String responseMessage;
                try {
                    responseMessage = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String str = "Can not get error message from error HttpURLConnection\n";
                    responseMessage = String.valueOf(e.getMessage());
                    mt.m19924e(responseMessage.length() != 0 ? str.concat(responseMessage) : new String(str));
                    responseMessage = null;
                }
                m19900b(responseMessage);
            }
        }
    }

    /* renamed from: a */
    public final void m19909a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (m19905c()) {
            m19901b(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    /* renamed from: a */
    public final void m19910a(Map<String, ?> map, int i) {
        if (m19905c()) {
            m19902b(map, i);
            if (i < HttpStatus.HTTP_OK || i >= 300) {
                m19900b(null);
            }
        }
    }

    /* renamed from: a */
    public final void m19911a(byte[] bArr) {
        m19895a("onNetworkResponseBody", new mq(bArr));
    }
}

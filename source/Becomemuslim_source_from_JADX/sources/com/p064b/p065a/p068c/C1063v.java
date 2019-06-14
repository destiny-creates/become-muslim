package com.p064b.p065a.p068c;

import com.facebook.stetho.common.Utf8Charset;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: MetaDataStore */
/* renamed from: com.b.a.c.v */
class C1063v {
    /* renamed from: a */
    private static final Charset f2959a = Charset.forName(Utf8Charset.NAME);
    /* renamed from: b */
    private final File f2960b;

    public C1063v(File file) {
        this.f2960b = file;
    }

    /* renamed from: a */
    public ae m3668a(String str) {
        str = m3664c(str);
        if (!str.exists()) {
            return ae.f2858a;
        }
        Closeable closeable = null;
        try {
            Closeable fileInputStream = new FileInputStream(str);
            try {
                str = C1063v.m3666e(C6428i.a(fileInputStream));
                C6428i.a(fileInputStream, "Failed to close user metadata file.");
                return str;
            } catch (Exception e) {
                str = e;
                closeable = fileInputStream;
                try {
                    C6514c.h().e("CrashlyticsCore", "Error deserializing user metadata.", str);
                    C6428i.a(closeable, "Failed to close user metadata file.");
                    return ae.f2858a;
                } catch (Throwable th) {
                    str = th;
                    C6428i.a(closeable, "Failed to close user metadata file.");
                    throw str;
                }
            } catch (Throwable th2) {
                str = th2;
                closeable = fileInputStream;
                C6428i.a(closeable, "Failed to close user metadata file.");
                throw str;
            }
        } catch (Exception e2) {
            str = e2;
            C6514c.h().e("CrashlyticsCore", "Error deserializing user metadata.", str);
            C6428i.a(closeable, "Failed to close user metadata file.");
            return ae.f2858a;
        }
    }

    /* renamed from: a */
    public void m3669a(String str, Map<String, String> map) {
        str = m3665d(str);
        Closeable closeable = null;
        try {
            map = C1063v.m3662a((Map) map);
            Closeable bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str), f2959a));
            try {
                bufferedWriter.write(map);
                bufferedWriter.flush();
                C6428i.a(bufferedWriter, "Failed to close key/value metadata file.");
            } catch (Exception e) {
                str = e;
                closeable = bufferedWriter;
                try {
                    C6514c.h().e("CrashlyticsCore", "Error serializing key/value metadata.", str);
                    C6428i.a(closeable, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    str = th;
                    C6428i.a(closeable, "Failed to close key/value metadata file.");
                    throw str;
                }
            } catch (Throwable th2) {
                str = th2;
                closeable = bufferedWriter;
                C6428i.a(closeable, "Failed to close key/value metadata file.");
                throw str;
            }
        } catch (Exception e2) {
            str = e2;
            C6514c.h().e("CrashlyticsCore", "Error serializing key/value metadata.", str);
            C6428i.a(closeable, "Failed to close key/value metadata file.");
        }
    }

    /* renamed from: b */
    public Map<String, String> m3670b(String str) {
        str = m3665d(str);
        if (!str.exists()) {
            return Collections.emptyMap();
        }
        Closeable closeable = null;
        try {
            Closeable fileInputStream = new FileInputStream(str);
            try {
                str = C1063v.m3667f(C6428i.a(fileInputStream));
                C6428i.a(fileInputStream, "Failed to close user metadata file.");
                return str;
            } catch (Exception e) {
                str = e;
                closeable = fileInputStream;
                try {
                    C6514c.h().e("CrashlyticsCore", "Error deserializing user metadata.", str);
                    C6428i.a(closeable, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    str = th;
                    C6428i.a(closeable, "Failed to close user metadata file.");
                    throw str;
                }
            } catch (Throwable th2) {
                str = th2;
                closeable = fileInputStream;
                C6428i.a(closeable, "Failed to close user metadata file.");
                throw str;
            }
        } catch (Exception e2) {
            str = e2;
            C6514c.h().e("CrashlyticsCore", "Error deserializing user metadata.", str);
            C6428i.a(closeable, "Failed to close user metadata file.");
            return Collections.emptyMap();
        }
    }

    /* renamed from: c */
    private File m3664c(String str) {
        File file = this.f2960b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("user");
        stringBuilder.append(".meta");
        return new File(file, stringBuilder.toString());
    }

    /* renamed from: d */
    private File m3665d(String str) {
        File file = this.f2960b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("keys");
        stringBuilder.append(".meta");
        return new File(file, stringBuilder.toString());
    }

    /* renamed from: e */
    private static ae m3666e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new ae(C1063v.m3663a(jSONObject, "userId"), C1063v.m3663a(jSONObject, "userName"), C1063v.m3663a(jSONObject, "userEmail"));
    }

    /* renamed from: f */
    private static Map<String, String> m3667f(String str) {
        JSONObject jSONObject = new JSONObject(str);
        str = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            str.put(str2, C1063v.m3663a(jSONObject, str2));
        }
        return str;
    }

    /* renamed from: a */
    private static String m3662a(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    /* renamed from: a */
    private static String m3663a(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) ? jSONObject.optString(str, null) : null;
    }
}

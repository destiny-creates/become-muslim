package io.p347a.p348a.p349a.p350a.p358g;

import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p357f.C7618b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

/* compiled from: DefaultCachedSettingsIo */
/* renamed from: io.a.a.a.a.g.i */
class C7621i implements C6496g {
    /* renamed from: a */
    private final C6520i f26335a;

    public C7621i(C6520i c6520i) {
        this.f26335a = c6520i;
    }

    /* renamed from: a */
    public JSONObject mo5465a() {
        Closeable fileInputStream;
        Throwable e;
        C6514c.m26634h().mo5472a("Fabric", "Reading cached settings...");
        Closeable closeable = null;
        try {
            JSONObject jSONObject;
            File file = new File(new C7618b(this.f26335a).mo5461a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(C6428i.m26356a((InputStream) fileInputStream));
                    closeable = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C6514c.m26634h().mo5480e("Fabric", "Failed to fetch cached settings", e);
                        C6428i.m26367a(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileInputStream;
                        C6428i.m26367a(closeable, "Error while closing settings cache file.");
                        throw e;
                    }
                }
            }
            C6514c.m26634h().mo5472a("Fabric", "No cached settings found.");
            jSONObject = null;
            C6428i.m26367a(closeable, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C6514c.m26634h().mo5480e("Fabric", "Failed to fetch cached settings", e);
            C6428i.m26367a(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            C6428i.m26367a(closeable, "Error while closing settings cache file.");
            throw e;
        }
    }

    /* renamed from: a */
    public void mo5466a(long j, JSONObject jSONObject) {
        Throwable e;
        C6514c.m26634h().mo5472a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            Closeable closeable = null;
            try {
                jSONObject.put("expires_at", j);
                Closeable fileWriter = new FileWriter(new File(new C7618b(this.f26335a).mo5461a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    C6428i.m26367a(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    closeable = fileWriter;
                    try {
                        C6514c.m26634h().mo5480e("Fabric", "Failed to cache settings", e);
                        C6428i.m26367a(closeable, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        e = th;
                        C6428i.m26367a(closeable, "Failed to close settings writer.");
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    closeable = fileWriter;
                    C6428i.m26367a(closeable, "Failed to close settings writer.");
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                C6514c.m26634h().mo5480e("Fabric", "Failed to cache settings", e);
                C6428i.m26367a(closeable, "Failed to close settings writer.");
            }
        }
    }
}

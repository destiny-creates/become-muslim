package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.ax;
import com.raizlabs.android.dbflow.config.C5679e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@cm
public final class ass {
    /* renamed from: a */
    private BlockingQueue<atc> f14968a = new ArrayBlockingQueue(100);
    /* renamed from: b */
    private ExecutorService f14969b;
    /* renamed from: c */
    private LinkedHashMap<String, String> f14970c = new LinkedHashMap();
    /* renamed from: d */
    private Map<String, asw> f14971d = new HashMap();
    /* renamed from: e */
    private String f14972e;
    /* renamed from: f */
    private Context f14973f;
    /* renamed from: g */
    private String f14974g;
    /* renamed from: h */
    private AtomicBoolean f14975h;
    /* renamed from: i */
    private File f14976i;

    /* renamed from: a */
    private final void m18899a() {
        FileOutputStream fileOutputStream;
        Throwable e;
        while (true) {
            try {
                atc atc = (atc) this.f14968a.take();
                Object b = atc.m18923b();
                if (!TextUtils.isEmpty(b)) {
                    Map a = m18902a(this.f14970c, atc.m18924c());
                    Builder buildUpon = Uri.parse(this.f14972e).buildUpon();
                    for (Entry entry : a.entrySet()) {
                        buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
                    }
                    StringBuilder stringBuilder = new StringBuilder(buildUpon.build().toString());
                    stringBuilder.append("&it=");
                    stringBuilder.append(b);
                    String stringBuilder2 = stringBuilder.toString();
                    if (this.f14975h.get()) {
                        File file = this.f14976i;
                        if (file != null) {
                            fileOutputStream = null;
                            try {
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                                try {
                                    fileOutputStream2.write(stringBuilder2.getBytes());
                                    fileOutputStream2.write(10);
                                } catch (IOException e2) {
                                    e = e2;
                                    fileOutputStream = fileOutputStream2;
                                    try {
                                        mt.m19921c("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                    } catch (Throwable th) {
                                        e = th;
                                    }
                                } catch (Throwable th2) {
                                    e = th2;
                                    fileOutputStream = fileOutputStream2;
                                }
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable e3) {
                                    mt.m19921c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e3);
                                }
                            } catch (IOException e4) {
                                e3 = e4;
                                mt.m19921c("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e3);
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            }
                        } else {
                            mt.m19924e("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
                        }
                    } else {
                        ax.e();
                        jw.m19698a(this.f14973f, this.f14974g, stringBuilder2);
                    }
                }
            } catch (Throwable e32) {
                mt.m19921c("CsiReporter:reporter interrupted", e32);
                return;
            }
        }
        throw e32;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable e5) {
                mt.m19921c("CsiReporter: Cannot close file: sdk_csi_data.txt.", e5);
            }
        }
        throw e32;
    }

    /* renamed from: a */
    public final asw m18901a(String str) {
        asw asw = (asw) this.f14971d.get(str);
        return asw != null ? asw : asw.f14978a;
    }

    /* renamed from: a */
    final Map<String, String> m18902a(Map<String, String> map, Map<String, String> map2) {
        Map<String, String> linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, m18901a(str).mo3958a(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public final void m18903a(Context context, String str, String str2, Map<String, String> map) {
        this.f14973f = context;
        this.f14974g = str;
        this.f14972e = str2;
        this.f14975h = new AtomicBoolean(false);
        this.f14975h.set(((Boolean) aph.m18688f().m18889a(asp.f14925P)).booleanValue());
        if (this.f14975h.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.f14976i = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            this.f14970c.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.f14969b = Executors.newSingleThreadExecutor();
        this.f14969b.execute(new ast(this));
        this.f14971d.put(NativeProtocol.WEB_DIALOG_ACTION, asw.f14979b);
        this.f14971d.put("ad_format", asw.f14979b);
        this.f14971d.put(C5679e.f18978a, asw.f14980c);
    }

    /* renamed from: a */
    public final void m18904a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f14970c.put(C5679e.f18978a, TextUtils.join(",", list));
        }
    }

    /* renamed from: a */
    public final boolean m18905a(atc atc) {
        return this.f14968a.offer(atc);
    }
}

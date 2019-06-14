package com.p073d.p074a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.JsonWriter;
import com.facebook.stetho.common.Utf8Charset;
import com.p073d.p074a.C1155l.C1154a;
import com.p073d.p074a.C1155l.C3479b;
import com.p073d.p074a.C1155l.C3480c;
import com.p073d.p074a.p075a.C1131e;
import com.p073d.p074a.p075a.C1131e.C1130a;
import com.p073d.p074a.p075a.C1132f;
import com.p073d.p074a.p075a.C3460b;
import com.p073d.p074a.p075a.C4540a;
import com.p073d.p074a.p075a.C4541c;
import com.p073d.p074a.p075a.C4542d;
import com.p073d.p074a.p075a.C4543g;
import com.p073d.p074a.p075a.C4544h;
import com.p073d.p074a.p076b.C1139b;
import com.p073d.p074a.p076b.C1139b.C1137c;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: SegmentIntegration */
/* renamed from: com.d.a.q */
class C3488q extends C1131e<Void> {
    /* renamed from: a */
    static final C1130a f9282a = new C34861();
    /* renamed from: b */
    static final Charset f9283b = Charset.forName(Utf8Charset.NAME);
    /* renamed from: c */
    final Object f9284c = new Object();
    /* renamed from: d */
    private final Context f9285d;
    /* renamed from: e */
    private final C1155l f9286e;
    /* renamed from: f */
    private final C1146e f9287f;
    /* renamed from: g */
    private final int f9288g;
    /* renamed from: h */
    private final C1164r f9289h;
    /* renamed from: i */
    private final Handler f9290i;
    /* renamed from: j */
    private final HandlerThread f9291j;
    /* renamed from: k */
    private final C1132f f9292k;
    /* renamed from: l */
    private final Map<String, Boolean> f9293l;
    /* renamed from: m */
    private final C1143d f9294m;
    /* renamed from: n */
    private final ExecutorService f9295n;
    /* renamed from: o */
    private final ScheduledExecutorService f9296o;
    /* renamed from: p */
    private final C1148g f9297p;

    /* compiled from: SegmentIntegration */
    /* renamed from: com.d.a.q$2 */
    class C11592 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3488q f3273a;

        C11592(C3488q c3488q) {
            this.f3273a = c3488q;
        }

        public void run() {
            this.f3273a.mo797a();
        }
    }

    /* compiled from: SegmentIntegration */
    /* renamed from: com.d.a.q$3 */
    class C11603 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3488q f3274a;

        C11603(C3488q c3488q) {
            this.f3274a = c3488q;
        }

        public void run() {
            synchronized (this.f3274a.f9284c) {
                this.f3274a.m11213c();
            }
        }
    }

    /* compiled from: SegmentIntegration */
    /* renamed from: com.d.a.q$a */
    static class C1161a implements Closeable {
        /* renamed from: a */
        private final JsonWriter f3275a;
        /* renamed from: b */
        private final BufferedWriter f3276b;
        /* renamed from: c */
        private boolean f3277c = false;

        C1161a(OutputStream outputStream) {
            this.f3276b = new BufferedWriter(new OutputStreamWriter(outputStream));
            this.f3275a = new JsonWriter(this.f3276b);
        }

        /* renamed from: a */
        C1161a m4112a() {
            this.f3275a.beginObject();
            return this;
        }

        /* renamed from: b */
        C1161a m4114b() {
            this.f3275a.name("batch").beginArray();
            this.f3277c = false;
            return this;
        }

        /* renamed from: a */
        C1161a m4113a(String str) {
            if (this.f3277c) {
                this.f3276b.write(44);
            } else {
                this.f3277c = true;
            }
            this.f3276b.write(str);
            return this;
        }

        /* renamed from: c */
        C1161a m4115c() {
            if (this.f3277c) {
                this.f3275a.endArray();
                return this;
            }
            throw new IOException("At least one payload must be provided.");
        }

        /* renamed from: d */
        C1161a m4116d() {
            this.f3275a.name("sentAt").value(C1139b.m4013a(new Date())).endObject();
            return this;
        }

        public void close() {
            this.f3275a.close();
        }
    }

    /* compiled from: SegmentIntegration */
    /* renamed from: com.d.a.q$c */
    static class C1162c extends Handler {
        /* renamed from: a */
        private final C3488q f3278a;

        C1162c(Looper looper, C3488q c3488q) {
            super(looper);
            this.f3278a = c3488q;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.f3278a.m11207a((C3460b) message.obj);
                    return;
                case 1:
                    this.f3278a.m11212b();
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown dispatcher message: ");
                    stringBuilder.append(message.what);
                    throw new AssertionError(stringBuilder.toString());
            }
        }
    }

    /* compiled from: SegmentIntegration */
    /* renamed from: com.d.a.q$1 */
    static class C34861 implements C1130a {
        /* renamed from: a */
        public String mo796a() {
            return "Segment.io";
        }

        C34861() {
        }

        /* renamed from: a */
        public C1131e<?> mo795a(C1166t c1166t, C1133a c1133a) {
            return C3488q.m11202a(c1133a.m4001d(), c1133a.f3218k, c1133a.f3219l, c1133a.f3212e, c1133a.f3213f, Collections.unmodifiableMap(c1133a.f3226s), c1133a.f3217j, c1133a.f3225r, c1133a.f3224q, c1133a.m4003e(), c1133a.f3220m);
        }
    }

    /* compiled from: SegmentIntegration */
    /* renamed from: com.d.a.q$b */
    static class C3487b implements C1154a {
        /* renamed from: a */
        final C1161a f9278a;
        /* renamed from: b */
        final C1148g f9279b;
        /* renamed from: c */
        int f9280c;
        /* renamed from: d */
        int f9281d;

        C3487b(C1161a c1161a, C1148g c1148g) {
            this.f9278a = c1161a;
            this.f9279b = c1148g;
        }

        /* renamed from: a */
        public boolean mo793a(InputStream inputStream, int i) {
            inputStream = this.f9279b.mo785a(inputStream);
            int i2 = this.f9280c + i;
            if (i2 > 475000) {
                return false;
            }
            this.f9280c = i2;
            byte[] bArr = new byte[i];
            inputStream.read(bArr, 0, i);
            this.f9278a.m4113a(new String(bArr, C3488q.f9283b));
            this.f9281d += 1;
            return true;
        }
    }

    /* renamed from: a */
    static com.p073d.p074a.C1158o m11201a(java.io.File r3, java.lang.String r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        com.p073d.p074a.p076b.C1139b.m4018a(r3);
        r0 = new java.io.File;
        r0.<init>(r3, r4);
        r1 = new com.d.a.o;	 Catch:{ IOException -> 0x000e }
        r1.<init>(r0);	 Catch:{ IOException -> 0x000e }
        return r1;
    L_0x000e:
        r1 = r0.delete();
        if (r1 == 0) goto L_0x001a;
    L_0x0014:
        r3 = new com.d.a.o;
        r3.<init>(r0);
        return r3;
    L_0x001a:
        r0 = new java.io.IOException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Could not create queue file (";
        r1.append(r2);
        r1.append(r4);
        r4 = ") in ";
        r1.append(r4);
        r1.append(r3);
        r3 = ".";
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.d.a.q.a(java.io.File, java.lang.String):com.d.a.o");
    }

    /* renamed from: a */
    static synchronized C3488q m11202a(Context context, C1146e c1146e, C1143d c1143d, ExecutorService executorService, C1164r c1164r, Map<String, Boolean> map, String str, long j, int i, C1132f c1132f, C1148g c1148g) {
        C1155l c3480c;
        Throwable e;
        C3488q c3488q;
        synchronized (C3488q.class) {
            try {
                try {
                    C1132f c1132f2 = c1132f;
                    c3480c = new C3480c(C3488q.m11201a(context.getDir("segment-disk-queue", 0), str));
                } catch (IOException e2) {
                    e = e2;
                    c1132f.m3971a(e, "Could not create disk queue. Falling back to memory queue.", new Object[0]);
                    c3480c = new C3479b();
                    c3488q = new C3488q(context, c1146e, c1143d, executorService, c3480c, c1164r, map, j, i, c1132f, c1148g);
                    return c3488q;
                }
            } catch (IOException e3) {
                e = e3;
                Context context2 = context;
                c1132f.m3971a(e, "Could not create disk queue. Falling back to memory queue.", new Object[0]);
                c3480c = new C3479b();
                c3488q = new C3488q(context, c1146e, c1143d, executorService, c3480c, c1164r, map, j, i, c1132f, c1148g);
                return c3488q;
            }
            c3488q = new C3488q(context, c1146e, c1143d, executorService, c3480c, c1164r, map, j, i, c1132f, c1148g);
        }
        return c3488q;
    }

    C3488q(Context context, C1146e c1146e, C1143d c1143d, ExecutorService executorService, C1155l c1155l, C1164r c1164r, Map<String, Boolean> map, long j, int i, C1132f c1132f, C1148g c1148g) {
        int i2 = i;
        this.f9285d = context;
        this.f9287f = c1146e;
        this.f9295n = executorService;
        this.f9286e = c1155l;
        this.f9289h = c1164r;
        this.f9292k = c1132f;
        this.f9293l = map;
        this.f9294m = c1143d;
        this.f9288g = i2;
        this.f9296o = Executors.newScheduledThreadPool(1, new C1137c());
        this.f9297p = c1148g;
        this.f9291j = new HandlerThread("Segment-SegmentDispatcher", 10);
        this.f9291j.start();
        this.f9290i = new C1162c(this.f9291j.getLooper(), this);
        r0.f9296o.scheduleAtFixedRate(new C11592(this), c1155l.mo788a() >= i2 ? 0 : j, j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public void mo800a(C4542d c4542d) {
        m11203b(c4542d);
    }

    /* renamed from: a */
    public void mo799a(C4541c c4541c) {
        m11203b(c4541c);
    }

    /* renamed from: a */
    public void mo802a(C4544h c4544h) {
        m11203b(c4544h);
    }

    /* renamed from: a */
    public void mo798a(C4540a c4540a) {
        m11203b(c4540a);
    }

    /* renamed from: a */
    public void mo801a(C4543g c4543g) {
        m11203b(c4543g);
    }

    /* renamed from: b */
    private void m11203b(C3460b c3460b) {
        this.f9290i.sendMessage(this.f9290i.obtainMessage(0, c3460b));
    }

    /* renamed from: a */
    void m11207a(C3460b c3460b) {
        Map d = c3460b.m11120d();
        LinkedHashMap linkedHashMap = new LinkedHashMap(d.size() + this.f9293l.size());
        linkedHashMap.putAll(d);
        linkedHashMap.putAll(this.f9293l);
        linkedHashMap.remove("Segment.io");
        d = new C1166t();
        d.putAll(c3460b);
        d.m4134c("integrations", linkedHashMap);
        if (this.f9286e.mo788a() >= 1000) {
            synchronized (this.f9284c) {
                if (this.f9286e.mo788a() >= 1000) {
                    this.f9292k.m3972b("Queue is at max capacity (%s), removing oldest payload.", Integer.valueOf(this.f9286e.mo788a()));
                    try {
                        this.f9286e.mo789a(1);
                    } catch (C3460b c3460b2) {
                        this.f9292k.m3971a(c3460b2, "Unable to remove oldest payload from queue.", new Object[0]);
                        return;
                    }
                }
            }
        }
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f9294m.m4048a(d, new OutputStreamWriter(this.f9297p.mo786a(byteArrayOutputStream)));
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (toByteArray == null || toByteArray.length == 0 || toByteArray.length > 15000) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not serialize payload ");
                stringBuilder.append(d);
                throw new IOException(stringBuilder.toString());
            }
            this.f9286e.mo791a(toByteArray);
            this.f9292k.m3970a("Enqueued %s payload. %s elements in the queue.", c3460b2, Integer.valueOf(this.f9286e.mo788a()));
            if (this.f9286e.mo788a() >= this.f9288g) {
                m11212b();
            }
        } catch (C3460b c3460b22) {
            this.f9292k.m3971a(c3460b22, "Could not add payload %s to queue: %s.", d, this.f9286e);
        }
    }

    /* renamed from: a */
    public void mo797a() {
        this.f9290i.sendMessage(this.f9290i.obtainMessage(1));
    }

    /* renamed from: b */
    void m11212b() {
        if (m11204e()) {
            this.f9295n.submit(new C11603(this));
        }
    }

    /* renamed from: e */
    private boolean m11204e() {
        return this.f9286e.mo788a() > 0 && C1139b.m4027b(this.f9285d);
    }

    /* renamed from: c */
    void m11213c() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r8 = this;
        r0 = r8.m11204e();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r8.f9292k;
        r1 = "Uploading payloads in queue to Segment.";
        r2 = 0;
        r3 = new java.lang.Object[r2];
        r0.m3970a(r1, r3);
        r0 = 0;
        r1 = r8.f9287f;	 Catch:{ b -> 0x00ba, IOException -> 0x00a4 }
        r1 = r1.m4051a();	 Catch:{ b -> 0x00ba, IOException -> 0x00a4 }
        r0 = new com.d.a.q$a;	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r3 = r1.f3247c;	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r0.<init>(r3);	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r0 = r0.m4112a();	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r0 = r0.m4114b();	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r3 = new com.d.a.q$b;	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r4 = r8.f9297p;	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r3.<init>(r0, r4);	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r4 = r8.f9286e;	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r4.mo790a(r3);	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r0 = r0.m4115c();	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r0 = r0.m4116d();	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r0.close();	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r0 = r3.f9281d;	 Catch:{ b -> 0x009f, IOException -> 0x009d }
        r1.close();	 Catch:{ b -> 0x0098, IOException -> 0x009d }
        com.p073d.p074a.p076b.C1139b.m4017a(r1);
        r1 = r8.f9286e;	 Catch:{ IOException -> 0x0079 }
        r1.mo789a(r0);	 Catch:{ IOException -> 0x0079 }
        r1 = r8.f9292k;
        r3 = "Uploaded %s payloads. %s remain in the queue.";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = java.lang.Integer.valueOf(r0);
        r4[r2] = r5;
        r2 = 1;
        r5 = r8.f9286e;
        r5 = r5.mo788a();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r2] = r5;
        r1.m3970a(r3, r4);
        r1 = r8.f9289h;
        r1.m4117a(r0);
        r0 = r8.f9286e;
        r0 = r0.mo788a();
        if (r0 <= 0) goto L_0x0078;
    L_0x0075:
        r8.m11213c();
    L_0x0078:
        return;
    L_0x0079:
        r1 = move-exception;
        r3 = r8.f9292k;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Unable to remove ";
        r4.append(r5);
        r4.append(r0);
        r0 = " payload(s) from queue.";
        r4.append(r0);
        r0 = r4.toString();
        r2 = new java.lang.Object[r2];
        r3.m3971a(r1, r0, r2);
        return;
    L_0x0098:
        r3 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00bc;
    L_0x009d:
        r0 = move-exception;
        goto L_0x00a8;
    L_0x009f:
        r3 = move-exception;
        r0 = r1;
        goto L_0x00bb;
    L_0x00a2:
        r1 = move-exception;
        goto L_0x0105;
    L_0x00a4:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x00a8:
        r3 = r8.f9292k;	 Catch:{ all -> 0x00b5 }
        r4 = "Error while uploading payloads";	 Catch:{ all -> 0x00b5 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00b5 }
        r3.m3971a(r0, r4, r2);	 Catch:{ all -> 0x00b5 }
        com.p073d.p074a.p076b.C1139b.m4017a(r1);
        return;
    L_0x00b5:
        r0 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0105;
    L_0x00ba:
        r3 = move-exception;
    L_0x00bb:
        r1 = 0;
    L_0x00bc:
        r4 = r3.f3248a;	 Catch:{ all -> 0x00a2 }
        r5 = 400; // 0x190 float:5.6E-43 double:1.976E-321;	 Catch:{ all -> 0x00a2 }
        if (r4 < r5) goto L_0x00f8;	 Catch:{ all -> 0x00a2 }
    L_0x00c2:
        r4 = r3.f3248a;	 Catch:{ all -> 0x00a2 }
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ all -> 0x00a2 }
        if (r4 >= r5) goto L_0x00f8;	 Catch:{ all -> 0x00a2 }
    L_0x00c8:
        r4 = r8.f9292k;	 Catch:{ all -> 0x00a2 }
        r5 = "Payloads were rejected by server. Marked for removal.";	 Catch:{ all -> 0x00a2 }
        r6 = new java.lang.Object[r2];	 Catch:{ all -> 0x00a2 }
        r4.m3971a(r3, r5, r6);	 Catch:{ all -> 0x00a2 }
        r4 = r8.f9286e;	 Catch:{ IOException -> 0x00d7 }
        r4.mo789a(r1);	 Catch:{ IOException -> 0x00d7 }
        goto L_0x00f4;
    L_0x00d7:
        r4 = r8.f9292k;	 Catch:{ all -> 0x00a2 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a2 }
        r5.<init>();	 Catch:{ all -> 0x00a2 }
        r6 = "Unable to remove ";	 Catch:{ all -> 0x00a2 }
        r5.append(r6);	 Catch:{ all -> 0x00a2 }
        r5.append(r1);	 Catch:{ all -> 0x00a2 }
        r1 = " payload(s) from queue.";	 Catch:{ all -> 0x00a2 }
        r5.append(r1);	 Catch:{ all -> 0x00a2 }
        r1 = r5.toString();	 Catch:{ all -> 0x00a2 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00a2 }
        r4.m3971a(r3, r1, r2);	 Catch:{ all -> 0x00a2 }
    L_0x00f4:
        com.p073d.p074a.p076b.C1139b.m4017a(r0);
        return;
    L_0x00f8:
        r1 = r8.f9292k;	 Catch:{ all -> 0x00a2 }
        r4 = "Error while uploading payloads";	 Catch:{ all -> 0x00a2 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00a2 }
        r1.m3971a(r3, r4, r2);	 Catch:{ all -> 0x00a2 }
        com.p073d.p074a.p076b.C1139b.m4017a(r0);
        return;
    L_0x0105:
        com.p073d.p074a.p076b.C1139b.m4017a(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.d.a.q.c():void");
    }
}

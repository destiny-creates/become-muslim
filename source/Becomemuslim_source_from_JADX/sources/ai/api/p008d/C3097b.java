package ai.api.p008d;

import ai.api.C0036f;
import ai.api.C0044j;
import ai.api.p005a.C0006c;
import ai.api.p005a.C3087a;
import ai.api.p007c.C0012a;
import ai.api.p007c.C0013c;
import ai.api.p009e.C0034e;
import ai.api.p009e.C0034e.C0033a;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.AsyncTask;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
/* compiled from: SpeaktoitRecognitionServiceImpl */
/* renamed from: ai.api.d.b */
public class C3097b extends C0006c implements C0033a, OnCompletionListener, OnErrorListener {
    /* renamed from: d */
    public static final String f7902d = "ai.api.d.b";
    /* renamed from: e */
    private final ExecutorService f7903e = Executors.newSingleThreadExecutor();
    /* renamed from: f */
    private final C0034e f7904f = new C0034e(16000);
    /* renamed from: g */
    private AudioRecord f7905g;
    /* renamed from: h */
    private final Object f7906h = new Object();
    /* renamed from: i */
    private volatile boolean f7907i = null;
    /* renamed from: j */
    private MediaPlayer f7908j;
    /* renamed from: k */
    private C0044j f7909k;
    /* renamed from: l */
    private C0026a f7910l;

    /* compiled from: SpeaktoitRecognitionServiceImpl */
    /* renamed from: ai.api.d.b$1 */
    class C00241 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3097b f87a;

        C00241(C3097b c3097b) {
            this.f87a = c3097b;
        }

        public void run() {
            this.f87a.mo7b();
        }
    }

    /* compiled from: SpeaktoitRecognitionServiceImpl */
    /* renamed from: ai.api.d.b$2 */
    class C00252 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3097b f88a;

        C00252(C3097b c3097b) {
            this.f88a = c3097b;
        }

        public void run() {
            this.f88a.mo8c();
        }
    }

    /* compiled from: SpeaktoitRecognitionServiceImpl */
    /* renamed from: ai.api.d.b$a */
    private class C0026a extends AsyncTask<Void, Void, C0013c> {
        /* renamed from: a */
        final /* synthetic */ C3097b f89a;
        /* renamed from: b */
        private final C0027b f90b;
        /* renamed from: c */
        private final C0044j f91c;
        /* renamed from: d */
        private C0012a f92d;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m73a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m74a((C0013c) obj);
        }

        private C0026a(C3097b c3097b, C0027b c0027b, C0044j c0044j) {
            this.f89a = c3097b;
            this.f90b = c0027b;
            this.f91c = c0044j;
        }

        /* renamed from: a */
        protected C0013c m73a(Void... voidArr) {
            try {
                return this.f89a.c.m45a(this.f90b, this.f91c);
            } catch (C0036f e) {
                this.f92d = new C0012a(e);
                return null;
            }
        }

        /* renamed from: a */
        protected void m74a(C0013c c0013c) {
            if (!isCancelled()) {
                if (c0013c != null) {
                    this.f89a.m13a(c0013c);
                } else {
                    this.f89a.mo8c();
                    this.f89a.m12a(this.f92d);
                }
            }
        }
    }

    /* compiled from: SpeaktoitRecognitionServiceImpl */
    /* renamed from: ai.api.d.b$b */
    private class C0027b extends InputStream {
        /* renamed from: a */
        int f93a;
        /* renamed from: b */
        int f94b;
        /* renamed from: c */
        int f95c;
        /* renamed from: d */
        float f96d;
        /* renamed from: e */
        float f97e;
        /* renamed from: f */
        int f98f;
        /* renamed from: g */
        final /* synthetic */ C3097b f99g;
        /* renamed from: h */
        private final float f100h;
        /* renamed from: i */
        private final AudioRecord f101i;
        /* renamed from: j */
        private byte[] f102j;
        /* renamed from: k */
        private final Object f103k;

        private C0027b(C3097b c3097b, AudioRecord audioRecord) {
            this.f99g = c3097b;
            this.f100h = (float) Math.pow(10.0d, -0.05d);
            this.f103k = new Object();
            this.f93a = 0;
            this.f94b = 0;
            this.f95c = 0;
            this.f96d = null;
            this.f97e = 1.0f;
            this.f101i = audioRecord;
        }

        public int read() {
            byte[] bArr = new byte[1];
            this.f101i.read(bArr, 0, 1);
            return bArr[0];
        }

        public int read(byte[] bArr, int i, int i2) {
            i = this.f101i.read(bArr, i, i2);
            if (i > 0) {
                synchronized (this.f103k) {
                    if (this.f99g.a.m9030j()) {
                        m75a(bArr, i);
                    }
                    Object obj = this.f102j;
                    int length = obj != null ? obj.length : 0;
                    this.f102j = new byte[(length + i)];
                    if (length > 0) {
                        System.arraycopy(obj, 0, this.f102j, 0, length);
                    }
                    System.arraycopy(bArr, 0, this.f102j, length, i);
                    while (this.f102j.length >= 320) {
                        bArr = new byte[320];
                        System.arraycopy(this.f102j, 0, bArr, 0, 320);
                        this.f99g.f7904f.m105a(bArr, 320);
                        bArr = this.f102j;
                        length = bArr.length - 320;
                        this.f102j = new byte[length];
                        System.arraycopy(bArr, 320, this.f102j, 0, length);
                    }
                    this.f99g.m11a((float) this.f99g.f7904f.m102a());
                }
            }
            return i != 0 ? i : -3;
        }

        /* renamed from: a */
        private void m75a(byte[] bArr, int i) {
            int i2 = 4800 - this.f93a;
            if (i >= i2) {
                bArr = ByteBuffer.wrap(bArr, i2, i - i2).order(ByteOrder.LITTLE_ENDIAN);
                ShortBuffer asShortBuffer = bArr.asShortBuffer();
                for (int i3 = 0; i3 < asShortBuffer.limit(); i3++) {
                    short s = asShortBuffer.get(i3);
                    this.f94b = Math.max(this.f94b, s);
                    this.f95c = Math.min(this.f95c, s);
                    this.f96d = (((this.f97e - 1.0f) / this.f97e) * this.f96d) + (((float) s) / this.f97e);
                    this.f97e += 1.0f;
                }
                this.f98f = Math.max(Math.abs(this.f94b), Math.abs(this.f95c));
                float f = (this.f100h * 32767.0f) / ((float) this.f98f);
                for (int i4 = 0; i4 < asShortBuffer.limit(); i4++) {
                    bArr.putShort((short) ((int) ((((float) asShortBuffer.get(i4)) - this.f96d) * f)));
                }
            }
            this.f93a += Math.min(i, i2);
        }
    }

    /* renamed from: h */
    public void mo9h() {
    }

    public C3097b(Context context, C3087a c3087a) {
        super(c3087a, context);
        m9077k();
    }

    /* renamed from: k */
    private void m9077k() {
        synchronized (this.f7906h) {
            this.f7905g = new AudioRecord(1, 16000, 16, 2, AudioRecord.getMinBufferSize(16000, 16, 2));
            this.f7904f.m104a(this.a.m9029i());
            this.f7904f.m103a((C0033a) this);
            this.f7908j = new MediaPlayer();
            this.f7908j.setOnErrorListener(this);
            this.f7908j.setOnCompletionListener(this);
        }
    }

    /* renamed from: a */
    public void mo5a() {
        mo6a(new C0044j());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo6a(ai.api.C0044j r3) {
        /*
        r2 = this;
        r0 = r2.f7906h;
        monitor-enter(r0);
        r1 = r2.f7907i;	 Catch:{ all -> 0x0041 }
        if (r1 != 0) goto L_0x0038;
    L_0x0007:
        r1 = r2.m21g();	 Catch:{ all -> 0x0041 }
        if (r1 != 0) goto L_0x0019;
    L_0x000d:
        r3 = new ai.api.c.a;	 Catch:{ all -> 0x0041 }
        r1 = "RECORD_AUDIO permission is denied. Please request permission from user.";
        r3.<init>(r1);	 Catch:{ all -> 0x0041 }
        r2.m12a(r3);	 Catch:{ all -> 0x0041 }
        monitor-exit(r0);	 Catch:{ all -> 0x0041 }
        return;
    L_0x0019:
        r1 = 1;
        r2.f7907i = r1;	 Catch:{ all -> 0x0041 }
        r2.f7909k = r3;	 Catch:{ all -> 0x0041 }
        r3 = r2.a;	 Catch:{ all -> 0x0041 }
        r3 = r3.m9031k();	 Catch:{ all -> 0x0041 }
        if (r3 == 0) goto L_0x0032;
    L_0x0026:
        r3 = r2.m9073a(r3);	 Catch:{ all -> 0x0041 }
        if (r3 != 0) goto L_0x003f;
    L_0x002c:
        r3 = r2.f7909k;	 Catch:{ all -> 0x0041 }
        r2.m9075b(r3);	 Catch:{ all -> 0x0041 }
        goto L_0x003f;
    L_0x0032:
        r3 = r2.f7909k;	 Catch:{ all -> 0x0041 }
        r2.m9075b(r3);	 Catch:{ all -> 0x0041 }
        goto L_0x003f;
    L_0x0038:
        r3 = f7902d;	 Catch:{ all -> 0x0041 }
        r1 = "Trying start listening when it already active";
        android.util.Log.w(r3, r1);	 Catch:{ all -> 0x0041 }
    L_0x003f:
        monitor-exit(r0);	 Catch:{ all -> 0x0041 }
        return;
    L_0x0041:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0041 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: ai.api.d.b.a(ai.api.j):void");
    }

    /* renamed from: b */
    private void m9075b(C0044j c0044j) {
        this.f7904f.m106b();
        this.f7905g.startRecording();
        m18d();
        this.f7910l = new C0026a(new C0027b(this.f7905g), c0044j);
        this.f7910l.execute(new Void[0]);
    }

    /* renamed from: b */
    public void mo7b() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = r3.f7906h;
        monitor-enter(r0);
        r1 = r3.f7907i;	 Catch:{ all -> 0x0027 }
        if (r1 == 0) goto L_0x0025;
    L_0x0007:
        r1 = r3.f7905g;	 Catch:{ IllegalStateException -> 0x001e }
        r1.stop();	 Catch:{ IllegalStateException -> 0x001e }
        r1 = 0;	 Catch:{ IllegalStateException -> 0x001e }
        r3.f7907i = r1;	 Catch:{ IllegalStateException -> 0x001e }
        r1 = r3.a;	 Catch:{ IllegalStateException -> 0x001e }
        r1 = r1.m9032l();	 Catch:{ IllegalStateException -> 0x001e }
        if (r1 == 0) goto L_0x001a;	 Catch:{ IllegalStateException -> 0x001e }
    L_0x0017:
        r3.m9073a(r1);	 Catch:{ IllegalStateException -> 0x001e }
    L_0x001a:
        r3.m20f();	 Catch:{ IllegalStateException -> 0x001e }
        goto L_0x0025;
    L_0x001e:
        r1 = f7902d;	 Catch:{ all -> 0x0027 }
        r2 = "Attempt to stop audioRecord when it is stopped";	 Catch:{ all -> 0x0027 }
        android.util.Log.w(r1, r2);	 Catch:{ all -> 0x0027 }
    L_0x0025:
        monitor-exit(r0);	 Catch:{ all -> 0x0027 }
        return;	 Catch:{ all -> 0x0027 }
    L_0x0027:
        r1 = move-exception;	 Catch:{ all -> 0x0027 }
        monitor-exit(r0);	 Catch:{ all -> 0x0027 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: ai.api.d.b.b():void");
    }

    /* renamed from: c */
    public void mo8c() {
        synchronized (this.f7906h) {
            if (this.f7907i) {
                this.f7905g.stop();
                this.f7907i = false;
                AssetFileDescriptor m = this.a.m9033m();
                if (m != null) {
                    m9073a(m);
                }
            }
            if (this.f7910l != null) {
                this.f7910l.cancel(true);
            }
            m19e();
        }
    }

    /* renamed from: a */
    private boolean m9073a(android.content.res.AssetFileDescriptor r8) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r7 = this;
        r0 = r7.f7908j;	 Catch:{ IOException -> 0x0027 }
        r0.stop();	 Catch:{ IOException -> 0x0027 }
        r0 = r7.f7908j;	 Catch:{ IOException -> 0x0027 }
        r0.reset();	 Catch:{ IOException -> 0x0027 }
        r1 = r7.f7908j;	 Catch:{ IOException -> 0x0027 }
        r2 = r8.getFileDescriptor();	 Catch:{ IOException -> 0x0027 }
        r3 = r8.getStartOffset();	 Catch:{ IOException -> 0x0027 }
        r5 = r8.getLength();	 Catch:{ IOException -> 0x0027 }
        r1.setDataSource(r2, r3, r5);	 Catch:{ IOException -> 0x0027 }
        r8 = r7.f7908j;	 Catch:{ IOException -> 0x0027 }
        r8.prepare();	 Catch:{ IOException -> 0x0027 }
        r8 = r7.f7908j;	 Catch:{ IOException -> 0x0027 }
        r8.start();	 Catch:{ IOException -> 0x0027 }
        r8 = 1;
        goto L_0x0028;
    L_0x0027:
        r8 = 0;
    L_0x0028:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: ai.api.d.b.a(android.content.res.AssetFileDescriptor):boolean");
    }

    /* renamed from: i */
    public void mo10i() {
        this.f7903e.submit(new C00241(this));
    }

    /* renamed from: j */
    public void mo11j() {
        this.f7903e.submit(new C00252(this));
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f7907i != null) {
            m9075b(this.f7909k);
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.f7907i != null) {
            m9075b(this.f7909k);
        }
        return null;
    }
}

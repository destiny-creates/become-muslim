package ai.api.p008d;

import ai.api.C0036f;
import ai.api.C0039h;
import ai.api.C0044j;
import ai.api.p005a.C0006c;
import ai.api.p005a.C3087a;
import ai.api.p007c.C0012a;
import ai.api.p007c.C0013c;
import ai.api.p007c.C3090b;
import ai.api.p009e.C0030b;
import ai.api.p009e.C0032d;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.util.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GoogleRecognitionServiceImpl */
/* renamed from: ai.api.d.a */
public class C3096a extends C0006c {
    /* renamed from: d */
    private static final String f7891d = "ai.api.d.a";
    /* renamed from: e */
    private SpeechRecognizer f7892e;
    /* renamed from: f */
    private final Object f7893f = new Object();
    /* renamed from: g */
    private C0044j f7894g;
    /* renamed from: h */
    private C0039h f7895h;
    /* renamed from: i */
    private final C0032d f7896i;
    /* renamed from: j */
    private volatile boolean f7897j = null;
    /* renamed from: k */
    private volatile boolean f7898k;
    /* renamed from: l */
    private final Handler f7899l = new Handler();
    /* renamed from: m */
    private Runnable f7900m;
    /* renamed from: n */
    private final Map<Integer, String> f7901n = new HashMap();

    /* compiled from: GoogleRecognitionServiceImpl */
    /* renamed from: ai.api.d.a$1 */
    class C00211 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3096a f82a;

        C00211(C3096a c3096a) {
            this.f82a = c3096a;
        }

        public void run() {
            this.f82a.mo7b();
        }
    }

    /* compiled from: GoogleRecognitionServiceImpl */
    /* renamed from: ai.api.d.a$a */
    private class C0023a implements RecognitionListener {
        /* renamed from: a */
        final /* synthetic */ C3096a f86a;

        public void onBeginningOfSpeech() {
        }

        public void onBufferReceived(byte[] bArr) {
        }

        public void onEvent(int i, Bundle bundle) {
        }

        private C0023a(C3096a c3096a) {
            this.f86a = c3096a;
        }

        public void onReadyForSpeech(Bundle bundle) {
            if (this.f86a.f7897j != null) {
                this.f86a.m18d();
            }
            this.f86a.f7898k = true;
        }

        public void onRmsChanged(float f) {
            if (this.f86a.f7897j) {
                this.f86a.m11a(f);
            }
        }

        public void onEndOfSpeech() {
            if (this.f86a.f7897j) {
                this.f86a.m20f();
            }
        }

        public void onError(int i) {
            if (i != 7 || this.f86a.f7898k) {
                if (this.f86a.f7897j) {
                    C0012a c0012a;
                    StringBuilder stringBuilder;
                    if (this.f86a.f7901n.containsKey(Integer.valueOf(i))) {
                        String str = (String) this.f86a.f7901n.get(Integer.valueOf(i));
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Speech recognition engine error: ");
                        stringBuilder.append(str);
                        c0012a = new C0012a(stringBuilder.toString());
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Speech recognition engine error: ");
                        stringBuilder.append(i);
                        c0012a = new C0012a(stringBuilder.toString());
                    }
                    this.f86a.m12a(c0012a);
                }
                this.f86a.m9061m();
                return;
            }
            Log.d(C3096a.f7891d, "SpeechRecognizer.ERROR_NO_MATCH, restartRecognition()");
            this.f86a.m9060l();
        }

        @TargetApi(14)
        public void onResults(Bundle bundle) {
            if (this.f86a.f7897j) {
                List stringArrayList = bundle.getStringArrayList("results_recognition");
                float[] fArr = null;
                if (VERSION.SDK_INT >= 14) {
                    fArr = bundle.getFloatArray("confidence_scores");
                }
                if (stringArrayList != null) {
                    if (stringArrayList.isEmpty() == null) {
                        bundle = new C3090b();
                        if (fArr != null) {
                            bundle.m9038a((String[]) stringArrayList.toArray(new String[stringArrayList.size()]), fArr);
                        } else {
                            bundle.m9036a((String) stringArrayList.get(0));
                        }
                        this.f86a.m9064a(stringArrayList);
                        this.f86a.m9041a((C3090b) bundle, this.f86a.f7894g);
                    }
                }
                this.f86a.m13a(new C0013c());
            }
            this.f86a.m9061m();
        }

        public void onPartialResults(Bundle bundle) {
            if (this.f86a.f7897j) {
                this.f86a.m9040a(1);
                List stringArrayList = bundle.getStringArrayList("results_recognition");
                if (stringArrayList != null && !stringArrayList.isEmpty()) {
                    this.f86a.m9064a(stringArrayList);
                }
            }
        }
    }

    public C3096a(Context context, C3087a c3087a) {
        super(c3087a, context);
        this.f7901n.put(Integer.valueOf(1), "Network operation timed out.");
        this.f7901n.put(Integer.valueOf(2), "Other network related errors.");
        this.f7901n.put(Integer.valueOf(3), "Audio recording error.");
        this.f7901n.put(Integer.valueOf(4), "Server sends error status.");
        this.f7901n.put(Integer.valueOf(5), "Other client side errors.");
        this.f7901n.put(Integer.valueOf(6), "No speech input.");
        this.f7901n.put(Integer.valueOf(7), "No recognition result matched.");
        this.f7901n.put(Integer.valueOf(8), "RecognitionService busy.");
        this.f7901n.put(Integer.valueOf(9), "Insufficient permissions.");
        if (C0030b.m85a(context) == null) {
            Log.w(f7891d, "Google Recognizer application not found on device. Quality of the recognition may be low. Please check if Google Search application installed and enabled.");
        }
        this.f7896i = C0032d.m91a(context);
        if (this.f7896i.m94b() != null) {
            this.f7900m = new C00211(this);
        }
    }

    /* renamed from: a */
    private void m9040a(int i) {
        if (this.f7900m == null) {
            return;
        }
        if (i == 0) {
            this.f7899l.removeCallbacks(this.f7900m);
        } else if (i == 1) {
            this.f7899l.removeCallbacks(this.f7900m);
            this.f7899l.postDelayed(this.f7900m, 1000);
        }
    }

    /* renamed from: h */
    protected void m9067h() {
        if (this.f7892e == null) {
            synchronized (this.f7893f) {
                if (this.f7892e != null) {
                    this.f7892e.destroy();
                    this.f7892e = null;
                }
                this.f7892e = SpeechRecognizer.createSpeechRecognizer(this.b, C0030b.m85a(this.b));
                this.f7892e.setRecognitionListener(new C0023a());
            }
        }
    }

    /* renamed from: i */
    protected void m9068i() {
        Log.d(f7891d, "clearRecognizer");
        if (this.f7892e != null) {
            synchronized (this.f7893f) {
                if (this.f7892e != null) {
                    this.f7892e.destroy();
                    this.f7892e = null;
                }
            }
        }
    }

    /* renamed from: a */
    private void m9041a(C3090b c3090b, final C0044j c0044j) {
        if (c3090b != null) {
            new AsyncTask<C3090b, Integer, C0013c>(this) {
                /* renamed from: b */
                final /* synthetic */ C3096a f84b;
                /* renamed from: c */
                private C0012a f85c;

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m71a((C3090b[]) objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    m72a((C0013c) obj);
                }

                /* renamed from: a */
                protected C0013c m71a(C3090b... c3090bArr) {
                    try {
                        return this.f84b.c.m43a((C3090b) c3090bArr[0], c0044j);
                    } catch (C0036f e) {
                        this.f85c = new C0012a(e);
                        return null;
                    }
                }

                /* renamed from: a */
                protected void m72a(C0013c c0013c) {
                    if (c0013c != null) {
                        this.f84b.m13a(c0013c);
                    } else {
                        this.f84b.m12a(this.f85c);
                    }
                }
            }.execute(new C3090b[]{c3090b});
            return;
        }
        throw new IllegalArgumentException("aiRequest must be not null");
    }

    /* renamed from: a */
    public void mo5a() {
        mo6a(new C0044j());
    }

    /* renamed from: a */
    public void mo6a(ai.api.C0044j r3) {
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
        r2 = this;
        r0 = r2.f7897j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r0 = r2.f7893f;
        monitor-enter(r0);
        r2.f7894g = r3;	 Catch:{ all -> 0x002f }
        r3 = r2.m21g();	 Catch:{ all -> 0x002f }
        if (r3 != 0) goto L_0x001b;	 Catch:{ all -> 0x002f }
    L_0x000f:
        r3 = new ai.api.c.a;	 Catch:{ all -> 0x002f }
        r1 = "RECORD_AUDIO permission is denied. Please request permission from user.";	 Catch:{ all -> 0x002f }
        r3.<init>(r1);	 Catch:{ all -> 0x002f }
        r2.m12a(r3);	 Catch:{ all -> 0x002f }
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return;	 Catch:{ all -> 0x002f }
    L_0x001b:
        r2.m9067h();	 Catch:{ all -> 0x002f }
        r3 = 1;	 Catch:{ all -> 0x002f }
        r2.f7897j = r3;	 Catch:{ all -> 0x002f }
        r3 = r2.m9059k();	 Catch:{ all -> 0x002f }
        r1 = 0;
        r2.f7898k = r1;	 Catch:{ SecurityException -> 0x002d }
        r1 = r2.f7892e;	 Catch:{ SecurityException -> 0x002d }
        r1.startListening(r3);	 Catch:{ SecurityException -> 0x002d }
    L_0x002d:
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        goto L_0x0040;	 Catch:{ all -> 0x002f }
    L_0x002f:
        r3 = move-exception;	 Catch:{ all -> 0x002f }
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        throw r3;
    L_0x0032:
        r3 = f7891d;
        r0 = "Trying to start recognition while another recognition active";
        android.util.Log.w(r3, r0);
        r3 = r2.f7898k;
        if (r3 != 0) goto L_0x0040;
    L_0x003d:
        r2.mo8c();
    L_0x0040:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ai.api.d.a.a(ai.api.j):void");
    }

    /* renamed from: k */
    private Intent m9059k() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        String replace = this.a.m27b().replace('-', '_');
        intent.putExtra("android.speech.extra.LANGUAGE", replace);
        intent.putExtra("android.speech.extra.LANGUAGE_PREFERENCE", replace);
        intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
        intent.putExtra("calling_package", this.b.getPackageName());
        intent.putExtra("android.speech.extra.EXTRA_ADDITIONAL_LANGUAGES", new String[]{replace});
        return intent;
    }

    /* renamed from: b */
    public void mo7b() {
        synchronized (this.f7893f) {
            if (this.f7892e != null) {
                this.f7892e.stopListening();
            }
        }
    }

    /* renamed from: c */
    public void mo8c() {
        synchronized (this.f7893f) {
            if (this.f7897j) {
                this.f7897j = false;
                if (this.f7892e != null) {
                    this.f7892e.cancel();
                }
                m19e();
            }
        }
    }

    /* renamed from: l */
    private void m9060l() {
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
        r0 = 0;
        r3.m9040a(r0);
        r3.f7897j = r0;
        r1 = r3.f7893f;
        monitor-enter(r1);
        r2 = r3.f7892e;	 Catch:{ Exception -> 0x0023 }
        if (r2 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x0023 }
    L_0x000d:
        r2 = r3.f7892e;	 Catch:{ Exception -> 0x0023 }
        r2.cancel();	 Catch:{ Exception -> 0x0023 }
        r2 = r3.m9059k();	 Catch:{ Exception -> 0x0023 }
        r3.f7898k = r0;	 Catch:{ Exception -> 0x0023 }
        r0 = r3.f7892e;	 Catch:{ Exception -> 0x0023 }
        r0.startListening(r2);	 Catch:{ Exception -> 0x0023 }
        r0 = 1;	 Catch:{ Exception -> 0x0023 }
        r3.f7897j = r0;	 Catch:{ Exception -> 0x0023 }
        goto L_0x0026;
    L_0x0021:
        r0 = move-exception;
        goto L_0x0028;
    L_0x0023:
        r3.mo7b();	 Catch:{ all -> 0x0021 }
    L_0x0026:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        return;	 Catch:{ all -> 0x0021 }
    L_0x0028:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: ai.api.d.a.l():void");
    }

    /* renamed from: a */
    protected void m9064a(List<String> list) {
        if (this.f7895h != null) {
            this.f7895h.m114a(list);
        }
    }

    /* renamed from: m */
    private void m9061m() {
        m9040a(0);
        if (this.f7896i.m93a()) {
            m9068i();
        }
        this.f7897j = false;
    }
}

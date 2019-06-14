package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.gms.ads.internal.ax;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
@cm
public final class ol extends ox implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {
    /* renamed from: c */
    private static final Map<Integer, String> f28716c = new HashMap();
    /* renamed from: d */
    private final po f28717d;
    /* renamed from: e */
    private final boolean f28718e;
    /* renamed from: f */
    private int f28719f = 0;
    /* renamed from: g */
    private int f28720g = 0;
    /* renamed from: h */
    private MediaPlayer f28721h;
    /* renamed from: i */
    private Uri f28722i;
    /* renamed from: j */
    private int f28723j;
    /* renamed from: k */
    private int f28724k;
    /* renamed from: l */
    private int f28725l;
    /* renamed from: m */
    private int f28726m;
    /* renamed from: n */
    private int f28727n;
    /* renamed from: o */
    private pl f28728o;
    /* renamed from: p */
    private boolean f28729p;
    /* renamed from: q */
    private int f28730q;
    /* renamed from: r */
    private ow f28731r;

    static {
        if (VERSION.SDK_INT >= 17) {
            f28716c.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
            f28716c.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
            f28716c.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
            f28716c.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
            f28716c.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        f28716c.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        f28716c.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        f28716c.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        f28716c.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        f28716c.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        f28716c.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        f28716c.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        f28716c.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        f28716c.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        if (VERSION.SDK_INT >= 19) {
            f28716c.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            f28716c.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public ol(Context context, boolean z, boolean z2, pm pmVar, po poVar) {
        super(context);
        setSurfaceTextureListener(this);
        this.f28717d = poVar;
        this.f28729p = z;
        this.f28718e = z2;
        this.f28717d.m20010a(this);
    }

    /* renamed from: a */
    private final void m37570a(float r2) {
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
        r1 = this;
        r0 = r1.f28721h;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r1.f28721h;	 Catch:{ IllegalStateException -> 0x0009 }
        r0.setVolume(r2, r2);	 Catch:{ IllegalStateException -> 0x0009 }
    L_0x0009:
        return;
    L_0x000a:
        r2 = "AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().";
        com.google.android.gms.internal.ads.mt.m19924e(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ol.a(float):void");
    }

    /* renamed from: a */
    private final void m37571a(boolean z) {
        jn.m30864a("AdMediaPlayerView release");
        if (this.f28728o != null) {
            this.f28728o.m30973b();
            this.f28728o = null;
        }
        if (this.f28721h != null) {
            this.f28721h.reset();
            this.f28721h.release();
            this.f28721h = null;
            m37572c(0);
            if (z) {
                this.f28720g = 0;
                this.f28720g = 0;
            }
        }
    }

    /* renamed from: c */
    private final void m37572c(int i) {
        if (i == 3) {
            this.f28717d.m20013c();
            this.b.m20022b();
        } else if (this.f28719f == 3) {
            this.f28717d.m20014d();
            this.b.m20023c();
        }
        this.f28719f = i;
    }

    /* renamed from: f */
    private final void m37573f() {
        jn.m30864a("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.f28722i != null) {
            if (surfaceTexture != null) {
                m37571a(false);
                try {
                    ax.v();
                    this.f28721h = new MediaPlayer();
                    this.f28721h.setOnBufferingUpdateListener(this);
                    this.f28721h.setOnCompletionListener(this);
                    this.f28721h.setOnErrorListener(this);
                    this.f28721h.setOnInfoListener(this);
                    this.f28721h.setOnPreparedListener(this);
                    this.f28721h.setOnVideoSizeChangedListener(this);
                    this.f28725l = 0;
                    if (this.f28729p) {
                        this.f28728o = new pl(getContext());
                        this.f28728o.m30972a(surfaceTexture, getWidth(), getHeight());
                        this.f28728o.start();
                        SurfaceTexture c = this.f28728o.m30974c();
                        if (c != null) {
                            surfaceTexture = c;
                        } else {
                            this.f28728o.m30973b();
                            this.f28728o = null;
                        }
                    }
                    this.f28721h.setDataSource(getContext(), this.f28722i);
                    ax.w();
                    this.f28721h.setSurface(new Surface(surfaceTexture));
                    this.f28721h.setAudioStreamType(3);
                    this.f28721h.setScreenOnWhilePlaying(true);
                    this.f28721h.prepareAsync();
                    m37572c(1);
                } catch (Throwable e) {
                    String valueOf = String.valueOf(this.f28722i);
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 36);
                    stringBuilder.append("Failed to initialize MediaPlayer at ");
                    stringBuilder.append(valueOf);
                    mt.m19921c(stringBuilder.toString(), e);
                    onError(this.f28721h, 1, 0);
                }
            }
        }
    }

    /* renamed from: g */
    private final void m37574g() {
        if (this.f28718e && m37575h() && this.f28721h.getCurrentPosition() > 0 && this.f28720g != 3) {
            jn.m30864a("AdMediaPlayerView nudging MediaPlayer");
            m37570a(0.0f);
            this.f28721h.start();
            int currentPosition = this.f28721h.getCurrentPosition();
            long a = ax.l().a();
            while (m37575h() && this.f28721h.getCurrentPosition() == currentPosition) {
                if (ax.l().a() - a > 250) {
                    break;
                }
            }
            this.f28721h.pause();
            mo4324e();
        }
    }

    /* renamed from: h */
    private final boolean m37575h() {
        return (this.f28721h == null || this.f28719f == -1 || this.f28719f == 0 || this.f28719f == 1) ? false : true;
    }

    /* renamed from: a */
    public final String mo6112a() {
        String str = "MediaPlayer";
        String valueOf = String.valueOf(this.f28729p ? " spherical" : "");
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    /* renamed from: a */
    public final void mo6113a(float f, float f2) {
        if (this.f28728o != null) {
            this.f28728o.m30970a(f, f2);
        }
    }

    /* renamed from: a */
    public final void mo6114a(int i) {
        StringBuilder stringBuilder = new StringBuilder(34);
        stringBuilder.append("AdMediaPlayerView seek ");
        stringBuilder.append(i);
        jn.m30864a(stringBuilder.toString());
        if (m37575h()) {
            this.f28721h.seekTo(i);
            this.f28730q = 0;
            return;
        }
        this.f28730q = i;
    }

    /* renamed from: a */
    public final void mo6115a(ow owVar) {
        this.f28731r = owVar;
    }

    /* renamed from: b */
    public final void mo6116b() {
        jn.m30864a("AdMediaPlayerView stop");
        if (this.f28721h != null) {
            this.f28721h.stop();
            this.f28721h.release();
            this.f28721h = null;
            m37572c(0);
            this.f28720g = 0;
        }
        this.f28717d.m20011b();
    }

    /* renamed from: b */
    final /* synthetic */ void m37581b(int i) {
        if (this.f28731r != null) {
            this.f28731r.onWindowVisibilityChanged(i);
        }
    }

    /* renamed from: c */
    public final void mo6117c() {
        jn.m30864a("AdMediaPlayerView play");
        if (m37575h()) {
            this.f28721h.start();
            m37572c(3);
            this.a.m19998a();
            jw.f15691a.post(new ou(this));
        }
        this.f28720g = 3;
    }

    /* renamed from: d */
    public final void mo6118d() {
        jn.m30864a("AdMediaPlayerView pause");
        if (m37575h() && this.f28721h.isPlaying()) {
            this.f28721h.pause();
            m37572c(4);
            jw.f15691a.post(new ov(this));
        }
        this.f28720g = 4;
    }

    /* renamed from: e */
    public final void mo4324e() {
        m37570a(this.b.m20019a());
    }

    public final int getCurrentPosition() {
        return m37575h() ? this.f28721h.getCurrentPosition() : 0;
    }

    public final int getDuration() {
        return m37575h() ? this.f28721h.getDuration() : -1;
    }

    public final int getVideoHeight() {
        return this.f28721h != null ? this.f28721h.getVideoHeight() : 0;
    }

    public final int getVideoWidth() {
        return this.f28721h != null ? this.f28721h.getVideoWidth() : 0;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f28725l = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        jn.m30864a("AdMediaPlayerView completion");
        m37572c(5);
        this.f28720g = 5;
        jw.f15691a.post(new oo(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f28716c.get(Integer.valueOf(i));
        String str2 = (String) f28716c.get(Integer.valueOf(i2));
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 38) + String.valueOf(str2).length());
        stringBuilder.append("AdMediaPlayerView MediaPlayer error: ");
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(str2);
        mt.m19924e(stringBuilder.toString());
        m37572c(-1);
        this.f28720g = -1;
        jw.f15691a.post(new op(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f28716c.get(Integer.valueOf(i));
        String str2 = (String) f28716c.get(Integer.valueOf(i2));
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 37) + String.valueOf(str2).length());
        stringBuilder.append("AdMediaPlayerView MediaPlayer info: ");
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(str2);
        jn.m30864a(stringBuilder.toString());
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void onMeasure(int r6, int r7) {
        /*
        r5 = this;
        r0 = r5.f28723j;
        r0 = getDefaultSize(r0, r6);
        r1 = r5.f28724k;
        r1 = getDefaultSize(r1, r7);
        r2 = r5.f28723j;
        if (r2 <= 0) goto L_0x008e;
    L_0x0010:
        r2 = r5.f28724k;
        if (r2 <= 0) goto L_0x008e;
    L_0x0014:
        r2 = r5.f28728o;
        if (r2 != 0) goto L_0x008e;
    L_0x0018:
        r0 = android.view.View.MeasureSpec.getMode(r6);
        r6 = android.view.View.MeasureSpec.getSize(r6);
        r1 = android.view.View.MeasureSpec.getMode(r7);
        r7 = android.view.View.MeasureSpec.getSize(r7);
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r0 != r2) goto L_0x0055;
    L_0x002c:
        if (r1 != r2) goto L_0x0055;
    L_0x002e:
        r0 = r5.f28723j;
        r0 = r0 * r7;
        r1 = r5.f28724k;
        r1 = r1 * r6;
        if (r0 >= r1) goto L_0x0042;
    L_0x0038:
        r6 = r5.f28723j;
        r6 = r6 * r7;
        r0 = r5.f28724k;
        r0 = r6 / r0;
        r6 = r0;
        goto L_0x0090;
    L_0x0042:
        r0 = r5.f28723j;
        r0 = r0 * r7;
        r1 = r5.f28724k;
        r1 = r1 * r6;
        if (r0 <= r1) goto L_0x0090;
    L_0x004c:
        r7 = r5.f28724k;
        r7 = r7 * r6;
        r0 = r5.f28723j;
        r1 = r7 / r0;
        goto L_0x008f;
    L_0x0055:
        r3 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r0 != r2) goto L_0x0067;
    L_0x0059:
        r0 = r5.f28724k;
        r0 = r0 * r6;
        r2 = r5.f28723j;
        r0 = r0 / r2;
        if (r1 != r3) goto L_0x0065;
    L_0x0062:
        if (r0 <= r7) goto L_0x0065;
    L_0x0064:
        goto L_0x0090;
    L_0x0065:
        r7 = r0;
        goto L_0x0090;
    L_0x0067:
        if (r1 != r2) goto L_0x0077;
    L_0x0069:
        r1 = r5.f28723j;
        r1 = r1 * r7;
        r2 = r5.f28724k;
        r1 = r1 / r2;
        if (r0 != r3) goto L_0x0075;
    L_0x0072:
        if (r1 <= r6) goto L_0x0075;
    L_0x0074:
        goto L_0x0090;
    L_0x0075:
        r6 = r1;
        goto L_0x0090;
    L_0x0077:
        r2 = r5.f28723j;
        r4 = r5.f28724k;
        if (r1 != r3) goto L_0x0087;
    L_0x007d:
        if (r4 <= r7) goto L_0x0087;
    L_0x007f:
        r1 = r5.f28723j;
        r1 = r1 * r7;
        r2 = r5.f28724k;
        r1 = r1 / r2;
        goto L_0x0089;
    L_0x0087:
        r1 = r2;
        r7 = r4;
    L_0x0089:
        if (r0 != r3) goto L_0x0075;
    L_0x008b:
        if (r1 <= r6) goto L_0x0075;
    L_0x008d:
        goto L_0x004c;
    L_0x008e:
        r6 = r0;
    L_0x008f:
        r7 = r1;
    L_0x0090:
        r5.setMeasuredDimension(r6, r7);
        r0 = r5.f28728o;
        if (r0 == 0) goto L_0x009c;
    L_0x0097:
        r0 = r5.f28728o;
        r0.m30971a(r6, r7);
    L_0x009c:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 != r1) goto L_0x00b9;
    L_0x00a2:
        r0 = r5.f28726m;
        if (r0 <= 0) goto L_0x00aa;
    L_0x00a6:
        r0 = r5.f28726m;
        if (r0 != r6) goto L_0x00b2;
    L_0x00aa:
        r0 = r5.f28727n;
        if (r0 <= 0) goto L_0x00b5;
    L_0x00ae:
        r0 = r5.f28727n;
        if (r0 == r7) goto L_0x00b5;
    L_0x00b2:
        r5.m37574g();
    L_0x00b5:
        r5.f28726m = r6;
        r5.f28727n = r7;
    L_0x00b9:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ol.onMeasure(int, int):void");
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        jn.m30864a("AdMediaPlayerView prepared");
        m37572c(2);
        this.f28717d.m20009a();
        jw.f15691a.post(new on(this));
        this.f28723j = mediaPlayer.getVideoWidth();
        this.f28724k = mediaPlayer.getVideoHeight();
        if (this.f28730q != 0) {
            mo6114a(this.f28730q);
        }
        m37574g();
        int i = this.f28723j;
        int i2 = this.f28724k;
        StringBuilder stringBuilder = new StringBuilder(62);
        stringBuilder.append("AdMediaPlayerView stream dimensions: ");
        stringBuilder.append(i);
        stringBuilder.append(" x ");
        stringBuilder.append(i2);
        mt.m19922d(stringBuilder.toString());
        if (this.f28720g == 3) {
            mo6117c();
        }
        mo4324e();
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        jn.m30864a("AdMediaPlayerView surface created");
        m37573f();
        jw.f15691a.post(new or(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        jn.m30864a("AdMediaPlayerView surface destroyed");
        if (this.f28721h != null && this.f28730q == 0) {
            this.f28730q = this.f28721h.getCurrentPosition();
        }
        if (this.f28728o != null) {
            this.f28728o.m30973b();
        }
        jw.f15691a.post(new ot(this));
        m37571a(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        jn.m30864a("AdMediaPlayerView surface changed");
        Object obj = null;
        Object obj2 = this.f28720g == 3 ? 1 : null;
        if (this.f28723j == i && this.f28724k == i2) {
            obj = 1;
        }
        if (!(this.f28721h == null || obj2 == null || r0 == null)) {
            if (this.f28730q != 0) {
                mo6114a(this.f28730q);
            }
            mo6117c();
        }
        if (this.f28728o != null) {
            this.f28728o.m30971a(i, i2);
        }
        jw.f15691a.post(new os(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f28717d.m20012b(this);
        this.a.m19999a(surfaceTexture, this.f28731r);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(57);
        stringBuilder.append("AdMediaPlayerView size changed: ");
        stringBuilder.append(i);
        stringBuilder.append(" x ");
        stringBuilder.append(i2);
        jn.m30864a(stringBuilder.toString());
        this.f28723j = mediaPlayer.getVideoWidth();
        this.f28724k = mediaPlayer.getVideoHeight();
        if (this.f28723j != 0 && this.f28724k != 0) {
            requestLayout();
        }
    }

    protected final void onWindowVisibilityChanged(int i) {
        StringBuilder stringBuilder = new StringBuilder(58);
        stringBuilder.append("AdMediaPlayerView window visibility changed to ");
        stringBuilder.append(i);
        jn.m30864a(stringBuilder.toString());
        jw.f15691a.post(new om(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        amq a = amq.m36801a(parse);
        if (a != null) {
            parse = Uri.parse(a.f28117a);
        }
        this.f28722i = parse;
        this.f28730q = 0;
        m37573f();
        requestLayout();
        invalidate();
    }

    public final String toString() {
        String name = getClass().getName();
        String toHexString = Integer.toHexString(hashCode());
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(name).length() + 1) + String.valueOf(toHexString).length());
        stringBuilder.append(name);
        stringBuilder.append("@");
        stringBuilder.append(toHexString);
        return stringBuilder.toString();
    }
}

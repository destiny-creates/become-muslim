package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.v4.app.C0296g;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.C0436a.C3207a;
import android.support.v4.media.session.C0437b.C3209a;
import android.support.v4.media.session.C0441c.C0438a;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public final class MediaControllerCompat {

    static class MediaControllerImplApi21 {
        /* renamed from: a */
        private final List<C0428a> f1104a;
        /* renamed from: b */
        private C0437b f1105b;
        /* renamed from: c */
        private HashMap<C0428a, C4827a> f1106c;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            /* renamed from: a */
            private WeakReference<MediaControllerImplApi21> f1103a;

            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f1103a.get();
                if (mediaControllerImplApi21 != null) {
                    if (bundle != null) {
                        mediaControllerImplApi21.f1105b = C3209a.m9756a(C0296g.m871a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                        mediaControllerImplApi21.m1270a();
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a */
        private static class C4827a extends C4462c {
            C4827a(C0428a c0428a) {
                super(c0428a);
            }

            /* renamed from: a */
            public void mo239a() {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo242a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo247a(List<QueueItem> list) {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo245a(CharSequence charSequence) {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo241a(Bundle bundle) {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo243a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }

        /* renamed from: a */
        private void m1270a() {
            if (this.f1105b != null) {
                synchronized (this.f1104a) {
                    for (C0428a c0428a : this.f1104a) {
                        C0436a c4827a = new C4827a(c0428a);
                        this.f1106c.put(c0428a, c4827a);
                        c0428a.f1110b = true;
                        try {
                            this.f1105b.mo260a(c4827a);
                            c0428a.m1272a();
                        } catch (Throwable e) {
                            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                        }
                    }
                    this.f1104a.clear();
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$a */
    public static abstract class C0428a implements DeathRecipient {
        /* renamed from: a */
        C0427a f1109a;
        /* renamed from: b */
        boolean f1110b;
        /* renamed from: c */
        private final Object f1111c;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a */
        private class C0427a extends Handler {
            /* renamed from: a */
            boolean f1107a;
            /* renamed from: b */
            final /* synthetic */ C0428a f1108b;

            public void handleMessage(Message message) {
                if (this.f1107a) {
                    switch (message.what) {
                        case 1:
                            this.f1108b.m1280a((String) message.obj, message.getData());
                            break;
                        case 2:
                            this.f1108b.m1278a((PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            this.f1108b.m1276a((MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            this.f1108b.m1277a((C0429b) message.obj);
                            break;
                        case 5:
                            this.f1108b.m1281a((List) message.obj);
                            break;
                        case 6:
                            this.f1108b.m1279a((CharSequence) message.obj);
                            break;
                        case 7:
                            this.f1108b.m1275a((Bundle) message.obj);
                            break;
                        case 8:
                            this.f1108b.m1283b();
                            break;
                        case 9:
                            this.f1108b.m1273a(((Integer) message.obj).intValue());
                            break;
                        case 11:
                            this.f1108b.m1282a(((Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            this.f1108b.m1284b(((Integer) message.obj).intValue());
                            break;
                        case 13:
                            this.f1108b.m1272a();
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$b */
        private static class C3205b implements C0438a {
            /* renamed from: a */
            private final WeakReference<C0428a> f8260a;

            C3205b(C0428a c0428a) {
                this.f8260a = new WeakReference(c0428a);
            }

            /* renamed from: a */
            public void mo231a() {
                C0428a c0428a = (C0428a) this.f8260a.get();
                if (c0428a != null) {
                    c0428a.m1283b();
                }
            }

            /* renamed from: a */
            public void mo236a(String str, Bundle bundle) {
                C0428a c0428a = (C0428a) this.f8260a.get();
                if (c0428a == null) {
                    return;
                }
                if (!c0428a.f1110b || VERSION.SDK_INT >= 23) {
                    c0428a.m1280a(str, bundle);
                }
            }

            /* renamed from: a */
            public void mo235a(Object obj) {
                C0428a c0428a = (C0428a) this.f8260a.get();
                if (c0428a == null) {
                    return;
                }
                if (!c0428a.f1110b) {
                    c0428a.m1278a(PlaybackStateCompat.m1300a(obj));
                }
            }

            /* renamed from: b */
            public void mo238b(Object obj) {
                C0428a c0428a = (C0428a) this.f8260a.get();
                if (c0428a != null) {
                    c0428a.m1276a(MediaMetadataCompat.m1247a(obj));
                }
            }

            /* renamed from: a */
            public void mo237a(List<?> list) {
                C0428a c0428a = (C0428a) this.f8260a.get();
                if (c0428a != null) {
                    c0428a.m1281a(QueueItem.m1288a((List) list));
                }
            }

            /* renamed from: a */
            public void mo234a(CharSequence charSequence) {
                C0428a c0428a = (C0428a) this.f8260a.get();
                if (c0428a != null) {
                    c0428a.m1279a(charSequence);
                }
            }

            /* renamed from: a */
            public void mo233a(Bundle bundle) {
                C0428a c0428a = (C0428a) this.f8260a.get();
                if (c0428a != null) {
                    c0428a.m1275a(bundle);
                }
            }

            /* renamed from: a */
            public void mo232a(int i, int i2, int i3, int i4, int i5) {
                C0428a c0428a = (C0428a) this.f8260a.get();
                if (c0428a != null) {
                    c0428a.m1277a(new C0429b(i, i2, i3, i4, i5));
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$c */
        private static class C4462c extends C3207a {
            /* renamed from: a */
            private final WeakReference<C0428a> f11913a;

            /* renamed from: a */
            public void mo248a(boolean z) {
            }

            C4462c(C0428a c0428a) {
                this.f11913a = new WeakReference(c0428a);
            }

            /* renamed from: a */
            public void mo246a(String str, Bundle bundle) {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    c0428a.m1274a(1, str, bundle);
                }
            }

            /* renamed from: a */
            public void mo239a() {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    c0428a.m1274a(8, null, null);
                }
            }

            /* renamed from: a */
            public void mo244a(PlaybackStateCompat playbackStateCompat) {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    c0428a.m1274a(2, playbackStateCompat, null);
                }
            }

            /* renamed from: a */
            public void mo242a(MediaMetadataCompat mediaMetadataCompat) {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    c0428a.m1274a(3, mediaMetadataCompat, null);
                }
            }

            /* renamed from: a */
            public void mo247a(List<QueueItem> list) {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    c0428a.m1274a(5, list, null);
                }
            }

            /* renamed from: a */
            public void mo245a(CharSequence charSequence) {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    c0428a.m1274a(6, charSequence, null);
                }
            }

            /* renamed from: b */
            public void mo251b(boolean z) {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    c0428a.m1274a(11, Boolean.valueOf(z), null);
                }
            }

            /* renamed from: a */
            public void mo240a(int i) {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    c0428a.m1274a(9, Integer.valueOf(i), null);
                }
            }

            /* renamed from: b */
            public void mo250b(int i) {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    c0428a.m1274a(12, Integer.valueOf(i), null);
                }
            }

            /* renamed from: a */
            public void mo241a(Bundle bundle) {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    c0428a.m1274a(7, bundle, null);
                }
            }

            /* renamed from: a */
            public void mo243a(ParcelableVolumeInfo parcelableVolumeInfo) {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    Object obj;
                    if (parcelableVolumeInfo != null) {
                        C0429b c0429b = new C0429b(parcelableVolumeInfo.f1123a, parcelableVolumeInfo.f1124b, parcelableVolumeInfo.f1125c, parcelableVolumeInfo.f1126d, parcelableVolumeInfo.f1127e);
                    } else {
                        obj = null;
                    }
                    c0428a.m1274a(4, obj, null);
                }
            }

            /* renamed from: b */
            public void mo249b() {
                C0428a c0428a = (C0428a) this.f11913a.get();
                if (c0428a != null) {
                    c0428a.m1274a(13, null, null);
                }
            }
        }

        /* renamed from: a */
        public void m1272a() {
        }

        /* renamed from: a */
        public void m1273a(int i) {
        }

        /* renamed from: a */
        public void m1275a(Bundle bundle) {
        }

        /* renamed from: a */
        public void m1276a(MediaMetadataCompat mediaMetadataCompat) {
        }

        /* renamed from: a */
        public void m1277a(C0429b c0429b) {
        }

        /* renamed from: a */
        public void m1278a(PlaybackStateCompat playbackStateCompat) {
        }

        /* renamed from: a */
        public void m1279a(CharSequence charSequence) {
        }

        /* renamed from: a */
        public void m1280a(String str, Bundle bundle) {
        }

        /* renamed from: a */
        public void m1281a(List<QueueItem> list) {
        }

        /* renamed from: a */
        public void m1282a(boolean z) {
        }

        /* renamed from: b */
        public void m1283b() {
        }

        /* renamed from: b */
        public void m1284b(int i) {
        }

        public C0428a() {
            if (VERSION.SDK_INT >= 21) {
                this.f1111c = C0441c.m1374a(new C3205b(this));
            } else {
                this.f1111c = new C4462c(this);
            }
        }

        /* renamed from: a */
        void m1274a(int i, Object obj, Bundle bundle) {
            if (this.f1109a != null) {
                i = this.f1109a.obtainMessage(i, obj);
                i.setData(bundle);
                i.sendToTarget();
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$b */
    public static final class C0429b {
        /* renamed from: a */
        private final int f1112a;
        /* renamed from: b */
        private final int f1113b;
        /* renamed from: c */
        private final int f1114c;
        /* renamed from: d */
        private final int f1115d;
        /* renamed from: e */
        private final int f1116e;

        C0429b(int i, int i2, int i3, int i4, int i5) {
            this.f1112a = i;
            this.f1113b = i2;
            this.f1114c = i3;
            this.f1115d = i4;
            this.f1116e = i5;
        }
    }
}

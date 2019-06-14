package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* compiled from: MediaControllerCompatApi21 */
/* renamed from: android.support.v4.media.session.c */
class C0441c {

    /* compiled from: MediaControllerCompatApi21 */
    /* renamed from: android.support.v4.media.session.c$a */
    public interface C0438a {
        /* renamed from: a */
        void mo231a();

        /* renamed from: a */
        void mo232a(int i, int i2, int i3, int i4, int i5);

        /* renamed from: a */
        void mo233a(Bundle bundle);

        /* renamed from: a */
        void mo234a(CharSequence charSequence);

        /* renamed from: a */
        void mo235a(Object obj);

        /* renamed from: a */
        void mo236a(String str, Bundle bundle);

        /* renamed from: a */
        void mo237a(List<?> list);

        /* renamed from: b */
        void mo238b(Object obj);
    }

    /* compiled from: MediaControllerCompatApi21 */
    /* renamed from: android.support.v4.media.session.c$b */
    static class C0439b<T extends C0438a> extends Callback {
        /* renamed from: a */
        protected final T f1145a;

        public C0439b(T t) {
            this.f1145a = t;
        }

        public void onSessionDestroyed() {
            this.f1145a.mo231a();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            this.f1145a.mo236a(str, bundle);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f1145a.mo235a((Object) playbackState);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f1145a.mo238b(mediaMetadata);
        }

        public void onQueueChanged(List<QueueItem> list) {
            this.f1145a.mo237a((List) list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f1145a.mo234a(charSequence);
        }

        public void onExtrasChanged(Bundle bundle) {
            this.f1145a.mo233a(bundle);
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
            this.f1145a.mo232a(playbackInfo.getPlaybackType(), C0440c.m1373b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }

    /* compiled from: MediaControllerCompatApi21 */
    /* renamed from: android.support.v4.media.session.c$c */
    public static class C0440c {
        /* renamed from: a */
        public static AudioAttributes m1372a(Object obj) {
            return ((PlaybackInfo) obj).getAudioAttributes();
        }

        /* renamed from: b */
        public static int m1373b(Object obj) {
            return C0440c.m1371a(C0440c.m1372a(obj));
        }

        /* renamed from: a */
        private static int m1371a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case 11:
                case 12:
                case 14:
                    return 3;
                case 2:
                    return null;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }
    }

    /* renamed from: a */
    public static Object m1374a(C0438a c0438a) {
        return new C0439b(c0438a);
    }
}

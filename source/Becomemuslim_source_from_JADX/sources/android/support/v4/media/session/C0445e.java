package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.CustomAction;
import android.os.Bundle;
import java.util.List;

/* compiled from: PlaybackStateCompatApi21 */
/* renamed from: android.support.v4.media.session.e */
class C0445e {

    /* compiled from: PlaybackStateCompatApi21 */
    /* renamed from: android.support.v4.media.session.e$a */
    static final class C0444a {
        /* renamed from: a */
        public static String m1377a(Object obj) {
            return ((CustomAction) obj).getAction();
        }

        /* renamed from: b */
        public static CharSequence m1378b(Object obj) {
            return ((CustomAction) obj).getName();
        }

        /* renamed from: c */
        public static int m1379c(Object obj) {
            return ((CustomAction) obj).getIcon();
        }

        /* renamed from: d */
        public static Bundle m1380d(Object obj) {
            return ((CustomAction) obj).getExtras();
        }
    }

    /* renamed from: a */
    public static int m1381a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    /* renamed from: b */
    public static long m1382b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    /* renamed from: c */
    public static long m1383c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    /* renamed from: d */
    public static float m1384d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    /* renamed from: e */
    public static long m1385e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    /* renamed from: f */
    public static CharSequence m1386f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    /* renamed from: g */
    public static long m1387g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    /* renamed from: h */
    public static List<Object> m1388h(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    /* renamed from: i */
    public static long m1389i(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }
}

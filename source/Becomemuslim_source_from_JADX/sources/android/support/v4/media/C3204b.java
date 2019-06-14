package android.support.v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.support.v4.media.C0425a.C0424a;

/* compiled from: MediaDescriptionCompatApi23 */
/* renamed from: android.support.v4.media.b */
class C3204b extends C0425a {

    /* compiled from: MediaDescriptionCompatApi23 */
    /* renamed from: android.support.v4.media.b$a */
    static class C3203a extends C0424a {
        /* renamed from: b */
        public static void m9683b(Object obj, Uri uri) {
            ((Builder) obj).setMediaUri(uri);
        }
    }

    /* renamed from: h */
    public static Uri m9684h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}

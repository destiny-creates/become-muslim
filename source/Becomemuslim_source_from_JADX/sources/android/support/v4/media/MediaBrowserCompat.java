package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p030f.C0396g;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {
    /* renamed from: a */
    static final boolean f1077a = Log.isLoggable("MediaBrowserCompat", 3);

    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new C04161();
        /* renamed from: a */
        private final int f1075a;
        /* renamed from: b */
        private final MediaDescriptionCompat f1076b;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$1 */
        static class C04161 implements Creator<MediaItem> {
            C04161() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1223a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1224a(i);
            }

            /* renamed from: a */
            public MediaItem m1223a(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: a */
            public MediaItem[] m1224a(int i) {
                return new MediaItem[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        MediaItem(Parcel parcel) {
            this.f1075a = parcel.readInt();
            this.f1076b = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1075a);
            this.f1076b.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=");
            stringBuilder.append(this.f1075a);
            stringBuilder.append(", mDescription=");
            stringBuilder.append(this.f1076b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$a */
    public static abstract class C0417a {
        /* renamed from: a */
        public void m1225a(String str, Bundle bundle, Bundle bundle2) {
        }

        /* renamed from: b */
        public void m1226b(String str, Bundle bundle, Bundle bundle2) {
        }

        /* renamed from: c */
        public void m1227c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$b */
    public static abstract class C0418b {
        /* renamed from: a */
        public void m1228a(MediaItem mediaItem) {
        }

        /* renamed from: a */
        public void m1229a(String str) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$c */
    public static abstract class C0419c {
        /* renamed from: a */
        public void m1230a(String str, Bundle bundle) {
        }

        /* renamed from: a */
        public void m1231a(String str, Bundle bundle, List<MediaItem> list) {
        }
    }

    private static class CustomActionResultReceiver extends C0396g {
        /* renamed from: d */
        private final String f8252d;
        /* renamed from: e */
        private final Bundle f8253e;
        /* renamed from: f */
        private final C0417a f8254f;

        /* renamed from: a */
        protected void mo230a(int i, Bundle bundle) {
            if (this.f8254f != null) {
                switch (i) {
                    case -1:
                        this.f8254f.m1227c(this.f8252d, this.f8253e, bundle);
                        break;
                    case 0:
                        this.f8254f.m1226b(this.f8252d, this.f8253e, bundle);
                        break;
                    case 1:
                        this.f8254f.m1225a(this.f8252d, this.f8253e, bundle);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown result code: ");
                        stringBuilder.append(i);
                        stringBuilder.append(" (extras=");
                        stringBuilder.append(this.f8253e);
                        stringBuilder.append(", resultData=");
                        stringBuilder.append(bundle);
                        stringBuilder.append(")");
                        Log.w("MediaBrowserCompat", stringBuilder.toString());
                        break;
                }
            }
        }
    }

    private static class ItemReceiver extends C0396g {
        /* renamed from: d */
        private final String f8255d;
        /* renamed from: e */
        private final C0418b f8256e;

        /* renamed from: a */
        protected void mo230a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null) {
                if (bundle.containsKey("media_item") != 0) {
                    i = bundle.getParcelable("media_item");
                    if (i != 0) {
                        if ((i instanceof MediaItem) == null) {
                            this.f8256e.m1229a(this.f8255d);
                            return;
                        }
                    }
                    this.f8256e.m1228a((MediaItem) i);
                    return;
                }
            }
            this.f8256e.m1229a(this.f8255d);
        }
    }

    private static class SearchResultReceiver extends C0396g {
        /* renamed from: d */
        private final String f8257d;
        /* renamed from: e */
        private final Bundle f8258e;
        /* renamed from: f */
        private final C0419c f8259f;

        /* renamed from: a */
        protected void mo230a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null) {
                if (bundle.containsKey("search_results") != 0) {
                    i = bundle.getParcelableArray("search_results");
                    bundle = null;
                    if (i != 0) {
                        bundle = new ArrayList();
                        for (Object obj : i) {
                            bundle.add((MediaItem) obj);
                        }
                    }
                    this.f8259f.m1231a(this.f8257d, this.f8258e, bundle);
                    return;
                }
            }
            this.f8259f.m1230a(this.f8257d, this.f8258e);
        }
    }
}

package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.C0443d.C0442a;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new C04301();
        /* renamed from: a */
        private final MediaDescriptionCompat f1117a;
        /* renamed from: b */
        private final long f1118b;
        /* renamed from: c */
        private Object f1119c;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem$1 */
        static class C04301 implements Creator<QueueItem> {
            C04301() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1285a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1286a(i);
            }

            /* renamed from: a */
            public QueueItem m1285a(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: a */
            public QueueItem[] m1286a(int i) {
                return new QueueItem[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j != -1) {
                this.f1117a = mediaDescriptionCompat;
                this.f1118b = j;
                this.f1119c = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        QueueItem(Parcel parcel) {
            this.f1117a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f1118b = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f1117a.writeToParcel(parcel, i);
            parcel.writeLong(this.f1118b);
        }

        /* renamed from: a */
        public static QueueItem m1287a(Object obj) {
            if (obj != null) {
                if (VERSION.SDK_INT >= 21) {
                    return new QueueItem(obj, MediaDescriptionCompat.m1243a(C0442a.m1375a(obj)), C0442a.m1376b(obj));
                }
            }
            return null;
        }

        /* renamed from: a */
        public static List<QueueItem> m1288a(List<?> list) {
            if (list != null) {
                if (VERSION.SDK_INT >= 21) {
                    List<QueueItem> arrayList = new ArrayList();
                    for (Object a : list) {
                        arrayList.add(m1287a(a));
                    }
                    return arrayList;
                }
            }
            return null;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MediaSession.QueueItem {Description=");
            stringBuilder.append(this.f1117a);
            stringBuilder.append(", Id=");
            stringBuilder.append(this.f1118b);
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new C04311();
        /* renamed from: a */
        private ResultReceiver f1120a;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1 */
        static class C04311 implements Creator<ResultReceiverWrapper> {
            C04311() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1289a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1290a(i);
            }

            /* renamed from: a */
            public ResultReceiverWrapper m1289a(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: a */
            public ResultReceiverWrapper[] m1290a(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f1120a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f1120a.writeToParcel(parcel, i);
        }
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new C04321();
        /* renamed from: a */
        private final Object f1121a;
        /* renamed from: b */
        private final C0437b f1122b;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token$1 */
        static class C04321 implements Creator<Token> {
            C04321() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1291a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1292a(i);
            }

            /* renamed from: a */
            public Token m1291a(Parcel parcel) {
                if (VERSION.SDK_INT >= 21) {
                    parcel = parcel.readParcelable(null);
                } else {
                    parcel = parcel.readStrongBinder();
                }
                return new Token(parcel);
            }

            /* renamed from: a */
            public Token[] m1292a(int i) {
                return new Token[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        Token(Object obj) {
            this(obj, null);
        }

        Token(Object obj, C0437b c0437b) {
            this.f1121a = obj;
            this.f1122b = c0437b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f1121a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f1121a);
            }
        }

        public int hashCode() {
            if (this.f1121a == null) {
                return 0;
            }
            return this.f1121a.hashCode();
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.f1121a == null) {
                if (token.f1121a != null) {
                    z = false;
                }
                return z;
            } else if (token.f1121a == null) {
                return false;
            } else {
                return this.f1121a.equals(token.f1121a);
            }
        }
    }
}

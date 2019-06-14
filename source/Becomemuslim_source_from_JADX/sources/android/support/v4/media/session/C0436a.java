package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.text.TextUtils;
import java.util.List;

/* compiled from: IMediaControllerCallback */
/* renamed from: android.support.v4.media.session.a */
public interface C0436a extends IInterface {

    /* compiled from: IMediaControllerCallback */
    /* renamed from: android.support.v4.media.session.a$a */
    public static abstract class C3207a extends Binder implements C0436a {

        /* compiled from: IMediaControllerCallback */
        /* renamed from: android.support.v4.media.session.a$a$a */
        private static class C3206a implements C0436a {
            /* renamed from: a */
            private IBinder f8261a;

            C3206a(IBinder iBinder) {
                this.f8261a = iBinder;
            }

            public IBinder asBinder() {
                return this.f8261a;
            }

            /* renamed from: a */
            public void mo246a(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8261a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo239a() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.f8261a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo244a(PlaybackStateCompat playbackStateCompat) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (playbackStateCompat != null) {
                        obtain.writeInt(1);
                        playbackStateCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8261a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo242a(MediaMetadataCompat mediaMetadataCompat) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (mediaMetadataCompat != null) {
                        obtain.writeInt(1);
                        mediaMetadataCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8261a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo247a(List<QueueItem> list) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeTypedList(list);
                    this.f8261a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo245a(CharSequence charSequence) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (charSequence != null) {
                        obtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8261a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo241a(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8261a.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo243a(ParcelableVolumeInfo parcelableVolumeInfo) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcelableVolumeInfo != null) {
                        obtain.writeInt(1);
                        parcelableVolumeInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f8261a.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo240a(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(i);
                    this.f8261a.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo248a(boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(z);
                    this.f8261a.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo251b(boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(z);
                    this.f8261a.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo250b(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(i);
                    this.f8261a.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo249b() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.f8261a.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C3207a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        /* renamed from: a */
        public static C0436a m9706a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0436a)) {
                return new C3206a(iBinder);
            }
            return (C0436a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                boolean z = false;
                Bundle bundle = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        i = parcel.readString();
                        if (parcel.readInt() != null) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        mo246a(i, bundle);
                        return true;
                    case 2:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo239a();
                        return true;
                    case 3:
                        PlaybackStateCompat playbackStateCompat;
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            playbackStateCompat = (PlaybackStateCompat) PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                        }
                        mo244a(playbackStateCompat);
                        return true;
                    case 4:
                        MediaMetadataCompat mediaMetadataCompat;
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            mediaMetadataCompat = (MediaMetadataCompat) MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                        }
                        mo242a(mediaMetadataCompat);
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo247a((List) parcel.createTypedArrayList(QueueItem.CREATOR));
                        return true;
                    case 6:
                        CharSequence charSequence;
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                        }
                        mo245a(charSequence);
                        return true;
                    case 7:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        mo241a(bundle);
                        return true;
                    case 8:
                        ParcelableVolumeInfo parcelableVolumeInfo;
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            parcelableVolumeInfo = (ParcelableVolumeInfo) ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                        }
                        mo243a(parcelableVolumeInfo);
                        return true;
                    case 9:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo240a(parcel.readInt());
                        return true;
                    case 10:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        mo248a(z);
                        return true;
                    case 11:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        mo251b(z);
                        return true;
                    case 12:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo250b(parcel.readInt());
                        return true;
                    case 13:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo249b();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
    }

    /* renamed from: a */
    void mo239a();

    /* renamed from: a */
    void mo240a(int i);

    /* renamed from: a */
    void mo241a(Bundle bundle);

    /* renamed from: a */
    void mo242a(MediaMetadataCompat mediaMetadataCompat);

    /* renamed from: a */
    void mo243a(ParcelableVolumeInfo parcelableVolumeInfo);

    /* renamed from: a */
    void mo244a(PlaybackStateCompat playbackStateCompat);

    /* renamed from: a */
    void mo245a(CharSequence charSequence);

    /* renamed from: a */
    void mo246a(String str, Bundle bundle);

    /* renamed from: a */
    void mo247a(List<QueueItem> list);

    /* renamed from: a */
    void mo248a(boolean z);

    /* renamed from: b */
    void mo249b();

    /* renamed from: b */
    void mo250b(int i);

    /* renamed from: b */
    void mo251b(boolean z);
}

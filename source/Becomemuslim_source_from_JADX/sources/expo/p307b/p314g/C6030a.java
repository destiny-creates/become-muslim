package expo.p307b.p314g;

import android.graphics.Bitmap;

/* compiled from: ImageLoader */
/* renamed from: expo.b.g.a */
public interface C6030a {

    /* compiled from: ImageLoader */
    /* renamed from: expo.b.g.a$a */
    public interface C6029a {
        void onFailure(Throwable th);

        void onSuccess(Bitmap bitmap);
    }

    void loadImageFromURL(String str, C6029a c6029a);
}

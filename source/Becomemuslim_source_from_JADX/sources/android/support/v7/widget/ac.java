package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.bd.C0772a;

/* compiled from: CardViewApi17Impl */
class ac extends ae {

    /* compiled from: CardViewApi17Impl */
    /* renamed from: android.support.v7.widget.ac$1 */
    class C33031 implements C0772a {
        /* renamed from: a */
        final /* synthetic */ ac f8714a;

        C33031(ac acVar) {
            this.f8714a = acVar;
        }

        /* renamed from: a */
        public void mo605a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    ac() {
    }

    /* renamed from: a */
    public void mo607a() {
        bd.f2068a = new C33031(this);
    }
}

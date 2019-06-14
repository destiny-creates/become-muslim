package host.exp.exponent.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

public class ExponentImageButton extends ImageButton {

    /* renamed from: host.exp.exponent.views.ExponentImageButton$1 */
    class C64111 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ ExponentImageButton f20737a;

        C64111(ExponentImageButton exponentImageButton) {
            this.f20737a = exponentImageButton;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                this.f20737a.setColorFilter(0);
            } else if (motionEvent.getAction() == null) {
                this.f20737a.setColorFilter(-7829368);
            }
            return false;
        }
    }

    public ExponentImageButton(Context context) {
        super(context);
        m26308a();
    }

    public ExponentImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26308a();
    }

    public ExponentImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26308a();
    }

    /* renamed from: a */
    private void m26308a() {
        setOnTouchListener(new C64111(this));
    }
}

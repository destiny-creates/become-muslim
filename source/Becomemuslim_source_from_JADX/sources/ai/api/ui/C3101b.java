package ai.api.ui;

import ai.api.C0043i.C0040a;
import ai.api.C0043i.C0042c;
import ai.api.ui.C0057c.C0056a;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: SoundLevelButton */
/* renamed from: ai.api.ui.b */
public class C3101b extends C0054a {
    /* renamed from: a */
    private static final String f7914a = "ai.api.ui.b";
    /* renamed from: d */
    protected static final int[] f7915d = new int[]{C0040a.state_listening};
    /* renamed from: b */
    private final C0057c f7916b;
    /* renamed from: e */
    protected boolean f7917e = false;

    /* compiled from: SoundLevelButton */
    /* renamed from: ai.api.ui.b$1 */
    class C00551 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3101b f149a;

        C00551(C3101b c3101b) {
            this.f149a = c3101b;
        }

        public void onClick(View view) {
            this.f149a.mo2610a(view);
        }
    }

    /* renamed from: a */
    protected void mo2610a(View view) {
    }

    public C3101b(Context context) {
        super(context);
        this.f7916b = new C0057c(m9093a(context, null));
        setCircleBackground(this.f7916b);
        m9094a();
    }

    public C3101b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7916b = new C0057c(m9093a(context, attributeSet));
        setCircleBackground(this.f7916b);
        m9094a();
    }

    public C3101b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7916b = new C0057c(m9093a(context, attributeSet));
        setCircleBackground(this.f7916b);
        m9094a();
    }

    /* renamed from: a */
    private void m9094a() {
        setOnClickListener(new C00551(this));
    }

    /* renamed from: a */
    private C0056a m9093a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        context = context.obtainStyledAttributes(attributeSet, C0042c.SoundLevelButton);
        try {
            this.f7917e = context.getBoolean(C0042c.SoundLevelButton_state_listening, false);
            AttributeSet c0056a = new C0056a(context.getDimension(C0042c.SoundLevelButton_maxRadius, -1.0f), context.getDimension(C0042c.SoundLevelButton_minRadius, -1.0f), context.getDimension(C0042c.SoundLevelButton_circleCenterX, -1.0f), context.getDimension(C0042c.SoundLevelButton_circleCenterY, -1.0f), context.getColor(C0042c.SoundLevelButton_centerColor, -889815), context.getColor(C0042c.SoundLevelButton_haloColor, C0057c.f156a));
            return c0056a;
        } finally {
            context.recycle();
        }
    }

    public int[] onCreateDrawableState(int i) {
        i = super.onCreateDrawableState(i + 1);
        if (this.f7917e) {
            C3101b.mergeDrawableStates(i, f7915d);
        }
        return i;
    }

    @TargetApi(16)
    private void setCircleBackground(C0057c c0057c) {
        if (VERSION.SDK_INT < 16) {
            setBackgroundDrawable(c0057c);
        } else {
            setBackground(c0057c);
        }
    }

    public void setDrawSoundLevel(boolean z) {
        this.f7917e = z;
        this.f7916b.m132a(z);
        refreshDrawableState();
        postInvalidate();
    }

    protected void setDrawCenter(boolean z) {
        this.f7916b.m133b(z);
    }

    public void setSoundLevel(float f) {
        this.f7916b.m131a(f);
        postInvalidate();
    }

    protected String getDebugState() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getDebugState());
        stringBuilder.append("\ndrawSL: ");
        stringBuilder.append(this.f7917e);
        return stringBuilder.toString();
    }

    protected float getMinRadius() {
        return this.f7916b.m130a();
    }
}

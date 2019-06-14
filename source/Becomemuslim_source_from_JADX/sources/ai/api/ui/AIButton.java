package ai.api.ui;

import ai.api.C0020c;
import ai.api.C0039h;
import ai.api.C0043i.C0040a;
import ai.api.C0043i.C0041b;
import ai.api.C0043i.C0042c;
import ai.api.p005a.C0006c;
import ai.api.p007c.C0012a;
import ai.api.p007c.C0013c;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class AIButton extends C3101b implements C0020c {
    /* renamed from: a */
    protected static final int[] f11800a = new int[]{C0040a.state_waiting};
    /* renamed from: b */
    protected static final int[] f11801b = new int[]{C0040a.state_speaking};
    /* renamed from: c */
    protected static final int[] f11802c = new int[]{C0040a.state_initializing_tts};
    /* renamed from: f */
    private static final String f11803f = "ai.api.ui.AIButton";
    /* renamed from: g */
    private float f11804g = 0.0f;
    /* renamed from: h */
    private boolean f11805h = false;
    /* renamed from: i */
    private final C0053c f11806i = new C0053c(this);
    /* renamed from: j */
    private C0006c f11807j;
    /* renamed from: k */
    private C0051a f11808k;
    /* renamed from: l */
    private C0039h f11809l;
    /* renamed from: m */
    private volatile C0052b f11810m = C0052b.normal;

    /* renamed from: ai.api.ui.AIButton$1 */
    class C00451 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ AIButton f135a;

        C00451(AIButton aIButton) {
            this.f135a = aIButton;
        }

        public void run() {
            this.f135a.m14731a(C0052b.normal);
        }
    }

    /* renamed from: ai.api.ui.AIButton$2 */
    class C00462 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ AIButton f136a;

        C00462(AIButton aIButton) {
            this.f136a = aIButton;
        }

        public void run() {
            this.f136a.m14731a(C0052b.normal);
        }
    }

    /* renamed from: ai.api.ui.AIButton$3 */
    class C00473 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ AIButton f137a;

        C00473(AIButton aIButton) {
            this.f137a = aIButton;
        }

        public void run() {
            this.f137a.m14731a(C0052b.listening);
        }
    }

    /* renamed from: ai.api.ui.AIButton$4 */
    class C00484 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ AIButton f138a;

        C00484(AIButton aIButton) {
            this.f138a = aIButton;
        }

        public void run() {
            this.f138a.m14731a(C0052b.normal);
        }
    }

    /* renamed from: ai.api.ui.AIButton$5 */
    class C00495 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ AIButton f139a;

        C00495(AIButton aIButton) {
            this.f139a = aIButton;
        }

        public void run() {
            this.f139a.m14731a(C0052b.busy);
        }
    }

    /* renamed from: ai.api.ui.AIButton$a */
    public interface C0051a {
        /* renamed from: a */
        void m121a();

        /* renamed from: a */
        void m122a(C0012a c0012a);

        /* renamed from: a */
        void m123a(C0013c c0013c);
    }

    /* renamed from: ai.api.ui.AIButton$b */
    public enum C0052b {
        normal,
        busy,
        listening,
        speaking,
        initializingTts;

        /* renamed from: a */
        public static C0052b m124a(TypedArray typedArray) {
            if (typedArray.getBoolean(C0042c.SoundLevelButton_state_listening, false)) {
                return listening;
            }
            if (typedArray.getBoolean(C0042c.SoundLevelButton_state_waiting, false)) {
                return busy;
            }
            if (typedArray.getBoolean(C0042c.SoundLevelButton_state_speaking, false)) {
                return speaking;
            }
            if (typedArray.getBoolean(C0042c.SoundLevelButton_state_initializing_tts, false) != null) {
                return initializingTts;
            }
            return normal;
        }
    }

    /* renamed from: ai.api.ui.AIButton$c */
    private class C0053c extends Animation {
        /* renamed from: a */
        final /* synthetic */ AIButton f147a;

        protected C0053c(AIButton aIButton) {
            this.f147a = aIButton;
            setDuration(1500);
            setRepeatCount(-1);
            setRepeatMode(1);
            setInterpolator(new LinearInterpolator());
        }

        protected void applyTransformation(float f, Transformation transformation) {
            this.f147a.f11804g = f;
            this.f147a.invalidate();
        }
    }

    public void onResult(C0013c c0013c) {
        post(new C00451(this));
        if (this.f11808k != null) {
            this.f11808k.m123a(c0013c);
        }
    }

    public void onError(C0012a c0012a) {
        post(new C00462(this));
        if (this.f11808k != null) {
            this.f11808k.m122a(c0012a);
        }
    }

    public void onAudioLevel(float f) {
        setSoundLevel(f);
    }

    public void onListeningStarted() {
        post(new C00473(this));
    }

    public void onListeningCanceled() {
        post(new C00484(this));
        if (this.f11808k != null) {
            this.f11808k.m121a();
        }
    }

    public void onListeningFinished() {
        post(new C00495(this));
    }

    public AIButton(Context context) {
        super(context);
        m14729a(context, null);
    }

    public AIButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14729a(context, attributeSet);
    }

    public AIButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14729a(context, attributeSet);
    }

    /* renamed from: a */
    private void m14729a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            context = context.obtainStyledAttributes(attributeSet, C0042c.SoundLevelButton);
            try {
                this.f11810m = C0052b.m124a(context);
            } finally {
                context.recycle();
            }
        }
    }

    public void setResultsListener(C0051a c0051a) {
        this.f11808k = c0051a;
    }

    public void setPartialResultsListener(C0039h c0039h) {
        this.f11809l = c0039h;
    }

    public C0006c getAIService() {
        return this.f11807j;
    }

    /* renamed from: a */
    protected void mo2610a(View view) {
        super.mo2610a(view);
        if (this.f11807j != null) {
            switch (this.f11810m) {
                case normal:
                    this.f11807j.mo5a();
                    return;
                case busy:
                    this.f11807j.mo8c();
                    return;
                default:
                    this.f11807j.mo7b();
                    return;
            }
        }
    }

    public int[] onCreateDrawableState(int i) {
        i = super.onCreateDrawableState(i + 1);
        if (this.f11810m != null) {
            switch (this.f11810m) {
                case normal:
                    break;
                case busy:
                    mergeDrawableStates(i, f11800a);
                    break;
                case listening:
                    mergeDrawableStates(i, d);
                    break;
                case speaking:
                    mergeDrawableStates(i, f11801b);
                    break;
                case initializingTts:
                    mergeDrawableStates(i, f11802c);
                    break;
                default:
                    break;
            }
        }
        return i;
    }

    /* renamed from: a */
    protected void m14731a(C0052b c0052b) {
        switch (c0052b) {
            case normal:
                m14730b();
                setDrawSoundLevel(false);
                break;
            case busy:
                m14728a();
                setDrawSoundLevel(false);
                break;
            case listening:
                m14730b();
                setDrawSoundLevel(true);
                break;
            case speaking:
                m14730b();
                setDrawSoundLevel(false);
                break;
            case initializingTts:
                m14730b();
                setDrawSoundLevel(false);
                break;
            default:
                break;
        }
        this.f11810m = c0052b;
        refreshDrawableState();
    }

    protected C0052b getCurrentState() {
        return this.f11810m;
    }

    /* renamed from: a */
    private void m14728a() {
        setDrawCenter(true);
        this.f11805h = false;
        startAnimation(this.f11806i);
    }

    /* renamed from: b */
    private void m14730b() {
        setDrawCenter(false);
        clearAnimation();
        this.f11804g = 0.0f;
        this.f11805h = false;
        postInvalidate();
    }

    protected String getDebugState() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getDebugState());
        stringBuilder.append("\nst:");
        stringBuilder.append(this.f11810m);
        return stringBuilder.toString();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = 0.0f;
        if (this.f11804g > 0.0f || this.f11805h) {
            float f2;
            float width = ((float) getWidth()) / 2.0f;
            float minRadius = getMinRadius() * 1.25f;
            float f3 = width - minRadius;
            width += minRadius;
            RectF rectF = new RectF(f3, f3, width, width);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(C0041b.icon_orange_color));
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth((float) m14727a(getContext(), 4.0f));
            paint.setStrokeCap(Cap.ROUND);
            paint.setAntiAlias(true);
            if (((double) this.f11804g) >= 0.5d || this.f11805h) {
                f = (this.f11804g - 0.5f) * 360.0f;
                this.f11805h = true;
                f2 = 180.0f;
            } else {
                f2 = this.f11804g * 360.0f;
            }
            canvas.drawArc(rectF, f + 270.0f, f2, false, paint);
        }
    }

    /* renamed from: a */
    private static int m14727a(Context context, float f) {
        return Math.round(TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()));
    }
}

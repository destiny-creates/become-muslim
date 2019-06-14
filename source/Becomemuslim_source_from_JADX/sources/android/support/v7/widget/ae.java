package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.bd.C0772a;

/* compiled from: CardViewBaseImpl */
class ae implements ag {
    /* renamed from: a */
    private final RectF f8716a = new RectF();

    /* compiled from: CardViewBaseImpl */
    /* renamed from: android.support.v7.widget.ae$1 */
    class C33041 implements C0772a {
        /* renamed from: a */
        final /* synthetic */ ae f8715a;

        C33041(ae aeVar) {
            this.f8715a = aeVar;
        }

        /* renamed from: a */
        public void mo605a(Canvas canvas, RectF rectF, float f, Paint paint) {
            C33041 c33041 = this;
            Canvas canvas2 = canvas;
            RectF rectF2 = rectF;
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                float f4 = -f3;
                c33041.f8715a.f8716a.set(f4, f4, f3, f3);
                int save = canvas.save();
                canvas2.translate(rectF2.left + f3, rectF2.top + f3);
                canvas.drawArc(c33041.f8715a.f8716a, 180.0f, 90.0f, true, paint);
                canvas2.translate(width, 0.0f);
                canvas2.rotate(90.0f);
                Paint paint2 = paint;
                canvas.drawArc(c33041.f8715a.f8716a, 180.0f, 90.0f, true, paint2);
                canvas2.translate(height, 0.0f);
                canvas2.rotate(90.0f);
                canvas.drawArc(c33041.f8715a.f8716a, 180.0f, 90.0f, true, paint2);
                canvas2.translate(width, 0.0f);
                canvas2.rotate(90.0f);
                canvas.drawArc(c33041.f8715a.f8716a, 180.0f, 90.0f, true, paint2);
                canvas2.restoreToCount(save);
                canvas.drawRect((rectF2.left + f3) - 1.0f, rectF2.top, (rectF2.right - f3) + 1.0f, rectF2.top + f3, paint);
                canvas.drawRect((rectF2.left + f3) - 1.0f, rectF2.bottom - f3, (rectF2.right - f3) + 1.0f, rectF2.bottom, paint);
            }
            canvas.drawRect(rectF2.left, rectF2.top + f, rectF2.right, rectF2.bottom - f, paint);
        }
    }

    /* renamed from: g */
    public void mo617g(af afVar) {
    }

    ae() {
    }

    /* renamed from: a */
    public void mo607a() {
        bd.f2068a = new C33041(this);
    }

    /* renamed from: a */
    public void mo609a(af afVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        context = m10389a(context, colorStateList, f, f2, f3);
        context.m2728a(afVar.mo519b());
        afVar.mo517a(context);
        m10402f(afVar);
    }

    /* renamed from: a */
    private bd m10389a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new bd(context.getResources(), colorStateList, f, f2, f3);
    }

    /* renamed from: f */
    public void m10402f(af afVar) {
        Rect rect = new Rect();
        m10390j(afVar).m2727a(rect);
        afVar.mo515a((int) Math.ceil((double) mo611b(afVar)), (int) Math.ceil((double) mo613c(afVar)));
        afVar.mo516a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: h */
    public void mo618h(af afVar) {
        m10390j(afVar).m2728a(afVar.mo519b());
        m10402f(afVar);
    }

    /* renamed from: a */
    public void mo610a(af afVar, ColorStateList colorStateList) {
        m10390j(afVar).m2726a(colorStateList);
    }

    /* renamed from: i */
    public ColorStateList mo619i(af afVar) {
        return m10390j(afVar).m2735f();
    }

    /* renamed from: a */
    public void mo608a(af afVar, float f) {
        m10390j(afVar).m2725a(f);
        m10402f(afVar);
    }

    /* renamed from: d */
    public float mo615d(af afVar) {
        return m10390j(afVar).m2724a();
    }

    /* renamed from: c */
    public void mo614c(af afVar, float f) {
        m10390j(afVar).m2730b(f);
    }

    /* renamed from: e */
    public float mo616e(af afVar) {
        return m10390j(afVar).m2729b();
    }

    /* renamed from: b */
    public void mo612b(af afVar, float f) {
        m10390j(afVar).m2732c(f);
        m10402f(afVar);
    }

    /* renamed from: a */
    public float mo606a(af afVar) {
        return m10390j(afVar).m2731c();
    }

    /* renamed from: b */
    public float mo611b(af afVar) {
        return m10390j(afVar).m2733d();
    }

    /* renamed from: c */
    public float mo613c(af afVar) {
        return m10390j(afVar).m2734e();
    }

    /* renamed from: j */
    private bd m10390j(af afVar) {
        return (bd) afVar.mo520c();
    }
}

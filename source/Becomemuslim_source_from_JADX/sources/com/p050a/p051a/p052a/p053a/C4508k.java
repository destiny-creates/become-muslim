package com.p050a.p051a.p052a.p053a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import com.p050a.p051a.p056c.p058b.C3374h;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* compiled from: MergePathsContent */
/* renamed from: com.a.a.a.a.k */
public class C4508k implements C0881i, C3360l {
    /* renamed from: a */
    private final Path f12162a = new Path();
    /* renamed from: b */
    private final Path f12163b = new Path();
    /* renamed from: c */
    private final Path f12164c = new Path();
    /* renamed from: d */
    private final String f12165d;
    /* renamed from: e */
    private final List<C3360l> f12166e = new ArrayList();
    /* renamed from: f */
    private final C3374h f12167f;

    public C4508k(C3374h c3374h) {
        if (VERSION.SDK_INT >= 19) {
            this.f12165d = c3374h.m10722a();
            this.f12167f = c3374h;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    /* renamed from: a */
    public void mo2794a(ListIterator<C0880b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            C0880b c0880b = (C0880b) listIterator.previous();
            if (c0880b instanceof C3360l) {
                this.f12166e.add((C3360l) c0880b);
                listIterator.remove();
            }
        }
    }

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
        for (int i = 0; i < this.f12166e.size(); i++) {
            ((C3360l) this.f12166e.get(i)).mo729a(list, list2);
        }
    }

    /* renamed from: e */
    public Path mo2793e() {
        this.f12164c.reset();
        switch (this.f12167f.m10723b()) {
            case Merge:
                m15301a();
                break;
            case Add:
                m15302a(Op.UNION);
                break;
            case Subtract:
                m15302a(Op.REVERSE_DIFFERENCE);
                break;
            case Intersect:
                m15302a(Op.INTERSECT);
                break;
            case ExcludeIntersections:
                m15302a(Op.XOR);
                break;
            default:
                break;
        }
        return this.f12164c;
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f12165d;
    }

    /* renamed from: a */
    private void m15301a() {
        for (int i = 0; i < this.f12166e.size(); i++) {
            this.f12164c.addPath(((C3360l) this.f12166e.get(i)).mo2793e());
        }
    }

    @TargetApi(19)
    /* renamed from: a */
    private void m15302a(Op op) {
        this.f12163b.reset();
        this.f12162a.reset();
        for (int size = this.f12166e.size() - 1; size >= 1; size--) {
            C3360l c3360l = (C3360l) this.f12166e.get(size);
            if (c3360l instanceof C4504c) {
                C4504c c4504c = (C4504c) c3360l;
                List c = c4504c.m15274c();
                for (int size2 = c.size() - 1; size2 >= 0; size2--) {
                    Path e = ((C3360l) c.get(size2)).mo2793e();
                    e.transform(c4504c.m15275d());
                    this.f12163b.addPath(e);
                }
            } else {
                this.f12163b.addPath(c3360l.mo2793e());
            }
        }
        int i = 0;
        C3360l c3360l2 = (C3360l) this.f12166e.get(0);
        if (c3360l2 instanceof C4504c) {
            C4504c c4504c2 = (C4504c) c3360l2;
            List c2 = c4504c2.m15274c();
            while (i < c2.size()) {
                Path e2 = ((C3360l) c2.get(i)).mo2793e();
                e2.transform(c4504c2.m15275d());
                this.f12162a.addPath(e2);
                i++;
            }
        } else {
            this.f12162a.set(c3360l2.mo2793e());
        }
        this.f12164c.op(this.f12162a, this.f12163b, op);
    }
}

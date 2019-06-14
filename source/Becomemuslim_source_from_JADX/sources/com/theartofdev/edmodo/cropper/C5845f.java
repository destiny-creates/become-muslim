package com.theartofdev.edmodo.cropper;

import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.facebook.imageutils.JfifUtil;
import com.theartofdev.edmodo.cropper.CropImageView.C5820b;
import com.theartofdev.edmodo.cropper.CropImageView.C5821c;
import com.theartofdev.edmodo.cropper.CropImageView.C5827i;
import com.theartofdev.edmodo.cropper.CropImageView.C5828j;

/* compiled from: CropImageOptions */
/* renamed from: com.theartofdev.edmodo.cropper.f */
public class C5845f implements Parcelable {
    public static final Creator<C5845f> CREATOR = new C58441();
    /* renamed from: A */
    public int f19412A;
    /* renamed from: B */
    public int f19413B;
    /* renamed from: C */
    public int f19414C;
    /* renamed from: D */
    public CharSequence f19415D;
    /* renamed from: E */
    public int f19416E;
    /* renamed from: F */
    public Uri f19417F;
    /* renamed from: G */
    public CompressFormat f19418G;
    /* renamed from: H */
    public int f19419H;
    /* renamed from: I */
    public int f19420I;
    /* renamed from: J */
    public int f19421J;
    /* renamed from: K */
    public C5827i f19422K;
    /* renamed from: L */
    public boolean f19423L;
    /* renamed from: M */
    public Rect f19424M;
    /* renamed from: N */
    public int f19425N;
    /* renamed from: O */
    public boolean f19426O;
    /* renamed from: P */
    public boolean f19427P;
    /* renamed from: Q */
    public boolean f19428Q;
    /* renamed from: R */
    public int f19429R;
    /* renamed from: S */
    public boolean f19430S;
    /* renamed from: T */
    public boolean f19431T;
    /* renamed from: U */
    public CharSequence f19432U;
    /* renamed from: V */
    public int f19433V;
    /* renamed from: a */
    public C5820b f19434a;
    /* renamed from: b */
    public float f19435b;
    /* renamed from: c */
    public float f19436c;
    /* renamed from: d */
    public C5821c f19437d;
    /* renamed from: e */
    public C5828j f19438e;
    /* renamed from: f */
    public boolean f19439f;
    /* renamed from: g */
    public boolean f19440g;
    /* renamed from: h */
    public boolean f19441h;
    /* renamed from: i */
    public boolean f19442i;
    /* renamed from: j */
    public int f19443j;
    /* renamed from: k */
    public float f19444k;
    /* renamed from: l */
    public boolean f19445l;
    /* renamed from: m */
    public int f19446m;
    /* renamed from: n */
    public int f19447n;
    /* renamed from: o */
    public float f19448o;
    /* renamed from: p */
    public int f19449p;
    /* renamed from: q */
    public float f19450q;
    /* renamed from: r */
    public float f19451r;
    /* renamed from: s */
    public float f19452s;
    /* renamed from: t */
    public int f19453t;
    /* renamed from: u */
    public float f19454u;
    /* renamed from: v */
    public int f19455v;
    /* renamed from: w */
    public int f19456w;
    /* renamed from: x */
    public int f19457x;
    /* renamed from: y */
    public int f19458y;
    /* renamed from: z */
    public int f19459z;

    /* compiled from: CropImageOptions */
    /* renamed from: com.theartofdev.edmodo.cropper.f$1 */
    static class C58441 implements Creator<C5845f> {
        C58441() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m24650a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m24651a(i);
        }

        /* renamed from: a */
        public C5845f m24650a(Parcel parcel) {
            return new C5845f(parcel);
        }

        /* renamed from: a */
        public C5845f[] m24651a(int i) {
            return new C5845f[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public C5845f() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.f19434a = C5820b.RECTANGLE;
        this.f19435b = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.f19436c = TypedValue.applyDimension(1, 24.0f, displayMetrics);
        this.f19437d = C5821c.ON_TOUCH;
        this.f19438e = C5828j.FIT_CENTER;
        this.f19439f = true;
        this.f19440g = true;
        this.f19441h = true;
        this.f19442i = false;
        this.f19443j = 4;
        this.f19444k = 0.1f;
        this.f19445l = false;
        this.f19446m = 1;
        this.f19447n = 1;
        this.f19448o = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.f19449p = Color.argb(170, JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE);
        this.f19450q = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.f19451r = TypedValue.applyDimension(1, 5.0f, displayMetrics);
        this.f19452s = TypedValue.applyDimension(1, 14.0f, displayMetrics);
        this.f19453t = -1;
        this.f19454u = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.f19455v = Color.argb(170, JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE, JfifUtil.MARKER_FIRST_BYTE);
        this.f19456w = Color.argb(119, 0, 0, 0);
        this.f19457x = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.f19458y = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.f19459z = 40;
        this.f19412A = 40;
        this.f19413B = 99999;
        this.f19414C = 99999;
        this.f19415D = "";
        this.f19416E = 0;
        this.f19417F = Uri.EMPTY;
        this.f19418G = CompressFormat.JPEG;
        this.f19419H = 90;
        this.f19420I = 0;
        this.f19421J = 0;
        this.f19422K = C5827i.NONE;
        this.f19423L = false;
        this.f19424M = null;
        this.f19425N = -1;
        this.f19426O = true;
        this.f19427P = true;
        this.f19428Q = false;
        this.f19429R = 90;
        this.f19430S = false;
        this.f19431T = false;
        this.f19432U = null;
        this.f19433V = 0;
    }

    protected C5845f(Parcel parcel) {
        this.f19434a = C5820b.values()[parcel.readInt()];
        this.f19435b = parcel.readFloat();
        this.f19436c = parcel.readFloat();
        this.f19437d = C5821c.values()[parcel.readInt()];
        this.f19438e = C5828j.values()[parcel.readInt()];
        boolean z = false;
        this.f19439f = parcel.readByte() != (byte) 0;
        this.f19440g = parcel.readByte() != (byte) 0;
        this.f19441h = parcel.readByte() != (byte) 0;
        this.f19442i = parcel.readByte() != (byte) 0;
        this.f19443j = parcel.readInt();
        this.f19444k = parcel.readFloat();
        this.f19445l = parcel.readByte() != (byte) 0;
        this.f19446m = parcel.readInt();
        this.f19447n = parcel.readInt();
        this.f19448o = parcel.readFloat();
        this.f19449p = parcel.readInt();
        this.f19450q = parcel.readFloat();
        this.f19451r = parcel.readFloat();
        this.f19452s = parcel.readFloat();
        this.f19453t = parcel.readInt();
        this.f19454u = parcel.readFloat();
        this.f19455v = parcel.readInt();
        this.f19456w = parcel.readInt();
        this.f19457x = parcel.readInt();
        this.f19458y = parcel.readInt();
        this.f19459z = parcel.readInt();
        this.f19412A = parcel.readInt();
        this.f19413B = parcel.readInt();
        this.f19414C = parcel.readInt();
        this.f19415D = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f19416E = parcel.readInt();
        this.f19417F = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f19418G = CompressFormat.valueOf(parcel.readString());
        this.f19419H = parcel.readInt();
        this.f19420I = parcel.readInt();
        this.f19421J = parcel.readInt();
        this.f19422K = C5827i.values()[parcel.readInt()];
        this.f19423L = parcel.readByte() != (byte) 0;
        this.f19424M = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.f19425N = parcel.readInt();
        this.f19426O = parcel.readByte() != (byte) 0;
        this.f19427P = parcel.readByte() != (byte) 0;
        this.f19428Q = parcel.readByte() != (byte) 0;
        this.f19429R = parcel.readInt();
        this.f19430S = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.f19431T = z;
        this.f19432U = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f19433V = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19434a.ordinal());
        parcel.writeFloat(this.f19435b);
        parcel.writeFloat(this.f19436c);
        parcel.writeInt(this.f19437d.ordinal());
        parcel.writeInt(this.f19438e.ordinal());
        parcel.writeByte((byte) this.f19439f);
        parcel.writeByte((byte) this.f19440g);
        parcel.writeByte((byte) this.f19441h);
        parcel.writeByte((byte) this.f19442i);
        parcel.writeInt(this.f19443j);
        parcel.writeFloat(this.f19444k);
        parcel.writeByte((byte) this.f19445l);
        parcel.writeInt(this.f19446m);
        parcel.writeInt(this.f19447n);
        parcel.writeFloat(this.f19448o);
        parcel.writeInt(this.f19449p);
        parcel.writeFloat(this.f19450q);
        parcel.writeFloat(this.f19451r);
        parcel.writeFloat(this.f19452s);
        parcel.writeInt(this.f19453t);
        parcel.writeFloat(this.f19454u);
        parcel.writeInt(this.f19455v);
        parcel.writeInt(this.f19456w);
        parcel.writeInt(this.f19457x);
        parcel.writeInt(this.f19458y);
        parcel.writeInt(this.f19459z);
        parcel.writeInt(this.f19412A);
        parcel.writeInt(this.f19413B);
        parcel.writeInt(this.f19414C);
        TextUtils.writeToParcel(this.f19415D, parcel, i);
        parcel.writeInt(this.f19416E);
        parcel.writeParcelable(this.f19417F, i);
        parcel.writeString(this.f19418G.name());
        parcel.writeInt(this.f19419H);
        parcel.writeInt(this.f19420I);
        parcel.writeInt(this.f19421J);
        parcel.writeInt(this.f19422K.ordinal());
        parcel.writeInt(this.f19423L);
        parcel.writeParcelable(this.f19424M, i);
        parcel.writeInt(this.f19425N);
        parcel.writeByte((byte) this.f19426O);
        parcel.writeByte((byte) this.f19427P);
        parcel.writeByte((byte) this.f19428Q);
        parcel.writeInt(this.f19429R);
        parcel.writeByte((byte) this.f19430S);
        parcel.writeByte((byte) this.f19431T);
        TextUtils.writeToParcel(this.f19432U, parcel, i);
        parcel.writeInt(this.f19433V);
    }

    /* renamed from: a */
    public void m24652a() {
        if (this.f19443j < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1");
        } else if (this.f19436c < 0.0f) {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
        } else if (this.f19444k < 0.0f || ((double) this.f19444k) >= 0.5d) {
            throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
        } else if (this.f19446m <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f19447n <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f19448o < 0.0f) {
            throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
        } else if (this.f19450q < 0.0f) {
            throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
        } else if (this.f19454u < 0.0f) {
            throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
        } else if (this.f19458y < 0) {
            throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
        } else if (this.f19459z < 0) {
            throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
        } else if (this.f19412A < 0) {
            throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
        } else if (this.f19413B < this.f19459z) {
            throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
        } else if (this.f19414C < this.f19412A) {
            throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
        } else if (this.f19420I < 0) {
            throw new IllegalArgumentException("Cannot set request width value to a number < 0 ");
        } else if (this.f19421J < 0) {
            throw new IllegalArgumentException("Cannot set request height value to a number < 0 ");
        } else if (this.f19429R < 0 || this.f19429R > 360) {
            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
        }
    }
}

package com.theartofdev.edmodo.cropper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.C0366b;
import android.support.v7.app.C4908c;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.facebook.device.yearclass.YearClass;
import com.facebook.stetho.server.http.HttpStatus;
import com.theartofdev.edmodo.cropper.C5842d.C7196b;
import com.theartofdev.edmodo.cropper.C5855i.C5850a;
import com.theartofdev.edmodo.cropper.C5855i.C5851b;
import com.theartofdev.edmodo.cropper.C5855i.C5852c;
import com.theartofdev.edmodo.cropper.C5855i.C5853d;
import com.theartofdev.edmodo.cropper.CropImageView.C5819a;
import com.theartofdev.edmodo.cropper.CropImageView.C5822d;
import com.theartofdev.edmodo.cropper.CropImageView.C5826h;
import java.io.File;

public class CropImageActivity extends C4908c implements C5822d, C5826h {
    /* renamed from: a */
    private CropImageView f32938a;
    /* renamed from: b */
    private Uri f32939b;
    /* renamed from: c */
    private C5845f f32940c;

    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C5851b.crop_image_activity);
        this.f32938a = (CropImageView) findViewById(C5850a.cropImageView);
        Bundle bundleExtra = getIntent().getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        this.f32939b = (Uri) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_SOURCE");
        this.f32940c = (C5845f) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        if (bundle == null) {
            if (this.f32939b != null) {
                if (this.f32939b.equals(Uri.EMPTY) == null) {
                    if (C5842d.m24643a((Context) this, this.f32939b) != null) {
                        requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
                    } else {
                        this.f32938a.setImageUriAsync(this.f32939b);
                    }
                }
            }
            if (C5842d.m24645b(this) != null) {
                requestPermissions(new String[]{"android.permission.CAMERA"}, YearClass.CLASS_2011);
            } else {
                C5842d.m24642a((Activity) this);
            }
        }
        bundle = b();
        if (bundle != null) {
            CharSequence string;
            if (this.f32940c == null || this.f32940c.f19415D == null || this.f32940c.f19415D.length() <= 0) {
                string = getResources().getString(C5853d.crop_image_activity_title);
            } else {
                string = this.f32940c.f19415D;
            }
            bundle.a(string);
            bundle.b(true);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f32938a.setOnSetImageUriCompleteListener(this);
        this.f32938a.setOnCropImageCompleteListener(this);
    }

    protected void onStop() {
        super.onStop();
        this.f32938a.setOnSetImageUriCompleteListener(null);
        this.f32938a.setOnCropImageCompleteListener(null);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Throwable th;
        getMenuInflater().inflate(C5852c.crop_image_menu, menu);
        if (!this.f32940c.f19426O) {
            menu.removeItem(C5850a.crop_image_menu_rotate_left);
            menu.removeItem(C5850a.crop_image_menu_rotate_right);
        } else if (this.f32940c.f19428Q) {
            menu.findItem(C5850a.crop_image_menu_rotate_left).setVisible(true);
        }
        if (!this.f32940c.f19427P) {
            menu.removeItem(C5850a.crop_image_menu_flip);
        }
        if (this.f32940c.f19432U != null) {
            menu.findItem(C5850a.crop_image_menu_crop).setTitle(this.f32940c.f19432U);
        }
        Drawable drawable = null;
        try {
            if (this.f32940c.f19433V != 0) {
                Drawable a = C0366b.a(this, this.f32940c.f19433V);
                try {
                    menu.findItem(C5850a.crop_image_menu_crop).setIcon(a);
                    drawable = a;
                } catch (Throwable e) {
                    Drawable drawable2 = a;
                    th = e;
                    drawable = drawable2;
                    Log.w("AIC", "Failed to read menu crop drawable", th);
                    if (this.f32940c.f19416E != 0) {
                        m44505a(menu, C5850a.crop_image_menu_rotate_left, this.f32940c.f19416E);
                        m44505a(menu, C5850a.crop_image_menu_rotate_right, this.f32940c.f19416E);
                        m44505a(menu, C5850a.crop_image_menu_flip, this.f32940c.f19416E);
                        if (drawable != null) {
                            m44505a(menu, C5850a.crop_image_menu_crop, this.f32940c.f19416E);
                        }
                    }
                    return true;
                }
            }
        } catch (Exception e2) {
            th = e2;
            Log.w("AIC", "Failed to read menu crop drawable", th);
            if (this.f32940c.f19416E != 0) {
                m44505a(menu, C5850a.crop_image_menu_rotate_left, this.f32940c.f19416E);
                m44505a(menu, C5850a.crop_image_menu_rotate_right, this.f32940c.f19416E);
                m44505a(menu, C5850a.crop_image_menu_flip, this.f32940c.f19416E);
                if (drawable != null) {
                    m44505a(menu, C5850a.crop_image_menu_crop, this.f32940c.f19416E);
                }
            }
            return true;
        }
        if (this.f32940c.f19416E != 0) {
            m44505a(menu, C5850a.crop_image_menu_rotate_left, this.f32940c.f19416E);
            m44505a(menu, C5850a.crop_image_menu_rotate_right, this.f32940c.f19416E);
            m44505a(menu, C5850a.crop_image_menu_flip, this.f32940c.f19416E);
            if (drawable != null) {
                m44505a(menu, C5850a.crop_image_menu_crop, this.f32940c.f19416E);
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == C5850a.crop_image_menu_crop) {
            m44511f();
            return true;
        } else if (menuItem.getItemId() == C5850a.crop_image_menu_rotate_left) {
            m44506a(-this.f32940c.f19429R);
            return true;
        } else if (menuItem.getItemId() == C5850a.crop_image_menu_rotate_right) {
            m44506a(this.f32940c.f19429R);
            return true;
        } else if (menuItem.getItemId() == C5850a.crop_image_menu_flip_horizontally) {
            this.f32938a.m24559a();
            return true;
        } else if (menuItem.getItemId() == C5850a.crop_image_menu_flip_vertically) {
            this.f32938a.m24565b();
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            m44513h();
            return true;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        m44513h();
    }

    @SuppressLint({"NewApi"})
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == HttpStatus.HTTP_OK) {
            if (i2 == 0) {
                m44513h();
            }
            if (i2 == -1) {
                this.f32939b = C5842d.m24637a((Context) this, intent);
                if (C5842d.m24643a((Context) this, this.f32939b) != 0) {
                    requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
                } else {
                    this.f32938a.setImageUriAsync(this.f32939b);
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 201) {
            if (this.f32939b == null || iArr.length <= null || iArr[null] != null) {
                Toast.makeText(this, C5853d.crop_image_activity_no_permissions, 1).show();
                m44513h();
            } else {
                this.f32938a.setImageUriAsync(this.f32939b);
            }
        }
        if (i == 2011) {
            C5842d.m24642a((Activity) this);
        }
    }

    /* renamed from: a */
    public void mo6879a(CropImageView cropImageView, Uri uri, Exception exception) {
        if (exception == null) {
            if (this.f32940c.f19424M != null) {
                this.f32938a.setCropRect(this.f32940c.f19424M);
            }
            if (this.f32940c.f19425N > -1) {
                this.f32938a.setRotatedDegrees(this.f32940c.f19425N);
                return;
            }
            return;
        }
        m44507a((Uri) null, exception, 1);
    }

    /* renamed from: a */
    public void mo6880a(CropImageView cropImageView, C5819a c5819a) {
        m44507a(c5819a.m24534b(), c5819a.m24535c(), c5819a.m24540h());
    }

    /* renamed from: f */
    protected void m44511f() {
        if (this.f32940c.f19423L) {
            m44507a(null, null, 1);
            return;
        }
        this.f32938a.m24562a(m44512g(), this.f32940c.f19418G, this.f32940c.f19419H, this.f32940c.f19420I, this.f32940c.f19421J, this.f32940c.f19422K);
    }

    /* renamed from: a */
    protected void m44506a(int i) {
        this.f32938a.m24560a(i);
    }

    /* renamed from: g */
    protected Uri m44512g() {
        Uri uri = this.f32940c.f19417F;
        if (uri != null && !uri.equals(Uri.EMPTY)) {
            return uri;
        }
        try {
            String str = this.f32940c.f19418G == CompressFormat.JPEG ? ".jpg" : this.f32940c.f19418G == CompressFormat.PNG ? ".png" : ".webp";
            return Uri.fromFile(File.createTempFile("cropped", str, getCacheDir()));
        } catch (Throwable e) {
            throw new RuntimeException("Failed to create temp file for output image", e);
        }
    }

    /* renamed from: a */
    protected void m44507a(Uri uri, Exception exception, int i) {
        setResult(exception == null ? -1 : 204, m44510b(uri, exception, i));
        finish();
    }

    /* renamed from: h */
    protected void m44513h() {
        setResult(0);
        finish();
    }

    /* renamed from: b */
    protected Intent m44510b(Uri uri, Exception exception, int i) {
        Parcelable c7196b = new C7196b(this.f32938a.getImageUri(), uri, exception, this.f32938a.getCropPoints(), this.f32938a.getCropRect(), this.f32938a.getRotatedDegrees(), this.f32938a.getWholeImageRect(), i);
        uri = new Intent();
        uri.putExtras(getIntent());
        uri.putExtra("CROP_IMAGE_EXTRA_RESULT", c7196b);
        return uri;
    }

    /* renamed from: a */
    private void m44505a(Menu menu, int i, int i2) {
        menu = menu.findItem(i);
        if (menu != null) {
            i = menu.getIcon();
            if (i != 0) {
                try {
                    i.mutate();
                    i.setColorFilter(i2, Mode.SRC_ATOP);
                    menu.setIcon(i);
                } catch (Menu menu2) {
                    Log.w("AIC", "Failed to update menu item color", menu2);
                }
            }
        }
    }
}

package host.exp.exponent;

import android.app.AlertDialog.Builder;
import android.app.IntentService;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.C0366b;
import host.exp.exponent.C6369g.C6359a;
import host.exp.exponent.experience.C8362a;
import host.exp.exponent.experience.ExperienceActivity;
import host.exp.exponent.experience.InfoActivity;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C7560j;
import host.exp.exponent.p344h.C6373d;
import host.exp.p333a.C6279c.C6272a;
import javax.inject.C6562a;
import org.json.JSONObject;

public class ExponentIntentService extends IntentService {
    @C6562a
    /* renamed from: a */
    C7560j f20433a;
    @C6562a
    /* renamed from: b */
    C6373d f20434b;
    @C6562a
    /* renamed from: c */
    C6369g f20435c;
    /* renamed from: d */
    private Handler f20436d = new Handler();

    /* renamed from: host.exp.exponent.ExponentIntentService$3 */
    class C62853 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ ExponentIntentService f20432a;

        C62853(ExponentIntentService exponentIntentService) {
            this.f20432a = exponentIntentService;
        }

        public void run() {
            this.f20432a.stopSelf();
        }
    }

    /* renamed from: a */
    public static Intent m25928a(Context context, String str) {
        Intent intent = new Intent(context, ExponentIntentService.class);
        intent.setAction("host.exp.exponent.action.INFO_SCREEN");
        intent.putExtra("experienceUrl", str);
        return intent;
    }

    /* renamed from: b */
    public static Intent m25932b(Context context, String str) {
        Intent intent = new Intent(context, ExponentIntentService.class);
        intent.setAction("host.exp.exponent.action.RELOAD_EXPERIENCE");
        intent.putExtra("experienceUrl", str);
        return intent;
    }

    /* renamed from: c */
    public static Intent m25934c(Context context, String str) {
        Intent intent = new Intent(context, ExponentIntentService.class);
        intent.setAction("host.exp.exponent.action.SAVE_EXPERIENCE");
        intent.putExtra("experienceUrl", str);
        return intent;
    }

    /* renamed from: a */
    public static Intent m25927a(Context context) {
        Intent intent = new Intent(context, ExponentIntentService.class);
        intent.setAction("host.exp.exponent.action.STAY_AWAKE");
        return intent;
    }

    public ExponentIntentService() {
        super("ExponentIntentService");
    }

    public void onCreate() {
        super.onCreate();
        C6294a.m25957a().m25961b(ExponentIntentService.class, this);
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            Object obj = -1;
            int hashCode = action.hashCode();
            Object obj2 = 1;
            if (hashCode != -969713043) {
                if (hashCode != 677699260) {
                    if (hashCode != 873243936) {
                        if (hashCode == 1712721071) {
                            if (action.equals("host.exp.exponent.action.STAY_AWAKE")) {
                                obj = 3;
                            }
                        }
                    } else if (action.equals("host.exp.exponent.action.RELOAD_EXPERIENCE")) {
                        obj = 1;
                    }
                } else if (action.equals("host.exp.exponent.action.SAVE_EXPERIENCE")) {
                    obj = 2;
                }
            } else if (action.equals("host.exp.exponent.action.INFO_SCREEN")) {
                obj = null;
            }
            switch (obj) {
                case null:
                    m25931a(intent.getStringExtra("experienceUrl"));
                    break;
                case 1:
                    m25933b(intent.getStringExtra("experienceUrl"));
                    break;
                case 2:
                    m25935c(intent.getStringExtra("experienceUrl"));
                    break;
                case 3:
                    m25929a();
                    break;
                default:
                    break;
            }
            obj2 = null;
            if (obj2 != null) {
                intent = this.f20433a.m34252c();
                if (intent instanceof ExperienceActivity) {
                    ((ExperienceActivity) intent).m44608q();
                }
            }
        }
    }

    /* renamed from: a */
    private void m25931a(String str) {
        Context f = C8362a.m44556f();
        if (f != null) {
            Intent intent = new Intent(f, InfoActivity.class);
            intent.putExtra("manifestUrl", str);
            intent.addFlags(603979776);
            f.startActivity(intent);
            sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            C6288a.m25943a("INFO_SCREEN", str);
        }
        stopSelf();
    }

    /* renamed from: b */
    private void m25933b(String str) {
        this.f20433a.m26070i(str);
        sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        C6288a.m25943a("RELOAD_EXPERIENCE", str);
        stopSelf();
    }

    /* renamed from: c */
    private void m25935c(final String str) {
        sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        if (this.f20434b.m26161c()) {
            this.f20433a.m34263h(str);
            C6288a.m25943a("SAVE_EXPERIENCE", str);
            stopSelf();
            return;
        }
        C6288a.m25943a("SAVE_EXPERIENCE_ALERT", str);
        this.f20433a.m34252c().runOnUiThread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ ExponentIntentService f20429b;

            public void run() {
                this.f20429b.m25936d(str);
            }
        });
    }

    /* renamed from: d */
    private void m25936d(final String str) {
        JSONObject jSONObject = this.f20434b.m26160c(str).f20639a;
        final String optString = jSONObject.optString("name");
        this.f20435c.m26140a(jSONObject.optString("iconUrl"), new C6359a(this) {
            /* renamed from: c */
            final /* synthetic */ ExponentIntentService f26071c;

            /* renamed from: host.exp.exponent.ExponentIntentService$2$1 */
            class C62831 implements OnClickListener {
                /* renamed from: a */
                final /* synthetic */ C75142 f20430a;

                C62831(C75142 c75142) {
                    this.f20430a = c75142;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    C6288a.m25943a("SAVE_EXPERIENCE_OPTION_NO", str);
                    this.f20430a.f26071c.stopSelf();
                }
            }

            /* renamed from: host.exp.exponent.ExponentIntentService$2$2 */
            class C62842 implements OnClickListener {
                /* renamed from: a */
                final /* synthetic */ C75142 f20431a;

                C62842(C75142 c75142) {
                    this.f20431a = c75142;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f20431a.f26071c.f20434b.m26153a("has_saved_shortcut", true);
                    this.f20431a.f26071c.f20433a.m34263h(str);
                    C6288a.m25943a("SAVE_EXPERIENCE_OPTION_YES", str);
                    this.f20431a.f26071c.stopSelf();
                }
            }

            /* renamed from: a */
            public void mo5380a(Bitmap bitmap) {
                Drawable bitmapDrawable = new BitmapDrawable(this.f26071c.getResources(), bitmap);
                bitmap = new Builder(this.f26071c.f20433a.m34252c()).setTitle("Save Shortcut");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("This will save a shortcut to ");
                stringBuilder.append(optString);
                stringBuilder.append(" on your home screen. Continue?");
                bitmap = bitmap.setMessage(stringBuilder.toString()).setPositiveButton(17039379, new C62842(this)).setNegativeButton(17039369, new C62831(this)).setIcon(bitmapDrawable).show();
                bitmap.getButton(-2).setTextColor(C0366b.c(this.f26071c, C6272a.colorPrimary));
                bitmap.getButton(-1).setTextColor(C0366b.c(this.f26071c, C6272a.colorPrimary));
            }
        });
    }

    /* renamed from: a */
    private void m25929a() {
        this.f20436d.postDelayed(new C62853(this), 60000);
    }
}

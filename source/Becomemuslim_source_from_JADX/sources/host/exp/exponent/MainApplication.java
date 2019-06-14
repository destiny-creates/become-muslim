package host.exp.exponent;

import cl.json.C3342a;
import co.apptailor.googlesignin.C3346c;
import com.RNFetchBlob.C3354e;
import com.bitgo.randombytes.C3443a;
import com.bugsnag.BugsnagReactNative;
import com.facebook.react.ReactPackage;
import com.geektime.rnonesignalandroid.C3980b;
import com.gettipsi.stripe.C3989e;
import com.github.yamill.orientation.C3990a;
import com.gmail.dronesforaliving.howtobecomemuslim.R;
import com.idehub.GoogleAnalyticsBridge.C6932c;
import com.imagepicker.C6941a;
import com.jadsonlourenco.RNShakeEvent.C6942a;
import com.learnium.RNDeviceInfo.C6943a;
import com.lugg.ReactNativeConfig.C6944a;
import com.masteratul.exceptionhandler.C6945b;
import com.ocetnik.timer.C6946a;
import com.polidea.reactnativeble.C7107a;
import com.reactnativecommunity.webview.C7150a;
import com.sudoplz.reactnativeamplitudeanalytics.C7194a;
import com.wenkesj.voice.C7198a;
import com.zmxv.RNSound.C7199a;
import de.innfactory.apiai.C7220a;
import expo.modules.ads.admob.AdMobPackage;
import expo.modules.analytics.segment.SegmentPackage;
import expo.modules.appauth.AppAuthPackage;
import expo.modules.backgroundfetch.BackgroundFetchPackage;
import expo.modules.barcodescanner.BarCodeScannerPackage;
import expo.modules.camera.CameraPackage;
import expo.modules.constants.ConstantsPackage;
import expo.modules.contacts.ContactsPackage;
import expo.modules.facedetector.FaceDetectorPackage;
import expo.modules.filesystem.FileSystemPackage;
import expo.modules.font.FontLoaderPackage;
import expo.modules.gl.GLPackage;
import expo.modules.google.signin.GoogleSignInPackage;
import expo.modules.localauthentication.LocalAuthenticationPackage;
import expo.modules.localization.LocalizationPackage;
import expo.modules.location.LocationPackage;
import expo.modules.medialibrary.MediaLibraryPackage;
import expo.modules.permissions.PermissionsPackage;
import expo.modules.print.PrintPackage;
import expo.modules.sensors.SensorsPackage;
import expo.modules.sms.SMSPackage;
import expo.modules.taskManager.TaskManagerPackage;
import expo.p304a.p305a.C6002i;
import expo.p318c.p319a.p320a.C6045b;
import java.util.Arrays;
import java.util.List;
import net.no_mad.tts.C7636a;

public class MainApplication extends C7528e implements C6045b<ReactPackage> {
    /* renamed from: d */
    public boolean mo6407d() {
        return false;
    }

    /* renamed from: e */
    public boolean mo6408e() {
        return true;
    }

    /* renamed from: a */
    public List<ReactPackage> mo6404a() {
        return Arrays.asList(new ReactPackage[]{new C7107a(), new C7150a(), new C3980b(), new C3443a(), new C6945b(), new C7220a(), new C7198a(), new C7636a(), new C3989e(), new C7199a(), new C3342a(), new C6941a(), new C6942a(), BugsnagReactNative.getPackage(), new C3354e(), new C6944a(), new C3346c(), new C6946a(), new C3990a(), new C6932c(), new C6943a(), new C7194a(this)});
    }

    /* renamed from: b */
    public List<C6002i> mo6405b() {
        return Arrays.asList(new C6002i[]{new CameraPackage(), new ConstantsPackage(), new SensorsPackage(), new FileSystemPackage(), new FaceDetectorPackage(), new GLPackage(), new GoogleSignInPackage(), new PermissionsPackage(), new SMSPackage(), new PrintPackage(), new ConstantsPackage(), new MediaLibraryPackage(), new SegmentPackage(), new FontLoaderPackage(), new LocationPackage(), new ContactsPackage(), new BarCodeScannerPackage(), new AdMobPackage(), new LocalAuthenticationPackage(), new LocalizationPackage(), new AppAuthPackage(), new TaskManagerPackage(), new BackgroundFetchPackage()});
    }

    /* renamed from: c */
    public String mo6406c() {
        return getString(R.string.gcm_defaultSenderId);
    }
}

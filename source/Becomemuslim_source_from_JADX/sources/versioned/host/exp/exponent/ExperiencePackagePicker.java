package versioned.host.exp.exponent;

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
import expo.modules.payments.stripe.StripePackage;
import expo.modules.permissions.PermissionsPackage;
import expo.modules.print.PrintPackage;
import expo.modules.sensors.SensorsPackage;
import expo.modules.sms.SMSPackage;
import expo.modules.taskManager.TaskManagerPackage;
import expo.p304a.p305a.C6002i;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class ExperiencePackagePicker {
    private static final List<C6002i> EXPO_MODULES_PACKAGES = Arrays.asList(new C6002i[]{new CameraPackage(), new SensorsPackage(), new FileSystemPackage(), new FaceDetectorPackage(), new ConstantsPackage(), new GLPackage(), new GoogleSignInPackage(), new PermissionsPackage(), new SMSPackage(), new PrintPackage(), new MediaLibraryPackage(), new SegmentPackage(), new FontLoaderPackage(), new LocationPackage(), new ContactsPackage(), new BarCodeScannerPackage(), new AdMobPackage(), new StripePackage(), new LocalAuthenticationPackage(), new LocalizationPackage(), new AppAuthPackage(), new TaskManagerPackage(), new BackgroundFetchPackage()});

    static List<C6002i> packages() {
        return EXPO_MODULES_PACKAGES;
    }

    static List<C6002i> packages(JSONObject jSONObject) {
        return EXPO_MODULES_PACKAGES;
    }
}

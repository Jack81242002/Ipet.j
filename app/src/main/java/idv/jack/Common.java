package idv.jack;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Common { // Android官方模擬器連結本機web server可以直接使用 http://10.0.2.2
    //	public static String URL = "http://192.168.196.202:8080/TextToJson_Web/SearchServlet";
//    public final static String URL = "http://10.0.2.2:8081/BA103G1/PetServletAndroid";
    public final static String URL = "http://10.0.2.2:8081/BA103G1/PetServletAndroid";


    public static boolean networkConnected(Activity activity) {
        ConnectivityManager conManager =
                (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static void showToast(Context context, int messageResId) {
        Toast.makeText(context, messageResId, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

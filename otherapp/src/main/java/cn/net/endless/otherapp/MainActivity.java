package cn.net.endless.otherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.flyingpigeon.library.ServiceManager;
import com.flyingpigeon.library.annotations.RequestLarge;
import com.flyingpigeon.library.annotations.route;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ServiceManager.getInstance().publish(this);
    }


    @RequestLarge
    @route("/fly/test")
    public void flyTest(final String str1, final byte[] str2) {
        Log.e("test", "str1===" + str1);
        Log.e("test", "str2===" + str2.length);
    }

    @route("/fly/test1")
    public void flyTest1(final Bundle in, final Bundle out) {
        Log.e("test", "in===" + in.getByteArray("key").length);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ServiceManager.getInstance().unpublish(this);
    }
}

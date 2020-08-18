package cn.net.endless.flying_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.flyingpigeon.library.FlyPigeon;
import com.flyingpigeon.library.Pigeon;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {

        Pigeon flyPigeon = Pigeon.newBuilder(MainActivity.this)
                .setAuthority("cn.net.endless").build();
        //这个报错
        flyPigeon.route("/fly/test", "test", new byte[1024 * 1024]).resquestLarge().fly();
        //这个可以
        flyPigeon.route("/fly/test1").withByteArray("key", new byte[1024]).fly();
    }
}

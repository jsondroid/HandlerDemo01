package jsondroid.android.com.handlerdemo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import jsondroid.android.com.handlerdemo01.handl.Imodle;
import jsondroid.android.com.handlerdemo01.handl.Modle;

public class MainActivity extends AppCompatActivity implements Imodle {

    ImageView imageView;

    Modle modle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        modle=new Modle(this);
    }

    int c=0;
    public void Onclick(View view) {
        modle.handl(c);
        c++;
    }

    @Override
    public void callback(Object obj) {
        Log.e("返回---->",""+obj);
        imageView.setImageResource(R.mipmap.ic_launcher);
    }
}

package com.example.olawr.revision;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageButton ib;
    RadioButton r1, r2, r3;
    MediaPlayer piratesound, priestsound;
    int which;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.b1);
        ib = (ImageButton)findViewById(R.id.ib1);
        r1 = (RadioButton)findViewById(R.id.rb1);
        r2 = (RadioButton)findViewById(R.id.rb2);
        r3 = (RadioButton)findViewById(R.id.rb3);
        piratesound = MediaPlayer.create(this, R.raw.piratenoise);
        priestsound = MediaPlayer.create(this, R.raw.priestnoise);

    }

    public void dothis(View v){
        Toast.makeText(getApplicationContext(),"Input Registered",Toast.LENGTH_SHORT).show();

        Intent i = new Intent(MainActivity.this, thanks.class);
        startActivity(i);
    }

    public void visibilitycheck(View v){
        if(r1.isChecked()){
            ib.setVisibility(View.VISIBLE);
            ib.setImageResource(R.drawable.swashbuckler);
            which = 1;
        }else if(r2.isChecked()){
            ib.setVisibility(View.VISIBLE);
            ib.setImageResource(R.drawable.priest);
            which = 2;
        }else if(r3.isChecked()){
            ib.setVisibility(View.VISIBLE);
            ib.setImageResource(R.drawable.pirate_priest);
            which = 3;
        }
    }

    public void soundplayer(View v){
        if(which==1){
            piratesound.start();
        }else if(which==2){
            priestsound.start();
        }else if(which==3){
            piratesound.start();
            final Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    priestsound.start();
                }
            }, 500);

        }
    }
}

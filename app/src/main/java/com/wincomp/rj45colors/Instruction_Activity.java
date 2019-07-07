package com.wincomp.rj45colors;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Instruction_Activity extends AppCompatActivity {
    VideoView videoView;
    Button button_Start;
    Button button_Next;
    Button button_Prew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_);
        videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.instruction1));
        button_Start = (Button) findViewById(R.id.button_start);
        button_Next = (Button) findViewById(R.id.button_next);
        button_Prew = (Button) findViewById(R.id.button_prew);

    }

    public void clickStartBtn(View view) {
        videoView.start();
        button_Next.setVisibility(View.VISIBLE);
        button_Start.setVisibility(View.INVISIBLE);

    }
}

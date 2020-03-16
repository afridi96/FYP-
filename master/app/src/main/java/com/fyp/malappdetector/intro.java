package com.fyp.malappdetector;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class intro extends AppCompatActivity {

    private static final long SPLASH_TIME = 4000;

    private ProgressBar progressBar;
    private int progressStatus = 0;
    TextView totalApps,scannedApps;
    Button toMalcious;
    private TextView textView;
    LinearLayout linearLayout;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        totalApps=findViewById(R.id.countTotalApps);
        linearLayout=findViewById(R.id.outPutLayout);
        scannedApps=findViewById(R.id.countScannedApps);
        toMalcious=findViewById(R.id.toMalicious);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
//
//
//        TimerTask task=new TimerTask() {
//            @Override
//            public void run() {
//                Intent mainIntent=new Intent().setClass(intro.this,MainActivity.class);
//                startActivity(mainIntent);
//                finish();
//            }
//        };
//        Timer timer=new Timer();
//        timer.schedule(task,SPLASH_TIME);
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 50) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            //textView.setText(progressStatus+"/"+progressBar.getMax());
                            totalApps.setText("99");
                            scannedApps.setText(Integer.toString(progressStatus));
                            //progressBar.invalidate();
                            if(progressStatus==50){
                                progressBar.setVisibility(View.GONE);
                                linearLayout.setVisibility(View.VISIBLE);

                            }
//                            Intent serviceIntent=new Intent();
//                            serviceIntent.setAction("com.example.progressbar.ScannerService");
//                            startService(new Intent(intro.this,ScannerService.class));
//                            Intent stopService=new Intent(intro.this,ScannerService.class);
//                            stopService(stopService);

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
        toMalcious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(intro.this,MaliciousApps.class);
                startActivity(intent);
            }
        });

                            Intent serviceIntent=new Intent();
                            serviceIntent.setAction("com.example.progressbar.ScannerService");
                            startService(new Intent(intro.this,ScannerService.class));
//                            Intent stopService=new Intent(intro.this,ScannerService.class);
//                            stopService(stopService);

    }

}

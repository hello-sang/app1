package com.example.dongho;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btSatrt,btEnd;
    TextView tvGio;
    TimePicker timepicker;
    Calendar calendar;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        Control();
    }

    private void Control() {
        btSatrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY,timepicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,timepicker.getCurrentMinute());

                int gio = timepicker.getCurrentHour();
                int phut=timepicker.getCurrentMinute();

                String hour=String.valueOf(gio);
                String minutes=String.valueOf(phut);


                Intent intent = new Intent(MainActivity.this,ClockReceiver.class);;
                intent.putExtra("hello","on");
                pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                tvGio.setText("thoi gian choj la : "+hour+":"+minutes+".");
            }

        });
        btEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvGio.setText("dung laij");
                Intent intent = new Intent(MainActivity.this,ClockReceiver.class);
                intent.putExtra("hello","off");
                sendBroadcast(intent);
            }

        });
    }

    private void Anhxa() {
        btSatrt=findViewById(R.id.btnBatdau);
        btEnd=findViewById(R.id.btnDung);
        tvGio=findViewById(R.id.tvThoigian);
        timepicker=findViewById(R.id.timepickerClock);

        calendar=Calendar.getInstance();
//alarmmanager cho pheps truy caapj vao t=he thong bao ddoognj
        alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);

        //chuyen trang


        //pendingIntent ddeer khi tawt app nos vaanx chayj
       /// pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
    }
}

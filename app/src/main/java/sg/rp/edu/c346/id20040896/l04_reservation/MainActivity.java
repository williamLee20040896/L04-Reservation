package sg.rp.edu.c346.id20040896.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    DatePicker dp ;
    TimePicker tp;
    Button btnReservation;
    Button btnReset;
    EditText name;
    EditText phone;
    EditText size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReservation = findViewById(R.id.buttonReservation);
        btnReset = findViewById(R.id.buttonReset);
        name = findViewById(R.id.editTextTextPersonName);
        phone = findViewById(R.id.editTextPhone);
        size = findViewById(R.id.editTextNumber);

        dp.updateDate(2021,5,1);
        tp.setIs24HourView(true);
        tp.setCurrentMinute(30);
        tp.setCurrentHour(19);

        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().equals(null) || phone.getText().toString().trim().length() == 0 ||
                    size.getText().toString().trim().length() == 0){

                    Toast.makeText(MainActivity.this, "Error",Toast.LENGTH_LONG).show();


                }
                else{
                    Toast.makeText(MainActivity.this, String.format("%s has reserve %d of pax table on ",name.getText().toString(),size.getText().toString()) + dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear() + " at " + tp.getCurrentHour() + ":" + tp.getCurrentMinute(), Toast.LENGTH_LONG).show();
                }

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size.setText("");
                phone.setText("");
                name.setText("");
                dp.updateDate(2021,5,1);
                tp.setIs24HourView(true);
                tp.setCurrentMinute(30);
                tp.setCurrentHour(19);


            }
        });




    }
}
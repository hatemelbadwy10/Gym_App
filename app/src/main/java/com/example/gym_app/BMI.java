package com.example.gym_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class BMI extends AppCompatActivity {
private double result=0;
    int weightValue;
    int heightValue;
    Button calcute;
    TextView resulet;
    int step = 1;
    int weightMin = 40;
    int heightMin = 130;
    int weightmax=220;
    int hightmax=210;
    NoticationHelper noticationHelper=new NoticationHelper();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

         weightValue = weightMin;
         heightValue = heightMin;

        SeekBar heightbar=findViewById(R.id.heightbar);
        SeekBar weightbar=findViewById(R.id.wieghtbar);
         calcute=findViewById(R.id.calculate);
        TextView height_value=findViewById(R.id.heightvalue);
        height_value.setText("130 CM");
        TextView weight_value=findViewById(R.id.wightvalue);
        weight_value.setText("40");
         resulet= findViewById(R.id.rsult);

        heightbar.setMax((hightmax-heightMin)/1);
        weightbar.setMax((weightmax-weightMin)/1);
heightbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
int value_height=heightMin+ (seekBar.getProgress()*step);
        height_value.setText(Integer.toString(value_height) + " CM");
        heightValue=value_height; }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});

    weightbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int value_weight=weightMin+(seekBar.getProgress()*step);
            weight_value.setText(Integer.toString(value_weight)+"KG");
            weightValue=value_weight;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void calculte_bmi(View view) {
        if(result == 0){
            result = ( weightValue/ Math.pow( (double) heightValue / 100, 2));
            calcute.setText("reset");
            calcute.setBackgroundColor(getResources().getColor(R.color.button_color));
            resulet.setText(getResults());
        }else{
            result = 0;
            calcute.setText("calculet");
            resulet.setText("");

        }
        noticationHelper.done_work(BMI.this);

    }
    private String getResults(){
        if(result < 16.0)
            return "Underweight (Severe thinness)";
        else if((result >= 16.0) & (result <= 16.9))
            return "Underweight (Moderate thinness)";
        else if((result >= 17.0) & (result <= 18.4))
            return "Underweight (Mild thinness)";
        else if((result >= 18.5) & (result <= 24.9))
            return "Normal range";
        else if((result >= 25.0) & (result <= 29.9))
            return "Overweight (Pre-obese)";
        else if((result >= 30.0) & (result <= 34.9))
            return "Obese (Class I)";
        else if((result >= 35.0) & (result <= 39.9))
            return "Obese (Class II)";
        else if(result >= 40.0)
            return "Obese (Class III)";
        return "";
    }
}
package com.example.a14049472.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


        private EditText height;
        private EditText weight;
        private TextView result;
        private Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            height = (EditText) findViewById(R.id.height);
            weight = (EditText) findViewById(R.id.weight);
            result = (TextView) findViewById(R.id.result);
            button=(Button)findViewById(R.id.calculate);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    calculateBMI(result);
                }
            });
        }


        public void calculateBMI(View v) {
            String heightStr = height.getText().toString();
            String weightStr = weight.getText().toString();



                if (heightStr != null && !"".equals(heightStr)
                        && weightStr != null && !"".equals(weightStr)) {
                    float heightValue = Float.parseFloat(heightStr) / 100;
                    float weightValue = Float.parseFloat(weightStr);

                    float bmi = weightValue / (heightValue * heightValue);

                    displayBMI(bmi);

                }
            }


        private void displayBMI(float bmi) {
            String bmiLabel = "";

            if (Float.compare(bmi, 15f) <= 0) {
                bmiLabel = "Very severely underweight \n Recommendation: \n Eat five to six smaller meals during the day";
            } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
                bmiLabel = "Severely underweight \n Recommendation: \n Choose nutrient-rich foods";
            } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
                bmiLabel ="Underweight \n Recommendation: \n Eat mini-meals";
            } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
                bmiLabel = "Normal \n Recommendation: \n GOOD YOU ARE FIT! KEEP IT OUT!";
            } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
                bmiLabel = "Overweight\n Recommendation: \n Likely to suffer heart disease \n Encourage to see a doctor";
            } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
                bmiLabel = "Obese_class_i\n Recommendation: \n Likely to suffer high blood pressure \n Encourage to see a doctor";
            } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
                bmiLabel = "Obese_class_ii\n Recommendation: \n Likely to suffer stroke \n  Encourage to see a doctor";
            } else {
                bmiLabel = "Obese_class_iii\n Recommendation: \n Likely to suffer diabetes \n Encourage to see a doctor";
            }

            bmiLabel = bmi + "\n\n" + bmiLabel;
            result.setText(bmiLabel);
        }
    }
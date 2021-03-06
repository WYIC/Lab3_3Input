package my.edu.tarc.lab3_3input;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = findViewById(R.id.checkBoxSmoker);
        textViewPremium = findViewById(R.id.textViewPremium);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age_group, android.R.layout.simple_dropdown_item_1line);
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Position : "+ position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view)
    {
        int position;
        int gender;
        double premium = 0;
        position = spinnerAge.getSelectedItemPosition();
        switch (position)
        {
            case 0:
                premium += 50;
                break;
            case 1:
                premium += 55;
                break;
            case 2:
                premium += 60;
                gender = radioGroupGender.getCheckedRadioButtonId();
                if (gender == R.id.radioButtonMale)
                {
                    premium += 50;
                }
                break;
            case 3:
                premium += 70;
                gender = radioGroupGender.getCheckedRadioButtonId();
                if (gender == R.id.radioButtonMale)
                {
                    premium += 100;
                }

                if (checkBoxSmoker.isChecked())
                {
                    premium += 100;
                }
                break;
            case 4:
                premium += 120;
                gender = radioGroupGender.getCheckedRadioButtonId();
                if (gender == R.id.radioButtonMale)
                {
                    premium += 100;
                }

                if (checkBoxSmoker.isChecked())
                {
                    premium += 150;
                }
                break;
            case 5:
                premium += 160;
                gender = radioGroupGender.getCheckedRadioButtonId();
                if (gender == R.id.radioButtonMale)
                {
                    premium += 50;
                }

                if (checkBoxSmoker.isChecked())
                {
                    premium += 150;
                }
                break;
            case 6:
                premium += 200;
                if (checkBoxSmoker.isChecked())
                {
                    premium += 250;
                }
                break;
            case 7:
                premium += 250;
                if (checkBoxSmoker.isChecked())
                {
                    premium += 250;
                }
                break;
        }

        textViewPremium.setText(premium + "");
    }

    public void reset(View view)
    {
        spinnerAge.setSelection(0);
        radioGroupGender.clearCheck();
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText("RM " + 0.00 + "");
    }
}

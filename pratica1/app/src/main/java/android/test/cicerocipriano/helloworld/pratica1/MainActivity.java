package android.test.cicerocipriano.helloworld.pratica1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2;
    Button plusBtn, minusBtn, timesBtn, divideBtn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.textBox1);
        input2 = findViewById(R.id.textBox2);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        timesBtn = findViewById(R.id.timesBtn);
        divideBtn = findViewById(R.id.divideBtn);
        result = findViewById(R.id.resultText);

        plusBtn.setOnClickListener(v -> operation(0));
        minusBtn.setOnClickListener(v -> operation(1));
        timesBtn.setOnClickListener(v -> operation(2));
        divideBtn.setOnClickListener(v -> operation(3));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void operation(int op){
        try{
            double val1 = Double.parseDouble(input1.getText().toString()), val2 = Double.parseDouble(input2.getText().toString());
            if(op == 0)
                result.setText(getString(R.string.result, val1 + val2));
            else if(op == 1)
                result.setText(getString(R.string.result, val1 - val2));
            else if(op == 2)
                result.setText(getString(R.string.result, val1 * val2));
            else{
                if(val2 == 0){
                    Toast.makeText(this, "Can't divide by zero.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result.setText(getString(R.string.result, val1 / val2));
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please, write valid values.", Toast.LENGTH_SHORT).show();
        }
    }
}
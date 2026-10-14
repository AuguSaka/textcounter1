package com.example.textcounter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int METRIC_SENTENCES = 0;
    private static final int METRIC_WORDS = 1;
    private static final int METRIC_PUNCTUATION = 2;
    private static final int METRIC_NUMBERS = 3;

    private EditText editTextInput;
    private Spinner spinnerMetric;
    private TextView textViewResult;

    private final TextMetricsCalculator calculator =
            new TextMetricsCalculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        spinnerMetric = findViewById(R.id.spinnerMetric);
        textViewResult = findViewById(R.id.textViewResult);

        Button buttonCalculate =
                findViewById(R.id.buttonCalculate);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.metric_options,
                        android.R.layout.simple_spinner_item
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerMetric.setAdapter(adapter);

        buttonCalculate.setOnClickListener(view -> {
            calculateResult();
        });
    }

    private void calculateResult() {
        String inputText = editTextInput.getText().toString();

        if (inputText.trim().isEmpty()) {
            Toast.makeText(
                    this,
                    R.string.empty_text_error,
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        int result = 0;

        int selectedMetric =
                spinnerMetric.getSelectedItemPosition();

        switch (selectedMetric) {
            case METRIC_SENTENCES:
                result = calculator.countSentences(inputText);
                break;

            case METRIC_WORDS:
                result = calculator.countWords(inputText);
                break;

            case METRIC_PUNCTUATION:
                result = calculator.countPunctuation(inputText);
                break;

            case METRIC_NUMBERS:
                result = calculator.countNumbers(inputText);
                break;
        }

        String metricName =
                spinnerMetric.getSelectedItem().toString();

        textViewResult.setText(
                getString(
                        R.string.result_format,
                        metricName,
                        result
                )
        );
    }
}

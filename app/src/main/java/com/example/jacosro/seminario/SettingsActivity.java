package com.example.jacosro.seminario;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.prefs.Preferences;

public class SettingsActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Spinner spinner;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        nameEditText = findViewById(R.id.nameEditText);
        spinner = findViewById(R.id.spinner);
        radioGroup = findViewById(R.id.radioGroup3);
    }

    @Override
    public void onStart() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        nameEditText.setText(preferences.getString("name", ""));
        spinner.setSelection(preferences.getInt("language", 0));
        RadioButton radioButton = findViewById(preferences.getInt("radioId", 0));

        if (radioButton != null) {
            radioButton.setSelected(true);
        }

        super.onStart();
    }

    @Override
    public void onPause() {
        String name = nameEditText.getText().toString();
        int language = spinner.getSelectedItemPosition();
        int radioId = radioGroup.getCheckedRadioButtonId();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", name.isEmpty() ? null : name);
        editor.putInt("language", language);
        editor.putInt("radioId", radioId);
        editor.apply();

        super.onPause();
    }
}

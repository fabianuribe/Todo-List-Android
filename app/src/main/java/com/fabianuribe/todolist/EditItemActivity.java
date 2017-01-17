package com.fabianuribe.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.fabianuribe.todolist.R.id.etNewItem;

public class EditItemActivity extends AppCompatActivity {

    int itemPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        itemPos = getIntent().getIntExtra("itemPos", 0);

        String itemName = getIntent().getStringExtra("itemName");
        EditText etEditName = (EditText) findViewById(R.id.etEditName);
        etEditName.setText(itemName);
        // Set the cursor to the end
        etEditName.setSelection(etEditName.getText().length());
    }

    public void onSubmit(View v) {
        EditText etEditName = (EditText) findViewById(R.id.etEditName);

        Intent data = new Intent();

        data.putExtra("itemName", etEditName.getText().toString());
        data.putExtra("itemPos", itemPos);

        setResult(RESULT_OK, data);
        finish();
    }
}

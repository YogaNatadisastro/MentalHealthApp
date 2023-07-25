package com.app.chatbot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class DetailReminderActivity extends AppCompatActivity {

    EditText namaObatEditText, waktuMakanObatEditText;
    ImageButton saveReminderBtn;
    Button deleteReminderViewBtn, addReminderViewBtn;
    TextView pageTitleTextView;
    String title,content,docId;
    boolean isEditMode = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_reminder);

        namaObatEditText = findViewById(R.id.reminder_nameObat_text);
        waktuMakanObatEditText = findViewById(R.id.reminder_waktuMakan_text);
        saveReminderBtn = findViewById(R.id.save_reminder_btn);
        pageTitleTextView = findViewById(R.id.page_tittle);
        deleteReminderViewBtn = findViewById(R.id.deleteReminder);
        addReminderViewBtn = findViewById(R.id.add_time);

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        docId = getIntent().getStringExtra("docId");

        if (docId!=null && !docId.isEmpty()){
            isEditMode = true;
        }

        namaObatEditText.setText(title);
        waktuMakanObatEditText.setText(content);
        if (isEditMode){
            pageTitleTextView.setText("Edit your Reminder");
            deleteReminderViewBtn.setVisibility(View.VISIBLE);

        }

        saveReminderBtn.setOnClickListener((v)-> saveReminder());

        deleteReminderViewBtn.setOnClickListener((v)-> deleteReminderFromFirebase());

        addReminderViewBtn.setOnClickListener((v)-> startActivity(new Intent(DetailReminderActivity.this, AlarmActivity.class)));

    }

    void saveReminder() {
        String namaObat = namaObatEditText.getText().toString();
        String waktuMakan = waktuMakanObatEditText.getText().toString();
        if(namaObat == null || namaObat.isEmpty()) {
            namaObatEditText.setError("obat is");
            return;
        }
        Reminder reminder = new Reminder();
        reminder.setTitle(namaObat);
        reminder.setContent(waktuMakan);
        reminder.setTimestamp(Timestamp.now());

        saveReminderToFirebase(reminder);
    }

    void saveReminderToFirebase(Reminder reminder) {
        DocumentReference documentReference;
        if (isEditMode){
            //update reminder
            documentReference = UtilityReminder.getCollectionReferenceForReminder().document(docId);
        } else {
            //create new reminder
            documentReference = UtilityReminder.getCollectionReferenceForReminder().document();
        }

        documentReference.set(reminder).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    //reminder is added
                    UtilityReminder.showToast(DetailReminderActivity.this, "Reminder added succesfully");
                    finish();
                } else {
                    UtilityReminder.showToast(DetailReminderActivity.this, "Failed while adding reminder");
                }
            }
        });
    }
    void deleteReminderFromFirebase(){
        DocumentReference documentReference;
            documentReference = UtilityReminder.getCollectionReferenceForReminder().document(docId);
        documentReference.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    //reminder is added
                    UtilityReminder.showToast(DetailReminderActivity.this, "Reminder added succesfully");
                    finish();
                } else {
                    UtilityReminder.showToast(DetailReminderActivity.this, "Failed while deleting reminder");
                }
            }
        });
    }
}
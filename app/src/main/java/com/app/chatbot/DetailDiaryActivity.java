package com.app.chatbot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class DetailDiaryActivity extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    ImageButton saveDiaryBtn;
    TextView pageTitleTextView;
    String title,content,docId;
    boolean isEditMode = false;
    TextView deleteDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_diary);

        titleEditText = findViewById(R.id.notes_tittle_text);
        contentEditText = findViewById(R.id.note_content_text);
        saveDiaryBtn = findViewById(R.id.save_diary_btn);
        pageTitleTextView = findViewById(R.id.page_tittle);
        deleteDiary = findViewById(R.id.delete_note_text_view_btn);
        //receive data
        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        docId = getIntent().getStringExtra("docId");

        if (docId!=null && !docId.isEmpty()){
            isEditMode = true;
        }

        titleEditText.setText(title);
        contentEditText.setText(content);
        if (isEditMode){
            pageTitleTextView.setText("Edit your diary");
            deleteDiary.setVisibility(View.VISIBLE);
        }

        saveDiaryBtn.setOnClickListener((v)-> saveDiary());

        deleteDiary.setOnClickListener((v)-> deleteDiaryFromFirebase());
    }

    void saveDiary() {
        String noteTitle = titleEditText.getText().toString();
        String noteContent = contentEditText.getText().toString();
        if (noteTitle == null || noteTitle.isEmpty()) {
            titleEditText.setError("Tittle is requird");
            return;
        }
        Diary diary = new Diary();
        diary.setTitle(noteTitle);
        diary.setContent(noteContent);
        diary.setTimestamp(Timestamp.now());

        setSaveDiaryToFirebase(diary);
    }

    void setSaveDiaryToFirebase(Diary diary) {
        DocumentReference documentReference;
        if (isEditMode){
            documentReference = Utility.getCollectionReferenceForDiary().document(docId);
        } else {
            documentReference = Utility.getCollectionReferenceForDiary().document();
        }
        documentReference = Utility.getCollectionReferenceForDiary().document();

        documentReference.set(diary).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Utility.showToast(DetailDiaryActivity.this, "Diary added succesfully");
                finish();
            } else {
                Utility.showToast(DetailDiaryActivity.this, "Failed while added diary");
                finish();
            }
        });
    }

    void deleteDiaryFromFirebase(){
        DocumentReference documentReference;
            documentReference = Utility.getCollectionReferenceForDiary().document(docId);
        documentReference.delete().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Utility.showToast(DetailDiaryActivity.this, "Diary deleted succesfully");
                finish();
            } else {
                Utility.showToast(DetailDiaryActivity.this, "Failed while deleting diary");
                finish();
            }
        });
    }

}
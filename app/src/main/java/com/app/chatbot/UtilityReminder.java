package com.app.chatbot;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;

public class UtilityReminder {

    static void showToast(Context context, String message) {
        Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
    }

    static CollectionReference getCollectionReferenceForReminder() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("reminder")
                .document(currentUser.getUid()).collection("my_reminder");
    }

    static String timestampToString(Timestamp timestamp){
        return new SimpleDateFormat("MM/dd/yyyy").format(timestamp.toDate());
    }
}

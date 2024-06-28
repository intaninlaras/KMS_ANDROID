package com.polytechnic.astra.ac.id.knowledgemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    private ImageView profileImage, refreshIcon;
//    private TextView welcomeText, textRiwayatMateri, textMateriTersimpan, textProgramStudy;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        profileImage = findViewById(R.id.profile_image);
//        refreshIcon = findViewById(R.id.refresh_icon);
//        welcomeText = findViewById(R.id.welcome_text);
//        textRiwayatMateri = findViewById(R.id.text_riwayat_materi);
//        textMateriTersimpan = findViewById(R.id.text_materi_tersimpan);
//        textProgramStudy = findViewById(R.id.text_program_study);
//
//        CardView cardView1 = findViewById(R.id.card_view_1);
//        CardView cardView2 = findViewById(R.id.card_view_2);
//        CardView cardView3 = findViewById(R.id.card_view_3);
//        CardView cardView4 = findViewById(R.id.card_view_4);
//
//        profileImage.setOnClickListener(v -> {
//            // Handle profile image click
//        });
//
//        refreshIcon.setOnClickListener(v -> {
//            // Handle log out click
//            logOut();
//        });
//
//        cardView1.setOnClickListener(v -> {
//            // Handle first card view click
//            openMaterialDetail("DDL & DML");
//        });
//
//        cardView2.setOnClickListener(v -> {
//            // Handle second card view click
//            openMaterialDetail("Laravel Framework");
//        });
//
//        cardView3.setOnClickListener(v -> {
//            // Handle third card view click
//            openProgramDetail("Manajemen Informatika");
//        });
//
//        cardView4.setOnClickListener(v -> {
//            // Handle fourth card view click
//            openProgramDetail("Mekatronika");
//        });
//
//    }
//
//    private void logOut() {
//        // Implement log out functionality
//        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//        startActivity(intent);
//        finish();
//    }
//
//    private void openMaterialDetail(String materialName) {
//        Intent intent = new Intent(MainActivity.this, MaterialDetailActivity.class);
//        intent.putExtra("MATERIAL_NAME", materialName);
//        startActivity(intent);
//    }
//
//    private void openProgramDetail(String programName) {
//        Intent intent = new Intent(MainActivity.this, ProgramDetailActivity.class);
//        intent.putExtra("PROGRAM_NAME", programName);
//        startActivity(intent);
//    }
}
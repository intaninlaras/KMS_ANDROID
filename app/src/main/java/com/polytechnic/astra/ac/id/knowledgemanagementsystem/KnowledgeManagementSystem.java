package com.polytechnic.astra.ac.id.knowledgemanagementsystem;

import android.app.Application;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;

public class KnowledgeManagementSystem extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        MyRepository.initialize(this);
    }
}

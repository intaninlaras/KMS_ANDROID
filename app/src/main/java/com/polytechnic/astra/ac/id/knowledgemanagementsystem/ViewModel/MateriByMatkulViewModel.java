package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.MateriViewVO;

import java.util.ArrayList;
import java.util.List;

public class MateriByMatkulViewModel extends AndroidViewModel {
    private MutableLiveData<List<MateriViewVO>> listMateri;

    public MateriByMatkulViewModel(@NonNull Application application) {
        super(application);
        listMateri = new MutableLiveData<>();
        loadDummyData(); // Load dummy data initially
    }

    public LiveData<List<MateriViewVO>> getListMateri() {
        return listMateri;
    }

    private void loadDummyData() {
        List<MateriViewVO> dummyMateriList = new ArrayList<>();

        // Generate dummy data
        dummyMateriList.add(new MateriViewVO("1", "Pemrograman", "Pengantar Pemrograman Java", "", "",
                "Modul ini memberikan pengantar komprehensif tentang bahasa pemrograman Java. " +
                        "Materi meliputi sintaksis, tipe data, struktur kontrol, prinsip pemrograman berbasis objek, " +
                        "dan penanganan exception dasar.",
                "Pelajari dasar-dasar pemrograman Java dari awal. Modul ini mencakup segalanya mulai dari " +
                        "persiapan lingkungan pengembangan hingga menulis program Java pertama Anda.",
                "", "", "", "", "Active"));

        dummyMateriList.add(new MateriViewVO("2", "Pemrograman", "Dasar-dasar Pemrograman Python", "", "",
                "Modul ini mencakup dasar-dasar bahasa pemrograman Python. " +
                        "Materi meliputi variabel, struktur data, alur kontrol, fungsi, dan modul.",
                "Mulai belajar pemrograman Python. Modul ini dirancang untuk pemula agar dapat memahami " +
                        "fundamental Python dengan efektif.",
                "", "", "", "", "Inactive"));

        dummyMateriList.add(new MateriViewVO("3", "Pemrograman", "Fundamental JavaScript", "", "",
                "Modul fundamental JavaScript mencakup konsep inti seperti variabel, operator, " +
                        "fungsi, array, objek, dan manipulasi DOM.",
                "Kuasai dasar-dasar bahasa pemrograman JavaScript. Modul ini cocok untuk pemula dan " +
                        "mereka yang ingin memperbarui kembali keterampilan JavaScript mereka.",
                "", "", "", "", "Active"));

        listMateri.setValue(dummyMateriList);
    }
}


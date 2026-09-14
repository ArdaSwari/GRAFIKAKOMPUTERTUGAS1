package com.example.mandirigktitik;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends Activity {

    private GLSurfaceView glSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);

        //is an Android API call used to make an Activity enter or exit fullscreen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //GLSurfaceView: Ini adalah SurfaceView khusus yang dirancang untuk merender grafik OpenGL ES.
        // Menyediakan permukaan khusus untuk menggambar dan mengelola thread rendering dan konteks
        // OpenGL-nya sendiri, memisahkan rendering grafik dari thread UI utama.
        // Pemisahan ini mencegah masalah kinerja dan memastikan pengalaman pengguna yang lancar.
        glSurfaceView = new GLSurfaceView(this);

        //tetapkan renderer ( mengubah data ke dalam gambar)
        glSurfaceView.setRenderer(new  ESRender());

        // menetapkan objek GLSurfaceView sebagai tampilan konten utama untuk Aktivitassaat ini
        setContentView(glSurfaceView);

    }
}


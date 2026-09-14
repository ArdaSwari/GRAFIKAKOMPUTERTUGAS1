package com.example.mandirigktitik;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ESRender implements GLSurfaceView.Renderer {
    private CreatePoints points_object; // the object to be drawn

    public ESRender(){
        this.points_object = new CreatePoints();

    }
    @Override
    public void onDrawFrame(GL10 gl) {
        /*fungsi untuk menampilkan isi dari kontainer*/
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f); // set        background with white color
        //gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f); //        set background with black color
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT); // clear Screen and Depth Buffer
        // display drawing points

        // Menggambar titik  dengan Opengl (koordinat titik telah tersedia)===========================================
        gl.glPushMatrix();  // start freeze state/event to each object
        gl.glTranslatef(0.0f, 0.0f, -5.0f);
        gl.glPointSize(40);
        gl.glEnable(GL10.GL_POINT_SMOOTH);
        points_object.draw_points(gl);// draw all points from the vertex list
        gl.glPopMatrix();  // end freeze state/event to each object

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0)
            height = 1; // To prevent divide by zero
        float aspect = (float) width / height;
        // Set the viewport (display area) to cover the  entire window

        gl.glViewport(0, 0, width, height);
        // Setup perspective projection, with aspect ratio matches viewport
        gl.glMatrixMode(GL10.GL_PROJECTION);// Select  projection      matrix
        gl.glLoadIdentity();// Reset projection matrix
        //  Use perspective projection
        GLU.gluPerspective(gl,  45, aspect, 0.1f, 100.f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);// Select    model-view matrix
        gl.glLoadIdentity();// Reset


    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        points_object = new CreatePoints();

    }
}


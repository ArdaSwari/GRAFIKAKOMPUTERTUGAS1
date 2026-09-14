package com.example.mandirigktitik;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class CreatePoints {
    public float X1, Y1, X2, Y2;
    /** * Constructo */
    public CreatePoints() {
        X1 = 0;
        X2 = 0;
        Y2 = 0;
        Y1 = 0;
    }
    // Point to our vertex buffer, return buffer holding    the vertices
    public static FloatBuffer makeFloatBuffer(float[] arr) {
        ByteBuffer bb = ByteBuffer.allocateDirect(arr.length * 4);
        bb.order(ByteOrder.nativeOrder());
        FloatBuffer fb = bb.asFloatBuffer();
        fb.put(arr);
        fb.position(0);

        return fb;
    }
    /**
     * The draw method for the primitive
     * object with
     * the
     * GL context
     */
    public void draw_points(GL10 gl) {
        // Aktifkan vertex array dan color array
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        // Array berisi 24 titik (X, Y, Z)
        float[] points = new float[]{
                0.0f, 1.0f, 0.0f,   // Titik 1 (Index 0)
                0.1f, 0.9f, 0.0f,   // Titik 2
                0.2f, 0.8f, 0.0f,   // Titik 3
                0.3f, 0.7f, 0.0f,   // Titik 4
                0.4f, 0.6f, 0.0f,   // Titik 5
                0.5f, 0.5f, 0.0f,   // Titik 6
                0.6f, 0.4f, 0.0f,   // Titik 7
                0.7f, 0.3f, 0.0f,   // Titik 8
                0.8f, 0.2f, 0.0f,   // Titik 9
                0.9f, 0.1f, 0.0f,   // Titik 10 (Index 9)
                1.0f, 0.0f, 0.0f,   // Titik 11
                0.9f, -0.1f, 0.0f,  // Titik 12
                0.8f, -0.2f, 0.0f,  // Titik 13
                0.7f, -0.3f, 0.0f,  // Titik 14
                0.6f, -0.4f, 0.0f,  // Titik 15
                0.5f, -0.5f, 0.0f,  // Titik 16
                0.4f, -0.6f, 0.0f,  // Titik 17
                0.3f, -0.7f, 0.0f,  // Titik 18
                0.2f, -0.8f, 0.0f,  // Titik 19
                0.1f, -0.9f, 0.0f,  // Titik 20
                0.0f, -1.0f, 0.0f,  // Titik 21
                -0.1f, -0.9f, 0.0f, // Titik 22 (Index 21)
                -0.2f, -0.8f, 0.0f, // Titik 23
                -0.3f, -0.7f, 0.0f  // Titik 24
        };

        // Buat array warna untuk 24 titik (4 nilai per titik: R, G, B, Alpha)
        float[] colors = new float[24 * 4];
        for (int i = 0; i < 24; i++) {
            if (i == 0 || i == 9 || i == 21) {
                // Set Titik 1, 10, dan 22 menjadi Hijau
                colors[i * 4] = 0.0f;       // Red
                colors[i * 4 + 1] = 1.0f;   // Green
                colors[i * 4 + 2] = 0.0f;   // Blue
                colors[i * 4 + 3] = 1.0f;   // Alpha
            } else {
                // Set sisa titik menjadi Merah
                colors[i * 4] = 1.0f;       // Red
                colors[i * 4 + 1] = 0.0f;   // Green
                colors[i * 4 + 2] = 0.0f;   // Blue
                colors[i * 4 + 3] = 1.0f;   // Alpha
            }
        }

        // Terapkan buffer koordinat dan warna
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, makeFloatBuffer(points));
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, makeFloatBuffer(colors));

        // Gambar 24 titik
        gl.glDrawArrays(GL10.GL_POINTS, 0, 24);

        // Matikan client state
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
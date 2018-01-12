package com.examle.jaime.navigationdrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * Created by usuario on 12/01/18.
 */

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Aplicación que te ayuda en la gestión de inventario.")
                .setImage(R.drawable.logo_fondo)
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("Contacta con nosotros")
                .addEmail("jaime.ji.ag@gmail.com", "Contacta con nosotros")
                .addGitHub("jaimejiag", "Visitanos")
                .addFacebook("salvatore", "Danos like en Facebook")
                .addTwitter("salv", "Siguenos en Twitter")
                .addYoutube("kjsadhfkjsd_345nkj", "Míranos en Youtube")
                .create();

        setContentView(aboutPage);
    }
}
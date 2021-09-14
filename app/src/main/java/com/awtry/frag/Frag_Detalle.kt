package com.awtry.frag

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.lang.Exception


class Frag_Detalle : Fragment(R.layout.fragment_frag__detalle) {

    private lateinit var Le_Foto: INFO_FOTO
    private var No_Foto: Int = 0
    private var Mi_Fav: Boolean = false

    override fun onResume() {
        super.onResume()

        preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        Le_Foto = savedInstanceState?.getParcelable(FAVORITE_USER) ?: INFO_FOTO()

        Le_Foto = Es_Fav()

        Le_Foto = requireArguments().getParcelable("Fotito")?: INFO_FOTO()
        //No_Foto = intent.getIntExtra("No_Foto", 0)
        //Mi_Fav = Le_Foto.Mi_favorito

        initviews()
        Disparador_Boton_Detalle()
    }

    private fun saveUserLikes(FAV: INFO_FOTO? = null){
        preferences.edit().putString(FAVORITE_USER, moshi.adapter(INFO_FOTO::class.java).toJson(FAV)).apply()
    }

    private fun Es_Fav() =
        preferences.getString(FAVORITE_USER, null)?.let{
            return@let try{
                moshi.adapter(INFO_FOTO::class.java).fromJson(it)
            }catch (e: Exception){
                INFO_FOTO()
            }
        } ?: INFO_FOTO()

    //region iniciador

    private lateinit var txtDetalle: TextView
    private lateinit var btnFAV: ImageView
    private lateinit var IMG_Detalle: ImageView

    //endregion

    private fun initviews(){
        IMG_Detalle = findViewById(R.id.IMG_DETALLE)
        btnFAV = findViewById(R.id.btn_favorito)
        txtDetalle = findViewById(R.id.txv_Detalle)

        btnFAV.setImageResource(R.drawable.ic_star_2)

        //Muestra imagen viajera
        IMG_Detalle.setImageResource(Le_Foto.img)
        txtDetalle.setText(Le_Foto.descripcion.text)
    }

    private fun cambia_fav(){
        if (Mi_Fav){
            btnFAV.setImageResource(R.drawable.ic_star_2)
        }else{
            btnFAV.setImageResource(R.drawable.ic_star_8)
        }
        Le_Foto.Mi_favorito = Mi_Fav
        saveUserLikes(Le_Foto)
    }

    private fun Disparador_Boton_Detalle(){
        IMG_Detalle.setOnClickListener{
            startActivity(Intent(this, Full_Foto::class.java).apply{
                putExtra("Foto_Final", Le_Foto)
            })
        }

        btnFAV.setOnClickListener{
            cambia_fav()
        }
    }
}
}
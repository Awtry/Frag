package com.awtry.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class Frag_Full_Photo : Fragment(R.layout.fragment_frag__full__photo) {

    private lateinit var Le_Foto: INFO_FOTO

    override fun onResume() {
        super.onResume()

        Le_Foto = requireArguments().getParcelable("Foto_Final") ?: INFO_FOTO()

        initview()
    }

    private lateinit var IMG_Full: ImageView

    private fun initview(){
        IMG_Full = requireView().findViewById(R.id.IMG_FULL)
        IMG_Full.setImageResource(Le_Foto.img)
    }

}
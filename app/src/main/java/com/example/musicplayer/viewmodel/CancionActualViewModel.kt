package com.example.musicplayer.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musicplayer.R
import com.example.musicplayer.data.model.Cancion

class CancionActualViewModel: ViewModel() {
    val cancion: Cancion = Cancion(
        1,
        "Who Lives, Who Dies, Who Tells Your Story",
        "Hamilton", "Lin Manuel Miranda",
        "Can I show you what I'm proudest of?",
        R.drawable.hamilton
    )
}
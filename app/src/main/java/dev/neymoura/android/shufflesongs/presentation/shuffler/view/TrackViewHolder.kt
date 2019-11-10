package dev.neymoura.android.shufflesongs.presentation.shuffler.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.neymoura.android.shufflesongs.R
import dev.neymoura.android.songsprovider.model.MusicalData
import kotlinx.android.synthetic.main.view_holder_track.view.*

class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun create(parent: ViewGroup): TrackViewHolder {
            return TrackViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.view_holder_track,
                    parent,
                    false
                )
            )
        }
    }

    fun bind(musicalData: MusicalData) {
        with(itemView) {
            trackName.text = musicalData.artistName
        }
    }

}
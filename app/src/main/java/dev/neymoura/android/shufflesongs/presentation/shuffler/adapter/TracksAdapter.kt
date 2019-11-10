package dev.neymoura.android.shufflesongs.presentation.shuffler.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.neymoura.android.shufflesongs.presentation.shuffler.view.TrackViewHolder
import dev.neymoura.android.songsprovider.model.MusicalData

class TracksAdapter : RecyclerView.Adapter<TrackViewHolder>() {

    var items: List<MusicalData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder =
        TrackViewHolder.create(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(items[position])
    }

}
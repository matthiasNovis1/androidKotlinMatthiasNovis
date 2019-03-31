package com.dream.architecturecomponents.ui.launches.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dream.architecturecomponents.R

import com.dream.architecturecomponents.data.Launches


import kotlinx.android.synthetic.main.item_launches.view.*

class LaunchesAdapter: RecyclerView.Adapter<LaunchesAdapter.LaunchesViewHolder>() {

    var onClick: ((item: Launches) -> Unit)? = null
    var onLongClick: ((item: Launches) -> Unit)? = null

    private var data = listOf<Launches>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_launches,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(data[position], object :
            OnMovieClickListener {
            override fun onItemClick(launch: Launches) {
                onClick?.invoke(launches)
            }

            override fun onItemLongClick(launch: Launches) {
                onLongClick?.invoke(launch)
            }
        })
    }

    fun replaceData(newData: List<Launches>) {
        this.data = newData
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(launch: launches, onMovieClickListener: OnMovieClickListener) {
            itemView.title.text = launch.mission_name
            itemView.overview.text = launch.overview
            itemView.root.apply {
                onClick { onMovieClickListener.onItemClick(launch) }
                onLongClick { onMovieClickListener.onItemLongClick(launch) }
            }
        }
    }

    interface OnMovieClickListener {

        fun onItemClick(launch: Launches)

        fun onItemLongClick(launch: Launches)

    }
}
package com.knightshrestha.neonnovels.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.knightshrestha.neonnovels.databinding.FragmentHomeRvItemBinding
import com.knightshrestha.neonnovels.datasources.local.dataclass.LocalSeriesItem
import java.text.SimpleDateFormat
import java.util.Locale

class HomeLocalListAdapter(
    private val values: List<LocalSeriesItem>
) : RecyclerView.Adapter<HomeLocalListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentHomeRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

//    var expandedPosition = -1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.title
        holder.synopsis.text = item.synopsis
        holder.updated.text = "Updated: " + SimpleDateFormat("dd MMMM, yyyy 'at' hh:mm aa", Locale("en", "NP")).format(item.updatedAt)
        Glide.with(holder.itemView.context).load(item.thumbnail).into(holder.thumbnail)

//        val isExpanded: Boolean = position == expandedPosition
//        holder.bookList.visibility = if (isExpanded) View.VISIBLE else View.GONE
//        holder.bookList.text = item.bookList?.joinToString("\n") ?: ""
//        holder.updated.text = item.modifiedAt?.let { Date(it) }.toString()
//        holder.updated.setCompoundDrawablesWithIntrinsicBounds(0,0, if (isExpanded) R.drawable.ic_less else R.drawable.ic_more, 0)
//
//
//        holder.itemView.setOnClickListener {
//            if (expandedPosition >= 0) {
//                notifyItemChanged(expandedPosition)
//            }
//            expandedPosition = if (isExpanded) -1 else position
//            notifyItemChanged(expandedPosition)
//        }
//
//        holder.bookList.setOnClickListener {
//            val action = BookListFragmentDirections.actionBookListFragmentToDetailFragment(item.bookID)
//            holder.itemView.findNavController().navigate(action)
//        }

//        holder.itemView.setOnClickListener {
//            val action = BookListFragmentDirections.actionBookListFragmentToDetailFragment(item.bookID)
//            holder.itemView.findNavController().navigate(action)
//        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentHomeRvItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val title = binding.textTitleRvitemHome
        val updated = binding.textUpdatedRvitemHome
        val synopsis = binding.textSynopsisRvitemHome
        val thumbnail = binding.imageThumbnailRvitemHome
    }

}
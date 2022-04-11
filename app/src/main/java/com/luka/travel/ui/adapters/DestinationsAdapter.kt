import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.luka.travel.R
import com.luka.travel.databinding.ItemPlaceToVisitBinding
import com.luka.travel.model.DestinationPhoto

class DestinationsAdapter(private val placesToVisit: List<DestinationPhoto>) :
    ListAdapter<DestinationPhoto, DestinationsAdapter.SliderViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val binding =
            ItemPlaceToVisitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(binding)

    }


    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {

        holder.bind(placesToVisit[position])
    }


    override fun getItemCount() = placesToVisit.size


    class SliderViewHolder(private val itemPlaceToVisitBinding: ItemPlaceToVisitBinding) :
        RecyclerView.ViewHolder(itemPlaceToVisitBinding.root) {

        fun bind(item: DestinationPhoto) {

            itemPlaceToVisitBinding.imageSlide.load(R.drawable.user_4)
        }

    }

    private class DiffCallback : DiffUtil.ItemCallback<DestinationPhoto>() {
        override fun areItemsTheSame(oldItem: DestinationPhoto, newItem: DestinationPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DestinationPhoto, newItem: DestinationPhoto): Boolean {
            return oldItem == newItem
        }
    }

}

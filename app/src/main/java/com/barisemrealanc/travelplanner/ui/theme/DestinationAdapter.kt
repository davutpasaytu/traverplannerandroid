import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barisemrealanc.travelplanner.databinding.ItemDestinationBinding

data class Destination(
    val title: String,
    val location: String,
    val imageRes: Int
)

class DestinationAdapter(private val destinations: List<Destination>) :
    RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder>() {

    inner class DestinationViewHolder(val binding: ItemDestinationBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val binding = ItemDestinationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DestinationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        val destination = destinations[position]
        holder.binding.apply {
            txtTitle.text = destination.title
            txtLocation.text = destination.location
            imgDestination.setImageResource(destination.imageRes)
        }
    }

    override fun getItemCount(): Int = destinations.size
}

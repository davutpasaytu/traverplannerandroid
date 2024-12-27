import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barisemrealanc.travelplanner.databinding.ItemParkBinding

class ParkAdapter(
    private val parks: List<ParkItem>,
    private val onSaveClick: (ParkItem) -> Unit,
    private val onDetailsClick: (ParkItem) -> Unit
) : RecyclerView.Adapter<ParkAdapter.ParkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val binding = ItemParkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        holder.bind(parks[position])
    }

    override fun getItemCount(): Int = parks.size

    inner class ParkViewHolder(private val binding: ItemParkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(park: ParkItem) {
            // ViewPager2 için ImagePagerAdapter bağlanıyor
            val imagePagerAdapter = ImagePagerAdapter(park.imageList) // imageList görsellerin listesi
            binding.viewPagerImages.adapter = imagePagerAdapter

            // Diğer veriler bağlanıyor
            binding.textViewParkName.text = park.name
            binding.textViewLocation.text = park.location
            binding.textViewRating.text = "★ ${park.rating}"
            binding.textViewDifficulty.text = park.difficulty
            binding.textViewDistance.text = park.distance
            binding.textViewEstimatedTime.text = park.estimatedTime

            // Kaydet butonu
            binding.buttonSave.setOnClickListener {
                onSaveClick(park)
            }

            // Detaylara tıklama
            binding.root.setOnClickListener {
                onDetailsClick(park)
            }
        }
    }
}

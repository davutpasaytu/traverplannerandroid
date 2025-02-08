import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barisemrealanc.travelplanner.databinding.ItemParkBinding

class ParkAdapter(
    private var parks: List<Place>,  // Data türünü Place olarak güncelledik
    private val onSaveClick: (Place) -> Unit,
    private val onDetailsClick: (Place) -> Unit
) : RecyclerView.Adapter<ParkAdapter.ParkViewHolder>() {

    // RecyclerView için ViewHolder oluşturma
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val binding = ItemParkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParkViewHolder(binding)
    }

    // RecyclerView'da her bir öğe için veri bağlama
    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        holder.bind(parks[position])
    }

    // Listedeki öğe sayısını döndürme
    override fun getItemCount(): Int = parks.size

    // Park verisi güncellenirse adapter'ı yeniden yükleme
    fun updatePlaces(newPlaces: List<Place>) {
        parks = newPlaces
        notifyDataSetChanged()  // RecyclerView'ı yeniden yükler
    }

    // ViewHolder sınıfı
    inner class ParkViewHolder(private val binding: ItemParkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(park: Place) {
            // ImagePagerAdapter ile resimleri bağlama
            val imagePagerAdapter = ImagePagerAdapter(park.images)  // images parametresi doğru
            binding.viewPagerImages.adapter = imagePagerAdapter

            // Diğer veriler bağlanıyor
            binding.textViewParkName.text = park.name
            binding.textViewLocation.text = "${park.city}, ${park.country}" // Konum için şehir ve ülke
            binding.textViewRating.text = "★ ${park.averageRating}"  // Ortalama rating
            binding.textViewDifficulty.text = park.category // Örneğin, parkın kategorisini zorluk yerine kullanabilirsin
            binding.textViewDistance.text = "" // Mesafe eklenmediyse, burayı uygun bir şekilde güncelle
            binding.textViewEstimatedTime.text = "" // Zamanı da ekleyebilirsin, eğer varsa

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

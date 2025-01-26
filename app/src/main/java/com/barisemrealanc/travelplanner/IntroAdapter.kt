import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.barisemrealanc.travelplanner.IntroPage
import com.barisemrealanc.travelplanner.databinding.ItemIntroPageBinding

class IntroAdapter(private val pages: List<IntroPage>) :
    RecyclerView.Adapter<IntroAdapter.IntroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        // Binding sınıfını kullanarak layout'u bağlayın
        val binding = ItemIntroPageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.bind(pages[position])
    }

    override fun getItemCount(): Int = pages.size

    inner class IntroViewHolder(private val binding: ItemIntroPageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(page: IntroPage) {
            binding.introImage.setImageResource(page.imageRes)
            binding.introTitle.text = page.title
            binding.introDescription.text = page.description

            binding.root.setBackgroundColor(page.backgroundColor)
        }
    }
}

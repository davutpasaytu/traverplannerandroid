import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide  // Eğer Glide kullanacaksanız, bunu eklemeniz gerekebilir

class ImagePagerAdapter(private val images: List<String>) : RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val imageView = ImageView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            scaleType = ImageView.ScaleType.CENTER_CROP
        }
        return ImageViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size

    inner class ImageViewHolder(private val imageView: ImageView) : RecyclerView.ViewHolder(imageView) {
        fun bind(imageUrl: String) {
            // Glide veya Picasso gibi kütüphaneler ile URL'den görseli yükleyebilirsiniz
            Glide.with(imageView.context)
                .load(imageUrl)  // URL'yi kullanarak görseli yükleyin
                .into(imageView)
        }
    }
}

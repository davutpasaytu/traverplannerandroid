data class Place(
    val _id: String,
    val name: String,
    val city: String,
    val country: String,
    val category: String,
    val description: String,
    val images: List<String>, // Eğer sadece URL'lerden oluşuyorsa, dizi tipinde olmalı
    val location: Location, // 'location' objesi için ayrı bir data class oluşturulmalı
    val averageRating: Double,
    val reviewsCount: Int,
    val createdAt: String,
    val updatedAt: String,
    val __v: Int
)

data class Location(
    val latitude: Double, // Latitude için bir sayı ekleyin
    val longitude: Double // Longitude için bir sayı ekleyin
)

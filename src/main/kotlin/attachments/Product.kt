package attachments


data class Product(
        val price: Price,
)


data class Price(
        val amount: Int,
        val currency: Currency,
        val text: String,
)


data class Currency(
        val id: Int,
        val name: String,
)
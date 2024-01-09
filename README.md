# CoCo

> Retrofit 동작 방식

<br>

```
// 네트워크와 통신할 레트로핏 서비스 인터페이스
interface Api {

    // public/ticker/ALL_KRW
    @GET("public/ticker/ALL_KRW")
    suspend fun getCurrentCoinList() : CurrentPriceList

}

```

```
// 레트로핏 구현 객체
object RetrofitInstance {

    private const val BASE_URL = "https://api.bithumb.com/"

    private val client = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance() : Retrofit {
        return client
    }

}
```
```

// 최종적으로 처음 가저오는 데이터 형태
data class CurrentPriceResult (
    val coinName : String,
    val coinInfo : CurrentPrice
)

```

```
data class CurrentPrice (
    val opening_price : String,
    val closing_price : String,
    val min_price : String,
    val max_price : String,
    val units_traded : String,
    val acc_trade_value : String,
    val prev_closing_price : String,
    val units_traded_24H : String,
    val acc_trade_value_24H : String,
    val fluctate_24H : String,
    val fluctate_rate_24H : String

//    opening_price: "22774000",
//    closing_price: "22558000",
//    min_price: "22380000",
//    max_price: "22897000",
//    units_traded: "2344.25102733",
//    acc_trade_value: "53116336853.7015",
//    prev_closing_price: "22773000",
//    units_traded_24H: "2789.33394039",
//    acc_trade_value_24H: "63274683837.6202",
//    fluctate_24H: "-280000",
//    fluctate_rate_24H: "-1.23"

)

```

![image](https://github.com/chanho0908/CoCo/assets/84930748/8b2e3bd1-2e5b-45a7-a135-d5b5ef7357b7)





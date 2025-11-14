import com.example.musicplayer.data.model.Cancion
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface CancionApi {
    @GET("canciones")
    suspend fun getCanciones(): Response<List<Cancion>>

    @GET("canciones/{id}")
    suspend fun getCancion(@Path("id") id: Int): Response<Cancion>

    @DELETE("canciones/{id}")
    suspend fun deleteCancion(@Path("id") id: Int): Response<Void>

    @Multipart
    @POST("canciones")
    suspend fun createCancion(
        @Part("nombre") nombre: RequestBody,
        @Part("album") album: RequestBody,
        @Part("artista") artista: RequestBody,
        @Part("descripcion") descripcion: RequestBody,
        @Part imagen: MultipartBody.Part? = null
    ): Response<Cancion>

    @Multipart
    @PUT("canciones/{id}")
    suspend fun updateCancion(
        @Path("id") id: Int,
        @Part("nombre") nombre: RequestBody?,
        @Part("album") album: RequestBody?,
        @Part("artista") artista: RequestBody?,
        @Part("descripcion") descripcion: RequestBody?,
        @Part imagen: MultipartBody.Part? = null
    ): Response<Cancion>
}

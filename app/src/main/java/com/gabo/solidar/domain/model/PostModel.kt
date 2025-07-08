import com.gabo.solidar.domain.type.AssistanceArea
import kotlinx.serialization.Serializable

@Serializable
data class PostModel(
    val id: String,
    val author: String,
    val date: String,
    val title: String,
    val description: String,
    val organization: String,
    val profilePicture: String,
    val following: Boolean,
    val likes: Long,
    val comments: Long,
    val shared: Long,
    val pictures: String,
    val assistanceArea: AssistanceArea,
    val verified: Boolean
)

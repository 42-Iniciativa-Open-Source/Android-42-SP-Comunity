package com.debcomp.aql.sp42.feature.home.model.entity
import com.google.gson.annotations.SerializedName

/*
 * Davi Áquila
 * aquiladvx
 *
 * 16/12/2020
 *
 */

data class Cadet(
    val achievements: List<Achievement>,
    @SerializedName("anonymize_date")
    val anonymizeDate: String,
    val campus: List<Campu>,
    @SerializedName("campus_users")
    val campusUsers: List<CampusUser>,
    @SerializedName("correction_point")
    val correctionPoint: Int,
    @SerializedName("cursus_users")
    val cursusUsers: List<CursusUser>,
    val displayname: String,
    val email: String,
    @SerializedName("expertises_users")
    val expertisesUsers: List<ExpertisesUser>,
    @SerializedName("first_name")
    val firstName: String,
    val groups: List<Any>,
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("languages_users")
    val languagesUsers: List<LanguagesUser>,
    @SerializedName("last_name")
    val lastName: String,
    val location: Any,
    val login: String,
    val partnerships: List<Any>,
    val patroned: List<Any>,
    val patroning: List<Any>,
    val phone: String,
    @SerializedName("pool_month")
    val poolMonth: String,
    @SerializedName("pool_year")
    val poolYear: String,
    @SerializedName("projects_users")
    val projectsUsers: List<ProjectsUser>,
    val roles: List<Role>,
    @SerializedName("staff?")
    val staff: Boolean,
    val titles: List<Title>,
    @SerializedName("titles_users")
    val titlesUsers: List<TitlesUser>,
    val url: String,
    @SerializedName("usual_first_name")
    val usualFirstName: Any,
    @SerializedName("usual_full_name")
    val usualFullName: String,
    val wallet: Int
)

data class Achievement(
    val description: String,
    val id: Int,
    val image: String,
    val kind: String,
    val name: String,
    @SerializedName("nbr_of_success")
    val nbrOfSuccess: Any,
    val tier: String,
    @SerializedName("users_url")
    val usersUrl: String,
    val visible: Boolean
)

data class Campu(
    val active: Boolean,
    val address: String,
    val city: String,
    val country: String,
    @SerializedName("email_extension")
    val emailExtension: String,
    val facebook: String,
    val id: Int,
    val language: Language,
    val name: String,
    @SerializedName("time_zone")
    val timeZone: String,
    val twitter: String,
    @SerializedName("users_count")
    val usersCount: Int,
    @SerializedName("vogsphere_id")
    val vogsphereId: Int,
    val website: String,
    val zip: String
)

data class CampusUser(
    @SerializedName("campus_id")
    val campusId: Int,
    val id: Int,
    @SerializedName("is_primary")
    val isPrimary: Boolean,
    @SerializedName("user_id")
    val userId: Int
)

data class CursusUser(
    @SerializedName("begin_at")
    val beginAt: String,
    @SerializedName("blackholed_at")
    val blackholedAt: Any,
    val cursus: Cursus,
    @SerializedName("cursus_id")
    val cursusId: Int,
    @SerializedName("end_at")
    val endAt: String,
    val grade: Any,
    @SerializedName("has_coalition")
    val hasCoalition: Boolean,
    val id: Int,
    val level: Double,
    val skills: List<Skill>,
    val user: User
)

data class ExpertisesUser(
    @SerializedName("contact_me")
    val contactMe: Boolean,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("expertise_id")
    val expertiseId: Int,
    val id: Int,
    val interested: Boolean,
    @SerializedName("user_id")
    val userId: Int,
    val value: Int
)

data class LanguagesUser(
    @SerializedName("created_at")
    val createdAt: String,
    val id: Int,
    @SerializedName("language_id")
    val languageId: Int,
    val position: Int,
    @SerializedName("user_id")
    val userId: Int
)

data class ProjectsUser(
    @SerializedName("current_team_id")
    val currentTeamId: Int,
    @SerializedName("cursus_ids")
    val cursusIds: List<Int>,
    @SerializedName("final_mark")
    val finalMark: Int,
    val id: Int,
    val marked: Boolean,
    @SerializedName("marked_at")
    val markedAt: String,
    val occurrence: Int,
    val project: Project,
    @SerializedName("retriable_at")
    val retriableAt: Any,
    val status: String,
    @SerializedName("validated?")
    val validated: Boolean
)

data class Role(
    val id: Int,
    val name: String
)

data class Title(
    val id: Int,
    val name: String
)

data class TitlesUser(
    val id: Int,
    val selected: Boolean,
    @SerializedName("title_id")
    val titleId: Int,
    @SerializedName("user_id")
    val userId: Int
)

data class Language(
    @SerializedName("created_at")
    val createdAt: String,
    val id: Int,
    val identifier: String,
    val name: String,
    @SerializedName("updated_at")
    val updatedAt: String
)

data class Cursus(
    @SerializedName("created_at")
    val createdAt: String,
    val id: Int,
    val name: String,
    val slug: String
)

data class Skill(
    val id: Int,
    val level: Double,
    val name: String
)

data class Project(
    val id: Int,
    val name: String,
    @SerializedName("parent_id")
    val parentId: Any,
    val slug: String
)
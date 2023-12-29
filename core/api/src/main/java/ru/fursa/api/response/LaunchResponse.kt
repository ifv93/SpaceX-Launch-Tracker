package ru.fursa.api.response

import com.google.gson.annotations.SerializedName

data class LaunchResponse(
    @SerializedName("flight_number") val flightNumber: Int,
    @SerializedName("name") val missionName: String,
    @SerializedName("links") val links: Links,
    @SerializedName("launch_site") val launchSite: LaunchSite? = null,
    @SerializedName("launch_success") val isRocketFailed: Boolean = false
)

data class Links(
    @SerializedName("mission_patch_small") val missionPatchSmall: String,
)

data class LaunchSite(
    @SerializedName("site_name_long") val siteNameLong: String? = null,
    @SerializedName("site_name") val siteNameShort: String? = null,
)
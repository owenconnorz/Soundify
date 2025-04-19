package com.soundify.innertube.pages

import com.soundify.innertube.models.Album
import com.soundify.innertube.models.AlbumItem
import com.soundify.innertube.models.Artist
import com.soundify.innertube.models.ArtistItem
import com.soundify.innertube.models.MusicResponsiveListItemRenderer
import com.soundify.innertube.models.MusicTwoRowItemRenderer
import com.soundify.innertube.models.PlaylistItem
import com.soundify.innertube.models.SongItem
import com.soundify.innertube.models.YTItem
import com.soundify.innertube.models.oddElements
import com.soundify.innertube.utils.parseTime

data class LibraryAlbumsPage(
    val albums: List<AlbumItem>,
    val continuation: String?,
) {
    companion object {
        fun fromMusicTwoRowItemRenderer(renderer: MusicTwoRowItemRenderer): AlbumItem? {
            return AlbumItem(
                        browseId = renderer.navigationEndpoint.browseEndpoint?.browseId ?: return null,
                        playlistId = renderer.thumbnailOverlay?.musicItemThumbnailOverlayRenderer?.content
                            ?.musicPlayButtonRenderer?.playNavigationEndpoint
                            ?.watchPlaylistEndpoint?.playlistId ?: return null,
                        title = renderer.title.runs?.firstOrNull()?.text ?: return null,
                        artists = null,
                        year = renderer.subtitle?.runs?.lastOrNull()?.text?.toIntOrNull(),
                        thumbnail = renderer.thumbnailRenderer.musicThumbnailRenderer?.getThumbnailUrl() ?: return null,
                        explicit = renderer.subtitleBadges?.find {
                            it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
                        } != null
                    )
        }
    }
}

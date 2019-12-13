package dev.neymoura.android.songsprovider.repository.remote

import dev.neymoura.android.songsprovider.commons.Resource
import dev.neymoura.android.songsprovider.model.MusicalData
import dev.neymoura.android.songsprovider.repository.ISongRepository

class FakeSongsProvider : ISongRepository {

    override suspend fun fetchSongs(
        artists: List<Long>,
        songsLimit: Int
    ): Resource<List<MusicalData>> {
        return Resource.success(
            listOf(
                MusicalData(
                    id = 1,
                    wrapperType = "artist",
                    artistId = 1,
                    artistName = "Samus Aran",
                    artworkUrl = "https://lgbtqgamearchive.files.wordpress.com/2015/09/metroid_ending_fin.jpg",
                    trackName = "Zebes",
                    primaryGenreName = "Space Hunter Tracks"
                ),
                MusicalData(
                    id = 2,
                    wrapperType = "artist",
                    artistId = 2,
                    artistName = "Pelé Arantes",
                    artworkUrl = "https://lgbtqgamearchive.files.wordpress.com/2015/09/metroid_ending_fin.jpg",
                    trackName = "Origem do Aran",
                    primaryGenreName = "Space Hunter Origins"
                ),
                MusicalData(
                    id = 3,
                    wrapperType = "track",
                    artistId = 1,
                    artistName = "Samus Aran",
                    artworkUrl = "https://lgbtqgamearchive.files.wordpress.com/2015/09/metroid_ending_fin.jpg",
                    trackName = "Ceres Station",
                    primaryGenreName = "Space Hunter Origins"
                ),
                MusicalData(
                    id = 4,
                    wrapperType = "track",
                    artistId = 2,
                    artistName = "Pelé Arantes",
                    artworkUrl = "https://lgbtqgamearchive.files.wordpress.com/2015/09/metroid_ending_fin.jpg",
                    trackName = "Kraid nails are nasty!",
                    primaryGenreName = "Space Hunter Origins"
                )
            )
        )
    }

}
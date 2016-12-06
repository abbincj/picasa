package net.azib.photos

import org.hamcrest.CoreMatchers.equalTo
import org.jetbrains.spek.api.Spek
import org.junit.Assert.assertThat

class GalleryLoaderTest: Spek({
  val xml = Gallery::class.java.getResourceAsStream("gallery.xml")

  it("parses gallery feed") {
    val gallery = XMLParser(GalleryLoader(212)).parse(xml)
    assertThat(gallery.authorId, equalTo("117440562642491680332"))
    assertThat(gallery.author, equalTo("Anton Keks"))
    assertThat(gallery.timestampISO, equalTo("2016-05-24T19:13:11Z"))
    assertThat(gallery.albums.size, equalTo(1))

    val album = gallery.albums.values.first()
    assertThat(album.id, equalTo("6212669462372660321"))
    assertThat(album.name, equalTo("Chernobyl"))
    assertThat(album.title, equalTo("Chernobyl"))
    assertThat(album.description, equalTo("Apocalyptic experience in Chernobyl and Pripyat, a soviet city abandoned in 1986 after the nuclear disaster. Current radiation levels are compatible with life :-)"))
    assertThat(album.author, equalTo("Anton Keks"))
    assertThat(album.isPublic, equalTo(true))
    assertThat(album.thumbUrl, equalTo("https://lh3.googleusercontent.com/-EfV7Xxjk3gk/VjfV9bujtGE/AAAAAAABKUY/gQBUlooE9lsYdyZ1O7ciOiGo-5pch3_DQCHM/s212-c/Chernobyl.jpg"))
    assertThat(album.timestampISO, equalTo("2015-11-05T21:37:39Z"))
    assertThat(album.geo!!.lat, equalTo(51.276303f))
    assertThat(album.geo!!.lon, equalTo(30.221899f))
    assertThat(album.size(), equalTo(159))
  }
})
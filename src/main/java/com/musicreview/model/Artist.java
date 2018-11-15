
package com.musicreview.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@Column(name = "artist_firstname")
    private String artist_firstname;

    @Column(name = "artist_secondname")
    private String artist_secondname;

    @Column(name = "artist_nickname")
    private String artist_nickname;


    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "artist_recordlabel", joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<RecordLabel> recordLabels;

    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable (name = "artist_musicrelease", joinColumns = @JoinColumn (name = "artist_id"),
    inverseJoinColumns = @JoinColumn (name = "musicrelease_id"))
    private Set <MusicRelease> musicReleaseSet;
  
    public Artist(String artist_firstname, String artist_secondname, String artist_nickname) {
        this.artist_firstname = artist_firstname;
        this.artist_secondname = artist_secondname;
        this.artist_nickname = artist_nickname;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArtist_firstname() {
		return artist_firstname;
	}

	public void setArtist_firstname(String artist_firstname) {
		this.artist_firstname = artist_firstname;
	}

	public String getArtist_secondname() {
		return artist_secondname;
	}

	public void setArtist_secondname(String artist_secondname) {
		this.artist_secondname = artist_secondname;
	}

	public String getArtist_nickname() {
		return artist_nickname;
	}

	public void setArtist_nickname(String artist_nickname) {
		this.artist_nickname = artist_nickname;
	}

	public Set<RecordLabel> getRecordLabels() {
		return recordLabels;
	}

	public void setRecordLabels(Set<RecordLabel> recordLabels) {
		this.recordLabels = recordLabels;
	}

	public Set<MusicRelease> getMusicReleaseSet() {
		return musicReleaseSet;
	}

	public void setMusicReleaseSet(Set<MusicRelease> musicReleaseSet) {
		this.musicReleaseSet = musicReleaseSet;
	}
    
  
}


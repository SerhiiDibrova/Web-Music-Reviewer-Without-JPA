package com.musicreview.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="record_label")
public class RecordLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "label_name")
    private String label_name;

    @Column(name = "label_country")
    private String label_country;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "artist_recordlabel", joinColumns = @JoinColumn(name = "label_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<Artist> artistsList;

    public RecordLabel(String label_name, String label_country) {
        this.label_name = label_name;
        this.label_country = label_country;
    }

    public RecordLabel(String label_name) {
        this.label_name = label_name;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel_name() {
		return label_name;
	}

	public void setLabel_name(String label_name) {
		this.label_name = label_name;
	}

	public String getLabel_country() {
		return label_country;
	}

	public void setLabel_country(String label_country) {
		this.label_country = label_country;
	}

	public Set<Artist> getArtistsList() {
		return artistsList;
	}

	public void setArtistsList(Set<Artist> artistsList) {
		this.artistsList = artistsList;
	}


    
    
}



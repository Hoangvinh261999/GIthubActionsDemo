package com.poly.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name="Videos")
@NamedQueries({
@NamedQuery(name = "Video.findByKeyword",
query = "SELECT DISTINCT o.video FROM Favorite o"
+ " WHERE o.video.title LIKE :keyword"),
@NamedQuery(name = "Video.findByUser",
query = "SELECT o.video FROM Favorite o"
+ " WHERE o.user.id=:id"),
@NamedQuery(
        name = "Video.findInRange",
        query = "SELECT DISTINCT o FROM Video o JOIN o.favorites f"
            + " WHERE f.likeDate BETWEEN :min AND :max"
    )


})
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "Video.findInMonths",
        query = "SELECT DISTINCT v.* FROM Videos v "
                + "JOIN Favorites f ON v.id = f.videoId "
                + "WHERE MONTH(f.likeDate) IN (:months)",
        resultClass = Video.class
    ),
    @NamedNativeQuery(
        name = "Report.random10",
        query = "SELECT TOP 10 * FROM Videos ORDER BY newid()", 
        resultClass = Video.class
    )
})
public class Video {
	@Id
	String Id;
	String title;
	String poster;
	String description;
	Integer views;
	Boolean active= true;
	@OneToMany(mappedBy = "video")
	List<Favorite> favorites;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<Favorite> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	
}

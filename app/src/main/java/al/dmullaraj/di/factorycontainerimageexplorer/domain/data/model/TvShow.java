package al.dmullaraj.di.factorycontainerimageexplorer.domain.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by denis.mullaraj on 22/02/2018.
 */

public class TvShow implements Parcelable{

    private String poster_path;
    private Double popularity;
    private Integer id;
    private String backdrop_path;
    private Double vote_average;
    private String overview;
    private String first_air_date;
    private List<String> origin_country;
    private List<Integer> genre_ids;
    private String original_language;
    private Integer vote_count;
    private String name;
    private String original_name;
    private final String base_url = "https://image.tmdb.org/t/p/";

    public String getLowResImageUrl(){
        return base_url + "/w92" + getPoster_path();
    }

    public String getHighResImageUrl(){
        return base_url + "/w500" + getPoster_path();
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    protected TvShow(Parcel in) {
        poster_path = in.readString();
        popularity = in.readByte() == 0x00 ? null : in.readDouble();
        id = in.readByte() == 0x00 ? null : in.readInt();
        backdrop_path = in.readString();
        vote_average = in.readByte() == 0x00 ? null : in.readDouble();
        overview = in.readString();
        first_air_date = in.readString();
        if (in.readByte() == 0x01) {
            origin_country = new ArrayList<>();
            in.readList(origin_country, String.class.getClassLoader());
        } else {
            origin_country = null;
        }
        if (in.readByte() == 0x01) {
            genre_ids = new ArrayList<>();
            in.readList(genre_ids, Integer.class.getClassLoader());
        } else {
            genre_ids = null;
        }
        original_language = in.readString();
        vote_count = in.readByte() == 0x00 ? null : in.readInt();
        name = in.readString();
        original_name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(poster_path);
        if (popularity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(popularity);
        }
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id);
        }
        dest.writeString(backdrop_path);
        if (vote_average == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(vote_average);
        }
        dest.writeString(overview);
        dest.writeString(first_air_date);
        if (origin_country == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(origin_country);
        }
        if (genre_ids == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(genre_ids);
        }
        dest.writeString(original_language);
        if (vote_count == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(vote_count);
        }
        dest.writeString(name);
        dest.writeString(original_name);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if(!(obj instanceof TvShow)) return false;

        TvShow tvShow = (TvShow) obj;

        if(poster_path != null ? !poster_path.equals(tvShow.poster_path) : tvShow.poster_path != null) return false;
        if(popularity != null ? !popularity.equals(tvShow.popularity) : tvShow.popularity != null) return false;
        if(id != null ? !id.equals(tvShow.id) : tvShow.id != null) return false;
        if(backdrop_path != null ? !backdrop_path.equals(tvShow.backdrop_path) : tvShow.backdrop_path != null) return false;
        if(vote_average != null ? !vote_average.equals(tvShow.vote_average) : tvShow.vote_average != null) return false;
        if(overview != null ? !overview.equals(tvShow.overview) : tvShow.overview != null) return false;
        if(first_air_date != null ? !first_air_date.equals(tvShow.first_air_date) : tvShow.first_air_date != null) return false;
        if(origin_country != null ? !origin_country.equals(tvShow.origin_country) : tvShow.origin_country != null) return false;
        if(genre_ids != null ? !genre_ids.equals(tvShow.genre_ids) : tvShow.genre_ids != null) return false;
        if(original_language != null ? !original_language.equals(tvShow.original_language) : tvShow.original_language != null) return false;
        if(vote_count != null ? !vote_count.equals(tvShow.vote_count) : tvShow.vote_count != null) return false;
        if(name != null ? !name.equals(tvShow.name) : tvShow.name != null) return false;
        if(original_name != null ? !original_name.equals(tvShow.original_name) : tvShow.original_name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                poster_path,
                popularity,
                id,
                backdrop_path,
                vote_average,
                overview,
                first_air_date,
                origin_country,
                genre_ids,
                original_language,
                vote_count,
                name,
                original_name);
    }
}
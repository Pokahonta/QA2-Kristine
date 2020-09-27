package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)  //
public class Response {
    private Coord coord;

    @JsonProperty("weather") //ukazivaem, chto java"Weathers" budet v json nazivatjsa"weather"
    private List<Weather> weathers;
    private String base;
    private Main main;
    private int visibility;
    @JsonProperty("wind")
    private Wind winds;
    private Cloud clouds;
    private int dt;
    private Sys sys;
    private int id;
    private String name;
    private int cod;

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWinds() {
        return winds;
    }

    public void setWinds(Wind winds) {
        this.winds = winds;
    }

    public Cloud getClouds() {
        return clouds;
    }

    public void setClouds(Cloud clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Cloud getCloud() {
        return cloud;
    }

    public void setCloud(Cloud cloud) {
        this.cloud = cloud;
    }

    private Cloud cloud;


    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}

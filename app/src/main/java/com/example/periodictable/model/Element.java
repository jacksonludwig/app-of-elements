package com.example.periodictable.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "appearance",
        "atomic_mass",
        "boil",
        "category",
        "color",
        "density",
        "discovered_by",
        "melt",
        "molar_heat",
        "named_by",
        "number",
        "period",
        "phase",
        "source",
        "spectral_img",
        "summary",
        "symbol",
        "xpos",
        "ypos",
        "shells",
        "electron_configuration",
        "electron_affinity",
        "electronegativity_pauling",
        "ionization_energies"
})
public class Element implements Serializable {

    private final static long serialVersionUID = -4154376710730116681L;
    @JsonProperty("name")
    private String name;
    @JsonProperty("appearance")
    private Object appearance;
    @JsonProperty("atomic_mass")
    private Integer atomicMass;
    @JsonProperty("boil")
    private Integer boil;
    @JsonProperty("category")
    private String category;
    @JsonProperty("color")
    private Object color;
    @JsonProperty("density")
    private Integer density;
    @JsonProperty("discovered_by")
    private String discoveredBy;
    @JsonProperty("melt")
    private Object melt;
    @JsonProperty("molar_heat")
    private Object molarHeat;
    @JsonProperty("named_by")
    private Object namedBy;
    @JsonProperty("number")
    private Integer number;
    @JsonProperty("period")
    private Integer period;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("source")
    private String source;
    @JsonProperty("spectral_img")
    private Object spectralImg;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("xpos")
    private Integer xpos;
    @JsonProperty("ypos")
    private Integer ypos;
    @JsonProperty("shells")
    private List<Integer> shells = null;
    @JsonProperty("electron_configuration")
    private String electronConfiguration;
    @JsonProperty("electron_affinity")
    private Double electronAffinity;
    @JsonProperty("electronegativity_pauling")
    private Object electronegativityPauling;
    @JsonProperty("ionization_energies")
    private List<Double> ionizationEnergies = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("appearance")
    public Object getAppearance() {
        return appearance;
    }

    @JsonProperty("appearance")
    public void setAppearance(Object appearance) {
        this.appearance = appearance;
    }

    @JsonProperty("atomic_mass")
    public Integer getAtomicMass() {
        return atomicMass;
    }

    @JsonProperty("atomic_mass")
    public void setAtomicMass(Integer atomicMass) {
        this.atomicMass = atomicMass;
    }

    @JsonProperty("boil")
    public Integer getBoil() {
        return boil;
    }

    @JsonProperty("boil")
    public void setBoil(Integer boil) {
        this.boil = boil;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("color")
    public Object getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(Object color) {
        this.color = color;
    }

    @JsonProperty("density")
    public Integer getDensity() {
        return density;
    }

    @JsonProperty("density")
    public void setDensity(Integer density) {
        this.density = density;
    }

    @JsonProperty("discovered_by")
    public String getDiscoveredBy() {
        return discoveredBy;
    }

    @JsonProperty("discovered_by")
    public void setDiscoveredBy(String discoveredBy) {
        this.discoveredBy = discoveredBy;
    }

    @JsonProperty("melt")
    public Object getMelt() {
        return melt;
    }

    @JsonProperty("melt")
    public void setMelt(Object melt) {
        this.melt = melt;
    }

    @JsonProperty("molar_heat")
    public Object getMolarHeat() {
        return molarHeat;
    }

    @JsonProperty("molar_heat")
    public void setMolarHeat(Object molarHeat) {
        this.molarHeat = molarHeat;
    }

    @JsonProperty("named_by")
    public Object getNamedBy() {
        return namedBy;
    }

    @JsonProperty("named_by")
    public void setNamedBy(Object namedBy) {
        this.namedBy = namedBy;
    }

    @JsonProperty("number")
    public Integer getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(Integer number) {
        this.number = number;
    }

    @JsonProperty("period")
    public Integer getPeriod() {
        return period;
    }

    @JsonProperty("period")
    public void setPeriod(Integer period) {
        this.period = period;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("spectral_img")
    public Object getSpectralImg() {
        return spectralImg;
    }

    @JsonProperty("spectral_img")
    public void setSpectralImg(Object spectralImg) {
        this.spectralImg = spectralImg;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("xpos")
    public Integer getXpos() {
        return xpos;
    }

    @JsonProperty("xpos")
    public void setXpos(Integer xpos) {
        this.xpos = xpos;
    }

    @JsonProperty("ypos")
    public Integer getYpos() {
        return ypos;
    }

    @JsonProperty("ypos")
    public void setYpos(Integer ypos) {
        this.ypos = ypos;
    }

    @JsonProperty("shells")
    public List<Integer> getShells() {
        return shells;
    }

    @JsonProperty("shells")
    public void setShells(List<Integer> shells) {
        this.shells = shells;
    }

    @JsonProperty("electron_configuration")
    public String getElectronConfiguration() {
        return electronConfiguration;
    }

    @JsonProperty("electron_configuration")
    public void setElectronConfiguration(String electronConfiguration) {
        this.electronConfiguration = electronConfiguration;
    }

    @JsonProperty("electron_affinity")
    public Double getElectronAffinity() {
        return electronAffinity;
    }

    @JsonProperty("electron_affinity")
    public void setElectronAffinity(Double electronAffinity) {
        this.electronAffinity = electronAffinity;
    }

    @JsonProperty("electronegativity_pauling")
    public Object getElectronegativityPauling() {
        return electronegativityPauling;
    }

    @JsonProperty("electronegativity_pauling")
    public void setElectronegativityPauling(Object electronegativityPauling) {
        this.electronegativityPauling = electronegativityPauling;
    }

    @JsonProperty("ionization_energies")
    public List<Double> getIonizationEnergies() {
        return ionizationEnergies;
    }

    @JsonProperty("ionization_energies")
    public void setIonizationEnergies(List<Double> ionizationEnergies) {
        this.ionizationEnergies = ionizationEnergies;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("appearance", appearance).append("atomicMass", atomicMass).append("boil", boil).append("category", category).append("color", color).append("density", density).append("discoveredBy", discoveredBy).append("melt", melt).append("molarHeat", molarHeat).append("namedBy", namedBy).append("number", number).append("period", period).append("phase", phase).append("source", source).append("spectralImg", spectralImg).append("summary", summary).append("symbol", symbol).append("xpos", xpos).append("ypos", ypos).append("shells", shells).append("electronConfiguration", electronConfiguration).append("electronAffinity", electronAffinity).append("electronegativityPauling", electronegativityPauling).append("ionizationEnergies", ionizationEnergies).append("additionalProperties", additionalProperties).toString();
    }

}

package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-11T07:30:28.396Z")
public class LigandDetails   {
  
  private Integer ligandID = null;
  private String pDBCode = null;
  private String name = null;
  private String SMILES = null;
  private String inChIKey = null;

  
  /**
   * KLIFS ID for a specific kinase structure
   **/
  public LigandDetails ligandID(Integer ligandID) {
    this.ligandID = ligandID;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "KLIFS ID for a specific kinase structure")
  @JsonProperty("ligand_ID")
  public Integer getLigandID() {
    return ligandID;
  }
  public void setLigandID(Integer ligandID) {
    this.ligandID = ligandID;
  }

  
  /**
   * 3-letter PDB-code for a specific ligand
   **/
  public LigandDetails pDBCode(String pDBCode) {
    this.pDBCode = pDBCode;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "3-letter PDB-code for a specific ligand")
  @JsonProperty("PDB-code")
  public String getPDBCode() {
    return pDBCode;
  }
  public void setPDBCode(String pDBCode) {
    this.pDBCode = pDBCode;
  }

  
  /**
   * Name of the ligand
   **/
  public LigandDetails name(String name) {
    this.name = name;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Name of the ligand")
  @JsonProperty("Name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * SMILES code for a specific ligand
   **/
  public LigandDetails SMILES(String SMILES) {
    this.SMILES = SMILES;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "SMILES code for a specific ligand")
  @JsonProperty("SMILES")
  public String getSMILES() {
    return SMILES;
  }
  public void setSMILES(String SMILES) {
    this.SMILES = SMILES;
  }

  
  /**
   * InChiKey of a specific ligand
   **/
  public LigandDetails inChIKey(String inChIKey) {
    this.inChIKey = inChIKey;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "InChiKey of a specific ligand")
  @JsonProperty("InChIKey")
  public String getInChIKey() {
    return inChIKey;
  }
  public void setInChIKey(String inChIKey) {
    this.inChIKey = inChIKey;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LigandDetails ligandDetails = (LigandDetails) o;
    return Objects.equals(this.ligandID, ligandDetails.ligandID) &&
        Objects.equals(this.pDBCode, ligandDetails.pDBCode) &&
        Objects.equals(this.name, ligandDetails.name) &&
        Objects.equals(this.SMILES, ligandDetails.SMILES) &&
        Objects.equals(this.inChIKey, ligandDetails.inChIKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ligandID, pDBCode, name, SMILES, inChIKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LigandDetails {\n");
    
    sb.append("    ligandID: ").append(toIndentedString(ligandID)).append("\n");
    sb.append("    pDBCode: ").append(toIndentedString(pDBCode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    SMILES: ").append(toIndentedString(SMILES)).append("\n");
    sb.append("    inChIKey: ").append(toIndentedString(inChIKey)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


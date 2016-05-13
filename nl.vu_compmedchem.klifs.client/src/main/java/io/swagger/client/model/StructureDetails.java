package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-05-13T12:15:53.243Z")
public class StructureDetails   {
  
  private Integer structureID = null;
  private String kinase = null;
  private String species = null;
  private Integer kinaseID = null;
  private String pdb = null;
  private String alt = null;
  private String chain = null;
  private Float rmsd1 = null;
  private Float rmsd2 = null;
  private String pocket = null;
  private Float resolution = null;
  private Float qualityScore = null;
  private Integer missingResidues = null;
  private Integer missingAtoms = null;
  private String ligand = null;
  private String allostericLigand = null;
  private String DFG = null;
  private String aCHelix = null;
  private Float grichDistance = null;
  private Float grichAngle = null;
  private Float grichRotation = null;
  private Boolean front = null;
  private Boolean gate = null;
  private Boolean back = null;
  private Boolean fpI = null;
  private Boolean fpII = null;
  private Boolean bpIA = null;
  private Boolean bpIB = null;
  private Boolean bpIIIn = null;
  private Boolean bpIIAIn = null;
  private Boolean bpIIBIn = null;
  private Boolean bpIIOut = null;
  private Boolean bpIIB = null;
  private Boolean bpIII = null;
  private Boolean bpIV = null;
  private Boolean bpV = null;

  
  /**
   * KLIFS ID for a specific kinase structure
   **/
  public StructureDetails structureID(Integer structureID) {
    this.structureID = structureID;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "KLIFS ID for a specific kinase structure")
  @JsonProperty("structure_ID")
  public Integer getStructureID() {
    return structureID;
  }
  public void setStructureID(Integer structureID) {
    this.structureID = structureID;
  }

  
  /**
   * HGNC gene symbol for a specific kinase structure
   **/
  public StructureDetails kinase(String kinase) {
    this.kinase = kinase;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "HGNC gene symbol for a specific kinase structure")
  @JsonProperty("kinase")
  public String getKinase() {
    return kinase;
  }
  public void setKinase(String kinase) {
    this.kinase = kinase;
  }

  
  /**
   * Species of a specific kinase structure (e.g. human)
   **/
  public StructureDetails species(String species) {
    this.species = species;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "Species of a specific kinase structure (e.g. human)")
  @JsonProperty("species")
  public String getSpecies() {
    return species;
  }
  public void setSpecies(String species) {
    this.species = species;
  }

  
  /**
   * KLIFS ID for a specific kinase
   **/
  public StructureDetails kinaseID(Integer kinaseID) {
    this.kinaseID = kinaseID;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "KLIFS ID for a specific kinase")
  @JsonProperty("kinase_ID")
  public Integer getKinaseID() {
    return kinaseID;
  }
  public void setKinaseID(Integer kinaseID) {
    this.kinaseID = kinaseID;
  }

  
  /**
   * 4-letter PDB-code for a given structure
   **/
  public StructureDetails pdb(String pdb) {
    this.pdb = pdb;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "4-letter PDB-code for a given structure")
  @JsonProperty("pdb")
  public String getPdb() {
    return pdb;
  }
  public void setPdb(String pdb) {
    this.pdb = pdb;
  }

  
  /**
   * Indicates the (alternate) model of the given structure
   **/
  public StructureDetails alt(String alt) {
    this.alt = alt;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Indicates the (alternate) model of the given structure")
  @JsonProperty("alt")
  public String getAlt() {
    return alt;
  }
  public void setAlt(String alt) {
    this.alt = alt;
  }

  
  /**
   * Indicates the chain of the given structure
   **/
  public StructureDetails chain(String chain) {
    this.chain = chain;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "Indicates the chain of the given structure")
  @JsonProperty("chain")
  public String getChain() {
    return chain;
  }
  public void setChain(String chain) {
    this.chain = chain;
  }

  
  /**
   * RMSD compared to the reference template for the superpose pocket
   **/
  public StructureDetails rmsd1(Float rmsd1) {
    this.rmsd1 = rmsd1;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "RMSD compared to the reference template for the superpose pocket")
  @JsonProperty("rmsd1")
  public Float getRmsd1() {
    return rmsd1;
  }
  public void setRmsd1(Float rmsd1) {
    this.rmsd1 = rmsd1;
  }

  
  /**
   * RMSD compared to the reference template for the full pocket
   **/
  public StructureDetails rmsd2(Float rmsd2) {
    this.rmsd2 = rmsd2;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "RMSD compared to the reference template for the full pocket")
  @JsonProperty("rmsd2")
  public Float getRmsd2() {
    return rmsd2;
  }
  public void setRmsd2(Float rmsd2) {
    this.rmsd2 = rmsd2;
  }

  
  /**
   * Alignment of the 85 pocket residues
   **/
  public StructureDetails pocket(String pocket) {
    this.pocket = pocket;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "Alignment of the 85 pocket residues")
  @JsonProperty("pocket")
  public String getPocket() {
    return pocket;
  }
  public void setPocket(String pocket) {
    this.pocket = pocket;
  }

  
  /**
   * Resolution of the crystal struture
   **/
  public StructureDetails resolution(Float resolution) {
    this.resolution = resolution;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Resolution of the crystal struture")
  @JsonProperty("resolution")
  public Float getResolution() {
    return resolution;
  }
  public void setResolution(Float resolution) {
    this.resolution = resolution;
  }

  
  /**
   * The quality score estimates the quality of the structure with respect to the binding pocket as well as the quality of the processing by KLIFS.
   **/
  public StructureDetails qualityScore(Float qualityScore) {
    this.qualityScore = qualityScore;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "The quality score estimates the quality of the structure with respect to the binding pocket as well as the quality of the processing by KLIFS.")
  @JsonProperty("quality_score")
  public Float getQualityScore() {
    return qualityScore;
  }
  public void setQualityScore(Float qualityScore) {
    this.qualityScore = qualityScore;
  }

  
  /**
   * Number of residues missing in the pocket
   **/
  public StructureDetails missingResidues(Integer missingResidues) {
    this.missingResidues = missingResidues;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "Number of residues missing in the pocket")
  @JsonProperty("missing_residues")
  public Integer getMissingResidues() {
    return missingResidues;
  }
  public void setMissingResidues(Integer missingResidues) {
    this.missingResidues = missingResidues;
  }

  
  /**
   * Number of atoms missing from pocket residues (not including the missing residues)
   **/
  public StructureDetails missingAtoms(Integer missingAtoms) {
    this.missingAtoms = missingAtoms;
    return this;
  }
  
  @ApiModelProperty(example = "null", required = true, value = "Number of atoms missing from pocket residues (not including the missing residues)")
  @JsonProperty("missing_atoms")
  public Integer getMissingAtoms() {
    return missingAtoms;
  }
  public void setMissingAtoms(Integer missingAtoms) {
    this.missingAtoms = missingAtoms;
  }

  
  /**
   * 3-letter PDB-code of the ligand within the main pocket
   **/
  public StructureDetails ligand(String ligand) {
    this.ligand = ligand;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "3-letter PDB-code of the ligand within the main pocket")
  @JsonProperty("ligand")
  public String getLigand() {
    return ligand;
  }
  public void setLigand(String ligand) {
    this.ligand = ligand;
  }

  
  /**
   * 3-letter PDB-code of the ligand outside the main pocket
   **/
  public StructureDetails allostericLigand(String allostericLigand) {
    this.allostericLigand = allostericLigand;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "3-letter PDB-code of the ligand outside the main pocket")
  @JsonProperty("allosteric_ligand")
  public String getAllostericLigand() {
    return allostericLigand;
  }
  public void setAllostericLigand(String allostericLigand) {
    this.allostericLigand = allostericLigand;
  }

  
  /**
   * Conformation of the DFG motif
   **/
  public StructureDetails DFG(String DFG) {
    this.DFG = DFG;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Conformation of the DFG motif")
  @JsonProperty("DFG")
  public String getDFG() {
    return DFG;
  }
  public void setDFG(String DFG) {
    this.DFG = DFG;
  }

  
  /**
   * Conformation of the alpha-C helix
   **/
  public StructureDetails aCHelix(String aCHelix) {
    this.aCHelix = aCHelix;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Conformation of the alpha-C helix")
  @JsonProperty("aC_helix")
  public String getACHelix() {
    return aCHelix;
  }
  public void setACHelix(String aCHelix) {
    this.aCHelix = aCHelix;
  }

  
  /**
   * Conformation of the G-rich loop - distance
   **/
  public StructureDetails grichDistance(Float grichDistance) {
    this.grichDistance = grichDistance;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Conformation of the G-rich loop - distance")
  @JsonProperty("Grich_distance")
  public Float getGrichDistance() {
    return grichDistance;
  }
  public void setGrichDistance(Float grichDistance) {
    this.grichDistance = grichDistance;
  }

  
  /**
   * Conformation of the G-rich loop - angle
   **/
  public StructureDetails grichAngle(Float grichAngle) {
    this.grichAngle = grichAngle;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Conformation of the G-rich loop - angle")
  @JsonProperty("Grich_angle")
  public Float getGrichAngle() {
    return grichAngle;
  }
  public void setGrichAngle(Float grichAngle) {
    this.grichAngle = grichAngle;
  }

  
  /**
   * Conformation of the G-rich loop - rotation
   **/
  public StructureDetails grichRotation(Float grichRotation) {
    this.grichRotation = grichRotation;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Conformation of the G-rich loop - rotation")
  @JsonProperty("Grich_rotation")
  public Float getGrichRotation() {
    return grichRotation;
  }
  public void setGrichRotation(Float grichRotation) {
    this.grichRotation = grichRotation;
  }

  
  /**
   * The ligand binds to the front pocket
   **/
  public StructureDetails front(Boolean front) {
    this.front = front;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to the front pocket")
  @JsonProperty("front")
  public Boolean getFront() {
    return front;
  }
  public void setFront(Boolean front) {
    this.front = front;
  }

  
  /**
   * The ligand binds to the gate area
   **/
  public StructureDetails gate(Boolean gate) {
    this.gate = gate;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to the gate area")
  @JsonProperty("gate")
  public Boolean getGate() {
    return gate;
  }
  public void setGate(Boolean gate) {
    this.gate = gate;
  }

  
  /**
   * The ligand binds to the back pocket
   **/
  public StructureDetails back(Boolean back) {
    this.back = back;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to the back pocket")
  @JsonProperty("back")
  public Boolean getBack() {
    return back;
  }
  public void setBack(Boolean back) {
    this.back = back;
  }

  
  /**
   * The ligand binds to FP-I
   **/
  public StructureDetails fpI(Boolean fpI) {
    this.fpI = fpI;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to FP-I")
  @JsonProperty("fp_I")
  public Boolean getFpI() {
    return fpI;
  }
  public void setFpI(Boolean fpI) {
    this.fpI = fpI;
  }

  
  /**
   * The ligand binds to FP-II
   **/
  public StructureDetails fpII(Boolean fpII) {
    this.fpII = fpII;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to FP-II")
  @JsonProperty("fp_II")
  public Boolean getFpII() {
    return fpII;
  }
  public void setFpII(Boolean fpII) {
    this.fpII = fpII;
  }

  
  /**
   * The ligand binds to BP-I-A
   **/
  public StructureDetails bpIA(Boolean bpIA) {
    this.bpIA = bpIA;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to BP-I-A")
  @JsonProperty("bp_I_A")
  public Boolean getBpIA() {
    return bpIA;
  }
  public void setBpIA(Boolean bpIA) {
    this.bpIA = bpIA;
  }

  
  /**
   * The ligand binds to BP-I-B
   **/
  public StructureDetails bpIB(Boolean bpIB) {
    this.bpIB = bpIB;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to BP-I-B")
  @JsonProperty("bp_I_B")
  public Boolean getBpIB() {
    return bpIB;
  }
  public void setBpIB(Boolean bpIB) {
    this.bpIB = bpIB;
  }

  
  /**
   * The ligand binds to BP-II-in
   **/
  public StructureDetails bpIIIn(Boolean bpIIIn) {
    this.bpIIIn = bpIIIn;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to BP-II-in")
  @JsonProperty("bp_II_in")
  public Boolean getBpIIIn() {
    return bpIIIn;
  }
  public void setBpIIIn(Boolean bpIIIn) {
    this.bpIIIn = bpIIIn;
  }

  
  /**
   * The ligand binds to BP-II-A-in
   **/
  public StructureDetails bpIIAIn(Boolean bpIIAIn) {
    this.bpIIAIn = bpIIAIn;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to BP-II-A-in")
  @JsonProperty("bp_II_A_in")
  public Boolean getBpIIAIn() {
    return bpIIAIn;
  }
  public void setBpIIAIn(Boolean bpIIAIn) {
    this.bpIIAIn = bpIIAIn;
  }

  
  /**
   * The ligand binds to BP-II-B-in
   **/
  public StructureDetails bpIIBIn(Boolean bpIIBIn) {
    this.bpIIBIn = bpIIBIn;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to BP-II-B-in")
  @JsonProperty("bp_II_B_in")
  public Boolean getBpIIBIn() {
    return bpIIBIn;
  }
  public void setBpIIBIn(Boolean bpIIBIn) {
    this.bpIIBIn = bpIIBIn;
  }

  
  /**
   * The ligand binds to BP-II-out
   **/
  public StructureDetails bpIIOut(Boolean bpIIOut) {
    this.bpIIOut = bpIIOut;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to BP-II-out")
  @JsonProperty("bp_II_out")
  public Boolean getBpIIOut() {
    return bpIIOut;
  }
  public void setBpIIOut(Boolean bpIIOut) {
    this.bpIIOut = bpIIOut;
  }

  
  /**
   * The ligand binds to BP-II-B
   **/
  public StructureDetails bpIIB(Boolean bpIIB) {
    this.bpIIB = bpIIB;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to BP-II-B")
  @JsonProperty("bp_II_B")
  public Boolean getBpIIB() {
    return bpIIB;
  }
  public void setBpIIB(Boolean bpIIB) {
    this.bpIIB = bpIIB;
  }

  
  /**
   * The ligand binds to BP-III
   **/
  public StructureDetails bpIII(Boolean bpIII) {
    this.bpIII = bpIII;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to BP-III")
  @JsonProperty("bp_III")
  public Boolean getBpIII() {
    return bpIII;
  }
  public void setBpIII(Boolean bpIII) {
    this.bpIII = bpIII;
  }

  
  /**
   * The ligand binds to BP-IV
   **/
  public StructureDetails bpIV(Boolean bpIV) {
    this.bpIV = bpIV;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to BP-IV")
  @JsonProperty("bp_IV")
  public Boolean getBpIV() {
    return bpIV;
  }
  public void setBpIV(Boolean bpIV) {
    this.bpIV = bpIV;
  }

  
  /**
   * The ligand binds to BP-V
   **/
  public StructureDetails bpV(Boolean bpV) {
    this.bpV = bpV;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "The ligand binds to BP-V")
  @JsonProperty("bp_V")
  public Boolean getBpV() {
    return bpV;
  }
  public void setBpV(Boolean bpV) {
    this.bpV = bpV;
  }

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StructureDetails structureDetails = (StructureDetails) o;
    return Objects.equals(this.structureID, structureDetails.structureID) &&
        Objects.equals(this.kinase, structureDetails.kinase) &&
        Objects.equals(this.species, structureDetails.species) &&
        Objects.equals(this.kinaseID, structureDetails.kinaseID) &&
        Objects.equals(this.pdb, structureDetails.pdb) &&
        Objects.equals(this.alt, structureDetails.alt) &&
        Objects.equals(this.chain, structureDetails.chain) &&
        Objects.equals(this.rmsd1, structureDetails.rmsd1) &&
        Objects.equals(this.rmsd2, structureDetails.rmsd2) &&
        Objects.equals(this.pocket, structureDetails.pocket) &&
        Objects.equals(this.resolution, structureDetails.resolution) &&
        Objects.equals(this.qualityScore, structureDetails.qualityScore) &&
        Objects.equals(this.missingResidues, structureDetails.missingResidues) &&
        Objects.equals(this.missingAtoms, structureDetails.missingAtoms) &&
        Objects.equals(this.ligand, structureDetails.ligand) &&
        Objects.equals(this.allostericLigand, structureDetails.allostericLigand) &&
        Objects.equals(this.DFG, structureDetails.DFG) &&
        Objects.equals(this.aCHelix, structureDetails.aCHelix) &&
        Objects.equals(this.grichDistance, structureDetails.grichDistance) &&
        Objects.equals(this.grichAngle, structureDetails.grichAngle) &&
        Objects.equals(this.grichRotation, structureDetails.grichRotation) &&
        Objects.equals(this.front, structureDetails.front) &&
        Objects.equals(this.gate, structureDetails.gate) &&
        Objects.equals(this.back, structureDetails.back) &&
        Objects.equals(this.fpI, structureDetails.fpI) &&
        Objects.equals(this.fpII, structureDetails.fpII) &&
        Objects.equals(this.bpIA, structureDetails.bpIA) &&
        Objects.equals(this.bpIB, structureDetails.bpIB) &&
        Objects.equals(this.bpIIIn, structureDetails.bpIIIn) &&
        Objects.equals(this.bpIIAIn, structureDetails.bpIIAIn) &&
        Objects.equals(this.bpIIBIn, structureDetails.bpIIBIn) &&
        Objects.equals(this.bpIIOut, structureDetails.bpIIOut) &&
        Objects.equals(this.bpIIB, structureDetails.bpIIB) &&
        Objects.equals(this.bpIII, structureDetails.bpIII) &&
        Objects.equals(this.bpIV, structureDetails.bpIV) &&
        Objects.equals(this.bpV, structureDetails.bpV);
  }

  @Override
  public int hashCode() {
    return Objects.hash(structureID, kinase, species, kinaseID, pdb, alt, chain, rmsd1, rmsd2, pocket, resolution, qualityScore, missingResidues, missingAtoms, ligand, allostericLigand, DFG, aCHelix, grichDistance, grichAngle, grichRotation, front, gate, back, fpI, fpII, bpIA, bpIB, bpIIIn, bpIIAIn, bpIIBIn, bpIIOut, bpIIB, bpIII, bpIV, bpV);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StructureDetails {\n");
    
    sb.append("    structureID: ").append(toIndentedString(structureID)).append("\n");
    sb.append("    kinase: ").append(toIndentedString(kinase)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
    sb.append("    kinaseID: ").append(toIndentedString(kinaseID)).append("\n");
    sb.append("    pdb: ").append(toIndentedString(pdb)).append("\n");
    sb.append("    alt: ").append(toIndentedString(alt)).append("\n");
    sb.append("    chain: ").append(toIndentedString(chain)).append("\n");
    sb.append("    rmsd1: ").append(toIndentedString(rmsd1)).append("\n");
    sb.append("    rmsd2: ").append(toIndentedString(rmsd2)).append("\n");
    sb.append("    pocket: ").append(toIndentedString(pocket)).append("\n");
    sb.append("    resolution: ").append(toIndentedString(resolution)).append("\n");
    sb.append("    qualityScore: ").append(toIndentedString(qualityScore)).append("\n");
    sb.append("    missingResidues: ").append(toIndentedString(missingResidues)).append("\n");
    sb.append("    missingAtoms: ").append(toIndentedString(missingAtoms)).append("\n");
    sb.append("    ligand: ").append(toIndentedString(ligand)).append("\n");
    sb.append("    allostericLigand: ").append(toIndentedString(allostericLigand)).append("\n");
    sb.append("    DFG: ").append(toIndentedString(DFG)).append("\n");
    sb.append("    aCHelix: ").append(toIndentedString(aCHelix)).append("\n");
    sb.append("    grichDistance: ").append(toIndentedString(grichDistance)).append("\n");
    sb.append("    grichAngle: ").append(toIndentedString(grichAngle)).append("\n");
    sb.append("    grichRotation: ").append(toIndentedString(grichRotation)).append("\n");
    sb.append("    front: ").append(toIndentedString(front)).append("\n");
    sb.append("    gate: ").append(toIndentedString(gate)).append("\n");
    sb.append("    back: ").append(toIndentedString(back)).append("\n");
    sb.append("    fpI: ").append(toIndentedString(fpI)).append("\n");
    sb.append("    fpII: ").append(toIndentedString(fpII)).append("\n");
    sb.append("    bpIA: ").append(toIndentedString(bpIA)).append("\n");
    sb.append("    bpIB: ").append(toIndentedString(bpIB)).append("\n");
    sb.append("    bpIIIn: ").append(toIndentedString(bpIIIn)).append("\n");
    sb.append("    bpIIAIn: ").append(toIndentedString(bpIIAIn)).append("\n");
    sb.append("    bpIIBIn: ").append(toIndentedString(bpIIBIn)).append("\n");
    sb.append("    bpIIOut: ").append(toIndentedString(bpIIOut)).append("\n");
    sb.append("    bpIIB: ").append(toIndentedString(bpIIB)).append("\n");
    sb.append("    bpIII: ").append(toIndentedString(bpIII)).append("\n");
    sb.append("    bpIV: ").append(toIndentedString(bpIV)).append("\n");
    sb.append("    bpV: ").append(toIndentedString(bpV)).append("\n");
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


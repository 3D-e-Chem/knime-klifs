

# StructureDetails


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**structureID** | **Integer** | KLIFS ID for a specific kinase structure |  |
|**kinase** | **String** | HGNC gene symbol for a specific kinase structure |  [optional] |
|**species** | **String** | Species of a specific kinase structure (e.g. human) |  |
|**kinaseID** | **Integer** | KLIFS ID for a specific kinase |  |
|**pdb** | **String** | 4-letter PDB-code for a given structure |  |
|**alt** | **String** | Indicates the (alternate) model of the given structure |  [optional] |
|**chain** | **String** | Indicates the chain of the given structure |  |
|**rmsd1** | **Float** | RMSD compared to the reference template for the superpose pocket |  |
|**rmsd2** | **Float** | RMSD compared to the reference template for the full pocket |  |
|**pocket** | **String** | Alignment of the 85 pocket residues |  |
|**resolution** | **Float** | Resolution of the crystal struture |  [optional] |
|**qualityScore** | **Float** | The quality score estimates the quality of the structure with respect to the binding pocket as well as the quality of the processing by KLIFS. |  |
|**missingResidues** | **Integer** | Number of residues missing in the pocket |  |
|**missingAtoms** | **Integer** | Number of atoms missing from pocket residues (not including the missing residues) |  |
|**ligand** | **String** | 3-letter PDB-code of the ligand within the main pocket |  [optional] |
|**allostericLigand** | **String** | 3-letter PDB-code of the ligand outside the main pocket |  [optional] |
|**DFG** | **String** | Conformation of the DFG motif |  [optional] |
|**aCHelix** | **String** | Conformation of the alpha-C helix |  [optional] |
|**grichDistance** | **Float** | Conformation of the G-rich loop - distance |  [optional] |
|**grichAngle** | **Float** | Conformation of the G-rich loop - angle |  [optional] |
|**grichRotation** | **Float** | Conformation of the G-rich loop - rotation |  [optional] |
|**front** | **Boolean** | The ligand binds to the front pocket |  [optional] |
|**gate** | **Boolean** | The ligand binds to the gate area |  [optional] |
|**back** | **Boolean** | The ligand binds to the back pocket |  [optional] |
|**fpI** | **Boolean** | The ligand binds to FP-I |  [optional] |
|**fpII** | **Boolean** | The ligand binds to FP-II |  [optional] |
|**bpIA** | **Boolean** | The ligand binds to BP-I-A |  [optional] |
|**bpIB** | **Boolean** | The ligand binds to BP-I-B |  [optional] |
|**bpIIIn** | **Boolean** | The ligand binds to BP-II-in |  [optional] |
|**bpIIAIn** | **Boolean** | The ligand binds to BP-II-A-in |  [optional] |
|**bpIIBIn** | **Boolean** | The ligand binds to BP-II-B-in |  [optional] |
|**bpIIOut** | **Boolean** | The ligand binds to BP-II-out |  [optional] |
|**bpIIB** | **Boolean** | The ligand binds to BP-II-B |  [optional] |
|**bpIII** | **Boolean** | The ligand binds to BP-III |  [optional] |
|**bpIV** | **Boolean** | The ligand binds to BP-IV |  [optional] |
|**bpV** | **Boolean** | The ligand binds to BP-V |  [optional] |




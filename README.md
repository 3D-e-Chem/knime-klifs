# KLIFS KNIME nodes

[![Java CI with Maven](https://github.com/3D-e-Chem/knime-klifs/actions/workflows/ci.yml/badge.svg)](https://github.com/3D-e-Chem/knime-gpcrdb/actions/workflows/ci.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=3D-e-Chem_knime-klifs&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=3D-e-Chem_knime-klifs)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=3D-e-Chem_knime-klifs&metric=coverage)](https://sonarcloud.io/summary/new_code?id=3D-e-Chem_knime-klifs)
[![DOI](https://zenodo.org/badge/20180/3D-e-Chem/knime-klifs.svg)](https://zenodo.org/badge/latestdoi/20180/3D-e-Chem/knime-klifs)

KNIME nodes for retrieving data from KLIFS (https://klifs.net/). KLIFS is a structural kinase-ligand interaction database. For more information regarding KLIFS see [the website](https://klifs.net/) and the references at the bottom.

# Installation

Requirements:

* KNIME, https://www.knime.org

Steps to get KLIFS nodes inside KNIME:

1. Goto Help > Install new software ... menu
2. Press add button
3. Fill text fields with `https://3d-e-chem.github.io/knime-node-collection`
4. Select --all sites-- in work with pulldown
6. Select KLIFS knime nodes
7. Install software & restart (for now an "Unsigned Content" warning can popup during the installation, you can safely ignore this)

# Usage

See the example workflow in `examples` folder.

# Build

```
mvn verify
```

Jar has been made in `plugin/target` folder.
An Eclipse update site will be made in `p2/target/repository` repository.

# Development

Steps to get development environment setup based on https://github.com/knime/knime-sdk-setup#sdk-setup:

1. Install Java 17
2. Install Eclipse for [RCP and RAP developers](https://www.eclipse.org/downloads/packages/installer)
3. Configure Java 17 inside Eclipse Window > Preferences > Java > Installed JREs
4. Import this repo as an Existing Maven project
5. Activate target platform by going to Window > Preferences > Plug-in Development > Target Platform and check the `KNIME Analytics Platform (5.1) - nl.esciencecenter.e3dchem.knime.sstea.targetplatform/KNIME-AP-5.1.target` target definition.

During import the Tycho Eclipse providers must be installed.

# New release

1. Update versions in pom files with `mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=<version>-SNAPSHOT` command.
2. Commit and push changes
3. Create package with `mvn package`, will create update site in `p2/target/repository`
4. Append new release to 3D-e-Chem update site
  1. Make clone of https://github.com/3D-e-Chem/3D-e-Chem.github.io repo
  2. Append release to 3D-e-Chem update site with `mvn install -Dtarget.update.site=<3D-e-Chem repo/updates>`
5. Commit and push changes in this repo and 3D-e-Chem.github.io repo
6. Make nodes available to 3D-e-Chem KNIME feature by following steps at https://github.com/3D-e-Chem/knime-node-collection#new-release
7. Create a GitHub release
8. Update DOI in CITATION.cff

# Create KLIFS client

0. Generate client

```    
wget https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/7.1.0/openapi-generator-cli-7.1.0.jar -O openapi-generator-cli.jar
java -jar openapi-generator-cli.jar generate -i https://klifs.net/swagger/swagger.json -o net.klifs.client -g java
# in knime-klifs/net.klifs.client/pom.xml change version of build-helper-maven-plugin to 3.4.0
mvn package
```

1. Compile client
```
cd net.klifs.client
mvn package
```

1. Make client jar and it's dependencies available in plugin
```
cp -r target/lib/* target/*jar ../nl.vu_compmedchem.klifs/lib/
```

1. Update `plugin/META-INF/MANIFEST.MF`, `plugin/build.properties` files to reflect contents of lib/

# References

* Kooistra, A. J.; Kanev, G. K.; van Linden, O. P.; Leurs, R.; de Esch, I. J.; de Graaf, C. Klifs: A Structural Kinase-Ligand Interaction Database. *Nucleic Acids Res.* **2016**, *44*, D365-371. [10.1093/nar/gkv1082](http://dx.doi.org/10.1093/nar/gkv1082)
* van Linden, O. P.; Kooistra, A. J.; Leurs, R.; de Esch, I. J.; de Graaf, C. Klifs: A Knowledge-Based Structural Database to Navigate Kinase–Ligand Interaction Space. *J. Med. Chem.* **2013**, *57*, 249-277. [10.1021/jm400378w](http://dx.doi.org/10.1021/jm400378w)

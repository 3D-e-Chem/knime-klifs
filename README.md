# KLIFS knime nodes

[![Build Status](https://travis-ci.org/3D-e-Chem/knime-klifs.svg?branch=master)](https://travis-ci.org/3D-e-Chem/knime-klifs)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e48d6b99a76d479ea37f13f6f3189b5b)](https://www.codacy.com/app/AJK-dev/knime-klifs?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=3D-e-Chem/knime-klifs&amp;utm_campaign=Badge_Grade)
[![DOI](https://zenodo.org/badge/20180/3D-e-Chem/knime-klifs.svg)](https://zenodo.org/badge/latestdoi/20180/3D-e-Chem/knime-klifs)

Knime plugin for retrieving data from KLIFS (http://klifs.vu-compmedchem.nl). KLIFS is a structural kinase-ligand interaction database. For more information regarding KLIFS see [the website](http://klifs.vu-compmedchem.nl) and the references at the bottom.

# Installation

Requirements:

* KNIME, https://www.knime.org

Steps to get KLIFS nodes inside KNIME:

1. Goto Help > Install new software ... menu
2. Press add button
3. Fill text fields with `https://3d-e-chem.github.io/updates`
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

Steps to get development enviroment setup:

1. Download KNIME SDK from https://www.knime.org/downloads/overview
2. Install/Extract/start KNIME SDK
3. Start SDK
4. Install m2e (Maven integration for Eclipse)

    1. Goto Help > Install new software ...
    2. Make sure Update site is http://update.knime.org/analytics-platform/3.1 in the pull down list otherwise add it
    3. Select --all sites-- in work with pulldown
    4. Select m2e (Maven integration for Eclipse)
    5. Install software & restart

5. Import this repo as an Existing Maven project
6. Import `client/` directory in repo as an Existing Maven project.

During import the Tycho Eclipse providers must be installed.

# New release

1. Update versions in pom files with `mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=<version>` command.
2. Manually update version of "source" feature in `p2/category.xml` file.
3. Commit and push changes
3. Create package with `mvn package`, will create update site in `p2/target/repository`
4. Append new release to 3D-e-Chem update site
  1. Make clone of https://github.com/3D-e-Chem/3D-e-Chem.github.io repo
  2. Append release to 3D-e-Chem update site with `mvn install -Dtarget.update.site=<3D-e-Chem repo/updates>`
5. Commit and push changes in this repo and 3D-e-Chem.github.io repo
6. Make nodes available to 3D-e-Chem KNIME feature by following steps at https://github.com/3D-e-Chem/knime-node-collection#new-release

## Offline Knime update site

If Knime update site can not be contacted then use a local version.

1. Download zip of update site from https://www.knime.org/downloads/update
2. Unzip it
3. To maven commands add `-Dknime.update.site=file://<path to update site directory>`

# Create KLIFS client

1. Compile client
```
cd nl.vu_compmedchem.klifs.client
mvn package
```

2. Make client jar and it's dependencies available in plugin
```
cp -r target/lib/* target/*jar ../nl.vu_compmedchem.klifs/lib/
```

3. Update `plugin/META-INF/MANIFEST.MF`, `plugin/build.properties` files to reflect contents of lib/

# References

* Kooistra, A. J.; Kanev, G. K.; van Linden, O. P.; Leurs, R.; de Esch, I. J.; de Graaf, C. Klifs: A Structural Kinase-Ligand Interaction Database. *Nucleic Acids Res.* **2016**, *44*, D365-371. [10.1093/nar/gkv1082](http://dx.doi.org/10.1093/nar/gkv1082)
* van Linden, O. P.; Kooistra, A. J.; Leurs, R.; de Esch, I. J.; de Graaf, C. Klifs: A Knowledge-Based Structural Database to Navigate Kinase–Ligand Interaction Space. *J. Med. Chem.* **2013**, *57*, 249-277. [10.1021/jm400378w](http://dx.doi.org/10.1021/jm400378w)

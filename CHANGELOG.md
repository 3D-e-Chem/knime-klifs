# Change Log
All notable changes to this project will be documented in this file.
This project adheres to [Semantic Versioning](http://semver.org/).
Formatted as described on http://keepachangelog.com/.

## [Unreleased]
- Updated test settings for Mac OS X

## [1.1.1] - 2017-01-26

### Changed
- Updated the repository/update site
- Handling structures without IFPs by the Interaction Fingerprint Retriever node

## [1.1.0] - 2017-01-20
- Time-out option (#1)
- Usual suspects for settings configuration (#2)

## [1.0.16] - 2016-12-21

### Changed
- Error messages handling KLIFS server
- Cleaned code
- Updated testflow

## [1.0.15] - 2016-12-20

### Added
- Base URL option to specify the location the KLIFS web services (e.g. for proxy/forwarding settings)

### Changed
- Updated testflows
- Type of SMILES columns from the "Ligands Overview Retriever" from StringCell to SmilesCell

## [1.0.14] - 2016-10-21

### Changed

- Added KNIME testflow

### Fixed

- Fixed handling of empty tables by the Interaction Fingerprint Retriever node
- Cleaned code based on Codacy flags

## [1.0.13] - 2016-10-05

### Changed

- Client is now based on okhttp/gson libraries to prevent conflicts within KNIME
- Project is linked to Codacy and Travis-CI

### Fixed

- When and empty input table is provided the nodes will now return an emtpy list instead of polling the KLIFS webservice.

# Change Log
All notable changes to this project will be documented in this file.
This project adheres to [Semantic Versioning](http://semver.org/).
Formatted as described on http://keepachangelog.com/.

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

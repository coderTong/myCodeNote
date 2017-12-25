stages:
- build
- archive

build_project:
stage: build
script:
- xctool -project iostestgitlable.xcodeproj -scheme iostestgitlable clean
- xctool -project iostestgitlable.xcodeproj -scheme iostestgitlable test -test-sdk iphonesimulator9.3

archive_project:
stage: archive
script:
- xctool -project iostestgitlable.xcodeproj -scheme iostestgitlable archive -archivePath build/iostestgitlable
- xcodebuild -exportArchive -exportFormat ipa -archivePath "build/iostestgitlable.xcarchive" -exportPath "build/iostestgitlable.ipa"
only:
- master
artifacts:
paths:
- build/iostestgitlable.ipa


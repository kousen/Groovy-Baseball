Groovy Baseball, a web application that displays
the results of MLB games on a given date.

Info is downloaded from box score data at MLB,
parsed using Groovy, then loaded into a Google Map.

Mostly used as a demo project for my book,
Making Java Groovy, http://manning.com/kousen .

A gradle build file is provided. The build works if
(1) you already have the stadium database generated, and
(2) you have Internet access so that it can get at the
box score data.

Run the Groovy script service/populate_stadium_data.groovy
to create and populate the stadium database. It uses H2
and the Google Geocoder service to get the lat/lng data
for individual stadiums.
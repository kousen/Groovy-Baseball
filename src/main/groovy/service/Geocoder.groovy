package service

import beans.Stadium;

class Geocoder {
    String base = 'http://maps.google.com/maps/api/geocode/xml?'

    void fillInLatLng(Stadium stadium) {
        String urlEncodedAddress = [stadium.street, stadium.city, stadium.state].collect { 
                URLEncoder.encode(it,'UTF-8')
            }.join(',+') 
        String url = base + [sensor:false,
            address: urlEncodedAddress].collect {k,v -> "$k=$v"}.join('&')
        println url
        def response = new XmlSlurper().parse(url)
        stadium.latitude = response.result.geometry.location.lat[0].toDouble()
        stadium.longitude = response.result.geometry.location.lng[0].toDouble()
    }
}
